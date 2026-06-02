package com.jibo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
   private static DatabaseHelper a = null;

   private DatabaseHelper(Context var1) {
      super(var1, a(), null, 22);
   }

   public static DatabaseHelper a(Context var0) {
      synchronized (DatabaseHelper.class) {
         if (a == null) {
            DatabaseHelper var1 = new DatabaseHelper(var0);
            a = var1;
         }

         return a;
      }
   }

   private static String a() {
      return "jiboapp.db";
   }

   public void onCreate(SQLiteDatabase var1) {
      var1.execSQL("DROP TABLE IF EXISTS entity");
      var1.execSQL("DROP TABLE IF EXISTS jot");
      var1.execSQL("DROP TABLE IF EXISTS log_entry");
      var1.execSQL("DROP TABLE IF EXISTS media");
      var1.execSQL(
         "CREATE TABLE entity (_id TEXT NOT NULL, name TEXT NOT NULL DEFAULT '', type INTEGER NOT NULL DEFAULT 0, retrieved INTEGER NOT NULL DEFAULT -1, modified  INTEGER NOT NULL DEFAULT -1, data TEXT NULL DEFAULT NULL );"
      );
      var1.execSQL(
         "CREATE TABLE jot (_id TEXT NOT NULL PRIMARY KEY, loopId  TEXT NOT NULL DEFAULT '', content  TEXT NULL DEFAULT NULL, sender  TEXT NULL DEFAULT NULL, parts TEXT NULL DEFAULT NULL,hasPhotoVideo INTEGER DEFAULT 0, tags TEXT NULL DEFAULT NULL,created INTEGER DEFAULT -1, is_read INTEGER DEFAULT 0  ); CREATE INDEX jot_index_created on jot(created);CREATE INDEX jot_index_loop_created on jot(created,loopId);"
      );
      var1.execSQL("CREATE TABLE log_entry (_id INTEGER PRIMARY KEY,data TEXT NULL DEFAULT NULL );");
      var1.execSQL(
         "CREATE TABLE media (_id TEXT NOT NULL PRIMARY KEY, accountId TEXT NULL DEFAULT NULL, loopId TEXT NULL DEFAULT NULL, url TEXT NULL DEFAULT NULL, type TEXT NULL DEFAULT NULL, reference TEXT NULL DEFAULT NULL, isEncrypted INTEGER DEFAULT 0, created  INTEGER NOT NULL DEFAULT -1  );CREATE INDEX media_index_created on media(created);CREATE INDEX media_index_loop_created on media(created,loopId);"
      );
   }

   public void onUpgrade(SQLiteDatabase var1, int var2, int var3) {
      if (var2 == 1 && var3 == 2) {
         var1.execSQL("DROP TABLE IF EXISTS media");
         var1.execSQL(
            "CREATE TABLE media (_id TEXT NOT NULL PRIMARY KEY, accountId TEXT NULL DEFAULT NULL, loopId TEXT NULL DEFAULT NULL, url TEXT NULL DEFAULT NULL, type TEXT NULL DEFAULT NULL, reference TEXT NULL DEFAULT NULL, isEncrypted INTEGER DEFAULT 0, created  INTEGER NOT NULL DEFAULT -1  );CREATE INDEX media_index_created on media(created);CREATE INDEX media_index_loop_created on media(created,loopId);"
         );
      } else {
         this.onCreate(var1);
      }
   }
}
