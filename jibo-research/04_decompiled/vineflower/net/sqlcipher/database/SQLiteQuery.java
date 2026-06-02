package net.sqlcipher.database;

import net.sqlcipher.CursorWindow;

public class SQLiteQuery extends SQLiteProgram {
   private static final String TAG = "Cursor";
   private String[] mBindArgs;
   private Object[] mObjectBindArgs;
   private int mOffsetIndex;

   SQLiteQuery(SQLiteDatabase var1, String var2, int var3, Object[] var4) {
      super(var1, var2);
      this.mOffsetIndex = var3;
      this.mObjectBindArgs = var4;
      if (this.mObjectBindArgs != null) {
         var3 = this.mObjectBindArgs.length;
      } else {
         var3 = 0;
      }

      this.mBindArgs = new String[var3];
   }

   SQLiteQuery(SQLiteDatabase var1, String var2, int var3, String[] var4) {
      super(var1, var2);
      this.mOffsetIndex = var3;
      this.mBindArgs = var4;
   }

   private final native int native_column_count();

   private final native String native_column_name(int var1);

   private final native int native_fill_window(CursorWindow var1, int var2, int var3, int var4, int var5);

   public void bindArguments(Object[] var1) {
      if (var1 != null && var1.length > 0) {
         for (int var2 = 0; var2 < var1.length; var2++) {
            Object var5 = var1[var2];
            if (var5 == null) {
               this.bindNull(var2 + 1);
            } else if (var5 instanceof Double) {
               this.bindDouble(var2 + 1, (Double)var5);
            } else if (var5 instanceof Float) {
               this.bindDouble(var2 + 1, Double.valueOf((double)((Number)var5).floatValue()));
            } else if (var5 instanceof Long) {
               this.bindLong(var2 + 1, (Long)var5);
            } else if (var5 instanceof Integer) {
               this.bindLong(var2 + 1, Long.valueOf((long)((Number)var5).intValue()));
            } else if (var5 instanceof Boolean) {
               long var3;
               if ((Boolean)var5) {
                  var3 = 1L;
               } else {
                  var3 = 0L;
               }

               this.bindLong(var2 + 1, var3);
            } else if (var5 instanceof byte[]) {
               this.bindBlob(var2 + 1, (byte[])var5);
            } else {
               this.bindString(var2 + 1, var5.toString());
            }
         }
      }
   }

   @Override
   public void bindDouble(int var1, double var2) {
      this.mBindArgs[var1 - 1] = Double.toString(var2);
      if (!this.mClosed) {
         super.bindDouble(var1, var2);
      }
   }

   @Override
   public void bindLong(int var1, long var2) {
      this.mBindArgs[var1 - 1] = Long.toString(var2);
      if (!this.mClosed) {
         super.bindLong(var1, var2);
      }
   }

   @Override
   public void bindNull(int var1) {
      this.mBindArgs[var1 - 1] = null;
      if (!this.mClosed) {
         super.bindNull(var1);
      }
   }

   @Override
   public void bindString(int var1, String var2) {
      this.mBindArgs[var1 - 1] = var2;
      if (!this.mClosed) {
         super.bindString(var1, var2);
      }
   }

   int columnCountLocked() {
      this.acquireReference();

      try {
         return this.native_column_count();
      } finally {
         this.releaseReference();
      }
   }

   String columnNameLocked(int var1) {
      this.acquireReference();

      try {
         return this.native_column_name(var1);
      } finally {
         this.releaseReference();
      }
   }

   int fillWindow(CursorWindow param1, int param2, int param3) {
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
      // 00: invokestatic android/os/SystemClock.uptimeMillis ()J
      // 03: pop2
      // 04: aload 0
      // 05: getfield net/sqlcipher/database/SQLiteQuery.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 08: invokevirtual net/sqlcipher/database/SQLiteDatabase.lock ()V
      // 0b: aload 0
      // 0c: invokevirtual net/sqlcipher/database/SQLiteQuery.acquireReference ()V
      // 0f: aload 1
      // 10: invokevirtual net/sqlcipher/CursorWindow.acquireReference ()V
      // 13: aload 0
      // 14: aload 1
      // 15: aload 1
      // 16: invokevirtual net/sqlcipher/CursorWindow.getStartPosition ()I
      // 19: aload 0
      // 1a: getfield net/sqlcipher/database/SQLiteQuery.mOffsetIndex I
      // 1d: iload 2
      // 1e: iload 3
      // 1f: invokespecial net/sqlcipher/database/SQLiteQuery.native_fill_window (Lnet/sqlcipher/CursorWindow;IIII)I
      // 22: istore 2
      // 23: getstatic net/sqlcipher/database/SQLiteDebug.DEBUG_SQL_STATEMENTS Z
      // 26: ifeq 4a
      // 29: new java/lang/StringBuilder
      // 2c: astore 4
      // 2e: aload 4
      // 30: invokespecial java/lang/StringBuilder.<init> ()V
      // 33: ldc "Cursor"
      // 35: aload 4
      // 37: ldc "fillWindow(): "
      // 39: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 3c: aload 0
      // 3d: getfield net/sqlcipher/database/SQLiteQuery.mSql Ljava/lang/String;
      // 40: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 43: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 46: invokestatic android/util/Log.d (Ljava/lang/String;Ljava/lang/String;)I
      // 49: pop
      // 4a: aload 1
      // 4b: invokevirtual net/sqlcipher/CursorWindow.releaseReference ()V
      // 4e: aload 0
      // 4f: invokevirtual net/sqlcipher/database/SQLiteQuery.releaseReference ()V
      // 52: aload 0
      // 53: getfield net/sqlcipher/database/SQLiteQuery.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 56: invokevirtual net/sqlcipher/database/SQLiteDatabase.unlock ()V
      // 59: iload 2
      // 5a: ireturn
      // 5b: astore 4
      // 5d: bipush 0
      // 5e: istore 2
      // 5f: aload 1
      // 60: invokevirtual net/sqlcipher/CursorWindow.releaseReference ()V
      // 63: aload 0
      // 64: invokevirtual net/sqlcipher/database/SQLiteQuery.releaseReference ()V
      // 67: aload 0
      // 68: getfield net/sqlcipher/database/SQLiteQuery.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 6b: invokevirtual net/sqlcipher/database/SQLiteDatabase.unlock ()V
      // 6e: goto 59
      // 71: astore 4
      // 73: aload 0
      // 74: getfield net/sqlcipher/database/SQLiteQuery.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 77: invokevirtual net/sqlcipher/database/SQLiteDatabase.onCorruption ()V
      // 7a: aload 4
      // 7c: athrow
      // 7d: astore 4
      // 7f: aload 1
      // 80: invokevirtual net/sqlcipher/CursorWindow.releaseReference ()V
      // 83: aload 4
      // 85: athrow
      // 86: astore 1
      // 87: aload 0
      // 88: invokevirtual net/sqlcipher/database/SQLiteQuery.releaseReference ()V
      // 8b: aload 0
      // 8c: getfield net/sqlcipher/database/SQLiteQuery.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 8f: invokevirtual net/sqlcipher/database/SQLiteDatabase.unlock ()V
      // 92: aload 1
      // 93: athrow
      // try (5 -> 7): 66 null
      // try (7 -> 35): 44 java/lang/IllegalStateException
      // try (7 -> 35): 55 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (7 -> 35): 61 null
      // try (35 -> 37): 66 null
      // try (47 -> 49): 66 null
      // try (56 -> 61): 61 null
      // try (62 -> 66): 66 null
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   void requery() {
      byte var2 = 0;
      if (this.mBindArgs != null) {
         int var3 = this.mBindArgs.length;

         int var1;
         StringBuilder var4;
         SQLiteMisuseException var5;
         label47: {
            try {
               if (this.mObjectBindArgs != null) {
                  this.bindArguments(this.mObjectBindArgs);
                  return;
               }
            } catch (SQLiteMisuseException var7) {
               var5 = var7;
               var4 = new StringBuilder("mSql " + this.mSql);
               var1 = var2;
               break label47;
            }

            var1 = 0;

            while (true) {
               if (var1 >= var3) {
                  return;
               }

               try {
                  super.bindString(var1 + 1, this.mBindArgs[var1]);
               } catch (SQLiteMisuseException var6) {
                  var5 = var6;
                  var4 = new StringBuilder("mSql " + this.mSql);
                  var1 = var2;
                  break;
               }

               var1++;
            }
         }

         while (var1 < var3) {
            var4.append(" ");
            var4.append(this.mBindArgs[var1]);
            var1++;
         }

         var4.append(" ");
         throw new IllegalStateException(var4.toString(), var5);
      }
   }

   @Override
   public String toString() {
      return "SQLiteQuery: " + this.mSql;
   }
}
