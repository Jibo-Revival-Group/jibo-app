package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class VideoAbuseReportReasonSnippet extends GenericJson {

    @Key
    private String label;

    @Key
    private List<VideoAbuseReportSecondaryReason> secondaryReasons;

    public String getLabel() {
        return this.label;
    }

    public VideoAbuseReportReasonSnippet setLabel(String str) {
        this.label = str;
        return this;
    }

    public List<VideoAbuseReportSecondaryReason> getSecondaryReasons() {
        return this.secondaryReasons;
    }

    public VideoAbuseReportReasonSnippet setSecondaryReasons(List<VideoAbuseReportSecondaryReason> list) {
        this.secondaryReasons = list;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public VideoAbuseReportReasonSnippet set(String str, Object obj) {
        return (VideoAbuseReportReasonSnippet) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public VideoAbuseReportReasonSnippet clone() {
        return (VideoAbuseReportReasonSnippet) super.clone();
    }
}
