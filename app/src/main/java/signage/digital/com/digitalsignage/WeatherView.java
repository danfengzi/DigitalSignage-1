package signage.digital.com.digitalsignage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import signage.digital.com.digitalsignage.library.model.WeatherUnderground;

/**
 * Created by Alexandre on 09/12/2016.
 */

public class WeatherView extends RelativeLayout {
    private View rootView;
    private TextView city;
    private TextView temp;
    private ImageView icon;
    private Context context;
    public WeatherView(Context context) {
        super(context);
        this.context = context;
        init(context);
    }

    public WeatherView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init(context);
    }

    public WeatherView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init(context);
    }

    private void init(Context context) {
        rootView = inflate(context, R.layout.item_weather_full, this);
        city = (TextView) rootView.findViewById(R.id.city);
        temp = (TextView) rootView.findViewById(R.id.temp);
        icon = (ImageView) rootView.findViewById(R.id.icon);
    }

    public void setWeather(WeatherUnderground w){
        city.setText(w.getCurrentWeather().getLocation().getCity());
        temp.setText(w.getCurrentWeather().getTemp_c()+"C/"+w.getCurrentWeather().getTemp_f()+"F");
        icon.setImageResource(getResources().getIdentifier(w.getCurrentWeather().getIcon(), "drawable", context.getPackageName()));

    }
}
