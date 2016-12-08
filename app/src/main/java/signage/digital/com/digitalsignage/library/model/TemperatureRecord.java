package signage.digital.com.digitalsignage.library.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fung.lam on 02/09/2015.
 * for openweathermap webservice call
 */
public class TemperatureRecord {

    @SerializedName("temp")
    float temperature;

    @SerializedName("pressure")
    float pressure;

    @SerializedName("humidity")
    float humidity;

    @SerializedName("temp_min")
    float minimumTemperature;

    @SerializedName("temp_max")
    float maximunTemperature;

    public float getTemperature() {
        return temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getMinimumTemperature() {
        return minimumTemperature;
    }

    public float getMaximunTemperature() {
        return maximunTemperature;
    }
}
