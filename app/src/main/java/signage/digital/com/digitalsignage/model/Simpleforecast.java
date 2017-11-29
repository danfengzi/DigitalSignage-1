package signage.digital.com.digitalsignage.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import java.util.List;

/**
 * Created by everest on 31/10/2017.
 */

public class Simpleforecast extends BaseObservable{
    private List<Forecastday> forecastday;

    @Bindable
    public List<Forecastday> getForecastday ()
    {
        return forecastday;
    }

    public void setForecastday (List<Forecastday> forecastday)
    {
        this.forecastday = forecastday;
    }

}