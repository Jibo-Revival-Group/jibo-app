package com.google.android.gms.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

final class zzchx extends zzcjl {
   static final Pair<String, Long> a = new Pair("", 0L);
   public final zzcib b = new zzcib(this, "health_monitor", Math.max(0L, zzchc.e.b()), null);
   public final zzcia c = new zzcia(this, "last_upload", 0L);
   public final zzcia d = new zzcia(this, "last_upload_attempt", 0L);
   public final zzcia e = new zzcia(this, "backoff", 0L);
   public final zzcia f = new zzcia(this, "last_delete_stale", 0L);
   public final zzcia g;
   public final zzcia h;
   public final zzcic i;
   public final zzcia j = new zzcia(this, "time_before_start", 10000L);
   public final zzcia k = new zzcia(this, "session_timeout", 1800000L);
   public final zzchz l = new zzchz(this, "start_new_session", true);
   public final zzcia m = new zzcia(this, "last_pause_time", 0L);
   public final zzcia n = new zzcia(this, "time_active", 0L);
   public boolean o;
   private SharedPreferences q;
   private String r;
   private boolean s;
   private long t;
   private String u;
   private long v;
   private final Object w;

   zzchx(zzcim var1) {
      super(var1);
      this.g = new zzcia(this, "midnight_offset", 0L);
      this.h = new zzcia(this, "first_open_time", 0L);
      this.i = new zzcic(this, "app_instance_id", null);
      this.w = new Object();
   }

   private final SharedPreferences D() {
      this.c();
      this.Q();
      return this.q;
   }

   final Boolean A() {
      this.c();
      Boolean var1;
      if (!this.D().contains("use_service")) {
         var1 = null;
      } else {
         var1 = this.D().getBoolean("use_service", false);
      }

      return var1;
   }

   final void B() {
      boolean var1 = true;
      this.c();
      this.t().E().a("Clearing collection preferences.");
      boolean var2 = this.D().contains("measurement_enabled");
      if (var2) {
         var1 = this.c(true);
      }

      Editor var3 = this.D().edit();
      var3.clear();
      var3.apply();
      if (var2) {
         this.b(var1);
      }
   }

   protected final String C() {
      this.c();
      String var2 = this.D().getString("previous_os_version", null);
      this.h().Q();
      String var3 = VERSION.RELEASE;
      if (!TextUtils.isEmpty(var3) && !var3.equals(var2)) {
         Editor var1 = this.D().edit();
         var1.putString("previous_os_version", var3);
         var1.apply();
      }

      return var2;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   final Pair<String, Boolean> a(String var1) {
      this.c();
      long var2 = this.k().b();
      Pair var8;
      if (this.r != null && var2 < this.t) {
         var8 = new Pair(this.r, this.s);
      } else {
         this.t = var2 + this.v().a(var1, zzchc.d);
         AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);

         label38: {
            try {
               var7 = AdvertisingIdClient.getAdvertisingIdInfo(this.l());
            } catch (Throwable var6) {
               this.t().D().a("Unable to get advertising id", var6);
               this.r = "";
               break label38;
            }

            if (var7 != null) {
               try {
                  this.r = var7.getId();
                  this.s = var7.isLimitAdTrackingEnabled();
               } catch (Throwable var5) {
                  this.t().D().a("Unable to get advertising id", var5);
                  this.r = "";
                  break label38;
               }
            }

            try {
               if (this.r == null) {
                  this.r = "";
               }
            } catch (Throwable var4) {
               this.t().D().a("Unable to get advertising id", var4);
               this.r = "";
            }
         }

         AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
         var8 = new Pair(this.r, this.s);
      }

      return var8;
   }

   final void a(boolean var1) {
      this.c();
      this.t().E().a("Setting useService", var1);
      Editor var2 = this.D().edit();
      var2.putBoolean("use_service", var1);
      var2.apply();
   }

   final String b(String var1) {
      this.c();
      String var2 = (String)this.a(var1).first;
      MessageDigest var3 = zzclq.g("MD5");
      if (var3 == null) {
         var1 = null;
      } else {
         var1 = String.format(Locale.US, "%032X", new BigInteger(1, var3.digest(var2.getBytes())));
      }

      return var1;
   }

   final void b(boolean var1) {
      this.c();
      this.t().E().a("Setting measurementEnabled", var1);
      Editor var2 = this.D().edit();
      var2.putBoolean("measurement_enabled", var1);
      var2.apply();
   }

   final void c(String var1) {
      this.c();
      Editor var2 = this.D().edit();
      var2.putString("gmp_app_id", var1);
      var2.apply();
   }

   final boolean c(boolean var1) {
      this.c();
      return this.D().getBoolean("measurement_enabled", var1);
   }

   final void d(String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.processStatement(ExprProcessor.java:119)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.getFinallyInformation(FinallyProcessor.java:136)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:84)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield com/google/android/gms/internal/zzchx.w Ljava/lang/Object;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 0
      // 08: aload 1
      // 09: putfield com/google/android/gms/internal/zzchx.u Ljava/lang/String;
      // 0c: aload 0
      // 0d: aload 0
      // 0e: invokevirtual com/google/android/gms/internal/zzcjk.k ()Lcom/google/android/gms/common/util/zzd;
      // 11: invokeinterface com/google/android/gms/common/util/zzd.b ()J 1
      // 16: putfield com/google/android/gms/internal/zzchx.v J
      // 19: aload 2
      // 1a: monitorexit
      // 1b: return
      // 1c: astore 1
      // 1d: aload 2
      // 1e: monitorexit
      // 1f: aload 1
      // 20: athrow
      // try (5 -> 15): 16 null
      // try (17 -> 19): 16 null
   }

   @Override
   protected final void d_() {
      this.q = this.l().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
      this.o = this.q.getBoolean("has_been_opened", false);
      if (!this.o) {
         Editor var1 = this.q.edit();
         var1.putBoolean("has_been_opened", true);
         var1.apply();
      }
   }

   @Override
   protected final boolean w() {
      return true;
   }

   final String y() {
      this.c();
      return this.D().getString("gmp_app_id", null);
   }

   final String z() {
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
      // 01: getfield com/google/android/gms/internal/zzchx.w Ljava/lang/Object;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 0
      // 08: invokevirtual com/google/android/gms/internal/zzcjk.k ()Lcom/google/android/gms/common/util/zzd;
      // 0b: invokeinterface com/google/android/gms/common/util/zzd.b ()J 1
      // 10: aload 0
      // 11: getfield com/google/android/gms/internal/zzchx.v J
      // 14: lsub
      // 15: invokestatic java/lang/Math.abs (J)J
      // 18: ldc2_w 1000
      // 1b: lcmp
      // 1c: ifge 28
      // 1f: aload 0
      // 20: getfield com/google/android/gms/internal/zzchx.u Ljava/lang/String;
      // 23: astore 1
      // 24: aload 2
      // 25: monitorexit
      // 26: aload 1
      // 27: areturn
      // 28: aconst_null
      // 29: astore 1
      // 2a: aload 2
      // 2b: monitorexit
      // 2c: goto 26
      // 2f: astore 1
      // 30: aload 2
      // 31: monitorexit
      // 32: aload 1
      // 33: athrow
      // try (5 -> 20): 27 null
      // try (24 -> 26): 27 null
      // try (28 -> 30): 27 null
   }
}
