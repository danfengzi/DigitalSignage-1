package signage.digital.com.digitalsignage.model;

import java.util.ArrayList;

/**
 * Created by everest on 24/05/2017.
 */

public class Screen {
    private String id;
    private String description;
    private ArrayList<String> flyers = new ArrayList<String>();
    private ArrayList<String> banners = new ArrayList<String>();
    private String calendar_id = "";
    private boolean play = false;

    public Screen(){ }

    public String getCalendar_id() {
        return calendar_id;
    }

    public void setCalendar_id(String calendar_id) {
        this.calendar_id = calendar_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getFlyers() {
        return flyers;
    }

    public void setFlyers(ArrayList<String> flyers) {
        this.flyers = flyers;
    }

    public ArrayList<String> getBanners() {
        return banners;
    }

    public void setBanners(ArrayList<String> banners) {
        this.banners = banners;
    }

    public boolean isPlay() {
        return play;
    }

    public void setPlay(boolean play) {
        this.play = play;
    }
}
