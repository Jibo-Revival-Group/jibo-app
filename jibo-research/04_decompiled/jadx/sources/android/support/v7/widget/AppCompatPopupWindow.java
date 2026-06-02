package android.support.v7.widget;

import android.content.Context;
import android.os.Build;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;

/* JADX INFO: loaded from: classes.dex */
class AppCompatPopupWindow extends PopupWindow {

    /* JADX INFO: renamed from: a */
    private static final boolean f3692a;

    /* JADX INFO: renamed from: b */
    private boolean f3693b;

    static {
        f3692a = Build.VERSION.SDK_INT < 21;
    }

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3901a(context, attributeSet, i, 0);
    }

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m3901a(context, attributeSet, i, i2);
    }

    /* JADX INFO: renamed from: a */
    private void m3901a(Context context, AttributeSet attributeSet, int i, int i2) {
        TintTypedArray tintTypedArrayM4955a = TintTypedArray.m4955a(context, attributeSet, R.styleable.PopupWindow, i, i2);
        if (tintTypedArrayM4955a.m4973g(R.styleable.PopupWindow_overlapAnchor)) {
            m3902a(tintTypedArrayM4955a.m4961a(R.styleable.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(tintTypedArrayM4955a.m4959a(R.styleable.PopupWindow_android_popupBackground));
        tintTypedArrayM4955a.m4960a();
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2) {
        if (f3692a && this.f3693b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (f3692a && this.f3693b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i, int i2, int i3, int i4) {
        super.update(view, i, (f3692a && this.f3693b) ? i2 - view.getHeight() : i2, i3, i4);
    }

    /* JADX INFO: renamed from: a */
    private void m3902a(boolean z) {
        if (f3692a) {
            this.f3693b = z;
        } else {
            PopupWindowCompat.m3062a(this, z);
        }
    }
}
