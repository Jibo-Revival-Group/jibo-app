package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Scope;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class zza implements Comparator {

    /* JADX INFO: renamed from: a */
    static final Comparator f6052a = new zza();

    private zza() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ((Scope) obj).m6933a().compareTo(((Scope) obj2).m6933a());
    }
}
