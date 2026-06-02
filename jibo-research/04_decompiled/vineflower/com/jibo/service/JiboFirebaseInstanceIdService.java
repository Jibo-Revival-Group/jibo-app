package com.jibo.service;

import android.content.Intent;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class JiboFirebaseInstanceIdService extends FirebaseInstanceIdService {
   private static final String b = JiboFirebaseInstanceIdService.class.getSimpleName();

   @Override
   public void a() {
      this.startService(new Intent(this, DeviceRegistrationService.class));
   }
}
