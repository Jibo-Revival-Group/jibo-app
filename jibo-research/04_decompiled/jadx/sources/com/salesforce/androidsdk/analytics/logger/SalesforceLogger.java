package com.salesforce.androidsdk.analytics.logger;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class SalesforceLogger {

    /* JADX INFO: renamed from: a */
    private static final ExecutorService f14013a = Executors.newFixedThreadPool(1);

    /* JADX INFO: renamed from: b */
    private static Map<String, SalesforceLogger> f14014b;

    /* JADX INFO: renamed from: c */
    private FileLogger f14015c;

    /* JADX INFO: renamed from: d */
    private Context f14016d;

    /* JADX INFO: renamed from: e */
    private String f14017e;

    /* JADX INFO: renamed from: f */
    private Level f14018f;

    public enum Level {
        OFF,
        ERROR,
        WARN,
        INFO,
        DEBUG,
        VERBOSE
    }

    /* JADX INFO: renamed from: a */
    public static synchronized SalesforceLogger m14312a(String str, Context context) {
        if (f14014b == null) {
            f14014b = new HashMap();
        }
        if (!f14014b.containsKey(str)) {
            f14014b.put(str, new SalesforceLogger(str, context));
        }
        return f14014b.get(str);
    }

    private SalesforceLogger(String str, Context context) {
        this.f14016d = context;
        this.f14017e = str;
        m14317c();
        try {
            this.f14015c = new FileLogger(context, str);
        } catch (IOException e) {
            Log.e("SalesforceLogger", "Couldn't create file logger", e);
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m14315a() {
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo;
        try {
            PackageManager packageManager = this.f14016d.getPackageManager();
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo(this.f14016d.getPackageName(), 0)) != null && (applicationInfo = packageInfo.applicationInfo) != null) {
                if ((applicationInfo.flags & 2) == 0) {
                    return false;
                }
            }
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return true;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m14320a(String str, String str2) {
        m14318a(Level.ERROR, str, str2);
    }

    /* JADX INFO: renamed from: a */
    public void m14321a(String str, String str2, Throwable th) {
        m14319a(Level.ERROR, str, str2, th);
    }

    /* JADX INFO: renamed from: b */
    public void m14322b(String str, String str2) {
        m14318a(Level.WARN, str, str2);
    }

    /* JADX INFO: renamed from: b */
    public void m14323b(String str, String str2, Throwable th) {
        m14319a(Level.WARN, str, str2, th);
    }

    /* JADX INFO: renamed from: c */
    public void m14324c(String str, String str2) {
        m14318a(Level.INFO, str, str2);
    }

    /* JADX INFO: renamed from: c */
    public void m14325c(String str, String str2, Throwable th) {
        m14319a(Level.INFO, str, str2, th);
    }

    /* JADX INFO: renamed from: d */
    public void m14326d(String str, String str2) {
        m14318a(Level.DEBUG, str, str2);
    }

    /* JADX INFO: renamed from: d */
    public void m14327d(String str, String str2, Throwable th) {
        m14319a(Level.DEBUG, str, str2, th);
    }

    /* JADX INFO: renamed from: a */
    public void m14318a(Level level, String str, String str2) {
        switch (level) {
            case OFF:
                break;
            case ERROR:
                Log.e(str, str2);
                break;
            case WARN:
                Log.w(str, str2);
                break;
            case INFO:
                Log.i(str, str2);
                break;
            case DEBUG:
                Log.d(str, str2);
                break;
            case VERBOSE:
                Log.v(str, str2);
                break;
            default:
                Log.d(str, str2);
                break;
        }
        if (level != Level.OFF) {
            m14314a(m14316b(), level, str, str2, null);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m14319a(Level level, String str, String str2, Throwable th) {
        switch (level) {
            case OFF:
                break;
            case ERROR:
                Log.e(str, str2, th);
                break;
            case WARN:
                Log.w(str, str2, th);
                break;
            case INFO:
                Log.i(str, str2, th);
                break;
            case DEBUG:
                Log.d(str, str2, th);
                break;
            case VERBOSE:
                Log.v(str, str2, th);
                break;
            default:
                Log.d(str, str2, th);
                break;
        }
        if (level != Level.OFF) {
            m14314a(m14316b(), level, str, str2, th);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m14314a(final String str, final Level level, final String str2, final String str3, final Throwable th) {
        f14013a.execute(new Runnable() { // from class: com.salesforce.androidsdk.analytics.logger.SalesforceLogger.1
            @Override // java.lang.Runnable
            public void run() {
                String str4;
                if (SalesforceLogger.this.f14015c != null) {
                    if (th != null) {
                        str4 = String.format("TIME: %s, LEVEL: %s, TAG: %s, MESSAGE: %s, EXCEPTION: %s", str, level, str2, str3, Log.getStackTraceString(th));
                    } else {
                        str4 = String.format("TIME: %s, LEVEL: %s, TAG: %s, MESSAGE: %s", str, level, str2, str3);
                    }
                    SalesforceLogger.this.f14015c.m14310a(str4);
                }
            }
        });
    }

    /* JADX INFO: renamed from: b */
    private String m14316b() {
        return new SimpleDateFormat("MM-dd HH:mm:ss.SSS").format(new Date(System.currentTimeMillis()));
    }

    /* JADX INFO: renamed from: a */
    private synchronized void m14313a(Level level) {
        SharedPreferences.Editor editorEdit = this.f14016d.getSharedPreferences("sf_logger_prefs", 0).edit();
        editorEdit.putString(this.f14017e, level.toString());
        editorEdit.commit();
        this.f14018f = level;
    }

    /* JADX INFO: renamed from: c */
    private void m14317c() {
        SharedPreferences sharedPreferences = this.f14016d.getSharedPreferences("sf_logger_prefs", 0);
        Level level = Level.DEBUG;
        if (!m14315a()) {
            level = Level.ERROR;
        }
        if (!sharedPreferences.contains(this.f14017e)) {
            m14313a(level);
        }
        this.f14018f = Level.valueOf(sharedPreferences.getString(this.f14017e, level.toString()));
    }
}
