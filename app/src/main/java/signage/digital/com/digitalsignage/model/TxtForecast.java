package signage.digital.com.digitalsignage.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TxtForecast {

    @SerializedName("forecastday")
    ArrayList<ForecastTxtDay> forecastday = new ArrayList<ForecastTxtDay>();

    public ArrayList<ForecastTxtDay> getForecastDay() {
        return forecastday;
    }
}
