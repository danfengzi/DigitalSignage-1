package signage.digital.com.digitalsignage.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

import signage.digital.com.digitalsignage.BR;

public class Forecasttxtday extends BaseObservable{

    private long period;
    private String icon;
    private String icon_url;
    private String title;
    private String fcttext;
    private String fcttext_metric;
    private String pop;

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

    public void setPeriod(long period) {
        this.period = period;
    }

    @Bindable
    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }
}
