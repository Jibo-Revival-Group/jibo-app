package com.jibo.service;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import com.jibo.p018db.EntityData;
import com.jibo.utils.LogUtils;
import com.jibo.utils.ServiceUtils;

/* JADX INFO: loaded from: classes.dex */
public class SyncTaskService extends IntentService {

    /* JADX INFO: renamed from: a */
    public static final String f9758a = LogUtils.m11405a(SyncTaskService.class);

    public SyncTaskService() {
        super(f9758a);
    }

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

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) throws Throwable {
        EntityData.m10089a(this).m10113a(intent.getExtras());
    }
}
