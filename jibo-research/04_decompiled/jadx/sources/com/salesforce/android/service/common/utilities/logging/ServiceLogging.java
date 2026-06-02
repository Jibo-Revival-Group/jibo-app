package com.salesforce.android.service.common.utilities.logging;

import android.util.Log;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ServiceLogging {

    /* JADX INFO: renamed from: a */
    public static final ServiceLoggingSink f13915a = new LogCatSink();

    /* JADX INFO: renamed from: b */
    private static int f13916b = 6;

    /* JADX INFO: renamed from: c */
    private static final Set<ServiceLoggingSink> f13917c = new HashSet();

    /* JADX INFO: renamed from: d */
    private static final Set<String> f13918d = new HashSet();

    /* JADX INFO: renamed from: a */
    public static ServiceLogger m14203a(Class<?> cls) {
        return m14204a(cls, null);
    }

    /* JADX INFO: renamed from: a */
    public static ServiceLogger m14204a(Class<?> cls, String str) {
        return ServiceLoggerImpl.m14196a(cls.getSimpleName(), str);
    }

    /* JADX INFO: renamed from: a */
    public static int m14202a() {
        return f13916b;
    }

    /* JADX INFO: renamed from: b */
    static Set<ServiceLoggingSink> m14206b() {
        return f13917c;
    }

    /* JADX INFO: renamed from: a */
    static boolean m14205a(String str) {
        return !f13918d.contains(str);
    }

    private static class LogCatSink implements ServiceLoggingSink {
        LogCatSink() {
        }

        @Override // com.salesforce.android.service.common.utilities.logging.ServiceLoggingSink
        /* JADX INFO: renamed from: a */
        public void mo14207a(int i, String str, String str2) {
            switch (i) {
                case 1:
                    Log.v(str, str2);
                    break;
                case 2:
                    Log.d(str, str2);
                    break;
                case 3:
                    Log.i(str, str2);
                    break;
                case 4:
                    Log.w(str, str2);
                    break;
                case 5:
                    Log.e(str, str2);
                    break;
            }
        }
    }
}
