package org.slf4j.helpers;

import com.facebook.internal.ServerProtocol;

/* JADX INFO: loaded from: classes2.dex */
public final class Util {

    /* JADX INFO: renamed from: a */
    private static boolean f16229a = false;

    /* JADX INFO: renamed from: a */
    public static String m17067a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("null input");
        }
        try {
            return System.getProperty(str);
        } catch (SecurityException e) {
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    public static boolean m17069b(String str) {
        String strM17067a = m17067a(str);
        if (strM17067a == null) {
            return false;
        }
        return strM17067a.equalsIgnoreCase(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
    }

    /* JADX INFO: renamed from: a */
    public static final void m17068a(String str, Throwable th) {
        System.err.println(str);
        System.err.println("Reported exception:");
        th.printStackTrace();
    }

    /* JADX INFO: renamed from: c */
    public static final void m17070c(String str) {
        System.err.println("SLF4J: " + str);
    }
}
