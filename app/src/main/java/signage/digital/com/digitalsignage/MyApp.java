package signage.digital.com.digitalsignage;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.util.ArrayList;

import signage.digital.com.digitalsignage.model.City;
import signage.digital.com.digitalsignage.model.ForecastUnderground;
import signage.digital.com.digitalsignage.model.Screen;
import signage.digital.com.digitalsignage.model.WeatherUnderground;

/**
 * Created by Alexandre on 19/09/2016.
 */
public class MyApp extends Application {
    private static MyApp ourInstance = new MyApp();
    private Screen screen;
    private Context context;
    private ArrayList<City> cities;
    public static MyApp getInstance() {
        return ourInstance;
    }
    private FirebaseStorage storage;
    private StorageReference storageRef;
    private DatabaseReference myRef;

    Handler handler = new Handler();

    Runnable serviceRunnable = new Runnable() {
        @Override
        public void run() {
            getWatherData();
            handler.postDelayed(this, (1000*60*30));
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public ArrayList<City> getCities(){
        return cities;
    }

    public void addCity(City c){
        if(cities==null)
            cities = new ArrayList<City>();
        cities.add(c);
    }

    public void getWatherData(){
        for(City c:cities){
            getWeatherUnderground(c);
        }
    }

    public void getWeatherUnderground(final City c){

        final WeatherApi helper = new WeatherApi(context);
        final Response.ErrorListener error = new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {    }
        };

        final Response.Listener<ForecastUnderground> l_forecast = new Response.Listener<ForecastUnderground>(){
            @Override
            public void onResponse(ForecastUnderground response) {
                c.setForecast(response);
            }
        };

        final Response.Listener<WeatherUnderground> l_weather = new Response.Listener<WeatherUnderground>(){
            @Override
            public void onResponse(WeatherUnderground response) {
                c.setWeather(response);
            }
        };

        helper.getWeather(c.getLatitude(), c.getLongitude(), l_weather, error, c.getLang());
        helper.getForecast(c.getLatitude(), c.getLongitude(), l_forecast, error, c.getLang());
        Log.d("------", "atualizando "+ c.getCity());
    }


    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public void saveScreen() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        myRef.child("screen").child(screen.getId()).setValue(screen);
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    private void downloadFile(String child, String file, OnSuccessListener<FileDownloadTask.TaskSnapshot> listener) {
        File localFile = new File(Environment.DIRECTORY_DOWNLOADS + file);
        storageRef.child(child).getFile(localFile).addOnSuccessListener(listener);
    }

    public void checkUpdate(){
        myRef.child("file").child("update").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                System.out.println("Inicio da atualizacao: ");
                boolean update = (boolean)dataSnapshot.getValue();
                if(update) {
                    update();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {   }
        });
        Log.d("------","Downloads: "+Environment.DIRECTORY_DOWNLOADS);

    }

    private void update(){
        File localFile =  new File(Environment.DIRECTORY_DOWNLOADS+"/app-release.apk");

        storageRef.child("app/app-release.apk").getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                System.out.println("Download completo: "+taskSnapshot.getBytesTransferred());
                myRef.child("file/update").setValue(false);
                System.out.println("Set to false: ");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                System.out.println("Falha no download: "+exception.getMessage());
            }
        });
    }

    private void appUpdate(){
        File file = new File("/mnt/internal_sd/Download/app-release.apk");
        file.setReadable(true, false);
        Intent intent = new Intent(Intent.ACTION_INSTALL_PACKAGE);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        startActivity(intent);
    }

}