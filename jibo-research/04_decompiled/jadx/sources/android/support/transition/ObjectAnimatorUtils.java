package android.support.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build;
import android.util.Property;

/* JADX INFO: loaded from: classes.dex */
class ObjectAnimatorUtils {

    /* JADX INFO: renamed from: a */
    private static final ObjectAnimatorUtilsImpl f1225a;

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f1225a = new ObjectAnimatorUtilsApi21();
        } else {
            f1225a = new ObjectAnimatorUtilsApi14();
        }
    }

    /* JADX INFO: renamed from: a */
    static <T> ObjectAnimator m1178a(T t, Property<T, PointF> property, Path path) {
        return f1225a.mo1179a(t, property, path);
    }
}
