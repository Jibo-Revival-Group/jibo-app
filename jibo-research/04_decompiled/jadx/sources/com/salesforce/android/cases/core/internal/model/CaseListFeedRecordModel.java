package com.salesforce.android.cases.core.internal.model;

import com.salesforce.android.cases.core.internal.http.response.CaseListFeeds;
import com.salesforce.android.cases.core.model.CaseListFeedRecord;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class CaseListFeedRecordModel implements CaseListFeedRecord {

    /* JADX INFO: renamed from: a */
    private String f12454a;

    /* JADX INFO: renamed from: b */
    private String f12455b;

    /* JADX INFO: renamed from: c */
    private Date f12456c;

    CaseListFeedRecordModel(CaseListFeeds.CaseListFeedRecord caseListFeedRecord) {
        if (caseListFeedRecord == null) {
            throw new IllegalArgumentException("record cannot be null.");
        }
        this.f12454a = caseListFeedRecord.m12304a();
        this.f12455b = caseListFeedRecord.m12305b();
        this.f12456c = caseListFeedRecord.m12306c();
    }

    /* JADX INFO: renamed from: a */
    public static CaseListFeedRecordModel m12459a(CaseListFeeds.CaseListFeedRecord caseListFeedRecord) {
        return new CaseListFeedRecordModel(caseListFeedRecord);
    }

    @Override // com.salesforce.android.cases.core.model.CaseListFeedRecord
    /* JADX INFO: renamed from: a */
    public String mo12460a() {
        return this.f12454a;
    }

    @Override // com.salesforce.android.cases.core.model.CaseListFeedRecord
    /* JADX INFO: renamed from: b */
    public String mo12461b() {
        return this.f12455b;
    }

    @Override // com.salesforce.android.cases.core.model.CaseListFeedRecord
    /* JADX INFO: renamed from: c */
    public Date mo12462c() {
        return this.f12456c;
    }

    public boolean equals(Object obj) {
        boolean zEquals = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CaseListFeedRecordModel caseListFeedRecordModel = (CaseListFeedRecordModel) obj;
        if (this.f12454a != null) {
            if (!this.f12454a.equals(caseListFeedRecordModel.f12454a)) {
                return false;
            }
        } else if (caseListFeedRecordModel.f12454a != null) {
            return false;
        }
        if (this.f12455b != null) {
            if (!this.f12455b.equals(caseListFeedRecordModel.f12455b)) {
                return false;
            }
        } else if (caseListFeedRecordModel.f12455b != null) {
            return false;
        }
        if (this.f12456c != null) {
            zEquals = this.f12456c.equals(caseListFeedRecordModel.f12456c);
        } else if (caseListFeedRecordModel.f12456c != null) {
            zEquals = false;
        }
        return zEquals;
    }

    public int hashCode() {
        return (((this.f12455b != null ? this.f12455b.hashCode() : 0) + ((this.f12454a != null ? this.f12454a.hashCode() : 0) * 31)) * 31) + (this.f12456c != null ? this.f12456c.hashCode() : 0);
    }
}
