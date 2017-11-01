package signage.digital.com.digitalsignage.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

/**
 * Created by everest on 30/10/2017.
 */

public class ForecastResponse extends BaseObservable{
    Response response;
    Forecast forecast;

    public ForecastResponse() {
    }

    @Bindable
    public Response getResponse ()
    {
        return response;
    }

    public void setResponse (Response response)
    {
        Log.d("-------","forecastresponse 1");
        this.response = response;
    }

    @Bindable
    public Forecast getForecast ()
    {
        return forecast;
    }

    public void setForecast (Forecast forecast)
    {
        Log.d("-------","forecastresponse 1");
        this.forecast = forecast;
    }

}

