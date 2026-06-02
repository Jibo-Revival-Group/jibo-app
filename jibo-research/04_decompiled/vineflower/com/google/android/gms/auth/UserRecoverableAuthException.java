package com.google.android.gms.auth;

import android.content.Intent;

public class UserRecoverableAuthException extends GoogleAuthException {
   private final Intent a;

   public UserRecoverableAuthException(String var1, Intent var2) {
      super(var1);
      this.a = var2;
   }

   public Intent b() {
      Intent var1;
      if (this.a == null) {
         var1 = null;
      } else {
         var1 = new Intent(this.a);
      }

      return var1;
   }
}
