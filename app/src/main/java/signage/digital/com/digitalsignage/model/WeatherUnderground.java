package signage.digital.com.digitalsignage.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.google.gson.annotations.SerializedName;

import signage.digital.com.digitalsignage.BR;


/**
 * Created by fung.lam on 02/09/2015.
 * for openweathermap webservice call
 */
public class WeatherUnderground  extends BaseObservable {

    @SerializedName("current_observation")
    public CurrentObservation currentObservation = new CurrentObservation();

    public ForecastUnderground forecast = new ForecastUnderground();

    @Bindable
    public CurrentObservation getCurrentObservation() {
        return currentObservation;
    }

    @Bindable
    public ForecastUnderground getForecast() {
        return forecast;
    }


    public void setResponse(CurrentObservation currentObservation) {
        this.currentObservation = currentObservation;
    }

    public void setForecast(ForecastUnderground forecast) {
        this.forecast = forecast;
    }
}
