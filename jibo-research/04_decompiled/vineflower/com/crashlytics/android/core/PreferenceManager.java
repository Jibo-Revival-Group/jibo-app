package com.crashlytics.android.core;

import android.annotation.SuppressLint;
import io.fabric.sdk.android.services.persistence.PreferenceStore;
import io.fabric.sdk.android.services.persistence.PreferenceStoreImpl;

@SuppressLint("CommitPrefEdits")
class PreferenceManager {
   private final PreferenceStore a;

   public PreferenceManager(PreferenceStore var1) {
      this.a = var1;
   }

   public static PreferenceManager a(PreferenceStore var0, CrashlyticsCore var1) {
      if (!var0.a().getBoolean("preferences_migration_complete", false)) {
         PreferenceStoreImpl var4 = new PreferenceStoreImpl(var1);
         boolean var2;
         if (!var0.a().contains("always_send_reports_opt_in") && var4.a().contains("always_send_reports_opt_in")) {
            var2 = true;
         } else {
            var2 = false;
         }

         if (var2) {
            boolean var3 = var4.a().getBoolean("always_send_reports_opt_in", false);
            var0.a(var0.b().putBoolean("always_send_reports_opt_in", var3));
         }

         var0.a(var0.b().putBoolean("preferences_migration_complete", true));
      }

      return new PreferenceManager(var0);
   }

   void a(boolean var1) {
      this.a.a(this.a.b().putBoolean("always_send_reports_opt_in", var1));
   }

   boolean a() {
      return this.a.a().getBoolean("always_send_reports_opt_in", false);
   }
}
