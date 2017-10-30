package signage.digital.com.digitalsignage;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by everest on 24/10/2017.
 */

public class Eventm extends BaseObservable {

    private String location;
    private String description;

    public Eventm(String description, String location){
        this.description = description;
        this.location = location;
    }

    public Eventm(){
    }

    @Bindable
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
        notifyPropertyChanged(BR.location);
    }

    @Bindable
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        notifyPropertyChanged(BR.description);
    }
}
