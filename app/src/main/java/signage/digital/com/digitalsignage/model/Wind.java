package signage.digital.com.digitalsignage.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

/**
 * Created by everest on 31/10/2017.
 */

class Wind extends BaseObservable{
    int mph;
    String dir;
    int degrees;
    int kph;

    public Wind() {        Log.d("-----","Wind:");

    }

    @Bindable
    public int getMph ()
    {
        return mph;
    }

    public void setMph (int mph)
    {
        this.mph = mph;
    }

    @Bindable
    public String getDir ()
    {
        return dir;
    }

    public void setDir (String dir)
    {
        this.dir = dir;
    }

    @Bindable
    public int getDegrees ()
    {
        return degrees;
    }

    public void setDegrees (int degrees)
    {
        this.degrees = degrees;
    }

    @Bindable
    public int getKph ()
    {
        return kph;
    }

    public void setKph (int kph)
    {
        this.kph = kph;
    }

}
