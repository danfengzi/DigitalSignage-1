package signage.digital.com.digitalsignage.library.model;

import com.google.gson.annotations.SerializedName;

public class Forecast {

    @SerializedName("simpleforecast")
    SimpleForecast simpleforecast;

    @SerializedName("txt_forecast")
    TxtForecast txt_forecast;

    public SimpleForecast getSimpleForecastday() {
        return simpleforecast;
    }

    public TxtForecast getTxt_forecast() {
        return txt_forecast;
    }
}
