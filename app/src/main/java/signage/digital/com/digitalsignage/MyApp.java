package signage.digital.com.digitalsignage;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableArrayList;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
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

/**
 * Created by Alexandre on 19/09/2016.
 */
public class MyApp extends Application {
    private static MyApp ourInstance = new MyApp();
    private Context context;
    private ArrayList<City> cities;

    public static MyApp getInstance() {
        return ourInstance;
    }

    private FirebaseStorage storage;
    private StorageReference storageRef;
    private DatabaseReference myRef;
    private ChildEventListener eventListener;
    private static String TAG="DigitalSignage---> ";
    private ObservableArrayList events;


    public ObservableArrayList getEvents() {
        if(events.isEmpty())
            events = new ObservableArrayList();
        return events;
    }

    public void setEvents(ObservableArrayList events) {
        this.events = events;
    }

    public void addEvent(Eventm event){
        if(events.isEmpty())
            events = new ObservableArrayList();
        this.events.add(event);
    }

    public void clearEvent(){
        if(!events.isEmpty())
            this.events.clear();
    }

    public void startListener(){
        eventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.d(TAG, s);
                Log.d(TAG, dataSnapshot.toString());
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {            }

            @Override
            public void onCancelled(DatabaseError databaseError) {            }
        };
        myRef.child("events").addChildEventListener(eventListener);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

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