package com.salesforce.androidsdk.smartstore.store;

import android.content.ContentValues;
import com.salesforce.androidsdk.smartstore.util.SmartStoreLogger;
import java.util.ArrayList;
import java.util.HashSet;
import net.sqlcipher.database.SQLiteDatabase;
import org.json.JSONException;
import org.json.JSONObject;

public class AlterSoupLongOperation extends LongOperation {
   protected String a;
   private String b;
   private AlterSoupLongOperation.AlterSoupStep c;
   private SoupSpec d;
   private SoupSpec e;
   private IndexSpec[] f;
   private IndexSpec[] g;
   private boolean h;
   private SmartStore i;
   private SQLiteDatabase j;
   private long k;

   private void c(AlterSoupLongOperation.AlterSoupStep var1) {
      switch (<unrepresentable>.a[this.c.ordinal()]) {
         case 1:
            this.b();
            if (var1 == AlterSoupLongOperation.AlterSoupStep.RENAME_OLD_SOUP_TABLE) {
               break;
            }
         case 2:
            this.c();
            if (var1 == AlterSoupLongOperation.AlterSoupStep.DROP_OLD_INDEXES) {
               break;
            }
         case 3:
            this.d();
            if (var1 == AlterSoupLongOperation.AlterSoupStep.REGISTER_SOUP_USING_TABLE_NAME) {
               break;
            }
         case 4:
            this.e();
            if (var1 == AlterSoupLongOperation.AlterSoupStep.COPY_TABLE) {
               break;
            }
         case 5:
            if (this.h) {
               this.f();
            }

            if (var1 == AlterSoupLongOperation.AlterSoupStep.RE_INDEX_SOUP) {
               break;
            }
         case 6:
            this.g();
            if (var1 == AlterSoupLongOperation.AlterSoupStep.DROP_OLD_TABLE) {
            }
      }
   }

   private void h() {
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
      // 000: aconst_null
      // 001: astore 7
      // 003: aload 0
      // 004: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.g [Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;
      // 007: invokestatic com/salesforce/androidsdk/smartstore/store/IndexSpec.a ([Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;)Ljava/util/Map;
      // 00a: astore 9
      // 00c: aload 0
      // 00d: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.f [Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;
      // 010: invokestatic com/salesforce/androidsdk/smartstore/store/IndexSpec.a ([Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;)Ljava/util/Map;
      // 013: astore 8
      // 015: aload 9
      // 017: invokeinterface java/util/Map.keySet ()Ljava/util/Set; 1
      // 01c: astore 6
      // 01e: aload 8
      // 020: invokeinterface java/util/Map.keySet ()Ljava/util/Set; 1
      // 025: astore 10
      // 027: aload 10
      // 029: aload 6
      // 02b: invokeinterface java/util/Set.retainAll (Ljava/util/Collection;)Z 2
      // 030: pop
      // 031: new java/util/ArrayList
      // 034: dup
      // 035: invokespecial java/util/ArrayList.<init> ()V
      // 038: astore 12
      // 03a: new java/util/ArrayList
      // 03d: dup
      // 03e: invokespecial java/util/ArrayList.<init> ()V
      // 041: astore 11
      // 043: aload 0
      // 044: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.d Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;
      // 047: invokevirtual com/salesforce/androidsdk/smartstore/store/SoupSpec.b ()Ljava/util/List;
      // 04a: ldc "externalStorage"
      // 04c: invokeinterface java/util/List.contains (Ljava/lang/Object;)Z 2
      // 051: ifne 065
      // 054: aload 0
      // 055: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.e Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;
      // 058: invokevirtual com/salesforce/androidsdk/smartstore/store/SoupSpec.b ()Ljava/util/List;
      // 05b: ldc "externalStorage"
      // 05d: invokeinterface java/util/List.contains (Ljava/lang/Object;)Z 2
      // 062: ifeq 0a8
      // 065: bipush 3
      // 066: anewarray 118
      // 069: astore 6
      // 06b: aload 6
      // 06d: bipush 0
      // 06e: ldc "id"
      // 070: aastore
      // 071: aload 6
      // 073: bipush 1
      // 074: ldc "created"
      // 076: aastore
      // 077: aload 6
      // 079: bipush 2
      // 07a: ldc "lastModified"
      // 07c: aastore
      // 07d: aload 6
      // 07f: arraylength
      // 080: istore 2
      // 081: bipush 0
      // 082: istore 1
      // 083: iload 1
      // 084: iload 2
      // 085: if_icmpge 0c9
      // 088: aload 6
      // 08a: iload 1
      // 08b: aaload
      // 08c: astore 13
      // 08e: aload 12
      // 090: aload 13
      // 092: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 097: pop
      // 098: aload 11
      // 09a: aload 13
      // 09c: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 0a1: pop
      // 0a2: iinc 1 1
      // 0a5: goto 083
      // 0a8: bipush 4
      // 0a9: anewarray 118
      // 0ac: astore 6
      // 0ae: aload 6
      // 0b0: bipush 0
      // 0b1: ldc "id"
      // 0b3: aastore
      // 0b4: aload 6
      // 0b6: bipush 1
      // 0b7: ldc "soup"
      // 0b9: aastore
      // 0ba: aload 6
      // 0bc: bipush 2
      // 0bd: ldc "created"
      // 0bf: aastore
      // 0c0: aload 6
      // 0c2: bipush 3
      // 0c3: ldc "lastModified"
      // 0c5: aastore
      // 0c6: goto 07d
      // 0c9: aload 10
      // 0cb: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 0d0: astore 6
      // 0d2: aload 6
      // 0d4: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0d9: ifeq 14d
      // 0dc: aload 6
      // 0de: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0e3: checkcast java/lang/String
      // 0e6: astore 14
      // 0e8: aload 9
      // 0ea: aload 14
      // 0ec: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 0f1: checkcast com/salesforce/androidsdk/smartstore/store/IndexSpec
      // 0f4: astore 13
      // 0f6: aload 8
      // 0f8: aload 14
      // 0fa: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 0ff: checkcast com/salesforce/androidsdk/smartstore/store/IndexSpec
      // 102: astore 14
      // 104: aload 14
      // 106: getfield com/salesforce/androidsdk/smartstore/store/IndexSpec.b Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;
      // 109: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore$Type.getColumnType ()Ljava/lang/String;
      // 10c: ifnull 0d2
      // 10f: aload 13
      // 111: getfield com/salesforce/androidsdk/smartstore/store/IndexSpec.b Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;
      // 114: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore$Type.getColumnType ()Ljava/lang/String;
      // 117: ifnull 130
      // 11a: aload 13
      // 11c: getfield com/salesforce/androidsdk/smartstore/store/IndexSpec.b Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;
      // 11f: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore$Type.getColumnType ()Ljava/lang/String;
      // 122: aload 14
      // 124: getfield com/salesforce/androidsdk/smartstore/store/IndexSpec.b Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;
      // 127: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore$Type.getColumnType ()Ljava/lang/String;
      // 12a: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 12d: ifeq 0d2
      // 130: aload 12
      // 132: aload 13
      // 134: getfield com/salesforce/androidsdk/smartstore/store/IndexSpec.c Ljava/lang/String;
      // 137: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 13c: pop
      // 13d: aload 11
      // 13f: aload 14
      // 141: getfield com/salesforce/androidsdk/smartstore/store/IndexSpec.c Ljava/lang/String;
      // 144: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 149: pop
      // 14a: goto 0d2
      // 14d: ldc "INSERT INTO %s (%s) SELECT %s FROM %s"
      // 14f: bipush 4
      // 150: anewarray 165
      // 153: dup
      // 154: bipush 0
      // 155: aload 0
      // 156: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.b Ljava/lang/String;
      // 159: aastore
      // 15a: dup
      // 15b: bipush 1
      // 15c: ldc ","
      // 15e: aload 11
      // 160: invokestatic android/text/TextUtils.join (Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
      // 163: aastore
      // 164: dup
      // 165: bipush 2
      // 166: ldc ","
      // 168: aload 12
      // 16a: invokestatic android/text/TextUtils.join (Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
      // 16d: aastore
      // 16e: dup
      // 16f: bipush 3
      // 170: aload 0
      // 171: invokespecial com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.i ()Ljava/lang/String;
      // 174: aastore
      // 175: invokestatic java/lang/String.format (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      // 178: astore 6
      // 17a: aload 0
      // 17b: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.j Lnet/sqlcipher/database/SQLiteDatabase;
      // 17e: aload 6
      // 180: invokevirtual net/sqlcipher/database/SQLiteDatabase.execSQL (Ljava/lang/String;)V
      // 183: aload 0
      // 184: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.f [Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;
      // 187: invokestatic com/salesforce/androidsdk/smartstore/store/IndexSpec.b ([Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;)Z
      // 18a: ifeq 272
      // 18d: new java/util/ArrayList
      // 190: dup
      // 191: invokespecial java/util/ArrayList.<init> ()V
      // 194: astore 11
      // 196: new java/util/ArrayList
      // 199: dup
      // 19a: invokespecial java/util/ArrayList.<init> ()V
      // 19d: astore 6
      // 19f: aload 11
      // 1a1: ldc "id"
      // 1a3: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 1a8: pop
      // 1a9: aload 6
      // 1ab: ldc "rowid"
      // 1ad: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 1b2: pop
      // 1b3: aload 10
      // 1b5: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 1ba: astore 12
      // 1bc: aload 12
      // 1be: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 1c3: ifeq 237
      // 1c6: aload 12
      // 1c8: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 1cd: checkcast java/lang/String
      // 1d0: astore 13
      // 1d2: aload 9
      // 1d4: aload 13
      // 1d6: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 1db: checkcast com/salesforce/androidsdk/smartstore/store/IndexSpec
      // 1de: astore 10
      // 1e0: aload 8
      // 1e2: aload 13
      // 1e4: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 1e9: checkcast com/salesforce/androidsdk/smartstore/store/IndexSpec
      // 1ec: astore 13
      // 1ee: aload 10
      // 1f0: getfield com/salesforce/androidsdk/smartstore/store/IndexSpec.b Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;
      // 1f3: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore$Type.getColumnType ()Ljava/lang/String;
      // 1f6: ifnull 20f
      // 1f9: aload 10
      // 1fb: getfield com/salesforce/androidsdk/smartstore/store/IndexSpec.b Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;
      // 1fe: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore$Type.getColumnType ()Ljava/lang/String;
      // 201: aload 13
      // 203: getfield com/salesforce/androidsdk/smartstore/store/IndexSpec.b Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;
      // 206: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore$Type.getColumnType ()Ljava/lang/String;
      // 209: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 20c: ifeq 1bc
      // 20f: aload 13
      // 211: getfield com/salesforce/androidsdk/smartstore/store/IndexSpec.b Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;
      // 214: getstatic com/salesforce/androidsdk/smartstore/store/SmartStore$Type.full_text Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;
      // 217: if_acmpne 1bc
      // 21a: aload 11
      // 21c: aload 10
      // 21e: getfield com/salesforce/androidsdk/smartstore/store/IndexSpec.c Ljava/lang/String;
      // 221: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 226: pop
      // 227: aload 6
      // 229: aload 13
      // 22b: getfield com/salesforce/androidsdk/smartstore/store/IndexSpec.c Ljava/lang/String;
      // 22e: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 233: pop
      // 234: goto 1bc
      // 237: ldc "INSERT INTO %s%s (%s) SELECT %s FROM %s"
      // 239: bipush 5
      // 23a: anewarray 165
      // 23d: dup
      // 23e: bipush 0
      // 23f: aload 0
      // 240: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.b Ljava/lang/String;
      // 243: aastore
      // 244: dup
      // 245: bipush 1
      // 246: ldc "_fts"
      // 248: aastore
      // 249: dup
      // 24a: bipush 2
      // 24b: ldc ","
      // 24d: aload 6
      // 24f: invokestatic android/text/TextUtils.join (Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
      // 252: aastore
      // 253: dup
      // 254: bipush 3
      // 255: ldc ","
      // 257: aload 11
      // 259: invokestatic android/text/TextUtils.join (Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
      // 25c: aastore
      // 25d: dup
      // 25e: bipush 4
      // 25f: aload 0
      // 260: invokespecial com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.i ()Ljava/lang/String;
      // 263: aastore
      // 264: invokestatic java/lang/String.format (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      // 267: astore 6
      // 269: aload 0
      // 26a: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.j Lnet/sqlcipher/database/SQLiteDatabase;
      // 26d: aload 6
      // 26f: invokevirtual net/sqlcipher/database/SQLiteDatabase.execSQL (Ljava/lang/String;)V
      // 272: aload 0
      // 273: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.e Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;
      // 276: invokevirtual com/salesforce/androidsdk/smartstore/store/SoupSpec.b ()Ljava/util/List;
      // 279: ldc "externalStorage"
      // 27b: invokeinterface java/util/List.contains (Ljava/lang/Object;)Z 2
      // 280: ifeq 3ad
      // 283: aload 0
      // 284: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.d Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;
      // 287: invokevirtual com/salesforce/androidsdk/smartstore/store/SoupSpec.b ()Ljava/util/List;
      // 28a: ldc "externalStorage"
      // 28c: invokeinterface java/util/List.contains (Ljava/lang/Object;)Z 2
      // 291: ifne 3ad
      // 294: aload 0
      // 295: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.j Lnet/sqlcipher/database/SQLiteDatabase;
      // 298: aload 0
      // 299: invokespecial com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.i ()Ljava/lang/String;
      // 29c: bipush 1
      // 29d: anewarray 118
      // 2a0: dup
      // 2a1: bipush 0
      // 2a2: ldc "id"
      // 2a4: aastore
      // 2a5: aconst_null
      // 2a6: aconst_null
      // 2a7: aconst_null
      // 2a8: aconst_null
      // 2a9: aconst_null
      // 2aa: invokevirtual net/sqlcipher/database/SQLiteDatabase.query (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lnet/sqlcipher/Cursor;
      // 2ad: astore 6
      // 2af: aload 6
      // 2b1: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 2b6: ifeq 38c
      // 2b9: aload 6
      // 2bb: invokeinterface android/database/Cursor.getCount ()I 1
      // 2c0: anewarray 215
      // 2c3: astore 7
      // 2c5: bipush 0
      // 2c6: istore 1
      // 2c7: aload 7
      // 2c9: iload 1
      // 2ca: aload 6
      // 2cc: bipush 0
      // 2cd: invokeinterface android/database/Cursor.getLong (I)J 2
      // 2d2: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 2d5: aastore
      // 2d6: aload 6
      // 2d8: invokeinterface android/database/Cursor.moveToNext ()Z 1
      // 2dd: ifne 473
      // 2e0: aload 7
      // 2e2: arraylength
      // 2e3: istore 2
      // 2e4: bipush 0
      // 2e5: istore 1
      // 2e6: iload 1
      // 2e7: iload 2
      // 2e8: if_icmpge 38c
      // 2eb: aload 7
      // 2ed: iload 1
      // 2ee: aaload
      // 2ef: invokevirtual java/lang/Long.longValue ()J
      // 2f2: lstore 4
      // 2f4: aload 0
      // 2f5: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.i Lcom/salesforce/androidsdk/smartstore/store/SmartStore;
      // 2f8: getfield com/salesforce/androidsdk/smartstore/store/SmartStore.b Lnet/sqlcipher/database/SQLiteOpenHelper;
      // 2fb: checkcast com/salesforce/androidsdk/smartstore/store/DBOpenHelper
      // 2fe: aload 0
      // 2ff: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.b Ljava/lang/String;
      // 302: lload 4
      // 304: aload 0
      // 305: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.i Lcom/salesforce/androidsdk/smartstore/store/SmartStore;
      // 308: getfield com/salesforce/androidsdk/smartstore/store/SmartStore.c Ljava/lang/String;
      // 30b: invokevirtual com/salesforce/androidsdk/smartstore/store/DBOpenHelper.b (Ljava/lang/String;JLjava/lang/String;)Ljava/lang/String;
      // 30e: astore 9
      // 310: new android/content/ContentValues
      // 313: astore 8
      // 315: aload 8
      // 317: invokespecial android/content/ContentValues.<init> ()V
      // 31a: aload 8
      // 31c: ldc "soup"
      // 31e: aload 9
      // 320: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/String;)V
      // 323: aload 0
      // 324: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.j Lnet/sqlcipher/database/SQLiteDatabase;
      // 327: invokestatic com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;
      // 32a: astore 10
      // 32c: aload 0
      // 32d: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.j Lnet/sqlcipher/database/SQLiteDatabase;
      // 330: astore 9
      // 332: aload 0
      // 333: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.b Ljava/lang/String;
      // 336: astore 11
      // 338: new java/lang/StringBuilder
      // 33b: astore 12
      // 33d: aload 12
      // 33f: invokespecial java/lang/StringBuilder.<init> ()V
      // 342: aload 10
      // 344: aload 9
      // 346: aload 11
      // 348: aload 8
      // 34a: ldc_w "id = ?"
      // 34d: bipush 1
      // 34e: anewarray 118
      // 351: dup
      // 352: bipush 0
      // 353: aload 12
      // 355: lload 4
      // 357: invokevirtual java/lang/StringBuilder.append (J)Ljava/lang/StringBuilder;
      // 35a: ldc_w ""
      // 35d: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 360: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 363: aastore
      // 364: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
      // 367: pop
      // 368: aload 0
      // 369: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.i Lcom/salesforce/androidsdk/smartstore/store/SmartStore;
      // 36c: getfield com/salesforce/androidsdk/smartstore/store/SmartStore.b Lnet/sqlcipher/database/SQLiteOpenHelper;
      // 36f: checkcast com/salesforce/androidsdk/smartstore/store/DBOpenHelper
      // 372: aload 0
      // 373: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.b Ljava/lang/String;
      // 376: bipush 1
      // 377: anewarray 215
      // 37a: dup
      // 37b: bipush 0
      // 37c: lload 4
      // 37e: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 381: aastore
      // 382: invokevirtual com/salesforce/androidsdk/smartstore/store/DBOpenHelper.a (Ljava/lang/String;[Ljava/lang/Long;)Z
      // 385: pop
      // 386: iinc 1 1
      // 389: goto 2e6
      // 38c: aload 6
      // 38e: ifnull 398
      // 391: aload 6
      // 393: invokeinterface android/database/Cursor.close ()V 1
      // 398: return
      // 399: astore 7
      // 39b: aconst_null
      // 39c: astore 6
      // 39e: aload 6
      // 3a0: ifnull 3aa
      // 3a3: aload 6
      // 3a5: invokeinterface android/database/Cursor.close ()V 1
      // 3aa: aload 7
      // 3ac: athrow
      // 3ad: aload 0
      // 3ae: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.e Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;
      // 3b1: invokevirtual com/salesforce/androidsdk/smartstore/store/SoupSpec.b ()Ljava/util/List;
      // 3b4: ldc "externalStorage"
      // 3b6: invokeinterface java/util/List.contains (Ljava/lang/Object;)Z 2
      // 3bb: ifne 398
      // 3be: aload 0
      // 3bf: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.d Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;
      // 3c2: invokevirtual com/salesforce/androidsdk/smartstore/store/SoupSpec.b ()Ljava/util/List;
      // 3c5: ldc "externalStorage"
      // 3c7: invokeinterface java/util/List.contains (Ljava/lang/Object;)Z 2
      // 3cc: ifeq 398
      // 3cf: aload 7
      // 3d1: astore 6
      // 3d3: aload 0
      // 3d4: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.j Lnet/sqlcipher/database/SQLiteDatabase;
      // 3d7: aload 0
      // 3d8: invokespecial com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.i ()Ljava/lang/String;
      // 3db: bipush 2
      // 3dc: anewarray 118
      // 3df: dup
      // 3e0: bipush 0
      // 3e1: ldc "id"
      // 3e3: aastore
      // 3e4: dup
      // 3e5: bipush 1
      // 3e6: ldc "soup"
      // 3e8: aastore
      // 3e9: aconst_null
      // 3ea: aconst_null
      // 3eb: aconst_null
      // 3ec: aconst_null
      // 3ed: aconst_null
      // 3ee: invokevirtual net/sqlcipher/database/SQLiteDatabase.query (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lnet/sqlcipher/Cursor;
      // 3f1: astore 7
      // 3f3: aload 7
      // 3f5: astore 6
      // 3f7: aload 7
      // 3f9: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 3fe: ifeq 44e
      // 401: aload 7
      // 403: astore 6
      // 405: aload 7
      // 407: bipush 0
      // 408: invokeinterface android/database/Cursor.getLong (I)J 2
      // 40d: lstore 4
      // 40f: aload 7
      // 411: astore 6
      // 413: aload 7
      // 415: bipush 1
      // 416: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 41b: astore 8
      // 41d: aload 7
      // 41f: astore 6
      // 421: aload 0
      // 422: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.i Lcom/salesforce/androidsdk/smartstore/store/SmartStore;
      // 425: getfield com/salesforce/androidsdk/smartstore/store/SmartStore.b Lnet/sqlcipher/database/SQLiteOpenHelper;
      // 428: checkcast com/salesforce/androidsdk/smartstore/store/DBOpenHelper
      // 42b: aload 0
      // 42c: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.b Ljava/lang/String;
      // 42f: lload 4
      // 431: aload 8
      // 433: aload 0
      // 434: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.i Lcom/salesforce/androidsdk/smartstore/store/SmartStore;
      // 437: getfield com/salesforce/androidsdk/smartstore/store/SmartStore.c Ljava/lang/String;
      // 43a: invokevirtual com/salesforce/androidsdk/smartstore/store/DBOpenHelper.a (Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)Z
      // 43d: pop
      // 43e: aload 7
      // 440: astore 6
      // 442: aload 7
      // 444: invokeinterface android/database/Cursor.moveToNext ()Z 1
      // 449: istore 3
      // 44a: iload 3
      // 44b: ifne 401
      // 44e: aload 7
      // 450: ifnull 398
      // 453: aload 7
      // 455: invokeinterface android/database/Cursor.close ()V 1
      // 45a: goto 398
      // 45d: astore 7
      // 45f: aload 6
      // 461: ifnull 46b
      // 464: aload 6
      // 466: invokeinterface android/database/Cursor.close ()V 1
      // 46b: aload 7
      // 46d: athrow
      // 46e: astore 7
      // 470: goto 39e
      // 473: iinc 1 1
      // 476: goto 2c7
      // try (289 -> 306): 412 null
      // try (306 -> 313): 507 null
      // try (315 -> 328): 507 null
      // try (333 -> 405): 507 null
      // try (435 -> 456): 500 null
      // try (458 -> 461): 500 null
      // try (463 -> 467): 500 null
      // try (469 -> 473): 500 null
      // try (475 -> 488): 500 null
      // try (490 -> 493): 500 null
   }

   private String i() {
      return this.b + "_old";
   }

   @Override
   public void a() {
      this.a(AlterSoupLongOperation.AlterSoupStep.LAST);
   }

   public void a(AlterSoupLongOperation.AlterSoupStep var1) {
      this.c(var1);
   }

   @Override
   protected void a(SmartStore var1, long var2, JSONObject var4, String var5) throws JSONException {
      this.i = var1;
      this.j = var1.a();
      this.k = var2;
      this.c = AlterSoupLongOperation.AlterSoupStep.valueOf(var5);
      this.a = var4.getString("soupName");
      this.d = SoupSpec.a(var4.optJSONObject("newSoupFeatures"));
      this.e = SoupSpec.a(var4.optJSONObject("oldSoupFeatures"));
      this.f = IndexSpec.a(var4.getJSONArray("newIndexSpecs"));
      this.g = IndexSpec.a(var4.getJSONArray("oldIndexSpecs"));
      this.h = var4.getBoolean("reIndexData");
      this.b = var4.getString("soupTableName");
   }

   protected void b() {
      try {
         this.j.beginTransaction();
         SQLiteDatabase var2 = this.j;
         StringBuilder var1 = new StringBuilder();
         var2.execSQL(var1.append("ALTER TABLE ").append(this.b).append(" RENAME TO ").append(this.i()).toString());
         if (IndexSpec.b(this.g)) {
            SQLiteDatabase var5 = this.j;
            StringBuilder var6 = new StringBuilder();
            var5.execSQL(var6.append("ALTER TABLE ").append(this.b).append("_fts").append(" RENAME TO ").append(this.i()).append("_fts").toString());
         }

         this.b(AlterSoupLongOperation.AlterSoupStep.RENAME_OLD_SOUP_TABLE);
         this.j.setTransactionSuccessful();
      } finally {
         this.j.endTransaction();
      }
   }

   protected void b(AlterSoupLongOperation.AlterSoupStep var1) {
      if (var1 == AlterSoupLongOperation.AlterSoupStep.LAST) {
         DBHelper.a(this.j).b(this.j, "long_operations_status", "id = ?", this.k + "");
      } else {
         long var2 = System.currentTimeMillis();
         ContentValues var4 = new ContentValues();
         var4.put("status", var1.toString());
         var4.put("lastModified", var2);
         DBHelper.a(this.j).a(this.j, "long_operations_status", var4, "id = ?", this.k + "");
      }

      SmartStoreLogger.b("AlterSoup:Status", this.a + " " + var1);
   }

   protected void c() {
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
      // 00: bipush 0
      // 01: istore 3
      // 02: aload 0
      // 03: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.j Lnet/sqlcipher/database/SQLiteDatabase;
      // 06: invokevirtual net/sqlcipher/database/SQLiteDatabase.beginTransaction ()V
      // 09: bipush 2
      // 0a: anewarray 118
      // 0d: astore 5
      // 0f: aload 5
      // 11: bipush 0
      // 12: ldc "created"
      // 14: aastore
      // 15: aload 5
      // 17: bipush 1
      // 18: ldc "lastModified"
      // 1a: aastore
      // 1b: aload 5
      // 1d: arraylength
      // 1e: istore 4
      // 20: bipush 0
      // 21: istore 2
      // 22: iload 3
      // 23: istore 1
      // 24: iload 2
      // 25: iload 4
      // 27: if_icmpge 53
      // 2a: aload 5
      // 2c: iload 2
      // 2d: aaload
      // 2e: astore 6
      // 30: aload 0
      // 31: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.j Lnet/sqlcipher/database/SQLiteDatabase;
      // 34: ldc_w "DROP INDEX IF EXISTS %s_%s_idx"
      // 37: bipush 2
      // 38: anewarray 165
      // 3b: dup
      // 3c: bipush 0
      // 3d: aload 0
      // 3e: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.b Ljava/lang/String;
      // 41: aastore
      // 42: dup
      // 43: bipush 1
      // 44: aload 6
      // 46: aastore
      // 47: invokestatic java/lang/String.format (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      // 4a: invokevirtual net/sqlcipher/database/SQLiteDatabase.execSQL (Ljava/lang/String;)V
      // 4d: iinc 2 1
      // 50: goto 22
      // 53: iload 1
      // 54: aload 0
      // 55: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.g [Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;
      // 58: arraylength
      // 59: if_icmpge 9e
      // 5c: aload 0
      // 5d: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.j Lnet/sqlcipher/database/SQLiteDatabase;
      // 60: astore 7
      // 62: aload 0
      // 63: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.b Ljava/lang/String;
      // 66: astore 6
      // 68: new java/lang/StringBuilder
      // 6b: astore 5
      // 6d: aload 5
      // 6f: invokespecial java/lang/StringBuilder.<init> ()V
      // 72: aload 7
      // 74: ldc_w "DROP INDEX IF EXISTS %s_%s_idx"
      // 77: bipush 2
      // 78: anewarray 165
      // 7b: dup
      // 7c: bipush 0
      // 7d: aload 6
      // 7f: aastore
      // 80: dup
      // 81: bipush 1
      // 82: aload 5
      // 84: ldc_w ""
      // 87: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 8a: iload 1
      // 8b: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 8e: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 91: aastore
      // 92: invokestatic java/lang/String.format (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      // 95: invokevirtual net/sqlcipher/database/SQLiteDatabase.execSQL (Ljava/lang/String;)V
      // 98: iinc 1 1
      // 9b: goto 53
      // 9e: aload 0
      // 9f: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.j Lnet/sqlcipher/database/SQLiteDatabase;
      // a2: invokestatic com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;
      // a5: aload 0
      // a6: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.j Lnet/sqlcipher/database/SQLiteDatabase;
      // a9: ldc_w "soup_index_map"
      // ac: ldc_w "soupName = ?"
      // af: bipush 1
      // b0: anewarray 118
      // b3: dup
      // b4: bipush 0
      // b5: aload 0
      // b6: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.a Ljava/lang/String;
      // b9: aastore
      // ba: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.b (Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
      // bd: aload 0
      // be: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.j Lnet/sqlcipher/database/SQLiteDatabase;
      // c1: invokestatic com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;
      // c4: aload 0
      // c5: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.a Ljava/lang/String;
      // c8: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.e (Ljava/lang/String;)V
      // cb: aload 0
      // cc: getstatic com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep.DROP_OLD_INDEXES Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;
      // cf: invokevirtual com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.b (Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;)V
      // d2: aload 0
      // d3: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.j Lnet/sqlcipher/database/SQLiteDatabase;
      // d6: invokevirtual net/sqlcipher/database/SQLiteDatabase.setTransactionSuccessful ()V
      // d9: aload 0
      // da: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.j Lnet/sqlcipher/database/SQLiteDatabase;
      // dd: invokevirtual net/sqlcipher/database/SQLiteDatabase.endTransaction ()V
      // e0: return
      // e1: astore 5
      // e3: aload 0
      // e4: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.j Lnet/sqlcipher/database/SQLiteDatabase;
      // e7: invokevirtual net/sqlcipher/database/SQLiteDatabase.endTransaction ()V
      // ea: aload 5
      // ec: athrow
      // try (2 -> 8): 115 null
      // try (16 -> 19): 115 null
      // try (30 -> 46): 115 null
      // try (48 -> 82): 115 null
      // try (84 -> 111): 115 null
   }

   protected void d() {
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
      // 01: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.j Lnet/sqlcipher/database/SQLiteDatabase;
      // 04: invokevirtual net/sqlcipher/database/SQLiteDatabase.beginTransaction ()V
      // 07: new android/content/ContentValues
      // 0a: astore 6
      // 0c: aload 6
      // 0e: invokespecial android/content/ContentValues.<init> ()V
      // 11: getstatic com/salesforce/androidsdk/smartstore/store/SoupSpec.a [Ljava/lang/String;
      // 14: astore 5
      // 16: aload 5
      // 18: arraylength
      // 19: istore 3
      // 1a: bipush 0
      // 1b: istore 1
      // 1c: iload 1
      // 1d: iload 3
      // 1e: if_icmpge 50
      // 21: aload 5
      // 23: iload 1
      // 24: aaload
      // 25: astore 4
      // 27: aload 0
      // 28: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.d Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;
      // 2b: invokevirtual com/salesforce/androidsdk/smartstore/store/SoupSpec.b ()Ljava/util/List;
      // 2e: aload 4
      // 30: invokeinterface java/util/List.contains (Ljava/lang/Object;)Z 2
      // 35: ifeq 4b
      // 38: bipush 1
      // 39: istore 2
      // 3a: aload 6
      // 3c: aload 4
      // 3e: iload 2
      // 3f: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 42: invokevirtual android/content/ContentValues.put (Ljava/lang/String;Ljava/lang/Integer;)V
      // 45: iinc 1 1
      // 48: goto 1c
      // 4b: bipush 0
      // 4c: istore 2
      // 4d: goto 3a
      // 50: aload 0
      // 51: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.j Lnet/sqlcipher/database/SQLiteDatabase;
      // 54: invokestatic com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;
      // 57: aload 0
      // 58: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.j Lnet/sqlcipher/database/SQLiteDatabase;
      // 5b: ldc_w "soup_attrs"
      // 5e: aload 6
      // 60: ldc_w "soupName = ?"
      // 63: bipush 1
      // 64: anewarray 118
      // 67: dup
      // 68: bipush 0
      // 69: aload 0
      // 6a: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.a Ljava/lang/String;
      // 6d: aastore
      // 6e: invokevirtual com/salesforce/androidsdk/smartstore/store/DBHelper.a (Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
      // 71: pop
      // 72: aload 0
      // 73: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.i Lcom/salesforce/androidsdk/smartstore/store/SmartStore;
      // 76: aload 0
      // 77: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.d Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;
      // 7a: aload 0
      // 7b: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.f [Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;
      // 7e: aload 0
      // 7f: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.b Ljava/lang/String;
      // 82: invokevirtual com/salesforce/androidsdk/smartstore/store/SmartStore.a (Lcom/salesforce/androidsdk/smartstore/store/SoupSpec;[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;Ljava/lang/String;)V
      // 85: aload 0
      // 86: getstatic com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep.REGISTER_SOUP_USING_TABLE_NAME Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;
      // 89: invokevirtual com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.b (Lcom/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation$AlterSoupStep;)V
      // 8c: aload 0
      // 8d: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.j Lnet/sqlcipher/database/SQLiteDatabase;
      // 90: invokevirtual net/sqlcipher/database/SQLiteDatabase.setTransactionSuccessful ()V
      // 93: aload 0
      // 94: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.j Lnet/sqlcipher/database/SQLiteDatabase;
      // 97: invokevirtual net/sqlcipher/database/SQLiteDatabase.endTransaction ()V
      // 9a: return
      // 9b: astore 4
      // 9d: aload 0
      // 9e: getfield com/salesforce/androidsdk/smartstore/store/AlterSoupLongOperation.j Lnet/sqlcipher/database/SQLiteDatabase;
      // a1: invokevirtual net/sqlcipher/database/SQLiteDatabase.endTransaction ()V
      // a4: aload 4
      // a6: athrow
      // try (0 -> 12): 75 null
      // try (21 -> 27): 75 null
      // try (29 -> 34): 75 null
      // try (39 -> 71): 75 null
   }

   protected void e() {
      this.j.beginTransaction();

      try {
         this.f = this.i.a(this.a);
         this.h();
         this.b(AlterSoupLongOperation.AlterSoupStep.COPY_TABLE);
         this.j.setTransactionSuccessful();
      } finally {
         this.j.endTransaction();
      }
   }

   protected void f() {
      byte var2 = 0;
      HashSet var4 = new HashSet();
      IndexSpec[] var5 = this.g;
      int var3 = var5.length;

      for (int var1 = 0; var1 < var3; var1++) {
         var4.add(var5[var1].a());
      }

      ArrayList var6 = new ArrayList();
      var5 = this.f;
      var3 = var5.length;

      for (int var10 = var2; var10 < var3; var10++) {
         IndexSpec var7 = var5[var10];
         if (!var4.contains(var7.a())) {
            var6.add(var7.a);
         }
      }

      this.j.beginTransaction();

      try {
         this.i.a(this.a, var6.toArray(new String[0]), false);
         this.b(AlterSoupLongOperation.AlterSoupStep.RE_INDEX_SOUP);
         this.j.setTransactionSuccessful();
      } finally {
         this.j.endTransaction();
      }
   }

   protected void g() {
      this.j.beginTransaction();

      try {
         SQLiteDatabase var1 = this.j;
         StringBuilder var2 = new StringBuilder();
         var1.execSQL(var2.append("DROP TABLE ").append(this.i()).toString());
         if (IndexSpec.b(this.g)) {
            SQLiteDatabase var6 = this.j;
            StringBuilder var5 = new StringBuilder();
            var6.execSQL(var5.append("DROP TABLE IF EXISTS ").append(this.i()).append("_fts").toString());
         }

         this.b(AlterSoupLongOperation.AlterSoupStep.DROP_OLD_TABLE);
         this.j.setTransactionSuccessful();
      } finally {
         this.j.endTransaction();
      }
   }

   public enum AlterSoupStep {
      COPY_TABLE,
      DROP_OLD_INDEXES,
      DROP_OLD_TABLE,
      REGISTER_SOUP_USING_TABLE_NAME,
      RENAME_OLD_SOUP_TABLE,
      RE_INDEX_SOUP,
      STARTING;

      private static final AlterSoupLongOperation.AlterSoupStep[] $VALUES = new AlterSoupLongOperation.AlterSoupStep[]{
         AlterSoupLongOperation.AlterSoupStep.STARTING,
         AlterSoupLongOperation.AlterSoupStep.RENAME_OLD_SOUP_TABLE,
         AlterSoupLongOperation.AlterSoupStep.DROP_OLD_INDEXES,
         AlterSoupLongOperation.AlterSoupStep.REGISTER_SOUP_USING_TABLE_NAME,
         AlterSoupLongOperation.AlterSoupStep.COPY_TABLE,
         AlterSoupLongOperation.AlterSoupStep.RE_INDEX_SOUP,
         AlterSoupLongOperation.AlterSoupStep.DROP_OLD_TABLE
      };
      public static final AlterSoupLongOperation.AlterSoupStep LAST = DROP_OLD_TABLE;
   }
}
