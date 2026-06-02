package android.support.transition;

import android.animation.Animator;
import android.graphics.Matrix;
import android.os.Build;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
class ImageViewUtils {

    /* JADX INFO: renamed from: a */
    private static final ImageViewUtilsImpl f1219a;

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f1219a = new ImageViewUtilsApi21();
        } else {
            f1219a = new ImageViewUtilsApi14();
        }
    }

    /* JADX INFO: renamed from: a */
    static void m1170a(ImageView imageView) {
        f1219a.mo1173a(imageView);
    }

    /* JADX INFO: renamed from: a */
    static void m1172a(ImageView imageView, Matrix matrix) {
        f1219a.mo1175a(imageView, matrix);
    }

    /* JADX INFO: renamed from: a */
    static void m1171a(ImageView imageView, Animator animator) {
        f1219a.mo1174a(imageView, animator);
    }
}
