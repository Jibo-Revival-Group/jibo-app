package io.fabric.sdk.android.services.settings;

public class SettingsData {
   public final AppSettingsData a;
   public final SessionSettingsData b;
   public final PromptSettingsData c;
   public final FeaturesSettingsData d;
   public final AnalyticsSettingsData e;
   public final BetaSettingsData f;
   public final long g;
   public final int h;
   public final int i;

   public SettingsData(
      long var1,
      AppSettingsData var3,
      SessionSettingsData var4,
      PromptSettingsData var5,
      FeaturesSettingsData var6,
      AnalyticsSettingsData var7,
      BetaSettingsData var8,
      int var9,
      int var10
   ) {
      this.g = var1;
      this.a = var3;
      this.b = var4;
      this.c = var5;
      this.d = var6;
      this.h = var9;
      this.i = var10;
      this.e = var7;
      this.f = var8;
   }

   public boolean a(long var1) {
      boolean var3;
      if (this.g < var1) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }
}
