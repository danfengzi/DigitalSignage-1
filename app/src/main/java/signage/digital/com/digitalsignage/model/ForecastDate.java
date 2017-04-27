package signage.digital.com.digitalsignage.model;

import com.google.gson.annotations.SerializedName;

public class ForecastDate {

    @SerializedName("day")
    int day = 0;

    @SerializedName("month")
    int month = 0;

    @SerializedName("year")
    int year = 0;

    @SerializedName("weekday_short")
    String weekday_short = "";

    @SerializedName("weekday")
    String weekday = "";

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
