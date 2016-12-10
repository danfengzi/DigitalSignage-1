package signage.digital.com.digitalsignage;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.GridView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import signage.digital.com.digitalsignage.adapter.ViewPagerAdapter;
import signage.digital.com.digitalsignage.fragment.FragAgendaConfig;
import signage.digital.com.digitalsignage.fragment.FragBannerConfig;
import signage.digital.com.digitalsignage.fragment.FragFlyerConfig;

public class ConfigActivity extends BaseActivity {
    private ProgressDialog progress;
    private Button ok;
    private FirebaseStorage storage;
    private StorageReference storageRef;
    private DatabaseReference myRef;
    private GridView grid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        storage = FirebaseStorage.getInstance();
        storageRef = storage.getReference();
        myRef = FirebaseDatabase.getInstance().getReference();

        setupViewPager();
    }

    private void setupViewPager() {
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setOnTouchListener(new OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                return true;
            }
        });
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragAgendaConfig(), "Agenda");
        adapter.addFragment(new FragFlyerConfig(), "Flyer");
        adapter.addFragment(new FragBannerConfig(), "Banner");
        //adapter.addFragment(new FragWeatherConfig(), "Tempo");
        viewPager.setAdapter(adapter);
    }



    public void onPause(){
        super.onPause();
        myRef.child("profile").setValue(MyApp.getInstance().getProfile());
    }

}
