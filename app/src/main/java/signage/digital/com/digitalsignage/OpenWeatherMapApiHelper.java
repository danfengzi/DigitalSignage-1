package signage.digital.com.digitalsignage;

import android.content.Context;
import android.support.annotation.NonNull;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.gson.reflect.TypeToken;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.Map;
import java.util.TreeMap;

import signage.digital.com.digitalsignage.library.model.ForecastRecord;
import signage.digital.com.digitalsignage.library.model.TemperatureResponseModel;
import signage.digital.com.digitalsignage.library.model.WeatherUnderground;
import signage.digital.com.digitalsignage.library.network.CustomGsonObjectRequest;

/**
 * Created by fung.lam on 09/09/2015.
 * API Helper for Open Weather Map API
 */
public class OpenWeatherMapApiHelper {
    //http://api.wunderground.com/api/68f861256e25308c/geolookup/q/37.776289,-122.395234.json
    private static final String HOST = "http://api.wunderground.com/api/";
    private static final String GET_WEATHER_ENDPOINT = "/conditions/q/";
    private static final String GET_FORECAST_ENDPOINT = "";

    private RequestQueue mRequestQueue;
    private String mAppId;


//    public OpenWeatherMapApiHelper(@NonNull RequestQueue requestQueue) {
//        mRequestQueue = requestQueue;
//    }

    public OpenWeatherMapApiHelper(@NonNull Context context){
        mRequestQueue = Volley.newRequestQueue(context);
//        mAppId = context.getResources().getString(R.string.api_key);
        mAppId = context.getResources().getString(R.string.undergroud_key);
    }

    public OpenWeatherMapApiHelper(@NonNull RequestQueue requestQueue, @NonNull String appId) {
        mRequestQueue = requestQueue;
        mAppId = appId;
    }

    //convert the map of params to "key1=value1&key2=value2" style
    private static String toUrlParams(@NonNull Map<String, Object> params) {
        StringBuilder sb = new StringBuilder();
        for (String key : params.keySet()) {
            try {
                sb.append("&").append(key).append("=").append(URLEncoder.encode(params.get(key).toString(), "utf-8"));

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return sb.toString().substring(1); //removing the heading '&'
    }

    /**
     * Send the Get Weather API request
     * @param listener what to do if success
     * @param errorListener what to do if failed
     * @return volley request
     */
    public Request getWeather(@NonNull Response.Listener<TemperatureResponseModel> listener, @NonNull Response.ErrorListener errorListener) {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("units", "metric");
        params.put("appid", mAppId);

        String url = HOST + GET_WEATHER_ENDPOINT + "?" + toUrlParams(params);

        Type type = new TypeToken<TemperatureResponseModel>() {
        }.getType();

        CustomGsonObjectRequest gsonReq = new CustomGsonObjectRequest<>(Request.Method.GET,
                url, type, null, listener, errorListener);


        // Adding request to request queue
        return mRequestQueue.add(gsonReq);

    }

    /**
     * Send the Get Weather API request
     * @param latitude latitude of location
     * @param longitude longitude of location
     * @param listener what to do if success
     * @param errorListener what to do if failed
     * @return volley request
     */
    public Request getWeather(double latitude, double longitude, @NonNull Response.Listener<WeatherUnderground> listener, @NonNull Response.ErrorListener errorListener) {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("units", "metric");
        params.put("lat", latitude);
        params.put("lon", longitude);
        //params.put("appid", mAppId);

        String url = HOST + mAppId + GET_WEATHER_ENDPOINT + latitude +","+ longitude+".json";

        Type type = new TypeToken<WeatherUnderground>() {
        }.getType();

        CustomGsonObjectRequest gsonReq = new CustomGsonObjectRequest<>(Request.Method.GET,
                url, type, null, listener, errorListener);


        // Adding request to request queue
        return mRequestQueue.add(gsonReq);

    }

    public Request getForecast(String id, @NonNull Response.Listener<ForecastRecord> listener, @NonNull Response.ErrorListener errorListener) {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("units", "metric");
        params.put("id", id);
        params.put("appid", mAppId);

        String url = HOST + GET_FORECAST_ENDPOINT + "?" + toUrlParams(params);

        Type type = new TypeToken<ForecastRecord>() {
        }.getType();

        CustomGsonObjectRequest gsonReq = new CustomGsonObjectRequest<>(Request.Method.GET,
                url, type, null, listener, errorListener);


        // Adding request to request queue
        return mRequestQueue.add(gsonReq);

    }
}
