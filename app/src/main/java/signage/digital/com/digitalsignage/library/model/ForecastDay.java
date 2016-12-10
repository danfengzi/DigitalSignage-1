package signage.digital.com.digitalsignage.library.model;

import com.google.gson.annotations.SerializedName;

public class ForecastDay {

    @SerializedName("high")
    Temperature high;

    @SerializedName("low")
    Temperature low;

    @SerializedName("icon")
    String icon;

    @SerializedName("avehumidity")
    int avehumidity;

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
}
