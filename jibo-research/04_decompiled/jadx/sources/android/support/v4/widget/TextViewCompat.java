package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.os.BuildCompat;
import android.util.Log;
import android.widget.TextView;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class TextViewCompat {

    /* JADX INFO: renamed from: a */
    static final TextViewCompatBaseImpl f2765a;

    static class TextViewCompatBaseImpl {

        /* JADX INFO: renamed from: a */
        private static Field f2766a;

        /* JADX INFO: renamed from: b */
        private static boolean f2767b;

        /* JADX INFO: renamed from: c */
        private static Field f2768c;

        /* JADX INFO: renamed from: d */
        private static boolean f2769d;

        TextViewCompatBaseImpl() {
        }

        /* JADX INFO: renamed from: a */
        public void mo3121a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        }

        /* JADX INFO: renamed from: a */
        private static Field m3125a(String str) {
            Field declaredField = null;
            try {
                declaredField = TextView.class.getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField;
            } catch (NoSuchFieldException e) {
                Log.e("TextViewCompatBase", "Could not retrieve " + str + " field.");
                return declaredField;
            }
        }

        /* JADX INFO: renamed from: a */
        private static int m3124a(Field field, TextView textView) {
            try {
                return field.getInt(textView);
            } catch (IllegalAccessException e) {
                Log.d("TextViewCompatBase", "Could not retrieve value of " + field.getName() + " field.");
                return -1;
            }
        }

        /* JADX INFO: renamed from: a */
        public int mo3120a(TextView textView) {
            if (!f2769d) {
                f2768c = m3125a("mMaxMode");
                f2769d = true;
            }
            if (f2768c != null && m3124a(f2768c, textView) == 1) {
                if (!f2767b) {
                    f2766a = m3125a("mMaximum");
                    f2767b = true;
                }
                if (f2766a != null) {
                    return m3124a(f2766a, textView);
                }
            }
            return -1;
        }

        /* JADX INFO: renamed from: a */
        public void mo3123a(TextView textView, int i) {
            textView.setTextAppearance(textView.getContext(), i);
        }

        /* JADX INFO: renamed from: b */
        public Drawable[] mo3122b(TextView textView) {
            return textView.getCompoundDrawables();
        }
    }

    static class TextViewCompatApi16Impl extends TextViewCompatBaseImpl {
        TextViewCompatApi16Impl() {
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        /* JADX INFO: renamed from: a */
        public int mo3120a(TextView textView) {
            return textView.getMaxLines();
        }
    }

    static class TextViewCompatApi17Impl extends TextViewCompatApi16Impl {
        TextViewCompatApi17Impl() {
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        /* JADX INFO: renamed from: a */
        public void mo3121a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            boolean z = textView.getLayoutDirection() == 1;
            Drawable drawable5 = z ? drawable3 : drawable;
            if (!z) {
                drawable = drawable3;
            }
            textView.setCompoundDrawables(drawable5, drawable2, drawable, drawable4);
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        /* JADX INFO: renamed from: b */
        public Drawable[] mo3122b(TextView textView) {
            boolean z = textView.getLayoutDirection() == 1;
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            if (z) {
                Drawable drawable = compoundDrawables[2];
                Drawable drawable2 = compoundDrawables[0];
                compoundDrawables[0] = drawable;
                compoundDrawables[2] = drawable2;
            }
            return compoundDrawables;
        }
    }

    static class TextViewCompatApi18Impl extends TextViewCompatApi17Impl {
        TextViewCompatApi18Impl() {
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatApi17Impl, android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        /* JADX INFO: renamed from: a */
        public void mo3121a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatApi17Impl, android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        /* JADX INFO: renamed from: b */
        public Drawable[] mo3122b(TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }
    }

    static class TextViewCompatApi23Impl extends TextViewCompatApi18Impl {
        TextViewCompatApi23Impl() {
        }

        @Override // android.support.v4.widget.TextViewCompat.TextViewCompatBaseImpl
        /* JADX INFO: renamed from: a */
        public void mo3123a(TextView textView, int i) {
            textView.setTextAppearance(i);
        }
    }

    static class TextViewCompatApi26Impl extends TextViewCompatApi23Impl {
        TextViewCompatApi26Impl() {
        }
    }

    static class TextViewCompatApi27Impl extends TextViewCompatApi26Impl {
        TextViewCompatApi27Impl() {
        }
    }

    static {
        if (BuildCompat.m2313a()) {
            f2765a = new TextViewCompatApi27Impl();
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            f2765a = new TextViewCompatApi26Impl();
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            f2765a = new TextViewCompatApi23Impl();
            return;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            f2765a = new TextViewCompatApi18Impl();
            return;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            f2765a = new TextViewCompatApi17Impl();
        } else if (Build.VERSION.SDK_INT >= 16) {
            f2765a = new TextViewCompatApi16Impl();
        } else {
            f2765a = new TextViewCompatBaseImpl();
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m3118a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        f2765a.mo3121a(textView, drawable, drawable2, drawable3, drawable4);
    }

    /* JADX INFO: renamed from: a */
    public static int m3116a(TextView textView) {
        return f2765a.mo3120a(textView);
    }

    /* JADX INFO: renamed from: a */
    public static void m3117a(TextView textView, int i) {
        f2765a.mo3123a(textView, i);
    }

    /* JADX INFO: renamed from: b */
    public static Drawable[] m3119b(TextView textView) {
        return f2765a.mo3122b(textView);
    }
}
