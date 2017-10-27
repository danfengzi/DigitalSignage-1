package signage.digital.com.digitalsignage;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import signage.digital.com.digitalsignage.model.City;
import signage.digital.com.digitalsignage.model.ForecastDay;
import signage.digital.com.digitalsignage.model.ForecastUnderground;
import signage.digital.com.digitalsignage.model.WeatherUnderground;

/**
 * Created by Alexandre on 09/12/2016.
 */

public class WeatherPage extends LinearLayout {
    private View rootView;
    private Context context;

    public WeatherPage(Context context) {
        super(context);
        this.context = context;
        init(context);
    }

    public WeatherPage(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init(context);
    }

    public WeatherPage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init(context);
    }

    private void init(Context context) {
        rootView = inflate(context, R.layout.weather_current, this);
    }
}
