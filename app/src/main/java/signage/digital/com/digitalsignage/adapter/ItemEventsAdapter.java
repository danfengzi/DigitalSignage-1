package signage.digital.com.digitalsignage.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import signage.digital.com.digitalsignage.CalendarEvent;
import signage.digital.com.digitalsignage.R;

/**
 * Created by Alexandre on 22/07/2016.
 */
public class ItemEventsAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<CalendarEvent> array;
    private LayoutInflater inflator;


    public void update(ArrayList<CalendarEvent> e){
        this.array = e;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return array.size();
    }

    @Override
    public Object getItem(int i) {
        return array.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ItemEventViewHolder mHolder;
        View v = view;
        if (view == null){
            mHolder = new ItemEventViewHolder();
            v = inflator.inflate(R.layout.item_event, null);
            mHolder.text1 = (TextView) v.findViewById(R.id.text1);
            mHolder.text2 = (TextView) v.findViewById(R.id.text2);
            v.setTag(mHolder);
        }
        else {
            mHolder = (ItemEventViewHolder) v.getTag();
        }
        mHolder.text1.setText(array.get(i).getTitle());
        mHolder.text2.setText(array.get(i).getRoom());
        return v;
    }


    public ItemEventsAdapter(Context c, ArrayList<CalendarEvent> array){
        this.context = c;
        this.array = array;
        this.inflator= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        notifyDataSetChanged();
    }

    class ItemEventViewHolder{
        public TextView text1;
        public TextView text2;
    }

}
