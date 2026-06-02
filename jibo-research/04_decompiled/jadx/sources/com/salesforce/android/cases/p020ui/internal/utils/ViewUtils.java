package com.salesforce.android.cases.p020ui.internal.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.design.R;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public class ViewUtils {
    /* JADX INFO: renamed from: a */
    public static void m13060a(final View view) {
        final InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
        view.post(new Runnable() { // from class: com.salesforce.android.cases.ui.internal.utils.ViewUtils.1
            @Override // java.lang.Runnable
            public void run() {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        });
    }

    /* JADX INFO: renamed from: b */
    public static void m13062b(View view) {
        if (view.getAlpha() != 1.0f || view.getVisibility() != 0) {
            view.setVisibility(0);
            view.setAlpha(CropImageView.DEFAULT_ASPECT_RATIO);
            view.animate().alpha(1.0f).start();
        }
    }

    /* JADX INFO: renamed from: c */
    public static void m13063c(final View view) {
        if (view.getAlpha() != CropImageView.DEFAULT_ASPECT_RATIO || 8 != view.getVisibility()) {
            view.animate().alpha(CropImageView.DEFAULT_ASPECT_RATIO).withEndAction(new Runnable() { // from class: com.salesforce.android.cases.ui.internal.utils.ViewUtils.2
                @Override // java.lang.Runnable
                public void run() {
                    view.setVisibility(8);
                }
            });
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m13064d(final View view) {
        view.post(new Runnable() { // from class: com.salesforce.android.cases.ui.internal.utils.ViewUtils.3
            @Override // java.lang.Runnable
            public void run() {
                view.requestFocus();
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m13058a(Snackbar snackbar, int i) {
        m13059a(snackbar, 0, i);
    }

    /* JADX INFO: renamed from: a */
    public static void m13059a(Snackbar snackbar, int i, int i2) {
        View viewB = snackbar.m488b();
        if (i != 0) {
            viewB.setBackgroundColor(i);
        }
        m13061b(snackbar, i2);
    }

    /* JADX INFO: renamed from: b */
    public static void m13061b(Snackbar snackbar, int i) {
        TextView textView = (TextView) snackbar.m488b().findViewById(R.id.snackbar_text);
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    @TargetApi(21)
    /* JADX INFO: renamed from: a */
    public static void m13057a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            TypedArray typedArrayObtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{com.salesforce.android.cases.R.attr.salesforceToolbarBackgroundColor});
            int color = typedArrayObtainStyledAttributes.getColor(0, ContextCompat.m1840c(activity, com.salesforce.android.cases.R.color.salesforce_brand_primary));
            typedArrayObtainStyledAttributes.recycle();
            activity.getWindow().setStatusBarColor(ColorUtils.m13045a(color, 0.2f));
        }
    }
}
