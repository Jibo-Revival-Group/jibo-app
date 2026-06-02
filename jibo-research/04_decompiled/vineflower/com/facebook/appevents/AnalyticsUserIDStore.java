package com.facebook.appevents;

import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.AppEventUtility;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class AnalyticsUserIDStore {
   private static final String ANALYTICS_USER_ID_KEY = "com.facebook.appevents.AnalyticsUserIDStore.userID";
   private static final String TAG = AnalyticsUserIDStore.class.getSimpleName();
   private static volatile boolean initialized = false;
   private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
   private static String userID;

   public static String getUserID() {
      if (!initialized) {
         Log.w(TAG, "initStore should have been called before calling setUserID");
         initAndWait();
      }

      lock.readLock().lock();

      try {
         return userID;
      } finally {
         lock.readLock().unlock();
      }
   }

   private static void initAndWait() {
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
      // 00: getstatic com/facebook/appevents/AnalyticsUserIDStore.initialized Z
      // 03: ifeq 07
      // 06: return
      // 07: getstatic com/facebook/appevents/AnalyticsUserIDStore.lock Ljava/util/concurrent/locks/ReentrantReadWriteLock;
      // 0a: invokevirtual java/util/concurrent/locks/ReentrantReadWriteLock.writeLock ()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
      // 0d: invokevirtual java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock.lock ()V
      // 10: getstatic com/facebook/appevents/AnalyticsUserIDStore.initialized Z
      // 13: istore 0
      // 14: iload 0
      // 15: ifeq 24
      // 18: getstatic com/facebook/appevents/AnalyticsUserIDStore.lock Ljava/util/concurrent/locks/ReentrantReadWriteLock;
      // 1b: invokevirtual java/util/concurrent/locks/ReentrantReadWriteLock.writeLock ()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
      // 1e: invokevirtual java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock.unlock ()V
      // 21: goto 06
      // 24: invokestatic com/facebook/FacebookSdk.getApplicationContext ()Landroid/content/Context;
      // 27: invokestatic android/preference/PreferenceManager.getDefaultSharedPreferences (Landroid/content/Context;)Landroid/content/SharedPreferences;
      // 2a: ldc "com.facebook.appevents.AnalyticsUserIDStore.userID"
      // 2c: aconst_null
      // 2d: invokeinterface android/content/SharedPreferences.getString (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; 3
      // 32: putstatic com/facebook/appevents/AnalyticsUserIDStore.userID Ljava/lang/String;
      // 35: bipush 1
      // 36: putstatic com/facebook/appevents/AnalyticsUserIDStore.initialized Z
      // 39: getstatic com/facebook/appevents/AnalyticsUserIDStore.lock Ljava/util/concurrent/locks/ReentrantReadWriteLock;
      // 3c: invokevirtual java/util/concurrent/locks/ReentrantReadWriteLock.writeLock ()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
      // 3f: invokevirtual java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock.unlock ()V
      // 42: goto 06
      // 45: astore 1
      // 46: getstatic com/facebook/appevents/AnalyticsUserIDStore.lock Ljava/util/concurrent/locks/ReentrantReadWriteLock;
      // 49: invokevirtual java/util/concurrent/locks/ReentrantReadWriteLock.writeLock ()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
      // 4c: invokevirtual java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock.unlock ()V
      // 4f: aload 1
      // 50: athrow
      // try (6 -> 8): 26 null
      // try (14 -> 22): 26 null
   }

   public static void initStore() {
      if (!initialized) {
         AppEventsLogger.getAnalyticsExecutor().execute(new Runnable() {
            @Override
            public void run() {
               AnalyticsUserIDStore.initAndWait();
            }
         });
      }
   }

   public static void setUserID(String var0) {
      AppEventUtility.assertIsNotMainThread();
      if (!initialized) {
         Log.w(TAG, "initStore should have been called before calling setUserID");
         initAndWait();
      }

      AppEventsLogger.getAnalyticsExecutor().execute(new Runnable(var0) {
         final String val$id;

         {
            this.val$id = var1;
         }

         @Override
         public void run() {
            AnalyticsUserIDStore.lock.writeLock().lock();

            try {
               AnalyticsUserIDStore.userID = this.val$id;
               Editor var1 = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
               var1.putString("com.facebook.appevents.AnalyticsUserIDStore.userID", AnalyticsUserIDStore.userID);
               var1.apply();
            } finally {
               AnalyticsUserIDStore.lock.writeLock().unlock();
            }
         }
      });
   }
}
