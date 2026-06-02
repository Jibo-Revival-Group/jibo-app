package io.fabric.sdk.android;

import android.content.Context;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.concurrency.DependsOn;
import io.fabric.sdk.android.services.concurrency.Task;
import java.io.File;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public abstract class Kit<Result> implements Comparable<Kit> {

    /* JADX INFO: renamed from: e */
    Fabric f14529e;

    /* JADX INFO: renamed from: g */
    Context f14531g;

    /* JADX INFO: renamed from: h */
    InitializationCallback<Result> f14532h;

    /* JADX INFO: renamed from: i */
    IdManager f14533i;

    /* JADX INFO: renamed from: f */
    InitializationTask<Result> f14530f = new InitializationTask<>(this);

    /* JADX INFO: renamed from: j */
    final DependsOn f14534j = (DependsOn) getClass().getAnnotation(DependsOn.class);

    /* JADX INFO: renamed from: a */
    public abstract String mo5600a();

    /* JADX INFO: renamed from: b */
    public abstract String mo5601b();

    /* JADX INFO: renamed from: f */
    protected abstract Result mo5604f();

    /* JADX INFO: renamed from: a */
    void m15115a(Context context, Fabric fabric, InitializationCallback<Result> initializationCallback, IdManager idManager) {
        this.f14529e = fabric;
        this.f14531g = new FabricContext(context, mo5601b(), m15123t());
        this.f14532h = initializationCallback;
        this.f14533i = idManager;
    }

    /* JADX INFO: renamed from: p */
    final void m15119p() {
        this.f14530f.m15300a(this.f14529e.m15097f(), (Object[]) new Void[]{(Void) null});
    }

    /* JADX INFO: renamed from: a_ */
    protected boolean mo5607a_() {
        return true;
    }

    /* JADX INFO: renamed from: a */
    protected void m15116a(Result result) {
    }

    /* JADX INFO: renamed from: b */
    protected void m15117b(Result result) {
    }

    /* JADX INFO: renamed from: q */
    protected IdManager m15120q() {
        return this.f14533i;
    }

    /* JADX INFO: renamed from: r */
    public Context m15121r() {
        return this.f14531g;
    }

    /* JADX INFO: renamed from: s */
    public Fabric m15122s() {
        return this.f14529e;
    }

    /* JADX INFO: renamed from: t */
    public String m15123t() {
        return ".Fabric" + File.separator + mo5601b();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(Kit kit) {
        if (m15118b(kit)) {
            return 1;
        }
        if (kit.m15118b((Kit) this)) {
            return -1;
        }
        if (!m15124u() || kit.m15124u()) {
            return (m15124u() || !kit.m15124u()) ? 0 : -1;
        }
        return 1;
    }

    /* JADX INFO: renamed from: b */
    boolean m15118b(Kit kit) {
        if (!m15124u()) {
            return false;
        }
        for (Class<?> cls : this.f14534j.m15297a()) {
            if (cls.isAssignableFrom(kit.getClass())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: u */
    boolean m15124u() {
        return this.f14534j != null;
    }

    /* JADX INFO: renamed from: v */
    protected Collection<Task> m15125v() {
        return this.f14530f.mo15284c();
    }
}
