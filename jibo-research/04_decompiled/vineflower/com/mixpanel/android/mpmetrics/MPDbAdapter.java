package com.mixpanel.android.mpmetrics;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.mixpanel.android.util.MPLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class MPDbAdapter {
   private static final Map<Context, MPDbAdapter> a = new HashMap<>();
   private static final String b = "CREATE TABLE "
      + MPDbAdapter.Table.EVENTS.getName()
      + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
      + "data"
      + " STRING NOT NULL, "
      + "created_at"
      + " INTEGER NOT NULL, "
      + "automatic_data"
      + " INTEGER DEFAULT 0, "
      + "token"
      + " STRING NOT NULL DEFAULT '')";
   private static final String c = "CREATE TABLE "
      + MPDbAdapter.Table.PEOPLE.getName()
      + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
      + "data"
      + " STRING NOT NULL, "
      + "created_at"
      + " INTEGER NOT NULL, "
      + "automatic_data"
      + " INTEGER DEFAULT 0, "
      + "token"
      + " STRING NOT NULL DEFAULT '')";
   private static final String d = "CREATE INDEX IF NOT EXISTS time_idx ON " + MPDbAdapter.Table.EVENTS.getName() + " (" + "created_at" + ");";
   private static final String e = "CREATE INDEX IF NOT EXISTS time_idx ON " + MPDbAdapter.Table.PEOPLE.getName() + " (" + "created_at" + ");";
   private final MPDbAdapter.MPDatabaseHelper f;

   public MPDbAdapter(Context var1) {
      this(var1, "mixpanel");
   }

   public MPDbAdapter(Context var1, String var2) {
      this.f = new MPDbAdapter.MPDatabaseHelper(var1, var2);
   }

   public static MPDbAdapter a(Context param0) {
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
      // 00: getstatic com/mixpanel/android/mpmetrics/MPDbAdapter.a Ljava/util/Map;
      // 03: astore 1
      // 04: aload 1
      // 05: monitorenter
      // 06: aload 0
      // 07: invokevirtual android/content/Context.getApplicationContext ()Landroid/content/Context;
      // 0a: astore 2
      // 0b: getstatic com/mixpanel/android/mpmetrics/MPDbAdapter.a Ljava/util/Map;
      // 0e: aload 2
      // 0f: invokeinterface java/util/Map.containsKey (Ljava/lang/Object;)Z 2
      // 14: ifne 2f
      // 17: new com/mixpanel/android/mpmetrics/MPDbAdapter
      // 1a: astore 0
      // 1b: aload 0
      // 1c: aload 2
      // 1d: invokespecial com/mixpanel/android/mpmetrics/MPDbAdapter.<init> (Landroid/content/Context;)V
      // 20: getstatic com/mixpanel/android/mpmetrics/MPDbAdapter.a Ljava/util/Map;
      // 23: aload 2
      // 24: aload 0
      // 25: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 2a: pop
      // 2b: aload 1
      // 2c: monitorexit
      // 2d: aload 0
      // 2e: areturn
      // 2f: getstatic com/mixpanel/android/mpmetrics/MPDbAdapter.a Ljava/util/Map;
      // 32: aload 2
      // 33: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 38: checkcast com/mixpanel/android/mpmetrics/MPDbAdapter
      // 3b: astore 0
      // 3c: goto 2b
      // 3f: astore 0
      // 40: aload 1
      // 41: monitorexit
      // 42: aload 0
      // 43: athrow
      // try (4 -> 21): 31 null
      // try (21 -> 23): 31 null
      // try (25 -> 30): 31 null
      // try (32 -> 34): 31 null
   }

   private void a(MPDbAdapter.Table var1, String var2) {
      String var9 = var1.getName();

      try {
         SQLiteDatabase var3 = this.f.getWritableDatabase();
         StringBuilder var4 = new StringBuilder();
         var3.delete(var9, var4.append("automatic_data = 1 AND token = '").append(var2).append("'").toString(), null);
      } catch (SQLiteException var7) {
         StringBuilder var10 = new StringBuilder();
         MPLog.e(
            "MixpanelAPI.Database",
            var10.append("Could not clean automatic Mixpanel records from ").append(var9).append(". Re-initializing database.").toString(),
            var7
         );
         this.f.a();
      } finally {
         this.f.close();
      }
   }

   public int a(JSONObject param1, String param2, MPDbAdapter.Table param3, boolean param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aconst_null
      // 001: astore 8
      // 003: aconst_null
      // 004: astore 7
      // 006: aload 0
      // 007: invokevirtual com/mixpanel/android/mpmetrics/MPDbAdapter.c ()Z
      // 00a: ifne 01b
      // 00d: ldc "MixpanelAPI.Database"
      // 00f: ldc "There is not enough space left on the device to store Mixpanel data, so data was discarded"
      // 011: invokestatic com/mixpanel/android/util/MPLog.e (Ljava/lang/String;Ljava/lang/String;)V
      // 014: bipush -2
      // 016: istore 5
      // 018: iload 5
      // 01a: ireturn
      // 01b: aload 3
      // 01c: invokevirtual com/mixpanel/android/mpmetrics/MPDbAdapter$Table.getName ()Ljava/lang/String;
      // 01f: astore 9
      // 021: bipush -1
      // 022: istore 5
      // 024: aload 8
      // 026: astore 3
      // 027: aload 0
      // 028: getfield com/mixpanel/android/mpmetrics/MPDbAdapter.f Lcom/mixpanel/android/mpmetrics/MPDbAdapter$MPDatabaseHelper;
      // 02b: invokevirtual com/mixpanel/android/mpmetrics/MPDbAdapter$MPDatabaseHelper.getWritableDatabase ()Landroid/database/sqlite/SQLiteDatabase;
      // 02e: astore 10
      // 030: aload 8
      // 032: astore 3
      // 033: new android/content/ContentValues
      // 036: astore 11
      // 038: aload 8
      // 03a: astore 3
      // 03b: aload 11
      // 03d: invokespecial android/content/ContentValues.<init> ()V
      // 040: aload 8
      // 042: astore 3
      // 043: aload 11
      // 045: ldc "data"
      // 047: aload 1
      // 048: invokevirtual org/json/JSONObject.toString ()Ljava/lang/String;
      // 04b: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/String;)V
      // 04e: aload 8
      // 050: astore 3
      // 051: aload 11
      // 053: ldc "created_at"
      // 055: invokestatic java/lang/System.currentTimeMillis ()J
      // 058: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 05b: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/Long;)V
      // 05e: aload 8
      // 060: astore 3
      // 061: aload 11
      // 063: ldc "automatic_data"
      // 065: iload 4
      // 067: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
      // 06a: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/Boolean;)V
      // 06d: aload 8
      // 06f: astore 3
      // 070: aload 11
      // 072: ldc "token"
      // 074: aload 2
      // 075: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/String;)V
      // 078: aload 8
      // 07a: astore 3
      // 07b: aload 10
      // 07d: aload 9
      // 07f: aconst_null
      // 080: aload 11
      // 082: invokevirtual android/database/sqlite/SQLiteDatabase.insert (Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
      // 085: pop2
      // 086: aload 8
      // 088: astore 3
      // 089: new java/lang/StringBuilder
      // 08c: astore 1
      // 08d: aload 8
      // 08f: astore 3
      // 090: aload 1
      // 091: invokespecial java/lang/StringBuilder.<init> ()V
      // 094: aload 8
      // 096: astore 3
      // 097: aload 10
      // 099: aload 1
      // 09a: ldc "SELECT COUNT(*) FROM "
      // 09c: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 09f: aload 9
      // 0a1: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0a4: ldc " WHERE token='"
      // 0a6: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0a9: aload 2
      // 0aa: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0ad: ldc "'"
      // 0af: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0b2: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0b5: aconst_null
      // 0b6: invokevirtual android/database/sqlite/SQLiteDatabase.rawQuery (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
      // 0b9: astore 1
      // 0ba: aload 1
      // 0bb: astore 2
      // 0bc: aload 1
      // 0bd: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 0c2: pop
      // 0c3: aload 1
      // 0c4: astore 2
      // 0c5: aload 1
      // 0c6: bipush 0
      // 0c7: invokeinterface android/database/Cursor.getInt (I)I 2
      // 0cc: istore 6
      // 0ce: iload 6
      // 0d0: istore 5
      // 0d2: aload 1
      // 0d3: ifnull 0dc
      // 0d6: aload 1
      // 0d7: invokeinterface android/database/Cursor.close ()V 1
      // 0dc: aload 0
      // 0dd: getfield com/mixpanel/android/mpmetrics/MPDbAdapter.f Lcom/mixpanel/android/mpmetrics/MPDbAdapter$MPDatabaseHelper;
      // 0e0: invokevirtual com/mixpanel/android/mpmetrics/MPDbAdapter$MPDatabaseHelper.close ()V
      // 0e3: goto 018
      // 0e6: astore 3
      // 0e7: aconst_null
      // 0e8: astore 1
      // 0e9: aload 1
      // 0ea: astore 2
      // 0eb: new java/lang/StringBuilder
      // 0ee: astore 8
      // 0f0: aload 1
      // 0f1: astore 2
      // 0f2: aload 8
      // 0f4: invokespecial java/lang/StringBuilder.<init> ()V
      // 0f7: aload 1
      // 0f8: astore 2
      // 0f9: ldc "MixpanelAPI.Database"
      // 0fb: aload 8
      // 0fd: ldc "Could not add Mixpanel data to table "
      // 0ff: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 102: aload 9
      // 104: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 107: ldc ". Re-initializing database."
      // 109: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 10c: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 10f: aload 3
      // 110: invokestatic com/mixpanel/android/util/MPLog.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      // 113: aload 1
      // 114: ifnull 15d
      // 117: aload 1
      // 118: astore 2
      // 119: aload 1
      // 11a: invokeinterface android/database/Cursor.close ()V 1
      // 11f: aload 7
      // 121: astore 1
      // 122: aload 1
      // 123: astore 3
      // 124: aload 0
      // 125: getfield com/mixpanel/android/mpmetrics/MPDbAdapter.f Lcom/mixpanel/android/mpmetrics/MPDbAdapter$MPDatabaseHelper;
      // 128: invokevirtual com/mixpanel/android/mpmetrics/MPDbAdapter$MPDatabaseHelper.a ()V
      // 12b: aload 1
      // 12c: ifnull 135
      // 12f: aload 1
      // 130: invokeinterface android/database/Cursor.close ()V 1
      // 135: aload 0
      // 136: getfield com/mixpanel/android/mpmetrics/MPDbAdapter.f Lcom/mixpanel/android/mpmetrics/MPDbAdapter$MPDatabaseHelper;
      // 139: invokevirtual com/mixpanel/android/mpmetrics/MPDbAdapter$MPDatabaseHelper.close ()V
      // 13c: goto 018
      // 13f: astore 1
      // 140: aload 3
      // 141: astore 2
      // 142: aload 2
      // 143: ifnull 14c
      // 146: aload 2
      // 147: invokeinterface android/database/Cursor.close ()V 1
      // 14c: aload 0
      // 14d: getfield com/mixpanel/android/mpmetrics/MPDbAdapter.f Lcom/mixpanel/android/mpmetrics/MPDbAdapter$MPDatabaseHelper;
      // 150: invokevirtual com/mixpanel/android/mpmetrics/MPDbAdapter$MPDatabaseHelper.close ()V
      // 153: aload 1
      // 154: athrow
      // 155: astore 1
      // 156: goto 142
      // 159: astore 3
      // 15a: goto 0e9
      // 15d: goto 122
      // try (21 -> 25): 115 android/database/sqlite/SQLiteException
      // try (21 -> 25): 160 null
      // try (27 -> 29): 115 android/database/sqlite/SQLiteException
      // try (27 -> 29): 160 null
      // try (31 -> 33): 115 android/database/sqlite/SQLiteException
      // try (31 -> 33): 160 null
      // try (35 -> 40): 115 android/database/sqlite/SQLiteException
      // try (35 -> 40): 160 null
      // try (42 -> 47): 115 android/database/sqlite/SQLiteException
      // try (42 -> 47): 160 null
      // try (49 -> 54): 115 android/database/sqlite/SQLiteException
      // try (49 -> 54): 160 null
      // try (56 -> 60): 115 android/database/sqlite/SQLiteException
      // try (56 -> 60): 160 null
      // try (62 -> 68): 115 android/database/sqlite/SQLiteException
      // try (62 -> 68): 160 null
      // try (70 -> 72): 115 android/database/sqlite/SQLiteException
      // try (70 -> 72): 160 null
      // try (74 -> 76): 115 android/database/sqlite/SQLiteException
      // try (74 -> 76): 160 null
      // try (78 -> 94): 115 android/database/sqlite/SQLiteException
      // try (78 -> 94): 160 null
      // try (96 -> 99): 174 android/database/sqlite/SQLiteException
      // try (96 -> 99): 172 null
      // try (101 -> 105): 174 android/database/sqlite/SQLiteException
      // try (101 -> 105): 172 null
      // try (120 -> 122): 172 null
      // try (124 -> 126): 172 null
      // try (128 -> 139): 172 null
      // try (143 -> 145): 172 null
      // try (149 -> 152): 160 null
   }

   public void a() {
      this.f.a();
   }

   public void a(long var1, MPDbAdapter.Table var3) {
      String var10 = var3.getName();

      try {
         SQLiteDatabase var4 = this.f.getWritableDatabase();
         StringBuilder var11 = new StringBuilder();
         var4.delete(var10, var11.append("created_at <= ").append(var1).toString(), null);
      } catch (SQLiteException var8) {
         StringBuilder var5 = new StringBuilder();
         MPLog.e(
            "MixpanelAPI.Database",
            var5.append("Could not clean timed-out Mixpanel records from ").append(var10).append(". Re-initializing database.").toString(),
            var8
         );
         this.f.a();
      } finally {
         this.f.close();
      }
   }

   public void a(String var1) {
      synchronized (this) {
         this.a(MPDbAdapter.Table.EVENTS, var1);
         this.a(MPDbAdapter.Table.PEOPLE, var1);
      }
   }

   public void a(String param1, MPDbAdapter.Table param2, String param3, boolean param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 2
      // 01: invokevirtual com/mixpanel/android/mpmetrics/MPDbAdapter$Table.getName ()Ljava/lang/String;
      // 04: astore 2
      // 05: aload 0
      // 06: getfield com/mixpanel/android/mpmetrics/MPDbAdapter.f Lcom/mixpanel/android/mpmetrics/MPDbAdapter$MPDatabaseHelper;
      // 09: invokevirtual com/mixpanel/android/mpmetrics/MPDbAdapter$MPDatabaseHelper.getWritableDatabase ()Landroid/database/sqlite/SQLiteDatabase;
      // 0c: astore 7
      // 0e: new java/lang/StringBuffer
      // 11: astore 5
      // 13: new java/lang/StringBuilder
      // 16: astore 6
      // 18: aload 6
      // 1a: invokespecial java/lang/StringBuilder.<init> ()V
      // 1d: aload 5
      // 1f: aload 6
      // 21: ldc "_id <= "
      // 23: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 26: aload 1
      // 27: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 2a: ldc " AND "
      // 2c: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 2f: ldc "token"
      // 31: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 34: ldc " = '"
      // 36: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 39: aload 3
      // 3a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 3d: ldc "'"
      // 3f: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 42: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 45: invokespecial java/lang/StringBuffer.<init> (Ljava/lang/String;)V
      // 48: iload 4
      // 4a: ifne 55
      // 4d: aload 5
      // 4f: ldc " AND automatic_data=0"
      // 51: invokevirtual java/lang/StringBuffer.append (Ljava/lang/String;)Ljava/lang/StringBuffer;
      // 54: pop
      // 55: aload 7
      // 57: aload 2
      // 58: aload 5
      // 5a: invokevirtual java/lang/StringBuffer.toString ()Ljava/lang/String;
      // 5d: aconst_null
      // 5e: invokevirtual android/database/sqlite/SQLiteDatabase.delete (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
      // 61: pop
      // 62: aload 0
      // 63: getfield com/mixpanel/android/mpmetrics/MPDbAdapter.f Lcom/mixpanel/android/mpmetrics/MPDbAdapter$MPDatabaseHelper;
      // 66: invokevirtual com/mixpanel/android/mpmetrics/MPDbAdapter$MPDatabaseHelper.close ()V
      // 69: return
      // 6a: astore 1
      // 6b: new java/lang/StringBuilder
      // 6e: astore 3
      // 6f: aload 3
      // 70: invokespecial java/lang/StringBuilder.<init> ()V
      // 73: ldc "MixpanelAPI.Database"
      // 75: aload 3
      // 76: ldc "Could not clean sent Mixpanel records from "
      // 78: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 7b: aload 2
      // 7c: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 7f: ldc ". Re-initializing database."
      // 81: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 84: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 87: aload 1
      // 88: invokestatic com/mixpanel/android/util/MPLog.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      // 8b: aload 0
      // 8c: getfield com/mixpanel/android/mpmetrics/MPDbAdapter.f Lcom/mixpanel/android/mpmetrics/MPDbAdapter$MPDatabaseHelper;
      // 8f: invokevirtual com/mixpanel/android/mpmetrics/MPDbAdapter$MPDatabaseHelper.a ()V
      // 92: aload 0
      // 93: getfield com/mixpanel/android/mpmetrics/MPDbAdapter.f Lcom/mixpanel/android/mpmetrics/MPDbAdapter$MPDatabaseHelper;
      // 96: invokevirtual com/mixpanel/android/mpmetrics/MPDbAdapter$MPDatabaseHelper.close ()V
      // 99: goto 69
      // 9c: astore 1
      // 9d: aload 0
      // 9e: getfield com/mixpanel/android/mpmetrics/MPDbAdapter.f Lcom/mixpanel/android/mpmetrics/MPDbAdapter$MPDatabaseHelper;
      // a1: invokevirtual com/mixpanel/android/mpmetrics/MPDbAdapter$MPDatabaseHelper.close ()V
      // a4: aload 1
      // a5: athrow
      // try (3 -> 31): 48 android/database/sqlite/SQLiteException
      // try (3 -> 31): 71 null
      // try (33 -> 37): 48 android/database/sqlite/SQLiteException
      // try (33 -> 37): 71 null
      // try (37 -> 44): 48 android/database/sqlite/SQLiteException
      // try (37 -> 44): 71 null
      // try (49 -> 67): 71 null
   }

   public String[] a(MPDbAdapter.Table param1, String param2, boolean param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aconst_null
      // 001: astore 5
      // 003: aconst_null
      // 004: astore 10
      // 006: aload 1
      // 007: invokevirtual com/mixpanel/android/mpmetrics/MPDbAdapter$Table.getName ()Ljava/lang/String;
      // 00a: astore 11
      // 00c: aload 0
      // 00d: getfield com/mixpanel/android/mpmetrics/MPDbAdapter.f Lcom/mixpanel/android/mpmetrics/MPDbAdapter$MPDatabaseHelper;
      // 010: invokevirtual com/mixpanel/android/mpmetrics/MPDbAdapter$MPDatabaseHelper.getReadableDatabase ()Landroid/database/sqlite/SQLiteDatabase;
      // 013: astore 1
      // 014: new java/lang/StringBuffer
      // 017: astore 7
      // 019: new java/lang/StringBuilder
      // 01c: astore 6
      // 01e: aload 6
      // 020: invokespecial java/lang/StringBuilder.<init> ()V
      // 023: aload 7
      // 025: aload 6
      // 027: ldc "SELECT * FROM "
      // 029: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 02c: aload 11
      // 02e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 031: ldc_w " WHERE "
      // 034: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 037: ldc "token"
      // 039: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 03c: ldc " = '"
      // 03e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 041: aload 2
      // 042: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 045: ldc_w "' "
      // 048: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 04b: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 04e: invokespecial java/lang/StringBuffer.<init> (Ljava/lang/String;)V
      // 051: new java/lang/StringBuffer
      // 054: astore 6
      // 056: new java/lang/StringBuilder
      // 059: astore 8
      // 05b: aload 8
      // 05d: invokespecial java/lang/StringBuilder.<init> ()V
      // 060: aload 6
      // 062: aload 8
      // 064: ldc "SELECT COUNT(*) FROM "
      // 066: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 069: aload 11
      // 06b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 06e: ldc_w " WHERE "
      // 071: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 074: ldc "token"
      // 076: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 079: ldc " = '"
      // 07b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 07e: aload 2
      // 07f: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 082: ldc_w "' "
      // 085: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 088: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 08b: invokespecial java/lang/StringBuffer.<init> (Ljava/lang/String;)V
      // 08e: iload 3
      // 08f: ifne 0a4
      // 092: aload 7
      // 094: ldc_w "AND automatic_data = 0 "
      // 097: invokevirtual java/lang/StringBuffer.append (Ljava/lang/String;)Ljava/lang/StringBuffer;
      // 09a: pop
      // 09b: aload 6
      // 09d: ldc_w " AND automatic_data = 0"
      // 0a0: invokevirtual java/lang/StringBuffer.append (Ljava/lang/String;)Ljava/lang/StringBuffer;
      // 0a3: pop
      // 0a4: aload 7
      // 0a6: ldc_w "ORDER BY created_at ASC LIMIT 50"
      // 0a9: invokevirtual java/lang/StringBuffer.append (Ljava/lang/String;)Ljava/lang/StringBuffer;
      // 0ac: pop
      // 0ad: aload 1
      // 0ae: aload 7
      // 0b0: invokevirtual java/lang/StringBuffer.toString ()Ljava/lang/String;
      // 0b3: aconst_null
      // 0b4: invokevirtual android/database/sqlite/SQLiteDatabase.rawQuery (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
      // 0b7: astore 2
      // 0b8: aload 1
      // 0b9: aload 6
      // 0bb: invokevirtual java/lang/StringBuffer.toString ()Ljava/lang/String;
      // 0be: aconst_null
      // 0bf: invokevirtual android/database/sqlite/SQLiteDatabase.rawQuery (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
      // 0c2: astore 6
      // 0c4: aload 6
      // 0c6: astore 8
      // 0c8: aload 2
      // 0c9: astore 7
      // 0cb: aload 6
      // 0cd: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 0d2: pop
      // 0d3: aload 6
      // 0d5: astore 8
      // 0d7: aload 2
      // 0d8: astore 7
      // 0da: aload 6
      // 0dc: bipush 0
      // 0dd: invokeinterface android/database/Cursor.getInt (I)I 2
      // 0e2: istore 4
      // 0e4: iload 4
      // 0e6: invokestatic java/lang/String.valueOf (I)Ljava/lang/String;
      // 0e9: astore 9
      // 0eb: aload 6
      // 0ed: astore 8
      // 0ef: aload 2
      // 0f0: astore 7
      // 0f2: new org/json/JSONArray
      // 0f5: astore 5
      // 0f7: aload 6
      // 0f9: astore 8
      // 0fb: aload 2
      // 0fc: astore 7
      // 0fe: aload 5
      // 100: invokespecial org/json/JSONArray.<init> ()V
      // 103: aconst_null
      // 104: astore 1
      // 105: aload 6
      // 107: astore 8
      // 109: aload 2
      // 10a: astore 7
      // 10c: aload 2
      // 10d: invokeinterface android/database/Cursor.moveToNext ()Z 1
      // 112: ifeq 179
      // 115: aload 6
      // 117: astore 8
      // 119: aload 2
      // 11a: astore 7
      // 11c: aload 2
      // 11d: invokeinterface android/database/Cursor.isLast ()Z 1
      // 122: ifeq 13c
      // 125: aload 6
      // 127: astore 8
      // 129: aload 2
      // 12a: astore 7
      // 12c: aload 2
      // 12d: aload 2
      // 12e: ldc_w "_id"
      // 131: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
      // 136: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 13b: astore 1
      // 13c: aload 6
      // 13e: astore 8
      // 140: aload 2
      // 141: astore 7
      // 143: new org/json/JSONObject
      // 146: astore 12
      // 148: aload 6
      // 14a: astore 8
      // 14c: aload 2
      // 14d: astore 7
      // 14f: aload 12
      // 151: aload 2
      // 152: aload 2
      // 153: ldc "data"
      // 155: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
      // 15a: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 15f: invokespecial org/json/JSONObject.<init> (Ljava/lang/String;)V
      // 162: aload 6
      // 164: astore 8
      // 166: aload 2
      // 167: astore 7
      // 169: aload 5
      // 16b: aload 12
      // 16d: invokevirtual org/json/JSONArray.put (Ljava/lang/Object;)Lorg/json/JSONArray;
      // 170: pop
      // 171: goto 105
      // 174: astore 7
      // 176: goto 105
      // 179: aload 6
      // 17b: astore 8
      // 17d: aload 2
      // 17e: astore 7
      // 180: aload 5
      // 182: invokevirtual org/json/JSONArray.length ()I
      // 185: ifle 2b1
      // 188: aload 6
      // 18a: astore 8
      // 18c: aload 2
      // 18d: astore 7
      // 18f: aload 5
      // 191: invokevirtual org/json/JSONArray.toString ()Ljava/lang/String;
      // 194: astore 5
      // 196: aload 0
      // 197: getfield com/mixpanel/android/mpmetrics/MPDbAdapter.f Lcom/mixpanel/android/mpmetrics/MPDbAdapter$MPDatabaseHelper;
      // 19a: invokevirtual com/mixpanel/android/mpmetrics/MPDbAdapter$MPDatabaseHelper.close ()V
      // 19d: aload 2
      // 19e: ifnull 1a7
      // 1a1: aload 2
      // 1a2: invokeinterface android/database/Cursor.close ()V 1
      // 1a7: aload 6
      // 1a9: ifnull 2a9
      // 1ac: aload 6
      // 1ae: invokeinterface android/database/Cursor.close ()V 1
      // 1b3: aload 1
      // 1b4: astore 2
      // 1b5: aload 5
      // 1b7: astore 1
      // 1b8: aload 10
      // 1ba: astore 5
      // 1bc: aload 2
      // 1bd: ifnull 1de
      // 1c0: aload 10
      // 1c2: astore 5
      // 1c4: aload 1
      // 1c5: ifnull 1de
      // 1c8: bipush 3
      // 1c9: anewarray 266
      // 1cc: astore 5
      // 1ce: aload 5
      // 1d0: bipush 0
      // 1d1: aload 2
      // 1d2: aastore
      // 1d3: aload 5
      // 1d5: bipush 1
      // 1d6: aload 1
      // 1d7: aastore
      // 1d8: aload 5
      // 1da: bipush 2
      // 1db: aload 9
      // 1dd: aastore
      // 1de: aload 5
      // 1e0: areturn
      // 1e1: astore 5
      // 1e3: aconst_null
      // 1e4: astore 1
      // 1e5: aconst_null
      // 1e6: astore 6
      // 1e8: aconst_null
      // 1e9: astore 2
      // 1ea: aload 6
      // 1ec: astore 8
      // 1ee: aload 2
      // 1ef: astore 7
      // 1f1: new java/lang/StringBuilder
      // 1f4: astore 9
      // 1f6: aload 6
      // 1f8: astore 8
      // 1fa: aload 2
      // 1fb: astore 7
      // 1fd: aload 9
      // 1ff: invokespecial java/lang/StringBuilder.<init> ()V
      // 202: aload 6
      // 204: astore 8
      // 206: aload 2
      // 207: astore 7
      // 209: ldc "MixpanelAPI.Database"
      // 20b: aload 9
      // 20d: ldc_w "Could not pull records for Mixpanel out of database "
      // 210: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 213: aload 11
      // 215: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 218: ldc_w ". Waiting to send."
      // 21b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 21e: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 221: aload 5
      // 223: invokestatic com/mixpanel/android/util/MPLog.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      // 226: aload 0
      // 227: getfield com/mixpanel/android/mpmetrics/MPDbAdapter.f Lcom/mixpanel/android/mpmetrics/MPDbAdapter$MPDatabaseHelper;
      // 22a: invokevirtual com/mixpanel/android/mpmetrics/MPDbAdapter$MPDatabaseHelper.close ()V
      // 22d: aload 2
      // 22e: ifnull 237
      // 231: aload 2
      // 232: invokeinterface android/database/Cursor.close ()V 1
      // 237: aload 6
      // 239: ifnull 29b
      // 23c: aload 6
      // 23e: invokeinterface android/database/Cursor.close ()V 1
      // 243: aconst_null
      // 244: astore 2
      // 245: aconst_null
      // 246: astore 5
      // 248: aload 1
      // 249: astore 9
      // 24b: aload 5
      // 24d: astore 1
      // 24e: goto 1b8
      // 251: astore 1
      // 252: aconst_null
      // 253: astore 2
      // 254: aload 0
      // 255: getfield com/mixpanel/android/mpmetrics/MPDbAdapter.f Lcom/mixpanel/android/mpmetrics/MPDbAdapter$MPDatabaseHelper;
      // 258: invokevirtual com/mixpanel/android/mpmetrics/MPDbAdapter$MPDatabaseHelper.close ()V
      // 25b: aload 2
      // 25c: ifnull 265
      // 25f: aload 2
      // 260: invokeinterface android/database/Cursor.close ()V 1
      // 265: aload 5
      // 267: ifnull 271
      // 26a: aload 5
      // 26c: invokeinterface android/database/Cursor.close ()V 1
      // 271: aload 1
      // 272: athrow
      // 273: astore 1
      // 274: goto 254
      // 277: astore 1
      // 278: aload 8
      // 27a: astore 5
      // 27c: aload 7
      // 27e: astore 2
      // 27f: goto 254
      // 282: astore 5
      // 284: aconst_null
      // 285: astore 1
      // 286: aconst_null
      // 287: astore 6
      // 289: goto 1ea
      // 28c: astore 5
      // 28e: aconst_null
      // 28f: astore 1
      // 290: goto 1ea
      // 293: astore 5
      // 295: aload 9
      // 297: astore 1
      // 298: goto 1ea
      // 29b: aconst_null
      // 29c: astore 2
      // 29d: aconst_null
      // 29e: astore 5
      // 2a0: aload 1
      // 2a1: astore 9
      // 2a3: aload 5
      // 2a5: astore 1
      // 2a6: goto 1b8
      // 2a9: aload 1
      // 2aa: astore 2
      // 2ab: aload 5
      // 2ad: astore 1
      // 2ae: goto 1b8
      // 2b1: aconst_null
      // 2b2: astore 5
      // 2b4: goto 196
      // try (11 -> 59): 223 android/database/sqlite/SQLiteException
      // try (11 -> 59): 277 null
      // try (61 -> 69): 223 android/database/sqlite/SQLiteException
      // try (61 -> 69): 277 null
      // try (69 -> 79): 223 android/database/sqlite/SQLiteException
      // try (69 -> 79): 277 null
      // try (79 -> 85): 301 android/database/sqlite/SQLiteException
      // try (79 -> 85): 293 null
      // try (89 -> 92): 307 android/database/sqlite/SQLiteException
      // try (89 -> 92): 295 null
      // try (96 -> 100): 307 android/database/sqlite/SQLiteException
      // try (96 -> 100): 295 null
      // try (107 -> 109): 311 android/database/sqlite/SQLiteException
      // try (107 -> 109): 295 null
      // try (113 -> 115): 311 android/database/sqlite/SQLiteException
      // try (113 -> 115): 295 null
      // try (121 -> 124): 311 android/database/sqlite/SQLiteException
      // try (121 -> 124): 295 null
      // try (128 -> 131): 311 android/database/sqlite/SQLiteException
      // try (128 -> 131): 295 null
      // try (135 -> 141): 311 android/database/sqlite/SQLiteException
      // try (135 -> 141): 295 null
      // try (145 -> 147): 167 org/json/JSONException
      // try (145 -> 147): 311 android/database/sqlite/SQLiteException
      // try (145 -> 147): 295 null
      // try (151 -> 158): 167 org/json/JSONException
      // try (151 -> 158): 311 android/database/sqlite/SQLiteException
      // try (151 -> 158): 295 null
      // try (162 -> 166): 167 org/json/JSONException
      // try (162 -> 166): 311 android/database/sqlite/SQLiteException
      // try (162 -> 166): 295 null
      // try (173 -> 176): 311 android/database/sqlite/SQLiteException
      // try (173 -> 176): 295 null
      // try (180 -> 183): 311 android/database/sqlite/SQLiteException
      // try (180 -> 183): 295 null
      // try (234 -> 236): 295 null
      // try (240 -> 242): 295 null
      // try (246 -> 257): 295 null
   }

   public File b() {
      return this.f.a;
   }

   protected boolean c() {
      return this.f.b();
   }

   private static class MPDatabaseHelper extends SQLiteOpenHelper {
      private final File a;
      private final MPConfig b;

      MPDatabaseHelper(Context var1, String var2) {
         super(var1, var2, null, 5);
         this.a = var1.getDatabasePath(var2);
         this.b = MPConfig.a(var1);
      }

      private void a(SQLiteDatabase var1) {
         var1.execSQL("ALTER TABLE " + MPDbAdapter.Table.EVENTS.getName() + " ADD COLUMN " + "automatic_data" + " INTEGER DEFAULT 0");
         var1.execSQL("ALTER TABLE " + MPDbAdapter.Table.PEOPLE.getName() + " ADD COLUMN " + "automatic_data" + " INTEGER DEFAULT 0");
         var1.execSQL("ALTER TABLE " + MPDbAdapter.Table.EVENTS.getName() + " ADD COLUMN " + "token" + " STRING NOT NULL DEFAULT ''");
         var1.execSQL("ALTER TABLE " + MPDbAdapter.Table.PEOPLE.getName() + " ADD COLUMN " + "token" + " STRING NOT NULL DEFAULT ''");
         Cursor var3 = var1.rawQuery("SELECT * FROM " + MPDbAdapter.Table.EVENTS.getName(), null);

         while (var3.moveToNext()) {
            int var2;
            label46: {
               String var12;
               try {
                  JSONObject var4 = new JSONObject(var3.getString(var3.getColumnIndex("data")));
                  var12 = var4.getJSONObject("properties").getString("token");
                  var2 = var3.getInt(var3.getColumnIndex("_id"));
               } catch (JSONException var9) {
                  var2 = 0;
                  break label46;
               }

               try {
                  StringBuilder var5 = new StringBuilder();
                  var1.execSQL(
                     var5.append("UPDATE ")
                        .append(MPDbAdapter.Table.EVENTS.getName())
                        .append(" SET ")
                        .append("token")
                        .append(" = '")
                        .append(var12)
                        .append("' WHERE _id = ")
                        .append(var2)
                        .toString()
                  );
                  continue;
               } catch (JSONException var8) {
               }
            }

            var1.delete(MPDbAdapter.Table.EVENTS.getName(), "_id = " + var2, null);
         }

         var3 = var1.rawQuery("SELECT * FROM " + MPDbAdapter.Table.PEOPLE.getName(), null);

         while (var3.moveToNext()) {
            int var10;
            label33: {
               String var14;
               try {
                  JSONObject var13 = new JSONObject(var3.getString(var3.getColumnIndex("data")));
                  var14 = var13.getString("$token");
                  var10 = var3.getInt(var3.getColumnIndex("_id"));
               } catch (JSONException var7) {
                  var10 = 0;
                  break label33;
               }

               try {
                  StringBuilder var15 = new StringBuilder();
                  var1.execSQL(
                     var15.append("UPDATE ")
                        .append(MPDbAdapter.Table.PEOPLE.getName())
                        .append(" SET ")
                        .append("token")
                        .append(" = '")
                        .append(var14)
                        .append("' WHERE _id = ")
                        .append(var10)
                        .toString()
                  );
                  continue;
               } catch (JSONException var6) {
               }
            }

            var1.delete(MPDbAdapter.Table.PEOPLE.getName(), "_id = " + var10, null);
         }
      }

      public void a() {
         this.close();
         this.a.delete();
      }

      public boolean b() {
         boolean var2 = true;
         boolean var1 = var2;
         if (this.a.exists()) {
            if (Math.max(this.a.getUsableSpace(), this.b.d()) >= this.a.length()) {
               var1 = var2;
            } else {
               var1 = false;
            }
         }

         return var1;
      }

      public void onCreate(SQLiteDatabase var1) {
         MPLog.a("MixpanelAPI.Database", "Creating a new Mixpanel events DB");
         var1.execSQL(MPDbAdapter.b);
         var1.execSQL(MPDbAdapter.c);
         var1.execSQL(MPDbAdapter.d);
         var1.execSQL(MPDbAdapter.e);
      }

      public void onUpgrade(SQLiteDatabase var1, int var2, int var3) {
         MPLog.a("MixpanelAPI.Database", "Upgrading app, replacing Mixpanel events DB");
         if (var3 == 5) {
            this.a(var1);
         } else {
            var1.execSQL("DROP TABLE IF EXISTS " + MPDbAdapter.Table.EVENTS.getName());
            var1.execSQL("DROP TABLE IF EXISTS " + MPDbAdapter.Table.PEOPLE.getName());
            var1.execSQL(MPDbAdapter.b);
            var1.execSQL(MPDbAdapter.c);
            var1.execSQL(MPDbAdapter.d);
            var1.execSQL(MPDbAdapter.e);
         }
      }
   }

   public enum Table {
      EVENTS("events"),
      PEOPLE("people");

      private static final MPDbAdapter.Table[] $VALUES = new MPDbAdapter.Table[]{MPDbAdapter.Table.EVENTS, MPDbAdapter.Table.PEOPLE};
      private final String mTableName;

      Table(String var3) {
         this.mTableName = var3;
      }

      public String getName() {
         return this.mTableName;
      }
   }
}
