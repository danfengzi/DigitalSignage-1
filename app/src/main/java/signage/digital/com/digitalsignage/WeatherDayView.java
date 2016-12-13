package signage.digital.com.digitalsignage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import signage.digital.com.digitalsignage.library.model.ForecastDay;

/**
 * Created by Alexandre on 09/12/2016.
 */

public class WeatherDayView extends RelativeLayout {
    private View rootView;
    private TextView day;
    private TextView max;
    private TextView min;
    private TextView pop;
    private ImageView icon;
    private Context context;
    public WeatherDayView(Context context) {
        super(context);
        this.context = context;
        init(context);
    }

    public WeatherDayView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init(context);
    }

    public WeatherDayView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init(context);
    }

    private void init(Context context) {
        rootView = inflate(context, R.layout.weatherday, this);
        day = (TextView) rootView.findViewById(R.id.day);
        max = (TextView) rootView.findViewById(R.id.max);
        min = (TextView) rootView.findViewById(R.id.min);
        pop = (TextView) rootView.findViewById(R.id.pop);
        icon = (ImageView) rootView.findViewById(R.id.icon);
    }

    public void setForecast(ForecastDay w){
        day.setText(w.getDate().getWeekday_short());
        max.setText(""+w.getHigh().getCelsius()+"c");
        min.setText(""+w.getLow().getCelsius()+"c");
        pop.setText(w.getPop()+"%");
        icon.setImageResource(getResources().getIdentifier(w.getIcon(), "drawable", context.getPackageName()));
    }

}
