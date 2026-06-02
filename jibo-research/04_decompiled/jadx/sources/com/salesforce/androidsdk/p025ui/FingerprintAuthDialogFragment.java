package com.salesforce.androidsdk.p025ui;

import android.R;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.app.DialogFragment;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(23)
public class FingerprintAuthDialogFragment extends DialogFragment {

    /* JADX INFO: renamed from: a */
    private Button f14361a;

    /* JADX INFO: renamed from: b */
    private TextView f14362b;

    /* JADX INFO: renamed from: c */
    private SalesforceR f14363c;

    /* JADX INFO: renamed from: d */
    private Cipher f14364d;

    /* JADX INFO: renamed from: e */
    private PasscodeActivity f14365e;

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        setStyle(0, R.style.Theme.Material.Light.Dialog);
        this.f14363c = SalesforceSDKManager.m14403a().m14438e();
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= 23) {
            FingerprintManager fingerprintManager = (FingerprintManager) this.f14365e.getSystemService("fingerprint");
            if (this.f14365e.checkSelfPermission("android.permission.USE_FINGERPRINT") == 0) {
                fingerprintManager.authenticate(new FingerprintManager.CryptoObject(this.f14364d), null, 0, new FingerprintManager.AuthenticationCallback() { // from class: com.salesforce.androidsdk.ui.FingerprintAuthDialogFragment.1
                    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
                    public void onAuthenticationError(int i, CharSequence charSequence) {
                        super.onAuthenticationError(i, charSequence);
                    }

                    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
                    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
                        super.onAuthenticationSucceeded(authenticationResult);
                        if (FingerprintAuthDialogFragment.this.f14362b != null) {
                            FingerprintAuthDialogFragment.this.f14362b.setText(FingerprintAuthDialogFragment.this.f14363c.m14945K());
                            FingerprintAuthDialogFragment.this.f14362b.setTextColor(-16711936);
                        }
                        if (FingerprintAuthDialogFragment.this.getFragmentManager() != null) {
                            FingerprintAuthDialogFragment.this.dismiss();
                        }
                        FingerprintAuthDialogFragment.this.f14365e.m14922x();
                    }

                    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
                    public void onAuthenticationFailed() {
                        super.onAuthenticationFailed();
                        if (FingerprintAuthDialogFragment.this.f14362b != null) {
                            FingerprintAuthDialogFragment.this.f14362b.setText(FingerprintAuthDialogFragment.this.f14363c.m14946L());
                            FingerprintAuthDialogFragment.this.f14362b.setTextColor(-65536);
                        }
                    }

                    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
                    public void onAuthenticationHelp(int i, CharSequence charSequence) {
                        super.onAuthenticationHelp(i, charSequence);
                        if (FingerprintAuthDialogFragment.this.f14362b != null) {
                            FingerprintAuthDialogFragment.this.f14362b.setText(charSequence.toString());
                            FingerprintAuthDialogFragment.this.f14362b.setTextColor(-65536);
                        }
                    }
                }, null);
            }
        }
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(bundle);
        dialogOnCreateDialog.getWindow().requestFeature(1);
        return dialogOnCreateDialog;
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(this.f14363c.m14942H(), viewGroup, false);
        this.f14361a = (Button) viewInflate.findViewById(this.f14363c.m14943I());
        this.f14361a.setOnClickListener(new View.OnClickListener() { // from class: com.salesforce.androidsdk.ui.FingerprintAuthDialogFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FingerprintAuthDialogFragment.this.dismiss();
            }
        });
        this.f14362b = (TextView) viewInflate.findViewById(this.f14363c.m14944J());
        return viewInflate;
    }

    /* JADX INFO: renamed from: a */
    public void m14843a(PasscodeActivity passcodeActivity) {
        this.f14365e = passcodeActivity;
    }
}
