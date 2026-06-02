package com.google.maps.model;

/* JADX INFO: loaded from: classes.dex */
public class SpeedLimit {
    public String placeId;
    public double speedLimit;

    public long speedLimitMph() {
        return Math.round(this.speedLimit * 0.621371d);
    }
}
