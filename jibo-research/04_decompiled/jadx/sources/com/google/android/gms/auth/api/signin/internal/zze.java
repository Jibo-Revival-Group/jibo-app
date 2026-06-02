package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzbm;
import com.google.android.gms.internal.zzbgg;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class zze {

    /* JADX INFO: renamed from: a */
    private static zzbgg f6036a = new zzbgg("GoogleSignInCommon", new String[0]);

    /* JADX INFO: renamed from: a */
    public static Intent m6774a(Context context, GoogleSignInOptions googleSignInOptions) {
        f6036a.m7772a("getSignInIntent()", new Object[0]);
        SignInConfiguration signInConfiguration = new SignInConfiguration(context.getPackageName(), googleSignInOptions);
        Intent intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        intent.setPackage(context.getPackageName());
        intent.setClass(context, SignInHubActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("config", signInConfiguration);
        intent.putExtra("config", bundle);
        return intent;
    }

    /* JADX INFO: renamed from: a */
    public static PendingResult<Status> m6775a(GoogleApiClient googleApiClient, Context context, boolean z) {
        f6036a.m7772a("Revoking access", new Object[0]);
        m6776a(context);
        return z ? PendingResults.m6924a(Status.f6134f, googleApiClient) : googleApiClient.mo6896b(new zzj(googleApiClient));
    }

    /* JADX INFO: renamed from: a */
    private static void m6776a(Context context) {
        zzo.m6781a(context).m6783a();
        Iterator<GoogleApiClient> it = GoogleApiClient.m6886a().iterator();
        while (it.hasNext()) {
            it.next().mo6900d();
        }
        zzbm.m7094b();
    }
}
