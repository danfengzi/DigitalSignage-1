package signage.digital.com.digitalsignage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;


public class MainActivity extends BaseActivity implements OnClickListener{
    private DatabaseReference myRef;
    private FirebaseAuth mAuth;
    private FirebaseStorage storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyApp.getInstance().setContext(this);

        storage = FirebaseStorage.getInstance();
        mAuth = FirebaseAuth.getInstance();

        setContentView(R.layout.activity_main);
        findViewById(R.id.play).setOnClickListener(this);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

    }

    @Override
    public void onStart() {
        super.onStart();
        showProgress();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(final FirebaseUser u){
        boolean isSignedIn = (u != null);
        if (!isSignedIn) {
            signInAnonymously();
        }
        hideProgress();
    }

    private void signInAnonymously() {
        showProgress();
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
    public void onClick(View view) {
        if(view.getId()==R.id.play) {
            Intent intent = new Intent(this, PlayActivity.class);
            startActivityForResult(intent, 2);
        }
    }
}
