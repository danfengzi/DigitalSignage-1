package signage.digital.com.digitalsignage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class SubFragBanner extends Fragment {
    private DatabaseReference myRef;
    private ChildEventListener listener;
    private AdapterViewFlipper flipper;
    private ItemImagesAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

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

        flipper = (AdapterViewFlipper)view.findViewById(R.id.banners);
        adapter = new ItemImagesAdapter(getContext(), new ArrayList<String>());
        flipper.setAdapter(adapter);
        flipper.setFlipInterval(10000);
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

    @Override
    public void onStart() {
        super.onStart();
    }

}