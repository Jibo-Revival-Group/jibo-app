package net.sqlcipher.database;

import android.util.Log;

class SQLiteCompiledSql {
   private static final String TAG = "SQLiteCompiledSql";
   SQLiteDatabase mDatabase;
   private boolean mInUse;
   private String mSqlStmt;
   private Throwable mStackTrace;
   long nHandle = 0L;
   long nStatement = 0L;

   SQLiteCompiledSql(SQLiteDatabase var1, String var2) {
      this.mSqlStmt = null;
      this.mStackTrace = null;
      this.mInUse = false;
      if (!var1.isOpen()) {
         throw new IllegalStateException("database " + var1.getPath() + " already closed");
      }

      this.mDatabase = var1;
      this.mSqlStmt = var2;
      this.mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
      this.nHandle = var1.mNativeHandle;
      this.compile(var2, true);
   }

   private void compile(String var1, boolean var2) {
      if (!this.mDatabase.isOpen()) {
         throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
      }

      if (var2) {
         this.mDatabase.lock();

         try {
            this.native_compile(var1);
         } finally {
            this.mDatabase.unlock();
         }
      }
   }

   private final native void native_compile(String var1);

   private final native void native_finalize();

   boolean acquire() {
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
      // 00: bipush 1
      // 01: istore 2
      // 02: aload 0
      // 03: monitorenter
      // 04: aload 0
      // 05: getfield net/sqlcipher/database/SQLiteCompiledSql.mInUse Z
      // 08: istore 1
      // 09: iload 1
      // 0a: ifeq 13
      // 0d: bipush 0
      // 0e: istore 1
      // 0f: aload 0
      // 10: monitorexit
      // 11: iload 1
      // 12: ireturn
      // 13: aload 0
      // 14: bipush 1
      // 15: putfield net/sqlcipher/database/SQLiteCompiledSql.mInUse Z
      // 18: iload 2
      // 19: istore 1
      // 1a: getstatic net/sqlcipher/database/SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION Z
      // 1d: ifeq 0f
      // 20: new java/lang/StringBuilder
      // 23: astore 3
      // 24: aload 3
      // 25: invokespecial java/lang/StringBuilder.<init> ()V
      // 28: ldc "SQLiteCompiledSql"
      // 2a: aload 3
      // 2b: ldc "Acquired DbObj (id#"
      // 2d: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 30: aload 0
      // 31: getfield net/sqlcipher/database/SQLiteCompiledSql.nStatement J
      // 34: invokevirtual java/lang/StringBuilder.append (J)Ljava/lang/StringBuilder;
      // 37: ldc ") from DB cache"
      // 39: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 3c: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 3f: invokestatic android/util/Log.v (Ljava/lang/String;Ljava/lang/String;)I
      // 42: pop
      // 43: iload 2
      // 44: istore 1
      // 45: goto 0f
      // 48: astore 3
      // 49: aload 0
      // 4a: monitorexit
      // 4b: aload 3
      // 4c: athrow
      // try (4 -> 7): 41 null
      // try (15 -> 18): 41 null
      // try (20 -> 38): 41 null
   }

   @Override
   protected void finalize() throws Throwable {
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
      // 00: bipush 100
      // 02: istore 2
      // 03: aload 0
      // 04: getfield net/sqlcipher/database/SQLiteCompiledSql.nStatement J
      // 07: lstore 3
      // 08: lload 3
      // 09: lconst_0
      // 0a: lcmp
      // 0b: ifne 13
      // 0e: aload 0
      // 0f: invokespecial java/lang/Object.finalize ()V
      // 12: return
      // 13: getstatic net/sqlcipher/database/SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION Z
      // 16: ifeq 3f
      // 19: new java/lang/StringBuilder
      // 1c: astore 5
      // 1e: aload 5
      // 20: invokespecial java/lang/StringBuilder.<init> ()V
      // 23: ldc "SQLiteCompiledSql"
      // 25: aload 5
      // 27: ldc "** warning ** Finalized DbObj (id#"
      // 29: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 2c: aload 0
      // 2d: getfield net/sqlcipher/database/SQLiteCompiledSql.nStatement J
      // 30: invokevirtual java/lang/StringBuilder.append (J)Ljava/lang/StringBuilder;
      // 33: ldc ")"
      // 35: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 38: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 3b: invokestatic android/util/Log.v (Ljava/lang/String;Ljava/lang/String;)I
      // 3e: pop
      // 3f: aload 0
      // 40: getfield net/sqlcipher/database/SQLiteCompiledSql.mSqlStmt Ljava/lang/String;
      // 43: invokevirtual java/lang/String.length ()I
      // 46: istore 1
      // 47: new java/lang/StringBuilder
      // 4a: astore 5
      // 4c: aload 5
      // 4e: invokespecial java/lang/StringBuilder.<init> ()V
      // 51: aload 5
      // 53: ldc "Releasing statement in a finalizer. Please ensure that you explicitly call close() on your cursor: "
      // 55: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 58: astore 6
      // 5a: aload 0
      // 5b: getfield net/sqlcipher/database/SQLiteCompiledSql.mSqlStmt Ljava/lang/String;
      // 5e: astore 5
      // 60: iload 1
      // 61: bipush 100
      // 63: if_icmple 8c
      // 66: iload 2
      // 67: istore 1
      // 68: ldc "SQLiteCompiledSql"
      // 6a: aload 6
      // 6c: aload 5
      // 6e: bipush 0
      // 6f: iload 1
      // 70: invokevirtual java/lang/String.substring (II)Ljava/lang/String;
      // 73: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 76: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 79: aload 0
      // 7a: getfield net/sqlcipher/database/SQLiteCompiledSql.mStackTrace Ljava/lang/Throwable;
      // 7d: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 80: pop
      // 81: aload 0
      // 82: invokevirtual net/sqlcipher/database/SQLiteCompiledSql.releaseSqlStatement ()V
      // 85: aload 0
      // 86: invokespecial java/lang/Object.finalize ()V
      // 89: goto 12
      // 8c: goto 68
      // 8f: astore 5
      // 91: aload 0
      // 92: invokespecial java/lang/Object.finalize ()V
      // 95: aload 5
      // 97: athrow
      // try (2 -> 5): 68 null
      // try (12 -> 30): 68 null
      // try (30 -> 45): 68 null
      // try (50 -> 64): 68 null
   }

   void release() {
      synchronized (this) {
         if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION) {
            StringBuilder var1 = new StringBuilder();
            Log.v("SQLiteCompiledSql", var1.append("Released DbObj (id#").append(this.nStatement).append(") back to DB cache").toString());
         }

         this.mInUse = false;
      }
   }

   void releaseSqlStatement() {
      if (this.nStatement != 0L) {
         if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION) {
            Log.v("SQLiteCompiledSql", "closed and deallocated DbObj (id#" + this.nStatement + ")");
         }

         try {
            this.mDatabase.lock();
            this.native_finalize();
            this.nStatement = 0L;
         } finally {
            this.mDatabase.unlock();
         }
      }
   }
}
