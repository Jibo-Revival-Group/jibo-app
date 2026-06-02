package com.google.android.gms.auth;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.zzaxb;
import com.google.android.gms.internal.zzbgg;
import com.google.android.gms.internal.zzey;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
final class zze implements zzj<TokenData> {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ Account f6061a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ String f6062b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ Bundle f6063c;

    zze(Account account, String str, Bundle bundle) {
        this.f6061a = account;
        this.f6062b = str;
        this.f6063c = bundle;
    }

    @Override // com.google.android.gms.auth.zzj
    /* JADX INFO: renamed from: a */
    public final /* synthetic */ TokenData mo6817a(IBinder iBinder) throws IOException, GoogleAuthException, RemoteException {
        Bundle bundle = (Bundle) zzd.m6814b(zzey.m8616a(iBinder).mo8614a(this.f6061a, this.f6062b, this.f6063c));
        TokenData tokenDataM6671a = TokenData.m6671a(bundle, "tokenDetails");
        if (tokenDataM6671a != null) {
            return tokenDataM6671a;
        }
        String string = bundle.getString("Error");
        Intent intent = (Intent) bundle.getParcelable("userRecoveryIntent");
        zzaxb zzaxbVarZzfb = zzaxb.zzfb(string);
        if (!zzaxb.zza(zzaxbVarZzfb)) {
            if (zzaxb.NETWORK_ERROR.equals(zzaxbVarZzfb) || zzaxb.SERVICE_UNAVAILABLE.equals(zzaxbVarZzfb)) {
                throw new IOException(string);
            }
            throw new GoogleAuthException(string);
        }
        zzbgg zzbggVar = zzd.f6060e;
        String strValueOf = String.valueOf(zzaxbVarZzfb);
        zzbggVar.m7774c("GoogleAuthUtil", new StringBuilder(String.valueOf(strValueOf).length() + 31).append("isUserRecoverableError status: ").append(strValueOf).toString());
        throw new UserRecoverableAuthException(string, intent);
    }
}
