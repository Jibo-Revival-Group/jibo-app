package com.salesforce.android.cases.core.internal.model;

import com.salesforce.android.cases.core.model.CaseListFeedRecord;
import com.salesforce.android.cases.core.model.CaseListRecord;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class CaseListRecordModel implements CaseListRecord {

    /* JADX INFO: renamed from: a */
    private String f12457a;

    /* JADX INFO: renamed from: b */
    private String f12458b;

    /* JADX INFO: renamed from: c */
    private String f12459c;

    /* JADX INFO: renamed from: d */
    private Date f12460d;

    /* JADX INFO: renamed from: e */
    private Date f12461e;

    /* JADX INFO: renamed from: f */
    private boolean f12462f;

    /* JADX INFO: renamed from: g */
    private boolean f12463g;

    /* JADX INFO: renamed from: h */
    private CaseListFeedRecordModel f12464h;

    CaseListRecordModel(com.salesforce.android.cases.core.internal.http.response.CaseListRecord caseListRecord) {
        if (caseListRecord == null) {
            throw new IllegalArgumentException("CaseListResponse.CaseListRecord cannot be null");
        }
        this.f12457a = caseListRecord.m12309c();
        this.f12458b = caseListRecord.m12307a();
        this.f12459c = caseListRecord.m12308b();
        this.f12460d = caseListRecord.m12310d();
        if (caseListRecord.m12312f() != null && caseListRecord.m12312f().m12303a().size() > 0) {
            this.f12464h = CaseListFeedRecordModel.m12459a(caseListRecord.m12312f().m12303a().get(0));
        }
        if (this.f12464h != null && this.f12464h.mo12462c() != null) {
            this.f12461e = this.f12464h.mo12462c();
        } else {
            this.f12461e = caseListRecord.m12311e();
        }
    }

    /* JADX INFO: renamed from: a */
    public static CaseListRecordModel m12463a(com.salesforce.android.cases.core.internal.http.response.CaseListRecord caseListRecord) {
        return new CaseListRecordModel(caseListRecord);
    }

    @Override // com.salesforce.android.cases.core.model.CaseListRecord
    /* JADX INFO: renamed from: a */
    public String mo12464a() {
        return this.f12457a;
    }

    @Override // com.salesforce.android.cases.core.model.CaseListRecord
    /* JADX INFO: renamed from: b */
    public String mo12466b() {
        return this.f12458b;
    }

    @Override // com.salesforce.android.cases.core.model.CaseListRecord
    /* JADX INFO: renamed from: c */
    public String mo12468c() {
        return this.f12459c;
    }

    @Override // com.salesforce.android.cases.core.model.CaseListRecord
    /* JADX INFO: renamed from: d */
    public Date mo12469d() {
        return this.f12461e;
    }

    @Override // com.salesforce.android.cases.core.model.CaseListRecord
    /* JADX INFO: renamed from: e */
    public boolean mo12470e() {
        return this.f12462f;
    }

    @Override // com.salesforce.android.cases.core.model.CaseListRecord
    /* JADX INFO: renamed from: a */
    public void mo12465a(boolean z) {
        this.f12462f = z;
    }

    @Override // com.salesforce.android.cases.core.model.CaseListRecord
    /* JADX INFO: renamed from: f */
    public boolean mo12471f() {
        return this.f12463g;
    }

    @Override // com.salesforce.android.cases.core.model.CaseListRecord
    /* JADX INFO: renamed from: b */
    public void mo12467b(boolean z) {
        this.f12463g = z;
    }

    @Override // com.salesforce.android.cases.core.model.CaseListRecord
    /* JADX INFO: renamed from: g */
    public CaseListFeedRecord mo12472g() {
        return this.f12464h;
    }

    public boolean equals(Object obj) {
        boolean zEquals = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CaseListRecordModel caseListRecordModel = (CaseListRecordModel) obj;
        if (this.f12462f != caseListRecordModel.f12462f || this.f12463g != caseListRecordModel.f12463g) {
            return false;
        }
        if (this.f12457a != null) {
            if (!this.f12457a.equals(caseListRecordModel.f12457a)) {
                return false;
            }
        } else if (caseListRecordModel.f12457a != null) {
            return false;
        }
        if (this.f12458b != null) {
            if (!this.f12458b.equals(caseListRecordModel.f12458b)) {
                return false;
            }
        } else if (caseListRecordModel.f12458b != null) {
            return false;
        }
        if (this.f12459c != null) {
            if (!this.f12459c.equals(caseListRecordModel.f12459c)) {
                return false;
            }
        } else if (caseListRecordModel.f12459c != null) {
            return false;
        }
        if (this.f12460d != null) {
            if (!this.f12460d.equals(caseListRecordModel.f12460d)) {
                return false;
            }
        } else if (caseListRecordModel.f12460d != null) {
            return false;
        }
        if (this.f12461e != null) {
            if (!this.f12461e.equals(caseListRecordModel.f12461e)) {
                return false;
            }
        } else if (caseListRecordModel.f12461e != null) {
            return false;
        }
        if (this.f12464h != null) {
            zEquals = this.f12464h.equals(caseListRecordModel.f12464h);
        } else if (caseListRecordModel.f12464h != null) {
            zEquals = false;
        }
        return zEquals;
    }

    public int hashCode() {
        return (((((this.f12462f ? 1 : 0) + (((this.f12461e != null ? this.f12461e.hashCode() : 0) + (((this.f12460d != null ? this.f12460d.hashCode() : 0) + (((this.f12459c != null ? this.f12459c.hashCode() : 0) + (((this.f12458b != null ? this.f12458b.hashCode() : 0) + ((this.f12457a != null ? this.f12457a.hashCode() : 0) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + (this.f12463g ? 1 : 0)) * 31) + (this.f12464h != null ? this.f12464h.hashCode() : 0);
    }
}
