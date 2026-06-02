package com.fasterxml.jackson.core.sym;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.util.InternCache;
import java.util.Arrays;
import java.util.BitSet;

public final class CharsToNameCanonicalizer {
   static final CharsToNameCanonicalizer a = new CharsToNameCanonicalizer();
   protected CharsToNameCanonicalizer b;
   protected final int c;
   protected boolean d;
   protected String[] e;
   protected CharsToNameCanonicalizer.Bucket[] f;
   protected int g;
   protected int h;
   protected int i;
   protected int j;
   protected boolean k;
   protected BitSet l;
   private final int m;

   private CharsToNameCanonicalizer() {
      this.d = true;
      this.c = -1;
      this.k = true;
      this.m = 0;
      this.j = 0;
      this.e(64);
   }

   private CharsToNameCanonicalizer(
      CharsToNameCanonicalizer var1, int var2, String[] var3, CharsToNameCanonicalizer.Bucket[] var4, int var5, int var6, int var7
   ) {
      this.b = var1;
      this.c = var2;
      this.d = JsonFactory.Feature.CANONICALIZE_FIELD_NAMES.enabledIn(var2);
      this.e = var3;
      this.f = var4;
      this.g = var5;
      this.m = var6;
      var2 = var3.length;
      this.h = f(var2);
      this.i = var2 - 1;
      this.j = var7;
      this.k = false;
   }

   public static CharsToNameCanonicalizer a() {
      long var1 = System.currentTimeMillis();
      int var0 = (int)var1;
      return a((int)(var1 >>> 32) + var0 | 1);
   }

   protected static CharsToNameCanonicalizer a(int var0) {
      return a.g(var0);
   }

   private String a(char[] var1, int var2, int var3, int var4, int var5) {
      if (!this.k) {
         this.f();
         this.k = true;
      } else if (this.g >= this.h) {
         this.g();
         var5 = this.c(this.a(var1, var2, var3));
      }

      String var6 = new String(var1, var2, var3);
      String var7 = var6;
      if (JsonFactory.Feature.INTERN_FIELD_NAMES.enabledIn(this.c)) {
         var7 = InternCache.a.a(var6);
      }

      this.g++;
      if (this.e[var5] == null) {
         this.e[var5] = var7;
      } else {
         var2 = var5 >> 1;
         CharsToNameCanonicalizer.Bucket var10 = new CharsToNameCanonicalizer.Bucket(var7, this.f[var2]);
         var3 = var10.c;
         if (var3 > 100) {
            this.a(var2, var10);
         } else {
            this.f[var2] = var10;
            this.j = Math.max(var3, this.j);
         }
      }

      return var7;
   }

   private String a(char[] var1, int var2, int var3, CharsToNameCanonicalizer.Bucket var4) {
      while (true) {
         String var6;
         if (var4 != null) {
            String var5 = var4.a(var1, var2, var3);
            if (var5 == null) {
               var4 = var4.b;
               continue;
            }

            var6 = var5;
         } else {
            var6 = null;
         }

         return var6;
      }
   }

   private void a(int var1, CharsToNameCanonicalizer.Bucket var2) {
      if (this.l == null) {
         this.l = new BitSet();
         this.l.set(var1);
      } else if (this.l.get(var1)) {
         if (JsonFactory.Feature.FAIL_ON_SYMBOL_HASH_OVERFLOW.enabledIn(this.c)) {
            this.d(100);
         }

         this.d = false;
      } else {
         this.l.set(var1);
      }

      this.e[var1 + var1] = var2.a;
      this.f[var1] = null;
      this.g = this.g - var2.c;
      this.j = -1;
   }

   private void a(CharsToNameCanonicalizer param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
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
      // 00: aload 1
      // 01: invokevirtual com/fasterxml/jackson/core/sym/CharsToNameCanonicalizer.c ()I
      // 04: sipush 12000
      // 07: if_icmple 20
      // 0a: aload 0
      // 0b: monitorenter
      // 0c: aload 0
      // 0d: sipush 256
      // 10: invokespecial com/fasterxml/jackson/core/sym/CharsToNameCanonicalizer.e (I)V
      // 13: aload 0
      // 14: bipush 0
      // 15: putfield com/fasterxml/jackson/core/sym/CharsToNameCanonicalizer.k Z
      // 18: aload 0
      // 19: monitorexit
      // 1a: return
      // 1b: astore 1
      // 1c: aload 0
      // 1d: monitorexit
      // 1e: aload 1
      // 1f: athrow
      // 20: aload 1
      // 21: invokevirtual com/fasterxml/jackson/core/sym/CharsToNameCanonicalizer.c ()I
      // 24: aload 0
      // 25: invokevirtual com/fasterxml/jackson/core/sym/CharsToNameCanonicalizer.c ()I
      // 28: if_icmple 1a
      // 2b: aload 0
      // 2c: monitorenter
      // 2d: aload 0
      // 2e: aload 1
      // 2f: getfield com/fasterxml/jackson/core/sym/CharsToNameCanonicalizer.e [Ljava/lang/String;
      // 32: putfield com/fasterxml/jackson/core/sym/CharsToNameCanonicalizer.e [Ljava/lang/String;
      // 35: aload 0
      // 36: aload 1
      // 37: getfield com/fasterxml/jackson/core/sym/CharsToNameCanonicalizer.f [Lcom/fasterxml/jackson/core/sym/CharsToNameCanonicalizer$Bucket;
      // 3a: putfield com/fasterxml/jackson/core/sym/CharsToNameCanonicalizer.f [Lcom/fasterxml/jackson/core/sym/CharsToNameCanonicalizer$Bucket;
      // 3d: aload 0
      // 3e: aload 1
      // 3f: getfield com/fasterxml/jackson/core/sym/CharsToNameCanonicalizer.g I
      // 42: putfield com/fasterxml/jackson/core/sym/CharsToNameCanonicalizer.g I
      // 45: aload 0
      // 46: aload 1
      // 47: getfield com/fasterxml/jackson/core/sym/CharsToNameCanonicalizer.h I
      // 4a: putfield com/fasterxml/jackson/core/sym/CharsToNameCanonicalizer.h I
      // 4d: aload 0
      // 4e: aload 1
      // 4f: getfield com/fasterxml/jackson/core/sym/CharsToNameCanonicalizer.i I
      // 52: putfield com/fasterxml/jackson/core/sym/CharsToNameCanonicalizer.i I
      // 55: aload 0
      // 56: aload 1
      // 57: getfield com/fasterxml/jackson/core/sym/CharsToNameCanonicalizer.j I
      // 5a: putfield com/fasterxml/jackson/core/sym/CharsToNameCanonicalizer.j I
      // 5d: aload 0
      // 5e: bipush 0
      // 5f: putfield com/fasterxml/jackson/core/sym/CharsToNameCanonicalizer.k Z
      // 62: aload 0
      // 63: monitorexit
      // 64: goto 1a
      // 67: astore 1
      // 68: aload 0
      // 69: monitorexit
      // 6a: aload 1
      // 6b: athrow
      // try (6 -> 14): 15 null
      // try (16 -> 18): 15 null
      // try (27 -> 56): 57 null
      // try (58 -> 60): 57 null
   }

   private void e(int var1) {
      this.e = new String[var1];
      this.f = new CharsToNameCanonicalizer.Bucket[var1 >> 1];
      this.i = var1 - 1;
      this.g = 0;
      this.j = 0;
      this.h = f(var1);
   }

   private static int f(int var0) {
      return var0 - (var0 >> 2);
   }

   private void f() {
      String[] var1 = this.e;
      this.e = Arrays.copyOf(var1, var1.length);
      CharsToNameCanonicalizer.Bucket[] var2 = this.f;
      this.f = Arrays.copyOf(var2, var2.length);
   }

   private CharsToNameCanonicalizer g(int var1) {
      return new CharsToNameCanonicalizer(null, -1, this.e, this.f, this.g, var1, this.j);
   }

   private void g() {
      int var6 = this.e.length;
      int var1 = var6 + var6;
      if (var1 > 65536) {
         this.g = 0;
         this.d = false;
         this.e = new String[64];
         this.f = new CharsToNameCanonicalizer.Bucket[32];
         this.i = 63;
         this.k = true;
      } else {
         String[] var7 = this.e;
         CharsToNameCanonicalizer.Bucket[] var8 = this.f;
         this.e = new String[var1];
         this.f = new CharsToNameCanonicalizer.Bucket[var1 >> 1];
         this.i = var1 - 1;
         this.h = f(var1);
         int var3 = 0;
         var1 = 0;
         int var2 = 0;

         while (var3 < var6) {
            String var9 = var7[var3];
            int var4 = var1;
            int var5 = var2;
            if (var9 != null) {
               var5 = var2 + 1;
               var2 = this.c(this.a(var9));
               if (this.e[var2] == null) {
                  this.e[var2] = var9;
                  var4 = var1;
               } else {
                  var2 >>= 1;
                  CharsToNameCanonicalizer.Bucket var19 = new CharsToNameCanonicalizer.Bucket(var9, this.f[var2]);
                  this.f[var2] = var19;
                  var4 = Math.max(var1, var19.c);
               }
            }

            var3++;
            var1 = var4;
            var2 = var5;
         }

         int var15 = 0;
         var3 = var2;

         for (int var13 = var15; var13 < var6 >> 1; var13++) {
            for (CharsToNameCanonicalizer.Bucket var18 = var8[var13]; var18 != null; var18 = var18.b) {
               var3++;
               String var20 = var18.a;
               var15 = this.c(this.a(var20));
               if (this.e[var15] == null) {
                  this.e[var15] = var20;
               } else {
                  var15 >>= 1;
                  CharsToNameCanonicalizer.Bucket var21 = new CharsToNameCanonicalizer.Bucket(var20, this.f[var15]);
                  this.f[var15] = var21;
                  var1 = Math.max(var1, var21.c);
               }
            }
         }

         this.j = var1;
         this.l = null;
         if (var3 != this.g) {
            throw new Error("Internal error on SymbolTable.rehash(): had " + this.g + " entries; now have " + var3 + ".");
         }
      }
   }

   public int a(String var1) {
      int var4 = var1.length();
      int var2 = this.m;
      int var3 = 0;

      while (var3 < var4) {
         char var5 = var1.charAt(var3);
         var3++;
         var2 = var5 + var2 * 33;
      }

      var3 = var2;
      if (var2 == 0) {
         var3 = 1;
      }

      return var3;
   }

   public int a(char[] var1, int var2, int var3) {
      int var4 = this.m;

      for (int var5 = var2; var5 < var2 + var3; var5++) {
         var4 = var4 * 33 + var1[var5];
      }

      var2 = var4;
      if (var4 == 0) {
         var2 = 1;
      }

      return var2;
   }

   public String a(char[] var1, int var2, int var3, int var4) {
      String var8;
      if (var3 < 1) {
         var8 = "";
      } else if (!this.d) {
         var8 = new String(var1, var2, var3);
      } else {
         int var7 = this.c(var4);
         var8 = this.e[var7];
         if (var8 != null) {
            if (var8.length() == var3) {
               int var5 = 0;

               while (var8.charAt(var5) == var1[var2 + var5]) {
                  int var6 = var5 + 1;
                  var5 = var6;
                  if (var6 == var3) {
                     return var8;
                  }
               }
            }

            CharsToNameCanonicalizer.Bucket var10 = this.f[var7 >> 1];
            if (var10 != null) {
               String var9 = var10.a(var1, var2, var3);
               var8 = var9;
               if (var9 != null) {
                  return var8;
               }

               var9 = this.a(var1, var2, var3, var10.b);
               var8 = var9;
               if (var9 != null) {
                  return var8;
               }
            }
         }

         var8 = this.a(var1, var2, var3, var4, var7);
      }

      return var8;
   }

   public CharsToNameCanonicalizer b(int param1) {
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
      // 01: monitorenter
      // 02: aload 0
      // 03: getfield com/fasterxml/jackson/core/sym/CharsToNameCanonicalizer.e [Ljava/lang/String;
      // 06: astore 5
      // 08: aload 0
      // 09: getfield com/fasterxml/jackson/core/sym/CharsToNameCanonicalizer.f [Lcom/fasterxml/jackson/core/sym/CharsToNameCanonicalizer$Bucket;
      // 0c: astore 6
      // 0e: aload 0
      // 0f: getfield com/fasterxml/jackson/core/sym/CharsToNameCanonicalizer.g I
      // 12: istore 2
      // 13: aload 0
      // 14: getfield com/fasterxml/jackson/core/sym/CharsToNameCanonicalizer.m I
      // 17: istore 4
      // 19: aload 0
      // 1a: getfield com/fasterxml/jackson/core/sym/CharsToNameCanonicalizer.j I
      // 1d: istore 3
      // 1e: aload 0
      // 1f: monitorexit
      // 20: new com/fasterxml/jackson/core/sym/CharsToNameCanonicalizer
      // 23: dup
      // 24: aload 0
      // 25: iload 1
      // 26: aload 5
      // 28: aload 6
      // 2a: iload 2
      // 2b: iload 4
      // 2d: iload 3
      // 2e: invokespecial com/fasterxml/jackson/core/sym/CharsToNameCanonicalizer.<init> (Lcom/fasterxml/jackson/core/sym/CharsToNameCanonicalizer;I[Ljava/lang/String;[Lcom/fasterxml/jackson/core/sym/CharsToNameCanonicalizer$Bucket;III)V
      // 31: areturn
      // 32: astore 5
      // 34: aload 0
      // 35: monitorexit
      // 36: aload 5
      // 38: athrow
      // try (2 -> 19): 30 null
      // try (31 -> 33): 30 null
   }

   public void b() {
      if (this.d() && this.b != null && this.d) {
         this.b.a(this);
         this.k = false;
      }
   }

   public int c() {
      return this.g;
   }

   public int c(int var1) {
      var1 = (var1 >>> 15) + var1;
      var1 ^= var1 << 7;
      return var1 + (var1 >>> 3) & this.i;
   }

   protected void d(int var1) {
      throw new IllegalStateException(
         "Longest collision chain in symbol table (of size " + this.g + ") now exceeds maximum, " + var1 + " -- suspect a DoS attack based on hash collisions"
      );
   }

   public boolean d() {
      return this.k;
   }

   public int e() {
      return this.m;
   }

   static final class Bucket {
      public final String a;
      public final CharsToNameCanonicalizer.Bucket b;
      public final int c;

      public Bucket(String var1, CharsToNameCanonicalizer.Bucket var2) {
         this.a = var1;
         this.b = var2;
         int var3;
         if (var2 == null) {
            var3 = 1;
         } else {
            var3 = var2.c + 1;
         }

         this.c = var3;
      }

      public String a(char[] var1, int var2, int var3) {
         Object var6;
         if (this.a.length() != var3) {
            var6 = null;
         } else {
            int var4 = 0;

            while (this.a.charAt(var4) == var1[var2 + var4]) {
               int var5 = var4 + 1;
               var4 = var5;
               if (var5 >= var3) {
                  var6 = this.a;
                  return var6;
               }
            }

            var6 = null;
         }

         return var6;
      }
   }
}
