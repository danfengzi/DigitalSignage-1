package signage.digital.com.digitalsignage.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.google.gson.annotations.SerializedName;

import signage.digital.com.digitalsignage.BR;

public class ForecastDate  extends BaseObservable {

    @SerializedName("day")
    public int day = 0;

    @SerializedName("month")
    public int month = 0;

    @SerializedName("year")
    public int year = 0;

    @SerializedName("weekday_short")
    public String weekday_short = "";

    @SerializedName("weekday")
    public String weekday = "";

    @Bindable
    public int getDay() {
        return day;
    }

    @Bindable
    public int getMonth() {
        return month;
    }

    @Bindable
    public int getYear() {
        return year;
    }

    @Bindable
    public String getWeekday_short() {
        return weekday_short;
    }

    @Bindable
    public String getWeekday() {
        return weekday;
    }

    public void setDay(int day) {
        this.day = day;
        notifyPropertyChanged(BR.day);
    }

    public void setMonth(int month) {
        this.month = month;
        notifyPropertyChanged(BR.month);

    }

    public void setYear(int year) {
        this.year = year;
        notifyPropertyChanged(BR.year);

    }

    public void setWeekday_short(String weekday_short) {
        this.weekday_short = weekday_short;
        notifyPropertyChanged(BR.weekday_short);

    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
        notifyPropertyChanged(BR.weekday);

    }

}
