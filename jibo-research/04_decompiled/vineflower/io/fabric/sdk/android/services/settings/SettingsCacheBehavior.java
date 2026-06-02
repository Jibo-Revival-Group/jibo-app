package io.fabric.sdk.android.services.settings;

public enum SettingsCacheBehavior {
   IGNORE_CACHE_EXPIRATION,
   SKIP_CACHE_LOOKUP,
   USE_CACHE;

   private static final SettingsCacheBehavior[] $VALUES = new SettingsCacheBehavior[]{
      SettingsCacheBehavior.USE_CACHE, SettingsCacheBehavior.SKIP_CACHE_LOOKUP, SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION
   };
}
