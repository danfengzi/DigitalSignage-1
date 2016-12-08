package signage.digital.com.digitalsignage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import signage.digital.com.digitalsignage.library.model.ForecastRecord;

/**
 * Created by Alexandre on 22/07/2016.
 */
public class ItemWeatherAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<ForecastRecord> array;
    private LayoutInflater inflator;


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
        final ItemGalleryViewHolder mHolder;
        View v = view;
        if (view == null)
        {
            mHolder = new ItemGalleryViewHolder();
            v = inflator.inflate(R.layout.item_weather_full, null);
            mHolder.city = (TextView) v.findViewById(R.id.city);
            mHolder.temp0 = (TextView) v.findViewById(R.id.temp0);
            mHolder.temp1 = (TextView) v.findViewById(R.id.temp1);
            mHolder.temp2 = (TextView) v.findViewById(R.id.temp2);
            mHolder.icon0 = (ImageView) v.findViewById(R.id.icon0);
            mHolder.icon1 = (ImageView) v.findViewById(R.id.icon1);
            mHolder.icon2 = (ImageView) v.findViewById(R.id.icon2);

            v.setTag(mHolder);
        }
        else
        {
            mHolder = (ItemGalleryViewHolder) v.getTag();
        }

        mHolder.city.setText(array.get(i).getCity().getName());
        mHolder.temp0.setText(array.get(i).getForecast().get(1).getTemperature().getMinimumTemperature()+"/"+array.get(i).getForecast().get(1).getTemperature().getMaximunTemperature());
        mHolder.temp1.setText(array.get(i).getForecast().get(2).getTemperature().getMinimumTemperature()+"/"+array.get(i).getForecast().get(1).getTemperature().getMaximunTemperature());
        mHolder.temp2.setText(array.get(i).getForecast().get(3).getTemperature().getMinimumTemperature()+"/"+array.get(i).getForecast().get(1).getTemperature().getMaximunTemperature());
        Glide.with(context)
                .load("http://openweathermap.org/img/w/"+array.get(i).getForecast().get(1).getWeather().get(1).getIcon()+".png")
                .dontAnimate()
                .into(mHolder.icon0);
        Glide.with(context)
                .load("http://openweathermap.org/img/w/"+array.get(i).getForecast().get(2).getWeather().get(1).getIcon()+".png")
                .dontAnimate()
                .into(mHolder.icon0);
        Glide.with(context)
                .load("http://openweathermap.org/img/w/"+array.get(i).getForecast().get(3).getWeather().get(1).getIcon()+".png")
                .dontAnimate()
                .into(mHolder.icon0);
        return v;
    }


    public ItemWeatherAdapter(Context c, ArrayList<ForecastRecord> array){
        this.context = c;
        this.array = array;
        this.inflator= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        notifyDataSetChanged();
    }

    class ItemGalleryViewHolder{
        public TextView city;
        public TextView temp0;
        public TextView temp1;
        public TextView temp2;
        public ImageView icon0;
        public ImageView icon1;
        public ImageView icon2;
    }

}
