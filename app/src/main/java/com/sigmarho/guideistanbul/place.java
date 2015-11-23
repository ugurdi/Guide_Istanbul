package com.sigmarho.guideistanbul;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by ugur on 11/16/15.
 */
public class place {

    LatLng latlon;
    String title;
    String basDesc;
    String detDesc;
    int[] pics;


    public place(LatLng latlon, String title, String basDesc, String detDesc, int[] pics) {
        this.latlon = latlon;
        this.title = title;
        this.basDesc = basDesc;
        this.detDesc = detDesc;
        this.pics = pics;
    }

    public LatLng getLatlon() {
        return latlon;
    }

    public void setLatlon(LatLng latlon) {
        this.latlon = latlon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBasDesc() {
        return basDesc;
    }

    public void setBasDesc(String basDesc) {
        this.basDesc = basDesc;
    }

    public String getDetDesc() {
        return detDesc;
    }

    public void setDetDesc(String detDesc) {
        this.detDesc = detDesc;
    }

    public int[] getPics() {
        return pics;
    }

    public void setPics(int[] pics) {
        this.pics = pics;
    }
}