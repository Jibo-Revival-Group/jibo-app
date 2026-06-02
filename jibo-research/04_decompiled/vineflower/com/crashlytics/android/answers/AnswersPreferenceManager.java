package com.crashlytics.android.answers;

import android.annotation.SuppressLint;
import android.content.Context;
import io.fabric.sdk.android.services.persistence.PreferenceStore;
import io.fabric.sdk.android.services.persistence.PreferenceStoreImpl;

class AnswersPreferenceManager {
   private final PreferenceStore a;

   AnswersPreferenceManager(PreferenceStore var1) {
      this.a = var1;
   }

   public static AnswersPreferenceManager a(Context var0) {
      return new AnswersPreferenceManager(new PreferenceStoreImpl(var0, "settings"));
   }

   @SuppressLint("CommitPrefEdits")
   public void a() {
      this.a.a(this.a.b().putBoolean("analytics_launched", true));
   }

   @SuppressLint("CommitPrefEdits")
   public boolean b() {
      return this.a.a().getBoolean("analytics_launched", false);
   }
}
