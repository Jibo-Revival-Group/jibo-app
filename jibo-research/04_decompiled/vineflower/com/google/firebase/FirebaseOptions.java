package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzca;
import com.google.android.gms.common.util.zzu;
import java.util.Arrays;

public final class FirebaseOptions {
   private final String a;
   private final String b;
   private final String c;
   private final String d;
   private final String e;
   private final String f;
   private final String g;

   private FirebaseOptions(String var1, String var2, String var3, String var4, String var5, String var6, String var7) {
      boolean var8;
      if (!zzu.a(var1)) {
         var8 = true;
      } else {
         var8 = false;
      }

      zzbq.a(var8, "ApplicationId must be set.");
      this.b = var1;
      this.a = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
      this.f = var6;
      this.g = var7;
   }

   public static FirebaseOptions a(Context var0) {
      zzca var2 = new zzca(var0);
      String var1 = var2.a("google_app_id");
      FirebaseOptions var3;
      if (TextUtils.isEmpty(var1)) {
         var3 = null;
      } else {
         var3 = new FirebaseOptions(
            var1,
            var2.a("google_api_key"),
            var2.a("firebase_database_url"),
            var2.a("ga_trackingId"),
            var2.a("gcm_defaultSenderId"),
            var2.a("google_storage_bucket"),
            var2.a("project_id")
         );
      }

      return var3;
   }

   public final String a() {
      return this.b;
   }

   public final String b() {
      return this.e;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var3 = false;
      boolean var2;
      if (!(var1 instanceof FirebaseOptions)) {
         var2 = var3;
      } else {
         var1 = var1;
         var2 = var3;
         if (zzbg.a(this.b, var1.b)) {
            var2 = var3;
            if (zzbg.a(this.a, var1.a)) {
               var2 = var3;
               if (zzbg.a(this.c, var1.c)) {
                  var2 = var3;
                  if (zzbg.a(this.d, var1.d)) {
                     var2 = var3;
                     if (zzbg.a(this.e, var1.e)) {
                        var2 = var3;
                        if (zzbg.a(this.f, var1.f)) {
                           var2 = var3;
                           if (zzbg.a(this.g, var1.g)) {
                              var2 = true;
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      return var2;
   }

   @Override
   public final int hashCode() {
      return Arrays.hashCode(new Object[]{this.b, this.a, this.c, this.d, this.e, this.f, this.g});
   }

   @Override
   public final String toString() {
      return zzbg.a(this)
         .a("applicationId", this.b)
         .a("apiKey", this.a)
         .a("databaseUrl", this.c)
         .a("gcmSenderId", this.e)
         .a("storageBucket", this.f)
         .a("projectId", this.g)
         .toString();
   }
}
