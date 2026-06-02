package com.jibo.service;

import com.google.firebase.iid.FirebaseInstanceId;
import com.jibo.utils.ServiceUtils;
import java.security.SecureRandom;

public class DeviceRegistrationService extends BasicDeviceRegistrationService {
   @Override
   protected String a() {
      return FirebaseInstanceId.a().d();
   }

   @Override
   protected String b() {
      SecureRandom var1 = new SecureRandom();
      return FirebaseInstanceId.a().c() + var1.nextLong();
   }

   public void onCreate() {
      super.onCreate();
      ServiceUtils.a(this);
   }

   public void onDestroy() {
      super.onDestroy();
      ServiceUtils.b(this);
   }
}
