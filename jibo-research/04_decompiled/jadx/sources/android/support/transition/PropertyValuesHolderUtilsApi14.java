package android.support.transition;

import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
class PropertyValuesHolderUtilsApi14 implements PropertyValuesHolderUtilsImpl {
    PropertyValuesHolderUtilsApi14() {
    }

    @Override // android.support.transition.PropertyValuesHolderUtilsImpl
    /* JADX INFO: renamed from: a */
    public PropertyValuesHolder mo1185a(Property<?, PointF> property, Path path) {
        return PropertyValuesHolder.ofFloat(new PathProperty(property, path), CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
    }
}
