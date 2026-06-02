package com.salesforce.android.service.common.p023ui.views;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;
import com.salesforce.android.service.common.p023ui.R;

/* JADX INFO: loaded from: classes.dex */
public class SalesforceTextInputLayout extends TextInputLayout {

    /* JADX INFO: renamed from: e */
    private EditText f13802e;

    public SalesforceTextInputLayout(Context context) {
        this(context, null);
    }

    public SalesforceTextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.salesforceTextInputLayoutStyle);
    }

    public SalesforceTextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14051a();
    }

    @Override // android.support.design.widget.TextInputLayout
    public EditText getEditText() {
        return this.f13802e;
    }

    /* JADX INFO: renamed from: a */
    private void m14051a() {
        LayoutInflater.from(getContext()).inflate(R.layout.salesforce_text_input_layout_edit_text, (ViewGroup) this, true);
        this.f13802e = (EditText) findViewById(R.id.text_input_layout_edit_text);
    }

    @Override // android.support.design.widget.TextInputLayout
    public void setHint(CharSequence charSequence) {
        super.setHint(charSequence);
        if (this.f13802e != null) {
            this.f13802e.setHint(charSequence);
        }
    }
}
