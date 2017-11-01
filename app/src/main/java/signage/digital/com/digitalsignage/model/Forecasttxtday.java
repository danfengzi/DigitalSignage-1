package signage.digital.com.digitalsignage.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

import signage.digital.com.digitalsignage.BR;

public class Forecasttxtday extends BaseObservable{

    long period = 0;
    String icon = "";
    String title = "";
    String fcttext = "";
    String fcttext_metric = "";
    String pop = "";

    public Forecasttxtday() {
    }

    @Bindable
    public long getPeriod() {
        return period;
    }

    @Bindable
    public String getIcon() {
        return icon;
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    @Bindable
    public String getFcttext() {
        return fcttext;
    }

    @Bindable
    public String getFcttext_metric() {
        return fcttext_metric;
    }

    @Bindable
    public String getPop() {
        return pop;
    }

    public void setPeriod(int period) {
        this.period = period;
        notifyPropertyChanged(BR.period);
    }

    public void setIcon(String icon) {
        this.icon = icon;
        notifyPropertyChanged(BR.icon);
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    public void setFcttext(String fcttext) {
        this.fcttext = fcttext;
        notifyPropertyChanged(BR.fcttext);
    }

    public void setFcttext_metric(String fcttext_metric) {
        this.fcttext_metric = fcttext_metric;
        notifyPropertyChanged(BR.fcttext_metric);
    }

    public void setPop(String pop) {
        this.pop = pop;
        notifyPropertyChanged(BR.pop);
    }
}
