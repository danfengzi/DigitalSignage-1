package signage.digital.com.digitalsignage;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

import signage.digital.com.digitalsignage.adapter.ItemEventsAdapter;
import signage.digital.com.digitalsignage.adapter.ViewPagerAdapter;
import signage.digital.com.digitalsignage.fragment.FragmentAdv;
import signage.digital.com.digitalsignage.fragment.FragmentEvent;
import signage.digital.com.digitalsignage.model.City;
import signage.digital.com.digitalsignage.model.Screen;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class PlayActivity extends BaseActivity{

    private int current = 0; //0 = start, 1 = adv, 2 = evt
    private ItemEventsAdapter eventsAdapter;
    private FragmentAdv adv;
    private FragmentEvent evt;
    private MyApp app;
    private ViewPager viewPager;

    Handler handler = new Handler();
    Runnable serviceRunnable = new Runnable() {
        @Override
        public void run() {
        updateAgenda(CalendarService.readCalendar(getBaseContext(),1,0, app.getScreen().getCalendar_id()));
        handler.postDelayed(this, (1000*60*5));
        }
    };

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
        setContentView(R.layout.activity_fullscreen);

        app = MyApp.getInstance();
        app.addCity(new City("Rio de Janeiro", -22.9865956, -43.2086082, "BR"));
        app.addCity(new City("São Paulo", -23.5810818, -46.6692446, "BR"));
        app.addCity(new City("Porto Alegre", -30.033764,-51.2278398, "BR"));
        app.addCity(new City("Buenos Aires", -34.5951784,-58.4242234, "BR"));

        setupViewPager();

    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        handler.postDelayed(serviceRunnable,5000);
    }

    @Override
    public void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        handler.removeCallbacks(serviceRunnable);
    }

    private void setupViewPager() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentAdv(), "Adv");
        adapter.addFragment(new FragmentEvent(), "Event");
        viewPager.setAdapter(adapter);
    }

    public void updateAgenda(ArrayList<CalendarEvent> events) {
        System.out.println("----------------updateAgenda");
        if (events.size()>0) {
            viewPager.setCurrentItem(1);
        }
        else {
            viewPager.setCurrentItem(0);
        }
    }
}