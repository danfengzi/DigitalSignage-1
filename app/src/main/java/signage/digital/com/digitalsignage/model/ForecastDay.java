package signage.digital.com.digitalsignage.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.google.gson.annotations.SerializedName;

import signage.digital.com.digitalsignage.BR;

public class ForecastDay  extends BaseObservable {

    @SerializedName("high")
    public Temperature high = new Temperature();

    @SerializedName("low")
    public  Temperature low = new Temperature();

    @SerializedName("date")
    public  ForecastDate date = new ForecastDate();

    @SerializedName("icon")
    public  String icon = "";

    @SerializedName("avehumidity")
    public  int avehumidity = 0;

    @SerializedName("pop")
    public  int pop = 0;

    @Bindable
    public Temperature getHigh() {
        return high;
    }

    @Bindable
    public Temperature getLow() {
        return low;
    }

    @Bindable
    public String getIcon() {
        return icon;
    }

    @Bindable
    public int getAvehumidity() {
        return avehumidity;
    }

    @Bindable
    public ForecastDate getDate() {
        return date;
    }

    @Bindable
    public int getPop() {
        return pop;
    }

    public void setHigh(Temperature high) {
        this.high = high;
        notifyPropertyChanged(BR.high);

    }

    public void setLow(Temperature low) {
        this.low = low;
        notifyPropertyChanged(BR.low);
    }

    public void setDate(ForecastDate date) {
        this.date = date;
        notifyPropertyChanged(BR.date);

    }

    public void setIcon(String icon) {
        this.icon = icon;
        notifyPropertyChanged(BR.icon);

    }

    public void setAvehumidity(int avehumidity) {
        this.avehumidity = avehumidity;
        notifyPropertyChanged(BR.avehumidity);

    }

    public void setPop(int pop) {
        this.pop = pop;
        notifyPropertyChanged(BR.pop);

    }
}
