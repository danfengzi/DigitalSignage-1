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
import signage.digital.com.digitalsignage.model.ForecastResponse;
import signage.digital.com.digitalsignage.model.Forecastday;
import signage.digital.com.digitalsignage.model.Forecasttxtday;
import signage.digital.com.digitalsignage.model.WeatherResponse;

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

    public void updateForecast(ForecastResponse w){
        try {
            condition.setText(w.getForecast().getTxt_forecast().getForecastday()[0].getFcttext_metric());
            days.removeAllViews();
            for (Forecastday f : w.getForecast().getSimpleforecast().getForecastday()) {
                WeatherDayView d = new WeatherDayView(context);
                d.setForecast(f);
                days.addView(d);
            }
        } catch (Exception e){
            Log.d("------", "erro "+e.getMessage());
        }
    }

    public void updateWeather(WeatherResponse w){
        try{
            temp.setText(w.getCurrent_observation().getTemp_c()+"c");
            icon.setImageResource(getResources().getIdentifier(w.getCurrent_observation().getIcon(), "drawable", context.getPackageName()));
        } catch (Exception e){
            Log.d("------", "erro "+e.getMessage());
        }
    }
}
