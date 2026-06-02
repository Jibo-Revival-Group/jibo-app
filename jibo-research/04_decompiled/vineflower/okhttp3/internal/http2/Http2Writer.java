package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Buffer;
import okio.BufferedSink;

final class Http2Writer implements Closeable {
   private static final Logger b = Logger.getLogger(Http2.class.getName());
   final Hpack.Writer a;
   private final BufferedSink c;
   private final boolean d;
   private final Buffer e;
   private int f;
   private boolean g;

   Http2Writer(BufferedSink var1, boolean var2) {
      this.c = var1;
      this.d = var2;
      this.e = new Buffer();
      this.a = new Hpack.Writer(this.e);
      this.f = 16384;
   }

   private static void a(BufferedSink var0, int var1) throws IOException {
      var0.k(var1 >>> 16 & 0xFF);
      var0.k(var1 >>> 8 & 0xFF);
      var0.k(var1 & 0xFF);
   }

   private void b(int var1, long var2) throws IOException {
      while (var2 > 0L) {
         int var5 = (int)Math.min(this.f, var2);
         var2 -= var5;
         byte var4;
         if (var2 == 0L) {
            var4 = 4;
         } else {
            var4 = 0;
         }

         this.a(var1, var5, (byte)9, var4);
         this.c.a_(this.e, var5);
      }
   }

   public void a() throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1065)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:566)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: getfield okhttp3/internal/http2/Http2Writer.g Z
      // 06: ifeq 1a
      // 09: new java/io/IOException
      // 0c: astore 2
      // 0d: aload 2
      // 0e: ldc "closed"
      // 10: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 13: aload 2
      // 14: athrow
      // 15: astore 2
      // 16: aload 0
      // 17: monitorexit
      // 18: aload 2
      // 19: athrow
      // 1a: aload 0
      // 1b: getfield okhttp3/internal/http2/Http2Writer.d Z
      // 1e: istore 1
      // 1f: iload 1
      // 20: ifne 26
      // 23: aload 0
      // 24: monitorexit
      // 25: return
      // 26: getstatic okhttp3/internal/http2/Http2Writer.b Ljava/util/logging/Logger;
      // 29: getstatic java/util/logging/Level.FINE Ljava/util/logging/Level;
      // 2c: invokevirtual java/util/logging/Logger.isLoggable (Ljava/util/logging/Level;)Z
      // 2f: ifeq 4a
      // 32: getstatic okhttp3/internal/http2/Http2Writer.b Ljava/util/logging/Logger;
      // 35: ldc ">> CONNECTION %s"
      // 37: bipush 1
      // 38: anewarray 4
      // 3b: dup
      // 3c: bipush 0
      // 3d: getstatic okhttp3/internal/http2/Http2.a Lokio/ByteString;
      // 40: invokevirtual okio/ByteString.f ()Ljava/lang/String;
      // 43: aastore
      // 44: invokestatic okhttp3/internal/Util.a (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      // 47: invokevirtual java/util/logging/Logger.fine (Ljava/lang/String;)V
      // 4a: aload 0
      // 4b: getfield okhttp3/internal/http2/Http2Writer.c Lokio/BufferedSink;
      // 4e: getstatic okhttp3/internal/http2/Http2.a Lokio/ByteString;
      // 51: invokevirtual okio/ByteString.i ()[B
      // 54: invokeinterface okio/BufferedSink.c ([B)Lokio/BufferedSink; 2
      // 59: pop
      // 5a: aload 0
      // 5b: getfield okhttp3/internal/http2/Http2Writer.c Lokio/BufferedSink;
      // 5e: invokeinterface okio/BufferedSink.flush ()V 1
      // 63: goto 23
      // try (2 -> 12): 12 null
      // try (17 -> 20): 12 null
      // try (25 -> 40): 12 null
      // try (40 -> 49): 12 null
   }

   void a(int var1, byte var2, Buffer var3, int var4) throws IOException {
      this.a(var1, var4, (byte)0, var2);
      if (var4 > 0) {
         this.c.a_(var3, var4);
      }
   }

   public void a(int var1, int var2, byte var3, byte var4) throws IOException {
      if (b.isLoggable(Level.FINE)) {
         b.fine(Http2.a(false, var1, var2, var3, var4));
      }

      if (var2 > this.f) {
         throw Http2.a("FRAME_SIZE_ERROR length > %d: %d", this.f, var2);
      }

      if ((-2147483648 & var1) != 0) {
         throw Http2.a("reserved bit set: %s", var1);
      }

      a(this.c, var2);
      this.c.k(var3 & 255);
      this.c.k(var4 & 255);
      this.c.i(2147483647 & var1);
   }

   public void a(int param1, int param2, List<Header> param3) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1065)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:566)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: getfield okhttp3/internal/http2/Http2Writer.g Z
      // 06: ifeq 1a
      // 09: new java/io/IOException
      // 0c: astore 3
      // 0d: aload 3
      // 0e: ldc "closed"
      // 10: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 13: aload 3
      // 14: athrow
      // 15: astore 3
      // 16: aload 0
      // 17: monitorexit
      // 18: aload 3
      // 19: athrow
      // 1a: aload 0
      // 1b: getfield okhttp3/internal/http2/Http2Writer.a Lokhttp3/internal/http2/Hpack$Writer;
      // 1e: aload 3
      // 1f: invokevirtual okhttp3/internal/http2/Hpack$Writer.a (Ljava/util/List;)V
      // 22: aload 0
      // 23: getfield okhttp3/internal/http2/Http2Writer.e Lokio/Buffer;
      // 26: invokevirtual okio/Buffer.b ()J
      // 29: lstore 6
      // 2b: aload 0
      // 2c: getfield okhttp3/internal/http2/Http2Writer.f I
      // 2f: bipush 4
      // 30: isub
      // 31: i2l
      // 32: lload 6
      // 34: invokestatic java/lang/Math.min (JJ)J
      // 37: l2i
      // 38: istore 5
      // 3a: lload 6
      // 3c: iload 5
      // 3e: i2l
      // 3f: lcmp
      // 40: ifne 87
      // 43: bipush 4
      // 44: istore 4
      // 46: aload 0
      // 47: iload 1
      // 48: iload 5
      // 4a: bipush 4
      // 4b: iadd
      // 4c: bipush 5
      // 4d: iload 4
      // 4f: invokevirtual okhttp3/internal/http2/Http2Writer.a (IIBB)V
      // 52: aload 0
      // 53: getfield okhttp3/internal/http2/Http2Writer.c Lokio/BufferedSink;
      // 56: ldc 2147483647
      // 58: iload 2
      // 59: iand
      // 5a: invokeinterface okio/BufferedSink.i (I)Lokio/BufferedSink; 2
      // 5f: pop
      // 60: aload 0
      // 61: getfield okhttp3/internal/http2/Http2Writer.c Lokio/BufferedSink;
      // 64: aload 0
      // 65: getfield okhttp3/internal/http2/Http2Writer.e Lokio/Buffer;
      // 68: iload 5
      // 6a: i2l
      // 6b: invokeinterface okio/BufferedSink.a_ (Lokio/Buffer;J)V 4
      // 70: lload 6
      // 72: iload 5
      // 74: i2l
      // 75: lcmp
      // 76: ifle 84
      // 79: aload 0
      // 7a: iload 1
      // 7b: lload 6
      // 7d: iload 5
      // 7f: i2l
      // 80: lsub
      // 81: invokespecial okhttp3/internal/http2/Http2Writer.b (IJ)V
      // 84: aload 0
      // 85: monitorexit
      // 86: return
      // 87: bipush 0
      // 88: istore 4
      // 8a: goto 46
      // try (2 -> 12): 12 null
      // try (17 -> 34): 12 null
      // try (41 -> 63): 12 null
      // try (68 -> 75): 12 null
   }

   public void a(int param1, long param2) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1065)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:566)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: getfield okhttp3/internal/http2/Http2Writer.g Z
      // 06: ifeq 1f
      // 09: new java/io/IOException
      // 0c: astore 4
      // 0e: aload 4
      // 10: ldc "closed"
      // 12: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 15: aload 4
      // 17: athrow
      // 18: astore 4
      // 1a: aload 0
      // 1b: monitorexit
      // 1c: aload 4
      // 1e: athrow
      // 1f: lload 2
      // 20: lconst_0
      // 21: lcmp
      // 22: ifeq 2d
      // 25: lload 2
      // 26: ldc2_w 2147483647
      // 29: lcmp
      // 2a: ifle 3e
      // 2d: ldc "windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s"
      // 2f: bipush 1
      // 30: anewarray 4
      // 33: dup
      // 34: bipush 0
      // 35: lload 2
      // 36: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 39: aastore
      // 3a: invokestatic okhttp3/internal/http2/Http2.a (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/IllegalArgumentException;
      // 3d: athrow
      // 3e: aload 0
      // 3f: iload 1
      // 40: bipush 4
      // 41: bipush 8
      // 43: bipush 0
      // 44: invokevirtual okhttp3/internal/http2/Http2Writer.a (IIBB)V
      // 47: aload 0
      // 48: getfield okhttp3/internal/http2/Http2Writer.c Lokio/BufferedSink;
      // 4b: lload 2
      // 4c: l2i
      // 4d: invokeinterface okio/BufferedSink.i (I)Lokio/BufferedSink; 2
      // 52: pop
      // 53: aload 0
      // 54: getfield okhttp3/internal/http2/Http2Writer.c Lokio/BufferedSink;
      // 57: invokeinterface okio/BufferedSink.flush ()V 1
      // 5c: aload 0
      // 5d: monitorexit
      // 5e: return
      // try (2 -> 12): 12 null
      // try (25 -> 35): 12 null
      // try (35 -> 50): 12 null
   }

   public void a(int var1, ErrorCode var2) throws IOException {
      synchronized (this) {
         if (this.g) {
            IOException var5 = new IOException("closed");
            throw var5;
         }

         if (var2.httpCode == -1) {
            IllegalArgumentException var4 = new IllegalArgumentException();
            throw var4;
         }

         this.a(var1, 4, (byte)3, (byte)0);
         this.c.i(var2.httpCode);
         this.c.flush();
      }
   }

   public void a(int var1, ErrorCode var2, byte[] var3) throws IOException {
      synchronized (this) {
         if (this.g) {
            IOException var5 = new IOException("closed");
            throw var5;
         }

         if (var2.httpCode == -1) {
            throw Http2.a("errorCode.httpCode == -1");
         }

         this.a(0, var3.length + 8, (byte)7, (byte)0);
         this.c.i(var1);
         this.c.i(var2.httpCode);
         if (var3.length > 0) {
            this.c.c(var3);
         }

         this.c.flush();
      }
   }

   public void a(Settings var1) throws IOException {
      synchronized (this) {
         if (this.g) {
            IOException var3 = new IOException("closed");
            throw var3;
         }

         this.f = var1.d(this.f);
         if (var1.c() != -1) {
            this.a.a(var1.c());
         }

         this.a(0, 0, (byte)4, (byte)1);
         this.c.flush();
      }
   }

   public void a(boolean param1, int param2, int param3) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1065)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:566)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 4
      // 03: aload 0
      // 04: monitorenter
      // 05: aload 0
      // 06: getfield okhttp3/internal/http2/Http2Writer.g Z
      // 09: ifeq 22
      // 0c: new java/io/IOException
      // 0f: astore 5
      // 11: aload 5
      // 13: ldc "closed"
      // 15: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 18: aload 5
      // 1a: athrow
      // 1b: astore 5
      // 1d: aload 0
      // 1e: monitorexit
      // 1f: aload 5
      // 21: athrow
      // 22: iload 1
      // 23: ifeq 29
      // 26: bipush 1
      // 27: istore 4
      // 29: aload 0
      // 2a: bipush 0
      // 2b: bipush 8
      // 2d: bipush 6
      // 2f: iload 4
      // 31: invokevirtual okhttp3/internal/http2/Http2Writer.a (IIBB)V
      // 34: aload 0
      // 35: getfield okhttp3/internal/http2/Http2Writer.c Lokio/BufferedSink;
      // 38: iload 2
      // 39: invokeinterface okio/BufferedSink.i (I)Lokio/BufferedSink; 2
      // 3e: pop
      // 3f: aload 0
      // 40: getfield okhttp3/internal/http2/Http2Writer.c Lokio/BufferedSink;
      // 43: iload 3
      // 44: invokeinterface okio/BufferedSink.i (I)Lokio/BufferedSink; 2
      // 49: pop
      // 4a: aload 0
      // 4b: getfield okhttp3/internal/http2/Http2Writer.c Lokio/BufferedSink;
      // 4e: invokeinterface okio/BufferedSink.flush ()V 1
      // 53: aload 0
      // 54: monitorexit
      // 55: return
      // try (4 -> 14): 14 null
      // try (23 -> 42): 14 null
   }

   public void a(boolean var1, int var2, int var3, List<Header> var4) throws IOException {
      synchronized (this) {
         if (this.g) {
            IOException var6 = new IOException("closed");
            throw var6;
         }

         this.a(var1, var2, var4);
      }
   }

   void a(boolean var1, int var2, List<Header> var3) throws IOException {
      if (this.g) {
         throw new IOException("closed");
      }

      this.a.a(var3);
      long var7 = this.e.b();
      int var6 = (int)Math.min(this.f, var7);
      byte var4;
      if (var7 == var6) {
         var4 = 4;
      } else {
         var4 = 0;
      }

      byte var5 = var4;
      if (var1) {
         var5 = (byte)(var4 | 1);
      }

      this.a(var2, var6, (byte)1, var5);
      this.c.a_(this.e, var6);
      if (var7 > var6) {
         this.b(var2, var7 - var6);
      }
   }

   public void a(boolean param1, int param2, Buffer param3, int param4) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1065)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:566)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: getfield okhttp3/internal/http2/Http2Writer.g Z
      // 06: ifeq 1a
      // 09: new java/io/IOException
      // 0c: astore 3
      // 0d: aload 3
      // 0e: ldc "closed"
      // 10: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 13: aload 3
      // 14: athrow
      // 15: astore 3
      // 16: aload 0
      // 17: monitorexit
      // 18: aload 3
      // 19: athrow
      // 1a: bipush 0
      // 1b: istore 5
      // 1d: iload 1
      // 1e: ifeq 25
      // 21: bipush 1
      // 22: i2b
      // 23: istore 5
      // 25: aload 0
      // 26: iload 2
      // 27: iload 5
      // 29: aload 3
      // 2a: iload 4
      // 2c: invokevirtual okhttp3/internal/http2/Http2Writer.a (IBLokio/Buffer;I)V
      // 2f: aload 0
      // 30: monitorexit
      // 31: return
      // try (2 -> 12): 12 null
      // try (24 -> 30): 12 null
   }

   public void b() throws IOException {
      synchronized (this) {
         if (this.g) {
            IOException var1 = new IOException("closed");
            throw var1;
         }

         this.c.flush();
      }
   }

   public void b(Settings param1) throws IOException {
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
      // 00: bipush 0
      // 01: istore 2
      // 02: aload 0
      // 03: monitorenter
      // 04: aload 0
      // 05: getfield okhttp3/internal/http2/Http2Writer.g Z
      // 08: ifeq 1c
      // 0b: new java/io/IOException
      // 0e: astore 1
      // 0f: aload 1
      // 10: ldc "closed"
      // 12: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 15: aload 1
      // 16: athrow
      // 17: astore 1
      // 18: aload 0
      // 19: monitorexit
      // 1a: aload 1
      // 1b: athrow
      // 1c: aload 0
      // 1d: bipush 0
      // 1e: aload 1
      // 1f: invokevirtual okhttp3/internal/http2/Settings.b ()I
      // 22: bipush 6
      // 24: imul
      // 25: bipush 4
      // 26: bipush 0
      // 27: invokevirtual okhttp3/internal/http2/Http2Writer.a (IIBB)V
      // 2a: iload 2
      // 2b: bipush 10
      // 2d: if_icmpge 6d
      // 30: aload 1
      // 31: iload 2
      // 32: invokevirtual okhttp3/internal/http2/Settings.a (I)Z
      // 35: ifne 3e
      // 38: iinc 2 1
      // 3b: goto 2a
      // 3e: iload 2
      // 3f: bipush 4
      // 40: if_icmpne 62
      // 43: bipush 3
      // 44: istore 3
      // 45: aload 0
      // 46: getfield okhttp3/internal/http2/Http2Writer.c Lokio/BufferedSink;
      // 49: iload 3
      // 4a: invokeinterface okio/BufferedSink.j (I)Lokio/BufferedSink; 2
      // 4f: pop
      // 50: aload 0
      // 51: getfield okhttp3/internal/http2/Http2Writer.c Lokio/BufferedSink;
      // 54: aload 1
      // 55: iload 2
      // 56: invokevirtual okhttp3/internal/http2/Settings.b (I)I
      // 59: invokeinterface okio/BufferedSink.i (I)Lokio/BufferedSink; 2
      // 5e: pop
      // 5f: goto 38
      // 62: iload 2
      // 63: bipush 7
      // 65: if_icmpne 79
      // 68: bipush 4
      // 69: istore 3
      // 6a: goto 45
      // 6d: aload 0
      // 6e: getfield okhttp3/internal/http2/Http2Writer.c Lokio/BufferedSink;
      // 71: invokeinterface okio/BufferedSink.flush ()V 1
      // 76: aload 0
      // 77: monitorexit
      // 78: return
      // 79: iload 2
      // 7a: istore 3
      // 7b: goto 45
      // try (4 -> 14): 14 null
      // try (19 -> 28): 14 null
      // try (31 -> 35): 14 null
      // try (42 -> 54): 14 null
      // try (61 -> 64): 14 null
   }

   public int c() {
      return this.f;
   }

   @Override
   public void close() throws IOException {
      synchronized (this) {
         this.g = true;
         this.c.close();
      }
   }
}
