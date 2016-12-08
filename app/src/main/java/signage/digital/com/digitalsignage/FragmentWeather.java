package signage.digital.com.digitalsignage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;

import java.util.ArrayList;

import signage.digital.com.digitalsignage.library.model.ForecastRecord;
import signage.digital.com.digitalsignage.library.model.WeatherUnderground;

public class FragmentWeather extends Fragment {
    private String cityId;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_weather, container, false);
        ListView list = (ListView)view.findViewById(R.id.list);

        ArrayList<ForecastRecord> array = new ArrayList<ForecastRecord>();
        OpenWeatherMapApiHelper helper = new OpenWeatherMapApiHelper(getContext());
        //config.ApiKey = "68f861256e25308c"; //undeground
        helper.getWeather(-22.9865956,-43.2086082, new Listener<WeatherUnderground>(){

            @Override
            public void onResponse(WeatherUnderground response) {
                Log.d("------", "tempc "+response.getCurrentWeather().getTemp_c());
                Log.d("------", "tempf "+response.getCurrentWeather().getTemp_f());
                Log.d("------", "hum "+response.getCurrentWeather().getHumidity());
                Log.d("------", "url "+response.getCurrentWeather().getIcon_url());
                Log.d("------", "inc "+response.getCurrentWeather().getPressure_in());
                Log.d("------", "mb "+response.getCurrentWeather().getPressure_mb());
                Log.d("------", "solar "+response.getCurrentWeather().getSolarradiation());
                Log.d("------", "uv "+response.getCurrentWeather().getUv());
                Log.d("------", "weather "+response.getCurrentWeather().getWeather());
            }
        }, new ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("------", "erro "+error.getMessage());

            }
        });

        return view;
    }

   @Override
    public void onStart() {
        super.onStart();
    }
}