package com.google.android.gms.common.internal;

public abstract class zzi<TListener> {
   private TListener a;
   private boolean b;
   private zzd c;

   public zzi(TListener var1, Object var2) {
      this.c = var1;
      super();
      this.a = (TListener)var2;
      this.b = false;
   }

   protected abstract void a(TListener var1);

   public final void b() {
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
      // 03: getfield com/google/android/gms/common/internal/zzi.a Ljava/lang/Object;
      // 06: astore 2
      // 07: aload 0
      // 08: getfield com/google/android/gms/common/internal/zzi.b Z
      // 0b: ifeq 42
      // 0e: aload 0
      // 0f: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 12: astore 4
      // 14: aload 4
      // 16: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 19: invokevirtual java/lang/String.length ()I
      // 1c: istore 1
      // 1d: new java/lang/StringBuilder
      // 20: astore 3
      // 21: aload 3
      // 22: iload 1
      // 23: bipush 47
      // 25: iadd
      // 26: invokespecial java/lang/StringBuilder.<init> (I)V
      // 29: ldc "GmsClient"
      // 2b: aload 3
      // 2c: ldc "Callback proxy "
      // 2e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 31: aload 4
      // 33: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 36: ldc " being reused. This is not safe."
      // 38: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 3b: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 3e: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // 41: pop
      // 42: aload 0
      // 43: monitorexit
      // 44: aload 2
      // 45: ifnull 4d
      // 48: aload 0
      // 49: aload 2
      // 4a: invokevirtual com/google/android/gms/common/internal/zzi.a (Ljava/lang/Object;)V
      // 4d: aload 0
      // 4e: monitorenter
      // 4f: aload 0
      // 50: bipush 1
      // 51: putfield com/google/android/gms/common/internal/zzi.b Z
      // 54: aload 0
      // 55: monitorexit
      // 56: aload 0
      // 57: invokevirtual com/google/android/gms/common/internal/zzi.c ()V
      // 5a: return
      // 5b: astore 2
      // 5c: aload 0
      // 5d: monitorexit
      // 5e: aload 2
      // 5f: athrow
      // 60: astore 2
      // 61: aload 2
      // 62: athrow
      // 63: astore 2
      // 64: aload 0
      // 65: monitorexit
      // 66: aload 2
      // 67: athrow
      // try (2 -> 33): 50 null
      // try (33 -> 35): 50 null
      // try (37 -> 40): 55 java/lang/RuntimeException
      // try (42 -> 47): 58 null
      // try (51 -> 53): 50 null
      // try (59 -> 61): 58 null
   }

   public final void c() {
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
      // 01: invokevirtual com/google/android/gms/common/internal/zzi.d ()V
      // 04: aload 0
      // 05: getfield com/google/android/gms/common/internal/zzi.c Lcom/google/android/gms/common/internal/zzd;
      // 08: invokestatic com/google/android/gms/common/internal/zzd.f (Lcom/google/android/gms/common/internal/zzd;)Ljava/util/ArrayList;
      // 0b: astore 2
      // 0c: aload 2
      // 0d: monitorenter
      // 0e: aload 0
      // 0f: getfield com/google/android/gms/common/internal/zzi.c Lcom/google/android/gms/common/internal/zzd;
      // 12: invokestatic com/google/android/gms/common/internal/zzd.f (Lcom/google/android/gms/common/internal/zzd;)Ljava/util/ArrayList;
      // 15: aload 0
      // 16: invokevirtual java/util/ArrayList.remove (Ljava/lang/Object;)Z
      // 19: pop
      // 1a: aload 2
      // 1b: monitorexit
      // 1c: return
      // 1d: astore 1
      // 1e: aload 2
      // 1f: monitorexit
      // 20: aload 1
      // 21: athrow
      // try (8 -> 16): 17 null
      // try (18 -> 20): 17 null
   }

   public final void d() {
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
      // 0: aload 0
      // 1: monitorenter
      // 2: aload 0
      // 3: aconst_null
      // 4: putfield com/google/android/gms/common/internal/zzi.a Ljava/lang/Object;
      // 7: aload 0
      // 8: monitorexit
      // 9: return
      // a: astore 1
      // b: aload 0
      // c: monitorexit
      // d: aload 1
      // e: athrow
      // try (2 -> 7): 8 null
      // try (9 -> 11): 8 null
   }
}
