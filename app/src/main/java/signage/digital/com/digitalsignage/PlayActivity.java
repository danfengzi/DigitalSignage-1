package signage.digital.com.digitalsignage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

import signage.digital.com.digitalsignage.fragment.FragmentAdv;
import signage.digital.com.digitalsignage.fragment.FragmentEvent;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class PlayActivity extends BaseActivity {

    private int eventSize;
    private FragmentAdv fragAdv;
    private FragmentEvent fragEvent;
    private int currentFrag=0; //1=Adv 2 = Event
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

        eventSize = MyApp.getInstance().updateEvents().size();

        fragAdv = new FragmentAdv();
        fragEvent = new FragmentEvent();


        if(eventSize==0) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentFragment, fragAdv).commit();
            currentFrag = 1;
        } else {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentFragment, fragEvent).commit();
            currentFrag = 2;
        }

        final long period = 10000*60;
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                buildPage();
            }
        }, 0, period);
    }

    private void switchFragment(Fragment f){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.contentFragment, f); //Container -> R.id.contentFragment
        transaction.commit();
    }

    private void buildPage(){
        eventSize = MyApp.getInstance().updateEvents().size();

        if(eventSize>0) {
            if(currentFrag==1) {
                switchFragment(fragEvent);
                currentFrag=2;
            }
        } else {
            if(currentFrag==2) {
                switchFragment(fragAdv);
                currentFrag=1;
            }

        }
    }
}
