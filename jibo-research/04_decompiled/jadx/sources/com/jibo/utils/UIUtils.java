package com.jibo.utils;

import android.content.Context;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.jibo.R;
import com.jibo.p019ui.view.proxima.ProximaHelper;
import com.jibo.utils.Util;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes.dex */
public class UIUtils {

    /* JADX INFO: renamed from: a */
    public static final SimpleDateFormat f11692a = new SimpleDateFormat("hh:mm a");

    /* JADX INFO: renamed from: b */
    public static final SimpleDateFormat f11693b = new SimpleDateFormat("M/d/yy");

    /* JADX INFO: renamed from: c */
    public static final SimpleDateFormat f11694c = new SimpleDateFormat("hh:mm a");

    /* JADX INFO: renamed from: a */
    public static void m11474a(Context context, View view) {
        if (view != null) {
            ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m11480b(Context context, View view) {
        if (view != null) {
            ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(view, 0);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m11476a(View view, Throwable th) {
        m11475a(view, ErrorHelper.m11382a(view.getContext().getApplicationContext(), th));
    }

    /* JADX INFO: renamed from: a */
    public static void m11475a(View view, String str) {
        Snackbar.m804a(view, str, 0).m490c();
    }

    /* JADX INFO: renamed from: a */
    public static boolean m11479a(String str) {
        return !TextUtils.isEmpty(str) && Commons.f11677b.matcher(str).matches();
    }

    /* JADX INFO: renamed from: a */
    public static SpannableStringBuilder m11473a(Context context, String str, String str2) {
        String str3 = str + "\n" + str2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str3);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.steel)), str3.indexOf(str2), str3.length(), 18);
        spannableStringBuilder.setSpan(new Util.CustomTypefaceSpan("", ProximaHelper.f11650b), str3.indexOf(str2), str3.length(), 33);
        spannableStringBuilder.setSpan(new RelativeSizeSpan(0.85f), str3.indexOf(str2), str3.length(), 33);
        return spannableStringBuilder;
    }

    /* JADX INFO: renamed from: a */
    public static void m11477a(String str, TextView textView) {
        m11478a(str, textView, ImageUtils.m11399b(textView.getContext(), R.color.black));
    }

    /* JADX INFO: renamed from: a */
    public static void m11478a(String str, TextView textView, int i) {
        String string = textView.getContext().getString(R.string.text_new_password_length);
        String string2 = textView.getContext().getString(R.string.text_new_password_number);
        String string3 = textView.getContext().getString(R.string.text_new_password_uppercase);
        String string4 = textView.getContext().getString(R.string.text_new_password_lowercase);
        String string5 = textView.getContext().getString(R.string.text_new_password_info2, string, string3, string4, string2);
        boolean zM11484d = m11484d(str);
        int iM11399b = ImageUtils.m11399b(textView.getContext(), R.color.firecracker);
        if (zM11484d) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(textView.getContext().getString(R.string.password_too_long));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(iM11399b), 0, spannableStringBuilder.length(), 33);
            textView.setText(spannableStringBuilder);
            return;
        }
        boolean zM11482b = m11482b(str);
        boolean zM11483c = m11483c(str);
        boolean zM11485e = m11485e(str);
        boolean zM11486f = m11486f(str);
        if (zM11482b && zM11483c && zM11485e && zM11486f) {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(string5);
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(i), 0, spannableStringBuilder2.length(), 33);
            textView.setText(string5);
            return;
        }
        SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(string5);
        int iIndexOf = string5.indexOf(string);
        int iIndexOf2 = string5.indexOf(string2);
        int iIndexOf3 = string5.indexOf(string3);
        int iIndexOf4 = string5.indexOf(string4);
        int i2 = (zM11483c || TextUtils.isEmpty(str)) ? i : iM11399b;
        int i3 = (zM11485e || TextUtils.isEmpty(str)) ? i : iM11399b;
        int i4 = (zM11482b || TextUtils.isEmpty(str)) ? i : iM11399b;
        if (!zM11486f && !TextUtils.isEmpty(str)) {
            i = iM11399b;
        }
        spannableStringBuilder3.setSpan(new ForegroundColorSpan(i2), iIndexOf, string.length() + iIndexOf, 33);
        spannableStringBuilder3.setSpan(new ForegroundColorSpan(i4), iIndexOf2, string2.length() + iIndexOf2, 33);
        spannableStringBuilder3.setSpan(new ForegroundColorSpan(i3), iIndexOf3, string3.length() + iIndexOf3, 33);
        spannableStringBuilder3.setSpan(new ForegroundColorSpan(i), iIndexOf4, string4.length() + iIndexOf4, 33);
        textView.setText(spannableStringBuilder3);
    }

    /* JADX INFO: renamed from: b */
    public static void m11481b(String str, TextView textView, int i) {
        String string = textView.getContext().getString(R.string.text_passphrase_length);
        String string2 = textView.getContext().getString(R.string.text_passphrase_number);
        String string3 = textView.getContext().getString(R.string.text_passphrase_uppercase);
        String string4 = textView.getContext().getString(R.string.text_passphrase_validation, string, string2, string3);
        boolean zM11484d = m11484d(str);
        int iM11399b = ImageUtils.m11399b(textView.getContext(), R.color.firecracker);
        if (zM11484d) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(textView.getContext().getString(R.string.password_too_long));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(iM11399b), 0, spannableStringBuilder.length(), 33);
            textView.setText(spannableStringBuilder);
            return;
        }
        boolean zM11482b = m11482b(str);
        boolean zM11483c = m11483c(str);
        boolean zM11485e = m11485e(str);
        if (zM11482b && zM11483c && zM11485e) {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(string4);
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(i), 0, spannableStringBuilder2.length(), 33);
            textView.setText(string4);
            return;
        }
        SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(string4);
        int iIndexOf = string4.indexOf(string);
        int iIndexOf2 = string4.indexOf(string2);
        int iIndexOf3 = string4.indexOf(string3);
        int i2 = (zM11483c || TextUtils.isEmpty(str)) ? i : iM11399b;
        int i3 = (zM11485e || TextUtils.isEmpty(str)) ? i : iM11399b;
        if (!zM11482b && !TextUtils.isEmpty(str)) {
            i = iM11399b;
        }
        spannableStringBuilder3.setSpan(new ForegroundColorSpan(i2), iIndexOf, string.length() + iIndexOf, 33);
        spannableStringBuilder3.setSpan(new ForegroundColorSpan(i), iIndexOf2, string2.length() + iIndexOf2, 33);
        spannableStringBuilder3.setSpan(new ForegroundColorSpan(i3), iIndexOf3, string3.length() + iIndexOf3, 33);
        textView.setText(spannableStringBuilder3);
    }

    /* JADX INFO: renamed from: b */
    private static boolean m11482b(String str) {
        return Commons.f11680e.matcher(str).matches();
    }

    /* JADX INFO: renamed from: c */
    private static boolean m11483c(String str) {
        return str.length() >= 8;
    }

    /* JADX INFO: renamed from: d */
    private static boolean m11484d(String str) {
        return str.length() > 64;
    }

    /* JADX INFO: renamed from: e */
    private static boolean m11485e(String str) {
        return Commons.f11678c.matcher(str).find();
    }

    /* JADX INFO: renamed from: f */
    private static boolean m11486f(String str) {
        return Commons.f11679d.matcher(str).matches();
    }

    /* JADX INFO: renamed from: a */
    public static int m11472a() {
        return Build.VERSION.SDK_INT >= 21 ? R.drawable.android_notification : R.mipmap.ic_launcher;
    }
}
