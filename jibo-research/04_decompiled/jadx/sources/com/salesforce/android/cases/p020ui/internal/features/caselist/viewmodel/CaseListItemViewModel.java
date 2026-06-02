package com.salesforce.android.cases.p020ui.internal.features.caselist.viewmodel;

import android.content.Context;
import android.text.format.DateUtils;
import com.salesforce.android.cases.R;
import com.salesforce.android.cases.core.model.CaseListRecord;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class CaseListItemViewModel {

    /* JADX INFO: renamed from: a */
    private Context f12765a;

    /* JADX INFO: renamed from: b */
    private CaseListRecord f12766b;

    /* JADX INFO: renamed from: c */
    private boolean f12767c;

    /* JADX INFO: renamed from: d */
    private String f12768d;

    /* JADX INFO: renamed from: e */
    private String f12769e;

    /* JADX INFO: renamed from: f */
    private String f12770f;

    /* JADX INFO: renamed from: g */
    private Date f12771g;

    public CaseListItemViewModel(Context context, CaseListRecord caseListRecord) {
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null.");
        }
        if (caseListRecord == null) {
            throw new IllegalArgumentException("CaseListRecord cannot be null.");
        }
        this.f12765a = context;
        this.f12766b = caseListRecord;
        this.f12767c = caseListRecord.mo12470e();
        this.f12768d = caseListRecord.mo12466b();
        this.f12769e = caseListRecord.mo12464a() != null ? caseListRecord.mo12464a() : caseListRecord.mo12468c();
        this.f12771g = caseListRecord.mo12469d();
        if (caseListRecord.mo12472g() != null) {
            this.f12770f = caseListRecord.mo12472g().mo12460a();
        }
    }

    /* JADX INFO: renamed from: a */
    public CaseListRecord m12919a() {
        return this.f12766b;
    }

    /* JADX INFO: renamed from: b */
    public boolean m12921b() {
        return this.f12767c;
    }

    /* JADX INFO: renamed from: a */
    public void m12920a(boolean z) {
        this.f12766b.mo12465a(z);
        this.f12767c = z;
    }

    /* JADX INFO: renamed from: c */
    public String m12922c() {
        return this.f12768d;
    }

    /* JADX INFO: renamed from: d */
    public String m12923d() {
        if (this.f12771g == null) {
            return null;
        }
        long time = this.f12771g.getTime();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - time <= 60000) {
            return this.f12765a.getString(R.string.cases_timestamp_just_now_text);
        }
        return DateUtils.getRelativeTimeSpanString(time, jCurrentTimeMillis, 60000L).toString();
    }

    /* JADX INFO: renamed from: e */
    public String m12924e() {
        return this.f12769e;
    }

    /* JADX INFO: renamed from: f */
    public String m12925f() {
        return this.f12770f;
    }

    /* JADX INFO: renamed from: g */
    public Date m12926g() {
        return this.f12771g;
    }

    public boolean equals(Object obj) {
        boolean zEquals = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CaseListItemViewModel caseListItemViewModel = (CaseListItemViewModel) obj;
        if (this.f12767c != caseListItemViewModel.f12767c) {
            return false;
        }
        if (this.f12766b != null) {
            if (!this.f12766b.equals(caseListItemViewModel.f12766b)) {
                return false;
            }
        } else if (caseListItemViewModel.f12766b != null) {
            return false;
        }
        if (this.f12768d != null) {
            if (!this.f12768d.equals(caseListItemViewModel.f12768d)) {
                return false;
            }
        } else if (caseListItemViewModel.f12768d != null) {
            return false;
        }
        if (this.f12769e != null) {
            if (!this.f12769e.equals(caseListItemViewModel.f12769e)) {
                return false;
            }
        } else if (caseListItemViewModel.f12769e != null) {
            return false;
        }
        if (this.f12770f != null) {
            if (!this.f12770f.equals(caseListItemViewModel.f12770f)) {
                return false;
            }
        } else if (caseListItemViewModel.f12770f != null) {
            return false;
        }
        if (this.f12771g != null) {
            zEquals = this.f12771g.equals(caseListItemViewModel.f12771g);
        } else if (caseListItemViewModel.f12771g != null) {
            zEquals = false;
        }
        return zEquals;
    }

    public int hashCode() {
        return (((this.f12770f != null ? this.f12770f.hashCode() : 0) + (((this.f12769e != null ? this.f12769e.hashCode() : 0) + (((this.f12768d != null ? this.f12768d.hashCode() : 0) + (((this.f12767c ? 1 : 0) + ((this.f12766b != null ? this.f12766b.hashCode() : 0) * 31)) * 31)) * 31)) * 31)) * 31) + (this.f12771g != null ? this.f12771g.hashCode() : 0);
    }
}
