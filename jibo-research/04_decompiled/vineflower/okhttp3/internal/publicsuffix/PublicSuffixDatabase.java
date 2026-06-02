package okhttp3.internal.publicsuffix;

import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.Util;

public final class PublicSuffixDatabase {
   private static final byte[] a = new byte[]{42};
   private static final String[] b = new String[0];
   private static final String[] c = new String[]{"*"};
   private static final PublicSuffixDatabase d = new PublicSuffixDatabase();
   private final AtomicBoolean e = new AtomicBoolean(false);
   private final CountDownLatch f = new CountDownLatch(1);
   private byte[] g;
   private byte[] h;

   private static String a(byte[] var0, byte[][] var1, int var2) {
      int var4 = 0;
      int var3 = var0.length;

      while (true) {
         if (var4 >= var3) {
            var15 = null;
            break;
         }

         int var5 = (var4 + var3) / 2;

         while (var5 > -1 && var0[var5] != 10) {
            var5--;
         }

         int var12 = var5 + 1;
         int var9 = 1;

         while (var0[var12 + var9] != 10) {
            var9++;
         }

         int var13 = var12 + var9 - var12;
         int var6 = 0;
         var5 = 0;
         int var7 = 0;
         int var10 = var2;

         int var14;
         while (true) {
            int var8;
            if (var7) {
               var8 = 46;
               var7 = 0;
            } else {
               var8 = var1[var10][var6] & 255;
            }

            var14 = var8 - (var0[var12 + var5] & 255);
            if (var14 != 0) {
               break;
            }

            var5++;
            var6++;
            if (var5 == var13) {
               break;
            }

            var8 = var6;
            int var11 = var10;
            if (var1[var10].length == var6) {
               if (var10 == var1.length - 1) {
                  break;
               }

               var11 = var10 + 1;
               var8 = -1;
               var7 = 1;
            }

            var6 = var8;
            var10 = var11;
         }

         if (var14 < 0) {
            var3 = var12 - 1;
         } else if (var14 > 0) {
            var4 = var9 + var12 + 1;
         } else {
            var7 = var13 - var5;
            var5 = var1[var10].length - var6;

            for (int var18 = var10 + 1; var18 < var1.length; var18++) {
               var5 += var1[var18].length;
            }

            if (var5 < var7) {
               var3 = var12 - 1;
            } else {
               if (var5 <= var7) {
                  var15 = new String(var0, var12, var13, Util.e);
                  break;
               }

               var4 = var9 + var12 + 1;
            }
         }
      }

      return var15;
   }

   public static PublicSuffixDatabase a() {
      return d;
   }

   private String[] a(String[] param1) {
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
      // 000: aconst_null
      // 001: astore 6
      // 003: bipush 0
      // 004: istore 3
      // 005: aload 0
      // 006: getfield okhttp3/internal/publicsuffix/PublicSuffixDatabase.e Ljava/util/concurrent/atomic/AtomicBoolean;
      // 009: invokevirtual java/util/concurrent/atomic/AtomicBoolean.get ()Z
      // 00c: ifne 039
      // 00f: aload 0
      // 010: getfield okhttp3/internal/publicsuffix/PublicSuffixDatabase.e Ljava/util/concurrent/atomic/AtomicBoolean;
      // 013: bipush 0
      // 014: bipush 1
      // 015: invokevirtual java/util/concurrent/atomic/AtomicBoolean.compareAndSet (ZZ)Z
      // 018: ifeq 039
      // 01b: aload 0
      // 01c: invokespecial okhttp3/internal/publicsuffix/PublicSuffixDatabase.b ()V
      // 01f: aload 0
      // 020: monitorenter
      // 021: aload 0
      // 022: getfield okhttp3/internal/publicsuffix/PublicSuffixDatabase.g [B
      // 025: ifnonnull 048
      // 028: new java/lang/IllegalStateException
      // 02b: astore 1
      // 02c: aload 1
      // 02d: ldc "Unable to load publicsuffixes.gz resource from the classpath."
      // 02f: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 032: aload 1
      // 033: athrow
      // 034: astore 1
      // 035: aload 0
      // 036: monitorexit
      // 037: aload 1
      // 038: athrow
      // 039: aload 0
      // 03a: getfield okhttp3/internal/publicsuffix/PublicSuffixDatabase.f Ljava/util/concurrent/CountDownLatch;
      // 03d: invokevirtual java/util/concurrent/CountDownLatch.await ()V
      // 040: goto 01f
      // 043: astore 4
      // 045: goto 01f
      // 048: aload 0
      // 049: monitorexit
      // 04a: aload 1
      // 04b: arraylength
      // 04c: anewarray 86
      // 04f: astore 7
      // 051: bipush 0
      // 052: istore 2
      // 053: iload 2
      // 054: aload 1
      // 055: arraylength
      // 056: if_icmpge 06c
      // 059: aload 7
      // 05b: iload 2
      // 05c: aload 1
      // 05d: iload 2
      // 05e: aaload
      // 05f: getstatic okhttp3/internal/Util.e Ljava/nio/charset/Charset;
      // 062: invokevirtual java/lang/String.getBytes (Ljava/nio/charset/Charset;)[B
      // 065: aastore
      // 066: iinc 2 1
      // 069: goto 053
      // 06c: bipush 0
      // 06d: istore 2
      // 06e: iload 2
      // 06f: aload 7
      // 071: arraylength
      // 072: if_icmpge 166
      // 075: aload 0
      // 076: getfield okhttp3/internal/publicsuffix/PublicSuffixDatabase.g [B
      // 079: aload 7
      // 07b: iload 2
      // 07c: invokestatic okhttp3/internal/publicsuffix/PublicSuffixDatabase.a ([B[[BI)Ljava/lang/String;
      // 07f: astore 1
      // 080: aload 1
      // 081: ifnull 102
      // 084: aload 7
      // 086: arraylength
      // 087: bipush 1
      // 088: if_icmple 160
      // 08b: aload 7
      // 08d: invokevirtual [[B.clone ()Ljava/lang/Object;
      // 090: checkcast [[B
      // 093: astore 4
      // 095: bipush 0
      // 096: istore 2
      // 097: iload 2
      // 098: aload 4
      // 09a: arraylength
      // 09b: bipush 1
      // 09c: isub
      // 09d: if_icmpge 160
      // 0a0: aload 4
      // 0a2: iload 2
      // 0a3: getstatic okhttp3/internal/publicsuffix/PublicSuffixDatabase.a [B
      // 0a6: aastore
      // 0a7: aload 0
      // 0a8: getfield okhttp3/internal/publicsuffix/PublicSuffixDatabase.g [B
      // 0ab: aload 4
      // 0ad: iload 2
      // 0ae: invokestatic okhttp3/internal/publicsuffix/PublicSuffixDatabase.a ([B[[BI)Ljava/lang/String;
      // 0b1: astore 5
      // 0b3: aload 5
      // 0b5: ifnull 108
      // 0b8: aload 6
      // 0ba: astore 4
      // 0bc: aload 5
      // 0be: ifnull 0e1
      // 0c1: iload 3
      // 0c2: istore 2
      // 0c3: aload 6
      // 0c5: astore 4
      // 0c7: iload 2
      // 0c8: aload 7
      // 0ca: arraylength
      // 0cb: bipush 1
      // 0cc: isub
      // 0cd: if_icmpge 0e1
      // 0d0: aload 0
      // 0d1: getfield okhttp3/internal/publicsuffix/PublicSuffixDatabase.h [B
      // 0d4: aload 7
      // 0d6: iload 2
      // 0d7: invokestatic okhttp3/internal/publicsuffix/PublicSuffixDatabase.a ([B[[BI)Ljava/lang/String;
      // 0da: astore 4
      // 0dc: aload 4
      // 0de: ifnull 10e
      // 0e1: aload 4
      // 0e3: ifnull 114
      // 0e6: new java/lang/StringBuilder
      // 0e9: dup
      // 0ea: invokespecial java/lang/StringBuilder.<init> ()V
      // 0ed: ldc "!"
      // 0ef: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0f2: aload 4
      // 0f4: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0f7: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0fa: ldc "\\."
      // 0fc: invokevirtual java/lang/String.split (Ljava/lang/String;)[Ljava/lang/String;
      // 0ff: astore 1
      // 100: aload 1
      // 101: areturn
      // 102: iinc 2 1
      // 105: goto 06e
      // 108: iinc 2 1
      // 10b: goto 097
      // 10e: iinc 2 1
      // 111: goto 0c3
      // 114: aload 1
      // 115: ifnonnull 124
      // 118: aload 5
      // 11a: ifnonnull 124
      // 11d: getstatic okhttp3/internal/publicsuffix/PublicSuffixDatabase.c [Ljava/lang/String;
      // 120: astore 1
      // 121: goto 100
      // 124: aload 1
      // 125: ifnull 150
      // 128: aload 1
      // 129: ldc "\\."
      // 12b: invokevirtual java/lang/String.split (Ljava/lang/String;)[Ljava/lang/String;
      // 12e: astore 4
      // 130: aload 5
      // 132: ifnull 158
      // 135: aload 5
      // 137: ldc "\\."
      // 139: invokevirtual java/lang/String.split (Ljava/lang/String;)[Ljava/lang/String;
      // 13c: astore 5
      // 13e: aload 5
      // 140: astore 1
      // 141: aload 4
      // 143: arraylength
      // 144: aload 5
      // 146: arraylength
      // 147: if_icmple 100
      // 14a: aload 4
      // 14c: astore 1
      // 14d: goto 100
      // 150: getstatic okhttp3/internal/publicsuffix/PublicSuffixDatabase.b [Ljava/lang/String;
      // 153: astore 4
      // 155: goto 130
      // 158: getstatic okhttp3/internal/publicsuffix/PublicSuffixDatabase.b [Ljava/lang/String;
      // 15b: astore 5
      // 15d: goto 13e
      // 160: aconst_null
      // 161: astore 5
      // 163: goto 0b8
      // 166: aconst_null
      // 167: astore 1
      // 168: goto 084
      // try (18 -> 28): 28 null
      // try (29 -> 31): 28 null
      // try (33 -> 36): 37 java/lang/InterruptedException
      // try (39 -> 41): 28 null
   }

   private void b() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: aconst_null
      // 01: astore 2
      // 02: ldc okhttp3/internal/publicsuffix/PublicSuffixDatabase
      // 04: invokevirtual java/lang/Class.getClassLoader ()Ljava/lang/ClassLoader;
      // 07: ldc "publicsuffixes.gz"
      // 09: invokevirtual java/lang/ClassLoader.getResourceAsStream (Ljava/lang/String;)Ljava/io/InputStream;
      // 0c: astore 1
      // 0d: aload 1
      // 0e: ifnull 84
      // 11: new okio/GzipSource
      // 14: dup
      // 15: aload 1
      // 16: invokestatic okio/Okio.a (Ljava/io/InputStream;)Lokio/Source;
      // 19: invokespecial okio/GzipSource.<init> (Lokio/Source;)V
      // 1c: invokestatic okio/Okio.a (Lokio/Source;)Lokio/BufferedSource;
      // 1f: astore 4
      // 21: aload 4
      // 23: invokeinterface okio/BufferedSource.k ()I 1
      // 28: newarray 8
      // 2a: astore 3
      // 2b: aload 4
      // 2d: aload 3
      // 2e: invokeinterface okio/BufferedSource.a ([B)V 2
      // 33: aload 4
      // 35: invokeinterface okio/BufferedSource.k ()I 1
      // 3a: newarray 8
      // 3c: astore 1
      // 3d: aload 4
      // 3f: aload 1
      // 40: invokeinterface okio/BufferedSource.a ([B)V 2
      // 45: aload 4
      // 47: invokestatic okhttp3/internal/Util.a (Ljava/io/Closeable;)V
      // 4a: aload 3
      // 4b: astore 2
      // 4c: aload 0
      // 4d: monitorenter
      // 4e: aload 0
      // 4f: aload 2
      // 50: putfield okhttp3/internal/publicsuffix/PublicSuffixDatabase.g [B
      // 53: aload 0
      // 54: aload 1
      // 55: putfield okhttp3/internal/publicsuffix/PublicSuffixDatabase.h [B
      // 58: aload 0
      // 59: monitorexit
      // 5a: aload 0
      // 5b: getfield okhttp3/internal/publicsuffix/PublicSuffixDatabase.f Ljava/util/concurrent/CountDownLatch;
      // 5e: invokevirtual java/util/concurrent/CountDownLatch.countDown ()V
      // 61: return
      // 62: astore 1
      // 63: invokestatic okhttp3/internal/platform/Platform.b ()Lokhttp3/internal/platform/Platform;
      // 66: bipush 5
      // 67: ldc "Failed to read public suffix list"
      // 69: aload 1
      // 6a: invokevirtual okhttp3/internal/platform/Platform.a (ILjava/lang/String;Ljava/lang/Throwable;)V
      // 6d: aload 4
      // 6f: invokestatic okhttp3/internal/Util.a (Ljava/io/Closeable;)V
      // 72: aconst_null
      // 73: astore 1
      // 74: goto 4c
      // 77: astore 1
      // 78: aload 4
      // 7a: invokestatic okhttp3/internal/Util.a (Ljava/io/Closeable;)V
      // 7d: aload 1
      // 7e: athrow
      // 7f: astore 1
      // 80: aload 0
      // 81: monitorexit
      // 82: aload 1
      // 83: athrow
      // 84: aconst_null
      // 85: astore 1
      // 86: goto 4c
      // try (16 -> 30): 48 java/io/IOException
      // try (16 -> 30): 59 null
      // try (36 -> 44): 64 null
      // try (49 -> 54): 59 null
      // try (65 -> 67): 64 null
   }

   public String a(String var1) {
      if (var1 == null) {
         throw new NullPointerException("domain == null");
      }

      String[] var4 = IDN.toUnicode(var1).split("\\.");
      String[] var3 = this.a(var4);
      if (var4.length == var3.length && var3[0].charAt(0) != '!') {
         var1 = null;
      } else {
         int var2;
         if (var3[0].charAt(0) == '!') {
            var2 = var4.length - var3.length;
         } else {
            var2 = var4.length - (var3.length + 1);
         }

         StringBuilder var7 = new StringBuilder();

         for (String[] var5 = var1.split("\\."); var2 < var5.length; var2++) {
            var7.append(var5[var2]).append('.');
         }

         var7.deleteCharAt(var7.length() - 1);
         var1 = var7.toString();
      }

      return var1;
   }
}
