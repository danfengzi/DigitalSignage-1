package signage.digital.com.digitalsignage.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewFlipper;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import signage.digital.com.digitalsignage.OpenWeatherMapApiHelper;
import signage.digital.com.digitalsignage.R;
import signage.digital.com.digitalsignage.WeatherView;
import signage.digital.com.digitalsignage.adapter.ItemImagesAdapter;
import signage.digital.com.digitalsignage.library.model.WeatherUnderground;

public class FragmentAdv extends Fragment {

    private DatabaseReference myRef;
    private ChildEventListener listener;
    private ViewFlipper flipper;
    private ItemImagesAdapter adapter;
    private WeatherView header;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        listener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                adapter.addItem((String)dataSnapshot.getValue());
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                adapter.removeItem((String)dataSnapshot.getValue());
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };
    }

    @Override
    public void onResume(){
        super.onResume();
        myRef.child("profile/flyers").addChildEventListener(listener);
    }

    public void onPause(){
        super.onPause();
        myRef.removeEventListener(listener);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_adv, container, false);
        flipper = (ViewFlipper)view.findViewById(R.id.flyers);
        header = new WeatherView(getContext());

        adapter = new ItemImagesAdapter(getContext(), new ArrayList<String>());
        //flipper.setAdapter(adapter);

        OpenWeatherMapApiHelper helper = new OpenWeatherMapApiHelper(getContext());
        //config.ApiKey = "68f861256e25308c"; //undeground
        helper.getWeather(-22.9865956,-43.2086082, new Listener<WeatherUnderground>(){
            @Override
            public void onResponse(WeatherUnderground response) {
                header.setWeather(response);
                flipper.addView(header);
                flipper.setFlipInterval(10000);
                flipper.setAutoStart(true);
            }
        }, new ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("------", "erro "+error.getMessage());

            }
        });




        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}