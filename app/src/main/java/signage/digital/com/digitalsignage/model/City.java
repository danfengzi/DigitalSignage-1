package signage.digital.com.digitalsignage.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

import signage.digital.com.digitalsignage.BR;

/**
 * Created by Alexandre on 25/12/2016.
 */

public class City  extends BaseObservable {
    String city;
    WeatherResponse weather;
    ForecastResponse forecast;

    public City(String city, WeatherResponse weatherresponse, ForecastResponse forecastresponse) {
        this.city = city;
        this.weather = weatherresponse;
        this.forecast = forecastresponse;
    }
    public City() {
    }

    @Bindable
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        Log.d("-------","city 1");
        this.city = city;
        notifyPropertyChanged(BR.city);
    }

    @Bindable
    public WeatherResponse getWeather() {
        return weather;
    }

    public void setWeather(WeatherResponse weather) {
        Log.d("-------","city 3");
        this.weather = weather;
    }

    @Bindable
    public ForecastResponse getForecast() {
        return forecast;
    }

    public void setForecast(ForecastResponse forecast) {
        Log.d("-------","city 2");
        this.forecast = forecast;
    }

    @Bindable
    public String getCondition() {
        return forecast.forecast.getSimpleforecast().forecastday[0].conditions;
    }
}
