package com.google.firebase.perf;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class FirebasePerformance {

    /* JADX INFO: renamed from: a */
    private static volatile FirebasePerformance f8723a;

    /* JADX INFO: renamed from: b */
    private final Map<String, String> f8724b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c */
    private boolean f8725c;

    private FirebasePerformance() {
        this.f8725c = true;
        try {
            FirebaseApp.m9080d();
            Context contextM9084a = FirebaseApp.m9080d().m9084a();
            this.f8725c = m9242a(contextM9084a, contextM9084a.getSharedPreferences("FirebasePerfSharedPrefs", 0));
        } catch (IllegalStateException e) {
            this.f8725c = false;
        }
    }

    /* JADX INFO: renamed from: a */
    public static FirebasePerformance m9240a() {
        if (f8723a == null) {
            synchronized (FirebasePerformance.class) {
                if (f8723a == null) {
                    f8723a = new FirebasePerformance();
                }
            }
        }
        return f8723a;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m9241a(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean("firebase_performance_collection_enabled", true);
        } catch (PackageManager.NameNotFoundException | NullPointerException e) {
            String strValueOf = String.valueOf(e.getMessage());
            Log.d("isEnabled", strValueOf.length() != 0 ? "No perf enable meta data found ".concat(strValueOf) : new String("No perf enable meta data found "));
            return true;
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m9242a(Context context, SharedPreferences sharedPreferences) {
        if (m9243b(context)) {
            return false;
        }
        try {
            if (sharedPreferences.contains("isEnabled")) {
                return sharedPreferences.getBoolean("isEnabled", true);
            }
        } catch (ClassCastException e) {
            String strValueOf = String.valueOf(e.getMessage());
            Log.d("FirebasePerformance", strValueOf.length() != 0 ? "Unable to access enable value: ".concat(strValueOf) : new String("Unable to access enable value: "));
        }
        return m9241a(context);
    }

    /* JADX INFO: renamed from: b */
    private static boolean m9243b(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean("firebase_performance_collection_deactivated", false);
        } catch (PackageManager.NameNotFoundException | NullPointerException e) {
            String strValueOf = String.valueOf(e.getMessage());
            Log.d("isEnabled", strValueOf.length() != 0 ? "No perf enable meta data found ".concat(strValueOf) : new String("No perf enable meta data found "));
            return false;
        }
    }

    /* JADX INFO: renamed from: b */
    public boolean m9244b() {
        return this.f8725c;
    }

    /* JADX INFO: renamed from: c */
    public final Map<String, String> m9245c() {
        return new HashMap(this.f8724b);
    }
}
