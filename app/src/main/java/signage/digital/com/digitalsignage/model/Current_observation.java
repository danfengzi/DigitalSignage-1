package signage.digital.com.digitalsignage.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import signage.digital.com.digitalsignage.BR;


/**
 * Created by fung.lam on 02/09/2015.
 * for openweathermap webservice call
 */
public class Current_observation  extends BaseObservable {

    //Long dewpoint_c;
    //Long dewpoint_f;
    Double temp_f;
    Double temp_c;
    //Long wind_mph;
    //Long wind_kph;
    //Long wind_degrees;
    //Long wind_gust_mph;
    //Long wind_gust_kph;
    String icon;

/*    String precip_1hr_metric;
    String precip_today_metric;
    String pressure_trend;
    String forecast_url;
    String history_url;
    String windchill_string;
    */
    String weather;
/*    String station_id;
    String UV;
    String observation_epoch;
    String precip_1hr_in;
    String feelslike_string;
    String observation_time;
    String local_tz_long;
    */
    String relative_humidity;
/*    Image image;
    String solarradiation;
    String visibility_mi;
    Observation_location observation_location;
    String precip_today_string;
    String feelslike_f;
    String observation_time_rfc822;
    String feelslike_c;
    String heat_index_string;
    String ob_url;
    String dewpoint_string;
    String local_tz_offset;
    String windchill_f;
    String windchill_c;
    String pressure_in;
    String pressure_mb;
    String local_time_rfc822;
    String precip_1hr_string;
    String icon_url;
    String wind_dir;
    String nowcast;
    Display_location display_location;
    String visibility_km;
    String temperature_string;
    String local_tz_short;
    String local_epoch;
    String wind_string;
    String precip_today_in;
*/
    public Current_observation() {
    }
/*
    @Bindable
    public Long getDewpoint_f ()
    {
        return dewpoint_f;
    }

    public void setDewpoint_f (Long dewpoint_f)
    {
        this.dewpoint_f = dewpoint_f;
        notifyPropertyChanged(BR.dewpoint_f);
    }

    @Bindable
    public Long getWind_degrees ()
    {
        return wind_degrees;
    }

    public void setWind_degrees (Long wind_degrees)
    {
        this.wind_degrees = wind_degrees;
        notifyPropertyChanged(BR.wind_degrees);

    }

    @Bindable
    public Long getDewpoint_c ()
    {
        return dewpoint_c;
    }

    public void setDewpoint_c (Long dewpoint_c)
    {
        this.dewpoint_c = dewpoint_c;
        notifyPropertyChanged(BR.dewpoint_c);

    }


    @Bindable
    public Long getWind_kph ()
    {
        return wind_kph;
    }

    public void setWind_kph (Long wind_kph)
    {
        this.wind_kph = wind_kph;
        notifyPropertyChanged(BR.wind_kph);
    }

    @Bindable
    public Long getWind_mph ()
    {
        return wind_mph;
    }

    public void setWind_mph (Long wind_mph)
    {
        this.wind_mph = wind_mph;
        notifyPropertyChanged(BR.wind_mph);
    }
*/
    @Bindable
    public Double getTemp_c ()
    {
        return temp_c;
    }

    public void setTemp_c (Double temp_c)
    {
        this.temp_c = temp_c;
        notifyPropertyChanged(BR.temp_c);
    }

    @Bindable
    public Double getTemp_f ()
    {
        return temp_f;
    }

    public void setTemp_f (Double temp_f)
    {
        this.temp_f = temp_f;
        notifyPropertyChanged(BR.temp_f);
    }

    @Bindable
    public String getIcon ()
    {
        return icon;
    }

    public void setIcon (String icon)
    {
        this.icon = icon;
        notifyPropertyChanged(BR.icon);
    }

/*
    @Bindable
    public Long getWind_gust_kph()
    {
        return wind_gust_kph;
    }

    public void setWind_gust_kph (Long wind_gust_kph)
    {
        Log.e("-------","Current obser windgustkm");
        this.wind_gust_kph = wind_gust_kph;
        notifyPropertyChanged(BR.wind_gust_kph);
    }

    @Bindable
    public Long getWind_gust_mph()
    {
        return wind_gust_mph;
    }

    public void setWind_gust_mph (Long wind_gust_mph)
    {
        Log.e("-------","Current obser windgustmph");
        this.wind_gust_mph = wind_gust_mph;
        notifyPropertyChanged(BR.wind_gust_mph);
    }


    @Bindable
    public String getPrecip_1hr_metric ()
    {
        return precip_1hr_metric;
    }

    public void setPrecip_1hr_metric (String precip_1hr_metric)
    {
        this.precip_1hr_metric = precip_1hr_metric;
        notifyPropertyChanged(BR.precip_1hr_metric);
    }

    @Bindable
    public String getPrecip_today_metric ()
    {
        return precip_today_metric;
    }

    public void setPrecip_today_metric (String precip_today_metric)
    {
        this.precip_today_metric = precip_today_metric;
        notifyPropertyChanged(BR.precip_today_metric);
    }

    @Bindable
    public String getPressure_trend ()
    {
        return pressure_trend;
    }

    public void setPressure_trend (String pressure_trend)
    {
        Log.e("-------","Current obser 3");
        this.pressure_trend = pressure_trend;
        notifyPropertyChanged(BR.pressure_trend);
    }

    @Bindable
    public String getForecast_url ()
    {
        return forecast_url;
    }

    public void setForecast_url (String forecast_url)
    {
        Log.e("-------","Current obser 4");
        this.forecast_url = forecast_url;
    }

    @Bindable
    public String getHistory_url ()
    {
        return history_url;
    }

    public void setHistory_url (String history_url)
    {
        Log.e("-------","Current obser 5");
        this.history_url = history_url;
    }

    @Bindable
    public String getWindchill_string ()
    {
        return windchill_string;
    }

    public void setWindchill_string (String windchill_string)
    {
        Log.e("-------","Current obser 6");
        this.windchill_string = windchill_string;
        notifyPropertyChanged(BR.windchill_string);
    }
*/
    @Bindable
    public String getWeather ()
    {
        return weather;
    }

    public void setWeather (String weather)
    {
        this.weather = weather;
        notifyPropertyChanged(BR.weather);
    }
/*
    @Bindable
    public String getStation_id ()
    {
        return station_id;
    }

    public void setStation_id (String station_id)
    {
        Log.e("-------","Current obser 8");
        this.station_id = station_id;
    }

    @Bindable
    public String getUV ()
    {
        return UV;
    }

    public void setUV (String uv)
    {
        Log.e("-------","Current obser 9");
        this.UV = uv;
        notifyPropertyChanged(BR.uV);
    }

    @Bindable
    public String getObservation_epoch ()
    {
        return observation_epoch;
    }

    public void setObservation_epoch (String observation_epoch)
    {
        Log.e("-------","Current obser 10");
        this.observation_epoch = observation_epoch;
    }


    @Bindable
    public String getPrecip_1hr_in ()
    {
        return precip_1hr_in;
    }

    public void setPrecip_1hr_in (String precip_1hr_in)
    {
        Log.e("-------","Current obser 11");
        this.precip_1hr_in = precip_1hr_in;
        notifyPropertyChanged(BR.precip_1hr_in);
    }

    @Bindable
    public String getFeelslike_string ()
    {
        return feelslike_string;
    }

    public void setFeelslike_string (String feelslike_string)
    {
        Log.e("-------","Current obser 12");
        this.feelslike_string = feelslike_string;
        notifyPropertyChanged(BR.feelslike_string);
    }

    @Bindable
    public String getObservation_time ()
    {
        return observation_time;
    }

    public void setObservation_time (String observation_time)
    {
        Log.e("-------","Current obser 13");
        this.observation_time = observation_time;
        notifyPropertyChanged(BR.observation_time);
    }

    @Bindable
    public String getLocal_tz_long ()
    {
        return local_tz_long;
    }

    public void setLocal_tz_long (String local_tz_long)
    {
        Log.e("-------","Current obser 14");

        this.local_tz_long = local_tz_long;
    }
*/
    @Bindable
    public String getRelative_humidity ()
    {
        return relative_humidity;
    }

    public void setRelative_humidity (String relative_humidity)
    {
        this.relative_humidity = relative_humidity;
        notifyPropertyChanged(BR.relative_humidity);
    }

/*
    @Bindable
    public Image getImage ()
    {
        return image;
    }

    public void setImage (Image image)
    {
        this.image = image;
    }

    @Bindable
    public String getSolarradiation ()
    {
        return solarradiation;
    }

    public void setSolarradiation (String solarradiation)
    {
        this.solarradiation = solarradiation;
        notifyPropertyChanged(BR.solarradiation);
    }

    @Bindable
    public String getVisibility_mi ()
    {
        return visibility_mi;
    }

    public void setVisibility_mi (String visibility_mi)
    {
        Log.e("-------","Current obser 18");
        this.visibility_mi = visibility_mi;
        notifyPropertyChanged(BR.visibility_mi);
    }

    @Bindable
    public Observation_location getObservation_location ()
    {
        return observation_location;
    }

    public void setObservation_location (Observation_location observation_location)
    {
        Log.e("-------","Current obser 19");
        this.observation_location = observation_location;
    }

    @Bindable
    public String getPrecip_today_string ()
    {
        return precip_today_string;
    }

    public void setPrecip_today_string (String precip_today_string)
    {
        Log.e("-------","Current obser 21");
        this.precip_today_string = precip_today_string;
        notifyPropertyChanged(BR.precip_today_string);
    }

    @Bindable
    public String getFeelslike_f ()
    {
        return feelslike_f;
    }

    public void setFeelslike_f (String feelslike_f)
    {
        Log.e("-------","Current obser 22");
        this.feelslike_f = feelslike_f;
        notifyPropertyChanged(BR.feelslike_f);
    }

    @Bindable
    public String getObservation_time_rfc822 ()
    {
        return observation_time_rfc822;
    }

    public void setObservation_time_rfc822 (String observation_time_rfc822)
    {
        Log.e("-------","Current obser23");
        this.observation_time_rfc822 = observation_time_rfc822;
    }

    @Bindable
    public String getFeelslike_c ()
    {
        return feelslike_c;
    }

    public void setFeelslike_c (String feelslike_c)
    {
        Log.e("-------","Current obser 24");
        this.feelslike_c = feelslike_c;
        notifyPropertyChanged(BR.feelslike_c);
    }

    @Bindable
    public String getHeat_index_string ()
    {
        return heat_index_string;
    }

    public void setHeat_index_string (String heat_index_string)
    {
        Log.e("-------","Current obser 26");
        this.heat_index_string = heat_index_string;
        notifyPropertyChanged(BR.heat_index_string);
    }

    @Bindable
    public String getOb_url ()
    {
        return ob_url;
    }

    public void setOb_url (String ob_url)
    {

        Log.e("-------","Current obser 27");
        this.ob_url = ob_url;
    }

    @Bindable
    public String getDewpoint_string ()
    {
        return dewpoint_string;
    }

    public void setDewpoint_string (String dewpoint_string)
    {
        Log.e("-------","Current obser 28");
        this.dewpoint_string = dewpoint_string;
        notifyPropertyChanged(BR.dewpoint_string);
    }

    public String getLocal_tz_offset ()
    {
        return local_tz_offset;
    }
    @Bindable

    public void setLocal_tz_offset (String local_tz_offset)
    {
        Log.e("-------","Current obser 29");
        this.local_tz_offset = local_tz_offset;
    }


    @Bindable
    public String getWindchill_f ()
    {
        return windchill_f;
    }

    public void setWindchill_f (String windchill_f)
    {
        Log.e("-------","Current obser 30");
        this.windchill_f = windchill_f;
        notifyPropertyChanged(BR.windchill_f);
    }

    @Bindable
    public String getWindchill_c ()
    {
        return windchill_c;
    }

    public void setWindchill_c (String windchill_c)
    {
        Log.e("-------","Current obser 31");
        this.windchill_c = windchill_c;
        notifyPropertyChanged(BR.windchill_c);
    }

    @Bindable
    public String getPressure_in ()
    {
        return pressure_in;
    }

    public void setPressure_in (String pressure_in)
    {
        Log.e("-------","Current obser 32");
        this.pressure_in = pressure_in;
        notifyPropertyChanged(BR.pressure_in);

    }


    @Bindable
    public String getPressure_mb ()
    {
        return pressure_mb;
    }

    public void setPressure_mb (String pressure_mb)
    {
        Log.e("-------","Current obser 34");
        this.pressure_mb = pressure_mb;
        notifyPropertyChanged(BR.pressure_mb);
    }


    @Bindable
    public String getLocal_time_rfc822 ()
    {
        return local_time_rfc822;
    }

    public void setLocal_time_rfc822 (String local_time_rfc822)
    {
        Log.e("-------","Current obser 36");
        this.local_time_rfc822 = local_time_rfc822;
    }

    @Bindable
    public String getPrecip_1hr_string ()
    {
        return precip_1hr_string;
    }

    public void setPrecip_1hr_string (String precip_1hr_string)
    {
        Log.e("-------","Current obser 37");
        this.precip_1hr_string = precip_1hr_string;
        notifyPropertyChanged(BR.precip_1hr_string);

    }

    @Bindable
    public String getIcon_url ()
    {
        return icon_url;
    }

    public void setIcon_url (String icon_url)
    {
        Log.e("-------","Current obser 38");
        this.icon_url = icon_url;
    }

    @Bindable
    public String getWind_dir ()
    {
        return wind_dir;
    }

    public void setWind_dir (String wind_dir)
    {
        Log.e("-------","Current obser 39");
        this.wind_dir = wind_dir;
        notifyPropertyChanged(BR.wind_dir);

    }


    @Bindable
    public String getNowcast ()
    {
        return nowcast;
    }

    public void setNowcast (String nowcast)
    {
        Log.e("-------","Current obser nowcast");
        this.nowcast = nowcast;
    }

    @Bindable
    public Display_location getDisplay_location ()
    {
        return display_location;
    }

    public void setDisplay_location (Display_location display_location)
    {
        Log.e("-------","Current obser 40");
        this.display_location = display_location;
    }

    @Bindable
    public String getVisibility_km ()
    {
        return visibility_km;
    }

    public void setVisibility_km (String visibility_km)
    {
        Log.e("-------","Current obser 41");
        this.visibility_km = visibility_km;
        notifyPropertyChanged(BR.visibility_km);

    }

    @Bindable
    public String getTemperature_string ()
    {
        return temperature_string;
    }

    public void setTemperature_string (String temperature_string)
    {
        Log.e("-------","Current obser 42");
        this.temperature_string = temperature_string;
        notifyPropertyChanged(BR.temperature_string);

    }

    @Bindable
    public String getLocal_tz_short ()
    {
        return local_tz_short;
    }

    public void setLocal_tz_short (String local_tz_short)
    {
        Log.e("-------","Current obser 43");
        this.local_tz_short = local_tz_short;
    }

    @Bindable
    public String getLocal_epoch ()
    {
        return local_epoch;
    }

    public void setLocal_epoch (String local_epoch)
    {
        Log.e("-------","Current obser 44");
        this.local_epoch = local_epoch;
    }

    @Bindable
    public String getWind_string ()
    {
        return wind_string;
    }

    public void setWind_string (String wind_string)
    {
        Log.e("-------","Current obser 45");
        this.wind_string = wind_string;
        notifyPropertyChanged(BR.wind_string);

    }

    @Bindable
    public String getPrecip_today_in ()
    {
        return precip_today_in;
    }

    public void setPrecip_today_in (String precip_today_in)
    {
        Log.e("-------","Current obser 46");
        this.precip_today_in = precip_today_in;
        notifyPropertyChanged(BR.precip_today_in);
    }
    */
}
