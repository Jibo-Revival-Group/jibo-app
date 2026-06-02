package com.amazonaws.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class DateUtils {
   private static final TimeZone GMT_TIMEZONE = TimeZone.getTimeZone("GMT");
   private static final Map<String, ThreadLocal<SimpleDateFormat>> sdfMap = new HashMap<>();

   public static String format(String var0, Date var1) {
      return getSimpleDateFormat(var0).get().format(var1);
   }

   public static String formatRFC822Date(Date var0) {
      return format("EEE, dd MMM yyyy HH:mm:ss z", var0);
   }

   private static ThreadLocal<SimpleDateFormat> getSimpleDateFormat(String param0) {
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
      // 00: getstatic com/amazonaws/util/DateUtils.sdfMap Ljava/util/Map;
      // 03: aload 0
      // 04: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 09: checkcast java/lang/ThreadLocal
      // 0c: astore 2
      // 0d: aload 2
      // 0e: astore 1
      // 0f: aload 2
      // 10: ifnonnull 42
      // 13: getstatic com/amazonaws/util/DateUtils.sdfMap Ljava/util/Map;
      // 16: astore 3
      // 17: aload 3
      // 18: monitorenter
      // 19: getstatic com/amazonaws/util/DateUtils.sdfMap Ljava/util/Map;
      // 1c: aload 0
      // 1d: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 22: checkcast java/lang/ThreadLocal
      // 25: astore 2
      // 26: aload 2
      // 27: astore 1
      // 28: aload 2
      // 29: ifnonnull 40
      // 2c: new com/amazonaws/util/DateUtils$1
      // 2f: astore 1
      // 30: aload 1
      // 31: aload 0
      // 32: invokespecial com/amazonaws/util/DateUtils$1.<init> (Ljava/lang/String;)V
      // 35: getstatic com/amazonaws/util/DateUtils.sdfMap Ljava/util/Map;
      // 38: aload 0
      // 39: aload 1
      // 3a: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 3f: pop
      // 40: aload 3
      // 41: monitorexit
      // 42: aload 1
      // 43: areturn
      // 44: astore 0
      // 45: aload 3
      // 46: monitorexit
      // 47: aload 0
      // 48: athrow
      // try (13 -> 18): 36 null
      // try (22 -> 32): 36 null
      // try (32 -> 34): 36 null
      // try (37 -> 39): 36 null
   }

   public static Date parse(String var0, String var1) {
      try {
         return getSimpleDateFormat(var0).get().parse(var1);
      } catch (ParseException var2) {
         throw new IllegalArgumentException(var2);
      }
   }

   public static Date parseCompressedISO8601Date(String var0) {
      return parse("yyyyMMdd'T'HHmmss'Z'", var0);
   }

   public static Date parseRFC822Date(String var0) {
      return parse("EEE, dd MMM yyyy HH:mm:ss z", var0);
   }
}
