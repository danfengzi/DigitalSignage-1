package signage.digital.com.digitalsignage;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import java.util.ArrayList;

import signage.digital.com.digitalsignage.adapter.ItemEventsAdapter;
import signage.digital.com.digitalsignage.fragment.FragmentAdv;
import signage.digital.com.digitalsignage.fragment.FragmentEvent;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class PlayActivity extends BaseActivity{

    private int current = 0; //0 = start, 1 = adv, 2 = evt
    private ItemEventsAdapter eventsAdapter;
    private FragmentAdv adv;
    private FragmentEvent evt;
    Handler handler = new Handler();

    Runnable serviceRunnable = new Runnable() {
        @Override
        public void run() {
        updateAgenda(CalendarService.readCalendar(getBaseContext(),1,0, MyApp.getInstance().getProfile().getCalendar_id()));
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

        //adv = new FragmentAdv();
        //adv.addWeather(l);
        //FragmentManager fm = getSupportFragmentManager();
        //FragmentTransaction transaction = fm.beginTransaction();
        //transaction.add(R.id.contentFragment, adv); //Container -> R.id.contentFragment
        //transaction.commit();
        //current=1;

        //evt.addWeather(l);


//        if (eventSize == 0) {
  //          getSupportFragmentManager().beginTransaction().add(R.id.contentFragment, adv).commit();
            //currentFrag = 1;
    //    } else {
      //      getSupportFragmentManager().beginTransaction()
        //            .add(R.id.contentFragment, evt).commit();
            //currentFrag = 2;
        //}
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        handler.postDelayed(serviceRunnable,5000);
        //switchFragment(adv,TYPE_ADVERTISING);
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
    }

    @Override
    public void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        handler.removeCallbacks(serviceRunnable);
    }

    @Override
    public void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
    }

    private void switchFragment(Fragment f) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.contentFragment, f); //Container -> R.id.contentFragment
        //transaction.addToBackStack(null);
        transaction.commit();
    }


    public void updateAgenda(ArrayList<CalendarEvent> events) {
        System.out.println("----------------updateAgenda");
        if (events.size()>0) {
            if (current == 1 || current == 0) {
                evt = new FragmentEvent();
                switchFragment(evt);
                current = 2;
                System.out.println("----------------replace to event");
            }
        }
        else {
            if (current == 2 || current == 0) {
                adv = new FragmentAdv();
                switchFragment(adv);
                current = 1;
                System.out.println("----------------replace to adv");
            }
        }
    }
}