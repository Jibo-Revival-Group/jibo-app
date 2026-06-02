package com.salesforce.android.cases.core.internal.model;

import com.salesforce.android.cases.core.internal.http.response.QuickActionResponse;
import com.salesforce.android.cases.core.model.CaseField;
import com.salesforce.android.cases.core.model.CaseLayoutData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CaseLayoutDataModel implements CaseLayoutData {

    /* JADX INFO: renamed from: a */
    private String f12451a;

    /* JADX INFO: renamed from: b */
    private String f12452b;

    /* JADX INFO: renamed from: c */
    private List<CaseFieldModel> f12453c;

    public CaseLayoutDataModel(QuickActionResponse quickActionResponse) {
        if (quickActionResponse == null) {
            throw new IllegalStateException("QuickActionResponse cannot be null.");
        }
        this.f12451a = quickActionResponse.m12348c();
        this.f12452b = quickActionResponse.m12346a();
        this.f12453c = new ArrayList();
        Iterator<List<QuickActionResponse.LayoutItem>> it = quickActionResponse.m12347b().iterator();
        while (it.hasNext()) {
            for (QuickActionResponse.LayoutItem layoutItem : it.next()) {
                if (layoutItem != null) {
                    this.f12453c.add(new CaseFieldModel(layoutItem));
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static CaseLayoutDataModel m12457a(QuickActionResponse quickActionResponse) {
        return new CaseLayoutDataModel(quickActionResponse);
    }

    @Override // com.salesforce.android.cases.core.model.CaseLayoutData
    /* JADX INFO: renamed from: a */
    public List<? extends CaseField> mo12458a() {
        return this.f12453c;
    }
}
