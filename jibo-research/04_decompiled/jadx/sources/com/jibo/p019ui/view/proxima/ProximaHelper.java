package com.jibo.p019ui.view.proxima;

import android.content.Context;
import android.graphics.Typeface;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class ProximaHelper {

    /* JADX INFO: renamed from: a */
    public static Typeface f11649a = null;

    /* JADX INFO: renamed from: b */
    public static Typeface f11650b = null;

    /* JADX INFO: renamed from: c */
    public static Typeface f11651c = null;

    /* JADX INFO: renamed from: d */
    public static Typeface f11652d = null;

    /* JADX INFO: renamed from: a */
    public static void m11355a(Context context) {
        f11650b = Typeface.createFromAsset(context.getAssets(), "fonts/ProximaNova-Light.ttf");
        f11649a = Typeface.createFromAsset(context.getAssets(), "fonts/ProximaNova-Regular.ttf");
        f11651c = Typeface.createFromAsset(context.getAssets(), "fonts/ProximaNova-Semibold.ttf");
        f11652d = Typeface.createFromAsset(context.getAssets(), "fonts/ProximaNova-Bold.otf");
    }

    /* JADX INFO: renamed from: a */
    public static Typeface m11354a(Context context, String str) {
        Typeface typeface = f11649a;
        try {
            if (!TextUtils.isEmpty(str) && !str.contains("ProximaNova-Regular.ttf")) {
                return Typeface.createFromAsset(context.getAssets(), "fonts/" + str);
            }
            return typeface;
        } catch (Exception e) {
            return f11649a;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m11357a(View view, String str) {
        Typeface typefaceM11354a = m11354a(view.getContext(), str);
        if (view instanceof TextView) {
            ((TextView) view).setTypeface(typefaceM11354a);
        } else if (view instanceof TextInputLayout) {
            ((TextInputLayout) view).setTypeface(typefaceM11354a);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m11356a(View view) {
        if (view instanceof TextView) {
            ((TextView) view).setTypeface(f11649a);
        } else if (view instanceof TextInputLayout) {
            ((TextInputLayout) view).setTypeface(f11649a);
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m11358b(View view) {
        if (view instanceof TextView) {
            ((TextView) view).setTypeface(f11651c);
        } else if (view instanceof TextInputLayout) {
            ((TextInputLayout) view).setTypeface(f11651c);
        }
    }
}
