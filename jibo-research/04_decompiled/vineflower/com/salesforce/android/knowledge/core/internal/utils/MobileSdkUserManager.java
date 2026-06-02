package com.salesforce.android.knowledge.core.internal.utils;

import com.salesforce.android.knowledge.core.LogoutListener;
import com.salesforce.android.service.common.http.HttpClient;
import com.salesforce.androidsdk.smartstore.store.SmartStore;

public interface MobileSdkUserManager {
   SmartStore a();

   void a(LogoutListener var1);

   HttpClient b();

   void c();
}
