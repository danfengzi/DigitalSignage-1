package signage.digital.com.digitalsignage.fragment;

import android.os.Bundle;
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

import signage.digital.com.digitalsignage.R;
import signage.digital.com.digitalsignage.WeatherView;
import signage.digital.com.digitalsignage.adapter.ImageAdapter;
import signage.digital.com.digitalsignage.adapter.ImageAdapter2;
import signage.digital.com.digitalsignage.model.City;

public class FragmentAdv extends Fragment {

    private DatabaseReference myRef;
    private ChildEventListener listener;
    private AdapterViewFlipper flipper;
    private LinearLayout weather;
    private ArrayList<WeatherView> list;

    private WeatherView rj;
    private WeatherView sp;
    private WeatherView pa;
    private WeatherView ba;
    private ImageAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("----------- onCreate ADV");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        weather = new LinearLayout(getContext());
        weather.setOrientation(LinearLayout.VERTICAL);

        rj = new WeatherView(getContext(), new City("Rio de Janeiro", -22.9865956, -43.2086082, "BR"));
        sp = new WeatherView(getContext(), new City("São Paulo", -23.5810818, -46.6692446, "BR"));
        pa = new WeatherView(getContext(), new City("Porto Alegre", -30.033764,-51.2278398, "BR"));
        ba = new WeatherView(getContext(), new City("Buenos Aires", -34.5951784,-58.4242234, "BR"));

        list = new ArrayList<WeatherView>();
        list.add(rj);
        list.add(sp);
        list.add(pa);
        list.add(ba);

        listener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                adapter.addItem(dataSnapshot.getValue(String.class));
                //flipper.addView(v);
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
                        flipper.removeView(v);
                    }
                }
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
        for(WeatherView v:list){
            v.startUpdate();
        }
    }

    public void onPause(){
        super.onPause();
        myRef.removeEventListener(listener);
        for(WeatherView v:list){
            v.stopUpdate();
        }
    }

    public void onDestroy(){
        super.onDestroy();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        System.out.println("----------------onCreateView ADV");

        View view =  inflater.inflate(R.layout.fragment_adv, container, false);
        flipper = (AdapterViewFlipper)view.findViewById(R.id.flyers);
        flipper.setInAnimation(getActivity(), R.anim.view_transition_in_left);
        flipper.setOutAnimation(getActivity(), R.anim.view_transition_out_right);
        flipper.setFlipInterval(20000);
        flipper.setAutoStart(true);

        adapter = new ImageAdapter(getContext());
        flipper.setAdapter(adapter);


        weather.removeAllViews();
        flipper.removeAllViews();

        for(WeatherView v:list){
            weather.addView(v);
        }

        ImageView logo = new ImageView(getContext());
        logo.setPadding(48,0,48,0);
        logo.setImageResource(R.drawable.wundergroundlogo);
        weather.addView(logo);
        flipper.addView(weather);
        return view;
    }

    private void setupViewer(){

    }

    @Override
    public void onStart() {
        super.onStart();
    }
}