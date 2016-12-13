package signage.digital.com.digitalsignage.library.model;

import com.google.gson.annotations.SerializedName;

public class ForecastDate {

    @SerializedName("day")
    int day;

    @SerializedName("month")
    int month;

    @SerializedName("year")
    int year;

    @SerializedName("weekday_short")
    String weekday_short;

    @SerializedName("weekday")
    String weekday;

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getWeekday_short() {
        return weekday_short;
    }

    public String getWeekday() {
        return weekday;
    }
}
