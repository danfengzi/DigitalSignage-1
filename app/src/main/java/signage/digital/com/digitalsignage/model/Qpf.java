package signage.digital.com.digitalsignage.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

/**
 * Created by everest on 31/10/2017.
 */

class Qpf extends BaseObservable{
    long mm;
    double in;

    public Qpf() {        Log.d("-----","Qpf:");

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
