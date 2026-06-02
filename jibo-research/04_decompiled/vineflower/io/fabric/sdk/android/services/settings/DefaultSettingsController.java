package io.fabric.sdk.android.services.settings;

import android.annotation.SuppressLint;
import android.content.SharedPreferences.Editor;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.CurrentTimeProvider;
import io.fabric.sdk.android.services.persistence.PreferenceStore;
import io.fabric.sdk.android.services.persistence.PreferenceStoreImpl;
import org.json.JSONException;
import org.json.JSONObject;

class DefaultSettingsController implements SettingsController {
   private final SettingsRequest a;
   private final SettingsJsonTransform b;
   private final CurrentTimeProvider c;
   private final CachedSettingsIo d;
   private final SettingsSpiCall e;
   private final Kit f;
   private final PreferenceStore g;

   public DefaultSettingsController(
      Kit var1, SettingsRequest var2, CurrentTimeProvider var3, SettingsJsonTransform var4, CachedSettingsIo var5, SettingsSpiCall var6
   ) {
      this.f = var1;
      this.a = var2;
      this.c = var3;
      this.b = var4;
      this.d = var5;
      this.e = var6;
      this.g = new PreferenceStoreImpl(this.f);
   }

   private void a(JSONObject var1, String var2) throws JSONException {
      Fabric.h().a("Fabric", var2 + var1.toString());
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private SettingsData b(SettingsCacheBehavior var1) {
      Object var6 = null;
      Object var7 = null;
      SettingsData var5 = (SettingsData)var7;

      label66: {
         JSONObject var8;
         try {
            if (SettingsCacheBehavior.SKIP_CACHE_LOOKUP.equals(var1)) {
               return var5;
            }

            var8 = this.d.a();
         } catch (Exception var15) {
            var16 = var15;
            var5 = (SettingsData)var6;
            break label66;
         }

         label63:
         if (var8 != null) {
            try {
               var5 = this.b.a(this.c, var8);
            } catch (Exception var13) {
               var16 = var13;
               var5 = (SettingsData)var6;
               break label63;
            }

            label56:
            if (var5 != null) {
               label51: {
                  boolean var2;
                  try {
                     this.a(var8, "Loaded cached settings: ");
                     long var3 = this.c.a();
                     if (SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION.equals(var1)) {
                        break label51;
                     }

                     var2 = var5.a(var3);
                  } catch (Exception var11) {
                     var16 = var11;
                     var5 = (SettingsData)var6;
                     break label56;
                  }

                  if (var2) {
                     try {
                        Fabric.h().a("Fabric", "Cached settings have expired.");
                     } catch (Exception var9) {
                        var16 = var9;
                        var5 = (SettingsData)var6;
                        break label56;
                     }

                     var5 = (SettingsData)var7;
                     return var5;
                  }
               }

               try {
                  Fabric.h().a("Fabric", "Returning cached settings.");
                  return var5;
               } catch (Exception var10) {
                  var16 = var10;
               }
            } else {
               label82: {
                  try {
                     Fabric.h().e("Fabric", "Failed to transform cached settings data.", null);
                  } catch (Exception var12) {
                     var16 = var12;
                     var5 = (SettingsData)var6;
                     break label82;
                  }

                  var5 = (SettingsData)var7;
                  return var5;
               }
            }
         } else {
            label83: {
               try {
                  Fabric.h().a("Fabric", "No cached settings data found.");
               } catch (Exception var14) {
                  var16 = var14;
                  var5 = (SettingsData)var6;
                  break label83;
               }

               var5 = (SettingsData)var7;
               return var5;
            }
         }
      }

      Fabric.h().e("Fabric", "Failed to get cached settings", var16);
      return var5;
   }

   @Override
   public SettingsData a() {
      return this.a(SettingsCacheBehavior.USE_CACHE);
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @Override
   public SettingsData a(SettingsCacheBehavior var1) {
      JSONObject var3 = null;
      SettingsData var2 = var3;

      label80: {
         label81: {
            try {
               if (Fabric.i()) {
                  break label81;
               }
            } catch (Exception var11) {
               var13 = var11;
               var12 = null;
               break label80;
            }

            var2 = var3;

            try {
               if (!this.d()) {
                  var2 = this.b(var1);
               }
            } catch (Exception var10) {
               var13 = var10;
               var12 = null;
               break label80;
            }
         }

         var12 = var2;
         if (var2 == null) {
            var12 = var2;

            try {
               var3 = this.e.a(this.a);
            } catch (Exception var9) {
               var13 = var9;
               break label80;
            }

            var12 = var2;
            if (var3 != null) {
               var12 = var2;

               try {
                  var2 = this.b.a(this.c, var3);
               } catch (Exception var8) {
                  var13 = var8;
                  break label80;
               }

               var12 = var2;

               try {
                  this.d.a(var2.g, var3);
               } catch (Exception var7) {
                  var13 = var7;
                  break label80;
               }

               var12 = var2;

               try {
                  this.a(var3, "Loaded settings: ");
               } catch (Exception var6) {
                  var13 = var6;
                  break label80;
               }

               var12 = var2;

               try {
                  this.a(this.b());
               } catch (Exception var5) {
                  var13 = var5;
                  break label80;
               }

               var12 = var2;
            }
         }

         var2 = var12;
         if (var12 != null) {
            return var2;
         }

         try {
            var2 = this.b(SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION);
            return var2;
         } catch (Exception var4) {
            var13 = var4;
         }
      }

      Fabric.h().e("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", var13);
      return var12;
   }

   @SuppressLint("CommitPrefEdits")
   boolean a(String var1) {
      Editor var2 = this.g.b();
      var2.putString("existing_instance_identifier", var1);
      return this.g.a(var2);
   }

   String b() {
      return CommonUtils.a(new String[]{CommonUtils.m(this.f.r())});
   }

   String c() {
      return this.g.a().getString("existing_instance_identifier", "");
   }

   boolean d() {
      boolean var1;
      if (!this.c().equals(this.b())) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }
}
