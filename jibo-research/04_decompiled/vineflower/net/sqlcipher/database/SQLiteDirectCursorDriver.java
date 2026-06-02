package net.sqlcipher.database;

import net.sqlcipher.Cursor;

public class SQLiteDirectCursorDriver implements SQLiteCursorDriver {
   private Cursor mCursor;
   private SQLiteDatabase mDatabase;
   private String mEditTable;
   private SQLiteQuery mQuery;
   private String mSql;

   public SQLiteDirectCursorDriver(SQLiteDatabase var1, String var2, String var3) {
      this.mDatabase = var1;
      this.mEditTable = var3;
      this.mSql = var2;
   }

   @Override
   public void cursorClosed() {
      this.mCursor = null;
   }

   @Override
   public void cursorDeactivated() {
   }

   @Override
   public void cursorRequeried(android.database.Cursor var1) {
   }

   public Cursor query(SQLiteDatabase.CursorFactory param1, Object[] param2) {
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
      // 00: new net/sqlcipher/database/SQLiteQuery
      // 03: dup
      // 04: aload 0
      // 05: getfield net/sqlcipher/database/SQLiteDirectCursorDriver.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 08: aload 0
      // 09: getfield net/sqlcipher/database/SQLiteDirectCursorDriver.mSql Ljava/lang/String;
      // 0c: bipush 0
      // 0d: aload 2
      // 0e: invokespecial net/sqlcipher/database/SQLiteQuery.<init> (Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;I[Ljava/lang/Object;)V
      // 11: astore 4
      // 13: aload 4
      // 15: astore 3
      // 16: aload 4
      // 18: aload 2
      // 19: invokevirtual net/sqlcipher/database/SQLiteQuery.bindArguments ([Ljava/lang/Object;)V
      // 1c: aload 1
      // 1d: ifnonnull 5f
      // 20: aload 4
      // 22: astore 3
      // 23: new net/sqlcipher/database/SQLiteCursor
      // 26: astore 1
      // 27: aload 4
      // 29: astore 3
      // 2a: aload 1
      // 2b: aload 0
      // 2c: getfield net/sqlcipher/database/SQLiteDirectCursorDriver.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 2f: aload 0
      // 30: aload 0
      // 31: getfield net/sqlcipher/database/SQLiteDirectCursorDriver.mEditTable Ljava/lang/String;
      // 34: aload 4
      // 36: invokespecial net/sqlcipher/database/SQLiteCursor.<init> (Lnet/sqlcipher/database/SQLiteDatabase;Lnet/sqlcipher/database/SQLiteCursorDriver;Ljava/lang/String;Lnet/sqlcipher/database/SQLiteQuery;)V
      // 39: aload 4
      // 3b: astore 3
      // 3c: aload 0
      // 3d: aload 1
      // 3e: putfield net/sqlcipher/database/SQLiteDirectCursorDriver.mCursor Lnet/sqlcipher/Cursor;
      // 41: aload 4
      // 43: astore 3
      // 44: aload 0
      // 45: aload 4
      // 47: putfield net/sqlcipher/database/SQLiteDirectCursorDriver.mQuery Lnet/sqlcipher/database/SQLiteQuery;
      // 4a: aconst_null
      // 4b: astore 3
      // 4c: aload 0
      // 4d: getfield net/sqlcipher/database/SQLiteDirectCursorDriver.mCursor Lnet/sqlcipher/Cursor;
      // 50: astore 1
      // 51: bipush 0
      // 52: ifeq 5d
      // 55: new java/lang/NullPointerException
      // 58: dup
      // 59: invokespecial java/lang/NullPointerException.<init> ()V
      // 5c: athrow
      // 5d: aload 1
      // 5e: areturn
      // 5f: aload 4
      // 61: astore 3
      // 62: aload 0
      // 63: aload 1
      // 64: aload 0
      // 65: getfield net/sqlcipher/database/SQLiteDirectCursorDriver.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 68: aload 0
      // 69: aload 0
      // 6a: getfield net/sqlcipher/database/SQLiteDirectCursorDriver.mEditTable Ljava/lang/String;
      // 6d: aload 4
      // 6f: invokeinterface net/sqlcipher/database/SQLiteDatabase$CursorFactory.newCursor (Lnet/sqlcipher/database/SQLiteDatabase;Lnet/sqlcipher/database/SQLiteCursorDriver;Ljava/lang/String;Lnet/sqlcipher/database/SQLiteQuery;)Lnet/sqlcipher/Cursor; 5
      // 74: putfield net/sqlcipher/database/SQLiteDirectCursorDriver.mCursor Lnet/sqlcipher/Cursor;
      // 77: goto 41
      // 7a: astore 1
      // 7b: aload 3
      // 7c: ifnull 83
      // 7f: aload 3
      // 80: invokevirtual net/sqlcipher/database/SQLiteQuery.close ()V
      // 83: aload 1
      // 84: athrow
      // try (12 -> 15): 67 null
      // try (19 -> 21): 67 null
      // try (23 -> 31): 67 null
      // try (33 -> 36): 67 null
      // try (38 -> 41): 67 null
      // try (43 -> 46): 67 null
      // try (56 -> 66): 67 null
   }

   @Override
   public Cursor query(SQLiteDatabase.CursorFactory param1, String[] param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 2 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1052)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:502)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 4
      // 03: new net/sqlcipher/database/SQLiteQuery
      // 06: dup
      // 07: aload 0
      // 08: getfield net/sqlcipher/database/SQLiteDirectCursorDriver.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 0b: aload 0
      // 0c: getfield net/sqlcipher/database/SQLiteDirectCursorDriver.mSql Ljava/lang/String;
      // 0f: bipush 0
      // 10: aload 2
      // 11: invokespecial net/sqlcipher/database/SQLiteQuery.<init> (Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;I[Ljava/lang/String;)V
      // 14: astore 5
      // 16: aload 2
      // 17: ifnonnull 35
      // 1a: bipush 0
      // 1b: istore 3
      // 1c: iload 4
      // 1e: iload 3
      // 1f: if_icmpge 3b
      // 22: aload 5
      // 24: iload 4
      // 26: bipush 1
      // 27: iadd
      // 28: aload 2
      // 29: iload 4
      // 2b: aaload
      // 2c: invokevirtual net/sqlcipher/database/SQLiteQuery.bindString (ILjava/lang/String;)V
      // 2f: iinc 4 1
      // 32: goto 1c
      // 35: aload 2
      // 36: arraylength
      // 37: istore 3
      // 38: goto 1c
      // 3b: aload 1
      // 3c: ifnonnull 72
      // 3f: new net/sqlcipher/database/SQLiteCursor
      // 42: astore 1
      // 43: aload 1
      // 44: aload 0
      // 45: getfield net/sqlcipher/database/SQLiteDirectCursorDriver.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 48: aload 0
      // 49: aload 0
      // 4a: getfield net/sqlcipher/database/SQLiteDirectCursorDriver.mEditTable Ljava/lang/String;
      // 4d: aload 5
      // 4f: invokespecial net/sqlcipher/database/SQLiteCursor.<init> (Lnet/sqlcipher/database/SQLiteDatabase;Lnet/sqlcipher/database/SQLiteCursorDriver;Ljava/lang/String;Lnet/sqlcipher/database/SQLiteQuery;)V
      // 52: aload 0
      // 53: aload 1
      // 54: putfield net/sqlcipher/database/SQLiteDirectCursorDriver.mCursor Lnet/sqlcipher/Cursor;
      // 57: aload 0
      // 58: aload 5
      // 5a: putfield net/sqlcipher/database/SQLiteDirectCursorDriver.mQuery Lnet/sqlcipher/database/SQLiteQuery;
      // 5d: aconst_null
      // 5e: astore 2
      // 5f: aload 0
      // 60: getfield net/sqlcipher/database/SQLiteDirectCursorDriver.mCursor Lnet/sqlcipher/Cursor;
      // 63: astore 1
      // 64: bipush 0
      // 65: ifeq 70
      // 68: new java/lang/NullPointerException
      // 6b: dup
      // 6c: invokespecial java/lang/NullPointerException.<init> ()V
      // 6f: athrow
      // 70: aload 1
      // 71: areturn
      // 72: aload 0
      // 73: aload 1
      // 74: aload 0
      // 75: getfield net/sqlcipher/database/SQLiteDirectCursorDriver.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 78: aload 0
      // 79: aload 0
      // 7a: getfield net/sqlcipher/database/SQLiteDirectCursorDriver.mEditTable Ljava/lang/String;
      // 7d: aload 5
      // 7f: invokeinterface net/sqlcipher/database/SQLiteDatabase$CursorFactory.newCursor (Lnet/sqlcipher/database/SQLiteDatabase;Lnet/sqlcipher/database/SQLiteCursorDriver;Ljava/lang/String;Lnet/sqlcipher/database/SQLiteQuery;)Lnet/sqlcipher/Cursor; 5
      // 84: putfield net/sqlcipher/database/SQLiteDirectCursorDriver.mCursor Lnet/sqlcipher/Cursor;
      // 87: goto 57
      // 8a: astore 1
      // 8b: aload 5
      // 8d: astore 2
      // 8e: aload 2
      // 8f: ifnull 96
      // 92: aload 2
      // 93: invokevirtual net/sqlcipher/database/SQLiteQuery.close ()V
      // 96: aload 1
      // 97: athrow
      // 98: astore 1
      // 99: goto 8e
      // try (19 -> 27): 75 null
      // try (29 -> 32): 75 null
      // try (35 -> 48): 75 null
      // try (48 -> 51): 75 null
      // try (53 -> 56): 84 null
      // try (64 -> 74): 75 null
   }

   @Override
   public void setBindArguments(String[] var1) {
      int var3 = var1.length;

      for (int var2 = 0; var2 < var3; var2++) {
         this.mQuery.bindString(var2 + 1, var1[var2]);
      }
   }

   @Override
   public String toString() {
      return "SQLiteDirectCursorDriver: " + this.mSql;
   }
}
