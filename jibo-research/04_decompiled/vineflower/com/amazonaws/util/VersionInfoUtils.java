package com.amazonaws.util;

import com.jibo.aws.integration.util.a;

public class VersionInfoUtils {
   public static final String TAG = a.a(VersionInfoUtils.class);
   private static volatile String platform = "android";
   private static volatile String userAgent;
   private static volatile String version = "2.2.7";

   public static String getPlatform() {
      return platform;
   }

   public static String getUserAgent() {
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
      // 00: getstatic com/amazonaws/util/VersionInfoUtils.userAgent Ljava/lang/String;
      // 03: ifnonnull 15
      // 06: ldc com/amazonaws/util/VersionInfoUtils
      // 08: monitorenter
      // 09: getstatic com/amazonaws/util/VersionInfoUtils.userAgent Ljava/lang/String;
      // 0c: ifnonnull 12
      // 0f: invokestatic com/amazonaws/util/VersionInfoUtils.initializeUserAgent ()V
      // 12: ldc com/amazonaws/util/VersionInfoUtils
      // 14: monitorexit
      // 15: getstatic com/amazonaws/util/VersionInfoUtils.userAgent Ljava/lang/String;
      // 18: areturn
      // 19: astore 0
      // 1a: ldc com/amazonaws/util/VersionInfoUtils
      // 1c: monitorexit
      // 1d: aload 0
      // 1e: athrow
      // try (4 -> 7): 11 null
      // try (7 -> 9): 11 null
      // try (12 -> 14): 11 null
   }

   public static String getVersion() {
      return version;
   }

   private static void initializeUserAgent() {
      userAgent = userAgent();
   }

   private static String replaceSpaces(String var0) {
      return var0.replace(' ', '_');
   }

   static String userAgent() {
      StringBuilder var1 = new StringBuilder(128);
      var1.append("aws-sdk-");
      var1.append(getPlatform().toLowerCase());
      var1.append("/");
      var1.append(getVersion());
      var1.append(" ");
      var1.append(replaceSpaces(System.getProperty("os.name")));
      var1.append("/");
      var1.append(replaceSpaces(System.getProperty("os.version")));
      var1.append(" ");
      var1.append(replaceSpaces(System.getProperty("java.vm.name")));
      var1.append("/");
      var1.append(replaceSpaces(System.getProperty("java.vm.version")));
      var1.append("/");
      var1.append(replaceSpaces(System.getProperty("java.version")));
      String var0 = System.getProperty("user.language");
      String var2 = System.getProperty("user.region");
      if (var0 != null && var2 != null) {
         var1.append(" ");
         var1.append(replaceSpaces(var0));
         var1.append("_");
         var1.append(replaceSpaces(var2));
      }

      return var1.toString();
   }
}
