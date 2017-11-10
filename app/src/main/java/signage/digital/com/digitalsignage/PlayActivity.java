package signage.digital.com.digitalsignage;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import java.util.List;
import signage.digital.com.digitalsignage.adapter.FragmentAdapter;
import signage.digital.com.digitalsignage.fragment.FragmentAdv;
import signage.digital.com.digitalsignage.fragment.FragmentEvent;
import signage.digital.com.digitalsignage.model.Conference;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class PlayActivity extends AppCompatActivity implements FragmentEvent.OnCalendarChangeListener{

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
                        | View.SYSTEM_UI_FLAG_IMMERSIVE
                        | View.SYSTEM_UI_FLAG_IMMERSIVE);
        setContentView(R.layout.activity_fullscreen2);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        adapter = new FragmentAdapter(getSupportFragmentManager());
        adapter.add(new FragmentAdv());
        adapter.add(new FragmentEvent());
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onCalendarChange(List<Conference> list) {
        if(list.size()==0) {
            viewPager.setCurrentItem(0);
        } else {
            viewPager.setCurrentItem(1);
        }
    }
}