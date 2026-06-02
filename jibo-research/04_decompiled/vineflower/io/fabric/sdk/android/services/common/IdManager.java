package io.fabric.sdk.android.services.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

public class IdManager {
   private static final Pattern d = Pattern.compile("[^\\p{Alnum}]");
   private static final String e = Pattern.quote("/");
   AdvertisingInfoProvider a;
   AdvertisingInfo b;
   boolean c;
   private final ReentrantLock f = new ReentrantLock();
   private final InstallerPackageNameProvider g;
   private final boolean h;
   private final boolean i;
   private final Context j;
   private final String k;
   private final String l;
   private final Collection<Kit> m;

   public IdManager(Context var1, String var2, String var3, Collection<Kit> var4) {
      if (var1 == null) {
         throw new IllegalArgumentException("appContext must not be null");
      }

      if (var2 == null) {
         throw new IllegalArgumentException("appIdentifier must not be null");
      }

      if (var4 == null) {
         throw new IllegalArgumentException("kits must not be null");
      }

      this.j = var1;
      this.k = var2;
      this.l = var3;
      this.m = var4;
      this.g = new InstallerPackageNameProvider();
      this.a = new AdvertisingInfoProvider(var1);
      this.h = CommonUtils.a(var1, "com.crashlytics.CollectDeviceIdentifiers", true);
      if (!this.h) {
         Fabric.h().a("Fabric", "Device ID collection disabled for " + var1.getPackageName());
      }

      this.i = CommonUtils.a(var1, "com.crashlytics.CollectUserIdentifiers", true);
      if (!this.i) {
         Fabric.h().a("Fabric", "User information collection disabled for " + var1.getPackageName());
      }
   }

   private String a(SharedPreferences param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1065)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:566)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield io/fabric/sdk/android/services/common/IdManager.f Ljava/util/concurrent/locks/ReentrantLock;
      // 04: invokevirtual java/util/concurrent/locks/ReentrantLock.lock ()V
      // 07: aload 1
      // 08: ldc "crashlytics.installation.id"
      // 0a: aconst_null
      // 0b: invokeinterface android/content/SharedPreferences.getString (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; 3
      // 10: astore 3
      // 11: aload 3
      // 12: astore 2
      // 13: aload 3
      // 14: ifnonnull 36
      // 17: aload 0
      // 18: invokestatic java/util/UUID.randomUUID ()Ljava/util/UUID;
      // 1b: invokevirtual java/util/UUID.toString ()Ljava/lang/String;
      // 1e: invokespecial io/fabric/sdk/android/services/common/IdManager.a (Ljava/lang/String;)Ljava/lang/String;
      // 21: astore 2
      // 22: aload 1
      // 23: invokeinterface android/content/SharedPreferences.edit ()Landroid/content/SharedPreferences$Editor; 1
      // 28: ldc "crashlytics.installation.id"
      // 2a: aload 2
      // 2b: invokeinterface android/content/SharedPreferences$Editor.putString (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor; 3
      // 30: invokeinterface android/content/SharedPreferences$Editor.commit ()Z 1
      // 35: pop
      // 36: aload 0
      // 37: getfield io/fabric/sdk/android/services/common/IdManager.f Ljava/util/concurrent/locks/ReentrantLock;
      // 3a: invokevirtual java/util/concurrent/locks/ReentrantLock.unlock ()V
      // 3d: aload 2
      // 3e: areturn
      // 3f: astore 1
      // 40: aload 0
      // 41: getfield io/fabric/sdk/android/services/common/IdManager.f Ljava/util/concurrent/locks/ReentrantLock;
      // 44: invokevirtual java/util/concurrent/locks/ReentrantLock.unlock ()V
      // 47: aload 1
      // 48: athrow
      // try (3 -> 8): 29 null
      // try (12 -> 24): 29 null
   }

   private String a(String var1) {
      if (var1 == null) {
         var1 = null;
      } else {
         var1 = d.matcher(var1).replaceAll("").toLowerCase(Locale.US);
      }

      return var1;
   }

   private void a(Map<IdManager.DeviceIdentifierType, String> var1, IdManager.DeviceIdentifierType var2, String var3) {
      if (var3 != null) {
         var1.put(var2, var3);
      }
   }

   private String b(String var1) {
      return var1.replaceAll(e, "");
   }

   public boolean a() {
      return this.i;
   }

   public String b() {
      String var2 = this.l;
      String var1 = var2;
      if (var2 == null) {
         SharedPreferences var3 = CommonUtils.a(this.j);
         var2 = var3.getString("crashlytics.installation.id", null);
         var1 = var2;
         if (var2 == null) {
            var1 = this.a(var3);
         }
      }

      return var1;
   }

   public String c() {
      return this.k;
   }

   public String d() {
      return this.e() + "/" + this.f();
   }

   public String e() {
      return this.b(VERSION.RELEASE);
   }

   public String f() {
      return this.b(VERSION.INCREMENTAL);
   }

   public String g() {
      return String.format(Locale.US, "%s/%s", this.b(Build.MANUFACTURER), this.b(Build.MODEL));
   }

   public String h() {
      String var1 = "";
      if (this.h) {
         String var2 = this.n();
         var1 = var2;
         if (var2 == null) {
            SharedPreferences var3 = CommonUtils.a(this.j);
            var2 = var3.getString("crashlytics.installation.id", null);
            var1 = var2;
            if (var2 == null) {
               var1 = this.a(var3);
            }
         }
      }

      return var1;
   }

   public Map<IdManager.DeviceIdentifierType, String> i() {
      HashMap var2 = new HashMap();

      for (Kit var3 : this.m) {
         if (var3 instanceof DeviceIdentifierProvider) {
            for (Entry var4 : ((DeviceIdentifierProvider)var3).e().entrySet()) {
               this.a(var2, (IdManager.DeviceIdentifierType)var4.getKey(), (String)var4.getValue());
            }
         }
      }

      this.a(var2, IdManager.DeviceIdentifierType.ANDROID_ID, this.n());
      this.a(var2, IdManager.DeviceIdentifierType.ANDROID_ADVERTISING_ID, this.m());
      return Collections.unmodifiableMap(var2);
   }

   public String j() {
      return this.g.a(this.j);
   }

   AdvertisingInfo k() {
      synchronized (this) {
         if (!this.c) {
            this.b = this.a.a();
            this.c = true;
         }

         return this.b;
      }
   }

   public Boolean l() {
      Object var2 = null;
      Boolean var1 = (Boolean)var2;
      if (this.h) {
         AdvertisingInfo var3 = this.k();
         var1 = (Boolean)var2;
         if (var3 != null) {
            var1 = var3.b;
         }
      }

      return var1;
   }

   public String m() {
      Object var2 = null;
      String var1 = (String)var2;
      if (this.h) {
         AdvertisingInfo var3 = this.k();
         var1 = (String)var2;
         if (var3 != null) {
            var1 = var3.a;
         }
      }

      return var1;
   }

   public String n() {
      Object var2 = null;
      String var1 = (String)var2;
      if (this.h) {
         String var3 = Secure.getString(this.j.getContentResolver(), "android_id");
         var1 = (String)var2;
         if (!"9774d56d682e549c".equals(var3)) {
            var1 = this.a(var3);
         }
      }

      return var1;
   }

   public enum DeviceIdentifierType {
      ANDROID_ADVERTISING_ID(103),
      ANDROID_DEVICE_ID(101),
      ANDROID_ID(100),
      ANDROID_SERIAL(102),
      BLUETOOTH_MAC_ADDRESS(2),
      FONT_TOKEN(53),
      WIFI_MAC_ADDRESS(1);

      private static final IdManager.DeviceIdentifierType[] $VALUES = new IdManager.DeviceIdentifierType[]{
         IdManager.DeviceIdentifierType.WIFI_MAC_ADDRESS,
         IdManager.DeviceIdentifierType.BLUETOOTH_MAC_ADDRESS,
         IdManager.DeviceIdentifierType.FONT_TOKEN,
         IdManager.DeviceIdentifierType.ANDROID_ID,
         IdManager.DeviceIdentifierType.ANDROID_DEVICE_ID,
         IdManager.DeviceIdentifierType.ANDROID_SERIAL,
         IdManager.DeviceIdentifierType.ANDROID_ADVERTISING_ID
      };
      public final int protobufIndex;

      DeviceIdentifierType(int var3) {
         this.protobufIndex = var3;
      }
   }
}
