package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.zzbq;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

public final class zzz {
   private static final Lock a = new ReentrantLock();
   private static zzz b;
   private final Lock c = new ReentrantLock();
   private final SharedPreferences d;

   private zzz(Context var1) {
      this.d = var1.getSharedPreferences("com.google.android.gms.signin", 0);
   }

   private final GoogleSignInAccount a(String var1) {
      Object var2 = null;
      GoogleSignInAccount var5;
      if (TextUtils.isEmpty(var1)) {
         var5 = (GoogleSignInAccount)var2;
      } else {
         String var3 = this.c(b("googleSignInAccount", var1));
         var5 = (GoogleSignInAccount)var2;
         if (var3 != null) {
            try {
               var5 = GoogleSignInAccount.a(var3);
            } catch (JSONException var4) {
               var5 = (GoogleSignInAccount)var2;
            }
         }
      }

      return var5;
   }

   public static zzz a(Context var0) {
      zzbq.a(var0);
      a.lock();

      try {
         if (b == null) {
            zzz var1 = new zzz(var0.getApplicationContext());
            b = var1;
         }

         return b;
      } finally {
         a.unlock();
      }
   }

   private final GoogleSignInOptions b(String var1) {
      Object var2 = null;
      GoogleSignInOptions var5;
      if (TextUtils.isEmpty(var1)) {
         var5 = (GoogleSignInOptions)var2;
      } else {
         String var3 = this.c(b("googleSignInOptions", var1));
         var5 = (GoogleSignInOptions)var2;
         if (var3 != null) {
            try {
               var5 = GoogleSignInOptions.a(var3);
            } catch (JSONException var4) {
               var5 = (GoogleSignInOptions)var2;
            }
         }
      }

      return var5;
   }

   private static String b(String var0, String var1) {
      return new StringBuilder(String.valueOf(var0).length() + String.valueOf(":").length() + String.valueOf(var1).length())
         .append(var0)
         .append(":")
         .append(var1)
         .toString();
   }

   private final String c(String var1) {
      this.c.lock();

      try {
         return this.d.getString(var1, null);
      } finally {
         this.c.unlock();
      }
   }

   private final void d(String var1) {
      this.c.lock();

      try {
         this.d.edit().remove(var1).apply();
      } finally {
         this.c.unlock();
      }
   }

   public final GoogleSignInAccount a() {
      return this.a(this.c("defaultGoogleSignInAccount"));
   }

   final void a(GoogleSignInAccount var1, GoogleSignInOptions var2) {
      zzbq.a(var1);
      zzbq.a(var2);
      String var3 = var1.j();
      this.a(b("googleSignInAccount", var3), var1.l());
      this.a(b("googleSignInOptions", var3), var2.b());
   }

   protected final void a(String var1, String var2) {
      this.c.lock();

      try {
         this.d.edit().putString(var1, var2).apply();
      } finally {
         this.c.unlock();
      }
   }

   public final GoogleSignInOptions b() {
      return this.b(this.c("defaultGoogleSignInAccount"));
   }

   public final void c() {
      String var1 = this.c("defaultGoogleSignInAccount");
      this.d("defaultGoogleSignInAccount");
      if (!TextUtils.isEmpty(var1)) {
         this.d(b("googleSignInAccount", var1));
         this.d(b("googleSignInOptions", var1));
      }
   }

   public final void d() {
      this.c.lock();

      try {
         this.d.edit().clear().apply();
      } finally {
         this.c.unlock();
      }
   }
}
