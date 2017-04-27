package signage.digital.com.digitalsignage.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.GridView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.firebase.storage.UploadTask.TaskSnapshot;

import java.io.ByteArrayOutputStream;
import java.io.File;

import signage.digital.com.digitalsignage.MyApp;
import signage.digital.com.digitalsignage.Profile;
import signage.digital.com.digitalsignage.R;
import signage.digital.com.digitalsignage.adapter.ItemImagesAdapter;

import static android.app.Activity.RESULT_OK;

public class FragFlyerConfig extends BaseFragment {

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
            if (requestCode == 1) {
                Uri selectedImageUri = data.getData();
                if (selectedImageUri != null) {
                    String path = getRealPathFromURI(getContext(), selectedImageUri);
                    //String path = data.getStringExtra("path");
                    File imgFile = new File(path);
                    if (imgFile.exists()) {
                        saveImage(imgFile.getAbsolutePath(), 1);
                    }
                }
            }
        }
    }

    public String getRealPathFromURI(Context context, Uri contentUri) {
        Cursor cursor = null;
        try {
            String[] proj = { MediaStore.Images.Media.DATA };
            cursor = context.getContentResolver().query(contentUri,  proj, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.frag_flayer_config, container, false);

        CheckBox auto = (CheckBox)view.findViewById(R.id.auto);
        auto.setChecked(MyApp.getInstance().getProfile().isPlay());
        auto.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                MyApp.getInstance().getProfile().setPlay(b);
            }
        });

        Button addImage = (Button)view.findViewById(R.id.addimage);
        addImage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoPickerIntent = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, 1);
                //Intent intent = new Intent(getContext(), GalleryActivity.class);
                //startActivityForResult(intent, 1);
            }
        });

        final ItemImagesAdapter adapter = new ItemImagesAdapter(getContext(), MyApp.getInstance().getProfile().getFlyers());
        GridView list = (GridView)view.findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
                AlertDialog.Builder adb = new AlertDialog.Builder(getContext());
                adb.setMessage("Deseja excluir esta image?");
                adb.setIcon(android.R.drawable.ic_dialog_alert);
                adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        MyApp.getInstance().getProfile().getFlyers().remove(i);
                        adapter.setItems(MyApp.getInstance().getProfile().getFlyers());
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
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Profile p = MyApp.getInstance().getProfile();
                Uri downloadUrl = taskSnapshot.getDownloadUrl();
                p.getFlyers().add(downloadUrl.toString());
                hideDialog();
            }
        });
    }
}