package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
class ActionBarBackgroundDrawable extends Drawable {

    /* JADX INFO: renamed from: a */
    final ActionBarContainer f3471a;

    public ActionBarBackgroundDrawable(ActionBarContainer actionBarContainer) {
        this.f3471a = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f3471a.f3475d) {
            if (this.f3471a.f3474c != null) {
                this.f3471a.f3474c.draw(canvas);
            }
        } else {
            if (this.f3471a.f3472a != null) {
                this.f3471a.f3472a.draw(canvas);
            }
            if (this.f3471a.f3473b != null && this.f3471a.f3476e) {
                this.f3471a.f3473b.draw(canvas);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }
}
