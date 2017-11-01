package signage.digital.com.digitalsignage.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;
import android.widget.BaseExpandableListAdapter;

/**
 * Created by everest on 30/10/2017.
 */

public class Features extends BaseObservable{
    private long forecast;
    private long conditions;

    public Features() {           Log.d("-----","Features:");
    }

    @Bindable
    public long getForecast ()
    {
        return forecast;
    }

    public void setForecast (long forecast)
    {
        Log.d("-------","features 1");
        this.forecast = forecast;
    }

    public long getConditions() {
        return conditions;
    }

    public void setConditions(long conditions) {
        Log.d("-------","features 2");
        this.conditions = conditions;
    }
}
