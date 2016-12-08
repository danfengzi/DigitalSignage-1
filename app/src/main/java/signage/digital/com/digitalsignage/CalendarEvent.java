package signage.digital.com.digitalsignage;

/**
 * Created by Alexandre on 08/11/2016.
 */

public class CalendarEvent{

    private String title;

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    private String room;

    public CalendarEvent() {

    }

    public CalendarEvent(String title, String room) {
        this.title = title;
        this.room = room;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}