package com.salesforce.android.service.common.p023ui.views;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.TextView;
import com.salesforce.android.service.common.p023ui.internal.text.SalesforceStyleHelper;

/* JADX INFO: loaded from: classes.dex */
public class SalesforceTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: b */
    private final SalesforceStyleHelper f13803b;

    public SalesforceTextView(Context context) {
        super(context);
        this.f13803b = null;
    }

    public SalesforceTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SalesforceTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13803b = SalesforceStyleHelper.m13998a(context, attributeSet);
        setTypeface(this.f13803b.m14004b());
        super.setText(this.f13803b.m14002a(getText()));
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (this.f13803b != null) {
            charSequence = this.f13803b.m14002a(charSequence);
        }
        super.setText(charSequence, bufferType);
    }
}
