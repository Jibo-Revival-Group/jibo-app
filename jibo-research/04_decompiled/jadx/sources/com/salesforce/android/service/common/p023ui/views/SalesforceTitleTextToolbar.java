package com.salesforce.android.service.common.p023ui.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.salesforce.android.service.common.p023ui.R;

/* JADX INFO: loaded from: classes.dex */
public class SalesforceTitleTextToolbar extends Toolbar {

    /* JADX INFO: renamed from: a */
    private SalesforceTextView f13804a;

    public SalesforceTitleTextToolbar(Context context) {
        this(context, null);
    }

    public SalesforceTitleTextToolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.toolbarStyle);
    }

    public SalesforceTitleTextToolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14052a(context, attributeSet, i);
    }

    public void setTitleText(CharSequence charSequence) {
        this.f13804a.setText(charSequence);
    }

    public void setTitleText(int i) {
        this.f13804a.setText(i);
    }

    /* JADX INFO: renamed from: a */
    private void m14052a(Context context, AttributeSet attributeSet, int i) {
        LayoutInflater.from(getContext()).inflate(R.layout.salesforce_toolbar_title_text_view, (ViewGroup) this, true);
        this.f13804a = (SalesforceTextView) findViewById(R.id.salesforce_toolbar_title);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SalesforceTitleTextToolbar, i, 0);
        CharSequence text = typedArrayObtainStyledAttributes.getText(R.styleable.SalesforceTitleTextToolbar_salesforce_title_text);
        if (!TextUtils.isEmpty(text)) {
            setTitleText(text);
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
