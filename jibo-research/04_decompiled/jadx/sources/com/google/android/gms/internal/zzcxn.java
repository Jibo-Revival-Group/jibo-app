package com.google.android.gms.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.internal.zzz;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzan;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzbr;
import com.google.android.gms.common.internal.zzm;
import com.google.android.gms.common.internal.zzr;

/* JADX INFO: loaded from: classes.dex */
public final class zzcxn extends zzab<zzcxl> implements zzcxd {

    /* JADX INFO: renamed from: d */
    private final boolean f7787d;

    /* JADX INFO: renamed from: e */
    private final zzr f7788e;

    /* JADX INFO: renamed from: f */
    private final Bundle f7789f;

    /* JADX INFO: renamed from: g */
    private Integer f7790g;

    private zzcxn(Context context, Looper looper, boolean z, zzr zzrVar, Bundle bundle, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 44, zzrVar, connectionCallbacks, onConnectionFailedListener);
        this.f7787d = true;
        this.f7788e = zzrVar;
        this.f7789f = bundle;
        this.f7790g = zzrVar.m7460j();
    }

    public zzcxn(Context context, Looper looper, boolean z, zzr zzrVar, zzcxe zzcxeVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, true, zzrVar, m8510a(zzrVar), connectionCallbacks, onConnectionFailedListener);
    }

    /* JADX INFO: renamed from: a */
    public static Bundle m8510a(zzr zzrVar) {
        zzcxe zzcxeVarM7459i = zzrVar.m7459i();
        Integer numM7460j = zzrVar.m7460j();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", zzrVar.m7452b());
        if (numM7460j != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", numM7460j.intValue());
        }
        if (zzcxeVarM7459i != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", zzcxeVarM7459i.m8499a());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", zzcxeVarM7459i.m8500b());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", zzcxeVarM7459i.m8501c());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", zzcxeVarM7459i.m8502d());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", zzcxeVarM7459i.m8503e());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", zzcxeVarM7459i.m8504f());
            if (zzcxeVarM7459i.m8505g() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", zzcxeVarM7459i.m8505g().longValue());
            }
            if (zzcxeVarM7459i.m8506h() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", zzcxeVarM7459i.m8506h().longValue());
            }
        }
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.zzd
    /* JADX INFO: renamed from: a */
    protected final /* synthetic */ IInterface mo6768a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return iInterfaceQueryLocalInterface instanceof zzcxl ? (zzcxl) iInterfaceQueryLocalInterface : new zzcxm(iBinder);
    }

    @Override // com.google.android.gms.internal.zzcxd
    /* JADX INFO: renamed from: a */
    public final void mo8495a(zzan zzanVar, boolean z) {
        try {
            ((zzcxl) m7439v()).mo8508a(zzanVar, this.f7790g.intValue(), z);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    @Override // com.google.android.gms.internal.zzcxd
    /* JADX INFO: renamed from: a */
    public final void mo8496a(zzcxj zzcxjVar) {
        zzbq.m7374a(zzcxjVar, "Expecting a valid ISignInCallbacks");
        try {
            Account accountM7453c = this.f7788e.m7453c();
            ((zzcxl) m7439v()).mo8509a(new zzcxo(new zzbr(accountM7453c, this.f7790g.intValue(), "<<default account>>".equals(accountM7453c.name) ? zzz.m6793a(m7436s()).m6798a() : null)), zzcxjVar);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                zzcxjVar.mo7056a(new zzcxq(8));
            } catch (RemoteException e2) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    @Override // com.google.android.gms.common.internal.zzd
    /* JADX INFO: renamed from: b */
    protected final String mo6769b() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.zzd
    /* JADX INFO: renamed from: b_ */
    protected final String mo6770b_() {
        return "com.google.android.gms.signin.service.START";
    }

    @Override // com.google.android.gms.internal.zzcxd
    /* JADX INFO: renamed from: e */
    public final void mo8497e() {
        try {
            ((zzcxl) m7439v()).mo8507a(this.f7790g.intValue());
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    @Override // com.google.android.gms.common.internal.zzd, com.google.android.gms.common.api.Api.zze
    /* JADX INFO: renamed from: i */
    public final boolean mo6864i() {
        return this.f7787d;
    }

    @Override // com.google.android.gms.internal.zzcxd
    /* JADX INFO: renamed from: m */
    public final void mo8498m() {
        m7424a(new zzm(this));
    }

    @Override // com.google.android.gms.common.internal.zzd
    /* JADX INFO: renamed from: t */
    protected final Bundle mo7437t() {
        if (!m7436s().getPackageName().equals(this.f7788e.m7457g())) {
            this.f7789f.putString("com.google.android.gms.signin.internal.realClientPackageName", this.f7788e.m7457g());
        }
        return this.f7789f;
    }
}
