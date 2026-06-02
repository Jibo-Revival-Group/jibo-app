package com.google.common.base;

import java.util.Locale;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
final class Platform {

    /* JADX INFO: renamed from: a */
    private static final Logger f8555a = Logger.getLogger(Platform.class.getName());

    /* JADX INFO: renamed from: b */
    private static final PatternCompiler f8556b = m9012b();

    private Platform() {
    }

    /* JADX INFO: renamed from: a */
    static long m9010a() {
        return System.nanoTime();
    }

    /* JADX INFO: renamed from: a */
    static String m9011a(double d) {
        return String.format(Locale.ROOT, "%.4g", Double.valueOf(d));
    }

    /* JADX INFO: renamed from: b */
    private static PatternCompiler m9012b() {
        return new JdkPatternCompiler();
    }

    private static final class JdkPatternCompiler implements PatternCompiler {
        private JdkPatternCompiler() {
        }
    }
}
