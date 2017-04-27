package signage.digital.com.digitalsignage.model;

import com.google.gson.annotations.SerializedName;


/**
 * Created by fung.lam on 02/09/2015.
 * for openweathermap webservice call
 */
public class ForecastUnderground {

    @SerializedName("forecast")
    Forecast forecast = new Forecast();

    public Forecast getForecast() {
        return forecast;
    }

}
