package signage.digital.com.digitalsignage;

import android.content.Context;
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

import signage.digital.com.digitalsignage.library.model.ForecastDay;
import signage.digital.com.digitalsignage.library.model.ForecastUnderground;
import signage.digital.com.digitalsignage.library.model.WeatherUnderground;

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

    public WeatherView(Context context) {
        super(context);
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
    }


    public void getWeatherUnderground(final String cidade, final double latitude, final double longitude, final String lg){

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
                condition.setText(response.getForecast().getTxt_forecast().getForecastDay().get(0).getFcttext_metric());
                days.removeAllViews();
                for(ForecastDay f : response.getForecast().getSimpleForecastday().getForecastDay()){
                    WeatherDayView d = new WeatherDayView(context);
                    d.setForecast(f);
                    days.addView(d);
                }
            }
        };

        final Listener<WeatherUnderground> l_weather = new Listener<WeatherUnderground>(){
            @Override
            public void onResponse(WeatherUnderground response) {
                city.setText(cidade);
                temp.setText(response.getCurrentWeather().getTemp_c()+"c");
                icon.setImageResource(getResources().getIdentifier(response.getCurrentWeather().getIcon(), "drawable", context.getPackageName()));
            }
        };

        helper.getWeather(latitude,longitude, l_weather, error, lg);
        helper.getForecast(latitude,longitude, l_forecast, error, lg);
    }
}
