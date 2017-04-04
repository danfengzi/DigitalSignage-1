package signage.digital.com.digitalsignage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuth.AuthStateListener;
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
    private FirebaseAuth auth;
    private static String EMAIL="alexandrefett@everest.com.br";
    private static String PSWD="tuneca2011";
    private FirebaseStorage storage;
    private StorageReference storageRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApp.getInstance().setContext(this);
        storage = FirebaseStorage.getInstance();
        storageRef = storage.getReference();

        Log.d(TAG, "Versao 2");
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
        myRef.child("file").child("update").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                System.out.println("Inicio da atualizacao: ");
                boolean update = (boolean)dataSnapshot.getValue();
                if(update) {
                    update();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        Log.d("------","Downloads: "+Environment.DIRECTORY_DOWNLOADS);
    }

    private void appUpdate(){
        File file = new File("/mnt/internal_sd/Download/app-release.apk");
        file.setReadable(true, false);
        Intent intent = new Intent(Intent.ACTION_INSTALL_PACKAGE);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        startActivity(intent);
        finish();
    }

    private void update(){
        File localFile =  new File(Environment.DIRECTORY_DOWNLOADS+"/app-release.apk");

        storageRef.child("app/app-release.apk").getFile(localFile).addOnSuccessListener(new OnSuccessListener<TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                System.out.println("Download completo: "+taskSnapshot.getBytesTransferred());
                myRef.child("file/update").setValue(false);
                System.out.println("Set to false: ");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                System.out.println("Falha no download: "+exception.getMessage());
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
