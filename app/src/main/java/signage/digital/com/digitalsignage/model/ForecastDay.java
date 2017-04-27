package signage.digital.com.digitalsignage.model;

import com.google.gson.annotations.SerializedName;

public class ForecastDay {

    @SerializedName("high")
    Temperature high = new Temperature();

    @SerializedName("low")
    Temperature low = new Temperature();

    @SerializedName("date")
    ForecastDate date = new ForecastDate();

    @SerializedName("icon")
    String icon = "";

    @SerializedName("avehumidity")
    int avehumidity = 0;

    @SerializedName("pop")
    int pop = 0;

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
