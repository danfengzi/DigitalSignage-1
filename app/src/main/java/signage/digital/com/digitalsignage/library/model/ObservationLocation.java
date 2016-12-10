package signage.digital.com.digitalsignage.library.model;

import com.google.gson.annotations.SerializedName;


/**
 * Created by fung.lam on 02/09/2015.
 * for openweathermap webservice call
 */
public class ObservationLocation {

    @SerializedName("full")
    String full;

    @SerializedName("city")
    String city;

    @SerializedName("state")
    String state;

    @SerializedName("country")
    String country;

    public String getFull() {
        return full;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }
}
