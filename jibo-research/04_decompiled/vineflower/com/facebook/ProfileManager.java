package com.facebook;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;

final class ProfileManager {
   static final String ACTION_CURRENT_PROFILE_CHANGED = "com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED";
   static final String EXTRA_NEW_PROFILE = "com.facebook.sdk.EXTRA_NEW_PROFILE";
   static final String EXTRA_OLD_PROFILE = "com.facebook.sdk.EXTRA_OLD_PROFILE";
   private static volatile ProfileManager instance;
   private Profile currentProfile;
   private final LocalBroadcastManager localBroadcastManager;
   private final ProfileCache profileCache;

   ProfileManager(LocalBroadcastManager var1, ProfileCache var2) {
      Validate.notNull(var1, "localBroadcastManager");
      Validate.notNull(var2, "profileCache");
      this.localBroadcastManager = var1;
      this.profileCache = var2;
   }

   static ProfileManager getInstance() {
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
      // 00: getstatic com/facebook/ProfileManager.instance Lcom/facebook/ProfileManager;
      // 03: ifnonnull 2f
      // 06: ldc com/facebook/ProfileManager
      // 08: monitorenter
      // 09: getstatic com/facebook/ProfileManager.instance Lcom/facebook/ProfileManager;
      // 0c: ifnonnull 2c
      // 0f: invokestatic com/facebook/FacebookSdk.getApplicationContext ()Landroid/content/Context;
      // 12: invokestatic android/support/v4/content/LocalBroadcastManager.a (Landroid/content/Context;)Landroid/support/v4/content/LocalBroadcastManager;
      // 15: astore 1
      // 16: new com/facebook/ProfileManager
      // 19: astore 0
      // 1a: new com/facebook/ProfileCache
      // 1d: astore 2
      // 1e: aload 2
      // 1f: invokespecial com/facebook/ProfileCache.<init> ()V
      // 22: aload 0
      // 23: aload 1
      // 24: aload 2
      // 25: invokespecial com/facebook/ProfileManager.<init> (Landroid/support/v4/content/LocalBroadcastManager;Lcom/facebook/ProfileCache;)V
      // 28: aload 0
      // 29: putstatic com/facebook/ProfileManager.instance Lcom/facebook/ProfileManager;
      // 2c: ldc com/facebook/ProfileManager
      // 2e: monitorexit
      // 2f: getstatic com/facebook/ProfileManager.instance Lcom/facebook/ProfileManager;
      // 32: areturn
      // 33: astore 0
      // 34: ldc com/facebook/ProfileManager
      // 36: monitorexit
      // 37: aload 0
      // 38: athrow
      // try (4 -> 21): 25 null
      // try (21 -> 23): 25 null
      // try (26 -> 28): 25 null
   }

   private void sendCurrentProfileChangedBroadcast(Profile var1, Profile var2) {
      Intent var3 = new Intent("com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED");
      var3.putExtra("com.facebook.sdk.EXTRA_OLD_PROFILE", var1);
      var3.putExtra("com.facebook.sdk.EXTRA_NEW_PROFILE", var2);
      this.localBroadcastManager.a(var3);
   }

   private void setCurrentProfile(Profile var1, boolean var2) {
      Profile var3 = this.currentProfile;
      this.currentProfile = var1;
      if (var2) {
         if (var1 != null) {
            this.profileCache.save(var1);
         } else {
            this.profileCache.clear();
         }
      }

      if (!Utility.areObjectsEqual(var3, var1)) {
         this.sendCurrentProfileChangedBroadcast(var3, var1);
      }
   }

   Profile getCurrentProfile() {
      return this.currentProfile;
   }

   boolean loadCurrentProfile() {
      boolean var1 = false;
      Profile var2 = this.profileCache.load();
      if (var2 != null) {
         this.setCurrentProfile(var2, false);
         var1 = true;
      }

      return var1;
   }

   void setCurrentProfile(Profile var1) {
      this.setCurrentProfile(var1, true);
   }
}
