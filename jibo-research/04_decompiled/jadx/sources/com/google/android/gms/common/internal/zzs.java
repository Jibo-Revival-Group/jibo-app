package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.support.v4.util.ArraySet;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzcxe;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public final class zzs {

    /* JADX INFO: renamed from: a */
    private Account f6642a;

    /* JADX INFO: renamed from: b */
    private ArraySet<Scope> f6643b;

    /* JADX INFO: renamed from: d */
    private String f6645d;

    /* JADX INFO: renamed from: e */
    private String f6646e;

    /* JADX INFO: renamed from: c */
    private int f6644c = 0;

    /* JADX INFO: renamed from: f */
    private zzcxe f6647f = zzcxe.f7775a;

    /* JADX INFO: renamed from: a */
    public final zzr m7461a() {
        return new zzr(this.f6642a, this.f6643b, null, 0, null, this.f6645d, this.f6646e, this.f6647f);
    }

    /* JADX INFO: renamed from: a */
    public final zzs m7462a(Account account) {
        this.f6642a = account;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public final zzs m7463a(String str) {
        this.f6645d = str;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public final zzs m7464a(Collection<Scope> collection) {
        if (this.f6643b == null) {
            this.f6643b = new ArraySet<>();
        }
        this.f6643b.addAll(collection);
        return this;
    }

    /* JADX INFO: renamed from: b */
    public final zzs m7465b(String str) {
        this.f6646e = str;
        return this;
    }
}
