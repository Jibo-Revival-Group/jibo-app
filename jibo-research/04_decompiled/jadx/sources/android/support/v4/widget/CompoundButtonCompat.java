package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class CompoundButtonCompat {

    /* JADX INFO: renamed from: a */
    private static final CompoundButtonCompatBaseImpl f2558a;

    static {
        if (Build.VERSION.SDK_INT >= 23) {
            f2558a = new CompoundButtonCompatApi23Impl();
        } else if (Build.VERSION.SDK_INT >= 21) {
            f2558a = new CompoundButtonCompatApi21Impl();
        } else {
            f2558a = new CompoundButtonCompatBaseImpl();
        }
    }

    static class CompoundButtonCompatBaseImpl {

        /* JADX INFO: renamed from: a */
        private static Field f2559a;

        /* JADX INFO: renamed from: b */
        private static boolean f2560b;

        CompoundButtonCompatBaseImpl() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: a */
        public void mo2931a(CompoundButton compoundButton, ColorStateList colorStateList) {
            if (compoundButton instanceof TintableCompoundButton) {
                ((TintableCompoundButton) compoundButton).setSupportButtonTintList(colorStateList);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: a */
        public void mo2932a(CompoundButton compoundButton, PorterDuff.Mode mode) {
            if (compoundButton instanceof TintableCompoundButton) {
                ((TintableCompoundButton) compoundButton).setSupportButtonTintMode(mode);
            }
        }

        /* JADX INFO: renamed from: a */
        public Drawable mo2933a(CompoundButton compoundButton) {
            if (!f2560b) {
                try {
                    f2559a = CompoundButton.class.getDeclaredField("mButtonDrawable");
                    f2559a.setAccessible(true);
                } catch (NoSuchFieldException e) {
                    Log.i("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", e);
                }
                f2560b = true;
            }
            if (f2559a != null) {
                try {
                    return (Drawable) f2559a.get(compoundButton);
                } catch (IllegalAccessException e2) {
                    Log.i("CompoundButtonCompat", "Failed to get button drawable via reflection", e2);
                    f2559a = null;
                }
            }
            return null;
        }
    }

    static class CompoundButtonCompatApi21Impl extends CompoundButtonCompatBaseImpl {
        CompoundButtonCompatApi21Impl() {
        }

        @Override // android.support.v4.widget.CompoundButtonCompat.CompoundButtonCompatBaseImpl
        /* JADX INFO: renamed from: a */
        public void mo2931a(CompoundButton compoundButton, ColorStateList colorStateList) {
            compoundButton.setButtonTintList(colorStateList);
        }

        @Override // android.support.v4.widget.CompoundButtonCompat.CompoundButtonCompatBaseImpl
        /* JADX INFO: renamed from: a */
        public void mo2932a(CompoundButton compoundButton, PorterDuff.Mode mode) {
            compoundButton.setButtonTintMode(mode);
        }
    }

    static class CompoundButtonCompatApi23Impl extends CompoundButtonCompatApi21Impl {
        CompoundButtonCompatApi23Impl() {
        }

        @Override // android.support.v4.widget.CompoundButtonCompat.CompoundButtonCompatBaseImpl
        /* JADX INFO: renamed from: a */
        public Drawable mo2933a(CompoundButton compoundButton) {
            return compoundButton.getButtonDrawable();
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2929a(CompoundButton compoundButton, ColorStateList colorStateList) {
        f2558a.mo2931a(compoundButton, colorStateList);
    }

    /* JADX INFO: renamed from: a */
    public static void m2930a(CompoundButton compoundButton, PorterDuff.Mode mode) {
        f2558a.mo2932a(compoundButton, mode);
    }

    /* JADX INFO: renamed from: a */
    public static Drawable m2928a(CompoundButton compoundButton) {
        return f2558a.mo2933a(compoundButton);
    }
}
