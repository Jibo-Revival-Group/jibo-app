package com.facebook;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Base64;
import android.util.Log;
import com.facebook.internal.LockOnGetVariable;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class FacebookSdk {
   public static final String APPLICATION_ID_PROPERTY = "com.facebook.sdk.ApplicationId";
   public static final String APPLICATION_NAME_PROPERTY = "com.facebook.sdk.ApplicationName";
   private static final String ATTRIBUTION_PREFERENCES = "com.facebook.sdk.attributionTracking";
   public static final String AUTO_LOG_APP_EVENTS_ENABLED_PROPERTY = "com.facebook.sdk.AutoLogAppEventsEnabled";
   static final String CALLBACK_OFFSET_CHANGED_AFTER_INIT = "The callback request code offset can't be updated once the SDK is initialized. Call FacebookSdk.setCallbackRequestCodeOffset inside your Application.onCreate method";
   static final String CALLBACK_OFFSET_NEGATIVE = "The callback request code offset can't be negative.";
   public static final String CALLBACK_OFFSET_PROPERTY = "com.facebook.sdk.CallbackOffset";
   public static final String CLIENT_TOKEN_PROPERTY = "com.facebook.sdk.ClientToken";
   private static final int DEFAULT_CALLBACK_REQUEST_CODE_OFFSET = 64206;
   private static final int DEFAULT_CORE_POOL_SIZE = 5;
   private static final int DEFAULT_KEEP_ALIVE = 1;
   private static final int DEFAULT_MAXIMUM_POOL_SIZE = 128;
   private static final int DEFAULT_THEME = R.style.com_facebook_activity_theme;
   private static final ThreadFactory DEFAULT_THREAD_FACTORY = new ThreadFactory() {
      private final AtomicInteger counter = new AtomicInteger(0);

      @Override
      public Thread newThread(Runnable var1) {
         return new Thread(var1, "FacebookSdk #" + this.counter.incrementAndGet());
      }
   };
   private static final BlockingQueue<Runnable> DEFAULT_WORK_QUEUE = new LinkedBlockingQueue<>(10);
   private static final String FACEBOOK_COM = "facebook.com";
   private static final Object LOCK = new Object();
   private static final int MAX_REQUEST_CODE_RANGE = 100;
   private static final String PUBLISH_ACTIVITY_PATH = "%s/activities";
   private static final String TAG = FacebookSdk.class.getCanonicalName();
   public static final String WEB_DIALOG_THEME = "com.facebook.sdk.WebDialogTheme";
   private static volatile String appClientToken;
   private static Context applicationContext;
   private static volatile String applicationId;
   private static volatile String applicationName;
   private static volatile Boolean autoLogAppEventsEnabled;
   private static LockOnGetVariable<File> cacheDir;
   private static int callbackRequestCodeOffset = 64206;
   private static volatile Executor executor;
   private static volatile String facebookDomain = "facebook.com";
   private static String graphApiVersion = ServerProtocol.getDefaultAPIVersion();
   private static volatile boolean isDebugEnabled = false;
   private static boolean isLegacyTokenUpgradeSupported = false;
   private static final HashSet<LoggingBehavior> loggingBehaviors = new HashSet<>(Arrays.asList(LoggingBehavior.DEVELOPER_ERRORS));
   private static AtomicLong onProgressThreshold = new AtomicLong(65536L);
   private static Boolean sdkInitialized = false;
   private static volatile int webDialogTheme;

   public static void addLoggingBehavior(LoggingBehavior param0) {
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
      // 00: getstatic com/facebook/FacebookSdk.loggingBehaviors Ljava/util/HashSet;
      // 03: astore 1
      // 04: aload 1
      // 05: monitorenter
      // 06: getstatic com/facebook/FacebookSdk.loggingBehaviors Ljava/util/HashSet;
      // 09: aload 0
      // 0a: invokevirtual java/util/HashSet.add (Ljava/lang/Object;)Z
      // 0d: pop
      // 0e: invokestatic com/facebook/FacebookSdk.updateGraphDebugBehavior ()V
      // 11: aload 1
      // 12: monitorexit
      // 13: return
      // 14: astore 0
      // 15: aload 1
      // 16: monitorexit
      // 17: aload 0
      // 18: athrow
      // try (4 -> 11): 12 null
      // try (13 -> 15): 12 null
   }

   public static void clearLoggingBehaviors() {
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
      // 00: getstatic com/facebook/FacebookSdk.loggingBehaviors Ljava/util/HashSet;
      // 03: astore 1
      // 04: aload 1
      // 05: monitorenter
      // 06: getstatic com/facebook/FacebookSdk.loggingBehaviors Ljava/util/HashSet;
      // 09: invokevirtual java/util/HashSet.clear ()V
      // 0c: aload 1
      // 0d: monitorexit
      // 0e: return
      // 0f: astore 0
      // 10: aload 1
      // 11: monitorexit
      // 12: aload 0
      // 13: athrow
      // try (4 -> 8): 9 null
      // try (10 -> 12): 9 null
   }

   public static Context getApplicationContext() {
      Validate.sdkInitialized();
      return applicationContext;
   }

   public static String getApplicationId() {
      Validate.sdkInitialized();
      return applicationId;
   }

   public static String getApplicationName() {
      Validate.sdkInitialized();
      return applicationName;
   }

   public static String getApplicationSignature(Context var0) {
      Object var2 = null;
      Validate.sdkInitialized();
      String var1;
      if (var0 == null) {
         var1 = (String)var2;
      } else {
         PackageManager var3 = var0.getPackageManager();
         var1 = (String)var2;
         if (var3 != null) {
            String var6 = var0.getPackageName();

            try {
               var7 = var3.getPackageInfo(var6, 64);
            } catch (NameNotFoundException var5) {
               var1 = (String)var2;
               return var1;
            }

            Signature[] var9 = var7.signatures;
            var1 = (String)var2;
            if (var9 != null) {
               var1 = (String)var2;
               if (var9.length != 0) {
                  try {
                     var8 = MessageDigest.getInstance("SHA-1");
                  } catch (NoSuchAlgorithmException var4) {
                     var1 = (String)var2;
                     return var1;
                  }

                  var8.update(var7.signatures[0].toByteArray());
                  var1 = Base64.encodeToString(var8.digest(), 9);
               }
            }
         }
      }

      return var1;
   }

   public static boolean getAutoLogAppEventsEnabled() {
      Validate.sdkInitialized();
      return autoLogAppEventsEnabled;
   }

   public static File getCacheDir() {
      Validate.sdkInitialized();
      return cacheDir.getValue();
   }

   public static int getCallbackRequestCodeOffset() {
      Validate.sdkInitialized();
      return callbackRequestCodeOffset;
   }

   public static String getClientToken() {
      Validate.sdkInitialized();
      return appClientToken;
   }

   public static Executor getExecutor() {
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
      // 00: getstatic com/facebook/FacebookSdk.LOCK Ljava/lang/Object;
      // 03: astore 0
      // 04: aload 0
      // 05: monitorenter
      // 06: getstatic com/facebook/FacebookSdk.executor Ljava/util/concurrent/Executor;
      // 09: ifnonnull 12
      // 0c: getstatic android/os/AsyncTask.THREAD_POOL_EXECUTOR Ljava/util/concurrent/Executor;
      // 0f: putstatic com/facebook/FacebookSdk.executor Ljava/util/concurrent/Executor;
      // 12: aload 0
      // 13: monitorexit
      // 14: getstatic com/facebook/FacebookSdk.executor Ljava/util/concurrent/Executor;
      // 17: areturn
      // 18: astore 1
      // 19: aload 0
      // 1a: monitorexit
      // 1b: aload 1
      // 1c: athrow
      // try (4 -> 8): 12 null
      // try (8 -> 10): 12 null
      // try (13 -> 15): 12 null
   }

   public static String getFacebookDomain() {
      return facebookDomain;
   }

   public static String getGraphApiVersion() {
      return graphApiVersion;
   }

   public static boolean getLimitEventAndDataUsage(Context var0) {
      Validate.sdkInitialized();
      return var0.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getBoolean("limitEventUsage", false);
   }

   public static Set<LoggingBehavior> getLoggingBehaviors() {
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
      // 00: getstatic com/facebook/FacebookSdk.loggingBehaviors Ljava/util/HashSet;
      // 03: astore 0
      // 04: aload 0
      // 05: monitorenter
      // 06: new java/util/HashSet
      // 09: astore 1
      // 0a: aload 1
      // 0b: getstatic com/facebook/FacebookSdk.loggingBehaviors Ljava/util/HashSet;
      // 0e: invokespecial java/util/HashSet.<init> (Ljava/util/Collection;)V
      // 11: aload 1
      // 12: invokestatic java/util/Collections.unmodifiableSet (Ljava/util/Set;)Ljava/util/Set;
      // 15: astore 1
      // 16: aload 0
      // 17: monitorexit
      // 18: aload 1
      // 19: areturn
      // 1a: astore 1
      // 1b: aload 0
      // 1c: monitorexit
      // 1d: aload 1
      // 1e: athrow
      // try (4 -> 14): 16 null
      // try (17 -> 19): 16 null
   }

   public static long getOnProgressThreshold() {
      Validate.sdkInitialized();
      return onProgressThreshold.get();
   }

   public static String getSdkVersion() {
      return "4.20.0";
   }

   public static int getWebDialogTheme() {
      Validate.sdkInitialized();
      return webDialogTheme;
   }

   public static boolean isDebugEnabled() {
      return isDebugEnabled;
   }

   public static boolean isFacebookRequestCode(int var0) {
      boolean var1;
      if (var0 >= callbackRequestCodeOffset && var0 < callbackRequestCodeOffset + 100) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public static boolean isInitialized() {
      synchronized (FacebookSdk.class) {
         return sdkInitialized;
      }
   }

   public static boolean isLegacyTokenUpgradeSupported() {
      return isLegacyTokenUpgradeSupported;
   }

   public static boolean isLoggingBehaviorEnabled(LoggingBehavior param0) {
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
      // 00: getstatic com/facebook/FacebookSdk.loggingBehaviors Ljava/util/HashSet;
      // 03: astore 2
      // 04: aload 2
      // 05: monitorenter
      // 06: invokestatic com/facebook/FacebookSdk.isDebugEnabled ()Z
      // 09: ifeq 1c
      // 0c: getstatic com/facebook/FacebookSdk.loggingBehaviors Ljava/util/HashSet;
      // 0f: aload 0
      // 10: invokevirtual java/util/HashSet.contains (Ljava/lang/Object;)Z
      // 13: ifeq 1c
      // 16: bipush 1
      // 17: istore 1
      // 18: aload 2
      // 19: monitorexit
      // 1a: iload 1
      // 1b: ireturn
      // 1c: bipush 0
      // 1d: istore 1
      // 1e: goto 18
      // 21: astore 0
      // 22: aload 2
      // 23: monitorexit
      // 24: aload 0
      // 25: athrow
      // try (4 -> 10): 19 null
      // try (12 -> 14): 19 null
      // try (20 -> 22): 19 null
   }

   static void loadDefaultsFromMetadata(Context var0) {
      if (var0 != null) {
         try {
            var3 = var0.getPackageManager().getApplicationInfo(var0.getPackageName(), 128);
         } catch (NameNotFoundException var2) {
            return;
         }

         if (var3 != null && var3.metaData != null) {
            if (applicationId == null) {
               String var1 = (String)var3.metaData.get("com.facebook.sdk.ApplicationId");
               if (var1 instanceof String) {
                  var1 = var1;
                  if (var1.toLowerCase(Locale.ROOT).startsWith("fb")) {
                     applicationId = var1.substring(2);
                  } else {
                     applicationId = var1;
                  }
               } else if (var1 instanceof Integer) {
                  throw new FacebookException(
                     "App Ids cannot be directly placed in the manifest.They must be prefixed by 'fb' or be placed in the string resource file."
                  );
               }
            }

            if (applicationName == null) {
               applicationName = var3.metaData.getString("com.facebook.sdk.ApplicationName");
            }

            if (appClientToken == null) {
               appClientToken = var3.metaData.getString("com.facebook.sdk.ClientToken");
            }

            if (webDialogTheme == 0) {
               setWebDialogTheme(var3.metaData.getInt("com.facebook.sdk.WebDialogTheme"));
            }

            if (callbackRequestCodeOffset == 64206) {
               callbackRequestCodeOffset = var3.metaData.getInt("com.facebook.sdk.CallbackOffset", 64206);
            }

            if (autoLogAppEventsEnabled == null) {
               autoLogAppEventsEnabled = var3.metaData.getBoolean("com.facebook.sdk.AutoLogAppEventsEnabled", true);
            }
         }
      }
   }

   static GraphResponse publishInstallAndWaitForResponse(Context param0, String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aload 0
      // 001: ifnull 008
      // 004: aload 1
      // 005: ifnonnull 032
      // 008: new java/lang/IllegalArgumentException
      // 00b: astore 0
      // 00c: aload 0
      // 00d: ldc_w "Both context and applicationId must be non-null"
      // 010: invokespecial java/lang/IllegalArgumentException.<init> (Ljava/lang/String;)V
      // 013: aload 0
      // 014: athrow
      // 015: astore 0
      // 016: ldc_w "Facebook-publish"
      // 019: aload 0
      // 01a: invokestatic com/facebook/internal/Utility.logd (Ljava/lang/String;Ljava/lang/Exception;)V
      // 01d: new com/facebook/GraphResponse
      // 020: dup
      // 021: aconst_null
      // 022: aconst_null
      // 023: new com/facebook/FacebookRequestError
      // 026: dup
      // 027: aconst_null
      // 028: aload 0
      // 029: invokespecial com/facebook/FacebookRequestError.<init> (Ljava/net/HttpURLConnection;Ljava/lang/Exception;)V
      // 02c: invokespecial com/facebook/GraphResponse.<init> (Lcom/facebook/GraphRequest;Ljava/net/HttpURLConnection;Lcom/facebook/FacebookRequestError;)V
      // 02f: astore 0
      // 030: aload 0
      // 031: areturn
      // 032: aload 0
      // 033: invokestatic com/facebook/internal/AttributionIdentifiers.getAttributionIdentifiers (Landroid/content/Context;)Lcom/facebook/internal/AttributionIdentifiers;
      // 036: astore 8
      // 038: aload 0
      // 039: ldc "com.facebook.sdk.attributionTracking"
      // 03b: bipush 0
      // 03c: invokevirtual android/content/Context.getSharedPreferences (Ljava/lang/String;I)Landroid/content/SharedPreferences;
      // 03f: astore 5
      // 041: new java/lang/StringBuilder
      // 044: astore 4
      // 046: aload 4
      // 048: invokespecial java/lang/StringBuilder.<init> ()V
      // 04b: aload 4
      // 04d: aload 1
      // 04e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 051: ldc_w "ping"
      // 054: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 057: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 05a: astore 4
      // 05c: new java/lang/StringBuilder
      // 05f: astore 6
      // 061: aload 6
      // 063: invokespecial java/lang/StringBuilder.<init> ()V
      // 066: aload 6
      // 068: aload 1
      // 069: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 06c: ldc_w "json"
      // 06f: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 072: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 075: astore 6
      // 077: aload 5
      // 079: aload 4
      // 07b: lconst_0
      // 07c: invokeinterface android/content/SharedPreferences.getLong (Ljava/lang/String;J)J 4
      // 081: lstore 2
      // 082: aload 5
      // 084: aload 6
      // 086: aconst_null
      // 087: invokeinterface android/content/SharedPreferences.getString (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; 3
      // 08c: astore 7
      // 08e: getstatic com/facebook/internal/AppEventsLoggerUtility$GraphAPIActivityType.MOBILE_INSTALL_EVENT Lcom/facebook/internal/AppEventsLoggerUtility$GraphAPIActivityType;
      // 091: aload 8
      // 093: aload 0
      // 094: invokestatic com/facebook/appevents/AppEventsLogger.getAnonymousAppDeviceGUID (Landroid/content/Context;)Ljava/lang/String;
      // 097: aload 0
      // 098: invokestatic com/facebook/FacebookSdk.getLimitEventAndDataUsage (Landroid/content/Context;)Z
      // 09b: aload 0
      // 09c: invokestatic com/facebook/internal/AppEventsLoggerUtility.getJSONObjectForGraphAPICall (Lcom/facebook/internal/AppEventsLoggerUtility$GraphAPIActivityType;Lcom/facebook/internal/AttributionIdentifiers;Ljava/lang/String;ZLandroid/content/Context;)Lorg/json/JSONObject;
      // 09f: astore 0
      // 0a0: aconst_null
      // 0a1: ldc "%s/activities"
      // 0a3: bipush 1
      // 0a4: anewarray 4
      // 0a7: dup
      // 0a8: bipush 0
      // 0a9: aload 1
      // 0aa: aastore
      // 0ab: invokestatic java/lang/String.format (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      // 0ae: aload 0
      // 0af: aconst_null
      // 0b0: invokestatic com/facebook/GraphRequest.newPostRequest (Lcom/facebook/AccessToken;Ljava/lang/String;Lorg/json/JSONObject;Lcom/facebook/GraphRequest$Callback;)Lcom/facebook/GraphRequest;
      // 0b3: astore 1
      // 0b4: lload 2
      // 0b5: lconst_0
      // 0b6: lcmp
      // 0b7: ifeq 116
      // 0ba: aload 7
      // 0bc: ifnull 14f
      // 0bf: new org/json/JSONObject
      // 0c2: astore 0
      // 0c3: aload 0
      // 0c4: aload 7
      // 0c6: invokespecial org/json/JSONObject.<init> (Ljava/lang/String;)V
      // 0c9: aload 0
      // 0ca: ifnonnull 107
      // 0cd: new com/facebook/GraphRequestBatch
      // 0d0: astore 0
      // 0d1: aload 0
      // 0d2: bipush 1
      // 0d3: anewarray 486
      // 0d6: dup
      // 0d7: bipush 0
      // 0d8: aload 1
      // 0d9: aastore
      // 0da: invokespecial com/facebook/GraphRequestBatch.<init> ([Lcom/facebook/GraphRequest;)V
      // 0dd: ldc_w "true"
      // 0e0: aconst_null
      // 0e1: aload 0
      // 0e2: invokestatic com/facebook/GraphResponse.createResponsesFromString (Ljava/lang/String;Ljava/net/HttpURLConnection;Lcom/facebook/GraphRequestBatch;)Ljava/util/List;
      // 0e5: bipush 0
      // 0e6: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 0eb: checkcast com/facebook/GraphResponse
      // 0ee: astore 0
      // 0ef: goto 030
      // 0f2: astore 0
      // 0f3: new com/facebook/FacebookException
      // 0f6: astore 1
      // 0f7: aload 1
      // 0f8: ldc_w "An error occurred while publishing install."
      // 0fb: aload 0
      // 0fc: invokespecial com/facebook/FacebookException.<init> (Ljava/lang/String;Ljava/lang/Throwable;)V
      // 0ff: aload 1
      // 100: athrow
      // 101: astore 0
      // 102: aconst_null
      // 103: astore 0
      // 104: goto 0c9
      // 107: new com/facebook/GraphResponse
      // 10a: dup
      // 10b: aconst_null
      // 10c: aconst_null
      // 10d: aconst_null
      // 10e: aload 0
      // 10f: invokespecial com/facebook/GraphResponse.<init> (Lcom/facebook/GraphRequest;Ljava/net/HttpURLConnection;Ljava/lang/String;Lorg/json/JSONObject;)V
      // 112: astore 0
      // 113: goto 030
      // 116: aload 1
      // 117: invokevirtual com/facebook/GraphRequest.executeAndWait ()Lcom/facebook/GraphResponse;
      // 11a: astore 0
      // 11b: aload 5
      // 11d: invokeinterface android/content/SharedPreferences.edit ()Landroid/content/SharedPreferences$Editor; 1
      // 122: astore 1
      // 123: aload 1
      // 124: aload 4
      // 126: invokestatic java/lang/System.currentTimeMillis ()J
      // 129: invokeinterface android/content/SharedPreferences$Editor.putLong (Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor; 4
      // 12e: pop
      // 12f: aload 0
      // 130: invokevirtual com/facebook/GraphResponse.getJSONObject ()Lorg/json/JSONObject;
      // 133: ifnull 146
      // 136: aload 1
      // 137: aload 6
      // 139: aload 0
      // 13a: invokevirtual com/facebook/GraphResponse.getJSONObject ()Lorg/json/JSONObject;
      // 13d: invokevirtual org/json/JSONObject.toString ()Ljava/lang/String;
      // 140: invokeinterface android/content/SharedPreferences$Editor.putString (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor; 3
      // 145: pop
      // 146: aload 1
      // 147: invokeinterface android/content/SharedPreferences$Editor.apply ()V 1
      // 14c: goto 030
      // 14f: aconst_null
      // 150: astore 0
      // 151: goto 0c9
      // try (4 -> 11): 11 java/lang/Exception
      // try (28 -> 68): 11 java/lang/Exception
      // try (68 -> 77): 122 org/json/JSONException
      // try (68 -> 77): 11 java/lang/Exception
      // try (77 -> 90): 11 java/lang/Exception
      // try (96 -> 101): 131 org/json/JSONException
      // try (96 -> 101): 11 java/lang/Exception
      // try (103 -> 121): 11 java/lang/Exception
      // try (123 -> 131): 11 java/lang/Exception
      // try (135 -> 143): 11 java/lang/Exception
      // try (144 -> 165): 11 java/lang/Exception
      // try (165 -> 167): 11 java/lang/Exception
   }

   public static void publishInstallAsync(Context var0, String var1) {
      var0 = var0.getApplicationContext();
      getExecutor().execute(new Runnable(var0, var1) {
         final Context val$applicationContext;
         final String val$applicationId;

         {
            this.val$applicationContext = var1;
            this.val$applicationId = var2;
         }

         @Override
         public void run() {
            FacebookSdk.publishInstallAndWaitForResponse(this.val$applicationContext, this.val$applicationId);
         }
      });
   }

   public static void removeLoggingBehavior(LoggingBehavior param0) {
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
      // 00: getstatic com/facebook/FacebookSdk.loggingBehaviors Ljava/util/HashSet;
      // 03: astore 1
      // 04: aload 1
      // 05: monitorenter
      // 06: getstatic com/facebook/FacebookSdk.loggingBehaviors Ljava/util/HashSet;
      // 09: aload 0
      // 0a: invokevirtual java/util/HashSet.remove (Ljava/lang/Object;)Z
      // 0d: pop
      // 0e: aload 1
      // 0f: monitorexit
      // 10: return
      // 11: astore 0
      // 12: aload 1
      // 13: monitorexit
      // 14: aload 0
      // 15: athrow
      // try (4 -> 10): 11 null
      // try (12 -> 14): 11 null
   }

   @Deprecated
   public static void sdkInitialize(Context var0) {
      synchronized (FacebookSdk.class) {
         sdkInitialize(var0, null);
      }
   }

   @Deprecated
   public static void sdkInitialize(Context var0, int var1) {
      synchronized (FacebookSdk.class) {
         sdkInitialize(var0, var1, null);
      }
   }

   @Deprecated
   public static void sdkInitialize(Context param0, int param1, FacebookSdk.InitializeCallback param2) {
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
      // 00: ldc com/facebook/FacebookSdk
      // 02: monitorenter
      // 03: getstatic com/facebook/FacebookSdk.sdkInitialized Ljava/lang/Boolean;
      // 06: invokevirtual java/lang/Boolean.booleanValue ()Z
      // 09: ifeq 25
      // 0c: iload 1
      // 0d: getstatic com/facebook/FacebookSdk.callbackRequestCodeOffset I
      // 10: if_icmpeq 25
      // 13: new com/facebook/FacebookException
      // 16: astore 0
      // 17: aload 0
      // 18: ldc "The callback request code offset can't be updated once the SDK is initialized. Call FacebookSdk.setCallbackRequestCodeOffset inside your Application.onCreate method"
      // 1a: invokespecial com/facebook/FacebookException.<init> (Ljava/lang/String;)V
      // 1d: aload 0
      // 1e: athrow
      // 1f: astore 0
      // 20: ldc com/facebook/FacebookSdk
      // 22: monitorexit
      // 23: aload 0
      // 24: athrow
      // 25: iload 1
      // 26: ifge 35
      // 29: new com/facebook/FacebookException
      // 2c: astore 0
      // 2d: aload 0
      // 2e: ldc "The callback request code offset can't be negative."
      // 30: invokespecial com/facebook/FacebookException.<init> (Ljava/lang/String;)V
      // 33: aload 0
      // 34: athrow
      // 35: iload 1
      // 36: putstatic com/facebook/FacebookSdk.callbackRequestCodeOffset I
      // 39: aload 0
      // 3a: aload 2
      // 3b: invokestatic com/facebook/FacebookSdk.sdkInitialize (Landroid/content/Context;Lcom/facebook/FacebookSdk$InitializeCallback;)V
      // 3e: ldc com/facebook/FacebookSdk
      // 40: monitorexit
      // 41: return
      // try (2 -> 15): 15 null
      // try (22 -> 29): 15 null
      // try (29 -> 34): 15 null
   }

   @Deprecated
   public static void sdkInitialize(Context param0, FacebookSdk.InitializeCallback param1) {
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
      // 00: ldc com/facebook/FacebookSdk
      // 02: monitorenter
      // 03: getstatic com/facebook/FacebookSdk.sdkInitialized Ljava/lang/Boolean;
      // 06: invokevirtual java/lang/Boolean.booleanValue ()Z
      // 09: ifeq 1a
      // 0c: aload 1
      // 0d: ifnull 16
      // 10: aload 1
      // 11: invokeinterface com/facebook/FacebookSdk$InitializeCallback.onInitialized ()V 1
      // 16: ldc com/facebook/FacebookSdk
      // 18: monitorexit
      // 19: return
      // 1a: aload 0
      // 1b: ldc_w "applicationContext"
      // 1e: invokestatic com/facebook/internal/Validate.notNull (Ljava/lang/Object;Ljava/lang/String;)V
      // 21: aload 0
      // 22: bipush 0
      // 23: invokestatic com/facebook/internal/Validate.hasFacebookActivity (Landroid/content/Context;Z)V
      // 26: aload 0
      // 27: bipush 0
      // 28: invokestatic com/facebook/internal/Validate.hasInternetPermissions (Landroid/content/Context;Z)V
      // 2b: aload 0
      // 2c: invokevirtual android/content/Context.getApplicationContext ()Landroid/content/Context;
      // 2f: putstatic com/facebook/FacebookSdk.applicationContext Landroid/content/Context;
      // 32: getstatic com/facebook/FacebookSdk.applicationContext Landroid/content/Context;
      // 35: invokestatic com/facebook/FacebookSdk.loadDefaultsFromMetadata (Landroid/content/Context;)V
      // 38: getstatic com/facebook/FacebookSdk.applicationId Ljava/lang/String;
      // 3b: invokestatic com/facebook/internal/Utility.isNullOrEmpty (Ljava/lang/String;)Z
      // 3e: ifeq 54
      // 41: new com/facebook/FacebookException
      // 44: astore 0
      // 45: aload 0
      // 46: ldc_w "A valid Facebook app id must be set in the AndroidManifest.xml or set by calling FacebookSdk.setApplicationId before initializing the sdk."
      // 49: invokespecial com/facebook/FacebookException.<init> (Ljava/lang/String;)V
      // 4c: aload 0
      // 4d: athrow
      // 4e: astore 0
      // 4f: ldc com/facebook/FacebookSdk
      // 51: monitorexit
      // 52: aload 0
      // 53: athrow
      // 54: bipush 1
      // 55: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
      // 58: putstatic com/facebook/FacebookSdk.sdkInitialized Ljava/lang/Boolean;
      // 5b: invokestatic com/facebook/internal/FetchedAppSettingsManager.loadAppSettingsAsync ()V
      // 5e: invokestatic com/facebook/internal/NativeProtocol.updateAllAvailableProtocolVersionsAsync ()V
      // 61: getstatic com/facebook/FacebookSdk.applicationContext Landroid/content/Context;
      // 64: invokestatic com/facebook/internal/BoltsMeasurementEventListener.getInstance (Landroid/content/Context;)Lcom/facebook/internal/BoltsMeasurementEventListener;
      // 67: pop
      // 68: new com/facebook/internal/LockOnGetVariable
      // 6b: astore 3
      // 6c: new com/facebook/FacebookSdk$2
      // 6f: astore 2
      // 70: aload 2
      // 71: invokespecial com/facebook/FacebookSdk$2.<init> ()V
      // 74: aload 3
      // 75: aload 2
      // 76: invokespecial com/facebook/internal/LockOnGetVariable.<init> (Ljava/util/concurrent/Callable;)V
      // 79: aload 3
      // 7a: putstatic com/facebook/FacebookSdk.cacheDir Lcom/facebook/internal/LockOnGetVariable;
      // 7d: new java/util/concurrent/FutureTask
      // 80: astore 2
      // 81: new com/facebook/FacebookSdk$3
      // 84: astore 3
      // 85: aload 3
      // 86: aload 1
      // 87: aload 0
      // 88: invokespecial com/facebook/FacebookSdk$3.<init> (Lcom/facebook/FacebookSdk$InitializeCallback;Landroid/content/Context;)V
      // 8b: aload 2
      // 8c: aload 3
      // 8d: invokespecial java/util/concurrent/FutureTask.<init> (Ljava/util/concurrent/Callable;)V
      // 90: invokestatic com/facebook/FacebookSdk.getExecutor ()Ljava/util/concurrent/Executor;
      // 93: aload 2
      // 94: invokeinterface java/util/concurrent/Executor.execute (Ljava/lang/Runnable;)V 2
      // 99: goto 16
      // try (2 -> 5): 36 null
      // try (7 -> 9): 36 null
      // try (12 -> 36): 36 null
      // try (41 -> 74): 36 null
   }

   public static void setApplicationId(String var0) {
      applicationId = var0;
   }

   public static void setApplicationName(String var0) {
      applicationName = var0;
   }

   public static void setAutoLogAppEventsEnabled(boolean var0) {
      autoLogAppEventsEnabled = var0;
   }

   public static void setCacheDir(File var0) {
      cacheDir = new LockOnGetVariable<>(var0);
   }

   public static void setClientToken(String var0) {
      appClientToken = var0;
   }

   public static void setExecutor(Executor param0) {
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
      // 01: ldc_w "executor"
      // 04: invokestatic com/facebook/internal/Validate.notNull (Ljava/lang/Object;Ljava/lang/String;)V
      // 07: getstatic com/facebook/FacebookSdk.LOCK Ljava/lang/Object;
      // 0a: astore 1
      // 0b: aload 1
      // 0c: monitorenter
      // 0d: aload 0
      // 0e: putstatic com/facebook/FacebookSdk.executor Ljava/util/concurrent/Executor;
      // 11: aload 1
      // 12: monitorexit
      // 13: return
      // 14: astore 0
      // 15: aload 1
      // 16: monitorexit
      // 17: aload 0
      // 18: athrow
      // try (7 -> 11): 12 null
      // try (13 -> 15): 12 null
   }

   public static void setFacebookDomain(String var0) {
      Log.w(TAG, "WARNING: Calling setFacebookDomain from non-DEBUG code.");
      facebookDomain = var0;
   }

   public static void setGraphApiVersion(String var0) {
      if (!Utility.isNullOrEmpty(var0) && !graphApiVersion.equals(var0)) {
         graphApiVersion = var0;
      }
   }

   public static void setIsDebugEnabled(boolean var0) {
      isDebugEnabled = var0;
   }

   public static void setLegacyTokenUpgradeSupported(boolean var0) {
      isLegacyTokenUpgradeSupported = var0;
   }

   public static void setLimitEventAndDataUsage(Context var0, boolean var1) {
      var0.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putBoolean("limitEventUsage", var1).apply();
   }

   public static void setOnProgressThreshold(long var0) {
      onProgressThreshold.set(var0);
   }

   public static void setWebDialogTheme(int var0) {
      if (var0 == 0) {
         var0 = DEFAULT_THEME;
      }

      webDialogTheme = var0;
   }

   private static void updateGraphDebugBehavior() {
      if (loggingBehaviors.contains(LoggingBehavior.GRAPH_API_DEBUG_INFO) && !loggingBehaviors.contains(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
         loggingBehaviors.add(LoggingBehavior.GRAPH_API_DEBUG_WARNING);
      }
   }

   public interface InitializeCallback {
      void onInitialized();
   }
}
