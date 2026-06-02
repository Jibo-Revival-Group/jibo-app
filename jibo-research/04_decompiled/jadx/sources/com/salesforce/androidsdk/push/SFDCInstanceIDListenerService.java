package com.salesforce.androidsdk.push;

import android.content.Intent;
import com.google.android.gms.iid.InstanceIDListenerService;

/* JADX INFO: loaded from: classes.dex */
public class SFDCInstanceIDListenerService extends InstanceIDListenerService {
    @Override // com.google.android.gms.iid.InstanceIDListenerService
    /* JADX INFO: renamed from: a */
    public void mo7613a() {
        startService(new Intent(this, (Class<?>) SFDCRegistrationIntentService.class));
    }
}
