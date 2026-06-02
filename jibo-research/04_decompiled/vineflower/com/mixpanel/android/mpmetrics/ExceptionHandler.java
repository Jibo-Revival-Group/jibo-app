package com.mixpanel.android.mpmetrics;

import android.os.Process;
import java.lang.Thread.UncaughtExceptionHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class ExceptionHandler implements UncaughtExceptionHandler {
   private static ExceptionHandler a;
   private final UncaughtExceptionHandler b = Thread.getDefaultUncaughtExceptionHandler();

   public ExceptionHandler() {
      Thread.setDefaultUncaughtExceptionHandler(this);
   }

   public static void a() {
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
      // 00: getstatic com/mixpanel/android/mpmetrics/ExceptionHandler.a Lcom/mixpanel/android/mpmetrics/ExceptionHandler;
      // 03: ifnonnull 1e
      // 06: ldc com/mixpanel/android/mpmetrics/ExceptionHandler
      // 08: monitorenter
      // 09: getstatic com/mixpanel/android/mpmetrics/ExceptionHandler.a Lcom/mixpanel/android/mpmetrics/ExceptionHandler;
      // 0c: ifnonnull 1b
      // 0f: new com/mixpanel/android/mpmetrics/ExceptionHandler
      // 12: astore 0
      // 13: aload 0
      // 14: invokespecial com/mixpanel/android/mpmetrics/ExceptionHandler.<init> ()V
      // 17: aload 0
      // 18: putstatic com/mixpanel/android/mpmetrics/ExceptionHandler.a Lcom/mixpanel/android/mpmetrics/ExceptionHandler;
      // 1b: ldc com/mixpanel/android/mpmetrics/ExceptionHandler
      // 1d: monitorexit
      // 1e: return
      // 1f: astore 0
      // 20: ldc com/mixpanel/android/mpmetrics/ExceptionHandler
      // 22: monitorexit
      // 23: aload 0
      // 24: athrow
      // try (4 -> 12): 15 null
      // try (12 -> 14): 15 null
      // try (16 -> 18): 15 null
   }

   private void b() {
      try {
         Thread.sleep(400L);
      } catch (InterruptedException var2) {
         var2.printStackTrace();
      }

      Process.killProcess(Process.myPid());
      System.exit(10);
   }

   @Override
   public void uncaughtException(Thread var1, Throwable var2) {
      MixpanelAPI.a(new MixpanelAPI.InstanceProcessor(this, var2) {
         final Throwable a;
         final ExceptionHandler b;

         {
            this.b = var1;
            this.a = var2x;
         }

         @Override
         public void a(MixpanelAPI var1) {
            try {
               JSONObject var2x = new JSONObject();
               var2x.put("$ae_crashed_reason", this.a.toString());
               var1.a("$ae_crashed", var2x, true);
            } catch (JSONException var3) {
            }
         }
      });
      MixpanelAPI.a(new MixpanelAPI.InstanceProcessor(this) {
         final ExceptionHandler a;

         {
            this.a = var1;
         }

         @Override
         public void a(MixpanelAPI var1) {
            var1.m();
         }
      });
      if (this.b != null) {
         this.b.uncaughtException(var1, var2);
      } else {
         this.b();
      }
   }
}
