package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcel;
import java.util.List;

public final class zzchi extends zzcjl {
   private final zzchj a = new zzchj(this, this.l(), "google_app_measurement_local.db");
   private boolean b;

   zzchi(zzcim var1) {
      super(var1);
   }

   @TargetApi(11)
   private final boolean a(int param1, byte[] param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aload 0
      // 001: invokevirtual com/google/android/gms/internal/zzcjk.c ()V
      // 004: aload 0
      // 005: getfield com/google/android/gms/internal/zzchi.b Z
      // 008: ifeq 011
      // 00b: bipush 0
      // 00c: istore 9
      // 00e: iload 9
      // 010: ireturn
      // 011: new android/content/ContentValues
      // 014: dup
      // 015: invokespecial android/content/ContentValues.<init> ()V
      // 018: astore 19
      // 01a: aload 19
      // 01c: ldc "type"
      // 01e: iload 1
      // 01f: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 022: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/Integer;)V
      // 025: aload 19
      // 027: ldc "entry"
      // 029: aload 2
      // 02a: invokevirtual android/content/ContentValues.put (Ljava/lang/String;[B)V
      // 02d: bipush 0
      // 02e: istore 3
      // 02f: bipush 5
      // 030: istore 1
      // 031: iload 3
      // 032: bipush 5
      // 033: if_icmpge 324
      // 036: aconst_null
      // 037: astore 14
      // 039: aconst_null
      // 03a: astore 10
      // 03c: aconst_null
      // 03d: astore 13
      // 03f: aconst_null
      // 040: astore 18
      // 042: aconst_null
      // 043: astore 17
      // 045: aconst_null
      // 046: astore 16
      // 048: aload 16
      // 04a: astore 11
      // 04c: aload 18
      // 04e: astore 12
      // 050: aload 17
      // 052: astore 2
      // 053: aload 0
      // 054: invokespecial com/google/android/gms/internal/zzchi.z ()Landroid/database/sqlite/SQLiteDatabase;
      // 057: astore 15
      // 059: aload 15
      // 05b: ifnonnull 08a
      // 05e: aload 16
      // 060: astore 11
      // 062: aload 15
      // 064: astore 13
      // 066: aload 18
      // 068: astore 12
      // 06a: aload 15
      // 06c: astore 14
      // 06e: aload 17
      // 070: astore 2
      // 071: aload 15
      // 073: astore 10
      // 075: aload 0
      // 076: bipush 1
      // 077: putfield com/google/android/gms/internal/zzchi.b Z
      // 07a: aload 15
      // 07c: ifnull 084
      // 07f: aload 15
      // 081: invokevirtual android/database/sqlite/SQLiteDatabase.close ()V
      // 084: bipush 0
      // 085: istore 9
      // 087: goto 00e
      // 08a: aload 16
      // 08c: astore 11
      // 08e: aload 15
      // 090: astore 13
      // 092: aload 18
      // 094: astore 12
      // 096: aload 15
      // 098: astore 14
      // 09a: aload 17
      // 09c: astore 2
      // 09d: aload 15
      // 09f: astore 10
      // 0a1: aload 15
      // 0a3: invokevirtual android/database/sqlite/SQLiteDatabase.beginTransaction ()V
      // 0a6: lconst_0
      // 0a7: lstore 7
      // 0a9: aload 16
      // 0ab: astore 11
      // 0ad: aload 15
      // 0af: astore 13
      // 0b1: aload 18
      // 0b3: astore 12
      // 0b5: aload 15
      // 0b7: astore 14
      // 0b9: aload 17
      // 0bb: astore 2
      // 0bc: aload 15
      // 0be: astore 10
      // 0c0: aload 15
      // 0c2: ldc "select count(1) from messages"
      // 0c4: aconst_null
      // 0c5: invokevirtual android/database/sqlite/SQLiteDatabase.rawQuery (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
      // 0c8: astore 16
      // 0ca: lload 7
      // 0cc: lstore 5
      // 0ce: aload 16
      // 0d0: ifnull 119
      // 0d3: lload 7
      // 0d5: lstore 5
      // 0d7: aload 16
      // 0d9: astore 11
      // 0db: aload 15
      // 0dd: astore 13
      // 0df: aload 16
      // 0e1: astore 12
      // 0e3: aload 15
      // 0e5: astore 14
      // 0e7: aload 16
      // 0e9: astore 2
      // 0ea: aload 15
      // 0ec: astore 10
      // 0ee: aload 16
      // 0f0: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 0f5: ifeq 119
      // 0f8: aload 16
      // 0fa: astore 11
      // 0fc: aload 15
      // 0fe: astore 13
      // 100: aload 16
      // 102: astore 12
      // 104: aload 15
      // 106: astore 14
      // 108: aload 16
      // 10a: astore 2
      // 10b: aload 15
      // 10d: astore 10
      // 10f: aload 16
      // 111: bipush 0
      // 112: invokeinterface android/database/Cursor.getLong (I)J 2
      // 117: lstore 5
      // 119: lload 5
      // 11b: ldc2_w 100000
      // 11e: lcmp
      // 11f: iflt 1bb
      // 122: aload 16
      // 124: astore 11
      // 126: aload 15
      // 128: astore 13
      // 12a: aload 16
      // 12c: astore 12
      // 12e: aload 15
      // 130: astore 14
      // 132: aload 16
      // 134: astore 2
      // 135: aload 15
      // 137: astore 10
      // 139: aload 0
      // 13a: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 13d: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 140: ldc "Data loss, local db full"
      // 142: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;)V
      // 145: ldc2_w 100000
      // 148: lload 5
      // 14a: lsub
      // 14b: lconst_1
      // 14c: ladd
      // 14d: lstore 7
      // 14f: aload 16
      // 151: astore 11
      // 153: aload 15
      // 155: astore 13
      // 157: aload 16
      // 159: astore 12
      // 15b: aload 15
      // 15d: astore 14
      // 15f: aload 16
      // 161: astore 2
      // 162: aload 15
      // 164: astore 10
      // 166: aload 15
      // 168: ldc "messages"
      // 16a: ldc "rowid in (select rowid from messages order by rowid asc limit ?)"
      // 16c: bipush 1
      // 16d: anewarray 116
      // 170: dup
      // 171: bipush 0
      // 172: lload 7
      // 174: invokestatic java/lang/Long.toString (J)Ljava/lang/String;
      // 177: aastore
      // 178: invokevirtual android/database/sqlite/SQLiteDatabase.delete (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
      // 17b: i2l
      // 17c: lstore 5
      // 17e: lload 5
      // 180: lload 7
      // 182: lcmp
      // 183: ifeq 1bb
      // 186: aload 16
      // 188: astore 11
      // 18a: aload 15
      // 18c: astore 13
      // 18e: aload 16
      // 190: astore 12
      // 192: aload 15
      // 194: astore 14
      // 196: aload 16
      // 198: astore 2
      // 199: aload 15
      // 19b: astore 10
      // 19d: aload 0
      // 19e: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 1a1: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 1a4: ldc "Different delete count than expected in local db. expected, received, difference"
      // 1a6: lload 7
      // 1a8: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 1ab: lload 5
      // 1ad: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 1b0: lload 7
      // 1b2: lload 5
      // 1b4: lsub
      // 1b5: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 1b8: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
      // 1bb: aload 16
      // 1bd: astore 11
      // 1bf: aload 15
      // 1c1: astore 13
      // 1c3: aload 16
      // 1c5: astore 12
      // 1c7: aload 15
      // 1c9: astore 14
      // 1cb: aload 16
      // 1cd: astore 2
      // 1ce: aload 15
      // 1d0: astore 10
      // 1d2: aload 15
      // 1d4: ldc "messages"
      // 1d6: aconst_null
      // 1d7: aload 19
      // 1d9: invokevirtual android/database/sqlite/SQLiteDatabase.insertOrThrow (Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
      // 1dc: pop2
      // 1dd: aload 16
      // 1df: astore 11
      // 1e1: aload 15
      // 1e3: astore 13
      // 1e5: aload 16
      // 1e7: astore 12
      // 1e9: aload 15
      // 1eb: astore 14
      // 1ed: aload 16
      // 1ef: astore 2
      // 1f0: aload 15
      // 1f2: astore 10
      // 1f4: aload 15
      // 1f6: invokevirtual android/database/sqlite/SQLiteDatabase.setTransactionSuccessful ()V
      // 1f9: aload 16
      // 1fb: astore 11
      // 1fd: aload 15
      // 1ff: astore 13
      // 201: aload 16
      // 203: astore 12
      // 205: aload 15
      // 207: astore 14
      // 209: aload 16
      // 20b: astore 2
      // 20c: aload 15
      // 20e: astore 10
      // 210: aload 15
      // 212: invokevirtual android/database/sqlite/SQLiteDatabase.endTransaction ()V
      // 215: aload 16
      // 217: ifnull 221
      // 21a: aload 16
      // 21c: invokeinterface android/database/Cursor.close ()V 1
      // 221: aload 15
      // 223: ifnull 22b
      // 226: aload 15
      // 228: invokevirtual android/database/sqlite/SQLiteDatabase.close ()V
      // 22b: bipush 1
      // 22c: istore 9
      // 22e: goto 00e
      // 231: astore 12
      // 233: aload 11
      // 235: astore 2
      // 236: aload 13
      // 238: astore 10
      // 23a: aload 0
      // 23b: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 23e: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 241: ldc "Error writing entry to local database"
      // 243: aload 12
      // 245: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;)V
      // 248: aload 11
      // 24a: astore 2
      // 24b: aload 13
      // 24d: astore 10
      // 24f: aload 0
      // 250: bipush 1
      // 251: putfield com/google/android/gms/internal/zzchi.b Z
      // 254: aload 11
      // 256: ifnull 260
      // 259: aload 11
      // 25b: invokeinterface android/database/Cursor.close ()V 1
      // 260: iload 1
      // 261: istore 4
      // 263: aload 13
      // 265: ifnull 270
      // 268: aload 13
      // 26a: invokevirtual android/database/sqlite/SQLiteDatabase.close ()V
      // 26d: iload 1
      // 26e: istore 4
      // 270: iinc 3 1
      // 273: iload 4
      // 275: istore 1
      // 276: goto 031
      // 279: astore 11
      // 27b: aload 12
      // 27d: astore 2
      // 27e: aload 14
      // 280: astore 10
      // 282: getstatic android/os/Build$VERSION.SDK_INT I
      // 285: bipush 11
      // 287: if_icmplt 2c7
      // 28a: aload 12
      // 28c: astore 2
      // 28d: aload 14
      // 28f: astore 10
      // 291: aload 11
      // 293: instanceof android/database/sqlite/SQLiteDatabaseLockedException
      // 296: ifeq 2c7
      // 299: aload 12
      // 29b: astore 2
      // 29c: aload 14
      // 29e: astore 10
      // 2a0: iload 1
      // 2a1: i2l
      // 2a2: invokestatic android/os/SystemClock.sleep (J)V
      // 2a5: iinc 1 20
      // 2a8: aload 12
      // 2aa: ifnull 2b4
      // 2ad: aload 12
      // 2af: invokeinterface android/database/Cursor.close ()V 1
      // 2b4: iload 1
      // 2b5: istore 4
      // 2b7: aload 14
      // 2b9: ifnull 270
      // 2bc: aload 14
      // 2be: invokevirtual android/database/sqlite/SQLiteDatabase.close ()V
      // 2c1: iload 1
      // 2c2: istore 4
      // 2c4: goto 270
      // 2c7: aload 14
      // 2c9: ifnull 2e7
      // 2cc: aload 12
      // 2ce: astore 2
      // 2cf: aload 14
      // 2d1: astore 10
      // 2d3: aload 14
      // 2d5: invokevirtual android/database/sqlite/SQLiteDatabase.inTransaction ()Z
      // 2d8: ifeq 2e7
      // 2db: aload 12
      // 2dd: astore 2
      // 2de: aload 14
      // 2e0: astore 10
      // 2e2: aload 14
      // 2e4: invokevirtual android/database/sqlite/SQLiteDatabase.endTransaction ()V
      // 2e7: aload 12
      // 2e9: astore 2
      // 2ea: aload 14
      // 2ec: astore 10
      // 2ee: aload 0
      // 2ef: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 2f2: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 2f5: ldc "Error writing entry to local database"
      // 2f7: aload 11
      // 2f9: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;)V
      // 2fc: aload 12
      // 2fe: astore 2
      // 2ff: aload 14
      // 301: astore 10
      // 303: aload 0
      // 304: bipush 1
      // 305: putfield com/google/android/gms/internal/zzchi.b Z
      // 308: goto 2a8
      // 30b: astore 11
      // 30d: aload 2
      // 30e: ifnull 317
      // 311: aload 2
      // 312: invokeinterface android/database/Cursor.close ()V 1
      // 317: aload 10
      // 319: ifnull 321
      // 31c: aload 10
      // 31e: invokevirtual android/database/sqlite/SQLiteDatabase.close ()V
      // 321: aload 11
      // 323: athrow
      // 324: aload 0
      // 325: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 328: invokevirtual com/google/android/gms/internal/zzchm.A ()Lcom/google/android/gms/internal/zzcho;
      // 32b: ldc "Failed to write entry to local database"
      // 32d: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;)V
      // 330: bipush 0
      // 331: istore 9
      // 333: goto 00e
      // try (47 -> 50): 282 android/database/sqlite/SQLiteFullException
      // try (47 -> 50): 316 android/database/sqlite/SQLiteException
      // try (47 -> 50): 385 null
      // try (64 -> 67): 282 android/database/sqlite/SQLiteFullException
      // try (64 -> 67): 316 android/database/sqlite/SQLiteException
      // try (64 -> 67): 385 null
      // try (86 -> 88): 282 android/database/sqlite/SQLiteFullException
      // try (86 -> 88): 316 android/database/sqlite/SQLiteException
      // try (86 -> 88): 385 null
      // try (102 -> 107): 282 android/database/sqlite/SQLiteFullException
      // try (102 -> 107): 316 android/database/sqlite/SQLiteException
      // try (102 -> 107): 385 null
      // try (125 -> 128): 282 android/database/sqlite/SQLiteFullException
      // try (125 -> 128): 316 android/database/sqlite/SQLiteException
      // try (125 -> 128): 385 null
      // try (140 -> 144): 282 android/database/sqlite/SQLiteFullException
      // try (140 -> 144): 316 android/database/sqlite/SQLiteException
      // try (140 -> 144): 385 null
      // try (160 -> 165): 282 android/database/sqlite/SQLiteFullException
      // try (160 -> 165): 316 android/database/sqlite/SQLiteException
      // try (160 -> 165): 385 null
      // try (183 -> 196): 282 android/database/sqlite/SQLiteFullException
      // try (183 -> 196): 316 android/database/sqlite/SQLiteException
      // try (183 -> 196): 385 null
      // try (212 -> 225): 282 android/database/sqlite/SQLiteFullException
      // try (212 -> 225): 316 android/database/sqlite/SQLiteException
      // try (212 -> 225): 385 null
      // try (237 -> 243): 282 android/database/sqlite/SQLiteFullException
      // try (237 -> 243): 316 android/database/sqlite/SQLiteException
      // try (237 -> 243): 385 null
      // try (255 -> 257): 282 android/database/sqlite/SQLiteFullException
      // try (255 -> 257): 316 android/database/sqlite/SQLiteException
      // try (255 -> 257): 385 null
      // try (269 -> 271): 282 android/database/sqlite/SQLiteFullException
      // try (269 -> 271): 316 android/database/sqlite/SQLiteException
      // try (269 -> 271): 385 null
      // try (287 -> 293): 385 null
      // try (297 -> 300): 385 null
      // try (321 -> 324): 385 null
      // try (328 -> 331): 385 null
      // try (335 -> 338): 385 null
      // try (358 -> 361): 385 null
      // try (365 -> 367): 385 null
      // try (371 -> 377): 385 null
      // try (381 -> 384): 385 null
   }

   private final SQLiteDatabase z() {
      SQLiteDatabase var1 = null;
      if (!this.b) {
         SQLiteDatabase var2 = this.a.getWritableDatabase();
         if (var2 == null) {
            this.b = true;
         } else {
            var1 = var2;
         }
      }

      return var1;
   }

   @TargetApi(11)
   public final List<zzbfm> a(int param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aload 0
      // 001: invokevirtual com/google/android/gms/internal/zzcjk.c ()V
      // 004: aload 0
      // 005: getfield com/google/android/gms/internal/zzchi.b Z
      // 008: ifeq 011
      // 00b: aconst_null
      // 00c: astore 8
      // 00e: aload 8
      // 010: areturn
      // 011: new java/util/ArrayList
      // 014: dup
      // 015: invokespecial java/util/ArrayList.<init> ()V
      // 018: astore 11
      // 01a: aload 0
      // 01b: invokevirtual com/google/android/gms/internal/zzcjk.l ()Landroid/content/Context;
      // 01e: ldc "google_app_measurement_local.db"
      // 020: invokevirtual android/content/Context.getDatabasePath (Ljava/lang/String;)Ljava/io/File;
      // 023: invokevirtual java/io/File.exists ()Z
      // 026: ifne 030
      // 029: aload 11
      // 02b: astore 8
      // 02d: goto 00e
      // 030: bipush 5
      // 031: istore 1
      // 032: bipush 0
      // 033: istore 3
      // 034: iload 3
      // 035: bipush 5
      // 036: if_icmpge 335
      // 039: aconst_null
      // 03a: astore 10
      // 03c: aconst_null
      // 03d: astore 9
      // 03f: aload 0
      // 040: invokespecial com/google/android/gms/internal/zzchi.z ()Landroid/database/sqlite/SQLiteDatabase;
      // 043: astore 8
      // 045: aload 8
      // 047: ifnonnull 05f
      // 04a: aload 0
      // 04b: bipush 1
      // 04c: putfield com/google/android/gms/internal/zzchi.b Z
      // 04f: aload 8
      // 051: ifnull 059
      // 054: aload 8
      // 056: invokevirtual android/database/sqlite/SQLiteDatabase.close ()V
      // 059: aconst_null
      // 05a: astore 8
      // 05c: goto 00e
      // 05f: aload 8
      // 061: invokevirtual android/database/sqlite/SQLiteDatabase.beginTransaction ()V
      // 064: bipush 100
      // 066: invokestatic java/lang/Integer.toString (I)Ljava/lang/String;
      // 069: astore 9
      // 06b: aload 8
      // 06d: ldc "messages"
      // 06f: bipush 3
      // 070: anewarray 116
      // 073: dup
      // 074: bipush 0
      // 075: ldc "rowid"
      // 077: aastore
      // 078: dup
      // 079: bipush 1
      // 07a: ldc "type"
      // 07c: aastore
      // 07d: dup
      // 07e: bipush 2
      // 07f: ldc "entry"
      // 081: aastore
      // 082: aconst_null
      // 083: aconst_null
      // 084: aconst_null
      // 085: aconst_null
      // 086: ldc "rowid asc"
      // 088: aload 9
      // 08a: invokevirtual android/database/sqlite/SQLiteDatabase.query (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      // 08d: astore 10
      // 08f: ldc2_w -1
      // 092: lstore 4
      // 094: aload 10
      // 096: invokeinterface android/database/Cursor.moveToNext ()Z 1
      // 09b: ifeq 2b7
      // 09e: aload 10
      // 0a0: bipush 0
      // 0a1: invokeinterface android/database/Cursor.getLong (I)J 2
      // 0a6: lstore 6
      // 0a8: aload 10
      // 0aa: bipush 1
      // 0ab: invokeinterface android/database/Cursor.getInt (I)I 2
      // 0b0: istore 2
      // 0b1: aload 10
      // 0b3: bipush 2
      // 0b4: invokeinterface android/database/Cursor.getBlob (I)[B 2
      // 0b9: astore 13
      // 0bb: iload 2
      // 0bc: ifne 1c9
      // 0bf: invokestatic android/os/Parcel.obtain ()Landroid/os/Parcel;
      // 0c2: astore 9
      // 0c4: aload 9
      // 0c6: aload 13
      // 0c8: bipush 0
      // 0c9: aload 13
      // 0cb: arraylength
      // 0cc: invokevirtual android/os/Parcel.unmarshall ([BII)V
      // 0cf: aload 9
      // 0d1: bipush 0
      // 0d2: invokevirtual android/os/Parcel.setDataPosition (I)V
      // 0d5: getstatic com/google/android/gms/internal/zzcha.CREATOR Landroid/os/Parcelable$Creator;
      // 0d8: aload 9
      // 0da: invokeinterface android/os/Parcelable$Creator.createFromParcel (Landroid/os/Parcel;)Ljava/lang/Object; 2
      // 0df: checkcast com/google/android/gms/internal/zzcha
      // 0e2: astore 12
      // 0e4: aload 9
      // 0e6: invokevirtual android/os/Parcel.recycle ()V
      // 0e9: lload 6
      // 0eb: lstore 4
      // 0ed: aload 12
      // 0ef: ifnull 094
      // 0f2: aload 11
      // 0f4: aload 12
      // 0f6: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 0fb: pop
      // 0fc: lload 6
      // 0fe: lstore 4
      // 100: goto 094
      // 103: astore 12
      // 105: aload 8
      // 107: astore 9
      // 109: aload 10
      // 10b: astore 8
      // 10d: aload 12
      // 10f: astore 10
      // 111: aload 0
      // 112: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 115: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 118: ldc "Error reading entries from local database"
      // 11a: aload 10
      // 11c: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;)V
      // 11f: aload 0
      // 120: bipush 1
      // 121: putfield com/google/android/gms/internal/zzchi.b Z
      // 124: aload 8
      // 126: ifnull 130
      // 129: aload 8
      // 12b: invokeinterface android/database/Cursor.close ()V 1
      // 130: aload 9
      // 132: ifnull 3a9
      // 135: aload 9
      // 137: invokevirtual android/database/sqlite/SQLiteDatabase.close ()V
      // 13a: iinc 3 1
      // 13d: goto 034
      // 140: astore 12
      // 142: aload 0
      // 143: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 146: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 149: ldc_w "Failed to load event from local database"
      // 14c: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;)V
      // 14f: aload 9
      // 151: invokevirtual android/os/Parcel.recycle ()V
      // 154: lload 6
      // 156: lstore 4
      // 158: goto 094
      // 15b: astore 12
      // 15d: aload 8
      // 15f: astore 9
      // 161: aload 12
      // 163: astore 8
      // 165: getstatic android/os/Build$VERSION.SDK_INT I
      // 168: bipush 11
      // 16a: if_icmplt 30b
      // 16d: aload 8
      // 16f: instanceof android/database/sqlite/SQLiteDatabaseLockedException
      // 172: ifeq 30b
      // 175: iload 1
      // 176: i2l
      // 177: invokestatic android/os/SystemClock.sleep (J)V
      // 17a: iload 1
      // 17b: bipush 20
      // 17d: iadd
      // 17e: istore 2
      // 17f: aload 10
      // 181: ifnull 18b
      // 184: aload 10
      // 186: invokeinterface android/database/Cursor.close ()V 1
      // 18b: iload 2
      // 18c: istore 1
      // 18d: aload 9
      // 18f: ifnull 13a
      // 192: aload 9
      // 194: invokevirtual android/database/sqlite/SQLiteDatabase.close ()V
      // 197: iload 2
      // 198: istore 1
      // 199: goto 13a
      // 19c: astore 12
      // 19e: aload 9
      // 1a0: invokevirtual android/os/Parcel.recycle ()V
      // 1a3: aload 12
      // 1a5: athrow
      // 1a6: astore 11
      // 1a8: aload 8
      // 1aa: astore 9
      // 1ac: aload 11
      // 1ae: astore 8
      // 1b0: aload 10
      // 1b2: ifnull 1bc
      // 1b5: aload 10
      // 1b7: invokeinterface android/database/Cursor.close ()V 1
      // 1bc: aload 9
      // 1be: ifnull 1c6
      // 1c1: aload 9
      // 1c3: invokevirtual android/database/sqlite/SQLiteDatabase.close ()V
      // 1c6: aload 8
      // 1c8: athrow
      // 1c9: iload 2
      // 1ca: bipush 1
      // 1cb: if_icmpne 236
      // 1ce: invokestatic android/os/Parcel.obtain ()Landroid/os/Parcel;
      // 1d1: astore 12
      // 1d3: aload 12
      // 1d5: aload 13
      // 1d7: bipush 0
      // 1d8: aload 13
      // 1da: arraylength
      // 1db: invokevirtual android/os/Parcel.unmarshall ([BII)V
      // 1de: aload 12
      // 1e0: bipush 0
      // 1e1: invokevirtual android/os/Parcel.setDataPosition (I)V
      // 1e4: getstatic com/google/android/gms/internal/zzcln.CREATOR Landroid/os/Parcelable$Creator;
      // 1e7: aload 12
      // 1e9: invokeinterface android/os/Parcelable$Creator.createFromParcel (Landroid/os/Parcel;)Ljava/lang/Object; 2
      // 1ee: checkcast com/google/android/gms/internal/zzcln
      // 1f1: astore 9
      // 1f3: aload 12
      // 1f5: invokevirtual android/os/Parcel.recycle ()V
      // 1f8: lload 6
      // 1fa: lstore 4
      // 1fc: aload 9
      // 1fe: ifnull 094
      // 201: aload 11
      // 203: aload 9
      // 205: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 20a: pop
      // 20b: lload 6
      // 20d: lstore 4
      // 20f: goto 094
      // 212: astore 9
      // 214: aload 0
      // 215: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 218: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 21b: ldc_w "Failed to load user property from local database"
      // 21e: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;)V
      // 221: aload 12
      // 223: invokevirtual android/os/Parcel.recycle ()V
      // 226: aconst_null
      // 227: astore 9
      // 229: goto 1f8
      // 22c: astore 9
      // 22e: aload 12
      // 230: invokevirtual android/os/Parcel.recycle ()V
      // 233: aload 9
      // 235: athrow
      // 236: iload 2
      // 237: bipush 2
      // 238: if_icmpne 2a3
      // 23b: invokestatic android/os/Parcel.obtain ()Landroid/os/Parcel;
      // 23e: astore 12
      // 240: aload 12
      // 242: aload 13
      // 244: bipush 0
      // 245: aload 13
      // 247: arraylength
      // 248: invokevirtual android/os/Parcel.unmarshall ([BII)V
      // 24b: aload 12
      // 24d: bipush 0
      // 24e: invokevirtual android/os/Parcel.setDataPosition (I)V
      // 251: getstatic com/google/android/gms/internal/zzcgl.CREATOR Landroid/os/Parcelable$Creator;
      // 254: aload 12
      // 256: invokeinterface android/os/Parcelable$Creator.createFromParcel (Landroid/os/Parcel;)Ljava/lang/Object; 2
      // 25b: checkcast com/google/android/gms/internal/zzcgl
      // 25e: astore 9
      // 260: aload 12
      // 262: invokevirtual android/os/Parcel.recycle ()V
      // 265: lload 6
      // 267: lstore 4
      // 269: aload 9
      // 26b: ifnull 094
      // 26e: aload 11
      // 270: aload 9
      // 272: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 277: pop
      // 278: lload 6
      // 27a: lstore 4
      // 27c: goto 094
      // 27f: astore 9
      // 281: aload 0
      // 282: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 285: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 288: ldc_w "Failed to load user property from local database"
      // 28b: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;)V
      // 28e: aload 12
      // 290: invokevirtual android/os/Parcel.recycle ()V
      // 293: aconst_null
      // 294: astore 9
      // 296: goto 265
      // 299: astore 9
      // 29b: aload 12
      // 29d: invokevirtual android/os/Parcel.recycle ()V
      // 2a0: aload 9
      // 2a2: athrow
      // 2a3: aload 0
      // 2a4: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 2a7: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 2aa: ldc_w "Unknown record type in local database"
      // 2ad: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;)V
      // 2b0: lload 6
      // 2b2: lstore 4
      // 2b4: goto 094
      // 2b7: aload 8
      // 2b9: ldc "messages"
      // 2bb: ldc_w "rowid <= ?"
      // 2be: bipush 1
      // 2bf: anewarray 116
      // 2c2: dup
      // 2c3: bipush 0
      // 2c4: lload 4
      // 2c6: invokestatic java/lang/Long.toString (J)Ljava/lang/String;
      // 2c9: aastore
      // 2ca: invokevirtual android/database/sqlite/SQLiteDatabase.delete (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
      // 2cd: aload 11
      // 2cf: invokeinterface java/util/List.size ()I 1
      // 2d4: if_icmpge 2e4
      // 2d7: aload 0
      // 2d8: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 2db: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 2de: ldc_w "Fewer entries removed from local database than expected"
      // 2e1: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;)V
      // 2e4: aload 8
      // 2e6: invokevirtual android/database/sqlite/SQLiteDatabase.setTransactionSuccessful ()V
      // 2e9: aload 8
      // 2eb: invokevirtual android/database/sqlite/SQLiteDatabase.endTransaction ()V
      // 2ee: aload 10
      // 2f0: ifnull 2fa
      // 2f3: aload 10
      // 2f5: invokeinterface android/database/Cursor.close ()V 1
      // 2fa: aload 8
      // 2fc: ifnull 304
      // 2ff: aload 8
      // 301: invokevirtual android/database/sqlite/SQLiteDatabase.close ()V
      // 304: aload 11
      // 306: astore 8
      // 308: goto 00e
      // 30b: aload 9
      // 30d: ifnull 31d
      // 310: aload 9
      // 312: invokevirtual android/database/sqlite/SQLiteDatabase.inTransaction ()Z
      // 315: ifeq 31d
      // 318: aload 9
      // 31a: invokevirtual android/database/sqlite/SQLiteDatabase.endTransaction ()V
      // 31d: aload 0
      // 31e: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 321: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 324: ldc "Error reading entries from local database"
      // 326: aload 8
      // 328: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;)V
      // 32b: aload 0
      // 32c: bipush 1
      // 32d: putfield com/google/android/gms/internal/zzchi.b Z
      // 330: iload 1
      // 331: istore 2
      // 332: goto 17f
      // 335: aload 0
      // 336: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 339: invokevirtual com/google/android/gms/internal/zzchm.A ()Lcom/google/android/gms/internal/zzcho;
      // 33c: ldc_w "Failed to read events from database in reasonable time"
      // 33f: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;)V
      // 342: aconst_null
      // 343: astore 8
      // 345: goto 00e
      // 348: astore 8
      // 34a: aconst_null
      // 34b: astore 11
      // 34d: aload 10
      // 34f: astore 9
      // 351: aload 11
      // 353: astore 10
      // 355: goto 1b0
      // 358: astore 11
      // 35a: aconst_null
      // 35b: astore 10
      // 35d: aload 8
      // 35f: astore 9
      // 361: aload 11
      // 363: astore 8
      // 365: goto 1b0
      // 368: astore 11
      // 36a: aload 8
      // 36c: astore 10
      // 36e: aload 11
      // 370: astore 8
      // 372: goto 1b0
      // 375: astore 8
      // 377: goto 1b0
      // 37a: astore 8
      // 37c: aconst_null
      // 37d: astore 10
      // 37f: goto 165
      // 382: astore 12
      // 384: aconst_null
      // 385: astore 10
      // 387: aload 8
      // 389: astore 9
      // 38b: aload 12
      // 38d: astore 8
      // 38f: goto 165
      // 392: astore 10
      // 394: aconst_null
      // 395: astore 9
      // 397: aconst_null
      // 398: astore 8
      // 39a: goto 111
      // 39d: astore 10
      // 39f: aload 8
      // 3a1: astore 9
      // 3a3: aconst_null
      // 3a4: astore 8
      // 3a6: goto 111
      // 3a9: goto 13a
      // try (33 -> 36): 414 android/database/sqlite/SQLiteFullException
      // try (33 -> 36): 402 android/database/sqlite/SQLiteException
      // try (33 -> 36): 378 null
      // try (38 -> 41): 420 android/database/sqlite/SQLiteFullException
      // try (38 -> 41): 406 android/database/sqlite/SQLiteException
      // try (38 -> 41): 386 null
      // try (48 -> 77): 420 android/database/sqlite/SQLiteFullException
      // try (48 -> 77): 406 android/database/sqlite/SQLiteException
      // try (48 -> 77): 386 null
      // try (79 -> 94): 125 android/database/sqlite/SQLiteFullException
      // try (79 -> 94): 162 android/database/sqlite/SQLiteException
      // try (79 -> 94): 198 null
      // try (96 -> 98): 125 android/database/sqlite/SQLiteFullException
      // try (96 -> 98): 162 android/database/sqlite/SQLiteException
      // try (96 -> 98): 198 null
      // try (98 -> 112): 151 com/google/android/gms/internal/zzbfo
      // try (98 -> 112): 193 null
      // try (112 -> 114): 125 android/database/sqlite/SQLiteFullException
      // try (112 -> 114): 162 android/database/sqlite/SQLiteException
      // try (112 -> 114): 198 null
      // try (118 -> 122): 125 android/database/sqlite/SQLiteFullException
      // try (118 -> 122): 162 android/database/sqlite/SQLiteException
      // try (118 -> 122): 198 null
      // try (132 -> 141): 394 null
      // try (152 -> 157): 193 null
      // try (157 -> 159): 125 android/database/sqlite/SQLiteFullException
      // try (157 -> 159): 162 android/database/sqlite/SQLiteException
      // try (157 -> 159): 198 null
      // try (167 -> 176): 400 null
      // try (194 -> 198): 125 android/database/sqlite/SQLiteFullException
      // try (194 -> 198): 162 android/database/sqlite/SQLiteException
      // try (194 -> 198): 198 null
      // try (216 -> 218): 125 android/database/sqlite/SQLiteFullException
      // try (216 -> 218): 162 android/database/sqlite/SQLiteException
      // try (216 -> 218): 198 null
      // try (218 -> 232): 245 com/google/android/gms/internal/zzbfo
      // try (218 -> 232): 256 null
      // try (232 -> 234): 125 android/database/sqlite/SQLiteFullException
      // try (232 -> 234): 162 android/database/sqlite/SQLiteException
      // try (232 -> 234): 198 null
      // try (238 -> 242): 125 android/database/sqlite/SQLiteFullException
      // try (238 -> 242): 162 android/database/sqlite/SQLiteException
      // try (238 -> 242): 198 null
      // try (246 -> 251): 256 null
      // try (251 -> 253): 125 android/database/sqlite/SQLiteFullException
      // try (251 -> 253): 162 android/database/sqlite/SQLiteException
      // try (251 -> 253): 198 null
      // try (257 -> 261): 125 android/database/sqlite/SQLiteFullException
      // try (257 -> 261): 162 android/database/sqlite/SQLiteException
      // try (257 -> 261): 198 null
      // try (264 -> 266): 125 android/database/sqlite/SQLiteFullException
      // try (264 -> 266): 162 android/database/sqlite/SQLiteException
      // try (264 -> 266): 198 null
      // try (266 -> 280): 293 com/google/android/gms/internal/zzbfo
      // try (266 -> 280): 304 null
      // try (280 -> 282): 125 android/database/sqlite/SQLiteFullException
      // try (280 -> 282): 162 android/database/sqlite/SQLiteException
      // try (280 -> 282): 198 null
      // try (286 -> 290): 125 android/database/sqlite/SQLiteFullException
      // try (286 -> 290): 162 android/database/sqlite/SQLiteException
      // try (286 -> 290): 198 null
      // try (294 -> 299): 304 null
      // try (299 -> 301): 125 android/database/sqlite/SQLiteFullException
      // try (299 -> 301): 162 android/database/sqlite/SQLiteException
      // try (299 -> 301): 198 null
      // try (305 -> 309): 125 android/database/sqlite/SQLiteFullException
      // try (305 -> 309): 162 android/database/sqlite/SQLiteException
      // try (305 -> 309): 198 null
      // try (309 -> 314): 125 android/database/sqlite/SQLiteFullException
      // try (309 -> 314): 162 android/database/sqlite/SQLiteException
      // try (309 -> 314): 198 null
      // try (317 -> 336): 125 android/database/sqlite/SQLiteFullException
      // try (317 -> 336): 162 android/database/sqlite/SQLiteException
      // try (317 -> 336): 198 null
      // try (336 -> 340): 125 android/database/sqlite/SQLiteFullException
      // try (336 -> 340): 162 android/database/sqlite/SQLiteException
      // try (336 -> 340): 198 null
      // try (353 -> 358): 400 null
      // try (358 -> 367): 400 null
   }

   public final boolean a(zzcgl var1) {
      this.p();
      byte[] var3 = zzclq.a(var1);
      boolean var2;
      if (var3.length > 131072) {
         this.t().A().a("Conditional user property too long for local database. Sending directly to service");
         var2 = false;
      } else {
         var2 = this.a(2, var3);
      }

      return var2;
   }

   public final boolean a(zzcha var1) {
      boolean var2 = false;
      Parcel var3 = Parcel.obtain();
      var1.writeToParcel(var3, 0);
      byte[] var4 = var3.marshall();
      var3.recycle();
      if (var4.length > 131072) {
         this.t().A().a("Event is too long for local database. Sending event directly to service");
      } else {
         var2 = this.a(0, var4);
      }

      return var2;
   }

   public final boolean a(zzcln var1) {
      boolean var2 = false;
      Parcel var3 = Parcel.obtain();
      var1.writeToParcel(var3, 0);
      byte[] var4 = var3.marshall();
      var3.recycle();
      if (var4.length > 131072) {
         this.t().A().a("User property too long for local database. Sending directly to service");
      } else {
         var2 = this.a(1, var4);
      }

      return var2;
   }

   @Override
   protected final boolean w() {
      return false;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public final void y() {
      this.c();

      int var1;
      try {
         var1 = this.z().delete("messages", null, null) + 0;
      } catch (SQLiteException var4) {
         this.t().y().a("Error resetting local analytics data. error", var4);
         return;
      }

      if (var1 > 0) {
         try {
            this.t().E().a("Reset local analytics data. records", var1);
         } catch (SQLiteException var3) {
            this.t().y().a("Error resetting local analytics data. error", var3);
         }
      }
   }
}
