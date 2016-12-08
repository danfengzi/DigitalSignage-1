package signage.digital.com.digitalsignage.library.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fung.lam on 02/09/2015.
 * for openweathermap webservice call
 */
public class RainRecord {

    @SerializedName("3h")
    float rain;

    public float getRain() {
        return rain;
    }

}
