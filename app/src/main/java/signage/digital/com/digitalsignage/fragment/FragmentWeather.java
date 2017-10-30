package signage.digital.com.digitalsignage.fragment;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import signage.digital.com.digitalsignage.Eventm;
import signage.digital.com.digitalsignage.LayoutHandler;
import signage.digital.com.digitalsignage.MyApp;
import signage.digital.com.digitalsignage.R;
import signage.digital.com.digitalsignage.WeatherView;
import signage.digital.com.digitalsignage.databinding.FragmentEventBinding;
import signage.digital.com.digitalsignage.databinding.FragmentWeatherBinding;
import signage.digital.com.digitalsignage.model.City;

/**
 * Created by everest on 29/05/2017.
 */

public class FragmentWeather extends Fragment {

    private DatabaseReference myRef;
    private ChildEventListener listener;
    private ObservableArrayList cities = new ObservableArrayList();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        listener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.d("-------","datasnapShot: "+dataSnapshot.toString());
                cities.add(dataSnapshot.getValue(City.class));
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {            }

            @Override
            public void onCancelled(DatabaseError databaseError) {            }
        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentWeatherBinding binding = DataBindingUtil.setContentView(getActivity(), R.layout.fragment_weather);
        binding.setCities(cities);
        View view =  binding.getRoot();

        return view;
    }

    @Override
    public void onResume(){
        super.onResume();
        myRef.child("cities").addChildEventListener(listener);
    }

    public void onPause(){
        super.onPause();
        myRef.removeEventListener(listener);
    }

}
