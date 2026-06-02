package com.google.firebase.perf;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FirebasePerformance {
   private static volatile FirebasePerformance a;
   private final Map<String, String> b = new ConcurrentHashMap<>();
   private boolean c = true;

   private FirebasePerformance() {
      try {
         FirebaseApp.d();
      } catch (IllegalStateException var2) {
         this.c = false;
         return;
      }

      Context var1 = FirebaseApp.d().a();
      this.c = a(var1, var1.getSharedPreferences("FirebasePerfSharedPrefs", 0));
   }

   public static FirebasePerformance a() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:573)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: getstatic com/google/firebase/perf/FirebasePerformance.a Lcom/google/firebase/perf/FirebasePerformance;
      // 03: ifnonnull 1e
      // 06: ldc com/google/firebase/perf/FirebasePerformance
      // 08: monitorenter
      // 09: getstatic com/google/firebase/perf/FirebasePerformance.a Lcom/google/firebase/perf/FirebasePerformance;
      // 0c: ifnonnull 1b
      // 0f: new com/google/firebase/perf/FirebasePerformance
      // 12: astore 0
      // 13: aload 0
      // 14: invokespecial com/google/firebase/perf/FirebasePerformance.<init> ()V
      // 17: aload 0
      // 18: putstatic com/google/firebase/perf/FirebasePerformance.a Lcom/google/firebase/perf/FirebasePerformance;
      // 1b: ldc com/google/firebase/perf/FirebasePerformance
      // 1d: monitorexit
      // 1e: getstatic com/google/firebase/perf/FirebasePerformance.a Lcom/google/firebase/perf/FirebasePerformance;
      // 21: areturn
      // 22: astore 0
      // 23: ldc com/google/firebase/perf/FirebasePerformance
      // 25: monitorexit
      // 26: aload 0
      // 27: athrow
      // try (4 -> 12): 16 null
      // try (12 -> 14): 16 null
      // try (17 -> 19): 16 null
   }

   private static boolean a(Context var0) {
      try {
         return var0.getPackageManager().getApplicationInfo(var0.getPackageName(), 128).metaData.getBoolean("firebase_performance_collection_enabled", true);
      } catch (NameNotFoundException var2) {
         var4 = var2;
      } catch (NullPointerException var3) {
         var4 = var3;
      }

      String var5 = String.valueOf(var4.getMessage());
      String var6;
      if (var5.length() != 0) {
         var6 = "No perf enable meta data found ".concat(var5);
      } else {
         var6 = new String("No perf enable meta data found ");
      }

      Log.d("isEnabled", var6);
      return true;
   }

   private static boolean a(Context var0, SharedPreferences var1) {
      boolean var2;
      if (b(var0)) {
         var2 = false;
      } else {
         try {
            if (var1.contains("isEnabled")) {
               var2 = var1.getBoolean("isEnabled", true);
               return var2;
            }
         } catch (ClassCastException var3) {
            String var4 = String.valueOf(var3.getMessage());
            String var5;
            if (var4.length() != 0) {
               var5 = "Unable to access enable value: ".concat(var4);
            } else {
               var5 = new String("Unable to access enable value: ");
            }

            Log.d("FirebasePerformance", var5);
         }

         var2 = a(var0);
      }

      return var2;
   }

   private static boolean b(Context var0) {
      try {
         return var0.getPackageManager()
            .getApplicationInfo(var0.getPackageName(), 128)
            .metaData
            .getBoolean("firebase_performance_collection_deactivated", false);
      } catch (NameNotFoundException var2) {
         var4 = var2;
      } catch (NullPointerException var3) {
         var4 = var3;
      }

      String var5 = String.valueOf(var4.getMessage());
      String var6;
      if (var5.length() != 0) {
         var6 = "No perf enable meta data found ".concat(var5);
      } else {
         var6 = new String("No perf enable meta data found ");
      }

      Log.d("isEnabled", var6);
      return false;
   }

   public boolean b() {
      return this.c;
   }

   public final Map<String, String> c() {
      return new HashMap<>(this.b);
   }
}
