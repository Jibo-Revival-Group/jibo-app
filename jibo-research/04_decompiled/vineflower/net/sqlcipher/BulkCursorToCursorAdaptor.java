package net.sqlcipher;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import java.util.Map;

public final class BulkCursorToCursorAdaptor extends AbstractWindowedCursor {
   private static final String TAG = "BulkCursor";
   private IBulkCursor mBulkCursor;
   private String[] mColumns;
   private int mCount;
   private AbstractCursor.SelfContentObserver mObserverBridge;
   private boolean mWantsAllOnMoveCalls;

   public static int findRowIdColumnIndex(String[] var0) {
      int var2 = var0.length;
      int var1 = 0;

      while (true) {
         if (var1 >= var2) {
            var1 = -1;
            break;
         }

         if (var0[var1].equals("_id")) {
            break;
         }

         var1++;
      }

      return var1;
   }

   @Override
   public void close() {
      super.close();

      try {
         this.mBulkCursor.close();
      } catch (RemoteException var2) {
         Log.w("BulkCursor", "Remote process exception when closing");
      }

      this.mWindow = null;
   }

   @Override
   public boolean commitUpdates(Map<? extends Long, ? extends Map<String, Object>> param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 3
      // 02: aload 0
      // 03: invokevirtual net/sqlcipher/BulkCursorToCursorAdaptor.supportsUpdates ()Z
      // 06: ifne 15
      // 09: ldc "BulkCursor"
      // 0b: ldc "commitUpdates not supported on this cursor, did you include the _id column?"
      // 0d: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;)I
      // 10: pop
      // 11: iload 3
      // 12: istore 2
      // 13: iload 2
      // 14: ireturn
      // 15: aload 0
      // 16: getfield net/sqlcipher/BulkCursorToCursorAdaptor.mUpdatedRows Ljava/util/HashMap;
      // 19: astore 4
      // 1b: aload 4
      // 1d: monitorenter
      // 1e: aload 1
      // 1f: ifnull 2a
      // 22: aload 0
      // 23: getfield net/sqlcipher/BulkCursorToCursorAdaptor.mUpdatedRows Ljava/util/HashMap;
      // 26: aload 1
      // 27: invokevirtual java/util/HashMap.putAll (Ljava/util/Map;)V
      // 2a: aload 0
      // 2b: getfield net/sqlcipher/BulkCursorToCursorAdaptor.mUpdatedRows Ljava/util/HashMap;
      // 2e: invokevirtual java/util/HashMap.size ()I
      // 31: ifgt 42
      // 34: aload 4
      // 36: monitorexit
      // 37: iload 3
      // 38: istore 2
      // 39: goto 13
      // 3c: astore 1
      // 3d: aload 4
      // 3f: monitorexit
      // 40: aload 1
      // 41: athrow
      // 42: aload 0
      // 43: getfield net/sqlcipher/BulkCursorToCursorAdaptor.mBulkCursor Lnet/sqlcipher/IBulkCursor;
      // 46: aload 0
      // 47: getfield net/sqlcipher/BulkCursorToCursorAdaptor.mUpdatedRows Ljava/util/HashMap;
      // 4a: invokeinterface net/sqlcipher/IBulkCursor.updateRows (Ljava/util/Map;)Z 2
      // 4f: istore 2
      // 50: iload 2
      // 51: bipush 1
      // 52: if_icmpne 61
      // 55: aload 0
      // 56: getfield net/sqlcipher/BulkCursorToCursorAdaptor.mUpdatedRows Ljava/util/HashMap;
      // 59: invokevirtual java/util/HashMap.clear ()V
      // 5c: aload 0
      // 5d: bipush 1
      // 5e: invokevirtual net/sqlcipher/BulkCursorToCursorAdaptor.onChange (Z)V
      // 61: aload 4
      // 63: monitorexit
      // 64: goto 13
      // 67: astore 1
      // 68: ldc "BulkCursor"
      // 6a: ldc "Unable to commit updates because the remote process is dead"
      // 6c: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;)I
      // 6f: pop
      // 70: aload 4
      // 72: monitorexit
      // 73: iload 3
      // 74: istore 2
      // 75: goto 13
      // try (20 -> 24): 33 null
      // try (24 -> 30): 33 null
      // try (34 -> 36): 33 null
      // try (38 -> 44): 56 android/os/RemoteException
      // try (38 -> 44): 33 null
      // try (47 -> 53): 56 android/os/RemoteException
      // try (47 -> 53): 33 null
      // try (53 -> 55): 33 null
      // try (57 -> 63): 33 null
   }

   @Override
   public void copyStringToBuffer(int var1, CharArrayBuffer var2) {
   }

   @Override
   public void deactivate() {
      super.deactivate();

      try {
         this.mBulkCursor.deactivate();
      } catch (RemoteException var2) {
         Log.w("BulkCursor", "Remote process exception when deactivating");
      }

      this.mWindow = null;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @Override
   public boolean deleteRow() {
      boolean var3;
      try {
         var3 = this.mBulkCursor.deleteRow(this.mPos);
      } catch (RemoteException var8) {
         Log.e("BulkCursor", "Unable to delete row because the remote process is dead");
         return false;
      }

      boolean var2 = var3;
      if (var3) {
         label41: {
            try {
               this.mWindow = null;
               this.mCount = this.mBulkCursor.count();
               if (this.mPos < this.mCount) {
                  int var1 = this.mPos;
                  this.mPos = -1;
                  this.moveToPosition(var1);
                  break label41;
               }
            } catch (RemoteException var7) {
               Log.e("BulkCursor", "Unable to delete row because the remote process is dead");
               var2 = false;
               return var2;
            }

            try {
               this.mPos = this.mCount;
            } catch (RemoteException var6) {
               Log.e("BulkCursor", "Unable to delete row because the remote process is dead");
               var2 = false;
               return var2;
            }
         }

         try {
            this.onChange(true);
         } catch (RemoteException var5) {
            Log.e("BulkCursor", "Unable to delete row because the remote process is dead");
            var2 = false;
            return var2;
         }

         var2 = var3;
      }

      return var2;
   }

   @Override
   public String[] getColumnNames() {
      if (this.mColumns == null) {
         try {
            this.mColumns = this.mBulkCursor.getColumnNames();
         } catch (RemoteException var2) {
            Log.e("BulkCursor", "Unable to fetch column names because the remote process is dead");
            return null;
         }
      }

      return this.mColumns;
   }

   @Override
   public int getCount() {
      return this.mCount;
   }

   @Override
   public Bundle getExtras() {
      try {
         return this.mBulkCursor.getExtras();
      } catch (RemoteException var2) {
         throw new RuntimeException(var2);
      }
   }

   public IContentObserver getObserver() {
      synchronized (this) {
         if (this.mObserverBridge == null) {
            AbstractCursor.SelfContentObserver var1 = new AbstractCursor.SelfContentObserver(this);
            this.mObserverBridge = var1;
         }
      }

      return null;
   }

   @Override
   public boolean onMove(int var1, int var2) {
      boolean var3 = false;

      try {
         if (this.mWindow != null) {
            if (var2 < this.mWindow.getStartPosition() || var2 >= this.mWindow.getStartPosition() + this.mWindow.getNumRows()) {
               this.mWindow = this.mBulkCursor.getWindow(var2);
            } else if (this.mWantsAllOnMoveCalls) {
               this.mBulkCursor.onMove(var2);
            }
         } else {
            this.mWindow = this.mBulkCursor.getWindow(var2);
         }
      } catch (RemoteException var5) {
         Log.e("BulkCursor", "Unable to get window because the remote process is dead");
         return var3;
      }

      if (this.mWindow != null) {
         var3 = true;
      }

      return var3;
   }

   @Override
   public void registerContentObserver(ContentObserver var1) {
   }

   @Override
   public void registerDataSetObserver(DataSetObserver var1) {
   }

   @Override
   public boolean requery() {
      boolean var2 = false;

      try {
         int var1 = this.mCount;
         IBulkCursor var4 = this.mBulkCursor;
         IContentObserver var3 = this.getObserver();
         CursorWindow var5 = new CursorWindow(false);
         this.mCount = var4.requery(var3, var5);
         if (this.mCount == -1) {
            this.deactivate();
            return var2;
         }

         this.mPos = -1;
         this.mWindow = null;
         super.requery();
      } catch (Exception var6) {
         Log.e("BulkCursor", "Unable to requery because the remote process exception " + var6.getMessage());
         this.deactivate();
         return var2;
      }

      return true;
   }

   @Override
   public Bundle respond(Bundle var1) {
      try {
         var1 = this.mBulkCursor.respond(var1);
      } catch (RemoteException var2) {
         Log.w("BulkCursor", "respond() threw RemoteException, returning an empty bundle.", var2);
         var1 = Bundle.EMPTY;
      }

      return var1;
   }

   public void set(IBulkCursor var1) {
      this.mBulkCursor = var1;

      try {
         this.mCount = this.mBulkCursor.count();
         this.mWantsAllOnMoveCalls = this.mBulkCursor.getWantsAllOnMoveCalls();
         this.mColumns = this.mBulkCursor.getColumnNames();
         this.mRowIdColumnIndex = findRowIdColumnIndex(this.mColumns);
      } catch (RemoteException var2) {
         Log.e("BulkCursor", "Setup failed because the remote process is dead");
      }
   }

   public void set(IBulkCursor var1, int var2, int var3) {
      this.mBulkCursor = var1;
      this.mColumns = null;
      this.mCount = var2;
      this.mRowIdColumnIndex = var3;
   }

   @Override
   public void unregisterContentObserver(ContentObserver var1) {
   }

   @Override
   public void unregisterDataSetObserver(DataSetObserver var1) {
   }
}
