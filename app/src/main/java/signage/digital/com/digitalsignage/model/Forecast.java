package signage.digital.com.digitalsignage.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class Forecast  extends BaseObservable {

    private Txt_forecast txt_forecast;
    private Simpleforecast simpleforecast;

    @Bindable
    public Txt_forecast getTxt_forecast ()
    {
        return txt_forecast;
    }

    public void setTxt_forecast (Txt_forecast txt_forecast)
    {
        this.txt_forecast = txt_forecast;
    }

    @Bindable
    public Simpleforecast getSimpleforecast ()
    {
        return simpleforecast;
    }

    public void setSimpleforecast (Simpleforecast simpleforecast)
    {
        this.simpleforecast = simpleforecast;
    }
}