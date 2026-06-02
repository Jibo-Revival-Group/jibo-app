package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbg;
import java.util.Arrays;

public final class zzbeh extends zzbfm {
   public static final Creator<zzbeh> CREATOR = new zzbei();
   public zzbew a;
   public byte[] b;
   public final zzfkq c;
   public final zzbec d;
   public final zzbec e;
   private int[] f;
   private String[] g;
   private int[] h;
   private byte[][] i;
   private zzctx[] j;
   private boolean k;

   public zzbeh(zzbew var1, zzfkq var2, zzbec var3, zzbec var4, int[] var5, String[] var6, int[] var7, byte[][] var8, zzctx[] var9, boolean var10) {
      this.a = var1;
      this.c = var2;
      this.d = var3;
      this.e = null;
      this.f = var5;
      this.g = null;
      this.h = var7;
      this.i = null;
      this.j = null;
      this.k = var10;
   }

   zzbeh(zzbew var1, byte[] var2, int[] var3, String[] var4, int[] var5, byte[][] var6, boolean var7, zzctx[] var8) {
      this.a = var1;
      this.b = var2;
      this.f = var3;
      this.g = var4;
      this.c = null;
      this.d = null;
      this.e = null;
      this.h = var5;
      this.i = var6;
      this.j = var8;
      this.k = var7;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (var1 instanceof zzbeh) {
            var1 = var1;
            if (!zzbg.a(this.a, var1.a)
               || !Arrays.equals(this.b, var1.b)
               || !Arrays.equals(this.f, var1.f)
               || !Arrays.equals(this.g, var1.g)
               || !zzbg.a(this.c, var1.c)
               || !zzbg.a(this.d, var1.d)
               || !zzbg.a(this.e, var1.e)
               || !Arrays.equals(this.h, var1.h)
               || !Arrays.deepEquals(this.i, var1.i)
               || !Arrays.equals(this.j, var1.j)
               || this.k != var1.k) {
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
      return Arrays.hashCode(new Object[]{this.a, this.b, this.f, this.g, this.c, this.d, this.e, this.h, this.i, this.j, this.k});
   }

   @Override
   public final String toString() {
      StringBuilder var2 = new StringBuilder("LogEventParcelable[").append(this.a).append(", LogEventBytes: ");
      String var1;
      if (this.b == null) {
         var1 = null;
      } else {
         var1 = new String(this.b);
      }

      return var2.append(var1)
         .append(", TestCodes: ")
         .append(Arrays.toString(this.f))
         .append(", MendelPackages: ")
         .append(Arrays.toString(this.g))
         .append(", LogEvent: ")
         .append(this.c)
         .append(", ExtensionProducer: ")
         .append(this.d)
         .append(", VeProducer: ")
         .append(this.e)
         .append(", ExperimentIDs: ")
         .append(Arrays.toString(this.h))
         .append(", ExperimentTokens: ")
         .append(Arrays.toString(this.i))
         .append(", ExperimentTokensParcelables: ")
         .append(Arrays.toString(this.j))
         .append(", AddPhenotypeExperimentTokens: ")
         .append(this.k)
         .append("]")
         .toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 2, this.a, var2, false);
      zzbfp.a(var1, 3, this.b, false);
      zzbfp.a(var1, 4, this.f, false);
      zzbfp.a(var1, 5, this.g, false);
      zzbfp.a(var1, 6, this.h, false);
      zzbfp.a(var1, 7, this.i, false);
      zzbfp.a(var1, 8, this.k);
      zzbfp.a(var1, 9, this.j, var2, false);
      zzbfp.a(var1, var3);
   }
}
