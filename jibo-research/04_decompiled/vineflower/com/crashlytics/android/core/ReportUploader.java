package com.crashlytics.android.core;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.common.BackgroundPriorityRunnable;
import java.io.File;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class ReportUploader {
   static final Map<String, String> a = Collections.singletonMap("X-CRASHLYTICS-INVALID-SESSION", "1");
   private static final short[] b = new short[]{10, 20, 30, 60, 120, 300};
   private final Object c = new Object();
   private final CreateReportSpiCall d;
   private final String e;
   private final ReportUploader.ReportFilesProvider f;
   private final ReportUploader.HandlingExceptionCheck g;
   private Thread h;

   public ReportUploader(String var1, CreateReportSpiCall var2, ReportUploader.ReportFilesProvider var3, ReportUploader.HandlingExceptionCheck var4) {
      if (var2 == null) {
         throw new IllegalArgumentException("createReportCall must not be null.");
      }

      this.d = var2;
      this.e = var1;
      this.f = var3;
      this.g = var4;
   }

   List<Report> a() {
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
      // 000: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 003: ldc "CrashlyticsCore"
      // 005: ldc "Checking for crash reports..."
      // 007: invokeinterface io/fabric/sdk/android/Logger.a (Ljava/lang/String;Ljava/lang/String;)V 3
      // 00c: aload 0
      // 00d: getfield com/crashlytics/android/core/ReportUploader.c Ljava/lang/Object;
      // 010: astore 3
      // 011: aload 3
      // 012: monitorenter
      // 013: aload 0
      // 014: getfield com/crashlytics/android/core/ReportUploader.f Lcom/crashlytics/android/core/ReportUploader$ReportFilesProvider;
      // 017: invokeinterface com/crashlytics/android/core/ReportUploader$ReportFilesProvider.a ()[Ljava/io/File; 1
      // 01c: astore 4
      // 01e: aload 0
      // 01f: getfield com/crashlytics/android/core/ReportUploader.f Lcom/crashlytics/android/core/ReportUploader$ReportFilesProvider;
      // 022: invokeinterface com/crashlytics/android/core/ReportUploader$ReportFilesProvider.b ()[Ljava/io/File; 1
      // 027: astore 5
      // 029: aload 3
      // 02a: monitorexit
      // 02b: new java/util/LinkedList
      // 02e: dup
      // 02f: invokespecial java/util/LinkedList.<init> ()V
      // 032: astore 3
      // 033: aload 4
      // 035: ifnull 087
      // 038: aload 4
      // 03a: arraylength
      // 03b: istore 2
      // 03c: bipush 0
      // 03d: istore 1
      // 03e: iload 1
      // 03f: iload 2
      // 040: if_icmpge 087
      // 043: aload 4
      // 045: iload 1
      // 046: aaload
      // 047: astore 6
      // 049: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 04c: ldc "CrashlyticsCore"
      // 04e: new java/lang/StringBuilder
      // 051: dup
      // 052: invokespecial java/lang/StringBuilder.<init> ()V
      // 055: ldc "Found crash report "
      // 057: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 05a: aload 6
      // 05c: invokevirtual java/io/File.getPath ()Ljava/lang/String;
      // 05f: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 062: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 065: invokeinterface io/fabric/sdk/android/Logger.a (Ljava/lang/String;Ljava/lang/String;)V 3
      // 06a: aload 3
      // 06b: new com/crashlytics/android/core/SessionReport
      // 06e: dup
      // 06f: aload 6
      // 071: invokespecial com/crashlytics/android/core/SessionReport.<init> (Ljava/io/File;)V
      // 074: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 079: pop
      // 07a: iinc 1 1
      // 07d: goto 03e
      // 080: astore 4
      // 082: aload 3
      // 083: monitorexit
      // 084: aload 4
      // 086: athrow
      // 087: new java/util/HashMap
      // 08a: dup
      // 08b: invokespecial java/util/HashMap.<init> ()V
      // 08e: astore 4
      // 090: aload 5
      // 092: ifnull 0e4
      // 095: aload 5
      // 097: arraylength
      // 098: istore 2
      // 099: bipush 0
      // 09a: istore 1
      // 09b: iload 1
      // 09c: iload 2
      // 09d: if_icmpge 0e4
      // 0a0: aload 5
      // 0a2: iload 1
      // 0a3: aaload
      // 0a4: astore 7
      // 0a6: aload 7
      // 0a8: invokestatic com/crashlytics/android/core/CrashlyticsController.a (Ljava/io/File;)Ljava/lang/String;
      // 0ab: astore 6
      // 0ad: aload 4
      // 0af: aload 6
      // 0b1: invokeinterface java/util/Map.containsKey (Ljava/lang/Object;)Z 2
      // 0b6: ifne 0ca
      // 0b9: aload 4
      // 0bb: aload 6
      // 0bd: new java/util/LinkedList
      // 0c0: dup
      // 0c1: invokespecial java/util/LinkedList.<init> ()V
      // 0c4: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 0c9: pop
      // 0ca: aload 4
      // 0cc: aload 6
      // 0ce: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 0d3: checkcast java/util/List
      // 0d6: aload 7
      // 0d8: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 0dd: pop
      // 0de: iinc 1 1
      // 0e1: goto 09b
      // 0e4: aload 4
      // 0e6: invokeinterface java/util/Map.keySet ()Ljava/util/Set; 1
      // 0eb: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 0f0: astore 6
      // 0f2: aload 6
      // 0f4: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0f9: ifeq 15b
      // 0fc: aload 6
      // 0fe: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 103: checkcast java/lang/String
      // 106: astore 7
      // 108: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 10b: ldc "CrashlyticsCore"
      // 10d: new java/lang/StringBuilder
      // 110: dup
      // 111: invokespecial java/lang/StringBuilder.<init> ()V
      // 114: ldc "Found invalid session: "
      // 116: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 119: aload 7
      // 11b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 11e: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 121: invokeinterface io/fabric/sdk/android/Logger.a (Ljava/lang/String;Ljava/lang/String;)V 3
      // 126: aload 4
      // 128: aload 7
      // 12a: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 12f: checkcast java/util/List
      // 132: astore 5
      // 134: aload 3
      // 135: new com/crashlytics/android/core/InvalidSessionReport
      // 138: dup
      // 139: aload 7
      // 13b: aload 5
      // 13d: aload 5
      // 13f: invokeinterface java/util/List.size ()I 1
      // 144: anewarray 120
      // 147: invokeinterface java/util/List.toArray ([Ljava/lang/Object;)[Ljava/lang/Object; 2
      // 14c: checkcast [Ljava/io/File;
      // 14f: invokespecial com/crashlytics/android/core/InvalidSessionReport.<init> (Ljava/lang/String;[Ljava/io/File;)V
      // 152: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 157: pop
      // 158: goto 0f2
      // 15b: aload 3
      // 15c: invokeinterface java/util/List.isEmpty ()Z 1
      // 161: ifeq 170
      // 164: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 167: ldc "CrashlyticsCore"
      // 169: ldc "No reports found."
      // 16b: invokeinterface io/fabric/sdk/android/Logger.a (Ljava/lang/String;Ljava/lang/String;)V 3
      // 170: aload 3
      // 171: areturn
      // try (9 -> 19): 58 null
      // try (59 -> 61): 58 null
   }

   public void a(float var1, ReportUploader.SendCheck var2) {
      synchronized (this) {
         if (this.h != null) {
            Fabric.h().a("CrashlyticsCore", "Report upload has already been started.");
         } else {
            ReportUploader.Worker var3 = new ReportUploader.Worker(this, var1, var2);
            Thread var6 = new Thread(var3, "Crashlytics Report Uploader");
            this.h = var6;
            this.h.start();
         }
      }
   }

   boolean a(Report param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 3
      // 02: aload 0
      // 03: getfield com/crashlytics/android/core/ReportUploader.c Ljava/lang/Object;
      // 06: astore 6
      // 08: aload 6
      // 0a: monitorenter
      // 0b: new com/crashlytics/android/core/CreateReportRequest
      // 0e: astore 5
      // 10: aload 5
      // 12: aload 0
      // 13: getfield com/crashlytics/android/core/ReportUploader.e Ljava/lang/String;
      // 16: aload 1
      // 17: invokespecial com/crashlytics/android/core/CreateReportRequest.<init> (Ljava/lang/String;Lcom/crashlytics/android/core/Report;)V
      // 1a: aload 0
      // 1b: getfield com/crashlytics/android/core/ReportUploader.d Lcom/crashlytics/android/core/CreateReportSpiCall;
      // 1e: aload 5
      // 20: invokeinterface com/crashlytics/android/core/CreateReportSpiCall.a (Lcom/crashlytics/android/core/CreateReportRequest;)Z 2
      // 25: istore 4
      // 27: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 2a: astore 7
      // 2c: new java/lang/StringBuilder
      // 2f: astore 5
      // 31: aload 5
      // 33: invokespecial java/lang/StringBuilder.<init> ()V
      // 36: aload 5
      // 38: ldc "Crashlytics report upload "
      // 3a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 3d: astore 8
      // 3f: iload 4
      // 41: ifeq 78
      // 44: ldc "complete: "
      // 46: astore 5
      // 48: aload 7
      // 4a: ldc "CrashlyticsCore"
      // 4c: aload 8
      // 4e: aload 5
      // 50: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 53: aload 1
      // 54: invokeinterface com/crashlytics/android/core/Report.b ()Ljava/lang/String; 1
      // 59: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 5c: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 5f: invokeinterface io/fabric/sdk/android/Logger.c (Ljava/lang/String;Ljava/lang/String;)V 3
      // 64: iload 3
      // 65: istore 2
      // 66: iload 4
      // 68: ifeq 73
      // 6b: aload 1
      // 6c: invokeinterface com/crashlytics/android/core/Report.f ()V 1
      // 71: bipush 1
      // 72: istore 2
      // 73: aload 6
      // 75: monitorexit
      // 76: iload 2
      // 77: ireturn
      // 78: ldc "FAILED: "
      // 7a: astore 5
      // 7c: goto 48
      // 7f: astore 5
      // 81: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 84: astore 7
      // 86: new java/lang/StringBuilder
      // 89: astore 8
      // 8b: aload 8
      // 8d: invokespecial java/lang/StringBuilder.<init> ()V
      // 90: aload 7
      // 92: ldc "CrashlyticsCore"
      // 94: aload 8
      // 96: ldc "Error occurred sending report "
      // 98: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 9b: aload 1
      // 9c: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 9f: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // a2: aload 5
      // a4: invokeinterface io/fabric/sdk/android/Logger.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V 4
      // a9: iload 3
      // aa: istore 2
      // ab: goto 73
      // ae: astore 1
      // af: aload 6
      // b1: monitorexit
      // b2: aload 1
      // b3: athrow
      // try (7 -> 29): 58 java/lang/Exception
      // try (7 -> 29): 78 null
      // try (33 -> 43): 58 java/lang/Exception
      // try (33 -> 43): 78 null
      // try (47 -> 49): 58 java/lang/Exception
      // try (47 -> 49): 78 null
      // try (51 -> 53): 78 null
      // try (59 -> 75): 78 null
      // try (79 -> 81): 78 null
   }

   static final class AlwaysSendCheck implements ReportUploader.SendCheck {
      @Override
      public boolean a() {
         return true;
      }
   }

   interface HandlingExceptionCheck {
      boolean a();
   }

   interface ReportFilesProvider {
      File[] a();

      File[] b();
   }

   interface SendCheck {
      boolean a();
   }

   private class Worker extends BackgroundPriorityRunnable {
      final ReportUploader a;
      private final float b;
      private final ReportUploader.SendCheck c;

      Worker(ReportUploader var1, float var2, ReportUploader.SendCheck var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }

      private void b() {
         Fabric.h().a("CrashlyticsCore", "Starting report processing in " + this.b + " second(s)...");
         if (this.b > 0.0F) {
            try {
               Thread.sleep((long)(this.b * 1000.0F));
            } catch (InterruptedException var7) {
               Thread.currentThread().interrupt();
               return;
            }
         }

         List var4 = this.a.a();
         if (!this.a.g.a()) {
            if (!var4.isEmpty() && !this.c.a()) {
               Fabric.h().a("CrashlyticsCore", "User declined to send. Removing " + var4.size() + " Report(s).");
               Iterator var9 = var4.iterator();

               while (var9.hasNext()) {
                  ((Report)var9.next()).f();
               }
            } else {
               int var1 = 0;

               while (!var4.isEmpty() && !this.a.g.a()) {
                  Fabric.h().a("CrashlyticsCore", "Attempting to send " + var4.size() + " report(s)");

                  for (Report var5 : var4) {
                     this.a.a(var5);
                  }

                  var4 = this.a.a();
                  if (!var4.isEmpty()) {
                     long var2 = ReportUploader.b[Math.min(var1, ReportUploader.b.length - 1)];
                     Fabric.h().a("CrashlyticsCore", "Report submisson: scheduling delayed retry in " + var2 + " seconds");

                     try {
                        Thread.sleep(var2 * 1000L);
                     } catch (InterruptedException var6) {
                        Thread.currentThread().interrupt();
                        break;
                     }

                     var1++;
                  }
               }
            }
         }
      }

      @Override
      public void a() {
         try {
            this.b();
         } catch (Exception var2) {
            Fabric.h().e("CrashlyticsCore", "An unexpected error occurred while attempting to upload crash reports.", var2);
         }

         this.a.h = null;
      }
   }
}
