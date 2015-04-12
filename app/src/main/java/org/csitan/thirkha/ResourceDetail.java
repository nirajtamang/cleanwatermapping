package org.csitan.thirkha;

/**
 * Created by lenovo on 4/12/15.
 */
public class ResourceDetail {
    private String popnDepend;
    private String sustan;
    private String effects;
    private String purpose;

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

    private String verne;
    private double lat;
    private double lon;
    private String type;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ResourceDetail() {
    }

    private String date;
    private String orgn_name;
    private int id;

    public String getPopnDepend() {
        return popnDepend;
    }

    public void setPopnDepend(String popnDepend) {
        this.popnDepend = popnDepend;
    }

    public String getSustan() {
        return sustan;
    }

    public void setSustan(String sustan) {
        this.sustan = sustan;
    }

    public String getEffects() {
        return effects;
    }

    public void setEffects(String effects) {
        this.effects = effects;
    }

    public String getVerne() {
        return verne;
    }

    public void setVerne(String verne) {
        this.verne = verne;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public ResourceDetail(String popnDepend, String sustan, String effects, String purpose, String verne, String date, String orgn_name, String type, double lat, double lon) {
        this.popnDepend = popnDepend;
        this.sustan = sustan;
        this.effects = effects;
        this.purpose = purpose;
        this.verne = verne;
        this.date = date;
        this.orgn_name = orgn_name;
        this.lat= lat;
        this.lon= lon;
    }

    public String getDate() {
        return date;

    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOrgn_name() {
        return orgn_name;
    }

    public void setOrgn_name(String orgn_name) {
        this.orgn_name = orgn_name;
    }
}
