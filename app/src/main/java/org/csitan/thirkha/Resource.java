package org.csitan.thirkha;

import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by lenovo on 4/11/15.
 */
public class Resource {
    public Resource(String temp, Double lat, Double lon) {
       this.lat= lat;
       this.lon = lon;
      this.type = temp;
    }
    public Resource(){}

    private int id;
    private String type;
    private double lat;
    private double lon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
