package com.google.android.gms.auth;

import android.content.Intent;

public class GooglePlayServicesAvailabilityException extends UserRecoverableAuthException {
   private final int a;

   GooglePlayServicesAvailabilityException(int var1, String var2, Intent var3) {
      super(var2, var3);
      this.a = var1;
   }

   public int a() {
      return this.a;
   }
}
