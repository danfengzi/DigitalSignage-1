package signage.digital.com.digitalsignage;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Alexandre on 21/09/2016.
 */

public class Profile {
    private ArrayList<String> flyers = new ArrayList<String>();
    private ArrayList<String> banners = new ArrayList<String>();
    private String calendar_id = "";
    private boolean play =  false;

    public static final String  FLYERS = "flyers";
    public static final String  BANNERS = "banners";
    public static final String  CALENDAR_ID = "calendar_id";
    public static final String  PLAY = "play";

    public Profile(){
    }

    public Profile(Object O){
        HashMap<String, Object> o = (HashMap<String, Object>)O;
        this.flyers = (ArrayList<String>) o.get(FLYERS);
        this.calendar_id = (String)o.get(CALENDAR_ID);
        this.play = (boolean)o.get(PLAY);
    }

    public HashMap<String, Object> toMap(){
        HashMap<String, Object> o = new HashMap<>();
        o.put(FLYERS, this.flyers);
        o.put(CALENDAR_ID, this.calendar_id);
        o.put(PLAY, this.play);
        return o;
    }

    public ArrayList<String> getFlyers() {
        return flyers;
    }

    public ArrayList<String> getBanners() {
        return banners;
    }

    public String getCalendar_id() {
        return calendar_id;
    }

    public void setCalendar_id(String calendar_id) {
        this.calendar_id = calendar_id;
    }

    public boolean isPlay() {
        return play;
    }

    public void setPlay(boolean play) {
        this.play = play;
    }


}
