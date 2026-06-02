package org.slf4j.helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.event.SubstituteLoggingEvent;

/* JADX INFO: loaded from: classes2.dex */
public class SubstituteLoggerFactory implements ILoggerFactory {

    /* JADX INFO: renamed from: a */
    boolean f16226a = false;

    /* JADX INFO: renamed from: b */
    final Map<String, SubstituteLogger> f16227b = new HashMap();

    /* JADX INFO: renamed from: c */
    final LinkedBlockingQueue<SubstituteLoggingEvent> f16228c = new LinkedBlockingQueue<>();

    @Override // org.slf4j.ILoggerFactory
    /* JADX INFO: renamed from: a */
    public synchronized Logger mo17017a(String str) {
        SubstituteLogger substituteLogger;
        substituteLogger = this.f16227b.get(str);
        if (substituteLogger == null) {
            substituteLogger = new SubstituteLogger(str, this.f16228c, this.f16226a);
            this.f16227b.put(str, substituteLogger);
        }
        return substituteLogger;
    }

    /* JADX INFO: renamed from: a */
    public List<SubstituteLogger> m17063a() {
        return new ArrayList(this.f16227b.values());
    }

    /* JADX INFO: renamed from: b */
    public LinkedBlockingQueue<SubstituteLoggingEvent> m17064b() {
        return this.f16228c;
    }

    /* JADX INFO: renamed from: c */
    public void m17065c() {
        this.f16226a = true;
    }

    /* JADX INFO: renamed from: d */
    public void m17066d() {
        this.f16227b.clear();
        this.f16228c.clear();
    }
}
