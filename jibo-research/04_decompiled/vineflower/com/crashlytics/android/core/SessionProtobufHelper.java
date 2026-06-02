package com.crashlytics.android.core;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.Build.VERSION;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.common.IdManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class SessionProtobufHelper {
   private static final ByteString a = ByteString.a("0");
   private static final ByteString b = ByteString.a("Unity");

   private static int a() {
      return 0 + CodedOutputStream.b(1, a) + CodedOutputStream.b(2, a) + CodedOutputStream.b(3, 0L);
   }

   private static int a(
      int var0,
      ByteString var1,
      ByteString var2,
      int var3,
      long var4,
      long var6,
      boolean var8,
      Map<IdManager.DeviceIdentifierType, String> var9,
      int var10,
      ByteString var11,
      ByteString var12
   ) {
      int var13 = CodedOutputStream.b(1, var1);
      int var14 = CodedOutputStream.e(3, var0);
      if (var2 == null) {
         var0 = 0;
      } else {
         var0 = CodedOutputStream.b(4, var2);
      }

      var0 = var0
         + var14
         + 0
         + var13
         + CodedOutputStream.d(5, var3)
         + CodedOutputStream.b(6, var4)
         + CodedOutputStream.b(7, var6)
         + CodedOutputStream.b(10, var8);
      if (var9 != null) {
         Iterator var18 = var9.entrySet().iterator();

         while (true) {
            var3 = var0;
            if (!var18.hasNext()) {
               break;
            }

            Entry var19 = (Entry)var18.next();
            var3 = a((IdManager.DeviceIdentifierType)var19.getKey(), (String)var19.getValue());
            var0 += var3 + CodedOutputStream.j(11) + CodedOutputStream.l(var3);
         }
      } else {
         var3 = var0;
      }

      var13 = CodedOutputStream.d(12, var10);
      if (var11 == null) {
         var0 = 0;
      } else {
         var0 = CodedOutputStream.b(13, var11);
      }

      if (var12 == null) {
         var10 = 0;
      } else {
         var10 = CodedOutputStream.b(14, var12);
      }

      return var10 + var3 + var13 + var0;
   }

   private static int a(
      long var0,
      String var2,
      TrimmedThrowableData var3,
      Thread var4,
      StackTraceElement[] var5,
      Thread[] var6,
      List<StackTraceElement[]> var7,
      int var8,
      Map<String, String> var9,
      RunningAppProcessInfo var10,
      int var11,
      ByteString var12,
      ByteString var13,
      Float var14,
      int var15,
      boolean var16,
      long var17,
      long var19,
      ByteString var21
   ) {
      int var22 = CodedOutputStream.b(1, var0);
      int var23 = CodedOutputStream.b(2, ByteString.a(var2));
      int var25 = a(var3, var4, var5, var6, var7, var8, var12, var13, var9, var10, var11);
      int var24 = CodedOutputStream.j(3);
      var8 = CodedOutputStream.l(var25);
      var11 = a(var14, var15, var16, var11, var17, var19);
      var11 = var11 + CodedOutputStream.j(5) + CodedOutputStream.l(var11) + 0 + var22 + var23 + var25 + var24 + var8;
      var8 = var11;
      if (var21 != null) {
         var8 = b(var21);
         var8 = var11 + var8 + CodedOutputStream.j(6) + CodedOutputStream.l(var8);
      }

      return var8;
   }

   private static int a(ByteString var0) {
      return 0 + CodedOutputStream.b(1, var0);
   }

   private static int a(ByteString var0, ByteString var1) {
      int var3 = 0 + CodedOutputStream.b(1, 0L) + CodedOutputStream.b(2, 0L) + CodedOutputStream.b(3, var0);
      int var2 = var3;
      if (var1 != null) {
         var2 = var3 + CodedOutputStream.b(4, var1);
      }

      return var2;
   }

   private static int a(ByteString var0, ByteString var1, ByteString var2, ByteString var3, ByteString var4, int var5, ByteString var6) {
      int var7 = CodedOutputStream.b(1, var0);
      int var10 = CodedOutputStream.b(2, var2);
      int var8 = CodedOutputStream.b(3, var3);
      int var9 = a(var1);
      var8 = 0 + var7 + var10 + var8 + var9 + CodedOutputStream.j(5) + CodedOutputStream.l(var9) + CodedOutputStream.b(6, var4);
      var7 = var8;
      if (var6 != null) {
         var7 = var8 + CodedOutputStream.b(8, b) + CodedOutputStream.b(9, var6);
      }

      return var7 + CodedOutputStream.e(10, var5);
   }

   private static int a(ByteString var0, ByteString var1, boolean var2) {
      return 0 + CodedOutputStream.e(1, 3) + CodedOutputStream.b(2, var0) + CodedOutputStream.b(3, var1) + CodedOutputStream.b(4, var2);
   }

   private static int a(TrimmedThrowableData var0, int var1, int var2) {
      byte var5 = 0;
      int var4 = CodedOutputStream.b(1, ByteString.a(var0.b)) + 0;
      String var10 = var0.a;
      int var3 = var4;
      if (var10 != null) {
         var3 = var4 + CodedOutputStream.b(3, ByteString.a(var10));
      }

      StackTraceElement[] var16 = var0.c;
      int var6 = var16.length;
      var4 = 0;

      while (var4 < var6) {
         int var7 = a(var16[var4], true);
         int var9 = CodedOutputStream.j(4);
         int var8 = CodedOutputStream.l(var7);
         var4++;
         var3 += var7 + var9 + var8;
      }

      TrimmedThrowableData var17 = var0.d;
      var4 = var3;
      if (var17 != null) {
         var4 = var5;
         var0 = var17;
         if (var1 < var2) {
            var1 = a(var17, var1 + 1, var2);
            var4 = var3 + var1 + CodedOutputStream.j(6) + CodedOutputStream.l(var1);
         } else {
            while (var0 != null) {
               var0 = var0.d;
               var4++;
            }

            var4 = var3 + CodedOutputStream.d(7, var4);
         }
      }

      return var4;
   }

   private static int a(
      TrimmedThrowableData var0,
      Thread var1,
      StackTraceElement[] var2,
      Thread[] var3,
      List<StackTraceElement[]> var4,
      int var5,
      ByteString var6,
      ByteString var7
   ) {
      int var8 = a(var1, var2, 4, true);
      int var11 = CodedOutputStream.j(1);
      int var9 = CodedOutputStream.l(var8);
      int var10 = var3.length;
      var8 = var8 + var11 + var9 + 0;

      for (int var17 = 0; var17 < var10; var17++) {
         var11 = a(var3[var17], (StackTraceElement[])var4.get(var17), 0, false);
         var8 += var11 + CodedOutputStream.j(1) + CodedOutputStream.l(var11);
      }

      int var14 = a(var0, 1, var5);
      var11 = CodedOutputStream.j(2);
      var5 = CodedOutputStream.l(var14);
      var10 = a();
      var9 = CodedOutputStream.j(3);
      int var12 = CodedOutputStream.l(var10);
      int var13 = a(var6, var7);
      return var14 + var11 + var5 + var8 + var10 + var9 + var12 + var13 + CodedOutputStream.j(3) + CodedOutputStream.l(var13);
   }

   private static int a(
      TrimmedThrowableData var0,
      Thread var1,
      StackTraceElement[] var2,
      Thread[] var3,
      List<StackTraceElement[]> var4,
      int var5,
      ByteString var6,
      ByteString var7,
      Map<String, String> var8,
      RunningAppProcessInfo var9,
      int var10
   ) {
      var5 = a(var0, var1, var2, var3, var4, var5, var6, var7);
      var5 = 0 + var5 + CodedOutputStream.j(1) + CodedOutputStream.l(var5);
      if (var8 != null) {
         for (Entry var14 : var8.entrySet()) {
            int var11 = a((String)var14.getKey(), (String)var14.getValue());
            var5 += var11 + CodedOutputStream.j(2) + CodedOutputStream.l(var11);
         }
      }

      if (var9 != null) {
         boolean var12;
         if (var9.importance != 100) {
            var12 = true;
         } else {
            var12 = false;
         }

         var5 += CodedOutputStream.b(3, var12);
      }

      return var5 + CodedOutputStream.d(4, var10);
   }

   private static int a(IdManager.DeviceIdentifierType var0, String var1) {
      return CodedOutputStream.e(1, var0.protobufIndex) + CodedOutputStream.b(2, ByteString.a(var1));
   }

   private static int a(Float var0, int var1, boolean var2, int var3, long var4, long var6) {
      int var8 = 0;
      if (var0 != null) {
         var8 = 0 + CodedOutputStream.b(1, var0);
      }

      return var8
         + CodedOutputStream.f(2, var1)
         + CodedOutputStream.b(3, var2)
         + CodedOutputStream.d(4, var3)
         + CodedOutputStream.b(5, var4)
         + CodedOutputStream.b(6, var6);
   }

   private static int a(StackTraceElement var0, boolean var1) {
      int var2;
      if (var0.isNativeMethod()) {
         var2 = CodedOutputStream.b(1, (long)Math.max(var0.getLineNumber(), 0)) + 0;
      } else {
         var2 = CodedOutputStream.b(1, 0L) + 0;
      }

      int var3 = var2 + CodedOutputStream.b(2, ByteString.a(var0.getClassName() + "." + var0.getMethodName()));
      var2 = var3;
      if (var0.getFileName() != null) {
         var2 = var3 + CodedOutputStream.b(3, ByteString.a(var0.getFileName()));
      }

      if (!var0.isNativeMethod() && var0.getLineNumber() > 0) {
         var2 += CodedOutputStream.b(4, (long)var0.getLineNumber());
      }

      byte var5;
      if (var1) {
         var5 = 2;
      } else {
         var5 = 0;
      }

      return CodedOutputStream.d(5, var5) + var2;
   }

   private static int a(String var0, String var1) {
      int var2 = CodedOutputStream.b(1, ByteString.a(var0));
      var0 = var1;
      if (var1 == null) {
         var0 = "";
      }

      return var2 + CodedOutputStream.b(2, ByteString.a(var0));
   }

   private static int a(Thread var0, StackTraceElement[] var1, int var2, boolean var3) {
      int var4 = CodedOutputStream.b(1, ByteString.a(var0.getName()));
      var2 = CodedOutputStream.d(2, var2) + var4;
      int var5 = var1.length;

      for (int var8 = 0; var8 < var5; var8++) {
         int var6 = a(var1[var8], var3);
         var2 += var6 + CodedOutputStream.j(3) + CodedOutputStream.l(var6);
      }

      return var2;
   }

   private static ByteString a(String var0) {
      ByteString var1;
      if (var0 == null) {
         var1 = null;
      } else {
         var1 = ByteString.a(var0);
      }

      return var1;
   }

   private static void a(CodedOutputStream var0, int var1, StackTraceElement var2, boolean var3) throws Exception {
      byte var4 = 4;
      var0.g(var1, 2);
      var0.k(a(var2, var3));
      if (var2.isNativeMethod()) {
         var0.a(1, (long)Math.max(var2.getLineNumber(), 0));
      } else {
         var0.a(1, 0L);
      }

      var0.a(2, ByteString.a(var2.getClassName() + "." + var2.getMethodName()));
      if (var2.getFileName() != null) {
         var0.a(3, ByteString.a(var2.getFileName()));
      }

      if (!var2.isNativeMethod() && var2.getLineNumber() > 0) {
         var0.a(4, (long)var2.getLineNumber());
      }

      byte var5;
      if (var3) {
         var5 = var4;
      } else {
         var5 = 0;
      }

      var0.a(5, var5);
   }

   public static void a(
      CodedOutputStream var0,
      long var1,
      String var3,
      TrimmedThrowableData var4,
      Thread var5,
      StackTraceElement[] var6,
      Thread[] var7,
      List<StackTraceElement[]> var8,
      Map<String, String> var9,
      LogFileManager var10,
      RunningAppProcessInfo var11,
      int var12,
      String var13,
      String var14,
      Float var15,
      int var16,
      boolean var17,
      long var18,
      long var20
   ) throws Exception {
      ByteString var22 = ByteString.a(var13);
      ByteString var23;
      if (var14 == null) {
         var23 = null;
      } else {
         var23 = ByteString.a(var14.replace("-", ""));
      }

      ByteString var24 = var10.a();
      if (var24 == null) {
         Fabric.h().a("CrashlyticsCore", "No log data to include with this event.");
      }

      var10.b();
      var0.g(10, 2);
      var0.k(a(var1, var3, var4, var5, var6, var7, var8, 8, var9, var11, var12, var22, var23, var15, var16, var17, var18, var20, var24));
      var0.a(1, var1);
      var0.a(2, ByteString.a(var3));
      a(var0, var4, var5, var6, var7, var8, 8, var22, var23, var9, var11, var12);
      a(var0, var15, var16, var17, var12, var18, var20);
      a(var0, var24);
   }

   private static void a(CodedOutputStream var0, ByteString var1) throws Exception {
      if (var1 != null) {
         var0.g(6, 2);
         var0.k(b(var1));
         var0.a(1, var1);
      }
   }

   private static void a(CodedOutputStream var0, TrimmedThrowableData var1, int var2, int var3, int var4) throws Exception {
      byte var5 = 0;
      var0.g(var4, 2);
      var0.k(a(var1, 1, var3));
      var0.a(1, ByteString.a(var1.b));
      String var7 = var1.a;
      if (var7 != null) {
         var0.a(3, ByteString.a(var7));
      }

      StackTraceElement[] var11 = var1.c;
      int var6 = var11.length;

      for (int var9 = 0; var9 < var6; var9++) {
         a(var0, 4, var11[var9], true);
      }

      TrimmedThrowableData var12 = var1.d;
      if (var12 != null) {
         var4 = var5;
         var1 = var12;
         if (var2 < var3) {
            a(var0, var12, var2 + 1, var3, 6);
         } else {
            while (var1 != null) {
               var1 = var1.d;
               var4++;
            }

            var0.a(7, var4);
         }
      }
   }

   private static void a(
      CodedOutputStream var0,
      TrimmedThrowableData var1,
      Thread var2,
      StackTraceElement[] var3,
      Thread[] var4,
      List<StackTraceElement[]> var5,
      int var6,
      ByteString var7,
      ByteString var8
   ) throws Exception {
      var0.g(1, 2);
      var0.k(a(var1, var2, var3, var4, var5, var6, var7, var8));
      a(var0, var2, var3, 4, true);
      int var10 = var4.length;

      for (int var9 = 0; var9 < var10; var9++) {
         a(var0, var4[var9], (StackTraceElement[])var5.get(var9), 0, false);
      }

      a(var0, var1, 1, var6, 2);
      var0.g(3, 2);
      var0.k(a());
      var0.a(1, a);
      var0.a(2, a);
      var0.a(3, 0L);
      var0.g(4, 2);
      var0.k(a(var7, var8));
      var0.a(1, 0L);
      var0.a(2, 0L);
      var0.a(3, var7);
      if (var8 != null) {
         var0.a(4, var8);
      }
   }

   private static void a(
      CodedOutputStream var0,
      TrimmedThrowableData var1,
      Thread var2,
      StackTraceElement[] var3,
      Thread[] var4,
      List<StackTraceElement[]> var5,
      int var6,
      ByteString var7,
      ByteString var8,
      Map<String, String> var9,
      RunningAppProcessInfo var10,
      int var11
   ) throws Exception {
      var0.g(3, 2);
      var0.k(a(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11));
      a(var0, var1, var2, var3, var4, var5, var6, var7, var8);
      if (var9 != null && !var9.isEmpty()) {
         a(var0, var9);
      }

      if (var10 != null) {
         boolean var12;
         if (var10.importance != 100) {
            var12 = true;
         } else {
            var12 = false;
         }

         var0.a(3, var12);
      }

      var0.a(4, var11);
   }

   private static void a(CodedOutputStream var0, Float var1, int var2, boolean var3, int var4, long var5, long var7) throws Exception {
      var0.g(5, 2);
      var0.k(a(var1, var2, var3, var4, var5, var7));
      if (var1 != null) {
         var0.a(1, var1);
      }

      var0.c(2, var2);
      var0.a(3, var3);
      var0.a(4, var4);
      var0.a(5, var5);
      var0.a(6, var7);
   }

   public static void a(
      CodedOutputStream var0,
      String var1,
      int var2,
      String var3,
      int var4,
      long var5,
      long var7,
      boolean var9,
      Map<IdManager.DeviceIdentifierType, String> var10,
      int var11,
      String var12,
      String var13
   ) throws Exception {
      ByteString var15 = ByteString.a(var1);
      ByteString var14 = a(var3);
      ByteString var17 = a(var13);
      ByteString var19 = a(var12);
      var0.g(9, 2);
      var0.k(a(var2, var15, var14, var4, var5, var7, var9, var10, var11, var19, var17));
      var0.a(1, var15);
      var0.b(3, var2);
      var0.a(4, var14);
      var0.a(5, var4);
      var0.a(6, var5);
      var0.a(7, var7);
      var0.a(10, var9);

      for (Entry var18 : var10.entrySet()) {
         var0.g(11, 2);
         var0.k(a((IdManager.DeviceIdentifierType)var18.getKey(), (String)var18.getValue()));
         var0.b(1, ((IdManager.DeviceIdentifierType)var18.getKey()).protobufIndex);
         var0.a(2, ByteString.a((String)var18.getValue()));
      }

      var0.a(12, var11);
      if (var19 != null) {
         var0.a(13, var19);
      }

      if (var17 != null) {
         var0.a(14, var17);
      }
   }

   public static void a(CodedOutputStream var0, String var1, String var2, long var3) throws Exception {
      var0.a(1, ByteString.a(var2));
      var0.a(2, ByteString.a(var1));
      var0.a(3, var3);
   }

   public static void a(CodedOutputStream var0, String var1, String var2, String var3) throws Exception {
      String var6 = var1;
      if (var1 == null) {
         var6 = "";
      }

      ByteString var8 = ByteString.a(var6);
      ByteString var10 = a(var2);
      ByteString var7 = a(var3);
      int var5 = 0 + CodedOutputStream.b(1, var8);
      int var4 = var5;
      if (var2 != null) {
         var4 = var5 + CodedOutputStream.b(2, var10);
      }

      var5 = var4;
      if (var3 != null) {
         var5 = var4 + CodedOutputStream.b(3, var7);
      }

      var0.g(6, 2);
      var0.k(var5);
      var0.a(1, var8);
      if (var2 != null) {
         var0.a(2, var10);
      }

      if (var3 != null) {
         var0.a(3, var7);
      }
   }

   public static void a(CodedOutputStream var0, String var1, String var2, String var3, String var4, String var5, int var6, String var7) throws Exception {
      ByteString var8 = ByteString.a(var1);
      ByteString var10 = ByteString.a(var2);
      ByteString var11 = ByteString.a(var3);
      ByteString var12 = ByteString.a(var4);
      ByteString var13 = ByteString.a(var5);
      ByteString var9;
      if (var7 != null) {
         var9 = ByteString.a(var7);
      } else {
         var9 = null;
      }

      var0.g(7, 2);
      var0.k(a(var8, var10, var11, var12, var13, var6, var9));
      var0.a(1, var8);
      var0.a(2, var11);
      var0.a(3, var12);
      var0.g(5, 2);
      var0.k(a(var10));
      var0.a(1, var10);
      var0.a(6, var13);
      if (var9 != null) {
         var0.a(8, b);
         var0.a(9, var9);
      }

      var0.b(10, var6);
   }

   private static void a(CodedOutputStream var0, Thread var1, StackTraceElement[] var2, int var3, boolean var4) throws Exception {
      var0.g(1, 2);
      var0.k(a(var1, var2, var3, var4));
      var0.a(1, ByteString.a(var1.getName()));
      var0.a(2, var3);
      int var5 = var2.length;

      for (int var6 = 0; var6 < var5; var6++) {
         a(var0, 3, var2[var6], var4);
      }
   }

   private static void a(CodedOutputStream var0, Map<String, String> var1) throws Exception {
      for (Entry var4 : var1.entrySet()) {
         var0.g(2, 2);
         var0.k(a((String)var4.getKey(), (String)var4.getValue()));
         var0.a(1, ByteString.a((String)var4.getKey()));
         String var2 = (String)var4.getValue();
         String var5 = var2;
         if (var2 == null) {
            var5 = "";
         }

         var0.a(2, ByteString.a(var5));
      }
   }

   public static void a(CodedOutputStream var0, boolean var1) throws Exception {
      ByteString var2 = ByteString.a(VERSION.RELEASE);
      ByteString var3 = ByteString.a(VERSION.CODENAME);
      var0.g(8, 2);
      var0.k(a(var2, var3, var1));
      var0.b(1, 3);
      var0.a(2, var2);
      var0.a(3, var3);
      var0.a(4, var1);
   }

   private static int b(ByteString var0) {
      return CodedOutputStream.b(1, var0);
   }
}
