package com.jibo.p019ui.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class PhotoViewerViewPager extends ViewPager {
    public PhotoViewerViewPager(Context context) {
        super(context);
    }

    public PhotoViewerViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.support.v4.view.ViewPager
    /* JADX INFO: renamed from: a */
    protected boolean mo2719a(View view, boolean z, int i, int i2, int i3) {
        return view instanceof TouchImageView ? ((TouchImageView) view).m11333a(-i) : super.mo2719a(view, z, i, i2, i3);
    }
}
