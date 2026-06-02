package android.support.design.widget;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class DrawableUtils {

    /* JADX INFO: renamed from: a */
    private static Method f715a;

    /* JADX INFO: renamed from: b */
    private static boolean f716b;

    /* JADX INFO: renamed from: a */
    static boolean m712a(DrawableContainer drawableContainer, Drawable.ConstantState constantState) {
        return m713b(drawableContainer, constantState);
    }

    /* JADX INFO: renamed from: b */
    private static boolean m713b(DrawableContainer drawableContainer, Drawable.ConstantState constantState) {
        if (!f716b) {
            try {
                f715a = DrawableContainer.class.getDeclaredMethod("setConstantState", DrawableContainer.DrawableContainerState.class);
                f715a.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.e("DrawableUtils", "Could not fetch setConstantState(). Oh well.");
            }
            f716b = true;
        }
        if (f715a != null) {
            try {
                f715a.invoke(drawableContainer, constantState);
                return true;
            } catch (Exception e2) {
                Log.e("DrawableUtils", "Could not invoke setConstantState(). Oh well.");
            }
        }
        return false;
    }
}
