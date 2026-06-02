package com.jibo.service;

import android.app.Service;
import com.google.firebase.iid.FirebaseInstanceId;
import com.jibo.utils.ServiceUtils;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes.dex */
public class DeviceRegistrationService extends BasicDeviceRegistrationService {
    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        ServiceUtils.m11426a((Service) this);
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ServiceUtils.m11428b(this);
    }

    @Override // com.jibo.service.BasicDeviceRegistrationService
    /* JADX INFO: renamed from: a */
    protected String mo10152a() {
        return FirebaseInstanceId.m9094a().m9108d();
    }

    @Override // com.jibo.service.BasicDeviceRegistrationService
    /* JADX INFO: renamed from: b */
    protected String mo10153b() {
        return FirebaseInstanceId.m9094a().m9107c() + new SecureRandom().nextLong();
    }
}
