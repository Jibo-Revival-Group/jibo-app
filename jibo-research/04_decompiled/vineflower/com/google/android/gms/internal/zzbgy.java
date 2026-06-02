package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zza;
import com.google.android.gms.common.util.zzb;
import com.google.android.gms.common.util.zzo;
import com.google.android.gms.common.util.zzp;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class zzbgy extends zzbgq {
   public static final Creator<zzbgy> CREATOR = new zzbgz();
   private final int a;
   private final Parcel b;
   private final int c;
   private final zzbgt d;
   private final String e;
   private int f;
   private int g;

   zzbgy(int var1, Parcel var2, zzbgt var3) {
      this.a = var1;
      this.b = zzbq.a(var2);
      this.c = 2;
      this.d = var3;
      if (this.d == null) {
         this.e = null;
      } else {
         this.e = this.d.a();
      }

      this.f = 2;
   }

   private static HashMap<String, String> a(Bundle var0) {
      HashMap var3 = new HashMap();

      for (String var1 : var0.keySet()) {
         var3.put(var1, var0.getString(var1));
      }

      return var3;
   }

   private static void a(StringBuilder var0, int var1, Object var2) {
      switch (var1) {
         case 0:
         case 1:
         case 2:
         case 3:
         case 4:
         case 5:
         case 6:
            var0.append(var2);
            break;
         case 7:
            var0.append("\"").append(zzo.a(var2.toString())).append("\"");
            break;
         case 8:
            var0.append("\"").append(zzb.a((byte[])var2)).append("\"");
            break;
         case 9:
            var0.append("\"").append(zzb.b((byte[])var2));
            var0.append("\"");
            break;
         case 10:
            zzp.a(var0, (HashMap<String, String>)var2);
            break;
         case 11:
            throw new IllegalArgumentException("Method does not accept concrete type.");
         default:
            throw new IllegalArgumentException(new StringBuilder(26).append("Unknown type = ").append(var1).toString());
      }
   }

   private final void a(StringBuilder var1, zzbgo<?, ?> var2, Parcel var3, int var4) {
      Object var10 = null;
      String var9 = null;
      int var5 = 0;
      int var6 = 0;
      if (!var2.d) {
         switch (var2.c) {
            case 0:
               var1.append(zzbfn.f(var3, var4));
               break;
            case 1:
               var1.append(zzbfn.j(var3, var4));
               break;
            case 2:
               var1.append(zzbfn.h(var3, var4));
               break;
            case 3:
               var1.append(zzbfn.k(var3, var4));
               break;
            case 4:
               var1.append(zzbfn.m(var3, var4));
               break;
            case 5:
               var1.append(zzbfn.o(var3, var4));
               break;
            case 6:
               var1.append(zzbfn.c(var3, var4));
               break;
            case 7:
               String var17 = zzbfn.p(var3, var4);
               var1.append("\"").append(zzo.a(var17)).append("\"");
               break;
            case 8:
               byte[] var16 = zzbfn.s(var3, var4);
               var1.append("\"").append(zzb.a(var16)).append("\"");
               break;
            case 9:
               byte[] var15 = zzbfn.s(var3, var4);
               var1.append("\"").append(zzb.b(var15));
               var1.append("\"");
               break;
            case 10:
               Bundle var14 = zzbfn.r(var3, var4);
               Set var20 = var14.keySet();
               var20.size();
               var1.append("{");
               Iterator var21 = var20.iterator();

               for (boolean var26 = true; var21.hasNext(); var26 = false) {
                  var9 = (String)var21.next();
                  if (!var26) {
                     var1.append(",");
                  }

                  var1.append("\"").append(var9).append("\"");
                  var1.append(":");
                  var1.append("\"").append(zzo.a(var14.getString(var9))).append("\"");
               }

               var1.append("}");
               break;
            case 11:
               var3 = zzbfn.C(var3, var4);
               var3.setDataPosition(0);
               this.a(var1, var2.c(), var3);
               break;
            default:
               throw new IllegalStateException("Unknown field type out");
         }
      } else {
         var1.append("[");
         switch (var2.c) {
            case 0:
               int[] var13 = zzbfn.v(var3, var4);
               var5 = var13.length;

               for (int var25 = var6; var25 < var5; var25++) {
                  if (var25 != 0) {
                     var1.append(",");
                  }

                  var1.append(Integer.toString(var13[var25]));
               }
               break;
            case 1:
               int var7 = zzbfn.a(var3, var4);
               int var8 = var3.dataPosition();
               BigInteger[] var12;
               if (var7 == 0) {
                  var12 = var9;
               } else {
                  var6 = var3.readInt();
                  var12 = new BigInteger[var6];

                  for (int var24 = var5; var24 < var6; var24++) {
                     var12[var24] = new BigInteger(var3.createByteArray());
                  }

                  var3.setDataPosition(var7 + var8);
               }

               zza.a(var1, var12);
               break;
            case 2:
               zza.a(var1, zzbfn.w(var3, var4));
               break;
            case 3:
               zza.a(var1, zzbfn.x(var3, var4));
               break;
            case 4:
               var4 = zzbfn.a(var3, var4);
               var5 = var3.dataPosition();
               double[] var11;
               if (var4 == 0) {
                  var11 = (double[])var10;
               } else {
                  var11 = var3.createDoubleArray();
                  var3.setDataPosition(var4 + var5);
               }

               zza.a(var1, var11);
               break;
            case 5:
               zza.a(var1, zzbfn.y(var3, var4));
               break;
            case 6:
               zza.a(var1, zzbfn.u(var3, var4));
               break;
            case 7:
               zza.a(var1, zzbfn.z(var3, var4));
               break;
            case 8:
            case 9:
            case 10:
               throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
            case 11:
               Parcel[] var18 = zzbfn.D(var3, var4);
               var5 = var18.length;

               for (int var22 = 0; var22 < var5; var22++) {
                  if (var22 > 0) {
                     var1.append(",");
                  }

                  var18[var22].setDataPosition(0);
                  this.a(var1, var2.c(), var18[var22]);
               }
               break;
            default:
               throw new IllegalStateException("Unknown field type out.");
         }

         var1.append("]");
      }
   }

   private final void a(StringBuilder var1, zzbgo<?, ?> var2, Object var3) {
      if (var2.b) {
         var3 = var3;
         var1.append("[");
         int var5 = var3.size();

         for (int var4 = 0; var4 < var5; var4++) {
            if (var4 != 0) {
               var1.append(",");
            }

            a(var1, var2.a, var3.get(var4));
         }

         var1.append("]");
      } else {
         a(var1, var2.a, var3);
      }
   }

   private final void a(StringBuilder var1, Map<String, zzbgo<?, ?>> var2, Parcel var3) {
      SparseArray var7 = new SparseArray();

      for (Entry var8 : var2.entrySet()) {
         var7.put(((zzbgo)var8.getValue()).f, var8);
      }

      var1.append('{');
      int var5 = zzbfn.a(var3);
      int var4 = 0;

      while (var3.dataPosition() < var5) {
         int var6 = var3.readInt();
         Entry var12 = (Entry)var7.get(65535 & var6);
         if (var12 != null) {
            if (var4) {
               var1.append(",");
            }

            String var10 = (String)var12.getKey();
            zzbgo var13 = (zzbgo)var12.getValue();
            var1.append("\"").append(var10).append("\":");
            if (var13.b()) {
               switch (var13.c) {
                  case 0:
                     this.a(var1, var13, a(var13, zzbfn.f(var3, var6)));
                     break;
                  case 1:
                     this.a(var1, var13, a(var13, zzbfn.j(var3, var6)));
                     break;
                  case 2:
                     this.a(var1, var13, a(var13, zzbfn.h(var3, var6)));
                     break;
                  case 3:
                     this.a(var1, var13, a(var13, zzbfn.k(var3, var6)));
                     break;
                  case 4:
                     this.a(var1, var13, a(var13, zzbfn.m(var3, var6)));
                     break;
                  case 5:
                     this.a(var1, var13, a(var13, zzbfn.o(var3, var6)));
                     break;
                  case 6:
                     this.a(var1, var13, a(var13, zzbfn.c(var3, var6)));
                     break;
                  case 7:
                     this.a(var1, var13, a(var13, zzbfn.p(var3, var6)));
                     break;
                  case 8:
                  case 9:
                     this.a(var1, var13, a(var13, zzbfn.s(var3, var6)));
                     break;
                  case 10:
                     this.a(var1, var13, a(var13, a(zzbfn.r(var3, var6))));
                     break;
                  case 11:
                     throw new IllegalArgumentException("Method does not accept concrete type.");
                  default:
                     var4 = var13.c;
                     throw new IllegalArgumentException(new StringBuilder(36).append("Unknown field out type = ").append(var4).toString());
               }
            } else {
               this.a(var1, var13, var3, var6);
            }

            var4 = 1;
         }
      }

      if (var3.dataPosition() != var5) {
         throw new zzbfo(new StringBuilder(37).append("Overread allowed size end=").append(var5).toString(), var3);
      }

      var1.append('}');
   }

   private Parcel b() {
      switch (this.f) {
         case 0:
            this.g = zzbfp.a(this.b);
         case 1:
            zzbfp.a(this.b, this.g);
            this.f = 2;
         default:
            return this.b;
      }
   }

   @Override
   public final Object a(String var1) {
      throw new UnsupportedOperationException("Converting to JSON does not require this method.");
   }

   @Override
   public final Map<String, zzbgo<?, ?>> a() {
      Map var1;
      if (this.d == null) {
         var1 = null;
      } else {
         var1 = this.d.a(this.e);
      }

      return var1;
   }

   @Override
   public final boolean b(String var1) {
      throw new UnsupportedOperationException("Converting to JSON does not require this method.");
   }

   @Override
   public String toString() {
      zzbq.a(this.d, "Cannot convert to JSON on client side.");
      Parcel var1 = this.b();
      var1.setDataPosition(0);
      StringBuilder var2 = new StringBuilder(100);
      this.a(var2, this.d.a(this.e), var1);
      return var2.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a);
      zzbfp.a(var1, 2, this.b(), false);
      zzbgt var4;
      switch (this.c) {
         case 0:
            var4 = null;
            break;
         case 1:
            var4 = this.d;
            break;
         case 2:
            var4 = this.d;
            break;
         default:
            var2 = this.c;
            throw new IllegalStateException(new StringBuilder(34).append("Invalid creation type: ").append(var2).toString());
      }

      zzbfp.a(var1, 3, var4, var2, false);
      zzbfp.a(var1, var3);
   }
}
