package com.salesforce.androidsdk.push;

import android.app.IntentService;
import android.content.Intent;
import com.google.android.gms.iid.InstanceID;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.config.BootConfig;
import com.salesforce.androidsdk.util.SalesforceSDKLogger;

/* JADX INFO: loaded from: classes.dex */
public class SFDCRegistrationIntentService extends IntentService {
    public SFDCRegistrationIntentService() {
        super("RegIntentService");
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        try {
            String strM7609b = InstanceID.m7604c(this).m7609b(BootConfig.m14502a(this).m14511d(), "GCM", null);
            UserAccount userAccountM14275b = SalesforceSDKManager.m14403a().m14450o().m14275b();
            PushMessaging.m14536a(this, strM7609b, userAccountM14275b);
            PushMessaging.m14541c(this, userAccountM14275b);
        } catch (Exception e) {
            SalesforceSDKLogger.m15016a("RegIntentService", "Error during GCM registration", e);
        }
    }
}
