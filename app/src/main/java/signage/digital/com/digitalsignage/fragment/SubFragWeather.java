package signage.digital.com.digitalsignage.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;

import signage.digital.com.digitalsignage.OpenWeatherMapApiHelper;
import signage.digital.com.digitalsignage.R;
import signage.digital.com.digitalsignage.library.model.WeatherUnderground;

public class SubFragWeather extends Fragment {
    private String cityId;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view =  inflater.inflate(R.layout.sub_frag_weather, container, false);

        OpenWeatherMapApiHelper helper = new OpenWeatherMapApiHelper(getContext());

        helper.getWeather(-22.9865956,-43.2086082, new Listener<WeatherUnderground>(){
            @Override
            public void onResponse(WeatherUnderground response) {

                initView(response, view);
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

    private void initView(WeatherUnderground w, View v){
        TextView city = (TextView)v.findViewById(R.id.city);
        city.setText(w.getCurrentWeather().getDisplay().getCity());
        TextView temp = (TextView)v.findViewById(R.id.temp);
        temp.setText(w.getCurrentWeather().getTemp_c()+"C/"+w.getCurrentWeather().getTemp_f()+"F");
        ImageView icon = (ImageView)v.findViewById(R.id.icon);
        Glide.with(getContext())
                .load(w.getCurrentWeather().getIcon_url())
                .dontAnimate()
                .into(icon);
    }

   @Override
    public void onStart() {
        super.onStart();
    }
}