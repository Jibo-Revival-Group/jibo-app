package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public class ImageViewCompat {

    /* JADX INFO: renamed from: a */
    static final ImageViewCompatImpl f2642a;

    interface ImageViewCompatImpl {
        /* JADX INFO: renamed from: a */
        ColorStateList mo3018a(ImageView imageView);

        /* JADX INFO: renamed from: a */
        void mo3019a(ImageView imageView, ColorStateList colorStateList);

        /* JADX INFO: renamed from: a */
        void mo3020a(ImageView imageView, PorterDuff.Mode mode);

        /* JADX INFO: renamed from: b */
        PorterDuff.Mode mo3021b(ImageView imageView);
    }

    static class BaseViewCompatImpl implements ImageViewCompatImpl {
        BaseViewCompatImpl() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.widget.ImageViewCompat.ImageViewCompatImpl
        /* JADX INFO: renamed from: a */
        public ColorStateList mo3018a(ImageView imageView) {
            if (imageView instanceof TintableImageSourceView) {
                return ((TintableImageSourceView) imageView).getSupportImageTintList();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.widget.ImageViewCompat.ImageViewCompatImpl
        /* JADX INFO: renamed from: a */
        public void mo3019a(ImageView imageView, ColorStateList colorStateList) {
            if (imageView instanceof TintableImageSourceView) {
                ((TintableImageSourceView) imageView).setSupportImageTintList(colorStateList);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.widget.ImageViewCompat.ImageViewCompatImpl
        /* JADX INFO: renamed from: a */
        public void mo3020a(ImageView imageView, PorterDuff.Mode mode) {
            if (imageView instanceof TintableImageSourceView) {
                ((TintableImageSourceView) imageView).setSupportImageTintMode(mode);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.widget.ImageViewCompat.ImageViewCompatImpl
        /* JADX INFO: renamed from: b */
        public PorterDuff.Mode mo3021b(ImageView imageView) {
            if (imageView instanceof TintableImageSourceView) {
                return ((TintableImageSourceView) imageView).getSupportImageTintMode();
            }
            return null;
        }
    }

    static class LollipopViewCompatImpl extends BaseViewCompatImpl {
        LollipopViewCompatImpl() {
        }

        @Override // android.support.v4.widget.ImageViewCompat.BaseViewCompatImpl, android.support.v4.widget.ImageViewCompat.ImageViewCompatImpl
        /* JADX INFO: renamed from: a */
        public ColorStateList mo3018a(ImageView imageView) {
            return imageView.getImageTintList();
        }

        @Override // android.support.v4.widget.ImageViewCompat.BaseViewCompatImpl, android.support.v4.widget.ImageViewCompat.ImageViewCompatImpl
        /* JADX INFO: renamed from: a */
        public void mo3019a(ImageView imageView, ColorStateList colorStateList) {
            imageView.setImageTintList(colorStateList);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable drawable = imageView.getDrawable();
                boolean z = (imageView.getImageTintList() == null || imageView.getImageTintMode() == null) ? false : true;
                if (drawable != null && z) {
                    if (drawable.isStateful()) {
                        drawable.setState(imageView.getDrawableState());
                    }
                    imageView.setImageDrawable(drawable);
                }
            }
        }

        @Override // android.support.v4.widget.ImageViewCompat.BaseViewCompatImpl, android.support.v4.widget.ImageViewCompat.ImageViewCompatImpl
        /* JADX INFO: renamed from: a */
        public void mo3020a(ImageView imageView, PorterDuff.Mode mode) {
            imageView.setImageTintMode(mode);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable drawable = imageView.getDrawable();
                boolean z = (imageView.getImageTintList() == null || imageView.getImageTintMode() == null) ? false : true;
                if (drawable != null && z) {
                    if (drawable.isStateful()) {
                        drawable.setState(imageView.getDrawableState());
                    }
                    imageView.setImageDrawable(drawable);
                }
            }
        }

        @Override // android.support.v4.widget.ImageViewCompat.BaseViewCompatImpl, android.support.v4.widget.ImageViewCompat.ImageViewCompatImpl
        /* JADX INFO: renamed from: b */
        public PorterDuff.Mode mo3021b(ImageView imageView) {
            return imageView.getImageTintMode();
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f2642a = new LollipopViewCompatImpl();
        } else {
            f2642a = new BaseViewCompatImpl();
        }
    }

    /* JADX INFO: renamed from: a */
    public static ColorStateList m3014a(ImageView imageView) {
        return f2642a.mo3018a(imageView);
    }

    /* JADX INFO: renamed from: a */
    public static void m3015a(ImageView imageView, ColorStateList colorStateList) {
        f2642a.mo3019a(imageView, colorStateList);
    }

    /* JADX INFO: renamed from: b */
    public static PorterDuff.Mode m3017b(ImageView imageView) {
        return f2642a.mo3021b(imageView);
    }

    /* JADX INFO: renamed from: a */
    public static void m3016a(ImageView imageView, PorterDuff.Mode mode) {
        f2642a.mo3020a(imageView, mode);
    }
}
