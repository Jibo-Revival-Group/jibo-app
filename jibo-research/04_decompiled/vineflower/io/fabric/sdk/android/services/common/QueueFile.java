package io.fabric.sdk.android.services.common;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QueueFile implements Closeable {
   private static final Logger b = Logger.getLogger(QueueFile.class.getName());
   int a;
   private final RandomAccessFile c;
   private int d;
   private QueueFile.Element e;
   private QueueFile.Element f;
   private final byte[] g = new byte[16];

   public QueueFile(File var1) throws IOException {
      if (!var1.exists()) {
         a(var1);
      }

      this.c = b(var1);
      this.c();
   }

   private static int a(byte[] var0, int var1) {
      return ((var0[var1] & 0xFF) << 24) + ((var0[var1 + 1] & 0xFF) << 16) + ((var0[var1 + 2] & 0xFF) << 8) + (var0[var1 + 3] & 0xFF);
   }

   private QueueFile.Element a(int var1) throws IOException {
      QueueFile.Element var2;
      if (var1 == 0) {
         var2 = QueueFile.Element.a;
      } else {
         this.c.seek(var1);
         var2 = new QueueFile.Element(var1, this.c.readInt());
      }

      return var2;
   }

   private void a(int var1, int var2, int var3, int var4) throws IOException {
      a(this.g, var1, var2, var3, var4);
      this.c.seek(0L);
      this.c.write(this.g);
   }

   private void a(int var1, byte[] var2, int var3, int var4) throws IOException {
      int var5 = this.b(var1);
      if (var5 + var4 <= this.a) {
         this.c.seek(var5);
         this.c.write(var2, var3, var4);
      } else {
         var1 = this.a - var5;
         this.c.seek(var5);
         this.c.write(var2, var3, var1);
         this.c.seek(16L);
         this.c.write(var2, var3 + var1, var4 - var1);
      }
   }

   private static void a(File var0) throws IOException {
      File var3 = new File(var0.getPath() + ".tmp");
      RandomAccessFile var1 = b(var3);

      try {
         var1.setLength(4096L);
         var1.seek(0L);
         byte[] var2 = new byte[16];
         a(var2, 4096, 0, 0, 0);
         var1.write(var2);
      } finally {
         var1.close();
      }

      if (!var3.renameTo(var0)) {
         throw new IOException("Rename failed!");
      }
   }

   private static void a(byte[] var0, int... var1) {
      int var2 = 0;
      int var4 = var1.length;
      byte var3 = 0;

      while (var2 < var4) {
         b(var0, var3, var1[var2]);
         var3 += 4;
         var2++;
      }
   }

   private int b(int var1) {
      if (var1 >= this.a) {
         var1 = var1 + 16 - this.a;
      }

      return var1;
   }

   private static RandomAccessFile b(File var0) throws FileNotFoundException {
      return new RandomAccessFile(var0, "rwd");
   }

   private static <T> T b(T var0, String var1) {
      if (var0 == null) {
         throw new NullPointerException(var1);
      } else {
         return (T)var0;
      }
   }

   private void b(int var1, byte[] var2, int var3, int var4) throws IOException {
      int var5 = this.b(var1);
      if (var5 + var4 <= this.a) {
         this.c.seek(var5);
         this.c.readFully(var2, var3, var4);
      } else {
         var1 = this.a - var5;
         this.c.seek(var5);
         this.c.readFully(var2, var3, var1);
         this.c.seek(16L);
         this.c.readFully(var2, var3 + var1, var4 - var1);
      }
   }

   private static void b(byte[] var0, int var1, int var2) {
      var0[var1] = (byte)(var2 >> 24);
      var0[var1 + 1] = (byte)(var2 >> 16);
      var0[var1 + 2] = (byte)(var2 >> 8);
      var0[var1 + 3] = (byte)var2;
   }

   private void c() throws IOException {
      this.c.seek(0L);
      this.c.readFully(this.g);
      this.a = a(this.g, 0);
      if (this.a > this.c.length()) {
         throw new IOException("File is truncated. Expected length: " + this.a + ", Actual length: " + this.c.length());
      }

      this.d = a(this.g, 4);
      int var1 = a(this.g, 8);
      int var2 = a(this.g, 12);
      this.e = this.a(var1);
      this.f = this.a(var2);
   }

   private void c(int var1) throws IOException {
      int var5 = var1 + 4;
      var1 = this.d();
      if (var1 < var5) {
         int var2 = this.a;

         int var3;
         int var4;
         do {
            var4 = var1 + var2;
            var3 = var2 << 1;
            var2 = var3;
            var1 = var4;
         } while (var4 < var5);

         this.d(var3);
         var1 = this.b(this.f.b + 4 + this.f.c);
         if (var1 < this.e.b) {
            FileChannel var6 = this.c.getChannel();
            var6.position(this.a);
            var1 -= 4;
            if (var6.transferTo(16L, var1, var6) != var1) {
               throw new AssertionError("Copied insufficient number of bytes!");
            }
         }

         if (this.f.b < this.e.b) {
            var1 = this.a + this.f.b - 16;
            this.a(var3, this.d, this.e.b, var1);
            this.f = new QueueFile.Element(var1, this.f.c);
         } else {
            this.a(var3, this.d, this.e.b, this.f.b);
         }

         this.a = var3;
      }
   }

   private int d() {
      return this.a - this.a();
   }

   private void d(int var1) throws IOException {
      this.c.setLength(var1);
      this.c.getChannel().force(true);
   }

   public int a() {
      int var1;
      if (this.d == 0) {
         var1 = 16;
      } else if (this.f.b >= this.e.b) {
         var1 = this.f.b - this.e.b + 4 + this.f.c + 16;
      } else {
         var1 = this.f.b + 4 + this.f.c + this.a - this.e.b;
      }

      return var1;
   }

   public void a(QueueFile.ElementReader param1) throws IOException {
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
      // 03: getfield io/fabric/sdk/android/services/common/QueueFile.e Lio/fabric/sdk/android/services/common/QueueFile$Element;
      // 06: getfield io/fabric/sdk/android/services/common/QueueFile$Element.b I
      // 09: istore 3
      // 0a: bipush 0
      // 0b: istore 2
      // 0c: iload 2
      // 0d: aload 0
      // 0e: getfield io/fabric/sdk/android/services/common/QueueFile.d I
      // 11: if_icmpge 50
      // 14: aload 0
      // 15: iload 3
      // 16: invokespecial io/fabric/sdk/android/services/common/QueueFile.a (I)Lio/fabric/sdk/android/services/common/QueueFile$Element;
      // 19: astore 4
      // 1b: new io/fabric/sdk/android/services/common/QueueFile$ElementInputStream
      // 1e: astore 5
      // 20: aload 5
      // 22: aload 0
      // 23: aload 4
      // 25: aconst_null
      // 26: invokespecial io/fabric/sdk/android/services/common/QueueFile$ElementInputStream.<init> (Lio/fabric/sdk/android/services/common/QueueFile;Lio/fabric/sdk/android/services/common/QueueFile$Element;Lio/fabric/sdk/android/services/common/QueueFile$1;)V
      // 29: aload 1
      // 2a: aload 5
      // 2c: aload 4
      // 2e: getfield io/fabric/sdk/android/services/common/QueueFile$Element.c I
      // 31: invokeinterface io/fabric/sdk/android/services/common/QueueFile$ElementReader.a (Ljava/io/InputStream;I)V 3
      // 36: aload 4
      // 38: getfield io/fabric/sdk/android/services/common/QueueFile$Element.b I
      // 3b: istore 3
      // 3c: aload 0
      // 3d: aload 4
      // 3f: getfield io/fabric/sdk/android/services/common/QueueFile$Element.c I
      // 42: iload 3
      // 43: bipush 4
      // 44: iadd
      // 45: iadd
      // 46: invokespecial io/fabric/sdk/android/services/common/QueueFile.b (I)I
      // 49: istore 3
      // 4a: iinc 2 1
      // 4d: goto 0c
      // 50: aload 0
      // 51: monitorexit
      // 52: return
      // 53: astore 1
      // 54: aload 0
      // 55: monitorexit
      // 56: aload 1
      // 57: athrow
      // try (2 -> 6): 45 null
      // try (8 -> 40): 45 null
   }

   public void a(byte[] var1) throws IOException {
      this.a(var1, 0, var1.length);
   }

   public void a(byte[] param1, int param2, int param3) throws IOException {
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
      // 02: aload 1
      // 03: ldc "buffer"
      // 05: invokestatic io/fabric/sdk/android/services/common/QueueFile.b (Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
      // 08: pop
      // 09: iload 2
      // 0a: iload 3
      // 0b: ior
      // 0c: iflt 17
      // 0f: iload 3
      // 10: aload 1
      // 11: arraylength
      // 12: iload 2
      // 13: isub
      // 14: if_icmple 26
      // 17: new java/lang/IndexOutOfBoundsException
      // 1a: astore 1
      // 1b: aload 1
      // 1c: invokespecial java/lang/IndexOutOfBoundsException.<init> ()V
      // 1f: aload 1
      // 20: athrow
      // 21: astore 1
      // 22: aload 0
      // 23: monitorexit
      // 24: aload 1
      // 25: athrow
      // 26: aload 0
      // 27: iload 3
      // 28: invokespecial io/fabric/sdk/android/services/common/QueueFile.c (I)V
      // 2b: aload 0
      // 2c: invokevirtual io/fabric/sdk/android/services/common/QueueFile.b ()Z
      // 2f: istore 5
      // 31: iload 5
      // 33: ifeq ac
      // 36: bipush 16
      // 38: istore 4
      // 3a: new io/fabric/sdk/android/services/common/QueueFile$Element
      // 3d: astore 6
      // 3f: aload 6
      // 41: iload 4
      // 43: iload 3
      // 44: invokespecial io/fabric/sdk/android/services/common/QueueFile$Element.<init> (II)V
      // 47: aload 0
      // 48: getfield io/fabric/sdk/android/services/common/QueueFile.g [B
      // 4b: bipush 0
      // 4c: iload 3
      // 4d: invokestatic io/fabric/sdk/android/services/common/QueueFile.b ([BII)V
      // 50: aload 0
      // 51: aload 6
      // 53: getfield io/fabric/sdk/android/services/common/QueueFile$Element.b I
      // 56: aload 0
      // 57: getfield io/fabric/sdk/android/services/common/QueueFile.g [B
      // 5a: bipush 0
      // 5b: bipush 4
      // 5c: invokespecial io/fabric/sdk/android/services/common/QueueFile.a (I[BII)V
      // 5f: aload 0
      // 60: aload 6
      // 62: getfield io/fabric/sdk/android/services/common/QueueFile$Element.b I
      // 65: bipush 4
      // 66: iadd
      // 67: aload 1
      // 68: iload 2
      // 69: iload 3
      // 6a: invokespecial io/fabric/sdk/android/services/common/QueueFile.a (I[BII)V
      // 6d: iload 5
      // 6f: ifeq c6
      // 72: aload 6
      // 74: getfield io/fabric/sdk/android/services/common/QueueFile$Element.b I
      // 77: istore 2
      // 78: aload 0
      // 79: aload 0
      // 7a: getfield io/fabric/sdk/android/services/common/QueueFile.a I
      // 7d: aload 0
      // 7e: getfield io/fabric/sdk/android/services/common/QueueFile.d I
      // 81: bipush 1
      // 82: iadd
      // 83: iload 2
      // 84: aload 6
      // 86: getfield io/fabric/sdk/android/services/common/QueueFile$Element.b I
      // 89: invokespecial io/fabric/sdk/android/services/common/QueueFile.a (IIII)V
      // 8c: aload 0
      // 8d: aload 6
      // 8f: putfield io/fabric/sdk/android/services/common/QueueFile.f Lio/fabric/sdk/android/services/common/QueueFile$Element;
      // 92: aload 0
      // 93: aload 0
      // 94: getfield io/fabric/sdk/android/services/common/QueueFile.d I
      // 97: bipush 1
      // 98: iadd
      // 99: putfield io/fabric/sdk/android/services/common/QueueFile.d I
      // 9c: iload 5
      // 9e: ifeq a9
      // a1: aload 0
      // a2: aload 0
      // a3: getfield io/fabric/sdk/android/services/common/QueueFile.f Lio/fabric/sdk/android/services/common/QueueFile$Element;
      // a6: putfield io/fabric/sdk/android/services/common/QueueFile.e Lio/fabric/sdk/android/services/common/QueueFile$Element;
      // a9: aload 0
      // aa: monitorexit
      // ab: return
      // ac: aload 0
      // ad: aload 0
      // ae: getfield io/fabric/sdk/android/services/common/QueueFile.f Lio/fabric/sdk/android/services/common/QueueFile$Element;
      // b1: getfield io/fabric/sdk/android/services/common/QueueFile$Element.b I
      // b4: bipush 4
      // b5: iadd
      // b6: aload 0
      // b7: getfield io/fabric/sdk/android/services/common/QueueFile.f Lio/fabric/sdk/android/services/common/QueueFile$Element;
      // ba: getfield io/fabric/sdk/android/services/common/QueueFile$Element.c I
      // bd: iadd
      // be: invokespecial io/fabric/sdk/android/services/common/QueueFile.b (I)I
      // c1: istore 4
      // c3: goto 3a
      // c6: aload 0
      // c7: getfield io/fabric/sdk/android/services/common/QueueFile.e Lio/fabric/sdk/android/services/common/QueueFile$Element;
      // ca: getfield io/fabric/sdk/android/services/common/QueueFile$Element.b I
      // cd: istore 2
      // ce: goto 78
      // try (2 -> 6): 22 null
      // try (10 -> 16): 22 null
      // try (16 -> 22): 22 null
      // try (27 -> 33): 22 null
      // try (37 -> 65): 22 null
      // try (67 -> 70): 22 null
      // try (70 -> 90): 22 null
      // try (92 -> 96): 22 null
      // try (99 -> 111): 22 null
      // try (112 -> 116): 22 null
   }

   public boolean a(int var1, int var2) {
      boolean var3;
      if (this.a() + 4 + var1 <= var2) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // $VF: Could not create synchronized statement, marking monitor enters and exits
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public boolean b() {
      synchronized (this){} // $VF: monitorenter 
      boolean var5 = false /* VF: Semaphore variable */;

      int var1;
      try {
         var5 = true;
         var1 = this.d;
         var5 = false;
      } finally {
         if (var5) {
            // $VF: monitorexit
         }
      }

      boolean var2;
      if (var1 == 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      // $VF: monitorexit
      return var2;
   }

   @Override
   public void close() throws IOException {
      synchronized (this) {
         this.c.close();
      }
   }

   @Override
   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append(this.getClass().getSimpleName()).append('[');
      var1.append("fileLength=").append(this.a);
      var1.append(", size=").append(this.d);
      var1.append(", first=").append(this.e);
      var1.append(", last=").append(this.f);
      var1.append(", element lengths=[");

      try {
         QueueFile.ElementReader var2 = new QueueFile.ElementReader(this, var1) {
            boolean a;
            final StringBuilder b;
            final QueueFile c;

            {
               this.c = var1;
               this.b = var2x;
               this.a = true;
            }

            @Override
            public void a(InputStream var1, int var2x) throws IOException {
               if (this.a) {
                  this.a = false;
               } else {
                  this.b.append(", ");
               }

               this.b.append(var2x);
            }
         };
         this.a(var2);
      } catch (IOException var3) {
         b.log(Level.WARNING, "read error", var3);
      }

      var1.append("]]");
      return var1.toString();
   }

   static class Element {
      static final QueueFile.Element a = new QueueFile.Element(0, 0);
      final int b;
      final int c;

      Element(int var1, int var2) {
         this.b = var1;
         this.c = var2;
      }

      @Override
      public String toString() {
         return this.getClass().getSimpleName() + "[position = " + this.b + ", length = " + this.c + "]";
      }
   }

   private final class ElementInputStream extends InputStream {
      final QueueFile a;
      private int b;
      private int c;

      private ElementInputStream(QueueFile var1, QueueFile.Element var2) {
         this.a = var1;
         this.b = var1.b(var2.b + 4);
         this.c = var2.c;
      }

      @Override
      public int read() throws IOException {
         int var1;
         if (this.c == 0) {
            var1 = -1;
         } else {
            this.a.c.seek(this.b);
            var1 = this.a.c.read();
            this.b = this.a.b(this.b + 1);
            this.c--;
         }

         return var1;
      }

      @Override
      public int read(byte[] var1, int var2, int var3) throws IOException {
         QueueFile.b(var1, "buffer");
         if ((var2 | var3) >= 0 && var3 <= var1.length - var2) {
            int var4;
            if (this.c > 0) {
               var4 = var3;
               if (var3 > this.c) {
                  var4 = this.c;
               }

               this.a.b(this.b, var1, var2, var4);
               this.b = this.a.b(this.b + var4);
               this.c -= var4;
            } else {
               var4 = -1;
            }

            return var4;
         } else {
            throw new ArrayIndexOutOfBoundsException();
         }
      }
   }

   public interface ElementReader {
      void a(InputStream var1, int var2) throws IOException;
   }
}
