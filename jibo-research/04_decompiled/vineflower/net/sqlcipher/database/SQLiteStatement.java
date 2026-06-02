package net.sqlcipher.database;

import android.os.SystemClock;

public class SQLiteStatement extends SQLiteProgram {
   SQLiteStatement(SQLiteDatabase var1, String var2) {
      super(var1, var2);
   }

   private final native long native_1x1_long();

   private final native String native_1x1_string();

   private final native void native_execute();

   public void execute() {
      if (!this.mDatabase.isOpen()) {
         throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
      }

      SystemClock.uptimeMillis();
      this.mDatabase.lock();
      this.acquireReference();

      try {
         this.native_execute();
      } finally {
         this.releaseReference();
         this.mDatabase.unlock();
      }
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public long executeInsert() {
      if (!this.mDatabase.isOpen()) {
         throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
      }

      SystemClock.uptimeMillis();
      this.mDatabase.lock();
      this.acquireReference();
      boolean var5 = false /* VF: Semaphore variable */;

      long var1;
      label33: {
         try {
            var5 = true;
            this.native_execute();
            if (this.mDatabase.lastChangeCount() > 0) {
               var1 = this.mDatabase.lastInsertRow();
               var5 = false;
               break label33;
            }

            var5 = false;
         } finally {
            if (var5) {
               this.releaseReference();
               this.mDatabase.unlock();
            }
         }

         var1 = -1L;
      }

      this.releaseReference();
      this.mDatabase.unlock();
      return var1;
   }

   public int executeUpdateDelete() {
      if (!this.mDatabase.isOpen()) {
         throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
      }

      SystemClock.uptimeMillis();
      this.mDatabase.lock();
      this.acquireReference();

      try {
         this.native_execute();
         return this.mDatabase.lastChangeCount();
      } finally {
         this.releaseReference();
         this.mDatabase.unlock();
      }
   }

   public long simpleQueryForLong() {
      if (!this.mDatabase.isOpen()) {
         throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
      }

      SystemClock.uptimeMillis();
      this.mDatabase.lock();
      this.acquireReference();

      try {
         return this.native_1x1_long();
      } finally {
         this.releaseReference();
         this.mDatabase.unlock();
      }
   }

   public String simpleQueryForString() {
      if (!this.mDatabase.isOpen()) {
         throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
      }

      SystemClock.uptimeMillis();
      this.mDatabase.lock();
      this.acquireReference();

      try {
         return this.native_1x1_string();
      } finally {
         this.releaseReference();
         this.mDatabase.unlock();
      }
   }
}
