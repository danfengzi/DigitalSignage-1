package signage.digital.com.digitalsignage.model;

import com.google.gson.annotations.SerializedName;

public class Temperature {

    @SerializedName("celsius")
    String celsius = "";

    @SerializedName("fahrenheit")
    String fahrenheit = "";

    public String getCelsius() {
        return celsius;
    }

    public String getFahrenheit() {
        return fahrenheit;
    }
}
