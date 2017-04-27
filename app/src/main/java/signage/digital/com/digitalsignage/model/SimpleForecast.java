package signage.digital.com.digitalsignage.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SimpleForecast {

    @SerializedName("forecastday")
    ArrayList<ForecastDay> forecastday = new ArrayList<ForecastDay>();

    public ArrayList<ForecastDay> getForecastDay() {
        return forecastday;
    }
}
