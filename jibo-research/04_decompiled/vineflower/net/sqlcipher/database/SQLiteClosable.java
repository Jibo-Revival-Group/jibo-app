package net.sqlcipher.database;

public abstract class SQLiteClosable {
   private Object mLock;
   private int mReferenceCount = 1;

   public SQLiteClosable() {
      this.mLock = new Object();
   }

   private String getObjInfo() {
      StringBuilder var1 = new StringBuilder();
      var1.append(this.getClass().getName());
      var1.append(" (");
      if (this instanceof SQLiteDatabase) {
         var1.append("database = ");
         var1.append(((SQLiteDatabase)this).getPath());
      } else if (this instanceof SQLiteProgram || this instanceof SQLiteStatement || this instanceof SQLiteQuery) {
         var1.append("mSql = ");
         var1.append(((SQLiteProgram)this).mSql);
      }

      var1.append(") ");
      return var1.toString();
   }

   public void acquireReference() {
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
      // 01: getfield net/sqlcipher/database/SQLiteClosable.mLock Ljava/lang/Object;
      // 04: astore 1
      // 05: aload 1
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield net/sqlcipher/database/SQLiteClosable.mReferenceCount I
      // 0b: ifgt 35
      // 0e: new java/lang/IllegalStateException
      // 11: astore 2
      // 12: new java/lang/StringBuilder
      // 15: astore 3
      // 16: aload 3
      // 17: invokespecial java/lang/StringBuilder.<init> ()V
      // 1a: aload 2
      // 1b: aload 3
      // 1c: ldc "attempt to re-open an already-closed object: "
      // 1e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 21: aload 0
      // 22: invokespecial net/sqlcipher/database/SQLiteClosable.getObjInfo ()Ljava/lang/String;
      // 25: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 28: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 2b: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 2e: aload 2
      // 2f: athrow
      // 30: astore 2
      // 31: aload 1
      // 32: monitorexit
      // 33: aload 2
      // 34: athrow
      // 35: aload 0
      // 36: aload 0
      // 37: getfield net/sqlcipher/database/SQLiteClosable.mReferenceCount I
      // 3a: bipush 1
      // 3b: iadd
      // 3c: putfield net/sqlcipher/database/SQLiteClosable.mReferenceCount I
      // 3f: aload 1
      // 40: monitorexit
      // 41: return
      // try (5 -> 25): 25 null
      // try (26 -> 28): 25 null
      // try (30 -> 38): 25 null
   }

   protected abstract void onAllReferencesReleased();

   protected void onAllReferencesReleasedFromContainer() {
   }

   public void releaseReference() {
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
      // 01: getfield net/sqlcipher/database/SQLiteClosable.mLock Ljava/lang/Object;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 0
      // 08: aload 0
      // 09: getfield net/sqlcipher/database/SQLiteClosable.mReferenceCount I
      // 0c: bipush 1
      // 0d: isub
      // 0e: putfield net/sqlcipher/database/SQLiteClosable.mReferenceCount I
      // 11: aload 0
      // 12: getfield net/sqlcipher/database/SQLiteClosable.mReferenceCount I
      // 15: ifne 1c
      // 18: aload 0
      // 19: invokevirtual net/sqlcipher/database/SQLiteClosable.onAllReferencesReleased ()V
      // 1c: aload 2
      // 1d: monitorexit
      // 1e: return
      // 1f: astore 1
      // 20: aload 2
      // 21: monitorexit
      // 22: aload 1
      // 23: athrow
      // try (5 -> 16): 19 null
      // try (16 -> 18): 19 null
      // try (20 -> 22): 19 null
   }

   public void releaseReferenceFromContainer() {
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
      // 01: getfield net/sqlcipher/database/SQLiteClosable.mLock Ljava/lang/Object;
      // 04: astore 1
      // 05: aload 1
      // 06: monitorenter
      // 07: aload 0
      // 08: aload 0
      // 09: getfield net/sqlcipher/database/SQLiteClosable.mReferenceCount I
      // 0c: bipush 1
      // 0d: isub
      // 0e: putfield net/sqlcipher/database/SQLiteClosable.mReferenceCount I
      // 11: aload 0
      // 12: getfield net/sqlcipher/database/SQLiteClosable.mReferenceCount I
      // 15: ifne 1c
      // 18: aload 0
      // 19: invokevirtual net/sqlcipher/database/SQLiteClosable.onAllReferencesReleasedFromContainer ()V
      // 1c: aload 1
      // 1d: monitorexit
      // 1e: return
      // 1f: astore 2
      // 20: aload 1
      // 21: monitorexit
      // 22: aload 2
      // 23: athrow
      // try (5 -> 16): 19 null
      // try (16 -> 18): 19 null
      // try (20 -> 22): 19 null
   }
}
