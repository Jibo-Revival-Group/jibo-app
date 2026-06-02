package net.sqlcipher;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObservable;
import android.database.ContentObserver;
import android.database.CrossProcessCursor;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCursor implements CrossProcessCursor, Cursor {
   private static final String TAG = "Cursor";
   protected boolean mClosed;
   ContentObservable mContentObservable;
   protected ContentResolver mContentResolver;
   protected Long mCurrentRowID;
   DataSetObservable mDataSetObservable = new DataSetObservable();
   private Bundle mExtras;
   private Uri mNotifyUri;
   protected int mPos;
   protected int mRowIdColumnIndex;
   private ContentObserver mSelfObserver;
   private final Object mSelfObserverLock;
   private boolean mSelfObserverRegistered;
   protected HashMap<Long, Map<String, Object>> mUpdatedRows;

   public AbstractCursor() {
      this.mContentObservable = new ContentObservable();
      this.mExtras = Bundle.EMPTY;
      this.mClosed = false;
      this.mSelfObserverLock = new Object();
      this.mPos = -1;
      this.mRowIdColumnIndex = -1;
      this.mCurrentRowID = null;
      this.mUpdatedRows = new HashMap<>();
   }

   public void abortUpdates() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield net/sqlcipher/AbstractCursor.mUpdatedRows Ljava/util/HashMap;
      // 04: astore 1
      // 05: aload 1
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield net/sqlcipher/AbstractCursor.mUpdatedRows Ljava/util/HashMap;
      // 0b: invokevirtual java/util/HashMap.clear ()V
      // 0e: aload 1
      // 0f: monitorexit
      // 10: return
      // 11: astore 2
      // 12: aload 1
      // 13: monitorexit
      // 14: aload 2
      // 15: athrow
      // try (5 -> 10): 11 null
      // try (12 -> 14): 11 null
   }

   protected void checkPosition() {
      if (-1 == this.mPos || this.getCount() == this.mPos) {
         throw new CursorIndexOutOfBoundsException(this.mPos, this.getCount());
      }
   }

   public void close() {
      this.mClosed = true;
      this.mContentObservable.unregisterAll();
      this.deactivateInternal();
   }

   public boolean commitUpdates() {
      return this.commitUpdates(null);
   }

   public boolean commitUpdates(Map<? extends Long, ? extends Map<String, Object>> var1) {
      return false;
   }

   public void copyStringToBuffer(int var1, CharArrayBuffer var2) {
      String var3 = this.getString(var1);
      if (var3 != null) {
         char[] var4 = var2.data;
         if (var4 != null && var4.length >= var3.length()) {
            var3.getChars(0, var3.length(), var4, 0);
         } else {
            var2.data = var3.toCharArray();
         }

         var2.sizeCopied = var3.length();
      } else {
         var2.sizeCopied = 0;
      }
   }

   public void deactivate() {
      this.deactivateInternal();
   }

   public void deactivateInternal() {
      if (this.mSelfObserver != null) {
         this.mContentResolver.unregisterContentObserver(this.mSelfObserver);
         this.mSelfObserverRegistered = false;
      }

      this.mDataSetObservable.notifyInvalidated();
   }

   public boolean deleteRow() {
      return false;
   }

   public void fillWindow(int var1, android.database.CursorWindow var2) {
      DatabaseUtils.cursorFillWindow(this, var1, var2);
   }

   @Override
   protected void finalize() {
      if (this.mSelfObserver != null && this.mSelfObserverRegistered) {
         this.mContentResolver.unregisterContentObserver(this.mSelfObserver);
      }
   }

   public byte[] getBlob(int var1) {
      throw new UnsupportedOperationException("getBlob is not supported");
   }

   public int getColumnCount() {
      return this.getColumnNames().length;
   }

   public int getColumnIndex(String var1) {
      int var2 = var1.lastIndexOf(46);
      String var4 = var1;
      if (var2 != -1) {
         Exception var7 = new Exception();
         Log.e("Cursor", "requesting column name with table name -- " + var1, var7);
         var4 = var1.substring(var2 + 1);
      }

      String[] var5 = this.getColumnNames();
      int var3 = var5.length;
      var2 = 0;

      while (true) {
         if (var2 >= var3) {
            var2 = -1;
            break;
         }

         if (var5[var2].equalsIgnoreCase(var4)) {
            break;
         }

         var2++;
      }

      return var2;
   }

   public int getColumnIndexOrThrow(String var1) {
      int var2 = this.getColumnIndex(var1);
      if (var2 < 0) {
         throw new IllegalArgumentException("column '" + var1 + "' does not exist");
      } else {
         return var2;
      }
   }

   public String getColumnName(int var1) {
      return this.getColumnNames()[var1];
   }

   public abstract String[] getColumnNames();

   public abstract int getCount();

   protected DataSetObservable getDataSetObservable() {
      return this.mDataSetObservable;
   }

   public abstract double getDouble(int var1);

   public Bundle getExtras() {
      return this.mExtras;
   }

   public abstract float getFloat(int var1);

   public abstract int getInt(int var1);

   public abstract long getLong(int var1);

   public Uri getNotificationUri() {
      return this.mNotifyUri;
   }

   public final int getPosition() {
      return this.mPos;
   }

   public abstract short getShort(int var1);

   public abstract String getString(int var1);

   @Override
   public abstract int getType(int var1);

   protected Object getUpdatedField(int var1) {
      return this.mUpdatedRows.get(this.mCurrentRowID).get(this.getColumnNames()[var1]);
   }

   public boolean getWantsAllOnMoveCalls() {
      return false;
   }

   public CursorWindow getWindow() {
      return null;
   }

   public boolean hasUpdates() {
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
      // 01: getfield net/sqlcipher/AbstractCursor.mUpdatedRows Ljava/util/HashMap;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield net/sqlcipher/AbstractCursor.mUpdatedRows Ljava/util/HashMap;
      // 0b: invokevirtual java/util/HashMap.size ()I
      // 0e: ifle 17
      // 11: bipush 1
      // 12: istore 1
      // 13: aload 2
      // 14: monitorexit
      // 15: iload 1
      // 16: ireturn
      // 17: bipush 0
      // 18: istore 1
      // 19: goto 13
      // 1c: astore 3
      // 1d: aload 2
      // 1e: monitorexit
      // 1f: aload 3
      // 20: athrow
      // try (5 -> 9): 18 null
      // try (11 -> 13): 18 null
      // try (19 -> 21): 18 null
   }

   public final boolean isAfterLast() {
      boolean var1 = true;
      if (this.getCount() != 0 && this.mPos != this.getCount()) {
         var1 = false;
      }

      return var1;
   }

   public final boolean isBeforeFirst() {
      boolean var1 = true;
      if (this.getCount() != 0 && this.mPos != -1) {
         var1 = false;
      }

      return var1;
   }

   public boolean isClosed() {
      return this.mClosed;
   }

   protected boolean isFieldUpdated(int var1) {
      if (this.mRowIdColumnIndex != -1 && this.mUpdatedRows.size() > 0) {
         Map var3 = this.mUpdatedRows.get(this.mCurrentRowID);
         if (var3 != null && var3.containsKey(this.getColumnNames()[var1])) {
            return true;
         }
      }

      return false;
   }

   public final boolean isFirst() {
      boolean var1;
      if (this.mPos == 0 && this.getCount() != 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public final boolean isLast() {
      int var1 = this.getCount();
      boolean var2;
      if (this.mPos == var1 - 1 && var1 != 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public abstract boolean isNull(int var1);

   public final boolean move(int var1) {
      return this.moveToPosition(this.mPos + var1);
   }

   public final boolean moveToFirst() {
      return this.moveToPosition(0);
   }

   public final boolean moveToLast() {
      return this.moveToPosition(this.getCount() - 1);
   }

   public final boolean moveToNext() {
      return this.moveToPosition(this.mPos + 1);
   }

   public final boolean moveToPosition(int var1) {
      boolean var3 = false;
      int var2 = this.getCount();
      if (var1 >= var2) {
         this.mPos = var2;
      } else if (var1 < 0) {
         this.mPos = -1;
      } else if (var1 == this.mPos) {
         var3 = true;
      } else {
         boolean var4 = this.onMove(this.mPos, var1);
         if (!var4) {
            this.mPos = -1;
            var3 = var4;
         } else {
            this.mPos = var1;
            var3 = var4;
            if (this.mRowIdColumnIndex != -1) {
               this.mCurrentRowID = this.getLong(this.mRowIdColumnIndex);
               var3 = var4;
            }
         }
      }

      return var3;
   }

   public final boolean moveToPrevious() {
      return this.moveToPosition(this.mPos - 1);
   }

   protected void notifyDataSetChange() {
      this.mDataSetObservable.notifyChanged();
   }

   protected void onChange(boolean param1) {
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
      // 01: getfield net/sqlcipher/AbstractCursor.mSelfObserverLock Ljava/lang/Object;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield net/sqlcipher/AbstractCursor.mContentObservable Landroid/database/ContentObservable;
      // 0b: iload 1
      // 0c: invokevirtual android/database/ContentObservable.dispatchChange (Z)V
      // 0f: aload 0
      // 10: getfield net/sqlcipher/AbstractCursor.mNotifyUri Landroid/net/Uri;
      // 13: ifnull 29
      // 16: iload 1
      // 17: ifeq 29
      // 1a: aload 0
      // 1b: getfield net/sqlcipher/AbstractCursor.mContentResolver Landroid/content/ContentResolver;
      // 1e: aload 0
      // 1f: getfield net/sqlcipher/AbstractCursor.mNotifyUri Landroid/net/Uri;
      // 22: aload 0
      // 23: getfield net/sqlcipher/AbstractCursor.mSelfObserver Landroid/database/ContentObserver;
      // 26: invokevirtual android/content/ContentResolver.notifyChange (Landroid/net/Uri;Landroid/database/ContentObserver;)V
      // 29: aload 2
      // 2a: monitorexit
      // 2b: return
      // 2c: astore 3
      // 2d: aload 2
      // 2e: monitorexit
      // 2f: aload 3
      // 30: athrow
      // try (5 -> 12): 24 null
      // try (14 -> 21): 24 null
      // try (21 -> 23): 24 null
      // try (25 -> 27): 24 null
   }

   public boolean onMove(int var1, int var2) {
      return true;
   }

   public void registerContentObserver(ContentObserver var1) {
      this.mContentObservable.registerObserver(var1);
   }

   public void registerDataSetObserver(DataSetObserver var1) {
      this.mDataSetObservable.registerObserver(var1);
   }

   public boolean requery() {
      if (this.mSelfObserver != null && !this.mSelfObserverRegistered) {
         this.mContentResolver.registerContentObserver(this.mNotifyUri, true, this.mSelfObserver);
         this.mSelfObserverRegistered = true;
      }

      this.mDataSetObservable.notifyChanged();
      return true;
   }

   public Bundle respond(Bundle var1) {
      return Bundle.EMPTY;
   }

   public void setExtras(Bundle var1) {
      Bundle var2 = var1;
      if (var1 == null) {
         var2 = Bundle.EMPTY;
      }

      this.mExtras = var2;
   }

   public void setNotificationUri(ContentResolver param1, Uri param2) {
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
      // 01: getfield net/sqlcipher/AbstractCursor.mSelfObserverLock Ljava/lang/Object;
      // 04: astore 3
      // 05: aload 3
      // 06: monitorenter
      // 07: aload 0
      // 08: aload 2
      // 09: putfield net/sqlcipher/AbstractCursor.mNotifyUri Landroid/net/Uri;
      // 0c: aload 0
      // 0d: aload 1
      // 0e: putfield net/sqlcipher/AbstractCursor.mContentResolver Landroid/content/ContentResolver;
      // 11: aload 0
      // 12: getfield net/sqlcipher/AbstractCursor.mSelfObserver Landroid/database/ContentObserver;
      // 15: ifnull 23
      // 18: aload 0
      // 19: getfield net/sqlcipher/AbstractCursor.mContentResolver Landroid/content/ContentResolver;
      // 1c: aload 0
      // 1d: getfield net/sqlcipher/AbstractCursor.mSelfObserver Landroid/database/ContentObserver;
      // 20: invokevirtual android/content/ContentResolver.unregisterContentObserver (Landroid/database/ContentObserver;)V
      // 23: new net/sqlcipher/AbstractCursor$SelfContentObserver
      // 26: astore 1
      // 27: aload 1
      // 28: aload 0
      // 29: invokespecial net/sqlcipher/AbstractCursor$SelfContentObserver.<init> (Lnet/sqlcipher/AbstractCursor;)V
      // 2c: aload 0
      // 2d: aload 1
      // 2e: putfield net/sqlcipher/AbstractCursor.mSelfObserver Landroid/database/ContentObserver;
      // 31: aload 0
      // 32: getfield net/sqlcipher/AbstractCursor.mContentResolver Landroid/content/ContentResolver;
      // 35: aload 0
      // 36: getfield net/sqlcipher/AbstractCursor.mNotifyUri Landroid/net/Uri;
      // 39: bipush 1
      // 3a: aload 0
      // 3b: getfield net/sqlcipher/AbstractCursor.mSelfObserver Landroid/database/ContentObserver;
      // 3e: invokevirtual android/content/ContentResolver.registerContentObserver (Landroid/net/Uri;ZLandroid/database/ContentObserver;)V
      // 41: aload 0
      // 42: bipush 1
      // 43: putfield net/sqlcipher/AbstractCursor.mSelfObserverRegistered Z
      // 46: aload 3
      // 47: monitorexit
      // 48: return
      // 49: astore 1
      // 4a: aload 3
      // 4b: monitorexit
      // 4c: aload 1
      // 4d: athrow
      // try (5 -> 19): 41 null
      // try (19 -> 40): 41 null
      // try (42 -> 44): 41 null
   }

   public boolean supportsUpdates() {
      boolean var1;
      if (this.mRowIdColumnIndex != -1) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public void unregisterContentObserver(ContentObserver var1) {
      if (!this.mClosed) {
         this.mContentObservable.unregisterObserver(var1);
      }
   }

   public void unregisterDataSetObserver(DataSetObserver var1) {
      this.mDataSetObservable.unregisterObserver(var1);
   }

   public boolean update(int param1, Object param2) {
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
      // 01: invokevirtual net/sqlcipher/AbstractCursor.supportsUpdates ()Z
      // 04: ifne 0b
      // 07: bipush 0
      // 08: istore 3
      // 09: iload 3
      // 0a: ireturn
      // 0b: aload 0
      // 0c: aload 0
      // 0d: getfield net/sqlcipher/AbstractCursor.mRowIdColumnIndex I
      // 10: invokevirtual net/sqlcipher/AbstractCursor.getLong (I)J
      // 13: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 16: astore 7
      // 18: aload 7
      // 1a: ifnonnull 3c
      // 1d: new java/lang/IllegalStateException
      // 20: dup
      // 21: new java/lang/StringBuilder
      // 24: dup
      // 25: invokespecial java/lang/StringBuilder.<init> ()V
      // 28: ldc_w "null rowid. mRowIdColumnIndex = "
      // 2b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 2e: aload 0
      // 2f: getfield net/sqlcipher/AbstractCursor.mRowIdColumnIndex I
      // 32: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 35: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 38: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 3b: athrow
      // 3c: aload 0
      // 3d: getfield net/sqlcipher/AbstractCursor.mUpdatedRows Ljava/util/HashMap;
      // 40: astore 6
      // 42: aload 6
      // 44: monitorenter
      // 45: aload 0
      // 46: getfield net/sqlcipher/AbstractCursor.mUpdatedRows Ljava/util/HashMap;
      // 49: aload 7
      // 4b: invokevirtual java/util/HashMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 4e: checkcast java/util/Map
      // 51: astore 5
      // 53: aload 5
      // 55: astore 4
      // 57: aload 5
      // 59: ifnonnull 72
      // 5c: new java/util/HashMap
      // 5f: astore 4
      // 61: aload 4
      // 63: invokespecial java/util/HashMap.<init> ()V
      // 66: aload 0
      // 67: getfield net/sqlcipher/AbstractCursor.mUpdatedRows Ljava/util/HashMap;
      // 6a: aload 7
      // 6c: aload 4
      // 6e: invokevirtual java/util/HashMap.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 71: pop
      // 72: aload 4
      // 74: aload 0
      // 75: invokevirtual net/sqlcipher/AbstractCursor.getColumnNames ()[Ljava/lang/String;
      // 78: iload 1
      // 79: aaload
      // 7a: aload 2
      // 7b: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 80: pop
      // 81: aload 6
      // 83: monitorexit
      // 84: bipush 1
      // 85: istore 3
      // 86: goto 09
      // 89: astore 2
      // 8a: aload 6
      // 8c: monitorexit
      // 8d: aload 2
      // 8e: athrow
      // try (33 -> 39): 66 null
      // try (43 -> 53): 66 null
      // try (53 -> 63): 66 null
      // try (67 -> 69): 66 null
   }

   public boolean updateBlob(int var1, byte[] var2) {
      return this.update(var1, var2);
   }

   public boolean updateDouble(int var1, double var2) {
      return this.update(var1, var2);
   }

   public boolean updateFloat(int var1, float var2) {
      return this.update(var1, var2);
   }

   public boolean updateInt(int var1, int var2) {
      return this.update(var1, var2);
   }

   public boolean updateLong(int var1, long var2) {
      return this.update(var1, var2);
   }

   public boolean updateShort(int var1, short var2) {
      return this.update(var1, var2);
   }

   public boolean updateString(int var1, String var2) {
      return this.update(var1, var2);
   }

   public boolean updateToNull(int var1) {
      return this.update(var1, null);
   }

   protected static class SelfContentObserver extends ContentObserver {
      WeakReference<AbstractCursor> mCursor;

      public SelfContentObserver(AbstractCursor var1) {
         super(null);
         this.mCursor = new WeakReference<>(var1);
      }

      public boolean deliverSelfNotifications() {
         return false;
      }

      public void onChange(boolean var1) {
         AbstractCursor var2 = this.mCursor.get();
         if (var2 != null) {
            var2.onChange(false);
         }
      }
   }
}
