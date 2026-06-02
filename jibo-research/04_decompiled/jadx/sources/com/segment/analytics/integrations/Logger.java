package com.segment.analytics.integrations;

import android.util.Log;
import com.segment.analytics.Analytics;

/* JADX INFO: loaded from: classes.dex */
public final class Logger {
    private static final String DEFAULT_TAG = "Analytics";
    public final Analytics.LogLevel logLevel;
    private final String tag;

    public Logger(String str, Analytics.LogLevel logLevel) {
        this.tag = str;
        this.logLevel = logLevel;
    }

    public void verbose(String str, Object... objArr) {
        if (shouldLog(Analytics.LogLevel.VERBOSE)) {
            Log.v(this.tag, String.format(str, objArr));
        }
    }

    public void info(String str, Object... objArr) {
        if (shouldLog(Analytics.LogLevel.INFO)) {
            Log.i(this.tag, String.format(str, objArr));
        }
    }

    public void debug(String str, Object... objArr) {
        if (shouldLog(Analytics.LogLevel.DEBUG)) {
            Log.d(this.tag, String.format(str, objArr));
        }
    }

    public void error(Throwable th, String str, Object... objArr) {
        if (shouldLog(Analytics.LogLevel.INFO)) {
            Log.e(this.tag, String.format(str, objArr), th);
        }
    }

    public Logger subLog(String str) {
        return new Logger("Analytics-" + str, this.logLevel);
    }

    public static Logger with(Analytics.LogLevel logLevel) {
        return new Logger(DEFAULT_TAG, logLevel);
    }

    private boolean shouldLog(Analytics.LogLevel logLevel) {
        return this.logLevel.ordinal() >= logLevel.ordinal();
    }
}
