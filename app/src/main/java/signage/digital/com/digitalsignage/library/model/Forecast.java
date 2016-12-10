package signage.digital.com.digitalsignage.library.model;

import com.google.gson.annotations.SerializedName;

public class Forecast {

    @SerializedName("simpleforecast")
    SimpleForecast simpleforecast;

    public SimpleForecast getSimpleForecastday() {
        return simpleforecast;
    }
}
