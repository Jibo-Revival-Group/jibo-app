package okhttp3.internal.http;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import okhttp3.internal.Util;

public final class HttpDate {
   private static final ThreadLocal<DateFormat> a = new ThreadLocal<DateFormat>() {
      protected DateFormat a() {
         SimpleDateFormat var1 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
         var1.setLenient(false);
         var1.setTimeZone(Util.f);
         return var1;
      }
   };
   private static final String[] b = new String[]{
      "EEE, dd MMM yyyy HH:mm:ss zzz",
      "EEEE, dd-MMM-yy HH:mm:ss zzz",
      "EEE MMM d HH:mm:ss yyyy",
      "EEE, dd-MMM-yyyy HH:mm:ss z",
      "EEE, dd-MMM-yyyy HH-mm-ss z",
      "EEE, dd MMM yy HH:mm:ss z",
      "EEE dd-MMM-yyyy HH:mm:ss z",
      "EEE dd MMM yyyy HH:mm:ss z",
      "EEE dd-MMM-yyyy HH-mm-ss z",
      "EEE dd-MMM-yy HH:mm:ss z",
      "EEE dd MMM yy HH:mm:ss z",
      "EEE,dd-MMM-yy HH:mm:ss z",
      "EEE,dd-MMM-yyyy HH:mm:ss z",
      "EEE, dd-MM-yyyy HH:mm:ss z",
      "EEE MMM d yyyy HH:mm:ss z"
   };
   private static final DateFormat[] c = new DateFormat[b.length];

   public static String a(Date var0) {
      return a.get().format(var0);
   }

   public static Date a(String param0) {
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
      // 00: bipush 0
      // 01: istore 1
      // 02: aload 0
      // 03: invokevirtual java/lang/String.length ()I
      // 06: ifne 0d
      // 09: aconst_null
      // 0a: astore 3
      // 0b: aload 3
      // 0c: areturn
      // 0d: new java/text/ParsePosition
      // 10: dup
      // 11: bipush 0
      // 12: invokespecial java/text/ParsePosition.<init> (I)V
      // 15: astore 5
      // 17: getstatic okhttp3/internal/http/HttpDate.a Ljava/lang/ThreadLocal;
      // 1a: invokevirtual java/lang/ThreadLocal.get ()Ljava/lang/Object;
      // 1d: checkcast java/text/DateFormat
      // 20: aload 0
      // 21: aload 5
      // 23: invokevirtual java/text/DateFormat.parse (Ljava/lang/String;Ljava/text/ParsePosition;)Ljava/util/Date;
      // 26: astore 3
      // 27: aload 5
      // 29: invokevirtual java/text/ParsePosition.getIndex ()I
      // 2c: aload 0
      // 2d: invokevirtual java/lang/String.length ()I
      // 30: if_icmpeq 0b
      // 33: getstatic okhttp3/internal/http/HttpDate.b [Ljava/lang/String;
      // 36: astore 6
      // 38: aload 6
      // 3a: monitorenter
      // 3b: getstatic okhttp3/internal/http/HttpDate.b [Ljava/lang/String;
      // 3e: arraylength
      // 3f: istore 2
      // 40: iload 1
      // 41: iload 2
      // 42: if_icmpge 99
      // 45: getstatic okhttp3/internal/http/HttpDate.c [Ljava/text/DateFormat;
      // 48: iload 1
      // 49: aaload
      // 4a: astore 4
      // 4c: aload 4
      // 4e: astore 3
      // 4f: aload 4
      // 51: ifnonnull 71
      // 54: new java/text/SimpleDateFormat
      // 57: astore 3
      // 58: aload 3
      // 59: getstatic okhttp3/internal/http/HttpDate.b [Ljava/lang/String;
      // 5c: iload 1
      // 5d: aaload
      // 5e: getstatic java/util/Locale.US Ljava/util/Locale;
      // 61: invokespecial java/text/SimpleDateFormat.<init> (Ljava/lang/String;Ljava/util/Locale;)V
      // 64: aload 3
      // 65: getstatic okhttp3/internal/Util.f Ljava/util/TimeZone;
      // 68: invokevirtual java/text/DateFormat.setTimeZone (Ljava/util/TimeZone;)V
      // 6b: getstatic okhttp3/internal/http/HttpDate.c [Ljava/text/DateFormat;
      // 6e: iload 1
      // 6f: aload 3
      // 70: aastore
      // 71: aload 5
      // 73: bipush 0
      // 74: invokevirtual java/text/ParsePosition.setIndex (I)V
      // 77: aload 3
      // 78: aload 0
      // 79: aload 5
      // 7b: invokevirtual java/text/DateFormat.parse (Ljava/lang/String;Ljava/text/ParsePosition;)Ljava/util/Date;
      // 7e: astore 3
      // 7f: aload 5
      // 81: invokevirtual java/text/ParsePosition.getIndex ()I
      // 84: ifeq 93
      // 87: aload 6
      // 89: monitorexit
      // 8a: goto 0b
      // 8d: astore 0
      // 8e: aload 6
      // 90: monitorexit
      // 91: aload 0
      // 92: athrow
      // 93: iinc 1 1
      // 96: goto 40
      // 99: aload 6
      // 9b: monitorexit
      // 9c: aconst_null
      // 9d: astore 3
      // 9e: goto 0b
      // try (30 -> 33): 73 null
      // try (36 -> 40): 73 null
      // try (44 -> 59): 73 null
      // try (59 -> 72): 73 null
      // try (74 -> 76): 73 null
      // try (80 -> 82): 73 null
   }
}
