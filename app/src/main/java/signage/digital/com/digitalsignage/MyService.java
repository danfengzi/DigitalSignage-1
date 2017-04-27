package signage.digital.com.digitalsignage;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;

import java.util.ArrayList;

import signage.digital.com.digitalsignage.model.City;
import signage.digital.com.digitalsignage.model.ForecastUnderground;
import signage.digital.com.digitalsignage.model.WeatherUnderground;

public class MyService extends Service {
    Callbacks activity;
    private final IBinder mBinder = new LocalBinder();
    Handler handler = new Handler();
    ArrayList<City> cities = new ArrayList<City>();

    Runnable serviceRunnable = new Runnable() {
        @Override
        public void run() {
            int i = 0;
            for(City c : cities){
                getWeatherUnderground(c, i);
                i++;
            }
            activity.updateAgenda(CalendarService.readCalendar(getBaseContext(),1,0, MyApp.getInstance().getProfile().getCalendar_id()));
            handler.postDelayed(this, (1000*60*30));
        }
    };


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //Do what you need in onStartCommand when service has been started
        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
    //returns the instance of the service
    public class LocalBinder extends Binder {
        public MyService getServiceInstance(){
            return MyService.this;
        }
    }

    public void registerClient(Activity activity){
        this.activity = (Callbacks)activity;
    }

    public void startCounter(){
        handler.postDelayed(serviceRunnable, 0);
    }

    public void stopCounter(){
        handler.removeCallbacks(serviceRunnable);
    }

    public interface Callbacks{
        public void updateWeather(WeatherUnderground weather, int i);
        public void updateFerecast(ForecastUnderground weather, int i);
        public void updateAgenda(ArrayList<CalendarEvent> events);
    }

    public void addCity(City c){
        cities.add(c);
    }

    public void getWeatherUnderground(City c, final int i){

        final OpenWeatherMapApiHelper helper = new OpenWeatherMapApiHelper(getBaseContext());
        final ErrorListener error = new ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("------", "erro "+error.getMessage());
            }
        };

        final Listener<ForecastUnderground> l_forecast = new Listener<ForecastUnderground>(){
            @Override
            public void onResponse(ForecastUnderground response) {
                Log.d("------", "forecast ");
//                city.setForecast(response);
                activity.updateFerecast(response, i);
            }
        };

        final Listener<WeatherUnderground> l_weather = new Listener<WeatherUnderground>(){
            @Override
            public void onResponse(WeatherUnderground response) {
                Log.d("------", "weather ");
//                city.setWeather(response);
                activity.updateWeather(response, i);
            }
        };

        helper.getWeather(c.getLatitude(), c.getLongitude(), l_weather, error, c.getLang());
        helper.getForecast(c.getLatitude(), c.getLongitude(), l_forecast, error, c.getLang());
        Log.d("------", "atualizando "+ c.getCity());
    }
}
