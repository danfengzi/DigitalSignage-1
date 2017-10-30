package signage.digital.com.digitalsignage.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.widget.BaseExpandableListAdapter;

/**
 * Created by everest on 30/10/2017.
 */

public class Features extends BaseObservable{
    private String forecast;

    public Features() {    }

    @Bindable
    public String getForecast ()
    {
        return forecast;
    }

    public void setForecast (String forecast)
    {
        this.forecast = forecast;
    }

}
