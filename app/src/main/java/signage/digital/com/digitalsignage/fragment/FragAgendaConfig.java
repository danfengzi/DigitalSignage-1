package signage.digital.com.digitalsignage.fragment;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract.Calendars;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListView;

import java.util.ArrayList;

import signage.digital.com.digitalsignage.adapter.AgendaAdapter;
import signage.digital.com.digitalsignage.MyApp;
import signage.digital.com.digitalsignage.R;

public class FragAgendaConfig extends Fragment {

    private AgendaAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private ArrayList<String> getAgendas(){
        final ArrayList<String> arrayName = new ArrayList<String>();
        final ArrayList<Integer> arrayId = new ArrayList<Integer>();
        ContentResolver contentResolver = getActivity().getContentResolver();

        final Cursor cCalendar = contentResolver.query(Uri.parse("content://com.android.calendar/calendars"),
                new String[]{ Calendars._ID, Calendars.NAME, Calendars.CALENDAR_DISPLAY_NAME },
                null, null, null);
        if(cCalendar.getCount() > 0) {
            while (cCalendar.moveToNext()) {
                arrayName.add(cCalendar.getString(1));
                arrayId.add(cCalendar.getInt(0));
                Log.d("--------", "data "+cCalendar.getString(1));
            }

        }
        return arrayName;
    }


    @Override
    public void onResume(){
        super.onResume();
    }

    public void onPause(){
        super.onPause();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.frag_agenda, container, false);

        adapter = new AgendaAdapter(getContext(), getAgendas());
        adapter.setSelectedAgenda(MyApp.getInstance().getProfile().getCalendar_id());

        ListView list = (ListView)view.findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                MyApp.getInstance().getProfile().setCalendar_id((String)adapterView.getAdapter().getItem(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}