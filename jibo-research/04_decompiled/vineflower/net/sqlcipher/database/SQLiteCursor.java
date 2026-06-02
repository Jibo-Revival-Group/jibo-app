package net.sqlcipher.database;

import android.database.DataSetObserver;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import net.sqlcipher.AbstractWindowedCursor;
import net.sqlcipher.CursorWindow;

public class SQLiteCursor extends AbstractWindowedCursor {
   static final int NO_COUNT = -1;
   static final String TAG = "Cursor";
   private Map<String, Integer> mColumnNameMap;
   private String[] mColumns;
   private int mCount;
   private int mCursorState;
   private SQLiteDatabase mDatabase;
   private SQLiteCursorDriver mDriver;
   private String mEditTable;
   private int mInitialRead;
   private ReentrantLock mLock;
   private int mMaxRead;
   protected SQLiteCursor.MainThreadNotificationHandler mNotificationHandler;
   private boolean mPendingData;
   private SQLiteQuery mQuery;
   private Throwable mStackTrace;

   public SQLiteCursor(SQLiteDatabase param1, SQLiteCursorDriver param2, String param3, SQLiteQuery param4) {
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
      // 00: bipush 0
      // 01: istore 5
      // 03: aload 0
      // 04: invokespecial net/sqlcipher/AbstractWindowedCursor.<init> ()V
      // 07: aload 0
      // 08: bipush -1
      // 09: putfield net/sqlcipher/database/SQLiteCursor.mCount I
      // 0c: aload 0
      // 0d: ldc 2147483647
      // 0f: putfield net/sqlcipher/database/SQLiteCursor.mMaxRead I
      // 12: aload 0
      // 13: ldc 2147483647
      // 15: putfield net/sqlcipher/database/SQLiteCursor.mInitialRead I
      // 18: aload 0
      // 19: bipush 0
      // 1a: putfield net/sqlcipher/database/SQLiteCursor.mCursorState I
      // 1d: aload 0
      // 1e: aconst_null
      // 1f: putfield net/sqlcipher/database/SQLiteCursor.mLock Ljava/util/concurrent/locks/ReentrantLock;
      // 22: aload 0
      // 23: bipush 0
      // 24: putfield net/sqlcipher/database/SQLiteCursor.mPendingData Z
      // 27: aload 0
      // 28: new net/sqlcipher/database/DatabaseObjectNotClosedException
      // 2b: dup
      // 2c: invokespecial net/sqlcipher/database/DatabaseObjectNotClosedException.<init> ()V
      // 2f: invokevirtual net/sqlcipher/database/DatabaseObjectNotClosedException.fillInStackTrace ()Ljava/lang/Throwable;
      // 32: putfield net/sqlcipher/database/SQLiteCursor.mStackTrace Ljava/lang/Throwable;
      // 35: aload 0
      // 36: aload 1
      // 37: putfield net/sqlcipher/database/SQLiteCursor.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 3a: aload 0
      // 3b: aload 2
      // 3c: putfield net/sqlcipher/database/SQLiteCursor.mDriver Lnet/sqlcipher/database/SQLiteCursorDriver;
      // 3f: aload 0
      // 40: aload 3
      // 41: putfield net/sqlcipher/database/SQLiteCursor.mEditTable Ljava/lang/String;
      // 44: aload 0
      // 45: aconst_null
      // 46: putfield net/sqlcipher/database/SQLiteCursor.mColumnNameMap Ljava/util/Map;
      // 49: aload 0
      // 4a: aload 4
      // 4c: putfield net/sqlcipher/database/SQLiteCursor.mQuery Lnet/sqlcipher/database/SQLiteQuery;
      // 4f: aload 1
      // 50: invokevirtual net/sqlcipher/database/SQLiteDatabase.lock ()V
      // 53: aload 0
      // 54: getfield net/sqlcipher/database/SQLiteCursor.mQuery Lnet/sqlcipher/database/SQLiteQuery;
      // 57: invokevirtual net/sqlcipher/database/SQLiteQuery.columnCountLocked ()I
      // 5a: istore 6
      // 5c: aload 0
      // 5d: iload 6
      // 5f: anewarray 91
      // 62: putfield net/sqlcipher/database/SQLiteCursor.mColumns [Ljava/lang/String;
      // 65: iload 5
      // 67: iload 6
      // 69: if_icmpge 93
      // 6c: aload 0
      // 6d: getfield net/sqlcipher/database/SQLiteCursor.mQuery Lnet/sqlcipher/database/SQLiteQuery;
      // 70: iload 5
      // 72: invokevirtual net/sqlcipher/database/SQLiteQuery.columnNameLocked (I)Ljava/lang/String;
      // 75: astore 2
      // 76: aload 0
      // 77: getfield net/sqlcipher/database/SQLiteCursor.mColumns [Ljava/lang/String;
      // 7a: iload 5
      // 7c: aload 2
      // 7d: aastore
      // 7e: ldc "_id"
      // 80: aload 2
      // 81: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 84: ifeq 8d
      // 87: aload 0
      // 88: iload 5
      // 8a: putfield net/sqlcipher/database/SQLiteCursor.mRowIdColumnIndex I
      // 8d: iinc 5 1
      // 90: goto 65
      // 93: aload 1
      // 94: invokevirtual net/sqlcipher/database/SQLiteDatabase.unlock ()V
      // 97: return
      // 98: astore 2
      // 99: aload 1
      // 9a: invokevirtual net/sqlcipher/database/SQLiteDatabase.unlock ()V
      // 9d: aload 2
      // 9e: athrow
      // try (43 -> 53): 78 null
      // try (56 -> 73): 78 null
   }

   private void deactivateCommon() {
      this.mCursorState = 0;
      if (this.mWindow != null) {
         this.mWindow.close();
         this.mWindow = null;
      }
   }

   private void fillWindow(int var1) {
      if (this.mWindow == null) {
         this.mWindow = new CursorWindow(true);
      } else {
         this.mCursorState++;
         this.queryThreadLock();

         try {
            this.mWindow.clear();
         } finally {
            this.queryThreadUnlock();
         }
      }

      this.mWindow.setStartPosition(var1);
      this.mCount = this.mQuery.fillWindow(this.mWindow, this.mInitialRead, 0);
      if (this.mCount == -1) {
         this.mCount = this.mInitialRead + var1;
         new Thread(new SQLiteCursor.QueryThread(this, this.mCursorState), "query thread").start();
      }
   }

   private void queryThreadLock() {
      if (this.mLock != null) {
         this.mLock.lock();
      }
   }

   private void queryThreadUnlock() {
      if (this.mLock != null) {
         this.mLock.unlock();
      }
   }

   @Override
   public void close() {
      super.close();
      this.deactivateCommon();
      this.mQuery.close();
      this.mDriver.cursorClosed();
   }

   @Override
   public boolean commitUpdates(Map<? extends Long, ? extends Map<String, Object>> param1) {
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
      // 000: aload 0
      // 001: invokevirtual net/sqlcipher/database/SQLiteCursor.supportsUpdates ()Z
      // 004: ifne 013
      // 007: ldc "Cursor"
      // 009: ldc "commitUpdates not supported on this cursor, did you include the _id column?"
      // 00b: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;)I
      // 00e: pop
      // 00f: bipush 0
      // 010: istore 3
      // 011: iload 3
      // 012: ireturn
      // 013: aload 0
      // 014: getfield net/sqlcipher/database/SQLiteCursor.mUpdatedRows Ljava/util/HashMap;
      // 017: astore 6
      // 019: aload 6
      // 01b: monitorenter
      // 01c: aload 1
      // 01d: ifnull 028
      // 020: aload 0
      // 021: getfield net/sqlcipher/database/SQLiteCursor.mUpdatedRows Ljava/util/HashMap;
      // 024: aload 1
      // 025: invokevirtual java/util/HashMap.putAll (Ljava/util/Map;)V
      // 028: aload 0
      // 029: getfield net/sqlcipher/database/SQLiteCursor.mUpdatedRows Ljava/util/HashMap;
      // 02c: invokevirtual java/util/HashMap.size ()I
      // 02f: ifne 03a
      // 032: aload 6
      // 034: monitorexit
      // 035: bipush 1
      // 036: istore 3
      // 037: goto 011
      // 03a: aload 0
      // 03b: getfield net/sqlcipher/database/SQLiteCursor.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 03e: invokevirtual net/sqlcipher/database/SQLiteDatabase.beginTransaction ()V
      // 041: new java/lang/StringBuilder
      // 044: astore 1
      // 045: aload 1
      // 046: sipush 128
      // 049: invokespecial java/lang/StringBuilder.<init> (I)V
      // 04c: aload 0
      // 04d: getfield net/sqlcipher/database/SQLiteCursor.mUpdatedRows Ljava/util/HashMap;
      // 050: invokevirtual java/util/HashMap.entrySet ()Ljava/util/Set;
      // 053: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 058: astore 7
      // 05a: aload 7
      // 05c: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 061: ifeq 1ce
      // 064: aload 7
      // 066: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 06b: checkcast java/util/Map$Entry
      // 06e: astore 9
      // 070: aload 9
      // 072: invokeinterface java/util/Map$Entry.getValue ()Ljava/lang/Object; 1
      // 077: checkcast java/util/Map
      // 07a: astore 8
      // 07c: aload 9
      // 07e: invokeinterface java/util/Map$Entry.getKey ()Ljava/lang/Object; 1
      // 083: checkcast java/lang/Long
      // 086: astore 9
      // 088: aload 9
      // 08a: ifnull 092
      // 08d: aload 8
      // 08f: ifnonnull 0d1
      // 092: new java/lang/IllegalStateException
      // 095: astore 7
      // 097: new java/lang/StringBuilder
      // 09a: astore 1
      // 09b: aload 1
      // 09c: invokespecial java/lang/StringBuilder.<init> ()V
      // 09f: aload 7
      // 0a1: aload 1
      // 0a2: ldc_w "null rowId or values found! rowId = "
      // 0a5: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0a8: aload 9
      // 0aa: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 0ad: ldc_w ", values = "
      // 0b0: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0b3: aload 8
      // 0b5: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 0b8: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0bb: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 0be: aload 7
      // 0c0: athrow
      // 0c1: astore 1
      // 0c2: aload 0
      // 0c3: getfield net/sqlcipher/database/SQLiteCursor.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 0c6: invokevirtual net/sqlcipher/database/SQLiteDatabase.endTransaction ()V
      // 0c9: aload 1
      // 0ca: athrow
      // 0cb: astore 1
      // 0cc: aload 6
      // 0ce: monitorexit
      // 0cf: aload 1
      // 0d0: athrow
      // 0d1: aload 8
      // 0d3: invokeinterface java/util/Map.size ()I 1
      // 0d8: ifeq 05a
      // 0db: aload 9
      // 0dd: invokevirtual java/lang/Long.longValue ()J
      // 0e0: lstore 4
      // 0e2: aload 8
      // 0e4: invokeinterface java/util/Map.entrySet ()Ljava/util/Set; 1
      // 0e9: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 0ee: astore 9
      // 0f0: aload 1
      // 0f1: bipush 0
      // 0f2: invokevirtual java/lang/StringBuilder.setLength (I)V
      // 0f5: new java/lang/StringBuilder
      // 0f8: astore 10
      // 0fa: aload 10
      // 0fc: invokespecial java/lang/StringBuilder.<init> ()V
      // 0ff: aload 1
      // 100: aload 10
      // 102: ldc_w "UPDATE "
      // 105: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 108: aload 0
      // 109: getfield net/sqlcipher/database/SQLiteCursor.mEditTable Ljava/lang/String;
      // 10c: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 10f: ldc_w " SET "
      // 112: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 115: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 118: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 11b: pop
      // 11c: aload 8
      // 11e: invokeinterface java/util/Map.size ()I 1
      // 123: anewarray 290
      // 126: astore 8
      // 128: bipush 0
      // 129: istore 2
      // 12a: aload 9
      // 12c: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 131: ifeq 17a
      // 134: aload 9
      // 136: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 13b: checkcast java/util/Map$Entry
      // 13e: astore 10
      // 140: aload 1
      // 141: aload 10
      // 143: invokeinterface java/util/Map$Entry.getKey ()Ljava/lang/Object; 1
      // 148: checkcast java/lang/String
      // 14b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 14e: pop
      // 14f: aload 1
      // 150: ldc_w "=?"
      // 153: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 156: pop
      // 157: aload 8
      // 159: iload 2
      // 15a: aload 10
      // 15c: invokeinterface java/util/Map$Entry.getValue ()Ljava/lang/Object; 1
      // 161: aastore
      // 162: aload 9
      // 164: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 169: ifeq 174
      // 16c: aload 1
      // 16d: ldc_w ", "
      // 170: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 173: pop
      // 174: iinc 2 1
      // 177: goto 12a
      // 17a: new java/lang/StringBuilder
      // 17d: astore 9
      // 17f: aload 9
      // 181: invokespecial java/lang/StringBuilder.<init> ()V
      // 184: aload 1
      // 185: aload 9
      // 187: ldc_w " WHERE "
      // 18a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 18d: aload 0
      // 18e: getfield net/sqlcipher/database/SQLiteCursor.mColumns [Ljava/lang/String;
      // 191: aload 0
      // 192: getfield net/sqlcipher/database/SQLiteCursor.mRowIdColumnIndex I
      // 195: aaload
      // 196: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 199: bipush 61
      // 19b: invokevirtual java/lang/StringBuilder.append (C)Ljava/lang/StringBuilder;
      // 19e: lload 4
      // 1a0: invokevirtual java/lang/StringBuilder.append (J)Ljava/lang/StringBuilder;
      // 1a3: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 1a6: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1a9: pop
      // 1aa: aload 1
      // 1ab: bipush 59
      // 1ad: invokevirtual java/lang/StringBuilder.append (C)Ljava/lang/StringBuilder;
      // 1b0: pop
      // 1b1: aload 0
      // 1b2: getfield net/sqlcipher/database/SQLiteCursor.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 1b5: aload 1
      // 1b6: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 1b9: aload 8
      // 1bb: invokevirtual net/sqlcipher/database/SQLiteDatabase.execSQL (Ljava/lang/String;[Ljava/lang/Object;)V
      // 1be: aload 0
      // 1bf: getfield net/sqlcipher/database/SQLiteCursor.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 1c2: aload 0
      // 1c3: getfield net/sqlcipher/database/SQLiteCursor.mEditTable Ljava/lang/String;
      // 1c6: lload 4
      // 1c8: invokevirtual net/sqlcipher/database/SQLiteDatabase.rowUpdated (Ljava/lang/String;J)V
      // 1cb: goto 05a
      // 1ce: aload 0
      // 1cf: getfield net/sqlcipher/database/SQLiteCursor.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 1d2: invokevirtual net/sqlcipher/database/SQLiteDatabase.setTransactionSuccessful ()V
      // 1d5: aload 0
      // 1d6: getfield net/sqlcipher/database/SQLiteCursor.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 1d9: invokevirtual net/sqlcipher/database/SQLiteDatabase.endTransaction ()V
      // 1dc: aload 0
      // 1dd: getfield net/sqlcipher/database/SQLiteCursor.mUpdatedRows Ljava/util/HashMap;
      // 1e0: invokevirtual java/util/HashMap.clear ()V
      // 1e3: aload 6
      // 1e5: monitorexit
      // 1e6: aload 0
      // 1e7: bipush 1
      // 1e8: invokevirtual net/sqlcipher/database/SQLiteCursor.onChange (Z)V
      // 1eb: bipush 1
      // 1ec: istore 3
      // 1ed: goto 011
      // try (18 -> 22): 89 null
      // try (22 -> 28): 89 null
      // try (31 -> 34): 89 null
      // try (34 -> 44): 83 null
      // try (44 -> 59): 83 null
      // try (63 -> 83): 83 null
      // try (84 -> 89): 89 null
      // try (90 -> 92): 89 null
      // try (94 -> 127): 83 null
      // try (129 -> 158): 83 null
      // try (160 -> 197): 83 null
      // try (198 -> 201): 83 null
      // try (201 -> 209): 89 null
   }

   @Override
   public void deactivate() {
      super.deactivate();
      this.deactivateCommon();
      this.mDriver.cursorDeactivated();
   }

   @Override
   public boolean deleteRow() {
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
      // 00: bipush 1
      // 01: istore 3
      // 02: aload 0
      // 03: invokevirtual net/sqlcipher/database/SQLiteCursor.checkPosition ()V
      // 06: aload 0
      // 07: getfield net/sqlcipher/database/SQLiteCursor.mRowIdColumnIndex I
      // 0a: bipush -1
      // 0b: if_icmpeq 15
      // 0e: aload 0
      // 0f: getfield net/sqlcipher/database/SQLiteCursor.mCurrentRowID Ljava/lang/Long;
      // 12: ifnonnull 22
      // 15: ldc "Cursor"
      // 17: ldc_w "Could not delete row because either the row ID column is not available or ithas not been read."
      // 1a: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;)I
      // 1d: pop
      // 1e: bipush 0
      // 1f: istore 3
      // 20: iload 3
      // 21: ireturn
      // 22: aload 0
      // 23: getfield net/sqlcipher/database/SQLiteCursor.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 26: invokevirtual net/sqlcipher/database/SQLiteDatabase.lock ()V
      // 29: aload 0
      // 2a: getfield net/sqlcipher/database/SQLiteCursor.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 2d: astore 5
      // 2f: aload 0
      // 30: getfield net/sqlcipher/database/SQLiteCursor.mEditTable Ljava/lang/String;
      // 33: astore 6
      // 35: new java/lang/StringBuilder
      // 38: astore 4
      // 3a: aload 4
      // 3c: invokespecial java/lang/StringBuilder.<init> ()V
      // 3f: aload 5
      // 41: aload 6
      // 43: aload 4
      // 45: aload 0
      // 46: getfield net/sqlcipher/database/SQLiteCursor.mColumns [Ljava/lang/String;
      // 49: aload 0
      // 4a: getfield net/sqlcipher/database/SQLiteCursor.mRowIdColumnIndex I
      // 4d: aaload
      // 4e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 51: ldc_w "=?"
      // 54: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 57: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 5a: bipush 1
      // 5b: anewarray 91
      // 5e: dup
      // 5f: bipush 0
      // 60: aload 0
      // 61: getfield net/sqlcipher/database/SQLiteCursor.mCurrentRowID Ljava/lang/Long;
      // 64: invokevirtual java/lang/Long.toString ()Ljava/lang/String;
      // 67: aastore
      // 68: invokevirtual net/sqlcipher/database/SQLiteDatabase.delete (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
      // 6b: pop
      // 6c: bipush 1
      // 6d: istore 1
      // 6e: aload 0
      // 6f: getfield net/sqlcipher/database/SQLiteCursor.mPos I
      // 72: istore 2
      // 73: aload 0
      // 74: invokevirtual net/sqlcipher/database/SQLiteCursor.requery ()Z
      // 77: pop
      // 78: aload 0
      // 79: iload 2
      // 7a: invokevirtual net/sqlcipher/database/SQLiteCursor.moveToPosition (I)Z
      // 7d: pop
      // 7e: aload 0
      // 7f: getfield net/sqlcipher/database/SQLiteCursor.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 82: invokevirtual net/sqlcipher/database/SQLiteDatabase.unlock ()V
      // 85: iload 1
      // 86: ifeq a4
      // 89: aload 0
      // 8a: bipush 1
      // 8b: invokevirtual net/sqlcipher/database/SQLiteCursor.onChange (Z)V
      // 8e: goto 20
      // 91: astore 4
      // 93: bipush 0
      // 94: istore 1
      // 95: goto 6e
      // 98: astore 4
      // 9a: aload 0
      // 9b: getfield net/sqlcipher/database/SQLiteCursor.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 9e: invokevirtual net/sqlcipher/database/SQLiteDatabase.unlock ()V
      // a1: aload 4
      // a3: athrow
      // a4: bipush 0
      // a5: istore 3
      // a6: goto 20
      // try (22 -> 54): 75 net/sqlcipher/SQLException
      // try (22 -> 54): 79 null
      // try (56 -> 66): 79 null
   }

   @Override
   public void fillWindow(int var1, android.database.CursorWindow var2) {
      if (this.mWindow == null) {
         this.mWindow = new CursorWindow(true);
      } else {
         this.mCursorState++;
         this.queryThreadLock();

         try {
            this.mWindow.clear();
         } finally {
            this.queryThreadUnlock();
         }
      }

      this.mWindow.setStartPosition(var1);
      this.mCount = this.mQuery.fillWindow(this.mWindow, this.mInitialRead, 0);
      if (this.mCount == -1) {
         this.mCount = this.mInitialRead + var1;
         new Thread(new SQLiteCursor.QueryThread(this, this.mCursorState), "query thread").start();
      }
   }

   @Override
   protected void finalize() {
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
      // 02: istore 1
      // 03: aload 0
      // 04: getfield net/sqlcipher/database/SQLiteCursor.mWindow Lnet/sqlcipher/CursorWindow;
      // 07: ifnull 70
      // 0a: aload 0
      // 0b: getfield net/sqlcipher/database/SQLiteCursor.mQuery Lnet/sqlcipher/database/SQLiteQuery;
      // 0e: getfield net/sqlcipher/database/SQLiteQuery.mSql Ljava/lang/String;
      // 11: invokevirtual java/lang/String.length ()I
      // 14: istore 2
      // 15: new java/lang/StringBuilder
      // 18: astore 3
      // 19: aload 3
      // 1a: invokespecial java/lang/StringBuilder.<init> ()V
      // 1d: aload 3
      // 1e: ldc_w "Finalizing a Cursor that has not been deactivated or closed. database = "
      // 21: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 24: aload 0
      // 25: getfield net/sqlcipher/database/SQLiteCursor.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 28: invokevirtual net/sqlcipher/database/SQLiteDatabase.getPath ()Ljava/lang/String;
      // 2b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 2e: ldc_w ", table = "
      // 31: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 34: aload 0
      // 35: getfield net/sqlcipher/database/SQLiteCursor.mEditTable Ljava/lang/String;
      // 38: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 3b: ldc_w ", query = "
      // 3e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 41: astore 3
      // 42: aload 0
      // 43: getfield net/sqlcipher/database/SQLiteCursor.mQuery Lnet/sqlcipher/database/SQLiteQuery;
      // 46: getfield net/sqlcipher/database/SQLiteQuery.mSql Ljava/lang/String;
      // 49: astore 4
      // 4b: iload 2
      // 4c: bipush 100
      // 4e: if_icmple 75
      // 51: ldc "Cursor"
      // 53: aload 3
      // 54: aload 4
      // 56: bipush 0
      // 57: iload 1
      // 58: invokevirtual java/lang/String.substring (II)Ljava/lang/String;
      // 5b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 5e: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 61: aload 0
      // 62: getfield net/sqlcipher/database/SQLiteCursor.mStackTrace Ljava/lang/Throwable;
      // 65: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 68: pop
      // 69: aload 0
      // 6a: invokevirtual net/sqlcipher/database/SQLiteCursor.close ()V
      // 6d: invokestatic net/sqlcipher/database/SQLiteDebug.notifyActiveCursorFinalized ()V
      // 70: aload 0
      // 71: invokespecial net/sqlcipher/AbstractWindowedCursor.finalize ()V
      // 74: return
      // 75: iload 2
      // 76: istore 1
      // 77: goto 51
      // 7a: astore 3
      // 7b: aload 0
      // 7c: invokespecial net/sqlcipher/AbstractWindowedCursor.finalize ()V
      // 7f: aload 3
      // 80: athrow
      // try (2 -> 33): 57 null
      // try (36 -> 51): 57 null
   }

   @Override
   public int getColumnIndex(String var1) {
      if (this.mColumnNameMap == null) {
         String[] var4 = this.mColumns;
         int var3 = var4.length;
         HashMap var5 = new HashMap(var3, 1.0F);

         for (int var2 = 0; var2 < var3; var2++) {
            var5.put(var4[var2], var2);
         }

         this.mColumnNameMap = var5;
      }

      int var7 = var1.lastIndexOf(46);
      String var9 = var1;
      if (var7 != -1) {
         Exception var10 = new Exception();
         Log.e("Cursor", "requesting column name with table name -- " + var1, var10);
         var9 = var1.substring(var7 + 1);
      }

      Integer var6 = this.mColumnNameMap.get(var9);
      if (var6 != null) {
         var7 = var6;
      } else {
         var7 = -1;
      }

      return var7;
   }

   @Override
   public String[] getColumnNames() {
      return this.mColumns;
   }

   @Override
   public int getCount() {
      if (this.mCount == -1) {
         this.fillWindow(0);
      }

      return this.mCount;
   }

   public SQLiteDatabase getDatabase() {
      return this.mDatabase;
   }

   @Override
   public boolean onMove(int var1, int var2) {
      if (this.mWindow == null || var2 < this.mWindow.getStartPosition() || var2 >= this.mWindow.getStartPosition() + this.mWindow.getNumRows()) {
         this.fillWindow(var2);
      }

      return true;
   }

   @Override
   public void registerDataSetObserver(DataSetObserver var1) {
      super.registerDataSetObserver(var1);
      if ((Integer.MAX_VALUE != this.mMaxRead || Integer.MAX_VALUE != this.mInitialRead) && this.mNotificationHandler == null) {
         this.queryThreadLock();

         try {
            SQLiteCursor.MainThreadNotificationHandler var4 = new SQLiteCursor.MainThreadNotificationHandler(this);
            this.mNotificationHandler = var4;
            if (this.mPendingData) {
               this.notifyDataSetChange();
               this.mPendingData = false;
            }
         } finally {
            this.queryThreadUnlock();
         }
      }
   }

   @Override
   public boolean requery() {
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
      // 00: aload 0
      // 01: invokevirtual net/sqlcipher/database/SQLiteCursor.isClosed ()Z
      // 04: ifeq 0b
      // 07: bipush 0
      // 08: istore 1
      // 09: iload 1
      // 0a: ireturn
      // 0b: aload 0
      // 0c: getfield net/sqlcipher/database/SQLiteCursor.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 0f: invokevirtual net/sqlcipher/database/SQLiteDatabase.lock ()V
      // 12: aload 0
      // 13: getfield net/sqlcipher/database/SQLiteCursor.mWindow Lnet/sqlcipher/CursorWindow;
      // 16: ifnull 20
      // 19: aload 0
      // 1a: getfield net/sqlcipher/database/SQLiteCursor.mWindow Lnet/sqlcipher/CursorWindow;
      // 1d: invokevirtual net/sqlcipher/CursorWindow.clear ()V
      // 20: aload 0
      // 21: bipush -1
      // 22: putfield net/sqlcipher/database/SQLiteCursor.mPos I
      // 25: aload 0
      // 26: getfield net/sqlcipher/database/SQLiteCursor.mDriver Lnet/sqlcipher/database/SQLiteCursorDriver;
      // 29: aload 0
      // 2a: invokeinterface net/sqlcipher/database/SQLiteCursorDriver.cursorRequeried (Landroid/database/Cursor;)V 2
      // 2f: aload 0
      // 30: bipush -1
      // 31: putfield net/sqlcipher/database/SQLiteCursor.mCount I
      // 34: aload 0
      // 35: aload 0
      // 36: getfield net/sqlcipher/database/SQLiteCursor.mCursorState I
      // 39: bipush 1
      // 3a: iadd
      // 3b: putfield net/sqlcipher/database/SQLiteCursor.mCursorState I
      // 3e: aload 0
      // 3f: invokespecial net/sqlcipher/database/SQLiteCursor.queryThreadLock ()V
      // 42: aload 0
      // 43: getfield net/sqlcipher/database/SQLiteCursor.mQuery Lnet/sqlcipher/database/SQLiteQuery;
      // 46: invokevirtual net/sqlcipher/database/SQLiteQuery.requery ()V
      // 49: aload 0
      // 4a: invokespecial net/sqlcipher/database/SQLiteCursor.queryThreadUnlock ()V
      // 4d: aload 0
      // 4e: getfield net/sqlcipher/database/SQLiteCursor.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 51: invokevirtual net/sqlcipher/database/SQLiteDatabase.unlock ()V
      // 54: aload 0
      // 55: invokespecial net/sqlcipher/AbstractWindowedCursor.requery ()Z
      // 58: istore 1
      // 59: goto 09
      // 5c: astore 2
      // 5d: aload 0
      // 5e: invokespecial net/sqlcipher/database/SQLiteCursor.queryThreadUnlock ()V
      // 61: aload 2
      // 62: athrow
      // 63: astore 2
      // 64: aload 0
      // 65: getfield net/sqlcipher/database/SQLiteCursor.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 68: invokevirtual net/sqlcipher/database/SQLiteDatabase.unlock ()V
      // 6b: aload 2
      // 6c: athrow
      // try (10 -> 16): 51 null
      // try (16 -> 34): 51 null
      // try (34 -> 37): 46 null
      // try (37 -> 39): 51 null
      // try (47 -> 51): 51 null
   }

   public void setLoadStyle(int var1, int var2) {
      this.mMaxRead = var2;
      this.mInitialRead = var1;
      this.mLock = new ReentrantLock(true);
   }

   public void setSelectionArguments(String[] var1) {
      this.mDriver.setBindArguments(var1);
   }

   @Override
   public void setWindow(CursorWindow var1) {
      if (this.mWindow != null) {
         this.mCursorState++;
         this.queryThreadLock();

         try {
            this.mWindow.close();
         } finally {
            this.queryThreadUnlock();
         }

         this.mCount = -1;
      }

      this.mWindow = var1;
   }

   @Override
   public boolean supportsUpdates() {
      boolean var1;
      if (!TextUtils.isEmpty(this.mEditTable)) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   protected static class MainThreadNotificationHandler extends Handler {
      private final WeakReference<SQLiteCursor> wrappedCursor;

      MainThreadNotificationHandler(SQLiteCursor var1) {
         this.wrappedCursor = new WeakReference<>(var1);
      }

      public void handleMessage(Message var1) {
         SQLiteCursor var2 = this.wrappedCursor.get();
         if (var2 != null) {
            var2.notifyDataSetChange();
         }
      }
   }

   private final class QueryThread implements Runnable {
      private final int mThreadState;
      final SQLiteCursor this$0;

      QueryThread(SQLiteCursor var1, int var2) {
         this.this$0 = var1;
         this.mThreadState = var2;
      }

      private void sendMessage() {
         if (this.this$0.mNotificationHandler != null) {
            this.this$0.mNotificationHandler.sendEmptyMessage(1);
            this.this$0.mPendingData = false;
         } else {
            this.this$0.mPendingData = true;
         }
      }

      @Override
      public void run() {
         // $VF: Couldn't be decompiled
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         // java.lang.RuntimeException: parsing failure!
         //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
         //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
         //
         // Bytecode:
         // 00: aload 0
         // 01: getfield net/sqlcipher/database/SQLiteCursor$QueryThread.this$0 Lnet/sqlcipher/database/SQLiteCursor;
         // 04: invokestatic net/sqlcipher/database/SQLiteCursor.access$100 (Lnet/sqlcipher/database/SQLiteCursor;)Lnet/sqlcipher/CursorWindow;
         // 07: astore 2
         // 08: invokestatic android/os/Process.myTid ()I
         // 0b: bipush 10
         // 0d: invokestatic android/os/Process.setThreadPriority (II)V
         // 10: aload 0
         // 11: getfield net/sqlcipher/database/SQLiteCursor$QueryThread.this$0 Lnet/sqlcipher/database/SQLiteCursor;
         // 14: invokestatic net/sqlcipher/database/SQLiteCursor.access$200 (Lnet/sqlcipher/database/SQLiteCursor;)Ljava/util/concurrent/locks/ReentrantLock;
         // 17: invokevirtual java/util/concurrent/locks/ReentrantLock.lock ()V
         // 1a: aload 0
         // 1b: getfield net/sqlcipher/database/SQLiteCursor$QueryThread.this$0 Lnet/sqlcipher/database/SQLiteCursor;
         // 1e: invokestatic net/sqlcipher/database/SQLiteCursor.access$300 (Lnet/sqlcipher/database/SQLiteCursor;)I
         // 21: aload 0
         // 22: getfield net/sqlcipher/database/SQLiteCursor$QueryThread.mThreadState I
         // 25: if_icmpeq 33
         // 28: aload 0
         // 29: getfield net/sqlcipher/database/SQLiteCursor$QueryThread.this$0 Lnet/sqlcipher/database/SQLiteCursor;
         // 2c: invokestatic net/sqlcipher/database/SQLiteCursor.access$200 (Lnet/sqlcipher/database/SQLiteCursor;)Ljava/util/concurrent/locks/ReentrantLock;
         // 2f: invokevirtual java/util/concurrent/locks/ReentrantLock.unlock ()V
         // 32: return
         // 33: aload 0
         // 34: getfield net/sqlcipher/database/SQLiteCursor$QueryThread.this$0 Lnet/sqlcipher/database/SQLiteCursor;
         // 37: invokestatic net/sqlcipher/database/SQLiteCursor.access$600 (Lnet/sqlcipher/database/SQLiteCursor;)Lnet/sqlcipher/database/SQLiteQuery;
         // 3a: aload 2
         // 3b: aload 0
         // 3c: getfield net/sqlcipher/database/SQLiteCursor$QueryThread.this$0 Lnet/sqlcipher/database/SQLiteCursor;
         // 3f: invokestatic net/sqlcipher/database/SQLiteCursor.access$400 (Lnet/sqlcipher/database/SQLiteCursor;)I
         // 42: aload 0
         // 43: getfield net/sqlcipher/database/SQLiteCursor$QueryThread.this$0 Lnet/sqlcipher/database/SQLiteCursor;
         // 46: invokestatic net/sqlcipher/database/SQLiteCursor.access$500 (Lnet/sqlcipher/database/SQLiteCursor;)I
         // 49: invokevirtual net/sqlcipher/database/SQLiteQuery.fillWindow (Lnet/sqlcipher/CursorWindow;II)I
         // 4c: istore 1
         // 4d: iload 1
         // 4e: ifeq 98
         // 51: iload 1
         // 52: bipush -1
         // 53: if_icmpne 7e
         // 56: aload 0
         // 57: getfield net/sqlcipher/database/SQLiteCursor$QueryThread.this$0 Lnet/sqlcipher/database/SQLiteCursor;
         // 5a: aload 0
         // 5b: getfield net/sqlcipher/database/SQLiteCursor$QueryThread.this$0 Lnet/sqlcipher/database/SQLiteCursor;
         // 5e: invokestatic net/sqlcipher/database/SQLiteCursor.access$500 (Lnet/sqlcipher/database/SQLiteCursor;)I
         // 61: aload 0
         // 62: getfield net/sqlcipher/database/SQLiteCursor$QueryThread.this$0 Lnet/sqlcipher/database/SQLiteCursor;
         // 65: invokestatic net/sqlcipher/database/SQLiteCursor.access$400 (Lnet/sqlcipher/database/SQLiteCursor;)I
         // 68: iadd
         // 69: invokestatic net/sqlcipher/database/SQLiteCursor.access$502 (Lnet/sqlcipher/database/SQLiteCursor;I)I
         // 6c: pop
         // 6d: aload 0
         // 6e: invokespecial net/sqlcipher/database/SQLiteCursor$QueryThread.sendMessage ()V
         // 71: aload 0
         // 72: getfield net/sqlcipher/database/SQLiteCursor$QueryThread.this$0 Lnet/sqlcipher/database/SQLiteCursor;
         // 75: invokestatic net/sqlcipher/database/SQLiteCursor.access$200 (Lnet/sqlcipher/database/SQLiteCursor;)Ljava/util/concurrent/locks/ReentrantLock;
         // 78: invokevirtual java/util/concurrent/locks/ReentrantLock.unlock ()V
         // 7b: goto 10
         // 7e: aload 0
         // 7f: getfield net/sqlcipher/database/SQLiteCursor$QueryThread.this$0 Lnet/sqlcipher/database/SQLiteCursor;
         // 82: iload 1
         // 83: invokestatic net/sqlcipher/database/SQLiteCursor.access$502 (Lnet/sqlcipher/database/SQLiteCursor;I)I
         // 86: pop
         // 87: aload 0
         // 88: invokespecial net/sqlcipher/database/SQLiteCursor$QueryThread.sendMessage ()V
         // 8b: aload 0
         // 8c: getfield net/sqlcipher/database/SQLiteCursor$QueryThread.this$0 Lnet/sqlcipher/database/SQLiteCursor;
         // 8f: invokestatic net/sqlcipher/database/SQLiteCursor.access$200 (Lnet/sqlcipher/database/SQLiteCursor;)Ljava/util/concurrent/locks/ReentrantLock;
         // 92: invokevirtual java/util/concurrent/locks/ReentrantLock.unlock ()V
         // 95: goto 32
         // 98: aload 0
         // 99: getfield net/sqlcipher/database/SQLiteCursor$QueryThread.this$0 Lnet/sqlcipher/database/SQLiteCursor;
         // 9c: invokestatic net/sqlcipher/database/SQLiteCursor.access$200 (Lnet/sqlcipher/database/SQLiteCursor;)Ljava/util/concurrent/locks/ReentrantLock;
         // 9f: invokevirtual java/util/concurrent/locks/ReentrantLock.unlock ()V
         // a2: goto 32
         // a5: astore 2
         // a6: aload 0
         // a7: getfield net/sqlcipher/database/SQLiteCursor$QueryThread.this$0 Lnet/sqlcipher/database/SQLiteCursor;
         // aa: invokestatic net/sqlcipher/database/SQLiteCursor.access$200 (Lnet/sqlcipher/database/SQLiteCursor;)Ljava/util/concurrent/locks/ReentrantLock;
         // ad: invokevirtual java/util/concurrent/locks/ReentrantLock.unlock ()V
         // b0: goto 32
         // b3: astore 2
         // b4: aload 0
         // b5: getfield net/sqlcipher/database/SQLiteCursor$QueryThread.this$0 Lnet/sqlcipher/database/SQLiteCursor;
         // b8: invokestatic net/sqlcipher/database/SQLiteCursor.access$200 (Lnet/sqlcipher/database/SQLiteCursor;)Ljava/util/concurrent/locks/ReentrantLock;
         // bb: invokevirtual java/util/concurrent/locks/ReentrantLock.unlock ()V
         // be: aload 2
         // bf: athrow
         // try (22 -> 34): 74 java/lang/Exception
         // try (22 -> 34): 80 null
         // try (39 -> 52): 74 java/lang/Exception
         // try (39 -> 52): 80 null
         // try (57 -> 64): 74 java/lang/Exception
         // try (57 -> 64): 80 null
      }
   }
}
