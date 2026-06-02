package android.support.v4.view;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes.dex */
public final class MotionEventCompat {
    /* JADX INFO: renamed from: a */
    public static boolean m2528a(MotionEvent motionEvent, int i) {
        return (motionEvent.getSource() & i) == i;
    }
}
