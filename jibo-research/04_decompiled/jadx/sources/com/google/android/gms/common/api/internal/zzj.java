package com.google.android.gms.common.api.internal;

import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzj {

    /* JADX INFO: renamed from: d */
    private int f6412d;

    /* JADX INFO: renamed from: b */
    private final ArrayMap<zzh<?>, String> f6410b = new ArrayMap<>();

    /* JADX INFO: renamed from: c */
    private final TaskCompletionSource<Map<zzh<?>, String>> f6411c = new TaskCompletionSource<>();

    /* JADX INFO: renamed from: e */
    private boolean f6413e = false;

    /* JADX INFO: renamed from: a */
    private final ArrayMap<zzh<?>, ConnectionResult> f6409a = new ArrayMap<>();

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public zzj(Iterable<? extends GoogleApi<?>> iterable) {
        Iterator<? extends GoogleApi<?>> it = iterable.iterator();
        while (it.hasNext()) {
            this.f6409a.put(it.next().m6877b(), null);
        }
        this.f6412d = this.f6409a.keySet().size();
    }

    /* JADX INFO: renamed from: a */
    public final Set<zzh<?>> m7215a() {
        return this.f6409a.keySet();
    }

    /* JADX INFO: renamed from: a */
    public final void m7216a(zzh<?> zzhVar, ConnectionResult connectionResult, String str) {
        this.f6409a.put(zzhVar, connectionResult);
        this.f6410b.put(zzhVar, str);
        this.f6412d--;
        if (!connectionResult.m6821b()) {
            this.f6413e = true;
        }
        if (this.f6412d == 0) {
            if (!this.f6413e) {
                this.f6411c.m8935a(this.f6410b);
            } else {
                this.f6411c.m8934a(new AvailabilityException(this.f6409a));
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final Task<Map<zzh<?>, String>> m7217b() {
        return this.f6411c.m8933a();
    }
}
