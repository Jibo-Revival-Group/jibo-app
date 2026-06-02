package android.support.transition;

import android.animation.LayoutTransition;
import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class ViewGroupUtilsApi14 implements ViewGroupUtilsImpl {

    /* JADX INFO: renamed from: a */
    private static LayoutTransition f1341a;

    /* JADX INFO: renamed from: b */
    private static Field f1342b;

    /* JADX INFO: renamed from: c */
    private static boolean f1343c;

    /* JADX INFO: renamed from: d */
    private static Method f1344d;

    /* JADX INFO: renamed from: e */
    private static boolean f1345e;

    ViewGroupUtilsApi14() {
    }

    @Override // android.support.transition.ViewGroupUtilsImpl
    /* JADX INFO: renamed from: a */
    public ViewGroupOverlayImpl mo1286a(ViewGroup viewGroup) {
        return ViewGroupOverlayApi14.m1278a(viewGroup);
    }

    @Override // android.support.transition.ViewGroupUtilsImpl
    /* JADX INFO: renamed from: a */
    public void mo1287a(ViewGroup viewGroup, boolean z) {
        boolean z2 = false;
        if (f1341a == null) {
            f1341a = new LayoutTransition() { // from class: android.support.transition.ViewGroupUtilsApi14.1
                @Override // android.animation.LayoutTransition
                public boolean isChangingLayout() {
                    return true;
                }
            };
            f1341a.setAnimator(2, null);
            f1341a.setAnimator(0, null);
            f1341a.setAnimator(1, null);
            f1341a.setAnimator(3, null);
            f1341a.setAnimator(4, null);
        }
        if (z) {
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null) {
                if (layoutTransition.isRunning()) {
                    m1285a(layoutTransition);
                }
                if (layoutTransition != f1341a) {
                    viewGroup.setTag(R.id.transition_layout_save, layoutTransition);
                }
            }
            viewGroup.setLayoutTransition(f1341a);
            return;
        }
        viewGroup.setLayoutTransition(null);
        if (!f1343c) {
            try {
                f1342b = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
                f1342b.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.i("ViewGroupUtilsApi14", "Failed to access mLayoutSuppressed field by reflection");
            }
            f1343c = true;
        }
        if (f1342b != null) {
            try {
                z2 = f1342b.getBoolean(viewGroup);
                if (z2) {
                    f1342b.setBoolean(viewGroup, false);
                }
            } catch (IllegalAccessException e2) {
                Log.i("ViewGroupUtilsApi14", "Failed to get mLayoutSuppressed field by reflection");
            }
        }
        if (z2) {
            viewGroup.requestLayout();
        }
        LayoutTransition layoutTransition2 = (LayoutTransition) viewGroup.getTag(R.id.transition_layout_save);
        if (layoutTransition2 != null) {
            viewGroup.setTag(R.id.transition_layout_save, null);
            viewGroup.setLayoutTransition(layoutTransition2);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m1285a(LayoutTransition layoutTransition) {
        if (!f1345e) {
            try {
                f1344d = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
                f1344d.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
            }
            f1345e = true;
        }
        if (f1344d != null) {
            try {
                f1344d.invoke(layoutTransition, new Object[0]);
            } catch (IllegalAccessException e2) {
                Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
            } catch (InvocationTargetException e3) {
                Log.i("ViewGroupUtilsApi14", "Failed to invoke cancel method by reflection");
            }
        }
    }
}
