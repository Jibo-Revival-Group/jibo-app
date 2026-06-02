package com.salesforce.android.knowledge.core.internal.db;

import android.database.Cursor;
import net.sqlcipher.database.SQLiteDatabase;

class DbUtil {
   public static String a(Cursor var0, String var1) {
      return var0.getString(var0.getColumnIndex(var1));
   }

   public static void a(SQLiteDatabase var0, String var1) {
      var0.execSQL("DROP TABLE IF EXISTS " + var1);
   }

   public static int b(Cursor var0, String var1) {
      return var0.getInt(var0.getColumnIndex(var1));
   }
}
