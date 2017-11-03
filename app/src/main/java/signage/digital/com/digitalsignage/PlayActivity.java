package signage.digital.com.digitalsignage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import java.util.List;

import signage.digital.com.digitalsignage.adapter.FragmentAdapter;
import signage.digital.com.digitalsignage.fragment.FragmentAdv;
import signage.digital.com.digitalsignage.fragment.FragmentEvent;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class PlayActivity extends BaseActivity implements FragmentEvent.OnCalendarChangeListener{

    private int numEvents = 0;
    ViewPager viewPager;
    FragmentAdapter adapter;

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

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        adapter = new FragmentAdapter(getSupportFragmentManager());
        adapter.add(new FragmentAdv());
        adapter.add(new FragmentEvent());

        viewPager.setAdapter(adapter);

    }

    @Override
    public void onCalendarChange(List<Eventm> list) {
        if(list.size()==0) {
            viewPager.setCurrentItem(0);
        } else {
            viewPager.setCurrentItem(1);
        }
        numEvents = list.size();
        Log.d("-----","List size: "+list.size());
    }
}