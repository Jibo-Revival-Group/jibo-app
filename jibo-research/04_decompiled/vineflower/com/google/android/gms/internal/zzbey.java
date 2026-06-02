package com.google.android.gms.internal;

public class zzbey<T> {
   private static final Object a = new Object();
   private static zzbfe b = null;
   private static int c = 0;
   private static String d = "com.google.android.providers.gsf.permission.READ_GSERVICES";
   private String e;
   private T f;
   private T g = (T)null;

   protected zzbey(String var1, T var2) {
      this.e = var1;
      this.f = (T)var2;
   }

   public static zzbey<Integer> a(String var0, Integer var1) {
      return new zzbfb(var0, var1);
   }

   public static zzbey<Long> a(String var0, Long var1) {
      return new zzbfa(var0, var1);
   }

   public static zzbey<String> a(String var0, String var1) {
      return new zzbfd(var0, var1);
   }

   public static zzbey<Boolean> a(String var0, boolean var1) {
      return new zzbez(var0, var1);
   }
}
