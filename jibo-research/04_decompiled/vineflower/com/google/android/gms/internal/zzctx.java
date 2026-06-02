package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class zzctx extends zzbfm {
   public static final Creator<zzctx> CREATOR = new zzcud();
   private static byte[][] a = new byte[0][];
   private static zzctx b = new zzctx("", null, a, a, a, a, null, null);
   private static final zzcuc k = new zzcty();
   private static final zzcuc l = new zzctz();
   private static final zzcuc m = new zzcua();
   private static final zzcuc n = new zzcub();
   private String c;
   private byte[] d;
   private byte[][] e;
   private byte[][] f;
   private byte[][] g;
   private byte[][] h;
   private int[] i;
   private byte[][] j;

   public zzctx(String var1, byte[] var2, byte[][] var3, byte[][] var4, byte[][] var5, byte[][] var6, int[] var7, byte[][] var8) {
      this.c = var1;
      this.d = var2;
      this.e = var3;
      this.f = var4;
      this.g = var5;
      this.h = var6;
      this.i = var7;
      this.j = var8;
   }

   private static List<Integer> a(int[] var0) {
      List var4;
      if (var0 == null) {
         var4 = Collections.emptyList();
      } else {
         ArrayList var3 = new ArrayList(var0.length);
         int var2 = var0.length;

         for (int var1 = 0; var1 < var2; var1++) {
            var3.add(var0[var1]);
         }

         Collections.sort(var3);
         var4 = var3;
      }

      return var4;
   }

   private static List<String> a(byte[][] var0) {
      List var4;
      if (var0 == null) {
         var4 = Collections.emptyList();
      } else {
         ArrayList var3 = new ArrayList(var0.length);
         int var2 = var0.length;

         for (int var1 = 0; var1 < var2; var1++) {
            var3.add(Base64.encodeToString(var0[var1], 3));
         }

         Collections.sort(var3);
         var4 = var3;
      }

      return var4;
   }

   private static void a(StringBuilder var0, String var1, int[] var2) {
      var0.append(var1);
      var0.append("=");
      if (var2 == null) {
         var0.append("null");
      } else {
         var0.append("(");
         int var5 = var2.length;
         boolean var3 = true;

         for (int var4 = 0; var4 < var5; var3 = false) {
            int var6 = var2[var4];
            if (!var3) {
               var0.append(", ");
            }

            var0.append(var6);
            var4++;
         }

         var0.append(")");
      }
   }

   private static void a(StringBuilder var0, String var1, byte[][] var2) {
      var0.append(var1);
      var0.append("=");
      if (var2 == null) {
         var0.append("null");
      } else {
         var0.append("(");
         int var5 = var2.length;
         boolean var4 = true;

         for (int var3 = 0; var3 < var5; var4 = false) {
            byte[] var6 = var2[var3];
            if (!var4) {
               var0.append(", ");
            }

            var0.append("'");
            var0.append(Base64.encodeToString(var6, 3));
            var0.append("'");
            var3++;
         }

         var0.append(")");
      }
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var3 = false;
      boolean var2 = var3;
      if (var1 instanceof zzctx) {
         var1 = var1;
         var2 = var3;
         if (zzcuh.a(this.c, var1.c)) {
            var2 = var3;
            if (Arrays.equals(this.d, var1.d)) {
               var2 = var3;
               if (zzcuh.a(a(this.e), a(var1.e))) {
                  var2 = var3;
                  if (zzcuh.a(a(this.f), a(var1.f))) {
                     var2 = var3;
                     if (zzcuh.a(a(this.g), a(var1.g))) {
                        var2 = var3;
                        if (zzcuh.a(a(this.h), a(var1.h))) {
                           var2 = var3;
                           if (zzcuh.a(a(this.i), a(var1.i))) {
                              var2 = var3;
                              if (zzcuh.a(a(this.j), a(var1.j))) {
                                 var2 = true;
                              }
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
   public final String toString() {
      StringBuilder var2 = new StringBuilder("ExperimentTokens");
      var2.append("(");
      String var1;
      if (this.c == null) {
         var1 = "null";
      } else {
         var1 = this.c;
         var1 = new StringBuilder(String.valueOf("'").length() + String.valueOf(var1).length() + String.valueOf("'").length())
            .append("'")
            .append(var1)
            .append("'")
            .toString();
      }

      var2.append(var1);
      var2.append(", ");
      byte[] var4 = this.d;
      var2.append("direct");
      var2.append("=");
      if (var4 == null) {
         var2.append("null");
      } else {
         var2.append("'");
         var2.append(Base64.encodeToString(var4, 3));
         var2.append("'");
      }

      var2.append(", ");
      a(var2, "GAIA", this.e);
      var2.append(", ");
      a(var2, "PSEUDO", this.f);
      var2.append(", ");
      a(var2, "ALWAYS", this.g);
      var2.append(", ");
      a(var2, "OTHER", this.h);
      var2.append(", ");
      a(var2, "weak", this.i);
      var2.append(", ");
      a(var2, "directs", this.j);
      var2.append(")");
      return var2.toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 2, this.c, false);
      zzbfp.a(var1, 3, this.d, false);
      zzbfp.a(var1, 4, this.e, false);
      zzbfp.a(var1, 5, this.f, false);
      zzbfp.a(var1, 6, this.g, false);
      zzbfp.a(var1, 7, this.h, false);
      zzbfp.a(var1, 8, this.i, false);
      zzbfp.a(var1, 9, this.j, false);
      zzbfp.a(var1, var2);
   }
}
