package signage.digital.com.digitalsignage.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by everest on 30/10/2017.
 */

public class Weather extends BaseObservable{

    private Response response;
    private Current_observation current_observation;

    @Bindable
    public Response getResponse ()
    {
        return response;
    }

    public void setResponse (Response response)
    {
        this.response = response;
    }

    @Bindable
    public Current_observation getCurrent_observation ()
    {
        return current_observation;
    }

    public void setCurrent_observation (Current_observation current_observation)
    {
        this.current_observation = current_observation;
    }
}
