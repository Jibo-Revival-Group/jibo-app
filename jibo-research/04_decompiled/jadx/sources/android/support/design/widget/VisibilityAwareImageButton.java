package android.support.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

/* JADX INFO: loaded from: classes.dex */
class VisibilityAwareImageButton extends ImageButton {

    /* JADX INFO: renamed from: a */
    private int f979a;

    public VisibilityAwareImageButton(Context context) {
        this(context, null);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f979a = getVisibility();
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        m951a(i, true);
    }

    /* JADX INFO: renamed from: a */
    final void m951a(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.f979a = i;
        }
    }

    final int getUserSetVisibility() {
        return this.f979a;
    }
}
