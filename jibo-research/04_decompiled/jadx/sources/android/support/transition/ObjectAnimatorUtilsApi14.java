package android.support.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
class ObjectAnimatorUtilsApi14 implements ObjectAnimatorUtilsImpl {
    ObjectAnimatorUtilsApi14() {
    }

    @Override // android.support.transition.ObjectAnimatorUtilsImpl
    /* JADX INFO: renamed from: a */
    public <T> ObjectAnimator mo1179a(T t, Property<T, PointF> property, Path path) {
        return ObjectAnimator.ofFloat(t, new PathProperty(property, path), CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
    }
}
