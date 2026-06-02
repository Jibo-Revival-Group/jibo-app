package android.support.transition;

import android.animation.Animator;
import android.graphics.Matrix;
import android.util.Log;
import android.widget.ImageView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class ImageViewUtilsApi21 implements ImageViewUtilsImpl {

    /* JADX INFO: renamed from: a */
    private static Method f1222a;

    /* JADX INFO: renamed from: b */
    private static boolean f1223b;

    ImageViewUtilsApi21() {
    }

    @Override // android.support.transition.ImageViewUtilsImpl
    /* JADX INFO: renamed from: a */
    public void mo1173a(ImageView imageView) {
    }

    @Override // android.support.transition.ImageViewUtilsImpl
    /* JADX INFO: renamed from: a */
    public void mo1175a(ImageView imageView, Matrix matrix) {
        m1176a();
        if (f1222a != null) {
            try {
                f1222a.invoke(imageView, matrix);
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    @Override // android.support.transition.ImageViewUtilsImpl
    /* JADX INFO: renamed from: a */
    public void mo1174a(ImageView imageView, Animator animator) {
    }

    /* JADX INFO: renamed from: a */
    private void m1176a() {
        if (!f1223b) {
            try {
                f1222a = ImageView.class.getDeclaredMethod("animateTransform", Matrix.class);
                f1222a.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("ImageViewUtilsApi21", "Failed to retrieve animateTransform method", e);
            }
            f1223b = true;
        }
    }
}
