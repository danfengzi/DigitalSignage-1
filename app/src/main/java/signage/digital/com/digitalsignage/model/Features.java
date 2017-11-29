package signage.digital.com.digitalsignage.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by everest on 30/10/2017.
 */

public class Features extends BaseObservable{
    private long forecast;
    private long conditions;

    @Bindable
    public long getForecast ()
    {
        return forecast;
    }

    public void setForecast (long forecast)
    {
        this.forecast = forecast;
    }

    public long getConditions() {
        return conditions;
    }

    public void setConditions(long conditions) {
        this.conditions = conditions;
    }
}
