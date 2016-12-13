package signage.digital.com.digitalsignage.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import signage.digital.com.digitalsignage.R;
import signage.digital.com.digitalsignage.library.model.WeatherUnderground;

public class SubFragWeather extends Fragment {
    private String cityId;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view =  inflater.inflate(R.layout.sub_frag_weather, container, false);


        return view;
    }

    private void initView(WeatherUnderground w, View v){
        TextView city = (TextView)v.findViewById(R.id.city);
        city.setText(w.getCurrentWeather().getDisplay().getCity());
        TextView temp = (TextView)v.findViewById(R.id.temp);
        temp.setText(w.getCurrentWeather().getTemp_c()+"C/"+w.getCurrentWeather().getTemp_f()+"F");
        ImageView icon = (ImageView)v.findViewById(R.id.icon);
        Picasso.with(getContext())
                .load(w.getCurrentWeather().getIcon_url())
                .into(icon);
    }

   @Override
    public void onStart() {
        super.onStart();
    }
}