package signage.digital.com.digitalsignage.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

import signage.digital.com.digitalsignage.BR;

/**
 * Created by everest on 31/10/2017.
 */

public class Temp extends BaseObservable{
    String celsius;
    String fahrenheit;

    public Temp() {         Log.d("-----","Temperature:");

    }

    @Bindable
    public String getCelsius ()
    {
        return celsius;
    }

    public void setCelsius (String celsius)
    {
        this.celsius = celsius;
        notifyPropertyChanged(BR.celsius);
    }

    @Bindable
    public String getFahrenheit ()
    {
        return fahrenheit;
    }

    public void setFahrenheit (String fahrenheit)
    {
        this.fahrenheit = fahrenheit;
        notifyPropertyChanged(BR.fahrenheit);
    }
}