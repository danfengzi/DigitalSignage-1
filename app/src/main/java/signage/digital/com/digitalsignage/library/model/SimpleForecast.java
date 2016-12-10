package signage.digital.com.digitalsignage.library.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SimpleForecast {

    @SerializedName("forecastday")
    ArrayList<ForecastDay> forecastday;

    public ArrayList<ForecastDay> getForecastDay() {
        return forecastday;
    }
}
