package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
final class zzau extends zzay {

    /* JADX INFO: renamed from: a */
    private final ArrayList<Api.zze> f6221a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzao f6222b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzau(zzao zzaoVar, ArrayList<Api.zze> arrayList) {
        super(zzaoVar, null);
        this.f6222b = zzaoVar;
        this.f6221a = arrayList;
    }

    @Override // com.google.android.gms.common.api.internal.zzay
    /* JADX INFO: renamed from: a */
    public final void mo7055a() {
        this.f6222b.f6191a.f6269d.f6232c = this.f6222b.m7049i();
        ArrayList<Api.zze> arrayList = this.f6221a;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Api.zze zzeVar = arrayList.get(i);
            i++;
            zzeVar.m6857a(this.f6222b.f6205o, this.f6222b.f6191a.f6269d.f6232c);
        }
    }
}
