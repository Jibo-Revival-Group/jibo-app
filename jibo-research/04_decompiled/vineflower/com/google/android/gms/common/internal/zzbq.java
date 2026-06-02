package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

public final class zzbq {
   public static <T> T a(T var0) {
      if (var0 == null) {
         throw new NullPointerException("null reference");
      } else {
         return (T)var0;
      }
   }

   public static <T> T a(T var0, Object var1) {
      if (var0 == null) {
         throw new NullPointerException(String.valueOf(var1));
      } else {
         return (T)var0;
      }
   }

   public static String a(String var0) {
      if (TextUtils.isEmpty(var0)) {
         throw new IllegalArgumentException("Given String is empty or null");
      } else {
         return var0;
      }
   }

   public static String a(String var0, Object var1) {
      if (TextUtils.isEmpty(var0)) {
         throw new IllegalArgumentException(String.valueOf(var1));
      } else {
         return var0;
      }
   }

   public static void a(Handler var0) {
      if (Looper.myLooper() != var0.getLooper()) {
         throw new IllegalStateException("Must be called on the handler thread");
      }
   }

   public static void a(boolean var0) {
      if (!var0) {
         throw new IllegalStateException();
      }
   }

   public static void a(boolean var0, Object var1) {
      if (!var0) {
         throw new IllegalStateException(String.valueOf(var1));
      }
   }

   public static void a(boolean var0, String var1, Object... var2) {
      if (!var0) {
         throw new IllegalStateException(String.format(var1, var2));
      }
   }

   public static void b(String var0) {
      if (!com.google.android.gms.common.util.zzw.a()) {
         throw new IllegalStateException(var0);
      }
   }

   public static void b(boolean var0) {
      if (!var0) {
         throw new IllegalArgumentException();
      }
   }

   public static void b(boolean var0, Object var1) {
      if (!var0) {
         throw new IllegalArgumentException(String.valueOf(var1));
      }
   }

   public static void b(boolean var0, String var1, Object... var2) {
      if (!var0) {
         throw new IllegalArgumentException(String.format(var1, var2));
      }
   }

   public static void c(String var0) {
      if (com.google.android.gms.common.util.zzw.a()) {
         throw new IllegalStateException(var0);
      }
   }
}
