package signage.digital.com.digitalsignage.fragment;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import signage.digital.com.digitalsignage.Eventm;
import signage.digital.com.digitalsignage.LayoutHandler;
import signage.digital.com.digitalsignage.R;
import signage.digital.com.digitalsignage.WeatherView;
import signage.digital.com.digitalsignage.databinding.FragmentEventBinding;

public class FragmentEvent extends BaseFragment {
    private ArrayList<WeatherView> listW;
    private DatabaseReference myRef;
    //private ChildEventListener listener;
    private ValueEventListener listener;

    private ObservableArrayList events = new ObservableArrayList();
    OnCalendarChangeListener mCallback;

    public interface OnCalendarChangeListener {
        public void onCalendarChange(List<Eventm> list);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
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

        listener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
//                Eventm event = dataSnapshot.getValue(Eventm.class);
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

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentEventBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_event, container, false);
        binding.setEntries(events);
        binding.setHandler(new LayoutHandler());

        myRef.child("events").addValueEventListener(listener);
        View view =  binding.getRoot();

        return view;
    }
}