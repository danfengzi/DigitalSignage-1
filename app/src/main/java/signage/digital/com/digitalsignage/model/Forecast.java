package signage.digital.com.digitalsignage.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.google.gson.annotations.SerializedName;

public class Forecast  extends BaseObservable {

    @SerializedName("simpleforecast")
    SimpleForecast simpleforecast = new SimpleForecast();

    @SerializedName("txt_forecast")
    TxtForecast txt_forecast = new TxtForecast();

    @Bindable
    public SimpleForecast getSimpleForecastday() {
        return simpleforecast;
    }

    @Bindable
    public TxtForecast getTxt_forecast() {
        return txt_forecast;
    }

    public void setSimpleforecast(SimpleForecast simpleforecast) {
        this.simpleforecast = simpleforecast;
    }

    public void setTxt_forecast(TxtForecast txt_forecast) {
        this.txt_forecast = txt_forecast;
    }
}
