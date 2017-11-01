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
        this.city = city;
        notifyPropertyChanged(BR.city);
    }

    @Bindable
    public WeatherResponse getWeather() {
        return weather;
    }

    public void setWeather(WeatherResponse weather) {
        this.weather = weather;
    }

    @Bindable
    public ForecastResponse getForecast() {
        return forecast;
    }

    public void setForecast(ForecastResponse forecast) {
        this.forecast = forecast;
    }

    @Bindable
    public String getCondition() {
        return forecast.forecast.getSimpleforecast().forecastday.get(0).conditions;
    }
}
