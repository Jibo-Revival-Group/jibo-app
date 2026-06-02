package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.view.View;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzcxe;
import com.google.api.client.googleapis.extensions.android.accounts.GoogleAccountManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzr {

    /* JADX INFO: renamed from: a */
    private final Account f6632a;

    /* JADX INFO: renamed from: b */
    private final Set<Scope> f6633b;

    /* JADX INFO: renamed from: c */
    private final Set<Scope> f6634c;

    /* JADX INFO: renamed from: d */
    private final Map<Api<?>, zzt> f6635d;

    /* JADX INFO: renamed from: e */
    private final int f6636e;

    /* JADX INFO: renamed from: f */
    private final View f6637f;

    /* JADX INFO: renamed from: g */
    private final String f6638g;

    /* JADX INFO: renamed from: h */
    private final String f6639h;

    /* JADX INFO: renamed from: i */
    private final zzcxe f6640i;

    /* JADX INFO: renamed from: j */
    private Integer f6641j;

    public zzr(Account account, Set<Scope> set, Map<Api<?>, zzt> map, int i, View view, String str, String str2, zzcxe zzcxeVar) {
        this.f6632a = account;
        this.f6633b = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        this.f6635d = map == null ? Collections.EMPTY_MAP : map;
        this.f6637f = view;
        this.f6636e = i;
        this.f6638g = str;
        this.f6639h = str2;
        this.f6640i = zzcxeVar;
        HashSet hashSet = new HashSet(this.f6633b);
        Iterator<zzt> it = this.f6635d.values().iterator();
        while (it.hasNext()) {
            hashSet.addAll(it.next().f6648a);
        }
        this.f6634c = Collections.unmodifiableSet(hashSet);
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public final String m7449a() {
        if (this.f6632a != null) {
            return this.f6632a.name;
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public final Set<Scope> m7450a(Api<?> api) {
        zzt zztVar = this.f6635d.get(api);
        if (zztVar == null || zztVar.f6648a.isEmpty()) {
            return this.f6633b;
        }
        HashSet hashSet = new HashSet(this.f6633b);
        hashSet.addAll(zztVar.f6648a);
        return hashSet;
    }

    /* JADX INFO: renamed from: a */
    public final void m7451a(Integer num) {
        this.f6641j = num;
    }

    /* JADX INFO: renamed from: b */
    public final Account m7452b() {
        return this.f6632a;
    }

    /* JADX INFO: renamed from: c */
    public final Account m7453c() {
        return this.f6632a != null ? this.f6632a : new Account("<<default account>>", GoogleAccountManager.ACCOUNT_TYPE);
    }

    /* JADX INFO: renamed from: d */
    public final Set<Scope> m7454d() {
        return this.f6633b;
    }

    /* JADX INFO: renamed from: e */
    public final Set<Scope> m7455e() {
        return this.f6634c;
    }

    /* JADX INFO: renamed from: f */
    public final Map<Api<?>, zzt> m7456f() {
        return this.f6635d;
    }

    /* JADX INFO: renamed from: g */
    public final String m7457g() {
        return this.f6638g;
    }

    /* JADX INFO: renamed from: h */
    public final String m7458h() {
        return this.f6639h;
    }

    /* JADX INFO: renamed from: i */
    public final zzcxe m7459i() {
        return this.f6640i;
    }

    /* JADX INFO: renamed from: j */
    public final Integer m7460j() {
        return this.f6641j;
    }
}
