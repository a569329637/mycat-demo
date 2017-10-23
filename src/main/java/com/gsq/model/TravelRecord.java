package com.gsq.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class TravelRecord implements Serializable {

    private int id;
    private String placeName;
    private Timestamp travelTime;

    public TravelRecord() {
    }

    public TravelRecord(int id, String placeName, Timestamp travelTime) {
        this.id = id;
        this.placeName = placeName;
        this.travelTime = travelTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public Timestamp getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(Timestamp travelTime) {
        this.travelTime = travelTime;
    }

    @Override
    public String toString() {
        return "TravelRecord{" +
                "id=" + id +
                ", placeName='" + placeName + '\'' +
                ", travelTime=" + travelTime +
                '}';
    }
}
