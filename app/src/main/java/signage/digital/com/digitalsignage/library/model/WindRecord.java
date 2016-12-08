package signage.digital.com.digitalsignage.library.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fung.lam on 02/09/2015.
 * for openweathermap webservice call
 */
public class WindRecord {

    @SerializedName("speed")
    float speed;

    @SerializedName("deg")
    float deg;

    public float getSpeed() {
        return speed;
    }

    public float getDeg() {
        return deg;
    }

}
