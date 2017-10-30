package signage.digital.com.digitalsignage.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import signage.digital.com.digitalsignage.BR;

public class SimpleForecast  extends BaseObservable {

    @SerializedName("forecastday")
    public ArrayList<ForecastDay> forecastday = new ArrayList<ForecastDay>();

    @Bindable
    public ArrayList<ForecastDay> getForecastday() {
        return forecastday;
    }

    public void setForecastday(ArrayList<ForecastDay> forecastday) {
        this.forecastday = forecastday;
        notifyPropertyChanged(BR.forecastday);
    }
}
