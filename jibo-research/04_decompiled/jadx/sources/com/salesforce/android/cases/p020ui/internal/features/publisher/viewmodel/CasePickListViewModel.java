package com.salesforce.android.cases.p020ui.internal.features.publisher.viewmodel;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import com.salesforce.android.cases.R;
import com.salesforce.android.cases.core.internal.util.StringUtils;
import com.salesforce.android.cases.core.model.CaseField;
import com.salesforce.android.cases.core.model.CaseFieldType;
import com.salesforce.android.cases.core.model.PickListOption;
import com.salesforce.android.cases.p020ui.internal.utils.ViewUtils;
import com.salesforce.android.service.common.p023ui.views.SalesforcePickListView;

/* JADX INFO: loaded from: classes.dex */
public class CasePickListViewModel implements AdapterView.OnItemSelectedListener, CaseFieldViewModel<SalesforcePickListView> {

    /* JADX INFO: renamed from: a */
    private SalesforcePickListView f12812a;

    /* JADX INFO: renamed from: b */
    private ArrayAdapter<? extends PickListOption> f12813b;

    /* JADX INFO: renamed from: c */
    private CaseField f12814c;

    /* JADX INFO: renamed from: d */
    private int f12815d;

    /* JADX INFO: renamed from: e */
    private boolean f12816e;

    public CasePickListViewModel(SalesforcePickListView salesforcePickListView, CaseField caseField) {
        int i = 0;
        this.f12815d = 0;
        if (caseField.mo12453f() != CaseFieldType.PICK_LIST) {
            throw new IllegalArgumentException("CaseField must be of type CaseFieldType.PICK_LIST.");
        }
        this.f12812a = salesforcePickListView;
        this.f12814c = caseField;
        salesforcePickListView.setId(caseField.mo12446a().hashCode());
        String strMo12449b = caseField.mo12449b();
        salesforcePickListView.setLabel(caseField.mo12451d() ? strMo12449b + "*" : strMo12449b);
        this.f12813b = new ArrayAdapter<>(salesforcePickListView.getContext(), R.layout.pick_list_item, caseField.mo12450c());
        this.f12813b.setDropDownViewResource(R.layout.pick_list_drop_down_item);
        salesforcePickListView.setAdapter(this.f12813b);
        String strMo12455h = caseField.mo12455h();
        if (StringUtils.m12617b(strMo12455h)) {
            while (true) {
                if (i >= caseField.mo12450c().size()) {
                    break;
                }
                if (!strMo12455h.equalsIgnoreCase(caseField.mo12450c().get(i).mo12506b())) {
                    i++;
                } else {
                    salesforcePickListView.setSelection(i);
                    this.f12815d = i;
                    break;
                }
            }
        }
        salesforcePickListView.setOnItemSelectedListener(this);
    }

    @Override // com.salesforce.android.cases.p020ui.internal.features.publisher.viewmodel.CaseFieldViewModel
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public SalesforcePickListView mo12990a() {
        return this.f12812a;
    }

    @Override // com.salesforce.android.cases.p020ui.internal.features.publisher.viewmodel.CaseFieldViewModel
    /* JADX INFO: renamed from: b */
    public boolean mo12991b() {
        return this.f12812a.isFocused();
    }

    @Override // com.salesforce.android.cases.p020ui.internal.features.publisher.viewmodel.CaseFieldViewModel
    /* JADX INFO: renamed from: c */
    public void mo12992c() {
        ViewUtils.m13064d(this.f12812a);
    }

    @Override // com.salesforce.android.cases.p020ui.internal.features.publisher.viewmodel.CaseFieldViewModel
    /* JADX INFO: renamed from: d */
    public CaseField mo12993d() {
        return this.f12814c;
    }

    @Override // com.salesforce.android.cases.p020ui.internal.features.publisher.viewmodel.CaseFieldViewModel
    /* JADX INFO: renamed from: e */
    public boolean mo12994e() {
        return true;
    }

    @Override // com.salesforce.android.cases.p020ui.internal.features.publisher.viewmodel.CaseFieldViewModel
    /* JADX INFO: renamed from: f */
    public String mo12995f() {
        PickListOption item = this.f12813b.getItem(this.f12812a.getSelectedItemPosition());
        return item != null ? item.mo12506b() : "";
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f12815d != i) {
            this.f12816e = true;
        }
        this.f12815d = i;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    @Override // com.salesforce.android.cases.p020ui.internal.features.publisher.viewmodel.CaseFieldViewModel
    /* JADX INFO: renamed from: g */
    public boolean mo12996g() {
        return this.f12816e;
    }
}
