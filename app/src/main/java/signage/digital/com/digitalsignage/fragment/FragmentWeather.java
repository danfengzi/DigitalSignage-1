package signage.digital.com.digitalsignage.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import signage.digital.com.digitalsignage.R;
import signage.digital.com.digitalsignage.WeatherView;

public class FragmentWeather extends Fragment {
    private String cityId;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_weather, container, false);
        LinearLayout w = (LinearLayout) view.findViewById(R.id.weather);

        WeatherView rio = new WeatherView(getContext());
        rio.getWeatherUnderground("Rio de Janeiro", -22.9865956,-43.2086082, "BR");

        WeatherView sp = new WeatherView(getContext());
        sp.getWeatherUnderground("São Paulo", -23.5810818,-46.6692446, "BR");

        WeatherView df = new WeatherView(getContext());
        df.getWeatherUnderground("Brasília", -15.7915718,-47.8928274, "BR");

        WeatherView ny = new WeatherView(getContext());
        ny.getWeatherUnderground("New York", 40.76688,-73.9782681, "BR");

        WeatherView ba = new WeatherView(getContext());
        ba.getWeatherUnderground("Buenos Aires", -34.5951784,-58.4242234, "BR");

        WeatherView pr = new WeatherView(getContext());
        pr.getWeatherUnderground("Paris", 48.8610227,2.3430481, "BR");

        w.addView(rio);
        w.addView(sp);
        w.addView(df);
        w.addView(ba);
        w.addView(ny);
        w.addView(pr);

        return view;
    }


   @Override
    public void onStart() {
        super.onStart();
    }
}