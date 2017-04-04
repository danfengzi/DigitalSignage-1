package signage.digital.com.digitalsignage;

import android.content.Context;
import android.support.annotation.NonNull;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.gson.reflect.TypeToken;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.Map;

import signage.digital.com.digitalsignage.model.ForecastUnderground;
import signage.digital.com.digitalsignage.model.WeatherUnderground;
import signage.digital.com.digitalsignage.library.network.CustomGsonObjectRequest;

/**
 * Created by fung.lam on 09/09/2015.
 * API Helper for Open Weather Map API
 */
public class OpenWeatherMapApiHelper {

    private static final String HOST = "http://api.wunderground.com/api/";
    private static final String GET_WEATHER_ENDPOINT = "/conditions/lang:%s/q/";
    private static final String GET_FORECAST_ENDPOINT = "/forecast/lang:%s/q/";
    private RequestQueue mRequestQueue;
    private String mAppId;



    public OpenWeatherMapApiHelper(@NonNull Context context){
        mRequestQueue = Volley.newRequestQueue(context);
        mAppId = context.getResources().getString(R.string.undergroud_key);
    }

    public OpenWeatherMapApiHelper(@NonNull RequestQueue requestQueue, @NonNull String appId) {
        mRequestQueue = requestQueue;
        mAppId = appId;
    }

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
     * @param latitude latitude of location
     * @param longitude longitude of location
     * @param listener what to do if success
     * @param errorListener what to do if failed
     * @return volley request
     */
    public Request getWeather(double latitude, double longitude, @NonNull Response.Listener<WeatherUnderground> listener, @NonNull Response.ErrorListener errorListener, String lg) {

        String url = HOST + mAppId + String.format(GET_WEATHER_ENDPOINT, lg) + latitude +","+ longitude+".json";

        Type type = new TypeToken<WeatherUnderground>() {  }.getType();

        CustomGsonObjectRequest gsonReq = new CustomGsonObjectRequest<>(Request.Method.GET, url, type, null, listener, errorListener);
        gsonReq.setShouldCache(false);
        gsonReq.setRetryPolicy(new DefaultRetryPolicy(
                10000,
                0,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        return mRequestQueue.add(gsonReq);

    }

    public Request getForecast(double latitude, double longitude, @NonNull Response.Listener<ForecastUnderground> listener, @NonNull Response.ErrorListener errorListener, String lg) {

        String url = HOST + mAppId + String.format(GET_FORECAST_ENDPOINT, lg)  + latitude +","+ longitude+".json";

        Type type = new TypeToken<ForecastUnderground>() {   }.getType();

        CustomGsonObjectRequest gsonReq = new CustomGsonObjectRequest<>(Request.Method.GET, url, type, null, listener, errorListener);
        gsonReq.setShouldCache(false);
        gsonReq.setRetryPolicy(new DefaultRetryPolicy(
                10000,
                0,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        return mRequestQueue.add(gsonReq);
    }
}
