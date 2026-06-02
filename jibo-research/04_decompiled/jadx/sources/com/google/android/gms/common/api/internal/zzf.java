package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public final class zzf extends zzb<Boolean> {

    /* JADX INFO: renamed from: b */
    private zzck<?> f6399b;

    public zzf(zzck<?> zzckVar, TaskCompletionSource<Boolean> taskCompletionSource) {
        super(4, taskCompletionSource);
        this.f6399b = zzckVar;
    }

    @Override // com.google.android.gms.common.api.internal.zzb, com.google.android.gms.common.api.internal.zza
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ void mo6961a(Status status) {
        super.mo6961a(status);
    }

    @Override // com.google.android.gms.common.api.internal.zzb, com.google.android.gms.common.api.internal.zza
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ void mo6962a(zzae zzaeVar, boolean z) {
    }

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
    /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r1v4 boolean
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
        */
    @Override // com.google.android.gms.common.api.internal.zzb
    /* JADX INFO: renamed from: b */
    public final void mo7057b(com.google.android.gms.common.api.internal.zzbo<?> r5) throws android.os.RemoteException {
        /*
            r4 = this;
            java.util.Map r0 = r5.m7134c()
            com.google.android.gms.common.api.internal.zzck<?> r1 = r4.f6399b
            java.lang.Object r0 = r0.remove(r1)
            com.google.android.gms.common.api.internal.zzcr r0 = (com.google.android.gms.common.api.internal.zzcr) r0
            if (r0 == 0) goto L1f
            com.google.android.gms.common.api.internal.zzdn<com.google.android.gms.common.api.Api$zzb, ?> r1 = r0.f6357b
            com.google.android.gms.common.api.Api$zze r2 = r5.m7132b()
            com.google.android.gms.tasks.TaskCompletionSource<T> r3 = r4.f6229a
            r1.m7207a(r2, r3)
            com.google.android.gms.common.api.internal.zzcq<com.google.android.gms.common.api.Api$zzb, ?> r0 = r0.f6356a
            r0.m7175a()
        L1e:
            return
        L1f:
            com.google.android.gms.tasks.TaskCompletionSource<T> r0 = r4.f6229a
            r1 = 0
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r0.m8937b(r1)
            goto L1e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzf.mo7057b(com.google.android.gms.common.api.internal.zzbo):void");
    }
}
