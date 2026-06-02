package com.crashlytics.android.answers;

import android.app.Activity;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class SessionEvent {

    /* JADX INFO: renamed from: a */
    public final SessionEventMetadata f5075a;

    /* JADX INFO: renamed from: b */
    public final long f5076b;

    /* JADX INFO: renamed from: c */
    public final Type f5077c;

    /* JADX INFO: renamed from: d */
    public final Map<String, String> f5078d;

    /* JADX INFO: renamed from: e */
    public final String f5079e;

    /* JADX INFO: renamed from: f */
    public final Map<String, Object> f5080f;

    /* JADX INFO: renamed from: g */
    public final String f5081g;

    /* JADX INFO: renamed from: h */
    public final Map<String, Object> f5082h;

    /* JADX INFO: renamed from: i */
    private String f5083i;

    enum Type {
        START,
        RESUME,
        PAUSE,
        STOP,
        CRASH,
        INSTALL,
        CUSTOM,
        PREDEFINED
    }

    /* JADX INFO: renamed from: a */
    public static Builder m5674a(Type type, Activity activity) {
        return new Builder(type).m5677a(Collections.singletonMap("activity", activity.getClass().getName()));
    }

    /* JADX INFO: renamed from: a */
    public static Builder m5673a(long j) {
        return new Builder(Type.INSTALL).m5677a(Collections.singletonMap("installedAt", String.valueOf(j)));
    }

    /* JADX INFO: renamed from: a */
    public static Builder m5675a(String str) {
        return new Builder(Type.CRASH).m5677a(Collections.singletonMap("sessionId", str));
    }

    /* JADX INFO: renamed from: a */
    public static Builder m5676a(String str, String str2) {
        return m5675a(str).m5679b(Collections.singletonMap("exceptionName", str2));
    }

    private SessionEvent(SessionEventMetadata sessionEventMetadata, long j, Type type, Map<String, String> map, String str, Map<String, Object> map2, String str2, Map<String, Object> map3) {
        this.f5075a = sessionEventMetadata;
        this.f5076b = j;
        this.f5077c = type;
        this.f5078d = map;
        this.f5079e = str;
        this.f5080f = map2;
        this.f5081g = str2;
        this.f5082h = map3;
    }

    static class Builder {

        /* JADX INFO: renamed from: a */
        final Type f5084a;

        /* JADX INFO: renamed from: b */
        final long f5085b = System.currentTimeMillis();

        /* JADX INFO: renamed from: c */
        Map<String, String> f5086c = null;

        /* JADX INFO: renamed from: d */
        String f5087d = null;

        /* JADX INFO: renamed from: e */
        Map<String, Object> f5088e = null;

        /* JADX INFO: renamed from: f */
        String f5089f = null;

        /* JADX INFO: renamed from: g */
        Map<String, Object> f5090g = null;

        public Builder(Type type) {
            this.f5084a = type;
        }

        /* JADX INFO: renamed from: a */
        public Builder m5677a(Map<String, String> map) {
            this.f5086c = map;
            return this;
        }

        /* JADX INFO: renamed from: b */
        public Builder m5679b(Map<String, Object> map) {
            this.f5088e = map;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public SessionEvent m5678a(SessionEventMetadata sessionEventMetadata) {
            return new SessionEvent(sessionEventMetadata, this.f5085b, this.f5084a, this.f5086c, this.f5087d, this.f5088e, this.f5089f, this.f5090g);
        }
    }

    public String toString() {
        if (this.f5083i == null) {
            this.f5083i = "[" + getClass().getSimpleName() + ": timestamp=" + this.f5076b + ", type=" + this.f5077c + ", details=" + this.f5078d + ", customType=" + this.f5079e + ", customAttributes=" + this.f5080f + ", predefinedType=" + this.f5081g + ", predefinedAttributes=" + this.f5082h + ", metadata=[" + this.f5075a + "]]";
        }
        return this.f5083i;
    }
}
