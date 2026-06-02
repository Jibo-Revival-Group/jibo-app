package com.salesforce.android.knowledge.core.internal.utils;

import com.salesforce.android.knowledge.core.LogoutListener;
import com.salesforce.android.service.common.http.HttpClient;
import com.salesforce.androidsdk.smartstore.store.SmartStore;

/* JADX INFO: loaded from: classes.dex */
public interface MobileSdkUserManager {
    /* JADX INFO: renamed from: a */
    SmartStore mo13273a();

    /* JADX INFO: renamed from: a */
    void mo13274a(LogoutListener logoutListener);

    /* JADX INFO: renamed from: b */
    HttpClient mo13275b();

    /* JADX INFO: renamed from: c */
    void mo13276c();
}
