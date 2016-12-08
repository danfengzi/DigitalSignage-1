package signage.digital.com.digitalsignage.library.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ForecastRecord {

    @SerializedName("dt")
    long date;

    @SerializedName("city")
    CityRecord city;

    @SerializedName("list")
    List<DayRecord> dayResponseModel;

    public CityRecord getCity() {
        return city;
    }

    public long getDate() {
        return date;
    }

    public ArrayList<DayRecord> getForecast() {
        return new ArrayList<>(dayResponseModel);
    }
}
