package signage.digital.com.digitalsignage.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.google.gson.annotations.SerializedName;

import signage.digital.com.digitalsignage.BR;

public class Temperature  extends BaseObservable {

    @SerializedName("celsius")
    public String celsius = "";

    @SerializedName("fahrenheit")
    public String fahrenheit = "";

    @Bindable public String getCelsius() {
        return celsius;
    }

    @Bindable public String getFahrenheit() {
        return fahrenheit;
    }

    public void setCelsius(String celsius) {
        this.celsius = celsius;
        notifyPropertyChanged(BR.day);

    }

    public void setFahrenheit(String fahrenheit) {
        this.fahrenheit = fahrenheit;
        notifyPropertyChanged(BR.fahrenheit);

    }
}
