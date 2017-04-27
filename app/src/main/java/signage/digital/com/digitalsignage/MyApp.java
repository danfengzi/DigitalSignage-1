package signage.digital.com.digitalsignage;

import android.app.Application;
import android.content.Context;
import android.os.Environment;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;

/**
 * Created by Alexandre on 19/09/2016.
 */
public class MyApp extends Application {
    private static MyApp ourInstance = new MyApp();
    private Profile profile;
    private Context context;
    public static MyApp getInstance() {
        return ourInstance;
    }
    private FirebaseStorage storage;
    private StorageReference storageRef;

    @Override
    public void onCreate() {
        super.onCreate();
        if(profile==null)
            profile = new Profile();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        storage = FirebaseStorage.getInstance();
        storageRef = storage.getReference();

    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        if(profile==null)
            this.profile = new Profile();
        this.profile = profile;
    }

    private void downloadFile(String child, String file, OnSuccessListener<FileDownloadTask.TaskSnapshot> listener) {
        File localFile = new File(Environment.DIRECTORY_DOWNLOADS + file);
        storageRef.child(child).getFile(localFile).addOnSuccessListener(listener);

        /*
                new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                System.out.println("Falha no download: "+exception.getMessage());
            }
        });
    }
    */
    }
}