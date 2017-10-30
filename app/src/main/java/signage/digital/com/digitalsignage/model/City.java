package signage.digital.com.digitalsignage.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import signage.digital.com.digitalsignage.BR;

/**
 * Created by Alexandre on 25/12/2016.
 */

public class City  extends BaseObservable {
    public String city;
    public WeatherResponse weatherResponse;
    public ForecastResponse forecastResponse;

    public City(String city, WeatherResponse weatherResponse, ForecastResponse forecastResponse) {
        this.city = city;
        this.weatherResponse = weatherResponse;
        this.forecastResponse = forecastResponse;
    }
    public City() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Bindable
    public WeatherResponse getWeatherResponse() {
        return weatherResponse;
    }

    public void setWeatherResponse(WeatherResponse weather) {
        this.weatherResponse = weather;
    }

    @Bindable
    public ForecastResponse getForecastResponse() {
        return forecastResponse;
    }

    public void setForecastResponse(ForecastResponse forecast) {
        this.forecastResponse = forecastResponse;
    }
}
