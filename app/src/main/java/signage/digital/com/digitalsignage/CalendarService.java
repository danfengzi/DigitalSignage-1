package signage.digital.com.digitalsignage;

/**
 * Created by Alexandre on 08/11/2016.
 */

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract.Calendars;
import android.provider.CalendarContract.Events;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class CalendarService {

    // Default constructor
    public static ArrayList<CalendarEvent> readCalendar(Context context, String name) {
        return readCalendar(context, 1, 0, name);
    }

    public static ArrayList<CalendarEvent> readCalendar(Context context, int days, int hours, String name) {
        ArrayList<CalendarEvent> events = new ArrayList<CalendarEvent>();
        ContentResolver contentResolver = context.getContentResolver();


        final Cursor cCalendar = contentResolver.query(Uri.parse("content://com.android.calendar/calendars"),
                new String[]{ Calendars._ID, Calendars.NAME, Calendars.CALENDAR_DISPLAY_NAME }, Calendars.NAME + "='"+name+"'" ,
                null, null);
        int id=0;
        Log.d("Digital-->>","cursor count "+cCalendar.getCount());
        if(cCalendar.getCount() == 1) {
            cCalendar.moveToFirst();
            id = cCalendar.getInt(0);
        }

        final Cursor cursor = contentResolver.query(Uri.parse("content://com.android.calendar/events"),
                new String[]{Events.CALENDAR_ID, Events.TITLE, Events.DESCRIPTION, Events.EVENT_LOCATION, Events.DTSTART, Events.DTEND },
                null, null, null);

        Uri.Builder builder = Uri.parse("content://com.android.calendar/instances/when").buildUpon();
        long now = new Date().getTime();

        ContentUris.appendId(builder, now);
        ContentUris.appendId(builder, now);

        Cursor eventCursor = contentResolver.query(builder.build(),
            new String[]  {Events.TITLE, Events.DESCRIPTION, Events.EVENT_LOCATION, Events.DTSTART, Events.DTEND}, "calendar_id=" + id,
            null, "startDay ASC, startMinute ASC");

        if(eventCursor.getCount()>0) {
            eventCursor.moveToFirst();

            CalendarEvent ce = loadEvent(eventCursor);
            events.add(ce);

            while (eventCursor.moveToNext()) {
                ce = loadEvent(eventCursor);
                events.add(ce);
            }
        }
        cCalendar.close();
        eventCursor.close();
        cursor.close();
        return events;
    }

    private static CalendarEvent loadEvent(Cursor csr) {
        Log.d("-------","Evento "+csr.getString(0)+" "+csr.getString(2)+" "+csr.getString(3)+" "+csr.getString(4));
        return new CalendarEvent(csr.getString(0), csr.getString(2), csr.getString(3), csr.getString(4));
    }

    private static HashSet<String> getCalenderIds(Cursor cursor) {
        HashSet<String> calendarIds = new HashSet<String>();
        try {
            if(cursor.getCount() > 0) {

                while (cursor.moveToNext()) {
                    String _id = cursor.getString(0);
                    String displayName = cursor.getString(1);
                    calendarIds.add(_id);
                }
            }
        }

        catch(AssertionError ex) {
            ex.printStackTrace();
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        return calendarIds;
    }
}