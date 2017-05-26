package signage.digital.com.digitalsignage.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

import signage.digital.com.digitalsignage.R;

/**
 * Created by everest on 28/04/2017.
 */

public class ImageAdapter2 extends PagerAdapter {

    Context mContext;
    LayoutInflater mLayoutInflater;
    ArrayList<String> files = new ArrayList<String>();
    View v;

    public ImageAdapter2(Context context) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setFirstView(View v){
        this.v = v;
    }

    public void addFile(String file){
        files.add(file);
        notifyDataSetChanged();
    }

    public void removeFile(String file){
        files.remove(file);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return files.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView;
        if(position>0) {
            itemView = mLayoutInflater.inflate(R.layout.layout_image, container, false);

            ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
            imageView.setImageBitmap(BitmapFactory.decodeFile(files.get(position)));
            container.addView(itemView);
        }
        else{
            itemView = v;
        }
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}