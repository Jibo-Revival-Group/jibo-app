package com.jibo.service;

import android.app.IntentService;
import android.content.Intent;
import android.content.SharedPreferences;
import com.amazonaws.auth.AWSCredentials;
import com.crashlytics.android.Crashlytics;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.JiboAccountClient;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.common.model.Device;
import com.jibo.p018db.EntityData;

/* JADX INFO: loaded from: classes.dex */
public abstract class BasicDeviceRegistrationService extends IntentService {

    /* JADX INFO: renamed from: a */
    private JiboAccountClient f9730a;

    /* JADX INFO: renamed from: a */
    protected abstract String mo10152a();

    /* JADX INFO: renamed from: b */
    protected abstract String mo10153b();

    public BasicDeviceRegistrationService() {
        super("DeviceRegisterService");
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.app_name), 0);
        try {
            try {
                final Account accountM10134i = EntityData.m10089a(this).m10134i();
                if (accountM10134i == null) {
                    try {
                        if (this.f9730a != null) {
                            this.f9730a.shutdown();
                        }
                    } catch (Exception e) {
                        Crashlytics.m5597a((Throwable) e);
                    }
                } else {
                    String strMo10152a = mo10152a();
                    String strMo10153b = mo10153b();
                    this.f9730a = new JiboAccountClient(new AWSCredentials() { // from class: com.jibo.service.BasicDeviceRegistrationService.1
                        @Override // com.amazonaws.auth.AWSCredentials
                        public String getAWSAccessKeyId() {
                            return accountM10134i.getAccessKeyId();
                        }

                        @Override // com.amazonaws.auth.AWSCredentials
                        public String getAWSSecretKey() {
                            return accountM10134i.getSecretAccessKey();
                        }
                    });
                    EntityData.m10089a(this).m10130f().createDevice(new Device(strMo10153b, strMo10152a, Device.Type.android));
                    sharedPreferences.edit().putString("PREF_PUSH_SERVICE_TOKEN", strMo10152a).apply();
                    sharedPreferences.edit().putString("PREF_INSTANCE_ID", strMo10153b).apply();
                    try {
                        if (this.f9730a != null) {
                            this.f9730a.shutdown();
                        }
                    } catch (Exception e2) {
                        Crashlytics.m5597a((Throwable) e2);
                    }
                }
            } catch (Exception e3) {
                Crashlytics.m5597a((Throwable) e3);
                sharedPreferences.edit().putString("PREF_PUSH_SERVICE_TOKEN", "").apply();
                sharedPreferences.edit().putString("PREF_INSTANCE_ID", "").apply();
                try {
                    if (this.f9730a != null) {
                        this.f9730a.shutdown();
                    }
                } catch (Exception e4) {
                    Crashlytics.m5597a((Throwable) e4);
                }
            }
        } catch (Throwable th) {
            try {
                if (this.f9730a != null) {
                    this.f9730a.shutdown();
                }
            } catch (Exception e5) {
                Crashlytics.m5597a((Throwable) e5);
            }
            throw th;
        }
    }
}
