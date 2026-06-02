package com.jibo.service;

import android.content.Intent;
import com.google.firebase.iid.FirebaseInstanceIdService;

/* JADX INFO: loaded from: classes.dex */
public class JiboFirebaseInstanceIdService extends FirebaseInstanceIdService {

    /* JADX INFO: renamed from: b */
    private static final String f9741b = JiboFirebaseInstanceIdService.class.getSimpleName();

    @Override // com.google.firebase.iid.FirebaseInstanceIdService
    /* JADX INFO: renamed from: a */
    public void mo9116a() {
        startService(new Intent(this, (Class<?>) DeviceRegistrationService.class));
    }
}
