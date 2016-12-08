package signage.digital.com.digitalsignage;

import android.app.Application;
import android.content.Context;

import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by Alexandre on 19/09/2016.
 */
public class MyApp extends Application {
    private static MyApp ourInstance = new MyApp();
    private Profile profile;
    private Context context;
    private ArrayList<CalendarEvent> events;

    public static MyApp getInstance() {
        return ourInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if(profile==null)
            profile = new Profile();
        if(events==null)
            events = CalendarService.readCalendar(context,1,0, MyApp.getInstance().getProfile().getCalendar_id());
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        if(profile==null)
            this.profile = new Profile();
        this.profile = profile;
    }

    public ArrayList<CalendarEvent> getEvents(){
        return events;
    }

    public ArrayList<CalendarEvent> updateEvents(){
        events = CalendarService.readCalendar(context,1,0, MyApp.getInstance().getProfile().getCalendar_id());
        return events;
    }

}