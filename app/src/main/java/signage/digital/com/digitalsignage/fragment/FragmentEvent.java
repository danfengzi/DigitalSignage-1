package signage.digital.com.digitalsignage.fragment;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import signage.digital.com.digitalsignage.Eventm;
import signage.digital.com.digitalsignage.LayoutHandler;
import signage.digital.com.digitalsignage.R;
import signage.digital.com.digitalsignage.WeatherView;
import signage.digital.com.digitalsignage.databinding.FragmentEventBinding;

public class FragmentEvent extends Fragment {
    private ArrayList<WeatherView> listW;
    private ObservableArrayList events = new ObservableArrayList();
    private static String TAG="FragmentEvent: ---> ";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentEventBinding binding = DataBindingUtil.setContentView(getActivity(), R.layout.fragment_event);
        events.add(new Eventm("teste","teste"));
        binding.setEntries(events);
        binding.setHandler(new LayoutHandler());
        View view =  binding.getRoot();

        return view;
    }

}