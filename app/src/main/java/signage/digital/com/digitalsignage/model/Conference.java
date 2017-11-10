package signage.digital.com.digitalsignage.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import signage.digital.com.digitalsignage.BR;

/**
 * Created by everest on 24/10/2017.
 */

public class Conference extends BaseObservable {

    private String location;
    private String description;

    public Conference(String description, String location){
        this.description = description;
        this.location = location;
    }

    public Conference(){
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
