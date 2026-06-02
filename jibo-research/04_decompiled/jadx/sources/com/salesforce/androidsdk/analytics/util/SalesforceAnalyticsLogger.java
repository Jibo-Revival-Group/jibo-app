package com.salesforce.androidsdk.analytics.util;

import android.content.Context;
import android.util.Log;
import com.salesforce.androidsdk.analytics.logger.SalesforceLogger;

/* JADX INFO: loaded from: classes.dex */
public class SalesforceAnalyticsLogger {
    /* JADX INFO: renamed from: a */
    public static void m14395a(Context context, String str, String str2) {
        m14393a(context, SalesforceLogger.Level.ERROR, str, str2);
    }

    /* JADX INFO: renamed from: a */
    public static void m14396a(Context context, String str, String str2, Throwable th) {
        m14394a(context, SalesforceLogger.Level.ERROR, str, str2, th);
    }

    /* JADX INFO: renamed from: b */
    public static void m14400b(Context context, String str, String str2, Throwable th) {
        m14394a(context, SalesforceLogger.Level.WARN, str, str2, th);
    }

    /* JADX INFO: renamed from: b */
    public static void m14399b(Context context, String str, String str2) {
        m14393a(context, SalesforceLogger.Level.DEBUG, str, str2);
    }

    /* JADX INFO: renamed from: a */
    private static void m14393a(Context context, SalesforceLogger.Level level, String str, String str2) {
        if (context != null) {
            SalesforceLogger.m14312a("SalesforceAnalytics", context).m14318a(level, str, str2);
        } else {
            m14397a(level, str, str2);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m14394a(Context context, SalesforceLogger.Level level, String str, String str2, Throwable th) {
        if (context != null) {
            SalesforceLogger.m14312a("SalesforceAnalytics", context).m14319a(level, str, str2, th);
        } else {
            m14398a(level, str, str2, th);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m14397a(SalesforceLogger.Level level, String str, String str2) {
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
    }

    /* JADX INFO: renamed from: a */
    private static void m14398a(SalesforceLogger.Level level, String str, String str2, Throwable th) {
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
    }
}
