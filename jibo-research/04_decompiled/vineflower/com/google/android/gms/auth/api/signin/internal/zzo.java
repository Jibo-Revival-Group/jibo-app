package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.zzbq;

public final class zzo {
   private static zzo a = null;
   private zzz b;
   private GoogleSignInAccount c;
   private GoogleSignInOptions d;

   private zzo(Context var1) {
      this.b = zzz.a(var1);
      this.c = this.b.a();
      this.d = this.b.b();
   }

   public static zzo a(Context var0) {
      synchronized (zzo.class) {
         return b(var0.getApplicationContext());
      }
   }

   private static zzo b(Context var0) {
      synchronized (zzo.class) {
         if (a == null) {
            zzo var1 = new zzo(var0);
            a = var1;
         }

         return a;
      }
   }

   public final void a() {
      synchronized (this) {
         this.b.d();
         this.c = null;
         this.d = null;
      }
   }

   public final void a(GoogleSignInOptions var1, GoogleSignInAccount var2) {
      synchronized (this) {
         zzz var3 = this.b;
         zzbq.a(var2);
         zzbq.a(var1);
         var3.a("defaultGoogleSignInAccount", var2.j());
         var3.a(var2, var1);
         this.c = var2;
         this.d = var1;
      }
   }
}
