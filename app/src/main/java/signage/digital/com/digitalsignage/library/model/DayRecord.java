package signage.digital.com.digitalsignage.library.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by fung.lam on 02/09/2015.
 * for openweathermap webservice call
 */
public class DayRecord {

    @SerializedName("main")
    TemperatureRecord temperature;

    @SerializedName("weather")
    List<WeatherRecord> weather;

    @SerializedName("clouds")
    CloudsRecord clouds;

    @SerializedName("wind")
    WindRecord wind;

    @SerializedName("rain")
    RainRecord rain;

    public String getDate() {
        return date;
    }

    @SerializedName("dt_txt")
    String date;

    public TemperatureRecord getTemperature() {
        return temperature;
    }

    public ArrayList<WeatherRecord> getWeather() {
        return new ArrayList<>(weather);
    }

    public CloudsRecord getClouds() {
        return clouds;
    }

    public WindRecord getWind() {
        return wind;
    }

    public RainRecord getRain() {
        return rain;
    }
}
