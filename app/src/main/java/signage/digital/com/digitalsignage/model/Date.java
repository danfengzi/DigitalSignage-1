package signage.digital.com.digitalsignage.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

/**
 * Created by everest on 31/10/2017.
 */

public class Date extends BaseObservable{
    String min;
    String epoch;
    String tz_short;
    String monthname;
    String weekday_short;
    long hour;
    String pretty;
    String monthname_short;
    String isdst;
    String weekday;
    String ampm;
    String tz_long;
    long yday;
    long sec;
    long month;
    long year;
    long day;

    public Date() {

    }

    @Bindable
    public String getMin ()
    {
        return min;
    }

    public void setMin (String min)
    {
        this.min = min;
    }

    @Bindable
    public String getEpoch ()
    {
        return epoch;
    }

    public void setEpoch (String epoch)
    {
        this.epoch = epoch;
    }

    @Bindable
    public String getTz_short ()
    {
        return tz_short;
    }

    public void setTz_short (String tz_short)
    {
        this.tz_short = tz_short;
    }

    @Bindable
    public String getMonthname ()
    {
        return monthname;
    }

    public void setMonthname (String monthname)
    {
        this.monthname = monthname;
    }

    @Bindable
    public String getWeekday_short ()
    {
        return weekday_short;
    }

    public void setWeekday_short (String weekday_short)
    {
        this.weekday_short = weekday_short;
    }

    @Bindable
    public long getHour ()
    {
        return hour;
    }

    public void setHour (long hour)
    {
        this.hour = hour;
    }

    @Bindable
    public String getPretty ()
    {
        return pretty;
    }

    public void setPretty (String pretty)
    {
        this.pretty = pretty;
    }

    @Bindable
    public String getMonthname_short ()
    {
        return monthname_short;
    }

    public void setMonthname_short (String monthname_short)
    {
        this.monthname_short = monthname_short;
    }

    @Bindable
    public String getIsdst ()
    {
        return isdst;
    }

    public void setIsdst (String isdst)
    {
        this.isdst = isdst;
    }

    @Bindable
    public String getWeekday ()
    {
        return weekday;
    }

    public void setWeekday (String weekday)
    {
        this.weekday = weekday;
    }

    @Bindable
    public String getAmpm ()
    {
        return ampm;
    }

    public void setAmpm (String ampm)
    {
        this.ampm = ampm;
    }

    @Bindable
    public String getTz_long ()
    {
        return tz_long;
    }

    public void setTz_long (String tz_long)
    {
        this.tz_long = tz_long;
    }

    @Bindable
    public long getYday ()
    {
        return yday;
    }

    public void setYday (long yday)
    {
        this.yday = yday;
    }

    @Bindable
    public long getSec ()
    {
        return sec;
    }

    public void setSec (long sec)
    {
        this.sec = sec;
    }

    @Bindable
    public long getMonth ()
    {
        return month;
    }

    public void setMonth (long month)
    {
        this.month = month;
    }

    @Bindable
    public long getYear ()
    {
        return year;
    }

    public void setYear (long year)
    {
        this.year = year;
    }

    @Bindable
    public long getDay ()
    {
        return day;
    }

    public void setDay (long day)
    {
        this.day = day;
    }
}
