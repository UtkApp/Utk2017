package com.nitj.utkansh.utkansh_app;

/**
 * Created by Rishab on 12/3/2016.
 */

public class Clubs_set {
    private int image_id;
    private String clubs;

    public Clubs_set(int image_id, String clubs)
    {
        this.setClubs(clubs);
        this.setImage_id(image_id);
    }

    public String getClubs() {
        return clubs;
    }

    public void setClubs(String clubs) {
        this.clubs = clubs;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }
}
