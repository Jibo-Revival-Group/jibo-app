package com.salesforce.androidsdk.push;

import android.os.Bundle;
import com.google.android.gms.gcm.GcmListenerService;
import com.salesforce.androidsdk.app.SalesforceSDKManager;

/* JADX INFO: loaded from: classes.dex */
public class SFDCGcmListenerService extends GcmListenerService {
    @Override // com.google.android.gms.gcm.GcmListenerService
    /* JADX INFO: renamed from: a */
    public void mo7583a(String str, Bundle bundle) {
        PushNotificationInterface pushNotificationInterfaceM14448m;
        if (bundle != null && SalesforceSDKManager.m14415b() && (pushNotificationInterfaceM14448m = SalesforceSDKManager.m14403a().m14448m()) != null) {
            bundle.putString("from", str);
            pushNotificationInterfaceM14448m.mo12198a(bundle);
        }
    }
}
