package io.fabric.sdk.android.services.common;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Crash {

    /* JADX INFO: renamed from: a */
    private final String f14572a;

    /* JADX INFO: renamed from: b */
    private final String f14573b;

    public Crash(String str, String str2) {
        this.f14572a = str;
        this.f14573b = str2;
    }

    /* JADX INFO: renamed from: a */
    public String m15213a() {
        return this.f14572a;
    }

    /* JADX INFO: renamed from: b */
    public String m15214b() {
        return this.f14573b;
    }

    public static class LoggedException extends Crash {
        public LoggedException(String str, String str2) {
            super(str, str2);
        }
    }

    public static class FatalException extends Crash {
        public FatalException(String str, String str2) {
            super(str, str2);
        }
    }
}
