package signage.digital.com.digitalsignage.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.google.gson.annotations.SerializedName;

import signage.digital.com.digitalsignage.BR;


/**
 * Created by fung.lam on 02/09/2015.
 * for openweathermap webservice call
 */
public class ObservationLocation  extends BaseObservable {

    @SerializedName("full")
    String full = "";

    @SerializedName("city")
    String city = "";

    @SerializedName("state")
    String state = "";

    @SerializedName("country")
    String country = "";

    @Bindable
    public String getFull() {
        return full;
    }

    @Bindable
    public String getCity() {
        return city;
    }

    @Bindable
    public String getState() {
        return state;
    }

    @Bindable
    public String getCountry() {
        return country;
    }

    public void setFull(String full) {
        this.full = full;
    }

    public void setCity(String city) {
        this.city = city;
        notifyPropertyChanged(BR.city);

    }

    public void setState(String state) {
        this.state = state;
        notifyPropertyChanged(BR.state);

    }

    public void setCountry(String country) {
        this.country = country;
        notifyPropertyChanged(BR.country);
    }
}
