package signage.digital.com.digitalsignage;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract.Calendars;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.GridView;
import android.widget.Spinner;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.firebase.storage.UploadTask.TaskSnapshot;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;

public class ConfigActivity extends BaseActivity {
    private ProgressDialog progress;
    private Button ok;
    private FirebaseStorage storage;
    private StorageReference storageRef;
    private DatabaseReference myRef;
    private GridView grid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        storage = FirebaseStorage.getInstance();
        storageRef = storage.getReference();
        myRef = FirebaseDatabase.getInstance().getReference();

        getCalendars();

        grid = (GridView)findViewById(R.id.gridlist);

        CheckBox auto = (CheckBox)findViewById(R.id.auto);
        auto.setChecked(MyApp.getInstance().getProfile().isPlay());
        auto.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                MyApp.getInstance().getProfile().setPlay(b);
            }
        });

        Button addImage = (Button)findViewById(R.id.addimage);
        addImage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConfigActivity.this, GalleryActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        Button addBanner = (Button)findViewById(R.id.addbanner);
        addBanner.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConfigActivity.this, GalleryActivity.class);
                startActivityForResult(intent, 3);
            }
        });
        setList();
    }

    private void setList(){
        grid.setAdapter(new ItemImagesAdapter(this, MyApp.getInstance().getProfile().getFlyers()));
        grid.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
                AlertDialog.Builder adb = new AlertDialog.Builder(ConfigActivity.this);
                adb.setMessage("Deseja excluir esta image?");
                adb.setIcon(android.R.drawable.ic_dialog_alert);
                adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        MyApp.getInstance().getProfile().getFlyers().remove(i);
                    }
                });
                adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                adb.show();
            }
        });
    }

    public void onPause(){
        super.onPause();
        myRef.child("profile").setValue(MyApp.getInstance().getProfile());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {
                String path = data.getStringExtra("path");
                File imgFile = new File(path);
                if (imgFile.exists()) {
                    saveImage(imgFile.getAbsolutePath(), 1);
                }
            }
            if (requestCode == 3) {
                String path = data.getStringExtra("path");
                File imgFile = new File(path);
                if (imgFile.exists()) {
                    saveImage(imgFile.getAbsolutePath(), 3);
                }
            }
        }
        setList();

    }

    private void getCalendars(){
        final ArrayList<String> arrayName = new ArrayList<String>();
        final ArrayList<Integer> arrayId = new ArrayList<Integer>();
        ContentResolver contentResolver = getContentResolver();

        final Cursor cCalendar = contentResolver.query(Uri.parse("content://com.android.calendar/calendars"),
                new String[]{ Calendars._ID, Calendars.NAME, Calendars.CALENDAR_DISPLAY_NAME },
                null, null, null);
        if(cCalendar.getCount() > 0){
            while (cCalendar.moveToNext()) {
                arrayName.add(cCalendar.getString(1));
                arrayId.add(cCalendar.getInt(0));
            }
            Spinner list = (Spinner)findViewById(R.id.spinner);
            list.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayName));
            list.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    MyApp.getInstance().getProfile().setCalendar_id(arrayName.get(i));
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }
    }

    public void saveImage(String path, final int type){ //type 1=flyers 3=banner
        showProgress();

        Bitmap bmp = BitmapFactory.decodeFile(path);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] b = baos.toByteArray();

        StorageReference imagesRef = storageRef.child("images/"+System.currentTimeMillis()+".jpg");

        UploadTask uploadTask = imagesRef.putBytes(b);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                Log.d("-------", "Uploadtask failed");
                hideProgress();
            }
        }).addOnSuccessListener(new OnSuccessListener<TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Profile p = MyApp.getInstance().getProfile();
                Uri downloadUrl = taskSnapshot.getDownloadUrl();
                if(type==1)
                    p.getFlyers().add(downloadUrl.toString());
                if(type==3)
                    p.getBanners().add(downloadUrl.toString());
                Log.d("----", "downloadUrl: "+downloadUrl.toString());
                hideProgress();
            }
        });

    }

}
