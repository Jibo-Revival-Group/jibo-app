package com.salesforce.android.cases.p020ui.internal.features.publisher.viewmodel;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import com.salesforce.android.cases.R;
import com.salesforce.android.cases.core.internal.util.StringUtils;
import com.salesforce.android.cases.core.model.CaseField;
import com.salesforce.android.cases.core.model.CaseFieldType;
import com.salesforce.android.cases.p020ui.internal.utils.ViewUtils;
import com.salesforce.android.service.common.p023ui.views.SalesforceTextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public class CaseTextInputViewModel implements TextWatcher, View.OnFocusChangeListener, CaseFieldViewModel<SalesforceTextInputLayout> {

    /* JADX INFO: renamed from: a */
    private SalesforceTextInputLayout f12817a;

    /* JADX INFO: renamed from: b */
    private EditText f12818b;

    /* JADX INFO: renamed from: c */
    private CaseField f12819c;

    /* JADX INFO: renamed from: d */
    private String f12820d;

    /* JADX INFO: renamed from: e */
    private boolean f12821e;

    public CaseTextInputViewModel(SalesforceTextInputLayout salesforceTextInputLayout, CaseField caseField) {
        this.f12820d = "";
        CaseFieldType caseFieldTypeMo12453f = caseField.mo12453f();
        if (caseFieldTypeMo12453f != CaseFieldType.TEXT && caseFieldTypeMo12453f != CaseFieldType.EMAIL && caseFieldTypeMo12453f != CaseFieldType.TEXT_AREA) {
            throw new IllegalArgumentException("CaseField must be of type CaseFieldType.TEXT, CaseFieldType.EMAIL or CaseFieldType.TEXT_AREA.");
        }
        this.f12817a = salesforceTextInputLayout;
        this.f12819c = caseField;
        String strMo12449b = caseField.mo12449b();
        salesforceTextInputLayout.setHint(caseField.mo12451d() ? strMo12449b + "*" : strMo12449b);
        salesforceTextInputLayout.setCounterMaxLength(caseField.mo12454g());
        this.f12818b = salesforceTextInputLayout.getEditText();
        this.f12818b.setId(caseField.mo12446a().hashCode());
        String strMo12455h = caseField.mo12455h();
        if (StringUtils.m12617b(strMo12455h)) {
            this.f12818b.setText(strMo12455h);
            this.f12820d = strMo12455h;
        }
        this.f12818b.setOnFocusChangeListener(this);
        this.f12818b.addTextChangedListener(this);
        if (CaseFieldType.EMAIL == caseField.mo12453f()) {
            this.f12818b.setInputType(209);
            this.f12818b.setMaxLines(1);
        } else if (CaseFieldType.TEXT_AREA == caseField.mo12453f()) {
            this.f12818b.setInputType(147457);
        } else {
            this.f12818b.setInputType(16385);
            this.f12818b.setMaxLines(1);
        }
    }

    @Override // com.salesforce.android.cases.p020ui.internal.features.publisher.viewmodel.CaseFieldViewModel
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public SalesforceTextInputLayout mo12990a() {
        return this.f12817a;
    }

    @Override // com.salesforce.android.cases.p020ui.internal.features.publisher.viewmodel.CaseFieldViewModel
    /* JADX INFO: renamed from: b */
    public boolean mo12991b() {
        return this.f12818b.isFocused();
    }

    @Override // com.salesforce.android.cases.p020ui.internal.features.publisher.viewmodel.CaseFieldViewModel
    /* JADX INFO: renamed from: c */
    public void mo12992c() {
        ViewUtils.m13064d(this.f12818b);
    }

    @Override // com.salesforce.android.cases.p020ui.internal.features.publisher.viewmodel.CaseFieldViewModel
    /* JADX INFO: renamed from: d */
    public CaseField mo12993d() {
        return this.f12819c;
    }

    @Override // com.salesforce.android.cases.p020ui.internal.features.publisher.viewmodel.CaseFieldViewModel
    /* JADX INFO: renamed from: e */
    public boolean mo12994e() {
        boolean zMo12451d = this.f12819c.mo12451d();
        String strMo12995f = mo12995f();
        Resources resources = this.f12818b.getResources();
        if (StringUtils.m12616a(strMo12995f)) {
            if (zMo12451d) {
                this.f12817a.setError(resources.getString(R.string.cases_validation_error_field_required_text, this.f12819c.mo12449b()));
                return false;
            }
        } else {
            if (CaseFieldType.EMAIL == this.f12819c.mo12453f() && !Patterns.EMAIL_ADDRESS.matcher(strMo12995f).matches()) {
                this.f12817a.setError(resources.getString(R.string.cases_validation_error_invalid_field_text, this.f12819c.mo12449b()));
                return false;
            }
            if (strMo12995f.length() > this.f12819c.mo12454g()) {
                this.f12817a.setError(resources.getString(R.string.cases_validation_error_length_invalid_text));
                return false;
            }
        }
        return true;
    }

    @Override // com.salesforce.android.cases.p020ui.internal.features.publisher.viewmodel.CaseFieldViewModel
    /* JADX INFO: renamed from: f */
    public String mo12995f() {
        return this.f12818b.getText().toString().trim();
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        this.f12817a.setCounterEnabled(z);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        CharSequence error = this.f12817a.getError();
        if (error != null && !StringUtils.m12616a(error.toString())) {
            this.f12817a.setError(null);
            this.f12817a.setErrorEnabled(false);
        }
        if (!this.f12820d.equals(editable.toString())) {
            this.f12821e = true;
        }
        this.f12820d = editable.toString();
    }

    @Override // com.salesforce.android.cases.p020ui.internal.features.publisher.viewmodel.CaseFieldViewModel
    /* JADX INFO: renamed from: g */
    public boolean mo12996g() {
        return this.f12821e;
    }
}
