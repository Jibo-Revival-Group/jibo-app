package com.salesforce.android.service.common.p023ui.views;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.widget.TextView;
import com.salesforce.android.service.common.p023ui.R;
import com.salesforce.android.service.common.p023ui.internal.text.SalesforceStyleHelper;

/* JADX INFO: loaded from: classes.dex */
public class SalesforceButton extends AppCompatButton {

    /* JADX INFO: renamed from: b */
    private final SalesforceStyleHelper f13740b;

    public SalesforceButton(Context context) {
        super(context);
        this.f13740b = null;
    }

    public SalesforceButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyle);
    }

    public SalesforceButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13740b = SalesforceStyleHelper.m13998a(context, attributeSet);
        setTypeface(this.f13740b.m14004b());
        super.setText(this.f13740b.m14002a(getText()));
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (this.f13740b != null) {
            charSequence = this.f13740b.m14002a(charSequence);
        }
        super.setText(charSequence, bufferType);
    }
}
