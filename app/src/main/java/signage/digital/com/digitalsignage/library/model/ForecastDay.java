package signage.digital.com.digitalsignage.library.model;

import com.google.gson.annotations.SerializedName;

public class ForecastDay {

    @SerializedName("high")
    Temperature high;

    @SerializedName("low")
    Temperature low;

    @SerializedName("date")
    ForecastDate date;

    @SerializedName("icon")
    String icon;

    @SerializedName("avehumidity")
    int avehumidity;

    @SerializedName("pop")
    int pop;

    public Temperature getHigh() {
        return high;
    }

    public Temperature getLow() {
        return low;
    }

    public String getIcon() {
        return icon;
    }

    public int getAvehumidity() {
        return avehumidity;
    }

    public ForecastDate getDate() {
        return date;
    }

    public int getPop() {
        return pop;
    }
}
