package com.jibo.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.handlers.AsyncHandler;
import com.crashlytics.android.Crashlytics;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.account.JiboAccountAsyncClient;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.account.model.GetRequest;
import com.jibo.aws.integration.aws.services.account.model.UpdateRequest;
import com.jibo.aws.integration.aws.services.gqa.JiboGQAAsyncClient;
import com.jibo.aws.integration.aws.services.jot.model.Message;
import com.jibo.aws.integration.aws.services.key.JiboKeyAsyncClient;
import com.jibo.aws.integration.aws.services.loop.JiboLoopAsyncClient;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.loop.model.Member;
import com.jibo.aws.integration.aws.services.media.JiboMediaAsyncClient;
import com.jibo.aws.integration.aws.services.media.model.Media;
import com.jibo.aws.integration.aws.services.push.JiboPushAsyncClient;
import com.jibo.aws.integration.aws.services.robotProperties.JiboRobotPropertiesAsyncClient;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.aws.integration.util.Commons;
import com.jibo.utils.LogUtils;
import com.jibo.utils.SharedPreferencesUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EntityData {
   public static final String a = LogUtils.a(EntityData.class);
   private static volatile EntityData b;
   private static Context c;
   private static final Gson l = new Gson();
   private volatile Account d;
   private volatile JiboAccountAsyncClient e;
   private volatile JiboLoopAsyncClient f;
   private volatile JiboGQAAsyncClient g;
   private volatile JiboKeyAsyncClient h;
   private volatile JiboMediaAsyncClient i;
   private volatile JiboPushAsyncClient j;
   private volatile JiboRobotPropertiesAsyncClient k;

   private EntityData(Context var1) {
      if (var1 != null) {
         var1 = var1.getApplicationContext();
      } else {
         var1 = null;
      }

      c = var1;
      this.m();
   }

   public static Loop a(Cursor var0) {
      try {
         return l.a(var0.getString(var0.getColumnIndex("data")), Loop.class);
      } catch (Exception var3) {
         Crashlytics.a(var3);
      } finally {
         ;
      }

      return null;
   }

   public static EntityData a(Context param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: ldc com/jibo/db/EntityData
      // 02: monitorenter
      // 03: getstatic com/jibo/db/EntityData.b Lcom/jibo/db/EntityData;
      // 06: astore 2
      // 07: aload 2
      // 08: astore 1
      // 09: aload 2
      // 0a: ifnonnull 2a
      // 0d: ldc com/jibo/db/EntityData
      // 0f: monitorenter
      // 10: getstatic com/jibo/db/EntityData.b Lcom/jibo/db/EntityData;
      // 13: astore 2
      // 14: aload 2
      // 15: astore 1
      // 16: aload 2
      // 17: ifnonnull 27
      // 1a: new com/jibo/db/EntityData
      // 1d: astore 1
      // 1e: aload 1
      // 1f: aload 0
      // 20: invokespecial com/jibo/db/EntityData.<init> (Landroid/content/Context;)V
      // 23: aload 1
      // 24: putstatic com/jibo/db/EntityData.b Lcom/jibo/db/EntityData;
      // 27: ldc com/jibo/db/EntityData
      // 29: monitorexit
      // 2a: ldc com/jibo/db/EntityData
      // 2c: monitorexit
      // 2d: aload 1
      // 2e: areturn
      // 2f: astore 0
      // 30: ldc com/jibo/db/EntityData
      // 32: monitorexit
      // 33: aload 0
      // 34: athrow
      // 35: astore 0
      // 36: ldc com/jibo/db/EntityData
      // 38: monitorexit
      // 39: aload 0
      // 3a: athrow
      // try (2 -> 4): 34 null
      // try (8 -> 10): 34 null
      // try (10 -> 12): 29 null
      // try (16 -> 23): 29 null
      // try (23 -> 25): 29 null
      // try (30 -> 32): 29 null
      // try (32 -> 34): 34 null
   }

   private void a(String param1, boolean param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: iload 2
      // 01: ifeq 9a
      // 04: aconst_null
      // 05: astore 3
      // 06: aconst_null
      // 07: astore 4
      // 09: getstatic com/jibo/db/EntityData.c Landroid/content/Context;
      // 0c: invokestatic com/jibo/db/DatabaseHelper.a (Landroid/content/Context;)Lcom/jibo/db/DatabaseHelper;
      // 0f: invokevirtual com/jibo/db/DatabaseHelper.getWritableDatabase ()Landroid/database/sqlite/SQLiteDatabase;
      // 12: astore 5
      // 14: aload 5
      // 16: astore 4
      // 18: aload 5
      // 1a: astore 3
      // 1b: new com/jibo/db/SelectionBuilder
      // 1e: astore 6
      // 20: aload 5
      // 22: astore 4
      // 24: aload 5
      // 26: astore 3
      // 27: aload 6
      // 29: invokespecial com/jibo/db/SelectionBuilder.<init> ()V
      // 2c: aload 5
      // 2e: astore 4
      // 30: aload 5
      // 32: astore 3
      // 33: aload 5
      // 35: invokevirtual android/database/sqlite/SQLiteDatabase.beginTransaction ()V
      // 38: aload 5
      // 3a: astore 4
      // 3c: aload 5
      // 3e: astore 3
      // 3f: aload 6
      // 41: ldc "media"
      // 43: invokevirtual com/jibo/db/SelectionBuilder.a (Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;
      // 46: ldc "loopId = ?"
      // 48: bipush 1
      // 49: anewarray 127
      // 4c: dup
      // 4d: bipush 0
      // 4e: aload 1
      // 4f: aastore
      // 50: invokevirtual com/jibo/db/SelectionBuilder.a (Ljava/lang/String;[Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;
      // 53: pop
      // 54: aload 5
      // 56: astore 4
      // 58: aload 5
      // 5a: astore 3
      // 5b: aload 6
      // 5d: aload 5
      // 5f: invokevirtual com/jibo/db/SelectionBuilder.a (Landroid/database/sqlite/SQLiteDatabase;)I
      // 62: pop
      // 63: aload 5
      // 65: astore 4
      // 67: aload 5
      // 69: astore 3
      // 6a: aload 5
      // 6c: invokevirtual android/database/sqlite/SQLiteDatabase.setTransactionSuccessful ()V
      // 6f: aload 5
      // 71: ifnull 79
      // 74: aload 5
      // 76: invokevirtual android/database/sqlite/SQLiteDatabase.endTransaction ()V
      // 79: return
      // 7a: astore 1
      // 7b: aload 4
      // 7d: astore 3
      // 7e: aload 1
      // 7f: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // 82: aload 4
      // 84: ifnull 79
      // 87: aload 4
      // 89: invokevirtual android/database/sqlite/SQLiteDatabase.endTransaction ()V
      // 8c: goto 79
      // 8f: astore 1
      // 90: aload 3
      // 91: ifnull 98
      // 94: aload 3
      // 95: invokevirtual android/database/sqlite/SQLiteDatabase.endTransaction ()V
      // 98: aload 1
      // 99: athrow
      // 9a: getstatic com/jibo/db/EntityData.c Landroid/content/Context;
      // 9d: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // a0: getstatic com/jibo/db/DatabaseContract$MediaEntry.b Landroid/net/Uri;
      // a3: ldc "loopId = ?"
      // a5: bipush 1
      // a6: anewarray 127
      // a9: dup
      // aa: bipush 0
      // ab: aload 1
      // ac: aastore
      // ad: invokevirtual android/content/ContentResolver.delete (Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
      // b0: pop
      // b1: goto 79
      // b4: astore 1
      // b5: aload 1
      // b6: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // b9: goto 79
      // bc: astore 1
      // bd: aload 1
      // be: athrow
      // try (6 -> 10): 63 java/lang/Exception
      // try (6 -> 10): 73 null
      // try (14 -> 16): 63 java/lang/Exception
      // try (14 -> 16): 73 null
      // try (20 -> 22): 63 java/lang/Exception
      // try (20 -> 22): 73 null
      // try (26 -> 28): 63 java/lang/Exception
      // try (26 -> 28): 73 null
      // try (32 -> 44): 63 java/lang/Exception
      // try (32 -> 44): 73 null
      // try (48 -> 52): 63 java/lang/Exception
      // try (48 -> 52): 73 null
      // try (56 -> 58): 63 java/lang/Exception
      // try (56 -> 58): 73 null
      // try (66 -> 68): 73 null
      // try (80 -> 92): 93 java/lang/Exception
      // try (80 -> 92): 97 null
      // try (94 -> 96): 97 null
   }

   private void a(List<Account> param1, int param2) {
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
      // 000: bipush 0
      // 001: istore 3
      // 002: iload 2
      // 003: ifle 082
      // 006: getstatic com/jibo/db/EntityData.c Landroid/content/Context;
      // 009: invokestatic com/jibo/db/DatabaseHelper.a (Landroid/content/Context;)Lcom/jibo/db/DatabaseHelper;
      // 00c: invokevirtual com/jibo/db/DatabaseHelper.getWritableDatabase ()Landroid/database/sqlite/SQLiteDatabase;
      // 00f: astore 5
      // 011: new com/jibo/db/SelectionBuilder
      // 014: astore 4
      // 016: aload 4
      // 018: invokespecial com/jibo/db/SelectionBuilder.<init> ()V
      // 01b: aload 4
      // 01d: ldc "entity"
      // 01f: invokevirtual com/jibo/db/SelectionBuilder.a (Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;
      // 022: ldc "type=2"
      // 024: bipush 0
      // 025: anewarray 127
      // 028: invokevirtual com/jibo/db/SelectionBuilder.a (Ljava/lang/String;[Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;
      // 02b: pop
      // 02c: iload 2
      // 02d: bipush 2
      // 02e: iand
      // 02f: ifeq 0ad
      // 032: new java/lang/StringBuilder
      // 035: astore 6
      // 037: aload 6
      // 039: ldc "_id"
      // 03b: invokespecial java/lang/StringBuilder.<init> (Ljava/lang/String;)V
      // 03e: aload 6
      // 040: ldc " IN ("
      // 042: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 045: astore 6
      // 047: new java/util/ArrayList
      // 04a: astore 7
      // 04c: aload 7
      // 04e: invokespecial java/util/ArrayList.<init> ()V
      // 051: aload 1
      // 052: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 057: astore 8
      // 059: aload 8
      // 05b: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 060: ifeq 087
      // 063: aload 7
      // 065: aload 8
      // 067: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 06c: checkcast com/jibo/aws/integration/aws/services/account/model/Account
      // 06f: invokevirtual com/jibo/aws/integration/aws/services/account/model/Account.getId ()Ljava/lang/String;
      // 072: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 077: pop
      // 078: goto 059
      // 07b: astore 4
      // 07d: aload 4
      // 07f: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // 082: aload 1
      // 083: ifnonnull 0b8
      // 086: return
      // 087: aload 6
      // 089: ldc "'"
      // 08b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 08e: ldc "','"
      // 090: aload 7
      // 092: invokestatic android/text/TextUtils.join (Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
      // 095: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 098: ldc "')"
      // 09a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 09d: pop
      // 09e: aload 4
      // 0a0: aload 6
      // 0a2: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0a5: bipush 0
      // 0a6: anewarray 127
      // 0a9: invokevirtual com/jibo/db/SelectionBuilder.a (Ljava/lang/String;[Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;
      // 0ac: pop
      // 0ad: aload 4
      // 0af: aload 5
      // 0b1: invokevirtual com/jibo/db/SelectionBuilder.a (Landroid/database/sqlite/SQLiteDatabase;)I
      // 0b4: pop
      // 0b5: goto 082
      // 0b8: aload 1
      // 0b9: invokeinterface java/util/List.size ()I 1
      // 0be: anewarray 223
      // 0c1: astore 4
      // 0c3: iload 3
      // 0c4: istore 2
      // 0c5: iload 2
      // 0c6: aload 1
      // 0c7: invokeinterface java/util/List.size ()I 1
      // 0cc: if_icmpge 145
      // 0cf: aload 1
      // 0d0: iload 2
      // 0d1: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 0d6: checkcast com/jibo/aws/integration/aws/services/account/model/Account
      // 0d9: astore 5
      // 0db: aload 4
      // 0dd: iload 2
      // 0de: new android/content/ContentValues
      // 0e1: dup
      // 0e2: invokespecial android/content/ContentValues.<init> ()V
      // 0e5: aastore
      // 0e6: aload 4
      // 0e8: iload 2
      // 0e9: aaload
      // 0ea: ldc "_id"
      // 0ec: aload 5
      // 0ee: invokevirtual com/jibo/aws/integration/aws/services/account/model/Account.getId ()Ljava/lang/String;
      // 0f1: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/String;)V
      // 0f4: aload 4
      // 0f6: iload 2
      // 0f7: aaload
      // 0f8: ldc "name"
      // 0fa: aload 5
      // 0fc: invokevirtual com/jibo/aws/integration/aws/services/account/model/Account.getFullName ()Ljava/lang/String;
      // 0ff: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/String;)V
      // 102: aload 4
      // 104: iload 2
      // 105: aaload
      // 106: ldc "type"
      // 108: bipush 2
      // 109: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 10c: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/Integer;)V
      // 10f: aload 4
      // 111: iload 2
      // 112: aaload
      // 113: ldc "modified"
      // 115: invokestatic java/lang/System.currentTimeMillis ()J
      // 118: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 11b: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/Long;)V
      // 11e: aload 4
      // 120: iload 2
      // 121: aaload
      // 122: ldc_w "retrieved"
      // 125: invokestatic java/lang/System.currentTimeMillis ()J
      // 128: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 12b: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/Long;)V
      // 12e: aload 4
      // 130: iload 2
      // 131: aaload
      // 132: ldc "data"
      // 134: getstatic com/jibo/db/EntityData.l Lcom/google/gson/Gson;
      // 137: aload 5
      // 139: invokevirtual com/google/gson/Gson.b (Ljava/lang/Object;)Ljava/lang/String;
      // 13c: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/String;)V
      // 13f: iinc 2 1
      // 142: goto 0c5
      // 145: getstatic com/jibo/db/EntityData.c Landroid/content/Context;
      // 148: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 14b: bipush 2
      // 14c: invokestatic com/jibo/db/DatabaseContract$EntityEntry.a (I)Landroid/net/Uri;
      // 14f: aload 4
      // 151: invokevirtual android/content/ContentResolver.bulkInsert (Landroid/net/Uri;[Landroid/content/ContentValues;)I
      // 154: pop
      // 155: goto 086
      // 158: astore 1
      // 159: aload 1
      // 15a: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // 15d: goto 086
      // 160: astore 1
      // 161: aload 1
      // 162: athrow
      // try (4 -> 20): 51 java/lang/Exception
      // try (24 -> 40): 51 java/lang/Exception
      // try (40 -> 50): 51 java/lang/Exception
      // try (57 -> 74): 51 java/lang/Exception
      // try (74 -> 78): 51 java/lang/Exception
      // try (145 -> 152): 153 java/lang/Exception
      // try (145 -> 152): 157 null
      // try (154 -> 156): 157 null
   }

   public static Message b(Cursor param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: bipush 1
      // 001: istore 1
      // 002: new com/jibo/aws/integration/aws/services/jot/model/Message
      // 005: dup
      // 006: invokespecial com/jibo/aws/integration/aws/services/jot/model/Message.<init> ()V
      // 009: astore 2
      // 00a: aload 2
      // 00b: aload 0
      // 00c: aload 0
      // 00d: ldc "_id"
      // 00f: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
      // 014: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 019: invokevirtual com/jibo/aws/integration/aws/services/jot/model/Message.setId (Ljava/lang/String;)V
      // 01c: aload 2
      // 01d: aload 0
      // 01e: aload 0
      // 01f: ldc_w "loopId"
      // 022: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
      // 027: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 02c: invokevirtual com/jibo/aws/integration/aws/services/jot/model/Message.setLoopId (Ljava/lang/String;)V
      // 02f: aload 2
      // 030: aload 0
      // 031: aload 0
      // 032: ldc_w "content"
      // 035: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
      // 03a: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 03f: invokevirtual com/jibo/aws/integration/aws/services/jot/model/Message.setContent (Ljava/lang/String;)V
      // 042: aload 2
      // 043: aload 0
      // 044: aload 0
      // 045: ldc_w "sender"
      // 048: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
      // 04d: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 052: invokevirtual com/jibo/aws/integration/aws/services/jot/model/Message.setSender (Ljava/lang/String;)V
      // 055: aload 2
      // 056: aload 0
      // 057: aload 0
      // 058: ldc_w "created"
      // 05b: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
      // 060: invokeinterface android/database/Cursor.getLong (I)J 2
      // 065: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 068: invokevirtual com/jibo/aws/integration/aws/services/jot/model/Message.setCreated (Ljava/lang/Long;)V
      // 06b: aload 0
      // 06c: aload 0
      // 06d: ldc_w "is_read"
      // 070: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
      // 075: invokeinterface android/database/Cursor.getInt (I)I 2
      // 07a: bipush 1
      // 07b: if_icmpne 142
      // 07e: aload 2
      // 07f: iload 1
      // 080: invokevirtual com/jibo/aws/integration/aws/services/jot/model/Message.setRead (Z)V
      // 083: aload 0
      // 084: aload 0
      // 085: ldc_w "parts"
      // 088: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
      // 08d: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 092: invokestatic android/text/TextUtils.isEmpty (Ljava/lang/CharSequence;)Z
      // 095: ifne 0e2
      // 098: ldc_w "[]"
      // 09b: aload 0
      // 09c: aload 0
      // 09d: ldc_w "parts"
      // 0a0: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
      // 0a5: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 0aa: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0ad: istore 1
      // 0ae: iload 1
      // 0af: ifne 0e2
      // 0b2: getstatic com/jibo/db/EntityData.l Lcom/google/gson/Gson;
      // 0b5: astore 4
      // 0b7: aload 0
      // 0b8: aload 0
      // 0b9: ldc_w "parts"
      // 0bc: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
      // 0c1: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 0c6: astore 5
      // 0c8: new com/jibo/db/EntityData$2
      // 0cb: astore 3
      // 0cc: aload 3
      // 0cd: invokespecial com/jibo/db/EntityData$2.<init> ()V
      // 0d0: aload 2
      // 0d1: aload 4
      // 0d3: aload 5
      // 0d5: aload 3
      // 0d6: invokevirtual com/jibo/db/EntityData$2.getType ()Ljava/lang/reflect/Type;
      // 0d9: invokevirtual com/google/gson/Gson.a (Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;
      // 0dc: checkcast java/util/List
      // 0df: invokevirtual com/jibo/aws/integration/aws/services/jot/model/Message.setParts (Ljava/util/List;)V
      // 0e2: aload 0
      // 0e3: aload 0
      // 0e4: ldc_w "tags"
      // 0e7: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
      // 0ec: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 0f1: invokestatic android/text/TextUtils.isEmpty (Ljava/lang/CharSequence;)Z
      // 0f4: ifne 140
      // 0f7: ldc_w "[]"
      // 0fa: aload 0
      // 0fb: aload 0
      // 0fc: ldc_w "tags"
      // 0ff: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
      // 104: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 109: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 10c: istore 1
      // 10d: iload 1
      // 10e: ifne 140
      // 111: getstatic com/jibo/db/EntityData.l Lcom/google/gson/Gson;
      // 114: astore 3
      // 115: aload 0
      // 116: aload 0
      // 117: ldc_w "tags"
      // 11a: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
      // 11f: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 124: astore 0
      // 125: new com/jibo/db/EntityData$3
      // 128: astore 4
      // 12a: aload 4
      // 12c: invokespecial com/jibo/db/EntityData$3.<init> ()V
      // 12f: aload 2
      // 130: aload 3
      // 131: aload 0
      // 132: aload 4
      // 134: invokevirtual com/jibo/db/EntityData$3.getType ()Ljava/lang/reflect/Type;
      // 137: invokevirtual com/google/gson/Gson.a (Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;
      // 13a: checkcast java/util/List
      // 13d: invokevirtual com/jibo/aws/integration/aws/services/jot/model/Message.setTags (Ljava/util/List;)V
      // 140: aload 2
      // 141: areturn
      // 142: bipush 0
      // 143: istore 1
      // 144: goto 07e
      // 147: astore 3
      // 148: aload 3
      // 149: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // 14c: goto 0e2
      // 14f: astore 0
      // 150: aload 0
      // 151: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // 154: goto 140
      // 157: astore 0
      // 158: aload 0
      // 159: athrow
      // 15a: astore 0
      // 15b: aload 0
      // 15c: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // 15f: goto 140
      // try (6 -> 49): 135 java/lang/Exception
      // try (6 -> 49): 139 null
      // try (49 -> 67): 135 java/lang/Exception
      // try (49 -> 67): 139 null
      // try (69 -> 89): 131 java/lang/Exception
      // try (69 -> 89): 139 null
      // try (89 -> 104): 135 java/lang/Exception
      // try (89 -> 104): 139 null
      // try (106 -> 126): 142 java/lang/Exception
      // try (106 -> 126): 139 null
      // try (132 -> 134): 135 java/lang/Exception
      // try (132 -> 134): 139 null
      // try (136 -> 138): 139 null
      // try (143 -> 145): 135 java/lang/Exception
      // try (143 -> 145): 139 null
   }

   private void b(Loop var1) {
      if (var1 != null) {
         List var2 = LoopHelper.getAccountIds(var1, Member.InvitationStatus.accepted);
         this.a(this.a().get(var2), 2);
      }
   }

   private void b(Loop param1, boolean param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aload 1
      // 001: aload 0
      // 002: invokevirtual com/jibo/db/EntityData.i ()Lcom/jibo/aws/integration/aws/services/account/model/Account;
      // 005: invokevirtual com/jibo/aws/integration/aws/services/account/model/Account.getEmail ()Ljava/lang/String;
      // 008: invokestatic com/jibo/aws/integration/helpers/LoopHelper.isMemberAccepted (Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z
      // 00b: ifne 00f
      // 00e: return
      // 00f: bipush 1
      // 010: istore 3
      // 011: new java/util/ArrayList
      // 014: dup
      // 015: invokespecial java/util/ArrayList.<init> ()V
      // 018: astore 8
      // 01a: aload 8
      // 01c: aload 1
      // 01d: invokevirtual com/jibo/aws/integration/aws/services/loop/model/Loop.getId ()Ljava/lang/String;
      // 020: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 025: pop
      // 026: new java/util/ArrayList
      // 029: dup
      // 02a: invokespecial java/util/ArrayList.<init> ()V
      // 02d: astore 4
      // 02f: aload 4
      // 031: new com/jibo/aws/integration/aws/services/media/model/Media
      // 034: dup
      // 035: invokespecial com/jibo/aws/integration/aws/services/media/model/Media.<init> ()V
      // 038: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 03d: pop
      // 03e: aload 4
      // 040: invokeinterface java/util/List.size ()I 1
      // 045: ifeq 00e
      // 048: aload 1
      // 049: invokevirtual com/jibo/aws/integration/aws/services/loop/model/Loop.getId ()Ljava/lang/String;
      // 04c: astore 5
      // 04e: aconst_null
      // 04f: astore 6
      // 051: iload 3
      // 052: ifeq 0d5
      // 055: iload 2
      // 056: ifeq 0d5
      // 059: aload 0
      // 05a: invokevirtual com/jibo/db/EntityData.e ()Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;
      // 05d: aload 8
      // 05f: aconst_null
      // 060: aconst_null
      // 061: invokevirtual com/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient.list (Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;)Ljava/util/List;
      // 064: astore 5
      // 066: aload 0
      // 067: aload 1
      // 068: invokevirtual com/jibo/aws/integration/aws/services/loop/model/Loop.getId ()Ljava/lang/String;
      // 06b: bipush 1
      // 06c: invokespecial com/jibo/db/EntityData.a (Ljava/lang/String;Z)V
      // 06f: aconst_null
      // 070: astore 6
      // 072: aload 5
      // 074: astore 4
      // 076: aload 6
      // 078: astore 5
      // 07a: aload 5
      // 07c: astore 7
      // 07e: aload 4
      // 080: invokeinterface java/util/List.size ()I 1
      // 085: ifle 156
      // 088: aload 5
      // 08a: astore 7
      // 08c: aload 4
      // 08e: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 093: astore 6
      // 095: aload 5
      // 097: astore 7
      // 099: aload 6
      // 09b: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0a0: ifeq 14b
      // 0a3: aload 5
      // 0a5: astore 7
      // 0a7: aload 6
      // 0a9: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0ae: checkcast com/jibo/aws/integration/aws/services/media/model/Media
      // 0b1: aload 1
      // 0b2: invokevirtual com/jibo/aws/integration/aws/services/loop/model/Loop.getId ()Ljava/lang/String;
      // 0b5: invokevirtual com/jibo/aws/integration/aws/services/media/model/Media.setLoopId (Ljava/lang/String;)V
      // 0b8: goto 095
      // 0bb: astore 6
      // 0bd: aload 5
      // 0bf: astore 7
      // 0c1: aload 6
      // 0c3: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // 0c6: aload 5
      // 0c8: ifnull 1a7
      // 0cb: aload 5
      // 0cd: invokeinterface android/database/Cursor.close ()V 1
      // 0d2: goto 03e
      // 0d5: getstatic com/jibo/db/EntityData.c Landroid/content/Context;
      // 0d8: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 0db: getstatic com/jibo/db/DatabaseContract$MediaEntry.b Landroid/net/Uri;
      // 0de: bipush 2
      // 0df: anewarray 127
      // 0e2: dup
      // 0e3: bipush 0
      // 0e4: ldc "_id"
      // 0e6: aastore
      // 0e7: dup
      // 0e8: bipush 1
      // 0e9: ldc_w "created"
      // 0ec: aastore
      // 0ed: ldc "loopId = ?"
      // 0ef: bipush 1
      // 0f0: anewarray 127
      // 0f3: dup
      // 0f4: bipush 0
      // 0f5: aload 5
      // 0f7: aastore
      // 0f8: ldc_w "created DESC LIMIT 1"
      // 0fb: invokevirtual android/content/ContentResolver.query (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      // 0fe: astore 5
      // 100: aload 5
      // 102: ifnull 137
      // 105: aload 5
      // 107: invokeinterface android/database/Cursor.isClosed ()Z 1
      // 10c: ifne 137
      // 10f: aload 5
      // 111: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 116: ifeq 137
      // 119: aload 0
      // 11a: invokevirtual com/jibo/db/EntityData.e ()Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;
      // 11d: aload 8
      // 11f: aload 5
      // 121: bipush 1
      // 122: invokeinterface android/database/Cursor.getLong (I)J 2
      // 127: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 12a: aconst_null
      // 12b: invokevirtual com/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient.list (Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;)Ljava/util/List;
      // 12e: astore 6
      // 130: aload 6
      // 132: astore 4
      // 134: goto 07a
      // 137: aload 0
      // 138: invokevirtual com/jibo/db/EntityData.e ()Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;
      // 13b: aload 8
      // 13d: aconst_null
      // 13e: aconst_null
      // 13f: invokevirtual com/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient.list (Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;)Ljava/util/List;
      // 142: astore 6
      // 144: aload 6
      // 146: astore 4
      // 148: goto 07a
      // 14b: aload 5
      // 14d: astore 7
      // 14f: aload 0
      // 150: aload 4
      // 152: bipush 0
      // 153: invokevirtual com/jibo/db/EntityData.a (Ljava/util/List;Z)V
      // 156: aload 5
      // 158: ifnull 1aa
      // 15b: aload 5
      // 15d: invokeinterface android/database/Cursor.close ()V 1
      // 162: bipush 0
      // 163: istore 3
      // 164: goto 0d2
      // 167: astore 1
      // 168: aload 6
      // 16a: astore 4
      // 16c: aload 4
      // 16e: ifnull 178
      // 171: aload 4
      // 173: invokeinterface android/database/Cursor.close ()V 1
      // 178: aload 1
      // 179: athrow
      // 17a: astore 1
      // 17b: aload 7
      // 17d: astore 4
      // 17f: goto 16c
      // 182: astore 1
      // 183: aload 5
      // 185: astore 4
      // 187: goto 16c
      // 18a: astore 6
      // 18c: aconst_null
      // 18d: astore 7
      // 18f: aload 5
      // 191: astore 4
      // 193: aload 7
      // 195: astore 5
      // 197: goto 0bd
      // 19a: astore 6
      // 19c: aconst_null
      // 19d: astore 5
      // 19f: goto 0bd
      // 1a2: astore 6
      // 1a4: goto 0bd
      // 1a7: goto 0d2
      // 1aa: bipush 0
      // 1ab: istore 3
      // 1ac: goto 0d2
      // try (40 -> 47): 184 java/lang/Exception
      // try (40 -> 47): 159 null
      // try (47 -> 52): 176 java/lang/Exception
      // try (47 -> 52): 159 null
      // try (60 -> 63): 82 java/lang/Exception
      // try (60 -> 63): 168 null
      // try (65 -> 68): 82 java/lang/Exception
      // try (65 -> 68): 168 null
      // try (70 -> 73): 82 java/lang/Exception
      // try (70 -> 73): 168 null
      // try (75 -> 81): 82 java/lang/Exception
      // try (75 -> 81): 168 null
      // try (85 -> 87): 168 null
      // try (92 -> 115): 184 java/lang/Exception
      // try (92 -> 115): 159 null
      // try (117 -> 133): 188 java/lang/Exception
      // try (117 -> 133): 172 null
      // try (136 -> 143): 188 java/lang/Exception
      // try (136 -> 143): 172 null
      // try (148 -> 152): 82 java/lang/Exception
      // try (148 -> 152): 168 null
   }

   private void b(List<Loop> param1) {
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
      // 005: getstatic com/jibo/db/EntityData.c Landroid/content/Context;
      // 008: invokestatic com/jibo/db/DatabaseHelper.a (Landroid/content/Context;)Lcom/jibo/db/DatabaseHelper;
      // 00b: invokevirtual com/jibo/db/DatabaseHelper.getWritableDatabase ()Landroid/database/sqlite/SQLiteDatabase;
      // 00e: astore 5
      // 010: aload 5
      // 012: astore 4
      // 014: aload 5
      // 016: astore 3
      // 017: new com/jibo/db/SelectionBuilder
      // 01a: astore 6
      // 01c: aload 5
      // 01e: astore 4
      // 020: aload 5
      // 022: astore 3
      // 023: aload 6
      // 025: invokespecial com/jibo/db/SelectionBuilder.<init> ()V
      // 028: aload 5
      // 02a: astore 4
      // 02c: aload 5
      // 02e: astore 3
      // 02f: aload 5
      // 031: invokevirtual android/database/sqlite/SQLiteDatabase.beginTransaction ()V
      // 034: aload 5
      // 036: astore 4
      // 038: aload 5
      // 03a: astore 3
      // 03b: aload 6
      // 03d: ldc "entity"
      // 03f: invokevirtual com/jibo/db/SelectionBuilder.a (Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;
      // 042: ldc_w "type=8"
      // 045: bipush 0
      // 046: anewarray 127
      // 049: invokevirtual com/jibo/db/SelectionBuilder.a (Ljava/lang/String;[Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;
      // 04c: pop
      // 04d: aload 5
      // 04f: astore 4
      // 051: aload 5
      // 053: astore 3
      // 054: aload 6
      // 056: aload 5
      // 058: invokevirtual com/jibo/db/SelectionBuilder.a (Landroid/database/sqlite/SQLiteDatabase;)I
      // 05b: pop
      // 05c: aload 5
      // 05e: astore 4
      // 060: aload 5
      // 062: astore 3
      // 063: aload 5
      // 065: invokevirtual android/database/sqlite/SQLiteDatabase.setTransactionSuccessful ()V
      // 068: aload 5
      // 06a: ifnull 072
      // 06d: aload 5
      // 06f: invokevirtual android/database/sqlite/SQLiteDatabase.endTransaction ()V
      // 072: aload 1
      // 073: invokeinterface java/util/List.size ()I 1
      // 078: anewarray 223
      // 07b: astore 3
      // 07c: bipush 0
      // 07d: istore 2
      // 07e: iload 2
      // 07f: aload 1
      // 080: invokeinterface java/util/List.size ()I 1
      // 085: if_icmpge 11a
      // 088: aload 1
      // 089: iload 2
      // 08a: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 08f: checkcast com/jibo/aws/integration/aws/services/loop/model/Loop
      // 092: astore 4
      // 094: aload 3
      // 095: iload 2
      // 096: new android/content/ContentValues
      // 099: dup
      // 09a: invokespecial android/content/ContentValues.<init> ()V
      // 09d: aastore
      // 09e: aload 3
      // 09f: iload 2
      // 0a0: aaload
      // 0a1: ldc "_id"
      // 0a3: aload 4
      // 0a5: invokevirtual com/jibo/aws/integration/aws/services/loop/model/Loop.getId ()Ljava/lang/String;
      // 0a8: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/String;)V
      // 0ab: aload 3
      // 0ac: iload 2
      // 0ad: aaload
      // 0ae: ldc "type"
      // 0b0: bipush 8
      // 0b2: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 0b5: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/Integer;)V
      // 0b8: aload 3
      // 0b9: iload 2
      // 0ba: aaload
      // 0bb: ldc "modified"
      // 0bd: invokestatic java/lang/System.currentTimeMillis ()J
      // 0c0: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 0c3: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/Long;)V
      // 0c6: aload 3
      // 0c7: iload 2
      // 0c8: aaload
      // 0c9: ldc_w "retrieved"
      // 0cc: invokestatic java/lang/System.currentTimeMillis ()J
      // 0cf: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 0d2: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/Long;)V
      // 0d5: aload 3
      // 0d6: iload 2
      // 0d7: aaload
      // 0d8: ldc "name"
      // 0da: aload 4
      // 0dc: invokevirtual com/jibo/aws/integration/aws/services/loop/model/Loop.getName ()Ljava/lang/String;
      // 0df: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/String;)V
      // 0e2: aload 3
      // 0e3: iload 2
      // 0e4: aaload
      // 0e5: ldc "data"
      // 0e7: getstatic com/jibo/db/EntityData.l Lcom/google/gson/Gson;
      // 0ea: aload 4
      // 0ec: invokevirtual com/google/gson/Gson.b (Ljava/lang/Object;)Ljava/lang/String;
      // 0ef: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/String;)V
      // 0f2: iinc 2 1
      // 0f5: goto 07e
      // 0f8: astore 5
      // 0fa: aload 4
      // 0fc: astore 3
      // 0fd: aload 5
      // 0ff: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // 102: aload 4
      // 104: ifnull 072
      // 107: aload 4
      // 109: invokevirtual android/database/sqlite/SQLiteDatabase.endTransaction ()V
      // 10c: goto 072
      // 10f: astore 1
      // 110: aload 3
      // 111: ifnull 118
      // 114: aload 3
      // 115: invokevirtual android/database/sqlite/SQLiteDatabase.endTransaction ()V
      // 118: aload 1
      // 119: athrow
      // 11a: getstatic com/jibo/db/EntityData.c Landroid/content/Context;
      // 11d: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 120: bipush 8
      // 122: invokestatic com/jibo/db/DatabaseContract$EntityEntry.a (I)Landroid/net/Uri;
      // 125: aload 3
      // 126: invokevirtual android/content/ContentResolver.bulkInsert (Landroid/net/Uri;[Landroid/content/ContentValues;)I
      // 129: pop
      // 12a: aload 0
      // 12b: invokespecial com/jibo/db/EntityData.r ()V
      // 12e: return
      // 12f: astore 1
      // 130: aload 1
      // 131: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // 134: goto 12a
      // 137: astore 1
      // 138: aload 1
      // 139: athrow
      // try (4 -> 8): 122 java/lang/Exception
      // try (4 -> 8): 132 null
      // try (12 -> 14): 122 java/lang/Exception
      // try (12 -> 14): 132 null
      // try (18 -> 20): 122 java/lang/Exception
      // try (18 -> 20): 132 null
      // try (24 -> 26): 122 java/lang/Exception
      // try (24 -> 26): 132 null
      // try (30 -> 38): 122 java/lang/Exception
      // try (30 -> 38): 132 null
      // try (42 -> 46): 122 java/lang/Exception
      // try (42 -> 46): 132 null
      // try (50 -> 52): 122 java/lang/Exception
      // try (50 -> 52): 132 null
      // try (125 -> 127): 132 null
      // try (139 -> 146): 149 java/lang/Exception
      // try (139 -> 146): 153 null
      // try (150 -> 152): 153 null
   }

   public static Media c(Cursor param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: bipush 1
      // 01: istore 1
      // 02: new com/jibo/aws/integration/aws/services/media/model/Media
      // 05: dup
      // 06: invokespecial com/jibo/aws/integration/aws/services/media/model/Media.<init> ()V
      // 09: astore 2
      // 0a: aload 2
      // 0b: aload 0
      // 0c: aload 0
      // 0d: ldc "_id"
      // 0f: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
      // 14: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 19: invokevirtual com/jibo/aws/integration/aws/services/media/model/Media.setPath (Ljava/lang/String;)V
      // 1c: aload 2
      // 1d: aload 0
      // 1e: aload 0
      // 1f: ldc_w "loopId"
      // 22: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
      // 27: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 2c: invokevirtual com/jibo/aws/integration/aws/services/media/model/Media.setLoopId (Ljava/lang/String;)V
      // 2f: aload 2
      // 30: aload 0
      // 31: aload 0
      // 32: ldc_w "created"
      // 35: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
      // 3a: invokeinterface android/database/Cursor.getLong (I)J 2
      // 3f: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 42: invokevirtual com/jibo/aws/integration/aws/services/media/model/Media.setCreated (Ljava/lang/Long;)V
      // 45: aload 2
      // 46: aload 0
      // 47: aload 0
      // 48: ldc_w "accountId"
      // 4b: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
      // 50: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 55: invokevirtual com/jibo/aws/integration/aws/services/media/model/Media.setAccountId (Ljava/lang/String;)V
      // 58: aload 2
      // 59: aload 0
      // 5a: aload 0
      // 5b: ldc_w "url"
      // 5e: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
      // 63: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 68: invokevirtual com/jibo/aws/integration/aws/services/media/model/Media.setUrl (Ljava/lang/String;)V
      // 6b: aload 2
      // 6c: aload 0
      // 6d: aload 0
      // 6e: ldc "type"
      // 70: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
      // 75: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 7a: invokevirtual com/jibo/aws/integration/aws/services/media/model/Media.setType (Ljava/lang/String;)V
      // 7d: aload 2
      // 7e: aload 0
      // 7f: aload 0
      // 80: ldc_w "reference"
      // 83: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
      // 88: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 8d: invokevirtual com/jibo/aws/integration/aws/services/media/model/Media.setReference (Ljava/lang/String;)V
      // 90: aload 0
      // 91: aload 0
      // 92: ldc_w "isEncrypted"
      // 95: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
      // 9a: invokeinterface android/database/Cursor.getInt (I)I 2
      // 9f: bipush 1
      // a0: if_icmpne ad
      // a3: aload 2
      // a4: iload 1
      // a5: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
      // a8: invokevirtual com/jibo/aws/integration/aws/services/media/model/Media.setEncrypted (Ljava/lang/Boolean;)V
      // ab: aload 2
      // ac: areturn
      // ad: bipush 0
      // ae: istore 1
      // af: goto a3
      // b2: astore 0
      // b3: aload 0
      // b4: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // b7: goto ab
      // ba: astore 0
      // bb: aload 0
      // bc: athrow
      // try (6 -> 63): 72 java/lang/Exception
      // try (6 -> 63): 76 null
      // try (63 -> 67): 72 java/lang/Exception
      // try (63 -> 67): 76 null
      // try (73 -> 75): 76 null
   }

   private void c(List<Loop> var1) {
      if (var1 != null && !var1.isEmpty()) {
         ArrayList var2 = new ArrayList();
         Iterator var3 = var1.iterator();

         while (var3.hasNext()) {
            var2.addAll(LoopHelper.getAccountIds((Loop)var3.next(), Member.InvitationStatus.accepted));
         }

         this.a(this.a().get(var2), 1);
      }
   }

   private void g(String var1) {
      try {
         try {
            if (TextUtils.isEmpty(var1)) {
               c.getContentResolver().delete(DatabaseContract.EntityEntry.a(2), null, null);
            } else {
               c.getContentResolver().delete(DatabaseContract.EntityEntry.a(2, var1), null, null);
            }
         } catch (Exception var4) {
            Crashlytics.a(var4);
         }
      } finally {
         ;
      }
   }

   private void h(String var1) {
      try {
         try {
            if (TextUtils.isEmpty(var1)) {
               c.getContentResolver().delete(DatabaseContract.JotEntry.a, null, null);
            } else {
               c.getContentResolver().delete(DatabaseContract.JotEntry.a(var1), null, null);
            }
         } catch (Exception var4) {
            Crashlytics.a(var4);
         }
      } finally {
         ;
      }
   }

   private void i(String var1) {
      try {
         try {
            if (TextUtils.isEmpty(var1)) {
               c.getContentResolver().delete(DatabaseContract.MediaEntry.b, null, null);
            } else {
               c.getContentResolver().delete(DatabaseContract.MediaEntry.a(var1), null, null);
            }
         } catch (Exception var4) {
            Crashlytics.a(var4);
         }
      } finally {
         ;
      }
   }

   private void m() {
      this.a();
      this.b();
      this.d();
      this.e();
      this.g();
   }

   private void n() {
      try {
         if (this.e != null) {
            this.e.logout();
            this.e.shutdown();
            this.e = null;
         }
      } catch (Exception var8) {
         Crashlytics.a(var8);
      }

      try {
         if (this.f != null) {
            this.f.shutdown();
            this.f = null;
         }
      } catch (Exception var7) {
         Crashlytics.a(var7);
      }

      try {
         if (this.h != null) {
            this.h.shutdown();
            this.h = null;
         }
      } catch (Exception var6) {
         Crashlytics.a(var6);
      }

      try {
         if (this.i != null) {
            this.i.shutdown();
            this.i = null;
         }
      } catch (Exception var5) {
         Crashlytics.a(var5);
      }

      try {
         if (this.j != null) {
            this.j.shutdown();
            this.j = null;
         }
      } catch (Exception var4) {
         Crashlytics.a(var4);
      }

      try {
         if (this.k != null) {
            this.k.shutdown();
            this.k = null;
         }
      } catch (Exception var3) {
         Crashlytics.a(var3);
      }

      try {
         if (this.g != null) {
            this.g.shutdown();
            this.g = null;
         }
      } catch (Exception var2) {
         Crashlytics.a(var2);
      }
   }

   private BasicAWSCredentials o() {
      Account var1 = this.i();
      BasicAWSCredentials var2;
      if (var1 != null && !TextUtils.isEmpty(var1.getAccessKeyId()) && !TextUtils.isEmpty(var1.getSecretAccessKey())) {
         var2 = new BasicAWSCredentials(var1.getAccessKeyId(), var1.getSecretAccessKey());
      } else {
         var2 = new BasicAWSCredentials("", "");
      }

      return var2;
   }

   private void p() {
      try {
         try {
            c.getContentResolver().delete(DatabaseContract.EntityEntry.a(1), null, null);
         } catch (Exception var4) {
            Crashlytics.a(var4);
         }
      } finally {
         ;
      }
   }

   private void q() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.processStatement(ExprProcessor.java:119)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.getFinallyInformation(FinallyProcessor.java:136)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:84)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: aconst_null
      // 04: putfield com/jibo/db/EntityData.d Lcom/jibo/aws/integration/aws/services/account/model/Account;
      // 07: aload 0
      // 08: monitorexit
      // 09: aload 0
      // 0a: invokevirtual com/jibo/db/EntityData.i ()Lcom/jibo/aws/integration/aws/services/account/model/Account;
      // 0d: pop
      // 0e: return
      // 0f: astore 1
      // 10: aload 0
      // 11: monitorexit
      // 12: aload 1
      // 13: athrow
      // try (2 -> 7): 11 null
      // try (12 -> 14): 11 null
   }

   private void r() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: getstatic com/jibo/db/EntityData.c Landroid/content/Context;
      // 003: invokestatic com/jibo/utils/SharedPreferencesUtil.f (Landroid/content/Context;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
      // 006: astore 2
      // 007: aload 2
      // 008: ifnull 19b
      // 00b: getstatic com/jibo/db/EntityData.c Landroid/content/Context;
      // 00e: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 011: bipush 8
      // 013: aload 2
      // 014: invokevirtual com/jibo/aws/integration/aws/services/loop/model/Loop.getId ()Ljava/lang/String;
      // 017: invokestatic com/jibo/db/DatabaseContract$EntityEntry.a (ILjava/lang/String;)Landroid/net/Uri;
      // 01a: getstatic com/jibo/db/DatabaseContract$EntityEntry.a [Ljava/lang/String;
      // 01d: aconst_null
      // 01e: aconst_null
      // 01f: aconst_null
      // 020: invokevirtual android/content/ContentResolver.query (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      // 023: astore 2
      // 024: aload 2
      // 025: ifnull 195
      // 028: aload 2
      // 029: astore 3
      // 02a: aload 2
      // 02b: invokeinterface android/database/Cursor.isClosed ()Z 1
      // 030: ifne 195
      // 033: aload 2
      // 034: astore 3
      // 035: aload 2
      // 036: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 03b: ifeq 195
      // 03e: aload 2
      // 03f: astore 3
      // 040: aload 2
      // 041: invokeinterface android/database/Cursor.getCount ()I 1
      // 046: ifle 195
      // 049: aload 2
      // 04a: astore 3
      // 04b: aload 2
      // 04c: invokestatic com/jibo/db/EntityData.a (Landroid/database/Cursor;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
      // 04f: astore 4
      // 051: aload 2
      // 052: astore 3
      // 053: aload 4
      // 055: aload 0
      // 056: invokevirtual com/jibo/db/EntityData.i ()Lcom/jibo/aws/integration/aws/services/account/model/Account;
      // 059: invokevirtual com/jibo/aws/integration/aws/services/account/model/Account.getId ()Ljava/lang/String;
      // 05c: invokestatic com/jibo/aws/integration/helpers/LoopHelper.isMemberAccepted (Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z
      // 05f: istore 1
      // 060: iload 1
      // 061: ifeq 195
      // 064: aload 2
      // 065: ifnull 18d
      // 068: aload 2
      // 069: invokeinterface android/database/Cursor.close ()V 1
      // 06e: aload 2
      // 06f: astore 3
      // 070: aload 4
      // 072: astore 2
      // 073: aload 2
      // 074: ifnonnull 177
      // 077: getstatic com/jibo/db/EntityData.c Landroid/content/Context;
      // 07a: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 07d: bipush 8
      // 07f: invokestatic com/jibo/db/DatabaseContract$EntityEntry.a (I)Landroid/net/Uri;
      // 082: getstatic com/jibo/db/DatabaseContract$EntityEntry.a [Ljava/lang/String;
      // 085: aconst_null
      // 086: aconst_null
      // 087: ldc "_id"
      // 089: invokevirtual android/content/ContentResolver.query (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      // 08c: astore 4
      // 08e: aload 4
      // 090: astore 3
      // 091: aload 3
      // 092: ifnull 183
      // 095: aload 3
      // 096: invokeinterface android/database/Cursor.isClosed ()Z 1
      // 09b: ifne 183
      // 09e: aload 3
      // 09f: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 0a4: ifeq 183
      // 0a7: aconst_null
      // 0a8: astore 4
      // 0aa: aload 3
      // 0ab: invokeinterface android/database/Cursor.isAfterLast ()Z 1
      // 0b0: ifne 17d
      // 0b3: aload 3
      // 0b4: invokestatic com/jibo/db/EntityData.a (Landroid/database/Cursor;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
      // 0b7: astore 6
      // 0b9: aload 6
      // 0bb: aload 0
      // 0bc: invokevirtual com/jibo/db/EntityData.i ()Lcom/jibo/aws/integration/aws/services/account/model/Account;
      // 0bf: invokevirtual com/jibo/aws/integration/aws/services/account/model/Account.getId ()Ljava/lang/String;
      // 0c2: invokestatic com/jibo/aws/integration/helpers/LoopHelper.isOwner (Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z
      // 0c5: istore 1
      // 0c6: iload 1
      // 0c7: ifeq 10f
      // 0ca: aload 6
      // 0cc: astore 2
      // 0cd: aload 2
      // 0ce: astore 4
      // 0d0: aload 3
      // 0d1: ifnull 0dd
      // 0d4: aload 3
      // 0d5: invokeinterface android/database/Cursor.close ()V 1
      // 0da: aload 2
      // 0db: astore 4
      // 0dd: aload 0
      // 0de: aload 4
      // 0e0: invokevirtual com/jibo/db/EntityData.a (Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
      // 0e3: return
      // 0e4: astore 4
      // 0e6: aconst_null
      // 0e7: astore 2
      // 0e8: aload 2
      // 0e9: astore 3
      // 0ea: aload 4
      // 0ec: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // 0ef: aload 2
      // 0f0: ifnull 186
      // 0f3: aload 2
      // 0f4: invokeinterface android/database/Cursor.close ()V 1
      // 0f9: aload 2
      // 0fa: astore 3
      // 0fb: aconst_null
      // 0fc: astore 2
      // 0fd: goto 073
      // 100: astore 2
      // 101: aconst_null
      // 102: astore 3
      // 103: aload 3
      // 104: ifnull 10d
      // 107: aload 3
      // 108: invokeinterface android/database/Cursor.close ()V 1
      // 10d: aload 2
      // 10e: athrow
      // 10f: aload 4
      // 111: astore 5
      // 113: aload 4
      // 115: ifnonnull 12f
      // 118: aload 4
      // 11a: astore 5
      // 11c: aload 6
      // 11e: aload 0
      // 11f: invokevirtual com/jibo/db/EntityData.i ()Lcom/jibo/aws/integration/aws/services/account/model/Account;
      // 122: invokevirtual com/jibo/aws/integration/aws/services/account/model/Account.getId ()Ljava/lang/String;
      // 125: invokestatic com/jibo/aws/integration/helpers/LoopHelper.isMemberAccepted (Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z
      // 128: ifeq 12f
      // 12b: aload 6
      // 12d: astore 5
      // 12f: aload 3
      // 130: invokeinterface android/database/Cursor.moveToNext ()Z 1
      // 135: pop
      // 136: aload 5
      // 138: astore 4
      // 13a: goto 0aa
      // 13d: astore 4
      // 13f: aload 4
      // 141: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // 144: aload 3
      // 145: ifnull 177
      // 148: aload 3
      // 149: invokeinterface android/database/Cursor.close ()V 1
      // 14e: aload 2
      // 14f: astore 4
      // 151: goto 0dd
      // 154: astore 2
      // 155: aload 3
      // 156: ifnull 15f
      // 159: aload 3
      // 15a: invokeinterface android/database/Cursor.close ()V 1
      // 15f: aload 2
      // 160: athrow
      // 161: astore 2
      // 162: goto 155
      // 165: astore 2
      // 166: goto 155
      // 169: astore 4
      // 16b: goto 13f
      // 16e: astore 2
      // 16f: goto 103
      // 172: astore 4
      // 174: goto 0e8
      // 177: aload 2
      // 178: astore 4
      // 17a: goto 0dd
      // 17d: aload 4
      // 17f: astore 2
      // 180: goto 0cd
      // 183: goto 0cd
      // 186: aload 2
      // 187: astore 3
      // 188: aconst_null
      // 189: astore 2
      // 18a: goto 073
      // 18d: aload 2
      // 18e: astore 3
      // 18f: aload 4
      // 191: astore 2
      // 192: goto 073
      // 195: aconst_null
      // 196: astore 4
      // 198: goto 064
      // 19b: aconst_null
      // 19c: astore 3
      // 19d: aconst_null
      // 19e: astore 2
      // 19f: goto 073
      // try (5 -> 17): 109 java/lang/Exception
      // try (5 -> 17): 125 null
      // try (21 -> 24): 179 java/lang/Exception
      // try (21 -> 24): 177 null
      // try (26 -> 29): 179 java/lang/Exception
      // try (26 -> 29): 177 null
      // try (31 -> 34): 179 java/lang/Exception
      // try (31 -> 34): 177 null
      // try (36 -> 39): 179 java/lang/Exception
      // try (36 -> 39): 177 null
      // try (41 -> 47): 179 java/lang/Exception
      // try (41 -> 47): 177 null
      // try (59 -> 69): 175 java/lang/Exception
      // try (59 -> 69): 164 null
      // try (73 -> 79): 154 java/lang/Exception
      // try (73 -> 79): 171 null
      // try (81 -> 93): 154 java/lang/Exception
      // try (81 -> 93): 171 null
      // try (114 -> 116): 177 null
      // try (140 -> 146): 154 java/lang/Exception
      // try (140 -> 146): 171 null
      // try (148 -> 151): 154 java/lang/Exception
      // try (148 -> 151): 171 null
      // try (155 -> 157): 173 null
   }

   public JiboAccountAsyncClient a() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: getfield com/jibo/db/EntityData.e Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;
      // 06: astore 1
      // 07: aload 1
      // 08: ifnull 12
      // 0b: aload 1
      // 0c: invokevirtual com/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient.isTerminated ()Z
      // 0f: ifeq 37
      // 12: aload 0
      // 13: monitorenter
      // 14: aload 0
      // 15: getfield com/jibo/db/EntityData.e Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;
      // 18: astore 1
      // 19: aload 1
      // 1a: ifnull 24
      // 1d: aload 1
      // 1e: invokevirtual com/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient.isTerminated ()Z
      // 21: ifeq 35
      // 24: new com/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient
      // 27: astore 1
      // 28: aload 1
      // 29: aload 0
      // 2a: invokespecial com/jibo/db/EntityData.o ()Lcom/amazonaws/auth/BasicAWSCredentials;
      // 2d: invokespecial com/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient.<init> (Lcom/amazonaws/auth/AWSCredentials;)V
      // 30: aload 0
      // 31: aload 1
      // 32: putfield com/jibo/db/EntityData.e Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;
      // 35: aload 0
      // 36: monitorexit
      // 37: aload 0
      // 38: getfield com/jibo/db/EntityData.e Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;
      // 3b: astore 1
      // 3c: aload 0
      // 3d: monitorexit
      // 3e: aload 1
      // 3f: areturn
      // 40: astore 1
      // 41: aload 0
      // 42: monitorexit
      // 43: aload 1
      // 44: athrow
      // 45: astore 1
      // 46: aload 0
      // 47: monitorexit
      // 48: aload 1
      // 49: athrow
      // try (2 -> 5): 43 null
      // try (7 -> 10): 43 null
      // try (10 -> 12): 43 null
      // try (12 -> 15): 38 null
      // try (17 -> 20): 38 null
      // try (20 -> 29): 38 null
      // try (29 -> 31): 38 null
      // try (31 -> 34): 43 null
      // try (39 -> 41): 38 null
      // try (41 -> 43): 43 null
   }

   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public Account a(String var1) {
      Object var2 = null;
      Account var34;
      if (TextUtils.isEmpty(var1)) {
         var34 = null;
      } else {
         label214: {
            Account var33;
            label213: {
               label220: {
                  label227: {
                     label222: {
                        label209: {
                           try {
                              var30 = c.getContentResolver().query(DatabaseContract.EntityEntry.a(2, var1), null, null, null, null);
                              break label209;
                           } catch (Exception var27) {
                              var3 = var27;
                           } finally {
                              ;
                           }

                           var29 = null;
                           break label222;
                        }

                        label203: {
                           try {
                              label201: {
                                 try {
                                    if (!var30.moveToFirst()) {
                                       break label220;
                                    }

                                    var33 = l.a(var30.getString(var30.getColumnIndex("data")), Account.class);
                                 } catch (Exception var25) {
                                    var3 = var25;
                                    break label201;
                                 }

                                 try {
                                    var33.setModified(var30.getLong(var30.getColumnIndex("modified")));
                                    var33.setRetrieved(var30.getLong(var30.getColumnIndex("retrieved")));
                                    break label213;
                                 } catch (Exception var24) {
                                    var3 = var24;
                                    break label203;
                                 }
                              }
                           } finally {
                              break label227;
                           }

                           Object var4 = null;
                           var2 = var30;
                           var29 = (Account)var4;
                           break label222;
                        }

                        var2 = var30;
                        var29 = var33;
                     }

                     try {
                        Crashlytics.a(var3);
                     } catch (Throwable var23) {
                        var30 = var2;
                        var2 = var23;
                        break label227;
                     }

                     var34 = var29;
                     if (var2 != null) {
                        var2.close();
                        var34 = var29;
                     }

                     return var34;
                  }

                  if (var30 != null) {
                     var30.close();
                  }

                  throw var2;
               }

               var31 = null;
               break label214;
            }

            var31 = var33;
         }

         var34 = var31;
         if (var30 != null) {
            var30.close();
            var34 = var31;
         }
      }

      return var34;
   }

   public List<Loop> a(boolean var1) {
      List var2 = this.b().listLoops();
      this.b(var2);
      if (var1) {
         this.c(var2);
      }

      return var2;
   }

   public void a(Bundle param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aload 0
      // 001: invokevirtual com/jibo/db/EntityData.i ()Lcom/jibo/aws/integration/aws/services/account/model/Account;
      // 004: ifnonnull 008
      // 007: return
      // 008: aload 1
      // 009: getstatic com/jibo/service/SyncHelper.a Ljava/lang/String;
      // 00c: bipush 14
      // 00e: invokevirtual android/os/Bundle.getInt (Ljava/lang/String;I)I
      // 011: istore 2
      // 012: iload 2
      // 013: bipush 2
      // 014: iand
      // 015: ifeq 01e
      // 018: aload 0
      // 019: bipush 1
      // 01a: invokevirtual com/jibo/db/EntityData.a (Z)Ljava/util/List;
      // 01d: pop
      // 01e: aload 1
      // 01f: ldc com/jibo/aws/integration/aws/services/loop/model/Loop
      // 021: invokevirtual java/lang/Class.getSimpleName ()Ljava/lang/String;
      // 024: aconst_null
      // 025: invokevirtual android/os/Bundle.getString (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 028: astore 1
      // 029: iload 2
      // 02a: bipush 1
      // 02b: iand
      // 02c: ifeq 03b
      // 02f: aload 1
      // 030: invokestatic android/text/TextUtils.isEmpty (Ljava/lang/CharSequence;)Z
      // 033: ifne 03b
      // 036: aload 0
      // 037: aload 1
      // 038: invokevirtual com/jibo/db/EntityData.f (Ljava/lang/String;)V
      // 03b: aload 1
      // 03c: invokestatic android/text/TextUtils.isEmpty (Ljava/lang/CharSequence;)Z
      // 03f: ifne 0f4
      // 042: bipush 8
      // 044: aload 1
      // 045: invokestatic com/jibo/db/DatabaseContract$EntityEntry.a (ILjava/lang/String;)Landroid/net/Uri;
      // 048: astore 1
      // 049: iload 2
      // 04a: bipush 4
      // 04b: iand
      // 04c: ifne 056
      // 04f: iload 2
      // 050: bipush 8
      // 052: iand
      // 053: ifeq 007
      // 056: getstatic com/jibo/db/EntityData.c Landroid/content/Context;
      // 059: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 05c: aload 1
      // 05d: getstatic com/jibo/db/DatabaseContract$EntityEntry.a [Ljava/lang/String;
      // 060: aconst_null
      // 061: aconst_null
      // 062: aconst_null
      // 063: invokevirtual android/content/ContentResolver.query (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      // 066: astore 4
      // 068: aload 4
      // 06a: ifnull 102
      // 06d: aload 4
      // 06f: astore 1
      // 070: aload 4
      // 072: invokeinterface android/database/Cursor.isClosed ()Z 1
      // 077: ifne 102
      // 07a: aload 4
      // 07c: astore 1
      // 07d: aload 4
      // 07f: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 084: ifeq 102
      // 087: aload 4
      // 089: astore 1
      // 08a: aload 4
      // 08c: invokeinterface android/database/Cursor.isAfterLast ()Z 1
      // 091: ifne 102
      // 094: aload 4
      // 096: astore 1
      // 097: aload 4
      // 099: invokestatic com/jibo/db/EntityData.a (Landroid/database/Cursor;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
      // 09c: astore 5
      // 09e: iload 2
      // 09f: bipush 8
      // 0a1: iand
      // 0a2: ifeq 0b8
      // 0a5: iload 2
      // 0a6: bipush 16
      // 0a8: iand
      // 0a9: ifeq 0fd
      // 0ac: bipush 1
      // 0ad: istore 3
      // 0ae: aload 4
      // 0b0: astore 1
      // 0b1: aload 0
      // 0b2: aload 5
      // 0b4: iload 3
      // 0b5: invokespecial com/jibo/db/EntityData.b (Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Z)V
      // 0b8: aload 4
      // 0ba: astore 1
      // 0bb: aload 4
      // 0bd: invokeinterface android/database/Cursor.moveToNext ()Z 1
      // 0c2: pop
      // 0c3: goto 087
      // 0c6: astore 5
      // 0c8: aload 4
      // 0ca: astore 1
      // 0cb: aload 5
      // 0cd: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // 0d0: aload 4
      // 0d2: ifnull 0dc
      // 0d5: aload 4
      // 0d7: invokeinterface android/database/Cursor.close ()V 1
      // 0dc: aload 0
      // 0dd: invokevirtual com/jibo/db/EntityData.j ()V
      // 0e0: goto 007
      // 0e3: astore 1
      // 0e4: getstatic com/jibo/db/EntityData.a Ljava/lang/String;
      // 0e7: ldc_w "onRunTask-end"
      // 0ea: invokestatic com/jibo/utils/LogUtils.c (Ljava/lang/String;Ljava/lang/String;)V
      // 0ed: aload 1
      // 0ee: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // 0f1: goto 007
      // 0f4: bipush 8
      // 0f6: invokestatic com/jibo/db/DatabaseContract$EntityEntry.a (I)Landroid/net/Uri;
      // 0f9: astore 1
      // 0fa: goto 049
      // 0fd: bipush 0
      // 0fe: istore 3
      // 0ff: goto 0ae
      // 102: aload 4
      // 104: ifnull 10e
      // 107: aload 4
      // 109: invokeinterface android/database/Cursor.close ()V 1
      // 10e: aload 0
      // 10f: invokevirtual com/jibo/db/EntityData.j ()V
      // 112: goto 007
      // 115: astore 4
      // 117: aconst_null
      // 118: astore 1
      // 119: aload 1
      // 11a: ifnull 123
      // 11d: aload 1
      // 11e: invokeinterface android/database/Cursor.close ()V 1
      // 123: aload 0
      // 124: invokevirtual com/jibo/db/EntityData.j ()V
      // 127: aload 4
      // 129: athrow
      // 12a: astore 4
      // 12c: goto 119
      // 12f: astore 5
      // 131: aconst_null
      // 132: astore 4
      // 134: goto 0c8
      // try (0 -> 3): 113 java/lang/Exception
      // try (4 -> 9): 113 java/lang/Exception
      // try (13 -> 17): 113 java/lang/Exception
      // try (17 -> 23): 113 java/lang/Exception
      // try (27 -> 33): 113 java/lang/Exception
      // try (33 -> 40): 113 java/lang/Exception
      // try (48 -> 57): 147 java/lang/Exception
      // try (48 -> 57): 134 null
      // try (61 -> 64): 101 java/lang/Exception
      // try (61 -> 64): 145 null
      // try (66 -> 69): 101 java/lang/Exception
      // try (66 -> 69): 145 null
      // try (71 -> 74): 101 java/lang/Exception
      // try (71 -> 74): 145 null
      // try (76 -> 79): 101 java/lang/Exception
      // try (76 -> 79): 145 null
      // try (91 -> 95): 101 java/lang/Exception
      // try (91 -> 95): 145 null
      // try (97 -> 100): 101 java/lang/Exception
      // try (97 -> 100): 145 null
      // try (104 -> 106): 145 null
      // try (108 -> 110): 113 java/lang/Exception
      // try (110 -> 112): 113 java/lang/Exception
      // try (120 -> 123): 113 java/lang/Exception
      // try (129 -> 131): 113 java/lang/Exception
      // try (131 -> 133): 113 java/lang/Exception
      // try (139 -> 141): 113 java/lang/Exception
      // try (141 -> 145): 113 java/lang/Exception
   }

   public void a(Account param1, boolean param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: new android/content/ContentValues
      // 003: astore 5
      // 005: aload 5
      // 007: invokespecial android/content/ContentValues.<init> ()V
      // 00a: aload 5
      // 00c: ldc "_id"
      // 00e: aload 1
      // 00f: invokevirtual com/jibo/aws/integration/aws/services/account/model/Account.getId ()Ljava/lang/String;
      // 012: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/String;)V
      // 015: aload 5
      // 017: ldc "name"
      // 019: aload 1
      // 01a: invokevirtual com/jibo/aws/integration/aws/services/account/model/Account.getFullName ()Ljava/lang/String;
      // 01d: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/String;)V
      // 020: aload 5
      // 022: ldc "modified"
      // 024: invokestatic java/lang/System.currentTimeMillis ()J
      // 027: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 02a: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/Long;)V
      // 02d: iload 2
      // 02e: ifeq 03f
      // 031: aload 5
      // 033: ldc_w "retrieved"
      // 036: invokestatic java/lang/System.currentTimeMillis ()J
      // 039: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 03c: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/Long;)V
      // 03f: aload 5
      // 041: ldc "data"
      // 043: getstatic com/jibo/db/EntityData.l Lcom/google/gson/Gson;
      // 046: aload 1
      // 047: invokevirtual com/google/gson/Gson.b (Ljava/lang/Object;)Ljava/lang/String;
      // 04a: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/String;)V
      // 04d: getstatic com/jibo/db/EntityData.c Landroid/content/Context;
      // 050: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 053: bipush 2
      // 054: aload 1
      // 055: invokevirtual com/jibo/aws/integration/aws/services/account/model/Account.getId ()Ljava/lang/String;
      // 058: invokestatic com/jibo/db/DatabaseContract$EntityEntry.a (ILjava/lang/String;)Landroid/net/Uri;
      // 05b: aconst_null
      // 05c: aconst_null
      // 05d: aconst_null
      // 05e: aconst_null
      // 05f: invokevirtual android/content/ContentResolver.query (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      // 062: astore 4
      // 064: aload 4
      // 066: astore 3
      // 067: aload 4
      // 069: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 06e: ifeq 0fa
      // 071: aload 4
      // 073: astore 3
      // 074: getstatic com/jibo/db/EntityData.l Lcom/google/gson/Gson;
      // 077: aload 4
      // 079: aload 4
      // 07b: ldc "data"
      // 07d: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
      // 082: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 087: ldc com/jibo/aws/integration/aws/services/account/model/Account
      // 089: invokevirtual com/google/gson/Gson.a (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
      // 08c: checkcast com/jibo/aws/integration/aws/services/account/model/Account
      // 08f: astore 6
      // 091: iload 2
      // 092: ifne 0c7
      // 095: aload 4
      // 097: astore 3
      // 098: aload 6
      // 09a: aload 1
      // 09b: invokevirtual com/jibo/aws/integration/aws/services/account/model/Account.equals (Ljava/lang/Object;)Z
      // 09e: ifne 0ba
      // 0a1: aload 4
      // 0a3: astore 3
      // 0a4: getstatic com/jibo/db/EntityData.c Landroid/content/Context;
      // 0a7: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 0aa: bipush 2
      // 0ab: aload 1
      // 0ac: invokevirtual com/jibo/aws/integration/aws/services/account/model/Account.getId ()Ljava/lang/String;
      // 0af: invokestatic com/jibo/db/DatabaseContract$EntityEntry.a (ILjava/lang/String;)Landroid/net/Uri;
      // 0b2: aload 5
      // 0b4: aconst_null
      // 0b5: aconst_null
      // 0b6: invokevirtual android/content/ContentResolver.update (Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
      // 0b9: pop
      // 0ba: aload 4
      // 0bc: ifnull 0c6
      // 0bf: aload 4
      // 0c1: invokeinterface android/database/Cursor.close ()V 1
      // 0c6: return
      // 0c7: aload 4
      // 0c9: astore 3
      // 0ca: getstatic com/jibo/db/EntityData.c Landroid/content/Context;
      // 0cd: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 0d0: bipush 2
      // 0d1: aload 1
      // 0d2: invokevirtual com/jibo/aws/integration/aws/services/account/model/Account.getId ()Ljava/lang/String;
      // 0d5: invokestatic com/jibo/db/DatabaseContract$EntityEntry.a (ILjava/lang/String;)Landroid/net/Uri;
      // 0d8: aload 5
      // 0da: aconst_null
      // 0db: aconst_null
      // 0dc: invokevirtual android/content/ContentResolver.update (Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
      // 0df: pop
      // 0e0: goto 0ba
      // 0e3: astore 1
      // 0e4: aload 4
      // 0e6: astore 3
      // 0e7: aload 1
      // 0e8: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // 0eb: aload 4
      // 0ed: ifnull 0c6
      // 0f0: aload 4
      // 0f2: invokeinterface android/database/Cursor.close ()V 1
      // 0f7: goto 0c6
      // 0fa: aload 4
      // 0fc: astore 3
      // 0fd: aload 5
      // 0ff: ldc "type"
      // 101: bipush 2
      // 102: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 105: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/Integer;)V
      // 108: aload 4
      // 10a: astore 3
      // 10b: getstatic com/jibo/db/EntityData.c Landroid/content/Context;
      // 10e: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 111: bipush 2
      // 112: invokestatic com/jibo/db/DatabaseContract$EntityEntry.a (I)Landroid/net/Uri;
      // 115: aload 5
      // 117: invokevirtual android/content/ContentResolver.insert (Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
      // 11a: pop
      // 11b: goto 0ba
      // 11e: astore 1
      // 11f: aload 3
      // 120: ifnull 129
      // 123: aload 3
      // 124: invokeinterface android/database/Cursor.close ()V 1
      // 129: aload 1
      // 12a: athrow
      // 12b: astore 1
      // 12c: aconst_null
      // 12d: astore 3
      // 12e: goto 11f
      // 131: astore 1
      // 132: aconst_null
      // 133: astore 4
      // 135: goto 0e4
      // try (0 -> 19): 139 java/lang/Exception
      // try (0 -> 19): 135 null
      // try (21 -> 26): 139 java/lang/Exception
      // try (21 -> 26): 135 null
      // try (26 -> 44): 139 java/lang/Exception
      // try (26 -> 44): 135 null
      // try (46 -> 49): 101 java/lang/Exception
      // try (46 -> 49): 128 null
      // try (51 -> 61): 101 java/lang/Exception
      // try (51 -> 61): 128 null
      // try (65 -> 69): 101 java/lang/Exception
      // try (65 -> 69): 128 null
      // try (71 -> 82): 101 java/lang/Exception
      // try (71 -> 82): 128 null
      // try (89 -> 100): 101 java/lang/Exception
      // try (89 -> 100): 128 null
      // try (104 -> 106): 128 null
      // try (113 -> 118): 101 java/lang/Exception
      // try (113 -> 118): 128 null
      // try (120 -> 127): 101 java/lang/Exception
      // try (120 -> 127): 128 null
   }

   public void a(Account param1, boolean param2, AsyncHandler<UpdateRequest, Account> param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: bipush 0
      // 001: istore 5
      // 003: new android/content/ContentValues
      // 006: astore 8
      // 008: aload 8
      // 00a: invokespecial android/content/ContentValues.<init> ()V
      // 00d: aload 8
      // 00f: ldc "_id"
      // 011: aload 1
      // 012: invokevirtual com/jibo/aws/integration/aws/services/account/model/Account.getId ()Ljava/lang/String;
      // 015: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/String;)V
      // 018: aload 8
      // 01a: ldc "modified"
      // 01c: invokestatic java/lang/System.currentTimeMillis ()J
      // 01f: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 022: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/Long;)V
      // 025: iload 2
      // 026: ifeq 037
      // 029: aload 8
      // 02b: ldc_w "retrieved"
      // 02e: invokestatic java/lang/System.currentTimeMillis ()J
      // 031: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 034: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/Long;)V
      // 037: getstatic com/jibo/db/EntityData.c Landroid/content/Context;
      // 03a: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 03d: bipush 1
      // 03e: invokestatic com/jibo/db/DatabaseContract$EntityEntry.a (I)Landroid/net/Uri;
      // 041: aconst_null
      // 042: aconst_null
      // 043: aconst_null
      // 044: aconst_null
      // 045: invokevirtual android/content/ContentResolver.query (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      // 048: astore 6
      // 04a: aload 6
      // 04c: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 051: ifeq 1e8
      // 054: getstatic com/jibo/db/EntityData.l Lcom/google/gson/Gson;
      // 057: aload 6
      // 059: aload 6
      // 05b: ldc "data"
      // 05d: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
      // 062: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 067: ldc com/jibo/aws/integration/aws/services/account/model/Account
      // 069: invokevirtual com/google/gson/Gson.a (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
      // 06c: checkcast com/jibo/aws/integration/aws/services/account/model/Account
      // 06f: astore 7
      // 071: iload 5
      // 073: istore 4
      // 075: aload 1
      // 076: invokevirtual com/jibo/aws/integration/aws/services/account/model/Account.getAccessKeyId ()Ljava/lang/String;
      // 079: ifnull 0f0
      // 07c: iload 5
      // 07e: istore 4
      // 080: aload 1
      // 081: invokevirtual com/jibo/aws/integration/aws/services/account/model/Account.getSecretAccessKey ()Ljava/lang/String;
      // 084: ifnull 0f0
      // 087: aload 1
      // 088: invokevirtual com/jibo/aws/integration/aws/services/account/model/Account.getAccessKeyId ()Ljava/lang/String;
      // 08b: ifnonnull 136
      // 08e: bipush 1
      // 08f: istore 4
      // 091: aload 7
      // 093: invokevirtual com/jibo/aws/integration/aws/services/account/model/Account.getAccessKeyId ()Ljava/lang/String;
      // 096: ifnonnull 13c
      // 099: bipush 1
      // 09a: istore 5
      // 09c: iload 5
      // 09e: iload 4
      // 0a0: ixor
      // 0a1: ifne 0ed
      // 0a4: aload 1
      // 0a5: invokevirtual com/jibo/aws/integration/aws/services/account/model/Account.getAccessKeyId ()Ljava/lang/String;
      // 0a8: ifnull 0ba
      // 0ab: aload 1
      // 0ac: invokevirtual com/jibo/aws/integration/aws/services/account/model/Account.getAccessKeyId ()Ljava/lang/String;
      // 0af: aload 7
      // 0b1: invokevirtual com/jibo/aws/integration/aws/services/account/model/Account.getAccessKeyId ()Ljava/lang/String;
      // 0b4: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0b7: ifeq 0ed
      // 0ba: aload 1
      // 0bb: invokevirtual com/jibo/aws/integration/aws/services/account/model/Account.getSecretAccessKey ()Ljava/lang/String;
      // 0be: ifnonnull 142
      // 0c1: bipush 1
      // 0c2: istore 4
      // 0c4: aload 7
      // 0c6: invokevirtual com/jibo/aws/integration/aws/services/account/model/Account.getSecretAccessKey ()Ljava/lang/String;
      // 0c9: ifnonnull 148
      // 0cc: bipush 1
      // 0cd: istore 5
      // 0cf: iload 5
      // 0d1: iload 4
      // 0d3: ixor
      // 0d4: ifne 0ed
      // 0d7: aload 1
      // 0d8: invokevirtual com/jibo/aws/integration/aws/services/account/model/Account.getSecretAccessKey ()Ljava/lang/String;
      // 0db: ifnull 14e
      // 0de: aload 1
      // 0df: invokevirtual com/jibo/aws/integration/aws/services/account/model/Account.getSecretAccessKey ()Ljava/lang/String;
      // 0e2: aload 7
      // 0e4: invokevirtual com/jibo/aws/integration/aws/services/account/model/Account.getSecretAccessKey ()Ljava/lang/String;
      // 0e7: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0ea: ifne 14e
      // 0ed: bipush 1
      // 0ee: istore 4
      // 0f0: iload 4
      // 0f2: ifeq 0f9
      // 0f5: aload 0
      // 0f6: invokespecial com/jibo/db/EntityData.n ()V
      // 0f9: iload 2
      // 0fa: ifne 187
      // 0fd: aload 1
      // 0fe: aload 7
      // 100: invokevirtual com/jibo/aws/integration/aws/services/account/model/Account.getUpdateRequest (Lcom/jibo/aws/integration/aws/services/account/model/Account;)Lcom/jibo/aws/integration/aws/services/account/model/UpdateRequest;
      // 103: astore 1
      // 104: aload 1
      // 105: invokevirtual com/jibo/aws/integration/aws/services/account/model/UpdateRequest.isEmpty ()Z
      // 108: ifne 154
      // 10b: aload 0
      // 10c: invokevirtual com/jibo/db/EntityData.a ()Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;
      // 10f: astore 8
      // 111: new com/jibo/db/EntityData$1
      // 114: astore 9
      // 116: aload 9
      // 118: aload 0
      // 119: aload 3
      // 11a: aload 7
      // 11c: aload 1
      // 11d: invokespecial com/jibo/db/EntityData$1.<init> (Lcom/jibo/db/EntityData;Lcom/amazonaws/handlers/AsyncHandler;Lcom/jibo/aws/integration/aws/services/account/model/Account;Lcom/jibo/aws/integration/aws/services/account/model/UpdateRequest;)V
      // 120: aload 8
      // 122: aload 1
      // 123: aload 9
      // 125: invokevirtual com/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient.update (Lcom/jibo/aws/integration/aws/services/account/model/UpdateRequest;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
      // 128: pop
      // 129: aload 6
      // 12b: ifnull 135
      // 12e: aload 6
      // 130: invokeinterface android/database/Cursor.close ()V 1
      // 135: return
      // 136: bipush 0
      // 137: istore 4
      // 139: goto 091
      // 13c: bipush 0
      // 13d: istore 5
      // 13f: goto 09c
      // 142: bipush 0
      // 143: istore 4
      // 145: goto 0c4
      // 148: bipush 0
      // 149: istore 5
      // 14b: goto 0cf
      // 14e: bipush 0
      // 14f: istore 4
      // 151: goto 0f0
      // 154: aload 3
      // 155: ifnull 129
      // 158: aload 3
      // 159: aload 1
      // 15a: aload 7
      // 15c: invokeinterface com/amazonaws/handlers/AsyncHandler.onSuccess (Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V 3
      // 161: goto 129
      // 164: astore 7
      // 166: aload 6
      // 168: astore 1
      // 169: aload 7
      // 16b: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // 16e: aload 3
      // 16f: ifnull 17a
      // 172: aload 3
      // 173: aload 7
      // 175: invokeinterface com/amazonaws/handlers/AsyncHandler.onError (Ljava/lang/Exception;)V 2
      // 17a: aload 1
      // 17b: ifnull 135
      // 17e: aload 1
      // 17f: invokeinterface android/database/Cursor.close ()V 1
      // 184: goto 135
      // 187: aload 7
      // 189: aload 1
      // 18a: invokevirtual com/jibo/aws/integration/aws/services/account/model/Account.update (Lcom/jibo/aws/integration/aws/services/account/model/Account;)V
      // 18d: aload 8
      // 18f: ldc "type"
      // 191: bipush 1
      // 192: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 195: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/Integer;)V
      // 198: aload 8
      // 19a: ldc "data"
      // 19c: getstatic com/jibo/db/EntityData.l Lcom/google/gson/Gson;
      // 19f: aload 7
      // 1a1: invokevirtual com/google/gson/Gson.b (Ljava/lang/Object;)Ljava/lang/String;
      // 1a4: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/String;)V
      // 1a7: getstatic com/jibo/db/EntityData.c Landroid/content/Context;
      // 1aa: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 1ad: bipush 1
      // 1ae: invokestatic com/jibo/db/DatabaseContract$EntityEntry.a (I)Landroid/net/Uri;
      // 1b1: aload 8
      // 1b3: aconst_null
      // 1b4: aconst_null
      // 1b5: invokevirtual android/content/ContentResolver.update (Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
      // 1b8: pop
      // 1b9: aload 0
      // 1ba: invokespecial com/jibo/db/EntityData.q ()V
      // 1bd: iload 4
      // 1bf: ifeq 1ca
      // 1c2: aload 0
      // 1c3: invokespecial com/jibo/db/EntityData.n ()V
      // 1c6: aload 0
      // 1c7: invokespecial com/jibo/db/EntityData.m ()V
      // 1ca: aload 3
      // 1cb: ifnull 129
      // 1ce: aload 3
      // 1cf: aconst_null
      // 1d0: aload 1
      // 1d1: invokeinterface com/amazonaws/handlers/AsyncHandler.onSuccess (Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V 3
      // 1d6: goto 129
      // 1d9: astore 1
      // 1da: aload 6
      // 1dc: ifnull 1e6
      // 1df: aload 6
      // 1e1: invokeinterface android/database/Cursor.close ()V 1
      // 1e6: aload 1
      // 1e7: athrow
      // 1e8: aload 8
      // 1ea: ldc "_id"
      // 1ec: aload 1
      // 1ed: invokevirtual com/jibo/aws/integration/aws/services/account/model/Account.getId ()Ljava/lang/String;
      // 1f0: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/String;)V
      // 1f3: aload 8
      // 1f5: ldc "type"
      // 1f7: bipush 1
      // 1f8: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 1fb: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/Integer;)V
      // 1fe: aload 8
      // 200: ldc "data"
      // 202: getstatic com/jibo/db/EntityData.l Lcom/google/gson/Gson;
      // 205: aload 1
      // 206: invokevirtual com/google/gson/Gson.b (Ljava/lang/Object;)Ljava/lang/String;
      // 209: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/String;)V
      // 20c: getstatic com/jibo/db/EntityData.c Landroid/content/Context;
      // 20f: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 212: bipush 1
      // 213: invokestatic com/jibo/db/DatabaseContract$EntityEntry.a (I)Landroid/net/Uri;
      // 216: aload 8
      // 218: invokevirtual android/content/ContentResolver.insert (Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
      // 21b: pop
      // 21c: aload 0
      // 21d: invokespecial com/jibo/db/EntityData.q ()V
      // 220: aload 0
      // 221: invokespecial com/jibo/db/EntityData.n ()V
      // 224: aload 0
      // 225: invokespecial com/jibo/db/EntityData.m ()V
      // 228: aload 3
      // 229: ifnull 129
      // 22c: aload 3
      // 22d: aconst_null
      // 22e: aload 1
      // 22f: invokeinterface com/amazonaws/handlers/AsyncHandler.onSuccess (Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V 3
      // 234: goto 129
      // 237: astore 1
      // 238: aconst_null
      // 239: astore 6
      // 23b: goto 1da
      // 23e: astore 3
      // 23f: aload 1
      // 240: astore 6
      // 242: aload 3
      // 243: astore 1
      // 244: goto 1da
      // 247: astore 7
      // 249: aconst_null
      // 24a: astore 1
      // 24b: goto 169
      // try (2 -> 16): 266 java/lang/Exception
      // try (2 -> 16): 256 null
      // try (18 -> 23): 266 java/lang/Exception
      // try (18 -> 23): 256 null
      // try (23 -> 33): 266 java/lang/Exception
      // try (23 -> 33): 256 null
      // try (33 -> 46): 160 java/lang/Exception
      // try (33 -> 46): 213 null
      // try (48 -> 51): 160 java/lang/Exception
      // try (48 -> 51): 213 null
      // try (53 -> 59): 160 java/lang/Exception
      // try (53 -> 59): 213 null
      // try (61 -> 64): 160 java/lang/Exception
      // try (61 -> 64): 213 null
      // try (70 -> 79): 160 java/lang/Exception
      // try (70 -> 79): 213 null
      // try (79 -> 82): 160 java/lang/Exception
      // try (79 -> 82): 213 null
      // try (84 -> 87): 160 java/lang/Exception
      // try (84 -> 87): 213 null
      // try (93 -> 102): 160 java/lang/Exception
      // try (93 -> 102): 213 null
      // try (106 -> 108): 160 java/lang/Exception
      // try (106 -> 108): 213 null
      // try (110 -> 133): 160 java/lang/Exception
      // try (110 -> 133): 213 null
      // try (155 -> 159): 160 java/lang/Exception
      // try (155 -> 159): 213 null
      // try (163 -> 165): 260 null
      // try (167 -> 170): 260 null
      // try (175 -> 200): 160 java/lang/Exception
      // try (175 -> 200): 213 null
      // try (202 -> 206): 160 java/lang/Exception
      // try (202 -> 206): 213 null
      // try (208 -> 212): 160 java/lang/Exception
      // try (208 -> 212): 213 null
      // try (220 -> 249): 160 java/lang/Exception
      // try (220 -> 249): 213 null
      // try (251 -> 255): 160 java/lang/Exception
      // try (251 -> 255): 213 null
   }

   public void a(Message param1, String param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: bipush 1
      // 001: istore 4
      // 003: aconst_null
      // 004: astore 5
      // 006: new android/content/ContentValues
      // 009: astore 7
      // 00b: aload 7
      // 00d: invokespecial android/content/ContentValues.<init> ()V
      // 010: aload 7
      // 012: ldc_w "loopId"
      // 015: aload 1
      // 016: invokevirtual com/jibo/aws/integration/aws/services/jot/model/Message.getLoopId ()Ljava/lang/String;
      // 019: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/String;)V
      // 01c: aload 7
      // 01e: ldc_w "content"
      // 021: aload 1
      // 022: invokevirtual com/jibo/aws/integration/aws/services/jot/model/Message.getContent ()Ljava/lang/String;
      // 025: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/String;)V
      // 028: aload 7
      // 02a: ldc_w "created"
      // 02d: aload 1
      // 02e: invokevirtual com/jibo/aws/integration/aws/services/jot/model/Message.getCreated ()Ljava/lang/Long;
      // 031: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/Long;)V
      // 034: aload 7
      // 036: ldc_w "sender"
      // 039: aload 1
      // 03a: invokevirtual com/jibo/aws/integration/aws/services/jot/model/Message.getSender ()Ljava/lang/String;
      // 03d: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/String;)V
      // 040: aload 1
      // 041: invokevirtual com/jibo/aws/integration/aws/services/jot/model/Message.isRead ()Ljava/lang/Boolean;
      // 044: invokevirtual java/lang/Boolean.booleanValue ()Z
      // 047: ifeq 0e5
      // 04a: bipush 1
      // 04b: istore 3
      // 04c: aload 7
      // 04e: ldc_w "is_read"
      // 051: iload 3
      // 052: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 055: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/Integer;)V
      // 058: aload 7
      // 05a: ldc_w "parts"
      // 05d: getstatic com/jibo/db/EntityData.l Lcom/google/gson/Gson;
      // 060: aload 1
      // 061: invokevirtual com/jibo/aws/integration/aws/services/jot/model/Message.getParts ()Ljava/util/List;
      // 064: invokevirtual com/google/gson/Gson.b (Ljava/lang/Object;)Ljava/lang/String;
      // 067: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/String;)V
      // 06a: aload 1
      // 06b: invokestatic com/jibo/aws/integration/helpers/JotHelper.hasPhotoOrVideo (Lcom/jibo/aws/integration/aws/services/jot/model/Message;)Z
      // 06e: ifeq 0ea
      // 071: iload 4
      // 073: istore 3
      // 074: aload 7
      // 076: ldc_w "hasPhotoVideo"
      // 079: iload 3
      // 07a: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 07d: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/Integer;)V
      // 080: aload 7
      // 082: ldc_w "tags"
      // 085: getstatic com/jibo/db/EntityData.l Lcom/google/gson/Gson;
      // 088: aload 1
      // 089: invokevirtual com/jibo/aws/integration/aws/services/jot/model/Message.getTags ()Ljava/util/List;
      // 08c: invokevirtual com/google/gson/Gson.b (Ljava/lang/Object;)Ljava/lang/String;
      // 08f: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/String;)V
      // 092: getstatic com/jibo/db/EntityData.c Landroid/content/Context;
      // 095: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 098: aload 2
      // 099: invokestatic com/jibo/db/DatabaseContract$JotEntry.a (Ljava/lang/String;)Landroid/net/Uri;
      // 09c: aconst_null
      // 09d: aconst_null
      // 09e: aconst_null
      // 09f: aconst_null
      // 0a0: invokevirtual android/content/ContentResolver.query (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      // 0a3: astore 6
      // 0a5: aload 6
      // 0a7: astore 5
      // 0a9: aload 6
      // 0ab: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 0b0: ifeq 0ef
      // 0b3: aload 6
      // 0b5: astore 5
      // 0b7: aload 7
      // 0b9: ldc "_id"
      // 0bb: aload 1
      // 0bc: invokevirtual com/jibo/aws/integration/aws/services/jot/model/Message.getId ()Ljava/lang/String;
      // 0bf: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/String;)V
      // 0c2: aload 6
      // 0c4: astore 5
      // 0c6: getstatic com/jibo/db/EntityData.c Landroid/content/Context;
      // 0c9: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 0cc: aload 2
      // 0cd: invokestatic com/jibo/db/DatabaseContract$JotEntry.a (Ljava/lang/String;)Landroid/net/Uri;
      // 0d0: aload 7
      // 0d2: aconst_null
      // 0d3: aconst_null
      // 0d4: invokevirtual android/content/ContentResolver.update (Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
      // 0d7: pop
      // 0d8: aload 6
      // 0da: ifnull 0e4
      // 0dd: aload 6
      // 0df: invokeinterface android/database/Cursor.close ()V 1
      // 0e4: return
      // 0e5: bipush 0
      // 0e6: istore 3
      // 0e7: goto 04c
      // 0ea: bipush 0
      // 0eb: istore 3
      // 0ec: goto 074
      // 0ef: aload 6
      // 0f1: astore 5
      // 0f3: getstatic com/jibo/db/DatabaseContract$JotEntry.a Landroid/net/Uri;
      // 0f6: astore 2
      // 0f7: aload 6
      // 0f9: astore 5
      // 0fb: aload 1
      // 0fc: invokevirtual com/jibo/aws/integration/aws/services/jot/model/Message.getId ()Ljava/lang/String;
      // 0ff: ifnull 11d
      // 102: aload 6
      // 104: astore 5
      // 106: aload 7
      // 108: ldc "_id"
      // 10a: aload 1
      // 10b: invokevirtual com/jibo/aws/integration/aws/services/jot/model/Message.getId ()Ljava/lang/String;
      // 10e: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/String;)V
      // 111: aload 6
      // 113: astore 5
      // 115: aload 1
      // 116: invokevirtual com/jibo/aws/integration/aws/services/jot/model/Message.getId ()Ljava/lang/String;
      // 119: invokestatic com/jibo/db/DatabaseContract$JotEntry.a (Ljava/lang/String;)Landroid/net/Uri;
      // 11c: astore 2
      // 11d: aload 6
      // 11f: astore 5
      // 121: getstatic com/jibo/db/EntityData.c Landroid/content/Context;
      // 124: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 127: aload 2
      // 128: aload 7
      // 12a: invokevirtual android/content/ContentResolver.insert (Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
      // 12d: pop
      // 12e: goto 0d8
      // 131: astore 1
      // 132: aload 6
      // 134: astore 5
      // 136: aload 1
      // 137: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // 13a: aload 6
      // 13c: ifnull 0e4
      // 13f: aload 6
      // 141: invokeinterface android/database/Cursor.close ()V 1
      // 146: goto 0e4
      // 149: astore 1
      // 14a: aload 5
      // 14c: astore 2
      // 14d: aload 2
      // 14e: ifnull 157
      // 151: aload 2
      // 152: invokeinterface android/database/Cursor.close ()V 1
      // 157: aload 1
      // 158: athrow
      // 159: astore 1
      // 15a: aload 5
      // 15c: astore 2
      // 15d: goto 14d
      // 160: astore 1
      // 161: aconst_null
      // 162: astore 6
      // 164: goto 132
      // try (4 -> 32): 161 java/lang/Exception
      // try (4 -> 32): 148 null
      // try (34 -> 49): 161 java/lang/Exception
      // try (34 -> 49): 148 null
      // try (51 -> 73): 161 java/lang/Exception
      // try (51 -> 73): 148 null
      // try (75 -> 78): 138 java/lang/Exception
      // try (75 -> 78): 157 null
      // try (80 -> 85): 138 java/lang/Exception
      // try (80 -> 85): 157 null
      // try (87 -> 96): 138 java/lang/Exception
      // try (87 -> 96): 157 null
      // try (109 -> 111): 138 java/lang/Exception
      // try (109 -> 111): 157 null
      // try (113 -> 116): 138 java/lang/Exception
      // try (113 -> 116): 157 null
      // try (118 -> 123): 138 java/lang/Exception
      // try (118 -> 123): 157 null
      // try (125 -> 129): 138 java/lang/Exception
      // try (125 -> 129): 157 null
      // try (131 -> 137): 138 java/lang/Exception
      // try (131 -> 137): 157 null
      // try (141 -> 143): 157 null
   }

   public void a(Loop var1) {
      Loop var2 = SharedPreferencesUtil.f(c);
      if (var2 == null && var1 != null || var2 != null && !var2.equals(var1)) {
         SharedPreferencesUtil.a(c, var1);
         c.getContentResolver().notifyChange(DatabaseContract.EntityEntry.a(8), null);
      }
   }

   public void a(Loop param1, boolean param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: new android/content/ContentValues
      // 003: astore 5
      // 005: aload 5
      // 007: invokespecial android/content/ContentValues.<init> ()V
      // 00a: aload 5
      // 00c: ldc "_id"
      // 00e: aload 1
      // 00f: invokevirtual com/jibo/aws/integration/aws/services/loop/model/Loop.getId ()Ljava/lang/String;
      // 012: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/String;)V
      // 015: aload 5
      // 017: ldc "modified"
      // 019: invokestatic java/lang/System.currentTimeMillis ()J
      // 01c: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 01f: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/Long;)V
      // 022: aload 5
      // 024: ldc "name"
      // 026: aload 1
      // 027: invokevirtual com/jibo/aws/integration/aws/services/loop/model/Loop.getName ()Ljava/lang/String;
      // 02a: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/String;)V
      // 02d: iload 2
      // 02e: ifeq 03f
      // 031: aload 5
      // 033: ldc_w "retrieved"
      // 036: invokestatic java/lang/System.currentTimeMillis ()J
      // 039: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 03c: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/Long;)V
      // 03f: aload 5
      // 041: ldc "data"
      // 043: getstatic com/jibo/db/EntityData.l Lcom/google/gson/Gson;
      // 046: aload 1
      // 047: invokevirtual com/google/gson/Gson.b (Ljava/lang/Object;)Ljava/lang/String;
      // 04a: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/String;)V
      // 04d: getstatic com/jibo/db/EntityData.c Landroid/content/Context;
      // 050: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 053: bipush 8
      // 055: aload 1
      // 056: invokevirtual com/jibo/aws/integration/aws/services/loop/model/Loop.getId ()Ljava/lang/String;
      // 059: invokestatic com/jibo/db/DatabaseContract$EntityEntry.a (ILjava/lang/String;)Landroid/net/Uri;
      // 05c: aconst_null
      // 05d: aconst_null
      // 05e: aconst_null
      // 05f: aconst_null
      // 060: invokevirtual android/content/ContentResolver.query (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      // 063: astore 4
      // 065: aload 4
      // 067: astore 3
      // 068: aload 4
      // 06a: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 06f: ifeq 101
      // 072: aload 4
      // 074: astore 3
      // 075: getstatic com/jibo/db/EntityData.l Lcom/google/gson/Gson;
      // 078: aload 4
      // 07a: aload 4
      // 07c: ldc "data"
      // 07e: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
      // 083: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 088: ldc com/jibo/aws/integration/aws/services/loop/model/Loop
      // 08a: invokevirtual com/google/gson/Gson.a (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
      // 08d: checkcast com/jibo/aws/integration/aws/services/loop/model/Loop
      // 090: astore 6
      // 092: iload 2
      // 093: ifne 0cd
      // 096: aload 4
      // 098: astore 3
      // 099: aload 6
      // 09b: aload 1
      // 09c: invokevirtual com/jibo/aws/integration/aws/services/loop/model/Loop.equals (Ljava/lang/Object;)Z
      // 09f: ifne 0bc
      // 0a2: aload 4
      // 0a4: astore 3
      // 0a5: getstatic com/jibo/db/EntityData.c Landroid/content/Context;
      // 0a8: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 0ab: bipush 8
      // 0ad: aload 1
      // 0ae: invokevirtual com/jibo/aws/integration/aws/services/loop/model/Loop.getId ()Ljava/lang/String;
      // 0b1: invokestatic com/jibo/db/DatabaseContract$EntityEntry.a (ILjava/lang/String;)Landroid/net/Uri;
      // 0b4: aload 5
      // 0b6: aconst_null
      // 0b7: aconst_null
      // 0b8: invokevirtual android/content/ContentResolver.update (Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
      // 0bb: pop
      // 0bc: aload 4
      // 0be: ifnull 0c8
      // 0c1: aload 4
      // 0c3: invokeinterface android/database/Cursor.close ()V 1
      // 0c8: aload 0
      // 0c9: invokespecial com/jibo/db/EntityData.r ()V
      // 0cc: return
      // 0cd: aload 4
      // 0cf: astore 3
      // 0d0: getstatic com/jibo/db/EntityData.c Landroid/content/Context;
      // 0d3: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 0d6: bipush 8
      // 0d8: aload 1
      // 0d9: invokevirtual com/jibo/aws/integration/aws/services/loop/model/Loop.getId ()Ljava/lang/String;
      // 0dc: invokestatic com/jibo/db/DatabaseContract$EntityEntry.a (ILjava/lang/String;)Landroid/net/Uri;
      // 0df: aload 5
      // 0e1: aconst_null
      // 0e2: aconst_null
      // 0e3: invokevirtual android/content/ContentResolver.update (Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
      // 0e6: pop
      // 0e7: goto 0bc
      // 0ea: astore 1
      // 0eb: aload 4
      // 0ed: astore 3
      // 0ee: aload 1
      // 0ef: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // 0f2: aload 4
      // 0f4: ifnull 0c8
      // 0f7: aload 4
      // 0f9: invokeinterface android/database/Cursor.close ()V 1
      // 0fe: goto 0c8
      // 101: aload 4
      // 103: astore 3
      // 104: aload 5
      // 106: ldc "type"
      // 108: bipush 8
      // 10a: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 10d: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/Integer;)V
      // 110: aload 4
      // 112: astore 3
      // 113: getstatic com/jibo/db/EntityData.c Landroid/content/Context;
      // 116: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 119: bipush 8
      // 11b: invokestatic com/jibo/db/DatabaseContract$EntityEntry.a (I)Landroid/net/Uri;
      // 11e: aload 5
      // 120: invokevirtual android/content/ContentResolver.insert (Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
      // 123: pop
      // 124: goto 0bc
      // 127: astore 1
      // 128: aload 3
      // 129: ifnull 132
      // 12c: aload 3
      // 12d: invokeinterface android/database/Cursor.close ()V 1
      // 132: aload 1
      // 133: athrow
      // 134: astore 1
      // 135: aconst_null
      // 136: astore 3
      // 137: goto 128
      // 13a: astore 1
      // 13b: aconst_null
      // 13c: astore 4
      // 13e: goto 0eb
      // try (0 -> 19): 141 java/lang/Exception
      // try (0 -> 19): 137 null
      // try (21 -> 26): 141 java/lang/Exception
      // try (21 -> 26): 137 null
      // try (26 -> 44): 141 java/lang/Exception
      // try (26 -> 44): 137 null
      // try (46 -> 49): 103 java/lang/Exception
      // try (46 -> 49): 130 null
      // try (51 -> 61): 103 java/lang/Exception
      // try (51 -> 61): 130 null
      // try (65 -> 69): 103 java/lang/Exception
      // try (65 -> 69): 130 null
      // try (71 -> 82): 103 java/lang/Exception
      // try (71 -> 82): 130 null
      // try (91 -> 102): 103 java/lang/Exception
      // try (91 -> 102): 130 null
      // try (106 -> 108): 130 null
      // try (115 -> 120): 103 java/lang/Exception
      // try (115 -> 120): 130 null
      // try (122 -> 129): 103 java/lang/Exception
      // try (122 -> 129): 130 null
   }

   public void a(Commons.AsyncCallback<Object> var1) {
      this.a().get(null, new AsyncHandler<GetRequest, List<Account>>(this, var1) {
         final Commons.AsyncCallback a;
         final EntityData b;

         {
            this.b = var1;
            this.a = var2;
         }

         public void a(GetRequest var1, List<Account> var2) {
            this.b.a((Account)var2.get(0), true, null);
            if (((Account)var2.get(0)).isActive()) {
               try {
                  List var4 = this.b.a(true);
                  this.a.onSuccess(var4);
               } catch (Exception var3) {
                  Crashlytics.a(var3);
                  this.a.onError(var3);
               }
            } else {
               this.a.onSuccess(var2.get(0));
            }
         }

         @Override
         public void onError(Exception var1) {
            this.a.onError(var1);
         }
      });
   }

   public void a(List<String> param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aload 1
      // 001: ifnull 00d
      // 004: aload 1
      // 005: invokeinterface java/util/List.size ()I 1
      // 00a: ifne 00e
      // 00d: return
      // 00e: new java/lang/StringBuilder
      // 011: dup
      // 012: ldc "_id"
      // 014: invokespecial java/lang/StringBuilder.<init> (Ljava/lang/String;)V
      // 017: ldc " IN ("
      // 019: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 01c: astore 2
      // 01d: aload 2
      // 01e: ldc "'"
      // 020: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 023: ldc "','"
      // 025: aload 1
      // 026: invokestatic android/text/TextUtils.join (Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
      // 029: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 02c: ldc "')"
      // 02e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 031: pop
      // 032: getstatic com/jibo/db/EntityData.c Landroid/content/Context;
      // 035: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 038: getstatic com/jibo/db/DatabaseContract$MediaEntry.b Landroid/net/Uri;
      // 03b: aload 2
      // 03c: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 03f: aconst_null
      // 040: invokevirtual android/content/ContentResolver.delete (Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
      // 043: pop
      // 044: aload 1
      // 045: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 04a: astore 4
      // 04c: aconst_null
      // 04d: astore 1
      // 04e: aload 4
      // 050: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 055: ifeq 00d
      // 058: aload 4
      // 05a: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 05f: checkcast java/lang/String
      // 062: astore 6
      // 064: getstatic com/jibo/db/EntityData.c Landroid/content/Context;
      // 067: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 06a: astore 3
      // 06b: getstatic com/jibo/db/DatabaseContract$JotEntry.a Landroid/net/Uri;
      // 06e: astore 2
      // 06f: new java/lang/StringBuilder
      // 072: astore 5
      // 074: aload 5
      // 076: invokespecial java/lang/StringBuilder.<init> ()V
      // 079: aload 3
      // 07a: aload 2
      // 07b: aconst_null
      // 07c: ldc_w "parts LIKE ?"
      // 07f: bipush 1
      // 080: anewarray 127
      // 083: dup
      // 084: bipush 0
      // 085: aload 5
      // 087: ldc_w "%\"path\":\""
      // 08a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 08d: aload 6
      // 08f: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 092: ldc_w "\"%"
      // 095: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 098: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 09b: aastore
      // 09c: aconst_null
      // 09d: invokevirtual android/content/ContentResolver.query (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      // 0a0: astore 2
      // 0a1: aload 2
      // 0a2: ifnull 11a
      // 0a5: aload 2
      // 0a6: invokeinterface android/database/Cursor.isClosed ()Z 1
      // 0ab: ifne 11a
      // 0ae: aload 2
      // 0af: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 0b4: ifeq 11a
      // 0b7: aload 2
      // 0b8: invokestatic com/jibo/db/EntityData.b (Landroid/database/Cursor;)Lcom/jibo/aws/integration/aws/services/jot/model/Message;
      // 0bb: astore 5
      // 0bd: aload 5
      // 0bf: invokevirtual com/jibo/aws/integration/aws/services/jot/model/Message.getParts ()Ljava/util/List;
      // 0c2: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 0c7: astore 3
      // 0c8: aload 3
      // 0c9: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0ce: ifeq 10f
      // 0d1: aload 3
      // 0d2: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0d7: checkcast com/jibo/aws/integration/aws/services/jot/model/MessagePart
      // 0da: astore 1
      // 0db: aload 1
      // 0dc: aconst_null
      // 0dd: invokevirtual com/jibo/aws/integration/aws/services/jot/model/MessagePart.setUrl (Ljava/lang/String;)V
      // 0e0: aload 1
      // 0e1: aconst_null
      // 0e2: invokevirtual com/jibo/aws/integration/aws/services/jot/model/MessagePart.setType (Ljava/lang/String;)V
      // 0e5: goto 0c8
      // 0e8: astore 3
      // 0e9: aload 2
      // 0ea: astore 1
      // 0eb: aload 3
      // 0ec: astore 2
      // 0ed: aload 2
      // 0ee: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // 0f1: aload 1
      // 0f2: astore 2
      // 0f3: aload 1
      // 0f4: ifnull 0ff
      // 0f7: aload 1
      // 0f8: invokeinterface android/database/Cursor.close ()V 1
      // 0fd: aload 1
      // 0fe: astore 2
      // 0ff: aload 2
      // 100: astore 1
      // 101: goto 04e
      // 104: astore 2
      // 105: aload 2
      // 106: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // 109: goto 044
      // 10c: astore 1
      // 10d: aload 1
      // 10e: athrow
      // 10f: aload 0
      // 110: aload 5
      // 112: aload 5
      // 114: invokevirtual com/jibo/aws/integration/aws/services/jot/model/Message.getId ()Ljava/lang/String;
      // 117: invokevirtual com/jibo/db/EntityData.a (Lcom/jibo/aws/integration/aws/services/jot/model/Message;Ljava/lang/String;)V
      // 11a: aload 2
      // 11b: ifnull 144
      // 11e: aload 2
      // 11f: invokeinterface android/database/Cursor.close ()V 1
      // 124: goto 0ff
      // 127: astore 3
      // 128: aload 2
      // 129: astore 1
      // 12a: aload 3
      // 12b: astore 2
      // 12c: aload 1
      // 12d: ifnull 136
      // 130: aload 1
      // 131: invokeinterface android/database/Cursor.close ()V 1
      // 136: aload 2
      // 137: athrow
      // 138: astore 2
      // 139: goto 12c
      // 13c: astore 2
      // 13d: goto 12c
      // 140: astore 2
      // 141: goto 0ed
      // 144: goto 0ff
      // try (23 -> 31): 119 java/lang/Exception
      // try (23 -> 31): 123 null
      // try (43 -> 72): 151 java/lang/Exception
      // try (43 -> 72): 149 null
      // try (74 -> 87): 101 java/lang/Exception
      // try (74 -> 87): 136 null
      // try (87 -> 100): 101 java/lang/Exception
      // try (87 -> 100): 136 null
      // try (106 -> 108): 147 null
      // try (120 -> 122): 123 null
      // try (126 -> 131): 101 java/lang/Exception
      // try (126 -> 131): 136 null
   }

   public void a(List<Media> var1, boolean var2) {
      if (var2) {
         this.i(null);
      }

      if (var1 != null && !var1.isEmpty()) {
         int var5 = var1.size();
         ContentValues[] var6 = new ContentValues[var5];

         for (int var3 = 0; var3 < var5; var3++) {
            Media var7 = (Media)var1.get(var3);
            var6[var3] = new ContentValues();
            var6[var3].put("_id", var7.getPath());
            var6[var3].put("loopId", var7.getLoopId());
            var6[var3].put("created", var7.getCreated());
            var6[var3].put("accountId", var7.getAccountId());
            var6[var3].put("type", var7.getType());
            var6[var3].put("reference", var7.getReference());
            var6[var3].put("url", var7.getUrl());
            ContentValues var8 = var6[var3];
            byte var4;
            if (var7.isEncrypted()) {
               var4 = 1;
            } else {
               var4 = 0;
            }

            var8.put("isEncrypted", Integer.valueOf(var4));
         }

         try {
            c.getContentResolver().bulkInsert(DatabaseContract.MediaEntry.b, var6);
         } catch (Exception var11) {
            Crashlytics.a(var11);
         } finally {
            ;
         }
      }
   }

   public JiboLoopAsyncClient b() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: getfield com/jibo/db/EntityData.f Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;
      // 06: astore 1
      // 07: aload 1
      // 08: ifnull 12
      // 0b: aload 1
      // 0c: invokevirtual com/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient.isTerminated ()Z
      // 0f: ifeq 37
      // 12: aload 0
      // 13: monitorenter
      // 14: aload 0
      // 15: getfield com/jibo/db/EntityData.f Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;
      // 18: astore 1
      // 19: aload 1
      // 1a: ifnull 24
      // 1d: aload 1
      // 1e: invokevirtual com/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient.isTerminated ()Z
      // 21: ifeq 35
      // 24: new com/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient
      // 27: astore 1
      // 28: aload 1
      // 29: aload 0
      // 2a: invokespecial com/jibo/db/EntityData.o ()Lcom/amazonaws/auth/BasicAWSCredentials;
      // 2d: invokespecial com/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient.<init> (Lcom/amazonaws/auth/AWSCredentials;)V
      // 30: aload 0
      // 31: aload 1
      // 32: putfield com/jibo/db/EntityData.f Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;
      // 35: aload 0
      // 36: monitorexit
      // 37: aload 0
      // 38: getfield com/jibo/db/EntityData.f Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;
      // 3b: astore 1
      // 3c: aload 0
      // 3d: monitorexit
      // 3e: aload 1
      // 3f: areturn
      // 40: astore 1
      // 41: aload 0
      // 42: monitorexit
      // 43: aload 1
      // 44: athrow
      // 45: astore 1
      // 46: aload 0
      // 47: monitorexit
      // 48: aload 1
      // 49: athrow
      // try (2 -> 5): 43 null
      // try (7 -> 10): 43 null
      // try (10 -> 12): 43 null
      // try (12 -> 15): 38 null
      // try (17 -> 20): 38 null
      // try (20 -> 29): 38 null
      // try (29 -> 31): 38 null
      // try (31 -> 34): 43 null
      // try (39 -> 41): 38 null
      // try (41 -> 43): 43 null
   }

   public void b(String var1) {
      try {
         if (TextUtils.isEmpty(var1)) {
            c.getContentResolver().delete(DatabaseContract.EntityEntry.a(8), null, null);
         } else {
            c.getContentResolver().delete(DatabaseContract.EntityEntry.a(8, var1), null, null);
         }
      } catch (Exception var4) {
         Crashlytics.a(var4);
      } finally {
         ;
      }

      this.r();
   }

   public JiboGQAAsyncClient c() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: getfield com/jibo/db/EntityData.g Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAAsyncClient;
      // 06: astore 1
      // 07: aload 1
      // 08: ifnull 12
      // 0b: aload 1
      // 0c: invokevirtual com/jibo/aws/integration/aws/services/gqa/JiboGQAAsyncClient.isTerminated ()Z
      // 0f: ifeq 37
      // 12: aload 0
      // 13: monitorenter
      // 14: aload 0
      // 15: getfield com/jibo/db/EntityData.g Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAAsyncClient;
      // 18: astore 1
      // 19: aload 1
      // 1a: ifnull 24
      // 1d: aload 1
      // 1e: invokevirtual com/jibo/aws/integration/aws/services/gqa/JiboGQAAsyncClient.isTerminated ()Z
      // 21: ifeq 35
      // 24: new com/jibo/aws/integration/aws/services/gqa/JiboGQAAsyncClient
      // 27: astore 1
      // 28: aload 1
      // 29: aload 0
      // 2a: invokespecial com/jibo/db/EntityData.o ()Lcom/amazonaws/auth/BasicAWSCredentials;
      // 2d: invokespecial com/jibo/aws/integration/aws/services/gqa/JiboGQAAsyncClient.<init> (Lcom/amazonaws/auth/AWSCredentials;)V
      // 30: aload 0
      // 31: aload 1
      // 32: putfield com/jibo/db/EntityData.g Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAAsyncClient;
      // 35: aload 0
      // 36: monitorexit
      // 37: aload 0
      // 38: getfield com/jibo/db/EntityData.g Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAAsyncClient;
      // 3b: astore 1
      // 3c: aload 0
      // 3d: monitorexit
      // 3e: aload 1
      // 3f: areturn
      // 40: astore 1
      // 41: aload 0
      // 42: monitorexit
      // 43: aload 1
      // 44: athrow
      // 45: astore 1
      // 46: aload 0
      // 47: monitorexit
      // 48: aload 1
      // 49: athrow
      // try (2 -> 5): 43 null
      // try (7 -> 10): 43 null
      // try (10 -> 12): 43 null
      // try (12 -> 15): 38 null
      // try (17 -> 20): 38 null
      // try (20 -> 29): 38 null
      // try (29 -> 31): 38 null
      // try (31 -> 34): 43 null
      // try (39 -> 41): 38 null
      // try (41 -> 43): 43 null
   }

   public Loop c(String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aconst_null
      // 01: astore 2
      // 02: aload 1
      // 03: invokestatic android/text/TextUtils.isEmpty (Ljava/lang/CharSequence;)Z
      // 06: ifeq 0d
      // 09: aload 2
      // 0a: astore 1
      // 0b: aload 1
      // 0c: areturn
      // 0d: getstatic com/jibo/db/EntityData.c Landroid/content/Context;
      // 10: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 13: bipush 8
      // 15: aload 1
      // 16: invokestatic com/jibo/db/DatabaseContract$EntityEntry.a (ILjava/lang/String;)Landroid/net/Uri;
      // 19: aconst_null
      // 1a: aconst_null
      // 1b: aconst_null
      // 1c: aconst_null
      // 1d: invokevirtual android/content/ContentResolver.query (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      // 20: astore 2
      // 21: aload 2
      // 22: ifnull 87
      // 25: aload 2
      // 26: astore 1
      // 27: aload 2
      // 28: invokeinterface android/database/Cursor.isClosed ()Z 1
      // 2d: ifne 87
      // 30: aload 2
      // 31: astore 1
      // 32: aload 2
      // 33: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 38: ifeq 87
      // 3b: aload 2
      // 3c: astore 1
      // 3d: aload 2
      // 3e: invokestatic com/jibo/db/EntityData.a (Landroid/database/Cursor;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
      // 41: astore 3
      // 42: aload 3
      // 43: astore 1
      // 44: aload 2
      // 45: ifnull 50
      // 48: aload 2
      // 49: invokeinterface android/database/Cursor.close ()V 1
      // 4e: aload 3
      // 4f: astore 1
      // 50: goto 0b
      // 53: astore 3
      // 54: aconst_null
      // 55: astore 2
      // 56: aload 2
      // 57: astore 1
      // 58: aload 3
      // 59: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // 5c: aload 2
      // 5d: ifnull 82
      // 60: aload 2
      // 61: invokeinterface android/database/Cursor.close ()V 1
      // 66: aconst_null
      // 67: astore 1
      // 68: goto 50
      // 6b: astore 2
      // 6c: aconst_null
      // 6d: astore 1
      // 6e: aload 1
      // 6f: ifnull 78
      // 72: aload 1
      // 73: invokeinterface android/database/Cursor.close ()V 1
      // 78: aload 2
      // 79: athrow
      // 7a: astore 2
      // 7b: goto 6e
      // 7e: astore 3
      // 7f: goto 56
      // 82: aconst_null
      // 83: astore 1
      // 84: goto 50
      // 87: aconst_null
      // 88: astore 3
      // 89: goto 42
      // try (9 -> 20): 46 java/lang/Exception
      // try (9 -> 20): 60 null
      // try (24 -> 27): 71 java/lang/Exception
      // try (24 -> 27): 69 null
      // try (29 -> 32): 71 java/lang/Exception
      // try (29 -> 32): 69 null
      // try (34 -> 37): 71 java/lang/Exception
      // try (34 -> 37): 69 null
      // try (51 -> 53): 69 null
   }

   public JiboKeyAsyncClient d() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: getfield com/jibo/db/EntityData.h Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;
      // 06: astore 1
      // 07: aload 1
      // 08: ifnull 12
      // 0b: aload 1
      // 0c: invokevirtual com/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient.isTerminated ()Z
      // 0f: ifeq 37
      // 12: aload 0
      // 13: monitorenter
      // 14: aload 0
      // 15: getfield com/jibo/db/EntityData.h Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;
      // 18: astore 1
      // 19: aload 1
      // 1a: ifnull 24
      // 1d: aload 1
      // 1e: invokevirtual com/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient.isTerminated ()Z
      // 21: ifeq 35
      // 24: new com/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient
      // 27: astore 1
      // 28: aload 1
      // 29: aload 0
      // 2a: invokespecial com/jibo/db/EntityData.o ()Lcom/amazonaws/auth/BasicAWSCredentials;
      // 2d: invokespecial com/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient.<init> (Lcom/amazonaws/auth/AWSCredentials;)V
      // 30: aload 0
      // 31: aload 1
      // 32: putfield com/jibo/db/EntityData.h Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;
      // 35: aload 0
      // 36: monitorexit
      // 37: aload 0
      // 38: getfield com/jibo/db/EntityData.h Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;
      // 3b: astore 1
      // 3c: aload 0
      // 3d: monitorexit
      // 3e: aload 1
      // 3f: areturn
      // 40: astore 1
      // 41: aload 0
      // 42: monitorexit
      // 43: aload 1
      // 44: athrow
      // 45: astore 1
      // 46: aload 0
      // 47: monitorexit
      // 48: aload 1
      // 49: athrow
      // try (2 -> 5): 43 null
      // try (7 -> 10): 43 null
      // try (10 -> 12): 43 null
      // try (12 -> 15): 38 null
      // try (17 -> 20): 38 null
      // try (20 -> 29): 38 null
      // try (29 -> 31): 38 null
      // try (31 -> 34): 43 null
      // try (39 -> 41): 38 null
      // try (41 -> 43): 43 null
   }

   public Media d(String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aconst_null
      // 01: astore 2
      // 02: aload 1
      // 03: invokestatic android/text/TextUtils.isEmpty (Ljava/lang/CharSequence;)Z
      // 06: ifeq 0d
      // 09: aload 2
      // 0a: astore 1
      // 0b: aload 1
      // 0c: areturn
      // 0d: getstatic com/jibo/db/EntityData.c Landroid/content/Context;
      // 10: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 13: aload 1
      // 14: invokestatic com/jibo/db/DatabaseContract$MediaEntry.a (Ljava/lang/String;)Landroid/net/Uri;
      // 17: aconst_null
      // 18: aconst_null
      // 19: aconst_null
      // 1a: aconst_null
      // 1b: invokevirtual android/content/ContentResolver.query (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      // 1e: astore 2
      // 1f: aload 2
      // 20: ifnull 85
      // 23: aload 2
      // 24: astore 1
      // 25: aload 2
      // 26: invokeinterface android/database/Cursor.isClosed ()Z 1
      // 2b: ifne 85
      // 2e: aload 2
      // 2f: astore 1
      // 30: aload 2
      // 31: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 36: ifeq 85
      // 39: aload 2
      // 3a: astore 1
      // 3b: aload 2
      // 3c: invokestatic com/jibo/db/EntityData.c (Landroid/database/Cursor;)Lcom/jibo/aws/integration/aws/services/media/model/Media;
      // 3f: astore 3
      // 40: aload 3
      // 41: astore 1
      // 42: aload 2
      // 43: ifnull 4e
      // 46: aload 2
      // 47: invokeinterface android/database/Cursor.close ()V 1
      // 4c: aload 3
      // 4d: astore 1
      // 4e: goto 0b
      // 51: astore 3
      // 52: aconst_null
      // 53: astore 2
      // 54: aload 2
      // 55: astore 1
      // 56: aload 3
      // 57: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // 5a: aload 2
      // 5b: ifnull 80
      // 5e: aload 2
      // 5f: invokeinterface android/database/Cursor.close ()V 1
      // 64: aconst_null
      // 65: astore 1
      // 66: goto 4e
      // 69: astore 2
      // 6a: aconst_null
      // 6b: astore 1
      // 6c: aload 1
      // 6d: ifnull 76
      // 70: aload 1
      // 71: invokeinterface android/database/Cursor.close ()V 1
      // 76: aload 2
      // 77: athrow
      // 78: astore 2
      // 79: goto 6c
      // 7c: astore 3
      // 7d: goto 54
      // 80: aconst_null
      // 81: astore 1
      // 82: goto 4e
      // 85: aconst_null
      // 86: astore 3
      // 87: goto 40
      // try (9 -> 19): 45 java/lang/Exception
      // try (9 -> 19): 59 null
      // try (23 -> 26): 70 java/lang/Exception
      // try (23 -> 26): 68 null
      // try (28 -> 31): 70 java/lang/Exception
      // try (28 -> 31): 68 null
      // try (33 -> 36): 70 java/lang/Exception
      // try (33 -> 36): 68 null
      // try (50 -> 52): 68 null
   }

   public JiboMediaAsyncClient e() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: getfield com/jibo/db/EntityData.i Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;
      // 06: astore 1
      // 07: aload 1
      // 08: ifnull 12
      // 0b: aload 1
      // 0c: invokevirtual com/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient.isTerminated ()Z
      // 0f: ifeq 37
      // 12: aload 0
      // 13: monitorenter
      // 14: aload 0
      // 15: getfield com/jibo/db/EntityData.i Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;
      // 18: astore 1
      // 19: aload 1
      // 1a: ifnull 24
      // 1d: aload 1
      // 1e: invokevirtual com/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient.isTerminated ()Z
      // 21: ifeq 35
      // 24: new com/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient
      // 27: astore 1
      // 28: aload 1
      // 29: aload 0
      // 2a: invokespecial com/jibo/db/EntityData.o ()Lcom/amazonaws/auth/BasicAWSCredentials;
      // 2d: invokespecial com/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient.<init> (Lcom/amazonaws/auth/AWSCredentials;)V
      // 30: aload 0
      // 31: aload 1
      // 32: putfield com/jibo/db/EntityData.i Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;
      // 35: aload 0
      // 36: monitorexit
      // 37: aload 0
      // 38: getfield com/jibo/db/EntityData.i Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;
      // 3b: astore 1
      // 3c: aload 0
      // 3d: monitorexit
      // 3e: aload 1
      // 3f: areturn
      // 40: astore 1
      // 41: aload 0
      // 42: monitorexit
      // 43: aload 1
      // 44: athrow
      // 45: astore 1
      // 46: aload 0
      // 47: monitorexit
      // 48: aload 1
      // 49: athrow
      // try (2 -> 5): 43 null
      // try (7 -> 10): 43 null
      // try (10 -> 12): 43 null
      // try (12 -> 15): 38 null
      // try (17 -> 20): 38 null
      // try (20 -> 29): 38 null
      // try (29 -> 31): 38 null
      // try (31 -> 34): 43 null
      // try (39 -> 41): 38 null
      // try (41 -> 43): 43 null
   }

   public Media e(String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aconst_null
      // 01: astore 3
      // 02: aconst_null
      // 03: astore 2
      // 04: aload 1
      // 05: invokestatic android/text/TextUtils.isEmpty (Ljava/lang/CharSequence;)Z
      // 08: ifeq 0f
      // 0b: aload 2
      // 0c: astore 1
      // 0d: aload 1
      // 0e: areturn
      // 0f: getstatic com/jibo/db/EntityData.c Landroid/content/Context;
      // 12: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 15: getstatic com/jibo/db/DatabaseContract$MediaEntry.b Landroid/net/Uri;
      // 18: aconst_null
      // 19: ldc_w "reference = ?"
      // 1c: bipush 1
      // 1d: anewarray 127
      // 20: dup
      // 21: bipush 0
      // 22: aload 1
      // 23: aastore
      // 24: aconst_null
      // 25: invokevirtual android/content/ContentResolver.query (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      // 28: astore 2
      // 29: aload 2
      // 2a: ifnull 8f
      // 2d: aload 2
      // 2e: astore 1
      // 2f: aload 2
      // 30: invokeinterface android/database/Cursor.isClosed ()Z 1
      // 35: ifne 8f
      // 38: aload 2
      // 39: astore 1
      // 3a: aload 2
      // 3b: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 40: ifeq 8f
      // 43: aload 2
      // 44: astore 1
      // 45: aload 2
      // 46: invokestatic com/jibo/db/EntityData.c (Landroid/database/Cursor;)Lcom/jibo/aws/integration/aws/services/media/model/Media;
      // 49: astore 3
      // 4a: aload 3
      // 4b: astore 1
      // 4c: aload 2
      // 4d: ifnull 58
      // 50: aload 2
      // 51: invokeinterface android/database/Cursor.close ()V 1
      // 56: aload 3
      // 57: astore 1
      // 58: goto 0d
      // 5b: astore 3
      // 5c: aconst_null
      // 5d: astore 2
      // 5e: aload 2
      // 5f: astore 1
      // 60: aload 3
      // 61: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // 64: aload 2
      // 65: ifnull 8a
      // 68: aload 2
      // 69: invokeinterface android/database/Cursor.close ()V 1
      // 6e: aconst_null
      // 6f: astore 1
      // 70: goto 58
      // 73: astore 2
      // 74: aload 3
      // 75: astore 1
      // 76: aload 1
      // 77: ifnull 80
      // 7a: aload 1
      // 7b: invokeinterface android/database/Cursor.close ()V 1
      // 80: aload 2
      // 81: athrow
      // 82: astore 2
      // 83: goto 76
      // 86: astore 3
      // 87: goto 5e
      // 8a: aconst_null
      // 8b: astore 1
      // 8c: goto 58
      // 8f: aconst_null
      // 90: astore 3
      // 91: goto 4a
      // try (11 -> 25): 51 java/lang/Exception
      // try (11 -> 25): 65 null
      // try (29 -> 32): 76 java/lang/Exception
      // try (29 -> 32): 74 null
      // try (34 -> 37): 76 java/lang/Exception
      // try (34 -> 37): 74 null
      // try (39 -> 42): 76 java/lang/Exception
      // try (39 -> 42): 74 null
      // try (56 -> 58): 74 null
   }

   public JiboPushAsyncClient f() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: getfield com/jibo/db/EntityData.j Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;
      // 06: astore 1
      // 07: aload 1
      // 08: ifnull 12
      // 0b: aload 1
      // 0c: invokevirtual com/jibo/aws/integration/aws/services/push/JiboPushAsyncClient.isTerminated ()Z
      // 0f: ifeq 37
      // 12: aload 0
      // 13: monitorenter
      // 14: aload 0
      // 15: getfield com/jibo/db/EntityData.j Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;
      // 18: astore 1
      // 19: aload 1
      // 1a: ifnull 24
      // 1d: aload 1
      // 1e: invokevirtual com/jibo/aws/integration/aws/services/push/JiboPushAsyncClient.isTerminated ()Z
      // 21: ifeq 35
      // 24: new com/jibo/aws/integration/aws/services/push/JiboPushAsyncClient
      // 27: astore 1
      // 28: aload 1
      // 29: aload 0
      // 2a: invokespecial com/jibo/db/EntityData.o ()Lcom/amazonaws/auth/BasicAWSCredentials;
      // 2d: invokespecial com/jibo/aws/integration/aws/services/push/JiboPushAsyncClient.<init> (Lcom/amazonaws/auth/AWSCredentials;)V
      // 30: aload 0
      // 31: aload 1
      // 32: putfield com/jibo/db/EntityData.j Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;
      // 35: aload 0
      // 36: monitorexit
      // 37: aload 0
      // 38: getfield com/jibo/db/EntityData.j Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;
      // 3b: astore 1
      // 3c: aload 0
      // 3d: monitorexit
      // 3e: aload 1
      // 3f: areturn
      // 40: astore 1
      // 41: aload 0
      // 42: monitorexit
      // 43: aload 1
      // 44: athrow
      // 45: astore 1
      // 46: aload 0
      // 47: monitorexit
      // 48: aload 1
      // 49: athrow
      // try (2 -> 5): 43 null
      // try (7 -> 10): 43 null
      // try (10 -> 12): 43 null
      // try (12 -> 15): 38 null
      // try (17 -> 20): 38 null
      // try (20 -> 29): 38 null
      // try (29 -> 31): 38 null
      // try (31 -> 34): 43 null
      // try (39 -> 41): 38 null
      // try (41 -> 43): 43 null
   }

   public void f(String var1) {
      if (!TextUtils.isEmpty(var1)) {
         List var2 = this.b().listLoops();
         this.b(var2);

         for (Loop var3 : var2) {
            if (var3.getId().equals(var1)) {
               this.b(var3);
               break;
            }
         }
      }
   }

   public JiboRobotPropertiesAsyncClient g() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: getfield com/jibo/db/EntityData.k Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;
      // 06: astore 1
      // 07: aload 1
      // 08: ifnull 12
      // 0b: aload 1
      // 0c: invokevirtual com/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient.isTerminated ()Z
      // 0f: ifeq 37
      // 12: aload 0
      // 13: monitorenter
      // 14: aload 0
      // 15: getfield com/jibo/db/EntityData.k Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;
      // 18: astore 1
      // 19: aload 1
      // 1a: ifnull 24
      // 1d: aload 1
      // 1e: invokevirtual com/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient.isTerminated ()Z
      // 21: ifeq 35
      // 24: new com/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient
      // 27: astore 1
      // 28: aload 1
      // 29: aload 0
      // 2a: invokespecial com/jibo/db/EntityData.o ()Lcom/amazonaws/auth/BasicAWSCredentials;
      // 2d: invokespecial com/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient.<init> (Lcom/amazonaws/auth/AWSCredentials;)V
      // 30: aload 0
      // 31: aload 1
      // 32: putfield com/jibo/db/EntityData.k Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;
      // 35: aload 0
      // 36: monitorexit
      // 37: aload 0
      // 38: getfield com/jibo/db/EntityData.k Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;
      // 3b: astore 1
      // 3c: aload 0
      // 3d: monitorexit
      // 3e: aload 1
      // 3f: areturn
      // 40: astore 1
      // 41: aload 0
      // 42: monitorexit
      // 43: aload 1
      // 44: athrow
      // 45: astore 1
      // 46: aload 0
      // 47: monitorexit
      // 48: aload 1
      // 49: athrow
      // try (2 -> 5): 43 null
      // try (7 -> 10): 43 null
      // try (10 -> 12): 43 null
      // try (12 -> 15): 38 null
      // try (17 -> 20): 38 null
      // try (20 -> 29): 38 null
      // try (29 -> 31): 38 null
      // try (31 -> 34): 43 null
      // try (39 -> 41): 38 null
      // try (41 -> 43): 43 null
   }

   public void h() {
      this.n();
      this.d = null;
      this.p();
      this.b((String)null);
      this.g(null);
      this.h(null);
      this.i(null);
   }

   public Account i() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: getfield com/jibo/db/EntityData.d Lcom/jibo/aws/integration/aws/services/account/model/Account;
      // 06: astore 2
      // 07: aload 2
      // 08: astore 1
      // 09: aload 2
      // 0a: ifnonnull 87
      // 0d: aload 0
      // 0e: monitorenter
      // 0f: aload 0
      // 10: getfield com/jibo/db/EntityData.d Lcom/jibo/aws/integration/aws/services/account/model/Account;
      // 13: astore 2
      // 14: aload 2
      // 15: ifnonnull fb
      // 18: getstatic com/jibo/db/EntityData.c Landroid/content/Context;
      // 1b: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 1e: bipush 1
      // 1f: invokestatic com/jibo/db/DatabaseContract$EntityEntry.a (I)Landroid/net/Uri;
      // 22: aconst_null
      // 23: aconst_null
      // 24: aconst_null
      // 25: aconst_null
      // 26: invokevirtual android/content/ContentResolver.query (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      // 29: astore 1
      // 2a: aload 1
      // 2b: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 30: ifeq f8
      // 33: getstatic com/jibo/db/EntityData.l Lcom/google/gson/Gson;
      // 36: aload 1
      // 37: aload 1
      // 38: ldc "data"
      // 3a: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
      // 3f: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 44: ldc com/jibo/aws/integration/aws/services/account/model/Account
      // 46: invokevirtual com/google/gson/Gson.a (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
      // 49: checkcast com/jibo/aws/integration/aws/services/account/model/Account
      // 4c: astore 3
      // 4d: aload 3
      // 4e: aload 1
      // 4f: aload 1
      // 50: ldc "modified"
      // 52: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
      // 57: invokeinterface android/database/Cursor.getLong (I)J 2
      // 5c: invokevirtual com/jibo/aws/integration/aws/services/account/model/Account.setModified (J)V
      // 5f: aload 3
      // 60: aload 1
      // 61: aload 1
      // 62: ldc_w "retrieved"
      // 65: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
      // 6a: invokeinterface android/database/Cursor.getLong (I)J 2
      // 6f: invokevirtual com/jibo/aws/integration/aws/services/account/model/Account.setRetrieved (J)V
      // 72: aload 3
      // 73: astore 2
      // 74: aload 0
      // 75: aload 2
      // 76: putfield com/jibo/db/EntityData.d Lcom/jibo/aws/integration/aws/services/account/model/Account;
      // 79: aload 1
      // 7a: ifnull f3
      // 7d: aload 1
      // 7e: invokeinterface android/database/Cursor.close ()V 1
      // 83: aload 2
      // 84: astore 1
      // 85: aload 0
      // 86: monitorexit
      // 87: aload 0
      // 88: monitorexit
      // 89: aload 1
      // 8a: areturn
      // 8b: astore 3
      // 8c: aconst_null
      // 8d: astore 4
      // 8f: aload 2
      // 90: astore 1
      // 91: aload 4
      // 93: astore 2
      // 94: aload 3
      // 95: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // 98: aload 2
      // 99: ifnull f0
      // 9c: aload 2
      // 9d: invokeinterface android/database/Cursor.close ()V 1
      // a2: goto 85
      // a5: astore 2
      // a6: aconst_null
      // a7: astore 1
      // a8: aload 1
      // a9: ifnull b2
      // ac: aload 1
      // ad: invokeinterface android/database/Cursor.close ()V 1
      // b2: aload 2
      // b3: athrow
      // b4: astore 1
      // b5: aload 0
      // b6: monitorexit
      // b7: aload 1
      // b8: athrow
      // b9: astore 1
      // ba: aload 0
      // bb: monitorexit
      // bc: aload 1
      // bd: athrow
      // be: astore 2
      // bf: goto a8
      // c2: astore 1
      // c3: aload 2
      // c4: astore 3
      // c5: aload 1
      // c6: astore 2
      // c7: aload 3
      // c8: astore 1
      // c9: goto a8
      // cc: astore 3
      // cd: aload 2
      // ce: astore 4
      // d0: aload 1
      // d1: astore 2
      // d2: aload 4
      // d4: astore 1
      // d5: goto 94
      // d8: astore 4
      // da: aload 1
      // db: astore 2
      // dc: aload 3
      // dd: astore 1
      // de: aload 4
      // e0: astore 3
      // e1: goto 94
      // e4: astore 3
      // e5: aload 2
      // e6: astore 4
      // e8: aload 1
      // e9: astore 2
      // ea: aload 4
      // ec: astore 1
      // ed: goto 94
      // f0: goto 85
      // f3: aload 2
      // f4: astore 1
      // f5: goto 85
      // f8: goto 74
      // fb: aload 2
      // fc: astore 1
      // fd: goto 85
      // try (2 -> 5): 98 null
      // try (9 -> 11): 98 null
      // try (11 -> 14): 93 null
      // try (16 -> 26): 70 java/lang/Exception
      // try (16 -> 26): 84 null
      // try (26 -> 39): 113 java/lang/Exception
      // try (26 -> 39): 103 null
      // try (39 -> 53): 121 java/lang/Exception
      // try (39 -> 53): 103 null
      // try (55 -> 58): 129 java/lang/Exception
      // try (55 -> 58): 103 null
      // try (60 -> 62): 93 null
      // try (64 -> 66): 93 null
      // try (77 -> 79): 105 null
      // try (81 -> 83): 93 null
      // try (89 -> 91): 93 null
      // try (91 -> 93): 93 null
      // try (94 -> 96): 93 null
      // try (96 -> 98): 98 null
   }

   public void j() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: getstatic com/jibo/db/EntityData.c Landroid/content/Context;
      // 003: invokestatic com/jibo/db/DatabaseHelper.a (Landroid/content/Context;)Lcom/jibo/db/DatabaseHelper;
      // 006: invokevirtual com/jibo/db/DatabaseHelper.getWritableDatabase ()Landroid/database/sqlite/SQLiteDatabase;
      // 009: astore 8
      // 00b: new com/jibo/db/SelectionBuilder
      // 00e: astore 5
      // 010: aload 5
      // 012: invokespecial com/jibo/db/SelectionBuilder.<init> ()V
      // 015: aload 8
      // 017: invokevirtual android/database/sqlite/SQLiteDatabase.beginTransaction ()V
      // 01a: aload 5
      // 01c: ldc "media"
      // 01e: invokevirtual com/jibo/db/SelectionBuilder.a (Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;
      // 021: ldc_w "accountId IS NULL"
      // 024: bipush 0
      // 025: anewarray 127
      // 028: invokevirtual com/jibo/db/SelectionBuilder.b (Ljava/lang/String;[Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;
      // 02b: ldc_w "accountId = ''"
      // 02e: bipush 0
      // 02f: anewarray 127
      // 032: invokevirtual com/jibo/db/SelectionBuilder.b (Ljava/lang/String;[Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;
      // 035: ldc_w "loopId IS NULL"
      // 038: bipush 0
      // 039: anewarray 127
      // 03c: invokevirtual com/jibo/db/SelectionBuilder.b (Ljava/lang/String;[Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;
      // 03f: ldc_w "loopId = ''"
      // 042: bipush 0
      // 043: anewarray 127
      // 046: invokevirtual com/jibo/db/SelectionBuilder.b (Ljava/lang/String;[Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;
      // 049: pop
      // 04a: aload 5
      // 04c: aload 8
      // 04e: invokevirtual com/jibo/db/SelectionBuilder.a (Landroid/database/sqlite/SQLiteDatabase;)I
      // 051: istore 2
      // 052: new com/jibo/db/SelectionBuilder
      // 055: astore 5
      // 057: aload 5
      // 059: invokespecial com/jibo/db/SelectionBuilder.<init> ()V
      // 05c: aload 5
      // 05e: ldc "media"
      // 060: invokevirtual com/jibo/db/SelectionBuilder.a (Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;
      // 063: ldc_w "type = ?"
      // 066: bipush 1
      // 067: anewarray 127
      // 06a: dup
      // 06b: bipush 0
      // 06c: ldc_w "thumb_robot"
      // 06f: aastore
      // 070: invokevirtual com/jibo/db/SelectionBuilder.a (Ljava/lang/String;[Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;
      // 073: pop
      // 074: aload 5
      // 076: aload 8
      // 078: invokevirtual com/jibo/db/SelectionBuilder.a (Landroid/database/sqlite/SQLiteDatabase;)I
      // 07b: pop
      // 07c: new com/jibo/db/SelectionBuilder
      // 07f: astore 5
      // 081: aload 5
      // 083: invokespecial com/jibo/db/SelectionBuilder.<init> ()V
      // 086: aload 5
      // 088: ldc "media"
      // 08a: invokevirtual com/jibo/db/SelectionBuilder.a (Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;
      // 08d: ldc_w "type = ?"
      // 090: bipush 1
      // 091: anewarray 127
      // 094: dup
      // 095: bipush 0
      // 096: ldc_w "image"
      // 099: aastore
      // 09a: invokevirtual com/jibo/db/SelectionBuilder.c (Ljava/lang/String;[Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;
      // 09d: ldc_w "_id NOT IN (SELECT reference FROM media WHERE type = ?)"
      // 0a0: bipush 1
      // 0a1: anewarray 127
      // 0a4: dup
      // 0a5: bipush 0
      // 0a6: ldc_w "thumb"
      // 0a9: aastore
      // 0aa: invokevirtual com/jibo/db/SelectionBuilder.c (Ljava/lang/String;[Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;
      // 0ad: pop
      // 0ae: aload 5
      // 0b0: aload 8
      // 0b2: invokevirtual com/jibo/db/SelectionBuilder.a (Landroid/database/sqlite/SQLiteDatabase;)I
      // 0b5: istore 3
      // 0b6: new com/jibo/db/SelectionBuilder
      // 0b9: astore 5
      // 0bb: aload 5
      // 0bd: invokespecial com/jibo/db/SelectionBuilder.<init> ()V
      // 0c0: aload 5
      // 0c2: ldc "media"
      // 0c4: invokevirtual com/jibo/db/SelectionBuilder.a (Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;
      // 0c7: ldc_w "type = ?"
      // 0ca: bipush 1
      // 0cb: anewarray 127
      // 0ce: dup
      // 0cf: bipush 0
      // 0d0: ldc_w "thumb"
      // 0d3: aastore
      // 0d4: invokevirtual com/jibo/db/SelectionBuilder.c (Ljava/lang/String;[Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;
      // 0d7: ldc_w "(reference IS NULL OR reference = '')"
      // 0da: bipush 0
      // 0db: anewarray 127
      // 0de: invokevirtual com/jibo/db/SelectionBuilder.c (Ljava/lang/String;[Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;
      // 0e1: pop
      // 0e2: aload 5
      // 0e4: aload 8
      // 0e6: invokevirtual com/jibo/db/SelectionBuilder.a (Landroid/database/sqlite/SQLiteDatabase;)I
      // 0e9: istore 4
      // 0eb: new com/jibo/db/SelectionBuilder
      // 0ee: astore 5
      // 0f0: aload 5
      // 0f2: invokespecial com/jibo/db/SelectionBuilder.<init> ()V
      // 0f5: aload 5
      // 0f7: ldc "media"
      // 0f9: invokevirtual com/jibo/db/SelectionBuilder.a (Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;
      // 0fc: ldc_w "type = ?"
      // 0ff: bipush 1
      // 100: anewarray 127
      // 103: dup
      // 104: bipush 0
      // 105: ldc_w "thumb"
      // 108: aastore
      // 109: invokevirtual com/jibo/db/SelectionBuilder.c (Ljava/lang/String;[Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;
      // 10c: ldc_w "reference NOT IN (SELECT _id FROM media WHERE type = ?)"
      // 10f: bipush 1
      // 110: anewarray 127
      // 113: dup
      // 114: bipush 0
      // 115: ldc_w "image"
      // 118: aastore
      // 119: invokevirtual com/jibo/db/SelectionBuilder.c (Ljava/lang/String;[Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;
      // 11c: pop
      // 11d: aload 5
      // 11f: aload 8
      // 121: invokevirtual com/jibo/db/SelectionBuilder.a (Landroid/database/sqlite/SQLiteDatabase;)I
      // 124: istore 1
      // 125: aload 8
      // 127: invokevirtual android/database/sqlite/SQLiteDatabase.setTransactionSuccessful ()V
      // 12a: iload 2
      // 12b: bipush 0
      // 12c: iadd
      // 12d: iload 3
      // 12e: iadd
      // 12f: iload 4
      // 131: iadd
      // 132: iload 1
      // 133: iadd
      // 134: ifle 144
      // 137: getstatic com/jibo/db/EntityData.c Landroid/content/Context;
      // 13a: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 13d: getstatic com/jibo/db/DatabaseContract$MediaEntry.b Landroid/net/Uri;
      // 140: aconst_null
      // 141: invokevirtual android/content/ContentResolver.notifyChange (Landroid/net/Uri;Landroid/database/ContentObserver;)V
      // 144: aload 8
      // 146: ifnull 14e
      // 149: aload 8
      // 14b: invokevirtual android/database/sqlite/SQLiteDatabase.endTransaction ()V
      // 14e: new java/util/ArrayList
      // 151: astore 9
      // 153: aload 9
      // 155: invokespecial java/util/ArrayList.<init> ()V
      // 158: getstatic com/jibo/db/EntityData.c Landroid/content/Context;
      // 15b: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 15e: bipush 8
      // 160: invokestatic com/jibo/db/DatabaseContract$EntityEntry.a (I)Landroid/net/Uri;
      // 163: bipush 1
      // 164: anewarray 127
      // 167: dup
      // 168: bipush 0
      // 169: ldc "_id"
      // 16b: aastore
      // 16c: aconst_null
      // 16d: aconst_null
      // 16e: aconst_null
      // 16f: invokevirtual android/content/ContentResolver.query (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      // 172: astore 6
      // 174: aload 6
      // 176: ifnull 2e2
      // 179: aload 6
      // 17b: astore 5
      // 17d: aload 6
      // 17f: invokeinterface android/database/Cursor.isClosed ()Z 1
      // 184: ifne 2e2
      // 187: aload 6
      // 189: astore 5
      // 18b: aload 6
      // 18d: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 192: ifeq 2e2
      // 195: aload 6
      // 197: astore 5
      // 199: aload 6
      // 19b: invokeinterface android/database/Cursor.isAfterLast ()Z 1
      // 1a0: ifne 2e2
      // 1a3: aload 6
      // 1a5: astore 5
      // 1a7: aload 9
      // 1a9: aload 6
      // 1ab: bipush 0
      // 1ac: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 1b1: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 1b6: pop
      // 1b7: aload 6
      // 1b9: astore 5
      // 1bb: aload 6
      // 1bd: invokeinterface android/database/Cursor.moveToNext ()Z 1
      // 1c2: pop
      // 1c3: goto 195
      // 1c6: astore 7
      // 1c8: aload 6
      // 1ca: astore 5
      // 1cc: aload 7
      // 1ce: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // 1d1: aload 6
      // 1d3: ifnull 1dd
      // 1d6: aload 6
      // 1d8: invokeinterface android/database/Cursor.close ()V 1
      // 1dd: aload 9
      // 1df: invokeinterface java/util/List.size ()I 1
      // 1e4: ifle 29d
      // 1e7: new java/lang/StringBuilder
      // 1ea: astore 5
      // 1ec: aload 5
      // 1ee: ldc_w "loopId"
      // 1f1: invokespecial java/lang/StringBuilder.<init> (Ljava/lang/String;)V
      // 1f4: aload 5
      // 1f6: ldc_w " NOT IN ("
      // 1f9: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1fc: astore 5
      // 1fe: aload 5
      // 200: ldc "'"
      // 202: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 205: ldc "','"
      // 207: aload 9
      // 209: invokestatic android/text/TextUtils.join (Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
      // 20c: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 20f: ldc "')"
      // 211: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 214: pop
      // 215: new com/jibo/db/SelectionBuilder
      // 218: astore 6
      // 21a: aload 6
      // 21c: invokespecial com/jibo/db/SelectionBuilder.<init> ()V
      // 21f: aload 8
      // 221: invokevirtual android/database/sqlite/SQLiteDatabase.beginTransaction ()V
      // 224: aload 6
      // 226: ldc_w "jot"
      // 229: invokevirtual com/jibo/db/SelectionBuilder.a (Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;
      // 22c: aload 5
      // 22e: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 231: bipush 0
      // 232: anewarray 127
      // 235: invokevirtual com/jibo/db/SelectionBuilder.a (Ljava/lang/String;[Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;
      // 238: pop
      // 239: aload 6
      // 23b: aload 8
      // 23d: invokevirtual com/jibo/db/SelectionBuilder.a (Landroid/database/sqlite/SQLiteDatabase;)I
      // 240: bipush 0
      // 241: iadd
      // 242: ifle 25f
      // 245: getstatic com/jibo/db/EntityData.c Landroid/content/Context;
      // 248: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 24b: getstatic com/jibo/db/DatabaseContract$JotEntry.a Landroid/net/Uri;
      // 24e: aconst_null
      // 24f: invokevirtual android/content/ContentResolver.notifyChange (Landroid/net/Uri;Landroid/database/ContentObserver;)V
      // 252: getstatic com/jibo/db/EntityData.c Landroid/content/Context;
      // 255: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 258: getstatic com/jibo/db/DatabaseContract.b Landroid/net/Uri;
      // 25b: aconst_null
      // 25c: invokevirtual android/content/ContentResolver.notifyChange (Landroid/net/Uri;Landroid/database/ContentObserver;)V
      // 25f: new com/jibo/db/SelectionBuilder
      // 262: astore 6
      // 264: aload 6
      // 266: invokespecial com/jibo/db/SelectionBuilder.<init> ()V
      // 269: aload 6
      // 26b: ldc "media"
      // 26d: invokevirtual com/jibo/db/SelectionBuilder.a (Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;
      // 270: aload 5
      // 272: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 275: bipush 0
      // 276: anewarray 127
      // 279: invokevirtual com/jibo/db/SelectionBuilder.a (Ljava/lang/String;[Ljava/lang/String;)Lcom/jibo/db/SelectionBuilder;
      // 27c: pop
      // 27d: aload 6
      // 27f: aload 8
      // 281: invokevirtual com/jibo/db/SelectionBuilder.a (Landroid/database/sqlite/SQLiteDatabase;)I
      // 284: istore 1
      // 285: aload 8
      // 287: invokevirtual android/database/sqlite/SQLiteDatabase.setTransactionSuccessful ()V
      // 28a: iload 1
      // 28b: bipush 0
      // 28c: iadd
      // 28d: ifle 29d
      // 290: getstatic com/jibo/db/EntityData.c Landroid/content/Context;
      // 293: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 296: getstatic com/jibo/db/DatabaseContract$MediaEntry.b Landroid/net/Uri;
      // 299: aconst_null
      // 29a: invokevirtual android/content/ContentResolver.notifyChange (Landroid/net/Uri;Landroid/database/ContentObserver;)V
      // 29d: aload 8
      // 29f: ifnull 2af
      // 2a2: aload 8
      // 2a4: invokevirtual android/database/sqlite/SQLiteDatabase.inTransaction ()Z
      // 2a7: ifeq 2af
      // 2aa: aload 8
      // 2ac: invokevirtual android/database/sqlite/SQLiteDatabase.endTransaction ()V
      // 2af: return
      // 2b0: astore 5
      // 2b2: aload 5
      // 2b4: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // 2b7: aload 8
      // 2b9: ifnull 14e
      // 2bc: aload 8
      // 2be: invokevirtual android/database/sqlite/SQLiteDatabase.endTransaction ()V
      // 2c1: goto 14e
      // 2c4: astore 5
      // 2c6: aload 5
      // 2c8: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // 2cb: goto 2af
      // 2ce: astore 5
      // 2d0: aload 5
      // 2d2: athrow
      // 2d3: astore 5
      // 2d5: aload 8
      // 2d7: ifnull 2df
      // 2da: aload 8
      // 2dc: invokevirtual android/database/sqlite/SQLiteDatabase.endTransaction ()V
      // 2df: aload 5
      // 2e1: athrow
      // 2e2: aload 6
      // 2e4: ifnull 1dd
      // 2e7: aload 6
      // 2e9: invokeinterface android/database/Cursor.close ()V 1
      // 2ee: goto 1dd
      // 2f1: astore 5
      // 2f3: aload 5
      // 2f5: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // 2f8: aload 8
      // 2fa: ifnull 2af
      // 2fd: aload 8
      // 2ff: invokevirtual android/database/sqlite/SQLiteDatabase.inTransaction ()Z
      // 302: ifeq 2af
      // 305: aload 8
      // 307: invokevirtual android/database/sqlite/SQLiteDatabase.endTransaction ()V
      // 30a: goto 2af
      // 30d: astore 6
      // 30f: aconst_null
      // 310: astore 5
      // 312: aload 5
      // 314: ifnull 31e
      // 317: aload 5
      // 319: invokeinterface android/database/Cursor.close ()V 1
      // 31e: aload 6
      // 320: athrow
      // 321: astore 5
      // 323: aload 8
      // 325: ifnull 335
      // 328: aload 8
      // 32a: invokevirtual android/database/sqlite/SQLiteDatabase.inTransaction ()Z
      // 32d: ifeq 335
      // 330: aload 8
      // 332: invokevirtual android/database/sqlite/SQLiteDatabase.endTransaction ()V
      // 335: aload 5
      // 337: athrow
      // 338: astore 6
      // 33a: goto 312
      // 33d: astore 7
      // 33f: aconst_null
      // 340: astore 6
      // 342: goto 1c8
      // try (0 -> 4): 311 java/lang/Exception
      // try (0 -> 4): 315 null
      // try (4 -> 136): 303 java/lang/Exception
      // try (4 -> 136): 318 null
      // try (146 -> 151): 303 java/lang/Exception
      // try (146 -> 151): 318 null
      // try (153 -> 155): 311 java/lang/Exception
      // try (153 -> 155): 315 null
      // try (155 -> 159): 330 java/lang/Exception
      // try (155 -> 159): 350 null
      // try (159 -> 174): 362 java/lang/Exception
      // try (159 -> 174): 341 null
      // try (178 -> 181): 205 java/lang/Exception
      // try (178 -> 181): 360 null
      // try (183 -> 186): 205 java/lang/Exception
      // try (183 -> 186): 360 null
      // try (188 -> 191): 205 java/lang/Exception
      // try (188 -> 191): 360 null
      // try (193 -> 199): 205 java/lang/Exception
      // try (193 -> 199): 360 null
      // try (201 -> 204): 205 java/lang/Exception
      // try (201 -> 204): 360 null
      // try (208 -> 210): 360 null
      // try (212 -> 214): 330 java/lang/Exception
      // try (212 -> 214): 350 null
      // try (214 -> 267): 330 java/lang/Exception
      // try (214 -> 267): 350 null
      // try (267 -> 286): 330 java/lang/Exception
      // try (267 -> 286): 350 null
      // try (290 -> 295): 330 java/lang/Exception
      // try (290 -> 295): 350 null
      // try (297 -> 302): 311 java/lang/Exception
      // try (297 -> 302): 315 null
      // try (304 -> 306): 318 null
      // try (308 -> 310): 311 java/lang/Exception
      // try (308 -> 310): 315 null
      // try (312 -> 314): 315 null
      // try (321 -> 323): 311 java/lang/Exception
      // try (321 -> 323): 315 null
      // try (323 -> 325): 311 java/lang/Exception
      // try (323 -> 325): 315 null
      // try (327 -> 329): 330 java/lang/Exception
      // try (327 -> 329): 350 null
      // try (331 -> 333): 350 null
      // try (335 -> 340): 311 java/lang/Exception
      // try (335 -> 340): 315 null
      // try (346 -> 348): 330 java/lang/Exception
      // try (346 -> 348): 350 null
      // try (348 -> 350): 330 java/lang/Exception
      // try (348 -> 350): 350 null
      // try (353 -> 358): 311 java/lang/Exception
      // try (353 -> 358): 315 null
      // try (358 -> 360): 311 java/lang/Exception
      // try (358 -> 360): 315 null
   }
}
