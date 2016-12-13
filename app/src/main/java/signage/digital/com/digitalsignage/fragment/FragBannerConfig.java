package signage.digital.com.digitalsignage.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.firebase.storage.UploadTask.TaskSnapshot;

import java.io.ByteArrayOutputStream;
import java.io.File;

import signage.digital.com.digitalsignage.GalleryActivity;
import signage.digital.com.digitalsignage.MyApp;
import signage.digital.com.digitalsignage.Profile;
import signage.digital.com.digitalsignage.R;
import signage.digital.com.digitalsignage.adapter.ItemImagesAdapter;

import static android.app.Activity.RESULT_OK;

public class FragBannerConfig extends BaseFragment {

    private FirebaseStorage storage;
    private StorageReference storageRef;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        storage = FirebaseStorage.getInstance();
        storageRef = storage.getReference();
    }

    @Override
    public void onResume(){
        super.onResume();
    }

    public void onPause(){
        super.onPause();
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 3) {
                String path = data.getStringExtra("path");
                File imgFile = new File(path);
                if (imgFile.exists()) {
                    saveImage(imgFile.getAbsolutePath(), 3);
                }
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.frag_banner_config, container, false);

        Button addBanner = (Button)view.findViewById(R.id.addbanner);
        addBanner.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), GalleryActivity.class);
                startActivityForResult(intent, 3);
            }
        });

        ListView list = (ListView)view.findViewById(R.id.list);
        list.setAdapter(new ItemImagesAdapter(getContext(), MyApp.getInstance().getProfile().getBanners()));
        list.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
                AlertDialog.Builder adb = new AlertDialog.Builder(getContext());
                adb.setMessage("Deseja excluir esta image?");
                adb.setIcon(android.R.drawable.ic_dialog_alert);
                adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        MyApp.getInstance().getProfile().getBanners().remove(i);
                    }
                });
                adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                adb.show();
            }
        });

        return view;
    }


    @Override
    public void onStart() {
        super.onStart();
    }

    public void saveImage(String path, final int type){ //type 1=flyers 3=banner
        showDialog();

        Bitmap bmp = BitmapFactory.decodeFile(path);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] b = baos.toByteArray();

        StorageReference imagesRef = storageRef.child("images/"+System.currentTimeMillis()+".jpg");

        UploadTask uploadTask = imagesRef.putBytes(b);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                hideDialog();
            }
        }).addOnSuccessListener(new OnSuccessListener<TaskSnapshot>() {
            @Override
            public void onSuccess(TaskSnapshot taskSnapshot) {
                Profile p = MyApp.getInstance().getProfile();
                Uri downloadUrl = taskSnapshot.getDownloadUrl();
                p.getBanners().add(downloadUrl.toString());
                hideDialog();
            }
        });
    }
}