package android.support.v4.view;

import android.os.Build;
import android.support.compat.R;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public final class ViewGroupCompat {

    /* JADX INFO: renamed from: a */
    static final ViewGroupCompatBaseImpl f2351a;

    static class ViewGroupCompatBaseImpl {
        ViewGroupCompatBaseImpl() {
        }

        /* JADX INFO: renamed from: a */
        public boolean mo2682a(ViewGroup viewGroup) {
            Boolean bool = (Boolean) viewGroup.getTag(R.id.tag_transition_group);
            return ((bool == null || !bool.booleanValue()) && viewGroup.getBackground() == null && ViewCompat.m2611o(viewGroup) == null) ? false : true;
        }
    }

    static class ViewGroupCompatApi18Impl extends ViewGroupCompatBaseImpl {
        ViewGroupCompatApi18Impl() {
        }
    }

    static class ViewGroupCompatApi21Impl extends ViewGroupCompatApi18Impl {
        ViewGroupCompatApi21Impl() {
        }

        @Override // android.support.v4.view.ViewGroupCompat.ViewGroupCompatBaseImpl
        /* JADX INFO: renamed from: a */
        public boolean mo2682a(ViewGroup viewGroup) {
            return viewGroup.isTransitionGroup();
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f2351a = new ViewGroupCompatApi21Impl();
        } else if (Build.VERSION.SDK_INT >= 18) {
            f2351a = new ViewGroupCompatApi18Impl();
        } else {
            f2351a = new ViewGroupCompatBaseImpl();
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m2681a(ViewGroup viewGroup) {
        return f2351a.mo2682a(viewGroup);
    }
}
