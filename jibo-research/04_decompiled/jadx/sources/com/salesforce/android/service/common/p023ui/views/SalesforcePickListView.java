package com.salesforce.android.service.common.p023ui.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.salesforce.android.service.common.p023ui.R;
import com.salesforce.android.service.common.p023ui.internal.utils.ViewGroupHelper;

/* JADX INFO: loaded from: classes.dex */
public class SalesforcePickListView extends LinearLayout {

    /* JADX INFO: renamed from: a */
    private TextView f13790a;

    /* JADX INFO: renamed from: b */
    private Spinner f13791b;

    public SalesforcePickListView(Context context) {
        this(context, null);
    }

    public SalesforcePickListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SalesforcePickListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14036a(context, attributeSet, i);
    }

    public Spinner getSpinner() {
        return this.f13791b;
    }

    public TextView getLabelView() {
        return this.f13790a;
    }

    @Override // android.view.View
    public void setId(int i) {
        this.f13791b.setId(i);
    }

    public void setLabel(CharSequence charSequence) {
        this.f13790a.setText(charSequence);
    }

    public void setLabel(int i) {
        this.f13790a.setText(i);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        ViewGroupHelper.m14014a(this, z);
        super.setEnabled(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.f13791b.dispatchTouchEvent(motionEvent);
        return true;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        this.f13791b.setAdapter(spinnerAdapter);
    }

    public void setSelection(int i) {
        this.f13791b.setSelection(i);
    }

    public int getSelectedItemPosition() {
        return this.f13791b.getSelectedItemPosition();
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.f13791b.setOnItemSelectedListener(onItemSelectedListener);
    }

    /* JADX INFO: renamed from: a */
    private void m14036a(Context context, AttributeSet attributeSet, int i) {
        setOrientation(1);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.salesforce_input_minimum_height));
        setAddStatesFromChildren(true);
        LayoutInflater.from(context).inflate(R.layout.salesforce_pick_list_view, (ViewGroup) this, true);
        this.f13790a = (TextView) findViewById(R.id.pick_list_label);
        this.f13791b = (Spinner) findViewById(R.id.pick_list_spinner);
        this.f13791b.setFocusableInTouchMode(true);
        this.f13791b.setFocusable(true);
        ((ViewGroup) findViewById(R.id.pick_list_spinner_frame)).setAddStatesFromChildren(true);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SalesforcePickListView, i, 0);
        CharSequence text = typedArrayObtainStyledAttributes.getText(R.styleable.SalesforcePickListView_salesforce_label);
        if (!TextUtils.isEmpty(text)) {
            setLabel(text);
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
