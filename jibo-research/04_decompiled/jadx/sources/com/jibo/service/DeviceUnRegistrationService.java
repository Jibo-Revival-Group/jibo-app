package com.jibo.service;

import android.app.IntentService;
import android.content.Intent;
import android.text.TextUtils;
import com.amazonaws.auth.AWSCredentials;
import com.crashlytics.android.Crashlytics;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.push.JiboPushAsyncClient;
import com.jibo.aws.integration.util.KeyManager;
import com.jibo.utils.SharedPreferencesUtil;

/* JADX INFO: loaded from: classes.dex */
public class DeviceUnRegistrationService extends IntentService {

    /* JADX INFO: renamed from: a */
    private static final String f9737a = DeviceUnRegistrationService.class.getSimpleName();

    /* JADX INFO: renamed from: b */
    private JiboPushAsyncClient f9738b;

    public DeviceUnRegistrationService() {
        super(f9737a);
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        try {
            try {
                String string = getSharedPreferences(getString(R.string.app_name), 0).getString("PREF_INSTANCE_ID", null);
                SharedPreferencesUtil.m11434b(this);
                final Account account = (Account) intent.getSerializableExtra(Account.class.getSimpleName());
                if (account == null) {
                    try {
                        if (this.f9738b != null) {
                            this.f9738b.shutdown();
                            return;
                        }
                        return;
                    } catch (Exception e) {
                        Crashlytics.m5597a((Throwable) e);
                        return;
                    }
                }
                KeyManager.getInstance(this, account.getId()).logout(this);
                if (!TextUtils.isEmpty(string)) {
                    this.f9738b = new JiboPushAsyncClient(new AWSCredentials() { // from class: com.jibo.service.DeviceUnRegistrationService.1
                        @Override // com.amazonaws.auth.AWSCredentials
                        public String getAWSAccessKeyId() {
                            return account.getAccessKeyId();
                        }

                        @Override // com.amazonaws.auth.AWSCredentials
                        public String getAWSSecretKey() {
                            return account.getSecretAccessKey();
                        }
                    });
                    this.f9738b.removeDevice(string);
                }
                try {
                    if (this.f9738b != null) {
                        this.f9738b.shutdown();
                    }
                } catch (Exception e2) {
                    Crashlytics.m5597a((Throwable) e2);
                }
            } catch (Exception e3) {
                Crashlytics.m5597a((Throwable) e3);
                try {
                    if (this.f9738b != null) {
                        this.f9738b.shutdown();
                    }
                } catch (Exception e4) {
                    Crashlytics.m5597a((Throwable) e4);
                }
            }
        } catch (Throwable th) {
            try {
                if (this.f9738b != null) {
                    this.f9738b.shutdown();
                }
            } catch (Exception e5) {
                Crashlytics.m5597a((Throwable) e5);
            }
            throw th;
        }
    }
}
