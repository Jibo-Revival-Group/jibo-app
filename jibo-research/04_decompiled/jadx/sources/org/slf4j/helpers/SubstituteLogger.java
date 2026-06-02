package org.slf4j.helpers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Queue;
import org.slf4j.Logger;
import org.slf4j.event.EventRecodingLogger;
import org.slf4j.event.LoggingEvent;
import org.slf4j.event.SubstituteLoggingEvent;

/* JADX INFO: loaded from: classes2.dex */
public class SubstituteLogger implements Logger {

    /* JADX INFO: renamed from: a */
    private final String f16219a;

    /* JADX INFO: renamed from: b */
    private volatile Logger f16220b;

    /* JADX INFO: renamed from: c */
    private Boolean f16221c;

    /* JADX INFO: renamed from: d */
    private Method f16222d;

    /* JADX INFO: renamed from: e */
    private EventRecodingLogger f16223e;

    /* JADX INFO: renamed from: f */
    private Queue<SubstituteLoggingEvent> f16224f;

    /* JADX INFO: renamed from: g */
    private final boolean f16225g;

    public SubstituteLogger(String str, Queue<SubstituteLoggingEvent> queue, boolean z) {
        this.f16219a = str;
        this.f16224f = queue;
        this.f16225g = z;
    }

    /* JADX INFO: renamed from: a */
    public String m17056a() {
        return this.f16219a;
    }

    @Override // org.slf4j.Logger
    /* JADX INFO: renamed from: a */
    public void mo17018a(String str) {
        m17059b().mo17018a(str);
    }

    @Override // org.slf4j.Logger
    /* JADX INFO: renamed from: b */
    public void mo17023b(String str) {
        m17059b().mo17023b(str);
    }

    @Override // org.slf4j.Logger
    /* JADX INFO: renamed from: a */
    public void mo17019a(String str, Object obj) {
        m17059b().mo17019a(str, obj);
    }

    @Override // org.slf4j.Logger
    /* JADX INFO: renamed from: a */
    public void mo17021a(String str, Throwable th) {
        m17059b().mo17021a(str, th);
    }

    @Override // org.slf4j.Logger
    /* JADX INFO: renamed from: a */
    public void mo17020a(String str, Object obj, Object obj2) {
        m17059b().mo17020a(str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    /* JADX INFO: renamed from: a */
    public void mo17022a(String str, Object... objArr) {
        m17059b().mo17022a(str, objArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f16219a.equals(((SubstituteLogger) obj).f16219a);
    }

    public int hashCode() {
        return this.f16219a.hashCode();
    }

    /* JADX INFO: renamed from: b */
    Logger m17059b() {
        if (this.f16220b != null) {
            return this.f16220b;
        }
        if (this.f16225g) {
            return NOPLogger.f16217a;
        }
        return m17055f();
    }

    /* JADX INFO: renamed from: f */
    private Logger m17055f() {
        if (this.f16223e == null) {
            this.f16223e = new EventRecodingLogger(this, this.f16224f);
        }
        return this.f16223e;
    }

    /* JADX INFO: renamed from: a */
    public void m17057a(Logger logger) {
        this.f16220b = logger;
    }

    /* JADX INFO: renamed from: c */
    public boolean m17060c() {
        if (this.f16221c != null) {
            return this.f16221c.booleanValue();
        }
        try {
            this.f16222d = this.f16220b.getClass().getMethod("log", LoggingEvent.class);
            this.f16221c = Boolean.TRUE;
        } catch (NoSuchMethodException e) {
            this.f16221c = Boolean.FALSE;
        }
        return this.f16221c.booleanValue();
    }

    /* JADX INFO: renamed from: a */
    public void m17058a(LoggingEvent loggingEvent) {
        if (m17060c()) {
            try {
                this.f16222d.invoke(this.f16220b, loggingEvent);
            } catch (IllegalAccessException e) {
            } catch (IllegalArgumentException e2) {
            } catch (InvocationTargetException e3) {
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public boolean m17061d() {
        return this.f16220b == null;
    }

    /* JADX INFO: renamed from: e */
    public boolean m17062e() {
        return this.f16220b instanceof NOPLogger;
    }
}
