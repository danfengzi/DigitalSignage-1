package signage.digital.com.digitalsignage.adapter;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Images.Thumbnails;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

import signage.digital.com.digitalsignage.R;

/**
 * Created by Alexandre on 22/07/2016.
 */
public class ItemGalleryAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Integer> array;
    private ArrayList<String> paths;
    private LayoutInflater inflator;


    @Override
    public int getCount() {
        return paths.size();
    }

    @Override
    public Object getItem(int i) {
        return paths.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ItemGalleryViewHolder mHolder;
        View v = view;
        if (view == null)
        {
            mHolder = new ItemGalleryViewHolder();
            v = inflator.inflate(R.layout.item_gallery, null);
            mHolder.image = (ImageView) v.findViewById(R.id.item_picture);
            v.setTag(mHolder);
        }
        else
        {
            mHolder = (ItemGalleryViewHolder) v.getTag();
        }
        Bitmap bitmap = Thumbnails.getThumbnail(context.getContentResolver(), array.get(i), Thumbnails.MINI_KIND, null);
        mHolder.image.setImageBitmap(bitmap);

        return v;
    }


    public ItemGalleryAdapter(Context c){
        this.context = c;
        this.paths = new ArrayList<String>();
        this.array = new ArrayList<Integer>();
        this.inflator= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        getIds();
        notifyDataSetChanged();
        Log.d("------", "size "+paths.size());
    }

    class ItemGalleryViewHolder{
        public ImageView image;
    }

    private void getIds() {
        String[] projection = new String[]{
                Media._ID
        };
        Uri images = Media.EXTERNAL_CONTENT_URI;
        Cursor cur = context.getContentResolver().query(images,
                null, // Which columns to return
                null,       // Which rows to return (all rows)
                null,       // Selection arguments (none)
                null        // Ordering
        );

        if (cur.moveToFirst()) {
            int idColumn = cur.getColumnIndex(Media._ID);
            int pathColumn = cur.getColumnIndex(Media.DATA);
            while (!cur.isAfterLast()) {
                array.add(cur.getInt(idColumn));
                paths.add(cur.getString(pathColumn));
                cur.moveToNext();
            }
        }
    }
}
