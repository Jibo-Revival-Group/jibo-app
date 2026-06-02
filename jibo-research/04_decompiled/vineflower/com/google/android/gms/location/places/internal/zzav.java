package com.google.android.gms.location.places.internal;

import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.zzbfq;
import com.google.android.gms.internal.zzbfr;
import com.google.android.gms.internal.zzdmz;
import com.google.android.gms.internal.zzfjr;
import java.util.ArrayList;
import java.util.List;

public class zzav extends com.google.android.gms.common.data.zzc {
   public zzav(DataHolder var1, int var2) {
      super(var1, var2);
   }

   private final byte[] a(String var1, byte[] var2) {
      byte[] var3;
      if (this.a(var1) && !this.f(var1)) {
         var3 = this.e(var1);
      } else {
         var3 = null;
      }

      return var3;
   }

   protected final float a(String var1, float var2) {
      float var3 = var2;
      if (this.a(var1)) {
         var3 = var2;
         if (!this.f(var1)) {
            var3 = this.d(var1);
         }
      }

      return var3;
   }

   protected final int a(String var1, int var2) {
      int var3 = var2;
      if (this.a(var1)) {
         var3 = var2;
         if (!this.f(var1)) {
            var3 = this.b(var1);
         }
      }

      return var3;
   }

   protected final <E extends zzbfq> E a(String var1, Creator<E> var2) {
      Object var3 = null;
      byte[] var4 = this.a(var1, (byte[])null);
      zzbfq var5;
      if (var4 == null) {
         var5 = (zzbfq)var3;
      } else {
         var5 = zzbfr.a(var4, var2);
      }

      return (E)var5;
   }

   protected final String a(String var1, String var2) {
      String var3 = var2;
      if (this.a(var1)) {
         var3 = var2;
         if (!this.f(var1)) {
            var3 = this.c(var1);
         }
      }

      return var3;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   protected final <E extends zzbfq> List<E> a(String var1, Creator<E> var2, List<E> var3) {
      byte[] var10 = this.a(var1, (byte[])null);
      List var11;
      if (var10 == null) {
         var11 = var3;
      } else {
         label47: {
            zzdmz var6;
            try {
               var6 = zzdmz.a(var10);
            } catch (zzfjr var9) {
               var12 = var9;
               List var14 = var3;
               if (!Log.isLoggable("SafeDataBufferRef", 6)) {
                  return var14;
               }
               break label47;
            }

            List var15 = var3;

            int var5;
            try {
               if (var6.c == null) {
                  return var15;
               }

               var17 = new ArrayList(var6.c.length);
               var13 = var6.c;
               var5 = var13.length;
            } catch (zzfjr var8) {
               var12 = var8;
               List var16 = var3;
               if (!Log.isLoggable("SafeDataBufferRef", 6)) {
                  return var16;
               }
               break label47;
            }

            int var4 = 0;

            while (true) {
               if (var4 >= var5) {
                  return var17;
               }

               try {
                  var17.add(zzbfr.a(var13[var4], var2));
               } catch (zzfjr var7) {
                  var12 = var7;
                  List var18 = var3;
                  if (!Log.isLoggable("SafeDataBufferRef", 6)) {
                     return var18;
                  }
                  break;
               }

               var4++;
            }
         }

         Log.e("SafeDataBufferRef", "Cannot parse byte[]", var12);
         var11 = var3;
      }

      return var11;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   protected final List<Integer> a(String var1, List<Integer> var2) {
      byte[] var8 = this.a(var1, (byte[])null);
      List var9;
      if (var8 == null) {
         var9 = var2;
      } else {
         zzfjr var4;
         label47: {
            try {
               var10 = zzdmz.a(var8);
            } catch (zzfjr var7) {
               var4 = var7;
               List var11 = var2;
               if (!Log.isLoggable("SafeDataBufferRef", 6)) {
                  return var11;
               }
               break label47;
            }

            List var12 = var2;

            try {
               if (var10.b == null) {
                  return var12;
               }

               var14 = new ArrayList(var10.b.length);
            } catch (zzfjr var6) {
               var4 = var6;
               List var13 = var2;
               if (!Log.isLoggable("SafeDataBufferRef", 6)) {
                  return var13;
               }
               break label47;
            }

            int var3 = 0;

            while (true) {
               try {
                  if (var3 >= var10.b.length) {
                     return var14;
                  }

                  var14.add(var10.b[var3]);
               } catch (zzfjr var5) {
                  var4 = var5;
                  List var15 = var2;
                  if (!Log.isLoggable("SafeDataBufferRef", 6)) {
                     return var15;
                  }
                  break;
               }

               var3++;
            }
         }

         Log.e("SafeDataBufferRef", "Cannot parse byte[]", var4);
         var9 = var2;
      }

      return var9;
   }
}
