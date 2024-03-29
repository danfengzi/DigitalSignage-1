package signage.digital.com.digitalsignage.fragment;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ViewFlipper;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;
import signage.digital.com.digitalsignage.R;
import signage.digital.com.digitalsignage.databinding.FragmentWeatherBinding;
import signage.digital.com.digitalsignage.model.City;

public class FragmentAdv extends Fragment {

    private DatabaseReference myRef;
    private ValueEventListener listener;
    private ChildEventListener citylistener;
    private ViewFlipper flipper;
    private ObservableArrayList cities = new ObservableArrayList();


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
                Log.e("Error Database: ",databaseError.getMessage());

            }
        };

        listener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(int i=1;i<flipper.getChildCount();i++){
                    flipper.removeViewAt(i);
                }
                for(DataSnapshot data:dataSnapshot.getChildren()){
                    ImageView imageView = new ImageView(getContext());
                    imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                    imageView.setScaleType(ImageView.ScaleType.FIT_END);
                    imageView.setTag(dataSnapshot.getValue().toString());
                    Picasso.with(getActivity().getBaseContext())
                            .load(data.getValue().toString())
                            .into(imageView);
                    flipper.addView(imageView);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {        }
        };
    }

    @Override
    public void onResume(){
        super.onResume();
        cities.clear();
        myRef.child("profile/flyers").addValueEventListener(listener);
        myRef.child("cities").addChildEventListener(citylistener);
    }

    public void onPause(){
        super.onPause();
        myRef.removeEventListener(listener);
        myRef.removeEventListener(citylistener);
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_adv, container, false);
        flipper = (ViewFlipper)view.findViewById(R.id.flipper);
        flipper.setAnimateFirstView(true);
        flipper.setInAnimation(inAnimation());
        flipper.setOutAnimation(outAnimation());

        flipper.setFlipInterval(20000);
        flipper.setAutoStart(true);

        FragmentWeatherBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_weather, container, false);
        binding.setCities(cities);
        flipper.addView(binding.getRoot());

        return view;
    }
}