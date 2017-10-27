package signage.digital.com.digitalsignage.fragment;

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
import android.widget.LinearLayout;
import android.widget.ViewFlipper;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;
import signage.digital.com.digitalsignage.MyApp;
import signage.digital.com.digitalsignage.R;
import signage.digital.com.digitalsignage.WeatherView;
import signage.digital.com.digitalsignage.model.City;

public class FragmentAdv extends Fragment {

    private DatabaseReference myRef;
    private ChildEventListener listener;
    private ViewFlipper flipper;
    private MyApp app;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("----------- onCreate ADV");
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        app = MyApp.getInstance();


        listener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                //adapter.addFragment(FragmentImage.getInstance(dataSnapshot.));
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                imageView.setScaleType(ImageView.ScaleType.FIT_END);
                imageView.setTag(dataSnapshot.getValue().toString());
                Picasso.with(getActivity().getBaseContext())
                        .load(dataSnapshot.getValue().toString())
                        .into(imageView);
                flipper.addView(imageView);
                //adapter.addItem(imageView);
                Log.d("-----","datasnapshot: "+dataSnapshot.getValue().toString());
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {         }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {        }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {         }

            @Override
            public void onCancelled(DatabaseError databaseError) {        }
        };
    }

    @Override
    public void onResume(){
        super.onResume();
//        myRef.child("profile/flyers").addChildEventListener(listener);
    }

    public void onPause(){
        super.onPause();
        myRef.removeEventListener(listener);
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
        System.out.println("----------------onCreateView ADV");

        View view =  inflater.inflate(R.layout.fragment_adv, container, false);
        flipper = (ViewFlipper)view.findViewById(R.id.flipper);
        flipper.setAnimateFirstView(true);
        flipper.setInAnimation(inAnimation());
        flipper.setOutAnimation(outAnimation());

        flipper.setFlipInterval(20000);
        flipper.setAutoStart(true);

        myRef.child("profile/flyers").addChildEventListener(listener);

        return view;
    }
}