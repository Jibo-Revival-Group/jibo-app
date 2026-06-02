package com.bumptech.glide.disklrucache;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

class StrictLineReader implements Closeable {
   private final InputStream a;
   private final Charset b;
   private byte[] c;
   private int d;
   private int e;

   public StrictLineReader(InputStream var1, int var2, Charset var3) {
      if (var1 == null || var3 == null) {
         throw new NullPointerException();
      }

      if (var2 < 0) {
         throw new IllegalArgumentException("capacity <= 0");
      }

      if (!var3.equals(Util.a)) {
         throw new IllegalArgumentException("Unsupported encoding");
      }

      this.a = var1;
      this.b = var3;
      this.c = new byte[var2];
   }

   public StrictLineReader(InputStream var1, Charset var2) {
      this(var1, 8192, var2);
   }

   private void c() throws IOException {
      int var1 = this.a.read(this.c, 0, this.c.length);
      if (var1 == -1) {
         throw new EOFException();
      }

      this.d = 0;
      this.e = var1;
   }

   public String a() throws IOException {
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
      // 000: aload 0
      // 001: getfield com/bumptech/glide/disklrucache/StrictLineReader.a Ljava/io/InputStream;
      // 004: astore 4
      // 006: aload 4
      // 008: monitorenter
      // 009: aload 0
      // 00a: getfield com/bumptech/glide/disklrucache/StrictLineReader.c [B
      // 00d: ifnonnull 022
      // 010: new java/io/IOException
      // 013: astore 3
      // 014: aload 3
      // 015: ldc "LineReader is closed"
      // 017: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 01a: aload 3
      // 01b: athrow
      // 01c: astore 3
      // 01d: aload 4
      // 01f: monitorexit
      // 020: aload 3
      // 021: athrow
      // 022: aload 0
      // 023: getfield com/bumptech/glide/disklrucache/StrictLineReader.d I
      // 026: aload 0
      // 027: getfield com/bumptech/glide/disklrucache/StrictLineReader.e I
      // 02a: if_icmplt 031
      // 02d: aload 0
      // 02e: invokespecial com/bumptech/glide/disklrucache/StrictLineReader.c ()V
      // 031: aload 0
      // 032: getfield com/bumptech/glide/disklrucache/StrictLineReader.d I
      // 035: istore 1
      // 036: iload 1
      // 037: aload 0
      // 038: getfield com/bumptech/glide/disklrucache/StrictLineReader.e I
      // 03b: if_icmpeq 096
      // 03e: aload 0
      // 03f: getfield com/bumptech/glide/disklrucache/StrictLineReader.c [B
      // 042: iload 1
      // 043: baload
      // 044: bipush 10
      // 046: if_icmpne 090
      // 049: iload 1
      // 04a: aload 0
      // 04b: getfield com/bumptech/glide/disklrucache/StrictLineReader.d I
      // 04e: if_icmpeq 08b
      // 051: aload 0
      // 052: getfield com/bumptech/glide/disklrucache/StrictLineReader.c [B
      // 055: iload 1
      // 056: bipush 1
      // 057: isub
      // 058: baload
      // 059: bipush 13
      // 05b: if_icmpne 08b
      // 05e: iload 1
      // 05f: bipush 1
      // 060: isub
      // 061: istore 2
      // 062: new java/lang/String
      // 065: astore 3
      // 066: aload 3
      // 067: aload 0
      // 068: getfield com/bumptech/glide/disklrucache/StrictLineReader.c [B
      // 06b: aload 0
      // 06c: getfield com/bumptech/glide/disklrucache/StrictLineReader.d I
      // 06f: iload 2
      // 070: aload 0
      // 071: getfield com/bumptech/glide/disklrucache/StrictLineReader.d I
      // 074: isub
      // 075: aload 0
      // 076: getfield com/bumptech/glide/disklrucache/StrictLineReader.b Ljava/nio/charset/Charset;
      // 079: invokevirtual java/nio/charset/Charset.name ()Ljava/lang/String;
      // 07c: invokespecial java/lang/String.<init> ([BIILjava/lang/String;)V
      // 07f: aload 0
      // 080: iload 1
      // 081: bipush 1
      // 082: iadd
      // 083: putfield com/bumptech/glide/disklrucache/StrictLineReader.d I
      // 086: aload 4
      // 088: monitorexit
      // 089: aload 3
      // 08a: areturn
      // 08b: iload 1
      // 08c: istore 2
      // 08d: goto 062
      // 090: iinc 1 1
      // 093: goto 036
      // 096: new com/bumptech/glide/disklrucache/StrictLineReader$1
      // 099: astore 3
      // 09a: aload 3
      // 09b: aload 0
      // 09c: aload 0
      // 09d: getfield com/bumptech/glide/disklrucache/StrictLineReader.e I
      // 0a0: aload 0
      // 0a1: getfield com/bumptech/glide/disklrucache/StrictLineReader.d I
      // 0a4: isub
      // 0a5: bipush 80
      // 0a7: iadd
      // 0a8: invokespecial com/bumptech/glide/disklrucache/StrictLineReader$1.<init> (Lcom/bumptech/glide/disklrucache/StrictLineReader;I)V
      // 0ab: aload 3
      // 0ac: aload 0
      // 0ad: getfield com/bumptech/glide/disklrucache/StrictLineReader.c [B
      // 0b0: aload 0
      // 0b1: getfield com/bumptech/glide/disklrucache/StrictLineReader.d I
      // 0b4: aload 0
      // 0b5: getfield com/bumptech/glide/disklrucache/StrictLineReader.e I
      // 0b8: aload 0
      // 0b9: getfield com/bumptech/glide/disklrucache/StrictLineReader.d I
      // 0bc: isub
      // 0bd: invokevirtual java/io/ByteArrayOutputStream.write ([BII)V
      // 0c0: aload 0
      // 0c1: bipush -1
      // 0c2: putfield com/bumptech/glide/disklrucache/StrictLineReader.e I
      // 0c5: aload 0
      // 0c6: invokespecial com/bumptech/glide/disklrucache/StrictLineReader.c ()V
      // 0c9: aload 0
      // 0ca: getfield com/bumptech/glide/disklrucache/StrictLineReader.d I
      // 0cd: istore 1
      // 0ce: iload 1
      // 0cf: aload 0
      // 0d0: getfield com/bumptech/glide/disklrucache/StrictLineReader.e I
      // 0d3: if_icmpeq 0ab
      // 0d6: aload 0
      // 0d7: getfield com/bumptech/glide/disklrucache/StrictLineReader.c [B
      // 0da: iload 1
      // 0db: baload
      // 0dc: bipush 10
      // 0de: if_icmpne 10d
      // 0e1: iload 1
      // 0e2: aload 0
      // 0e3: getfield com/bumptech/glide/disklrucache/StrictLineReader.d I
      // 0e6: if_icmpeq 0fb
      // 0e9: aload 3
      // 0ea: aload 0
      // 0eb: getfield com/bumptech/glide/disklrucache/StrictLineReader.c [B
      // 0ee: aload 0
      // 0ef: getfield com/bumptech/glide/disklrucache/StrictLineReader.d I
      // 0f2: iload 1
      // 0f3: aload 0
      // 0f4: getfield com/bumptech/glide/disklrucache/StrictLineReader.d I
      // 0f7: isub
      // 0f8: invokevirtual java/io/ByteArrayOutputStream.write ([BII)V
      // 0fb: aload 0
      // 0fc: iload 1
      // 0fd: bipush 1
      // 0fe: iadd
      // 0ff: putfield com/bumptech/glide/disklrucache/StrictLineReader.d I
      // 102: aload 3
      // 103: invokevirtual java/io/ByteArrayOutputStream.toString ()Ljava/lang/String;
      // 106: astore 3
      // 107: aload 4
      // 109: monitorexit
      // 10a: goto 089
      // 10d: iinc 1 1
      // 110: goto 0ce
      // try (5 -> 15): 15 null
      // try (16 -> 18): 15 null
      // try (20 -> 27): 15 null
      // try (27 -> 30): 15 null
      // try (30 -> 52): 15 null
      // try (56 -> 78): 15 null
      // try (85 -> 97): 15 null
      // try (97 -> 116): 15 null
      // try (116 -> 140): 15 null
      // try (140 -> 150): 15 null
   }

   public boolean b() {
      boolean var1;
      if (this.e == -1) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public void close() throws IOException {
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
      // 00: aload 0
      // 01: getfield com/bumptech/glide/disklrucache/StrictLineReader.a Ljava/io/InputStream;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/bumptech/glide/disklrucache/StrictLineReader.c [B
      // 0b: ifnull 1a
      // 0e: aload 0
      // 0f: aconst_null
      // 10: putfield com/bumptech/glide/disklrucache/StrictLineReader.c [B
      // 13: aload 0
      // 14: getfield com/bumptech/glide/disklrucache/StrictLineReader.a Ljava/io/InputStream;
      // 17: invokevirtual java/io/InputStream.close ()V
      // 1a: aload 2
      // 1b: monitorexit
      // 1c: return
      // 1d: astore 1
      // 1e: aload 2
      // 1f: monitorexit
      // 20: aload 1
      // 21: athrow
      // try (5 -> 14): 17 null
      // try (14 -> 16): 17 null
      // try (18 -> 20): 17 null
   }
}
