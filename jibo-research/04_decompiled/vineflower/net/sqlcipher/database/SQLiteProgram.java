package net.sqlcipher.database;

import android.util.Log;

public abstract class SQLiteProgram extends SQLiteClosable {
   private static final String TAG = "SQLiteProgram";
   boolean mClosed;
   private SQLiteCompiledSql mCompiledSql;
   @Deprecated
   protected SQLiteDatabase mDatabase;
   final String mSql;
   @Deprecated
   protected long nHandle = 0L;
   @Deprecated
   protected long nStatement = 0L;

   SQLiteProgram(SQLiteDatabase var1, String var2) {
      this.mClosed = false;
      this.mDatabase = var1;
      this.mSql = var2.trim();
      var1.acquireReference();
      var1.addSQLiteClosable(this);
      this.nHandle = var1.mNativeHandle;
      String var5;
      if (this.mSql.length() >= 6) {
         var5 = this.mSql.substring(0, 6);
      } else {
         var5 = this.mSql;
      }

      if (!var5.equalsIgnoreCase("INSERT")
         && !var5.equalsIgnoreCase("UPDATE")
         && !var5.equalsIgnoreCase("REPLAC")
         && !var5.equalsIgnoreCase("DELETE")
         && !var5.equalsIgnoreCase("SELECT")) {
         this.mCompiledSql = new SQLiteCompiledSql(var1, var2);
         this.nStatement = this.mCompiledSql.nStatement;
      } else {
         this.mCompiledSql = var1.getCompiledStatementForSql(var2);
         if (this.mCompiledSql == null) {
            this.mCompiledSql = new SQLiteCompiledSql(var1, var2);
            this.mCompiledSql.acquire();
            var1.addToCompiledQueries(var2, this.mCompiledSql);
            if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION) {
               Log.v("SQLiteProgram", "Created DbObj (id#" + this.mCompiledSql.nStatement + ") for sql: " + var2);
            }
         } else if (!this.mCompiledSql.acquire()) {
            long var3 = this.mCompiledSql.nStatement;
            this.mCompiledSql = new SQLiteCompiledSql(var1, var2);
            if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION) {
               Log.v(
                  "SQLiteProgram",
                  "** possible bug ** Created NEW DbObj (id#"
                     + this.mCompiledSql.nStatement
                     + ") because the previously created DbObj (id#"
                     + var3
                     + ") was not released for sql:"
                     + var2
               );
            }
         }

         this.nStatement = this.mCompiledSql.nStatement;
      }
   }

   private final native void native_clear_bindings();

   private void releaseCompiledSqlIfNotInCache() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.util.collections.fixed.FastFixedSet.contains(Object)" because "predset" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.lambda$removeErroneousNodes$1(FastExtendedPostdominanceHelper.java:231)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.iterateReachability(FastExtendedPostdominanceHelper.java:373)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.removeErroneousNodes(FastExtendedPostdominanceHelper.java:207)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.getExtendedPostdominators(FastExtendedPostdominanceHelper.java:63)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.findGeneralStatement(DomHelper.java:537)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.processStatement(DomHelper.java:472)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.processStatement(DomHelper.java:379)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:208)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield net/sqlcipher/database/SQLiteProgram.mCompiledSql Lnet/sqlcipher/database/SQLiteCompiledSql;
      // 04: ifnonnull 08
      // 07: return
      // 08: aload 0
      // 09: getfield net/sqlcipher/database/SQLiteProgram.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 0c: getfield net/sqlcipher/database/SQLiteDatabase.mCompiledQueries Ljava/util/Map;
      // 0f: astore 2
      // 10: aload 2
      // 11: monitorenter
      // 12: aload 0
      // 13: getfield net/sqlcipher/database/SQLiteProgram.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 16: getfield net/sqlcipher/database/SQLiteDatabase.mCompiledQueries Ljava/util/Map;
      // 19: aload 0
      // 1a: getfield net/sqlcipher/database/SQLiteProgram.mCompiledSql Lnet/sqlcipher/database/SQLiteCompiledSql;
      // 1d: invokeinterface java/util/Map.containsValue (Ljava/lang/Object;)Z 2
      // 22: ifne 40
      // 25: aload 0
      // 26: getfield net/sqlcipher/database/SQLiteProgram.mCompiledSql Lnet/sqlcipher/database/SQLiteCompiledSql;
      // 29: invokevirtual net/sqlcipher/database/SQLiteCompiledSql.releaseSqlStatement ()V
      // 2c: aload 0
      // 2d: aconst_null
      // 2e: putfield net/sqlcipher/database/SQLiteProgram.mCompiledSql Lnet/sqlcipher/database/SQLiteCompiledSql;
      // 31: aload 0
      // 32: lconst_0
      // 33: putfield net/sqlcipher/database/SQLiteProgram.nStatement J
      // 36: aload 2
      // 37: monitorexit
      // 38: goto 07
      // 3b: astore 1
      // 3c: aload 2
      // 3d: monitorexit
      // 3e: aload 1
      // 3f: athrow
      // 40: aload 0
      // 41: getfield net/sqlcipher/database/SQLiteProgram.mCompiledSql Lnet/sqlcipher/database/SQLiteCompiledSql;
      // 44: invokevirtual net/sqlcipher/database/SQLiteCompiledSql.release ()V
      // 47: goto 36
      // try (10 -> 26): 29 null
      // try (26 -> 28): 29 null
      // try (30 -> 32): 29 null
      // try (34 -> 37): 29 null
   }

   public void bindBlob(int var1, byte[] var2) {
      if (var2 == null) {
         throw new IllegalArgumentException("the bind value at index " + var1 + " is null");
      }

      if (this.mClosed) {
         throw new IllegalStateException("program already closed");
      }

      if (!this.mDatabase.isOpen()) {
         throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
      }

      this.acquireReference();

      try {
         this.native_bind_blob(var1, var2);
      } finally {
         this.releaseReference();
      }
   }

   public void bindDouble(int var1, double var2) {
      if (this.mClosed) {
         throw new IllegalStateException("program already closed");
      }

      if (!this.mDatabase.isOpen()) {
         throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
      }

      this.acquireReference();

      try {
         this.native_bind_double(var1, var2);
      } finally {
         this.releaseReference();
      }
   }

   public void bindLong(int var1, long var2) {
      if (this.mClosed) {
         throw new IllegalStateException("program already closed");
      }

      if (!this.mDatabase.isOpen()) {
         throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
      }

      this.acquireReference();

      try {
         this.native_bind_long(var1, var2);
      } finally {
         this.releaseReference();
      }
   }

   public void bindNull(int var1) {
      if (this.mClosed) {
         throw new IllegalStateException("program already closed");
      }

      if (!this.mDatabase.isOpen()) {
         throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
      }

      this.acquireReference();

      try {
         this.native_bind_null(var1);
      } finally {
         this.releaseReference();
      }
   }

   public void bindString(int var1, String var2) {
      if (var2 == null) {
         throw new IllegalArgumentException("the bind value at index " + var1 + " is null");
      }

      if (this.mClosed) {
         throw new IllegalStateException("program already closed");
      }

      if (!this.mDatabase.isOpen()) {
         throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
      }

      this.acquireReference();

      try {
         this.native_bind_string(var1, var2);
      } finally {
         this.releaseReference();
      }
   }

   public void clearBindings() {
      if (this.mClosed) {
         throw new IllegalStateException("program already closed");
      }

      if (!this.mDatabase.isOpen()) {
         throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
      }

      this.acquireReference();

      try {
         this.native_clear_bindings();
      } finally {
         this.releaseReference();
      }
   }

   public void close() {
      if (!this.mClosed && this.mDatabase.isOpen()) {
         this.mDatabase.lock();

         try {
            this.releaseReference();
         } finally {
            this.mDatabase.unlock();
         }

         this.mClosed = true;
      }
   }

   @Deprecated
   protected void compile(String var1, boolean var2) {
   }

   String getSqlString() {
      return this.mSql;
   }

   public final long getUniqueId() {
      return this.nStatement;
   }

   protected final native void native_bind_blob(int var1, byte[] var2);

   protected final native void native_bind_double(int var1, double var2);

   protected final native void native_bind_long(int var1, long var2);

   protected final native void native_bind_null(int var1);

   protected final native void native_bind_string(int var1, String var2);

   @Deprecated
   protected final native void native_compile(String var1);

   @Deprecated
   protected final native void native_finalize();

   @Override
   protected void onAllReferencesReleased() {
      this.releaseCompiledSqlIfNotInCache();
      this.mDatabase.releaseReference();
      this.mDatabase.removeSQLiteClosable(this);
   }

   @Override
   protected void onAllReferencesReleasedFromContainer() {
      this.releaseCompiledSqlIfNotInCache();
      this.mDatabase.releaseReference();
   }
}
