package android.support.design.widget;

import android.graphics.Outline;

/* JADX INFO: loaded from: classes.dex */
class CircularBorderDrawableLollipop extends CircularBorderDrawable {
    CircularBorderDrawableLollipop() {
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        copyBounds(this.f584b);
        outline.setOval(this.f584b);
    }
}
