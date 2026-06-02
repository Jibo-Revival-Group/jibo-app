package com.crashlytics.android.beta;

import android.annotation.SuppressLint;
import android.content.Context;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.common.ApiKey;
import io.fabric.sdk.android.services.common.CurrentTimeProvider;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.persistence.PreferenceStore;
import io.fabric.sdk.android.services.settings.BetaSettingsData;
import java.util.concurrent.atomic.AtomicBoolean;

abstract class AbstractCheckForUpdatesController implements UpdatesController {
   private final AtomicBoolean a = new AtomicBoolean();
   private final AtomicBoolean b;
   private Context c;
   private Beta d;
   private IdManager e;
   private BetaSettingsData f;
   private BuildProperties g;
   private PreferenceStore h;
   private CurrentTimeProvider i;
   private HttpRequestFactory j;
   private long k = 0L;

   public AbstractCheckForUpdatesController() {
      this(false);
   }

   public AbstractCheckForUpdatesController(boolean var1) {
      this.b = new AtomicBoolean(var1);
   }

   private void e() {
      Fabric.h().a("Beta", "Performing update check");
      String var1 = new ApiKey().a(this.c);
      String var2 = this.e.i().get(IdManager.DeviceIdentifierType.FONT_TOKEN);
      new CheckForUpdatesRequest(this.d, this.d.g(), this.f.a, this.j, new CheckForUpdatesResponseTransform()).a(var1, var2, this.g);
   }

   void a(long var1) {
      this.k = var1;
   }

   @Override
   public void a(
      Context var1,
      Beta var2,
      IdManager var3,
      BetaSettingsData var4,
      BuildProperties var5,
      PreferenceStore var6,
      CurrentTimeProvider var7,
      HttpRequestFactory var8
   ) {
      this.c = var1;
      this.d = var2;
      this.e = var3;
      this.f = var4;
      this.g = var5;
      this.h = var6;
      this.i = var7;
      this.j = var8;
      if (this.b()) {
         this.c();
      }
   }

   protected boolean a() {
      this.b.set(true);
      return this.a.get();
   }

   boolean b() {
      this.a.set(true);
      return this.b.get();
   }

   @SuppressLint("CommitPrefEdits")
   protected void c() {
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
      // 01: getfield com/crashlytics/android/beta/AbstractCheckForUpdatesController.h Lio/fabric/sdk/android/services/persistence/PreferenceStore;
      // 04: astore 6
      // 06: aload 6
      // 08: monitorenter
      // 09: aload 0
      // 0a: getfield com/crashlytics/android/beta/AbstractCheckForUpdatesController.h Lio/fabric/sdk/android/services/persistence/PreferenceStore;
      // 0d: invokeinterface io/fabric/sdk/android/services/persistence/PreferenceStore.a ()Landroid/content/SharedPreferences; 1
      // 12: ldc "last_update_check"
      // 14: invokeinterface android/content/SharedPreferences.contains (Ljava/lang/String;)Z 2
      // 19: ifeq 36
      // 1c: aload 0
      // 1d: getfield com/crashlytics/android/beta/AbstractCheckForUpdatesController.h Lio/fabric/sdk/android/services/persistence/PreferenceStore;
      // 20: aload 0
      // 21: getfield com/crashlytics/android/beta/AbstractCheckForUpdatesController.h Lio/fabric/sdk/android/services/persistence/PreferenceStore;
      // 24: invokeinterface io/fabric/sdk/android/services/persistence/PreferenceStore.b ()Landroid/content/SharedPreferences$Editor; 1
      // 29: ldc "last_update_check"
      // 2b: invokeinterface android/content/SharedPreferences$Editor.remove (Ljava/lang/String;)Landroid/content/SharedPreferences$Editor; 2
      // 30: invokeinterface io/fabric/sdk/android/services/persistence/PreferenceStore.a (Landroid/content/SharedPreferences$Editor;)Z 2
      // 35: pop
      // 36: aload 6
      // 38: monitorexit
      // 39: aload 0
      // 3a: getfield com/crashlytics/android/beta/AbstractCheckForUpdatesController.i Lio/fabric/sdk/android/services/common/CurrentTimeProvider;
      // 3d: invokeinterface io/fabric/sdk/android/services/common/CurrentTimeProvider.a ()J 1
      // 42: lstore 1
      // 43: aload 0
      // 44: getfield com/crashlytics/android/beta/AbstractCheckForUpdatesController.f Lio/fabric/sdk/android/services/settings/BetaSettingsData;
      // 47: getfield io/fabric/sdk/android/services/settings/BetaSettingsData.b I
      // 4a: i2l
      // 4b: ldc2_w 1000
      // 4e: lmul
      // 4f: lstore 3
      // 50: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 53: ldc "Beta"
      // 55: new java/lang/StringBuilder
      // 58: dup
      // 59: invokespecial java/lang/StringBuilder.<init> ()V
      // 5c: ldc "Check for updates delay: "
      // 5e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 61: lload 3
      // 62: invokevirtual java/lang/StringBuilder.append (J)Ljava/lang/StringBuilder;
      // 65: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 68: invokeinterface io/fabric/sdk/android/Logger.a (Ljava/lang/String;Ljava/lang/String;)V 3
      // 6d: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 70: ldc "Beta"
      // 72: new java/lang/StringBuilder
      // 75: dup
      // 76: invokespecial java/lang/StringBuilder.<init> ()V
      // 79: ldc "Check for updates last check time: "
      // 7b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 7e: aload 0
      // 7f: invokevirtual com/crashlytics/android/beta/AbstractCheckForUpdatesController.d ()J
      // 82: invokevirtual java/lang/StringBuilder.append (J)Ljava/lang/StringBuilder;
      // 85: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 88: invokeinterface io/fabric/sdk/android/Logger.a (Ljava/lang/String;Ljava/lang/String;)V 3
      // 8d: lload 3
      // 8e: aload 0
      // 8f: invokevirtual com/crashlytics/android/beta/AbstractCheckForUpdatesController.d ()J
      // 92: ladd
      // 93: lstore 3
      // 94: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 97: ldc "Beta"
      // 99: new java/lang/StringBuilder
      // 9c: dup
      // 9d: invokespecial java/lang/StringBuilder.<init> ()V
      // a0: ldc "Check for updates current time: "
      // a2: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // a5: lload 1
      // a6: invokevirtual java/lang/StringBuilder.append (J)Ljava/lang/StringBuilder;
      // a9: ldc ", next check time: "
      // ab: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // ae: lload 3
      // af: invokevirtual java/lang/StringBuilder.append (J)Ljava/lang/StringBuilder;
      // b2: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // b5: invokeinterface io/fabric/sdk/android/Logger.a (Ljava/lang/String;Ljava/lang/String;)V 3
      // ba: lload 1
      // bb: lload 3
      // bc: lcmp
      // bd: iflt dc
      // c0: aload 0
      // c1: invokespecial com/crashlytics/android/beta/AbstractCheckForUpdatesController.e ()V
      // c4: aload 0
      // c5: lload 1
      // c6: invokevirtual com/crashlytics/android/beta/AbstractCheckForUpdatesController.a (J)V
      // c9: return
      // ca: astore 5
      // cc: aload 6
      // ce: monitorexit
      // cf: aload 5
      // d1: athrow
      // d2: astore 5
      // d4: aload 0
      // d5: lload 1
      // d6: invokevirtual com/crashlytics/android/beta/AbstractCheckForUpdatesController.a (J)V
      // d9: aload 5
      // db: athrow
      // dc: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // df: ldc "Beta"
      // e1: ldc "Check for updates next check time was not passed"
      // e3: invokeinterface io/fabric/sdk/android/Logger.a (Ljava/lang/String;Ljava/lang/String;)V 3
      // e8: goto c9
      // try (5 -> 20): 86 null
      // try (20 -> 22): 86 null
      // try (80 -> 82): 91 null
      // try (87 -> 89): 86 null
   }

   long d() {
      return this.k;
   }
}
