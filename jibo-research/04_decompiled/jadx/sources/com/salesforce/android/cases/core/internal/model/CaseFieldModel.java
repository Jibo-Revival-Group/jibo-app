package com.salesforce.android.cases.core.internal.model;

import com.salesforce.android.cases.core.internal.http.response.QuickActionResponse;
import com.salesforce.android.cases.core.internal.util.StringUtils;
import com.salesforce.android.cases.core.model.CaseField;
import com.salesforce.android.cases.core.model.CaseFieldType;
import com.salesforce.android.cases.core.model.PickListOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CaseFieldModel implements CaseField {

    /* JADX INFO: renamed from: a */
    private String f12442a;

    /* JADX INFO: renamed from: b */
    private String f12443b;

    /* JADX INFO: renamed from: c */
    private List<PickListOptionModel> f12444c;

    /* JADX INFO: renamed from: d */
    private boolean f12445d;

    /* JADX INFO: renamed from: e */
    private boolean f12446e;

    /* JADX INFO: renamed from: f */
    private boolean f12447f;

    /* JADX INFO: renamed from: g */
    private CaseFieldType f12448g;

    /* JADX INFO: renamed from: h */
    private int f12449h;

    /* JADX INFO: renamed from: i */
    private String f12450i;

    public CaseFieldModel(QuickActionResponse.LayoutItem layoutItem) {
        if (layoutItem == null || layoutItem.m12355a().isEmpty()) {
            throw new IllegalStateException("LayoutItem or its fields cannot be null or empty.");
        }
        QuickActionResponse.Field field = layoutItem.m12355a().get(0);
        this.f12442a = field.m12351c();
        this.f12443b = field.m12349a();
        this.f12445d = layoutItem.m12357c();
        this.f12446e = layoutItem.m12356b();
        this.f12448g = CaseFieldType.fromString(field.m12353e());
        this.f12449h = field.m12350b();
        this.f12450i = StringUtils.m12618c(field.m12354f());
        if (CaseFieldType.PICK_LIST == this.f12448g && field.m12352d().size() > 0) {
            this.f12444c = new ArrayList();
            Iterator<QuickActionResponse.PickListOption> it = field.m12352d().iterator();
            while (it.hasNext()) {
                this.f12444c.add(new PickListOptionModel(it.next()));
            }
        }
    }

    @Override // com.salesforce.android.cases.core.model.CaseField
    /* JADX INFO: renamed from: a */
    public String mo12446a() {
        return this.f12442a;
    }

    @Override // com.salesforce.android.cases.core.model.CaseField
    /* JADX INFO: renamed from: b */
    public String mo12449b() {
        return this.f12443b;
    }

    @Override // com.salesforce.android.cases.core.model.CaseField
    /* JADX INFO: renamed from: c */
    public List<? extends PickListOption> mo12450c() {
        return this.f12444c == null ? Collections.emptyList() : this.f12444c;
    }

    @Override // com.salesforce.android.cases.core.model.CaseField
    /* JADX INFO: renamed from: d */
    public boolean mo12451d() {
        return this.f12445d;
    }

    @Override // com.salesforce.android.cases.core.model.CaseField
    /* JADX INFO: renamed from: e */
    public boolean mo12452e() {
        return this.f12446e;
    }

    @Override // com.salesforce.android.cases.core.model.CaseField
    /* JADX INFO: renamed from: f */
    public CaseFieldType mo12453f() {
        return this.f12448g;
    }

    @Override // com.salesforce.android.cases.core.model.CaseField
    /* JADX INFO: renamed from: g */
    public int mo12454g() {
        return this.f12449h;
    }

    @Override // com.salesforce.android.cases.core.model.CaseField
    /* JADX INFO: renamed from: h */
    public String mo12455h() {
        return this.f12450i;
    }

    @Override // com.salesforce.android.cases.core.model.CaseField
    /* JADX INFO: renamed from: i */
    public boolean mo12456i() {
        return this.f12447f;
    }

    @Override // com.salesforce.android.cases.core.model.CaseField
    /* JADX INFO: renamed from: a */
    public void mo12448a(boolean z) {
        this.f12447f = z;
    }

    @Override // com.salesforce.android.cases.core.model.CaseField
    /* JADX INFO: renamed from: a */
    public void mo12447a(String str) {
        this.f12450i = str;
    }
}
