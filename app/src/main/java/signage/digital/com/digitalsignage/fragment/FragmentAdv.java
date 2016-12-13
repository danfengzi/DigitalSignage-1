package signage.digital.com.digitalsignage.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import signage.digital.com.digitalsignage.R;
import signage.digital.com.digitalsignage.WeatherView;

public class FragmentAdv extends Fragment {

    private DatabaseReference myRef;
    private ChildEventListener listener;
    private ViewFlipper flipper;
    private Runnable runnableCode;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        listener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                ImageView v = new ImageView(getContext());
                v.setTag((String)dataSnapshot.getValue());
                Picasso.with(getContext())
                        .load((String)dataSnapshot.getValue())
                        .into(v);
                flipper.addView(v);
                Log.d("-------","add data "+(String)dataSnapshot.getValue());
                Log.d("-------","count data "+flipper.getChildCount());
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
                Log.d("-------","remove data "+dataSnapshot.getValue());
                Log.d("-------","count data "+flipper.getChildCount());
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
        flipper.setInAnimation(getActivity(), R.anim.view_transition_in_left);
        flipper.setOutAnimation(getActivity(), R.anim.view_transition_out_right);
        flipper.setFlipInterval(10000);
        flipper.setAutoStart(true);
        buildView();

        return view;
    }

    private View buildView(){
        View view =  getActivity().getLayoutInflater().inflate(R.layout.fragment_weather, null);
        LinearLayout w = (LinearLayout) view.findViewById(R.id.weather);

        final WeatherView rj = new WeatherView(getContext());
        final WeatherView sp = new WeatherView(getContext());
        final WeatherView ny = new WeatherView(getContext());
        final WeatherView ba = new WeatherView(getContext());
        final WeatherView pr = new WeatherView(getContext());
        final WeatherView pa = new WeatherView(getContext());

        w.addView(rj);
        w.addView(sp);
        w.addView(pa);
        w.addView(ba);
        w.addView(ny);
        w.addView(pr);

        final Handler handler = new Handler();
        runnableCode = new Runnable() {
            @Override
            public void run() {
                rj.getWeatherUnderground("Rio de Janeiro",-22.9865956,-43.2086082, "BR");
                sp.getWeatherUnderground("São Paulo", -23.5810818,-46.6692446, "BR");
                pa.getWeatherUnderground("Porto Alegre", -30.033764,-51.2278398, "BR");
                ny.getWeatherUnderground("New York", 40.76688,-73.9782681, "BR");
                ba.getWeatherUnderground("Buenos Aires", -34.5951784,-58.4242234, "BR");
                pr.getWeatherUnderground("Paris", 48.8610227,2.3430481, "BR");
                handler.postDelayed(runnableCode, 1000*60*10);
            }
        };
        handler.post(runnableCode);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}