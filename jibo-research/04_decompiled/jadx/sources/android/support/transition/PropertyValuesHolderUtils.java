package android.support.transition;

import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build;
import android.util.Property;

/* JADX INFO: loaded from: classes.dex */
class PropertyValuesHolderUtils {

    /* JADX INFO: renamed from: a */
    private static final PropertyValuesHolderUtilsImpl f1235a;

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f1235a = new PropertyValuesHolderUtilsApi21();
        } else {
            f1235a = new PropertyValuesHolderUtilsApi14();
        }
    }

    /* JADX INFO: renamed from: a */
    static PropertyValuesHolder m1184a(Property<?, PointF> property, Path path) {
        return f1235a.mo1185a(property, path);
    }
}
