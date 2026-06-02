package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class RecyclableBufferedInputStream extends FilterInputStream {
   private volatile byte[] buf;
   private int count;
   private int marklimit;
   private int markpos = -1;
   private int pos;

   public RecyclableBufferedInputStream(InputStream var1, byte[] var2) {
      super(var1);
      if (var2 != null && var2.length != 0) {
         this.buf = var2;
      } else {
         throw new IllegalArgumentException("buffer is null or empty");
      }
   }

   private int fillbuf(InputStream var1, byte[] var2) throws IOException {
      int var3;
      if (this.markpos != -1 && this.pos - this.markpos < this.marklimit) {
         byte[] var5;
         if (this.markpos == 0 && this.marklimit > var2.length && this.count == var2.length) {
            int var8 = var2.length * 2;
            var3 = var8;
            if (var8 > this.marklimit) {
               var3 = this.marklimit;
            }

            if (Log.isLoggable("BufferedIs", 3)) {
               Log.d("BufferedIs", "allocate buffer of length: " + var3);
            }

            var5 = new byte[var3];
            System.arraycopy(var2, 0, var5, 0, var2.length);
            this.buf = var5;
         } else {
            var5 = var2;
            if (this.markpos > 0) {
               System.arraycopy(var2, this.markpos, var2, 0, var2.length - this.markpos);
               var5 = var2;
            }
         }

         this.pos = this.pos - this.markpos;
         this.markpos = 0;
         this.count = 0;
         int var9 = var1.read(var5, this.pos, var5.length - this.pos);
         if (var9 <= 0) {
            var3 = this.pos;
         } else {
            var3 = this.pos + var9;
         }

         this.count = var3;
         var3 = var9;
      } else {
         int var4 = var1.read(var2);
         var3 = var4;
         if (var4 > 0) {
            this.markpos = -1;
            this.pos = 0;
            this.count = var4;
            var3 = var4;
         }
      }

      return var3;
   }

   private static IOException streamClosed() throws IOException {
      throw new IOException("BufferedInputStream is closed");
   }

   @Override
   public int available() throws IOException {
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
      // 03: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.in Ljava/io/InputStream;
      // 06: astore 4
      // 08: aload 0
      // 09: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.buf [B
      // 0c: ifnull 14
      // 0f: aload 4
      // 11: ifnonnull 1f
      // 14: invokestatic com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.streamClosed ()Ljava/io/IOException;
      // 17: athrow
      // 18: astore 4
      // 1a: aload 0
      // 1b: monitorexit
      // 1c: aload 4
      // 1e: athrow
      // 1f: aload 0
      // 20: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.count I
      // 23: istore 3
      // 24: aload 0
      // 25: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.pos I
      // 28: istore 1
      // 29: aload 4
      // 2b: invokevirtual java/io/InputStream.available ()I
      // 2e: istore 2
      // 2f: aload 0
      // 30: monitorexit
      // 31: iload 2
      // 32: iload 3
      // 33: iload 1
      // 34: isub
      // 35: iadd
      // 36: ireturn
      // try (2 -> 8): 12 null
      // try (10 -> 12): 12 null
      // try (17 -> 26): 12 null
   }

   @Override
   public void close() throws IOException {
      this.buf = null;
      InputStream var1 = this.in;
      this.in = null;
      if (var1 != null) {
         var1.close();
      }
   }

   public void fixMarkLimit() {
      synchronized (this) {
         this.marklimit = this.buf.length;
      }
   }

   @Override
   public void mark(int var1) {
      synchronized (this) {
         this.marklimit = Math.max(this.marklimit, var1);
         this.markpos = this.pos;
      }
   }

   @Override
   public boolean markSupported() {
      return true;
   }

   @Override
   public int read() throws IOException {
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
      // 00: bipush -1
      // 01: istore 1
      // 02: aload 0
      // 03: monitorenter
      // 04: aload 0
      // 05: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.buf [B
      // 08: astore 4
      // 0a: aload 0
      // 0b: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.in Ljava/io/InputStream;
      // 0e: astore 3
      // 0f: aload 4
      // 11: ifnull 18
      // 14: aload 3
      // 15: ifnonnull 21
      // 18: invokestatic com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.streamClosed ()Ljava/io/IOException;
      // 1b: athrow
      // 1c: astore 3
      // 1d: aload 0
      // 1e: monitorexit
      // 1f: aload 3
      // 20: athrow
      // 21: aload 0
      // 22: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.pos I
      // 25: aload 0
      // 26: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.count I
      // 29: if_icmplt 3d
      // 2c: aload 0
      // 2d: aload 3
      // 2e: aload 4
      // 30: invokespecial com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.fillbuf (Ljava/io/InputStream;[B)I
      // 33: istore 2
      // 34: iload 2
      // 35: bipush -1
      // 36: if_icmpne 3d
      // 39: aload 0
      // 3a: monitorexit
      // 3b: iload 1
      // 3c: ireturn
      // 3d: aload 4
      // 3f: astore 3
      // 40: aload 4
      // 42: aload 0
      // 43: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.buf [B
      // 46: if_acmpeq 5b
      // 49: aload 0
      // 4a: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.buf [B
      // 4d: astore 4
      // 4f: aload 4
      // 51: astore 3
      // 52: aload 4
      // 54: ifnonnull 5b
      // 57: invokestatic com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.streamClosed ()Ljava/io/IOException;
      // 5a: athrow
      // 5b: aload 0
      // 5c: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.count I
      // 5f: aload 0
      // 60: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.pos I
      // 63: isub
      // 64: ifle 39
      // 67: aload 0
      // 68: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.pos I
      // 6b: istore 1
      // 6c: aload 0
      // 6d: iload 1
      // 6e: bipush 1
      // 6f: iadd
      // 70: putfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.pos I
      // 73: aload 3
      // 74: iload 1
      // 75: baload
      // 76: istore 1
      // 77: iload 1
      // 78: sipush 255
      // 7b: iand
      // 7c: istore 1
      // 7d: goto 39
      // try (4 -> 10): 16 null
      // try (14 -> 16): 16 null
      // try (21 -> 31): 16 null
      // try (40 -> 47): 16 null
      // try (51 -> 53): 16 null
      // try (53 -> 67): 16 null
   }

   @Override
   public int read(byte[] param1, int param2, int param3) throws IOException {
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
      // 000: bipush -1
      // 001: istore 6
      // 003: aload 0
      // 004: monitorenter
      // 005: aload 0
      // 006: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.buf [B
      // 009: astore 9
      // 00b: aload 9
      // 00d: ifnonnull 019
      // 010: invokestatic com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.streamClosed ()Ljava/io/IOException;
      // 013: athrow
      // 014: astore 1
      // 015: aload 0
      // 016: monitorexit
      // 017: aload 1
      // 018: athrow
      // 019: iload 3
      // 01a: ifne 023
      // 01d: bipush 0
      // 01e: istore 2
      // 01f: aload 0
      // 020: monitorexit
      // 021: iload 2
      // 022: ireturn
      // 023: aload 0
      // 024: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.in Ljava/io/InputStream;
      // 027: astore 10
      // 029: aload 10
      // 02b: ifnonnull 032
      // 02e: invokestatic com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.streamClosed ()Ljava/io/IOException;
      // 031: athrow
      // 032: aload 0
      // 033: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.pos I
      // 036: aload 0
      // 037: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.count I
      // 03a: if_icmpge 0cc
      // 03d: aload 0
      // 03e: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.count I
      // 041: aload 0
      // 042: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.pos I
      // 045: isub
      // 046: iload 3
      // 047: if_icmplt 079
      // 04a: iload 3
      // 04b: istore 4
      // 04d: aload 9
      // 04f: aload 0
      // 050: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.pos I
      // 053: aload 1
      // 054: iload 2
      // 055: iload 4
      // 057: invokestatic java/lang/System.arraycopy (Ljava/lang/Object;ILjava/lang/Object;II)V
      // 05a: aload 0
      // 05b: aload 0
      // 05c: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.pos I
      // 05f: iload 4
      // 061: iadd
      // 062: putfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.pos I
      // 065: iload 4
      // 067: iload 3
      // 068: if_icmpeq 073
      // 06b: aload 10
      // 06d: invokevirtual java/io/InputStream.available ()I
      // 070: ifne 087
      // 073: iload 4
      // 075: istore 2
      // 076: goto 01f
      // 079: aload 0
      // 07a: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.count I
      // 07d: aload 0
      // 07e: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.pos I
      // 081: isub
      // 082: istore 4
      // 084: goto 04d
      // 087: iload 2
      // 088: iload 4
      // 08a: iadd
      // 08b: istore 2
      // 08c: iload 3
      // 08d: iload 4
      // 08f: isub
      // 090: istore 4
      // 092: aload 0
      // 093: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.markpos I
      // 096: bipush -1
      // 097: if_icmpne 0d2
      // 09a: iload 4
      // 09c: aload 9
      // 09e: arraylength
      // 09f: if_icmplt 0d2
      // 0a2: aload 10
      // 0a4: aload 1
      // 0a5: iload 2
      // 0a6: iload 4
      // 0a8: invokevirtual java/io/InputStream.read ([BII)I
      // 0ab: istore 7
      // 0ad: iload 7
      // 0af: istore 5
      // 0b1: aload 9
      // 0b3: astore 8
      // 0b5: iload 7
      // 0b7: bipush -1
      // 0b8: if_icmpne 139
      // 0bb: iload 6
      // 0bd: istore 2
      // 0be: iload 4
      // 0c0: iload 3
      // 0c1: if_icmpeq 01f
      // 0c4: iload 3
      // 0c5: iload 4
      // 0c7: isub
      // 0c8: istore 2
      // 0c9: goto 01f
      // 0cc: iload 3
      // 0cd: istore 4
      // 0cf: goto 092
      // 0d2: aload 0
      // 0d3: aload 10
      // 0d5: aload 9
      // 0d7: invokespecial com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.fillbuf (Ljava/io/InputStream;[B)I
      // 0da: bipush -1
      // 0db: if_icmpne 0ef
      // 0de: iload 6
      // 0e0: istore 2
      // 0e1: iload 4
      // 0e3: iload 3
      // 0e4: if_icmpeq 01f
      // 0e7: iload 3
      // 0e8: iload 4
      // 0ea: isub
      // 0eb: istore 2
      // 0ec: goto 01f
      // 0ef: aload 9
      // 0f1: astore 8
      // 0f3: aload 9
      // 0f5: aload 0
      // 0f6: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.buf [B
      // 0f9: if_acmpeq 10f
      // 0fc: aload 0
      // 0fd: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.buf [B
      // 100: astore 9
      // 102: aload 9
      // 104: astore 8
      // 106: aload 9
      // 108: ifnonnull 10f
      // 10b: invokestatic com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.streamClosed ()Ljava/io/IOException;
      // 10e: athrow
      // 10f: aload 0
      // 110: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.count I
      // 113: aload 0
      // 114: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.pos I
      // 117: isub
      // 118: iload 4
      // 11a: if_icmplt 14a
      // 11d: iload 4
      // 11f: istore 5
      // 121: aload 8
      // 123: aload 0
      // 124: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.pos I
      // 127: aload 1
      // 128: iload 2
      // 129: iload 5
      // 12b: invokestatic java/lang/System.arraycopy (Ljava/lang/Object;ILjava/lang/Object;II)V
      // 12e: aload 0
      // 12f: aload 0
      // 130: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.pos I
      // 133: iload 5
      // 135: iadd
      // 136: putfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.pos I
      // 139: iload 4
      // 13b: iload 5
      // 13d: isub
      // 13e: istore 4
      // 140: iload 4
      // 142: ifne 158
      // 145: iload 3
      // 146: istore 2
      // 147: goto 01f
      // 14a: aload 0
      // 14b: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.count I
      // 14e: aload 0
      // 14f: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.pos I
      // 152: isub
      // 153: istore 5
      // 155: goto 121
      // 158: aload 10
      // 15a: invokevirtual java/io/InputStream.available ()I
      // 15d: istore 7
      // 15f: iload 7
      // 161: ifne 16c
      // 164: iload 3
      // 165: iload 4
      // 167: isub
      // 168: istore 2
      // 169: goto 01f
      // 16c: iload 2
      // 16d: iload 5
      // 16f: iadd
      // 170: istore 2
      // 171: aload 8
      // 173: astore 9
      // 175: goto 092
      // try (4 -> 7): 11 null
      // try (9 -> 11): 11 null
      // try (24 -> 27): 11 null
      // try (29 -> 31): 11 null
      // try (31 -> 43): 11 null
      // try (45 -> 58): 11 null
      // try (61 -> 64): 11 null
      // try (67 -> 73): 11 null
      // try (82 -> 96): 11 null
      // try (116 -> 122): 11 null
      // try (134 -> 141): 11 null
      // try (145 -> 147): 11 null
      // try (147 -> 154): 11 null
      // try (156 -> 169): 11 null
      // try (178 -> 184): 11 null
      // try (185 -> 188): 11 null
   }

   @Override
   public void reset() throws IOException {
      synchronized (this) {
         if (this.buf == null) {
            IOException var3 = new IOException("Stream is closed");
            throw var3;
         }

         if (-1 == this.markpos) {
            RecyclableBufferedInputStream.InvalidMarkException var1 = new RecyclableBufferedInputStream.InvalidMarkException("Mark has been invalidated");
            throw var1;
         }

         this.pos = this.markpos;
      }
   }

   @Override
   public long skip(long param1) throws IOException {
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
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.buf [B
      // 06: astore 5
      // 08: aload 0
      // 09: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.in Ljava/io/InputStream;
      // 0c: astore 6
      // 0e: aload 5
      // 10: ifnonnull 1e
      // 13: invokestatic com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.streamClosed ()Ljava/io/IOException;
      // 16: athrow
      // 17: astore 5
      // 19: aload 0
      // 1a: monitorexit
      // 1b: aload 5
      // 1d: athrow
      // 1e: lload 1
      // 1f: lconst_1
      // 20: lcmp
      // 21: ifge 2a
      // 24: lconst_0
      // 25: lstore 1
      // 26: aload 0
      // 27: monitorexit
      // 28: lload 1
      // 29: lreturn
      // 2a: aload 6
      // 2c: ifnonnull 33
      // 2f: invokestatic com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.streamClosed ()Ljava/io/IOException;
      // 32: athrow
      // 33: aload 0
      // 34: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.count I
      // 37: aload 0
      // 38: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.pos I
      // 3b: isub
      // 3c: i2l
      // 3d: lload 1
      // 3e: lcmp
      // 3f: iflt 51
      // 42: aload 0
      // 43: aload 0
      // 44: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.pos I
      // 47: i2l
      // 48: lload 1
      // 49: ladd
      // 4a: l2i
      // 4b: putfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.pos I
      // 4e: goto 26
      // 51: aload 0
      // 52: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.count I
      // 55: aload 0
      // 56: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.pos I
      // 59: isub
      // 5a: i2l
      // 5b: lstore 3
      // 5c: aload 0
      // 5d: aload 0
      // 5e: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.count I
      // 61: putfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.pos I
      // 64: aload 0
      // 65: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.markpos I
      // 68: bipush -1
      // 69: if_icmpeq c2
      // 6c: lload 1
      // 6d: aload 0
      // 6e: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.marklimit I
      // 71: i2l
      // 72: lcmp
      // 73: ifgt c2
      // 76: aload 0
      // 77: aload 6
      // 79: aload 5
      // 7b: invokespecial com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.fillbuf (Ljava/io/InputStream;[B)I
      // 7e: bipush -1
      // 7f: if_icmpne 87
      // 82: lload 3
      // 83: lstore 1
      // 84: goto 26
      // 87: aload 0
      // 88: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.count I
      // 8b: aload 0
      // 8c: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.pos I
      // 8f: isub
      // 90: i2l
      // 91: lload 1
      // 92: lload 3
      // 93: lsub
      // 94: lcmp
      // 95: iflt a9
      // 98: aload 0
      // 99: lload 1
      // 9a: lload 3
      // 9b: lsub
      // 9c: aload 0
      // 9d: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.pos I
      // a0: i2l
      // a1: ladd
      // a2: l2i
      // a3: putfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.pos I
      // a6: goto 26
      // a9: lload 3
      // aa: aload 0
      // ab: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.count I
      // ae: i2l
      // af: ladd
      // b0: aload 0
      // b1: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.pos I
      // b4: i2l
      // b5: lsub
      // b6: lstore 1
      // b7: aload 0
      // b8: aload 0
      // b9: getfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.count I
      // bc: putfield com/bumptech/glide/load/resource/bitmap/RecyclableBufferedInputStream.pos I
      // bf: goto 26
      // c2: aload 6
      // c4: lload 1
      // c5: lload 3
      // c6: lsub
      // c7: invokevirtual java/io/InputStream.skip (J)J
      // ca: lstore 1
      // cb: lload 3
      // cc: lload 1
      // cd: ladd
      // ce: lstore 1
      // cf: goto 26
      // try (2 -> 8): 12 null
      // try (10 -> 12): 12 null
      // try (29 -> 31): 12 null
      // try (31 -> 48): 12 null
      // try (49 -> 76): 12 null
      // try (79 -> 100): 12 null
      // try (101 -> 115): 12 null
      // try (116 -> 122): 12 null
   }

   public static class InvalidMarkException extends RuntimeException {
      public InvalidMarkException(String var1) {
         super(var1);
      }
   }
}
