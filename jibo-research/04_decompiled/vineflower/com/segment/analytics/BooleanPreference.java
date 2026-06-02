package com.segment.analytics;

import android.content.SharedPreferences;

public class BooleanPreference {
   private final boolean defaultValue;
   private final String key;
   private final SharedPreferences preferences;

   public BooleanPreference(SharedPreferences var1, String var2, boolean var3) {
      this.preferences = var1;
      this.key = var2;
      this.defaultValue = var3;
   }

   public boolean get() {
      return this.preferences.getBoolean(this.key, this.defaultValue);
   }

   public void set(boolean var1) {
      this.preferences.edit().putBoolean(this.key, var1).apply();
   }
}
