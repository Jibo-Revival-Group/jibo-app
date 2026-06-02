package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
@KeepName
public class SignInHubActivity extends FragmentActivity {

    /* JADX INFO: renamed from: a */
    private static boolean f6026a = false;

    /* JADX INFO: renamed from: b */
    private boolean f6027b = false;

    /* JADX INFO: renamed from: c */
    private SignInConfiguration f6028c;

    /* JADX INFO: renamed from: d */
    private boolean f6029d;

    /* JADX INFO: renamed from: e */
    private int f6030e;

    /* JADX INFO: renamed from: f */
    private Intent f6031f;

    class zza implements LoaderManager.LoaderCallbacks<Void> {
        private zza() {
        }

        @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
        /* JADX INFO: renamed from: a */
        public final Loader<Void> mo1689a(int i, Bundle bundle) {
            return new zzb(SignInHubActivity.this, GoogleApiClient.m6886a());
        }

        @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
        /* JADX INFO: renamed from: a */
        public final void mo1690a(Loader<Void> loader) {
        }

        @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
        /* JADX INFO: renamed from: a */
        public final /* synthetic */ void mo1691a(Loader<Void> loader, Void r5) {
            SignInHubActivity.this.setResult(SignInHubActivity.this.f6030e, SignInHubActivity.this.f6031f);
            SignInHubActivity.this.finish();
        }
    }

    /* JADX INFO: renamed from: a */
    private final void m6760a() {
        getSupportLoaderManager().mo1683a(0, null, new zza());
        f6026a = false;
    }

    /* JADX INFO: renamed from: a */
    private final void m6761a(int i) {
        Status status = new Status(i);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
        f6026a = false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (this.f6027b) {
        }
        setResult(0);
        switch (i) {
            case 40962:
                if (intent != null) {
                    SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra("signInAccount");
                    if (signInAccount != null && signInAccount.m6757a() != null) {
                        GoogleSignInAccount googleSignInAccountM6757a = signInAccount.m6757a();
                        zzo.m6781a(this).m6784a(this.f6028c.m6758a(), googleSignInAccountM6757a);
                        intent.removeExtra("signInAccount");
                        intent.putExtra("googleSignInAccount", googleSignInAccountM6757a);
                        this.f6029d = true;
                        this.f6030e = i2;
                        this.f6031f = intent;
                        m6760a();
                    } else if (intent.hasExtra("errorCode")) {
                        m6761a(intent.getIntExtra("errorCode", 8));
                    }
                }
                m6761a(8);
                break;
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        String action = intent.getAction();
        if ("com.google.android.gms.auth.NO_IMPL".equals(action)) {
            m6761a(12500);
            return;
        }
        if (f6026a) {
            setResult(0);
            m6761a(12502);
            return;
        }
        f6026a = true;
        if (!action.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN") && !action.equals("com.google.android.gms.auth.APPAUTH_SIGN_IN")) {
            String strValueOf = String.valueOf(intent.getAction());
            Log.e("AuthSignInClient", strValueOf.length() != 0 ? "Unknown action: ".concat(strValueOf) : new String("Unknown action: "));
            finish();
            return;
        }
        this.f6028c = (SignInConfiguration) intent.getBundleExtra("config").getParcelable("config");
        if (this.f6028c == null) {
            Log.e("AuthSignInClient", "Activity started with invalid configuration.");
            setResult(0);
            finish();
            return;
        }
        if (bundle != null) {
            this.f6029d = bundle.getBoolean("signingInGoogleApiClients");
            if (this.f6029d) {
                this.f6030e = bundle.getInt("signInResultCode");
                this.f6031f = (Intent) bundle.getParcelable("signInResultData");
                m6760a();
                return;
            }
            return;
        }
        Intent intent2 = new Intent(action);
        if (action.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN")) {
            intent2.setPackage("com.google.android.gms");
        } else {
            intent2.setPackage(getPackageName());
        }
        intent2.putExtra("config", this.f6028c);
        try {
            startActivityForResult(intent2, 40962);
        } catch (ActivityNotFoundException e) {
            this.f6027b = true;
            Log.w("AuthSignInClient", "Could not launch sign in Intent. Google Play Service is probably being updated...");
            m6761a(17);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("signingInGoogleApiClients", this.f6029d);
        if (this.f6029d) {
            bundle.putInt("signInResultCode", this.f6030e);
            bundle.putParcelable("signInResultData", this.f6031f);
        }
    }
}
