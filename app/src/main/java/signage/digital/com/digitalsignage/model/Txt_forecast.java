package signage.digital.com.digitalsignage.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

import java.util.List;

/**
 * Created by everest on 31/10/2017.
 */

public class Txt_forecast extends BaseObservable {
    List<Forecasttxtday> forecasttxtday;
    String date;

    public Txt_forecast() {

    }

    @Bindable
    public List<Forecasttxtday> getForecastday ()
    {
        return forecasttxtday;
    }

    public void setForecasttxtday (List<Forecasttxtday> forecastday)
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
