package io.fabric.sdk.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import io.fabric.sdk.android.services.common.ApiKey;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.DeliveryMechanism;
import io.fabric.sdk.android.services.network.DefaultHttpRequestFactory;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.settings.AppRequestData;
import io.fabric.sdk.android.services.settings.AppSettingsData;
import io.fabric.sdk.android.services.settings.CreateAppSpiCall;
import io.fabric.sdk.android.services.settings.IconRequest;
import io.fabric.sdk.android.services.settings.Settings;
import io.fabric.sdk.android.services.settings.SettingsData;
import io.fabric.sdk.android.services.settings.UpdateAppSpiCall;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

class Onboarding extends Kit<Boolean> {
   private final HttpRequestFactory a = new DefaultHttpRequestFactory();
   private PackageManager b;
   private String c;
   private PackageInfo d;
   private String k;
   private String l;
   private String m;
   private String n;
   private String o;
   private final Future<Map<String, KitInfo>> p;
   private final Collection<Kit> q;

   public Onboarding(Future<Map<String, KitInfo>> var1, Collection<Kit> var2) {
      this.p = var1;
      this.q = var2;
   }

   private AppRequestData a(IconRequest var1, Collection<KitInfo> var2) {
      Context var5 = this.r();
      String var4 = new ApiKey().a(var5);
      String var6 = CommonUtils.a(new String[]{CommonUtils.m(var5)});
      int var3 = DeliveryMechanism.determineFrom(this.m).getId();
      return new AppRequestData(var4, this.q().c(), this.l, this.k, var6, this.n, var3, this.o, "0", var1, var2);
   }

   private boolean a(AppSettingsData var1, IconRequest var2, Collection<KitInfo> var3) {
      AppRequestData var4 = this.a(var2, var3);
      return new UpdateAppSpiCall(this, this.e(), var1.c, this.a).a(var4);
   }

   private boolean a(String var1, AppSettingsData var2, Collection<KitInfo> var3) {
      boolean var5 = true;
      boolean var4;
      if ("new".equals(var2.b)) {
         if (this.b(var1, var2, var3)) {
            var4 = Settings.a().d();
         } else {
            Fabric.h().e("Fabric", "Failed to create app with Crashlytics service.", null);
            var4 = false;
         }
      } else if ("configured".equals(var2.b)) {
         var4 = Settings.a().d();
      } else {
         var4 = var5;
         if (var2.e) {
            Fabric.h().a("Fabric", "Server says an update is required - forcing a full App update.");
            this.c(var1, var2, var3);
            var4 = var5;
         }
      }

      return var4;
   }

   private boolean b(String var1, AppSettingsData var2, Collection<KitInfo> var3) {
      AppRequestData var4 = this.a(IconRequest.a(this.r(), var1), var3);
      return new CreateAppSpiCall(this, this.e(), var2.c, this.a).a(var4);
   }

   private boolean c(String var1, AppSettingsData var2, Collection<KitInfo> var3) {
      return this.a(var2, IconRequest.a(this.r(), var1), var3);
   }

   private SettingsData g() {
      SettingsData var1;
      try {
         Settings.a().a(this, this.i, this.a, this.k, this.l, this.e()).c();
         var1 = Settings.a().b();
      } catch (Exception var2) {
         Fabric.h().e("Fabric", "Error dealing with settings", var2);
         var1 = null;
      }

      return var1;
   }

   @Override
   public String a() {
      return "1.3.17.dev";
   }

   Map<String, KitInfo> a(Map<String, KitInfo> var1, Collection<Kit> var2) {
      for (Kit var4 : var2) {
         if (!var1.containsKey(var4.b())) {
            var1.put(var4.b(), new KitInfo(var4.b(), var4.a(), "binary"));
         }
      }

      return var1;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @Override
   protected boolean a_() {
      boolean var1 = false;

      String var2;
      label30: {
         label36: {
            try {
               this.m = this.q().j();
               this.b = this.r().getPackageManager();
               this.c = this.r().getPackageName();
               this.d = this.b.getPackageInfo(this.c, 0);
               this.k = Integer.toString(this.d.versionCode);
               if (this.d.versionName == null) {
                  break label36;
               }
            } catch (NameNotFoundException var5) {
               Fabric.h().e("Fabric", "Failed init", var5);
               return var1;
            }

            try {
               var2 = this.d.versionName;
               break label30;
            } catch (NameNotFoundException var4) {
               Fabric.h().e("Fabric", "Failed init", var4);
               return var1;
            }
         }

         var2 = "0.0";
      }

      try {
         this.l = var2;
         this.n = this.b.getApplicationLabel(this.r().getApplicationInfo()).toString();
         this.o = Integer.toString(this.r().getApplicationInfo().targetSdkVersion);
      } catch (NameNotFoundException var3) {
         Fabric.h().e("Fabric", "Failed init", var3);
         return var1;
      }

      return true;
   }

   @Override
   public String b() {
      return "io.fabric.sdk.android:fabric";
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   protected Boolean d() {
      String var4 = CommonUtils.k(this.r());
      SettingsData var3 = this.g();
      label32:
      if (var3 != null) {
         Map var2;
         label35: {
            try {
               if (this.p != null) {
                  var2 = this.p.get();
                  break label35;
               }
            } catch (Exception var7) {
               Fabric.h().e("Fabric", "Error performing auto configuration.", var7);
               break label32;
            }

            try {
               var2 = new HashMap();
            } catch (Exception var6) {
               Fabric.h().e("Fabric", "Error performing auto configuration.", var6);
               break label32;
            }
         }

         try {
            var2 = this.a(var2, this.q);
            boolean var9 = this.a(var4, var3.a, var2.values());
            return var9;
         } catch (Exception var5) {
            Fabric.h().e("Fabric", "Error performing auto configuration.", var5);
         }
      }

      boolean var1 = false;
      return var1;
   }

   String e() {
      return CommonUtils.b(this.r(), "com.crashlytics.ApiEndpoint");
   }
}
