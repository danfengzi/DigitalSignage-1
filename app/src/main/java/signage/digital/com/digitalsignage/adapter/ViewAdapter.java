package signage.digital.com.digitalsignage.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import signage.digital.com.digitalsignage.R;

/**
 * Created by Alexandre on 22/07/2016.
 */
public class ViewAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<View> views;
    private LayoutInflater inflator;

    public void addItem(View v){
        views.add(v);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public Object getItem(int i) {
        return views.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder mHolder;
        View v = view;
        if (view == null) {
            mHolder = new ViewHolder();
            v = new View(context);
            //v = inflator.inflate(R.layout.item_gallery, null);
            mHolder.view = v;
            v.setTag(mHolder);
        }
        else {
            mHolder = (ViewHolder) v.getTag();
        }
        Log.d("-------","position: "+i);

        return v;
    }

    public ViewAdapter(Context c){
        this.context = c;
        this.views = new ArrayList<View>();
        this.inflator= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    class ViewHolder{
        public View view;
    }
}
