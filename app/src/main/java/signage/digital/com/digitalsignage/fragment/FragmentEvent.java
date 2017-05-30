package signage.digital.com.digitalsignage.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import signage.digital.com.digitalsignage.CalendarEvent;
import signage.digital.com.digitalsignage.CalendarService;
import signage.digital.com.digitalsignage.MyApp;
import signage.digital.com.digitalsignage.R;
import signage.digital.com.digitalsignage.WeatherView;
import signage.digital.com.digitalsignage.adapter.ItemEventsAdapter;
import signage.digital.com.digitalsignage.model.City;
import signage.digital.com.digitalsignage.model.Screen;

public class FragmentEvent extends Fragment {
    private ListView list;
    private DatabaseReference myRef;
    private ChildEventListener listener;
    private ViewFlipper flipper;
    private ItemEventsAdapter eventsAdapter;
    private ArrayList<WeatherView> listW;
    private ArrayList<CalendarEvent> eventos;

    private WeatherView rj;
    private WeatherView sp;
    private WeatherView pa;
    private WeatherView ba;
    private Screen screen = MyApp.getInstance().getScreen();

    Handler handler = new Handler();

    Runnable serviceRunnable = new Runnable() {
        @Override
        public void run() {
            eventos = CalendarService.readCalendar(getContext(),1,0, screen.getCalendar_id());
            handler.postDelayed(this, (1000*60*5));
            eventsAdapter = new ItemEventsAdapter(getContext(), eventos);
            list.setAdapter(eventsAdapter);
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("----------------onCreate Event");


        rj = new WeatherView(getContext(), new City("Rio de Janeiro", -22.9865956, -43.2086082, "BR"));
        sp = new WeatherView(getContext(), new City("São Paulo", -23.5810818, -46.6692446, "BR"));
        pa = new WeatherView(getContext(), new City("Porto Alegre", -30.033764,-51.2278398, "BR"));
        ba = new WeatherView(getContext(), new City("Buenos Aires", -34.5951784,-58.4242234, "BR"));

        listW = new ArrayList<WeatherView>();
        listW.add(rj);
        listW.add(sp);
        listW.add(pa);
        listW.add(ba);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        listener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                ImageView v = new ImageView(getContext());
                v.setScaleType(ScaleType.FIT_END);
                v.setTag((String)dataSnapshot.getValue());
                Picasso.with(getContext())
                        .load((String)dataSnapshot.getValue())
                        .into(v);
                flipper.addView(v);
                System.out.println("----------------onChildAdded");
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                for(int i = 0;i<flipper.getChildCount();i++){
                    View v = flipper.getChildAt(i);
                    if(v.getTag()==dataSnapshot.getValue()){
                        flipper.removeViewAt(i);
                    }
                }
                Log.d("-------","remove data "+dataSnapshot.getValue());
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };
    }

    public void onDestroy() {
        super.onDestroy();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        System.out.println("----------------onCreateView Event");

        View view =  inflater.inflate(R.layout.fragment_event, container, false);

        list = (ListView)view.findViewById(R.id.list);
        flipper = (ViewFlipper)view.findViewById(R.id.banners);

        flipper.removeAllViews();
        for(WeatherView v:listW){
            flipper.addView(v);
        }

        flipper.setInAnimation(getActivity(), R.anim.view_transition_in_left);
        flipper.setOutAnimation(getActivity(), R.anim.view_transition_out_right);

        flipper.setFlipInterval(15000);
        flipper.setAutoStart(true);

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

    public void startUpdate(){
        Log.d("------", "startUpdate");
        handler.postDelayed(serviceRunnable, 1000);
    }

    public void stopUpdate(){
        Log.d("------", "stopUpdate");
        handler.removeCallbacks(serviceRunnable);
    }
}