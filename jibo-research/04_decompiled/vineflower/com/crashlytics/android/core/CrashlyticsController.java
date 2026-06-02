package com.crashlytics.android.core;

import android.app.Activity;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Environment;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.core.internal.models.SessionEventData;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.Crash;
import io.fabric.sdk.android.services.common.DeliveryMechanism;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.persistence.FileStore;
import io.fabric.sdk.android.services.settings.PromptSettingsData;
import io.fabric.sdk.android.services.settings.SessionSettingsData;
import io.fabric.sdk.android.services.settings.Settings;
import io.fabric.sdk.android.services.settings.SettingsData;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CrashlyticsController {
   static final FilenameFilter a = new FilenameFilter() {
      @Override
      public boolean accept(File var1, String var2) {
         boolean var3;
         if (var2.length() == ".cls".length() + 35 && var2.endsWith(".cls")) {
            var3 = true;
         } else {
            var3 = false;
         }

         return var3;
      }
   };
   static final Comparator<File> b = new Comparator<File>() {
      public int a(File var1, File var2) {
         return var2.getName().compareTo(var1.getName());
      }
   };
   static final Comparator<File> c = new Comparator<File>() {
      public int a(File var1, File var2) {
         return var1.getName().compareTo(var2.getName());
      }
   };
   static final FilenameFilter d = new FilenameFilter() {
      @Override
      public boolean accept(File var1, String var2) {
         return CrashlyticsController.e.matcher(var2).matches();
      }
   };
   private static final Pattern e = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");
   private static final Map<String, String> f = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", "1");
   private static final String[] g = new String[]{"SessionUser", "SessionApp", "SessionOS", "SessionDevice"};
   private final AtomicInteger h = new AtomicInteger(0);
   private final CrashlyticsCore i;
   private final CrashlyticsBackgroundWorker j;
   private final HttpRequestFactory k;
   private final IdManager l;
   private final PreferenceManager m;
   private final FileStore n;
   private final AppData o;
   private final CrashlyticsController.LogFileDirectoryProvider p;
   private final LogFileManager q;
   private final ReportUploader.ReportFilesProvider r;
   private final ReportUploader.HandlingExceptionCheck s;
   private final DevicePowerStateListener t;
   private final StackTraceTrimmingStrategy u;
   private final String v;
   private CrashlyticsUncaughtExceptionHandler w;

   CrashlyticsController(
      CrashlyticsCore var1,
      CrashlyticsBackgroundWorker var2,
      HttpRequestFactory var3,
      IdManager var4,
      PreferenceManager var5,
      FileStore var6,
      AppData var7,
      UnityVersionProvider var8
   ) {
      this.i = var1;
      this.j = var2;
      this.k = var3;
      this.l = var4;
      this.m = var5;
      this.n = var6;
      this.o = var7;
      this.v = var8.a();
      Context var9 = var1.r();
      this.p = new CrashlyticsController.LogFileDirectoryProvider(var6);
      this.q = new LogFileManager(var9, this.p);
      this.r = new CrashlyticsController.ReportUploaderFilesProvider(this);
      this.s = new CrashlyticsController.ReportUploaderHandlingExceptionCheck(this);
      this.t = new DevicePowerStateListener(var9);
      this.u = new MiddleOutFallbackStrategy(1024, new RemoveRepeatsStrategy(10));
   }

   static String a(File var0) {
      return var0.getName().substring(0, 35);
   }

   private void a(ClsFileOutputStream var1) {
      if (var1 != null) {
         try {
            var1.a();
         } catch (IOException var2) {
            Fabric.h().e("CrashlyticsCore", "Error closing session file stream in the presence of an exception", var2);
         }
      }
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private static void a(CodedOutputStream var0, File var1) throws IOException {
      if (!var1.exists()) {
         Fabric.h().e("CrashlyticsCore", "Tried to include a file that doesn't exist: " + var1.getName(), null);
      } else {
         boolean var7 = false /* VF: Semaphore variable */;

         FileInputStream var2;
         try {
            var7 = true;
            var2 = new FileInputStream(var1);
            var7 = false;
         } finally {
            if (var7) {
               Object var10 = null;
               CommonUtils.a((Closeable)var10, "Failed to close file input stream.");
            }
         }

         try {
            a(var2, var0, (int)var1.length());
         } finally {
            ;
         }

         CommonUtils.a(var2, "Failed to close file input stream.");
      }
   }

   private void a(CodedOutputStream var1, String var2) throws IOException {
      for (String var7 : g) {
         File[] var5 = this.a(new CrashlyticsController.FileNameContainsFilter(var2 + var7));
         if (var5.length == 0) {
            Fabric.h().e("CrashlyticsCore", "Can't find " + var7 + " data for session ID " + var2, null);
         } else {
            Fabric.h().a("CrashlyticsCore", "Collecting " + var7 + " data for session ID " + var2);
            a(var1, var5[0]);
         }
      }
   }

   private void a(CodedOutputStream var1, Date var2, Thread var3, Throwable var4, String var5, boolean var6) throws Exception {
      TrimmedThrowableData var19 = new TrimmedThrowableData(var4, this.u);
      Context var26 = this.i.r();
      long var17 = var2.getTime() / 1000L;
      Float var22 = CommonUtils.c(var26);
      int var8 = CommonUtils.a(var26, this.t.a());
      boolean var10 = CommonUtils.d(var26);
      int var9 = var26.getResources().getConfiguration().orientation;
      long var11 = CommonUtils.b();
      long var15 = CommonUtils.b(var26);
      long var13 = CommonUtils.b(Environment.getDataDirectory().getPath());
      RunningAppProcessInfo var24 = CommonUtils.a(var26.getPackageName(), var26);
      LinkedList var20 = new LinkedList();
      StackTraceElement[] var21 = var19.c;
      String var25 = this.o.b;
      String var23 = this.l.c();
      Thread[] var31;
      if (var6) {
         Map var30 = Thread.getAllStackTraces();
         Thread[] var28 = new Thread[var30.size()];
         Iterator var27 = var30.entrySet().iterator();
         int var7 = 0;

         while (true) {
            var31 = var28;
            if (!var27.hasNext()) {
               break;
            }

            Entry var32 = (Entry)var27.next();
            var28[var7] = (Thread)var32.getKey();
            var20.add(this.u.a((StackTraceElement[])var32.getValue()));
            var7++;
         }
      } else {
         var31 = new Thread[0];
      }

      Map var29;
      if (!CommonUtils.a(var26, "com.crashlytics.CollectCustomKeys", true)) {
         var29 = new TreeMap();
      } else {
         var29 = this.i.g();
         if (var29 != null && var29.size() > 1) {
            var29 = new TreeMap(var29);
         }
      }

      SessionProtobufHelper.a(
         var1, var17, var5, var19, var3, var21, var31, var20, var29, this.q, var24, var9, var23, var25, var22, var8, var10, var11 - var15, var13
      );
   }

   private static void a(CodedOutputStream var0, File[] var1, String var2) {
      Arrays.sort(var1, CommonUtils.a);

      for (File var5 : var1) {
         try {
            Fabric.h().a("CrashlyticsCore", String.format(Locale.US, "Found Non Fatal for session ID %s in %s ", var2, var5.getName()));
            a(var0, var5);
         } catch (Exception var6) {
            Fabric.h().e("CrashlyticsCore", "Error writting non-fatal to session.", var6);
         }
      }
   }

   private void a(SessionSettingsData var1, boolean var2) throws Exception {
      byte var3;
      if (var2) {
         var3 = 1;
      } else {
         var3 = 0;
      }

      this.b(var3 + 8);
      File[] var4 = this.n();
      if (var4.length <= var3) {
         Fabric.h().a("CrashlyticsCore", "No open sessions to be closed.");
      } else {
         this.f(a(var4[var3]));
         if (var1 == null) {
            Fabric.h().a("CrashlyticsCore", "Unable to close session. Settings are not loaded.");
         } else {
            this.a(var4, var3, var1.c);
         }
      }
   }

   private void a(File var1, String var2, int var3) {
      Fabric.h().a("CrashlyticsCore", "Collecting session parts for ID " + var2);
      File[] var6 = this.a(new CrashlyticsController.FileNameContainsFilter(var2 + "SessionCrash"));
      boolean var4;
      if (var6 != null && var6.length > 0) {
         var4 = true;
      } else {
         var4 = false;
      }

      Fabric.h().a("CrashlyticsCore", String.format(Locale.US, "Session %s has fatal exception: %s", var2, var4));
      File[] var7 = this.a(new CrashlyticsController.FileNameContainsFilter(var2 + "SessionEvent"));
      boolean var5;
      if (var7 != null && var7.length > 0) {
         var5 = true;
      } else {
         var5 = false;
      }

      Fabric.h().a("CrashlyticsCore", String.format(Locale.US, "Session %s has non-fatal exceptions: %s", var2, var5));
      if (!var4 && !var5) {
         Fabric.h().a("CrashlyticsCore", "No events present for session ID " + var2);
      } else {
         var7 = this.a(var2, var7, var3);
         File var8;
         if (var4) {
            var8 = var6[0];
         } else {
            var8 = null;
         }

         this.a(var1, var2, var7, var8);
      }

      Fabric.h().a("CrashlyticsCore", "Removing session part files for ID " + var2);
      this.a(var2);
   }

   private void a(File param1, String param2, File[] param3, File param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aconst_null
      // 001: astore 8
      // 003: aconst_null
      // 004: astore 11
      // 006: aconst_null
      // 007: astore 10
      // 009: aconst_null
      // 00a: astore 7
      // 00c: aload 4
      // 00e: ifnull 17b
      // 011: bipush 1
      // 012: istore 5
      // 014: iload 5
      // 016: ifeq 181
      // 019: aload 0
      // 01a: invokevirtual com/crashlytics/android/core/CrashlyticsController.g ()Ljava/io/File;
      // 01d: astore 6
      // 01f: aload 6
      // 021: invokevirtual java/io/File.exists ()Z
      // 024: ifne 02d
      // 027: aload 6
      // 029: invokevirtual java/io/File.mkdirs ()Z
      // 02c: pop
      // 02d: new com/crashlytics/android/core/ClsFileOutputStream
      // 030: astore 9
      // 032: aload 9
      // 034: aload 6
      // 036: aload 2
      // 037: invokespecial com/crashlytics/android/core/ClsFileOutputStream.<init> (Ljava/io/File;Ljava/lang/String;)V
      // 03a: aload 11
      // 03c: astore 6
      // 03e: aload 9
      // 040: astore 7
      // 042: aload 10
      // 044: astore 8
      // 046: aload 9
      // 048: invokestatic com/crashlytics/android/core/CodedOutputStream.a (Ljava/io/OutputStream;)Lcom/crashlytics/android/core/CodedOutputStream;
      // 04b: astore 10
      // 04d: aload 10
      // 04f: astore 6
      // 051: aload 9
      // 053: astore 7
      // 055: aload 10
      // 057: astore 8
      // 059: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 05c: astore 11
      // 05e: aload 10
      // 060: astore 6
      // 062: aload 9
      // 064: astore 7
      // 066: aload 10
      // 068: astore 8
      // 06a: new java/lang/StringBuilder
      // 06d: astore 12
      // 06f: aload 10
      // 071: astore 6
      // 073: aload 9
      // 075: astore 7
      // 077: aload 10
      // 079: astore 8
      // 07b: aload 12
      // 07d: invokespecial java/lang/StringBuilder.<init> ()V
      // 080: aload 10
      // 082: astore 6
      // 084: aload 9
      // 086: astore 7
      // 088: aload 10
      // 08a: astore 8
      // 08c: aload 11
      // 08e: ldc "CrashlyticsCore"
      // 090: aload 12
      // 092: ldc_w "Collecting SessionStart data for session ID "
      // 095: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 098: aload 2
      // 099: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 09c: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 09f: invokeinterface io/fabric/sdk/android/Logger.a (Ljava/lang/String;Ljava/lang/String;)V 3
      // 0a4: aload 10
      // 0a6: astore 6
      // 0a8: aload 9
      // 0aa: astore 7
      // 0ac: aload 10
      // 0ae: astore 8
      // 0b0: aload 10
      // 0b2: aload 1
      // 0b3: invokestatic com/crashlytics/android/core/CrashlyticsController.a (Lcom/crashlytics/android/core/CodedOutputStream;Ljava/io/File;)V
      // 0b6: aload 10
      // 0b8: astore 6
      // 0ba: aload 9
      // 0bc: astore 7
      // 0be: aload 10
      // 0c0: astore 8
      // 0c2: new java/util/Date
      // 0c5: astore 1
      // 0c6: aload 10
      // 0c8: astore 6
      // 0ca: aload 9
      // 0cc: astore 7
      // 0ce: aload 10
      // 0d0: astore 8
      // 0d2: aload 1
      // 0d3: invokespecial java/util/Date.<init> ()V
      // 0d6: aload 10
      // 0d8: astore 6
      // 0da: aload 9
      // 0dc: astore 7
      // 0de: aload 10
      // 0e0: astore 8
      // 0e2: aload 10
      // 0e4: bipush 4
      // 0e5: aload 1
      // 0e6: invokevirtual java/util/Date.getTime ()J
      // 0e9: ldc2_w 1000
      // 0ec: ldiv
      // 0ed: invokevirtual com/crashlytics/android/core/CodedOutputStream.a (IJ)V
      // 0f0: aload 10
      // 0f2: astore 6
      // 0f4: aload 9
      // 0f6: astore 7
      // 0f8: aload 10
      // 0fa: astore 8
      // 0fc: aload 10
      // 0fe: bipush 5
      // 0ff: iload 5
      // 101: invokevirtual com/crashlytics/android/core/CodedOutputStream.a (IZ)V
      // 104: aload 10
      // 106: astore 6
      // 108: aload 9
      // 10a: astore 7
      // 10c: aload 10
      // 10e: astore 8
      // 110: aload 10
      // 112: bipush 11
      // 114: bipush 1
      // 115: invokevirtual com/crashlytics/android/core/CodedOutputStream.a (II)V
      // 118: aload 10
      // 11a: astore 6
      // 11c: aload 9
      // 11e: astore 7
      // 120: aload 10
      // 122: astore 8
      // 124: aload 10
      // 126: bipush 12
      // 128: bipush 3
      // 129: invokevirtual com/crashlytics/android/core/CodedOutputStream.b (II)V
      // 12c: aload 10
      // 12e: astore 6
      // 130: aload 9
      // 132: astore 7
      // 134: aload 10
      // 136: astore 8
      // 138: aload 0
      // 139: aload 10
      // 13b: aload 2
      // 13c: invokespecial com/crashlytics/android/core/CrashlyticsController.a (Lcom/crashlytics/android/core/CodedOutputStream;Ljava/lang/String;)V
      // 13f: aload 10
      // 141: astore 6
      // 143: aload 9
      // 145: astore 7
      // 147: aload 10
      // 149: astore 8
      // 14b: aload 10
      // 14d: aload 3
      // 14e: aload 2
      // 14f: invokestatic com/crashlytics/android/core/CrashlyticsController.a (Lcom/crashlytics/android/core/CodedOutputStream;[Ljava/io/File;Ljava/lang/String;)V
      // 152: iload 5
      // 154: ifeq 16a
      // 157: aload 10
      // 159: astore 6
      // 15b: aload 9
      // 15d: astore 7
      // 15f: aload 10
      // 161: astore 8
      // 163: aload 10
      // 165: aload 4
      // 167: invokestatic com/crashlytics/android/core/CrashlyticsController.a (Lcom/crashlytics/android/core/CodedOutputStream;Ljava/io/File;)V
      // 16a: aload 10
      // 16c: ldc_w "Error flushing session file stream"
      // 16f: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Flushable;Ljava/lang/String;)V
      // 172: aload 9
      // 174: ldc_w "Failed to close CLS file"
      // 177: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // 17a: return
      // 17b: bipush 0
      // 17c: istore 5
      // 17e: goto 014
      // 181: aload 0
      // 182: invokevirtual com/crashlytics/android/core/CrashlyticsController.h ()Ljava/io/File;
      // 185: astore 6
      // 187: goto 01f
      // 18a: astore 3
      // 18b: aconst_null
      // 18c: astore 1
      // 18d: aload 7
      // 18f: astore 8
      // 191: aload 8
      // 193: astore 6
      // 195: aload 1
      // 196: astore 7
      // 198: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 19b: astore 4
      // 19d: aload 8
      // 19f: astore 6
      // 1a1: aload 1
      // 1a2: astore 7
      // 1a4: new java/lang/StringBuilder
      // 1a7: astore 9
      // 1a9: aload 8
      // 1ab: astore 6
      // 1ad: aload 1
      // 1ae: astore 7
      // 1b0: aload 9
      // 1b2: invokespecial java/lang/StringBuilder.<init> ()V
      // 1b5: aload 8
      // 1b7: astore 6
      // 1b9: aload 1
      // 1ba: astore 7
      // 1bc: aload 4
      // 1be: ldc "CrashlyticsCore"
      // 1c0: aload 9
      // 1c2: ldc_w "Failed to write session file for session ID: "
      // 1c5: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1c8: aload 2
      // 1c9: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1cc: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 1cf: aload 3
      // 1d0: invokeinterface io/fabric/sdk/android/Logger.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V 4
      // 1d5: aload 8
      // 1d7: ldc_w "Error flushing session file stream"
      // 1da: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Flushable;Ljava/lang/String;)V
      // 1dd: aload 0
      // 1de: aload 1
      // 1df: invokespecial com/crashlytics/android/core/CrashlyticsController.a (Lcom/crashlytics/android/core/ClsFileOutputStream;)V
      // 1e2: goto 17a
      // 1e5: astore 1
      // 1e6: aconst_null
      // 1e7: astore 7
      // 1e9: aload 8
      // 1eb: astore 6
      // 1ed: aload 6
      // 1ef: ldc_w "Error flushing session file stream"
      // 1f2: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Flushable;Ljava/lang/String;)V
      // 1f5: aload 7
      // 1f7: ldc_w "Failed to close CLS file"
      // 1fa: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // 1fd: aload 1
      // 1fe: athrow
      // 1ff: astore 1
      // 200: goto 1ed
      // 203: astore 3
      // 204: aload 9
      // 206: astore 1
      // 207: goto 191
      // try (23 -> 29): 190 java/lang/Exception
      // try (23 -> 29): 234 null
      // try (35 -> 38): 249 java/lang/Exception
      // try (35 -> 38): 247 null
      // try (44 -> 46): 249 java/lang/Exception
      // try (44 -> 46): 247 null
      // try (52 -> 54): 249 java/lang/Exception
      // try (52 -> 54): 247 null
      // try (60 -> 62): 249 java/lang/Exception
      // try (60 -> 62): 247 null
      // try (68 -> 77): 249 java/lang/Exception
      // try (68 -> 77): 247 null
      // try (83 -> 86): 249 java/lang/Exception
      // try (83 -> 86): 247 null
      // try (92 -> 94): 249 java/lang/Exception
      // try (92 -> 94): 247 null
      // try (100 -> 102): 249 java/lang/Exception
      // try (100 -> 102): 247 null
      // try (108 -> 115): 249 java/lang/Exception
      // try (108 -> 115): 247 null
      // try (121 -> 125): 249 java/lang/Exception
      // try (121 -> 125): 247 null
      // try (131 -> 135): 249 java/lang/Exception
      // try (131 -> 135): 247 null
      // try (141 -> 145): 249 java/lang/Exception
      // try (141 -> 145): 247 null
      // try (151 -> 155): 249 java/lang/Exception
      // try (151 -> 155): 247 null
      // try (161 -> 165): 249 java/lang/Exception
      // try (161 -> 165): 247 null
      // try (173 -> 176): 249 java/lang/Exception
      // try (173 -> 176): 247 null
      // try (199 -> 201): 247 null
      // try (205 -> 207): 247 null
      // try (211 -> 213): 247 null
      // try (217 -> 227): 247 null
   }

   private static void a(InputStream var0, CodedOutputStream var1, int var2) throws IOException {
      byte[] var4 = new byte[var2];
      var2 = 0;

      while (var2 < var4.length) {
         int var3 = var0.read(var4, var2, var4.length - var2);
         if (var3 < 0) {
            break;
         }

         var2 += var3;
      }

      var1.a(var4);
   }

   private void a(String var1) {
      File[] var4 = this.b(var1);
      int var3 = var4.length;

      for (int var2 = 0; var2 < var3; var2++) {
         var4[var2].delete();
      }
   }

   private void a(String var1, int var2) {
      Utils.a(this.f(), new CrashlyticsController.FileNameContainsFilter(var1 + "SessionEvent"), var2, c);
   }

   private static void a(String var0, String var1) {
      Answers var2 = Fabric.a(Answers.class);
      if (var2 == null) {
         Fabric.h().a("CrashlyticsCore", "Answers is not available");
      } else {
         var2.a(new Crash.LoggedException(var0, var1));
      }
   }

   private void a(String param1, Date param2) throws Exception {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 2 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1052)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:502)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aconst_null
      // 01: astore 5
      // 03: aconst_null
      // 04: astore 3
      // 05: new com/crashlytics/android/core/ClsFileOutputStream
      // 08: astore 4
      // 0a: aload 0
      // 0b: invokevirtual com/crashlytics/android/core/CrashlyticsController.f ()Ljava/io/File;
      // 0e: astore 6
      // 10: new java/lang/StringBuilder
      // 13: astore 7
      // 15: aload 7
      // 17: invokespecial java/lang/StringBuilder.<init> ()V
      // 1a: aload 4
      // 1c: aload 6
      // 1e: aload 7
      // 20: aload 1
      // 21: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 24: ldc_w "BeginSession"
      // 27: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 2a: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 2d: invokespecial com/crashlytics/android/core/ClsFileOutputStream.<init> (Ljava/io/File;Ljava/lang/String;)V
      // 30: aload 5
      // 32: astore 3
      // 33: aload 4
      // 35: invokestatic com/crashlytics/android/core/CodedOutputStream.a (Ljava/io/OutputStream;)Lcom/crashlytics/android/core/CodedOutputStream;
      // 38: astore 5
      // 3a: aload 5
      // 3c: astore 3
      // 3d: aload 5
      // 3f: aload 1
      // 40: getstatic java/util/Locale.US Ljava/util/Locale;
      // 43: ldc_w "Crashlytics Android SDK/%s"
      // 46: bipush 1
      // 47: anewarray 4
      // 4a: dup
      // 4b: bipush 0
      // 4c: aload 0
      // 4d: getfield com/crashlytics/android/core/CrashlyticsController.i Lcom/crashlytics/android/core/CrashlyticsCore;
      // 50: invokevirtual com/crashlytics/android/core/CrashlyticsCore.a ()Ljava/lang/String;
      // 53: aastore
      // 54: invokestatic java/lang/String.format (Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      // 57: aload 2
      // 58: invokevirtual java/util/Date.getTime ()J
      // 5b: ldc2_w 1000
      // 5e: ldiv
      // 5f: invokestatic com/crashlytics/android/core/SessionProtobufHelper.a (Lcom/crashlytics/android/core/CodedOutputStream;Ljava/lang/String;Ljava/lang/String;J)V
      // 62: aload 5
      // 64: ldc_w "Failed to flush to session begin file."
      // 67: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Flushable;Ljava/lang/String;)V
      // 6a: aload 4
      // 6c: ldc_w "Failed to close begin session file."
      // 6f: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // 72: return
      // 73: astore 1
      // 74: aconst_null
      // 75: astore 2
      // 76: aload 3
      // 77: ldc_w "Failed to flush to session begin file."
      // 7a: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Flushable;Ljava/lang/String;)V
      // 7d: aload 2
      // 7e: ldc_w "Failed to close begin session file."
      // 81: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // 84: aload 1
      // 85: athrow
      // 86: astore 1
      // 87: aload 4
      // 89: astore 2
      // 8a: goto 76
      // try (4 -> 22): 54 null
      // try (24 -> 27): 65 null
      // try (29 -> 47): 65 null
   }

   private void a(Date param1, Thread param2, Throwable param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aconst_null
      // 01: astore 4
      // 03: aconst_null
      // 04: astore 8
      // 06: aconst_null
      // 07: astore 7
      // 09: aconst_null
      // 0a: astore 5
      // 0c: aload 0
      // 0d: invokespecial com/crashlytics/android/core/CrashlyticsController.k ()Ljava/lang/String;
      // 10: astore 6
      // 12: aload 6
      // 14: ifnonnull 34
      // 17: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 1a: ldc "CrashlyticsCore"
      // 1c: ldc_w "Tried to write a fatal exception while no session was open."
      // 1f: aconst_null
      // 20: invokeinterface io/fabric/sdk/android/Logger.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V 4
      // 25: aconst_null
      // 26: ldc_w "Failed to flush to session begin file."
      // 29: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Flushable;Ljava/lang/String;)V
      // 2c: aconst_null
      // 2d: ldc_w "Failed to close fatal exception file output stream."
      // 30: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // 33: return
      // 34: aload 6
      // 36: aload 3
      // 37: invokevirtual java/lang/Object.getClass ()Ljava/lang/Class;
      // 3a: invokevirtual java/lang/Class.getName ()Ljava/lang/String;
      // 3d: invokestatic com/crashlytics/android/core/CrashlyticsController.b (Ljava/lang/String;Ljava/lang/String;)V
      // 40: aload 0
      // 41: invokevirtual com/crashlytics/android/core/CrashlyticsController.f ()Ljava/io/File;
      // 44: astore 9
      // 46: new java/lang/StringBuilder
      // 49: astore 10
      // 4b: aload 10
      // 4d: invokespecial java/lang/StringBuilder.<init> ()V
      // 50: new com/crashlytics/android/core/ClsFileOutputStream
      // 53: dup
      // 54: aload 9
      // 56: aload 10
      // 58: aload 6
      // 5a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 5d: ldc_w "SessionCrash"
      // 60: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 63: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 66: invokespecial com/crashlytics/android/core/ClsFileOutputStream.<init> (Ljava/io/File;Ljava/lang/String;)V
      // 69: astore 6
      // 6b: aload 8
      // 6d: astore 4
      // 6f: aload 7
      // 71: astore 5
      // 73: aload 6
      // 75: invokestatic com/crashlytics/android/core/CodedOutputStream.a (Ljava/io/OutputStream;)Lcom/crashlytics/android/core/CodedOutputStream;
      // 78: astore 7
      // 7a: aload 7
      // 7c: astore 4
      // 7e: aload 7
      // 80: astore 5
      // 82: aload 0
      // 83: aload 7
      // 85: aload 1
      // 86: aload 2
      // 87: aload 3
      // 88: ldc_w "crash"
      // 8b: bipush 1
      // 8c: invokespecial com/crashlytics/android/core/CrashlyticsController.a (Lcom/crashlytics/android/core/CodedOutputStream;Ljava/util/Date;Ljava/lang/Thread;Ljava/lang/Throwable;Ljava/lang/String;Z)V
      // 8f: aload 7
      // 91: ldc_w "Failed to flush to session begin file."
      // 94: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Flushable;Ljava/lang/String;)V
      // 97: aload 6
      // 99: ldc_w "Failed to close fatal exception file output stream."
      // 9c: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // 9f: goto 33
      // a2: astore 2
      // a3: aconst_null
      // a4: astore 1
      // a5: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // a8: ldc "CrashlyticsCore"
      // aa: ldc_w "An error occurred in the fatal exception logger"
      // ad: aload 2
      // ae: invokeinterface io/fabric/sdk/android/Logger.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V 4
      // b3: aload 5
      // b5: ldc_w "Failed to flush to session begin file."
      // b8: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Flushable;Ljava/lang/String;)V
      // bb: aload 1
      // bc: ldc_w "Failed to close fatal exception file output stream."
      // bf: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // c2: goto 33
      // c5: astore 2
      // c6: aconst_null
      // c7: astore 1
      // c8: aload 4
      // ca: ldc_w "Failed to flush to session begin file."
      // cd: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Flushable;Ljava/lang/String;)V
      // d0: aload 1
      // d1: ldc_w "Failed to close fatal exception file output stream."
      // d4: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // d7: aload 2
      // d8: athrow
      // d9: astore 2
      // da: aload 6
      // dc: astore 1
      // dd: goto c8
      // e0: astore 2
      // e1: aload 5
      // e3: astore 4
      // e5: goto c8
      // e8: astore 2
      // e9: aload 6
      // eb: astore 1
      // ec: goto a5
      // try (8 -> 11): 74 java/lang/Exception
      // try (8 -> 11): 89 null
      // try (13 -> 18): 74 java/lang/Exception
      // try (13 -> 18): 89 null
      // try (25 -> 48): 74 java/lang/Exception
      // try (25 -> 48): 89 null
      // try (52 -> 55): 108 java/lang/Exception
      // try (52 -> 55): 100 null
      // try (59 -> 67): 108 java/lang/Exception
      // try (59 -> 67): 100 null
      // try (77 -> 82): 104 null
   }

   private void a(File[] var1, int var2, int var3) {
      Fabric.h().a("CrashlyticsCore", "Closing open sessions.");

      while (var2 < var1.length) {
         File var4 = var1[var2];
         String var5 = a(var4);
         Fabric.h().a("CrashlyticsCore", "Closing session: " + var5);
         this.a(var4, var5, var3);
         var2++;
      }
   }

   private void a(File[] var1, Set<String> var2) {
      for (File var7 : var1) {
         String var6 = var7.getName();
         Matcher var5 = e.matcher(var6);
         if (!var5.matches()) {
            Fabric.h().a("CrashlyticsCore", "Deleting unknown file: " + var6);
            var7.delete();
            break;
         }

         if (!var2.contains(var5.group(1))) {
            Fabric.h().a("CrashlyticsCore", "Trimming session file: " + var6);
            var7.delete();
         }
      }
   }

   private boolean a(SettingsData var1) {
      boolean var3 = false;
      boolean var2;
      if (var1 == null) {
         var2 = var3;
      } else {
         var2 = var3;
         if (var1.d.a) {
            var2 = var3;
            if (!this.m.a()) {
               var2 = true;
            }
         }
      }

      return var2;
   }

   private File[] a(File var1, FilenameFilter var2) {
      return this.b(var1.listFiles(var2));
   }

   private File[] a(FilenameFilter var1) {
      return this.a(this.f(), var1);
   }

   private File[] a(String var1, File[] var2, int var3) {
      File[] var4 = var2;
      if (var2.length > var3) {
         Fabric.h().a("CrashlyticsCore", String.format(Locale.US, "Trimming down to %d logged exceptions.", var3));
         this.a(var1, var3);
         var4 = this.a(new CrashlyticsController.FileNameContainsFilter(var1 + "SessionEvent"));
      }

      return var4;
   }

   private void b(int var1) {
      HashSet var4 = new HashSet();
      File[] var3 = this.n();
      int var2 = Math.min(var1, var3.length);

      for (int var5 = 0; var5 < var2; var5++) {
         var4.add(a(var3[var5]));
      }

      this.q.a(var4);
      this.a(this.a(new CrashlyticsController.AnySessionPartFileFilter()), var4);
   }

   private void b(SessionEventData param1) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: bipush 1
      // 001: istore 2
      // 002: aconst_null
      // 003: astore 7
      // 005: aconst_null
      // 006: astore 4
      // 008: aconst_null
      // 009: astore 8
      // 00b: aconst_null
      // 00c: astore 5
      // 00e: aload 0
      // 00f: invokespecial com/crashlytics/android/core/CrashlyticsController.l ()Ljava/lang/String;
      // 012: astore 9
      // 014: aload 9
      // 016: ifnonnull 036
      // 019: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 01c: ldc "CrashlyticsCore"
      // 01e: ldc_w "Tried to write a native crash while no session was open."
      // 021: aconst_null
      // 022: invokeinterface io/fabric/sdk/android/Logger.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V 4
      // 027: aconst_null
      // 028: ldc_w "Failed to flush to session begin file."
      // 02b: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Flushable;Ljava/lang/String;)V
      // 02e: aconst_null
      // 02f: ldc_w "Failed to close fatal exception file output stream."
      // 032: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // 035: return
      // 036: aload 9
      // 038: getstatic java/util/Locale.US Ljava/util/Locale;
      // 03b: ldc_w "<native-crash [%s (%s)]>"
      // 03e: bipush 2
      // 03f: anewarray 4
      // 042: dup
      // 043: bipush 0
      // 044: aload 1
      // 045: getfield com/crashlytics/android/core/internal/models/SessionEventData.b Lcom/crashlytics/android/core/internal/models/SignalData;
      // 048: getfield com/crashlytics/android/core/internal/models/SignalData.b Ljava/lang/String;
      // 04b: aastore
      // 04c: dup
      // 04d: bipush 1
      // 04e: aload 1
      // 04f: getfield com/crashlytics/android/core/internal/models/SessionEventData.b Lcom/crashlytics/android/core/internal/models/SignalData;
      // 052: getfield com/crashlytics/android/core/internal/models/SignalData.a Ljava/lang/String;
      // 055: aastore
      // 056: invokestatic java/lang/String.format (Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      // 059: invokestatic com/crashlytics/android/core/CrashlyticsController.b (Ljava/lang/String;Ljava/lang/String;)V
      // 05c: aload 1
      // 05d: getfield com/crashlytics/android/core/internal/models/SessionEventData.d [Lcom/crashlytics/android/core/internal/models/BinaryImageData;
      // 060: ifnull 13b
      // 063: aload 1
      // 064: getfield com/crashlytics/android/core/internal/models/SessionEventData.d [Lcom/crashlytics/android/core/internal/models/BinaryImageData;
      // 067: arraylength
      // 068: ifle 13b
      // 06b: iload 2
      // 06c: ifeq 140
      // 06f: ldc_w "SessionCrash"
      // 072: astore 3
      // 073: aload 0
      // 074: invokevirtual com/crashlytics/android/core/CrashlyticsController.f ()Ljava/io/File;
      // 077: astore 6
      // 079: new java/lang/StringBuilder
      // 07c: astore 10
      // 07e: aload 10
      // 080: invokespecial java/lang/StringBuilder.<init> ()V
      // 083: new com/crashlytics/android/core/ClsFileOutputStream
      // 086: dup
      // 087: aload 6
      // 089: aload 10
      // 08b: aload 9
      // 08d: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 090: aload 3
      // 091: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 094: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 097: invokespecial com/crashlytics/android/core/ClsFileOutputStream.<init> (Ljava/io/File;Ljava/lang/String;)V
      // 09a: astore 6
      // 09c: aload 4
      // 09e: astore 3
      // 09f: aload 6
      // 0a1: astore 4
      // 0a3: aload 8
      // 0a5: astore 5
      // 0a7: aload 6
      // 0a9: invokestatic com/crashlytics/android/core/CodedOutputStream.a (Ljava/io/OutputStream;)Lcom/crashlytics/android/core/CodedOutputStream;
      // 0ac: astore 7
      // 0ae: aload 7
      // 0b0: astore 3
      // 0b1: aload 6
      // 0b3: astore 4
      // 0b5: aload 7
      // 0b7: astore 5
      // 0b9: new com/crashlytics/android/core/MetaDataStore
      // 0bc: astore 8
      // 0be: aload 7
      // 0c0: astore 3
      // 0c1: aload 6
      // 0c3: astore 4
      // 0c5: aload 7
      // 0c7: astore 5
      // 0c9: aload 8
      // 0cb: aload 0
      // 0cc: invokevirtual com/crashlytics/android/core/CrashlyticsController.f ()Ljava/io/File;
      // 0cf: invokespecial com/crashlytics/android/core/MetaDataStore.<init> (Ljava/io/File;)V
      // 0d2: aload 7
      // 0d4: astore 3
      // 0d5: aload 6
      // 0d7: astore 4
      // 0d9: aload 7
      // 0db: astore 5
      // 0dd: aload 8
      // 0df: aload 9
      // 0e1: invokevirtual com/crashlytics/android/core/MetaDataStore.b (Ljava/lang/String;)Ljava/util/Map;
      // 0e4: astore 8
      // 0e6: aload 7
      // 0e8: astore 3
      // 0e9: aload 6
      // 0eb: astore 4
      // 0ed: aload 7
      // 0ef: astore 5
      // 0f1: new com/crashlytics/android/core/LogFileManager
      // 0f4: astore 10
      // 0f6: aload 7
      // 0f8: astore 3
      // 0f9: aload 6
      // 0fb: astore 4
      // 0fd: aload 7
      // 0ff: astore 5
      // 101: aload 10
      // 103: aload 0
      // 104: getfield com/crashlytics/android/core/CrashlyticsController.i Lcom/crashlytics/android/core/CrashlyticsCore;
      // 107: invokevirtual com/crashlytics/android/core/CrashlyticsCore.r ()Landroid/content/Context;
      // 10a: aload 0
      // 10b: getfield com/crashlytics/android/core/CrashlyticsController.p Lcom/crashlytics/android/core/CrashlyticsController$LogFileDirectoryProvider;
      // 10e: aload 9
      // 110: invokespecial com/crashlytics/android/core/LogFileManager.<init> (Landroid/content/Context;Lcom/crashlytics/android/core/LogFileManager$DirectoryProvider;Ljava/lang/String;)V
      // 113: aload 7
      // 115: astore 3
      // 116: aload 6
      // 118: astore 4
      // 11a: aload 7
      // 11c: astore 5
      // 11e: aload 1
      // 11f: aload 10
      // 121: aload 8
      // 123: aload 7
      // 125: invokestatic com/crashlytics/android/core/NativeCrashWriter.a (Lcom/crashlytics/android/core/internal/models/SessionEventData;Lcom/crashlytics/android/core/LogFileManager;Ljava/util/Map;Lcom/crashlytics/android/core/CodedOutputStream;)V
      // 128: aload 7
      // 12a: ldc_w "Failed to flush to session begin file."
      // 12d: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Flushable;Ljava/lang/String;)V
      // 130: aload 6
      // 132: ldc_w "Failed to close fatal exception file output stream."
      // 135: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // 138: goto 035
      // 13b: bipush 0
      // 13c: istore 2
      // 13d: goto 06b
      // 140: ldc_w "SessionMissingBinaryImages"
      // 143: astore 3
      // 144: goto 073
      // 147: astore 7
      // 149: aconst_null
      // 14a: astore 1
      // 14b: aload 5
      // 14d: astore 3
      // 14e: aload 1
      // 14f: astore 4
      // 151: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 154: ldc "CrashlyticsCore"
      // 156: ldc_w "An error occurred in the native crash logger"
      // 159: aload 7
      // 15b: invokeinterface io/fabric/sdk/android/Logger.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V 4
      // 160: aload 5
      // 162: ldc_w "Failed to flush to session begin file."
      // 165: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Flushable;Ljava/lang/String;)V
      // 168: aload 1
      // 169: ldc_w "Failed to close fatal exception file output stream."
      // 16c: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // 16f: goto 035
      // 172: astore 1
      // 173: aconst_null
      // 174: astore 4
      // 176: aload 7
      // 178: astore 3
      // 179: aload 3
      // 17a: ldc_w "Failed to flush to session begin file."
      // 17d: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Flushable;Ljava/lang/String;)V
      // 180: aload 4
      // 182: ldc_w "Failed to close fatal exception file output stream."
      // 185: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // 188: aload 1
      // 189: athrow
      // 18a: astore 1
      // 18b: goto 179
      // 18e: astore 7
      // 190: aload 6
      // 192: astore 1
      // 193: goto 14b
      // try (10 -> 13): 158 java/lang/Exception
      // try (10 -> 13): 177 null
      // try (15 -> 20): 158 java/lang/Exception
      // try (15 -> 20): 177 null
      // try (27 -> 53): 158 java/lang/Exception
      // try (27 -> 53): 177 null
      // try (57 -> 75): 158 java/lang/Exception
      // try (57 -> 75): 177 null
      // try (81 -> 84): 192 java/lang/Exception
      // try (81 -> 84): 190 null
      // try (90 -> 92): 192 java/lang/Exception
      // try (90 -> 92): 190 null
      // try (98 -> 102): 192 java/lang/Exception
      // try (98 -> 102): 190 null
      // try (108 -> 112): 192 java/lang/Exception
      // try (108 -> 112): 190 null
      // try (118 -> 120): 192 java/lang/Exception
      // try (118 -> 120): 190 null
      // try (126 -> 134): 192 java/lang/Exception
      // try (126 -> 134): 190 null
      // try (140 -> 145): 192 java/lang/Exception
      // try (140 -> 145): 190 null
      // try (165 -> 170): 190 null
   }

   private void b(SettingsData var1) {
      if (var1 == null) {
         Fabric.h().d("CrashlyticsCore", "Cannot send reports. Settings are unavailable.");
      } else {
         Context var4 = this.i.r();
         CreateReportSpiCall var7 = this.h(var1.a.d);
         ReportUploader var8 = new ReportUploader(this.o.a, var7, this.r, this.s);
         File[] var5 = this.b();
         int var3 = var5.length;

         for (int var2 = 0; var2 < var3; var2++) {
            SessionReport var6 = new SessionReport(var5[var2], f);
            this.j.a(new CrashlyticsController.SendReportRunnable(var4, var6, var8));
         }
      }
   }

   private static void b(String var0, String var1) {
      Answers var2 = Fabric.a(Answers.class);
      if (var2 == null) {
         Fabric.h().a("CrashlyticsCore", "Answers is not available");
      } else {
         var2.a(new Crash.FatalException(var0, var1));
      }
   }

   private void b(Date param1, Thread param2, Throwable param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aconst_null
      // 001: astore 4
      // 003: aconst_null
      // 004: astore 8
      // 006: aconst_null
      // 007: astore 7
      // 009: aconst_null
      // 00a: astore 5
      // 00c: aload 0
      // 00d: invokespecial com/crashlytics/android/core/CrashlyticsController.k ()Ljava/lang/String;
      // 010: astore 9
      // 012: aload 9
      // 014: ifnonnull 026
      // 017: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 01a: ldc "CrashlyticsCore"
      // 01c: ldc_w "Tried to write a non-fatal exception while no session was open."
      // 01f: aconst_null
      // 020: invokeinterface io/fabric/sdk/android/Logger.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V 4
      // 025: return
      // 026: aload 9
      // 028: aload 3
      // 029: invokevirtual java/lang/Object.getClass ()Ljava/lang/Class;
      // 02c: invokevirtual java/lang/Class.getName ()Ljava/lang/String;
      // 02f: invokestatic com/crashlytics/android/core/CrashlyticsController.a (Ljava/lang/String;Ljava/lang/String;)V
      // 032: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 035: astore 10
      // 037: new java/lang/StringBuilder
      // 03a: astore 6
      // 03c: aload 6
      // 03e: invokespecial java/lang/StringBuilder.<init> ()V
      // 041: aload 10
      // 043: ldc "CrashlyticsCore"
      // 045: aload 6
      // 047: ldc_w "Crashlytics is logging non-fatal exception \""
      // 04a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 04d: aload 3
      // 04e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 051: ldc_w "\" from thread "
      // 054: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 057: aload 2
      // 058: invokevirtual java/lang/Thread.getName ()Ljava/lang/String;
      // 05b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 05e: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 061: invokeinterface io/fabric/sdk/android/Logger.a (Ljava/lang/String;Ljava/lang/String;)V 3
      // 066: aload 0
      // 067: getfield com/crashlytics/android/core/CrashlyticsController.h Ljava/util/concurrent/atomic/AtomicInteger;
      // 06a: invokevirtual java/util/concurrent/atomic/AtomicInteger.getAndIncrement ()I
      // 06d: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (I)Ljava/lang/String;
      // 070: astore 10
      // 072: new java/lang/StringBuilder
      // 075: astore 6
      // 077: aload 6
      // 079: invokespecial java/lang/StringBuilder.<init> ()V
      // 07c: aload 6
      // 07e: aload 9
      // 080: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 083: ldc_w "SessionEvent"
      // 086: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 089: aload 10
      // 08b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 08e: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 091: astore 10
      // 093: new com/crashlytics/android/core/ClsFileOutputStream
      // 096: astore 6
      // 098: aload 6
      // 09a: aload 0
      // 09b: invokevirtual com/crashlytics/android/core/CrashlyticsController.f ()Ljava/io/File;
      // 09e: aload 10
      // 0a0: invokespecial com/crashlytics/android/core/ClsFileOutputStream.<init> (Ljava/io/File;Ljava/lang/String;)V
      // 0a3: aload 8
      // 0a5: astore 4
      // 0a7: aload 7
      // 0a9: astore 5
      // 0ab: aload 6
      // 0ad: invokestatic com/crashlytics/android/core/CodedOutputStream.a (Ljava/io/OutputStream;)Lcom/crashlytics/android/core/CodedOutputStream;
      // 0b0: astore 7
      // 0b2: aload 7
      // 0b4: astore 4
      // 0b6: aload 7
      // 0b8: astore 5
      // 0ba: aload 0
      // 0bb: aload 7
      // 0bd: aload 1
      // 0be: aload 2
      // 0bf: aload 3
      // 0c0: ldc_w "error"
      // 0c3: bipush 0
      // 0c4: invokespecial com/crashlytics/android/core/CrashlyticsController.a (Lcom/crashlytics/android/core/CodedOutputStream;Ljava/util/Date;Ljava/lang/Thread;Ljava/lang/Throwable;Ljava/lang/String;Z)V
      // 0c7: aload 7
      // 0c9: ldc_w "Failed to flush to non-fatal file."
      // 0cc: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Flushable;Ljava/lang/String;)V
      // 0cf: aload 6
      // 0d1: ldc_w "Failed to close non-fatal file output stream."
      // 0d4: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // 0d7: aload 0
      // 0d8: aload 9
      // 0da: bipush 64
      // 0dc: invokespecial com/crashlytics/android/core/CrashlyticsController.a (Ljava/lang/String;I)V
      // 0df: goto 025
      // 0e2: astore 1
      // 0e3: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 0e6: ldc "CrashlyticsCore"
      // 0e8: ldc_w "An error occurred when trimming non-fatal files."
      // 0eb: aload 1
      // 0ec: invokeinterface io/fabric/sdk/android/Logger.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V 4
      // 0f1: goto 025
      // 0f4: astore 2
      // 0f5: aconst_null
      // 0f6: astore 1
      // 0f7: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 0fa: ldc "CrashlyticsCore"
      // 0fc: ldc_w "An error occurred in the non-fatal exception logger"
      // 0ff: aload 2
      // 100: invokeinterface io/fabric/sdk/android/Logger.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V 4
      // 105: aload 5
      // 107: ldc_w "Failed to flush to non-fatal file."
      // 10a: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Flushable;Ljava/lang/String;)V
      // 10d: aload 1
      // 10e: ldc_w "Failed to close non-fatal file output stream."
      // 111: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // 114: goto 0d7
      // 117: astore 2
      // 118: aconst_null
      // 119: astore 1
      // 11a: aload 4
      // 11c: ldc_w "Failed to flush to non-fatal file."
      // 11f: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Flushable;Ljava/lang/String;)V
      // 122: aload 1
      // 123: ldc_w "Failed to close non-fatal file output stream."
      // 126: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // 129: aload 2
      // 12a: athrow
      // 12b: astore 2
      // 12c: aload 6
      // 12e: astore 1
      // 12f: goto 11a
      // 132: astore 2
      // 133: aload 5
      // 135: astore 4
      // 137: goto 11a
      // 13a: astore 2
      // 13b: aload 6
      // 13d: astore 1
      // 13e: goto 0f7
      // try (24 -> 69): 106 java/lang/Exception
      // try (24 -> 69): 121 null
      // try (73 -> 76): 140 java/lang/Exception
      // try (73 -> 76): 132 null
      // try (80 -> 88): 140 java/lang/Exception
      // try (80 -> 88): 132 null
      // try (94 -> 98): 99 java/lang/Exception
      // try (109 -> 114): 136 null
   }

   private File[] b(File var1) {
      return this.b(var1.listFiles());
   }

   private File[] b(String var1) {
      return this.a(new CrashlyticsController.SessionPartFileFilter(var1));
   }

   private File[] b(File[] var1) {
      File[] var2 = var1;
      if (var1 == null) {
         var2 = new File[0];
      }

      return var2;
   }

   private void c(String var1) throws Exception {
      Object var4 = null;

      ClsFileOutputStream var3;
      try {
         File var6 = this.f();
         StringBuilder var5 = new StringBuilder();
         var3 = new ClsFileOutputStream(var6, var5.append(var1).append("SessionApp").toString());
      } finally {
         ;
      }

      CodedOutputStream var22;
      try {
         var22 = CodedOutputStream.a(var3);
      } finally {
         CommonUtils.a((Flushable)var4, "Failed to flush to session app file.");
         CommonUtils.a(var3, "Failed to close session app file.");
         throw var1;
      }

      try {
         String var21 = this.l.c();
         String var7 = this.o.e;
         String var23 = this.o.f;
         var1 = this.l.b();
         int var2 = DeliveryMechanism.determineFrom(this.o.c).getId();
         SessionProtobufHelper.a(var22, var21, this.o.a, var7, var23, var1, var2, this.v);
      } finally {
         ;
      }

      CommonUtils.a(var22, "Failed to flush to session app file.");
      CommonUtils.a(var3, "Failed to close session app file.");
   }

   private void d(String param1) throws Exception {
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
      // 00: aconst_null
      // 01: astore 3
      // 02: aconst_null
      // 03: astore 4
      // 05: new com/crashlytics/android/core/ClsFileOutputStream
      // 08: astore 2
      // 09: aload 0
      // 0a: invokevirtual com/crashlytics/android/core/CrashlyticsController.f ()Ljava/io/File;
      // 0d: astore 5
      // 0f: new java/lang/StringBuilder
      // 12: astore 6
      // 14: aload 6
      // 16: invokespecial java/lang/StringBuilder.<init> ()V
      // 19: aload 2
      // 1a: aload 5
      // 1c: aload 6
      // 1e: aload 1
      // 1f: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 22: ldc "SessionOS"
      // 24: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 27: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 2a: invokespecial com/crashlytics/android/core/ClsFileOutputStream.<init> (Ljava/io/File;Ljava/lang/String;)V
      // 2d: aload 3
      // 2e: astore 1
      // 2f: aload 2
      // 30: invokestatic com/crashlytics/android/core/CodedOutputStream.a (Ljava/io/OutputStream;)Lcom/crashlytics/android/core/CodedOutputStream;
      // 33: astore 3
      // 34: aload 3
      // 35: astore 1
      // 36: aload 3
      // 37: aload 0
      // 38: getfield com/crashlytics/android/core/CrashlyticsController.i Lcom/crashlytics/android/core/CrashlyticsCore;
      // 3b: invokevirtual com/crashlytics/android/core/CrashlyticsCore.r ()Landroid/content/Context;
      // 3e: invokestatic io/fabric/sdk/android/services/common/CommonUtils.g (Landroid/content/Context;)Z
      // 41: invokestatic com/crashlytics/android/core/SessionProtobufHelper.a (Lcom/crashlytics/android/core/CodedOutputStream;Z)V
      // 44: aload 3
      // 45: ldc_w "Failed to flush to session OS file."
      // 48: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Flushable;Ljava/lang/String;)V
      // 4b: aload 2
      // 4c: ldc_w "Failed to close session OS file."
      // 4f: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // 52: return
      // 53: astore 3
      // 54: aconst_null
      // 55: astore 2
      // 56: aload 4
      // 58: astore 1
      // 59: aload 1
      // 5a: ldc_w "Failed to flush to session OS file."
      // 5d: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Flushable;Ljava/lang/String;)V
      // 60: aload 2
      // 61: ldc_w "Failed to close session OS file."
      // 64: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // 67: aload 3
      // 68: athrow
      // 69: astore 3
      // 6a: goto 59
      // try (4 -> 22): 42 null
      // try (24 -> 27): 55 null
      // try (29 -> 35): 55 null
   }

   private void e(String param1) throws Exception {
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
      // 000: aconst_null
      // 001: astore 15
      // 003: aconst_null
      // 004: astore 12
      // 006: aconst_null
      // 007: astore 14
      // 009: new com/crashlytics/android/core/ClsFileOutputStream
      // 00c: astore 13
      // 00e: aload 0
      // 00f: invokevirtual com/crashlytics/android/core/CrashlyticsController.f ()Ljava/io/File;
      // 012: astore 17
      // 014: new java/lang/StringBuilder
      // 017: astore 16
      // 019: aload 16
      // 01b: invokespecial java/lang/StringBuilder.<init> ()V
      // 01e: aload 13
      // 020: aload 17
      // 022: aload 16
      // 024: aload 1
      // 025: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 028: ldc "SessionDevice"
      // 02a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 02d: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 030: invokespecial com/crashlytics/android/core/ClsFileOutputStream.<init> (Ljava/io/File;Ljava/lang/String;)V
      // 033: aload 12
      // 035: astore 1
      // 036: aload 13
      // 038: invokestatic com/crashlytics/android/core/CodedOutputStream.a (Ljava/io/OutputStream;)Lcom/crashlytics/android/core/CodedOutputStream;
      // 03b: astore 12
      // 03d: aload 12
      // 03f: astore 1
      // 040: aload 0
      // 041: getfield com/crashlytics/android/core/CrashlyticsController.i Lcom/crashlytics/android/core/CrashlyticsCore;
      // 044: invokevirtual com/crashlytics/android/core/CrashlyticsCore.r ()Landroid/content/Context;
      // 047: astore 14
      // 049: aload 12
      // 04b: astore 1
      // 04c: new android/os/StatFs
      // 04f: astore 16
      // 051: aload 12
      // 053: astore 1
      // 054: aload 16
      // 056: invokestatic android/os/Environment.getDataDirectory ()Ljava/io/File;
      // 059: invokevirtual java/io/File.getPath ()Ljava/lang/String;
      // 05c: invokespecial android/os/StatFs.<init> (Ljava/lang/String;)V
      // 05f: aload 12
      // 061: astore 1
      // 062: aload 0
      // 063: getfield com/crashlytics/android/core/CrashlyticsController.l Lio/fabric/sdk/android/services/common/IdManager;
      // 066: invokevirtual io/fabric/sdk/android/services/common/IdManager.h ()Ljava/lang/String;
      // 069: astore 15
      // 06b: aload 12
      // 06d: astore 1
      // 06e: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a ()I
      // 071: istore 4
      // 073: aload 12
      // 075: astore 1
      // 076: invokestatic java/lang/Runtime.getRuntime ()Ljava/lang/Runtime;
      // 079: invokevirtual java/lang/Runtime.availableProcessors ()I
      // 07c: istore 2
      // 07d: aload 12
      // 07f: astore 1
      // 080: invokestatic io/fabric/sdk/android/services/common/CommonUtils.b ()J
      // 083: lstore 7
      // 085: aload 12
      // 087: astore 1
      // 088: aload 16
      // 08a: invokevirtual android/os/StatFs.getBlockCount ()I
      // 08d: i2l
      // 08e: lstore 9
      // 090: aload 12
      // 092: astore 1
      // 093: aload 16
      // 095: invokevirtual android/os/StatFs.getBlockSize ()I
      // 098: i2l
      // 099: lstore 5
      // 09b: aload 12
      // 09d: astore 1
      // 09e: aload 14
      // 0a0: invokestatic io/fabric/sdk/android/services/common/CommonUtils.f (Landroid/content/Context;)Z
      // 0a3: istore 11
      // 0a5: aload 12
      // 0a7: astore 1
      // 0a8: aload 0
      // 0a9: getfield com/crashlytics/android/core/CrashlyticsController.l Lio/fabric/sdk/android/services/common/IdManager;
      // 0ac: invokevirtual io/fabric/sdk/android/services/common/IdManager.i ()Ljava/util/Map;
      // 0af: astore 16
      // 0b1: aload 12
      // 0b3: astore 1
      // 0b4: aload 14
      // 0b6: invokestatic io/fabric/sdk/android/services/common/CommonUtils.h (Landroid/content/Context;)I
      // 0b9: istore 3
      // 0ba: aload 12
      // 0bc: astore 1
      // 0bd: aload 12
      // 0bf: aload 15
      // 0c1: iload 4
      // 0c3: getstatic android/os/Build.MODEL Ljava/lang/String;
      // 0c6: iload 2
      // 0c7: lload 7
      // 0c9: lload 9
      // 0cb: lload 5
      // 0cd: lmul
      // 0ce: iload 11
      // 0d0: aload 16
      // 0d2: iload 3
      // 0d3: getstatic android/os/Build.MANUFACTURER Ljava/lang/String;
      // 0d6: getstatic android/os/Build.PRODUCT Ljava/lang/String;
      // 0d9: invokestatic com/crashlytics/android/core/SessionProtobufHelper.a (Lcom/crashlytics/android/core/CodedOutputStream;Ljava/lang/String;ILjava/lang/String;IJJZLjava/util/Map;ILjava/lang/String;Ljava/lang/String;)V
      // 0dc: aload 12
      // 0de: ldc_w "Failed to flush session device info."
      // 0e1: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Flushable;Ljava/lang/String;)V
      // 0e4: aload 13
      // 0e6: ldc_w "Failed to close session device file."
      // 0e9: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // 0ec: return
      // 0ed: astore 12
      // 0ef: aload 15
      // 0f1: astore 13
      // 0f3: aload 14
      // 0f5: astore 1
      // 0f6: aload 1
      // 0f7: ldc_w "Failed to flush session device info."
      // 0fa: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Flushable;Ljava/lang/String;)V
      // 0fd: aload 13
      // 0ff: ldc_w "Failed to close session device file."
      // 102: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // 105: aload 12
      // 107: athrow
      // 108: astore 12
      // 10a: goto 0f6
      // try (6 -> 24): 116 null
      // try (26 -> 29): 129 null
      // try (31 -> 35): 129 null
      // try (37 -> 39): 129 null
      // try (41 -> 45): 129 null
      // try (47 -> 51): 129 null
      // try (53 -> 55): 129 null
      // try (57 -> 60): 129 null
      // try (62 -> 64): 129 null
      // try (66 -> 70): 129 null
      // try (72 -> 76): 129 null
      // try (78 -> 81): 129 null
      // try (83 -> 87): 129 null
      // try (89 -> 92): 129 null
      // try (94 -> 109): 129 null
   }

   private void f(String param1) throws Exception {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.insertSemaphore(FinallyProcessor.java:351)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:98)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aconst_null
      // 01: astore 3
      // 02: aconst_null
      // 03: astore 4
      // 05: new com/crashlytics/android/core/ClsFileOutputStream
      // 08: astore 5
      // 0a: aload 0
      // 0b: invokevirtual com/crashlytics/android/core/CrashlyticsController.f ()Ljava/io/File;
      // 0e: astore 7
      // 10: new java/lang/StringBuilder
      // 13: astore 6
      // 15: aload 6
      // 17: invokespecial java/lang/StringBuilder.<init> ()V
      // 1a: aload 5
      // 1c: aload 7
      // 1e: aload 6
      // 20: aload 1
      // 21: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 24: ldc "SessionUser"
      // 26: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 29: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 2c: invokespecial com/crashlytics/android/core/ClsFileOutputStream.<init> (Ljava/io/File;Ljava/lang/String;)V
      // 2f: aload 5
      // 31: invokestatic com/crashlytics/android/core/CodedOutputStream.a (Ljava/io/OutputStream;)Lcom/crashlytics/android/core/CodedOutputStream;
      // 34: astore 4
      // 36: aload 4
      // 38: astore 3
      // 39: aload 0
      // 3a: aload 1
      // 3b: invokespecial com/crashlytics/android/core/CrashlyticsController.g (Ljava/lang/String;)Lcom/crashlytics/android/core/UserMetaData;
      // 3e: astore 1
      // 3f: aload 4
      // 41: astore 3
      // 42: aload 1
      // 43: invokevirtual com/crashlytics/android/core/UserMetaData.a ()Z
      // 46: istore 2
      // 47: iload 2
      // 48: ifeq 5c
      // 4b: aload 4
      // 4d: ldc_w "Failed to flush session user file."
      // 50: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Flushable;Ljava/lang/String;)V
      // 53: aload 5
      // 55: ldc_w "Failed to close session user file."
      // 58: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // 5b: return
      // 5c: aload 4
      // 5e: astore 3
      // 5f: aload 4
      // 61: aload 1
      // 62: getfield com/crashlytics/android/core/UserMetaData.b Ljava/lang/String;
      // 65: aload 1
      // 66: getfield com/crashlytics/android/core/UserMetaData.c Ljava/lang/String;
      // 69: aload 1
      // 6a: getfield com/crashlytics/android/core/UserMetaData.d Ljava/lang/String;
      // 6d: invokestatic com/crashlytics/android/core/SessionProtobufHelper.a (Lcom/crashlytics/android/core/CodedOutputStream;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
      // 70: aload 4
      // 72: ldc_w "Failed to flush session user file."
      // 75: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Flushable;Ljava/lang/String;)V
      // 78: aload 5
      // 7a: ldc_w "Failed to close session user file."
      // 7d: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // 80: goto 5b
      // 83: astore 1
      // 84: aconst_null
      // 85: astore 3
      // 86: aload 4
      // 88: ldc_w "Failed to flush session user file."
      // 8b: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Flushable;Ljava/lang/String;)V
      // 8e: aload 3
      // 8f: ldc_w "Failed to close session user file."
      // 92: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a (Ljava/io/Closeable;Ljava/lang/String;)V
      // 95: aload 1
      // 96: athrow
      // 97: astore 1
      // 98: aload 3
      // 99: astore 4
      // 9b: aload 5
      // 9d: astore 3
      // 9e: goto 86
      // try (4 -> 22): 62 null
      // try (22 -> 25): 73 null
      // try (27 -> 31): 73 null
      // try (33 -> 36): 73 null
      // try (47 -> 55): 73 null
   }

   private UserMetaData g(String var1) {
      UserMetaData var2;
      if (this.e()) {
         var2 = new UserMetaData(this.i.h(), this.i.j(), this.i.i());
      } else {
         var2 = new MetaDataStore(this.f()).a(var1);
      }

      return var2;
   }

   private CreateReportSpiCall h(String var1) {
      String var2 = CommonUtils.b(this.i.r(), "com.crashlytics.ApiEndpoint");
      return new DefaultCreateReportSpiCall(this.i, var2, var1, this.k);
   }

   private String k() {
      File[] var1 = this.n();
      String var2;
      if (var1.length > 0) {
         var2 = a(var1[0]);
      } else {
         var2 = null;
      }

      return var2;
   }

   private String l() {
      File[] var1 = this.n();
      String var2;
      if (var1.length > 1) {
         var2 = a(var1[1]);
      } else {
         var2 = null;
      }

      return var2;
   }

   private void m() throws Exception {
      Date var2 = new Date();
      String var1 = new CLSUUID(this.l).toString();
      Fabric.h().a("CrashlyticsCore", "Opening a new session with ID " + var1);
      this.a(var1, var2);
      this.c(var1);
      this.d(var1);
      this.e(var1);
      this.q.a(var1);
   }

   private File[] n() {
      File[] var1 = this.c();
      Arrays.sort(var1, b);
      return var1;
   }

   private void o() {
      File var2 = this.i();
      if (var2.exists()) {
         File[] var3 = this.a(var2, new CrashlyticsController.InvalidPartFileFilter());
         Arrays.sort(var3, Collections.reverseOrder());
         HashSet var4 = new HashSet();

         for (int var1 = 0; var1 < var3.length && var4.size() < 4; var1++) {
            var4.add(a(var3[var1]));
         }

         this.a(this.b(var2), var4);
      }
   }

   void a() {
      this.j.b(new Callable<Void>(this) {
         final CrashlyticsController a;

         {
            this.a = var1;
         }

         public Void a() throws Exception {
            this.a.m();
            return null;
         }
      });
   }

   void a(float var1, SettingsData var2) {
      if (var2 == null) {
         Fabric.h().d("CrashlyticsCore", "Could not send reports. Settings are not available.");
      } else {
         CreateReportSpiCall var3 = this.h(var2.a.d);
         ReportUploader.SendCheck var4;
         if (this.a(var2)) {
            var4 = new CrashlyticsController.PrivacyDialogCheck(this.i, this.m, var2.c);
         } else {
            var4 = new ReportUploader.AlwaysSendCheck();
         }

         new ReportUploader(this.o.a, var3, this.r, this.s).a(var1, var4);
      }
   }

   void a(int var1) {
      var1 -= Utils.a(this.g(), var1, c);
      int var2 = Utils.a(this.h(), var1, c);
      Utils.a(this.f(), a, var1 - var2, c);
   }

   void a(SessionEventData var1) {
      this.j.b(new Callable<Void>(this, var1) {
         final SessionEventData a;
         final CrashlyticsController b;

         {
            this.b = var1;
            this.a = var2;
         }

         public Void a() throws Exception {
            if (!this.b.e()) {
               this.b.b(this.a);
            }

            return null;
         }
      });
   }

   void a(UncaughtExceptionHandler var1) {
      this.a();
      this.w = new CrashlyticsUncaughtExceptionHandler(new CrashlyticsUncaughtExceptionHandler.CrashListener(this) {
         final CrashlyticsController a;

         {
            this.a = var1;
         }

         @Override
         public void a(Thread var1, Throwable var2) {
            this.a.a(var1, var2);
         }
      }, var1);
      Thread.setDefaultUncaughtExceptionHandler(this.w);
   }

   void a(Thread var1, Throwable var2) {
      synchronized (this) {
         Logger var3 = Fabric.h();
         StringBuilder var4 = new StringBuilder();
         var3.a(
            "CrashlyticsCore",
            var4.append("Crashlytics is handling uncaught exception \"").append(var2).append("\" from thread ").append(var1.getName()).toString()
         );
         this.t.b();
         Date var8 = new Date();
         CrashlyticsBackgroundWorker var5 = this.j;
         Callable var9 = new Callable<Void>(this, var8, var1, var2) {
            final Date a;
            final Thread b;
            final Throwable c;
            final CrashlyticsController d;

            {
               this.d = var1;
               this.a = var2x;
               this.b = var3x;
               this.c = var4x;
            }

            public Void a() throws Exception {
               this.d.i.o();
               this.d.a(this.a, this.b, this.c);
               SettingsData var2x = Settings.a().b();
               SessionSettingsData var1x;
               if (var2x != null) {
                  var1x = var2x.b;
               } else {
                  var1x = null;
               }

               this.d.b(var1x);
               this.d.m();
               if (var1x != null) {
                  this.d.a(var1x.g);
               }

               if (!this.d.a(var2x)) {
                  this.d.b(var2x);
               }

               return null;
            }
         };
         var5.a(var9);
      }
   }

   void a(File[] var1) {
      byte var3 = 0;
      HashSet var5 = new HashSet();

      for (File var6 : var1) {
         Fabric.h().a("CrashlyticsCore", "Found invalid session part file: " + var6);
         var5.add(a(var6));
      }

      if (!var5.isEmpty()) {
         File var7 = this.i();
         if (!var7.exists()) {
            var7.mkdir();
         }

         File[] var11 = this.a(new FilenameFilter(this, var5) {
            final Set a;
            final CrashlyticsController b;

            {
               this.b = var1;
               this.a = var2;
            }

            @Override
            public boolean accept(File var1, String var2) {
               boolean var3x = false;
               if (var2.length() >= 35) {
                  var3x = this.a.contains(var2.substring(0, 35));
               }

               return var3x;
            }
         });
         int var9 = var11.length;

         for (int var8 = var3; var8 < var9; var8++) {
            File var10 = var11[var8];
            Fabric.h().a("CrashlyticsCore", "Moving session file: " + var10);
            if (!var10.renameTo(new File(var7, var10.getName()))) {
               Fabric.h().a("CrashlyticsCore", "Could not move session file. Deleting " + var10);
               var10.delete();
            }
         }

         this.o();
      }
   }

   boolean a(SessionSettingsData var1) {
      return this.j.a(new Callable<Boolean>(this, var1) {
         final SessionSettingsData a;
         final CrashlyticsController b;

         {
            this.b = var1;
            this.a = var2;
         }

         public Boolean a() throws Exception {
            Boolean var1x;
            if (this.b.e()) {
               Fabric.h().a("CrashlyticsCore", "Skipping session finalization because a crash has already occurred.");
               var1x = Boolean.FALSE;
            } else {
               Fabric.h().a("CrashlyticsCore", "Finalizing previously open sessions.");
               this.b.a(this.a, true);
               Fabric.h().a("CrashlyticsCore", "Closed all previously open sessions");
               var1x = Boolean.TRUE;
            }

            return var1x;
         }
      });
   }

   void b(SessionSettingsData var1) throws Exception {
      this.a(var1, false);
   }

   void b(Thread var1, Throwable var2) {
      Date var3 = new Date();
      this.j.a(new Runnable(this, var3, var1, var2) {
         final Date a;
         final Thread b;
         final Throwable c;
         final CrashlyticsController d;

         {
            this.d = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4;
         }

         @Override
         public void run() {
            if (!this.d.e()) {
               this.d.b(this.a, this.b, this.c);
            }
         }
      });
   }

   File[] b() {
      LinkedList var1 = new LinkedList();
      Collections.addAll(var1, this.a(this.g(), a));
      Collections.addAll(var1, this.a(this.h(), a));
      Collections.addAll(var1, this.a(this.f(), a));
      return var1.toArray(new File[var1.size()]);
   }

   File[] c() {
      return this.a(new CrashlyticsController.FileNameContainsFilter("BeginSession"));
   }

   void d() {
      this.j.a(new Runnable(this) {
         final CrashlyticsController a;

         {
            this.a = var1;
         }

         @Override
         public void run() {
            this.a.a(this.a.a(new CrashlyticsController.InvalidPartFileFilter()));
         }
      });
   }

   boolean e() {
      boolean var1;
      if (this.w != null && this.w.a()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   File f() {
      return this.n.a();
   }

   File g() {
      return new File(this.f(), "fatal-sessions");
   }

   File h() {
      return new File(this.f(), "nonfatal-sessions");
   }

   File i() {
      return new File(this.f(), "invalidClsFiles");
   }

   private static class AnySessionPartFileFilter implements FilenameFilter {
      private AnySessionPartFileFilter() {
      }

      @Override
      public boolean accept(File var1, String var2) {
         boolean var3;
         if (!CrashlyticsController.a.accept(var1, var2) && CrashlyticsController.e.matcher(var2).matches()) {
            var3 = true;
         } else {
            var3 = false;
         }

         return var3;
      }
   }

   static class FileNameContainsFilter implements FilenameFilter {
      private final String a;

      public FileNameContainsFilter(String var1) {
         this.a = var1;
      }

      @Override
      public boolean accept(File var1, String var2) {
         boolean var3;
         if (var2.contains(this.a) && !var2.endsWith(".cls_temp")) {
            var3 = true;
         } else {
            var3 = false;
         }

         return var3;
      }
   }

   static class InvalidPartFileFilter implements FilenameFilter {
      @Override
      public boolean accept(File var1, String var2) {
         boolean var3;
         if (!ClsFileOutputStream.a.accept(var1, var2) && !var2.contains("SessionMissingBinaryImages")) {
            var3 = false;
         } else {
            var3 = true;
         }

         return var3;
      }
   }

   private static final class LogFileDirectoryProvider implements LogFileManager.DirectoryProvider {
      private final FileStore a;

      public LogFileDirectoryProvider(FileStore var1) {
         this.a = var1;
      }

      @Override
      public File a() {
         File var1 = new File(this.a.a(), "log-files");
         if (!var1.exists()) {
            var1.mkdirs();
         }

         return var1;
      }
   }

   private static final class PrivacyDialogCheck implements ReportUploader.SendCheck {
      private final Kit a;
      private final PreferenceManager b;
      private final PromptSettingsData c;

      public PrivacyDialogCheck(Kit var1, PreferenceManager var2, PromptSettingsData var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }

      @Override
      public boolean a() {
         Activity var2 = this.a.s().b();
         boolean var1;
         if (var2 != null && !var2.isFinishing()) {
            CrashPromptDialog.AlwaysSendCallback var3 = new CrashPromptDialog.AlwaysSendCallback(this) {
               final CrashlyticsController.PrivacyDialogCheck a;

               {
                  this.a = var1;
               }

               @Override
               public void a(boolean var1) {
                  this.a.b.a(var1);
               }
            };
            CrashPromptDialog var4 = CrashPromptDialog.a(var2, this.c, var3);
            var2.runOnUiThread(new Runnable(this, var4) {
               final CrashPromptDialog a;
               final CrashlyticsController.PrivacyDialogCheck b;

               {
                  this.b = var1;
                  this.a = var2x;
               }

               @Override
               public void run() {
                  this.a.a();
               }
            });
            Fabric.h().a("CrashlyticsCore", "Waiting for user opt-in.");
            var4.b();
            var1 = var4.c();
         } else {
            var1 = true;
         }

         return var1;
      }
   }

   private final class ReportUploaderFilesProvider implements ReportUploader.ReportFilesProvider {
      final CrashlyticsController a;

      private ReportUploaderFilesProvider(CrashlyticsController var1) {
         this.a = var1;
      }

      @Override
      public File[] a() {
         return this.a.b();
      }

      @Override
      public File[] b() {
         return this.a.i().listFiles();
      }
   }

   private final class ReportUploaderHandlingExceptionCheck implements ReportUploader.HandlingExceptionCheck {
      final CrashlyticsController a;

      private ReportUploaderHandlingExceptionCheck(CrashlyticsController var1) {
         this.a = var1;
      }

      @Override
      public boolean a() {
         return this.a.e();
      }
   }

   private static final class SendReportRunnable implements Runnable {
      private final Context a;
      private final Report b;
      private final ReportUploader c;

      public SendReportRunnable(Context var1, Report var2, ReportUploader var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }

      @Override
      public void run() {
         if (CommonUtils.n(this.a)) {
            Fabric.h().a("CrashlyticsCore", "Attempting to send crash report at time of crash...");
            this.c.a(this.b);
         }
      }
   }

   static class SessionPartFileFilter implements FilenameFilter {
      private final String a;

      public SessionPartFileFilter(String var1) {
         this.a = var1;
      }

      @Override
      public boolean accept(File var1, String var2) {
         boolean var4 = false;
         boolean var3;
         if (var2.equals(this.a + ".cls")) {
            var3 = var4;
         } else {
            var3 = var4;
            if (var2.contains(this.a)) {
               var3 = var4;
               if (!var2.endsWith(".cls_temp")) {
                  var3 = true;
               }
            }
         }

         return var3;
      }
   }
}
