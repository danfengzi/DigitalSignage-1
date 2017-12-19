package signage.digital.com.digitalsignage.fragment;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ViewFlipper;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.List;
import signage.digital.com.digitalsignage.model.Conference;
import signage.digital.com.digitalsignage.R;
import signage.digital.com.digitalsignage.databinding.FragmentEventBinding;
import signage.digital.com.digitalsignage.model.City;

public class FragmentEvent extends Fragment {
    private DatabaseReference myRef;
    private ValueEventListener listener;
    private ChildEventListener citylistener;
    private ObservableArrayList events = new ObservableArrayList();
    private ObservableArrayList cities = new ObservableArrayList();
    OnCalendarChangeListener mCallback;
    ViewFlipper flipper;

    public interface OnCalendarChangeListener {
        public void onCalendarChange(List<Conference> list);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            Activity activity = (Activity)context;
            mCallback = (OnCalendarChangeListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException("Must implement OnCalendarChangeListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        citylistener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                City city = dataSnapshot.getValue(City.class);
                cities.add(city);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                cities.set(Integer.valueOf(dataSnapshot.getKey()), dataSnapshot.getValue(City.class));
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        } ;

        listener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                flipper.stopFlipping();
                events.clear();
                for(DataSnapshot s:dataSnapshot.getChildren()){
                    Conference event = s.getValue(Conference.class);
                    events.add(event);
                }
                mCallback.onCalendarChange(events);
                flipper.startFlipping();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {            }
        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentEventBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_event,
                container, false);
        binding.setEntries(events);
        binding.setCities(cities);

        flipper = binding.getRoot().findViewById(R.id.flipperbanner);
        flipper.setInAnimation(inAnimation());
        flipper.setOutAnimation(outAnimation());
        flipper.setFlipInterval(15000);
        View view =  binding.getRoot();

        myRef.child("events").addValueEventListener(listener);

        return view;
    }

    @Override
    public void onPause(){
        super.onPause();
        myRef.child("cities").removeEventListener(citylistener);
        cities.clear();
    }

    @Override
    public void onResume(){
        super.onResume();
        myRef.child("cities").addChildEventListener(citylistener);
    }

    public static Animation inAnimation() {
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new DecelerateInterpolator()); //add this
        fadeIn.setDuration(1000);
        return fadeIn;
    }

    public static Animation outAnimation() {
        Animation fadeOut = new AlphaAnimation(1,0);
        fadeOut.setInterpolator(new DecelerateInterpolator()); //add this
        fadeOut.setDuration(1000);
        return fadeOut;
    }
}