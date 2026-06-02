package com.mixpanel.android.takeoverinapp;

import android.R;
import android.content.Context;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public class MiniCircleImageView extends ImageView {

    /* JADX INFO: renamed from: a */
    private Paint f12064a;

    /* JADX INFO: renamed from: b */
    private int f12065b;

    /* JADX INFO: renamed from: c */
    private int f12066c;

    public MiniCircleImageView(Context context) {
        super(context);
        m11990a();
    }

    public MiniCircleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11990a();
    }

    public MiniCircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11990a();
    }

    /* JADX INFO: renamed from: a */
    private void m11990a() {
        this.f12064a = new Paint(1);
        if (Build.VERSION.SDK_INT >= 23) {
            this.f12064a.setColor(getResources().getColor(R.color.white, null));
        } else {
            this.f12064a.setColor(getResources().getColor(R.color.white));
        }
        this.f12064a.setStyle(Paint.Style.STROKE);
        this.f12064a.setStrokeWidth(TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics()));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f12065b = i;
        this.f12066c = i2;
    }
}
