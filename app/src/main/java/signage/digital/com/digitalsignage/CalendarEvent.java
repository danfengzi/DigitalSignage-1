package signage.digital.com.digitalsignage;

/**
 * Created by Alexandre on 08/11/2016.
 */

public class CalendarEvent{

    private String title;
    private String start;
    private String end;

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    private String room;

    public CalendarEvent() {

    }

    public CalendarEvent(String title, String room, String start, String end) {
        this.title = title;
        this.room = room;
        this.start = start;
        this.end = end;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }
}