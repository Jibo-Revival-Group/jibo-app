package com.google.android.gms.internal;

import android.net.ConnectivityManager;
import java.io.IOException;
import java.net.HttpURLConnection;

public final class zzchq extends zzcjl {
   public zzchq(zzcim var1) {
      super(var1);
   }

   private static byte[] a(HttpURLConnection param0) throws IOException {
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
      // 00: aconst_null
      // 01: astore 3
      // 02: aload 3
      // 03: astore 2
      // 04: new java/io/ByteArrayOutputStream
      // 07: astore 4
      // 09: aload 3
      // 0a: astore 2
      // 0b: aload 4
      // 0d: invokespecial java/io/ByteArrayOutputStream.<init> ()V
      // 10: aload 3
      // 11: astore 2
      // 12: aload 0
      // 13: invokevirtual java/net/HttpURLConnection.getInputStream ()Ljava/io/InputStream;
      // 16: astore 0
      // 17: aload 0
      // 18: astore 2
      // 19: sipush 1024
      // 1c: newarray 8
      // 1e: astore 3
      // 1f: aload 0
      // 20: astore 2
      // 21: aload 0
      // 22: aload 3
      // 23: invokevirtual java/io/InputStream.read ([B)I
      // 26: istore 1
      // 27: iload 1
      // 28: ifle 43
      // 2b: aload 0
      // 2c: astore 2
      // 2d: aload 4
      // 2f: aload 3
      // 30: bipush 0
      // 31: iload 1
      // 32: invokevirtual java/io/ByteArrayOutputStream.write ([BII)V
      // 35: goto 1f
      // 38: astore 0
      // 39: aload 2
      // 3a: ifnull 41
      // 3d: aload 2
      // 3e: invokevirtual java/io/InputStream.close ()V
      // 41: aload 0
      // 42: athrow
      // 43: aload 0
      // 44: astore 2
      // 45: aload 4
      // 47: invokevirtual java/io/ByteArrayOutputStream.toByteArray ()[B
      // 4a: astore 3
      // 4b: aload 0
      // 4c: ifnull 53
      // 4f: aload 0
      // 50: invokevirtual java/io/InputStream.close ()V
      // 53: aload 3
      // 54: areturn
      // try (4 -> 6): 36 null
      // try (8 -> 10): 36 null
      // try (12 -> 15): 36 null
      // try (17 -> 20): 36 null
      // try (22 -> 26): 36 null
      // try (30 -> 35): 36 null
      // try (45 -> 48): 36 null
   }

   @Override
   protected final boolean w() {
      return false;
   }

   public final boolean y() {
      this.Q();
      ConnectivityManager var2 = (ConnectivityManager)this.l().getSystemService("connectivity");

      try {
         var4 = var2.getActiveNetworkInfo();
      } catch (SecurityException var3) {
         var4 = null;
      }

      boolean var1;
      if (var4 != null && var4.isConnected()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }
}
