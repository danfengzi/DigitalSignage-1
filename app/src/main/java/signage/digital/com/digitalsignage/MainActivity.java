package signage.digital.com.digitalsignage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuth.AuthStateListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends BaseActivity implements OnClickListener{
    private DatabaseReference myRef;
    private Profile profile;
    private FirebaseAuth auth;
    private static String EMAIL="alexandrefett@everest.com.br";
    private static String PSWD="tuneca2011";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApp.getInstance().setContext(this);

        setContentView(R.layout.activity_main);
        findViewById(R.id.config).setOnClickListener(this);
        findViewById(R.id.play).setOnClickListener(this);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        auth = FirebaseAuth.getInstance();
        showProgress();
        if(auth.getCurrentUser()==null){
            login();
        } else{
            getProfile();
        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.config) {
            Intent intent = new Intent(this, ConfigActivity.class);
            startActivityForResult(intent, 1);
        }
        if(view.getId()==R.id.play) {
            Intent intent = new Intent(this, PlayActivity.class);
            startActivityForResult(intent, 2);
        }
    }

    private void play(){
        MyApp.getInstance().getProfile().setPlay(true);
        myRef.child("profile").setValue(MyApp.getInstance().getProfile());
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
        }
    }

    private void login(){
        auth.signInWithEmailAndPassword(EMAIL, PSWD);
        auth.addAuthStateListener(new AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()==null) {
                    hideProgress();
                    Toast.makeText(MainActivity.this, "Erro: ", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Login realizado", Toast.LENGTH_LONG).show();
                    getProfile();
                }
            }
        });
    }

    private void getProfile(){
        myRef.child("profile").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                hideProgress();
                Log.d("------", "data "+dataSnapshot.toString());
                if(dataSnapshot.getValue(Profile.class)==null)
                    MyApp.getInstance().setProfile(new Profile());
                else{
                    MyApp.getInstance().setProfile(dataSnapshot.getValue(Profile.class));
                    if(MyApp.getInstance().getProfile().isPlay()) {
                        Intent intent = new Intent(MainActivity.this, PlayActivity.class);
                        startActivityForResult(intent, 2);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                hideProgress();
            }
        });
    }
}
