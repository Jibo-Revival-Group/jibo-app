package com.salesforce.android.service.common.utilities.lifecycle;

import com.salesforce.android.service.common.utilities.lifecycle.LifecycleMetric;
import com.salesforce.android.service.common.utilities.lifecycle.LifecycleMetricWatcher;
import com.salesforce.android.service.common.utilities.lifecycle.LifecycleState;
import com.salesforce.android.service.common.utilities.lifecycle.LifecycleStateWatcher;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.lang.Enum;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class LifecycleEvaluator<S extends Enum<S> & LifecycleState<M>, M extends Enum<M> & LifecycleMetric> {

    /* JADX INFO: Incorrect field signature: [TS; */
    /* JADX INFO: renamed from: a */
    private final Enum[] f13886a;

    /* JADX INFO: renamed from: b */
    private final EnumSet<M> f13887b;

    /* JADX INFO: Incorrect field signature: TS; */
    /* JADX INFO: renamed from: c */
    private Enum f13888c;

    /* JADX INFO: Incorrect field signature: TS; */
    /* JADX INFO: renamed from: d */
    private Enum f13889d;

    /* JADX INFO: Incorrect field signature: TS; */
    /* JADX INFO: renamed from: e */
    private Enum f13890e;

    /* JADX INFO: renamed from: f */
    private final ServiceLogger f13891f;

    /* JADX INFO: renamed from: g */
    private final Set<LifecycleListener<S, M>> f13892g;

    /* JADX INFO: renamed from: h */
    private final LifecycleMetricWatcher<S, M> f13893h;

    /* JADX INFO: renamed from: i */
    private final LifecycleStateWatcher<S, M> f13894i;

    LifecycleEvaluator(Class<S> cls, Class<M> cls2, LifecycleMetricWatcher<S, M> lifecycleMetricWatcher, LifecycleStateWatcher<S, M> lifecycleStateWatcher, ServiceLogger serviceLogger) {
        this.f13886a = (Enum[]) cls.getEnumConstants();
        this.f13887b = EnumSet.noneOf(cls2);
        Enum r0 = this.f13886a[0];
        this.f13888c = r0;
        this.f13889d = r0;
        this.f13892g = Collections.newSetFromMap(new ConcurrentHashMap());
        this.f13893h = lifecycleMetricWatcher;
        this.f13894i = lifecycleStateWatcher;
        this.f13891f = serviceLogger;
        this.f13890e = null;
    }

    /* JADX WARN: Incorrect types in method signature: (TS;)Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator<TS;TM;>; */
    /* JADX INFO: renamed from: a */
    public LifecycleEvaluator m14162a(Enum r1) {
        this.f13889d = r1;
        return this;
    }

    /* JADX WARN: Incorrect types in method signature: (TM;Z)Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator<TS;TM;>; */
    /* JADX INFO: renamed from: a */
    public LifecycleEvaluator m14163a(Enum r6, boolean z) {
        if (z) {
            this.f13887b.add(r6);
        } else {
            this.f13887b.remove(r6);
        }
        this.f13891f.mo14189b("Metric {}.{} has been set to {}", r6.getClass().getSimpleName(), r6.name(), Boolean.valueOf(z));
        return this;
    }

    /* JADX WARN: Incorrect types in method signature: (TM;)Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator<TS;TM;>; */
    /* JADX INFO: renamed from: b */
    public LifecycleEvaluator m14167b(Enum r2) {
        return m14163a(r2, true);
    }

    /* JADX WARN: Incorrect types in method signature: (TM;)Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleEvaluator<TS;TM;>; */
    /* JADX INFO: renamed from: c */
    public LifecycleEvaluator m14168c(Enum r2) {
        return m14163a(r2, false);
    }

    /* JADX INFO: renamed from: a */
    public void m14164a() {
        Enum r0;
        Enum enumM14169c = m14169c();
        Enum enumM14170d = m14170d();
        Iterator it = EnumSet.range((this.f13890e != null ? this.f13890e : this.f13888c).ordinal() < this.f13889d.ordinal() ? enumM14169c : this.f13889d, enumM14170d).iterator();
        while (true) {
            if (!it.hasNext()) {
                r0 = enumM14170d;
                break;
            } else {
                r0 = (Enum) it.next();
                if (!m14174f(r0)) {
                    break;
                }
            }
        }
        m14173e(r0);
        this.f13890e = null;
    }

    /* JADX INFO: renamed from: b */
    public LifecycleEvaluator<S, M> m14166b() {
        this.f13890e = this.f13889d;
        return this;
    }

    /* JADX WARN: Incorrect return type in method signature: ()TS; */
    /* JADX INFO: renamed from: c */
    public Enum m14169c() {
        return this.f13886a[0];
    }

    /* JADX WARN: Incorrect return type in method signature: ()TS; */
    /* JADX INFO: renamed from: d */
    public Enum m14170d() {
        return this.f13886a[this.f13886a.length - 1];
    }

    /* JADX WARN: Incorrect return type in method signature: ()TS; */
    /* JADX INFO: renamed from: e */
    public Enum m14172e() {
        return this.f13888c;
    }

    /* JADX INFO: renamed from: a */
    public void m14165a(LifecycleListener<S, M> lifecycleListener) {
        this.f13892g.add(lifecycleListener);
    }

    /* JADX WARN: Incorrect types in method signature: (TM;)Z */
    /* JADX INFO: renamed from: d */
    boolean m14171d(Enum r2) {
        return this.f13887b.contains(r2);
    }

    /* JADX WARN: Incorrect types in method signature: (TS;)V */
    /* JADX INFO: renamed from: e */
    void m14173e(Enum r2) {
        if (r2 != this.f13888c) {
            this.f13894i.m14184a(r2, this);
        }
    }

    /* JADX WARN: Incorrect types in method signature: (TS;)Z */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: f */
    boolean m14174f(Enum r7) {
        if (((LifecycleState) r7).getMetrics() == null) {
            return true;
        }
        for (Enum r0 : ((LifecycleState) r7).getMetrics()) {
            if (!m14171d(r0)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Incorrect types in method signature: (TM;)V */
    /* JADX INFO: renamed from: g */
    void m14175g(Enum r3) {
        Iterator<LifecycleListener<S, M>> it = this.f13892g.iterator();
        while (it.hasNext()) {
            it.next().mo13807a(r3);
        }
    }

    /* JADX WARN: Incorrect types in method signature: (TS;)V */
    /* JADX INFO: renamed from: h */
    void m14176h(Enum r4) {
        Enum r1 = this.f13888c;
        this.f13888c = r4;
        if (this.f13888c == m14170d()) {
            this.f13893h.m14181b();
            this.f13894i.m14183a();
        } else {
            this.f13893h.m14179a(this.f13888c, this);
        }
        Iterator<LifecycleListener<S, M>> it = this.f13892g.iterator();
        while (it.hasNext()) {
            it.next().mo13808a(r4, r1);
        }
    }

    public static class Builder<S extends Enum<S> & LifecycleState<M>, M extends Enum<M> & LifecycleMetric> {

        /* JADX INFO: renamed from: a */
        private LifecycleMetricWatcher<S, M> f13895a;

        /* JADX INFO: renamed from: b */
        private LifecycleStateWatcher<S, M> f13896b;

        /* JADX INFO: renamed from: c */
        private ServiceLogger f13897c;

        /* JADX INFO: renamed from: a */
        public LifecycleEvaluator<S, M> m14177a(Class<S> cls, Class<M> cls2) {
            if (this.f13895a == null) {
                this.f13895a = new LifecycleMetricWatcher.Builder().m14182a(cls);
            }
            if (this.f13896b == null) {
                this.f13896b = new LifecycleStateWatcher.Builder().m14185a(cls);
            }
            if (this.f13897c == null) {
                this.f13897c = ServiceLogging.m14204a(LifecycleEvaluator.class, String.format("LifecycleEvaluator:%s", cls.getSimpleName()));
            }
            return new LifecycleEvaluator<>(cls, cls2, this.f13895a, this.f13896b, this.f13897c);
        }
    }
}
