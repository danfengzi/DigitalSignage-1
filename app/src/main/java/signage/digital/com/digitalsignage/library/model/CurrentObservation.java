package signage.digital.com.digitalsignage.library.model;

import com.google.gson.annotations.SerializedName;


/**
 * Created by fung.lam on 02/09/2015.
 * for openweathermap webservice call
 */
public class CurrentObservation {

    @SerializedName("display_location")
    DisplayObservation display;

    @SerializedName("observation_location")
    ObservationLocation location;

    @SerializedName("weather")
    String weather;

    @SerializedName("temp_f")
    String temp_f;

    @SerializedName("temp_c")
    String temp_c;

    @SerializedName("relative_humidity")
    String humidity;

    @SerializedName("pressure_mb")
    String pressure_mb;

    @SerializedName("pressure_in")
    String pressure_in;

    @SerializedName("solarradiation")
    String solarradiation;

    @SerializedName("UV")
    String uv;

    @SerializedName("icon_url")
    String icon_url;

    @SerializedName("icon")
    String icon;

    public DisplayObservation getDisplay() {
        return display;
    }

    public ObservationLocation getLocation() {
        return location;
    }

    public String getWeather() {
        return weather;
    }

    public String getTemp_f() {
        return temp_f;
    }

    public String getTemp_c() {
        return temp_c;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getPressure_mb() {
        return pressure_mb;
    }

    public String getPressure_in() {
        return pressure_in;
    }

    public String getSolarradiation() {
        return solarradiation;
    }

    public String getUv() {
        return uv;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public String getIcon() {
        return icon;
    }

}
