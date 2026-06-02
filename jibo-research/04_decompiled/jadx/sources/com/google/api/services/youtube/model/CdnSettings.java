package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes.dex */
public final class CdnSettings extends GenericJson {

    @Key
    private String format;

    @Key
    private String frameRate;

    @Key
    private IngestionInfo ingestionInfo;

    @Key
    private String ingestionType;

    @Key
    private String resolution;

    public String getFormat() {
        return this.format;
    }

    public CdnSettings setFormat(String str) {
        this.format = str;
        return this;
    }

    public String getFrameRate() {
        return this.frameRate;
    }

    public CdnSettings setFrameRate(String str) {
        this.frameRate = str;
        return this;
    }

    public IngestionInfo getIngestionInfo() {
        return this.ingestionInfo;
    }

    public CdnSettings setIngestionInfo(IngestionInfo ingestionInfo) {
        this.ingestionInfo = ingestionInfo;
        return this;
    }

    public String getIngestionType() {
        return this.ingestionType;
    }

    public CdnSettings setIngestionType(String str) {
        this.ingestionType = str;
        return this;
    }

    public String getResolution() {
        return this.resolution;
    }

    public CdnSettings setResolution(String str) {
        this.resolution = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public CdnSettings set(String str, Object obj) {
        return (CdnSettings) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public CdnSettings clone() {
        return (CdnSettings) super.clone();
    }
}
