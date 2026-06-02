package com.segment.analytics;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QueueFile implements Closeable {
   static final int HEADER_LENGTH = 16;
   private static final int INITIAL_LENGTH = 4096;
   private static final Logger LOGGER = Logger.getLogger(QueueFile.class.getName());
   private static final byte[] ZEROES = new byte[4096];
   private final byte[] buffer = new byte[16];
   private int elementCount;
   int fileLength;
   private QueueFile.Element first;
   private QueueFile.Element last;
   final RandomAccessFile raf;

   public QueueFile(File var1) throws IOException {
      if (!var1.exists()) {
         initialize(var1);
      }

      this.raf = open(var1);
      this.readHeader();
   }

   QueueFile(RandomAccessFile var1) throws IOException {
      this.raf = var1;
      this.readHeader();
   }

   private void expandIfNecessary(int var1) throws IOException {
      int var4 = var1 + 4;
      int var2 = this.remainingBytes();
      if (var2 < var4) {
         var1 = this.fileLength;

         while (true) {
            int var3 = var2 + var1;
            var2 = var1 << 1;
            if (var2 < var1) {
               throw new EOFException("Cannot grow file beyond " + var1 + " bytes");
            }

            if (var3 >= var4) {
               this.setLength(var2);
               var1 = this.wrapPosition(this.last.position + 4 + this.last.length);
               if (var1 <= this.first.position) {
                  FileChannel var5 = this.raf.getChannel();
                  var5.position(this.fileLength);
                  var1 -= 16;
                  if (var5.transferTo(16L, var1, var5) != var1) {
                     throw new AssertionError("Copied insufficient number of bytes!");
                  }

                  this.ringErase(16, var1);
               }

               if (this.last.position < this.first.position) {
                  var1 = this.fileLength + this.last.position - 16;
                  this.writeHeader(var2, this.elementCount, this.first.position, var1);
                  this.last = new QueueFile.Element(var1, this.last.length);
               } else {
                  this.writeHeader(var2, this.elementCount, this.first.position, this.last.position);
               }

               this.fileLength = var2;
               break;
            }

            var1 = var2;
            var2 = var3;
         }
      }
   }

   private static void initialize(File var0) throws IOException {
      File var3 = new File(var0.getPath() + ".tmp");
      RandomAccessFile var1 = open(var3);

      try {
         var1.setLength(4096L);
         var1.seek(0L);
         byte[] var2 = new byte[16];
         writeInt(var2, 0, 4096);
         var1.write(var2);
      } finally {
         var1.close();
      }

      if (!var3.renameTo(var0)) {
         throw new IOException("Rename failed!");
      }
   }

   private static RandomAccessFile open(File var0) throws FileNotFoundException {
      return new RandomAccessFile(var0, "rwd");
   }

   private QueueFile.Element readElement(int var1) throws IOException {
      QueueFile.Element var2;
      if (var1 == 0) {
         var2 = QueueFile.Element.NULL;
      } else {
         this.ringRead(var1, this.buffer, 0, 4);
         var2 = new QueueFile.Element(var1, readInt(this.buffer, 0));
      }

      return var2;
   }

   private void readHeader() throws IOException {
      this.raf.seek(0L);
      this.raf.readFully(this.buffer);
      this.fileLength = readInt(this.buffer, 0);
      if (this.fileLength > this.raf.length()) {
         throw new IOException("File is truncated. Expected length: " + this.fileLength + ", Actual length: " + this.raf.length());
      }

      if (this.fileLength <= 0) {
         throw new IOException("File is corrupt; length stored in header (" + this.fileLength + ") is invalid.");
      }

      this.elementCount = readInt(this.buffer, 4);
      int var1 = readInt(this.buffer, 8);
      int var2 = readInt(this.buffer, 12);
      this.first = this.readElement(var1);
      this.last = this.readElement(var2);
   }

   private static int readInt(byte[] var0, int var1) {
      return ((var0[var1] & 0xFF) << 24) + ((var0[var1 + 1] & 0xFF) << 16) + ((var0[var1 + 2] & 0xFF) << 8) + (var0[var1 + 3] & 0xFF);
   }

   private int remainingBytes() {
      return this.fileLength - this.usedBytes();
   }

   private void ringErase(int var1, int var2) throws IOException {
      while (var2 > 0) {
         int var3 = Math.min(var2, ZEROES.length);
         this.ringWrite(var1, ZEROES, 0, var3);
         var2 -= var3;
         var1 += var3;
      }
   }

   private void ringWrite(int var1, byte[] var2, int var3, int var4) throws IOException {
      int var5 = this.wrapPosition(var1);
      if (var5 + var4 <= this.fileLength) {
         this.raf.seek(var5);
         this.raf.write(var2, var3, var4);
      } else {
         var1 = this.fileLength - var5;
         this.raf.seek(var5);
         this.raf.write(var2, var3, var1);
         this.raf.seek(16L);
         this.raf.write(var2, var3 + var1, var4 - var1);
      }
   }

   private void setLength(int var1) throws IOException {
      this.raf.setLength(var1);
      this.raf.getChannel().force(true);
   }

   private int usedBytes() {
      int var1;
      if (this.elementCount == 0) {
         var1 = 16;
      } else if (this.last.position >= this.first.position) {
         var1 = this.last.position - this.first.position + 4 + this.last.length + 16;
      } else {
         var1 = this.last.position + 4 + this.last.length + this.fileLength - this.first.position;
      }

      return var1;
   }

   private void writeHeader(int var1, int var2, int var3, int var4) throws IOException {
      writeInt(this.buffer, 0, var1);
      writeInt(this.buffer, 4, var2);
      writeInt(this.buffer, 8, var3);
      writeInt(this.buffer, 12, var4);
      this.raf.seek(0L);
      this.raf.write(this.buffer);
   }

   private static void writeInt(byte[] var0, int var1, int var2) {
      var0[var1] = (byte)(var2 >> 24);
      var0[var1 + 1] = (byte)(var2 >> 16);
      var0[var1 + 2] = (byte)(var2 >> 8);
      var0[var1 + 3] = (byte)var2;
   }

   public void add(byte[] var1) throws IOException {
      this.add(var1, 0, var1.length);
   }

   public void add(byte[] param1, int param2, int param3) throws IOException {
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
      // 03: ifnonnull 18
      // 06: new java/lang/NullPointerException
      // 09: astore 1
      // 0a: aload 1
      // 0b: ldc_w "data == null"
      // 0e: invokespecial java/lang/NullPointerException.<init> (Ljava/lang/String;)V
      // 11: aload 1
      // 12: athrow
      // 13: astore 1
      // 14: aload 0
      // 15: monitorexit
      // 16: aload 1
      // 17: athrow
      // 18: iload 2
      // 19: iload 3
      // 1a: ior
      // 1b: iflt 26
      // 1e: iload 3
      // 1f: aload 1
      // 20: arraylength
      // 21: iload 2
      // 22: isub
      // 23: if_icmple 30
      // 26: new java/lang/IndexOutOfBoundsException
      // 29: astore 1
      // 2a: aload 1
      // 2b: invokespecial java/lang/IndexOutOfBoundsException.<init> ()V
      // 2e: aload 1
      // 2f: athrow
      // 30: aload 0
      // 31: iload 3
      // 32: invokespecial com/segment/analytics/QueueFile.expandIfNecessary (I)V
      // 35: aload 0
      // 36: invokevirtual com/segment/analytics/QueueFile.isEmpty ()Z
      // 39: istore 5
      // 3b: iload 5
      // 3d: ifeq b6
      // 40: bipush 16
      // 42: istore 4
      // 44: new com/segment/analytics/QueueFile$Element
      // 47: astore 6
      // 49: aload 6
      // 4b: iload 4
      // 4d: iload 3
      // 4e: invokespecial com/segment/analytics/QueueFile$Element.<init> (II)V
      // 51: aload 0
      // 52: getfield com/segment/analytics/QueueFile.buffer [B
      // 55: bipush 0
      // 56: iload 3
      // 57: invokestatic com/segment/analytics/QueueFile.writeInt ([BII)V
      // 5a: aload 0
      // 5b: aload 6
      // 5d: getfield com/segment/analytics/QueueFile$Element.position I
      // 60: aload 0
      // 61: getfield com/segment/analytics/QueueFile.buffer [B
      // 64: bipush 0
      // 65: bipush 4
      // 66: invokespecial com/segment/analytics/QueueFile.ringWrite (I[BII)V
      // 69: aload 0
      // 6a: aload 6
      // 6c: getfield com/segment/analytics/QueueFile$Element.position I
      // 6f: bipush 4
      // 70: iadd
      // 71: aload 1
      // 72: iload 2
      // 73: iload 3
      // 74: invokespecial com/segment/analytics/QueueFile.ringWrite (I[BII)V
      // 77: iload 5
      // 79: ifeq d0
      // 7c: aload 6
      // 7e: getfield com/segment/analytics/QueueFile$Element.position I
      // 81: istore 2
      // 82: aload 0
      // 83: aload 0
      // 84: getfield com/segment/analytics/QueueFile.fileLength I
      // 87: aload 0
      // 88: getfield com/segment/analytics/QueueFile.elementCount I
      // 8b: bipush 1
      // 8c: iadd
      // 8d: iload 2
      // 8e: aload 6
      // 90: getfield com/segment/analytics/QueueFile$Element.position I
      // 93: invokespecial com/segment/analytics/QueueFile.writeHeader (IIII)V
      // 96: aload 0
      // 97: aload 6
      // 99: putfield com/segment/analytics/QueueFile.last Lcom/segment/analytics/QueueFile$Element;
      // 9c: aload 0
      // 9d: aload 0
      // 9e: getfield com/segment/analytics/QueueFile.elementCount I
      // a1: bipush 1
      // a2: iadd
      // a3: putfield com/segment/analytics/QueueFile.elementCount I
      // a6: iload 5
      // a8: ifeq b3
      // ab: aload 0
      // ac: aload 0
      // ad: getfield com/segment/analytics/QueueFile.last Lcom/segment/analytics/QueueFile$Element;
      // b0: putfield com/segment/analytics/QueueFile.first Lcom/segment/analytics/QueueFile$Element;
      // b3: aload 0
      // b4: monitorexit
      // b5: return
      // b6: aload 0
      // b7: aload 0
      // b8: getfield com/segment/analytics/QueueFile.last Lcom/segment/analytics/QueueFile$Element;
      // bb: getfield com/segment/analytics/QueueFile$Element.position I
      // be: bipush 4
      // bf: iadd
      // c0: aload 0
      // c1: getfield com/segment/analytics/QueueFile.last Lcom/segment/analytics/QueueFile$Element;
      // c4: getfield com/segment/analytics/QueueFile$Element.length I
      // c7: iadd
      // c8: invokevirtual com/segment/analytics/QueueFile.wrapPosition (I)I
      // cb: istore 4
      // cd: goto 44
      // d0: aload 0
      // d1: getfield com/segment/analytics/QueueFile.first Lcom/segment/analytics/QueueFile$Element;
      // d4: getfield com/segment/analytics/QueueFile$Element.position I
      // d7: istore 2
      // d8: goto 82
      // try (4 -> 11): 11 null
      // try (20 -> 26): 11 null
      // try (26 -> 32): 11 null
      // try (32 -> 38): 11 null
      // try (42 -> 70): 11 null
      // try (72 -> 75): 11 null
      // try (75 -> 95): 11 null
      // try (97 -> 101): 11 null
      // try (104 -> 116): 11 null
      // try (117 -> 121): 11 null
   }

   public void clear() throws IOException {
      synchronized (this) {
         this.writeHeader(4096, 0, 0, 0);
         this.raf.seek(16L);
         this.raf.write(ZEROES, 0, 4080);
         this.elementCount = 0;
         this.first = QueueFile.Element.NULL;
         this.last = QueueFile.Element.NULL;
         if (this.fileLength > 4096) {
            this.setLength(4096);
         }

         this.fileLength = 4096;
      }
   }

   @Override
   public void close() throws IOException {
      synchronized (this) {
         this.raf.close();
      }
   }

   public int forEach(PayloadQueue.ElementVisitor param1) throws IOException {
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
      // 03: getfield com/segment/analytics/QueueFile.first Lcom/segment/analytics/QueueFile$Element;
      // 06: getfield com/segment/analytics/QueueFile$Element.position I
      // 09: istore 3
      // 0a: bipush 0
      // 0b: istore 2
      // 0c: iload 2
      // 0d: aload 0
      // 0e: getfield com/segment/analytics/QueueFile.elementCount I
      // 11: if_icmpge 5d
      // 14: aload 0
      // 15: iload 3
      // 16: invokespecial com/segment/analytics/QueueFile.readElement (I)Lcom/segment/analytics/QueueFile$Element;
      // 19: astore 6
      // 1b: new com/segment/analytics/QueueFile$ElementInputStream
      // 1e: astore 5
      // 20: aload 5
      // 22: aload 0
      // 23: aload 6
      // 25: invokespecial com/segment/analytics/QueueFile$ElementInputStream.<init> (Lcom/segment/analytics/QueueFile;Lcom/segment/analytics/QueueFile$Element;)V
      // 28: aload 1
      // 29: aload 5
      // 2b: aload 6
      // 2d: getfield com/segment/analytics/QueueFile$Element.length I
      // 30: invokeinterface com/segment/analytics/PayloadQueue$ElementVisitor.read (Ljava/io/InputStream;I)Z 3
      // 35: istore 4
      // 37: iload 4
      // 39: ifne 43
      // 3c: iinc 2 1
      // 3f: aload 0
      // 40: monitorexit
      // 41: iload 2
      // 42: ireturn
      // 43: aload 6
      // 45: getfield com/segment/analytics/QueueFile$Element.position I
      // 48: istore 3
      // 49: aload 0
      // 4a: aload 6
      // 4c: getfield com/segment/analytics/QueueFile$Element.length I
      // 4f: iload 3
      // 50: bipush 4
      // 51: iadd
      // 52: iadd
      // 53: invokevirtual com/segment/analytics/QueueFile.wrapPosition (I)I
      // 56: istore 3
      // 57: iinc 2 1
      // 5a: goto 0c
      // 5d: aload 0
      // 5e: getfield com/segment/analytics/QueueFile.elementCount I
      // 61: istore 2
      // 62: goto 3f
      // 65: astore 1
      // 66: aload 0
      // 67: monitorexit
      // 68: aload 1
      // 69: athrow
      // try (2 -> 6): 53 null
      // try (8 -> 28): 53 null
      // try (35 -> 47): 53 null
      // try (49 -> 52): 53 null
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // $VF: Could not create synchronized statement, marking monitor enters and exits
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public boolean isEmpty() {
      synchronized (this){} // $VF: monitorenter 
      boolean var5 = false /* VF: Semaphore variable */;

      int var1;
      try {
         var5 = true;
         var1 = this.elementCount;
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

   public byte[] peek() throws IOException {
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
      // 03: invokevirtual com/segment/analytics/QueueFile.isEmpty ()Z
      // 06: istore 2
      // 07: iload 2
      // 08: ifeq 11
      // 0b: aconst_null
      // 0c: astore 3
      // 0d: aload 0
      // 0e: monitorexit
      // 0f: aload 3
      // 10: areturn
      // 11: aload 0
      // 12: getfield com/segment/analytics/QueueFile.first Lcom/segment/analytics/QueueFile$Element;
      // 15: getfield com/segment/analytics/QueueFile$Element.length I
      // 18: istore 1
      // 19: iload 1
      // 1a: newarray 8
      // 1c: astore 3
      // 1d: aload 0
      // 1e: aload 0
      // 1f: getfield com/segment/analytics/QueueFile.first Lcom/segment/analytics/QueueFile$Element;
      // 22: getfield com/segment/analytics/QueueFile$Element.position I
      // 25: bipush 4
      // 26: iadd
      // 27: aload 3
      // 28: bipush 0
      // 29: iload 1
      // 2a: invokevirtual com/segment/analytics/QueueFile.ringRead (I[BII)V
      // 2d: goto 0d
      // 30: astore 3
      // 31: aload 0
      // 32: monitorexit
      // 33: aload 3
      // 34: athrow
      // try (2 -> 5): 31 null
      // try (13 -> 30): 31 null
   }

   public void remove() throws IOException {
      synchronized (this) {
         this.remove(1);
      }
   }

   public void remove(int param1) throws IOException {
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
      // 000: bipush 0
      // 001: istore 2
      // 002: aload 0
      // 003: monitorenter
      // 004: aload 0
      // 005: invokevirtual com/segment/analytics/QueueFile.isEmpty ()Z
      // 008: ifeq 01f
      // 00b: new java/util/NoSuchElementException
      // 00e: astore 7
      // 010: aload 7
      // 012: invokespecial java/util/NoSuchElementException.<init> ()V
      // 015: aload 7
      // 017: athrow
      // 018: astore 7
      // 01a: aload 0
      // 01b: monitorexit
      // 01c: aload 7
      // 01e: athrow
      // 01f: iload 1
      // 020: ifge 04f
      // 023: new java/lang/IllegalArgumentException
      // 026: astore 8
      // 028: new java/lang/StringBuilder
      // 02b: astore 7
      // 02d: aload 7
      // 02f: invokespecial java/lang/StringBuilder.<init> ()V
      // 032: aload 8
      // 034: aload 7
      // 036: ldc_w "Cannot remove negative ("
      // 039: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 03c: iload 1
      // 03d: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 040: ldc_w ") number of elements."
      // 043: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 046: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 049: invokespecial java/lang/IllegalArgumentException.<init> (Ljava/lang/String;)V
      // 04c: aload 8
      // 04e: athrow
      // 04f: iload 1
      // 050: ifne 056
      // 053: aload 0
      // 054: monitorexit
      // 055: return
      // 056: iload 1
      // 057: aload 0
      // 058: getfield com/segment/analytics/QueueFile.elementCount I
      // 05b: if_icmpne 065
      // 05e: aload 0
      // 05f: invokevirtual com/segment/analytics/QueueFile.clear ()V
      // 062: goto 053
      // 065: iload 1
      // 066: aload 0
      // 067: getfield com/segment/analytics/QueueFile.elementCount I
      // 06a: if_icmple 0a6
      // 06d: new java/lang/IllegalArgumentException
      // 070: astore 7
      // 072: new java/lang/StringBuilder
      // 075: astore 8
      // 077: aload 8
      // 079: invokespecial java/lang/StringBuilder.<init> ()V
      // 07c: aload 7
      // 07e: aload 8
      // 080: ldc_w "Cannot remove more elements ("
      // 083: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 086: iload 1
      // 087: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 08a: ldc_w ") than present in queue ("
      // 08d: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 090: aload 0
      // 091: getfield com/segment/analytics/QueueFile.elementCount I
      // 094: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 097: ldc_w ")."
      // 09a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 09d: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0a0: invokespecial java/lang/IllegalArgumentException.<init> (Ljava/lang/String;)V
      // 0a3: aload 7
      // 0a5: athrow
      // 0a6: aload 0
      // 0a7: getfield com/segment/analytics/QueueFile.first Lcom/segment/analytics/QueueFile$Element;
      // 0aa: getfield com/segment/analytics/QueueFile$Element.position I
      // 0ad: istore 6
      // 0af: aload 0
      // 0b0: getfield com/segment/analytics/QueueFile.first Lcom/segment/analytics/QueueFile$Element;
      // 0b3: getfield com/segment/analytics/QueueFile$Element.position I
      // 0b6: istore 4
      // 0b8: aload 0
      // 0b9: getfield com/segment/analytics/QueueFile.first Lcom/segment/analytics/QueueFile$Element;
      // 0bc: getfield com/segment/analytics/QueueFile$Element.length I
      // 0bf: istore 5
      // 0c1: bipush 0
      // 0c2: istore 3
      // 0c3: iload 2
      // 0c4: iload 1
      // 0c5: if_icmpge 0f8
      // 0c8: iload 3
      // 0c9: iload 5
      // 0cb: bipush 4
      // 0cc: iadd
      // 0cd: iadd
      // 0ce: istore 3
      // 0cf: aload 0
      // 0d0: iload 5
      // 0d2: iload 4
      // 0d4: bipush 4
      // 0d5: iadd
      // 0d6: iadd
      // 0d7: invokevirtual com/segment/analytics/QueueFile.wrapPosition (I)I
      // 0da: istore 4
      // 0dc: aload 0
      // 0dd: iload 4
      // 0df: aload 0
      // 0e0: getfield com/segment/analytics/QueueFile.buffer [B
      // 0e3: bipush 0
      // 0e4: bipush 4
      // 0e5: invokevirtual com/segment/analytics/QueueFile.ringRead (I[BII)V
      // 0e8: aload 0
      // 0e9: getfield com/segment/analytics/QueueFile.buffer [B
      // 0ec: bipush 0
      // 0ed: invokestatic com/segment/analytics/QueueFile.readInt ([BI)I
      // 0f0: istore 5
      // 0f2: iinc 2 1
      // 0f5: goto 0c3
      // 0f8: aload 0
      // 0f9: aload 0
      // 0fa: getfield com/segment/analytics/QueueFile.fileLength I
      // 0fd: aload 0
      // 0fe: getfield com/segment/analytics/QueueFile.elementCount I
      // 101: iload 1
      // 102: isub
      // 103: iload 4
      // 105: aload 0
      // 106: getfield com/segment/analytics/QueueFile.last Lcom/segment/analytics/QueueFile$Element;
      // 109: getfield com/segment/analytics/QueueFile$Element.position I
      // 10c: invokespecial com/segment/analytics/QueueFile.writeHeader (IIII)V
      // 10f: aload 0
      // 110: aload 0
      // 111: getfield com/segment/analytics/QueueFile.elementCount I
      // 114: iload 1
      // 115: isub
      // 116: putfield com/segment/analytics/QueueFile.elementCount I
      // 119: new com/segment/analytics/QueueFile$Element
      // 11c: astore 7
      // 11e: aload 7
      // 120: iload 4
      // 122: iload 5
      // 124: invokespecial com/segment/analytics/QueueFile$Element.<init> (II)V
      // 127: aload 0
      // 128: aload 7
      // 12a: putfield com/segment/analytics/QueueFile.first Lcom/segment/analytics/QueueFile$Element;
      // 12d: aload 0
      // 12e: iload 6
      // 130: iload 3
      // 131: invokespecial com/segment/analytics/QueueFile.ringErase (II)V
      // 134: goto 053
      // try (4 -> 13): 13 null
      // try (20 -> 38): 13 null
      // try (43 -> 49): 13 null
      // try (50 -> 77): 13 null
      // try (77 -> 89): 13 null
      // try (100 -> 120): 13 null
      // try (122 -> 153): 13 null
   }

   void ringRead(int var1, byte[] var2, int var3, int var4) throws IOException {
      int var5 = this.wrapPosition(var1);
      if (var5 + var4 <= this.fileLength) {
         this.raf.seek(var5);
         this.raf.readFully(var2, var3, var4);
      } else {
         var1 = this.fileLength - var5;
         this.raf.seek(var5);
         this.raf.readFully(var2, var3, var1);
         this.raf.seek(16L);
         this.raf.readFully(var2, var3 + var1, var4 - var1);
      }
   }

   public int size() {
      synchronized (this) {
         return this.elementCount;
      }
   }

   @Override
   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append(this.getClass().getSimpleName()).append('[');
      var1.append("fileLength=").append(this.fileLength);
      var1.append(", size=").append(this.elementCount);
      var1.append(", first=").append(this.first);
      var1.append(", last=").append(this.last);
      var1.append(", element lengths=[");

      try {
         PayloadQueue.ElementVisitor var2 = new PayloadQueue.ElementVisitor(this, var1) {
            boolean first;
            final QueueFile this$0;
            final StringBuilder val$builder;

            {
               this.this$0 = var1;
               this.val$builder = var2x;
               this.first = true;
            }

            @Override
            public boolean read(InputStream var1, int var2x) throws IOException {
               if (this.first) {
                  this.first = false;
               } else {
                  this.val$builder.append(", ");
               }

               this.val$builder.append(var2x);
               return true;
            }
         };
         this.forEach(var2);
      } catch (IOException var3) {
         LOGGER.log(Level.WARNING, "read error", var3);
      }

      var1.append("]]");
      return var1.toString();
   }

   int wrapPosition(int var1) {
      if (var1 >= this.fileLength) {
         var1 = var1 + 16 - this.fileLength;
      }

      return var1;
   }

   static class Element {
      static final int HEADER_LENGTH = 4;
      static final QueueFile.Element NULL = new QueueFile.Element(0, 0);
      final int length;
      final int position;

      Element(int var1, int var2) {
         this.position = var1;
         this.length = var2;
      }

      @Override
      public String toString() {
         return this.getClass().getSimpleName() + "[position = " + this.position + ", length = " + this.length + "]";
      }
   }

   final class ElementInputStream extends InputStream {
      private int position;
      private int remaining;
      final QueueFile this$0;

      ElementInputStream(QueueFile var1, QueueFile.Element var2) {
         this.this$0 = var1;
         this.position = var1.wrapPosition(var2.position + 4);
         this.remaining = var2.length;
      }

      @Override
      public int read() throws IOException {
         int var1;
         if (this.remaining == 0) {
            var1 = -1;
         } else {
            this.this$0.raf.seek(this.position);
            var1 = this.this$0.raf.read();
            this.position = this.this$0.wrapPosition(this.position + 1);
            this.remaining--;
         }

         return var1;
      }

      @Override
      public int read(byte[] var1, int var2, int var3) throws IOException {
         if ((var2 | var3) >= 0 && var3 <= var1.length - var2) {
            int var4;
            if (this.remaining == 0) {
               var4 = -1;
            } else {
               var4 = var3;
               if (var3 > this.remaining) {
                  var4 = this.remaining;
               }

               this.this$0.ringRead(this.position, var1, var2, var4);
               this.position = this.this$0.wrapPosition(this.position + var4);
               this.remaining -= var4;
            }

            return var4;
         } else {
            throw new ArrayIndexOutOfBoundsException();
         }
      }
   }
}
