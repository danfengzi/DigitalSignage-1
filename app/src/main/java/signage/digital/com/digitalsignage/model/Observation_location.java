package signage.digital.com.digitalsignage.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by fung.lam on 02/09/2015.
 * for openweathermap webservice call
 */
public class Observation_location extends BaseObservable {

    private String full;
    private String elevation;
    private String state;
    private String longitude;
    private String latitude;
    private String country_iso3166;
    private String country;
    private String city;

    public Observation_location() {
    }

    @Bindable
    public String getFull ()
    {
        return full;
    }

    public void setFull (String full)
    {
        this.full = full;
    }

    @Bindable
    public String getElevation ()
    {
        return elevation;
    }

    public void setElevation (String elevation)
    {
        this.elevation = elevation;
    }

    @Bindable
    public String getState ()
    {
        return state;
    }

    public void setState (String state)
    {
        this.state = state;
    }

    @Bindable
    public String getLongitude ()
    {
        return longitude;
    }

    public void setLongitude (String longitude)
    {
        this.longitude = longitude;
    }

    @Bindable
    public String getLatitude ()
    {
        return latitude;
    }

    public void setLatitude (String latitude)
    {
        this.latitude = latitude;
    }

    @Bindable
    public String getCountry_iso3166 ()
    {
        return country_iso3166;
    }

    public void setCountry_iso3166 (String country_iso3166)
    {
        this.country_iso3166 = country_iso3166;
    }

    @Bindable
    public String getCountry ()
    {
        return country;
    }

    public void setCountry (String country)
    {
        this.country = country;
    }

    @Bindable
    public String getCity ()
    {
        return city;
    }

    public void setCity (String city)
    {
        this.city = city;
    }

}