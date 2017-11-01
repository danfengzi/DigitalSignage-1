package signage.digital.com.digitalsignage.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

import signage.digital.com.digitalsignage.BR;

/**
 * Created by everest on 31/10/2017.
 */

public class Forecastday extends BaseObservable {
    Qpf qpf_allday;
    String icon;
    Wind maxwind;
    Qpf qpf_day;
    String icon_url;
    String skyicon;
    int pop;
    Date date;
    long period;
    Snow snow_night;
    String conditions;
    Wind avewind;
    long avehumidity;
    Snow snow_day;
    long minhumidity;
    Qpf qpf_night;
    Temp high;
    Snow snow_allday;
    Temp low;
    long maxhumidity;

    public Forecastday() {
    }

    @Bindable
    public Qpf getQpf_allday ()
    {
        return qpf_allday;
    }

    public void setQpf_allday (Qpf qpf_allday)
    {
        this.qpf_allday = qpf_allday;
    }

    @Bindable
    public String getIcon ()
    {
        return icon;
    }

    public void setIcon (String icon)
    {
        this.icon = icon;
    }

    @Bindable
    public Wind getMaxwind ()
    {
        return maxwind;
    }

    public void setMaxwind (Wind maxwind)
    {
        this.maxwind = maxwind;
    }

    @Bindable
    public Qpf getQpf_day ()
    {
        return qpf_day;
    }

    public void setQpf_day (Qpf qpf_day)
    {
        this.qpf_day = qpf_day;
    }

    @Bindable
    public String getIcon_url ()
    {
        return icon_url;
    }

    public void setIcon_url (String icon_url)
    {
        this.icon_url = icon_url;
    }

    @Bindable
    public String getSkyicon ()
    {
        return skyicon;
    }

    public void setSkyicon (String skyicon)
    {
        this.skyicon = skyicon;
    }

    @Bindable
    public int getPop ()
    {
        return pop;
    }

    public void setPop (int pop)
    {
        this.pop = pop;
        notifyPropertyChanged(BR.pop);
    }

    @Bindable
    public Date getDate ()
    {
        return date;
    }

    public void setDate (Date date)
    {
        this.date = date;
    }

    @Bindable
    public long getPeriod ()
    {
        return period;
    }

    public void setPeriod (long period)
    {
        this.period = period;
    }

    @Bindable
    public Snow getSnow_night ()
    {
        return snow_night;
    }

    public void setSnow_night (Snow snow_night)
    {
        this.snow_night = snow_night;
    }

    @Bindable
    public String getConditions ()
    {
        return conditions;
    }

    public void setConditions (String conditions)
    {
        this.conditions = conditions;
        notifyPropertyChanged(BR.conditions);
    }

    @Bindable
    public Wind getAvewind ()
    {
        return avewind;
    }

    public void setAvewind (Wind avewind)
    {
        this.avewind = avewind;
    }

    @Bindable
    public long getAvehumidity ()
    {
        return avehumidity;
    }

    public void setAvehumidity (long avehumidity)
    {
        this.avehumidity = avehumidity;
    }

    @Bindable
    public Snow getSnow_day ()
    {
        return snow_day;
    }

    public void setSnow_day (Snow snow_day)
    {
        this.snow_day = snow_day;
    }

    @Bindable
    public long getMinhumidity ()
    {
        return minhumidity;
    }

    public void setMinhumidity (long minhumidity)
    {
        this.minhumidity = minhumidity;
    }

    @Bindable
    public Qpf getQpf_night ()
    {
        return qpf_night;
    }

    public void setQpf_night (Qpf qpf_night)
    {
        this.qpf_night = qpf_night;
    }

    @Bindable
    public Temp getHigh ()
    {
        return high;
    }

    public void setHigh (Temp high)
    {
        this.high = high;
    }

    @Bindable
    public Snow getSnow_allday ()
    {
        return snow_allday;
    }

    public void setSnow_allday (Snow snow_allday)
    {
        this.snow_allday = snow_allday;
    }

    @Bindable
    public Temp getLow ()
    {
        return low;
    }

    public void setLow (Temp low)
    {
        this.low = low;
    }

    @Bindable
    public long getMaxhumidity ()
    {
        return maxhumidity;
    }

    public void setMaxhumidity (long maxhumidity)
    {
        this.maxhumidity = maxhumidity;
    }

}
