package signage.digital.com.digitalsignage.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;

import signage.digital.com.digitalsignage.CalendarService;
import signage.digital.com.digitalsignage.MyApp;
import signage.digital.com.digitalsignage.R;
import signage.digital.com.digitalsignage.WeatherView;
import signage.digital.com.digitalsignage.adapter.ImageAdapter;
import signage.digital.com.digitalsignage.model.City;

/**
 * Created by everest on 29/05/2017.
 */

public class FragmentWeather extends Fragment {

    private LinearLayout weather;
    private MyApp app;
    private WeatherView rj;
    private WeatherView sp;
    private WeatherView pa;
    private WeatherView ba;

    Handler handler = new Handler();

    Runnable serviceRunnable = new Runnable() {
        @Override
        public void run() {
            getWeather();
            handler.postDelayed(this, (1000*60*5));
        }
    };

    public void startUpdate(){
        handler.postDelayed(serviceRunnable, 2000);
    }

    private void getWeather(){
        ViewGroup group = (ViewGroup)this.getView();
        for(City c:app.getCities()){
            WeatherView wView = (WeatherView)group.findViewWithTag(c);
            wView.updateCityView(c);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("----------- onCreate ADV");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        app = MyApp.getInstance();
    }

    private void setupWeather(){
        weather = new LinearLayout(getContext());
        weather.setOrientation(LinearLayout.VERTICAL);

        WeatherView wView;
        for(City c:app.getCities()){
            wView = new WeatherView(getContext(), c);
            wView.setTag(c);
            weather.addView(wView);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        System.out.println("----------------onCreateView ADV");

        LinearLayout view =  (LinearLayout)inflater.inflate(R.layout.fragment_weather, container, false);

        rj = (WeatherView)view.findViewById(R.id.rj);
        rj.setTag(app.getCities().get(0));

        sp = (WeatherView)view.findViewById(R.id.sp);
        sp.setTag(app.getCities().get(1));

        pa = (WeatherView)view.findViewById(R.id.pa);
        pa.setTag(app.getCities().get(2));

        ba = (WeatherView)view.findViewById(R.id.ba);
        ba.setTag(app.getCities().get(3));

        startUpdate();
        return view;
    }

}
