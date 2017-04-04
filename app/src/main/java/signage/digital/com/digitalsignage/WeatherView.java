package signage.digital.com.digitalsignage;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;

import signage.digital.com.digitalsignage.model.City;
import signage.digital.com.digitalsignage.model.ForecastDay;
import signage.digital.com.digitalsignage.model.ForecastUnderground;
import signage.digital.com.digitalsignage.model.WeatherUnderground;

/**
 * Created by Alexandre on 09/12/2016.
 */

public class WeatherView extends RelativeLayout {
    private View rootView;
    private TextView city;
    private TextView condition;
    private TextView temp;
    private ImageView icon;
    private LinearLayout days;
    private Context context;
    private City mCity;

    Handler handler = new Handler();

    Runnable serviceRunnable = new Runnable() {
        @Override
        public void run() {
           getWeatherUnderground(mCity);
           handler.postDelayed(this, (1000*60*30));
        }
    };

    public WeatherView(Context context, City c) {
        super(context);
        this.mCity = c;
        this.context = context;
        init(context);
    }

    public WeatherView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init(context);
    }

    public WeatherView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init(context);
    }

    private void init(Context context) {
        rootView = inflate(context, R.layout.weather_current, this);
        city = (TextView) rootView.findViewById(R.id.city);
        condition = (TextView) rootView.findViewById(R.id.condition);
        temp = (TextView) rootView.findViewById(R.id.temp);
        days = (LinearLayout) rootView.findViewById(R.id.days);
        icon = (ImageView) rootView.findViewById(R.id.icon);
        city.setText(mCity.getCity());
    }

    public void updateForecast(ForecastUnderground w){
        try {
            condition.setText(w.getForecast().getTxt_forecast().getForecastDay().get(0).getFcttext_metric());
            days.removeAllViews();
            for (ForecastDay f : w.getForecast().getSimpleForecastday().getForecastDay()) {
                WeatherDayView d = new WeatherDayView(context);
                d.setForecast(f);
                days.addView(d);
            }
        } catch (Exception e){
            Log.d("------", "erro "+e.getMessage());
        }
    }

    public void updateWeather(WeatherUnderground w){
        try{
            temp.setText(w.getCurrentWeather().getTemp_c()+"c");
            icon.setImageResource(getResources().getIdentifier(w.getCurrentWeather().getIcon(), "drawable", context.getPackageName()));
        } catch (Exception e){
            Log.d("------", "erro "+e.getMessage());
        }
    }

    public void getWeatherUnderground(City c){

        final OpenWeatherMapApiHelper helper = new OpenWeatherMapApiHelper(context);
        final ErrorListener error = new ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("------", "erro "+error.getMessage());
            }
        };

        final Listener<ForecastUnderground> l_forecast = new Listener<ForecastUnderground>(){
            @Override
            public void onResponse(ForecastUnderground response) {
                updateForecast(response);
            }
        };

        final Listener<WeatherUnderground> l_weather = new Listener<WeatherUnderground>(){
            @Override
            public void onResponse(WeatherUnderground response) {
                updateWeather(response);
            }
        };

        helper.getWeather(c.getLatitude(), c.getLongitude(), l_weather, error, c.getLang());
        helper.getForecast(c.getLatitude(), c.getLongitude(), l_forecast, error, c.getLang());
        Log.d("------", "atualizando "+ c.getCity());
    }

    public void startUpdate(){
        Log.d("------", "startUpdate");
        handler.postDelayed(serviceRunnable, 0);
    }

    public void stopUpdate(){
        Log.d("------", "stopUpdate");
        handler.removeCallbacks(serviceRunnable);
    }
}
