package signage.digital.com.digitalsignage.model;

/**
 * Created by Alexandre on 25/12/2016.
 */

public class City {
    private String city;
    private double latitude;
    private double longitude;
    private String lang;
    private WeatherUnderground weather;
    private ForecastUnderground forecast;

    public City(String city, double latitude, double longitude, String lang) {
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
        this.lang = lang;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public WeatherUnderground getWeather() {
        return weather;
    }

    public void setWeather(WeatherUnderground weather) {
        this.weather = weather;
    }

    public ForecastUnderground getForecast() {
        return forecast;
    }

    public void setForecast(ForecastUnderground forecast) {
        this.forecast = forecast;
    }


}
