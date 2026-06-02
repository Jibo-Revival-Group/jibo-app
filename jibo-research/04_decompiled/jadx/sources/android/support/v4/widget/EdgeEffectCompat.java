package android.support.v4.widget;

import android.os.Build;
import android.widget.EdgeEffect;

/* JADX INFO: loaded from: classes.dex */
public final class EdgeEffectCompat {

    /* JADX INFO: renamed from: a */
    private static final EdgeEffectBaseImpl f2641a;

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f2641a = new EdgeEffectApi21Impl();
        } else {
            f2641a = new EdgeEffectBaseImpl();
        }
    }

    static class EdgeEffectBaseImpl {
        EdgeEffectBaseImpl() {
        }

        /* JADX INFO: renamed from: a */
        public void mo3013a(EdgeEffect edgeEffect, float f, float f2) {
            edgeEffect.onPull(f);
        }
    }

    static class EdgeEffectApi21Impl extends EdgeEffectBaseImpl {
        EdgeEffectApi21Impl() {
        }

        @Override // android.support.v4.widget.EdgeEffectCompat.EdgeEffectBaseImpl
        /* JADX INFO: renamed from: a */
        public void mo3013a(EdgeEffect edgeEffect, float f, float f2) {
            edgeEffect.onPull(f, f2);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m3012a(EdgeEffect edgeEffect, float f, float f2) {
        f2641a.mo3013a(edgeEffect, f, f2);
    }
}
