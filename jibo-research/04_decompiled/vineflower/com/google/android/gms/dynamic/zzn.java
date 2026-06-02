package com.google.android.gms.dynamic;

import android.os.IBinder;
import java.lang.reflect.Field;

public final class zzn<T> extends IObjectWrapper.zza {
   private final T a;

   private zzn(T var1) {
      this.a = (T)var1;
   }

   public static <T> IObjectWrapper a(T var0) {
      return new zzn<>(var0);
   }

   public static <T> T a(IObjectWrapper var0) {
      int var2 = 0;
      Object var9;
      if (var0 instanceof zzn) {
         var9 = ((zzn)var0).a;
      } else {
         IBinder var6 = var0.asBinder();
         Field[] var5 = var6.getClass().getDeclaredFields();
         var9 = null;

         for (Field var4 : var5) {
            if (!var4.isSynthetic()) {
               var2++;
               var9 = var4;
            }
         }

         if (var2 != 1) {
            int var11 = var5.length;
            throw new IllegalArgumentException(new StringBuilder(64).append("Unexpected number of IObjectWrapper declared fields: ").append(var11).toString());
         }

         if (var9.isAccessible()) {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
         }

         var9.setAccessible(true);

         try {
            var9 = (Field)var9.get(var6);
         } catch (NullPointerException var7) {
            throw new IllegalArgumentException("Binder object is null.", var7);
         } catch (IllegalAccessException var8) {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", var8);
         }
      }

      return (T)var9;
   }
}
