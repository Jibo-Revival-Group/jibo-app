package io.fabric.sdk.android.services.concurrency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public class PriorityTask implements Dependency<Task>, PriorityProvider, Task {

    /* JADX INFO: renamed from: a */
    private final List<Task> f14652a = new ArrayList();

    /* JADX INFO: renamed from: b */
    private final AtomicBoolean f14653b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: c */
    private final AtomicReference<Throwable> f14654c = new AtomicReference<>(null);

    @Override // io.fabric.sdk.android.services.concurrency.Dependency
    /* JADX INFO: renamed from: c */
    public synchronized Collection<Task> mo15284c() {
        return Collections.unmodifiableCollection(this.f14652a);
    }

    @Override // io.fabric.sdk.android.services.concurrency.Dependency
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public synchronized void mo15285c(Task task) {
        this.f14652a.add(task);
    }

    @Override // io.fabric.sdk.android.services.concurrency.Dependency
    /* JADX INFO: renamed from: d */
    public boolean mo15286d() {
        Iterator<Task> it = mo15284c().iterator();
        while (it.hasNext()) {
            if (!it.next().mo15302f()) {
                return false;
            }
        }
        return true;
    }

    @Override // io.fabric.sdk.android.services.concurrency.Task
    /* JADX INFO: renamed from: b */
    public synchronized void mo15301b(boolean z) {
        this.f14653b.set(z);
    }

    @Override // io.fabric.sdk.android.services.concurrency.Task
    /* JADX INFO: renamed from: f */
    public boolean mo15302f() {
        return this.f14653b.get();
    }

    /* JADX INFO: renamed from: b */
    public Priority mo5882b() {
        return Priority.NORMAL;
    }

    @Override // io.fabric.sdk.android.services.concurrency.Task
    /* JADX INFO: renamed from: a */
    public void mo15299a(Throwable th) {
        this.f14654c.set(th);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return Priority.compareTo(this, obj);
    }

    /* JADX INFO: renamed from: a */
    public static boolean m15308a(Object obj) {
        try {
            return (((Dependency) obj) == null || ((Task) obj) == null || ((PriorityProvider) obj) == null) ? false : true;
        } catch (ClassCastException e) {
            return false;
        }
    }
}
