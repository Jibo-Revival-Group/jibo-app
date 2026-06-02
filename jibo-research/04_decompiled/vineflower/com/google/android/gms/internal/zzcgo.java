package com.google.android.gms.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.zzbq;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class zzcgo extends zzcjl {
   private static final String[] a = new String[]{
      "last_bundled_timestamp",
      "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;",
      "last_sampled_complex_event_id",
      "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;",
      "last_sampling_rate",
      "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;",
      "last_exempt_from_sampling",
      "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;"
   };
   private static final String[] b = new String[]{"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
   private static final String[] c = new String[]{
      "app_version",
      "ALTER TABLE apps ADD COLUMN app_version TEXT;",
      "app_store",
      "ALTER TABLE apps ADD COLUMN app_store TEXT;",
      "gmp_version",
      "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;",
      "dev_cert_hash",
      "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;",
      "measurement_enabled",
      "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;",
      "last_bundle_start_timestamp",
      "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;",
      "day",
      "ALTER TABLE apps ADD COLUMN day INTEGER;",
      "daily_public_events_count",
      "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;",
      "daily_events_count",
      "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;",
      "daily_conversions_count",
      "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;",
      "remote_config",
      "ALTER TABLE apps ADD COLUMN remote_config BLOB;",
      "config_fetched_time",
      "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;",
      "failed_config_fetch_time",
      "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;",
      "app_version_int",
      "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;",
      "firebase_instance_id",
      "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;",
      "daily_error_events_count",
      "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;",
      "daily_realtime_events_count",
      "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;",
      "health_monitor_sample",
      "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;",
      "android_id",
      "ALTER TABLE apps ADD COLUMN android_id INTEGER;",
      "adid_reporting_enabled",
      "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;"
   };
   private static final String[] d = new String[]{"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
   private static final String[] e = new String[]{"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;"};
   private static final String[] f = new String[]{"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
   private final zzcgr g;
   private final zzclk h = new zzclk(this.k());

   zzcgo(zzcim var1) {
      super(var1);
      this.g = new zzcgr(this, this.l(), "google_app_measurement.db");
   }

   private final boolean T() {
      return this.l().getDatabasePath("google_app_measurement.db").exists();
   }

   private final long a(String param1, String[] param2, long param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokevirtual com/google/android/gms/internal/zzcgo.A ()Landroid/database/sqlite/SQLiteDatabase;
      // 04: astore 9
      // 06: aconst_null
      // 07: astore 7
      // 09: aconst_null
      // 0a: astore 8
      // 0c: aload 9
      // 0e: aload 1
      // 0f: aload 2
      // 10: invokevirtual android/database/sqlite/SQLiteDatabase.rawQuery (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
      // 13: astore 2
      // 14: aload 2
      // 15: astore 8
      // 17: aload 2
      // 18: astore 7
      // 1a: aload 2
      // 1b: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 20: ifeq 44
      // 23: aload 2
      // 24: astore 8
      // 26: aload 2
      // 27: astore 7
      // 29: aload 2
      // 2a: bipush 0
      // 2b: invokeinterface android/database/Cursor.getLong (I)J 2
      // 30: lstore 3
      // 31: lload 3
      // 32: lstore 5
      // 34: aload 2
      // 35: ifnull 41
      // 38: aload 2
      // 39: invokeinterface android/database/Cursor.close ()V 1
      // 3e: lload 3
      // 3f: lstore 5
      // 41: lload 5
      // 43: lreturn
      // 44: lload 3
      // 45: lstore 5
      // 47: aload 2
      // 48: ifnull 41
      // 4b: aload 2
      // 4c: invokeinterface android/database/Cursor.close ()V 1
      // 51: lload 3
      // 52: lstore 5
      // 54: goto 41
      // 57: astore 2
      // 58: aload 8
      // 5a: astore 7
      // 5c: aload 0
      // 5d: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 60: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 63: ldc "Database error"
      // 65: aload 1
      // 66: aload 2
      // 67: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
      // 6a: aload 8
      // 6c: astore 7
      // 6e: aload 2
      // 6f: athrow
      // 70: astore 1
      // 71: aload 7
      // 73: ifnull 7d
      // 76: aload 7
      // 78: invokeinterface android/database/Cursor.close ()V 1
      // 7d: aload 1
      // 7e: athrow
      // try (7 -> 12): 46 android/database/sqlite/SQLiteException
      // try (7 -> 12): 60 null
      // try (16 -> 19): 46 android/database/sqlite/SQLiteException
      // try (16 -> 19): 60 null
      // try (23 -> 27): 46 android/database/sqlite/SQLiteException
      // try (23 -> 27): 60 null
      // try (49 -> 56): 60 null
      // try (58 -> 60): 60 null
   }

   private final Object a(Cursor var1, int var2) {
      Object var4 = null;
      int var3 = var1.getType(var2);
      Serializable var5;
      switch (var3) {
         case 0:
            this.t().y().a("Loaded invalid null value from database");
            var5 = (Serializable)var4;
            break;
         case 1:
            var5 = var1.getLong(var2);
            break;
         case 2:
            var5 = var1.getDouble(var2);
            break;
         case 3:
            var5 = var1.getString(var2);
            break;
         case 4:
            this.t().y().a("Loaded invalid blob type value, ignoring it");
            var5 = (Serializable)var4;
            break;
         default:
            this.t().y().a("Loaded invalid unknown value type, ignoring it", var3);
            var5 = (Serializable)var4;
      }

      return var5;
   }

   private static Set<String> a(SQLiteDatabase var0, String var1) {
      HashSet var2 = new HashSet();
      Cursor var5 = var0.rawQuery(
         new StringBuilder(String.valueOf(var1).length() + 22).append("SELECT * FROM ").append(var1).append(" LIMIT 0").toString(), null
      );

      try {
         Collections.addAll(var2, var5.getColumnNames());
      } finally {
         var5.close();
      }

      return var2;
   }

   private static void a(ContentValues var0, String var1, Object var2) {
      zzbq.a(var1);
      zzbq.a(var2);
      if (var2 instanceof String) {
         var0.put(var1, (String)var2);
      } else if (var2 instanceof Long) {
         var0.put(var1, (Long)var2);
      } else {
         if (!(var2 instanceof Double)) {
            throw new IllegalArgumentException("Invalid value type");
         }

         var0.put(var1, (Double)var2);
      }
   }

   static void a(zzchm var0, SQLiteDatabase var1) {
      if (var0 == null) {
         throw new IllegalArgumentException("Monitor must not be null");
      }

      File var2 = new File(var1.getPath());
      if (!var2.setReadable(false, false)) {
         var0.A().a("Failed to turn off database read permission");
      }

      if (!var2.setWritable(false, false)) {
         var0.A().a("Failed to turn off database write permission");
      }

      if (!var2.setReadable(true, true)) {
         var0.A().a("Failed to turn on database read permission for owner");
      }

      if (!var2.setWritable(true, true)) {
         var0.A().a("Failed to turn on database write permission for owner");
      }
   }

   static void a(zzchm var0, SQLiteDatabase var1, String var2, String var3, String var4, String[] var5) throws SQLiteException {
      if (var0 == null) {
         throw new IllegalArgumentException("Monitor must not be null");
      }

      if (!a(var0, var1, var2)) {
         var1.execSQL(var3);
      }

      try {
         a(var0, var1, var2, var4, var5);
      } catch (SQLiteException var6) {
         var0.y().a("Failed to verify columns on table that was just created", var2);
         throw var6;
      }
   }

   private static void a(zzchm var0, SQLiteDatabase var1, String var2, String var3, String[] var4) throws SQLiteException {
      byte var6 = 0;
      if (var0 == null) {
         throw new IllegalArgumentException("Monitor must not be null");
      }

      Set var8 = a(var1, var2);

      for (var3 : var3.split(",")) {
         if (!var8.remove(var3)) {
            throw new SQLiteException(
               new StringBuilder(String.valueOf(var2).length() + 35 + String.valueOf(var3).length())
                  .append("Table ")
                  .append(var2)
                  .append(" is missing required column: ")
                  .append(var3)
                  .toString()
            );
         }
      }

      if (var4 != null) {
         for (byte var11 = var6; var11 < var4.length; var11 += 2) {
            if (!var8.remove(var4[var11])) {
               var1.execSQL(var4[var11 + 1]);
            }
         }
      }

      if (!var8.isEmpty()) {
         var0.A().a("Table has extra columns. table, columns", var2, TextUtils.join(", ", var8));
      }
   }

   private static boolean a(zzchm param0, SQLiteDatabase param1, String param2) {
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
      // 00: aconst_null
      // 01: astore 5
      // 03: aload 0
      // 04: ifnonnull 12
      // 07: new java/lang/IllegalArgumentException
      // 0a: dup
      // 0b: ldc_w "Monitor must not be null"
      // 0e: invokespecial java/lang/IllegalArgumentException.<init> (Ljava/lang/String;)V
      // 11: athrow
      // 12: aload 1
      // 13: ldc_w "SQLITE_MASTER"
      // 16: bipush 1
      // 17: anewarray 19
      // 1a: dup
      // 1b: bipush 0
      // 1c: ldc_w "name"
      // 1f: aastore
      // 20: ldc_w "name=?"
      // 23: bipush 1
      // 24: anewarray 19
      // 27: dup
      // 28: bipush 0
      // 29: aload 2
      // 2a: aastore
      // 2b: aconst_null
      // 2c: aconst_null
      // 2d: aconst_null
      // 2e: invokevirtual android/database/sqlite/SQLiteDatabase.query (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      // 31: astore 1
      // 32: aload 1
      // 33: astore 5
      // 35: aload 5
      // 37: astore 1
      // 38: aload 5
      // 3a: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 3f: istore 3
      // 40: iload 3
      // 41: istore 4
      // 43: aload 5
      // 45: ifnull 52
      // 48: aload 5
      // 4a: invokeinterface android/database/Cursor.close ()V 1
      // 4f: iload 3
      // 50: istore 4
      // 52: iload 4
      // 54: ireturn
      // 55: astore 6
      // 57: aconst_null
      // 58: astore 5
      // 5a: aload 5
      // 5c: astore 1
      // 5d: aload 0
      // 5e: invokevirtual com/google/android/gms/internal/zzchm.A ()Lcom/google/android/gms/internal/zzcho;
      // 61: ldc_w "Error querying for table"
      // 64: aload 2
      // 65: aload 6
      // 67: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
      // 6a: aload 5
      // 6c: ifnull 76
      // 6f: aload 5
      // 71: invokeinterface android/database/Cursor.close ()V 1
      // 76: bipush 0
      // 77: istore 4
      // 79: goto 52
      // 7c: astore 0
      // 7d: aload 5
      // 7f: astore 1
      // 80: aload 1
      // 81: ifnull 8a
      // 84: aload 1
      // 85: invokeinterface android/database/Cursor.close ()V 1
      // 8a: aload 0
      // 8b: athrow
      // 8c: astore 0
      // 8d: goto 80
      // 90: astore 6
      // 92: goto 5a
      // try (9 -> 29): 46 android/database/sqlite/SQLiteException
      // try (9 -> 29): 64 null
      // try (33 -> 36): 75 android/database/sqlite/SQLiteException
      // try (33 -> 36): 73 null
      // try (51 -> 57): 73 null
   }

   private final boolean a(String var1, int var2, zzcls var3) {
      boolean var4 = false;
      this.Q();
      this.c();
      zzbq.a(var1);
      zzbq.a(var3);
      if (TextUtils.isEmpty(var3.b)) {
         this.t()
            .A()
            .a("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zzchm.a(var1), var2, String.valueOf(var3.a));
      } else {
         byte[] var5;
         try {
            var5 = new byte[var3.f()];
            zzfjk var6 = zzfjk.a(var5, 0, var5.length);
            var3.a(var6);
            var6.a();
         } catch (IOException var8) {
            this.t().y().a("Configuration loss. Failed to serialize event filter. appId", zzchm.a(var1), var8);
            return var4;
         }

         ContentValues var9 = new ContentValues();
         var9.put("app_id", var1);
         var9.put("audience_id", var2);
         var9.put("filter_id", var3.a);
         var9.put("event_name", var3.b);
         var9.put("data", var5);

         try {
            if (this.A().insertWithOnConflict("event_filters", null, var9, 5) == -1L) {
               this.t().y().a("Failed to insert event filter (got -1). appId", zzchm.a(var1));
            }
         } catch (SQLiteException var7) {
            this.t().y().a("Error storing event filter. appId", zzchm.a(var1), var7);
            return var4;
         }

         var4 = true;
      }

      return var4;
   }

   private final boolean a(String var1, int var2, zzclv var3) {
      boolean var4 = false;
      this.Q();
      this.c();
      zzbq.a(var1);
      zzbq.a(var3);
      if (TextUtils.isEmpty(var3.b)) {
         this.t()
            .A()
            .a("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zzchm.a(var1), var2, String.valueOf(var3.a));
      } else {
         byte[] var5;
         try {
            var5 = new byte[var3.f()];
            zzfjk var6 = zzfjk.a(var5, 0, var5.length);
            var3.a(var6);
            var6.a();
         } catch (IOException var8) {
            this.t().y().a("Configuration loss. Failed to serialize property filter. appId", zzchm.a(var1), var8);
            return var4;
         }

         ContentValues var9 = new ContentValues();
         var9.put("app_id", var1);
         var9.put("audience_id", var2);
         var9.put("filter_id", var3.a);
         var9.put("property_name", var3.b);
         var9.put("data", var5);

         try {
            if (this.A().insertWithOnConflict("property_filters", null, var9, 5) == -1L) {
               this.t().y().a("Failed to insert property filter (got -1). appId", zzchm.a(var1));
               return var4;
            }
         } catch (SQLiteException var7) {
            this.t().y().a("Error storing property filter. appId", zzchm.a(var1), var7);
            return var4;
         }

         var4 = true;
      }

      return var4;
   }

   private final boolean a(String var1, List<Integer> var2) {
      boolean var6 = false;
      zzbq.a(var1);
      this.Q();
      this.c();
      SQLiteDatabase var9 = this.A();

      long var7;
      try {
         var7 = this.b("select count(1) from audience_filter_values where app_id=?", new String[]{var1});
      } catch (SQLiteException var12) {
         this.t().y().a("Database error querying filters. appId", zzchm.a(var1), var12);
         return var6;
      }

      int var4 = Math.max(0, Math.min(2000, this.v().b(var1, zzchc.H)));
      boolean var5;
      if (var7 <= var4) {
         var5 = var6;
      } else {
         ArrayList var10 = new ArrayList();
         int var3 = 0;

         while (true) {
            if (var3 >= var2.size()) {
               String var13 = TextUtils.join(",", var10);
               String var14 = new StringBuilder(String.valueOf(var13).length() + 2).append("(").append(var13).append(")").toString();
               var5 = var6;
               if (var9.delete(
                     "audience_filter_values",
                     new StringBuilder(String.valueOf(var14).length() + 140)
                        .append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ")
                        .append(var14)
                        .append(" order by rowid desc limit -1 offset ?)")
                        .toString(),
                     new String[]{var1, Integer.toString(var4)}
                  )
                  > 0) {
                  var5 = true;
               }
               break;
            }

            Integer var11 = (Integer)var2.get(var3);
            var5 = var6;
            if (var11 == null) {
               break;
            }

            var5 = var6;
            if (!(var11 instanceof Integer)) {
               break;
            }

            var10.add(Integer.toString(var11));
            var3++;
         }
      }

      return var5;
   }

   private final long b(String param1, String[] param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokevirtual com/google/android/gms/internal/zzcgo.A ()Landroid/database/sqlite/SQLiteDatabase;
      // 04: astore 7
      // 06: aconst_null
      // 07: astore 6
      // 09: aconst_null
      // 0a: astore 5
      // 0c: aload 7
      // 0e: aload 1
      // 0f: aload 2
      // 10: invokevirtual android/database/sqlite/SQLiteDatabase.rawQuery (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
      // 13: astore 2
      // 14: aload 2
      // 15: astore 5
      // 17: aload 2
      // 18: astore 6
      // 1a: aload 2
      // 1b: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 20: ifeq 3d
      // 23: aload 2
      // 24: astore 5
      // 26: aload 2
      // 27: astore 6
      // 29: aload 2
      // 2a: bipush 0
      // 2b: invokeinterface android/database/Cursor.getLong (I)J 2
      // 30: lstore 3
      // 31: aload 2
      // 32: ifnull 3b
      // 35: aload 2
      // 36: invokeinterface android/database/Cursor.close ()V 1
      // 3b: lload 3
      // 3c: lreturn
      // 3d: aload 2
      // 3e: astore 5
      // 40: aload 2
      // 41: astore 6
      // 43: new android/database/sqlite/SQLiteException
      // 46: astore 7
      // 48: aload 2
      // 49: astore 5
      // 4b: aload 2
      // 4c: astore 6
      // 4e: aload 7
      // 50: ldc_w "Database returned empty set"
      // 53: invokespecial android/database/sqlite/SQLiteException.<init> (Ljava/lang/String;)V
      // 56: aload 2
      // 57: astore 5
      // 59: aload 2
      // 5a: astore 6
      // 5c: aload 7
      // 5e: athrow
      // 5f: astore 2
      // 60: aload 5
      // 62: astore 6
      // 64: aload 0
      // 65: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 68: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 6b: ldc "Database error"
      // 6d: aload 1
      // 6e: aload 2
      // 6f: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
      // 72: aload 5
      // 74: astore 6
      // 76: aload 2
      // 77: athrow
      // 78: astore 1
      // 79: aload 6
      // 7b: ifnull 85
      // 7e: aload 6
      // 80: invokeinterface android/database/Cursor.close ()V 1
      // 85: aload 1
      // 86: athrow
      // try (7 -> 12): 52 android/database/sqlite/SQLiteException
      // try (7 -> 12): 66 null
      // try (16 -> 19): 52 android/database/sqlite/SQLiteException
      // try (16 -> 19): 66 null
      // try (23 -> 27): 52 android/database/sqlite/SQLiteException
      // try (23 -> 27): 66 null
      // try (37 -> 39): 52 android/database/sqlite/SQLiteException
      // try (37 -> 39): 66 null
      // try (43 -> 46): 52 android/database/sqlite/SQLiteException
      // try (43 -> 46): 66 null
      // try (50 -> 52): 52 android/database/sqlite/SQLiteException
      // try (50 -> 52): 66 null
      // try (55 -> 62): 66 null
      // try (64 -> 66): 66 null
   }

   final SQLiteDatabase A() {
      this.c();

      try {
         return this.g.getWritableDatabase();
      } catch (SQLiteException var2) {
         this.t().A().a("Error opening database", var2);
         throw var2;
      }
   }

   public final String B() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aconst_null
      // 01: astore 4
      // 03: aload 0
      // 04: invokevirtual com/google/android/gms/internal/zzcgo.A ()Landroid/database/sqlite/SQLiteDatabase;
      // 07: astore 1
      // 08: aload 1
      // 09: ldc_w "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
      // 0c: aconst_null
      // 0d: invokevirtual android/database/sqlite/SQLiteDatabase.rawQuery (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
      // 10: astore 1
      // 11: aload 1
      // 12: astore 2
      // 13: aload 1
      // 14: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 19: ifeq 36
      // 1c: aload 1
      // 1d: astore 2
      // 1e: aload 1
      // 1f: bipush 0
      // 20: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 25: astore 3
      // 26: aload 3
      // 27: astore 2
      // 28: aload 1
      // 29: ifnull 34
      // 2c: aload 1
      // 2d: invokeinterface android/database/Cursor.close ()V 1
      // 32: aload 3
      // 33: astore 2
      // 34: aload 2
      // 35: areturn
      // 36: aload 4
      // 38: astore 2
      // 39: aload 1
      // 3a: ifnull 34
      // 3d: aload 1
      // 3e: invokeinterface android/database/Cursor.close ()V 1
      // 43: aload 4
      // 45: astore 2
      // 46: goto 34
      // 49: astore 3
      // 4a: aconst_null
      // 4b: astore 1
      // 4c: aload 1
      // 4d: astore 2
      // 4e: aload 0
      // 4f: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 52: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 55: ldc_w "Database error getting next bundle app id"
      // 58: aload 3
      // 59: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;)V
      // 5c: aload 4
      // 5e: astore 2
      // 5f: aload 1
      // 60: ifnull 34
      // 63: aload 1
      // 64: invokeinterface android/database/Cursor.close ()V 1
      // 69: aload 4
      // 6b: astore 2
      // 6c: goto 34
      // 6f: astore 1
      // 70: aconst_null
      // 71: astore 2
      // 72: aload 2
      // 73: ifnull 7c
      // 76: aload 2
      // 77: invokeinterface android/database/Cursor.close ()V 1
      // 7c: aload 1
      // 7d: athrow
      // 7e: astore 1
      // 7f: goto 72
      // 82: astore 3
      // 83: goto 4c
      // try (5 -> 10): 40 android/database/sqlite/SQLiteException
      // try (5 -> 10): 60 null
      // try (12 -> 15): 71 android/database/sqlite/SQLiteException
      // try (12 -> 15): 69 null
      // try (17 -> 21): 71 android/database/sqlite/SQLiteException
      // try (17 -> 21): 69 null
      // try (45 -> 51): 69 null
   }

   public final boolean C() {
      boolean var1;
      if (this.b("select count(1) > 0 from queue where has_realtime = 1", (String[])null) != 0L) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   final void D() {
      this.c();
      this.Q();
      if (this.T()) {
         long var2 = this.u().f.a();
         long var4 = this.k().b();
         if (Math.abs(var4 - var2) > zzchc.A.b()) {
            this.u().f.a(var4);
            this.c();
            this.Q();
            if (this.T()) {
               int var1 = this.A()
                  .delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(this.k().a()), String.valueOf(zzcgn.y())});
               if (var1 > 0) {
                  this.t().E().a("Deleted stale rows. rowsDeleted", var1);
               }
            }
         }
      }
   }

   public final long E() {
      return this.a("select max(bundle_end_timestamp) from queue", null, 0L);
   }

   public final long F() {
      return this.a("select max(timestamp) from raw_events", null, 0L);
   }

   public final boolean G() {
      boolean var1;
      if (this.b("select count(1) > 0 from raw_events", (String[])null) != 0L) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public final boolean H() {
      boolean var1;
      if (this.b("select count(1) > 0 from raw_events where realtime = 1", (String[])null) != 0L) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public final long I() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: ldc2_w -1
      // 03: lstore 3
      // 04: aconst_null
      // 05: astore 7
      // 07: aconst_null
      // 08: astore 6
      // 0a: aload 0
      // 0b: invokevirtual com/google/android/gms/internal/zzcgo.A ()Landroid/database/sqlite/SQLiteDatabase;
      // 0e: ldc_w "select rowid from raw_events order by rowid desc limit 1;"
      // 11: aconst_null
      // 12: invokevirtual android/database/sqlite/SQLiteDatabase.rawQuery (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
      // 15: astore 8
      // 17: aload 8
      // 19: astore 6
      // 1b: aload 8
      // 1d: astore 7
      // 1f: aload 8
      // 21: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 26: istore 5
      // 28: iload 5
      // 2a: ifne 3f
      // 2d: lload 3
      // 2e: lstore 1
      // 2f: aload 8
      // 31: ifnull 3d
      // 34: aload 8
      // 36: invokeinterface android/database/Cursor.close ()V 1
      // 3b: lload 3
      // 3c: lstore 1
      // 3d: lload 1
      // 3e: lreturn
      // 3f: aload 8
      // 41: astore 6
      // 43: aload 8
      // 45: astore 7
      // 47: aload 8
      // 49: bipush 0
      // 4a: invokeinterface android/database/Cursor.getLong (I)J 2
      // 4f: lstore 1
      // 50: lload 1
      // 51: lstore 3
      // 52: lload 3
      // 53: lstore 1
      // 54: aload 8
      // 56: ifnull 3d
      // 59: aload 8
      // 5b: invokeinterface android/database/Cursor.close ()V 1
      // 60: lload 3
      // 61: lstore 1
      // 62: goto 3d
      // 65: astore 8
      // 67: aload 6
      // 69: astore 7
      // 6b: aload 0
      // 6c: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 6f: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 72: ldc_w "Error querying raw events"
      // 75: aload 8
      // 77: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;)V
      // 7a: lload 3
      // 7b: lstore 1
      // 7c: aload 6
      // 7e: ifnull 3d
      // 81: aload 6
      // 83: invokeinterface android/database/Cursor.close ()V 1
      // 88: lload 3
      // 89: lstore 1
      // 8a: goto 3d
      // 8d: astore 6
      // 8f: aload 7
      // 91: ifnull 9b
      // 94: aload 7
      // 96: invokeinterface android/database/Cursor.close ()V 1
      // 9b: aload 6
      // 9d: athrow
      // try (6 -> 12): 50 android/database/sqlite/SQLiteException
      // try (6 -> 12): 68 null
      // try (16 -> 19): 50 android/database/sqlite/SQLiteException
      // try (16 -> 19): 68 null
      // try (35 -> 39): 50 android/database/sqlite/SQLiteException
      // try (35 -> 39): 68 null
      // try (53 -> 59): 68 null
   }

   public final long a(zzcme var1) throws IOException {
      this.c();
      this.Q();
      zzbq.a(var1);
      zzbq.a(var1.o);

      byte[] var4;
      try {
         var4 = new byte[var1.f()];
         zzfjk var5 = zzfjk.a(var4, 0, var4.length);
         var1.a(var5);
         var5.a();
      } catch (IOException var8) {
         this.t().y().a("Data loss. Failed to serialize event metadata. appId", zzchm.a(var1.o), var8);
         throw var8;
      }

      zzclq var9 = this.p();
      zzbq.a(var4);
      var9.c();
      MessageDigest var6 = zzclq.g("MD5");
      long var2;
      if (var6 == null) {
         var9.t().y().a("Failed to get MD5");
         var2 = 0L;
      } else {
         var2 = zzclq.c(var6.digest(var4));
      }

      ContentValues var10 = new ContentValues();
      var10.put("app_id", var1.o);
      var10.put("metadata_fingerprint", var2);
      var10.put("metadata", var4);

      try {
         this.A().insertWithOnConflict("raw_events_metadata", null, var10, 4);
         return var2;
      } catch (SQLiteException var7) {
         this.t().y().a("Error storing raw event metadata. appId", zzchm.a(var1.o), var7);
         throw var7;
      }
   }

   public final zzcgp a(long param1, String param3, boolean param4, boolean param5, boolean param6, boolean param7, boolean param8) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aload 3
      // 001: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/String;)Ljava/lang/String;
      // 004: pop
      // 005: aload 0
      // 006: invokevirtual com/google/android/gms/internal/zzcjk.c ()V
      // 009: aload 0
      // 00a: invokevirtual com/google/android/gms/internal/zzcjl.Q ()V
      // 00d: new com/google/android/gms/internal/zzcgp
      // 010: dup
      // 011: invokespecial com/google/android/gms/internal/zzcgp.<init> ()V
      // 014: astore 12
      // 016: aload 0
      // 017: invokevirtual com/google/android/gms/internal/zzcgo.A ()Landroid/database/sqlite/SQLiteDatabase;
      // 01a: astore 11
      // 01c: aload 11
      // 01e: ldc_w "apps"
      // 021: bipush 6
      // 023: anewarray 19
      // 026: dup
      // 027: bipush 0
      // 028: ldc "day"
      // 02a: aastore
      // 02b: dup
      // 02c: bipush 1
      // 02d: ldc "daily_events_count"
      // 02f: aastore
      // 030: dup
      // 031: bipush 2
      // 032: ldc "daily_public_events_count"
      // 034: aastore
      // 035: dup
      // 036: bipush 3
      // 037: ldc "daily_conversions_count"
      // 039: aastore
      // 03a: dup
      // 03b: bipush 4
      // 03c: ldc "daily_error_events_count"
      // 03e: aastore
      // 03f: dup
      // 040: bipush 5
      // 041: ldc "daily_realtime_events_count"
      // 043: aastore
      // 044: ldc_w "app_id=?"
      // 047: bipush 1
      // 048: anewarray 19
      // 04b: dup
      // 04c: bipush 0
      // 04d: aload 3
      // 04e: aastore
      // 04f: aconst_null
      // 050: aconst_null
      // 051: aconst_null
      // 052: invokevirtual android/database/sqlite/SQLiteDatabase.query (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      // 055: astore 10
      // 057: aload 10
      // 059: astore 9
      // 05b: aload 10
      // 05d: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 062: ifne 089
      // 065: aload 10
      // 067: astore 9
      // 069: aload 0
      // 06a: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 06d: invokevirtual com/google/android/gms/internal/zzchm.A ()Lcom/google/android/gms/internal/zzcho;
      // 070: ldc_w "Not updating daily counts, app is not known. appId"
      // 073: aload 3
      // 074: invokestatic com/google/android/gms/internal/zzchm.a (Ljava/lang/String;)Ljava/lang/Object;
      // 077: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;)V
      // 07a: aload 10
      // 07c: ifnull 086
      // 07f: aload 10
      // 081: invokeinterface android/database/Cursor.close ()V 1
      // 086: aload 12
      // 088: areturn
      // 089: aload 10
      // 08b: astore 9
      // 08d: aload 10
      // 08f: bipush 0
      // 090: invokeinterface android/database/Cursor.getLong (I)J 2
      // 095: lload 1
      // 096: lcmp
      // 097: ifne 0ef
      // 09a: aload 10
      // 09c: astore 9
      // 09e: aload 12
      // 0a0: aload 10
      // 0a2: bipush 1
      // 0a3: invokeinterface android/database/Cursor.getLong (I)J 2
      // 0a8: putfield com/google/android/gms/internal/zzcgp.b J
      // 0ab: aload 10
      // 0ad: astore 9
      // 0af: aload 12
      // 0b1: aload 10
      // 0b3: bipush 2
      // 0b4: invokeinterface android/database/Cursor.getLong (I)J 2
      // 0b9: putfield com/google/android/gms/internal/zzcgp.a J
      // 0bc: aload 10
      // 0be: astore 9
      // 0c0: aload 12
      // 0c2: aload 10
      // 0c4: bipush 3
      // 0c5: invokeinterface android/database/Cursor.getLong (I)J 2
      // 0ca: putfield com/google/android/gms/internal/zzcgp.c J
      // 0cd: aload 10
      // 0cf: astore 9
      // 0d1: aload 12
      // 0d3: aload 10
      // 0d5: bipush 4
      // 0d6: invokeinterface android/database/Cursor.getLong (I)J 2
      // 0db: putfield com/google/android/gms/internal/zzcgp.d J
      // 0de: aload 10
      // 0e0: astore 9
      // 0e2: aload 12
      // 0e4: aload 10
      // 0e6: bipush 5
      // 0e7: invokeinterface android/database/Cursor.getLong (I)J 2
      // 0ec: putfield com/google/android/gms/internal/zzcgp.e J
      // 0ef: iload 4
      // 0f1: ifeq 104
      // 0f4: aload 10
      // 0f6: astore 9
      // 0f8: aload 12
      // 0fa: aload 12
      // 0fc: getfield com/google/android/gms/internal/zzcgp.b J
      // 0ff: lconst_1
      // 100: ladd
      // 101: putfield com/google/android/gms/internal/zzcgp.b J
      // 104: iload 5
      // 106: ifeq 119
      // 109: aload 10
      // 10b: astore 9
      // 10d: aload 12
      // 10f: aload 12
      // 111: getfield com/google/android/gms/internal/zzcgp.a J
      // 114: lconst_1
      // 115: ladd
      // 116: putfield com/google/android/gms/internal/zzcgp.a J
      // 119: iload 6
      // 11b: ifeq 12e
      // 11e: aload 10
      // 120: astore 9
      // 122: aload 12
      // 124: aload 12
      // 126: getfield com/google/android/gms/internal/zzcgp.c J
      // 129: lconst_1
      // 12a: ladd
      // 12b: putfield com/google/android/gms/internal/zzcgp.c J
      // 12e: iload 7
      // 130: ifeq 143
      // 133: aload 10
      // 135: astore 9
      // 137: aload 12
      // 139: aload 12
      // 13b: getfield com/google/android/gms/internal/zzcgp.d J
      // 13e: lconst_1
      // 13f: ladd
      // 140: putfield com/google/android/gms/internal/zzcgp.d J
      // 143: iload 8
      // 145: ifeq 158
      // 148: aload 10
      // 14a: astore 9
      // 14c: aload 12
      // 14e: aload 12
      // 150: getfield com/google/android/gms/internal/zzcgp.e J
      // 153: lconst_1
      // 154: ladd
      // 155: putfield com/google/android/gms/internal/zzcgp.e J
      // 158: aload 10
      // 15a: astore 9
      // 15c: new android/content/ContentValues
      // 15f: astore 13
      // 161: aload 10
      // 163: astore 9
      // 165: aload 13
      // 167: invokespecial android/content/ContentValues.<init> ()V
      // 16a: aload 10
      // 16c: astore 9
      // 16e: aload 13
      // 170: ldc "day"
      // 172: lload 1
      // 173: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 176: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/Long;)V
      // 179: aload 10
      // 17b: astore 9
      // 17d: aload 13
      // 17f: ldc "daily_public_events_count"
      // 181: aload 12
      // 183: getfield com/google/android/gms/internal/zzcgp.a J
      // 186: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 189: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/Long;)V
      // 18c: aload 10
      // 18e: astore 9
      // 190: aload 13
      // 192: ldc "daily_events_count"
      // 194: aload 12
      // 196: getfield com/google/android/gms/internal/zzcgp.b J
      // 199: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 19c: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/Long;)V
      // 19f: aload 10
      // 1a1: astore 9
      // 1a3: aload 13
      // 1a5: ldc "daily_conversions_count"
      // 1a7: aload 12
      // 1a9: getfield com/google/android/gms/internal/zzcgp.c J
      // 1ac: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 1af: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/Long;)V
      // 1b2: aload 10
      // 1b4: astore 9
      // 1b6: aload 13
      // 1b8: ldc "daily_error_events_count"
      // 1ba: aload 12
      // 1bc: getfield com/google/android/gms/internal/zzcgp.d J
      // 1bf: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 1c2: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/Long;)V
      // 1c5: aload 10
      // 1c7: astore 9
      // 1c9: aload 13
      // 1cb: ldc "daily_realtime_events_count"
      // 1cd: aload 12
      // 1cf: getfield com/google/android/gms/internal/zzcgp.e J
      // 1d2: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 1d5: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/Long;)V
      // 1d8: aload 10
      // 1da: astore 9
      // 1dc: aload 11
      // 1de: ldc_w "apps"
      // 1e1: aload 13
      // 1e3: ldc_w "app_id=?"
      // 1e6: bipush 1
      // 1e7: anewarray 19
      // 1ea: dup
      // 1eb: bipush 0
      // 1ec: aload 3
      // 1ed: aastore
      // 1ee: invokevirtual android/database/sqlite/SQLiteDatabase.update (Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
      // 1f1: pop
      // 1f2: aload 10
      // 1f4: ifnull 1fe
      // 1f7: aload 10
      // 1f9: invokeinterface android/database/Cursor.close ()V 1
      // 1fe: goto 086
      // 201: astore 11
      // 203: aconst_null
      // 204: astore 10
      // 206: aload 10
      // 208: astore 9
      // 20a: aload 0
      // 20b: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 20e: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 211: ldc_w "Error updating daily counts. appId"
      // 214: aload 3
      // 215: invokestatic com/google/android/gms/internal/zzchm.a (Ljava/lang/String;)Ljava/lang/Object;
      // 218: aload 11
      // 21a: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
      // 21d: aload 10
      // 21f: ifnull 229
      // 222: aload 10
      // 224: invokeinterface android/database/Cursor.close ()V 1
      // 229: goto 086
      // 22c: astore 3
      // 22d: aconst_null
      // 22e: astore 9
      // 230: aload 9
      // 232: ifnull 23c
      // 235: aload 9
      // 237: invokeinterface android/database/Cursor.close ()V 1
      // 23c: aload 3
      // 23d: athrow
      // 23e: astore 3
      // 23f: goto 230
      // 242: astore 11
      // 244: goto 206
      // try (11 -> 54): 241 android/database/sqlite/SQLiteException
      // try (11 -> 54): 259 null
      // try (56 -> 59): 270 android/database/sqlite/SQLiteException
      // try (56 -> 59): 268 null
      // try (61 -> 68): 270 android/database/sqlite/SQLiteException
      // try (61 -> 68): 268 null
      // try (76 -> 82): 270 android/database/sqlite/SQLiteException
      // try (76 -> 82): 268 null
      // try (84 -> 89): 270 android/database/sqlite/SQLiteException
      // try (84 -> 89): 268 null
      // try (91 -> 96): 270 android/database/sqlite/SQLiteException
      // try (91 -> 96): 268 null
      // try (98 -> 103): 270 android/database/sqlite/SQLiteException
      // try (98 -> 103): 268 null
      // try (105 -> 110): 270 android/database/sqlite/SQLiteException
      // try (105 -> 110): 268 null
      // try (112 -> 117): 270 android/database/sqlite/SQLiteException
      // try (112 -> 117): 268 null
      // try (121 -> 127): 270 android/database/sqlite/SQLiteException
      // try (121 -> 127): 268 null
      // try (131 -> 137): 270 android/database/sqlite/SQLiteException
      // try (131 -> 137): 268 null
      // try (141 -> 147): 270 android/database/sqlite/SQLiteException
      // try (141 -> 147): 268 null
      // try (151 -> 157): 270 android/database/sqlite/SQLiteException
      // try (151 -> 157): 268 null
      // try (161 -> 167): 270 android/database/sqlite/SQLiteException
      // try (161 -> 167): 268 null
      // try (169 -> 171): 270 android/database/sqlite/SQLiteException
      // try (169 -> 171): 268 null
      // try (173 -> 175): 270 android/database/sqlite/SQLiteException
      // try (173 -> 175): 268 null
      // try (177 -> 182): 270 android/database/sqlite/SQLiteException
      // try (177 -> 182): 268 null
      // try (184 -> 190): 270 android/database/sqlite/SQLiteException
      // try (184 -> 190): 268 null
      // try (192 -> 198): 270 android/database/sqlite/SQLiteException
      // try (192 -> 198): 268 null
      // try (200 -> 206): 270 android/database/sqlite/SQLiteException
      // try (200 -> 206): 268 null
      // try (208 -> 214): 270 android/database/sqlite/SQLiteException
      // try (208 -> 214): 268 null
      // try (216 -> 222): 270 android/database/sqlite/SQLiteException
      // try (216 -> 222): 268 null
      // try (224 -> 236): 270 android/database/sqlite/SQLiteException
      // try (224 -> 236): 268 null
      // try (246 -> 254): 268 null
   }

   public final zzcgw a(String param1, String param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aload 1
      // 001: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/String;)Ljava/lang/String;
      // 004: pop
      // 005: aload 2
      // 006: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/String;)Ljava/lang/String;
      // 009: pop
      // 00a: aload 0
      // 00b: invokevirtual com/google/android/gms/internal/zzcjk.c ()V
      // 00e: aload 0
      // 00f: invokevirtual com/google/android/gms/internal/zzcjl.Q ()V
      // 012: aload 0
      // 013: invokevirtual com/google/android/gms/internal/zzcgo.A ()Landroid/database/sqlite/SQLiteDatabase;
      // 016: ldc_w "events"
      // 019: bipush 7
      // 01b: anewarray 19
      // 01e: dup
      // 01f: bipush 0
      // 020: ldc_w "lifetime_count"
      // 023: aastore
      // 024: dup
      // 025: bipush 1
      // 026: ldc_w "current_bundle_count"
      // 029: aastore
      // 02a: dup
      // 02b: bipush 2
      // 02c: ldc_w "last_fire_timestamp"
      // 02f: aastore
      // 030: dup
      // 031: bipush 3
      // 032: ldc "last_bundled_timestamp"
      // 034: aastore
      // 035: dup
      // 036: bipush 4
      // 037: ldc "last_sampled_complex_event_id"
      // 039: aastore
      // 03a: dup
      // 03b: bipush 5
      // 03c: ldc "last_sampling_rate"
      // 03e: aastore
      // 03f: dup
      // 040: bipush 6
      // 042: ldc "last_exempt_from_sampling"
      // 044: aastore
      // 045: ldc_w "app_id=? and name=?"
      // 048: bipush 2
      // 049: anewarray 19
      // 04c: dup
      // 04d: bipush 0
      // 04e: aload 1
      // 04f: aastore
      // 050: dup
      // 051: bipush 1
      // 052: aload 2
      // 053: aastore
      // 054: aconst_null
      // 055: aconst_null
      // 056: aconst_null
      // 057: invokevirtual android/database/sqlite/SQLiteDatabase.query (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      // 05a: astore 14
      // 05c: aload 14
      // 05e: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 063: istore 13
      // 065: iload 13
      // 067: ifne 07a
      // 06a: aload 14
      // 06c: ifnull 076
      // 06f: aload 14
      // 071: invokeinterface android/database/Cursor.close ()V 1
      // 076: aconst_null
      // 077: astore 1
      // 078: aload 1
      // 079: areturn
      // 07a: aload 14
      // 07c: bipush 0
      // 07d: invokeinterface android/database/Cursor.getLong (I)J 2
      // 082: lstore 7
      // 084: aload 14
      // 086: bipush 1
      // 087: invokeinterface android/database/Cursor.getLong (I)J 2
      // 08c: lstore 9
      // 08e: aload 14
      // 090: bipush 2
      // 091: invokeinterface android/database/Cursor.getLong (I)J 2
      // 096: lstore 5
      // 098: aload 14
      // 09a: bipush 3
      // 09b: invokeinterface android/database/Cursor.isNull (I)Z 2
      // 0a0: ifeq 131
      // 0a3: lconst_0
      // 0a4: lstore 3
      // 0a5: aload 14
      // 0a7: bipush 4
      // 0a8: invokeinterface android/database/Cursor.isNull (I)Z 2
      // 0ad: ifeq 13d
      // 0b0: aconst_null
      // 0b1: astore 15
      // 0b3: aload 14
      // 0b5: bipush 5
      // 0b6: invokeinterface android/database/Cursor.isNull (I)Z 2
      // 0bb: ifeq 14d
      // 0be: aconst_null
      // 0bf: astore 16
      // 0c1: aconst_null
      // 0c2: astore 17
      // 0c4: aload 14
      // 0c6: bipush 6
      // 0c8: invokeinterface android/database/Cursor.isNull (I)Z 2
      // 0cd: ifne 0e8
      // 0d0: aload 14
      // 0d2: bipush 6
      // 0d4: invokeinterface android/database/Cursor.getLong (I)J 2
      // 0d9: lconst_1
      // 0da: lcmp
      // 0db: ifne 161
      // 0de: bipush 1
      // 0df: istore 13
      // 0e1: iload 13
      // 0e3: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
      // 0e6: astore 17
      // 0e8: new com/google/android/gms/internal/zzcgw
      // 0eb: astore 18
      // 0ed: aload 18
      // 0ef: aload 1
      // 0f0: aload 2
      // 0f1: lload 7
      // 0f3: lload 9
      // 0f5: lload 5
      // 0f7: lload 3
      // 0f8: aload 15
      // 0fa: aload 16
      // 0fc: aload 17
      // 0fe: invokespecial com/google/android/gms/internal/zzcgw.<init> (Ljava/lang/String;Ljava/lang/String;JJJJLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;)V
      // 101: aload 14
      // 103: invokeinterface android/database/Cursor.moveToNext ()Z 1
      // 108: ifeq 11c
      // 10b: aload 0
      // 10c: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 10f: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 112: ldc_w "Got multiple records for event aggregates, expected one. appId"
      // 115: aload 1
      // 116: invokestatic com/google/android/gms/internal/zzchm.a (Ljava/lang/String;)Ljava/lang/Object;
      // 119: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;)V
      // 11c: aload 18
      // 11e: astore 1
      // 11f: aload 14
      // 121: ifnull 078
      // 124: aload 14
      // 126: invokeinterface android/database/Cursor.close ()V 1
      // 12b: aload 18
      // 12d: astore 1
      // 12e: goto 078
      // 131: aload 14
      // 133: bipush 3
      // 134: invokeinterface android/database/Cursor.getLong (I)J 2
      // 139: lstore 3
      // 13a: goto 0a5
      // 13d: aload 14
      // 13f: bipush 4
      // 140: invokeinterface android/database/Cursor.getLong (I)J 2
      // 145: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 148: astore 15
      // 14a: goto 0b3
      // 14d: aload 14
      // 14f: bipush 5
      // 150: invokeinterface android/database/Cursor.getLong (I)J 2
      // 155: lstore 11
      // 157: lload 11
      // 159: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 15c: astore 16
      // 15e: goto 0c1
      // 161: bipush 0
      // 162: istore 13
      // 164: goto 0e1
      // 167: astore 15
      // 169: aconst_null
      // 16a: astore 14
      // 16c: aload 0
      // 16d: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 170: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 173: ldc_w "Error querying events. appId"
      // 176: aload 1
      // 177: invokestatic com/google/android/gms/internal/zzchm.a (Ljava/lang/String;)Ljava/lang/Object;
      // 17a: aload 0
      // 17b: invokevirtual com/google/android/gms/internal/zzcjk.o ()Lcom/google/android/gms/internal/zzchk;
      // 17e: aload 2
      // 17f: invokevirtual com/google/android/gms/internal/zzchk.a (Ljava/lang/String;)Ljava/lang/String;
      // 182: aload 15
      // 184: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
      // 187: aload 14
      // 189: ifnull 193
      // 18c: aload 14
      // 18e: invokeinterface android/database/Cursor.close ()V 1
      // 193: aconst_null
      // 194: astore 1
      // 195: goto 078
      // 198: astore 1
      // 199: aconst_null
      // 19a: astore 14
      // 19c: aload 14
      // 19e: ifnull 1a8
      // 1a1: aload 14
      // 1a3: invokeinterface android/database/Cursor.close ()V 1
      // 1a8: aload 1
      // 1a9: athrow
      // 1aa: astore 1
      // 1ab: goto 19c
      // 1ae: astore 1
      // 1af: goto 19c
      // 1b2: astore 15
      // 1b4: goto 16c
      // try (10 -> 59): 173 android/database/sqlite/SQLiteException
      // try (10 -> 59): 195 null
      // try (59 -> 62): 208 android/database/sqlite/SQLiteException
      // try (59 -> 62): 204 null
      // try (72 -> 88): 208 android/database/sqlite/SQLiteException
      // try (72 -> 88): 204 null
      // try (90 -> 94): 208 android/database/sqlite/SQLiteException
      // try (90 -> 94): 204 null
      // try (96 -> 100): 208 android/database/sqlite/SQLiteException
      // try (96 -> 100): 204 null
      // try (104 -> 114): 208 android/database/sqlite/SQLiteException
      // try (104 -> 114): 204 null
      // try (116 -> 119): 208 android/database/sqlite/SQLiteException
      // try (116 -> 119): 204 null
      // try (119 -> 142): 208 android/database/sqlite/SQLiteException
      // try (119 -> 142): 204 null
      // try (151 -> 155): 208 android/database/sqlite/SQLiteException
      // try (151 -> 155): 204 null
      // try (156 -> 161): 208 android/database/sqlite/SQLiteException
      // try (156 -> 161): 204 null
      // try (162 -> 166): 208 android/database/sqlite/SQLiteException
      // try (162 -> 166): 204 null
      // try (176 -> 188): 206 null
   }

   public final String a(long param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aconst_null
      // 01: astore 6
      // 03: aload 0
      // 04: invokevirtual com/google/android/gms/internal/zzcjk.c ()V
      // 07: aload 0
      // 08: invokevirtual com/google/android/gms/internal/zzcjl.Q ()V
      // 0b: aload 0
      // 0c: invokevirtual com/google/android/gms/internal/zzcgo.A ()Landroid/database/sqlite/SQLiteDatabase;
      // 0f: ldc_w "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
      // 12: bipush 1
      // 13: anewarray 19
      // 16: dup
      // 17: bipush 0
      // 18: lload 1
      // 19: invokestatic java/lang/String.valueOf (J)Ljava/lang/String;
      // 1c: aastore
      // 1d: invokevirtual android/database/sqlite/SQLiteDatabase.rawQuery (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
      // 20: astore 4
      // 22: aload 4
      // 24: astore 3
      // 25: aload 4
      // 27: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 2c: ifne 53
      // 2f: aload 4
      // 31: astore 3
      // 32: aload 0
      // 33: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 36: invokevirtual com/google/android/gms/internal/zzchm.E ()Lcom/google/android/gms/internal/zzcho;
      // 39: ldc_w "No expired configs for apps with pending events"
      // 3c: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;)V
      // 3f: aload 6
      // 41: astore 3
      // 42: aload 4
      // 44: ifnull 51
      // 47: aload 4
      // 49: invokeinterface android/database/Cursor.close ()V 1
      // 4e: aload 6
      // 50: astore 3
      // 51: aload 3
      // 52: areturn
      // 53: aload 4
      // 55: astore 3
      // 56: aload 4
      // 58: bipush 0
      // 59: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 5e: astore 5
      // 60: aload 5
      // 62: astore 3
      // 63: aload 4
      // 65: ifnull 51
      // 68: aload 4
      // 6a: invokeinterface android/database/Cursor.close ()V 1
      // 6f: aload 5
      // 71: astore 3
      // 72: goto 51
      // 75: astore 5
      // 77: aconst_null
      // 78: astore 4
      // 7a: aload 4
      // 7c: astore 3
      // 7d: aload 0
      // 7e: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 81: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 84: ldc_w "Error selecting expired configs"
      // 87: aload 5
      // 89: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;)V
      // 8c: aload 6
      // 8e: astore 3
      // 8f: aload 4
      // 91: ifnull 51
      // 94: aload 4
      // 96: invokeinterface android/database/Cursor.close ()V 1
      // 9b: aload 6
      // 9d: astore 3
      // 9e: goto 51
      // a1: astore 4
      // a3: aconst_null
      // a4: astore 3
      // a5: aload 3
      // a6: ifnull af
      // a9: aload 3
      // aa: invokeinterface android/database/Cursor.close ()V 1
      // af: aload 4
      // b1: athrow
      // b2: astore 4
      // b4: goto a5
      // b7: astore 5
      // b9: goto 7a
      // try (6 -> 18): 55 android/database/sqlite/SQLiteException
      // try (6 -> 18): 75 null
      // try (20 -> 23): 86 android/database/sqlite/SQLiteException
      // try (20 -> 23): 84 null
      // try (25 -> 30): 86 android/database/sqlite/SQLiteException
      // try (25 -> 30): 84 null
      // try (42 -> 46): 86 android/database/sqlite/SQLiteException
      // try (42 -> 46): 84 null
      // try (60 -> 66): 84 null
   }

   public final List<zzclp> a(String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aconst_null
      // 001: astore 7
      // 003: aload 1
      // 004: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/String;)Ljava/lang/String;
      // 007: pop
      // 008: aload 0
      // 009: invokevirtual com/google/android/gms/internal/zzcjk.c ()V
      // 00c: aload 0
      // 00d: invokevirtual com/google/android/gms/internal/zzcjl.Q ()V
      // 010: new java/util/ArrayList
      // 013: dup
      // 014: invokespecial java/util/ArrayList.<init> ()V
      // 017: astore 6
      // 019: aload 0
      // 01a: invokevirtual com/google/android/gms/internal/zzcgo.A ()Landroid/database/sqlite/SQLiteDatabase;
      // 01d: ldc_w "user_attributes"
      // 020: bipush 4
      // 021: anewarray 19
      // 024: dup
      // 025: bipush 0
      // 026: ldc_w "name"
      // 029: aastore
      // 02a: dup
      // 02b: bipush 1
      // 02c: ldc "origin"
      // 02e: aastore
      // 02f: dup
      // 030: bipush 2
      // 031: ldc_w "set_timestamp"
      // 034: aastore
      // 035: dup
      // 036: bipush 3
      // 037: ldc_w "value"
      // 03a: aastore
      // 03b: ldc_w "app_id=?"
      // 03e: bipush 1
      // 03f: anewarray 19
      // 042: dup
      // 043: bipush 0
      // 044: aload 1
      // 045: aastore
      // 046: aconst_null
      // 047: aconst_null
      // 048: ldc_w "rowid"
      // 04b: ldc_w "1000"
      // 04e: invokevirtual android/database/sqlite/SQLiteDatabase.query (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      // 051: astore 5
      // 053: aload 5
      // 055: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 05a: istore 2
      // 05b: iload 2
      // 05c: ifne 070
      // 05f: aload 5
      // 061: ifnull 06b
      // 064: aload 5
      // 066: invokeinterface android/database/Cursor.close ()V 1
      // 06b: aload 6
      // 06d: astore 1
      // 06e: aload 1
      // 06f: areturn
      // 070: aload 5
      // 072: bipush 0
      // 073: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 078: astore 9
      // 07a: aload 5
      // 07c: bipush 1
      // 07d: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 082: astore 8
      // 084: aload 8
      // 086: astore 7
      // 088: aload 8
      // 08a: ifnonnull 092
      // 08d: ldc_w ""
      // 090: astore 7
      // 092: aload 5
      // 094: bipush 2
      // 095: invokeinterface android/database/Cursor.getLong (I)J 2
      // 09a: lstore 3
      // 09b: aload 0
      // 09c: aload 5
      // 09e: bipush 3
      // 09f: invokespecial com/google/android/gms/internal/zzcgo.a (Landroid/database/Cursor;I)Ljava/lang/Object;
      // 0a2: astore 8
      // 0a4: aload 8
      // 0a6: ifnonnull 0d8
      // 0a9: aload 0
      // 0aa: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 0ad: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 0b0: ldc_w "Read invalid user property value, ignoring it. appId"
      // 0b3: aload 1
      // 0b4: invokestatic com/google/android/gms/internal/zzchm.a (Ljava/lang/String;)Ljava/lang/Object;
      // 0b7: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;)V
      // 0ba: aload 5
      // 0bc: invokeinterface android/database/Cursor.moveToNext ()Z 1
      // 0c1: istore 2
      // 0c2: iload 2
      // 0c3: ifne 070
      // 0c6: aload 5
      // 0c8: ifnull 0d2
      // 0cb: aload 5
      // 0cd: invokeinterface android/database/Cursor.close ()V 1
      // 0d2: aload 6
      // 0d4: astore 1
      // 0d5: goto 06e
      // 0d8: new com/google/android/gms/internal/zzclp
      // 0db: astore 10
      // 0dd: aload 10
      // 0df: aload 1
      // 0e0: aload 7
      // 0e2: aload 9
      // 0e4: lload 3
      // 0e5: aload 8
      // 0e7: invokespecial com/google/android/gms/internal/zzclp.<init> (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Object;)V
      // 0ea: aload 6
      // 0ec: aload 10
      // 0ee: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 0f3: pop
      // 0f4: goto 0ba
      // 0f7: astore 6
      // 0f9: aload 0
      // 0fa: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 0fd: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 100: ldc_w "Error querying user properties. appId"
      // 103: aload 1
      // 104: invokestatic com/google/android/gms/internal/zzchm.a (Ljava/lang/String;)Ljava/lang/Object;
      // 107: aload 6
      // 109: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
      // 10c: aload 5
      // 10e: ifnull 118
      // 111: aload 5
      // 113: invokeinterface android/database/Cursor.close ()V 1
      // 118: aconst_null
      // 119: astore 1
      // 11a: goto 06e
      // 11d: astore 1
      // 11e: aload 7
      // 120: astore 5
      // 122: aload 5
      // 124: ifnull 12e
      // 127: aload 5
      // 129: invokeinterface android/database/Cursor.close ()V 1
      // 12e: aload 1
      // 12f: athrow
      // 130: astore 1
      // 131: goto 122
      // 134: astore 1
      // 135: goto 122
      // 138: astore 6
      // 13a: aconst_null
      // 13b: astore 5
      // 13d: goto 0f9
      // try (13 -> 47): 147 android/database/sqlite/SQLiteException
      // try (13 -> 47): 134 null
      // try (47 -> 50): 118 android/database/sqlite/SQLiteException
      // try (47 -> 50): 143 null
      // try (60 -> 68): 118 android/database/sqlite/SQLiteException
      // try (60 -> 68): 143 null
      // try (74 -> 83): 118 android/database/sqlite/SQLiteException
      // try (74 -> 83): 143 null
      // try (85 -> 92): 118 android/database/sqlite/SQLiteException
      // try (85 -> 92): 143 null
      // try (92 -> 95): 118 android/database/sqlite/SQLiteException
      // try (92 -> 95): 143 null
      // try (104 -> 117): 118 android/database/sqlite/SQLiteException
      // try (104 -> 117): 143 null
      // try (119 -> 127): 145 null
   }

   public final List<Pair<zzcme, Long>> a(String param1, int param2, int param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: bipush 1
      // 001: istore 5
      // 003: aload 0
      // 004: invokevirtual com/google/android/gms/internal/zzcjk.c ()V
      // 007: aload 0
      // 008: invokevirtual com/google/android/gms/internal/zzcjl.Q ()V
      // 00b: iload 2
      // 00c: ifle 07c
      // 00f: bipush 1
      // 010: istore 4
      // 012: iload 4
      // 014: invokestatic com/google/android/gms/common/internal/zzbq.b (Z)V
      // 017: iload 3
      // 018: ifle 082
      // 01b: iload 5
      // 01d: istore 4
      // 01f: iload 4
      // 021: invokestatic com/google/android/gms/common/internal/zzbq.b (Z)V
      // 024: aload 1
      // 025: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/String;)Ljava/lang/String;
      // 028: pop
      // 029: aload 0
      // 02a: invokevirtual com/google/android/gms/internal/zzcgo.A ()Landroid/database/sqlite/SQLiteDatabase;
      // 02d: ldc_w "queue"
      // 030: bipush 2
      // 031: anewarray 19
      // 034: dup
      // 035: bipush 0
      // 036: ldc_w "rowid"
      // 039: aastore
      // 03a: dup
      // 03b: bipush 1
      // 03c: ldc_w "data"
      // 03f: aastore
      // 040: ldc_w "app_id=?"
      // 043: bipush 1
      // 044: anewarray 19
      // 047: dup
      // 048: bipush 0
      // 049: aload 1
      // 04a: aastore
      // 04b: aconst_null
      // 04c: aconst_null
      // 04d: ldc_w "rowid"
      // 050: iload 2
      // 051: invokestatic java/lang/String.valueOf (I)Ljava/lang/String;
      // 054: invokevirtual android/database/sqlite/SQLiteDatabase.query (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      // 057: astore 8
      // 059: aload 8
      // 05b: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 060: ifne 088
      // 063: invokestatic java/util/Collections.emptyList ()Ljava/util/List;
      // 066: astore 9
      // 068: aload 9
      // 06a: astore 1
      // 06b: aload 8
      // 06d: ifnull 07a
      // 070: aload 8
      // 072: invokeinterface android/database/Cursor.close ()V 1
      // 077: aload 9
      // 079: astore 1
      // 07a: aload 1
      // 07b: areturn
      // 07c: bipush 0
      // 07d: istore 4
      // 07f: goto 012
      // 082: bipush 0
      // 083: istore 4
      // 085: goto 01f
      // 088: new java/util/ArrayList
      // 08b: astore 9
      // 08d: aload 9
      // 08f: invokespecial java/util/ArrayList.<init> ()V
      // 092: bipush 0
      // 093: istore 2
      // 094: aload 8
      // 096: bipush 0
      // 097: invokeinterface android/database/Cursor.getLong (I)J 2
      // 09c: lstore 6
      // 09e: aload 8
      // 0a0: bipush 1
      // 0a1: invokeinterface android/database/Cursor.getBlob (I)[B 2
      // 0a6: astore 10
      // 0a8: aload 0
      // 0a9: invokevirtual com/google/android/gms/internal/zzcjk.p ()Lcom/google/android/gms/internal/zzclq;
      // 0ac: aload 10
      // 0ae: invokevirtual com/google/android/gms/internal/zzclq.b ([B)[B
      // 0b1: astore 12
      // 0b3: aload 9
      // 0b5: invokeinterface java/util/List.isEmpty ()Z 1
      // 0ba: ifne 0c6
      // 0bd: aload 12
      // 0bf: arraylength
      // 0c0: iload 2
      // 0c1: iadd
      // 0c2: iload 3
      // 0c3: if_icmpgt 10e
      // 0c6: aload 12
      // 0c8: bipush 0
      // 0c9: aload 12
      // 0cb: arraylength
      // 0cc: invokestatic com/google/android/gms/internal/zzfjj.a ([BII)Lcom/google/android/gms/internal/zzfjj;
      // 0cf: astore 10
      // 0d1: new com/google/android/gms/internal/zzcme
      // 0d4: astore 11
      // 0d6: aload 11
      // 0d8: invokespecial com/google/android/gms/internal/zzcme.<init> ()V
      // 0db: aload 11
      // 0dd: aload 10
      // 0df: invokevirtual com/google/android/gms/internal/zzfjs.a (Lcom/google/android/gms/internal/zzfjj;)Lcom/google/android/gms/internal/zzfjs;
      // 0e2: pop
      // 0e3: aload 12
      // 0e5: arraylength
      // 0e6: iload 2
      // 0e7: iadd
      // 0e8: istore 2
      // 0e9: aload 9
      // 0eb: aload 11
      // 0ed: lload 6
      // 0ef: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 0f2: invokestatic android/util/Pair.create (Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
      // 0f5: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 0fa: pop
      // 0fb: aload 8
      // 0fd: invokeinterface android/database/Cursor.moveToNext ()Z 1
      // 102: istore 4
      // 104: iload 4
      // 106: ifeq 10e
      // 109: iload 2
      // 10a: iload 3
      // 10b: if_icmple 1a4
      // 10e: aload 9
      // 110: astore 1
      // 111: aload 8
      // 113: ifnull 07a
      // 116: aload 8
      // 118: invokeinterface android/database/Cursor.close ()V 1
      // 11d: aload 9
      // 11f: astore 1
      // 120: goto 07a
      // 123: astore 10
      // 125: aload 0
      // 126: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 129: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 12c: ldc_w "Failed to unzip queued bundle. appId"
      // 12f: aload 1
      // 130: invokestatic com/google/android/gms/internal/zzchm.a (Ljava/lang/String;)Ljava/lang/Object;
      // 133: aload 10
      // 135: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
      // 138: goto 0fb
      // 13b: astore 10
      // 13d: aload 0
      // 13e: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 141: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 144: ldc_w "Failed to merge queued bundle. appId"
      // 147: aload 1
      // 148: invokestatic com/google/android/gms/internal/zzchm.a (Ljava/lang/String;)Ljava/lang/Object;
      // 14b: aload 10
      // 14d: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
      // 150: goto 0fb
      // 153: astore 9
      // 155: aconst_null
      // 156: astore 8
      // 158: aload 0
      // 159: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 15c: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 15f: ldc_w "Error querying bundles. appId"
      // 162: aload 1
      // 163: invokestatic com/google/android/gms/internal/zzchm.a (Ljava/lang/String;)Ljava/lang/Object;
      // 166: aload 9
      // 168: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
      // 16b: invokestatic java/util/Collections.emptyList ()Ljava/util/List;
      // 16e: astore 9
      // 170: aload 9
      // 172: astore 1
      // 173: aload 8
      // 175: ifnull 07a
      // 178: aload 8
      // 17a: invokeinterface android/database/Cursor.close ()V 1
      // 17f: aload 9
      // 181: astore 1
      // 182: goto 07a
      // 185: astore 1
      // 186: aconst_null
      // 187: astore 8
      // 189: aload 8
      // 18b: ifnull 195
      // 18e: aload 8
      // 190: invokeinterface android/database/Cursor.close ()V 1
      // 195: aload 1
      // 196: athrow
      // 197: astore 1
      // 198: goto 189
      // 19b: astore 1
      // 19c: goto 189
      // 19f: astore 9
      // 1a1: goto 158
      // 1a4: goto 094
      // try (21 -> 48): 160 android/database/sqlite/SQLiteException
      // try (21 -> 48): 182 null
      // try (48 -> 53): 195 android/database/sqlite/SQLiteException
      // try (48 -> 53): 191 null
      // try (69 -> 73): 195 android/database/sqlite/SQLiteException
      // try (69 -> 73): 191 null
      // try (75 -> 79): 195 android/database/sqlite/SQLiteException
      // try (75 -> 79): 191 null
      // try (79 -> 88): 140 java/io/IOException
      // try (79 -> 88): 195 android/database/sqlite/SQLiteException
      // try (79 -> 88): 191 null
      // try (88 -> 97): 195 android/database/sqlite/SQLiteException
      // try (88 -> 97): 191 null
      // try (97 -> 107): 195 android/database/sqlite/SQLiteException
      // try (97 -> 107): 191 null
      // try (107 -> 111): 150 java/io/IOException
      // try (107 -> 111): 195 android/database/sqlite/SQLiteException
      // try (107 -> 111): 191 null
      // try (111 -> 123): 195 android/database/sqlite/SQLiteException
      // try (111 -> 123): 191 null
      // try (123 -> 126): 195 android/database/sqlite/SQLiteException
      // try (123 -> 126): 191 null
      // try (141 -> 149): 195 android/database/sqlite/SQLiteException
      // try (141 -> 149): 191 null
      // try (151 -> 159): 195 android/database/sqlite/SQLiteException
      // try (151 -> 159): 191 null
      // try (163 -> 173): 193 null
   }

   public final List<zzclp> a(String param1, String param2, String param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aconst_null
      // 001: astore 8
      // 003: aload 1
      // 004: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/String;)Ljava/lang/String;
      // 007: pop
      // 008: aload 0
      // 009: invokevirtual com/google/android/gms/internal/zzcjk.c ()V
      // 00c: aload 0
      // 00d: invokevirtual com/google/android/gms/internal/zzcjl.Q ()V
      // 010: new java/util/ArrayList
      // 013: dup
      // 014: invokespecial java/util/ArrayList.<init> ()V
      // 017: astore 9
      // 019: new java/util/ArrayList
      // 01c: astore 7
      // 01e: aload 7
      // 020: bipush 3
      // 021: invokespecial java/util/ArrayList.<init> (I)V
      // 024: aload 7
      // 026: aload 1
      // 027: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 02c: pop
      // 02d: new java/lang/StringBuilder
      // 030: astore 10
      // 032: aload 10
      // 034: ldc_w "app_id=?"
      // 037: invokespecial java/lang/StringBuilder.<init> (Ljava/lang/String;)V
      // 03a: aload 2
      // 03b: invokestatic android/text/TextUtils.isEmpty (Ljava/lang/CharSequence;)Z
      // 03e: ifne 053
      // 041: aload 7
      // 043: aload 2
      // 044: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 049: pop
      // 04a: aload 10
      // 04c: ldc_w " and origin=?"
      // 04f: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 052: pop
      // 053: aload 3
      // 054: invokestatic android/text/TextUtils.isEmpty (Ljava/lang/CharSequence;)Z
      // 057: ifne 075
      // 05a: aload 7
      // 05c: aload 3
      // 05d: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 060: ldc_w "*"
      // 063: invokevirtual java/lang/String.concat (Ljava/lang/String;)Ljava/lang/String;
      // 066: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 06b: pop
      // 06c: aload 10
      // 06e: ldc_w " and name glob ?"
      // 071: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 074: pop
      // 075: aload 7
      // 077: aload 7
      // 079: invokeinterface java/util/List.size ()I 1
      // 07e: anewarray 19
      // 081: invokeinterface java/util/List.toArray ([Ljava/lang/Object;)[Ljava/lang/Object; 2
      // 086: checkcast [Ljava/lang/String;
      // 089: astore 11
      // 08b: aload 0
      // 08c: invokevirtual com/google/android/gms/internal/zzcgo.A ()Landroid/database/sqlite/SQLiteDatabase;
      // 08f: astore 7
      // 091: aload 10
      // 093: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 096: astore 10
      // 098: aload 7
      // 09a: ldc_w "user_attributes"
      // 09d: bipush 4
      // 09e: anewarray 19
      // 0a1: dup
      // 0a2: bipush 0
      // 0a3: ldc_w "name"
      // 0a6: aastore
      // 0a7: dup
      // 0a8: bipush 1
      // 0a9: ldc_w "set_timestamp"
      // 0ac: aastore
      // 0ad: dup
      // 0ae: bipush 2
      // 0af: ldc_w "value"
      // 0b2: aastore
      // 0b3: dup
      // 0b4: bipush 3
      // 0b5: ldc "origin"
      // 0b7: aastore
      // 0b8: aload 10
      // 0ba: aload 11
      // 0bc: aconst_null
      // 0bd: aconst_null
      // 0be: ldc_w "rowid"
      // 0c1: ldc_w "1001"
      // 0c4: invokevirtual android/database/sqlite/SQLiteDatabase.query (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      // 0c7: astore 7
      // 0c9: aload 2
      // 0ca: astore 8
      // 0cc: aload 7
      // 0ce: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 0d3: istore 6
      // 0d5: iload 6
      // 0d7: ifne 0eb
      // 0da: aload 7
      // 0dc: ifnull 0e6
      // 0df: aload 7
      // 0e1: invokeinterface android/database/Cursor.close ()V 1
      // 0e6: aload 9
      // 0e8: astore 1
      // 0e9: aload 1
      // 0ea: areturn
      // 0eb: aload 2
      // 0ec: astore 8
      // 0ee: aload 9
      // 0f0: invokeinterface java/util/List.size ()I 1
      // 0f5: sipush 1000
      // 0f8: if_icmplt 123
      // 0fb: aload 2
      // 0fc: astore 8
      // 0fe: aload 0
      // 0ff: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 102: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 105: ldc_w "Read more than the max allowed user properties, ignoring excess"
      // 108: sipush 1000
      // 10b: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 10e: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;)V
      // 111: aload 7
      // 113: ifnull 11d
      // 116: aload 7
      // 118: invokeinterface android/database/Cursor.close ()V 1
      // 11d: aload 9
      // 11f: astore 1
      // 120: goto 0e9
      // 123: aload 2
      // 124: astore 8
      // 126: aload 7
      // 128: bipush 0
      // 129: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 12e: astore 11
      // 130: aload 2
      // 131: astore 8
      // 133: aload 7
      // 135: bipush 1
      // 136: invokeinterface android/database/Cursor.getLong (I)J 2
      // 13b: lstore 4
      // 13d: aload 2
      // 13e: astore 8
      // 140: aload 0
      // 141: aload 7
      // 143: bipush 2
      // 144: invokespecial com/google/android/gms/internal/zzcgo.a (Landroid/database/Cursor;I)Ljava/lang/Object;
      // 147: astore 10
      // 149: aload 2
      // 14a: astore 8
      // 14c: aload 7
      // 14e: bipush 3
      // 14f: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 154: astore 2
      // 155: aload 10
      // 157: ifnonnull 17a
      // 15a: aload 0
      // 15b: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 15e: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 161: ldc_w "(2)Read invalid user property value, ignoring it"
      // 164: aload 1
      // 165: invokestatic com/google/android/gms/internal/zzchm.a (Ljava/lang/String;)Ljava/lang/Object;
      // 168: aload 2
      // 169: aload 3
      // 16a: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
      // 16d: aload 7
      // 16f: invokeinterface android/database/Cursor.moveToNext ()Z 1
      // 174: ifne 0eb
      // 177: goto 111
      // 17a: new com/google/android/gms/internal/zzclp
      // 17d: astore 8
      // 17f: aload 8
      // 181: aload 1
      // 182: aload 2
      // 183: aload 11
      // 185: lload 4
      // 187: aload 10
      // 189: invokespecial com/google/android/gms/internal/zzclp.<init> (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Object;)V
      // 18c: aload 9
      // 18e: aload 8
      // 190: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 195: pop
      // 196: goto 16d
      // 199: astore 8
      // 19b: aload 7
      // 19d: astore 3
      // 19e: aload 8
      // 1a0: astore 7
      // 1a2: aload 0
      // 1a3: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 1a6: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 1a9: ldc_w "(2)Error querying user properties"
      // 1ac: aload 1
      // 1ad: invokestatic com/google/android/gms/internal/zzchm.a (Ljava/lang/String;)Ljava/lang/Object;
      // 1b0: aload 2
      // 1b1: aload 7
      // 1b3: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
      // 1b6: aload 3
      // 1b7: ifnull 1c0
      // 1ba: aload 3
      // 1bb: invokeinterface android/database/Cursor.close ()V 1
      // 1c0: aconst_null
      // 1c1: astore 1
      // 1c2: goto 0e9
      // 1c5: astore 1
      // 1c6: aload 8
      // 1c8: astore 2
      // 1c9: aload 2
      // 1ca: ifnull 1d3
      // 1cd: aload 2
      // 1ce: invokeinterface android/database/Cursor.close ()V 1
      // 1d3: aload 1
      // 1d4: athrow
      // 1d5: astore 1
      // 1d6: aload 7
      // 1d8: astore 2
      // 1d9: goto 1c9
      // 1dc: astore 1
      // 1dd: aload 3
      // 1de: astore 2
      // 1df: goto 1c9
      // 1e2: astore 7
      // 1e4: aconst_null
      // 1e5: astore 3
      // 1e6: goto 1a2
      // 1e9: astore 2
      // 1ea: aload 7
      // 1ec: astore 3
      // 1ed: aload 2
      // 1ee: astore 7
      // 1f0: aload 8
      // 1f2: astore 2
      // 1f3: goto 1a2
      // try (13 -> 38): 222 android/database/sqlite/SQLiteException
      // try (13 -> 38): 205 null
      // try (38 -> 52): 222 android/database/sqlite/SQLiteException
      // try (38 -> 52): 205 null
      // try (52 -> 93): 222 android/database/sqlite/SQLiteException
      // try (52 -> 93): 205 null
      // try (95 -> 98): 226 android/database/sqlite/SQLiteException
      // try (95 -> 98): 214 null
      // try (110 -> 114): 226 android/database/sqlite/SQLiteException
      // try (110 -> 114): 214 null
      // try (116 -> 123): 226 android/database/sqlite/SQLiteException
      // try (116 -> 123): 214 null
      // try (132 -> 136): 226 android/database/sqlite/SQLiteException
      // try (132 -> 136): 214 null
      // try (138 -> 142): 226 android/database/sqlite/SQLiteException
      // try (138 -> 142): 214 null
      // try (144 -> 149): 226 android/database/sqlite/SQLiteException
      // try (144 -> 149): 214 null
      // try (151 -> 155): 226 android/database/sqlite/SQLiteException
      // try (151 -> 155): 214 null
      // try (157 -> 166): 184 android/database/sqlite/SQLiteException
      // try (157 -> 166): 214 null
      // try (166 -> 169): 184 android/database/sqlite/SQLiteException
      // try (166 -> 169): 214 null
      // try (170 -> 183): 184 android/database/sqlite/SQLiteException
      // try (170 -> 183): 214 null
      // try (189 -> 198): 218 null
   }

   public final List<zzcgl> a(String param1, String[] param2) {
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
      // 005: invokevirtual com/google/android/gms/internal/zzcjl.Q ()V
      // 008: new java/util/ArrayList
      // 00b: dup
      // 00c: invokespecial java/util/ArrayList.<init> ()V
      // 00f: astore 12
      // 011: aload 0
      // 012: invokevirtual com/google/android/gms/internal/zzcgo.A ()Landroid/database/sqlite/SQLiteDatabase;
      // 015: ldc_w "conditional_properties"
      // 018: bipush 13
      // 01a: anewarray 19
      // 01d: dup
      // 01e: bipush 0
      // 01f: ldc_w "app_id"
      // 022: aastore
      // 023: dup
      // 024: bipush 1
      // 025: ldc "origin"
      // 027: aastore
      // 028: dup
      // 029: bipush 2
      // 02a: ldc_w "name"
      // 02d: aastore
      // 02e: dup
      // 02f: bipush 3
      // 030: ldc_w "value"
      // 033: aastore
      // 034: dup
      // 035: bipush 4
      // 036: ldc_w "active"
      // 039: aastore
      // 03a: dup
      // 03b: bipush 5
      // 03c: ldc_w "trigger_event_name"
      // 03f: aastore
      // 040: dup
      // 041: bipush 6
      // 043: ldc_w "trigger_timeout"
      // 046: aastore
      // 047: dup
      // 048: bipush 7
      // 04a: ldc_w "timed_out_event"
      // 04d: aastore
      // 04e: dup
      // 04f: bipush 8
      // 051: ldc_w "creation_timestamp"
      // 054: aastore
      // 055: dup
      // 056: bipush 9
      // 058: ldc_w "triggered_event"
      // 05b: aastore
      // 05c: dup
      // 05d: bipush 10
      // 05f: ldc_w "triggered_timestamp"
      // 062: aastore
      // 063: dup
      // 064: bipush 11
      // 066: ldc_w "time_to_live"
      // 069: aastore
      // 06a: dup
      // 06b: bipush 12
      // 06d: ldc_w "expired_event"
      // 070: aastore
      // 071: aload 1
      // 072: aload 2
      // 073: aconst_null
      // 074: aconst_null
      // 075: ldc_w "rowid"
      // 078: ldc_w "1001"
      // 07b: invokevirtual android/database/sqlite/SQLiteDatabase.query (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      // 07e: astore 1
      // 07f: aload 1
      // 080: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 085: istore 11
      // 087: iload 11
      // 089: ifne 09b
      // 08c: aload 1
      // 08d: ifnull 096
      // 090: aload 1
      // 091: invokeinterface android/database/Cursor.close ()V 1
      // 096: aload 12
      // 098: astore 2
      // 099: aload 2
      // 09a: areturn
      // 09b: aload 12
      // 09d: invokeinterface java/util/List.size ()I 1
      // 0a2: sipush 1000
      // 0a5: if_icmplt 0cb
      // 0a8: aload 0
      // 0a9: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 0ac: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 0af: ldc_w "Read more than the max allowed conditional properties, ignoring extra"
      // 0b2: sipush 1000
      // 0b5: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 0b8: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;)V
      // 0bb: aload 1
      // 0bc: ifnull 0c5
      // 0bf: aload 1
      // 0c0: invokeinterface android/database/Cursor.close ()V 1
      // 0c5: aload 12
      // 0c7: astore 2
      // 0c8: goto 099
      // 0cb: aload 1
      // 0cc: bipush 0
      // 0cd: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 0d2: astore 14
      // 0d4: aload 1
      // 0d5: bipush 1
      // 0d6: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 0db: astore 15
      // 0dd: aload 1
      // 0de: bipush 2
      // 0df: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 0e4: astore 20
      // 0e6: aload 0
      // 0e7: aload 1
      // 0e8: bipush 3
      // 0e9: invokespecial com/google/android/gms/internal/zzcgo.a (Landroid/database/Cursor;I)Ljava/lang/Object;
      // 0ec: astore 19
      // 0ee: aload 1
      // 0ef: bipush 4
      // 0f0: invokeinterface android/database/Cursor.getInt (I)I 2
      // 0f5: ifeq 1b9
      // 0f8: bipush 1
      // 0f9: istore 11
      // 0fb: aload 1
      // 0fc: bipush 5
      // 0fd: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 102: astore 13
      // 104: aload 1
      // 105: bipush 6
      // 107: invokeinterface android/database/Cursor.getLong (I)J 2
      // 10c: lstore 9
      // 10e: aload 0
      // 10f: invokevirtual com/google/android/gms/internal/zzcjk.p ()Lcom/google/android/gms/internal/zzclq;
      // 112: aload 1
      // 113: bipush 7
      // 115: invokeinterface android/database/Cursor.getBlob (I)[B 2
      // 11a: getstatic com/google/android/gms/internal/zzcha.CREATOR Landroid/os/Parcelable$Creator;
      // 11d: invokevirtual com/google/android/gms/internal/zzclq.a ([BLandroid/os/Parcelable$Creator;)Landroid/os/Parcelable;
      // 120: checkcast com/google/android/gms/internal/zzcha
      // 123: astore 16
      // 125: aload 1
      // 126: bipush 8
      // 128: invokeinterface android/database/Cursor.getLong (I)J 2
      // 12d: lstore 5
      // 12f: aload 0
      // 130: invokevirtual com/google/android/gms/internal/zzcjk.p ()Lcom/google/android/gms/internal/zzclq;
      // 133: aload 1
      // 134: bipush 9
      // 136: invokeinterface android/database/Cursor.getBlob (I)[B 2
      // 13b: getstatic com/google/android/gms/internal/zzcha.CREATOR Landroid/os/Parcelable$Creator;
      // 13e: invokevirtual com/google/android/gms/internal/zzclq.a ([BLandroid/os/Parcelable$Creator;)Landroid/os/Parcelable;
      // 141: checkcast com/google/android/gms/internal/zzcha
      // 144: astore 2
      // 145: aload 1
      // 146: bipush 10
      // 148: invokeinterface android/database/Cursor.getLong (I)J 2
      // 14d: lstore 3
      // 14e: aload 1
      // 14f: bipush 11
      // 151: invokeinterface android/database/Cursor.getLong (I)J 2
      // 156: lstore 7
      // 158: aload 0
      // 159: invokevirtual com/google/android/gms/internal/zzcjk.p ()Lcom/google/android/gms/internal/zzclq;
      // 15c: aload 1
      // 15d: bipush 12
      // 15f: invokeinterface android/database/Cursor.getBlob (I)[B 2
      // 164: getstatic com/google/android/gms/internal/zzcha.CREATOR Landroid/os/Parcelable$Creator;
      // 167: invokevirtual com/google/android/gms/internal/zzclq.a ([BLandroid/os/Parcelable$Creator;)Landroid/os/Parcelable;
      // 16a: checkcast com/google/android/gms/internal/zzcha
      // 16d: astore 17
      // 16f: new com/google/android/gms/internal/zzcln
      // 172: astore 18
      // 174: aload 18
      // 176: aload 20
      // 178: lload 3
      // 179: aload 19
      // 17b: aload 15
      // 17d: invokespecial com/google/android/gms/internal/zzcln.<init> (Ljava/lang/String;JLjava/lang/Object;Ljava/lang/String;)V
      // 180: new com/google/android/gms/internal/zzcgl
      // 183: astore 19
      // 185: aload 19
      // 187: aload 14
      // 189: aload 15
      // 18b: aload 18
      // 18d: lload 5
      // 18f: iload 11
      // 191: aload 13
      // 193: aload 16
      // 195: lload 9
      // 197: aload 2
      // 198: lload 7
      // 19a: aload 17
      // 19c: invokespecial com/google/android/gms/internal/zzcgl.<init> (Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gms/internal/zzcln;JZLjava/lang/String;Lcom/google/android/gms/internal/zzcha;JLcom/google/android/gms/internal/zzcha;JLcom/google/android/gms/internal/zzcha;)V
      // 19f: aload 12
      // 1a1: aload 19
      // 1a3: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 1a8: pop
      // 1a9: aload 1
      // 1aa: invokeinterface android/database/Cursor.moveToNext ()Z 1
      // 1af: istore 11
      // 1b1: iload 11
      // 1b3: ifne 09b
      // 1b6: goto 0bb
      // 1b9: bipush 0
      // 1ba: istore 11
      // 1bc: goto 0fb
      // 1bf: astore 2
      // 1c0: aconst_null
      // 1c1: astore 1
      // 1c2: aload 0
      // 1c3: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 1c6: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 1c9: ldc_w "Error querying conditional user property value"
      // 1cc: aload 2
      // 1cd: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;)V
      // 1d0: invokestatic java/util/Collections.emptyList ()Ljava/util/List;
      // 1d3: astore 12
      // 1d5: aload 12
      // 1d7: astore 2
      // 1d8: aload 1
      // 1d9: ifnull 099
      // 1dc: aload 1
      // 1dd: invokeinterface android/database/Cursor.close ()V 1
      // 1e2: aload 12
      // 1e4: astore 2
      // 1e5: goto 099
      // 1e8: astore 2
      // 1e9: aconst_null
      // 1ea: astore 1
      // 1eb: aload 1
      // 1ec: ifnull 1f5
      // 1ef: aload 1
      // 1f0: invokeinterface android/database/Cursor.close ()V 1
      // 1f5: aload 2
      // 1f6: athrow
      // 1f7: astore 2
      // 1f8: goto 1eb
      // 1fb: astore 2
      // 1fc: goto 1eb
      // 1ff: astore 2
      // 200: goto 1c2
      // try (8 -> 73): 210 android/database/sqlite/SQLiteException
      // try (8 -> 73): 230 null
      // try (73 -> 76): 243 android/database/sqlite/SQLiteException
      // try (73 -> 76): 239 null
      // try (86 -> 97): 243 android/database/sqlite/SQLiteException
      // try (86 -> 97): 239 null
      // try (104 -> 125): 243 android/database/sqlite/SQLiteException
      // try (104 -> 125): 239 null
      // try (127 -> 204): 243 android/database/sqlite/SQLiteException
      // try (127 -> 204): 239 null
      // try (213 -> 221): 241 null
   }

   public final void a(zzcgh var1) {
      zzbq.a(var1);
      this.c();
      this.Q();
      ContentValues var3 = new ContentValues();
      var3.put("app_id", var1.b());
      var3.put("app_instance_id", var1.c());
      var3.put("gmp_app_id", var1.d());
      var3.put("resettable_device_id_hash", var1.e());
      var3.put("last_bundle_index", var1.o());
      var3.put("last_bundle_start_timestamp", var1.g());
      var3.put("last_bundle_end_timestamp", var1.h());
      var3.put("app_version", var1.i());
      var3.put("app_store", var1.k());
      var3.put("gmp_version", var1.l());
      var3.put("dev_cert_hash", var1.m());
      var3.put("measurement_enabled", var1.n());
      var3.put("day", var1.s());
      var3.put("daily_public_events_count", var1.t());
      var3.put("daily_events_count", var1.u());
      var3.put("daily_conversions_count", var1.v());
      var3.put("config_fetched_time", var1.p());
      var3.put("failed_config_fetch_time", var1.q());
      var3.put("app_version_int", var1.j());
      var3.put("firebase_instance_id", var1.f());
      var3.put("daily_error_events_count", var1.x());
      var3.put("daily_realtime_events_count", var1.w());
      var3.put("health_monitor_sample", var1.y());
      var3.put("android_id", var1.A());
      var3.put("adid_reporting_enabled", var1.B());

      try {
         SQLiteDatabase var2 = this.A();
         if (var2.update("apps", var3, "app_id = ?", new String[]{var1.b()}) == 0L && var2.insertWithOnConflict("apps", null, var3, 5) == -1L) {
            this.t().y().a("Failed to insert/update app (got -1). appId", zzchm.a(var1.b()));
         }
      } catch (SQLiteException var4) {
         this.t().y().a("Error storing app. appId", zzchm.a(var1.b()), var4);
      }
   }

   public final void a(zzcgw var1) {
      Object var3 = null;
      zzbq.a(var1);
      this.c();
      this.Q();
      ContentValues var4 = new ContentValues();
      var4.put("app_id", var1.a);
      var4.put("name", var1.b);
      var4.put("lifetime_count", var1.c);
      var4.put("current_bundle_count", var1.d);
      var4.put("last_fire_timestamp", var1.e);
      var4.put("last_bundled_timestamp", var1.f);
      var4.put("last_sampled_complex_event_id", var1.g);
      var4.put("last_sampling_rate", var1.h);
      Long var2 = (Long)var3;
      if (var1.i != null) {
         var2 = (Long)var3;
         if (var1.i) {
            var2 = 1L;
         }
      }

      var4.put("last_exempt_from_sampling", var2);

      try {
         if (this.A().insertWithOnConflict("events", null, var4, 5) == -1L) {
            this.t().y().a("Failed to insert/update event aggregates (got -1). appId", zzchm.a(var1.a));
         }
      } catch (SQLiteException var5) {
         this.t().y().a("Error storing event aggregates. appId", zzchm.a(var1.a), var5);
      }
   }

   final void a(String param1, zzclr[] param2) {
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
      // 000: bipush 0
      // 001: istore 7
      // 003: aload 0
      // 004: invokevirtual com/google/android/gms/internal/zzcjl.Q ()V
      // 007: aload 0
      // 008: invokevirtual com/google/android/gms/internal/zzcjk.c ()V
      // 00b: aload 1
      // 00c: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/String;)Ljava/lang/String;
      // 00f: pop
      // 010: aload 2
      // 011: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/Object;)Ljava/lang/Object;
      // 014: pop
      // 015: aload 0
      // 016: invokevirtual com/google/android/gms/internal/zzcgo.A ()Landroid/database/sqlite/SQLiteDatabase;
      // 019: astore 11
      // 01b: aload 11
      // 01d: invokevirtual android/database/sqlite/SQLiteDatabase.beginTransaction ()V
      // 020: aload 0
      // 021: invokevirtual com/google/android/gms/internal/zzcjl.Q ()V
      // 024: aload 0
      // 025: invokevirtual com/google/android/gms/internal/zzcjk.c ()V
      // 028: aload 1
      // 029: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/String;)Ljava/lang/String;
      // 02c: pop
      // 02d: aload 0
      // 02e: invokevirtual com/google/android/gms/internal/zzcgo.A ()Landroid/database/sqlite/SQLiteDatabase;
      // 031: astore 12
      // 033: aload 12
      // 035: ldc_w "property_filters"
      // 038: ldc_w "app_id=?"
      // 03b: bipush 1
      // 03c: anewarray 19
      // 03f: dup
      // 040: bipush 0
      // 041: aload 1
      // 042: aastore
      // 043: invokevirtual android/database/sqlite/SQLiteDatabase.delete (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
      // 046: pop
      // 047: aload 12
      // 049: ldc_w "event_filters"
      // 04c: ldc_w "app_id=?"
      // 04f: bipush 1
      // 050: anewarray 19
      // 053: dup
      // 054: bipush 0
      // 055: aload 1
      // 056: aastore
      // 057: invokevirtual android/database/sqlite/SQLiteDatabase.delete (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
      // 05a: pop
      // 05b: aload 2
      // 05c: arraylength
      // 05d: istore 8
      // 05f: bipush 0
      // 060: istore 4
      // 062: iload 4
      // 064: iload 8
      // 066: if_icmpge 1f4
      // 069: aload 2
      // 06a: iload 4
      // 06c: aaload
      // 06d: astore 12
      // 06f: aload 0
      // 070: invokevirtual com/google/android/gms/internal/zzcjl.Q ()V
      // 073: aload 0
      // 074: invokevirtual com/google/android/gms/internal/zzcjk.c ()V
      // 077: aload 1
      // 078: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/String;)Ljava/lang/String;
      // 07b: pop
      // 07c: aload 12
      // 07e: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/Object;)Ljava/lang/Object;
      // 081: pop
      // 082: aload 12
      // 084: getfield com/google/android/gms/internal/zzclr.c [Lcom/google/android/gms/internal/zzcls;
      // 087: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/Object;)Ljava/lang/Object;
      // 08a: pop
      // 08b: aload 12
      // 08d: getfield com/google/android/gms/internal/zzclr.b [Lcom/google/android/gms/internal/zzclv;
      // 090: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/Object;)Ljava/lang/Object;
      // 093: pop
      // 094: aload 12
      // 096: getfield com/google/android/gms/internal/zzclr.a Ljava/lang/Integer;
      // 099: ifnonnull 0b3
      // 09c: aload 0
      // 09d: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 0a0: invokevirtual com/google/android/gms/internal/zzchm.A ()Lcom/google/android/gms/internal/zzcho;
      // 0a3: ldc_w "Audience with no ID. appId"
      // 0a6: aload 1
      // 0a7: invokestatic com/google/android/gms/internal/zzchm.a (Ljava/lang/String;)Ljava/lang/Object;
      // 0aa: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;)V
      // 0ad: iinc 4 1
      // 0b0: goto 062
      // 0b3: aload 12
      // 0b5: getfield com/google/android/gms/internal/zzclr.a Ljava/lang/Integer;
      // 0b8: invokevirtual java/lang/Integer.intValue ()I
      // 0bb: istore 9
      // 0bd: aload 12
      // 0bf: getfield com/google/android/gms/internal/zzclr.c [Lcom/google/android/gms/internal/zzcls;
      // 0c2: astore 13
      // 0c4: aload 13
      // 0c6: arraylength
      // 0c7: istore 5
      // 0c9: bipush 0
      // 0ca: istore 3
      // 0cb: iload 3
      // 0cc: iload 5
      // 0ce: if_icmpge 102
      // 0d1: aload 13
      // 0d3: iload 3
      // 0d4: aaload
      // 0d5: getfield com/google/android/gms/internal/zzcls.a Ljava/lang/Integer;
      // 0d8: ifnonnull 0fc
      // 0db: aload 0
      // 0dc: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 0df: invokevirtual com/google/android/gms/internal/zzchm.A ()Lcom/google/android/gms/internal/zzcho;
      // 0e2: ldc_w "Event filter with no ID. Audience definition ignored. appId, audienceId"
      // 0e5: aload 1
      // 0e6: invokestatic com/google/android/gms/internal/zzchm.a (Ljava/lang/String;)Ljava/lang/Object;
      // 0e9: aload 12
      // 0eb: getfield com/google/android/gms/internal/zzclr.a Ljava/lang/Integer;
      // 0ee: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
      // 0f1: goto 0ad
      // 0f4: astore 1
      // 0f5: aload 11
      // 0f7: invokevirtual android/database/sqlite/SQLiteDatabase.endTransaction ()V
      // 0fa: aload 1
      // 0fb: athrow
      // 0fc: iinc 3 1
      // 0ff: goto 0cb
      // 102: aload 12
      // 104: getfield com/google/android/gms/internal/zzclr.b [Lcom/google/android/gms/internal/zzclv;
      // 107: astore 13
      // 109: aload 13
      // 10b: arraylength
      // 10c: istore 5
      // 10e: bipush 0
      // 10f: istore 3
      // 110: iload 3
      // 111: iload 5
      // 113: if_icmpge 13f
      // 116: aload 13
      // 118: iload 3
      // 119: aaload
      // 11a: getfield com/google/android/gms/internal/zzclv.a Ljava/lang/Integer;
      // 11d: ifnonnull 139
      // 120: aload 0
      // 121: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 124: invokevirtual com/google/android/gms/internal/zzchm.A ()Lcom/google/android/gms/internal/zzcho;
      // 127: ldc_w "Property filter with no ID. Audience definition ignored. appId, audienceId"
      // 12a: aload 1
      // 12b: invokestatic com/google/android/gms/internal/zzchm.a (Ljava/lang/String;)Ljava/lang/Object;
      // 12e: aload 12
      // 130: getfield com/google/android/gms/internal/zzclr.a Ljava/lang/Integer;
      // 133: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
      // 136: goto 0ad
      // 139: iinc 3 1
      // 13c: goto 110
      // 13f: aload 12
      // 141: getfield com/google/android/gms/internal/zzclr.c [Lcom/google/android/gms/internal/zzcls;
      // 144: astore 13
      // 146: aload 13
      // 148: arraylength
      // 149: istore 5
      // 14b: bipush 0
      // 14c: istore 3
      // 14d: iload 3
      // 14e: iload 5
      // 150: if_icmpge 232
      // 153: aload 0
      // 154: aload 1
      // 155: iload 9
      // 157: aload 13
      // 159: iload 3
      // 15a: aaload
      // 15b: invokespecial com/google/android/gms/internal/zzcgo.a (Ljava/lang/String;ILcom/google/android/gms/internal/zzcls;)Z
      // 15e: ifne 1e8
      // 161: bipush 0
      // 162: istore 3
      // 163: iload 3
      // 164: istore 5
      // 166: iload 3
      // 167: ifeq 195
      // 16a: aload 12
      // 16c: getfield com/google/android/gms/internal/zzclr.b [Lcom/google/android/gms/internal/zzclv;
      // 16f: astore 12
      // 171: aload 12
      // 173: arraylength
      // 174: istore 10
      // 176: bipush 0
      // 177: istore 6
      // 179: iload 3
      // 17a: istore 5
      // 17c: iload 6
      // 17e: iload 10
      // 180: if_icmpge 195
      // 183: aload 0
      // 184: aload 1
      // 185: iload 9
      // 187: aload 12
      // 189: iload 6
      // 18b: aaload
      // 18c: invokespecial com/google/android/gms/internal/zzcgo.a (Ljava/lang/String;ILcom/google/android/gms/internal/zzclv;)Z
      // 18f: ifne 1ee
      // 192: bipush 0
      // 193: istore 5
      // 195: iload 5
      // 197: ifne 0ad
      // 19a: aload 0
      // 19b: invokevirtual com/google/android/gms/internal/zzcjl.Q ()V
      // 19e: aload 0
      // 19f: invokevirtual com/google/android/gms/internal/zzcjk.c ()V
      // 1a2: aload 1
      // 1a3: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/String;)Ljava/lang/String;
      // 1a6: pop
      // 1a7: aload 0
      // 1a8: invokevirtual com/google/android/gms/internal/zzcgo.A ()Landroid/database/sqlite/SQLiteDatabase;
      // 1ab: astore 12
      // 1ad: aload 12
      // 1af: ldc_w "property_filters"
      // 1b2: ldc_w "app_id=? and audience_id=?"
      // 1b5: bipush 2
      // 1b6: anewarray 19
      // 1b9: dup
      // 1ba: bipush 0
      // 1bb: aload 1
      // 1bc: aastore
      // 1bd: dup
      // 1be: bipush 1
      // 1bf: iload 9
      // 1c1: invokestatic java/lang/String.valueOf (I)Ljava/lang/String;
      // 1c4: aastore
      // 1c5: invokevirtual android/database/sqlite/SQLiteDatabase.delete (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
      // 1c8: pop
      // 1c9: aload 12
      // 1cb: ldc_w "event_filters"
      // 1ce: ldc_w "app_id=? and audience_id=?"
      // 1d1: bipush 2
      // 1d2: anewarray 19
      // 1d5: dup
      // 1d6: bipush 0
      // 1d7: aload 1
      // 1d8: aastore
      // 1d9: dup
      // 1da: bipush 1
      // 1db: iload 9
      // 1dd: invokestatic java/lang/String.valueOf (I)Ljava/lang/String;
      // 1e0: aastore
      // 1e1: invokevirtual android/database/sqlite/SQLiteDatabase.delete (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
      // 1e4: pop
      // 1e5: goto 0ad
      // 1e8: iinc 3 1
      // 1eb: goto 14d
      // 1ee: iinc 6 1
      // 1f1: goto 179
      // 1f4: new java/util/ArrayList
      // 1f7: astore 12
      // 1f9: aload 12
      // 1fb: invokespecial java/util/ArrayList.<init> ()V
      // 1fe: aload 2
      // 1ff: arraylength
      // 200: istore 4
      // 202: iload 7
      // 204: istore 3
      // 205: iload 3
      // 206: iload 4
      // 208: if_icmpge 21f
      // 20b: aload 12
      // 20d: aload 2
      // 20e: iload 3
      // 20f: aaload
      // 210: getfield com/google/android/gms/internal/zzclr.a Ljava/lang/Integer;
      // 213: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 218: pop
      // 219: iinc 3 1
      // 21c: goto 205
      // 21f: aload 0
      // 220: aload 1
      // 221: aload 12
      // 223: invokespecial com/google/android/gms/internal/zzcgo.a (Ljava/lang/String;Ljava/util/List;)Z
      // 226: pop
      // 227: aload 11
      // 229: invokevirtual android/database/sqlite/SQLiteDatabase.setTransactionSuccessful ()V
      // 22c: aload 11
      // 22e: invokevirtual android/database/sqlite/SQLiteDatabase.endTransaction ()V
      // 231: return
      // 232: bipush 1
      // 233: istore 3
      // 234: goto 163
      // try (17 -> 52): 121 null
      // try (61 -> 89): 121 null
      // try (91 -> 101): 121 null
      // try (106 -> 120): 121 null
      // try (128 -> 134): 121 null
      // try (139 -> 153): 121 null
      // try (156 -> 162): 121 null
      // try (167 -> 175): 121 null
      // try (181 -> 187): 121 null
      // try (194 -> 202): 121 null
      // try (206 -> 248): 121 null
      // try (253 -> 260): 121 null
      // try (265 -> 272): 121 null
      // try (274 -> 281): 121 null
   }

   public final void a(List<Long> var1) {
      zzbq.a(var1);
      this.c();
      this.Q();
      StringBuilder var3 = new StringBuilder("rowid in (");

      for (int var2 = 0; var2 < var1.size(); var2++) {
         if (var2 != 0) {
            var3.append(",");
         }

         var3.append(((Long)var1.get(var2)).longValue());
      }

      var3.append(")");
      int var4 = this.A().delete("raw_events", var3.toString(), null);
      if (var4 != var1.size()) {
         this.t().y().a("Deleted fewer rows from raw events table than expected", var4, var1.size());
      }
   }

   public final boolean a(zzcgl var1) {
      boolean var2 = false;
      zzbq.a(var1);
      this.c();
      this.Q();
      if (this.c(var1.a, var1.c.a) != null || this.b("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{var1.a}) < 1000L) {
         ContentValues var3 = new ContentValues();
         var3.put("app_id", var1.a);
         var3.put("origin", var1.b);
         var3.put("name", var1.c.a);
         a(var3, "value", var1.c.a());
         var3.put("active", var1.e);
         var3.put("trigger_event_name", var1.f);
         var3.put("trigger_timeout", var1.h);
         this.p();
         var3.put("timed_out_event", zzclq.a(var1.g));
         var3.put("creation_timestamp", var1.d);
         this.p();
         var3.put("triggered_event", zzclq.a(var1.i));
         var3.put("triggered_timestamp", var1.c.b);
         var3.put("time_to_live", var1.j);
         this.p();
         var3.put("expired_event", zzclq.a(var1.k));

         try {
            if (this.A().insertWithOnConflict("conditional_properties", null, var3, 5) == -1L) {
               this.t().y().a("Failed to insert/update conditional user property (got -1)", zzchm.a(var1.a));
            }
         } catch (SQLiteException var4) {
            this.t().y().a("Error storing conditional user property", zzchm.a(var1.a), var4);
         }

         var2 = true;
      }

      return var2;
   }

   public final boolean a(zzcgv var1, long var2, boolean var4) {
      boolean var6 = false;
      this.c();
      this.Q();
      zzbq.a(var1);
      zzbq.a(var1.a);
      zzcmb var7 = new zzcmb();
      var7.d = var1.d;
      var7.a = new zzcmc[var1.e.a()];
      Iterator var8 = var1.e.iterator();

      for (int var5 = 0; var8.hasNext(); var5++) {
         String var10 = (String)var8.next();
         zzcmc var9 = new zzcmc();
         var7.a[var5] = var9;
         var9.a = var10;
         Object var18 = var1.e.a(var10);
         this.p().a(var9, var18);
      }

      try {
         var16 = new byte[var7.f()];
         zzfjk var17 = zzfjk.a(var16, 0, var16.length);
         var7.a(var17);
         var17.a();
      } catch (IOException var12) {
         this.t().y().a("Data loss. Failed to serialize event params/data. appId", zzchm.a(var1.a), var12);
         return var6;
      }

      this.t().E().a("Saving event, name, data size", this.o().a(var1.b), var16.length);
      ContentValues var15 = new ContentValues();
      var15.put("app_id", var1.a);
      var15.put("name", var1.b);
      var15.put("timestamp", var1.c);
      var15.put("metadata_fingerprint", var2);
      var15.put("data", var16);
      byte var14;
      if (var4) {
         var14 = 1;
      } else {
         var14 = 0;
      }

      var15.put("realtime", Integer.valueOf(var14));

      try {
         if (this.A().insert("raw_events", null, var15) == -1L) {
            this.t().y().a("Failed to insert raw event (got -1). appId", zzchm.a(var1.a));
            return var6;
         }
      } catch (SQLiteException var11) {
         this.t().y().a("Error storing raw event. appId", zzchm.a(var1.a), var11);
         return var6;
      }

      return true;
   }

   public final boolean a(zzclp var1) {
      boolean var2 = false;
      zzbq.a(var1);
      this.c();
      this.Q();
      if (this.c(var1.a, var1.c) != null
         || (
            zzclq.a(var1.c)
               ? this.b("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{var1.a}) < 25L
               : this.b("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{var1.a, var1.b}) < 25L
         )) {
         ContentValues var3 = new ContentValues();
         var3.put("app_id", var1.a);
         var3.put("origin", var1.b);
         var3.put("name", var1.c);
         var3.put("set_timestamp", var1.d);
         a(var3, "value", var1.e);

         try {
            if (this.A().insertWithOnConflict("user_attributes", null, var3, 5) == -1L) {
               this.t().y().a("Failed to insert/update user property (got -1). appId", zzchm.a(var1.a));
            }
         } catch (SQLiteException var4) {
            this.t().y().a("Error storing user property. appId", zzchm.a(var1.a), var4);
         }

         var2 = true;
      }

      return var2;
   }

   public final boolean a(zzcme var1, boolean var2) {
      boolean var6 = false;
      this.c();
      this.Q();
      zzbq.a(var1);
      zzbq.a(var1.o);
      zzbq.a(var1.f);
      this.D();
      long var4 = this.k().a();
      if (var1.f < var4 - zzcgn.y() || var1.f > zzcgn.y() + var4) {
         this.t().A().a("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzchm.a(var1.o), var4, var1.f);
      }

      byte[] var13;
      try {
         var13 = new byte[var1.f()];
         zzfjk var7 = zzfjk.a(var13, 0, var13.length);
         var1.a(var7);
         var7.a();
         var13 = this.p().a(var13);
      } catch (IOException var10) {
         this.t().y().a("Data loss. Failed to serialize bundle. appId", zzchm.a(var1.o), var10);
         return var6;
      }

      this.t().E().a("Saving bundle, size", var13.length);
      ContentValues var12 = new ContentValues();
      var12.put("app_id", var1.o);
      var12.put("bundle_end_timestamp", var1.f);
      var12.put("data", var13);
      byte var3;
      if (var2) {
         var3 = 1;
      } else {
         var3 = 0;
      }

      var12.put("has_realtime", Integer.valueOf(var3));

      try {
         if (this.A().insert("queue", null, var12) == -1L) {
            this.t().y().a("Failed to insert bundle (got -1). appId", zzchm.a(var1.o));
            return var6;
         }
      } catch (SQLiteException var9) {
         this.t().y().a("Error storing bundle. appId", zzchm.a(var1.o), var9);
         return var6;
      }

      return true;
   }

   public final zzcgh b(String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aload 1
      // 001: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/String;)Ljava/lang/String;
      // 004: pop
      // 005: aload 0
      // 006: invokevirtual com/google/android/gms/internal/zzcjk.c ()V
      // 009: aload 0
      // 00a: invokevirtual com/google/android/gms/internal/zzcjl.Q ()V
      // 00d: aload 0
      // 00e: invokevirtual com/google/android/gms/internal/zzcgo.A ()Landroid/database/sqlite/SQLiteDatabase;
      // 011: ldc_w "apps"
      // 014: bipush 24
      // 016: anewarray 19
      // 019: dup
      // 01a: bipush 0
      // 01b: ldc_w "app_instance_id"
      // 01e: aastore
      // 01f: dup
      // 020: bipush 1
      // 021: ldc_w "gmp_app_id"
      // 024: aastore
      // 025: dup
      // 026: bipush 2
      // 027: ldc_w "resettable_device_id_hash"
      // 02a: aastore
      // 02b: dup
      // 02c: bipush 3
      // 02d: ldc_w "last_bundle_index"
      // 030: aastore
      // 031: dup
      // 032: bipush 4
      // 033: ldc "last_bundle_start_timestamp"
      // 035: aastore
      // 036: dup
      // 037: bipush 5
      // 038: ldc_w "last_bundle_end_timestamp"
      // 03b: aastore
      // 03c: dup
      // 03d: bipush 6
      // 03f: ldc "app_version"
      // 041: aastore
      // 042: dup
      // 043: bipush 7
      // 045: ldc "app_store"
      // 047: aastore
      // 048: dup
      // 049: bipush 8
      // 04b: ldc "gmp_version"
      // 04d: aastore
      // 04e: dup
      // 04f: bipush 9
      // 051: ldc "dev_cert_hash"
      // 053: aastore
      // 054: dup
      // 055: bipush 10
      // 057: ldc "measurement_enabled"
      // 059: aastore
      // 05a: dup
      // 05b: bipush 11
      // 05d: ldc "day"
      // 05f: aastore
      // 060: dup
      // 061: bipush 12
      // 063: ldc "daily_public_events_count"
      // 065: aastore
      // 066: dup
      // 067: bipush 13
      // 069: ldc "daily_events_count"
      // 06b: aastore
      // 06c: dup
      // 06d: bipush 14
      // 06f: ldc "daily_conversions_count"
      // 071: aastore
      // 072: dup
      // 073: bipush 15
      // 075: ldc "config_fetched_time"
      // 077: aastore
      // 078: dup
      // 079: bipush 16
      // 07b: ldc "failed_config_fetch_time"
      // 07d: aastore
      // 07e: dup
      // 07f: bipush 17
      // 081: ldc "app_version_int"
      // 083: aastore
      // 084: dup
      // 085: bipush 18
      // 087: ldc "firebase_instance_id"
      // 089: aastore
      // 08a: dup
      // 08b: bipush 19
      // 08d: ldc "daily_error_events_count"
      // 08f: aastore
      // 090: dup
      // 091: bipush 20
      // 093: ldc "daily_realtime_events_count"
      // 095: aastore
      // 096: dup
      // 097: bipush 21
      // 099: ldc "health_monitor_sample"
      // 09b: aastore
      // 09c: dup
      // 09d: bipush 22
      // 09f: ldc "android_id"
      // 0a1: aastore
      // 0a2: dup
      // 0a3: bipush 23
      // 0a5: ldc "adid_reporting_enabled"
      // 0a7: aastore
      // 0a8: ldc_w "app_id=?"
      // 0ab: bipush 1
      // 0ac: anewarray 19
      // 0af: dup
      // 0b0: bipush 0
      // 0b1: aload 1
      // 0b2: aastore
      // 0b3: aconst_null
      // 0b4: aconst_null
      // 0b5: aconst_null
      // 0b6: invokevirtual android/database/sqlite/SQLiteDatabase.query (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      // 0b9: astore 6
      // 0bb: aload 6
      // 0bd: astore 5
      // 0bf: aload 6
      // 0c1: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 0c6: istore 2
      // 0c7: iload 2
      // 0c8: ifne 0db
      // 0cb: aload 6
      // 0cd: ifnull 0d7
      // 0d0: aload 6
      // 0d2: invokeinterface android/database/Cursor.close ()V 1
      // 0d7: aconst_null
      // 0d8: astore 1
      // 0d9: aload 1
      // 0da: areturn
      // 0db: aload 6
      // 0dd: astore 5
      // 0df: new com/google/android/gms/internal/zzcgh
      // 0e2: astore 7
      // 0e4: aload 6
      // 0e6: astore 5
      // 0e8: aload 7
      // 0ea: aload 0
      // 0eb: getfield com/google/android/gms/internal/zzcgo.p Lcom/google/android/gms/internal/zzcim;
      // 0ee: aload 1
      // 0ef: invokespecial com/google/android/gms/internal/zzcgh.<init> (Lcom/google/android/gms/internal/zzcim;Ljava/lang/String;)V
      // 0f2: aload 6
      // 0f4: astore 5
      // 0f6: aload 7
      // 0f8: aload 6
      // 0fa: bipush 0
      // 0fb: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 100: invokevirtual com/google/android/gms/internal/zzcgh.a (Ljava/lang/String;)V
      // 103: aload 6
      // 105: astore 5
      // 107: aload 7
      // 109: aload 6
      // 10b: bipush 1
      // 10c: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 111: invokevirtual com/google/android/gms/internal/zzcgh.b (Ljava/lang/String;)V
      // 114: aload 6
      // 116: astore 5
      // 118: aload 7
      // 11a: aload 6
      // 11c: bipush 2
      // 11d: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 122: invokevirtual com/google/android/gms/internal/zzcgh.c (Ljava/lang/String;)V
      // 125: aload 6
      // 127: astore 5
      // 129: aload 7
      // 12b: aload 6
      // 12d: bipush 3
      // 12e: invokeinterface android/database/Cursor.getLong (I)J 2
      // 133: invokevirtual com/google/android/gms/internal/zzcgh.f (J)V
      // 136: aload 6
      // 138: astore 5
      // 13a: aload 7
      // 13c: aload 6
      // 13e: bipush 4
      // 13f: invokeinterface android/database/Cursor.getLong (I)J 2
      // 144: invokevirtual com/google/android/gms/internal/zzcgh.a (J)V
      // 147: aload 6
      // 149: astore 5
      // 14b: aload 7
      // 14d: aload 6
      // 14f: bipush 5
      // 150: invokeinterface android/database/Cursor.getLong (I)J 2
      // 155: invokevirtual com/google/android/gms/internal/zzcgh.b (J)V
      // 158: aload 6
      // 15a: astore 5
      // 15c: aload 7
      // 15e: aload 6
      // 160: bipush 6
      // 162: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 167: invokevirtual com/google/android/gms/internal/zzcgh.e (Ljava/lang/String;)V
      // 16a: aload 6
      // 16c: astore 5
      // 16e: aload 7
      // 170: aload 6
      // 172: bipush 7
      // 174: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 179: invokevirtual com/google/android/gms/internal/zzcgh.f (Ljava/lang/String;)V
      // 17c: aload 6
      // 17e: astore 5
      // 180: aload 7
      // 182: aload 6
      // 184: bipush 8
      // 186: invokeinterface android/database/Cursor.getLong (I)J 2
      // 18b: invokevirtual com/google/android/gms/internal/zzcgh.d (J)V
      // 18e: aload 6
      // 190: astore 5
      // 192: aload 7
      // 194: aload 6
      // 196: bipush 9
      // 198: invokeinterface android/database/Cursor.getLong (I)J 2
      // 19d: invokevirtual com/google/android/gms/internal/zzcgh.e (J)V
      // 1a0: aload 6
      // 1a2: astore 5
      // 1a4: aload 6
      // 1a6: bipush 10
      // 1a8: invokeinterface android/database/Cursor.isNull (I)Z 2
      // 1ad: ifne 1c0
      // 1b0: aload 6
      // 1b2: astore 5
      // 1b4: aload 6
      // 1b6: bipush 10
      // 1b8: invokeinterface android/database/Cursor.getInt (I)I 2
      // 1bd: ifeq 327
      // 1c0: bipush 1
      // 1c1: istore 2
      // 1c2: aload 6
      // 1c4: astore 5
      // 1c6: aload 7
      // 1c8: iload 2
      // 1c9: invokevirtual com/google/android/gms/internal/zzcgh.a (Z)V
      // 1cc: aload 6
      // 1ce: astore 5
      // 1d0: aload 7
      // 1d2: aload 6
      // 1d4: bipush 11
      // 1d6: invokeinterface android/database/Cursor.getLong (I)J 2
      // 1db: invokevirtual com/google/android/gms/internal/zzcgh.i (J)V
      // 1de: aload 6
      // 1e0: astore 5
      // 1e2: aload 7
      // 1e4: aload 6
      // 1e6: bipush 12
      // 1e8: invokeinterface android/database/Cursor.getLong (I)J 2
      // 1ed: invokevirtual com/google/android/gms/internal/zzcgh.j (J)V
      // 1f0: aload 6
      // 1f2: astore 5
      // 1f4: aload 7
      // 1f6: aload 6
      // 1f8: bipush 13
      // 1fa: invokeinterface android/database/Cursor.getLong (I)J 2
      // 1ff: invokevirtual com/google/android/gms/internal/zzcgh.k (J)V
      // 202: aload 6
      // 204: astore 5
      // 206: aload 7
      // 208: aload 6
      // 20a: bipush 14
      // 20c: invokeinterface android/database/Cursor.getLong (I)J 2
      // 211: invokevirtual com/google/android/gms/internal/zzcgh.l (J)V
      // 214: aload 6
      // 216: astore 5
      // 218: aload 7
      // 21a: aload 6
      // 21c: bipush 15
      // 21e: invokeinterface android/database/Cursor.getLong (I)J 2
      // 223: invokevirtual com/google/android/gms/internal/zzcgh.g (J)V
      // 226: aload 6
      // 228: astore 5
      // 22a: aload 7
      // 22c: aload 6
      // 22e: bipush 16
      // 230: invokeinterface android/database/Cursor.getLong (I)J 2
      // 235: invokevirtual com/google/android/gms/internal/zzcgh.h (J)V
      // 238: aload 6
      // 23a: astore 5
      // 23c: aload 6
      // 23e: bipush 17
      // 240: invokeinterface android/database/Cursor.isNull (I)Z 2
      // 245: ifeq 32c
      // 248: ldc2_w -2147483648
      // 24b: lstore 3
      // 24c: aload 6
      // 24e: astore 5
      // 250: aload 7
      // 252: lload 3
      // 253: invokevirtual com/google/android/gms/internal/zzcgh.c (J)V
      // 256: aload 6
      // 258: astore 5
      // 25a: aload 7
      // 25c: aload 6
      // 25e: bipush 18
      // 260: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 265: invokevirtual com/google/android/gms/internal/zzcgh.d (Ljava/lang/String;)V
      // 268: aload 6
      // 26a: astore 5
      // 26c: aload 7
      // 26e: aload 6
      // 270: bipush 19
      // 272: invokeinterface android/database/Cursor.getLong (I)J 2
      // 277: invokevirtual com/google/android/gms/internal/zzcgh.n (J)V
      // 27a: aload 6
      // 27c: astore 5
      // 27e: aload 7
      // 280: aload 6
      // 282: bipush 20
      // 284: invokeinterface android/database/Cursor.getLong (I)J 2
      // 289: invokevirtual com/google/android/gms/internal/zzcgh.m (J)V
      // 28c: aload 6
      // 28e: astore 5
      // 290: aload 7
      // 292: aload 6
      // 294: bipush 21
      // 296: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 29b: invokevirtual com/google/android/gms/internal/zzcgh.g (Ljava/lang/String;)V
      // 29e: aload 6
      // 2a0: astore 5
      // 2a2: aload 6
      // 2a4: bipush 22
      // 2a6: invokeinterface android/database/Cursor.isNull (I)Z 2
      // 2ab: ifeq 33e
      // 2ae: lconst_0
      // 2af: lstore 3
      // 2b0: aload 6
      // 2b2: astore 5
      // 2b4: aload 7
      // 2b6: lload 3
      // 2b7: invokevirtual com/google/android/gms/internal/zzcgh.o (J)V
      // 2ba: aload 6
      // 2bc: astore 5
      // 2be: aload 6
      // 2c0: bipush 23
      // 2c2: invokeinterface android/database/Cursor.isNull (I)Z 2
      // 2c7: ifne 2da
      // 2ca: aload 6
      // 2cc: astore 5
      // 2ce: aload 6
      // 2d0: bipush 23
      // 2d2: invokeinterface android/database/Cursor.getInt (I)I 2
      // 2d7: ifeq 34f
      // 2da: bipush 1
      // 2db: istore 2
      // 2dc: aload 6
      // 2de: astore 5
      // 2e0: aload 7
      // 2e2: iload 2
      // 2e3: invokevirtual com/google/android/gms/internal/zzcgh.b (Z)V
      // 2e6: aload 6
      // 2e8: astore 5
      // 2ea: aload 7
      // 2ec: invokevirtual com/google/android/gms/internal/zzcgh.a ()V
      // 2ef: aload 6
      // 2f1: astore 5
      // 2f3: aload 6
      // 2f5: invokeinterface android/database/Cursor.moveToNext ()Z 1
      // 2fa: ifeq 312
      // 2fd: aload 6
      // 2ff: astore 5
      // 301: aload 0
      // 302: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 305: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 308: ldc_w "Got multiple records for app, expected one. appId"
      // 30b: aload 1
      // 30c: invokestatic com/google/android/gms/internal/zzchm.a (Ljava/lang/String;)Ljava/lang/Object;
      // 30f: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;)V
      // 312: aload 7
      // 314: astore 1
      // 315: aload 6
      // 317: ifnull 0d9
      // 31a: aload 6
      // 31c: invokeinterface android/database/Cursor.close ()V 1
      // 321: aload 7
      // 323: astore 1
      // 324: goto 0d9
      // 327: bipush 0
      // 328: istore 2
      // 329: goto 1c2
      // 32c: aload 6
      // 32e: astore 5
      // 330: aload 6
      // 332: bipush 17
      // 334: invokeinterface android/database/Cursor.getInt (I)I 2
      // 339: i2l
      // 33a: lstore 3
      // 33b: goto 24c
      // 33e: aload 6
      // 340: astore 5
      // 342: aload 6
      // 344: bipush 22
      // 346: invokeinterface android/database/Cursor.getLong (I)J 2
      // 34b: lstore 3
      // 34c: goto 2b0
      // 34f: bipush 0
      // 350: istore 2
      // 351: goto 2dc
      // 354: astore 7
      // 356: aconst_null
      // 357: astore 6
      // 359: aload 6
      // 35b: astore 5
      // 35d: aload 0
      // 35e: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 361: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 364: ldc_w "Error querying app. appId"
      // 367: aload 1
      // 368: invokestatic com/google/android/gms/internal/zzchm.a (Ljava/lang/String;)Ljava/lang/Object;
      // 36b: aload 7
      // 36d: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
      // 370: aload 6
      // 372: ifnull 37c
      // 375: aload 6
      // 377: invokeinterface android/database/Cursor.close ()V 1
      // 37c: aconst_null
      // 37d: astore 1
      // 37e: goto 0d9
      // 381: astore 1
      // 382: aconst_null
      // 383: astore 5
      // 385: aload 5
      // 387: ifnull 391
      // 38a: aload 5
      // 38c: invokeinterface android/database/Cursor.close ()V 1
      // 391: aload 1
      // 392: athrow
      // 393: astore 1
      // 394: goto 385
      // 397: astore 7
      // 399: goto 359
      // try (7 -> 120): 398 android/database/sqlite/SQLiteException
      // try (7 -> 120): 418 null
      // try (122 -> 125): 429 android/database/sqlite/SQLiteException
      // try (122 -> 125): 427 null
      // try (137 -> 139): 429 android/database/sqlite/SQLiteException
      // try (137 -> 139): 427 null
      // try (141 -> 146): 429 android/database/sqlite/SQLiteException
      // try (141 -> 146): 427 null
      // try (148 -> 153): 429 android/database/sqlite/SQLiteException
      // try (148 -> 153): 427 null
      // try (155 -> 160): 429 android/database/sqlite/SQLiteException
      // try (155 -> 160): 427 null
      // try (162 -> 167): 429 android/database/sqlite/SQLiteException
      // try (162 -> 167): 427 null
      // try (169 -> 174): 429 android/database/sqlite/SQLiteException
      // try (169 -> 174): 427 null
      // try (176 -> 181): 429 android/database/sqlite/SQLiteException
      // try (176 -> 181): 427 null
      // try (183 -> 188): 429 android/database/sqlite/SQLiteException
      // try (183 -> 188): 427 null
      // try (190 -> 195): 429 android/database/sqlite/SQLiteException
      // try (190 -> 195): 427 null
      // try (197 -> 202): 429 android/database/sqlite/SQLiteException
      // try (197 -> 202): 427 null
      // try (204 -> 209): 429 android/database/sqlite/SQLiteException
      // try (204 -> 209): 427 null
      // try (211 -> 216): 429 android/database/sqlite/SQLiteException
      // try (211 -> 216): 427 null
      // try (218 -> 222): 429 android/database/sqlite/SQLiteException
      // try (218 -> 222): 427 null
      // try (224 -> 228): 429 android/database/sqlite/SQLiteException
      // try (224 -> 228): 427 null
      // try (232 -> 235): 429 android/database/sqlite/SQLiteException
      // try (232 -> 235): 427 null
      // try (237 -> 242): 429 android/database/sqlite/SQLiteException
      // try (237 -> 242): 427 null
      // try (244 -> 249): 429 android/database/sqlite/SQLiteException
      // try (244 -> 249): 427 null
      // try (251 -> 256): 429 android/database/sqlite/SQLiteException
      // try (251 -> 256): 427 null
      // try (258 -> 263): 429 android/database/sqlite/SQLiteException
      // try (258 -> 263): 427 null
      // try (265 -> 270): 429 android/database/sqlite/SQLiteException
      // try (265 -> 270): 427 null
      // try (272 -> 277): 429 android/database/sqlite/SQLiteException
      // try (272 -> 277): 427 null
      // try (279 -> 283): 429 android/database/sqlite/SQLiteException
      // try (279 -> 283): 427 null
      // try (287 -> 290): 429 android/database/sqlite/SQLiteException
      // try (287 -> 290): 427 null
      // try (292 -> 297): 429 android/database/sqlite/SQLiteException
      // try (292 -> 297): 427 null
      // try (299 -> 304): 429 android/database/sqlite/SQLiteException
      // try (299 -> 304): 427 null
      // try (306 -> 311): 429 android/database/sqlite/SQLiteException
      // try (306 -> 311): 427 null
      // try (313 -> 318): 429 android/database/sqlite/SQLiteException
      // try (313 -> 318): 427 null
      // try (320 -> 324): 429 android/database/sqlite/SQLiteException
      // try (320 -> 324): 427 null
      // try (328 -> 331): 429 android/database/sqlite/SQLiteException
      // try (328 -> 331): 427 null
      // try (333 -> 337): 429 android/database/sqlite/SQLiteException
      // try (333 -> 337): 427 null
      // try (339 -> 343): 429 android/database/sqlite/SQLiteException
      // try (339 -> 343): 427 null
      // try (347 -> 350): 429 android/database/sqlite/SQLiteException
      // try (347 -> 350): 427 null
      // try (352 -> 354): 429 android/database/sqlite/SQLiteException
      // try (352 -> 354): 427 null
      // try (356 -> 359): 429 android/database/sqlite/SQLiteException
      // try (356 -> 359): 427 null
      // try (361 -> 368): 429 android/database/sqlite/SQLiteException
      // try (361 -> 368): 427 null
      // try (382 -> 387): 429 android/database/sqlite/SQLiteException
      // try (382 -> 387): 427 null
      // try (390 -> 394): 429 android/database/sqlite/SQLiteException
      // try (390 -> 394): 427 null
      // try (403 -> 411): 427 null
   }

   public final List<zzcgl> b(String var1, String var2, String var3) {
      zzbq.a(var1);
      this.c();
      this.Q();
      ArrayList var4 = new ArrayList(3);
      var4.add(var1);
      StringBuilder var5 = new StringBuilder("app_id=?");
      if (!TextUtils.isEmpty(var2)) {
         var4.add(var2);
         var5.append(" and origin=?");
      }

      if (!TextUtils.isEmpty(var3)) {
         var4.add(String.valueOf(var3).concat("*"));
         var5.append(" and name glob ?");
      }

      String[] var6 = var4.toArray(new String[var4.size()]);
      return this.a(var5.toString(), var6);
   }

   public final void b(String var1, String var2) {
      zzbq.a(var1);
      zzbq.a(var2);
      this.c();
      this.Q();

      try {
         int var3 = this.A().delete("user_attributes", "app_id=? and name=?", new String[]{var1, var2});
         this.t().E().a("Deleted user attribute rows", var3);
      } catch (SQLiteException var5) {
         this.t().y().a("Error deleting user attribute. appId", zzchm.a(var1), this.o().c(var2), var5);
      }
   }

   public final long c(String var1) {
      zzbq.a(var1);
      this.c();
      this.Q();

      int var2;
      try {
         var2 = this.A()
            .delete(
               "raw_events",
               "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)",
               new String[]{var1, String.valueOf(Math.max(0, Math.min(1000000, this.v().b(var1, zzchc.r))))}
            );
      } catch (SQLiteException var6) {
         this.t().y().a("Error deleting over the limit events. appId", zzchm.a(var1), var6);
         return 0L;
      }

      return var2;
   }

   public final zzclp c(String param1, String param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aconst_null
      // 001: astore 7
      // 003: aload 1
      // 004: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/String;)Ljava/lang/String;
      // 007: pop
      // 008: aload 2
      // 009: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/String;)Ljava/lang/String;
      // 00c: pop
      // 00d: aload 0
      // 00e: invokevirtual com/google/android/gms/internal/zzcjk.c ()V
      // 011: aload 0
      // 012: invokevirtual com/google/android/gms/internal/zzcjl.Q ()V
      // 015: aload 0
      // 016: invokevirtual com/google/android/gms/internal/zzcgo.A ()Landroid/database/sqlite/SQLiteDatabase;
      // 019: ldc_w "user_attributes"
      // 01c: bipush 3
      // 01d: anewarray 19
      // 020: dup
      // 021: bipush 0
      // 022: ldc_w "set_timestamp"
      // 025: aastore
      // 026: dup
      // 027: bipush 1
      // 028: ldc_w "value"
      // 02b: aastore
      // 02c: dup
      // 02d: bipush 2
      // 02e: ldc "origin"
      // 030: aastore
      // 031: ldc_w "app_id=? and name=?"
      // 034: bipush 2
      // 035: anewarray 19
      // 038: dup
      // 039: bipush 0
      // 03a: aload 1
      // 03b: aastore
      // 03c: dup
      // 03d: bipush 1
      // 03e: aload 2
      // 03f: aastore
      // 040: aconst_null
      // 041: aconst_null
      // 042: aconst_null
      // 043: invokevirtual android/database/sqlite/SQLiteDatabase.query (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      // 046: astore 6
      // 048: aload 6
      // 04a: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 04f: istore 3
      // 050: iload 3
      // 051: ifne 064
      // 054: aload 6
      // 056: ifnull 060
      // 059: aload 6
      // 05b: invokeinterface android/database/Cursor.close ()V 1
      // 060: aconst_null
      // 061: astore 1
      // 062: aload 1
      // 063: areturn
      // 064: aload 6
      // 066: bipush 0
      // 067: invokeinterface android/database/Cursor.getLong (I)J 2
      // 06c: lstore 4
      // 06e: aload 0
      // 06f: aload 6
      // 071: bipush 1
      // 072: invokespecial com/google/android/gms/internal/zzcgo.a (Landroid/database/Cursor;I)Ljava/lang/Object;
      // 075: astore 9
      // 077: aload 6
      // 079: bipush 2
      // 07a: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 07f: astore 8
      // 081: new com/google/android/gms/internal/zzclp
      // 084: astore 7
      // 086: aload 7
      // 088: aload 1
      // 089: aload 8
      // 08b: aload 2
      // 08c: lload 4
      // 08e: aload 9
      // 090: invokespecial com/google/android/gms/internal/zzclp.<init> (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Object;)V
      // 093: aload 6
      // 095: invokeinterface android/database/Cursor.moveToNext ()Z 1
      // 09a: ifeq 0ae
      // 09d: aload 0
      // 09e: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 0a1: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 0a4: ldc_w "Got multiple records for user property, expected one. appId"
      // 0a7: aload 1
      // 0a8: invokestatic com/google/android/gms/internal/zzchm.a (Ljava/lang/String;)Ljava/lang/Object;
      // 0ab: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;)V
      // 0ae: aload 7
      // 0b0: astore 1
      // 0b1: aload 6
      // 0b3: ifnull 062
      // 0b6: aload 6
      // 0b8: invokeinterface android/database/Cursor.close ()V 1
      // 0bd: aload 7
      // 0bf: astore 1
      // 0c0: goto 062
      // 0c3: astore 7
      // 0c5: aconst_null
      // 0c6: astore 6
      // 0c8: aload 0
      // 0c9: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 0cc: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 0cf: ldc_w "Error querying user property. appId"
      // 0d2: aload 1
      // 0d3: invokestatic com/google/android/gms/internal/zzchm.a (Ljava/lang/String;)Ljava/lang/Object;
      // 0d6: aload 0
      // 0d7: invokevirtual com/google/android/gms/internal/zzcjk.o ()Lcom/google/android/gms/internal/zzchk;
      // 0da: aload 2
      // 0db: invokevirtual com/google/android/gms/internal/zzchk.c (Ljava/lang/String;)Ljava/lang/String;
      // 0de: aload 7
      // 0e0: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
      // 0e3: aload 6
      // 0e5: ifnull 0ef
      // 0e8: aload 6
      // 0ea: invokeinterface android/database/Cursor.close ()V 1
      // 0ef: aconst_null
      // 0f0: astore 1
      // 0f1: goto 062
      // 0f4: astore 1
      // 0f5: aload 7
      // 0f7: astore 2
      // 0f8: aload 2
      // 0f9: ifnull 102
      // 0fc: aload 2
      // 0fd: invokeinterface android/database/Cursor.close ()V 1
      // 102: aload 1
      // 103: athrow
      // 104: astore 1
      // 105: aload 6
      // 107: astore 2
      // 108: goto 0f8
      // 10b: astore 1
      // 10c: aload 6
      // 10e: astore 2
      // 10f: goto 0f8
      // 112: astore 7
      // 114: goto 0c8
      // try (12 -> 45): 99 android/database/sqlite/SQLiteException
      // try (12 -> 45): 121 null
      // try (45 -> 48): 138 android/database/sqlite/SQLiteException
      // try (45 -> 48): 130 null
      // try (58 -> 90): 138 android/database/sqlite/SQLiteException
      // try (58 -> 90): 130 null
      // try (102 -> 114): 134 null
   }

   public final zzcgl d(String param1, String param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aload 1
      // 001: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/String;)Ljava/lang/String;
      // 004: pop
      // 005: aload 2
      // 006: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/String;)Ljava/lang/String;
      // 009: pop
      // 00a: aload 0
      // 00b: invokevirtual com/google/android/gms/internal/zzcjk.c ()V
      // 00e: aload 0
      // 00f: invokevirtual com/google/android/gms/internal/zzcjl.Q ()V
      // 012: aload 0
      // 013: invokevirtual com/google/android/gms/internal/zzcgo.A ()Landroid/database/sqlite/SQLiteDatabase;
      // 016: ldc_w "conditional_properties"
      // 019: bipush 11
      // 01b: anewarray 19
      // 01e: dup
      // 01f: bipush 0
      // 020: ldc "origin"
      // 022: aastore
      // 023: dup
      // 024: bipush 1
      // 025: ldc_w "value"
      // 028: aastore
      // 029: dup
      // 02a: bipush 2
      // 02b: ldc_w "active"
      // 02e: aastore
      // 02f: dup
      // 030: bipush 3
      // 031: ldc_w "trigger_event_name"
      // 034: aastore
      // 035: dup
      // 036: bipush 4
      // 037: ldc_w "trigger_timeout"
      // 03a: aastore
      // 03b: dup
      // 03c: bipush 5
      // 03d: ldc_w "timed_out_event"
      // 040: aastore
      // 041: dup
      // 042: bipush 6
      // 044: ldc_w "creation_timestamp"
      // 047: aastore
      // 048: dup
      // 049: bipush 7
      // 04b: ldc_w "triggered_event"
      // 04e: aastore
      // 04f: dup
      // 050: bipush 8
      // 052: ldc_w "triggered_timestamp"
      // 055: aastore
      // 056: dup
      // 057: bipush 9
      // 059: ldc_w "time_to_live"
      // 05c: aastore
      // 05d: dup
      // 05e: bipush 10
      // 060: ldc_w "expired_event"
      // 063: aastore
      // 064: ldc_w "app_id=? and name=?"
      // 067: bipush 2
      // 068: anewarray 19
      // 06b: dup
      // 06c: bipush 0
      // 06d: aload 1
      // 06e: aastore
      // 06f: dup
      // 070: bipush 1
      // 071: aload 2
      // 072: aastore
      // 073: aconst_null
      // 074: aconst_null
      // 075: aconst_null
      // 076: invokevirtual android/database/sqlite/SQLiteDatabase.query (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      // 079: astore 12
      // 07b: aload 12
      // 07d: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 082: istore 11
      // 084: iload 11
      // 086: ifne 099
      // 089: aload 12
      // 08b: ifnull 095
      // 08e: aload 12
      // 090: invokeinterface android/database/Cursor.close ()V 1
      // 095: aconst_null
      // 096: astore 1
      // 097: aload 1
      // 098: areturn
      // 099: aload 12
      // 09b: bipush 0
      // 09c: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 0a1: astore 14
      // 0a3: aload 0
      // 0a4: aload 12
      // 0a6: bipush 1
      // 0a7: invokespecial com/google/android/gms/internal/zzcgo.a (Landroid/database/Cursor;I)Ljava/lang/Object;
      // 0aa: astore 13
      // 0ac: aload 12
      // 0ae: bipush 2
      // 0af: invokeinterface android/database/Cursor.getInt (I)I 2
      // 0b4: ifeq 19c
      // 0b7: bipush 1
      // 0b8: istore 11
      // 0ba: aload 12
      // 0bc: bipush 3
      // 0bd: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 0c2: astore 19
      // 0c4: aload 12
      // 0c6: bipush 4
      // 0c7: invokeinterface android/database/Cursor.getLong (I)J 2
      // 0cc: lstore 5
      // 0ce: aload 0
      // 0cf: invokevirtual com/google/android/gms/internal/zzcjk.p ()Lcom/google/android/gms/internal/zzclq;
      // 0d2: aload 12
      // 0d4: bipush 5
      // 0d5: invokeinterface android/database/Cursor.getBlob (I)[B 2
      // 0da: getstatic com/google/android/gms/internal/zzcha.CREATOR Landroid/os/Parcelable$Creator;
      // 0dd: invokevirtual com/google/android/gms/internal/zzclq.a ([BLandroid/os/Parcelable$Creator;)Landroid/os/Parcelable;
      // 0e0: checkcast com/google/android/gms/internal/zzcha
      // 0e3: astore 17
      // 0e5: aload 12
      // 0e7: bipush 6
      // 0e9: invokeinterface android/database/Cursor.getLong (I)J 2
      // 0ee: lstore 9
      // 0f0: aload 0
      // 0f1: invokevirtual com/google/android/gms/internal/zzcjk.p ()Lcom/google/android/gms/internal/zzclq;
      // 0f4: aload 12
      // 0f6: bipush 7
      // 0f8: invokeinterface android/database/Cursor.getBlob (I)[B 2
      // 0fd: getstatic com/google/android/gms/internal/zzcha.CREATOR Landroid/os/Parcelable$Creator;
      // 100: invokevirtual com/google/android/gms/internal/zzclq.a ([BLandroid/os/Parcelable$Creator;)Landroid/os/Parcelable;
      // 103: checkcast com/google/android/gms/internal/zzcha
      // 106: astore 16
      // 108: aload 12
      // 10a: bipush 8
      // 10c: invokeinterface android/database/Cursor.getLong (I)J 2
      // 111: lstore 7
      // 113: aload 12
      // 115: bipush 9
      // 117: invokeinterface android/database/Cursor.getLong (I)J 2
      // 11c: lstore 3
      // 11d: aload 0
      // 11e: invokevirtual com/google/android/gms/internal/zzcjk.p ()Lcom/google/android/gms/internal/zzclq;
      // 121: aload 12
      // 123: bipush 10
      // 125: invokeinterface android/database/Cursor.getBlob (I)[B 2
      // 12a: getstatic com/google/android/gms/internal/zzcha.CREATOR Landroid/os/Parcelable$Creator;
      // 12d: invokevirtual com/google/android/gms/internal/zzclq.a ([BLandroid/os/Parcelable$Creator;)Landroid/os/Parcelable;
      // 130: checkcast com/google/android/gms/internal/zzcha
      // 133: astore 18
      // 135: new com/google/android/gms/internal/zzcln
      // 138: astore 15
      // 13a: aload 15
      // 13c: aload 2
      // 13d: lload 7
      // 13f: aload 13
      // 141: aload 14
      // 143: invokespecial com/google/android/gms/internal/zzcln.<init> (Ljava/lang/String;JLjava/lang/Object;Ljava/lang/String;)V
      // 146: new com/google/android/gms/internal/zzcgl
      // 149: astore 13
      // 14b: aload 13
      // 14d: aload 1
      // 14e: aload 14
      // 150: aload 15
      // 152: lload 9
      // 154: iload 11
      // 156: aload 19
      // 158: aload 17
      // 15a: lload 5
      // 15c: aload 16
      // 15e: lload 3
      // 15f: aload 18
      // 161: invokespecial com/google/android/gms/internal/zzcgl.<init> (Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gms/internal/zzcln;JZLjava/lang/String;Lcom/google/android/gms/internal/zzcha;JLcom/google/android/gms/internal/zzcha;JLcom/google/android/gms/internal/zzcha;)V
      // 164: aload 12
      // 166: invokeinterface android/database/Cursor.moveToNext ()Z 1
      // 16b: ifeq 187
      // 16e: aload 0
      // 16f: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 172: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 175: ldc_w "Got multiple records for conditional property, expected one"
      // 178: aload 1
      // 179: invokestatic com/google/android/gms/internal/zzchm.a (Ljava/lang/String;)Ljava/lang/Object;
      // 17c: aload 0
      // 17d: invokevirtual com/google/android/gms/internal/zzcjk.o ()Lcom/google/android/gms/internal/zzchk;
      // 180: aload 2
      // 181: invokevirtual com/google/android/gms/internal/zzchk.c (Ljava/lang/String;)Ljava/lang/String;
      // 184: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
      // 187: aload 13
      // 189: astore 1
      // 18a: aload 12
      // 18c: ifnull 097
      // 18f: aload 12
      // 191: invokeinterface android/database/Cursor.close ()V 1
      // 196: aload 13
      // 198: astore 1
      // 199: goto 097
      // 19c: bipush 0
      // 19d: istore 11
      // 19f: goto 0ba
      // 1a2: astore 13
      // 1a4: aconst_null
      // 1a5: astore 12
      // 1a7: aload 0
      // 1a8: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 1ab: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 1ae: ldc_w "Error querying conditional property"
      // 1b1: aload 1
      // 1b2: invokestatic com/google/android/gms/internal/zzchm.a (Ljava/lang/String;)Ljava/lang/Object;
      // 1b5: aload 0
      // 1b6: invokevirtual com/google/android/gms/internal/zzcjk.o ()Lcom/google/android/gms/internal/zzchk;
      // 1b9: aload 2
      // 1ba: invokevirtual com/google/android/gms/internal/zzchk.c (Ljava/lang/String;)Ljava/lang/String;
      // 1bd: aload 13
      // 1bf: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
      // 1c2: aload 12
      // 1c4: ifnull 1ce
      // 1c7: aload 12
      // 1c9: invokeinterface android/database/Cursor.close ()V 1
      // 1ce: aconst_null
      // 1cf: astore 1
      // 1d0: goto 097
      // 1d3: astore 1
      // 1d4: aconst_null
      // 1d5: astore 12
      // 1d7: aload 12
      // 1d9: ifnull 1e3
      // 1dc: aload 12
      // 1de: invokeinterface android/database/Cursor.close ()V 1
      // 1e3: aload 1
      // 1e4: athrow
      // 1e5: astore 1
      // 1e6: goto 1d7
      // 1e9: astore 1
      // 1ea: goto 1d7
      // 1ed: astore 13
      // 1ef: goto 1a7
      // try (10 -> 75): 199 android/database/sqlite/SQLiteException
      // try (10 -> 75): 221 null
      // try (75 -> 78): 234 android/database/sqlite/SQLiteException
      // try (75 -> 78): 230 null
      // try (88 -> 101): 234 android/database/sqlite/SQLiteException
      // try (88 -> 101): 230 null
      // try (103 -> 187): 234 android/database/sqlite/SQLiteException
      // try (103 -> 187): 230 null
      // try (202 -> 214): 232 null
   }

   public final byte[] d(String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 1
      // 01: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/String;)Ljava/lang/String;
      // 04: pop
      // 05: aload 0
      // 06: invokevirtual com/google/android/gms/internal/zzcjk.c ()V
      // 09: aload 0
      // 0a: invokevirtual com/google/android/gms/internal/zzcjl.Q ()V
      // 0d: aload 0
      // 0e: invokevirtual com/google/android/gms/internal/zzcgo.A ()Landroid/database/sqlite/SQLiteDatabase;
      // 11: ldc_w "apps"
      // 14: bipush 1
      // 15: anewarray 19
      // 18: dup
      // 19: bipush 0
      // 1a: ldc "remote_config"
      // 1c: aastore
      // 1d: ldc_w "app_id=?"
      // 20: bipush 1
      // 21: anewarray 19
      // 24: dup
      // 25: bipush 0
      // 26: aload 1
      // 27: aastore
      // 28: aconst_null
      // 29: aconst_null
      // 2a: aconst_null
      // 2b: invokevirtual android/database/sqlite/SQLiteDatabase.query (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      // 2e: astore 4
      // 30: aload 4
      // 32: astore 3
      // 33: aload 4
      // 35: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 3a: istore 2
      // 3b: iload 2
      // 3c: ifne 4f
      // 3f: aload 4
      // 41: ifnull 4b
      // 44: aload 4
      // 46: invokeinterface android/database/Cursor.close ()V 1
      // 4b: aconst_null
      // 4c: astore 1
      // 4d: aload 1
      // 4e: areturn
      // 4f: aload 4
      // 51: astore 3
      // 52: aload 4
      // 54: bipush 0
      // 55: invokeinterface android/database/Cursor.getBlob (I)[B 2
      // 5a: astore 5
      // 5c: aload 4
      // 5e: astore 3
      // 5f: aload 4
      // 61: invokeinterface android/database/Cursor.moveToNext ()Z 1
      // 66: ifeq 7d
      // 69: aload 4
      // 6b: astore 3
      // 6c: aload 0
      // 6d: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 70: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 73: ldc_w "Got multiple records for app config, expected one. appId"
      // 76: aload 1
      // 77: invokestatic com/google/android/gms/internal/zzchm.a (Ljava/lang/String;)Ljava/lang/Object;
      // 7a: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;)V
      // 7d: aload 5
      // 7f: astore 1
      // 80: aload 4
      // 82: ifnull 4d
      // 85: aload 4
      // 87: invokeinterface android/database/Cursor.close ()V 1
      // 8c: aload 5
      // 8e: astore 1
      // 8f: goto 4d
      // 92: astore 5
      // 94: aconst_null
      // 95: astore 4
      // 97: aload 4
      // 99: astore 3
      // 9a: aload 0
      // 9b: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 9e: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // a1: ldc_w "Error querying remote config. appId"
      // a4: aload 1
      // a5: invokestatic com/google/android/gms/internal/zzchm.a (Ljava/lang/String;)Ljava/lang/Object;
      // a8: aload 5
      // aa: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
      // ad: aload 4
      // af: ifnull b9
      // b2: aload 4
      // b4: invokeinterface android/database/Cursor.close ()V 1
      // b9: aconst_null
      // ba: astore 1
      // bb: goto 4d
      // be: astore 1
      // bf: aconst_null
      // c0: astore 3
      // c1: aload 3
      // c2: ifnull cb
      // c5: aload 3
      // c6: invokeinterface android/database/Cursor.close ()V 1
      // cb: aload 1
      // cc: athrow
      // cd: astore 1
      // ce: goto c1
      // d1: astore 5
      // d3: goto 97
      // try (7 -> 28): 72 android/database/sqlite/SQLiteException
      // try (7 -> 28): 92 null
      // try (30 -> 33): 103 android/database/sqlite/SQLiteException
      // try (30 -> 33): 101 null
      // try (45 -> 49): 103 android/database/sqlite/SQLiteException
      // try (45 -> 49): 101 null
      // try (51 -> 54): 103 android/database/sqlite/SQLiteException
      // try (51 -> 54): 101 null
      // try (56 -> 63): 103 android/database/sqlite/SQLiteException
      // try (56 -> 63): 101 null
      // try (77 -> 85): 101 null
   }

   public final int e(String var1, String var2) {
      byte var4 = 0;
      zzbq.a(var1);
      zzbq.a(var2);
      this.c();
      this.Q();

      int var3;
      try {
         var3 = this.A().delete("conditional_properties", "app_id=? and name=?", new String[]{var1, var2});
      } catch (SQLiteException var6) {
         this.t().y().a("Error deleting conditional property", zzchm.a(var1), this.o().c(var2), var6);
         var3 = var4;
      }

      return var3;
   }

   final Map<Integer, zzcmf> e(String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aload 0
      // 001: invokevirtual com/google/android/gms/internal/zzcjl.Q ()V
      // 004: aload 0
      // 005: invokevirtual com/google/android/gms/internal/zzcjk.c ()V
      // 008: aload 1
      // 009: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/String;)Ljava/lang/String;
      // 00c: pop
      // 00d: aload 0
      // 00e: invokevirtual com/google/android/gms/internal/zzcgo.A ()Landroid/database/sqlite/SQLiteDatabase;
      // 011: astore 4
      // 013: aload 4
      // 015: ldc_w "audience_filter_values"
      // 018: bipush 2
      // 019: anewarray 19
      // 01c: dup
      // 01d: bipush 0
      // 01e: ldc_w "audience_id"
      // 021: aastore
      // 022: dup
      // 023: bipush 1
      // 024: ldc_w "current_results"
      // 027: aastore
      // 028: ldc_w "app_id=?"
      // 02b: bipush 1
      // 02c: anewarray 19
      // 02f: dup
      // 030: bipush 0
      // 031: aload 1
      // 032: aastore
      // 033: aconst_null
      // 034: aconst_null
      // 035: aconst_null
      // 036: invokevirtual android/database/sqlite/SQLiteDatabase.query (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      // 039: astore 5
      // 03b: aload 5
      // 03d: astore 4
      // 03f: aload 5
      // 041: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 046: istore 3
      // 047: iload 3
      // 048: ifne 05b
      // 04b: aload 5
      // 04d: ifnull 057
      // 050: aload 5
      // 052: invokeinterface android/database/Cursor.close ()V 1
      // 057: aconst_null
      // 058: astore 1
      // 059: aload 1
      // 05a: areturn
      // 05b: aload 5
      // 05d: astore 4
      // 05f: new android/support/v4/util/ArrayMap
      // 062: astore 6
      // 064: aload 5
      // 066: astore 4
      // 068: aload 6
      // 06a: invokespecial android/support/v4/util/ArrayMap.<init> ()V
      // 06d: aload 5
      // 06f: astore 4
      // 071: aload 5
      // 073: bipush 0
      // 074: invokeinterface android/database/Cursor.getInt (I)I 2
      // 079: istore 2
      // 07a: aload 5
      // 07c: astore 4
      // 07e: aload 5
      // 080: bipush 1
      // 081: invokeinterface android/database/Cursor.getBlob (I)[B 2
      // 086: astore 7
      // 088: aload 5
      // 08a: astore 4
      // 08c: aload 7
      // 08e: bipush 0
      // 08f: aload 7
      // 091: arraylength
      // 092: invokestatic com/google/android/gms/internal/zzfjj.a ([BII)Lcom/google/android/gms/internal/zzfjj;
      // 095: astore 8
      // 097: aload 5
      // 099: astore 4
      // 09b: new com/google/android/gms/internal/zzcmf
      // 09e: astore 7
      // 0a0: aload 5
      // 0a2: astore 4
      // 0a4: aload 7
      // 0a6: invokespecial com/google/android/gms/internal/zzcmf.<init> ()V
      // 0a9: aload 5
      // 0ab: astore 4
      // 0ad: aload 7
      // 0af: aload 8
      // 0b1: invokevirtual com/google/android/gms/internal/zzfjs.a (Lcom/google/android/gms/internal/zzfjj;)Lcom/google/android/gms/internal/zzfjs;
      // 0b4: pop
      // 0b5: aload 5
      // 0b7: astore 4
      // 0b9: aload 6
      // 0bb: iload 2
      // 0bc: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 0bf: aload 7
      // 0c1: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 0c6: pop
      // 0c7: aload 5
      // 0c9: astore 4
      // 0cb: aload 5
      // 0cd: invokeinterface android/database/Cursor.moveToNext ()Z 1
      // 0d2: istore 3
      // 0d3: iload 3
      // 0d4: ifne 06d
      // 0d7: aload 6
      // 0d9: astore 1
      // 0da: aload 5
      // 0dc: ifnull 059
      // 0df: aload 5
      // 0e1: invokeinterface android/database/Cursor.close ()V 1
      // 0e6: aload 6
      // 0e8: astore 1
      // 0e9: goto 059
      // 0ec: astore 7
      // 0ee: aload 5
      // 0f0: astore 4
      // 0f2: aload 0
      // 0f3: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 0f6: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 0f9: ldc_w "Failed to merge filter results. appId, audienceId, error"
      // 0fc: aload 1
      // 0fd: invokestatic com/google/android/gms/internal/zzchm.a (Ljava/lang/String;)Ljava/lang/Object;
      // 100: iload 2
      // 101: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 104: aload 7
      // 106: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
      // 109: goto 0c7
      // 10c: astore 6
      // 10e: aload 5
      // 110: astore 4
      // 112: aload 0
      // 113: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 116: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 119: ldc_w "Database error querying filter results. appId"
      // 11c: aload 1
      // 11d: invokestatic com/google/android/gms/internal/zzchm.a (Ljava/lang/String;)Ljava/lang/Object;
      // 120: aload 6
      // 122: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
      // 125: aload 5
      // 127: ifnull 131
      // 12a: aload 5
      // 12c: invokeinterface android/database/Cursor.close ()V 1
      // 131: aconst_null
      // 132: astore 1
      // 133: goto 059
      // 136: astore 1
      // 137: aconst_null
      // 138: astore 4
      // 13a: aload 4
      // 13c: ifnull 146
      // 13f: aload 4
      // 141: invokeinterface android/database/Cursor.close ()V 1
      // 146: aload 1
      // 147: athrow
      // 148: astore 1
      // 149: goto 13a
      // 14c: astore 6
      // 14e: aconst_null
      // 14f: astore 5
      // 151: goto 10e
      // try (10 -> 34): 158 android/database/sqlite/SQLiteException
      // try (10 -> 34): 147 null
      // try (36 -> 39): 129 android/database/sqlite/SQLiteException
      // try (36 -> 39): 156 null
      // try (51 -> 53): 129 android/database/sqlite/SQLiteException
      // try (51 -> 53): 156 null
      // try (55 -> 57): 129 android/database/sqlite/SQLiteException
      // try (55 -> 57): 156 null
      // try (59 -> 63): 129 android/database/sqlite/SQLiteException
      // try (59 -> 63): 156 null
      // try (65 -> 69): 129 android/database/sqlite/SQLiteException
      // try (65 -> 69): 156 null
      // try (71 -> 77): 129 android/database/sqlite/SQLiteException
      // try (71 -> 77): 156 null
      // try (79 -> 81): 129 android/database/sqlite/SQLiteException
      // try (79 -> 81): 156 null
      // try (83 -> 85): 129 android/database/sqlite/SQLiteException
      // try (83 -> 85): 156 null
      // try (87 -> 91): 115 java/io/IOException
      // try (87 -> 91): 129 android/database/sqlite/SQLiteException
      // try (87 -> 91): 156 null
      // try (93 -> 99): 129 android/database/sqlite/SQLiteException
      // try (93 -> 99): 156 null
      // try (101 -> 104): 129 android/database/sqlite/SQLiteException
      // try (101 -> 104): 156 null
      // try (118 -> 128): 129 android/database/sqlite/SQLiteException
      // try (118 -> 128): 156 null
      // try (132 -> 140): 156 null
   }

   public final long f(String var1) {
      zzbq.a(var1);
      return this.a("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{var1}, 0L);
   }

   final Map<Integer, List<zzcls>> f(String param1, String param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aload 0
      // 001: invokevirtual com/google/android/gms/internal/zzcjl.Q ()V
      // 004: aload 0
      // 005: invokevirtual com/google/android/gms/internal/zzcjk.c ()V
      // 008: aload 1
      // 009: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/String;)Ljava/lang/String;
      // 00c: pop
      // 00d: aload 2
      // 00e: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/String;)Ljava/lang/String;
      // 011: pop
      // 012: new android/support/v4/util/ArrayMap
      // 015: dup
      // 016: invokespecial android/support/v4/util/ArrayMap.<init> ()V
      // 019: astore 7
      // 01b: aload 0
      // 01c: invokevirtual com/google/android/gms/internal/zzcgo.A ()Landroid/database/sqlite/SQLiteDatabase;
      // 01f: astore 5
      // 021: aload 5
      // 023: ldc_w "event_filters"
      // 026: bipush 2
      // 027: anewarray 19
      // 02a: dup
      // 02b: bipush 0
      // 02c: ldc_w "audience_id"
      // 02f: aastore
      // 030: dup
      // 031: bipush 1
      // 032: ldc_w "data"
      // 035: aastore
      // 036: ldc_w "app_id=? AND event_name=?"
      // 039: bipush 2
      // 03a: anewarray 19
      // 03d: dup
      // 03e: bipush 0
      // 03f: aload 1
      // 040: aastore
      // 041: dup
      // 042: bipush 1
      // 043: aload 2
      // 044: aastore
      // 045: aconst_null
      // 046: aconst_null
      // 047: aconst_null
      // 048: invokevirtual android/database/sqlite/SQLiteDatabase.query (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      // 04b: astore 5
      // 04d: aload 5
      // 04f: astore 2
      // 050: aload 5
      // 052: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 057: ifne 077
      // 05a: aload 5
      // 05c: astore 2
      // 05d: invokestatic java/util/Collections.emptyMap ()Ljava/util/Map;
      // 060: astore 6
      // 062: aload 6
      // 064: astore 2
      // 065: aload 2
      // 066: astore 1
      // 067: aload 5
      // 069: ifnull 075
      // 06c: aload 5
      // 06e: invokeinterface android/database/Cursor.close ()V 1
      // 073: aload 2
      // 074: astore 1
      // 075: aload 1
      // 076: areturn
      // 077: aload 5
      // 079: astore 2
      // 07a: aload 5
      // 07c: bipush 1
      // 07d: invokeinterface android/database/Cursor.getBlob (I)[B 2
      // 082: astore 6
      // 084: aload 5
      // 086: astore 2
      // 087: aload 6
      // 089: bipush 0
      // 08a: aload 6
      // 08c: arraylength
      // 08d: invokestatic com/google/android/gms/internal/zzfjj.a ([BII)Lcom/google/android/gms/internal/zzfjj;
      // 090: astore 6
      // 092: aload 5
      // 094: astore 2
      // 095: new com/google/android/gms/internal/zzcls
      // 098: astore 9
      // 09a: aload 5
      // 09c: astore 2
      // 09d: aload 9
      // 09f: invokespecial com/google/android/gms/internal/zzcls.<init> ()V
      // 0a2: aload 5
      // 0a4: astore 2
      // 0a5: aload 9
      // 0a7: aload 6
      // 0a9: invokevirtual com/google/android/gms/internal/zzfjs.a (Lcom/google/android/gms/internal/zzfjj;)Lcom/google/android/gms/internal/zzfjs;
      // 0ac: pop
      // 0ad: aload 5
      // 0af: astore 2
      // 0b0: aload 5
      // 0b2: bipush 0
      // 0b3: invokeinterface android/database/Cursor.getInt (I)I 2
      // 0b8: istore 3
      // 0b9: aload 5
      // 0bb: astore 2
      // 0bc: aload 7
      // 0be: iload 3
      // 0bf: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 0c2: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 0c7: checkcast java/util/List
      // 0ca: astore 8
      // 0cc: aload 8
      // 0ce: astore 6
      // 0d0: aload 8
      // 0d2: ifnonnull 0f6
      // 0d5: aload 5
      // 0d7: astore 2
      // 0d8: new java/util/ArrayList
      // 0db: astore 6
      // 0dd: aload 5
      // 0df: astore 2
      // 0e0: aload 6
      // 0e2: invokespecial java/util/ArrayList.<init> ()V
      // 0e5: aload 5
      // 0e7: astore 2
      // 0e8: aload 7
      // 0ea: iload 3
      // 0eb: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 0ee: aload 6
      // 0f0: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 0f5: pop
      // 0f6: aload 5
      // 0f8: astore 2
      // 0f9: aload 6
      // 0fb: aload 9
      // 0fd: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 102: pop
      // 103: aload 5
      // 105: astore 2
      // 106: aload 5
      // 108: invokeinterface android/database/Cursor.moveToNext ()Z 1
      // 10d: istore 4
      // 10f: iload 4
      // 111: ifne 077
      // 114: aload 5
      // 116: ifnull 120
      // 119: aload 5
      // 11b: invokeinterface android/database/Cursor.close ()V 1
      // 120: aload 7
      // 122: astore 1
      // 123: goto 075
      // 126: astore 6
      // 128: aload 5
      // 12a: astore 2
      // 12b: aload 0
      // 12c: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 12f: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 132: ldc_w "Failed to merge filter. appId"
      // 135: aload 1
      // 136: invokestatic com/google/android/gms/internal/zzchm.a (Ljava/lang/String;)Ljava/lang/Object;
      // 139: aload 6
      // 13b: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
      // 13e: goto 103
      // 141: astore 6
      // 143: aload 5
      // 145: astore 2
      // 146: aload 0
      // 147: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 14a: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 14d: ldc_w "Database error querying filters. appId"
      // 150: aload 1
      // 151: invokestatic com/google/android/gms/internal/zzchm.a (Ljava/lang/String;)Ljava/lang/Object;
      // 154: aload 6
      // 156: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
      // 159: aload 5
      // 15b: ifnull 165
      // 15e: aload 5
      // 160: invokeinterface android/database/Cursor.close ()V 1
      // 165: aconst_null
      // 166: astore 1
      // 167: goto 075
      // 16a: astore 1
      // 16b: aconst_null
      // 16c: astore 2
      // 16d: aload 2
      // 16e: ifnull 177
      // 171: aload 2
      // 172: invokeinterface android/database/Cursor.close ()V 1
      // 177: aload 1
      // 178: athrow
      // 179: astore 1
      // 17a: goto 16d
      // 17d: astore 6
      // 17f: aconst_null
      // 180: astore 5
      // 182: goto 143
      // try (17 -> 45): 189 android/database/sqlite/SQLiteException
      // try (17 -> 45): 178 null
      // try (47 -> 50): 160 android/database/sqlite/SQLiteException
      // try (47 -> 50): 187 null
      // try (52 -> 54): 160 android/database/sqlite/SQLiteException
      // try (52 -> 54): 187 null
      // try (68 -> 72): 160 android/database/sqlite/SQLiteException
      // try (68 -> 72): 187 null
      // try (74 -> 80): 160 android/database/sqlite/SQLiteException
      // try (74 -> 80): 187 null
      // try (82 -> 84): 160 android/database/sqlite/SQLiteException
      // try (82 -> 84): 187 null
      // try (86 -> 88): 160 android/database/sqlite/SQLiteException
      // try (86 -> 88): 187 null
      // try (90 -> 94): 148 java/io/IOException
      // try (90 -> 94): 160 android/database/sqlite/SQLiteException
      // try (90 -> 94): 187 null
      // try (96 -> 100): 160 android/database/sqlite/SQLiteException
      // try (96 -> 100): 187 null
      // try (102 -> 108): 160 android/database/sqlite/SQLiteException
      // try (102 -> 108): 187 null
      // try (114 -> 116): 160 android/database/sqlite/SQLiteException
      // try (114 -> 116): 187 null
      // try (118 -> 120): 160 android/database/sqlite/SQLiteException
      // try (118 -> 120): 187 null
      // try (122 -> 128): 160 android/database/sqlite/SQLiteException
      // try (122 -> 128): 187 null
      // try (130 -> 134): 160 android/database/sqlite/SQLiteException
      // try (130 -> 134): 187 null
      // try (136 -> 139): 160 android/database/sqlite/SQLiteException
      // try (136 -> 139): 187 null
      // try (151 -> 159): 160 android/database/sqlite/SQLiteException
      // try (151 -> 159): 187 null
      // try (163 -> 171): 187 null
   }

   final Map<Integer, List<zzclv>> g(String param1, String param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aload 0
      // 001: invokevirtual com/google/android/gms/internal/zzcjl.Q ()V
      // 004: aload 0
      // 005: invokevirtual com/google/android/gms/internal/zzcjk.c ()V
      // 008: aload 1
      // 009: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/String;)Ljava/lang/String;
      // 00c: pop
      // 00d: aload 2
      // 00e: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/String;)Ljava/lang/String;
      // 011: pop
      // 012: new android/support/v4/util/ArrayMap
      // 015: dup
      // 016: invokespecial android/support/v4/util/ArrayMap.<init> ()V
      // 019: astore 7
      // 01b: aload 0
      // 01c: invokevirtual com/google/android/gms/internal/zzcgo.A ()Landroid/database/sqlite/SQLiteDatabase;
      // 01f: astore 5
      // 021: aload 5
      // 023: ldc_w "property_filters"
      // 026: bipush 2
      // 027: anewarray 19
      // 02a: dup
      // 02b: bipush 0
      // 02c: ldc_w "audience_id"
      // 02f: aastore
      // 030: dup
      // 031: bipush 1
      // 032: ldc_w "data"
      // 035: aastore
      // 036: ldc_w "app_id=? AND property_name=?"
      // 039: bipush 2
      // 03a: anewarray 19
      // 03d: dup
      // 03e: bipush 0
      // 03f: aload 1
      // 040: aastore
      // 041: dup
      // 042: bipush 1
      // 043: aload 2
      // 044: aastore
      // 045: aconst_null
      // 046: aconst_null
      // 047: aconst_null
      // 048: invokevirtual android/database/sqlite/SQLiteDatabase.query (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      // 04b: astore 5
      // 04d: aload 5
      // 04f: astore 2
      // 050: aload 5
      // 052: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 057: ifne 077
      // 05a: aload 5
      // 05c: astore 2
      // 05d: invokestatic java/util/Collections.emptyMap ()Ljava/util/Map;
      // 060: astore 6
      // 062: aload 6
      // 064: astore 2
      // 065: aload 2
      // 066: astore 1
      // 067: aload 5
      // 069: ifnull 075
      // 06c: aload 5
      // 06e: invokeinterface android/database/Cursor.close ()V 1
      // 073: aload 2
      // 074: astore 1
      // 075: aload 1
      // 076: areturn
      // 077: aload 5
      // 079: astore 2
      // 07a: aload 5
      // 07c: bipush 1
      // 07d: invokeinterface android/database/Cursor.getBlob (I)[B 2
      // 082: astore 6
      // 084: aload 5
      // 086: astore 2
      // 087: aload 6
      // 089: bipush 0
      // 08a: aload 6
      // 08c: arraylength
      // 08d: invokestatic com/google/android/gms/internal/zzfjj.a ([BII)Lcom/google/android/gms/internal/zzfjj;
      // 090: astore 6
      // 092: aload 5
      // 094: astore 2
      // 095: new com/google/android/gms/internal/zzclv
      // 098: astore 9
      // 09a: aload 5
      // 09c: astore 2
      // 09d: aload 9
      // 09f: invokespecial com/google/android/gms/internal/zzclv.<init> ()V
      // 0a2: aload 5
      // 0a4: astore 2
      // 0a5: aload 9
      // 0a7: aload 6
      // 0a9: invokevirtual com/google/android/gms/internal/zzfjs.a (Lcom/google/android/gms/internal/zzfjj;)Lcom/google/android/gms/internal/zzfjs;
      // 0ac: pop
      // 0ad: aload 5
      // 0af: astore 2
      // 0b0: aload 5
      // 0b2: bipush 0
      // 0b3: invokeinterface android/database/Cursor.getInt (I)I 2
      // 0b8: istore 3
      // 0b9: aload 5
      // 0bb: astore 2
      // 0bc: aload 7
      // 0be: iload 3
      // 0bf: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 0c2: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 0c7: checkcast java/util/List
      // 0ca: astore 8
      // 0cc: aload 8
      // 0ce: astore 6
      // 0d0: aload 8
      // 0d2: ifnonnull 0f6
      // 0d5: aload 5
      // 0d7: astore 2
      // 0d8: new java/util/ArrayList
      // 0db: astore 6
      // 0dd: aload 5
      // 0df: astore 2
      // 0e0: aload 6
      // 0e2: invokespecial java/util/ArrayList.<init> ()V
      // 0e5: aload 5
      // 0e7: astore 2
      // 0e8: aload 7
      // 0ea: iload 3
      // 0eb: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 0ee: aload 6
      // 0f0: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 0f5: pop
      // 0f6: aload 5
      // 0f8: astore 2
      // 0f9: aload 6
      // 0fb: aload 9
      // 0fd: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 102: pop
      // 103: aload 5
      // 105: astore 2
      // 106: aload 5
      // 108: invokeinterface android/database/Cursor.moveToNext ()Z 1
      // 10d: istore 4
      // 10f: iload 4
      // 111: ifne 077
      // 114: aload 5
      // 116: ifnull 120
      // 119: aload 5
      // 11b: invokeinterface android/database/Cursor.close ()V 1
      // 120: aload 7
      // 122: astore 1
      // 123: goto 075
      // 126: astore 6
      // 128: aload 5
      // 12a: astore 2
      // 12b: aload 0
      // 12c: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 12f: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 132: ldc_w "Failed to merge filter"
      // 135: aload 1
      // 136: invokestatic com/google/android/gms/internal/zzchm.a (Ljava/lang/String;)Ljava/lang/Object;
      // 139: aload 6
      // 13b: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
      // 13e: goto 103
      // 141: astore 6
      // 143: aload 5
      // 145: astore 2
      // 146: aload 0
      // 147: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 14a: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 14d: ldc_w "Database error querying filters. appId"
      // 150: aload 1
      // 151: invokestatic com/google/android/gms/internal/zzchm.a (Ljava/lang/String;)Ljava/lang/Object;
      // 154: aload 6
      // 156: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
      // 159: aload 5
      // 15b: ifnull 165
      // 15e: aload 5
      // 160: invokeinterface android/database/Cursor.close ()V 1
      // 165: aconst_null
      // 166: astore 1
      // 167: goto 075
      // 16a: astore 1
      // 16b: aconst_null
      // 16c: astore 2
      // 16d: aload 2
      // 16e: ifnull 177
      // 171: aload 2
      // 172: invokeinterface android/database/Cursor.close ()V 1
      // 177: aload 1
      // 178: athrow
      // 179: astore 1
      // 17a: goto 16d
      // 17d: astore 6
      // 17f: aconst_null
      // 180: astore 5
      // 182: goto 143
      // try (17 -> 45): 189 android/database/sqlite/SQLiteException
      // try (17 -> 45): 178 null
      // try (47 -> 50): 160 android/database/sqlite/SQLiteException
      // try (47 -> 50): 187 null
      // try (52 -> 54): 160 android/database/sqlite/SQLiteException
      // try (52 -> 54): 187 null
      // try (68 -> 72): 160 android/database/sqlite/SQLiteException
      // try (68 -> 72): 187 null
      // try (74 -> 80): 160 android/database/sqlite/SQLiteException
      // try (74 -> 80): 187 null
      // try (82 -> 84): 160 android/database/sqlite/SQLiteException
      // try (82 -> 84): 187 null
      // try (86 -> 88): 160 android/database/sqlite/SQLiteException
      // try (86 -> 88): 187 null
      // try (90 -> 94): 148 java/io/IOException
      // try (90 -> 94): 160 android/database/sqlite/SQLiteException
      // try (90 -> 94): 187 null
      // try (96 -> 100): 160 android/database/sqlite/SQLiteException
      // try (96 -> 100): 187 null
      // try (102 -> 108): 160 android/database/sqlite/SQLiteException
      // try (102 -> 108): 187 null
      // try (114 -> 116): 160 android/database/sqlite/SQLiteException
      // try (114 -> 116): 187 null
      // try (118 -> 120): 160 android/database/sqlite/SQLiteException
      // try (118 -> 120): 187 null
      // try (122 -> 128): 160 android/database/sqlite/SQLiteException
      // try (122 -> 128): 187 null
      // try (130 -> 134): 160 android/database/sqlite/SQLiteException
      // try (130 -> 134): 187 null
      // try (136 -> 139): 160 android/database/sqlite/SQLiteException
      // try (136 -> 139): 187 null
      // try (151 -> 159): 160 android/database/sqlite/SQLiteException
      // try (151 -> 159): 187 null
      // try (163 -> 171): 187 null
   }

   protected final long h(String param1, String param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aload 1
      // 001: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/String;)Ljava/lang/String;
      // 004: pop
      // 005: aload 2
      // 006: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/String;)Ljava/lang/String;
      // 009: pop
      // 00a: aload 0
      // 00b: invokevirtual com/google/android/gms/internal/zzcjk.c ()V
      // 00e: aload 0
      // 00f: invokevirtual com/google/android/gms/internal/zzcjl.Q ()V
      // 012: aload 0
      // 013: invokevirtual com/google/android/gms/internal/zzcgo.A ()Landroid/database/sqlite/SQLiteDatabase;
      // 016: astore 9
      // 018: aload 9
      // 01a: invokevirtual android/database/sqlite/SQLiteDatabase.beginTransaction ()V
      // 01d: aload 2
      // 01e: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 021: invokevirtual java/lang/String.length ()I
      // 024: istore 3
      // 025: new java/lang/StringBuilder
      // 028: astore 8
      // 02a: aload 8
      // 02c: iload 3
      // 02d: bipush 32
      // 02f: iadd
      // 030: invokespecial java/lang/StringBuilder.<init> (I)V
      // 033: aload 0
      // 034: aload 8
      // 036: ldc_w "select "
      // 039: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 03c: aload 2
      // 03d: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 040: ldc_w " from app2 where app_id=?"
      // 043: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 046: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 049: bipush 1
      // 04a: anewarray 19
      // 04d: dup
      // 04e: bipush 0
      // 04f: aload 1
      // 050: aastore
      // 051: ldc2_w -1
      // 054: invokespecial com/google/android/gms/internal/zzcgo.a (Ljava/lang/String;[Ljava/lang/String;J)J
      // 057: lstore 6
      // 059: lload 6
      // 05b: lstore 4
      // 05d: lload 6
      // 05f: ldc2_w -1
      // 062: lcmp
      // 063: ifne 0c5
      // 066: new android/content/ContentValues
      // 069: astore 8
      // 06b: aload 8
      // 06d: invokespecial android/content/ContentValues.<init> ()V
      // 070: aload 8
      // 072: ldc_w "app_id"
      // 075: aload 1
      // 076: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/String;)V
      // 079: aload 8
      // 07b: ldc_w "first_open_count"
      // 07e: bipush 0
      // 07f: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 082: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/Integer;)V
      // 085: aload 8
      // 087: ldc "previous_install_count"
      // 089: bipush 0
      // 08a: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 08d: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/Integer;)V
      // 090: aload 9
      // 092: ldc_w "app2"
      // 095: aconst_null
      // 096: aload 8
      // 098: bipush 5
      // 099: invokevirtual android/database/sqlite/SQLiteDatabase.insertWithOnConflict (Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J
      // 09c: ldc2_w -1
      // 09f: lcmp
      // 0a0: ifne 0c2
      // 0a3: aload 0
      // 0a4: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 0a7: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 0aa: ldc_w "Failed to insert column (got -1). appId"
      // 0ad: aload 1
      // 0ae: invokestatic com/google/android/gms/internal/zzchm.a (Ljava/lang/String;)Ljava/lang/Object;
      // 0b1: aload 2
      // 0b2: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
      // 0b5: aload 9
      // 0b7: invokevirtual android/database/sqlite/SQLiteDatabase.endTransaction ()V
      // 0ba: ldc2_w -1
      // 0bd: lstore 4
      // 0bf: lload 4
      // 0c1: lreturn
      // 0c2: lconst_0
      // 0c3: lstore 4
      // 0c5: new android/content/ContentValues
      // 0c8: astore 8
      // 0ca: aload 8
      // 0cc: invokespecial android/content/ContentValues.<init> ()V
      // 0cf: aload 8
      // 0d1: ldc_w "app_id"
      // 0d4: aload 1
      // 0d5: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/String;)V
      // 0d8: aload 8
      // 0da: aload 2
      // 0db: lconst_1
      // 0dc: lload 4
      // 0de: ladd
      // 0df: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 0e2: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/Long;)V
      // 0e5: aload 9
      // 0e7: ldc_w "app2"
      // 0ea: aload 8
      // 0ec: ldc_w "app_id = ?"
      // 0ef: bipush 1
      // 0f0: anewarray 19
      // 0f3: dup
      // 0f4: bipush 0
      // 0f5: aload 1
      // 0f6: aastore
      // 0f7: invokevirtual android/database/sqlite/SQLiteDatabase.update (Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
      // 0fa: i2l
      // 0fb: lconst_0
      // 0fc: lcmp
      // 0fd: ifne 11f
      // 100: aload 0
      // 101: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 104: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 107: ldc_w "Failed to update column (got 0). appId"
      // 10a: aload 1
      // 10b: invokestatic com/google/android/gms/internal/zzchm.a (Ljava/lang/String;)Ljava/lang/Object;
      // 10e: aload 2
      // 10f: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
      // 112: aload 9
      // 114: invokevirtual android/database/sqlite/SQLiteDatabase.endTransaction ()V
      // 117: ldc2_w -1
      // 11a: lstore 4
      // 11c: goto 0bf
      // 11f: aload 9
      // 121: invokevirtual android/database/sqlite/SQLiteDatabase.setTransactionSuccessful ()V
      // 124: aload 9
      // 126: invokevirtual android/database/sqlite/SQLiteDatabase.endTransaction ()V
      // 129: goto 0bf
      // 12c: astore 8
      // 12e: lconst_0
      // 12f: lstore 4
      // 131: aload 0
      // 132: invokevirtual com/google/android/gms/internal/zzcjk.t ()Lcom/google/android/gms/internal/zzchm;
      // 135: invokevirtual com/google/android/gms/internal/zzchm.y ()Lcom/google/android/gms/internal/zzcho;
      // 138: ldc_w "Error inserting column. appId"
      // 13b: aload 1
      // 13c: invokestatic com/google/android/gms/internal/zzchm.a (Ljava/lang/String;)Ljava/lang/Object;
      // 13f: aload 2
      // 140: aload 8
      // 142: invokevirtual com/google/android/gms/internal/zzcho.a (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
      // 145: aload 9
      // 147: invokevirtual android/database/sqlite/SQLiteDatabase.endTransaction ()V
      // 14a: goto 0bf
      // 14d: astore 1
      // 14e: aload 9
      // 150: invokevirtual android/database/sqlite/SQLiteDatabase.endTransaction ()V
      // 153: aload 1
      // 154: athrow
      // 155: astore 8
      // 157: goto 131
      // try (15 -> 44): 141 android/database/sqlite/SQLiteException
      // try (15 -> 44): 156 null
      // try (50 -> 85): 141 android/database/sqlite/SQLiteException
      // try (50 -> 85): 156 null
      // try (93 -> 131): 161 android/database/sqlite/SQLiteException
      // try (93 -> 131): 156 null
      // try (136 -> 138): 161 android/database/sqlite/SQLiteException
      // try (136 -> 138): 156 null
      // try (144 -> 153): 156 null
   }

   @Override
   protected final boolean w() {
      return false;
   }

   public final void x() {
      this.Q();
      this.A().beginTransaction();
   }

   public final void y() {
      this.Q();
      this.A().setTransactionSuccessful();
   }

   public final void z() {
      this.Q();
      this.A().endTransaction();
   }
}
