package signage.digital.com.digitalsignage;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.util.List;
import signage.digital.com.digitalsignage.adapter.FragmentAdapter;
import signage.digital.com.digitalsignage.fragment.FragmentAdv;
import signage.digital.com.digitalsignage.fragment.FragmentEvent;
import signage.digital.com.digitalsignage.model.Conference;


public class MainActivity extends AppCompatActivity implements FragmentEvent.OnCalendarChangeListener{
    private FirebaseAuth mAuth;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();

    }


    private void buildScreen(){
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
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
        adapter.add(new FragmentAdv());
        adapter.add(new FragmentEvent());
        viewPager.setAdapter(adapter);

    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    private void updateUI(final FirebaseUser u){
        boolean isSignedIn = (u != null);
        if (!isSignedIn) {
            signInAnonymously();
        } else {
            buildScreen();
        }
    }

    private void signInAnonymously() {
        mAuth.signInAnonymously()
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Authenticated!", Toast.LENGTH_SHORT).show();
                    FirebaseUser fuser = mAuth.getCurrentUser();
                    updateUI(fuser);
                } else {
                    Toast.makeText(MainActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                    updateUI(null);
                }
                }
            });
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
