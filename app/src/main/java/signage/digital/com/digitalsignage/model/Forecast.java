package signage.digital.com.digitalsignage.model;

import com.google.gson.annotations.SerializedName;

public class Forecast {

    @SerializedName("simpleforecast")
    SimpleForecast simpleforecast = new SimpleForecast();

    @SerializedName("txt_forecast")
    TxtForecast txt_forecast = new TxtForecast();

    public SimpleForecast getSimpleForecastday() {
        return simpleforecast;
    }

    public TxtForecast getTxt_forecast() {
        return txt_forecast;
    }
}
