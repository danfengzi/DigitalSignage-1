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

    public WeatherUnderground(){ }

    @SerializedName("current_observation")
    public CurrentObservation current_observation = new CurrentObservation();

    //public ForecastUnderground forecastunderground = new ForecastUnderground();

    @Bindable
    public CurrentObservation getCurrentObservation() {
        return current_observation;
    }

    //@Bindable
    //public ForecastUnderground getForecast() {

    public void setCurrent_observation(CurrentObservation current_observation) {
        this.current_observation = current_observation;
        notifyPropertyChanged(BR.currentObservation);
    }
    //    return forecastunderground;
    //}

    //public void setForecastunderground(ForecastUnderground forecastunderground) {
     //   this.forecastunderground = forecastunderground;
//        notifyPropertyChanged(BR.forecast);
  //  }
}
