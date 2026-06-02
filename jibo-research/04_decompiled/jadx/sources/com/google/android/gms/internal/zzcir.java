package com.google.android.gms.internal;

import android.os.Binder;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzx;
import com.google.android.gms.common.zzp;
import com.google.android.gms.common.zzq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes.dex */
public final class zzcir extends zzchf {

    /* JADX INFO: renamed from: a */
    private final zzcim f7384a;

    /* JADX INFO: renamed from: b */
    private Boolean f7385b;

    /* JADX INFO: renamed from: c */
    private String f7386c;

    public zzcir(zzcim zzcimVar) {
        this(zzcimVar, null);
    }

    private zzcir(zzcim zzcimVar, String str) {
        zzbq.m7373a(zzcimVar);
        this.f7384a = zzcimVar;
        this.f7386c = null;
    }

    /* JADX INFO: renamed from: a */
    private final void m8256a(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            this.f7384a.m8233f().m8106y().m8108a("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        if (z) {
            try {
                if (this.f7385b == null) {
                    this.f7385b = Boolean.valueOf("com.google.android.gms".equals(this.f7386c) || zzx.m7524a(this.f7384a.m8247t(), Binder.getCallingUid()) || zzq.m7546a(this.f7384a.m8247t()).m7550a(Binder.getCallingUid()));
                }
                if (this.f7385b.booleanValue()) {
                    return;
                }
            } catch (SecurityException e) {
                this.f7384a.m8233f().m8106y().m8109a("Measurement Service called with invalid calling package. appId", zzchm.m8093a(str));
                throw e;
            }
        }
        if (this.f7386c == null && zzp.zzb(this.f7384a.m8247t(), Binder.getCallingUid(), str)) {
            this.f7386c = str;
        }
        if (str.equals(this.f7386c)) {
        } else {
            throw new SecurityException(String.format("Unknown calling package name '%s'.", str));
        }
    }

    /* JADX INFO: renamed from: b */
    private final void m8257b(zzcgi zzcgiVar, boolean z) {
        zzbq.m7373a(zzcgiVar);
        m8256a(zzcgiVar.f7087a, false);
        this.f7384a.m8242o().m8438f(zzcgiVar.f7088b);
    }

    @Override // com.google.android.gms.internal.zzche
    /* JADX INFO: renamed from: a */
    public final List<zzcln> mo8042a(zzcgi zzcgiVar, boolean z) {
        m8257b(zzcgiVar, false);
        try {
            List<zzclp> list = (List) this.f7384a.m8235h().m8172a(new zzcjh(this, zzcgiVar)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzclp zzclpVar : list) {
                if (z || !zzclq.m8410i(zzclpVar.f7608c)) {
                    arrayList.add(new zzcln(zzclpVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.f7384a.m8233f().m8106y().m8110a("Failed to get user attributes. appId", zzchm.m8093a(zzcgiVar.f7087a), e);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.zzche
    /* JADX INFO: renamed from: a */
    public final List<zzcgl> mo8043a(String str, String str2, zzcgi zzcgiVar) {
        m8257b(zzcgiVar, false);
        try {
            return (List) this.f7384a.m8235h().m8172a(new zzciz(this, zzcgiVar, str, str2)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.f7384a.m8233f().m8106y().m8109a("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.internal.zzche
    /* JADX INFO: renamed from: a */
    public final List<zzcgl> mo8044a(String str, String str2, String str3) {
        m8256a(str, true);
        try {
            return (List) this.f7384a.m8235h().m8172a(new zzcja(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.f7384a.m8233f().m8106y().m8109a("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.internal.zzche
    /* JADX INFO: renamed from: a */
    public final List<zzcln> mo8045a(String str, String str2, String str3, boolean z) {
        m8256a(str, true);
        try {
            List<zzclp> list = (List) this.f7384a.m8235h().m8172a(new zzciy(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzclp zzclpVar : list) {
                if (z || !zzclq.m8410i(zzclpVar.f7608c)) {
                    arrayList.add(new zzcln(zzclpVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.f7384a.m8233f().m8106y().m8110a("Failed to get user attributes. appId", zzchm.m8093a(str), e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.internal.zzche
    /* JADX INFO: renamed from: a */
    public final List<zzcln> mo8046a(String str, String str2, boolean z, zzcgi zzcgiVar) {
        m8257b(zzcgiVar, false);
        try {
            List<zzclp> list = (List) this.f7384a.m8235h().m8172a(new zzcix(this, zzcgiVar, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzclp zzclpVar : list) {
                if (z || !zzclq.m8410i(zzclpVar.f7608c)) {
                    arrayList.add(new zzcln(zzclpVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.f7384a.m8233f().m8106y().m8110a("Failed to get user attributes. appId", zzchm.m8093a(zzcgiVar.f7087a), e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.internal.zzche
    /* JADX INFO: renamed from: a */
    public final void mo8047a(long j, String str, String str2, String str3) {
        this.f7384a.m8235h().m8173a(new zzcjj(this, str2, str3, str, j));
    }

    @Override // com.google.android.gms.internal.zzche
    /* JADX INFO: renamed from: a */
    public final void mo8048a(zzcgi zzcgiVar) {
        m8257b(zzcgiVar, false);
        zzcji zzcjiVar = new zzcji(this, zzcgiVar);
        if (this.f7384a.m8235h().m8176z()) {
            zzcjiVar.run();
        } else {
            this.f7384a.m8235h().m8173a(zzcjiVar);
        }
    }

    @Override // com.google.android.gms.internal.zzche
    /* JADX INFO: renamed from: a */
    public final void mo8049a(zzcgl zzcglVar) {
        zzbq.m7373a(zzcglVar);
        zzbq.m7373a(zzcglVar.f7104c);
        m8256a(zzcglVar.f7102a, true);
        zzcgl zzcglVar2 = new zzcgl(zzcglVar);
        if (zzcglVar.f7104c.m8383a() == null) {
            this.f7384a.m8235h().m8173a(new zzciv(this, zzcglVar2));
        } else {
            this.f7384a.m8235h().m8173a(new zzciw(this, zzcglVar2));
        }
    }

    @Override // com.google.android.gms.internal.zzche
    /* JADX INFO: renamed from: a */
    public final void mo8050a(zzcgl zzcglVar, zzcgi zzcgiVar) {
        zzbq.m7373a(zzcglVar);
        zzbq.m7373a(zzcglVar.f7104c);
        m8257b(zzcgiVar, false);
        zzcgl zzcglVar2 = new zzcgl(zzcglVar);
        zzcglVar2.f7102a = zzcgiVar.f7087a;
        if (zzcglVar.f7104c.m8383a() == null) {
            this.f7384a.m8235h().m8173a(new zzcit(this, zzcglVar2, zzcgiVar));
        } else {
            this.f7384a.m8235h().m8173a(new zzciu(this, zzcglVar2, zzcgiVar));
        }
    }

    @Override // com.google.android.gms.internal.zzche
    /* JADX INFO: renamed from: a */
    public final void mo8051a(zzcha zzchaVar, zzcgi zzcgiVar) {
        zzbq.m7373a(zzchaVar);
        m8257b(zzcgiVar, false);
        this.f7384a.m8235h().m8173a(new zzcjc(this, zzchaVar, zzcgiVar));
    }

    @Override // com.google.android.gms.internal.zzche
    /* JADX INFO: renamed from: a */
    public final void mo8052a(zzcha zzchaVar, String str, String str2) {
        zzbq.m7373a(zzchaVar);
        zzbq.m7375a(str);
        m8256a(str, true);
        this.f7384a.m8235h().m8173a(new zzcjd(this, zzchaVar, str));
    }

    @Override // com.google.android.gms.internal.zzche
    /* JADX INFO: renamed from: a */
    public final void mo8053a(zzcln zzclnVar, zzcgi zzcgiVar) {
        zzbq.m7373a(zzclnVar);
        m8257b(zzcgiVar, false);
        if (zzclnVar.m8383a() == null) {
            this.f7384a.m8235h().m8173a(new zzcjf(this, zzclnVar, zzcgiVar));
        } else {
            this.f7384a.m8235h().m8173a(new zzcjg(this, zzclnVar, zzcgiVar));
        }
    }

    @Override // com.google.android.gms.internal.zzche
    /* JADX INFO: renamed from: a */
    public final byte[] mo8054a(zzcha zzchaVar, String str) {
        zzbq.m7375a(str);
        zzbq.m7373a(zzchaVar);
        m8256a(str, true);
        this.f7384a.m8233f().m8100D().m8109a("Log and bundle. event", this.f7384a.m8243p().m8090a(zzchaVar.f7156a));
        long jMo7498c = this.f7384a.m8248u().mo7498c() / 1000000;
        try {
            byte[] bArr = (byte[]) this.f7384a.m8235h().m8174b(new zzcje(this, zzchaVar, str)).get();
            if (bArr == null) {
                this.f7384a.m8233f().m8106y().m8109a("Log and bundle returned null. appId", zzchm.m8093a(str));
                bArr = new byte[0];
            }
            this.f7384a.m8233f().m8100D().m8111a("Log and bundle processed. event, size, time_ms", this.f7384a.m8243p().m8090a(zzchaVar.f7156a), Integer.valueOf(bArr.length), Long.valueOf((this.f7384a.m8248u().mo7498c() / 1000000) - jMo7498c));
            return bArr;
        } catch (InterruptedException | ExecutionException e) {
            this.f7384a.m8233f().m8106y().m8111a("Failed to log and bundle. appId, event, error", zzchm.m8093a(str), this.f7384a.m8243p().m8090a(zzchaVar.f7156a), e);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.zzche
    /* JADX INFO: renamed from: b */
    public final void mo8055b(zzcgi zzcgiVar) {
        m8257b(zzcgiVar, false);
        this.f7384a.m8235h().m8173a(new zzcis(this, zzcgiVar));
    }

    @Override // com.google.android.gms.internal.zzche
    /* JADX INFO: renamed from: c */
    public final String mo8056c(zzcgi zzcgiVar) {
        m8257b(zzcgiVar, false);
        return this.f7384a.m8210a(zzcgiVar.f7087a);
    }

    @Override // com.google.android.gms.internal.zzche
    /* JADX INFO: renamed from: d */
    public final void mo8057d(zzcgi zzcgiVar) {
        m8256a(zzcgiVar.f7087a, false);
        this.f7384a.m8235h().m8173a(new zzcjb(this, zzcgiVar));
    }
}
