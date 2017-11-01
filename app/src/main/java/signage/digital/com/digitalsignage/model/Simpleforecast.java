package signage.digital.com.digitalsignage.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

/**
 * Created by everest on 31/10/2017.
 */

public class Simpleforecast extends BaseObservable{
    Forecastday[] forecastday;

    public Simpleforecast() {        Log.d("-----","Simpleforecast:");

    }

    @Bindable
    public Forecastday[] getForecastday ()
    {
        return forecastday;
    }

    public void setForecastday (Forecastday[] forecastday)
    {
        this.forecastday = forecastday;
    }

}