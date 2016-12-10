package signage.digital.com.digitalsignage.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;

import java.util.ArrayList;

import signage.digital.com.digitalsignage.OpenWeatherMapApiHelper;
import signage.digital.com.digitalsignage.R;
import signage.digital.com.digitalsignage.WeatherView;
import signage.digital.com.digitalsignage.library.model.Forecast;
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
        final View header = inflater.inflate(R.layout.item_weather_full, null);
        final ListView list = (ListView)view.findViewById(R.id.list);

        ArrayList<Forecast> array = new ArrayList<Forecast>();
        OpenWeatherMapApiHelper helper = new OpenWeatherMapApiHelper(getContext());
        //config.ApiKey = "68f861256e25308c"; //undeground
        helper.getWeather(-22.9865956,-43.2086082, new Listener<WeatherUnderground>(){
            @Override
            public void onResponse(WeatherUnderground response) {
                WeatherView header = new WeatherView(getContext());
                header.setWeather(response);
                list.addHeaderView(header);
                Log.d("------", "tempc "+response.getCurrentWeather().getTemp_c());
            }
        }, new ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("------", "erro "+error.getMessage());

            }
        });

        return view;
    }

    private void initHeader(WeatherUnderground r, View v){

        TextView city = (TextView)v.findViewById(R.id.city);
        city.setText(r.getCurrentWeather().getDisplay().getCity());
    }

   @Override
    public void onStart() {
        super.onStart();
    }
}