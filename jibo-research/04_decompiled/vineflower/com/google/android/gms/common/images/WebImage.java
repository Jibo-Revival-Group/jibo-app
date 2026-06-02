package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;
import java.util.Locale;

public final class WebImage extends zzbfm {
   public static final Creator<WebImage> CREATOR = new zze();
   private int a;
   private final Uri b;
   private final int c;
   private final int d;

   WebImage(int var1, Uri var2, int var3, int var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public final Uri a() {
      return this.b;
   }

   public final int b() {
      return this.c;
   }

   public final int c() {
      return this.d;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (var1 != null && var1 instanceof WebImage) {
            var1 = var1;
            if (!zzbg.a(this.b, var1.b) || this.c != var1.c || this.d != var1.d) {
               var2 = false;
            }
         } else {
            var2 = false;
         }
      }

      return var2;
   }

   @Override
   public final int hashCode() {
      return Arrays.hashCode(new Object[]{this.b, this.c, this.d});
   }

   @Override
   public final String toString() {
      return String.format(Locale.US, "Image %dx%d %s", this.c, this.d, this.b.toString());
   }

   public final void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a);
      zzbfp.a(var1, 2, this.a(), var2, false);
      zzbfp.a(var1, 3, this.b());
      zzbfp.a(var1, 4, this.c());
      zzbfp.a(var1, var3);
   }
}
