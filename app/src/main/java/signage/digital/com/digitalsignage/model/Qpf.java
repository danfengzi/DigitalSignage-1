package signage.digital.com.digitalsignage.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by everest on 31/10/2017.
 */

class Qpf extends BaseObservable{
    private long mm;
    private double in;

    public Qpf() {
    }

    @Bindable
    public long getMm ()
    {
        return mm;
    }

    public void setMm (long mm)
    {
        this.mm = mm;
    }

    @Bindable
    public double getIn ()
    {
        return in;
    }

    public void setIn (double in)
    {
        this.in = in;
    }
}
