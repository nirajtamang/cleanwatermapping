package org.csitan.thirkha;

import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by lenovo on 4/11/15.
 */
public class Resource {

    private String type;
   // private boolean drinkable;
    private LatLng latLang;

    public String getType() {
        return type;
    }

    public LatLng getLatLang() {
        return latLang;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLatLang(LatLng latLang) {
        this.latLang = latLang;
    }

    /* private double cod;
            //chemical oxygen demand

            private double dissOxy;
                //dissolve oxygen
            private double ph_value;
            private double bode;
            //biological oxygen demand
            private String description;

                */
    public void getResource()
    {

    }

    public void putData(LatLng latLng, String abc)
    {
        latLang = latLng;
        type = abc;


    }









}
