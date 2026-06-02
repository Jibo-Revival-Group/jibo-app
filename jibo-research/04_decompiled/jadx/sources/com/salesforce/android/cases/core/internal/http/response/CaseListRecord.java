package com.salesforce.android.cases.core.internal.http.response;

import com.google.gson.annotations.SerializedName;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class CaseListRecord {

    @SerializedName(m9428a = "CaseNumber")
    private String caseNumber;

    @SerializedName(m9428a = "CreatedDate")
    private Date createdDate;

    @SerializedName(m9428a = "Feeds")
    private CaseListFeeds feeds;

    /* JADX INFO: renamed from: id */
    @SerializedName(m9428a = "Id")
    private String f12320id;

    @SerializedName(m9428a = "LastModifiedDate")
    private Date lastModifiedDate;

    @SerializedName(m9428a = "Subject")
    private String subject;

    /* JADX INFO: renamed from: a */
    public String m12307a() {
        return this.f12320id;
    }

    /* JADX INFO: renamed from: b */
    public String m12308b() {
        return this.caseNumber;
    }

    /* JADX INFO: renamed from: c */
    public String m12309c() {
        return this.subject;
    }

    /* JADX INFO: renamed from: d */
    public Date m12310d() {
        return this.createdDate;
    }

    /* JADX INFO: renamed from: e */
    public Date m12311e() {
        return this.lastModifiedDate;
    }

    /* JADX INFO: renamed from: f */
    public CaseListFeeds m12312f() {
        return this.feeds;
    }
}
