package com.jibo.db;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import com.jibo.utils.LogUtils;

public class DatabaseProvider extends ContentProvider {
   private static final String a = LogUtils.a(DatabaseProvider.class);
   private static final UriMatcher b = a();
   private DatabaseHelper c;

   private static UriMatcher a() {
      UriMatcher var0 = new UriMatcher(-1);
      var0.addURI("com.jibo.provider.db", "entity", 100);
      var0.addURI("com.jibo.provider.db", "entity/#", 101);
      var0.addURI("com.jibo.provider.db", "entity/#/*", 102);
      var0.addURI("com.jibo.provider.db", "log_entries", 400);
      var0.addURI("com.jibo.provider.db", "log_entries/#", 401);
      var0.addURI("com.jibo.provider.db", "media", 300);
      var0.addURI("com.jibo.provider.db", "media/*", 301);
      var0.addURI("com.jibo.provider.db", "jot", 200);
      var0.addURI("com.jibo.provider.db", "jot/*", 201);
      return var0;
   }

   private SelectionBuilder a(Uri var1) {
      SelectionBuilder var2 = new SelectionBuilder();
      SelectionBuilder var3;
      switch (b.match(var1)) {
         case 100:
            var3 = var2.a("entity").b("type ASC");
            break;
         case 101:
            var3 = var2.a("entity").a("type=?", (String)var1.getPathSegments().get(1));
            break;
         case 102:
            var3 = var2.a("entity").a("type=?", (String)var1.getPathSegments().get(1)).c("_id=?", (String)var1.getPathSegments().get(2));
            break;
         case 200:
            var3 = var2.a("jot");
            break;
         case 201:
            var3 = var2.a("jot").a("_id=?", (String)var1.getPathSegments().get(1));
            break;
         case 300:
            var3 = var2.a("media").b("created DESC");
            break;
         case 301:
            var3 = var2.a("media").a("_id=?", (String)var1.getPathSegments().get(1));
            break;
         case 400:
            var3 = var2.a("log_entry");
            break;
         case 401:
            var3 = var2.a("log_entry").a("_id=?", (String)var1.getPathSegments().get(1));
            break;
         default:
            throw new UnsupportedOperationException("Unknown uri: " + var1);
      }

      return var3;
   }

   public int bulkInsert(Uri param1, ContentValues[] param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aload 0
      // 001: getfield com/jibo/db/DatabaseProvider.c Lcom/jibo/db/DatabaseHelper;
      // 004: invokevirtual com/jibo/db/DatabaseHelper.getWritableDatabase ()Landroid/database/sqlite/SQLiteDatabase;
      // 007: astore 9
      // 009: getstatic com/jibo/db/DatabaseProvider.b Landroid/content/UriMatcher;
      // 00c: aload 1
      // 00d: invokevirtual android/content/UriMatcher.match (Landroid/net/Uri;)I
      // 010: istore 6
      // 012: aload 9
      // 014: invokevirtual android/database/sqlite/SQLiteDatabase.beginTransaction ()V
      // 017: iload 6
      // 019: lookupswitch 67 7 100 113 101 113 200 189 201 189 300 196 301 196 400 182
      // 05c: new java/lang/UnsupportedOperationException
      // 05f: astore 2
      // 060: new java/lang/StringBuilder
      // 063: astore 8
      // 065: aload 8
      // 067: invokespecial java/lang/StringBuilder.<init> ()V
      // 06a: aload 2
      // 06b: aload 8
      // 06d: ldc "Unknown uri: "
      // 06f: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 072: aload 1
      // 073: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 076: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 079: invokespecial java/lang/UnsupportedOperationException.<init> (Ljava/lang/String;)V
      // 07c: aload 2
      // 07d: athrow
      // 07e: astore 1
      // 07f: aload 9
      // 081: invokevirtual android/database/sqlite/SQLiteDatabase.endTransaction ()V
      // 084: bipush 0
      // 085: istore 4
      // 087: iload 4
      // 089: ireturn
      // 08a: ldc "entity"
      // 08c: astore 8
      // 08e: aload 2
      // 08f: ifnull 0e4
      // 092: aload 8
      // 094: ifnull 0e4
      // 097: aload 2
      // 098: arraylength
      // 099: istore 7
      // 09b: bipush 0
      // 09c: istore 5
      // 09e: bipush 0
      // 09f: istore 3
      // 0a0: iload 3
      // 0a1: istore 4
      // 0a3: iload 5
      // 0a5: iload 7
      // 0a7: if_icmpge 0e7
      // 0aa: iload 3
      // 0ab: istore 4
      // 0ad: aload 9
      // 0af: aload 8
      // 0b1: aconst_null
      // 0b2: aload 2
      // 0b3: iload 5
      // 0b5: aaload
      // 0b6: bipush 5
      // 0b7: invokevirtual android/database/sqlite/SQLiteDatabase.insertWithOnConflict (Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J
      // 0ba: ldc2_w -1
      // 0bd: lcmp
      // 0be: ifeq 0c6
      // 0c1: iload 3
      // 0c2: bipush 1
      // 0c3: iadd
      // 0c4: istore 4
      // 0c6: iinc 5 1
      // 0c9: iload 4
      // 0cb: istore 3
      // 0cc: goto 0a0
      // 0cf: ldc "log_entry"
      // 0d1: astore 8
      // 0d3: goto 08e
      // 0d6: ldc "jot"
      // 0d8: astore 8
      // 0da: goto 08e
      // 0dd: ldc "media"
      // 0df: astore 8
      // 0e1: goto 08e
      // 0e4: bipush 0
      // 0e5: istore 4
      // 0e7: aload 9
      // 0e9: invokevirtual android/database/sqlite/SQLiteDatabase.setTransactionSuccessful ()V
      // 0ec: aload 0
      // 0ed: invokevirtual com/jibo/db/DatabaseProvider.getContext ()Landroid/content/Context;
      // 0f0: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 0f3: aload 1
      // 0f4: aconst_null
      // 0f5: invokevirtual android/content/ContentResolver.notifyChange (Landroid/net/Uri;Landroid/database/ContentObserver;)V
      // 0f8: iload 6
      // 0fa: sipush 200
      // 0fd: if_icmpne 10e
      // 100: aload 0
      // 101: invokevirtual com/jibo/db/DatabaseProvider.getContext ()Landroid/content/Context;
      // 104: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 107: getstatic com/jibo/db/DatabaseContract.b Landroid/net/Uri;
      // 10a: aconst_null
      // 10b: invokevirtual android/content/ContentResolver.notifyChange (Landroid/net/Uri;Landroid/database/ContentObserver;)V
      // 10e: aload 9
      // 110: invokevirtual android/database/sqlite/SQLiteDatabase.endTransaction ()V
      // 113: goto 087
      // 116: astore 1
      // 117: getstatic com/jibo/db/DatabaseProvider.a Ljava/lang/String;
      // 11a: ldc "bulkInsert"
      // 11c: aload 1
      // 11d: invokestatic com/jibo/utils/LogUtils.a (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      // 120: aload 9
      // 122: invokevirtual android/database/sqlite/SQLiteDatabase.endTransaction ()V
      // 125: bipush 0
      // 126: istore 4
      // 128: goto 087
      // 12b: astore 1
      // 12c: aload 9
      // 12e: invokevirtual android/database/sqlite/SQLiteDatabase.endTransaction ()V
      // 131: aload 1
      // 132: athrow
      // try (12 -> 28): 28 java/lang/UnsupportedOperationException
      // try (12 -> 28): 105 java/lang/Exception
      // try (12 -> 28): 115 null
      // try (41 -> 44): 28 java/lang/UnsupportedOperationException
      // try (41 -> 44): 105 java/lang/Exception
      // try (41 -> 44): 115 null
      // try (55 -> 66): 28 java/lang/UnsupportedOperationException
      // try (55 -> 66): 105 java/lang/Exception
      // try (55 -> 66): 115 null
      // try (85 -> 93): 28 java/lang/UnsupportedOperationException
      // try (85 -> 93): 105 java/lang/Exception
      // try (85 -> 93): 115 null
      // try (96 -> 102): 28 java/lang/UnsupportedOperationException
      // try (96 -> 102): 105 java/lang/Exception
      // try (96 -> 102): 115 null
      // try (106 -> 110): 115 null
   }

   public int delete(Uri var1, String var2, String[] var3) {
      int var4;
      try {
         SQLiteDatabase var5 = this.c.getWritableDatabase();
         var4 = this.a(var1).a(var2, var3).a(var5);
         this.getContext().getContentResolver().notifyChange(var1, null);
      } catch (Exception var6) {
         var4 = 0;
      }

      return var4;
   }

   public String getType(Uri var1) {
      String var2;
      switch (b.match(var1)) {
         case 100:
         case 101:
         case 102:
            var2 = "com.jibo.provider.db/entity";
            break;
         case 200:
         case 201:
            var2 = "com.jibo.provider.db/jot";
            break;
         case 300:
         case 301:
            var2 = "com.jibo.provider.db/media";
            break;
         case 400:
         case 401:
            var2 = "vnd.android.cursor.dir/vnd.logprovider.entries";
            break;
         default:
            throw new UnsupportedOperationException("Unknown uri: " + var1);
      }

      return var2;
   }

   public Uri insert(Uri var1, ContentValues var2) {
      SQLiteDatabase var5 = this.c.getWritableDatabase();
      Uri var6;
      switch (b.match(var1)) {
         case 100:
         case 101:
         case 102:
            if (var5.insert("entity", null, var2) <= 0L) {
               throw new SQLException("Failed to insert row into " + var1);
            }

            var6 = var1;
            break;
         case 200:
         case 201:
            if (var5.insert("jot", null, var2) <= 0L) {
               throw new SQLException("Failed to insert row into " + var1);
            }

            this.getContext().getContentResolver().notifyChange(DatabaseContract.b, null);
            var6 = var1;
            break;
         case 300:
         case 301:
            if (var5.insert("media", null, var2) <= 0L) {
               throw new SQLException("Failed to insert row into " + var1);
            }

            var6 = var1;
            break;
         case 400:
            long var3 = var5.insert("log_entry", null, var2);
            if (var3 <= 0L) {
               throw new SQLException("Failed to insert row into " + var1);
            }

            var6 = DatabaseContract.LogEntry.a(var3);
            break;
         default:
            throw new UnsupportedOperationException("Unknown uri: " + var1);
      }

      this.getContext().getContentResolver().notifyChange(var1, null);
      return var6;
   }

   public boolean onCreate() {
      this.c = DatabaseHelper.a(this.getContext());
      return true;
   }

   public Cursor query(Uri var1, String[] var2, String var3, String[] var4, String var5) {
      SQLiteDatabase var7 = this.c.getReadableDatabase();
      SelectionBuilder var6 = this.a(var1);
      Cursor var8;
      if (!TextUtils.isEmpty(var6.a())) {
         var8 = var6.a(var3, var4).a(var7, var2, null, null, var5, var6.a());
      } else {
         var8 = var6.a(var3, var4).a(var7, var2, var5);
      }

      var8.setNotificationUri(this.getContext().getContentResolver(), var1);
      return var8;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public int update(Uri var1, ContentValues var2, String var3, String[] var4) {
      int var6;
      int var7;
      try {
         SQLiteDatabase var8 = this.c.getWritableDatabase();
         var6 = this.a(var1).a(var3, var4).a(var8, var2);
         this.getContext().getContentResolver().notifyChange(var1, null);
         var7 = b.match(var1);
      } catch (Exception var10) {
         return 0;
      }

      if (var7 != 200) {
         int var5 = var6;
         if (var7 != 201) {
            return var5;
         }
      }

      try {
         this.getContext().getContentResolver().notifyChange(DatabaseContract.JotEntry.a, null);
         this.getContext().getContentResolver().notifyChange(DatabaseContract.b, null);
      } catch (Exception var9) {
         byte var11 = 0;
         return var11;
      }

      return var6;
   }
}
