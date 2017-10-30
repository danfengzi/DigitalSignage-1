package signage.digital.com.digitalsignage.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.google.gson.annotations.SerializedName;

import signage.digital.com.digitalsignage.BR;


/**
 * Created by fung.lam on 02/09/2015.
 * for openweathermap webservice call
 */
public class Current_observation  extends BaseObservable {

    private String wind_gust_mph;
    private String precip_1hr_metric;
    private String precip_today_metric;
    private String pressure_trend;
    private String forecast_url;
    private String history_url;
    private String windchill_string;
    private String weather;
    private String station_id;
    private String UV;
    private String observation_epoch;
    private String wind_gust_kph;
    private String precip_1hr_in;
    private String feelslike_string;
    private String observation_time;
    private String local_tz_long;
    private String temp_f;
    private String relative_humidity;
    private String temp_c;
    private Image image;
    private String solarradiation;
    private String visibility_mi;
    private Observation_location observation_location;
    private String wind_mph;
    private String heat_index_c;
    private String precip_today_string;
    private String feelslike_f;
    private String observation_time_rfc822;
    private String feelslike_c;
    private String heat_index_f;
    private String heat_index_string;
    private String ob_url;
    private String dewpoint_string;
    private String local_tz_offset;
    private String wind_kph;
    private String windchill_f;
    private String windchill_c;
    private String pressure_in;
    private String wind_degrees;
    private String dewpoint_c;
    private String pressure_mb;
    private String icon;
    private String local_time_rfc822;
    private String precip_1hr_string;
    private String icon_url;
    private String wind_dir;
    private String dewpoint_f;
    private String nowcast;
    private Display_location display_location;
    private String visibility_km;
    private String temperature_string;
    private String local_tz_short;
    private String local_epoch;
    private String wind_string;
    private String precip_today_in;

    public Current_observation() {
    }

    @Bindable
    public String getWind_gust_mph ()
    {
        return wind_gust_mph;
    }

    public void setWind_gust_mph (String wind_gust_mph)
    {
        this.wind_gust_mph = wind_gust_mph;
    }

    @Bindable
    public String getPrecip_1hr_metric ()
    {
        return precip_1hr_metric;
    }

    public void setPrecip_1hr_metric (String precip_1hr_metric)
    {
        this.precip_1hr_metric = precip_1hr_metric;
    }

    @Bindable
    public String getPrecip_today_metric ()
    {
        return precip_today_metric;
    }

    public void setPrecip_today_metric (String precip_today_metric)
    {
        this.precip_today_metric = precip_today_metric;
    }

    @Bindable
    public String getPressure_trend ()
    {
        return pressure_trend;
    }

    public void setPressure_trend (String pressure_trend)
    {
        this.pressure_trend = pressure_trend;
    }

    @Bindable
    public String getForecast_url ()
    {
        return forecast_url;
    }

    public void setForecast_url (String forecast_url)
    {
        this.forecast_url = forecast_url;
    }

    @Bindable
    public String getHistory_url ()
    {
        return history_url;
    }

    public void setHistory_url (String history_url)
    {
        this.history_url = history_url;
    }

    @Bindable
    public String getWindchill_string ()
    {
        return windchill_string;
    }

    public void setWindchill_string (String windchill_string)
    {
        this.windchill_string = windchill_string;
    }

    @Bindable
    public String getWeather ()
    {
        return weather;
    }

    public void setWeather (String weather)
    {
        this.weather = weather;
    }

    @Bindable
    public String getStation_id ()
    {
        return station_id;
    }

    public void setStation_id (String station_id)
    {
        this.station_id = station_id;
    }

    @Bindable
    public String getUV ()
    {
        return UV;
    }

    public void setUV (String UV)
    {
        this.UV = UV;
    }

    @Bindable
    public String getObservation_epoch ()
    {
        return observation_epoch;
    }

    public void setObservation_epoch (String observation_epoch)
    {
        this.observation_epoch = observation_epoch;
    }

    @Bindable
    public String getWind_gust_kph ()
    {
        return wind_gust_kph;
    }

    public void setWind_gust_kph (String wind_gust_kph)
    {
        this.wind_gust_kph = wind_gust_kph;
    }

    @Bindable
    public String getPrecip_1hr_in ()
    {
        return precip_1hr_in;
    }

    public void setPrecip_1hr_in (String precip_1hr_in)
    {
        this.precip_1hr_in = precip_1hr_in;
    }

    @Bindable
    public String getFeelslike_string ()
    {
        return feelslike_string;
    }

    public void setFeelslike_string (String feelslike_string)
    {
        this.feelslike_string = feelslike_string;
    }

    @Bindable
    public String getObservation_time ()
    {
        return observation_time;
    }

    public void setObservation_time (String observation_time)
    {
        this.observation_time = observation_time;
    }

    @Bindable
    public String getLocal_tz_long ()
    {
        return local_tz_long;
    }

    public void setLocal_tz_long (String local_tz_long)
    {
        this.local_tz_long = local_tz_long;
    }

    @Bindable
    public String getTemp_f ()
    {
        return temp_f;
    }

    public void setTemp_f (String temp_f)
    {
        this.temp_f = temp_f;
    }

    @Bindable
    public String getRelative_humidity ()
    {
        return relative_humidity;
    }

    public void setRelative_humidity (String relative_humidity)
    {
        this.relative_humidity = relative_humidity;
    }

    @Bindable
    public String getTemp_c ()
    {
        return temp_c;
    }

    public void setTemp_c (String temp_c)
    {
        this.temp_c = temp_c;
    }

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
    }

    @Bindable
    public String getVisibility_mi ()
    {
        return visibility_mi;
    }

    public void setVisibility_mi (String visibility_mi)
    {
        this.visibility_mi = visibility_mi;
    }

    @Bindable
    public Observation_location getObservation_location ()
    {
        return observation_location;
    }

    public void setObservation_location (Observation_location observation_location)
    {
        this.observation_location = observation_location;
    }

    @Bindable
    public String getWind_mph ()
    {
        return wind_mph;
    }

    public void setWind_mph (String wind_mph)
    {
        this.wind_mph = wind_mph;
    }

    @Bindable
    public String getHeat_index_c ()
    {
        return heat_index_c;
    }

    public void setHeat_index_c (String heat_index_c)
    {
        this.heat_index_c = heat_index_c;
    }

    @Bindable
    public String getPrecip_today_string ()
    {
        return precip_today_string;
    }

    public void setPrecip_today_string (String precip_today_string)
    {
        this.precip_today_string = precip_today_string;
    }

    @Bindable
    public String getFeelslike_f ()
    {
        return feelslike_f;
    }

    public void setFeelslike_f (String feelslike_f)
    {
        this.feelslike_f = feelslike_f;
    }

    @Bindable
    public String getObservation_time_rfc822 ()
    {
        return observation_time_rfc822;
    }

    public void setObservation_time_rfc822 (String observation_time_rfc822)
    {
        this.observation_time_rfc822 = observation_time_rfc822;
    }

    @Bindable
    public String getFeelslike_c ()
    {
        return feelslike_c;
    }

    public void setFeelslike_c (String feelslike_c)
    {
        this.feelslike_c = feelslike_c;
    }

    @Bindable
    public String getHeat_index_f ()
    {
        return heat_index_f;
    }

    public void setHeat_index_f (String heat_index_f)
    {
        this.heat_index_f = heat_index_f;
    }

    @Bindable
    public String getHeat_index_string ()
    {
        return heat_index_string;
    }

    public void setHeat_index_string (String heat_index_string)
    {
        this.heat_index_string = heat_index_string;
    }

    @Bindable
    public String getOb_url ()
    {
        return ob_url;
    }

    public void setOb_url (String ob_url)
    {
        this.ob_url = ob_url;
    }

    @Bindable
    public String getDewpoint_string ()
    {
        return dewpoint_string;
    }

    public void setDewpoint_string (String dewpoint_string)
    {
        this.dewpoint_string = dewpoint_string;
    }

    public String getLocal_tz_offset ()
    {
        return local_tz_offset;
    }
    @Bindable

    public void setLocal_tz_offset (String local_tz_offset)
    {
        this.local_tz_offset = local_tz_offset;
    }

    @Bindable
    public String getWind_kph ()
    {
        return wind_kph;
    }

    public void setWind_kph (String wind_kph)
    {
        this.wind_kph = wind_kph;
    }

    @Bindable
    public String getWindchill_f ()
    {
        return windchill_f;
    }

    public void setWindchill_f (String windchill_f)
    {
        this.windchill_f = windchill_f;
    }

    @Bindable
    public String getWindchill_c ()
    {
        return windchill_c;
    }

    public void setWindchill_c (String windchill_c)
    {
        this.windchill_c = windchill_c;
    }

    @Bindable
    public String getPressure_in ()
    {
        return pressure_in;
    }

    public void setPressure_in (String pressure_in)
    {
        this.pressure_in = pressure_in;
    }

    @Bindable
    public String getWind_degrees ()
    {
        return wind_degrees;
    }

    public void setWind_degrees (String wind_degrees)
    {
        this.wind_degrees = wind_degrees;
    }

    @Bindable
    public String getDewpoint_c ()
    {
        return dewpoint_c;
    }

    public void setDewpoint_c (String dewpoint_c)
    {
        this.dewpoint_c = dewpoint_c;
    }

    @Bindable
    public String getPressure_mb ()
    {
        return pressure_mb;
    }

    public void setPressure_mb (String pressure_mb)
    {
        this.pressure_mb = pressure_mb;
    }

    @Bindable
    public String getIcon ()
    {
        return icon;
    }

    public void setIcon (String icon)
    {
        this.icon = icon;
    }

    @Bindable
    public String getLocal_time_rfc822 ()
    {
        return local_time_rfc822;
    }

    public void setLocal_time_rfc822 (String local_time_rfc822)
    {
        this.local_time_rfc822 = local_time_rfc822;
    }

    @Bindable
    public String getPrecip_1hr_string ()
    {
        return precip_1hr_string;
    }

    public void setPrecip_1hr_string (String precip_1hr_string)
    {
        this.precip_1hr_string = precip_1hr_string;
    }

    @Bindable
    public String getIcon_url ()
    {
        return icon_url;
    }

    public void setIcon_url (String icon_url)
    {
        this.icon_url = icon_url;
    }

    @Bindable
    public String getWind_dir ()
    {
        return wind_dir;
    }

    public void setWind_dir (String wind_dir)
    {
        this.wind_dir = wind_dir;
    }

    @Bindable
    public String getDewpoint_f ()
    {
        return dewpoint_f;
    }

    public void setDewpoint_f (String dewpoint_f)
    {
        this.dewpoint_f = dewpoint_f;
    }

    @Bindable
    public String getNowcast ()
    {
        return nowcast;
    }

    public void setNowcast (String nowcast)
    {
        this.nowcast = nowcast;
    }

    @Bindable
    public Display_location getDisplay_location ()
    {
        return display_location;
    }

    public void setDisplay_location (Display_location display_location)
    {
        this.display_location = display_location;
    }

    @Bindable
    public String getVisibility_km ()
    {
        return visibility_km;
    }

    public void setVisibility_km (String visibility_km)
    {
        this.visibility_km = visibility_km;
    }

    @Bindable
    public String getTemperature_string ()
    {
        return temperature_string;
    }

    public void setTemperature_string (String temperature_string)
    {
        this.temperature_string = temperature_string;
    }

    @Bindable
    public String getLocal_tz_short ()
    {
        return local_tz_short;
    }

    public void setLocal_tz_short (String local_tz_short)
    {
        this.local_tz_short = local_tz_short;
    }

    @Bindable
    public String getLocal_epoch ()
    {
        return local_epoch;
    }

    public void setLocal_epoch (String local_epoch)
    {
        this.local_epoch = local_epoch;
    }

    @Bindable
    public String getWind_string ()
    {
        return wind_string;
    }

    public void setWind_string (String wind_string)
    {
        this.wind_string = wind_string;
    }

    @Bindable
    public String getPrecip_today_in ()
    {
        return precip_today_in;
    }

    public void setPrecip_today_in (String precip_today_in)
    {
        this.precip_today_in = precip_today_in;
    }
}
