package signage.digital.com.digitalsignage.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import java.util.List;

/**
 * Created by everest on 31/10/2017.
 */

public class Txt_forecast extends BaseObservable {
    private List<Forecasttxtday> forecastday;
    private String date;

    public Txt_forecast() {  }

    @Bindable
    public List<Forecasttxtday> getForecastday ()
    {
        return forecastday;
    }

    public void setForecastday (List<Forecasttxtday> forecastday)
    {
        this.forecastday = forecastday;
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
