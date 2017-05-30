package signage.digital.com.digitalsignage.fragment;

import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.util.ArrayList;

import signage.digital.com.digitalsignage.MyApp;
import signage.digital.com.digitalsignage.R;
import signage.digital.com.digitalsignage.WeatherView;
import signage.digital.com.digitalsignage.adapter.ImageAdapter;
import signage.digital.com.digitalsignage.adapter.ImageAdapter2;
import signage.digital.com.digitalsignage.adapter.ViewPagerAdapter;
import signage.digital.com.digitalsignage.model.City;

public class FragmentAdv extends Fragment {

    private DatabaseReference myRef;
    private ChildEventListener listener;
    private AdapterViewFlipper flipper;
    private ImageAdapter adapter;
    private MyApp app;
    private FirebaseStorage storage;
    private StorageReference storageRef;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("----------- onCreate ADV");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        app = MyApp.getInstance();
        storage = FirebaseStorage.getInstance();
        storageRef = storage.getReference();

        listener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                downloadFile(dataSnapshot.getValue(String.class));
                System.out.println("----------------onChildAdded");
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


    private void downloadFile(final String file) {
        final File localFile = new File(Environment.DIRECTORY_DOWNLOADS + file);
        storageRef.child("images").getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                Fragment f = FragmentImage.getInstance(Environment.DIRECTORY_DOWNLOADS + file);
                flipper.addView(f.getView());

            }
        });
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
        System.out.println("----------------onCreateView ADV");

        View view =  inflater.inflate(R.layout.fragment_adv, container, false);
        flipper = (AdapterViewFlipper)view.findViewById(R.id.flipper);
        flipper.setInAnimation(getActivity(), R.anim.view_transition_in_left);
        flipper.setOutAnimation(getActivity(), R.anim.view_transition_out_right);
        flipper.setFlipInterval(20000);
        flipper.setAutoStart(true);

        FragmentWeather fw = new FragmentWeather();

        flipper.addView(fw.getView());
        flipper.setAdapter(adapter);

        flipper.removeAllViews();
        return view;
    }

    private void setupViewPager(View v) {
    //    ViewPager viewPager = (ViewPager) v.findViewById(R.id.viewpageradv);
    //    ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
    //    viewPager.setAdapter(adapter);
    }

}