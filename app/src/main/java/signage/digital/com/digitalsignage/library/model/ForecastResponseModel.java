package signage.digital.com.digitalsignage.library.model;

import com.google.gson.annotations.SerializedName;


/**
 * Created by fung.lam on 02/09/2015.
 * for openweathermap webservice call
 */
public class ForecastResponseModel {

    @SerializedName("city")
    ForecastRecord forecastRecord;

    public ForecastRecord getWeatherRecord() {
        return forecastRecord;
    }

}
