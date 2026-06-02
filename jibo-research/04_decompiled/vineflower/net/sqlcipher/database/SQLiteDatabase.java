package net.sqlcipher.database;

import android.content.ContentValues;
import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.Map.Entry;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import net.sqlcipher.CrossProcessCursorWrapper;
import net.sqlcipher.Cursor;
import net.sqlcipher.CursorWrapper;
import net.sqlcipher.DatabaseErrorHandler;
import net.sqlcipher.SQLException;

public class SQLiteDatabase extends SQLiteClosable {
   private static final String COMMIT_SQL = "COMMIT;";
   public static final int CONFLICT_ABORT = 2;
   public static final int CONFLICT_FAIL = 3;
   public static final int CONFLICT_IGNORE = 4;
   public static final int CONFLICT_NONE = 0;
   public static final int CONFLICT_REPLACE = 5;
   public static final int CONFLICT_ROLLBACK = 1;
   private static final String[] CONFLICT_VALUES = new String[]{"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
   public static final int CREATE_IF_NECESSARY = 268435456;
   private static final Pattern EMAIL_IN_DB_PATTERN = Pattern.compile("[\\w\\.\\-]+@[\\w\\.\\-]+");
   private static final int EVENT_DB_CORRUPT = 75004;
   private static final int EVENT_DB_OPERATION = 52000;
   static final String GET_LOCK_LOG_PREFIX = "GETLOCK:";
   private static final String KEY_ENCODING = "UTF-8";
   private static final int LOCK_ACQUIRED_WARNING_THREAD_TIME_IN_MS = 100;
   private static final int LOCK_ACQUIRED_WARNING_TIME_IN_MS = 300;
   private static final int LOCK_ACQUIRED_WARNING_TIME_IN_MS_ALWAYS_PRINT = 2000;
   private static final int LOCK_WARNING_WINDOW_IN_MS = 20000;
   private static final String LOG_SLOW_QUERIES_PROPERTY = "db.log.slow_query_threshold";
   public static final int MAX_SQL_CACHE_SIZE = 250;
   private static final int MAX_WARNINGS_ON_CACHESIZE_CONDITION = 1;
   public static final String MEMORY = ":memory:";
   public static final int NO_LOCALIZED_COLLATORS = 16;
   public static final int OPEN_READONLY = 1;
   public static final int OPEN_READWRITE = 0;
   private static final int OPEN_READ_MASK = 1;
   private static final int QUERY_LOG_SQL_LENGTH = 64;
   private static final int SLEEP_AFTER_YIELD_QUANTUM = 1000;
   public static final String SQLCIPHER_ANDROID_VERSION = "3.5.7";
   public static final int SQLITE_MAX_LIKE_PATTERN_LENGTH = 50000;
   private static final String TAG = "Database";
   private static WeakHashMap<SQLiteDatabase, Object> sActiveDatabases = new WeakHashMap<>();
   private static int sQueryLogTimeInMillis = 0;
   private int mCacheFullWarnings;
   Map<String, SQLiteCompiledSql> mCompiledQueries;
   private final DatabaseErrorHandler mErrorHandler;
   private SQLiteDatabase.CursorFactory mFactory;
   private int mFlags;
   private boolean mInnerTransactionIsSuccessful;
   private long mLastLockMessageTime;
   private String mLastSqlStatement;
   private final ReentrantLock mLock = new ReentrantLock(true);
   private long mLockAcquiredThreadTime;
   private long mLockAcquiredWallTime = 0L;
   private boolean mLockingEnabled;
   private int mMaxSqlCacheSize;
   long mNativeHandle;
   private int mNumCacheHits;
   private int mNumCacheMisses;
   private String mPath;
   private String mPathForLogs;
   private WeakHashMap<SQLiteClosable, Object> mPrograms;
   private final int mSlowQueryThreshold;
   private Throwable mStackTrace;
   private final Map<String, SQLiteDatabase.SyncUpdateInfo> mSyncUpdateInfo;
   int mTempTableSequence;
   private String mTimeClosed;
   private String mTimeOpened;
   private boolean mTransactionIsSuccessful;
   private SQLiteTransactionListener mTransactionListener;

   private SQLiteDatabase(String var1, SQLiteDatabase.CursorFactory var2, int var3, DatabaseErrorHandler var4) {
      this.mLockAcquiredThreadTime = 0L;
      this.mLastLockMessageTime = 0L;
      this.mLastSqlStatement = null;
      this.mNativeHandle = 0L;
      this.mTempTableSequence = 0;
      this.mPathForLogs = null;
      this.mCompiledQueries = new HashMap<>();
      this.mMaxSqlCacheSize = 250;
      this.mTimeOpened = null;
      this.mTimeClosed = null;
      this.mStackTrace = null;
      this.mLockingEnabled = true;
      this.mSyncUpdateInfo = new HashMap<>();
      if (var1 == null) {
         throw new IllegalArgumentException("path should not be null");
      }

      this.mFlags = var3;
      this.mPath = var1;
      this.mSlowQueryThreshold = -1;
      this.mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
      this.mFactory = var2;
      this.mPrograms = new WeakHashMap<>();
      this.mErrorHandler = var4;
   }

   public SQLiteDatabase(String var1, char[] var2, SQLiteDatabase.CursorFactory var3, int var4) {
      this(var1, var3, var4, null);
      this.openDatabaseInternal(var2, null);
   }

   public SQLiteDatabase(String var1, char[] var2, SQLiteDatabase.CursorFactory var3, int var4, SQLiteDatabaseHook var5) {
      this(var1, var3, var4, null);
      this.openDatabaseInternal(var2, var5);
   }

   private void checkLockHoldTime() {
      long var2 = SystemClock.elapsedRealtime();
      long var4 = var2 - this.mLockAcquiredWallTime;
      if ((var4 >= 2000L || Log.isLoggable("Database", 2) || var2 - this.mLastLockMessageTime >= 20000L) && var4 > 300L) {
         int var1 = (int)((Debug.threadCpuTimeNanos() - this.mLockAcquiredThreadTime) / 1000000L);
         if (var1 > 100 || var4 > 2000L) {
            this.mLastLockMessageTime = var2;
            String var6 = "lock held on " + this.mPath + " for " + var4 + "ms. Thread time was " + var1 + "ms";
            if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING_STACK_TRACE) {
               Log.d("Database", var6, new Exception());
            } else {
               Log.d("Database", var6);
            }
         }
      }
   }

   private void closeClosable() {
      this.deallocCachedSqlStatements();
      Iterator var1 = this.mPrograms.entrySet().iterator();

      while (var1.hasNext()) {
         SQLiteClosable var2 = (SQLiteClosable)((Entry)var1.next()).getKey();
         if (var2 != null) {
            var2.onAllReferencesReleasedFromContainer();
         }
      }
   }

   private boolean containsNull(char[] var1) {
      boolean var5 = false;
      boolean var4 = var5;
      if (var1 != null) {
         var4 = var5;
         if (var1.length > 0) {
            int var3 = var1.length;
            int var2 = 0;

            while (true) {
               var4 = var5;
               if (var2 >= var3) {
                  break;
               }

               if (var1[var2] == 0) {
                  var4 = true;
                  break;
               }

               var2++;
            }
         }
      }

      return var4;
   }

   public static SQLiteDatabase create(SQLiteDatabase.CursorFactory var0, String var1) {
      char[] var2;
      if (var1 == null) {
         var2 = null;
      } else {
         var2 = var1.toCharArray();
      }

      return openDatabase(":memory:", var2, var0, 268435456);
   }

   public static SQLiteDatabase create(SQLiteDatabase.CursorFactory var0, char[] var1) {
      return openDatabase(":memory:", var1, var0, 268435456);
   }

   private native void dbclose();

   private native void dbopen(String var1, int var2);

   private void deallocCachedSqlStatements() {
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
      // 01: getfield net/sqlcipher/database/SQLiteDatabase.mCompiledQueries Ljava/util/Map;
      // 04: astore 1
      // 05: aload 1
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield net/sqlcipher/database/SQLiteDatabase.mCompiledQueries Ljava/util/Map;
      // 0b: invokeinterface java/util/Map.values ()Ljava/util/Collection; 1
      // 10: invokeinterface java/util/Collection.iterator ()Ljava/util/Iterator; 1
      // 15: astore 2
      // 16: aload 2
      // 17: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 1c: ifeq 33
      // 1f: aload 2
      // 20: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 25: checkcast net/sqlcipher/database/SQLiteCompiledSql
      // 28: invokevirtual net/sqlcipher/database/SQLiteCompiledSql.releaseSqlStatement ()V
      // 2b: goto 16
      // 2e: astore 2
      // 2f: aload 1
      // 30: monitorexit
      // 31: aload 2
      // 32: athrow
      // 33: aload 0
      // 34: getfield net/sqlcipher/database/SQLiteDatabase.mCompiledQueries Ljava/util/Map;
      // 37: invokeinterface java/util/Map.clear ()V 1
      // 3c: aload 1
      // 3d: monitorexit
      // 3e: return
      // try (5 -> 10): 18 null
      // try (10 -> 17): 18 null
      // try (19 -> 21): 18 null
      // try (23 -> 28): 18 null
   }

   private native void enableSqlProfiling(String var1);

   private native void enableSqlTracing(String var1);

   public static String findEditTable(String var0) {
      if (TextUtils.isEmpty(var0)) {
         throw new IllegalStateException("Invalid tables");
      }

      int var1 = var0.indexOf(32);
      int var2 = var0.indexOf(44);
      String var3;
      if (var1 <= 0 || var1 >= var2 && var2 >= 0) {
         var3 = var0;
         if (var2 > 0) {
            if (var2 >= var1) {
               var3 = var0;
               if (var1 >= 0) {
                  return var3;
               }
            }

            var3 = var0.substring(0, var2);
         }
      } else {
         var3 = var0.substring(0, var1);
      }

      return var3;
   }

   private static ArrayList<SQLiteDatabase> getActiveDatabases() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: new java/util/ArrayList
      // 03: dup
      // 04: invokespecial java/util/ArrayList.<init> ()V
      // 07: astore 1
      // 08: getstatic net/sqlcipher/database/SQLiteDatabase.sActiveDatabases Ljava/util/WeakHashMap;
      // 0b: astore 0
      // 0c: aload 0
      // 0d: monitorenter
      // 0e: aload 1
      // 0f: getstatic net/sqlcipher/database/SQLiteDatabase.sActiveDatabases Ljava/util/WeakHashMap;
      // 12: invokevirtual java/util/WeakHashMap.keySet ()Ljava/util/Set;
      // 15: invokevirtual java/util/ArrayList.addAll (Ljava/util/Collection;)Z
      // 18: pop
      // 19: aload 0
      // 1a: monitorexit
      // 1b: aload 1
      // 1c: areturn
      // 1d: astore 1
      // 1e: aload 0
      // 1f: monitorexit
      // 20: aload 1
      // 21: athrow
      // try (8 -> 15): 17 null
      // try (18 -> 20): 17 null
   }

   private static ArrayList<Pair<String, String>> getAttachedDbs(SQLiteDatabase var0) {
      ArrayList var1 = null;
      ArrayList var2;
      if (!var0.isOpen()) {
         var2 = var1;
      } else {
         var1 = new ArrayList();
         Cursor var3 = var0.rawQuery("pragma database_list;", (String[])null);

         while (var3.moveToNext()) {
            var1.add(new Pair(var3.getString(1), var3.getString(2)));
         }

         var3.close();
         var2 = var1;
      }

      return var2;
   }

   private byte[] getBytes(char[] var1) {
      byte[] var3;
      if (var1 != null && var1.length != 0) {
         CharBuffer var4 = CharBuffer.wrap(var1);
         ByteBuffer var2 = Charset.forName("UTF-8").encode(var4);
         var3 = new byte[var2.limit()];
         var2.get(var3);
      } else {
         var3 = null;
      }

      return var3;
   }

   static ArrayList<SQLiteDebug.DbStats> getDbStats() {
      ArrayList var8 = new ArrayList();

      for (SQLiteDatabase var7 : getActiveDatabases()) {
         if (var7 != null && var7.isOpen()) {
            int var2 = var7.native_getDbLookaside();
            String var5 = var7.getPath();
            int var0 = var5.lastIndexOf("/");
            if (var0 != -1) {
               var0++;
            } else {
               var0 = 0;
            }

            String var6 = var5.substring(var0);
            ArrayList var10 = getAttachedDbs(var7);
            if (var10 != null) {
               int var1 = 0;
               var0 = var2;

               while (var1 < var10.size()) {
                  Pair var11 = (Pair)var10.get(var1);
                  long var3 = getPragmaVal(var7, (String)var11.first + ".page_count;");
                  if (var1 == 0) {
                     var5 = var6;
                  } else {
                     var5 = "  (attached) " + (String)var11.first;
                     if (((String)var11.second).trim().length() > 0) {
                        var0 = ((String)var11.second).lastIndexOf("/");
                        StringBuilder var17 = new StringBuilder().append(var5).append(" : ");
                        String var18 = (String)var11.second;
                        if (var0 != -1) {
                           var0++;
                        } else {
                           var0 = 0;
                        }

                        var5 = var17.append(var18.substring(var0)).toString();
                        var0 = 0;
                     } else {
                        var0 = 0;
                     }
                  }

                  if (var3 > 0L) {
                     var8.add(new SQLiteDebug.DbStats(var5, var3, var7.getPageSize(), var0));
                  }

                  var1++;
               }
            }
         }
      }

      return var8;
   }

   private String getPathForLogs() {
      String var1;
      if (this.mPathForLogs != null) {
         var1 = this.mPathForLogs;
      } else if (this.mPath == null) {
         var1 = null;
      } else {
         if (this.mPath.indexOf(64) == -1) {
            this.mPathForLogs = this.mPath;
         } else {
            this.mPathForLogs = EMAIL_IN_DB_PATTERN.matcher(this.mPath).replaceAll("XX@YY");
         }

         var1 = this.mPathForLogs;
      }

      return var1;
   }

   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private static long getPragmaVal(SQLiteDatabase var0, String var1) {
      long var4;
      if (!var0.isOpen()) {
         var4 = 0L;
      } else {
         Object var6 = null;

         long var2;
         SQLiteStatement var7;
         label82: {
            label74: {
               try {
                  StringBuilder var8 = new StringBuilder();
                  var7 = new SQLiteStatement(var0, var8.append("PRAGMA ").append(var1).toString());
               } catch (Throwable var14) {
                  var15 = (SQLiteStatement)var6;
                  var6 = var14;
                  break label74;
               }

               label71:
               try {
                  var2 = var7.simpleQueryForLong();
                  break label82;
               } catch (Throwable var13) {
                  SQLiteStatement var16 = var7;
                  var6 = var13;
                  var15 = var16;
                  break label71;
               }
            }

            if (var15 != null) {
               var15.close();
            }

            throw var6;
         }

         var4 = var2;
         if (var7 != null) {
            var7.close();
            var4 = var2;
         }
      }

      return var4;
   }

   private String getTime() {
      return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS ", Locale.US).format(System.currentTimeMillis());
   }

   private native void key(byte[] var1) throws SQLException;

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private void keyDatabase(SQLiteDatabaseHook var1, Runnable var2) {
      if (var1 != null) {
         var1.preKey(this);
      }

      if (var2 != null) {
         var2.run();
      }

      if (var1 != null) {
         var1.postKey(this);
      }

      if (SQLiteDebug.DEBUG_SQL_CACHE) {
         this.mTimeOpened = this.getTime();
      }

      try {
         var5 = this.rawQuery("select count(*) from sqlite_master;", new String[0]);
      } catch (RuntimeException var4) {
         Log.e("Database", var4.getMessage(), var4);
         throw var4;
      }

      if (var5 != null) {
         try {
            var5.moveToFirst();
            var5.getInt(0);
            var5.close();
         } catch (RuntimeException var3) {
            Log.e("Database", var3.getMessage(), var3);
            throw var3;
         }
      }
   }

   private native void key_mutf8(char[] var1) throws SQLException;

   private static void loadICUData(Context param0, File param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aconst_null
      // 001: astore 3
      // 002: aconst_null
      // 003: astore 4
      // 005: new java/io/File
      // 008: dup
      // 009: aload 1
      // 00a: ldc_w "icu"
      // 00d: invokespecial java/io/File.<init> (Ljava/io/File;Ljava/lang/String;)V
      // 010: astore 1
      // 011: new java/io/File
      // 014: dup
      // 015: aload 1
      // 016: ldc_w "icudt46l.dat"
      // 019: invokespecial java/io/File.<init> (Ljava/io/File;Ljava/lang/String;)V
      // 01c: astore 5
      // 01e: aload 1
      // 01f: invokevirtual java/io/File.exists ()Z
      // 022: ifne 02a
      // 025: aload 1
      // 026: invokevirtual java/io/File.mkdirs ()Z
      // 029: pop
      // 02a: aload 5
      // 02c: invokevirtual java/io/File.exists ()Z
      // 02f: ifne 0c3
      // 032: new java/util/zip/ZipInputStream
      // 035: astore 1
      // 036: aload 1
      // 037: aload 0
      // 038: invokevirtual android/content/Context.getAssets ()Landroid/content/res/AssetManager;
      // 03b: ldc_w "icudt46l.zip"
      // 03e: invokevirtual android/content/res/AssetManager.open (Ljava/lang/String;)Ljava/io/InputStream;
      // 041: invokespecial java/util/zip/ZipInputStream.<init> (Ljava/io/InputStream;)V
      // 044: aload 1
      // 045: invokevirtual java/util/zip/ZipInputStream.getNextEntry ()Ljava/util/zip/ZipEntry;
      // 048: pop
      // 049: new java/io/FileOutputStream
      // 04c: astore 0
      // 04d: aload 0
      // 04e: aload 5
      // 050: invokespecial java/io/FileOutputStream.<init> (Ljava/io/File;)V
      // 053: sipush 1024
      // 056: newarray 8
      // 058: astore 6
      // 05a: aload 1
      // 05b: aload 6
      // 05d: invokevirtual java/util/zip/ZipInputStream.read ([B)I
      // 060: istore 2
      // 061: aload 1
      // 062: astore 4
      // 064: aload 0
      // 065: astore 3
      // 066: iload 2
      // 067: ifle 0c8
      // 06a: aload 0
      // 06b: aload 6
      // 06d: bipush 0
      // 06e: iload 2
      // 06f: invokevirtual java/io/OutputStream.write ([BII)V
      // 072: goto 05a
      // 075: astore 3
      // 076: aload 1
      // 077: astore 4
      // 079: aload 0
      // 07a: astore 1
      // 07b: aload 4
      // 07d: astore 0
      // 07e: ldc "Database"
      // 080: ldc_w "Error copying icu dat file"
      // 083: aload 3
      // 084: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 087: pop
      // 088: aload 5
      // 08a: invokevirtual java/io/File.exists ()Z
      // 08d: ifeq 096
      // 090: aload 5
      // 092: invokevirtual java/io/File.delete ()Z
      // 095: pop
      // 096: new java/lang/RuntimeException
      // 099: astore 4
      // 09b: aload 4
      // 09d: aload 3
      // 09e: invokespecial java/lang/RuntimeException.<init> (Ljava/lang/Throwable;)V
      // 0a1: aload 4
      // 0a3: athrow
      // 0a4: astore 4
      // 0a6: aload 1
      // 0a7: astore 3
      // 0a8: aload 0
      // 0a9: astore 1
      // 0aa: aload 4
      // 0ac: astore 0
      // 0ad: aload 1
      // 0ae: ifnull 0b5
      // 0b1: aload 1
      // 0b2: invokevirtual java/util/zip/ZipInputStream.close ()V
      // 0b5: aload 3
      // 0b6: ifnull 0c1
      // 0b9: aload 3
      // 0ba: invokevirtual java/io/OutputStream.flush ()V
      // 0bd: aload 3
      // 0be: invokevirtual java/io/OutputStream.close ()V
      // 0c1: aload 0
      // 0c2: athrow
      // 0c3: aconst_null
      // 0c4: astore 4
      // 0c6: aconst_null
      // 0c7: astore 3
      // 0c8: aload 4
      // 0ca: ifnull 0d2
      // 0cd: aload 4
      // 0cf: invokevirtual java/util/zip/ZipInputStream.close ()V
      // 0d2: aload 3
      // 0d3: ifnull 0de
      // 0d6: aload 3
      // 0d7: invokevirtual java/io/OutputStream.flush ()V
      // 0da: aload 3
      // 0db: invokevirtual java/io/OutputStream.close ()V
      // 0de: return
      // 0df: astore 0
      // 0e0: ldc "Database"
      // 0e2: ldc_w "Error in closing streams IO streams after expanding ICU dat file"
      // 0e5: aload 0
      // 0e6: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 0e9: pop
      // 0ea: new java/lang/RuntimeException
      // 0ed: dup
      // 0ee: aload 0
      // 0ef: invokespecial java/lang/RuntimeException.<init> (Ljava/lang/Throwable;)V
      // 0f2: athrow
      // 0f3: astore 0
      // 0f4: ldc "Database"
      // 0f6: ldc_w "Error in closing streams IO streams after expanding ICU dat file"
      // 0f9: aload 0
      // 0fa: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 0fd: pop
      // 0fe: new java/lang/RuntimeException
      // 101: dup
      // 102: aload 0
      // 103: invokespecial java/lang/RuntimeException.<init> (Ljava/lang/Throwable;)V
      // 106: athrow
      // 107: astore 0
      // 108: aconst_null
      // 109: astore 4
      // 10b: aload 3
      // 10c: astore 1
      // 10d: aload 4
      // 10f: astore 3
      // 110: goto 0ad
      // 113: astore 0
      // 114: aconst_null
      // 115: astore 3
      // 116: goto 0ad
      // 119: astore 4
      // 11b: aload 0
      // 11c: astore 3
      // 11d: aload 4
      // 11f: astore 0
      // 120: goto 0ad
      // 123: astore 3
      // 124: aconst_null
      // 125: astore 1
      // 126: aload 4
      // 128: astore 0
      // 129: goto 07e
      // 12c: astore 3
      // 12d: aconst_null
      // 12e: astore 4
      // 130: aload 1
      // 131: astore 0
      // 132: aload 4
      // 134: astore 1
      // 135: goto 07e
      // try (16 -> 22): 159 java/lang/Exception
      // try (16 -> 22): 141 null
      // try (22 -> 33): 159 java/lang/Exception
      // try (22 -> 33): 141 null
      // try (33 -> 41): 165 java/lang/Exception
      // try (33 -> 41): 149 null
      // try (41 -> 44): 60 java/lang/Exception
      // try (41 -> 44): 153 null
      // try (44 -> 48): 60 java/lang/Exception
      // try (44 -> 48): 153 null
      // try (54 -> 59): 60 java/lang/Exception
      // try (54 -> 59): 153 null
      // try (67 -> 78): 85 null
      // try (78 -> 85): 85 null
      // try (94 -> 96): 130 java/io/IOException
      // try (98 -> 102): 130 java/io/IOException
      // try (110 -> 112): 119 java/io/IOException
      // try (114 -> 118): 119 java/io/IOException
   }

   public static void loadLibs(Context var0) {
      synchronized (SQLiteDatabase.class) {
         loadLibs(var0, var0.getFilesDir());
      }
   }

   public static void loadLibs(Context var0, File var1) {
      synchronized (SQLiteDatabase.class) {
         SQLiteDatabase.LibraryLoader var2 = new SQLiteDatabase.LibraryLoader() {
            @Override
            public void loadLibraries(String... var1) {
               int var3 = var1.length;

               for (int var2x = 0; var2x < var3; var2x++) {
                  System.loadLibrary(var1[var2x]);
               }
            }
         };
         loadLibs(var0, var1, var2);
      }
   }

   public static void loadLibs(Context var0, File var1, SQLiteDatabase.LibraryLoader var2) {
      synchronized (SQLiteDatabase.class) {
         var2.loadLibraries("sqlcipher");
      }
   }

   public static void loadLibs(Context var0, SQLiteDatabase.LibraryLoader var1) {
      synchronized (SQLiteDatabase.class) {
         loadLibs(var0, var0.getFilesDir(), var1);
      }
   }

   private void lockForced() {
      this.mLock.lock();
      if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING && this.mLock.getHoldCount() == 1) {
         this.mLockAcquiredWallTime = SystemClock.elapsedRealtime();
         this.mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
      }
   }

   private void markTableSyncable(String param1, String param2, String param3, String param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokevirtual net/sqlcipher/database/SQLiteDatabase.lock ()V
      // 04: new java/lang/StringBuilder
      // 07: astore 5
      // 09: aload 5
      // 0b: invokespecial java/lang/StringBuilder.<init> ()V
      // 0e: aload 0
      // 0f: aload 5
      // 11: ldc_w "SELECT _sync_dirty FROM "
      // 14: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 17: aload 3
      // 18: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1b: ldc_w " LIMIT 0"
      // 1e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 21: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 24: invokevirtual net/sqlcipher/database/SQLiteDatabase.native_execSQL (Ljava/lang/String;)V
      // 27: new java/lang/StringBuilder
      // 2a: astore 5
      // 2c: aload 5
      // 2e: invokespecial java/lang/StringBuilder.<init> ()V
      // 31: aload 0
      // 32: aload 5
      // 34: ldc_w "SELECT "
      // 37: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 3a: aload 2
      // 3b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 3e: ldc_w " FROM "
      // 41: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 44: aload 1
      // 45: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 48: ldc_w " LIMIT 0"
      // 4b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 4e: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 51: invokevirtual net/sqlcipher/database/SQLiteDatabase.native_execSQL (Ljava/lang/String;)V
      // 54: aload 0
      // 55: invokevirtual net/sqlcipher/database/SQLiteDatabase.unlock ()V
      // 58: new net/sqlcipher/database/SQLiteDatabase$SyncUpdateInfo
      // 5b: dup
      // 5c: aload 3
      // 5d: aload 4
      // 5f: aload 2
      // 60: invokespecial net/sqlcipher/database/SQLiteDatabase$SyncUpdateInfo.<init> (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
      // 63: astore 3
      // 64: aload 0
      // 65: getfield net/sqlcipher/database/SQLiteDatabase.mSyncUpdateInfo Ljava/util/Map;
      // 68: astore 2
      // 69: aload 2
      // 6a: monitorenter
      // 6b: aload 0
      // 6c: getfield net/sqlcipher/database/SQLiteDatabase.mSyncUpdateInfo Ljava/util/Map;
      // 6f: aload 1
      // 70: aload 3
      // 71: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 76: pop
      // 77: aload 2
      // 78: monitorexit
      // 79: return
      // 7a: astore 1
      // 7b: aload 0
      // 7c: invokevirtual net/sqlcipher/database/SQLiteDatabase.unlock ()V
      // 7f: aload 1
      // 80: athrow
      // 81: astore 1
      // 82: aload 2
      // 83: monitorexit
      // 84: aload 1
      // 85: athrow
      // try (2 -> 34): 57 null
      // try (48 -> 56): 62 null
      // try (63 -> 65): 62 null
   }

   private native int native_getDbLookaside();

   private native void native_key(char[] var1) throws SQLException;

   private native void native_rawExecSQL(String var1);

   private native void native_rekey(String var1) throws SQLException;

   private native int native_status(int var1, boolean var2);

   public static SQLiteDatabase openDatabase(String var0, String var1, SQLiteDatabase.CursorFactory var2, int var3) {
      return openDatabase(var0, var1, var2, var3, null);
   }

   public static SQLiteDatabase openDatabase(String var0, String var1, SQLiteDatabase.CursorFactory var2, int var3, SQLiteDatabaseHook var4) {
      return openDatabase(var0, var1, var2, var3, var4, null);
   }

   public static SQLiteDatabase openDatabase(
      String var0, String var1, SQLiteDatabase.CursorFactory var2, int var3, SQLiteDatabaseHook var4, DatabaseErrorHandler var5
   ) {
      char[] var6;
      if (var1 == null) {
         var6 = null;
      } else {
         var6 = var1.toCharArray();
      }

      return openDatabase(var0, var6, var2, var3, var4, var5);
   }

   public static SQLiteDatabase openDatabase(String var0, char[] var1, SQLiteDatabase.CursorFactory var2, int var3) {
      return openDatabase(var0, var1, var2, var3, null, null);
   }

   public static SQLiteDatabase openDatabase(String var0, char[] var1, SQLiteDatabase.CursorFactory var2, int var3, SQLiteDatabaseHook var4) {
      return openDatabase(var0, var1, var2, var3, var4, null);
   }

   public static SQLiteDatabase openDatabase(
      String param0, char[] param1, SQLiteDatabase.CursorFactory param2, int param3, SQLiteDatabaseHook param4, DatabaseErrorHandler param5
   ) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: aconst_null
      // 01: astore 8
      // 03: aload 5
      // 05: ifnull 4c
      // 08: new net/sqlcipher/database/SQLiteDatabase
      // 0b: astore 6
      // 0d: aload 6
      // 0f: aload 0
      // 10: aload 2
      // 11: iload 3
      // 12: aload 5
      // 14: invokespecial net/sqlcipher/database/SQLiteDatabase.<init> (Ljava/lang/String;Lnet/sqlcipher/database/SQLiteDatabase$CursorFactory;ILnet/sqlcipher/DatabaseErrorHandler;)V
      // 17: aload 6
      // 19: aload 1
      // 1a: aload 4
      // 1c: invokespecial net/sqlcipher/database/SQLiteDatabase.openDatabaseInternal ([CLnet/sqlcipher/database/SQLiteDatabaseHook;)V
      // 1f: getstatic net/sqlcipher/database/SQLiteDebug.DEBUG_SQL_STATEMENTS Z
      // 22: ifeq 2b
      // 25: aload 6
      // 27: aload 0
      // 28: invokespecial net/sqlcipher/database/SQLiteDatabase.enableSqlTracing (Ljava/lang/String;)V
      // 2b: getstatic net/sqlcipher/database/SQLiteDebug.DEBUG_SQL_TIME Z
      // 2e: ifeq 37
      // 31: aload 6
      // 33: aload 0
      // 34: invokespecial net/sqlcipher/database/SQLiteDatabase.enableSqlProfiling (Ljava/lang/String;)V
      // 37: getstatic net/sqlcipher/database/SQLiteDatabase.sActiveDatabases Ljava/util/WeakHashMap;
      // 3a: astore 0
      // 3b: aload 0
      // 3c: monitorenter
      // 3d: getstatic net/sqlcipher/database/SQLiteDatabase.sActiveDatabases Ljava/util/WeakHashMap;
      // 40: aload 6
      // 42: aconst_null
      // 43: invokevirtual java/util/WeakHashMap.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 46: pop
      // 47: aload 0
      // 48: monitorexit
      // 49: aload 6
      // 4b: areturn
      // 4c: new net/sqlcipher/DefaultDatabaseErrorHandler
      // 4f: dup
      // 50: invokespecial net/sqlcipher/DefaultDatabaseErrorHandler.<init> ()V
      // 53: astore 5
      // 55: goto 08
      // 58: astore 7
      // 5a: aload 8
      // 5c: astore 6
      // 5e: ldc "Database"
      // 60: new java/lang/StringBuilder
      // 63: dup
      // 64: invokespecial java/lang/StringBuilder.<init> ()V
      // 67: ldc_w "Calling error handler for corrupt database "
      // 6a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 6d: aload 0
      // 6e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 71: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 74: aload 7
      // 76: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 79: pop
      // 7a: aload 5
      // 7c: aload 6
      // 7e: invokeinterface net/sqlcipher/DatabaseErrorHandler.onCorruption (Lnet/sqlcipher/database/SQLiteDatabase;)V 2
      // 83: new net/sqlcipher/database/SQLiteDatabase
      // 86: dup
      // 87: aload 0
      // 88: aload 2
      // 89: iload 3
      // 8a: aload 5
      // 8c: invokespecial net/sqlcipher/database/SQLiteDatabase.<init> (Ljava/lang/String;Lnet/sqlcipher/database/SQLiteDatabase$CursorFactory;ILnet/sqlcipher/DatabaseErrorHandler;)V
      // 8f: astore 6
      // 91: aload 6
      // 93: aload 1
      // 94: aload 4
      // 96: invokespecial net/sqlcipher/database/SQLiteDatabase.openDatabaseInternal ([CLnet/sqlcipher/database/SQLiteDatabaseHook;)V
      // 99: goto 1f
      // 9c: astore 1
      // 9d: aload 0
      // 9e: monitorexit
      // 9f: aload 1
      // a0: athrow
      // a1: astore 7
      // a3: goto 5e
      // try (4 -> 12): 44 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (12 -> 16): 80 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (30 -> 37): 75 null
      // try (76 -> 78): 75 null
   }

   private void openDatabaseInternal(char[] param1, SQLiteDatabaseHook param2) {
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
      // 01: istore 3
      // 02: bipush 0
      // 03: istore 4
      // 05: bipush 0
      // 06: istore 5
      // 08: aload 0
      // 09: aload 1
      // 0a: invokespecial net/sqlcipher/database/SQLiteDatabase.getBytes ([C)[B
      // 0d: astore 6
      // 0f: aload 0
      // 10: aload 0
      // 11: getfield net/sqlcipher/database/SQLiteDatabase.mPath Ljava/lang/String;
      // 14: aload 0
      // 15: getfield net/sqlcipher/database/SQLiteDatabase.mFlags I
      // 18: invokespecial net/sqlcipher/database/SQLiteDatabase.dbopen (Ljava/lang/String;I)V
      // 1b: new net/sqlcipher/database/SQLiteDatabase$2
      // 1e: astore 7
      // 20: aload 7
      // 22: aload 0
      // 23: aload 6
      // 25: invokespecial net/sqlcipher/database/SQLiteDatabase$2.<init> (Lnet/sqlcipher/database/SQLiteDatabase;[B)V
      // 28: aload 0
      // 29: aload 2
      // 2a: aload 7
      // 2c: invokespecial net/sqlcipher/database/SQLiteDatabase.keyDatabase (Lnet/sqlcipher/database/SQLiteDatabaseHook;Ljava/lang/Runnable;)V
      // 2f: aload 6
      // 31: ifnull e1
      // 34: aload 6
      // 36: arraylength
      // 37: ifle e1
      // 3a: aload 6
      // 3c: arraylength
      // 3d: istore 4
      // 3f: iload 5
      // 41: istore 3
      // 42: iload 3
      // 43: iload 4
      // 45: if_icmpge e1
      // 48: aload 6
      // 4a: iload 3
      // 4b: baload
      // 4c: istore 5
      // 4e: iinc 3 1
      // 51: goto 42
      // 54: astore 7
      // 56: aload 0
      // 57: aload 1
      // 58: invokespecial net/sqlcipher/database/SQLiteDatabase.containsNull ([C)Z
      // 5b: ifeq a4
      // 5e: new net/sqlcipher/database/SQLiteDatabase$3
      // 61: astore 7
      // 63: aload 7
      // 65: aload 0
      // 66: aload 1
      // 67: invokespecial net/sqlcipher/database/SQLiteDatabase$3.<init> (Lnet/sqlcipher/database/SQLiteDatabase;[C)V
      // 6a: aload 0
      // 6b: aload 2
      // 6c: aload 7
      // 6e: invokespecial net/sqlcipher/database/SQLiteDatabase.keyDatabase (Lnet/sqlcipher/database/SQLiteDatabaseHook;Ljava/lang/Runnable;)V
      // 71: aload 6
      // 73: ifnull 82
      // 76: aload 6
      // 78: arraylength
      // 79: ifle 82
      // 7c: aload 0
      // 7d: aload 6
      // 7f: invokespecial net/sqlcipher/database/SQLiteDatabase.rekey ([B)V
      // 82: aload 6
      // 84: ifnull e1
      // 87: aload 6
      // 89: arraylength
      // 8a: ifle e1
      // 8d: aload 6
      // 8f: arraylength
      // 90: istore 4
      // 92: iload 3
      // 93: iload 4
      // 95: if_icmpge e1
      // 98: aload 6
      // 9a: iload 3
      // 9b: baload
      // 9c: istore 5
      // 9e: iinc 3 1
      // a1: goto 92
      // a4: aload 7
      // a6: athrow
      // a7: astore 1
      // a8: aload 0
      // a9: invokespecial net/sqlcipher/database/SQLiteDatabase.dbclose ()V
      // ac: getstatic net/sqlcipher/database/SQLiteDebug.DEBUG_SQL_CACHE Z
      // af: ifeq ba
      // b2: aload 0
      // b3: aload 0
      // b4: invokespecial net/sqlcipher/database/SQLiteDatabase.getTime ()Ljava/lang/String;
      // b7: putfield net/sqlcipher/database/SQLiteDatabase.mTimeClosed Ljava/lang/String;
      // ba: aload 6
      // bc: ifnull df
      // bf: aload 6
      // c1: arraylength
      // c2: ifle df
      // c5: aload 6
      // c7: arraylength
      // c8: istore 5
      // ca: iload 4
      // cc: istore 3
      // cd: iload 3
      // ce: iload 5
      // d0: if_icmpge df
      // d3: aload 6
      // d5: iload 3
      // d6: baload
      // d7: istore 4
      // d9: iinc 3 1
      // dc: goto cd
      // df: aload 1
      // e0: athrow
      // e1: return
      // try (16 -> 26): 45 java/lang/RuntimeException
      // try (16 -> 26): 87 null
      // try (46 -> 60): 87 null
      // try (62 -> 68): 87 null
      // try (85 -> 87): 87 null
   }

   public static SQLiteDatabase openOrCreateDatabase(File var0, String var1, SQLiteDatabase.CursorFactory var2) {
      return openOrCreateDatabase(var0, var1, var2, null);
   }

   public static SQLiteDatabase openOrCreateDatabase(File var0, String var1, SQLiteDatabase.CursorFactory var2, SQLiteDatabaseHook var3) {
      return openOrCreateDatabase(var0, var1, var2, var3, null);
   }

   public static SQLiteDatabase openOrCreateDatabase(
      File var0, String var1, SQLiteDatabase.CursorFactory var2, SQLiteDatabaseHook var3, DatabaseErrorHandler var4
   ) {
      String var5;
      if (var0 == null) {
         var5 = null;
      } else {
         var5 = var0.getPath();
      }

      return openOrCreateDatabase(var5, var1, var2, var3, var4);
   }

   public static SQLiteDatabase openOrCreateDatabase(String var0, String var1, SQLiteDatabase.CursorFactory var2) {
      return openDatabase(var0, var1, var2, 268435456, null);
   }

   public static SQLiteDatabase openOrCreateDatabase(String var0, String var1, SQLiteDatabase.CursorFactory var2, SQLiteDatabaseHook var3) {
      return openDatabase(var0, var1, var2, 268435456, var3);
   }

   public static SQLiteDatabase openOrCreateDatabase(
      String var0, String var1, SQLiteDatabase.CursorFactory var2, SQLiteDatabaseHook var3, DatabaseErrorHandler var4
   ) {
      char[] var5;
      if (var1 == null) {
         var5 = null;
      } else {
         var5 = var1.toCharArray();
      }

      return openDatabase(var0, var5, var2, 268435456, var3, var4);
   }

   public static SQLiteDatabase openOrCreateDatabase(String var0, char[] var1, SQLiteDatabase.CursorFactory var2) {
      return openDatabase(var0, var1, var2, 268435456, null);
   }

   public static SQLiteDatabase openOrCreateDatabase(String var0, char[] var1, SQLiteDatabase.CursorFactory var2, SQLiteDatabaseHook var3) {
      return openDatabase(var0, var1, var2, 268435456, var3);
   }

   public static SQLiteDatabase openOrCreateDatabase(
      String var0, char[] var1, SQLiteDatabase.CursorFactory var2, SQLiteDatabaseHook var3, DatabaseErrorHandler var4
   ) {
      return openDatabase(var0, var1, var2, 268435456, var3, var4);
   }

   private native void rekey(byte[] var1) throws SQLException;

   public static native int releaseMemory();

   public static native void setICURoot(String var0);

   private void unlockForced() {
      if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING && this.mLock.getHoldCount() == 1) {
         this.checkLockHoldTime();
      }

      this.mLock.unlock();
   }

   private boolean yieldIfContendedHelper(boolean var1, long var2) {
      if (this.mLock.getQueueLength() == 0) {
         this.mLockAcquiredWallTime = SystemClock.elapsedRealtime();
         this.mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
         var1 = false;
      } else {
         this.setTransactionSuccessful();
         SQLiteTransactionListener var6 = this.mTransactionListener;
         this.endTransaction();
         if (var1 && this.isDbLockedByCurrentThread()) {
            throw new IllegalStateException("Db locked more than once. yielfIfContended cannot yield");
         }

         if (var2 > 0L) {
            while (var2 > 0L) {
               long var4;
               if (var2 < 1000L) {
                  var4 = var2;
               } else {
                  var4 = 1000L;
               }

               try {
                  Thread.sleep(var4);
               } catch (InterruptedException var8) {
                  Thread.interrupted();
               }

               var2 -= 1000L;
               if (this.mLock.getQueueLength() == 0) {
                  break;
               }
            }
         }

         this.beginTransactionWithListener(var6);
         var1 = true;
      }

      return var1;
   }

   void addSQLiteClosable(SQLiteClosable var1) {
      this.lock();

      try {
         this.mPrograms.put(var1, null);
      } finally {
         this.unlock();
      }
   }

   void addToCompiledQueries(String param1, SQLiteCompiledSql param2) {
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
      // 001: getfield net/sqlcipher/database/SQLiteDatabase.mMaxSqlCacheSize I
      // 004: ifne 035
      // 007: getstatic net/sqlcipher/database/SQLiteDebug.DEBUG_SQL_CACHE Z
      // 00a: ifeq 034
      // 00d: ldc "Database"
      // 00f: new java/lang/StringBuilder
      // 012: dup
      // 013: invokespecial java/lang/StringBuilder.<init> ()V
      // 016: ldc_w "|NOT adding_sql_to_cache|"
      // 019: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 01c: aload 0
      // 01d: invokevirtual net/sqlcipher/database/SQLiteDatabase.getPath ()Ljava/lang/String;
      // 020: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 023: ldc_w "|"
      // 026: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 029: aload 1
      // 02a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 02d: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 030: invokestatic android/util/Log.v (Ljava/lang/String;Ljava/lang/String;)I
      // 033: pop
      // 034: return
      // 035: aload 0
      // 036: getfield net/sqlcipher/database/SQLiteDatabase.mCompiledQueries Ljava/util/Map;
      // 039: astore 4
      // 03b: aload 4
      // 03d: monitorenter
      // 03e: aload 0
      // 03f: getfield net/sqlcipher/database/SQLiteDatabase.mCompiledQueries Ljava/util/Map;
      // 042: aload 1
      // 043: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 048: checkcast net/sqlcipher/database/SQLiteCompiledSql
      // 04b: ifnull 05a
      // 04e: aload 4
      // 050: monitorexit
      // 051: goto 034
      // 054: astore 1
      // 055: aload 4
      // 057: monitorexit
      // 058: aload 1
      // 059: athrow
      // 05a: aload 0
      // 05b: getfield net/sqlcipher/database/SQLiteDatabase.mCompiledQueries Ljava/util/Map;
      // 05e: invokeinterface java/util/Map.size ()I 1
      // 063: aload 0
      // 064: getfield net/sqlcipher/database/SQLiteDatabase.mMaxSqlCacheSize I
      // 067: if_icmpne 0b6
      // 06a: aload 0
      // 06b: getfield net/sqlcipher/database/SQLiteDatabase.mCacheFullWarnings I
      // 06e: bipush 1
      // 06f: iadd
      // 070: istore 3
      // 071: aload 0
      // 072: iload 3
      // 073: putfield net/sqlcipher/database/SQLiteDatabase.mCacheFullWarnings I
      // 076: iload 3
      // 077: bipush 1
      // 078: if_icmpne 0b0
      // 07b: new java/lang/StringBuilder
      // 07e: astore 2
      // 07f: aload 2
      // 080: invokespecial java/lang/StringBuilder.<init> ()V
      // 083: ldc "Database"
      // 085: aload 2
      // 086: ldc_w "Reached MAX size for compiled-sql statement cache for database "
      // 089: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 08c: aload 0
      // 08d: invokevirtual net/sqlcipher/database/SQLiteDatabase.getPath ()Ljava/lang/String;
      // 090: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 093: ldc_w "; i.e., NO space for this sql statement in cache: "
      // 096: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 099: aload 1
      // 09a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 09d: ldc_w ". Please change your sql statements to use '?' for "
      // 0a0: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0a3: ldc_w "bindargs, instead of using actual values"
      // 0a6: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0a9: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0ac: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // 0af: pop
      // 0b0: aload 4
      // 0b2: monitorexit
      // 0b3: goto 034
      // 0b6: aload 0
      // 0b7: getfield net/sqlcipher/database/SQLiteDatabase.mCompiledQueries Ljava/util/Map;
      // 0ba: aload 1
      // 0bb: aload 2
      // 0bc: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 0c1: pop
      // 0c2: getstatic net/sqlcipher/database/SQLiteDebug.DEBUG_SQL_CACHE Z
      // 0c5: ifeq 0b0
      // 0c8: new java/lang/StringBuilder
      // 0cb: astore 2
      // 0cc: aload 2
      // 0cd: invokespecial java/lang/StringBuilder.<init> ()V
      // 0d0: ldc "Database"
      // 0d2: aload 2
      // 0d3: ldc_w "|adding_sql_to_cache|"
      // 0d6: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0d9: aload 0
      // 0da: invokevirtual net/sqlcipher/database/SQLiteDatabase.getPath ()Ljava/lang/String;
      // 0dd: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0e0: ldc_w "|"
      // 0e3: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0e6: aload 0
      // 0e7: getfield net/sqlcipher/database/SQLiteDatabase.mCompiledQueries Ljava/util/Map;
      // 0ea: invokeinterface java/util/Map.size ()I 1
      // 0ef: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 0f2: ldc_w "|"
      // 0f5: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0f8: aload 1
      // 0f9: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0fc: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0ff: invokestatic android/util/Log.v (Ljava/lang/String;Ljava/lang/String;)I
      // 102: pop
      // 103: goto 0b0
      // try (27 -> 35): 36 null
      // try (37 -> 39): 36 null
      // try (41 -> 55): 36 null
      // try (58 -> 80): 36 null
      // try (80 -> 82): 36 null
      // try (83 -> 115): 36 null
   }

   public void beginTransaction() {
      this.beginTransactionWithListener(null);
   }

   public void beginTransactionWithListener(SQLiteTransactionListener param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokespecial net/sqlcipher/database/SQLiteDatabase.lockForced ()V
      // 04: aload 0
      // 05: invokevirtual net/sqlcipher/database/SQLiteDatabase.isOpen ()Z
      // 08: ifne 16
      // 0b: new java/lang/IllegalStateException
      // 0e: dup
      // 0f: ldc_w "database not open"
      // 12: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 15: athrow
      // 16: aload 0
      // 17: getfield net/sqlcipher/database/SQLiteDatabase.mLock Ljava/util/concurrent/locks/ReentrantLock;
      // 1a: invokevirtual java/util/concurrent/locks/ReentrantLock.getHoldCount ()I
      // 1d: bipush 1
      // 1e: if_icmple 46
      // 21: aload 0
      // 22: getfield net/sqlcipher/database/SQLiteDatabase.mInnerTransactionIsSuccessful Z
      // 25: ifeq 66
      // 28: new java/lang/IllegalStateException
      // 2b: astore 1
      // 2c: aload 1
      // 2d: ldc_w "Cannot call beginTransaction between calling setTransactionSuccessful and endTransaction"
      // 30: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 33: ldc "Database"
      // 35: ldc_w "beginTransaction() failed"
      // 38: aload 1
      // 39: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 3c: pop
      // 3d: aload 1
      // 3e: athrow
      // 3f: astore 1
      // 40: aload 0
      // 41: invokespecial net/sqlcipher/database/SQLiteDatabase.unlockForced ()V
      // 44: aload 1
      // 45: athrow
      // 46: aload 0
      // 47: ldc_w "BEGIN EXCLUSIVE;"
      // 4a: invokevirtual net/sqlcipher/database/SQLiteDatabase.execSQL (Ljava/lang/String;)V
      // 4d: aload 0
      // 4e: aload 1
      // 4f: putfield net/sqlcipher/database/SQLiteDatabase.mTransactionListener Lnet/sqlcipher/database/SQLiteTransactionListener;
      // 52: aload 0
      // 53: bipush 1
      // 54: putfield net/sqlcipher/database/SQLiteDatabase.mTransactionIsSuccessful Z
      // 57: aload 0
      // 58: bipush 0
      // 59: putfield net/sqlcipher/database/SQLiteDatabase.mInnerTransactionIsSuccessful Z
      // 5c: aload 1
      // 5d: ifnull 66
      // 60: aload 1
      // 61: invokeinterface net/sqlcipher/database/SQLiteTransactionListener.onBegin ()V 1
      // 66: return
      // 67: astore 1
      // 68: aload 0
      // 69: ldc_w "ROLLBACK;"
      // 6c: invokevirtual net/sqlcipher/database/SQLiteDatabase.execSQL (Ljava/lang/String;)V
      // 6f: aload 1
      // 70: athrow
      // try (10 -> 30): 30 null
      // try (35 -> 47): 30 null
      // try (49 -> 51): 52 java/lang/RuntimeException
      // try (49 -> 51): 30 null
      // try (53 -> 58): 30 null
   }

   public void changePassword(String var1) throws SQLiteException {
      if (!this.isOpen()) {
         throw new SQLiteException("database not open");
      }

      if (var1 != null) {
         byte[] var5 = this.getBytes(var1.toCharArray());
         this.rekey(var5);

         for (byte var4 : var5) {
            ;
         }
      }
   }

   public void changePassword(char[] var1) throws SQLiteException {
      if (!this.isOpen()) {
         throw new SQLiteException("database not open");
      }

      if (var1 != null) {
         byte[] var5 = this.getBytes(var1);
         this.rekey(var5);

         for (byte var4 : var5) {
            ;
         }
      }
   }

   public void close() {
      if (this.isOpen()) {
         this.lock();

         try {
            this.closeClosable();
            this.onAllReferencesReleased();
         } finally {
            this.unlock();
         }
      }
   }

   public SQLiteStatement compileStatement(String var1) throws SQLException {
      this.lock();
      if (!this.isOpen()) {
         throw new IllegalStateException("database not open");
      }

      try {
         return new SQLiteStatement(this, var1);
      } finally {
         this.unlock();
      }
   }

   public int delete(String param1, String param2, String[] param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aload 0
      // 001: invokevirtual net/sqlcipher/database/SQLiteDatabase.lock ()V
      // 004: aload 0
      // 005: invokevirtual net/sqlcipher/database/SQLiteDatabase.isOpen ()Z
      // 008: ifne 016
      // 00b: new java/lang/IllegalStateException
      // 00e: dup
      // 00f: ldc_w "database not open"
      // 012: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 015: athrow
      // 016: aconst_null
      // 017: astore 9
      // 019: aconst_null
      // 01a: astore 8
      // 01c: aload 8
      // 01e: astore 7
      // 020: aload 9
      // 022: astore 6
      // 024: new java/lang/StringBuilder
      // 027: astore 10
      // 029: aload 8
      // 02b: astore 7
      // 02d: aload 9
      // 02f: astore 6
      // 031: aload 10
      // 033: invokespecial java/lang/StringBuilder.<init> ()V
      // 036: aload 8
      // 038: astore 7
      // 03a: aload 9
      // 03c: astore 6
      // 03e: aload 10
      // 040: ldc_w "DELETE FROM "
      // 043: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 046: aload 1
      // 047: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 04a: astore 10
      // 04c: aload 8
      // 04e: astore 7
      // 050: aload 9
      // 052: astore 6
      // 054: aload 2
      // 055: invokestatic android/text/TextUtils.isEmpty (Ljava/lang/CharSequence;)Z
      // 058: ifne 0d0
      // 05b: aload 8
      // 05d: astore 7
      // 05f: aload 9
      // 061: astore 6
      // 063: new java/lang/StringBuilder
      // 066: astore 1
      // 067: aload 8
      // 069: astore 7
      // 06b: aload 9
      // 06d: astore 6
      // 06f: aload 1
      // 070: invokespecial java/lang/StringBuilder.<init> ()V
      // 073: aload 8
      // 075: astore 7
      // 077: aload 9
      // 079: astore 6
      // 07b: aload 1
      // 07c: ldc_w " WHERE "
      // 07f: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 082: aload 2
      // 083: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 086: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 089: astore 1
      // 08a: aload 8
      // 08c: astore 7
      // 08e: aload 9
      // 090: astore 6
      // 092: aload 0
      // 093: aload 10
      // 095: aload 1
      // 096: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 099: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 09c: invokevirtual net/sqlcipher/database/SQLiteDatabase.compileStatement (Ljava/lang/String;)Lnet/sqlcipher/database/SQLiteStatement;
      // 09f: astore 1
      // 0a0: aload 3
      // 0a1: ifnull 0d6
      // 0a4: aload 1
      // 0a5: astore 7
      // 0a7: aload 1
      // 0a8: astore 6
      // 0aa: aload 3
      // 0ab: arraylength
      // 0ac: istore 5
      // 0ae: bipush 0
      // 0af: istore 4
      // 0b1: iload 4
      // 0b3: iload 5
      // 0b5: if_icmpge 0d6
      // 0b8: aload 1
      // 0b9: astore 7
      // 0bb: aload 1
      // 0bc: astore 6
      // 0be: aload 1
      // 0bf: iload 4
      // 0c1: bipush 1
      // 0c2: iadd
      // 0c3: aload 3
      // 0c4: iload 4
      // 0c6: aaload
      // 0c7: invokestatic net/sqlcipher/DatabaseUtils.bindObjectToProgram (Lnet/sqlcipher/database/SQLiteProgram;ILjava/lang/Object;)V
      // 0ca: iinc 4 1
      // 0cd: goto 0b1
      // 0d0: ldc ""
      // 0d2: astore 1
      // 0d3: goto 08a
      // 0d6: aload 1
      // 0d7: astore 7
      // 0d9: aload 1
      // 0da: astore 6
      // 0dc: aload 1
      // 0dd: invokevirtual net/sqlcipher/database/SQLiteStatement.execute ()V
      // 0e0: aload 1
      // 0e1: astore 7
      // 0e3: aload 1
      // 0e4: astore 6
      // 0e6: aload 0
      // 0e7: invokevirtual net/sqlcipher/database/SQLiteDatabase.lastChangeCount ()I
      // 0ea: istore 4
      // 0ec: aload 1
      // 0ed: ifnull 0f4
      // 0f0: aload 1
      // 0f1: invokevirtual net/sqlcipher/database/SQLiteStatement.close ()V
      // 0f4: aload 0
      // 0f5: invokevirtual net/sqlcipher/database/SQLiteDatabase.unlock ()V
      // 0f8: iload 4
      // 0fa: ireturn
      // 0fb: astore 1
      // 0fc: aload 7
      // 0fe: astore 6
      // 100: aload 0
      // 101: invokevirtual net/sqlcipher/database/SQLiteDatabase.onCorruption ()V
      // 104: aload 7
      // 106: astore 6
      // 108: aload 1
      // 109: athrow
      // 10a: astore 1
      // 10b: aload 6
      // 10d: ifnull 115
      // 110: aload 6
      // 112: invokevirtual net/sqlcipher/database/SQLiteStatement.close ()V
      // 115: aload 0
      // 116: invokevirtual net/sqlcipher/database/SQLiteDatabase.unlock ()V
      // 119: aload 1
      // 11a: athrow
      // try (18 -> 20): 129 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (18 -> 20): 138 null
      // try (24 -> 26): 129 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (24 -> 26): 138 null
      // try (30 -> 36): 129 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (30 -> 36): 138 null
      // try (40 -> 43): 129 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (40 -> 43): 138 null
      // try (47 -> 49): 129 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (47 -> 49): 138 null
      // try (53 -> 55): 129 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (53 -> 55): 138 null
      // try (59 -> 66): 129 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (59 -> 66): 138 null
      // try (70 -> 77): 129 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (70 -> 77): 138 null
      // try (83 -> 86): 129 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (83 -> 86): 138 null
      // try (95 -> 103): 129 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (95 -> 103): 138 null
      // try (112 -> 114): 129 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (112 -> 114): 138 null
      // try (118 -> 121): 129 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (118 -> 121): 138 null
      // try (132 -> 134): 138 null
      // try (136 -> 138): 138 null
   }

   public void endTransaction() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokevirtual net/sqlcipher/database/SQLiteDatabase.isOpen ()Z
      // 04: ifne 12
      // 07: new java/lang/IllegalStateException
      // 0a: dup
      // 0b: ldc_w "database not open"
      // 0e: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 11: athrow
      // 12: aload 0
      // 13: getfield net/sqlcipher/database/SQLiteDatabase.mLock Ljava/util/concurrent/locks/ReentrantLock;
      // 16: invokevirtual java/util/concurrent/locks/ReentrantLock.isHeldByCurrentThread ()Z
      // 19: ifne 27
      // 1c: new java/lang/IllegalStateException
      // 1f: dup
      // 20: ldc_w "no transaction pending"
      // 23: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 26: athrow
      // 27: aload 0
      // 28: getfield net/sqlcipher/database/SQLiteDatabase.mInnerTransactionIsSuccessful Z
      // 2b: ifeq 4a
      // 2e: aload 0
      // 2f: bipush 0
      // 30: putfield net/sqlcipher/database/SQLiteDatabase.mInnerTransactionIsSuccessful Z
      // 33: aload 0
      // 34: getfield net/sqlcipher/database/SQLiteDatabase.mLock Ljava/util/concurrent/locks/ReentrantLock;
      // 37: invokevirtual java/util/concurrent/locks/ReentrantLock.getHoldCount ()I
      // 3a: istore 1
      // 3b: iload 1
      // 3c: bipush 1
      // 3d: if_icmpeq 5e
      // 40: aload 0
      // 41: aconst_null
      // 42: putfield net/sqlcipher/database/SQLiteDatabase.mTransactionListener Lnet/sqlcipher/database/SQLiteTransactionListener;
      // 45: aload 0
      // 46: invokespecial net/sqlcipher/database/SQLiteDatabase.unlockForced ()V
      // 49: return
      // 4a: aload 0
      // 4b: bipush 0
      // 4c: putfield net/sqlcipher/database/SQLiteDatabase.mTransactionIsSuccessful Z
      // 4f: goto 33
      // 52: astore 2
      // 53: aload 0
      // 54: aconst_null
      // 55: putfield net/sqlcipher/database/SQLiteDatabase.mTransactionListener Lnet/sqlcipher/database/SQLiteTransactionListener;
      // 58: aload 0
      // 59: invokespecial net/sqlcipher/database/SQLiteDatabase.unlockForced ()V
      // 5c: aload 2
      // 5d: athrow
      // 5e: aload 0
      // 5f: getfield net/sqlcipher/database/SQLiteDatabase.mTransactionListener Lnet/sqlcipher/database/SQLiteTransactionListener;
      // 62: astore 2
      // 63: aload 2
      // 64: ifnull c1
      // 67: aload 0
      // 68: getfield net/sqlcipher/database/SQLiteDatabase.mTransactionIsSuccessful Z
      // 6b: ifeq 92
      // 6e: aload 0
      // 6f: getfield net/sqlcipher/database/SQLiteDatabase.mTransactionListener Lnet/sqlcipher/database/SQLiteTransactionListener;
      // 72: invokeinterface net/sqlcipher/database/SQLiteTransactionListener.onCommit ()V 1
      // 77: aconst_null
      // 78: astore 2
      // 79: aload 0
      // 7a: getfield net/sqlcipher/database/SQLiteDatabase.mTransactionIsSuccessful Z
      // 7d: ifeq a7
      // 80: aload 0
      // 81: ldc "COMMIT;"
      // 83: invokevirtual net/sqlcipher/database/SQLiteDatabase.execSQL (Ljava/lang/String;)V
      // 86: aload 0
      // 87: aconst_null
      // 88: putfield net/sqlcipher/database/SQLiteDatabase.mTransactionListener Lnet/sqlcipher/database/SQLiteTransactionListener;
      // 8b: aload 0
      // 8c: invokespecial net/sqlcipher/database/SQLiteDatabase.unlockForced ()V
      // 8f: goto 49
      // 92: aload 0
      // 93: getfield net/sqlcipher/database/SQLiteDatabase.mTransactionListener Lnet/sqlcipher/database/SQLiteTransactionListener;
      // 96: invokeinterface net/sqlcipher/database/SQLiteTransactionListener.onRollback ()V 1
      // 9b: goto 77
      // 9e: astore 2
      // 9f: aload 0
      // a0: bipush 0
      // a1: putfield net/sqlcipher/database/SQLiteDatabase.mTransactionIsSuccessful Z
      // a4: goto 79
      // a7: aload 0
      // a8: ldc_w "ROLLBACK;"
      // ab: invokevirtual net/sqlcipher/database/SQLiteDatabase.execSQL (Ljava/lang/String;)V
      // ae: aload 2
      // af: ifnull 86
      // b2: aload 2
      // b3: athrow
      // b4: astore 2
      // b5: ldc "Database"
      // b7: ldc_w "exception during rollback, maybe the DB previously performed an auto-rollback"
      // ba: invokestatic android/util/Log.d (Ljava/lang/String;Ljava/lang/String;)I
      // bd: pop
      // be: goto 86
      // c1: aconst_null
      // c2: astore 2
      // c3: goto 79
      // try (17 -> 23): 40 null
      // try (23 -> 27): 40 null
      // try (36 -> 39): 40 null
      // try (48 -> 51): 40 null
      // try (53 -> 59): 77 java/lang/RuntimeException
      // try (53 -> 59): 40 null
      // try (61 -> 67): 40 null
      // try (73 -> 76): 77 java/lang/RuntimeException
      // try (73 -> 76): 40 null
      // try (78 -> 81): 40 null
      // try (82 -> 85): 89 net/sqlcipher/SQLException
      // try (82 -> 85): 40 null
      // try (87 -> 89): 89 net/sqlcipher/SQLException
      // try (87 -> 89): 40 null
      // try (90 -> 94): 40 null
   }

   public void execSQL(String var1) throws SQLException {
      SystemClock.uptimeMillis();
      this.lock();
      if (!this.isOpen()) {
         throw new IllegalStateException("database not open");
      }

      try {
         this.native_execSQL(var1);
      } catch (SQLiteDatabaseCorruptException var4) {
         this.onCorruption();
         throw var4;
      } finally {
         this.unlock();
      }
   }

   public void execSQL(String param1, Object[] param2) throws SQLException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 2
      // 01: ifnonnull 0f
      // 04: new java/lang/IllegalArgumentException
      // 07: dup
      // 08: ldc_w "Empty bindArgs"
      // 0b: invokespecial java/lang/IllegalArgumentException.<init> (Ljava/lang/String;)V
      // 0e: athrow
      // 0f: invokestatic android/os/SystemClock.uptimeMillis ()J
      // 12: pop2
      // 13: aload 0
      // 14: invokevirtual net/sqlcipher/database/SQLiteDatabase.lock ()V
      // 17: aload 0
      // 18: invokevirtual net/sqlcipher/database/SQLiteDatabase.isOpen ()Z
      // 1b: ifne 29
      // 1e: new java/lang/IllegalStateException
      // 21: dup
      // 22: ldc_w "database not open"
      // 25: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 28: athrow
      // 29: aconst_null
      // 2a: astore 6
      // 2c: aconst_null
      // 2d: astore 5
      // 2f: aload 0
      // 30: aload 1
      // 31: invokevirtual net/sqlcipher/database/SQLiteDatabase.compileStatement (Ljava/lang/String;)Lnet/sqlcipher/database/SQLiteStatement;
      // 34: astore 1
      // 35: aload 2
      // 36: ifnull 61
      // 39: aload 1
      // 3a: astore 5
      // 3c: aload 1
      // 3d: astore 6
      // 3f: aload 2
      // 40: arraylength
      // 41: istore 4
      // 43: bipush 0
      // 44: istore 3
      // 45: iload 3
      // 46: iload 4
      // 48: if_icmpge 61
      // 4b: aload 1
      // 4c: astore 5
      // 4e: aload 1
      // 4f: astore 6
      // 51: aload 1
      // 52: iload 3
      // 53: bipush 1
      // 54: iadd
      // 55: aload 2
      // 56: iload 3
      // 57: aaload
      // 58: invokestatic net/sqlcipher/DatabaseUtils.bindObjectToProgram (Lnet/sqlcipher/database/SQLiteProgram;ILjava/lang/Object;)V
      // 5b: iinc 3 1
      // 5e: goto 45
      // 61: aload 1
      // 62: astore 5
      // 64: aload 1
      // 65: astore 6
      // 67: aload 1
      // 68: invokevirtual net/sqlcipher/database/SQLiteStatement.execute ()V
      // 6b: aload 1
      // 6c: ifnull 73
      // 6f: aload 1
      // 70: invokevirtual net/sqlcipher/database/SQLiteStatement.close ()V
      // 73: aload 0
      // 74: invokevirtual net/sqlcipher/database/SQLiteDatabase.unlock ()V
      // 77: return
      // 78: astore 1
      // 79: aload 5
      // 7b: astore 6
      // 7d: aload 0
      // 7e: invokevirtual net/sqlcipher/database/SQLiteDatabase.onCorruption ()V
      // 81: aload 5
      // 83: astore 6
      // 85: aload 1
      // 86: athrow
      // 87: astore 1
      // 88: aload 6
      // 8a: ifnull 92
      // 8d: aload 6
      // 8f: invokevirtual net/sqlcipher/database/SQLiteStatement.close ()V
      // 92: aload 0
      // 93: invokevirtual net/sqlcipher/database/SQLiteDatabase.unlock ()V
      // 96: aload 1
      // 97: athrow
      // try (23 -> 27): 68 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (23 -> 27): 77 null
      // try (33 -> 36): 68 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (33 -> 36): 77 null
      // try (45 -> 53): 68 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (45 -> 53): 77 null
      // try (59 -> 61): 68 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (59 -> 61): 77 null
      // try (71 -> 73): 77 null
      // try (75 -> 77): 77 null
   }

   @Override
   protected void finalize() {
      if (this.isOpen()) {
         Log.e("Database", "close() was never explicitly called on database '" + this.mPath + "' ", this.mStackTrace);
         this.closeClosable();
         this.onAllReferencesReleased();
      }
   }

   SQLiteCompiledSql getCompiledStatementForSql(String param1) {
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
      // 01: getfield net/sqlcipher/database/SQLiteDatabase.mCompiledQueries Ljava/util/Map;
      // 04: astore 5
      // 06: aload 5
      // 08: monitorenter
      // 09: aload 0
      // 0a: getfield net/sqlcipher/database/SQLiteDatabase.mMaxSqlCacheSize I
      // 0d: ifne 3c
      // 10: getstatic net/sqlcipher/database/SQLiteDebug.DEBUG_SQL_CACHE Z
      // 13: ifeq 35
      // 16: new java/lang/StringBuilder
      // 19: astore 1
      // 1a: aload 1
      // 1b: invokespecial java/lang/StringBuilder.<init> ()V
      // 1e: ldc "Database"
      // 20: aload 1
      // 21: ldc_w "|cache NOT found|"
      // 24: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 27: aload 0
      // 28: invokevirtual net/sqlcipher/database/SQLiteDatabase.getPath ()Ljava/lang/String;
      // 2b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 2e: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 31: invokestatic android/util/Log.v (Ljava/lang/String;Ljava/lang/String;)I
      // 34: pop
      // 35: aconst_null
      // 36: astore 3
      // 37: aload 5
      // 39: monitorexit
      // 3a: aload 3
      // 3b: areturn
      // 3c: aload 0
      // 3d: getfield net/sqlcipher/database/SQLiteDatabase.mCompiledQueries Ljava/util/Map;
      // 40: aload 1
      // 41: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 46: checkcast net/sqlcipher/database/SQLiteCompiledSql
      // 49: astore 4
      // 4b: aload 4
      // 4d: ifnull e9
      // 50: bipush 1
      // 51: istore 2
      // 52: aload 5
      // 54: monitorexit
      // 55: iload 2
      // 56: ifeq f4
      // 59: aload 0
      // 5a: aload 0
      // 5b: getfield net/sqlcipher/database/SQLiteDatabase.mNumCacheHits I
      // 5e: bipush 1
      // 5f: iadd
      // 60: putfield net/sqlcipher/database/SQLiteDatabase.mNumCacheHits I
      // 63: aload 4
      // 65: astore 3
      // 66: getstatic net/sqlcipher/database/SQLiteDebug.DEBUG_SQL_CACHE Z
      // 69: ifeq 3a
      // 6c: ldc "Database"
      // 6e: new java/lang/StringBuilder
      // 71: dup
      // 72: invokespecial java/lang/StringBuilder.<init> ()V
      // 75: ldc_w "|cache_stats|"
      // 78: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 7b: aload 0
      // 7c: invokevirtual net/sqlcipher/database/SQLiteDatabase.getPath ()Ljava/lang/String;
      // 7f: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 82: ldc_w "|"
      // 85: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 88: aload 0
      // 89: getfield net/sqlcipher/database/SQLiteDatabase.mCompiledQueries Ljava/util/Map;
      // 8c: invokeinterface java/util/Map.size ()I 1
      // 91: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 94: ldc_w "|"
      // 97: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 9a: aload 0
      // 9b: getfield net/sqlcipher/database/SQLiteDatabase.mNumCacheHits I
      // 9e: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // a1: ldc_w "|"
      // a4: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // a7: aload 0
      // a8: getfield net/sqlcipher/database/SQLiteDatabase.mNumCacheMisses I
      // ab: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // ae: ldc_w "|"
      // b1: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // b4: iload 2
      // b5: invokevirtual java/lang/StringBuilder.append (Z)Ljava/lang/StringBuilder;
      // b8: ldc_w "|"
      // bb: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // be: aload 0
      // bf: getfield net/sqlcipher/database/SQLiteDatabase.mTimeOpened Ljava/lang/String;
      // c2: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // c5: ldc_w "|"
      // c8: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // cb: aload 0
      // cc: getfield net/sqlcipher/database/SQLiteDatabase.mTimeClosed Ljava/lang/String;
      // cf: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // d2: ldc_w "|"
      // d5: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // d8: aload 1
      // d9: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // dc: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // df: invokestatic android/util/Log.v (Ljava/lang/String;Ljava/lang/String;)I
      // e2: pop
      // e3: aload 4
      // e5: astore 3
      // e6: goto 3a
      // e9: bipush 0
      // ea: istore 2
      // eb: goto 52
      // ee: astore 1
      // ef: aload 5
      // f1: monitorexit
      // f2: aload 1
      // f3: athrow
      // f4: aload 0
      // f5: aload 0
      // f6: getfield net/sqlcipher/database/SQLiteDatabase.mNumCacheMisses I
      // f9: bipush 1
      // fa: iadd
      // fb: putfield net/sqlcipher/database/SQLiteDatabase.mNumCacheMisses I
      // fe: goto 63
      // try (5 -> 24): 106 null
      // try (26 -> 28): 106 null
      // try (30 -> 36): 106 null
      // try (40 -> 42): 106 null
      // try (107 -> 109): 106 null
   }

   public int getMaxSqlCacheSize() {
      synchronized (this) {
         return this.mMaxSqlCacheSize;
      }
   }

   // $VF: Could not properly define all variable types!
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public long getMaximumSize() {
      this.lock();
      if (!this.isOpen()) {
         throw new IllegalStateException("database not open");
      }

      SQLiteStatement var6;
      try {
         var6 = new SQLiteStatement(this, "PRAGMA max_page_count;");
      } finally {
         ;
      }

      long var1;
      long var3;
      try {
         var3 = var6.simpleQueryForLong();
         var1 = this.getPageSize();
      } finally {
         if (var6 != null) {
            var6.close();
         }

         this.unlock();
         <unknown> var5;
         throw var5_1;
      }

      if (var6 != null) {
         var6.close();
      }

      this.unlock();
      return var3 * var1;
   }

   // $VF: Could not properly define all variable types!
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public long getPageSize() {
      this.lock();
      if (!this.isOpen()) {
         throw new IllegalStateException("database not open");
      }

      SQLiteStatement var3;
      try {
         var3 = new SQLiteStatement(this, "PRAGMA page_size;");
      } finally {
         ;
      }

      long var1;
      try {
         var1 = var3.simpleQueryForLong();
      } finally {
         if (var3 != null) {
            var3.close();
         }

         this.unlock();
         <unknown> var4;
         throw var4_1;
      }

      if (var3 != null) {
         var3.close();
      }

      this.unlock();
      return var1;
   }

   public final String getPath() {
      return this.mPath;
   }

   public Map<String, String> getSyncedTables() {
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
      // 01: getfield net/sqlcipher/database/SQLiteDatabase.mSyncUpdateInfo Ljava/util/Map;
      // 04: astore 1
      // 05: aload 1
      // 06: monitorenter
      // 07: new java/util/HashMap
      // 0a: astore 5
      // 0c: aload 5
      // 0e: invokespecial java/util/HashMap.<init> ()V
      // 11: aload 0
      // 12: getfield net/sqlcipher/database/SQLiteDatabase.mSyncUpdateInfo Ljava/util/Map;
      // 15: invokeinterface java/util/Map.keySet ()Ljava/util/Set; 1
      // 1a: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 1f: astore 3
      // 20: aload 3
      // 21: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 26: ifeq 5e
      // 29: aload 3
      // 2a: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 2f: checkcast java/lang/String
      // 32: astore 2
      // 33: aload 0
      // 34: getfield net/sqlcipher/database/SQLiteDatabase.mSyncUpdateInfo Ljava/util/Map;
      // 37: aload 2
      // 38: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 3d: checkcast net/sqlcipher/database/SQLiteDatabase$SyncUpdateInfo
      // 40: astore 4
      // 42: aload 4
      // 44: getfield net/sqlcipher/database/SQLiteDatabase$SyncUpdateInfo.deletedTable Ljava/lang/String;
      // 47: ifnull 20
      // 4a: aload 5
      // 4c: aload 2
      // 4d: aload 4
      // 4f: getfield net/sqlcipher/database/SQLiteDatabase$SyncUpdateInfo.deletedTable Ljava/lang/String;
      // 52: invokevirtual java/util/HashMap.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 55: pop
      // 56: goto 20
      // 59: astore 2
      // 5a: aload 1
      // 5b: monitorexit
      // 5c: aload 2
      // 5d: athrow
      // 5e: aload 1
      // 5f: monitorexit
      // 60: aload 5
      // 62: areturn
      // try (5 -> 14): 37 null
      // try (14 -> 36): 37 null
      // try (38 -> 40): 37 null
      // try (42 -> 44): 37 null
   }

   // $VF: Could not properly define all variable types!
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public int getVersion() {
      this.lock();
      if (!this.isOpen()) {
         throw new IllegalStateException("database not open");
      }

      SQLiteStatement var5;
      try {
         var5 = new SQLiteStatement(this, "PRAGMA user_version;");
      } finally {
         ;
      }

      long var2;
      try {
         var2 = var5.simpleQueryForLong();
      } finally {
         if (var5 != null) {
            var5.close();
         }

         this.unlock();
         <unknown> var4;
         throw var4_1;
      }

      int var1 = (int)var2;
      if (var5 != null) {
         var5.close();
      }

      this.unlock();
      return var1;
   }

   public boolean inTransaction() {
      boolean var1;
      if (this.mLock.getHoldCount() > 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public long insert(String var1, String var2, ContentValues var3) {
      long var4;
      try {
         var4 = this.insertWithOnConflict(var1, var2, var3, 0);
      } catch (SQLException var6) {
         Log.e("Database", "Error inserting <redacted values> into " + var1, var6);
         var4 = -1L;
      }

      return var4;
   }

   public long insertOrThrow(String var1, String var2, ContentValues var3) throws SQLException {
      return this.insertWithOnConflict(var1, var2, var3, 0);
   }

   public long insertWithOnConflict(String param1, String param2, ContentValues param3, int param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aconst_null
      // 001: astore 10
      // 003: aconst_null
      // 004: astore 11
      // 006: bipush 0
      // 007: istore 5
      // 009: aload 0
      // 00a: invokevirtual net/sqlcipher/database/SQLiteDatabase.isOpen ()Z
      // 00d: ifne 01b
      // 010: new java/lang/IllegalStateException
      // 013: dup
      // 014: ldc_w "database not open"
      // 017: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 01a: athrow
      // 01b: new java/lang/StringBuilder
      // 01e: dup
      // 01f: sipush 152
      // 022: invokespecial java/lang/StringBuilder.<init> (I)V
      // 025: astore 12
      // 027: aload 12
      // 029: ldc_w "INSERT"
      // 02c: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 02f: pop
      // 030: aload 12
      // 032: getstatic net/sqlcipher/database/SQLiteDatabase.CONFLICT_VALUES [Ljava/lang/String;
      // 035: iload 4
      // 037: aaload
      // 038: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 03b: pop
      // 03c: aload 12
      // 03e: ldc_w " INTO "
      // 041: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 044: pop
      // 045: aload 12
      // 047: aload 1
      // 048: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 04b: pop
      // 04c: new java/lang/StringBuilder
      // 04f: dup
      // 050: bipush 40
      // 052: invokespecial java/lang/StringBuilder.<init> (I)V
      // 055: astore 13
      // 057: aload 3
      // 058: ifnull 149
      // 05b: aload 3
      // 05c: invokevirtual android/content/ContentValues.size ()I
      // 05f: ifle 149
      // 062: aload 3
      // 063: invokevirtual android/content/ContentValues.valueSet ()Ljava/util/Set;
      // 066: astore 9
      // 068: aload 9
      // 06a: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 06f: astore 2
      // 070: aload 12
      // 072: bipush 40
      // 074: invokevirtual java/lang/StringBuilder.append (C)Ljava/lang/StringBuilder;
      // 077: pop
      // 078: bipush 0
      // 079: istore 4
      // 07b: aload 2
      // 07c: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 081: ifeq 0c0
      // 084: iload 4
      // 086: ifeq 09b
      // 089: aload 12
      // 08b: ldc_w ", "
      // 08e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 091: pop
      // 092: aload 13
      // 094: ldc_w ", "
      // 097: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 09a: pop
      // 09b: aload 12
      // 09d: aload 2
      // 09e: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0a3: checkcast java/util/Map$Entry
      // 0a6: invokeinterface java/util/Map$Entry.getKey ()Ljava/lang/Object; 1
      // 0ab: checkcast java/lang/String
      // 0ae: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0b1: pop
      // 0b2: aload 13
      // 0b4: bipush 63
      // 0b6: invokevirtual java/lang/StringBuilder.append (C)Ljava/lang/StringBuilder;
      // 0b9: pop
      // 0ba: bipush 1
      // 0bb: istore 4
      // 0bd: goto 07b
      // 0c0: aload 12
      // 0c2: bipush 41
      // 0c4: invokevirtual java/lang/StringBuilder.append (C)Ljava/lang/StringBuilder;
      // 0c7: pop
      // 0c8: aload 12
      // 0ca: ldc_w " VALUES("
      // 0cd: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0d0: pop
      // 0d1: aload 12
      // 0d3: aload 13
      // 0d5: invokevirtual java/lang/StringBuilder.append (Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
      // 0d8: pop
      // 0d9: aload 12
      // 0db: ldc_w ");"
      // 0de: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0e1: pop
      // 0e2: aload 0
      // 0e3: invokevirtual net/sqlcipher/database/SQLiteDatabase.lock ()V
      // 0e6: aload 11
      // 0e8: astore 3
      // 0e9: aload 10
      // 0eb: astore 2
      // 0ec: aload 0
      // 0ed: aload 12
      // 0ef: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0f2: invokevirtual net/sqlcipher/database/SQLiteDatabase.compileStatement (Ljava/lang/String;)Lnet/sqlcipher/database/SQLiteStatement;
      // 0f5: astore 10
      // 0f7: aload 9
      // 0f9: ifnull 178
      // 0fc: aload 10
      // 0fe: astore 3
      // 0ff: aload 10
      // 101: astore 2
      // 102: aload 9
      // 104: invokeinterface java/util/Set.size ()I 1
      // 109: istore 6
      // 10b: aload 10
      // 10d: astore 3
      // 10e: aload 10
      // 110: astore 2
      // 111: aload 9
      // 113: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 118: astore 9
      // 11a: iload 5
      // 11c: istore 4
      // 11e: iload 4
      // 120: iload 6
      // 122: if_icmpge 178
      // 125: aload 10
      // 127: astore 3
      // 128: aload 10
      // 12a: astore 2
      // 12b: aload 10
      // 12d: iload 4
      // 12f: bipush 1
      // 130: iadd
      // 131: aload 9
      // 133: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 138: checkcast java/util/Map$Entry
      // 13b: invokeinterface java/util/Map$Entry.getValue ()Ljava/lang/Object; 1
      // 140: invokestatic net/sqlcipher/DatabaseUtils.bindObjectToProgram (Lnet/sqlcipher/database/SQLiteProgram;ILjava/lang/Object;)V
      // 143: iinc 4 1
      // 146: goto 11e
      // 149: aload 12
      // 14b: new java/lang/StringBuilder
      // 14e: dup
      // 14f: invokespecial java/lang/StringBuilder.<init> ()V
      // 152: ldc_w "("
      // 155: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 158: aload 2
      // 159: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 15c: ldc_w ") "
      // 15f: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 162: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 165: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 168: pop
      // 169: aload 13
      // 16b: ldc_w "NULL"
      // 16e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 171: pop
      // 172: aconst_null
      // 173: astore 9
      // 175: goto 0c8
      // 178: aload 10
      // 17a: astore 3
      // 17b: aload 10
      // 17d: astore 2
      // 17e: aload 10
      // 180: invokevirtual net/sqlcipher/database/SQLiteStatement.execute ()V
      // 183: aload 10
      // 185: astore 3
      // 186: aload 10
      // 188: astore 2
      // 189: aload 0
      // 18a: invokevirtual net/sqlcipher/database/SQLiteDatabase.lastChangeCount ()I
      // 18d: ifle 1e7
      // 190: aload 10
      // 192: astore 3
      // 193: aload 10
      // 195: astore 2
      // 196: aload 0
      // 197: invokevirtual net/sqlcipher/database/SQLiteDatabase.lastInsertRow ()J
      // 19a: lstore 7
      // 19c: lload 7
      // 19e: ldc2_w -1
      // 1a1: lcmp
      // 1a2: ifne 1ef
      // 1a5: aload 10
      // 1a7: astore 3
      // 1a8: aload 10
      // 1aa: astore 2
      // 1ab: new java/lang/StringBuilder
      // 1ae: astore 9
      // 1b0: aload 10
      // 1b2: astore 3
      // 1b3: aload 10
      // 1b5: astore 2
      // 1b6: aload 9
      // 1b8: invokespecial java/lang/StringBuilder.<init> ()V
      // 1bb: aload 10
      // 1bd: astore 3
      // 1be: aload 10
      // 1c0: astore 2
      // 1c1: ldc "Database"
      // 1c3: aload 9
      // 1c5: ldc_w "Error inserting <redacted values> using <redacted sql> into "
      // 1c8: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1cb: aload 1
      // 1cc: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1cf: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 1d2: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;)I
      // 1d5: pop
      // 1d6: aload 10
      // 1d8: ifnull 1e0
      // 1db: aload 10
      // 1dd: invokevirtual net/sqlcipher/database/SQLiteStatement.close ()V
      // 1e0: aload 0
      // 1e1: invokevirtual net/sqlcipher/database/SQLiteDatabase.unlock ()V
      // 1e4: lload 7
      // 1e6: lreturn
      // 1e7: ldc2_w -1
      // 1ea: lstore 7
      // 1ec: goto 19c
      // 1ef: aload 10
      // 1f1: astore 3
      // 1f2: aload 10
      // 1f4: astore 2
      // 1f5: ldc "Database"
      // 1f7: bipush 2
      // 1f8: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 1fb: ifeq 1d6
      // 1fe: aload 10
      // 200: astore 3
      // 201: aload 10
      // 203: astore 2
      // 204: new java/lang/StringBuilder
      // 207: astore 9
      // 209: aload 10
      // 20b: astore 3
      // 20c: aload 10
      // 20e: astore 2
      // 20f: aload 9
      // 211: invokespecial java/lang/StringBuilder.<init> ()V
      // 214: aload 10
      // 216: astore 3
      // 217: aload 10
      // 219: astore 2
      // 21a: ldc "Database"
      // 21c: aload 9
      // 21e: ldc_w "Inserting row "
      // 221: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 224: lload 7
      // 226: invokevirtual java/lang/StringBuilder.append (J)Ljava/lang/StringBuilder;
      // 229: ldc_w " from <redacted values> using <redacted sql> into "
      // 22c: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 22f: aload 1
      // 230: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 233: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 236: invokestatic android/util/Log.v (Ljava/lang/String;Ljava/lang/String;)I
      // 239: pop
      // 23a: goto 1d6
      // 23d: astore 1
      // 23e: aload 3
      // 23f: astore 2
      // 240: aload 0
      // 241: invokevirtual net/sqlcipher/database/SQLiteDatabase.onCorruption ()V
      // 244: aload 3
      // 245: astore 2
      // 246: aload 1
      // 247: athrow
      // 248: astore 1
      // 249: aload 2
      // 24a: ifnull 251
      // 24d: aload 2
      // 24e: invokevirtual net/sqlcipher/database/SQLiteStatement.close ()V
      // 251: aload 0
      // 252: invokevirtual net/sqlcipher/database/SQLiteDatabase.unlock ()V
      // 255: aload 1
      // 256: athrow
      // try (109 -> 114): 268 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (109 -> 114): 277 null
      // try (120 -> 123): 268 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (120 -> 123): 277 null
      // try (127 -> 130): 268 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (127 -> 130): 277 null
      // try (139 -> 148): 268 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (139 -> 148): 277 null
      // try (174 -> 176): 268 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (174 -> 176): 277 null
      // try (180 -> 183): 268 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (180 -> 183): 277 null
      // try (187 -> 190): 268 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (187 -> 190): 277 null
      // try (198 -> 200): 268 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (198 -> 200): 277 null
      // try (204 -> 206): 268 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (204 -> 206): 277 null
      // try (210 -> 219): 268 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (210 -> 219): 277 null
      // try (234 -> 238): 268 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (234 -> 238): 277 null
      // try (242 -> 244): 268 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (242 -> 244): 277 null
      // try (248 -> 250): 268 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (248 -> 250): 277 null
      // try (254 -> 267): 268 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (254 -> 267): 277 null
      // try (271 -> 273): 277 null
      // try (275 -> 277): 277 null
   }

   public boolean isDbLockedByCurrentThread() {
      return this.mLock.isHeldByCurrentThread();
   }

   public boolean isDbLockedByOtherThreads() {
      boolean var1;
      if (!this.mLock.isHeldByCurrentThread() && this.mLock.isLocked()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean isInCompiledSqlCache(String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield net/sqlcipher/database/SQLiteDatabase.mCompiledQueries Ljava/util/Map;
      // 04: astore 3
      // 05: aload 3
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield net/sqlcipher/database/SQLiteDatabase.mCompiledQueries Ljava/util/Map;
      // 0b: aload 1
      // 0c: invokeinterface java/util/Map.containsKey (Ljava/lang/Object;)Z 2
      // 11: istore 2
      // 12: aload 3
      // 13: monitorexit
      // 14: iload 2
      // 15: ireturn
      // 16: astore 1
      // 17: aload 3
      // 18: monitorexit
      // 19: aload 1
      // 1a: athrow
      // try (5 -> 12): 14 null
      // try (15 -> 17): 14 null
   }

   public boolean isOpen() {
      boolean var1;
      if (this.mNativeHandle != 0L) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean isReadOnly() {
      boolean var1 = true;
      if ((this.mFlags & 1) != 1) {
         var1 = false;
      }

      return var1;
   }

   native int lastChangeCount();

   native long lastInsertRow();

   void lock() {
      if (this.mLockingEnabled) {
         this.mLock.lock();
         if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING && this.mLock.getHoldCount() == 1) {
            this.mLockAcquiredWallTime = SystemClock.elapsedRealtime();
            this.mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
         }
      }
   }

   public void markTableSyncable(String var1, String var2) {
      if (!this.isOpen()) {
         throw new SQLiteException("database not open");
      }

      this.markTableSyncable(var1, "_id", var1, var2);
   }

   public void markTableSyncable(String var1, String var2, String var3) {
      if (!this.isOpen()) {
         throw new SQLiteException("database not open");
      }

      this.markTableSyncable(var1, var2, var3, null);
   }

   native void native_execSQL(String var1) throws SQLException;

   native void native_setLocale(String var1, int var2);

   public boolean needUpgrade(int var1) {
      boolean var2;
      if (var1 > this.getVersion()) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   @Override
   protected void onAllReferencesReleased() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokevirtual net/sqlcipher/database/SQLiteDatabase.isOpen ()Z
      // 04: ifeq 29
      // 07: getstatic net/sqlcipher/database/SQLiteDebug.DEBUG_SQL_CACHE Z
      // 0a: ifeq 15
      // 0d: aload 0
      // 0e: aload 0
      // 0f: invokespecial net/sqlcipher/database/SQLiteDatabase.getTime ()Ljava/lang/String;
      // 12: putfield net/sqlcipher/database/SQLiteDatabase.mTimeClosed Ljava/lang/String;
      // 15: aload 0
      // 16: invokespecial net/sqlcipher/database/SQLiteDatabase.dbclose ()V
      // 19: getstatic net/sqlcipher/database/SQLiteDatabase.sActiveDatabases Ljava/util/WeakHashMap;
      // 1c: astore 1
      // 1d: aload 1
      // 1e: monitorenter
      // 1f: getstatic net/sqlcipher/database/SQLiteDatabase.sActiveDatabases Ljava/util/WeakHashMap;
      // 22: aload 0
      // 23: invokevirtual java/util/WeakHashMap.remove (Ljava/lang/Object;)Ljava/lang/Object;
      // 26: pop
      // 27: aload 1
      // 28: monitorexit
      // 29: return
      // 2a: astore 2
      // 2b: aload 1
      // 2c: monitorexit
      // 2d: aload 2
      // 2e: athrow
      // try (15 -> 21): 22 null
      // try (23 -> 25): 22 null
   }

   void onCorruption() {
      Log.e("Database", "Calling error handler for corrupt database (detected) " + this.mPath);
      this.mErrorHandler.onCorruption(this);
   }

   public void purgeFromCompiledSqlCache(String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield net/sqlcipher/database/SQLiteDatabase.mCompiledQueries Ljava/util/Map;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield net/sqlcipher/database/SQLiteDatabase.mCompiledQueries Ljava/util/Map;
      // 0b: aload 1
      // 0c: invokeinterface java/util/Map.remove (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 11: pop
      // 12: aload 2
      // 13: monitorexit
      // 14: return
      // 15: astore 1
      // 16: aload 2
      // 17: monitorexit
      // 18: aload 1
      // 19: athrow
      // try (5 -> 12): 13 null
      // try (14 -> 16): 13 null
   }

   public Cursor query(String var1, String[] var2, String var3, String[] var4, String var5, String var6, String var7) {
      return this.query(false, var1, var2, var3, var4, var5, var6, var7, null);
   }

   public Cursor query(String var1, String[] var2, String var3, String[] var4, String var5, String var6, String var7, String var8) {
      return this.query(false, var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public Cursor query(boolean var1, String var2, String[] var3, String var4, String[] var5, String var6, String var7, String var8, String var9) {
      return this.queryWithFactory(null, var1, var2, var3, var4, var5, var6, var7, var8, var9);
   }

   public Cursor queryWithFactory(
      SQLiteDatabase.CursorFactory var1,
      boolean var2,
      String var3,
      String[] var4,
      String var5,
      String[] var6,
      String var7,
      String var8,
      String var9,
      String var10
   ) {
      if (!this.isOpen()) {
         throw new IllegalStateException("database not open");
      } else {
         return this.rawQueryWithFactory(var1, SQLiteQueryBuilder.buildQueryString(var2, var3, var4, var5, var7, var8, var9, var10), var6, findEditTable(var3));
      }
   }

   public void rawExecSQL(String var1) {
      SystemClock.uptimeMillis();
      this.lock();
      if (!this.isOpen()) {
         throw new IllegalStateException("database not open");
      }

      try {
         this.native_rawExecSQL(var1);
      } catch (SQLiteDatabaseCorruptException var4) {
         this.onCorruption();
         throw var4;
      } finally {
         this.unlock();
      }
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public Cursor rawQuery(String var1, Object[] var2) {
      int var3 = -1;
      if (!this.isOpen()) {
         throw new IllegalStateException("database not open");
      }

      long var4 = 0L;
      if (this.mSlowQueryThreshold != -1) {
         var4 = System.currentTimeMillis();
      }

      SQLiteDirectCursorDriver var9 = new SQLiteDirectCursorDriver(this, var1, null);
      boolean var7 = false /* VF: Semaphore variable */;

      try {
         var7 = true;
         var2 = var9.query(this.mFactory, var2);
         var7 = false;
      } finally {
         if (var7) {
            if (this.mSlowQueryThreshold != -1) {
               if (false) {
                  throw new NullPointerException();
               }

               var4 = System.currentTimeMillis() - var4;
               if (var4 >= this.mSlowQueryThreshold) {
                  Log.v("Database", "query (" + var4 + " ms): " + var9.toString() + ", args are <redacted>, count is " + -1);
               }
            }
         }
      }

      if (this.mSlowQueryThreshold != -1) {
         if (var2 != null) {
            var3 = var2.getCount();
         }

         var4 = System.currentTimeMillis() - var4;
         if (var4 >= this.mSlowQueryThreshold) {
            Log.v("Database", "query (" + var4 + " ms): " + var9.toString() + ", args are <redacted>, count is " + var3);
         }
      }

      return new CrossProcessCursorWrapper(var2);
   }

   public Cursor rawQuery(String var1, String[] var2) {
      return this.rawQueryWithFactory(null, var1, var2, null);
   }

   public Cursor rawQuery(String var1, String[] var2, int var3, int var4) {
      CursorWrapper var5 = (CursorWrapper)this.rawQueryWithFactory(null, var1, var2, null);
      ((SQLiteCursor)var5.getWrappedCursor()).setLoadStyle(var3, var4);
      return var5;
   }

   public Cursor rawQueryWithFactory(SQLiteDatabase.CursorFactory param1, String param2, String[] param3, String param4) {
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
      // 000: bipush -1
      // 001: istore 5
      // 003: aload 0
      // 004: invokevirtual net/sqlcipher/database/SQLiteDatabase.isOpen ()Z
      // 007: ifne 015
      // 00a: new java/lang/IllegalStateException
      // 00d: dup
      // 00e: ldc_w "database not open"
      // 011: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 014: athrow
      // 015: lconst_0
      // 016: lstore 6
      // 018: aload 0
      // 019: getfield net/sqlcipher/database/SQLiteDatabase.mSlowQueryThreshold I
      // 01c: bipush -1
      // 01d: if_icmpeq 025
      // 020: invokestatic java/lang/System.currentTimeMillis ()J
      // 023: lstore 6
      // 025: new net/sqlcipher/database/SQLiteDirectCursorDriver
      // 028: dup
      // 029: aload 0
      // 02a: aload 2
      // 02b: aload 4
      // 02d: invokespecial net/sqlcipher/database/SQLiteDirectCursorDriver.<init> (Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)V
      // 030: astore 2
      // 031: aload 1
      // 032: ifnull 0a1
      // 035: aload 2
      // 036: aload 1
      // 037: aload 3
      // 038: invokeinterface net/sqlcipher/database/SQLiteCursorDriver.query (Lnet/sqlcipher/database/SQLiteDatabase$CursorFactory;[Ljava/lang/String;)Lnet/sqlcipher/Cursor; 3
      // 03d: astore 1
      // 03e: aload 0
      // 03f: getfield net/sqlcipher/database/SQLiteDatabase.mSlowQueryThreshold I
      // 042: bipush -1
      // 043: if_icmpeq 098
      // 046: aload 1
      // 047: ifnull 052
      // 04a: aload 1
      // 04b: invokeinterface net/sqlcipher/Cursor.getCount ()I 1
      // 050: istore 5
      // 052: invokestatic java/lang/System.currentTimeMillis ()J
      // 055: lload 6
      // 057: lsub
      // 058: lstore 6
      // 05a: lload 6
      // 05c: aload 0
      // 05d: getfield net/sqlcipher/database/SQLiteDatabase.mSlowQueryThreshold I
      // 060: i2l
      // 061: lcmp
      // 062: iflt 098
      // 065: ldc "Database"
      // 067: new java/lang/StringBuilder
      // 06a: dup
      // 06b: invokespecial java/lang/StringBuilder.<init> ()V
      // 06e: ldc_w "query ("
      // 071: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 074: lload 6
      // 076: invokevirtual java/lang/StringBuilder.append (J)Ljava/lang/StringBuilder;
      // 079: ldc_w " ms): "
      // 07c: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 07f: aload 2
      // 080: invokevirtual java/lang/Object.toString ()Ljava/lang/String;
      // 083: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 086: ldc_w ", args are <redacted>, count is "
      // 089: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 08c: iload 5
      // 08e: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 091: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 094: invokestatic android/util/Log.v (Ljava/lang/String;Ljava/lang/String;)I
      // 097: pop
      // 098: new net/sqlcipher/CrossProcessCursorWrapper
      // 09b: dup
      // 09c: aload 1
      // 09d: invokespecial net/sqlcipher/CrossProcessCursorWrapper.<init> (Lnet/sqlcipher/Cursor;)V
      // 0a0: areturn
      // 0a1: aload 0
      // 0a2: getfield net/sqlcipher/database/SQLiteDatabase.mFactory Lnet/sqlcipher/database/SQLiteDatabase$CursorFactory;
      // 0a5: astore 1
      // 0a6: goto 035
      // 0a9: astore 1
      // 0aa: aload 0
      // 0ab: getfield net/sqlcipher/database/SQLiteDatabase.mSlowQueryThreshold I
      // 0ae: bipush -1
      // 0af: if_icmpeq 103
      // 0b2: bipush 0
      // 0b3: ifeq 0be
      // 0b6: new java/lang/NullPointerException
      // 0b9: dup
      // 0ba: invokespecial java/lang/NullPointerException.<init> ()V
      // 0bd: athrow
      // 0be: invokestatic java/lang/System.currentTimeMillis ()J
      // 0c1: lload 6
      // 0c3: lsub
      // 0c4: lstore 6
      // 0c6: lload 6
      // 0c8: aload 0
      // 0c9: getfield net/sqlcipher/database/SQLiteDatabase.mSlowQueryThreshold I
      // 0cc: i2l
      // 0cd: lcmp
      // 0ce: iflt 103
      // 0d1: ldc "Database"
      // 0d3: new java/lang/StringBuilder
      // 0d6: dup
      // 0d7: invokespecial java/lang/StringBuilder.<init> ()V
      // 0da: ldc_w "query ("
      // 0dd: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0e0: lload 6
      // 0e2: invokevirtual java/lang/StringBuilder.append (J)Ljava/lang/StringBuilder;
      // 0e5: ldc_w " ms): "
      // 0e8: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0eb: aload 2
      // 0ec: invokevirtual java/lang/Object.toString ()Ljava/lang/String;
      // 0ef: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0f2: ldc_w ", args are <redacted>, count is "
      // 0f5: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0f8: bipush -1
      // 0f9: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 0fc: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0ff: invokestatic android/util/Log.v (Ljava/lang/String;Ljava/lang/String;)I
      // 102: pop
      // 103: aload 1
      // 104: athrow
      // try (27 -> 32): 80 null
      // try (76 -> 79): 80 null
   }

   void removeSQLiteClosable(SQLiteClosable var1) {
      this.lock();

      try {
         this.mPrograms.remove(var1);
      } finally {
         this.unlock();
      }
   }

   public long replace(String var1, String var2, ContentValues var3) {
      long var4;
      try {
         var4 = this.insertWithOnConflict(var1, var2, var3, 5);
      } catch (SQLException var6) {
         Log.e("Database", "Error inserting <redacted values> into " + var1, var6);
         var4 = -1L;
      }

      return var4;
   }

   public long replaceOrThrow(String var1, String var2, ContentValues var3) throws SQLException {
      return this.insertWithOnConflict(var1, var2, var3, 5);
   }

   public void resetCompiledSqlCache() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield net/sqlcipher/database/SQLiteDatabase.mCompiledQueries Ljava/util/Map;
      // 04: astore 1
      // 05: aload 1
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield net/sqlcipher/database/SQLiteDatabase.mCompiledQueries Ljava/util/Map;
      // 0b: invokeinterface java/util/Map.clear ()V 1
      // 10: aload 1
      // 11: monitorexit
      // 12: return
      // 13: astore 2
      // 14: aload 1
      // 15: monitorexit
      // 16: aload 2
      // 17: athrow
      // try (5 -> 10): 11 null
      // try (12 -> 14): 11 null
   }

   void rowUpdated(String param1, long param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield net/sqlcipher/database/SQLiteDatabase.mSyncUpdateInfo Ljava/util/Map;
      // 04: astore 4
      // 06: aload 4
      // 08: monitorenter
      // 09: aload 0
      // 0a: getfield net/sqlcipher/database/SQLiteDatabase.mSyncUpdateInfo Ljava/util/Map;
      // 0d: aload 1
      // 0e: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 13: checkcast net/sqlcipher/database/SQLiteDatabase$SyncUpdateInfo
      // 16: astore 5
      // 18: aload 4
      // 1a: monitorexit
      // 1b: aload 5
      // 1d: ifnull 64
      // 20: aload 0
      // 21: new java/lang/StringBuilder
      // 24: dup
      // 25: invokespecial java/lang/StringBuilder.<init> ()V
      // 28: ldc_w "UPDATE "
      // 2b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 2e: aload 5
      // 30: getfield net/sqlcipher/database/SQLiteDatabase$SyncUpdateInfo.masterTable Ljava/lang/String;
      // 33: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 36: ldc_w " SET _sync_dirty=1 WHERE _id=(SELECT "
      // 39: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 3c: aload 5
      // 3e: getfield net/sqlcipher/database/SQLiteDatabase$SyncUpdateInfo.foreignKey Ljava/lang/String;
      // 41: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 44: ldc_w " FROM "
      // 47: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 4a: aload 1
      // 4b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 4e: ldc_w " WHERE _id="
      // 51: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 54: lload 2
      // 55: invokevirtual java/lang/StringBuilder.append (J)Ljava/lang/StringBuilder;
      // 58: ldc_w ")"
      // 5b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 5e: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 61: invokevirtual net/sqlcipher/database/SQLiteDatabase.execSQL (Ljava/lang/String;)V
      // 64: return
      // 65: astore 1
      // 66: aload 4
      // 68: monitorexit
      // 69: aload 1
      // 6a: athrow
      // try (5 -> 13): 42 null
      // try (43 -> 45): 42 null
   }

   public void setLocale(Locale var1) {
      this.lock();

      try {
         this.native_setLocale(var1.toString(), this.mFlags);
      } finally {
         this.unlock();
      }
   }

   public void setLockingEnabled(boolean var1) {
      this.mLockingEnabled = var1;
   }

   public void setMaxSqlCacheSize(int param1) {
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
      // 01: monitorenter
      // 02: iload 1
      // 03: sipush 250
      // 06: if_icmpgt 0d
      // 09: iload 1
      // 0a: ifge 1f
      // 0d: new java/lang/IllegalStateException
      // 10: astore 2
      // 11: aload 2
      // 12: ldc_w "expected value between 0 and 250"
      // 15: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 18: aload 2
      // 19: athrow
      // 1a: astore 2
      // 1b: aload 0
      // 1c: monitorexit
      // 1d: aload 2
      // 1e: athrow
      // 1f: iload 1
      // 20: aload 0
      // 21: getfield net/sqlcipher/database/SQLiteDatabase.mMaxSqlCacheSize I
      // 24: if_icmpge 34
      // 27: new java/lang/IllegalStateException
      // 2a: astore 2
      // 2b: aload 2
      // 2c: ldc_w "cannot set cacheSize to a value less than the value set with previous setMaxSqlCacheSize() call."
      // 2f: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 32: aload 2
      // 33: athrow
      // 34: aload 0
      // 35: iload 1
      // 36: putfield net/sqlcipher/database/SQLiteDatabase.mMaxSqlCacheSize I
      // 39: aload 0
      // 3a: monitorexit
      // 3b: return
      // try (7 -> 14): 14 null
      // try (19 -> 30): 14 null
      // try (30 -> 33): 14 null
   }

   public long setMaximumSize(long param1) {
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
      // 00: aload 0
      // 01: invokevirtual net/sqlcipher/database/SQLiteDatabase.lock ()V
      // 04: aload 0
      // 05: invokevirtual net/sqlcipher/database/SQLiteDatabase.isOpen ()Z
      // 08: ifne 16
      // 0b: new java/lang/IllegalStateException
      // 0e: dup
      // 0f: ldc_w "database not open"
      // 12: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 15: athrow
      // 16: aload 0
      // 17: invokevirtual net/sqlcipher/database/SQLiteDatabase.getPageSize ()J
      // 1a: lstore 5
      // 1c: lload 1
      // 1d: lload 5
      // 1f: ldiv
      // 20: lstore 3
      // 21: lload 1
      // 22: lload 5
      // 24: lrem
      // 25: lconst_0
      // 26: lcmp
      // 27: ifeq 86
      // 2a: lload 3
      // 2b: lconst_1
      // 2c: ladd
      // 2d: lstore 1
      // 2e: new net/sqlcipher/database/SQLiteStatement
      // 31: astore 7
      // 33: new java/lang/StringBuilder
      // 36: astore 8
      // 38: aload 8
      // 3a: invokespecial java/lang/StringBuilder.<init> ()V
      // 3d: aload 7
      // 3f: aload 0
      // 40: aload 8
      // 42: ldc_w "PRAGMA max_page_count = "
      // 45: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 48: lload 1
      // 49: invokevirtual java/lang/StringBuilder.append (J)Ljava/lang/StringBuilder;
      // 4c: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 4f: invokespecial net/sqlcipher/database/SQLiteStatement.<init> (Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)V
      // 52: aload 7
      // 54: invokevirtual net/sqlcipher/database/SQLiteStatement.simpleQueryForLong ()J
      // 57: lstore 1
      // 58: aload 7
      // 5a: ifnull 62
      // 5d: aload 7
      // 5f: invokevirtual net/sqlcipher/database/SQLiteStatement.close ()V
      // 62: aload 0
      // 63: invokevirtual net/sqlcipher/database/SQLiteDatabase.unlock ()V
      // 66: lload 1
      // 67: lload 5
      // 69: lmul
      // 6a: lreturn
      // 6b: astore 8
      // 6d: aconst_null
      // 6e: astore 7
      // 70: aload 7
      // 72: ifnull 7a
      // 75: aload 7
      // 77: invokevirtual net/sqlcipher/database/SQLiteStatement.close ()V
      // 7a: aload 0
      // 7b: invokevirtual net/sqlcipher/database/SQLiteDatabase.unlock ()V
      // 7e: aload 8
      // 80: athrow
      // 81: astore 8
      // 83: goto 70
      // 86: lload 3
      // 87: lstore 1
      // 88: goto 2e
      // try (10 -> 17): 55 null
      // try (27 -> 42): 55 null
      // try (42 -> 45): 66 null
   }

   public void setPageSize(long var1) {
      this.execSQL("PRAGMA page_size = " + var1);
   }

   public void setTransactionSuccessful() {
      if (!this.isOpen()) {
         throw new IllegalStateException("database not open");
      }

      if (!this.mLock.isHeldByCurrentThread()) {
         throw new IllegalStateException("no transaction pending");
      }

      if (this.mInnerTransactionIsSuccessful) {
         throw new IllegalStateException("setTransactionSuccessful may only be called once per call to beginTransaction");
      }

      this.mInnerTransactionIsSuccessful = true;
   }

   public void setVersion(int var1) {
      this.execSQL("PRAGMA user_version = " + var1);
   }

   public int status(int var1, boolean var2) {
      return this.native_status(var1, var2);
   }

   void unlock() {
      if (this.mLockingEnabled) {
         if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING && this.mLock.getHoldCount() == 1) {
            this.checkLockHoldTime();
         }

         this.mLock.unlock();
      }
   }

   public int update(String var1, ContentValues var2, String var3, String[] var4) {
      return this.updateWithOnConflict(var1, var2, var3, var4, 0);
   }

   public int updateWithOnConflict(String param1, ContentValues param2, String param3, String[] param4, int param5) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aload 2
      // 001: ifnull 00b
      // 004: aload 2
      // 005: invokevirtual android/content/ContentValues.size ()I
      // 008: ifne 016
      // 00b: new java/lang/IllegalArgumentException
      // 00e: dup
      // 00f: ldc_w "Empty values"
      // 012: invokespecial java/lang/IllegalArgumentException.<init> (Ljava/lang/String;)V
      // 015: athrow
      // 016: new java/lang/StringBuilder
      // 019: dup
      // 01a: bipush 120
      // 01c: invokespecial java/lang/StringBuilder.<init> (I)V
      // 01f: astore 10
      // 021: aload 10
      // 023: ldc_w "UPDATE "
      // 026: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 029: pop
      // 02a: aload 10
      // 02c: getstatic net/sqlcipher/database/SQLiteDatabase.CONFLICT_VALUES [Ljava/lang/String;
      // 02f: iload 5
      // 031: aaload
      // 032: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 035: pop
      // 036: aload 10
      // 038: aload 1
      // 039: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 03c: pop
      // 03d: aload 10
      // 03f: ldc_w " SET "
      // 042: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 045: pop
      // 046: aload 2
      // 047: invokevirtual android/content/ContentValues.valueSet ()Ljava/util/Set;
      // 04a: astore 11
      // 04c: aload 11
      // 04e: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 053: astore 2
      // 054: aload 2
      // 055: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 05a: ifeq 092
      // 05d: aload 10
      // 05f: aload 2
      // 060: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 065: checkcast java/util/Map$Entry
      // 068: invokeinterface java/util/Map$Entry.getKey ()Ljava/lang/Object; 1
      // 06d: checkcast java/lang/String
      // 070: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 073: pop
      // 074: aload 10
      // 076: ldc_w "=?"
      // 079: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 07c: pop
      // 07d: aload 2
      // 07e: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 083: ifeq 054
      // 086: aload 10
      // 088: ldc_w ", "
      // 08b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 08e: pop
      // 08f: goto 054
      // 092: aload 3
      // 093: invokestatic android/text/TextUtils.isEmpty (Ljava/lang/CharSequence;)Z
      // 096: ifne 0a9
      // 099: aload 10
      // 09b: ldc_w " WHERE "
      // 09e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0a1: pop
      // 0a2: aload 10
      // 0a4: aload 3
      // 0a5: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0a8: pop
      // 0a9: aload 0
      // 0aa: invokevirtual net/sqlcipher/database/SQLiteDatabase.lock ()V
      // 0ad: aload 0
      // 0ae: invokevirtual net/sqlcipher/database/SQLiteDatabase.isOpen ()Z
      // 0b1: ifne 0bf
      // 0b4: new java/lang/IllegalStateException
      // 0b7: dup
      // 0b8: ldc_w "database not open"
      // 0bb: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 0be: athrow
      // 0bf: aconst_null
      // 0c0: astore 2
      // 0c1: aconst_null
      // 0c2: astore 9
      // 0c4: aconst_null
      // 0c5: astore 3
      // 0c6: aload 0
      // 0c7: aload 10
      // 0c9: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0cc: invokevirtual net/sqlcipher/database/SQLiteDatabase.compileStatement (Ljava/lang/String;)Lnet/sqlcipher/database/SQLiteStatement;
      // 0cf: astore 10
      // 0d1: aload 10
      // 0d3: astore 3
      // 0d4: aload 10
      // 0d6: astore 2
      // 0d7: aload 10
      // 0d9: astore 9
      // 0db: aload 11
      // 0dd: invokeinterface java/util/Set.size ()I 1
      // 0e2: istore 7
      // 0e4: aload 10
      // 0e6: astore 3
      // 0e7: aload 10
      // 0e9: astore 2
      // 0ea: aload 10
      // 0ec: astore 9
      // 0ee: aload 11
      // 0f0: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 0f5: astore 11
      // 0f7: bipush 1
      // 0f8: istore 5
      // 0fa: bipush 0
      // 0fb: istore 6
      // 0fd: iload 6
      // 0ff: iload 7
      // 101: if_icmpge 12d
      // 104: aload 10
      // 106: astore 3
      // 107: aload 10
      // 109: astore 2
      // 10a: aload 10
      // 10c: astore 9
      // 10e: aload 10
      // 110: iload 5
      // 112: aload 11
      // 114: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 119: checkcast java/util/Map$Entry
      // 11c: invokeinterface java/util/Map$Entry.getValue ()Ljava/lang/Object; 1
      // 121: invokestatic net/sqlcipher/DatabaseUtils.bindObjectToProgram (Lnet/sqlcipher/database/SQLiteProgram;ILjava/lang/Object;)V
      // 124: iinc 5 1
      // 127: iinc 6 1
      // 12a: goto 0fd
      // 12d: aload 4
      // 12f: ifnull 172
      // 132: aload 10
      // 134: astore 3
      // 135: aload 10
      // 137: astore 2
      // 138: aload 10
      // 13a: astore 9
      // 13c: aload 4
      // 13e: arraylength
      // 13f: istore 8
      // 141: bipush 0
      // 142: istore 7
      // 144: iload 5
      // 146: istore 6
      // 148: iload 7
      // 14a: istore 5
      // 14c: iload 5
      // 14e: iload 8
      // 150: if_icmpge 172
      // 153: aload 10
      // 155: astore 3
      // 156: aload 10
      // 158: astore 2
      // 159: aload 10
      // 15b: astore 9
      // 15d: aload 10
      // 15f: iload 6
      // 161: aload 4
      // 163: iload 5
      // 165: aaload
      // 166: invokevirtual net/sqlcipher/database/SQLiteStatement.bindString (ILjava/lang/String;)V
      // 169: iinc 6 1
      // 16c: iinc 5 1
      // 16f: goto 14c
      // 172: aload 10
      // 174: astore 3
      // 175: aload 10
      // 177: astore 2
      // 178: aload 10
      // 17a: astore 9
      // 17c: aload 10
      // 17e: invokevirtual net/sqlcipher/database/SQLiteStatement.execute ()V
      // 181: aload 10
      // 183: astore 3
      // 184: aload 10
      // 186: astore 2
      // 187: aload 10
      // 189: astore 9
      // 18b: aload 0
      // 18c: invokevirtual net/sqlcipher/database/SQLiteDatabase.lastChangeCount ()I
      // 18f: istore 5
      // 191: aload 10
      // 193: astore 3
      // 194: aload 10
      // 196: astore 2
      // 197: aload 10
      // 199: astore 9
      // 19b: ldc "Database"
      // 19d: bipush 2
      // 19e: invokestatic android/util/Log.isLoggable (Ljava/lang/String;I)Z
      // 1a1: ifeq 1ec
      // 1a4: aload 10
      // 1a6: astore 3
      // 1a7: aload 10
      // 1a9: astore 2
      // 1aa: aload 10
      // 1ac: astore 9
      // 1ae: new java/lang/StringBuilder
      // 1b1: astore 4
      // 1b3: aload 10
      // 1b5: astore 3
      // 1b6: aload 10
      // 1b8: astore 2
      // 1b9: aload 10
      // 1bb: astore 9
      // 1bd: aload 4
      // 1bf: invokespecial java/lang/StringBuilder.<init> ()V
      // 1c2: aload 10
      // 1c4: astore 3
      // 1c5: aload 10
      // 1c7: astore 2
      // 1c8: aload 10
      // 1ca: astore 9
      // 1cc: ldc "Database"
      // 1ce: aload 4
      // 1d0: ldc_w "Updated "
      // 1d3: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1d6: iload 5
      // 1d8: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 1db: ldc_w " rows using <redacted values> and <redacted sql> for "
      // 1de: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1e1: aload 1
      // 1e2: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1e5: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 1e8: invokestatic android/util/Log.v (Ljava/lang/String;Ljava/lang/String;)I
      // 1eb: pop
      // 1ec: aload 10
      // 1ee: ifnull 1f6
      // 1f1: aload 10
      // 1f3: invokevirtual net/sqlcipher/database/SQLiteStatement.close ()V
      // 1f6: aload 0
      // 1f7: invokevirtual net/sqlcipher/database/SQLiteDatabase.unlock ()V
      // 1fa: iload 5
      // 1fc: ireturn
      // 1fd: astore 1
      // 1fe: aload 3
      // 1ff: astore 2
      // 200: aload 0
      // 201: invokevirtual net/sqlcipher/database/SQLiteDatabase.onCorruption ()V
      // 204: aload 3
      // 205: astore 2
      // 206: aload 1
      // 207: athrow
      // 208: astore 1
      // 209: aload 2
      // 20a: ifnull 211
      // 20d: aload 2
      // 20e: invokevirtual net/sqlcipher/database/SQLiteStatement.close ()V
      // 211: aload 0
      // 212: invokevirtual net/sqlcipher/database/SQLiteDatabase.unlock ()V
      // 215: aload 1
      // 216: athrow
      // 217: astore 4
      // 219: aload 9
      // 21b: astore 2
      // 21c: new java/lang/StringBuilder
      // 21f: astore 3
      // 220: aload 9
      // 222: astore 2
      // 223: aload 3
      // 224: invokespecial java/lang/StringBuilder.<init> ()V
      // 227: aload 9
      // 229: astore 2
      // 22a: ldc "Database"
      // 22c: aload 3
      // 22d: ldc_w "Error updating <redacted values> using <redacted sql> for "
      // 230: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 233: aload 1
      // 234: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 237: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 23a: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;)I
      // 23d: pop
      // 23e: aload 9
      // 240: astore 2
      // 241: aload 4
      // 243: athrow
      // try (89 -> 94): 240 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (89 -> 94): 258 net/sqlcipher/SQLException
      // try (89 -> 94): 249 null
      // try (100 -> 103): 240 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (100 -> 103): 258 net/sqlcipher/SQLException
      // try (100 -> 103): 249 null
      // try (109 -> 112): 240 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (109 -> 112): 258 net/sqlcipher/SQLException
      // try (109 -> 112): 249 null
      // try (125 -> 132): 240 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (125 -> 132): 258 net/sqlcipher/SQLException
      // try (125 -> 132): 249 null
      // try (143 -> 146): 240 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (143 -> 146): 258 net/sqlcipher/SQLException
      // try (143 -> 146): 249 null
      // try (161 -> 167): 240 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (161 -> 167): 258 net/sqlcipher/SQLException
      // try (161 -> 167): 249 null
      // try (176 -> 178): 240 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (176 -> 178): 258 net/sqlcipher/SQLException
      // try (176 -> 178): 249 null
      // try (184 -> 187): 240 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (184 -> 187): 258 net/sqlcipher/SQLException
      // try (184 -> 187): 249 null
      // try (193 -> 197): 240 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (193 -> 197): 258 net/sqlcipher/SQLException
      // try (193 -> 197): 249 null
      // try (203 -> 205): 240 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (203 -> 205): 258 net/sqlcipher/SQLException
      // try (203 -> 205): 249 null
      // try (211 -> 213): 240 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (211 -> 213): 258 net/sqlcipher/SQLException
      // try (211 -> 213): 249 null
      // try (219 -> 232): 240 net/sqlcipher/database/SQLiteDatabaseCorruptException
      // try (219 -> 232): 258 net/sqlcipher/SQLException
      // try (219 -> 232): 249 null
      // try (243 -> 245): 249 null
      // try (247 -> 249): 249 null
      // try (261 -> 263): 249 null
      // try (265 -> 267): 249 null
      // try (269 -> 278): 249 null
      // try (280 -> 282): 249 null
   }

   @Deprecated
   public boolean yieldIfContended() {
      boolean var1 = false;
      if (this.isOpen()) {
         var1 = this.yieldIfContendedHelper(false, -1L);
      }

      return var1;
   }

   public boolean yieldIfContendedSafely() {
      boolean var1;
      if (!this.isOpen()) {
         var1 = false;
      } else {
         var1 = this.yieldIfContendedHelper(true, -1L);
      }

      return var1;
   }

   public boolean yieldIfContendedSafely(long var1) {
      boolean var3;
      if (!this.isOpen()) {
         var3 = false;
      } else {
         var3 = this.yieldIfContendedHelper(true, var1);
      }

      return var3;
   }

   public interface CursorFactory {
      Cursor newCursor(SQLiteDatabase var1, SQLiteCursorDriver var2, String var3, SQLiteQuery var4);
   }

   public interface LibraryLoader {
      void loadLibraries(String... var1);
   }

   private static class SyncUpdateInfo {
      String deletedTable;
      String foreignKey;
      String masterTable;

      SyncUpdateInfo(String var1, String var2, String var3) {
         this.masterTable = var1;
         this.deletedTable = var2;
         this.foreignKey = var3;
      }
   }
}
