package com.facebook.internal;

import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import java.util.HashMap;

public class Logger {
   public static final String LOG_TAG_BASE = "FacebookSDK.";
   private static final HashMap<String, String> stringsToReplace = new HashMap<>();
   private final LoggingBehavior behavior;
   private StringBuilder contents;
   private int priority = 3;
   private final String tag;

   public Logger(LoggingBehavior var1, String var2) {
      Validate.notNullOrEmpty(var2, "tag");
      this.behavior = var1;
      this.tag = "FacebookSDK." + var2;
      this.contents = new StringBuilder();
   }

   public static void log(LoggingBehavior var0, int var1, String var2, String var3) {
      if (FacebookSdk.isLoggingBehaviorEnabled(var0)) {
         String var4 = replaceStrings(var3);
         var3 = var2;
         if (!var2.startsWith("FacebookSDK.")) {
            var3 = "FacebookSDK." + var2;
         }

         Log.println(var1, var3, var4);
         if (var0 == LoggingBehavior.DEVELOPER_ERRORS) {
            new Exception().printStackTrace();
         }
      }
   }

   public static void log(LoggingBehavior var0, int var1, String var2, String var3, Object... var4) {
      if (FacebookSdk.isLoggingBehaviorEnabled(var0)) {
         log(var0, var1, var2, String.format(var3, var4));
      }
   }

   public static void log(LoggingBehavior var0, String var1, String var2) {
      log(var0, 3, var1, var2);
   }

   public static void log(LoggingBehavior var0, String var1, String var2, Object... var3) {
      if (FacebookSdk.isLoggingBehaviorEnabled(var0)) {
         log(var0, 3, var1, String.format(var2, var3));
      }
   }

   public static void registerAccessToken(String var0) {
      synchronized (Logger.class) {
         if (!FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.INCLUDE_ACCESS_TOKENS)) {
            registerStringToReplace(var0, "ACCESS_TOKEN_REMOVED");
         }
      }
   }

   public static void registerStringToReplace(String var0, String var1) {
      synchronized (Logger.class) {
         stringsToReplace.put(var0, var1);
      }
   }

   private static String replaceStrings(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.insertSemaphore(FinallyProcessor.java:351)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:98)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: ldc com/facebook/internal/Logger
      // 02: monitorenter
      // 03: getstatic com/facebook/internal/Logger.stringsToReplace Ljava/util/HashMap;
      // 06: invokevirtual java/util/HashMap.entrySet ()Ljava/util/Set;
      // 09: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 0e: astore 1
      // 0f: aload 1
      // 10: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 15: ifeq 3c
      // 18: aload 1
      // 19: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 1e: checkcast java/util/Map$Entry
      // 21: astore 2
      // 22: aload 0
      // 23: aload 2
      // 24: invokeinterface java/util/Map$Entry.getKey ()Ljava/lang/Object; 1
      // 29: checkcast java/lang/CharSequence
      // 2c: aload 2
      // 2d: invokeinterface java/util/Map$Entry.getValue ()Ljava/lang/Object; 1
      // 32: checkcast java/lang/CharSequence
      // 35: invokevirtual java/lang/String.replace (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
      // 38: astore 0
      // 39: goto 0f
      // 3c: ldc com/facebook/internal/Logger
      // 3e: monitorexit
      // 3f: aload 0
      // 40: areturn
      // 41: astore 0
      // 42: ldc com/facebook/internal/Logger
      // 44: monitorexit
      // 45: aload 0
      // 46: athrow
      // try (2 -> 6): 27 null
      // try (6 -> 22): 27 null
   }

   private boolean shouldLog() {
      return FacebookSdk.isLoggingBehaviorEnabled(this.behavior);
   }

   public void append(String var1) {
      if (this.shouldLog()) {
         this.contents.append(var1);
      }
   }

   public void append(String var1, Object... var2) {
      if (this.shouldLog()) {
         this.contents.append(String.format(var1, var2));
      }
   }

   public void append(StringBuilder var1) {
      if (this.shouldLog()) {
         this.contents.append(var1);
      }
   }

   public void appendKeyValue(String var1, Object var2) {
      this.append("  %s:\t%s\n", var1, var2);
   }

   public String getContents() {
      return replaceStrings(this.contents.toString());
   }

   public int getPriority() {
      return this.priority;
   }

   public void log() {
      this.logString(this.contents.toString());
      this.contents = new StringBuilder();
   }

   public void logString(String var1) {
      log(this.behavior, this.priority, this.tag, var1);
   }

   public void setPriority(int var1) {
      Validate.oneOf(var1, "value", 7, 3, 6, 4, 2, 5);
      this.priority = var1;
   }
}
