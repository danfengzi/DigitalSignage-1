package signage.digital.com.digitalsignage.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

/**
 * Created by everest on 30/10/2017.
 */

public class Response extends BaseObservable{
    Features features;
    String termsofService;
    String version;

    public Response() {
    }

    @Bindable
    public Features getFeatures ()
    {
        return features;
    }

    public void setFeatures (Features features)
    {
        this.features = features;
    }

    @Bindable
    public String getTermsofService ()
    {
        return termsofService;
    }

    public void setTermsofService (String termsofservice)
    {
        this.termsofService = termsofservice;
    }

    @Bindable
    public String getVersion ()
    {
        return version;
    }

    public void setVersion (String version)
    {
        this.version = version;
    }

}
