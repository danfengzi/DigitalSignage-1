package signage.digital.com.digitalsignage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import signage.digital.com.digitalsignage.adapter.ViewPagerAdapter;
import signage.digital.com.digitalsignage.fragment.FragmentAdv;
import signage.digital.com.digitalsignage.fragment.FragmentEvent;
import signage.digital.com.digitalsignage.fragment.FragmentWeather;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class PlayActivity extends BaseActivity implements FragmentEvent.OnCalendarChangeListener{

    private int numEvents = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE);

        setContentView(R.layout.activity_fullscreen2);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(new FragmentEvent(),"event");
        //transaction.add(new FragmentAdv(),"adv");
        transaction.add(R.id.fragment_container, new FragmentAdv(),"adv");
        transaction.commit();
    }

    private void switchFragment(String tag){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, getSupportFragmentManager().findFragmentByTag(tag));
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onCalendarChange(List<Eventm> list) {
        if(list.size()==0) {
            switchFragment("adv");
        } else {
            if(list.size()!=numEvents){
                switchFragment("event");
            }
        }
        numEvents = list.size();
        Log.d("-----","List size: "+list.size());
    }
}