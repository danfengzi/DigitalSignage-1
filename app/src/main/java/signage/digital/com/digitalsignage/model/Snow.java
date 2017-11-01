package signage.digital.com.digitalsignage.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

/**
 * Created by everest on 31/10/2017.
 */

class Snow extends BaseObservable {
    int cm;
    double in;

    public Snow() {
    }

    @Bindable
    public int getCm ()
    {
        return cm;
    }

    public void setCm (int cm)
    {
        this.cm = cm;
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