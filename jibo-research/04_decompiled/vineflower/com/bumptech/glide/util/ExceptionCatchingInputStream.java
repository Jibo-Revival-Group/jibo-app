package com.bumptech.glide.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

public class ExceptionCatchingInputStream extends InputStream {
   private static final Queue<ExceptionCatchingInputStream> a = Util.a(0);
   private InputStream b;
   private IOException c;

   ExceptionCatchingInputStream() {
   }

   public static ExceptionCatchingInputStream a(InputStream param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.processStatement(ExprProcessor.java:119)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.getFinallyInformation(FinallyProcessor.java:136)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:84)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: getstatic com/bumptech/glide/util/ExceptionCatchingInputStream.a Ljava/util/Queue;
      // 03: astore 1
      // 04: aload 1
      // 05: monitorenter
      // 06: getstatic com/bumptech/glide/util/ExceptionCatchingInputStream.a Ljava/util/Queue;
      // 09: invokeinterface java/util/Queue.poll ()Ljava/lang/Object; 1
      // 0e: checkcast com/bumptech/glide/util/ExceptionCatchingInputStream
      // 11: astore 2
      // 12: aload 1
      // 13: monitorexit
      // 14: aload 2
      // 15: astore 1
      // 16: aload 2
      // 17: ifnonnull 22
      // 1a: new com/bumptech/glide/util/ExceptionCatchingInputStream
      // 1d: dup
      // 1e: invokespecial com/bumptech/glide/util/ExceptionCatchingInputStream.<init> ()V
      // 21: astore 1
      // 22: aload 1
      // 23: aload 0
      // 24: invokevirtual com/bumptech/glide/util/ExceptionCatchingInputStream.b (Ljava/io/InputStream;)V
      // 27: aload 1
      // 28: areturn
      // 29: astore 0
      // 2a: aload 1
      // 2b: monitorexit
      // 2c: aload 0
      // 2d: athrow
      // try (4 -> 10): 23 null
      // try (24 -> 26): 23 null
   }

   public IOException a() {
      return this.c;
   }

   @Override
   public int available() throws IOException {
      return this.b.available();
   }

   public void b() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.processStatement(ExprProcessor.java:119)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.getFinallyInformation(FinallyProcessor.java:136)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:84)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: aconst_null
      // 02: putfield com/bumptech/glide/util/ExceptionCatchingInputStream.c Ljava/io/IOException;
      // 05: aload 0
      // 06: aconst_null
      // 07: putfield com/bumptech/glide/util/ExceptionCatchingInputStream.b Ljava/io/InputStream;
      // 0a: getstatic com/bumptech/glide/util/ExceptionCatchingInputStream.a Ljava/util/Queue;
      // 0d: astore 1
      // 0e: aload 1
      // 0f: monitorenter
      // 10: getstatic com/bumptech/glide/util/ExceptionCatchingInputStream.a Ljava/util/Queue;
      // 13: aload 0
      // 14: invokeinterface java/util/Queue.offer (Ljava/lang/Object;)Z 2
      // 19: pop
      // 1a: aload 1
      // 1b: monitorexit
      // 1c: return
      // 1d: astore 2
      // 1e: aload 1
      // 1f: monitorexit
      // 20: aload 2
      // 21: athrow
      // try (10 -> 16): 17 null
      // try (18 -> 20): 17 null
   }

   void b(InputStream var1) {
      this.b = var1;
   }

   @Override
   public void close() throws IOException {
      this.b.close();
   }

   @Override
   public void mark(int var1) {
      this.b.mark(var1);
   }

   @Override
   public boolean markSupported() {
      return this.b.markSupported();
   }

   @Override
   public int read() throws IOException {
      int var1;
      try {
         var1 = this.b.read();
      } catch (IOException var3) {
         this.c = var3;
         var1 = -1;
      }

      return var1;
   }

   @Override
   public int read(byte[] var1) throws IOException {
      int var2;
      try {
         var2 = this.b.read(var1);
      } catch (IOException var3) {
         this.c = var3;
         var2 = -1;
      }

      return var2;
   }

   @Override
   public int read(byte[] var1, int var2, int var3) throws IOException {
      try {
         var2 = this.b.read(var1, var2, var3);
      } catch (IOException var4) {
         this.c = var4;
         var2 = -1;
      }

      return var2;
   }

   @Override
   public void reset() throws IOException {
      synchronized (this) {
         this.b.reset();
      }
   }

   @Override
   public long skip(long var1) throws IOException {
      try {
         var1 = this.b.skip(var1);
      } catch (IOException var4) {
         this.c = var4;
         var1 = 0L;
      }

      return var1;
   }
}
