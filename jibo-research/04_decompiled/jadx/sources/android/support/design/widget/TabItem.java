package android.support.design.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.design.R;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class TabItem extends View {

    /* JADX INFO: renamed from: a */
    final CharSequence f845a;

    /* JADX INFO: renamed from: b */
    final Drawable f846b;

    /* JADX INFO: renamed from: c */
    final int f847c;

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TintTypedArray tintTypedArrayM4954a = TintTypedArray.m4954a(context, attributeSet, R.styleable.TabItem);
        this.f845a = tintTypedArrayM4954a.m4965c(R.styleable.TabItem_android_text);
        this.f846b = tintTypedArrayM4954a.m4959a(R.styleable.TabItem_android_icon);
        this.f847c = tintTypedArrayM4954a.m4972g(R.styleable.TabItem_android_layout, 0);
        tintTypedArrayM4954a.m4960a();
    }
}
