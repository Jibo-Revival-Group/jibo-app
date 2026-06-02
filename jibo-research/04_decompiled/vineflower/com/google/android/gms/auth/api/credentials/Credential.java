package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Credential extends zzbfm implements ReflectedParcelable {
   public static final Creator<Credential> CREATOR = new zza();
   private final String a;
   private final String b;
   private final Uri c;
   private final List<IdToken> d;
   private final String e;
   private final String f;
   private final String g;
   private final String h;
   private final String i;
   private final String j;

   Credential(String var1, String var2, Uri var3, List<IdToken> var4, String var5, String var6, String var7, String var8, String var9, String var10) {
      String var12 = zzbq.a(var1, "credential identifier cannot be null").trim();
      zzbq.a(var12, "credential identifier cannot be empty");
      if (var5 != null && TextUtils.isEmpty(var5)) {
         throw new IllegalArgumentException("Password must not be empty if set");
      }

      if (var6 != null) {
         boolean var11;
         label56: {
            if (!TextUtils.isEmpty(var6)) {
               Uri var13 = Uri.parse(var6);
               if (!var13.isAbsolute() || !var13.isHierarchical() || TextUtils.isEmpty(var13.getScheme()) || TextUtils.isEmpty(var13.getAuthority())) {
                  var11 = false;
                  break label56;
               }

               if ("http".equalsIgnoreCase(var13.getScheme()) || "https".equalsIgnoreCase(var13.getScheme())) {
                  var11 = true;
                  break label56;
               }
            }

            var11 = false;
         }

         if (!Boolean.valueOf(var11)) {
            throw new IllegalArgumentException("Account type must be a valid Http/Https URI");
         }
      }

      if (!TextUtils.isEmpty(var6) && !TextUtils.isEmpty(var5)) {
         throw new IllegalArgumentException("Password and AccountType are mutually exclusive");
      }

      var1 = var2;
      if (var2 != null) {
         var1 = var2;
         if (TextUtils.isEmpty(var2.trim())) {
            var1 = null;
         }
      }

      this.b = var1;
      this.c = var3;
      List var15;
      if (var4 == null) {
         var15 = Collections.emptyList();
      } else {
         var15 = Collections.unmodifiableList(var4);
      }

      this.d = var15;
      this.a = var12;
      this.e = var5;
      this.f = var6;
      this.g = var7;
      this.h = var8;
      this.i = var9;
      this.j = var10;
   }

   public String a() {
      return this.a;
   }

   public String b() {
      return this.b;
   }

   public Uri c() {
      return this.c;
   }

   public List<IdToken> d() {
      return this.d;
   }

   public String e() {
      return this.e;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (!(var1 instanceof Credential)) {
            var2 = false;
         } else {
            var1 = var1;
            if (!TextUtils.equals(this.a, var1.a)
               || !TextUtils.equals(this.b, var1.b)
               || !zzbg.a(this.c, var1.c)
               || !TextUtils.equals(this.e, var1.e)
               || !TextUtils.equals(this.f, var1.f)
               || !TextUtils.equals(this.g, var1.g)) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   public String f() {
      return this.g;
   }

   public String g() {
      return this.f;
   }

   public String h() {
      return this.i;
   }

   @Override
   public int hashCode() {
      return Arrays.hashCode(new Object[]{this.a, this.b, this.c, this.e, this.f, this.g});
   }

   public String i() {
      return this.j;
   }

   public void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a(), false);
      zzbfp.a(var1, 2, this.b(), false);
      zzbfp.a(var1, 3, this.c(), var2, false);
      zzbfp.c(var1, 4, this.d(), false);
      zzbfp.a(var1, 5, this.e(), false);
      zzbfp.a(var1, 6, this.g(), false);
      zzbfp.a(var1, 7, this.f(), false);
      zzbfp.a(var1, 8, this.h, false);
      zzbfp.a(var1, 9, this.h(), false);
      zzbfp.a(var1, 10, this.i(), false);
      zzbfp.a(var1, var3);
   }
}
