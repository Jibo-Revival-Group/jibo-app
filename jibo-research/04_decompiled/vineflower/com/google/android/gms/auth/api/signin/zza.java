package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Scope;
import java.util.Comparator;

// $VF: synthetic class
final class zza implements Comparator {
   static final Comparator a = new zza();

   private zza() {
   }

   @Override
   public final int compare(Object var1, Object var2) {
      return GoogleSignInAccount.a((Scope)var1, (Scope)var2);
   }
}
