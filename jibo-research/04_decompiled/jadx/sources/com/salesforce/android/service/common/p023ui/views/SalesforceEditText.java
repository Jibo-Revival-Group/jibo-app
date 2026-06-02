package com.salesforce.android.service.common.p023ui.views;

import android.content.Context;
import android.support.design.widget.TextInputEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import com.salesforce.android.service.common.p023ui.R;
import com.salesforce.android.service.common.p023ui.internal.text.SalesforceStyleHelper;

/* JADX INFO: loaded from: classes.dex */
public class SalesforceEditText extends TextInputEditText {
    public SalesforceEditText(Context context) {
        super(context);
    }

    public SalesforceEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    public SalesforceEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        final SalesforceStyleHelper salesforceStyleHelperM13998a = SalesforceStyleHelper.m13998a(context, attributeSet);
        setTypeface(salesforceStyleHelperM13998a.m14004b());
        setText(salesforceStyleHelperM13998a.m14002a(getText()));
        addTextChangedListener(new TextWatcher() { // from class: com.salesforce.android.service.common.ui.views.SalesforceEditText.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                salesforceStyleHelperM13998a.m14002a(editable);
            }
        });
    }
}
