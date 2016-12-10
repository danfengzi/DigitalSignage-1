package signage.digital.com.digitalsignage.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
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

import signage.digital.com.digitalsignage.CalendarEvent;
import signage.digital.com.digitalsignage.OpenWeatherMapApiHelper;
import signage.digital.com.digitalsignage.R;
import signage.digital.com.digitalsignage.WeatherView;
import signage.digital.com.digitalsignage.adapter.ItemEventsAdapter;
import signage.digital.com.digitalsignage.adapter.ItemImagesAdapter;
import signage.digital.com.digitalsignage.library.model.WeatherUnderground;

public class FragmentEvent extends Fragment {
    private ListView list;
    private DatabaseReference myRef;
    private ChildEventListener listener;
    private ViewFlipper flipper;
    private ItemImagesAdapter adapter;
    private ItemEventsAdapter eventsAdapter;
    private Runnable runnableCode;
    private WeatherView header;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        eventsAdapter = new ItemEventsAdapter(getContext(), new ArrayList<CalendarEvent>());

        listener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                adapter.addItem((String)dataSnapshot.getValue());
                Log.d("-------","data "+dataSnapshot.getValue());
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                adapter.removeItem((String)dataSnapshot.getValue());
                Log.d("-------","data "+dataSnapshot.getValue());
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_event, container, false);
        list = (ListView)view.findViewById(R.id.list);
        list.setAdapter(eventsAdapter);

        flipper = (ViewFlipper)view.findViewById(R.id.flipper);
        adapter = new ItemImagesAdapter(getContext(), new ArrayList<String>());

        header = new WeatherView(getContext());

        //flipper.setAdapter(adapter);


        OpenWeatherMapApiHelper helper = new OpenWeatherMapApiHelper(getContext());
        helper.getWeather(-22.9865956,-43.2086082, new Listener<WeatherUnderground>(){
            @Override
            public void onResponse(WeatherUnderground response) {
                header.setWeather(response);
                Log.d("--------","data "+response.getCurrentWeather().getDisplay().getCity());
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






        final Handler handler = new Handler();
        runnableCode = new Runnable() {
            @Override
            public void run() {
                getEvents();
                handler.postDelayed(runnableCode, 10000);
            }
        };
        handler.post(runnableCode);

        return view;
    }

    @Override
    public void onResume(){
        super.onResume();
        myRef.child("profile/banners").addChildEventListener(listener);

    }

    public void onPause(){
        super.onPause();
        myRef.removeEventListener(listener);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    private void getEvents(){
        eventsAdapter.update();
    }
}