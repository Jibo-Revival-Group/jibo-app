package com.google.android.gms.internal;

import android.net.Uri;

public final class zzcup {
   private final String a;
   private final Uri b;
   private final String c;
   private final String d;
   private final boolean e;
   private final boolean f;

   public zzcup(Uri var1) {
      this(null, var1, "", "", false, false);
   }

   private zzcup(String var1, Uri var2, String var3, String var4, boolean var5, boolean var6) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
      this.f = var6;
   }

   public final zzcui<String> a(String var1, String var2) {
      return zzcui.a(this, var1, null);
   }

   public final zzcup a(String var1) {
      if (this.e) {
         throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
      } else {
         return new zzcup(this.a, this.b, var1, this.d, this.e, this.f);
      }
   }

   public final zzcup b(String var1) {
      return new zzcup(this.a, this.b, this.c, var1, this.e, this.f);
   }
}
