package signage.digital.com.digitalsignage.model;

import com.google.gson.annotations.SerializedName;


/**
 * Created by fung.lam on 02/09/2015.
 * for openweathermap webservice call
 */
public class WeatherUnderground {

    @SerializedName("current_observation")
    CurrentObservation response = new CurrentObservation();

    ForecastUnderground forecast = new ForecastUnderground();

    public CurrentObservation getCurrentWeather() {
        return response;
    }

    public ForecastUnderground getForecast() {
        return forecast;
    }

}
