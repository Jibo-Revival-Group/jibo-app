package org.slf4j.event;

import org.slf4j.Marker;
import org.slf4j.helpers.SubstituteLogger;

/* JADX INFO: loaded from: classes2.dex */
public class SubstituteLoggingEvent implements LoggingEvent {

    /* JADX INFO: renamed from: a */
    Level f16208a;

    /* JADX INFO: renamed from: b */
    Marker f16209b;

    /* JADX INFO: renamed from: c */
    String f16210c;

    /* JADX INFO: renamed from: d */
    SubstituteLogger f16211d;

    /* JADX INFO: renamed from: e */
    String f16212e;

    /* JADX INFO: renamed from: f */
    String f16213f;

    /* JADX INFO: renamed from: g */
    Object[] f16214g;

    /* JADX INFO: renamed from: h */
    long f16215h;

    /* JADX INFO: renamed from: i */
    Throwable f16216i;

    /* JADX INFO: renamed from: a */
    public void m17049a(Level level) {
        this.f16208a = level;
    }

    /* JADX INFO: renamed from: a */
    public void m17048a(Marker marker) {
        this.f16209b = marker;
    }

    /* JADX INFO: renamed from: a */
    public void m17046a(String str) {
        this.f16210c = str;
    }

    /* JADX INFO: renamed from: a */
    public SubstituteLogger m17044a() {
        return this.f16211d;
    }

    /* JADX INFO: renamed from: a */
    public void m17050a(SubstituteLogger substituteLogger) {
        this.f16211d = substituteLogger;
    }

    /* JADX INFO: renamed from: b */
    public void m17052b(String str) {
        this.f16213f = str;
    }

    /* JADX INFO: renamed from: a */
    public void m17051a(Object[] objArr) {
        this.f16214g = objArr;
    }

    /* JADX INFO: renamed from: a */
    public void m17045a(long j) {
        this.f16215h = j;
    }

    /* JADX INFO: renamed from: c */
    public void m17053c(String str) {
        this.f16212e = str;
    }

    /* JADX INFO: renamed from: a */
    public void m17047a(Throwable th) {
        this.f16216i = th;
    }
}
