package signage.digital.com.digitalsignage.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

/**
 * Created by everest on 30/10/2017.
 */

public class Display_location extends BaseObservable {
    String zip;
    String magic;
    String full;
    String elevation;
    String state;
    String wmo;
    String longitude;
    String latitude;
    String state_name;
    String country_iso3166;
    String country;
    String city;

    public Display_location() {
        Log.d("-----","Display Location:");

    }

    @Bindable
    public String getZip ()
    {
        return zip;
    }

    public void setZip (String zip)
    {
        this.zip = zip;
    }

    @Bindable
    public String getMagic ()
    {
        return magic;
    }

    public void setMagic (String magic)
    {
        this.magic = magic;
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
    public String getWmo ()
    {
        return wmo;
    }

    public void setWmo (String wmo)
    {
        this.wmo = wmo;
    }

    @Bindable
    public String getLongitude ()
    {
        return longitude;
    }

    @Bindable
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
    public String getState_name ()
    {
        return state_name;
    }

    public void setState_name (String state_name)
    {
        this.state_name = state_name;
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

