package signage.digital.com.digitalsignage.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

/**
 * Created by everest on 30/10/2017.
 */

public class WeatherResponse extends BaseObservable{

    Response response;
    Current_observation current_observation;

    public WeatherResponse() {
    }

    @Bindable
    public Response getResponse ()
    {
        return response;
    }

    public void setResponse (Response response)
    {
        Log.d("-------","weather response 1");
        this.response = response;
    }

    @Bindable
    public Current_observation getCurrent_observation ()
    {
        return current_observation;
    }

    public void setCurrent_observation (Current_observation current_observation)
    {
        Log.d("-------","weather response 2");
        this.current_observation = current_observation;
    }
}
