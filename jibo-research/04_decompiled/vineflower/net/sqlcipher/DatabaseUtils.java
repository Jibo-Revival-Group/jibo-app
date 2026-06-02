package net.sqlcipher;

import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.Collator;
import java.util.HashMap;
import net.sqlcipher.database.SQLiteAbortException;
import net.sqlcipher.database.SQLiteConstraintException;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteDatabaseCorruptException;
import net.sqlcipher.database.SQLiteDiskIOException;
import net.sqlcipher.database.SQLiteException;
import net.sqlcipher.database.SQLiteFullException;
import net.sqlcipher.database.SQLiteProgram;
import net.sqlcipher.database.SQLiteStatement;

public class DatabaseUtils {
   private static final boolean DEBUG = false;
   private static final char[] HEX_DIGITS_LOWER = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
   private static final boolean LOCAL_LOGV = false;
   private static final String TAG = "DatabaseUtils";
   private static final String[] countProjection = new String[]{"count(*)"};
   private static Collator mColl = null;

   public static void appendEscapedSQLString(StringBuilder var0, String var1) {
      var0.append('\'');
      if (var1.indexOf(39) != -1) {
         int var4 = var1.length();

         for (int var3 = 0; var3 < var4; var3++) {
            char var2 = var1.charAt(var3);
            if (var2 == '\'') {
               var0.append('\'');
            }

            var0.append(var2);
         }
      } else {
         var0.append(var1);
      }

      var0.append('\'');
   }

   public static final void appendValueToSql(StringBuilder var0, Object var1) {
      if (var1 == null) {
         var0.append("NULL");
      } else if (var1 instanceof Boolean) {
         if ((Boolean)var1) {
            var0.append('1');
         } else {
            var0.append('0');
         }
      } else {
         appendEscapedSQLString(var0, var1.toString());
      }
   }

   public static void bindObjectToProgram(SQLiteProgram var0, int var1, Object var2) {
      if (var2 == null) {
         var0.bindNull(var1);
      } else if (var2 instanceof Double || var2 instanceof Float) {
         var0.bindDouble(var1, ((Number)var2).doubleValue());
      } else if (var2 instanceof Number) {
         var0.bindLong(var1, ((Number)var2).longValue());
      } else if (var2 instanceof Boolean) {
         if ((Boolean)var2) {
            var0.bindLong(var1, 1L);
         } else {
            var0.bindLong(var1, 0L);
         }
      } else if (var2 instanceof byte[]) {
         var0.bindBlob(var1, (byte[])var2);
      } else {
         var0.bindString(var1, var2.toString());
      }
   }

   public static String concatenateWhere(String var0, String var1) {
      if (!TextUtils.isEmpty(var0)) {
         if (TextUtils.isEmpty(var1)) {
            var1 = var0;
         } else {
            var1 = "(" + var0 + ") AND (" + var1 + ")";
         }
      }

      return var1;
   }

   public static void cursorDoubleToContentValues(Cursor var0, String var1, ContentValues var2, String var3) {
      int var4 = var0.getColumnIndex(var1);
      if (!var0.isNull(var4)) {
         var2.put(var3, var0.getDouble(var4));
      } else {
         var2.put(var3, (Double)null);
      }
   }

   public static void cursorDoubleToContentValuesIfPresent(Cursor var0, ContentValues var1, String var2) {
      int var3 = var0.getColumnIndexOrThrow(var2);
      if (!var0.isNull(var3)) {
         var1.put(var2, var0.getDouble(var3));
      }
   }

   public static void cursorDoubleToCursorValues(Cursor var0, String var1, ContentValues var2) {
      cursorDoubleToContentValues(var0, var1, var2, var1);
   }

   public static void cursorFillWindow(Cursor var0, int var1, android.database.CursorWindow var2) {
      if (var1 >= 0 && var1 < var0.getCount()) {
         int var4 = var0.getPosition();
         int var5 = var0.getColumnCount();
         var2.clear();
         var2.setStartPosition(var1);
         var2.setNumColumns(var5);
         if (var0.moveToPosition(var1)) {
            while (var2.allocRow()) {
               for (int var3 = 0; var3 < var5; var3++) {
                  boolean var6;
                  switch (var0.getType(var3)) {
                     case 0:
                        var6 = var2.putNull(var1, var3);
                        break;
                     case 1:
                        var6 = var2.putLong(var0.getLong(var3), var1, var3);
                        break;
                     case 2:
                        var6 = var2.putDouble(var0.getDouble(var3), var1, var3);
                        break;
                     case 3:
                     default:
                        String var8 = var0.getString(var3);
                        if (var8 != null) {
                           var6 = var2.putString(var8, var1, var3);
                        } else {
                           var6 = var2.putNull(var1, var3);
                        }
                        break;
                     case 4:
                        byte[] var7 = var0.getBlob(var3);
                        if (var7 != null) {
                           var6 = var2.putBlob(var7, var1, var3);
                        } else {
                           var6 = var2.putNull(var1, var3);
                        }
                  }

                  if (!var6) {
                     var2.freeLastRow();
                     break;
                  }
               }

               var1++;
               if (!var0.moveToNext()) {
                  break;
               }
            }
         }

         var0.moveToPosition(var4);
      }
   }

   public static void cursorFloatToContentValuesIfPresent(Cursor var0, ContentValues var1, String var2) {
      int var3 = var0.getColumnIndexOrThrow(var2);
      if (!var0.isNull(var3)) {
         var1.put(var2, var0.getFloat(var3));
      }
   }

   public static void cursorIntToContentValues(Cursor var0, String var1, ContentValues var2) {
      cursorIntToContentValues(var0, var1, var2, var1);
   }

   public static void cursorIntToContentValues(Cursor var0, String var1, ContentValues var2, String var3) {
      int var4 = var0.getColumnIndex(var1);
      if (!var0.isNull(var4)) {
         var2.put(var3, var0.getInt(var4));
      } else {
         var2.put(var3, (Integer)null);
      }
   }

   public static void cursorIntToContentValuesIfPresent(Cursor var0, ContentValues var1, String var2) {
      int var3 = var0.getColumnIndexOrThrow(var2);
      if (!var0.isNull(var3)) {
         var1.put(var2, var0.getInt(var3));
      }
   }

   public static void cursorLongToContentValues(Cursor var0, String var1, ContentValues var2) {
      cursorLongToContentValues(var0, var1, var2, var1);
   }

   public static void cursorLongToContentValues(Cursor var0, String var1, ContentValues var2, String var3) {
      int var4 = var0.getColumnIndex(var1);
      if (!var0.isNull(var4)) {
         var2.put(var3, var0.getLong(var4));
      } else {
         var2.put(var3, (Long)null);
      }
   }

   public static void cursorLongToContentValuesIfPresent(Cursor var0, ContentValues var1, String var2) {
      int var3 = var0.getColumnIndexOrThrow(var2);
      if (!var0.isNull(var3)) {
         var1.put(var2, var0.getLong(var3));
      }
   }

   public static void cursorRowToContentValues(Cursor var0, ContentValues var1) {
      AbstractWindowedCursor var4;
      if (var0 instanceof AbstractWindowedCursor) {
         var4 = (AbstractWindowedCursor)var0;
      } else {
         var4 = null;
      }

      String[] var5 = var0.getColumnNames();
      int var3 = var5.length;

      for (int var2 = 0; var2 < var3; var2++) {
         if (var4 != null && var4.isBlob(var2)) {
            var1.put(var5[var2], var0.getBlob(var2));
         } else {
            var1.put(var5[var2], var0.getString(var2));
         }
      }
   }

   public static void cursorShortToContentValuesIfPresent(Cursor var0, ContentValues var1, String var2) {
      int var3 = var0.getColumnIndexOrThrow(var2);
      if (!var0.isNull(var3)) {
         var1.put(var2, var0.getShort(var3));
      }
   }

   public static void cursorStringToContentValues(Cursor var0, String var1, ContentValues var2) {
      cursorStringToContentValues(var0, var1, var2, var1);
   }

   public static void cursorStringToContentValues(Cursor var0, String var1, ContentValues var2, String var3) {
      var2.put(var3, var0.getString(var0.getColumnIndexOrThrow(var1)));
   }

   public static void cursorStringToContentValuesIfPresent(Cursor var0, ContentValues var1, String var2) {
      int var3 = var0.getColumnIndexOrThrow(var2);
      if (!var0.isNull(var3)) {
         var1.put(var2, var0.getString(var3));
      }
   }

   public static void cursorStringToInsertHelper(Cursor var0, String var1, DatabaseUtils.InsertHelper var2, int var3) {
      var2.bind(var3, var0.getString(var0.getColumnIndexOrThrow(var1)));
   }

   public static void dumpCurrentRow(Cursor var0) {
      dumpCurrentRow(var0, System.out);
   }

   public static void dumpCurrentRow(Cursor var0, PrintStream var1) {
      String[] var5 = var0.getColumnNames();
      var1.println("" + var0.getPosition() + " {");
      int var3 = var5.length;

      for (int var2 = 0; var2 < var3; var2++) {
         String var4;
         try {
            var4 = var0.getString(var2);
         } catch (SQLiteException var6) {
            var4 = "<unprintable>";
         }

         var1.println("   " + var5[var2] + '=' + var4);
      }

      var1.println("}");
   }

   public static void dumpCurrentRow(Cursor var0, StringBuilder var1) {
      String[] var5 = var0.getColumnNames();
      var1.append("" + var0.getPosition() + " {\n");
      int var3 = var5.length;

      for (int var2 = 0; var2 < var3; var2++) {
         String var4;
         try {
            var4 = var0.getString(var2);
         } catch (SQLiteException var6) {
            var4 = "<unprintable>";
         }

         var1.append("   " + var5[var2] + '=' + var4 + "\n");
      }

      var1.append("}\n");
   }

   public static String dumpCurrentRowToString(Cursor var0) {
      StringBuilder var1 = new StringBuilder();
      dumpCurrentRow(var0, var1);
      return var1.toString();
   }

   public static void dumpCursor(Cursor var0) {
      dumpCursor(var0, System.out);
   }

   public static void dumpCursor(Cursor var0, PrintStream var1) {
      var1.println(">>>>> Dumping cursor " + var0);
      if (var0 != null) {
         int var2 = var0.getPosition();
         var0.moveToPosition(-1);

         while (var0.moveToNext()) {
            dumpCurrentRow(var0, var1);
         }

         var0.moveToPosition(var2);
      }

      var1.println("<<<<<");
   }

   public static void dumpCursor(Cursor var0, StringBuilder var1) {
      var1.append(">>>>> Dumping cursor " + var0 + "\n");
      if (var0 != null) {
         int var2 = var0.getPosition();
         var0.moveToPosition(-1);

         while (var0.moveToNext()) {
            dumpCurrentRow(var0, var1);
         }

         var0.moveToPosition(var2);
      }

      var1.append("<<<<<\n");
   }

   public static String dumpCursorToString(Cursor var0) {
      StringBuilder var1 = new StringBuilder();
      dumpCursor(var0, var1);
      return var1.toString();
   }

   private static char[] encodeHex(byte[] var0, char[] var1) {
      int var3 = 0;
      int var4 = var0.length;
      char[] var6 = new char[var4 << 1];

      for (int var2 = 0; var2 < var4; var2++) {
         int var5 = var3 + 1;
         var6[var3] = var1[(var0[var2] & 240) >>> 4];
         var3 = var5 + 1;
         var6[var5] = var1[var0[var2] & 15];
      }

      return var6;
   }

   public static String getCollationKey(String var0) {
      byte[] var1 = getCollationKeyInBytes(var0);

      try {
         var0 = new String(var1, 0, getKeyLen(var1), "ISO8859_1");
      } catch (Exception var2) {
         var0 = "";
      }

      return var0;
   }

   private static byte[] getCollationKeyInBytes(String var0) {
      if (mColl == null) {
         mColl = Collator.getInstance();
         mColl.setStrength(0);
      }

      return mColl.getCollationKey(var0).toByteArray();
   }

   public static String getHexCollationKey(String var0) {
      byte[] var1 = getCollationKeyInBytes(var0);
      return new String(encodeHex(var1, HEX_DIGITS_LOWER), 0, getKeyLen(var1) * 2);
   }

   private static int getKeyLen(byte[] var0) {
      int var1;
      if (var0[var0.length - 1] != 0) {
         var1 = var0.length;
      } else {
         var1 = var0.length - 1;
      }

      return var1;
   }

   public static int getTypeOfObject(Object var0) {
      byte var1;
      if (var0 == null) {
         var1 = 0;
      } else if (var0 instanceof byte[]) {
         var1 = 4;
      } else if (var0 instanceof Float || var0 instanceof Double) {
         var1 = 2;
      } else if (!(var0 instanceof Long) && !(var0 instanceof Integer)) {
         var1 = 3;
      } else {
         var1 = 1;
      }

      return var1;
   }

   public static long longForQuery(SQLiteDatabase var0, String var1, String[] var2) {
      SQLiteStatement var7 = var0.compileStatement(var1);

      try {
         return longForQuery(var7, var2);
      } finally {
         var7.close();
      }
   }

   public static long longForQuery(SQLiteStatement var0, String[] var1) {
      if (var1 != null) {
         int var3 = var1.length;

         for (int var2 = 0; var2 < var3; var2++) {
            bindObjectToProgram(var0, var2 + 1, var1[var2]);
         }
      }

      return var0.simpleQueryForLong();
   }

   public static long queryNumEntries(SQLiteDatabase var0, String var1) {
      Cursor var6 = var0.query(var1, countProjection, null, null, null, null, null);

      try {
         var6.moveToFirst();
         return var6.getLong(0);
      } finally {
         var6.close();
      }
   }

   public static final void readExceptionFromParcel(Parcel var0) {
      int var1 = var0.readInt();
      if (var1 != 0) {
         readExceptionFromParcel(var0, var0.readString(), var1);
      }
   }

   private static final void readExceptionFromParcel(Parcel var0, String var1, int var2) {
      switch (var2) {
         case 2:
            throw new IllegalArgumentException(var1);
         case 3:
            throw new UnsupportedOperationException(var1);
         case 4:
            throw new SQLiteAbortException(var1);
         case 5:
            throw new SQLiteConstraintException(var1);
         case 6:
            throw new SQLiteDatabaseCorruptException(var1);
         case 7:
            throw new SQLiteFullException(var1);
         case 8:
            throw new SQLiteDiskIOException(var1);
         case 9:
            throw new SQLiteException(var1);
         default:
            var0.readException(var2, var1);
      }
   }

   public static void readExceptionWithFileNotFoundExceptionFromParcel(Parcel var0) throws FileNotFoundException {
      int var1 = var0.readInt();
      if (var1 != 0) {
         String var2 = var0.readString();
         if (var1 == 1) {
            throw new FileNotFoundException(var2);
         }

         readExceptionFromParcel(var0, var2, var1);
      }
   }

   public static void readExceptionWithOperationApplicationExceptionFromParcel(Parcel var0) throws OperationApplicationException {
      int var1 = var0.readInt();
      if (var1 != 0) {
         String var2 = var0.readString();
         if (var1 == 10) {
            throw new OperationApplicationException(var2);
         }

         readExceptionFromParcel(var0, var2, var1);
      }
   }

   public static String sqlEscapeString(String var0) {
      StringBuilder var1 = new StringBuilder();
      appendEscapedSQLString(var1, var0);
      return var1.toString();
   }

   public static String stringForQuery(SQLiteDatabase var0, String var1, String[] var2) {
      SQLiteStatement var5 = var0.compileStatement(var1);

      try {
         return stringForQuery(var5, var2);
      } finally {
         var5.close();
      }
   }

   public static String stringForQuery(SQLiteStatement var0, String[] var1) {
      if (var1 != null) {
         int var3 = var1.length;

         for (int var2 = 0; var2 < var3; var2++) {
            bindObjectToProgram(var0, var2 + 1, var1[var2]);
         }
      }

      return var0.simpleQueryForString();
   }

   public static final void writeExceptionToParcel(Parcel var0, Exception var1) {
      byte var3 = 1;
      boolean var2;
      if (var1 instanceof FileNotFoundException) {
         var2 = false;
      } else if (var1 instanceof IllegalArgumentException) {
         var3 = 2;
         var2 = true;
      } else if (var1 instanceof UnsupportedOperationException) {
         var3 = 3;
         var2 = true;
      } else if (var1 instanceof SQLiteAbortException) {
         var3 = 4;
         var2 = true;
      } else if (var1 instanceof SQLiteConstraintException) {
         var3 = 5;
         var2 = true;
      } else if (var1 instanceof SQLiteDatabaseCorruptException) {
         var3 = 6;
         var2 = true;
      } else if (var1 instanceof SQLiteFullException) {
         var3 = 7;
         var2 = true;
      } else if (var1 instanceof SQLiteDiskIOException) {
         var3 = 8;
         var2 = true;
      } else if (var1 instanceof SQLiteException) {
         var3 = 9;
         var2 = true;
      } else {
         if (!(var1 instanceof OperationApplicationException)) {
            var0.writeException(var1);
            Log.e("DatabaseUtils", "Writing exception to parcel", var1);
            return;
         }

         var3 = 10;
         var2 = true;
      }

      var0.writeInt(var3);
      var0.writeString(var1.getMessage());
      if (var2) {
         Log.e("DatabaseUtils", "Writing exception to parcel", var1);
      }
   }

   public static class InsertHelper {
      public static final int TABLE_INFO_PRAGMA_COLUMNNAME_INDEX = 1;
      public static final int TABLE_INFO_PRAGMA_DEFAULT_INDEX = 4;
      private HashMap<String, Integer> mColumns;
      private final SQLiteDatabase mDb;
      private String mInsertSQL = null;
      private SQLiteStatement mInsertStatement = null;
      private SQLiteStatement mPreparedStatement;
      private SQLiteStatement mReplaceStatement = null;
      private final String mTableName;

      public InsertHelper(SQLiteDatabase var1, String var2) {
         this.mPreparedStatement = null;
         this.mDb = var1;
         this.mTableName = var2;
      }

      private void buildSQL() throws SQLException {
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
         // 001: astore 3
         // 002: new java/lang/StringBuilder
         // 005: dup
         // 006: sipush 128
         // 009: invokespecial java/lang/StringBuilder.<init> (I)V
         // 00c: astore 5
         // 00e: aload 5
         // 010: ldc "INSERT INTO "
         // 012: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 015: pop
         // 016: aload 5
         // 018: aload 0
         // 019: getfield net/sqlcipher/DatabaseUtils$InsertHelper.mTableName Ljava/lang/String;
         // 01c: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 01f: pop
         // 020: aload 5
         // 022: ldc " ("
         // 024: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 027: pop
         // 028: new java/lang/StringBuilder
         // 02b: dup
         // 02c: sipush 128
         // 02f: invokespecial java/lang/StringBuilder.<init> (I)V
         // 032: astore 6
         // 034: aload 6
         // 036: ldc "VALUES ("
         // 038: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 03b: pop
         // 03c: aload 3
         // 03d: astore 2
         // 03e: aload 0
         // 03f: getfield net/sqlcipher/DatabaseUtils$InsertHelper.mDb Lnet/sqlcipher/database/SQLiteDatabase;
         // 042: astore 4
         // 044: aload 3
         // 045: astore 2
         // 046: new java/lang/StringBuilder
         // 049: astore 7
         // 04b: aload 3
         // 04c: astore 2
         // 04d: aload 7
         // 04f: invokespecial java/lang/StringBuilder.<init> ()V
         // 052: aload 3
         // 053: astore 2
         // 054: aload 4
         // 056: aload 7
         // 058: ldc "PRAGMA table_info("
         // 05a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 05d: aload 0
         // 05e: getfield net/sqlcipher/DatabaseUtils$InsertHelper.mTableName Ljava/lang/String;
         // 061: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 064: ldc ")"
         // 066: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 069: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
         // 06c: aconst_null
         // 06d: invokevirtual net/sqlcipher/database/SQLiteDatabase.rawQuery (Ljava/lang/String;[Ljava/lang/String;)Lnet/sqlcipher/Cursor;
         // 070: astore 4
         // 072: aload 4
         // 074: astore 2
         // 075: new java/util/HashMap
         // 078: astore 3
         // 079: aload 4
         // 07b: astore 2
         // 07c: aload 3
         // 07d: aload 4
         // 07f: invokeinterface net/sqlcipher/Cursor.getCount ()I 1
         // 084: invokespecial java/util/HashMap.<init> (I)V
         // 087: aload 4
         // 089: astore 2
         // 08a: aload 0
         // 08b: aload 3
         // 08c: putfield net/sqlcipher/DatabaseUtils$InsertHelper.mColumns Ljava/util/HashMap;
         // 08f: bipush 1
         // 090: istore 1
         // 091: aload 4
         // 093: astore 2
         // 094: aload 4
         // 096: invokeinterface net/sqlcipher/Cursor.moveToNext ()Z 1
         // 09b: ifeq 170
         // 09e: aload 4
         // 0a0: astore 2
         // 0a1: aload 4
         // 0a3: bipush 1
         // 0a4: invokeinterface net/sqlcipher/Cursor.getString (I)Ljava/lang/String; 2
         // 0a9: astore 3
         // 0aa: aload 4
         // 0ac: astore 2
         // 0ad: aload 4
         // 0af: bipush 4
         // 0b0: invokeinterface net/sqlcipher/Cursor.getString (I)Ljava/lang/String; 2
         // 0b5: astore 7
         // 0b7: aload 4
         // 0b9: astore 2
         // 0ba: aload 0
         // 0bb: getfield net/sqlcipher/DatabaseUtils$InsertHelper.mColumns Ljava/util/HashMap;
         // 0be: aload 3
         // 0bf: iload 1
         // 0c0: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
         // 0c3: invokevirtual java/util/HashMap.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
         // 0c6: pop
         // 0c7: aload 4
         // 0c9: astore 2
         // 0ca: aload 5
         // 0cc: ldc "'"
         // 0ce: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 0d1: pop
         // 0d2: aload 4
         // 0d4: astore 2
         // 0d5: aload 5
         // 0d7: aload 3
         // 0d8: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 0db: pop
         // 0dc: aload 4
         // 0de: astore 2
         // 0df: aload 5
         // 0e1: ldc "'"
         // 0e3: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 0e6: pop
         // 0e7: aload 7
         // 0e9: ifnonnull 133
         // 0ec: aload 4
         // 0ee: astore 2
         // 0ef: aload 6
         // 0f1: ldc "?"
         // 0f3: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 0f6: pop
         // 0f7: aload 4
         // 0f9: astore 2
         // 0fa: iload 1
         // 0fb: aload 4
         // 0fd: invokeinterface net/sqlcipher/Cursor.getCount ()I 1
         // 102: if_icmpne 164
         // 105: ldc ") "
         // 107: astore 3
         // 108: aload 4
         // 10a: astore 2
         // 10b: aload 5
         // 10d: aload 3
         // 10e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 111: pop
         // 112: aload 4
         // 114: astore 2
         // 115: iload 1
         // 116: aload 4
         // 118: invokeinterface net/sqlcipher/Cursor.getCount ()I 1
         // 11d: if_icmpne 16a
         // 120: ldc ");"
         // 122: astore 3
         // 123: aload 4
         // 125: astore 2
         // 126: aload 6
         // 128: aload 3
         // 129: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 12c: pop
         // 12d: iinc 1 1
         // 130: goto 091
         // 133: aload 4
         // 135: astore 2
         // 136: aload 6
         // 138: ldc "COALESCE(?, "
         // 13a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 13d: pop
         // 13e: aload 4
         // 140: astore 2
         // 141: aload 6
         // 143: aload 7
         // 145: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 148: pop
         // 149: aload 4
         // 14b: astore 2
         // 14c: aload 6
         // 14e: ldc ")"
         // 150: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 153: pop
         // 154: goto 0f7
         // 157: astore 3
         // 158: aload 2
         // 159: ifnull 162
         // 15c: aload 2
         // 15d: invokeinterface net/sqlcipher/Cursor.close ()V 1
         // 162: aload 3
         // 163: athrow
         // 164: ldc ", "
         // 166: astore 3
         // 167: goto 108
         // 16a: ldc ", "
         // 16c: astore 3
         // 16d: goto 123
         // 170: aload 4
         // 172: ifnull 17c
         // 175: aload 4
         // 177: invokeinterface net/sqlcipher/Cursor.close ()V 1
         // 17c: aload 5
         // 17e: aload 6
         // 180: invokevirtual java/lang/StringBuilder.append (Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
         // 183: pop
         // 184: aload 0
         // 185: aload 5
         // 187: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
         // 18a: putfield net/sqlcipher/DatabaseUtils$InsertHelper.mInsertSQL Ljava/lang/String;
         // 18d: return
         // try (31 -> 34): 175 null
         // try (36 -> 38): 175 null
         // try (40 -> 42): 175 null
         // try (44 -> 57): 175 null
         // try (59 -> 61): 175 null
         // try (63 -> 67): 175 null
         // try (69 -> 72): 175 null
         // try (76 -> 79): 175 null
         // try (81 -> 85): 175 null
         // try (87 -> 91): 175 null
         // try (93 -> 100): 175 null
         // try (102 -> 106): 175 null
         // try (108 -> 112): 175 null
         // try (114 -> 118): 175 null
         // try (122 -> 126): 175 null
         // try (128 -> 132): 175 null
         // try (136 -> 140): 175 null
         // try (142 -> 146): 175 null
         // try (150 -> 154): 175 null
         // try (158 -> 162): 175 null
         // try (164 -> 168): 175 null
         // try (170 -> 174): 175 null
      }

      private SQLiteStatement getStatement(boolean var1) throws SQLException {
         SQLiteStatement var3;
         if (var1) {
            if (this.mReplaceStatement == null) {
               if (this.mInsertSQL == null) {
                  this.buildSQL();
               }

               String var2 = "INSERT OR REPLACE" + this.mInsertSQL.substring(6);
               this.mReplaceStatement = this.mDb.compileStatement(var2);
            }

            var3 = this.mReplaceStatement;
         } else {
            if (this.mInsertStatement == null) {
               if (this.mInsertSQL == null) {
                  this.buildSQL();
               }

               this.mInsertStatement = this.mDb.compileStatement(this.mInsertSQL);
            }

            var3 = this.mInsertStatement;
         }

         return var3;
      }

      private long insertInternal(ContentValues param1, boolean param2) {
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
         // 03: iload 2
         // 04: invokespecial net/sqlcipher/DatabaseUtils$InsertHelper.getStatement (Z)Lnet/sqlcipher/database/SQLiteStatement;
         // 07: astore 7
         // 09: aload 7
         // 0b: invokevirtual net/sqlcipher/database/SQLiteStatement.clearBindings ()V
         // 0e: aload 1
         // 0f: invokevirtual android/content/ContentValues.valueSet ()Ljava/util/Set;
         // 12: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
         // 17: astore 5
         // 19: aload 5
         // 1b: invokeinterface java/util/Iterator.hasNext ()Z 1
         // 20: ifeq 82
         // 23: aload 5
         // 25: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
         // 2a: checkcast java/util/Map$Entry
         // 2d: astore 6
         // 2f: aload 7
         // 31: aload 0
         // 32: aload 6
         // 34: invokeinterface java/util/Map$Entry.getKey ()Ljava/lang/Object; 1
         // 39: checkcast java/lang/String
         // 3c: invokevirtual net/sqlcipher/DatabaseUtils$InsertHelper.getColumnIndex (Ljava/lang/String;)I
         // 3f: aload 6
         // 41: invokeinterface java/util/Map$Entry.getValue ()Ljava/lang/Object; 1
         // 46: invokestatic net/sqlcipher/DatabaseUtils.bindObjectToProgram (Lnet/sqlcipher/database/SQLiteProgram;ILjava/lang/Object;)V
         // 49: goto 19
         // 4c: astore 6
         // 4e: new java/lang/StringBuilder
         // 51: astore 5
         // 53: aload 5
         // 55: invokespecial java/lang/StringBuilder.<init> ()V
         // 58: ldc "DatabaseUtils"
         // 5a: aload 5
         // 5c: ldc "Error inserting "
         // 5e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 61: aload 1
         // 62: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
         // 65: ldc " into table  "
         // 67: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 6a: aload 0
         // 6b: getfield net/sqlcipher/DatabaseUtils$InsertHelper.mTableName Ljava/lang/String;
         // 6e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 71: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
         // 74: aload 6
         // 76: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
         // 79: pop
         // 7a: ldc2_w -1
         // 7d: lstore 3
         // 7e: aload 0
         // 7f: monitorexit
         // 80: lload 3
         // 81: lreturn
         // 82: aload 7
         // 84: invokevirtual net/sqlcipher/database/SQLiteStatement.executeInsert ()J
         // 87: lstore 3
         // 88: goto 7e
         // 8b: astore 1
         // 8c: aload 0
         // 8d: monitorexit
         // 8e: aload 1
         // 8f: athrow
         // try (2 -> 12): 29 net/sqlcipher/SQLException
         // try (2 -> 12): 59 null
         // try (12 -> 28): 29 net/sqlcipher/SQLException
         // try (12 -> 28): 59 null
         // try (30 -> 49): 59 null
         // try (55 -> 58): 29 net/sqlcipher/SQLException
         // try (55 -> 58): 59 null
      }

      public void bind(int var1, double var2) {
         this.mPreparedStatement.bindDouble(var1, var2);
      }

      public void bind(int var1, float var2) {
         this.mPreparedStatement.bindDouble(var1, var2);
      }

      public void bind(int var1, int var2) {
         this.mPreparedStatement.bindLong(var1, var2);
      }

      public void bind(int var1, long var2) {
         this.mPreparedStatement.bindLong(var1, var2);
      }

      public void bind(int var1, String var2) {
         if (var2 == null) {
            this.mPreparedStatement.bindNull(var1);
         } else {
            this.mPreparedStatement.bindString(var1, var2);
         }
      }

      public void bind(int var1, boolean var2) {
         SQLiteStatement var5 = this.mPreparedStatement;
         long var3;
         if (var2) {
            var3 = 1L;
         } else {
            var3 = 0L;
         }

         var5.bindLong(var1, var3);
      }

      public void bind(int var1, byte[] var2) {
         if (var2 == null) {
            this.mPreparedStatement.bindNull(var1);
         } else {
            this.mPreparedStatement.bindBlob(var1, var2);
         }
      }

      public void bindNull(int var1) {
         this.mPreparedStatement.bindNull(var1);
      }

      public void close() {
         if (this.mInsertStatement != null) {
            this.mInsertStatement.close();
            this.mInsertStatement = null;
         }

         if (this.mReplaceStatement != null) {
            this.mReplaceStatement.close();
            this.mReplaceStatement = null;
         }

         this.mInsertSQL = null;
         this.mColumns = null;
      }

      // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      public long execute() {
         if (this.mPreparedStatement == null) {
            throw new IllegalStateException("you must prepare this inserter before calling execute");
         }

         boolean var7 = false /* VF: Semaphore variable */;

         long var13;
         label49: {
            try {
               var7 = true;
               var13 = this.mPreparedStatement.executeInsert();
               var7 = false;
               break label49;
            } catch (SQLException var8) {
               StringBuilder var4 = new StringBuilder();
               Log.e("DatabaseUtils", var4.append("Error executing InsertHelper with table ").append(this.mTableName).toString(), var8);
               var7 = false;
            } finally {
               if (var7) {
                  this.mPreparedStatement = null;
               }
            }

            var13 = -1L;
            this.mPreparedStatement = null;
            return var13;
         }

         this.mPreparedStatement = null;
         return var13;
      }

      public int getColumnIndex(String var1) {
         this.getStatement(false);
         Integer var2 = this.mColumns.get(var1);
         if (var2 == null) {
            throw new IllegalArgumentException("column '" + var1 + "' is invalid");
         } else {
            return var2;
         }
      }

      public long insert(ContentValues var1) {
         return this.insertInternal(var1, false);
      }

      public void prepareForInsert() {
         this.mPreparedStatement = this.getStatement(false);
         this.mPreparedStatement.clearBindings();
      }

      public void prepareForReplace() {
         this.mPreparedStatement = this.getStatement(true);
         this.mPreparedStatement.clearBindings();
      }

      public long replace(ContentValues var1) {
         return this.insertInternal(var1, true);
      }
   }
}
