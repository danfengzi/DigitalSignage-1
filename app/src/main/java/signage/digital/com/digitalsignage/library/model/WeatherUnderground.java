package signage.digital.com.digitalsignage.library.model;

import com.google.gson.annotations.SerializedName;


/**
 * Created by fung.lam on 02/09/2015.
 * for openweathermap webservice call
 */
public class WeatherUnderground {

    @SerializedName("current_observation")
    CurrentObservation response;

    ForecastUnderground forecast;

    public CurrentObservation getCurrentWeather() {
        return response;
    }

    public ForecastUnderground getForecast() {
        return forecast;
    }

    public void setForecast(ForecastUnderground forecast) {
        this.forecast = forecast;
    }
}
