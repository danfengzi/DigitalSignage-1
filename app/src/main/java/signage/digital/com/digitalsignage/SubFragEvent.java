package signage.digital.com.digitalsignage;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class SubFragEvent extends Fragment {
    private ListView list;
    private ItemEventsAdapter eventsAdapter;
    private Runnable runnableCode;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        eventsAdapter = new ItemEventsAdapter(getContext(), new ArrayList<CalendarEvent>());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.sub_frag_event, container, false);
        list = (ListView)view.findViewById(R.id.list);
        list.setAdapter(eventsAdapter);

        final Handler handler = new Handler();
        runnableCode = new Runnable() {
            @Override
            public void run() {
                getEvents();
                handler.postDelayed(runnableCode, 10000);
            }
        };
        handler.post(runnableCode);

        return view;
    }

    private void getEvents(){
        eventsAdapter.update();
    }
}