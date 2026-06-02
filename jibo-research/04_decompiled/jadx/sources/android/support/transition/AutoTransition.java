package android.support.transition;

import android.content.Context;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes.dex */
public class AutoTransition extends TransitionSet {
    public AutoTransition() {
        m1071q();
    }

    public AutoTransition(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m1071q();
    }

    /* JADX INFO: renamed from: q */
    private void m1071q() {
        m1262a(1);
        m1266b(new Fade(2)).m1266b(new ChangeBounds()).m1266b(new Fade(1));
    }
}
