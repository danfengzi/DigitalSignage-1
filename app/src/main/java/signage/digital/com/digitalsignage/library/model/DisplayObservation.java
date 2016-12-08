package signage.digital.com.digitalsignage.library.model;

import com.google.gson.annotations.SerializedName;


/**
 * Created by fung.lam on 02/09/2015.
 * for openweathermap webservice call
 */
public class DisplayObservation {

    @SerializedName("full")
    String full;

    @SerializedName("city")
    String city;

    public String getFull() {
        return full;
    }

    public String getCity() {
        return city;
    }
}
