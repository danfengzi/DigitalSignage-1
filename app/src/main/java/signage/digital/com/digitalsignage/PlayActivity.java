package signage.digital.com.digitalsignage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import java.util.List;
import signage.digital.com.digitalsignage.fragment.FragmentAdv;
import signage.digital.com.digitalsignage.fragment.FragmentEvent;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class PlayActivity extends BaseActivity implements FragmentEvent.OnCalendarChangeListener{

    private int numEvents = 0;
    private FragmentAdv frag_adv;
    private FragmentEvent frag_event;
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

        frag_adv = new FragmentAdv();
        frag_event = new FragmentEvent();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(frag_event,"event");
        transaction.commit();
    }

    private void switchFragment(Fragment fragment, String tag){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onCalendarChange(List<Eventm> list) {
        if(list.size()==0) {
            switchFragment(frag_adv, "adv");
        } else {
            if(list.size()!=numEvents){
                switchFragment(frag_event, "event");
            }
        }
        numEvents = list.size();
        Log.d("-----","List size: "+list.size());
    }
}