package org.slf4j.event;

import java.util.Queue;
import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.helpers.SubstituteLogger;

/* JADX INFO: loaded from: classes2.dex */
public class EventRecodingLogger implements Logger {

    /* JADX INFO: renamed from: a */
    String f16205a;

    /* JADX INFO: renamed from: b */
    SubstituteLogger f16206b;

    /* JADX INFO: renamed from: c */
    Queue<SubstituteLoggingEvent> f16207c;

    public EventRecodingLogger(SubstituteLogger substituteLogger, Queue<SubstituteLoggingEvent> queue) {
        this.f16206b = substituteLogger;
        this.f16205a = substituteLogger.m17056a();
        this.f16207c = queue;
    }

    /* JADX INFO: renamed from: a */
    private void m17042a(Level level, String str, Object[] objArr, Throwable th) {
        m17043a(level, null, str, objArr, th);
    }

    /* JADX INFO: renamed from: a */
    private void m17043a(Level level, Marker marker, String str, Object[] objArr, Throwable th) {
        SubstituteLoggingEvent substituteLoggingEvent = new SubstituteLoggingEvent();
        substituteLoggingEvent.m17045a(System.currentTimeMillis());
        substituteLoggingEvent.m17049a(level);
        substituteLoggingEvent.m17050a(this.f16206b);
        substituteLoggingEvent.m17046a(this.f16205a);
        substituteLoggingEvent.m17048a(marker);
        substituteLoggingEvent.m17052b(str);
        substituteLoggingEvent.m17051a(objArr);
        substituteLoggingEvent.m17047a(th);
        substituteLoggingEvent.m17053c(Thread.currentThread().getName());
        this.f16207c.add(substituteLoggingEvent);
    }

    @Override // org.slf4j.Logger
    /* JADX INFO: renamed from: a */
    public void mo17018a(String str) {
        m17042a(Level.TRACE, str, null, null);
    }

    @Override // org.slf4j.Logger
    /* JADX INFO: renamed from: b */
    public void mo17023b(String str) {
        m17042a(Level.INFO, str, null, null);
    }

    @Override // org.slf4j.Logger
    /* JADX INFO: renamed from: a */
    public void mo17019a(String str, Object obj) {
        m17042a(Level.INFO, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.Logger
    /* JADX INFO: renamed from: a */
    public void mo17021a(String str, Throwable th) {
        m17042a(Level.INFO, str, null, th);
    }

    @Override // org.slf4j.Logger
    /* JADX INFO: renamed from: a */
    public void mo17020a(String str, Object obj, Object obj2) {
        m17042a(Level.WARN, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.Logger
    /* JADX INFO: renamed from: a */
    public void mo17022a(String str, Object... objArr) {
        m17042a(Level.ERROR, str, objArr, null);
    }
}
