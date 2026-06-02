package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes.dex */
public final class VideoAgeGating extends GenericJson {

    @Key
    private Boolean alcoholContent;

    @Key
    private Boolean restricted;

    @Key
    private String videoGameRating;

    public Boolean getAlcoholContent() {
        return this.alcoholContent;
    }

    public VideoAgeGating setAlcoholContent(Boolean bool) {
        this.alcoholContent = bool;
        return this;
    }

    public Boolean getRestricted() {
        return this.restricted;
    }

    public VideoAgeGating setRestricted(Boolean bool) {
        this.restricted = bool;
        return this;
    }

    public String getVideoGameRating() {
        return this.videoGameRating;
    }

    public VideoAgeGating setVideoGameRating(String str) {
        this.videoGameRating = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public VideoAgeGating set(String str, Object obj) {
        return (VideoAgeGating) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public VideoAgeGating clone() {
        return (VideoAgeGating) super.clone();
    }
}
