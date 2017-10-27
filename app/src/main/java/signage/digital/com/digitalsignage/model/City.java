package signage.digital.com.digitalsignage.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import signage.digital.com.digitalsignage.BR;

/**
 * Created by Alexandre on 25/12/2016.
 */

public class City  extends BaseObservable {
    public String city;
    public WeatherUnderground weather;
    public ForecastUnderground forecast;

    public City(String city, WeatherUnderground weather, ForecastUnderground forecast) {
        this.city = city;
        this.weather = weather;
        this.forecast = forecast;
    }
    public City() {
    }

    @Bindable
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
        notifyPropertyChanged(BR.city);
    }

    @Bindable
    public WeatherUnderground getWeather() {
        return weather;
    }

    public void setWeather(WeatherUnderground weather) {
        this.weather = weather;
        notifyPropertyChanged(BR.weather);
    }

    @Bindable
    public ForecastUnderground getForecast() {
        return forecast;
    }

    public void setForecast(ForecastUnderground forecast) {
        this.forecast = forecast;
        notifyPropertyChanged(BR.forecast);
    }
}
