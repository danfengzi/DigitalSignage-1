package signage.digital.com.digitalsignage.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.google.gson.annotations.SerializedName;

import signage.digital.com.digitalsignage.BR;


/**
 * Created by fung.lam on 02/09/2015.
 * for openweathermap webservice call
 */
public class CurrentObservation  extends BaseObservable {

    @SerializedName("display_location")
    public DisplayObservation display = new DisplayObservation();

    @SerializedName("observation_location")
    public ObservationLocation location = new ObservationLocation();

    @SerializedName("weather")
    public String weather = "";

    @SerializedName("temp_f")
    public String temp_f = "";

    @SerializedName("temp_c")
    public String temp_c = "";

    @SerializedName("relative_humidity")
    public String humidity = "";

    @SerializedName("pressure_mb")
    public String pressure_mb = "";

    @SerializedName("pressure_in")
    public String pressure_in = "";

    @SerializedName("solarradiation")
    public String solarradiation = "";

    @SerializedName("UV")
    public String uv = "";

    @SerializedName("icon_url")
    public String icon_url = "";

    @SerializedName("icon")
    public String icon = "";

    @Bindable
    public DisplayObservation getDisplay() {
        return display;
    }

    @Bindable
    public ObservationLocation getLocation() {
        return location;
    }

    @Bindable
    public String getWeather() {
        return weather;
    }

    @Bindable
    public String getTemp_f() {
        return temp_f;
    }

    @Bindable
    public String getTemp_c() {
        return temp_c;
    }

    @Bindable
    public String getHumidity() {
        return humidity;
    }

    @Bindable
    public String getPressure_mb() {
        return pressure_mb;
    }

    @Bindable
    public String getPressure_in() {
        return pressure_in;
    }

    @Bindable
    public String getSolarradiation() {
        return solarradiation;
    }

    @Bindable
    public String getUv() {
        return uv;
    }

    @Bindable
    public String getIcon_url() {
        return icon_url;
    }

    @Bindable
    public String getIcon() {
        return icon;
    }

    public void setDisplay(DisplayObservation display) {
        this.display = display;
    }

    public void setLocation(ObservationLocation location) {
        this.location = location;
    }

    public void setWeather(String weather) {
        this.weather = weather;
        notifyPropertyChanged(BR.weather);

    }

    public void setTemp_f(String temp_f) {
        this.temp_f = temp_f;
        notifyPropertyChanged(BR.temp_f);

    }

    public void setTemp_c(String temp_c) {
        this.temp_c = temp_c;
        notifyPropertyChanged(BR.temp_c);

    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
        notifyPropertyChanged(BR.humidity);

    }

    public void setPressure_mb(String pressure_mb) {
        this.pressure_mb = pressure_mb;
        notifyPropertyChanged(BR.pressure_mb);

    }

    public void setPressure_in(String pressure_in) {
        this.pressure_in = pressure_in;
        notifyPropertyChanged(BR.pressure_in);

    }

    public void setSolarradiation(String solarradiation) {
        this.solarradiation = solarradiation;
        notifyPropertyChanged(BR.solarradiation);

    }

    public void setUv(String uv) {
        this.uv = uv;
        notifyPropertyChanged(BR.uv);
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
        notifyPropertyChanged(BR.icon_url);

    }

    public void setIcon(String icon) {
        this.icon = icon;
        notifyPropertyChanged(BR.icon);

    }
}
