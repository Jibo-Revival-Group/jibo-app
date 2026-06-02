package com.facebook;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.internal.Validate;
import org.json.JSONException;
import org.json.JSONObject;

class AccessTokenCache {
   static final String CACHED_ACCESS_TOKEN_KEY = "com.facebook.AccessTokenManager.CachedAccessToken";
   private final SharedPreferences sharedPreferences;
   private LegacyTokenHelper tokenCachingStrategy;
   private final AccessTokenCache.SharedPreferencesTokenCachingStrategyFactory tokenCachingStrategyFactory;

   public AccessTokenCache() {
      this(
         FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0),
         new AccessTokenCache.SharedPreferencesTokenCachingStrategyFactory()
      );
   }

   AccessTokenCache(SharedPreferences var1, AccessTokenCache.SharedPreferencesTokenCachingStrategyFactory var2) {
      this.sharedPreferences = var1;
      this.tokenCachingStrategyFactory = var2;
   }

   private AccessToken getCachedAccessToken() {
      Object var2 = null;
      String var3 = this.sharedPreferences.getString("com.facebook.AccessTokenManager.CachedAccessToken", null);
      AccessToken var1 = (AccessToken)var2;
      if (var3 != null) {
         try {
            JSONObject var5 = new JSONObject(var3);
            var1 = AccessToken.createFromJSONObject(var5);
         } catch (JSONException var4) {
            var1 = (AccessToken)var2;
         }
      }

      return var1;
   }

   private AccessToken getLegacyAccessToken() {
      Object var2 = null;
      Bundle var3 = this.getTokenCachingStrategy().load();
      AccessToken var1 = (AccessToken)var2;
      if (var3 != null) {
         var1 = (AccessToken)var2;
         if (LegacyTokenHelper.hasTokenInformation(var3)) {
            var1 = AccessToken.createFromLegacyCache(var3);
         }
      }

      return var1;
   }

   private LegacyTokenHelper getTokenCachingStrategy() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:573)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield com/facebook/AccessTokenCache.tokenCachingStrategy Lcom/facebook/LegacyTokenHelper;
      // 04: ifnonnull 1d
      // 07: aload 0
      // 08: monitorenter
      // 09: aload 0
      // 0a: getfield com/facebook/AccessTokenCache.tokenCachingStrategy Lcom/facebook/LegacyTokenHelper;
      // 0d: ifnonnull 1b
      // 10: aload 0
      // 11: aload 0
      // 12: getfield com/facebook/AccessTokenCache.tokenCachingStrategyFactory Lcom/facebook/AccessTokenCache$SharedPreferencesTokenCachingStrategyFactory;
      // 15: invokevirtual com/facebook/AccessTokenCache$SharedPreferencesTokenCachingStrategyFactory.create ()Lcom/facebook/LegacyTokenHelper;
      // 18: putfield com/facebook/AccessTokenCache.tokenCachingStrategy Lcom/facebook/LegacyTokenHelper;
      // 1b: aload 0
      // 1c: monitorexit
      // 1d: aload 0
      // 1e: getfield com/facebook/AccessTokenCache.tokenCachingStrategy Lcom/facebook/LegacyTokenHelper;
      // 21: areturn
      // 22: astore 1
      // 23: aload 0
      // 24: monitorexit
      // 25: aload 1
      // 26: athrow
      // try (5 -> 13): 18 null
      // try (13 -> 15): 18 null
      // try (19 -> 21): 18 null
   }

   private boolean hasCachedAccessToken() {
      return this.sharedPreferences.contains("com.facebook.AccessTokenManager.CachedAccessToken");
   }

   private boolean shouldCheckLegacyToken() {
      return FacebookSdk.isLegacyTokenUpgradeSupported();
   }

   public void clear() {
      this.sharedPreferences.edit().remove("com.facebook.AccessTokenManager.CachedAccessToken").apply();
      if (this.shouldCheckLegacyToken()) {
         this.getTokenCachingStrategy().clear();
      }
   }

   public AccessToken load() {
      AccessToken var1 = null;
      if (this.hasCachedAccessToken()) {
         var1 = this.getCachedAccessToken();
      } else if (this.shouldCheckLegacyToken()) {
         AccessToken var2 = this.getLegacyAccessToken();
         var1 = var2;
         if (var2 != null) {
            this.save(var2);
            this.getTokenCachingStrategy().clear();
            var1 = var2;
         }
      }

      return var1;
   }

   public void save(AccessToken var1) {
      Validate.notNull(var1, "accessToken");

      try {
         JSONObject var3 = var1.toJSONObject();
         this.sharedPreferences.edit().putString("com.facebook.AccessTokenManager.CachedAccessToken", var3.toString()).apply();
      } catch (JSONException var2) {
      }
   }

   static class SharedPreferencesTokenCachingStrategyFactory {
      public LegacyTokenHelper create() {
         return new LegacyTokenHelper(FacebookSdk.getApplicationContext());
      }
   }
}
