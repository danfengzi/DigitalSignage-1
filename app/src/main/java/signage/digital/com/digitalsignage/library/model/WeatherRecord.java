package signage.digital.com.digitalsignage.library.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fung.lam on 02/09/2015.
 * for openweathermap webservice call
 */
public class WeatherRecord {

    @SerializedName("id")
    int id;

    @SerializedName("main")
    String main;

    @SerializedName("description")
    String description;

    @SerializedName("icon")
    String icon;

    public int getId() {
        return id;
    }

    public String getMain() {
        return main;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }
}
