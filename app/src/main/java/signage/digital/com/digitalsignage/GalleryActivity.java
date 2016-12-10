package signage.digital.com.digitalsignage;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import java.util.ArrayList;

import signage.digital.com.digitalsignage.adapter.ItemGalleryAdapter;

public class GalleryActivity extends BaseActivity {
    // LogCat tag
    private static final String TAG = "--->>>";
    private Uri fileUri;
    private GridView listGallery;
    private ArrayList<String> paths = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_gallery);

        listGallery = (GridView)findViewById(R.id.imagelist);
        listGallery.setAdapter(new ItemGalleryAdapter(this));
        listGallery.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent();
                intent.putExtra("path", (String)listGallery.getAdapter().getItem(i));
                setResult(Activity.RESULT_OK, intent);
                finish();

            }
        });

    }
}