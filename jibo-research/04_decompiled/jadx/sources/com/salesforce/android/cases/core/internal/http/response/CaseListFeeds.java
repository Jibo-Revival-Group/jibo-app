package com.salesforce.android.cases.core.internal.http.response;

import com.google.gson.annotations.SerializedName;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CaseListFeeds {

    @SerializedName(m9428a = "records")
    private List<CaseListFeedRecord> records;

    /* JADX INFO: renamed from: a */
    public List<CaseListFeedRecord> m12303a() {
        return this.records == null ? Collections.emptyList() : Collections.unmodifiableList(this.records);
    }

    public class CaseListFeedRecord {

        @SerializedName(m9428a = "Body")
        private String body;

        @SerializedName(m9428a = "CreatedById")
        private String createdById;

        @SerializedName(m9428a = "LastModifiedDate")
        private Date lastModifiedDate;

        /* JADX INFO: renamed from: a */
        public String m12304a() {
            return this.body;
        }

        /* JADX INFO: renamed from: b */
        public String m12305b() {
            return this.createdById;
        }

        /* JADX INFO: renamed from: c */
        public Date m12306c() {
            return this.lastModifiedDate;
        }
    }
}
