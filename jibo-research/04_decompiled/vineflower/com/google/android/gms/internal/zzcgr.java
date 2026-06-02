package com.google.android.gms.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;

final class zzcgr extends SQLiteOpenHelper {
   private zzcgo a;

   zzcgr(zzcgo var1, Context var2, String var3) {
      this.a = var1;
      super(var2, var3, null, 1);
   }

   public final SQLiteDatabase getWritableDatabase() {
      if (!zzcgo.a(this.a).a(3600000L)) {
         throw new SQLiteException("Database open failed");
      }

      SQLiteDatabase var1;
      try {
         var1 = super.getWritableDatabase();
      } catch (SQLiteException var3) {
         zzcgo.a(this.a).a();
         this.a.t().y().a("Opening the database failed, dropping and recreating it");
         if (!this.a.l().getDatabasePath("google_app_measurement.db").delete()) {
            this.a.t().y().a("Failed to delete corrupted db file", "google_app_measurement.db");
         }

         try {
            var1 = super.getWritableDatabase();
            zzcgo.a(this.a).b();
         } catch (SQLiteException var2) {
            this.a.t().y().a("Failed to open freshly created database", var2);
            throw var2;
         }
      }

      return var1;
   }

   public final void onCreate(SQLiteDatabase var1) {
      zzcgo.a(this.a.t(), var1);
   }

   public final void onDowngrade(SQLiteDatabase var1, int var2, int var3) {
   }

   public final void onOpen(SQLiteDatabase var1) {
      if (VERSION.SDK_INT < 15) {
         Cursor var2 = var1.rawQuery("PRAGMA journal_mode=memory", null);

         try {
            var2.moveToFirst();
         } finally {
            var2.close();
         }
      }

      zzcgo.a(
         this.a.t(),
         var1,
         "events",
         "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;",
         "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp",
         zzcgo.J()
      );
      zzcgo.a(
         this.a.t(),
         var1,
         "conditional_properties",
         "CREATE TABLE IF NOT EXISTS conditional_properties ( app_id TEXT NOT NULL, origin TEXT NOT NULL, name TEXT NOT NULL, value BLOB NOT NULL, creation_timestamp INTEGER NOT NULL, active INTEGER NOT NULL, trigger_event_name TEXT, trigger_timeout INTEGER NOT NULL, timed_out_event BLOB,triggered_event BLOB, triggered_timestamp INTEGER NOT NULL, time_to_live INTEGER NOT NULL, expired_event BLOB, PRIMARY KEY (app_id, name)) ;",
         "app_id,origin,name,value,active,trigger_event_name,trigger_timeout,creation_timestamp,timed_out_event,triggered_event,triggered_timestamp,time_to_live,expired_event",
         null
      );
      zzcgo.a(
         this.a.t(),
         var1,
         "user_attributes",
         "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, set_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;",
         "app_id,name,set_timestamp,value",
         zzcgo.K()
      );
      zzcgo.a(
         this.a.t(),
         var1,
         "apps",
         "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;",
         "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp",
         zzcgo.L()
      );
      zzcgo.a(
         this.a.t(),
         var1,
         "queue",
         "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);",
         "app_id,bundle_end_timestamp,data",
         zzcgo.M()
      );
      zzcgo.a(
         this.a.t(),
         var1,
         "raw_events_metadata",
         "CREATE TABLE IF NOT EXISTS raw_events_metadata ( app_id TEXT NOT NULL, metadata_fingerprint INTEGER NOT NULL, metadata BLOB NOT NULL, PRIMARY KEY (app_id, metadata_fingerprint));",
         "app_id,metadata_fingerprint,metadata",
         null
      );
      zzcgo.a(
         this.a.t(),
         var1,
         "raw_events",
         "CREATE TABLE IF NOT EXISTS raw_events ( app_id TEXT NOT NULL, name TEXT NOT NULL, timestamp INTEGER NOT NULL, metadata_fingerprint INTEGER NOT NULL, data BLOB NOT NULL);",
         "app_id,name,timestamp,metadata_fingerprint,data",
         zzcgo.N()
      );
      zzcgo.a(
         this.a.t(),
         var1,
         "event_filters",
         "CREATE TABLE IF NOT EXISTS event_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, event_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, event_name, audience_id, filter_id));",
         "app_id,audience_id,filter_id,event_name,data",
         null
      );
      zzcgo.a(
         this.a.t(),
         var1,
         "property_filters",
         "CREATE TABLE IF NOT EXISTS property_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, property_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, property_name, audience_id, filter_id));",
         "app_id,audience_id,filter_id,property_name,data",
         null
      );
      zzcgo.a(
         this.a.t(),
         var1,
         "audience_filter_values",
         "CREATE TABLE IF NOT EXISTS audience_filter_values ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, current_results BLOB, PRIMARY KEY (app_id, audience_id));",
         "app_id,audience_id,current_results",
         null
      );
      zzcgo.a(
         this.a.t(),
         var1,
         "app2",
         "CREATE TABLE IF NOT EXISTS app2 ( app_id TEXT NOT NULL, first_open_count INTEGER NOT NULL, PRIMARY KEY (app_id));",
         "app_id,first_open_count",
         zzcgo.O()
      );
   }

   public final void onUpgrade(SQLiteDatabase var1, int var2, int var3) {
   }
}
