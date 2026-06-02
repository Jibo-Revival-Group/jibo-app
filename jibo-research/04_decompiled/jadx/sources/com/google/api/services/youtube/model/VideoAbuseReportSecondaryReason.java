package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes.dex */
public final class VideoAbuseReportSecondaryReason extends GenericJson {

    /* JADX INFO: renamed from: id */
    @Key
    private String f8515id;

    @Key
    private String label;

    public String getId() {
        return this.f8515id;
    }

    public VideoAbuseReportSecondaryReason setId(String str) {
        this.f8515id = str;
        return this;
    }

    public String getLabel() {
        return this.label;
    }

    public VideoAbuseReportSecondaryReason setLabel(String str) {
        this.label = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public VideoAbuseReportSecondaryReason set(String str, Object obj) {
        return (VideoAbuseReportSecondaryReason) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public VideoAbuseReportSecondaryReason clone() {
        return (VideoAbuseReportSecondaryReason) super.clone();
    }
}
