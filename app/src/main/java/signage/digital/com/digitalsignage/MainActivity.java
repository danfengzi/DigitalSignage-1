package signage.digital.com.digitalsignage;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuth.AuthStateListener;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FileDownloadTask.TaskSnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;

public class MainActivity extends BaseActivity implements OnClickListener{
    private DatabaseReference myRef;
    private Profile profile;
    private FirebaseAuth mAuth;
    private FirebaseStorage storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyApp.getInstance().setContext(this);

        storage = FirebaseStorage.getInstance();
        mAuth = FirebaseAuth.getInstance();

        setContentView(R.layout.activity_main);
        findViewById(R.id.config).setOnClickListener(this);
        findViewById(R.id.play).setOnClickListener(this);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        showProgress();

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
        if (isSignedIn) {
            getProfile();
        } else {
            signInAnonymously();
        }
    }

    private void signInAnonymously() {
        showProgress();
        mAuth.signInAnonymously()
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInAnonymously:success");
                    FirebaseUser fuser = mAuth.getCurrentUser();
                    updateUI(fuser);
                } else {
                    Toast.makeText(MainActivity.this, "Authentication failed.",
                            Toast.LENGTH_SHORT).show();
                    updateUI(null);
                }
                }
            });
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
