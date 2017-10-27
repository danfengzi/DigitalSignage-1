package signage.digital.com.digitalsignage;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import signage.digital.com.digitalsignage.adapter.ViewPagerAdapter;
import signage.digital.com.digitalsignage.fragment.FragmentAdv;
import signage.digital.com.digitalsignage.fragment.FragmentEvent;
import signage.digital.com.digitalsignage.fragment.FragmentWeather;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class PlayActivity extends BaseActivity{

    private FragmentAdv adv;
    private FragmentEvent evt;
    private MyApp app;
    private ViewPager viewPager;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        myRef.child("events").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Log.d("-----","datasnapshot: "+dataSnapshot.toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE);
        setContentView(R.layout.activity_fullscreen);

        setupViewPager();
    }

    private void setupViewPager() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentWeather(), "Adv");
        //adapter.addFragment(new FragmentAdv(), "Adv");
        //adapter.addFragment(new FragmentEvent(), "Event");
        viewPager.setAdapter(adapter);
    }
}