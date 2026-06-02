package net.sqlcipher.database;

import android.content.Context;
import net.sqlcipher.DatabaseErrorHandler;
import net.sqlcipher.DefaultDatabaseErrorHandler;

public abstract class SQLiteOpenHelper {
   private static final String TAG = SQLiteOpenHelper.class.getSimpleName();
   private final Context mContext;
   private SQLiteDatabase mDatabase = null;
   private final DatabaseErrorHandler mErrorHandler;
   private final SQLiteDatabase.CursorFactory mFactory;
   private final SQLiteDatabaseHook mHook;
   private boolean mIsInitializing = false;
   private final String mName;
   private final int mNewVersion;

   public SQLiteOpenHelper(Context var1, String var2, SQLiteDatabase.CursorFactory var3, int var4) {
      this(var1, var2, var3, var4, null, new DefaultDatabaseErrorHandler());
   }

   public SQLiteOpenHelper(Context var1, String var2, SQLiteDatabase.CursorFactory var3, int var4, SQLiteDatabaseHook var5) {
      this(var1, var2, var3, var4, var5, new DefaultDatabaseErrorHandler());
   }

   public SQLiteOpenHelper(Context var1, String var2, SQLiteDatabase.CursorFactory var3, int var4, SQLiteDatabaseHook var5, DatabaseErrorHandler var6) {
      if (var4 < 1) {
         throw new IllegalArgumentException("Version must be >= 1, was " + var4);
      }

      if (var6 == null) {
         throw new IllegalArgumentException("DatabaseErrorHandler param value can't be null.");
      }

      this.mContext = var1;
      this.mName = var2;
      this.mFactory = var3;
      this.mNewVersion = var4;
      this.mHook = var5;
      this.mErrorHandler = var6;
   }

   public void close() {
      synchronized (this) {
         if (this.mIsInitializing) {
            IllegalStateException var1 = new IllegalStateException("Closed during initialization");
            throw var1;
         }

         if (this.mDatabase != null && this.mDatabase.isOpen()) {
            this.mDatabase.close();
            this.mDatabase = null;
         }
      }
   }

   public SQLiteDatabase getReadableDatabase(String param1) {
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
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 1
      // 03: ifnonnull 12
      // 06: aconst_null
      // 07: astore 1
      // 08: aload 0
      // 09: aload 1
      // 0a: invokevirtual net/sqlcipher/database/SQLiteOpenHelper.getReadableDatabase ([C)Lnet/sqlcipher/database/SQLiteDatabase;
      // 0d: astore 1
      // 0e: aload 0
      // 0f: monitorexit
      // 10: aload 1
      // 11: areturn
      // 12: aload 1
      // 13: invokevirtual java/lang/String.toCharArray ()[C
      // 16: astore 1
      // 17: goto 08
      // 1a: astore 1
      // 1b: aload 0
      // 1c: monitorexit
      // 1d: aload 1
      // 1e: athrow
      // try (6 -> 10): 18 null
      // try (14 -> 17): 18 null
   }

   public SQLiteDatabase getReadableDatabase(char[] param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aload 0
      // 001: monitorenter
      // 002: aload 0
      // 003: getfield net/sqlcipher/database/SQLiteOpenHelper.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 006: ifnull 01c
      // 009: aload 0
      // 00a: getfield net/sqlcipher/database/SQLiteOpenHelper.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 00d: invokevirtual net/sqlcipher/database/SQLiteDatabase.isOpen ()Z
      // 010: ifeq 01c
      // 013: aload 0
      // 014: getfield net/sqlcipher/database/SQLiteOpenHelper.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 017: astore 1
      // 018: aload 0
      // 019: monitorexit
      // 01a: aload 1
      // 01b: areturn
      // 01c: aload 0
      // 01d: getfield net/sqlcipher/database/SQLiteOpenHelper.mIsInitializing Z
      // 020: ifeq 034
      // 023: new java/lang/IllegalStateException
      // 026: astore 1
      // 027: aload 1
      // 028: ldc "getReadableDatabase called recursively"
      // 02a: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 02d: aload 1
      // 02e: athrow
      // 02f: astore 1
      // 030: aload 0
      // 031: monitorexit
      // 032: aload 1
      // 033: athrow
      // 034: aload 0
      // 035: aload 1
      // 036: invokevirtual net/sqlcipher/database/SQLiteOpenHelper.getWritableDatabase ([C)Lnet/sqlcipher/database/SQLiteDatabase;
      // 039: astore 2
      // 03a: aload 2
      // 03b: astore 1
      // 03c: goto 018
      // 03f: astore 2
      // 040: aload 0
      // 041: getfield net/sqlcipher/database/SQLiteOpenHelper.mName Ljava/lang/String;
      // 044: ifnonnull 049
      // 047: aload 2
      // 048: athrow
      // 049: getstatic net/sqlcipher/database/SQLiteOpenHelper.TAG Ljava/lang/String;
      // 04c: astore 3
      // 04d: new java/lang/StringBuilder
      // 050: astore 4
      // 052: aload 4
      // 054: invokespecial java/lang/StringBuilder.<init> ()V
      // 057: aload 3
      // 058: aload 4
      // 05a: ldc "Couldn't open "
      // 05c: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 05f: aload 0
      // 060: getfield net/sqlcipher/database/SQLiteOpenHelper.mName Ljava/lang/String;
      // 063: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 066: ldc " for writing (will try read-only):"
      // 068: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 06b: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 06e: aload 2
      // 06f: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 072: pop
      // 073: aconst_null
      // 074: astore 4
      // 076: aconst_null
      // 077: astore 3
      // 078: aload 4
      // 07a: astore 2
      // 07b: aload 0
      // 07c: bipush 1
      // 07d: putfield net/sqlcipher/database/SQLiteOpenHelper.mIsInitializing Z
      // 080: aload 4
      // 082: astore 2
      // 083: aload 0
      // 084: getfield net/sqlcipher/database/SQLiteOpenHelper.mContext Landroid/content/Context;
      // 087: aload 0
      // 088: getfield net/sqlcipher/database/SQLiteOpenHelper.mName Ljava/lang/String;
      // 08b: invokevirtual android/content/Context.getDatabasePath (Ljava/lang/String;)Ljava/io/File;
      // 08e: invokevirtual java/io/File.getPath ()Ljava/lang/String;
      // 091: astore 5
      // 093: aload 4
      // 095: astore 2
      // 096: new java/io/File
      // 099: astore 6
      // 09b: aload 4
      // 09d: astore 2
      // 09e: aload 6
      // 0a0: aload 5
      // 0a2: invokespecial java/io/File.<init> (Ljava/lang/String;)V
      // 0a5: aload 4
      // 0a7: astore 2
      // 0a8: new java/io/File
      // 0ab: astore 7
      // 0ad: aload 4
      // 0af: astore 2
      // 0b0: aload 7
      // 0b2: aload 0
      // 0b3: getfield net/sqlcipher/database/SQLiteOpenHelper.mContext Landroid/content/Context;
      // 0b6: aload 0
      // 0b7: getfield net/sqlcipher/database/SQLiteOpenHelper.mName Ljava/lang/String;
      // 0ba: invokevirtual android/content/Context.getDatabasePath (Ljava/lang/String;)Ljava/io/File;
      // 0bd: invokevirtual java/io/File.getParent ()Ljava/lang/String;
      // 0c0: invokespecial java/io/File.<init> (Ljava/lang/String;)V
      // 0c3: aload 4
      // 0c5: astore 2
      // 0c6: aload 7
      // 0c8: invokevirtual java/io/File.exists ()Z
      // 0cb: ifne 0d7
      // 0ce: aload 4
      // 0d0: astore 2
      // 0d1: aload 7
      // 0d3: invokevirtual java/io/File.mkdirs ()Z
      // 0d6: pop
      // 0d7: aload 4
      // 0d9: astore 2
      // 0da: aload 6
      // 0dc: invokevirtual java/io/File.exists ()Z
      // 0df: ifne 100
      // 0e2: aload 4
      // 0e4: astore 2
      // 0e5: aload 0
      // 0e6: bipush 0
      // 0e7: putfield net/sqlcipher/database/SQLiteOpenHelper.mIsInitializing Z
      // 0ea: aload 4
      // 0ec: astore 2
      // 0ed: aload 0
      // 0ee: aload 1
      // 0ef: invokevirtual net/sqlcipher/database/SQLiteOpenHelper.getWritableDatabase ([C)Lnet/sqlcipher/database/SQLiteDatabase;
      // 0f2: astore 3
      // 0f3: aload 3
      // 0f4: astore 2
      // 0f5: aload 0
      // 0f6: bipush 1
      // 0f7: putfield net/sqlcipher/database/SQLiteOpenHelper.mIsInitializing Z
      // 0fa: aload 3
      // 0fb: astore 2
      // 0fc: aload 3
      // 0fd: invokevirtual net/sqlcipher/database/SQLiteDatabase.close ()V
      // 100: aload 3
      // 101: astore 2
      // 102: aload 5
      // 104: aload 1
      // 105: aload 0
      // 106: getfield net/sqlcipher/database/SQLiteOpenHelper.mFactory Lnet/sqlcipher/database/SQLiteDatabase$CursorFactory;
      // 109: bipush 1
      // 10a: invokestatic net/sqlcipher/database/SQLiteDatabase.openDatabase (Ljava/lang/String;[CLnet/sqlcipher/database/SQLiteDatabase$CursorFactory;I)Lnet/sqlcipher/database/SQLiteDatabase;
      // 10d: astore 3
      // 10e: aload 3
      // 10f: astore 2
      // 110: aload 3
      // 111: invokevirtual net/sqlcipher/database/SQLiteDatabase.getVersion ()I
      // 114: aload 0
      // 115: getfield net/sqlcipher/database/SQLiteOpenHelper.mNewVersion I
      // 118: if_icmpeq 178
      // 11b: aload 3
      // 11c: astore 2
      // 11d: new net/sqlcipher/database/SQLiteException
      // 120: astore 4
      // 122: aload 3
      // 123: astore 2
      // 124: new java/lang/StringBuilder
      // 127: astore 1
      // 128: aload 3
      // 129: astore 2
      // 12a: aload 1
      // 12b: invokespecial java/lang/StringBuilder.<init> ()V
      // 12e: aload 3
      // 12f: astore 2
      // 130: aload 4
      // 132: aload 1
      // 133: ldc "Can't upgrade read-only database from version "
      // 135: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 138: aload 3
      // 139: invokevirtual net/sqlcipher/database/SQLiteDatabase.getVersion ()I
      // 13c: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 13f: ldc " to "
      // 141: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 144: aload 0
      // 145: getfield net/sqlcipher/database/SQLiteOpenHelper.mNewVersion I
      // 148: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 14b: ldc ": "
      // 14d: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 150: aload 5
      // 152: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 155: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 158: invokespecial net/sqlcipher/database/SQLiteException.<init> (Ljava/lang/String;)V
      // 15b: aload 3
      // 15c: astore 2
      // 15d: aload 4
      // 15f: athrow
      // 160: astore 1
      // 161: aload 0
      // 162: bipush 0
      // 163: putfield net/sqlcipher/database/SQLiteOpenHelper.mIsInitializing Z
      // 166: aload 2
      // 167: ifnull 176
      // 16a: aload 2
      // 16b: aload 0
      // 16c: getfield net/sqlcipher/database/SQLiteOpenHelper.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 16f: if_acmpeq 176
      // 172: aload 2
      // 173: invokevirtual net/sqlcipher/database/SQLiteDatabase.close ()V
      // 176: aload 1
      // 177: athrow
      // 178: aload 3
      // 179: astore 2
      // 17a: aload 0
      // 17b: aload 3
      // 17c: invokevirtual net/sqlcipher/database/SQLiteOpenHelper.onOpen (Lnet/sqlcipher/database/SQLiteDatabase;)V
      // 17f: aload 3
      // 180: astore 2
      // 181: getstatic net/sqlcipher/database/SQLiteOpenHelper.TAG Ljava/lang/String;
      // 184: astore 4
      // 186: aload 3
      // 187: astore 2
      // 188: new java/lang/StringBuilder
      // 18b: astore 1
      // 18c: aload 3
      // 18d: astore 2
      // 18e: aload 1
      // 18f: invokespecial java/lang/StringBuilder.<init> ()V
      // 192: aload 3
      // 193: astore 2
      // 194: aload 4
      // 196: aload 1
      // 197: ldc "Opened "
      // 199: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 19c: aload 0
      // 19d: getfield net/sqlcipher/database/SQLiteOpenHelper.mName Ljava/lang/String;
      // 1a0: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1a3: ldc " in read-only mode"
      // 1a5: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1a8: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 1ab: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // 1ae: pop
      // 1af: aload 3
      // 1b0: astore 2
      // 1b1: aload 0
      // 1b2: aload 3
      // 1b3: putfield net/sqlcipher/database/SQLiteOpenHelper.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 1b6: aload 3
      // 1b7: astore 2
      // 1b8: aload 0
      // 1b9: getfield net/sqlcipher/database/SQLiteOpenHelper.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 1bc: astore 4
      // 1be: aload 0
      // 1bf: bipush 0
      // 1c0: putfield net/sqlcipher/database/SQLiteOpenHelper.mIsInitializing Z
      // 1c3: aload 4
      // 1c5: astore 1
      // 1c6: aload 3
      // 1c7: ifnull 018
      // 1ca: aload 4
      // 1cc: astore 1
      // 1cd: aload 3
      // 1ce: aload 0
      // 1cf: getfield net/sqlcipher/database/SQLiteOpenHelper.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 1d2: if_acmpeq 018
      // 1d5: aload 3
      // 1d6: invokevirtual net/sqlcipher/database/SQLiteDatabase.close ()V
      // 1d9: aload 4
      // 1db: astore 1
      // 1dc: goto 018
      // try (2 -> 12): 26 null
      // try (16 -> 26): 26 null
      // try (31 -> 35): 38 net/sqlcipher/database/SQLiteException
      // try (31 -> 35): 26 null
      // try (39 -> 44): 26 null
      // try (44 -> 63): 26 null
      // try (69 -> 72): 191 null
      // try (74 -> 81): 191 null
      // try (83 -> 85): 191 null
      // try (87 -> 90): 191 null
      // try (92 -> 94): 191 null
      // try (96 -> 104): 191 null
      // try (106 -> 109): 191 null
      // try (111 -> 114): 191 null
      // try (116 -> 119): 191 null
      // try (121 -> 124): 191 null
      // try (126 -> 130): 191 null
      // try (132 -> 135): 191 null
      // try (137 -> 139): 191 null
      // try (141 -> 148): 191 null
      // try (150 -> 155): 191 null
      // try (157 -> 159): 191 null
      // try (161 -> 163): 191 null
      // try (165 -> 167): 191 null
      // try (169 -> 187): 191 null
      // try (189 -> 191): 191 null
      // try (192 -> 195): 26 null
      // try (197 -> 203): 26 null
      // try (203 -> 205): 26 null
      // try (207 -> 210): 191 null
      // try (212 -> 214): 191 null
      // try (216 -> 218): 191 null
      // try (220 -> 222): 191 null
      // try (224 -> 236): 191 null
      // try (238 -> 241): 191 null
      // try (243 -> 246): 191 null
      // try (246 -> 249): 26 null
      // try (255 -> 261): 26 null
   }

   public SQLiteDatabase getWritableDatabase(String param1) {
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
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 1
      // 03: ifnonnull 12
      // 06: aconst_null
      // 07: astore 1
      // 08: aload 0
      // 09: aload 1
      // 0a: invokevirtual net/sqlcipher/database/SQLiteOpenHelper.getWritableDatabase ([C)Lnet/sqlcipher/database/SQLiteDatabase;
      // 0d: astore 1
      // 0e: aload 0
      // 0f: monitorexit
      // 10: aload 1
      // 11: areturn
      // 12: aload 1
      // 13: invokevirtual java/lang/String.toCharArray ()[C
      // 16: astore 1
      // 17: goto 08
      // 1a: astore 1
      // 1b: aload 0
      // 1c: monitorexit
      // 1d: aload 1
      // 1e: athrow
      // try (6 -> 10): 18 null
      // try (14 -> 17): 18 null
   }

   public SQLiteDatabase getWritableDatabase(char[] param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aconst_null
      // 001: astore 4
      // 003: aload 0
      // 004: monitorenter
      // 005: aload 0
      // 006: getfield net/sqlcipher/database/SQLiteOpenHelper.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 009: ifnull 029
      // 00c: aload 0
      // 00d: getfield net/sqlcipher/database/SQLiteOpenHelper.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 010: invokevirtual net/sqlcipher/database/SQLiteDatabase.isOpen ()Z
      // 013: ifeq 029
      // 016: aload 0
      // 017: getfield net/sqlcipher/database/SQLiteOpenHelper.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 01a: invokevirtual net/sqlcipher/database/SQLiteDatabase.isReadOnly ()Z
      // 01d: ifne 029
      // 020: aload 0
      // 021: getfield net/sqlcipher/database/SQLiteOpenHelper.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 024: astore 1
      // 025: aload 0
      // 026: monitorexit
      // 027: aload 1
      // 028: areturn
      // 029: aload 0
      // 02a: getfield net/sqlcipher/database/SQLiteOpenHelper.mIsInitializing Z
      // 02d: ifeq 041
      // 030: new java/lang/IllegalStateException
      // 033: astore 1
      // 034: aload 1
      // 035: ldc "getWritableDatabase called recursively"
      // 037: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 03a: aload 1
      // 03b: athrow
      // 03c: astore 1
      // 03d: aload 0
      // 03e: monitorexit
      // 03f: aload 1
      // 040: athrow
      // 041: aload 0
      // 042: getfield net/sqlcipher/database/SQLiteOpenHelper.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 045: ifnull 04f
      // 048: aload 0
      // 049: getfield net/sqlcipher/database/SQLiteOpenHelper.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 04c: invokevirtual net/sqlcipher/database/SQLiteDatabase.lock ()V
      // 04f: aload 0
      // 050: bipush 1
      // 051: putfield net/sqlcipher/database/SQLiteOpenHelper.mIsInitializing Z
      // 054: aload 0
      // 055: getfield net/sqlcipher/database/SQLiteOpenHelper.mName Ljava/lang/String;
      // 058: ifnonnull 0b4
      // 05b: aconst_null
      // 05c: aload 1
      // 05d: invokestatic net/sqlcipher/database/SQLiteDatabase.create (Lnet/sqlcipher/database/SQLiteDatabase$CursorFactory;[C)Lnet/sqlcipher/database/SQLiteDatabase;
      // 060: astore 1
      // 061: aload 1
      // 062: invokevirtual net/sqlcipher/database/SQLiteDatabase.getVersion ()I
      // 065: istore 2
      // 066: iload 2
      // 067: aload 0
      // 068: getfield net/sqlcipher/database/SQLiteOpenHelper.mNewVersion I
      // 06b: if_icmpeq 08b
      // 06e: aload 1
      // 06f: invokevirtual net/sqlcipher/database/SQLiteDatabase.beginTransaction ()V
      // 072: iload 2
      // 073: ifne 0f3
      // 076: aload 0
      // 077: aload 1
      // 078: invokevirtual net/sqlcipher/database/SQLiteOpenHelper.onCreate (Lnet/sqlcipher/database/SQLiteDatabase;)V
      // 07b: aload 1
      // 07c: aload 0
      // 07d: getfield net/sqlcipher/database/SQLiteOpenHelper.mNewVersion I
      // 080: invokevirtual net/sqlcipher/database/SQLiteDatabase.setVersion (I)V
      // 083: aload 1
      // 084: invokevirtual net/sqlcipher/database/SQLiteDatabase.setTransactionSuccessful ()V
      // 087: aload 1
      // 088: invokevirtual net/sqlcipher/database/SQLiteDatabase.endTransaction ()V
      // 08b: aload 0
      // 08c: aload 1
      // 08d: invokevirtual net/sqlcipher/database/SQLiteOpenHelper.onOpen (Lnet/sqlcipher/database/SQLiteDatabase;)V
      // 090: aload 0
      // 091: bipush 0
      // 092: putfield net/sqlcipher/database/SQLiteOpenHelper.mIsInitializing Z
      // 095: aload 0
      // 096: getfield net/sqlcipher/database/SQLiteOpenHelper.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 099: astore 3
      // 09a: aload 3
      // 09b: ifnull 0ac
      // 09e: aload 0
      // 09f: getfield net/sqlcipher/database/SQLiteOpenHelper.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 0a2: invokevirtual net/sqlcipher/database/SQLiteDatabase.close ()V
      // 0a5: aload 0
      // 0a6: getfield net/sqlcipher/database/SQLiteOpenHelper.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 0a9: invokevirtual net/sqlcipher/database/SQLiteDatabase.unlock ()V
      // 0ac: aload 0
      // 0ad: aload 1
      // 0ae: putfield net/sqlcipher/database/SQLiteOpenHelper.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 0b1: goto 025
      // 0b4: aload 0
      // 0b5: getfield net/sqlcipher/database/SQLiteOpenHelper.mContext Landroid/content/Context;
      // 0b8: aload 0
      // 0b9: getfield net/sqlcipher/database/SQLiteOpenHelper.mName Ljava/lang/String;
      // 0bc: invokevirtual android/content/Context.getDatabasePath (Ljava/lang/String;)Ljava/io/File;
      // 0bf: invokevirtual java/io/File.getPath ()Ljava/lang/String;
      // 0c2: astore 5
      // 0c4: new java/io/File
      // 0c7: astore 3
      // 0c8: aload 3
      // 0c9: aload 5
      // 0cb: invokespecial java/io/File.<init> (Ljava/lang/String;)V
      // 0ce: aload 3
      // 0cf: invokevirtual java/io/File.exists ()Z
      // 0d2: ifne 0dd
      // 0d5: aload 3
      // 0d6: invokevirtual java/io/File.getParentFile ()Ljava/io/File;
      // 0d9: invokevirtual java/io/File.mkdirs ()Z
      // 0dc: pop
      // 0dd: aload 5
      // 0df: aload 1
      // 0e0: aload 0
      // 0e1: getfield net/sqlcipher/database/SQLiteOpenHelper.mFactory Lnet/sqlcipher/database/SQLiteDatabase$CursorFactory;
      // 0e4: aload 0
      // 0e5: getfield net/sqlcipher/database/SQLiteOpenHelper.mHook Lnet/sqlcipher/database/SQLiteDatabaseHook;
      // 0e8: aload 0
      // 0e9: getfield net/sqlcipher/database/SQLiteOpenHelper.mErrorHandler Lnet/sqlcipher/DatabaseErrorHandler;
      // 0ec: invokestatic net/sqlcipher/database/SQLiteDatabase.openOrCreateDatabase (Ljava/lang/String;[CLnet/sqlcipher/database/SQLiteDatabase$CursorFactory;Lnet/sqlcipher/database/SQLiteDatabaseHook;Lnet/sqlcipher/DatabaseErrorHandler;)Lnet/sqlcipher/database/SQLiteDatabase;
      // 0ef: astore 1
      // 0f0: goto 061
      // 0f3: aload 0
      // 0f4: aload 1
      // 0f5: iload 2
      // 0f6: aload 0
      // 0f7: getfield net/sqlcipher/database/SQLiteOpenHelper.mNewVersion I
      // 0fa: invokevirtual net/sqlcipher/database/SQLiteOpenHelper.onUpgrade (Lnet/sqlcipher/database/SQLiteDatabase;II)V
      // 0fd: goto 07b
      // 100: astore 3
      // 101: aload 1
      // 102: invokevirtual net/sqlcipher/database/SQLiteDatabase.endTransaction ()V
      // 105: aload 3
      // 106: athrow
      // 107: astore 3
      // 108: aload 0
      // 109: bipush 0
      // 10a: putfield net/sqlcipher/database/SQLiteOpenHelper.mIsInitializing Z
      // 10d: aload 0
      // 10e: getfield net/sqlcipher/database/SQLiteOpenHelper.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 111: ifnull 11b
      // 114: aload 0
      // 115: getfield net/sqlcipher/database/SQLiteOpenHelper.mDatabase Lnet/sqlcipher/database/SQLiteDatabase;
      // 118: invokevirtual net/sqlcipher/database/SQLiteDatabase.unlock ()V
      // 11b: aload 1
      // 11c: ifnull 123
      // 11f: aload 1
      // 120: invokevirtual net/sqlcipher/database/SQLiteDatabase.close ()V
      // 123: aload 3
      // 124: athrow
      // 125: astore 3
      // 126: aload 4
      // 128: astore 1
      // 129: goto 108
      // 12c: astore 3
      // 12d: goto 0a5
      // try (4 -> 18): 32 null
      // try (22 -> 32): 32 null
      // try (37 -> 43): 32 null
      // try (43 -> 53): 154 null
      // try (53 -> 62): 138 null
      // try (64 -> 67): 133 null
      // try (67 -> 73): 133 null
      // try (73 -> 75): 138 null
      // try (75 -> 78): 138 null
      // try (78 -> 84): 32 null
      // try (86 -> 89): 158 java/lang/Exception
      // try (86 -> 89): 32 null
      // try (89 -> 92): 32 null
      // try (92 -> 95): 32 null
      // try (96 -> 115): 154 null
      // try (115 -> 125): 154 null
      // try (126 -> 132): 133 null
      // try (134 -> 138): 138 null
      // try (139 -> 148): 32 null
      // try (150 -> 152): 32 null
      // try (152 -> 154): 32 null
   }

   public abstract void onCreate(SQLiteDatabase var1);

   public void onOpen(SQLiteDatabase var1) {
   }

   public abstract void onUpgrade(SQLiteDatabase var1, int var2, int var3);
}
