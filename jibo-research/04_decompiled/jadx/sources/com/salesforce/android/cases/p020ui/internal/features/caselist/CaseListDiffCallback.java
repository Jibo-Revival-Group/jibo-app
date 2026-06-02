package com.salesforce.android.cases.p020ui.internal.features.caselist;

import android.support.v7.util.DiffUtil;
import com.salesforce.android.cases.core.model.CaseListRecord;
import com.salesforce.android.cases.p020ui.internal.features.caselist.viewmodel.CaseListItemViewModel;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CaseListDiffCallback extends DiffUtil.Callback {

    /* JADX INFO: renamed from: a */
    private final ServiceLogger f12711a = ServiceLogging.m14203a((Class<?>) CaseListDiffCallback.class);

    /* JADX INFO: renamed from: b */
    private final List<CaseListItemViewModel> f12712b;

    /* JADX INFO: renamed from: c */
    private final List<CaseListItemViewModel> f12713c;

    public CaseListDiffCallback(List<CaseListItemViewModel> list, List<CaseListItemViewModel> list2) {
        this.f12712b = list;
        this.f12713c = list2;
    }

    @Override // android.support.v7.util.DiffUtil.Callback
    /* JADX INFO: renamed from: a */
    public int mo3447a() {
        return this.f12712b.size();
    }

    @Override // android.support.v7.util.DiffUtil.Callback
    /* JADX INFO: renamed from: b */
    public int mo3449b() {
        return this.f12713c.size();
    }

    @Override // android.support.v7.util.DiffUtil.Callback
    /* JADX INFO: renamed from: a */
    public boolean mo3448a(int i, int i2) {
        CaseListRecord caseListRecordM12919a = this.f12712b.get(i).m12919a();
        CaseListRecord caseListRecordM12919a2 = this.f12713c.get(i2).m12919a();
        boolean z = caseListRecordM12919a2.mo12466b() != null && caseListRecordM12919a2.mo12466b().equals(caseListRecordM12919a.mo12466b());
        this.f12711a.mo14189b("old {}, new {}, areItemsTheSame: {}", Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z));
        return z;
    }

    @Override // android.support.v7.util.DiffUtil.Callback
    /* JADX INFO: renamed from: b */
    public boolean mo3450b(int i, int i2) {
        boolean zEquals = this.f12713c.get(i2).equals(this.f12712b.get(i));
        if (!zEquals) {
            this.f12711a.mo14189b("Case List Contents Differ: old {}, new {}", Integer.valueOf(i), Integer.valueOf(i2));
        }
        return zEquals;
    }
}
