package signage.digital.com.digitalsignage.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

import com.google.gson.annotations.SerializedName;


/**
 * Created by fung.lam on 02/09/2015.
 * for openweathermap webservice call
 */
public class DisplayObservation  extends BaseObservable {

    String full;
    String city;

    public DisplayObservation() {
    }

    @Bindable
    public String getFull() {
        return full;
    }

    @Bindable
    public String getCity() {
        return city;
    }
}
