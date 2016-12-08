package signage.digital.com.digitalsignage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Alexandre on 22/07/2016.
 */
public class ItemImagesAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> paths;
    private LayoutInflater inflator;

    public void addItem(String url){
        paths.add(url);
        notifyDataSetChanged();
    }

    public void removeItem(String url){
        paths.remove(url);
        notifyDataSetChanged();
    }


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
        final ImagesViewHolder mHolder;
        View v = view;
        if (view == null) {
            mHolder = new ImagesViewHolder();
            v = inflator.inflate(R.layout.item_banner, null);
            mHolder.image = (ImageView) v.findViewById(R.id.item_picture);
            v.setTag(mHolder);
        }
        else {
            mHolder = (ImagesViewHolder) v.getTag();
        }
        Glide.with(context)
                .load(paths.get(i))
                .dontAnimate()
                .into(mHolder.image);
        return v;
    }


    public ItemImagesAdapter(Context c, ArrayList<String> array){
        this.context = c;
        this.paths = array;
        this.inflator= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        notifyDataSetChanged();
    }

    class ImagesViewHolder{
        public ImageView image;
    }

}