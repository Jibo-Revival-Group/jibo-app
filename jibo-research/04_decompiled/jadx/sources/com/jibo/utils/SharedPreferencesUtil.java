package com.jibo.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class SharedPreferencesUtil {
    /* JADX INFO: renamed from: a */
    public static void m11429a(Context context) {
        int i;
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), 0);
        if (sharedPreferences.contains("PREF_APP_OPEN_NUM")) {
            i = sharedPreferences.getInt("PREF_APP_OPEN_NUM", 0) + 1;
        } else {
            i = 1;
        }
        sharedPreferences.edit().putInt("PREF_APP_OPEN_NUM", i).apply();
    }

    /* JADX INFO: renamed from: b */
    public static void m11434b(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), 0);
        sharedPreferences.edit().putString("PREF_PUSH_SERVICE_TOKEN", "").apply();
        sharedPreferences.edit().putString("PREF_INSTANCE_ID", "").apply();
        sharedPreferences.edit().putInt("PREF_MEDIA_TAB_MODE", 0).apply();
        sharedPreferences.edit().putString(Loop.class.getSimpleName(), "").apply();
        sharedPreferences.edit().putString("PREF_PARENTS_MEMBERS", "").apply();
        sharedPreferences.edit().putBoolean("PREF_ENCRYPTION_ENABLED", true).apply();
        sharedPreferences.edit().putString("PREF_LOOPS_IN_TIMEOUT", "").apply();
        sharedPreferences.edit().putString("PREF_LOOPS_ALERTED_TIMEOUT", "").apply();
        sharedPreferences.edit().putString("PREF_LOOPS_NO_HOLIDAYS", "").apply();
        sharedPreferences.edit().putBoolean("PREF_PUSHES_ON_GALLERY_CONTENT", true).apply();
        sharedPreferences.edit().putBoolean("PREF_IS_PERSONAL_REPORT_DIALOG_SHOWN", false).apply();
    }

    /* JADX INFO: renamed from: c */
    public static boolean m11438c(Context context) {
        return context.getSharedPreferences(context.getString(R.string.app_name), 0).getBoolean("PREF_ACQUISITION", false);
    }

    /* JADX INFO: renamed from: d */
    public static void m11439d(Context context) {
        context.getSharedPreferences(context.getString(R.string.app_name), 0).edit().putBoolean("PREF_ACQUISITION", true).apply();
    }

    /* JADX INFO: renamed from: e */
    public static int m11441e(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), 0);
        int i = sharedPreferences.getInt("PREF_APP_OPEN_NUM", 0);
        sharedPreferences.edit().remove("PREF_APP_OPEN_NUM").apply();
        return i;
    }

    /* JADX INFO: renamed from: f */
    public static Loop m11443f(Context context) {
        String string = context.getSharedPreferences(context.getString(R.string.app_name), 0).getString(Loop.class.getSimpleName(), "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return (Loop) new Gson().m9355a(string, Loop.class);
    }

    /* JADX INFO: renamed from: a */
    public static void m11430a(Context context, Loop loop) {
        context.getSharedPreferences(context.getString(R.string.app_name), 0).edit().putString(Loop.class.getSimpleName(), new Gson().m9362b(loop)).apply();
    }

    /* JADX INFO: renamed from: g */
    public static boolean m11446g(Context context) {
        return context.getSharedPreferences(context.getString(R.string.app_name), 0).getBoolean("PREF_ENCRYPTION_ENABLED", true);
    }

    /* JADX INFO: renamed from: a */
    public static void m11432a(Context context, String str, boolean z) {
        context.getSharedPreferences(context.getString(R.string.app_name), 0).edit().putBoolean(str, z).apply();
    }

    /* JADX INFO: renamed from: h */
    public static String[] m11448h(Context context) {
        return context.getSharedPreferences(context.getString(R.string.app_name), 0).getString("PREF_PARENTS_MEMBERS", "").split(",");
    }

    /* JADX INFO: renamed from: a */
    public static void m11431a(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), 0);
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, sharedPreferences.getString("PREF_PARENTS_MEMBERS", "").split(","));
        arrayList.remove("");
        arrayList.remove(str);
        arrayList.add(str);
        sharedPreferences.edit().putString("PREF_PARENTS_MEMBERS", TextUtils.join(",", arrayList)).apply();
    }

    /* JADX INFO: renamed from: b */
    public static void m11435b(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), 0);
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, sharedPreferences.getString("PREF_PARENTS_MEMBERS", "").split(","));
        arrayList.remove("");
        arrayList.remove(str);
        sharedPreferences.edit().putString("PREF_PARENTS_MEMBERS", TextUtils.join(",", arrayList)).apply();
    }

    /* JADX INFO: renamed from: i */
    public static boolean m11449i(Context context) {
        return context.getSharedPreferences(context.getString(R.string.app_name), 0).getBoolean("PREF_FIRST_TIME_TIPS", true);
    }

    /* JADX INFO: renamed from: j */
    public static void m11450j(Context context) {
        context.getSharedPreferences(context.getString(R.string.app_name), 0).edit().putBoolean("PREF_FIRST_TIME_TIPS", false).apply();
    }

    /* JADX INFO: renamed from: k */
    public static boolean m11451k(Context context) {
        return context.getSharedPreferences(context.getString(R.string.app_name), 0).getBoolean("PREF_SHOW_INVITE_CONGRATS", true);
    }

    /* JADX INFO: renamed from: l */
    public static void m11452l(Context context) {
        context.getSharedPreferences(context.getString(R.string.app_name), 0).edit().putBoolean("PREF_SHOW_INVITE_CONGRATS", false).apply();
    }

    /* JADX INFO: renamed from: m */
    public static String[] m11453m(Context context) {
        return context.getSharedPreferences(context.getString(R.string.app_name), 0).getString("PREF_LOOPS_IN_TIMEOUT", "").split(",");
    }

    /* JADX INFO: renamed from: c */
    public static void m11437c(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), 0);
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, sharedPreferences.getString("PREF_LOOPS_IN_TIMEOUT", "").split(","));
        arrayList.remove("");
        arrayList.remove(str);
        arrayList.add(str);
        sharedPreferences.edit().putString("PREF_LOOPS_IN_TIMEOUT", TextUtils.join(",", arrayList)).apply();
    }

    /* JADX INFO: renamed from: d */
    public static void m11440d(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), 0);
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, sharedPreferences.getString("PREF_LOOPS_IN_TIMEOUT", "").split(","));
        arrayList.remove("");
        arrayList.remove(str);
        sharedPreferences.edit().putString("PREF_LOOPS_IN_TIMEOUT", TextUtils.join(",", arrayList)).apply();
    }

    /* JADX INFO: renamed from: e */
    public static void m11442e(Context context, String str) {
        m11440d(context, str);
        m11444f(context, str);
    }

    /* JADX INFO: renamed from: n */
    public static String[] m11454n(Context context) {
        return context.getSharedPreferences(context.getString(R.string.app_name), 0).getString("PREF_LOOPS_ALERTED_TIMEOUT", "").split(",");
    }

    /* JADX INFO: renamed from: f */
    public static void m11444f(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), 0);
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, sharedPreferences.getString("PREF_LOOPS_ALERTED_TIMEOUT", "").split(","));
        arrayList.remove("");
        arrayList.remove(str);
        arrayList.add(str);
        sharedPreferences.edit().putString("PREF_LOOPS_ALERTED_TIMEOUT", TextUtils.join(",", arrayList)).apply();
    }

    /* JADX INFO: renamed from: o */
    public static String[] m11455o(Context context) {
        return context.getSharedPreferences(context.getString(R.string.app_name), 0).getString("PREF_LOOPS_NO_HOLIDAYS", "").split(",");
    }

    /* JADX INFO: renamed from: g */
    public static void m11445g(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), 0);
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, sharedPreferences.getString("PREF_LOOPS_NO_HOLIDAYS", "").split(","));
        arrayList.remove("");
        arrayList.remove(str);
        arrayList.add(str);
        sharedPreferences.edit().putString("PREF_LOOPS_NO_HOLIDAYS", TextUtils.join(",", arrayList)).apply();
    }

    /* JADX INFO: renamed from: h */
    public static void m11447h(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), 0);
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, sharedPreferences.getString("PREF_LOOPS_NO_HOLIDAYS", "").split(","));
        arrayList.remove("");
        arrayList.remove(str);
        sharedPreferences.edit().putString("PREF_LOOPS_NO_HOLIDAYS", TextUtils.join(",", arrayList)).apply();
    }

    /* JADX INFO: renamed from: p */
    public static boolean m11456p(Context context) {
        return context.getSharedPreferences(context.getString(R.string.app_name), 0).getBoolean("PREF_PUSHES_ON_GALLERY_CONTENT", true);
    }

    /* JADX INFO: renamed from: a */
    public static void m11433a(Context context, boolean z) {
        context.getSharedPreferences(context.getString(R.string.app_name), 0).edit().putBoolean("PREF_PUSHES_ON_GALLERY_CONTENT", z).apply();
    }

    /* JADX INFO: renamed from: q */
    public static boolean m11457q(Context context) {
        return context.getSharedPreferences(context.getString(R.string.app_name), 0).getBoolean("PREF_IS_PERSONAL_REPORT_DIALOG_SHOWN", false);
    }

    /* JADX INFO: renamed from: b */
    public static void m11436b(Context context, boolean z) {
        context.getSharedPreferences(context.getString(R.string.app_name), 0).edit().putBoolean("PREF_IS_PERSONAL_REPORT_DIALOG_SHOWN", z).apply();
    }
}
