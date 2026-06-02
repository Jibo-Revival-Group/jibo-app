package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;

@TargetApi(11)
final class zzchj extends SQLiteOpenHelper {
   private zzchi a;

   zzchj(zzchi var1, Context var2, String var3) {
      this.a = var1;
      super(var2, var3, null, 1);
   }

   public final SQLiteDatabase getWritableDatabase() {
      SQLiteDatabase var1;
      try {
         var1 = super.getWritableDatabase();
      } catch (SQLiteException var3) {
         if (VERSION.SDK_INT >= 11 && var3 instanceof SQLiteDatabaseLockedException) {
            throw var3;
         }

         this.a.t().y().a("Opening the local database failed, dropping and recreating it");
         if (!this.a.l().getDatabasePath("google_app_measurement_local.db").delete()) {
            this.a.t().y().a("Failed to delete corrupted local db file", "google_app_measurement_local.db");
         }

         try {
            var1 = super.getWritableDatabase();
         } catch (SQLiteException var2) {
            this.a.t().y().a("Failed to open local database. Events will bypass local storage", var2);
            var1 = null;
         }
      }

      return var1;
   }

   public final void onCreate(SQLiteDatabase var1) {
      zzcgo.a(this.a.t(), var1);
   }

   public final void onDowngrade(SQLiteDatabase var1, int var2, int var3) {
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public final void onOpen(SQLiteDatabase var1) {
      Object var2 = null;
      if (VERSION.SDK_INT < 15) {
         boolean var8 = false /* VF: Semaphore variable */;

         Cursor var3;
         try {
            var8 = true;
            var3 = var1.rawQuery("PRAGMA journal_mode=memory", null);
            var8 = false;
         } finally {
            if (var8) {
               if (var2 != null) {
                  var2.close();
               }
            }
         }

         try {
            var3.moveToFirst();
         } finally {
            ;
         }

         if (var3 != null) {
            var3.close();
         }
      }

      zzcgo.a(this.a.t(), var1, "messages", "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)", "type,entry", null);
   }

   public final void onUpgrade(SQLiteDatabase var1, int var2, int var3) {
   }
}
