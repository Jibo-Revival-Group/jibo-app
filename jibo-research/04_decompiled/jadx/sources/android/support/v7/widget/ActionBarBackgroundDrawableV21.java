package android.support.v7.widget;

import android.graphics.Outline;

/* JADX INFO: loaded from: classes.dex */
class ActionBarBackgroundDrawableV21 extends ActionBarBackgroundDrawable {
    public ActionBarBackgroundDrawableV21(ActionBarContainer actionBarContainer) {
        super(actionBarContainer);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.f3471a.f3475d) {
            if (this.f3471a.f3474c != null) {
                this.f3471a.f3474c.getOutline(outline);
            }
        } else if (this.f3471a.f3472a != null) {
            this.f3471a.f3472a.getOutline(outline);
        }
    }
}
