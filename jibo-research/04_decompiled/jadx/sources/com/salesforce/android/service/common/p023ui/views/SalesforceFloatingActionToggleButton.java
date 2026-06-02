package com.salesforce.android.service.common.p023ui.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.CompoundButton;
import android.widget.ToggleButton;
import com.salesforce.android.service.common.p023ui.R;
import com.salesforce.android.service.common.utilities.spatial.Coordinate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SalesforceFloatingActionToggleButton extends ToggleButton implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a */
    List<CompoundButton.OnCheckedChangeListener> f13781a;

    /* JADX INFO: renamed from: b */
    private final int f13782b;

    /* JADX INFO: renamed from: c */
    private final int f13783c;

    /* JADX INFO: renamed from: d */
    private final int f13784d;

    /* JADX INFO: renamed from: e */
    private final int f13785e;

    /* JADX INFO: renamed from: f */
    private final Drawable f13786f;

    /* JADX INFO: renamed from: g */
    private final Drawable f13787g;

    /* JADX INFO: renamed from: h */
    private final SalesforceFloatingActionButtonImpl f13788h;

    /* JADX INFO: renamed from: i */
    private Coordinate f13789i;

    public SalesforceFloatingActionToggleButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13789i = Coordinate.m14208a(0, 0);
        setOnCheckedChangeListener(this);
        this.f13781a = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SalesforceFloatingActionToggleButton, 0, 0);
        try {
            this.f13782b = m14035a(typedArrayObtainStyledAttributes, R.styleable.f13663xd6e7343f, R.color.salesforce_contrast_primary);
            this.f13783c = m14035a(typedArrayObtainStyledAttributes, R.styleable.f13662xd5795138, R.color.salesforce_feedback_secondary);
            this.f13784d = m14035a(typedArrayObtainStyledAttributes, R.styleable.f13665xb58b0955, R.color.salesforce_contrast_inverted);
            this.f13785e = m14035a(typedArrayObtainStyledAttributes, R.styleable.f13664xd41b73ce, R.color.salesforce_brand_primary_inverted);
            this.f13786f = typedArrayObtainStyledAttributes.getDrawable(R.styleable.SalesforceFloatingActionToggleButton_salesforce_src_unchecked);
            this.f13787g = typedArrayObtainStyledAttributes.getDrawable(R.styleable.SalesforceFloatingActionToggleButton_salesforce_src_checked);
            typedArrayObtainStyledAttributes.recycle();
            this.f13788h = SalesforceFloatingActionButtonImpl.m14018a(this).m14028a(this.f13782b).m14031b(this.f13783c).m14029a(this.f13786f).m14033c(this.f13784d).m14032b(this.f13787g).m14034d(this.f13785e).m14030a();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    private int m14035a(TypedArray typedArray, int i, int i2) {
        return typedArray.getColor(i, ContextCompat.m1840c(getContext(), i2));
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.f13788h.m14021a(this.f13789i).start();
        } else {
            this.f13788h.m14026b(this.f13789i).start();
        }
        Iterator<CompoundButton.OnCheckedChangeListener> it = this.f13781a.iterator();
        while (it.hasNext()) {
            it.next().onCheckedChanged(compoundButton, z);
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (onCheckedChangeListener instanceof SalesforceFloatingActionToggleButton) {
            super.setOnCheckedChangeListener(onCheckedChangeListener);
        } else {
            this.f13781a.add(onCheckedChangeListener);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f13788h.m14022a(i, i2);
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f13789i = Coordinate.m14208a((int) motionEvent.getX(), (int) motionEvent.getY());
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.f13788h.m14023a(canvas);
    }
}
