package signage.digital.com.digitalsignage.library.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TxtForecast {

    @SerializedName("forecastday")
    ArrayList<ForecastTxtDay> forecastday;

    public ArrayList<ForecastTxtDay> getForecastDay() {
        return forecastday;
    }
}
