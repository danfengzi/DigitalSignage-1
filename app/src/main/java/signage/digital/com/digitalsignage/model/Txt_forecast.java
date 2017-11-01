package signage.digital.com.digitalsignage.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

/**
 * Created by everest on 31/10/2017.
 */

public class Txt_forecast extends BaseObservable {
    Forecasttxtday[] forecasttxtday;
    String date;

    public Txt_forecast() {        Log.d("-----","Txt_forecast:");

    }

    @Bindable
    public Forecasttxtday[] getForecastday ()
    {
        return forecasttxtday;
    }

    public void setForecasttxtday (Forecasttxtday[] forecastday)
    {
        this.forecasttxtday = forecastday;
    }

    @Bindable
    public String getDate ()
    {
        return date;
    }

    public void setDate (String date)
    {
        this.date = date;
    }
}
