package signage.digital.com.digitalsignage.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import signage.digital.com.digitalsignage.BR;

public class TxtForecast  extends BaseObservable {

    @SerializedName("forecastday")
    ArrayList<ForecastTxtDay> forecastday = new ArrayList<ForecastTxtDay>();

    @Bindable public ArrayList<ForecastTxtDay> getForecastDay() {
        return forecastday;
    }

    public void setForecastday(ArrayList<ForecastTxtDay> forecastday) {
        this.forecastday = forecastday;
    }
}
