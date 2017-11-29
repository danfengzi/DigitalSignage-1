package signage.digital.com.digitalsignage.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by everest on 30/10/2017.
 */

public class Response extends BaseObservable{
    private Features features;
    private String termsofService;
    private String version;

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
