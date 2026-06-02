package com.google.android.gms.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class zzcgv {

    /* JADX INFO: renamed from: a */
    final String f7138a;

    /* JADX INFO: renamed from: b */
    final String f7139b;

    /* JADX INFO: renamed from: c */
    final long f7140c;

    /* JADX INFO: renamed from: d */
    final long f7141d;

    /* JADX INFO: renamed from: e */
    final zzcgx f7142e;

    /* JADX INFO: renamed from: f */
    private String f7143f;

    zzcgv(zzcim zzcimVar, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzbq.m7375a(str2);
        zzbq.m7375a(str3);
        this.f7138a = str2;
        this.f7139b = str3;
        this.f7143f = TextUtils.isEmpty(str) ? null : str;
        this.f7140c = j;
        this.f7141d = j2;
        if (this.f7141d != 0 && this.f7141d > this.f7140c) {
            zzcimVar.m8233f().m8097A().m8109a("Event created with reverse previous/current timestamps. appId", zzchm.m8093a(str2));
        }
        this.f7142e = m8022a(zzcimVar, bundle);
    }

    private zzcgv(zzcim zzcimVar, String str, String str2, String str3, long j, long j2, zzcgx zzcgxVar) {
        zzbq.m7375a(str2);
        zzbq.m7375a(str3);
        zzbq.m7373a(zzcgxVar);
        this.f7138a = str2;
        this.f7139b = str3;
        this.f7143f = TextUtils.isEmpty(str) ? null : str;
        this.f7140c = j;
        this.f7141d = j2;
        if (this.f7141d != 0 && this.f7141d > this.f7140c) {
            zzcimVar.m8233f().m8097A().m8109a("Event created with reverse previous/current timestamps. appId", zzchm.m8093a(str2));
        }
        this.f7142e = zzcgxVar;
    }

    /* JADX INFO: renamed from: a */
    private static zzcgx m8022a(zzcim zzcimVar, Bundle bundle) {
        if (bundle == null || bundle.isEmpty()) {
            return new zzcgx(new Bundle());
        }
        Bundle bundle2 = new Bundle(bundle);
        Iterator<String> it = bundle2.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next == null) {
                zzcimVar.m8233f().m8106y().m8108a("Param name can't be null");
                it.remove();
            } else {
                Object objM8421a = zzcimVar.m8242o().m8421a(next, bundle2.get(next));
                if (objM8421a == null) {
                    zzcimVar.m8233f().m8097A().m8109a("Param value can't be null", zzcimVar.m8243p().m8091b(next));
                    it.remove();
                } else {
                    zzcimVar.m8242o().m8423a(bundle2, next, objM8421a);
                }
            }
        }
        return new zzcgx(bundle2);
    }

    /* JADX INFO: renamed from: a */
    final zzcgv m8023a(zzcim zzcimVar, long j) {
        return new zzcgv(zzcimVar, this.f7143f, this.f7138a, this.f7139b, this.f7140c, j, this.f7142e);
    }

    public final String toString() {
        String str = this.f7138a;
        String str2 = this.f7139b;
        String strValueOf = String.valueOf(this.f7142e);
        return new StringBuilder(String.valueOf(str).length() + 33 + String.valueOf(str2).length() + String.valueOf(strValueOf).length()).append("Event{appId='").append(str).append("', name='").append(str2).append("', params=").append(strValueOf).append("}").toString();
    }
}
