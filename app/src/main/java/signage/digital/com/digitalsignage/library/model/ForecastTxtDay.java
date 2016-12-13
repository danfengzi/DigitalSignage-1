package signage.digital.com.digitalsignage.library.model;

import com.google.gson.annotations.SerializedName;

public class ForecastTxtDay {

    @SerializedName("period")
    int period;

    @SerializedName("icon")
    String icon;

    @SerializedName("title")
    String title;

    @SerializedName("fcttext")
    String fcttext;

    @SerializedName("fcttext_metric")
    String fcttext_metric;

    @SerializedName("pop")
    String pop;

    public int getPeriod() {
        return period;
    }

    public String getIcon() {
        return icon;
    }

    public String getTitle() {
        return title;
    }

    public String getFcttext() {
        return fcttext;
    }

    public String getFcttext_metric() {
        return fcttext_metric;
    }

    public String getPop() {
        return pop;
    }
}
