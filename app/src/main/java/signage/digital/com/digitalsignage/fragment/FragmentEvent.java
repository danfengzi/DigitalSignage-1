package signage.digital.com.digitalsignage.fragment;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewFlipper;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.List;
import signage.digital.com.digitalsignage.Eventm;
import signage.digital.com.digitalsignage.R;
import signage.digital.com.digitalsignage.databinding.FragmentEventBinding;
import signage.digital.com.digitalsignage.databinding.WeatherCurrentBinding;
import signage.digital.com.digitalsignage.model.City;

public class FragmentEvent extends BaseFragment {
    private DatabaseReference myRef;
    private ValueEventListener listener;
    private ChildEventListener citylistener;
    private ObservableArrayList events = new ObservableArrayList();
    private ObservableArrayList cities = new ObservableArrayList();
    OnCalendarChangeListener mCallback;
    private ViewFlipper flipper;

    public interface OnCalendarChangeListener {
        public void onCalendarChange(List<Eventm> list);
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
                flipper.addView(setupCityView(city));
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
                events.clear();
                for(DataSnapshot s:dataSnapshot.getChildren()){
                    Eventm event = s.getValue(Eventm.class);
                    events.add(event);
                }
                mCallback.onCalendarChange(events);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {            }
        };
        System.out.println("----------------onCreate Event");

    }

    private View setupCityView(City city){
        LayoutInflater inflater = getLayoutInflater();
//        ViewGroup container = this.getView().findViewById(R.id.flipperbanner);
        WeatherCurrentBinding binding = DataBindingUtil.inflate(inflater, R.layout.weather_current, flipper, false);
        binding.setCity(city);

        return binding.getRoot();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentEventBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_event, container, false);
        binding.setEntries(events);
        flipper = binding.getRoot().findViewById(R.id.flipperbanner);
        View view =  binding.getRoot();
        System.out.println("----------------onCreateView Event");


        return view;
    }

    @Override
    public void onResume(){
        super.onResume();
        myRef.child("events").addValueEventListener(listener);
        myRef.child("cities").addChildEventListener(citylistener);
    }

}