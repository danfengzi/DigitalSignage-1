package signage.digital.com.digitalsignage.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.google.gson.annotations.SerializedName;


/**
 * Created by fung.lam on 02/09/2015.
 * for openweathermap webservice call
 */
public class ForecastUnderground  extends BaseObservable {

    @SerializedName("forecast")
    Forecast forecast = new Forecast();

    @Bindable
    public Forecast getForecast() {
        return forecast;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }
}
