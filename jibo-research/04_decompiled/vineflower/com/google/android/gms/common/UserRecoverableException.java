package com.google.android.gms.common;

import android.content.Intent;

public class UserRecoverableException extends Exception {
   private final Intent a;

   public UserRecoverableException(String var1, Intent var2) {
      super(var1);
      this.a = var2;
   }

   public Intent b() {
      return new Intent(this.a);
   }
}
