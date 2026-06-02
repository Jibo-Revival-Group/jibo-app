package com.salesforce.android.service.common.p023ui.views;

import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;
import com.salesforce.android.service.common.p023ui.R;
import com.salesforce.android.service.common.utilities.spatial.Coordinate;

/* JADX INFO: loaded from: classes.dex */
public class SalesforceFloatingActionButton extends Button {

    /* JADX INFO: renamed from: a */
    private final int f13743a;

    /* JADX INFO: renamed from: b */
    private final int f13744b;

    /* JADX INFO: renamed from: c */
    private final int f13745c;

    /* JADX INFO: renamed from: d */
    private final int f13746d;

    /* JADX INFO: renamed from: e */
    private final Drawable f13747e;

    /* JADX INFO: renamed from: f */
    private final SalesforceFloatingActionButtonImpl f13748f;

    public SalesforceFloatingActionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SalesforceFloatingActionButton, 0, 0);
        try {
            this.f13743a = m14015a(typedArrayObtainStyledAttributes, R.styleable.SalesforceFloatingActionButton_salesforce_background_unselected, R.color.salesforce_contrast_primary);
            this.f13744b = m14015a(typedArrayObtainStyledAttributes, R.styleable.SalesforceFloatingActionButton_salesforce_background_selected, R.color.salesforce_feedback_primary);
            this.f13745c = m14015a(typedArrayObtainStyledAttributes, R.styleable.SalesforceFloatingActionButton_salesforce_src_color_unselected, R.color.salesforce_contrast_inverted);
            this.f13746d = m14015a(typedArrayObtainStyledAttributes, R.styleable.SalesforceFloatingActionButton_salesforce_src_color_selected, R.color.salesforce_brand_primary_inverted);
            this.f13747e = typedArrayObtainStyledAttributes.getDrawable(R.styleable.SalesforceFloatingActionButton_salesforce_src);
            typedArrayObtainStyledAttributes.recycle();
            this.f13748f = SalesforceFloatingActionButtonImpl.m14018a(this).m14028a(this.f13743a).m14031b(this.f13744b).m14029a(this.f13747e).m14033c(this.f13745c).m14034d(this.f13746d).m14030a();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    private int m14015a(TypedArray typedArray, int i, int i2) {
        return typedArray.getColor(i, ContextCompat.m1840c(getContext(), i2));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f13748f.m14022a(i, i2);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            Coordinate coordinateM14208a = Coordinate.m14208a((int) motionEvent.getX(), (int) motionEvent.getY());
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(this.f13748f.m14021a(coordinateM14208a), this.f13748f.m14026b(coordinateM14208a));
            animatorSet.start();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.f13748f.m14023a(canvas);
    }
}
