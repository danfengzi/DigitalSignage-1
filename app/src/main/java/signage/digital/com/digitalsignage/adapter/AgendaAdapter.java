package signage.digital.com.digitalsignage.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

import signage.digital.com.digitalsignage.R;

/**
 * Created by Alexandre on 08/12/2016.
 */

public class AgendaAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> array;
    private LayoutInflater inflator;
    private String agenda;

    public void setSelectedAgenda(String agenda) {
        this.agenda = agenda;
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
        final AgendaAdapter.AgendaViewHolder mHolder;
        View v = view;
        if (view == null) {
            mHolder = new AgendaAdapter.AgendaViewHolder();
            v = inflator.inflate(R.layout.item_agenda, null);
            mHolder.text1 = (TextView) v.findViewById(R.id.text1);
            mHolder.check1 = (CheckBox) v.findViewById(R.id.checkBox1);
            v.setTag(mHolder);
        } else {
            mHolder = (AgendaAdapter.AgendaViewHolder) v.getTag();
        }
        mHolder.text1.setText(array.get(i));
        if (array.get(i).equals(agenda)) {
            mHolder.check1.setChecked(true);
        } else {
            mHolder.check1.setChecked(false);
        }
        return v;
    }


    public AgendaAdapter(Context c, ArrayList<String> array) {
        this.context = c;
        this.array = array;
        this.inflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    class AgendaViewHolder {
        public TextView text1;
        public CheckBox check1;
    }
}