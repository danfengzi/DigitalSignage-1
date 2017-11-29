package signage.digital.com.digitalsignage.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import signage.digital.com.digitalsignage.BR;

/**
 * Created by everest on 31/10/2017.
 */

public class Temp extends BaseObservable{
    private String celsius;
    private String fahrenheit;

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