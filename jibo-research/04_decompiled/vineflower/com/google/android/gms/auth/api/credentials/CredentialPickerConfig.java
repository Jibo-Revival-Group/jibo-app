package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class CredentialPickerConfig extends zzbfm implements ReflectedParcelable {
   public static final Creator<CredentialPickerConfig> CREATOR = new zzc();
   private int a;
   private final boolean b;
   private final boolean c;
   @Deprecated
   private final boolean d;
   private final int e;

   CredentialPickerConfig(int var1, boolean var2, boolean var3, boolean var4, int var5) {
      byte var6 = 3;
      boolean var7 = true;
      super();
      this.a = var1;
      this.b = var2;
      this.c = var3;
      if (var1 < 2) {
         this.d = var4;
         byte var8;
         if (var4) {
            var8 = var6;
         } else {
            var8 = 1;
         }

         this.e = var8;
      } else {
         if (var5 == 3) {
            var2 = var7;
         } else {
            var2 = false;
         }

         this.d = var2;
         this.e = var5;
      }
   }

   private CredentialPickerConfig(CredentialPickerConfig.Builder var1) {
      this(2, var1.a, var1.b, false, var1.c);
   }

   public final boolean a() {
      return this.b;
   }

   public final boolean b() {
      return this.c;
   }

   @Deprecated
   public final boolean c() {
      boolean var1;
      if (this.e == 3) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a());
      zzbfp.a(var1, 2, this.b());
      zzbfp.a(var1, 3, this.c());
      zzbfp.a(var1, 4, this.e);
      zzbfp.a(var1, 1000, this.a);
      zzbfp.a(var1, var2);
   }

   public static class Builder {
      private boolean a = false;
      private boolean b = true;
      private int c = 1;

      public CredentialPickerConfig a() {
         return new CredentialPickerConfig(this, null);
      }
   }
}
