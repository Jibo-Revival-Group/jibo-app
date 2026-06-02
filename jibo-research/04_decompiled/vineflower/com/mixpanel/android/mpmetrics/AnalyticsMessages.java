package com.mixpanel.android.mpmetrics;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.iid.InstanceID;
import com.mixpanel.android.util.HttpService;
import com.mixpanel.android.util.MPLog;
import com.mixpanel.android.util.RemoteService;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class AnalyticsMessages {
   private static final Map<Context, AnalyticsMessages> d = new HashMap<>();
   protected final Context a;
   protected final MPConfig b;
   private final AnalyticsMessages.Worker c;

   AnalyticsMessages(Context var1) {
      this.a = var1;
      this.b = this.c(var1);
      this.c = this.a();
      this.b().a();
   }

   public static AnalyticsMessages a(Context param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.util.collections.fixed.FastFixedSet.contains(Object)" because "predset" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.lambda$removeErroneousNodes$1(FastExtendedPostdominanceHelper.java:231)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.iterateReachability(FastExtendedPostdominanceHelper.java:373)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.removeErroneousNodes(FastExtendedPostdominanceHelper.java:207)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.getExtendedPostdominators(FastExtendedPostdominanceHelper.java:63)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.findGeneralStatement(DomHelper.java:537)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.processStatement(DomHelper.java:472)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.processStatement(DomHelper.java:379)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:208)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: getstatic com/mixpanel/android/mpmetrics/AnalyticsMessages.d Ljava/util/Map;
      // 03: astore 1
      // 04: aload 1
      // 05: monitorenter
      // 06: aload 0
      // 07: invokevirtual android/content/Context.getApplicationContext ()Landroid/content/Context;
      // 0a: astore 2
      // 0b: getstatic com/mixpanel/android/mpmetrics/AnalyticsMessages.d Ljava/util/Map;
      // 0e: aload 2
      // 0f: invokeinterface java/util/Map.containsKey (Ljava/lang/Object;)Z 2
      // 14: ifne 2f
      // 17: new com/mixpanel/android/mpmetrics/AnalyticsMessages
      // 1a: astore 0
      // 1b: aload 0
      // 1c: aload 2
      // 1d: invokespecial com/mixpanel/android/mpmetrics/AnalyticsMessages.<init> (Landroid/content/Context;)V
      // 20: getstatic com/mixpanel/android/mpmetrics/AnalyticsMessages.d Ljava/util/Map;
      // 23: aload 2
      // 24: aload 0
      // 25: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 2a: pop
      // 2b: aload 1
      // 2c: monitorexit
      // 2d: aload 0
      // 2e: areturn
      // 2f: getstatic com/mixpanel/android/mpmetrics/AnalyticsMessages.d Ljava/util/Map;
      // 32: aload 2
      // 33: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 38: checkcast com/mixpanel/android/mpmetrics/AnalyticsMessages
      // 3b: astore 0
      // 3c: goto 2b
      // 3f: astore 0
      // 40: aload 1
      // 41: monitorexit
      // 42: aload 0
      // 43: athrow
      // try (4 -> 21): 31 null
      // try (21 -> 23): 31 null
      // try (25 -> 30): 31 null
      // try (32 -> 34): 31 null
   }

   private void a(String var1) {
      MPLog.a("MixpanelAPI.Messages", var1 + " (Thread " + Thread.currentThread().getId() + ")");
   }

   private void a(String var1, Throwable var2) {
      MPLog.a("MixpanelAPI.Messages", var1 + " (Thread " + Thread.currentThread().getId() + ")", var2);
   }

   protected AnalyticsMessages.Worker a() {
      return new AnalyticsMessages.Worker(this);
   }

   public void a(AnalyticsMessages.EventDescription var1) {
      Message var2 = Message.obtain();
      var2.what = 1;
      var2.obj = var1;
      this.c.a(var2);
   }

   public void a(AnalyticsMessages.FlushDescription var1) {
      Message var3 = Message.obtain();
      var3.what = 2;
      var3.obj = var1.d();
      byte var2;
      if (var1.a()) {
         var2 = 1;
      } else {
         var2 = 0;
      }

      var3.arg1 = var2;
      this.c.a(var3);
   }

   public void a(AnalyticsMessages.PeopleDescription var1) {
      Message var2 = Message.obtain();
      var2.what = 0;
      var2.obj = var1;
      this.c.a(var2);
   }

   public void a(DecideMessages var1) {
      Message var2 = Message.obtain();
      var2.what = 12;
      var2.obj = var1;
      this.c.a(var2);
   }

   protected MPDbAdapter b(Context var1) {
      return MPDbAdapter.a(var1);
   }

   protected RemoteService b() {
      return new HttpService();
   }

   protected MPConfig c(Context var1) {
      return MPConfig.a(var1);
   }

   static class EventDescription extends AnalyticsMessages.MixpanelDescription {
      private final String a;
      private final JSONObject b;
      private final boolean c;

      public EventDescription(String var1, JSONObject var2, String var3, boolean var4) {
         super(var3);
         this.a = var1;
         this.b = var2;
         this.c = var4;
      }

      public String a() {
         return this.a;
      }

      public JSONObject b() {
         return this.b;
      }

      public boolean c() {
         return this.c;
      }
   }

   static class FlushDescription extends AnalyticsMessages.MixpanelDescription {
      private final boolean a;

      public FlushDescription(String var1) {
         this(var1, true);
      }

      protected FlushDescription(String var1, boolean var2) {
         super(var1);
         this.a = var2;
      }

      public boolean a() {
         return this.a;
      }
   }

   static class MixpanelDescription {
      private final String a;

      public MixpanelDescription(String var1) {
         this.a = var1;
      }

      public String d() {
         return this.a;
      }
   }

   static class PeopleDescription extends AnalyticsMessages.MixpanelDescription {
      private final JSONObject a;

      public PeopleDescription(JSONObject var1, String var2) {
         super(var2);
         this.a = var1;
      }

      public JSONObject a() {
         return this.a;
      }

      @Override
      public String toString() {
         return this.a.toString();
      }
   }

   class Worker {
      final AnalyticsMessages a;
      private final Object b;
      private Handler c;
      private long d;
      private long e;
      private long f;
      private SystemInformation g;

      public Worker(AnalyticsMessages var1) {
         this.a = var1;
         this.b = new Object();
         this.d = 0L;
         this.e = 0L;
         this.f = -1L;
         this.c = this.a();
      }

      private void b() {
         long var1 = System.currentTimeMillis();
         long var3 = this.d + 1L;
         if (this.f > 0L) {
            this.e = (var1 - this.f + this.e * this.d) / var3;
            long var5 = this.e / 1000L;
            this.a.a("Average send frequency approximately " + var5 + " seconds.");
         }

         this.f = var1;
         this.d = var3;
      }

      protected Handler a() {
         HandlerThread var1 = new HandlerThread("com.mixpanel.android.AnalyticsWorker", 10);
         var1.start();
         return new AnalyticsMessages.Worker.AnalyticsMessageHandler(this, var1.getLooper());
      }

      public void a(Message param1) {
         // $VF: Couldn't be decompiled
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.util.collections.fixed.FastFixedSet.contains(Object)" because "predset" is null
         //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.lambda$removeErroneousNodes$1(FastExtendedPostdominanceHelper.java:231)
         //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.iterateReachability(FastExtendedPostdominanceHelper.java:373)
         //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.removeErroneousNodes(FastExtendedPostdominanceHelper.java:207)
         //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.FastExtendedPostdominanceHelper.getExtendedPostdominators(FastExtendedPostdominanceHelper.java:63)
         //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.findGeneralStatement(DomHelper.java:537)
         //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.processStatement(DomHelper.java:472)
         //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.processStatement(DomHelper.java:379)
         //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:208)
         //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
         //
         // Bytecode:
         // 00: aload 0
         // 01: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.b Ljava/lang/Object;
         // 04: astore 2
         // 05: aload 2
         // 06: monitorenter
         // 07: aload 0
         // 08: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.c Landroid/os/Handler;
         // 0b: ifnonnull 34
         // 0e: aload 0
         // 0f: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;
         // 12: astore 4
         // 14: new java/lang/StringBuilder
         // 17: astore 3
         // 18: aload 3
         // 19: invokespecial java/lang/StringBuilder.<init> ()V
         // 1c: aload 4
         // 1e: aload 3
         // 1f: ldc "Dead mixpanel worker dropping a message: "
         // 21: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 24: aload 1
         // 25: getfield android/os/Message.what I
         // 28: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
         // 2b: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
         // 2e: invokestatic com/mixpanel/android/mpmetrics/AnalyticsMessages.a (Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;Ljava/lang/String;)V
         // 31: aload 2
         // 32: monitorexit
         // 33: return
         // 34: aload 0
         // 35: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.c Landroid/os/Handler;
         // 38: aload 1
         // 39: invokevirtual android/os/Handler.sendMessage (Landroid/os/Message;)Z
         // 3c: pop
         // 3d: goto 31
         // 40: astore 1
         // 41: aload 2
         // 42: monitorexit
         // 43: aload 1
         // 44: athrow
         // try (5 -> 24): 33 null
         // try (24 -> 26): 33 null
         // try (27 -> 32): 33 null
         // try (34 -> 36): 33 null
      }

      class AnalyticsMessageHandler extends Handler {
         final AnalyticsMessages.Worker a;
         private MPDbAdapter b;
         private final DecideChecker c;
         private final long d;
         private long e;
         private long f;
         private int g;

         public AnalyticsMessageHandler(AnalyticsMessages.Worker var1, Looper var2) {
            super(var2);
            this.a = var1;
            this.b = null;
            var1.g = SystemInformation.a(var1.a.a);
            this.c = this.a();
            this.d = var1.a.b.b();
         }

         private JSONObject a(AnalyticsMessages.EventDescription var1) throws JSONException {
            JSONObject var3 = new JSONObject();
            JSONObject var2 = var1.b();
            JSONObject var6 = this.b();
            var6.put("token", var1.d());
            if (var2 != null) {
               Iterator var4 = var2.keys();

               while (var4.hasNext()) {
                  String var5 = (String)var4.next();
                  var6.put(var5, var2.get(var5));
               }
            }

            var3.put("event", var1.a());
            var3.put("properties", var6);
            return var3;
         }

         private void a(MPDbAdapter var1, String var2) {
            if (!this.a.a.b().a(this.a.a.a, this.a.a.b.z())) {
               this.a.a.a("Not flushing data to Mixpanel because the device is not connected to the internet.");
            } else {
               this.a(var1, var2, MPDbAdapter.Table.EVENTS, this.a.a.b.k());
               this.a(var1, var2, MPDbAdapter.Table.PEOPLE, this.a.a.b.l());
            }
         }

         private void a(MPDbAdapter param1, String param2, MPDbAdapter.Table param3, String param4) {
            // $VF: Couldn't be decompiled
            // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
            // java.lang.RuntimeException: parsing failure!
            //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
            //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
            //
            // Bytecode:
            // 000: aload 0
            // 001: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;
            // 004: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;
            // 007: invokevirtual com/mixpanel/android/mpmetrics/AnalyticsMessages.b ()Lcom/mixpanel/android/util/RemoteService;
            // 00a: astore 14
            // 00c: aload 0
            // 00d: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.c Lcom/mixpanel/android/mpmetrics/DecideChecker;
            // 010: aload 2
            // 011: invokevirtual com/mixpanel/android/mpmetrics/DecideChecker.b (Ljava/lang/String;)Lcom/mixpanel/android/mpmetrics/DecideMessages;
            // 014: astore 11
            // 016: bipush 1
            // 017: istore 10
            // 019: aload 11
            // 01b: ifnull 026
            // 01e: aload 11
            // 020: invokevirtual com/mixpanel/android/mpmetrics/DecideMessages.d ()Ljava/lang/Boolean;
            // 023: ifnonnull 029
            // 026: bipush 0
            // 027: istore 10
            // 029: aload 1
            // 02a: aload 3
            // 02b: aload 2
            // 02c: iload 10
            // 02e: invokevirtual com/mixpanel/android/mpmetrics/MPDbAdapter.a (Lcom/mixpanel/android/mpmetrics/MPDbAdapter$Table;Ljava/lang/String;Z)[Ljava/lang/String;
            // 031: astore 13
            // 033: bipush 0
            // 034: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
            // 037: astore 11
            // 039: aload 13
            // 03b: astore 12
            // 03d: aload 13
            // 03f: ifnull 04f
            // 042: aload 13
            // 044: bipush 2
            // 045: aaload
            // 046: invokestatic java/lang/Integer.valueOf (Ljava/lang/String;)Ljava/lang/Integer;
            // 049: astore 11
            // 04b: aload 13
            // 04d: astore 12
            // 04f: aload 12
            // 051: ifnull 3c7
            // 054: aload 11
            // 056: invokevirtual java/lang/Integer.intValue ()I
            // 059: ifle 3c7
            // 05c: aload 12
            // 05e: bipush 0
            // 05f: aaload
            // 060: astore 13
            // 062: aload 12
            // 064: bipush 1
            // 065: aaload
            // 066: astore 15
            // 068: aload 15
            // 06a: invokestatic com/mixpanel/android/util/Base64Coder.a (Ljava/lang/String;)Ljava/lang/String;
            // 06d: astore 12
            // 06f: new java/util/HashMap
            // 072: dup
            // 073: invokespecial java/util/HashMap.<init> ()V
            // 076: astore 16
            // 078: aload 16
            // 07a: ldc "data"
            // 07c: aload 12
            // 07e: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
            // 083: pop
            // 084: getstatic com/mixpanel/android/mpmetrics/MPConfig.a Z
            // 087: ifeq 096
            // 08a: aload 16
            // 08c: ldc "verbose"
            // 08e: ldc "1"
            // 090: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
            // 095: pop
            // 096: bipush 1
            // 097: istore 6
            // 099: bipush 1
            // 09a: istore 5
            // 09c: aload 14
            // 09e: aload 4
            // 0a0: aload 16
            // 0a2: aload 0
            // 0a3: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;
            // 0a6: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;
            // 0a9: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages.b Lcom/mixpanel/android/mpmetrics/MPConfig;
            // 0ac: invokevirtual com/mixpanel/android/mpmetrics/MPConfig.y ()Ljavax/net/ssl/SSLSocketFactory;
            // 0af: invokeinterface com/mixpanel/android/util/RemoteService.a (Ljava/lang/String;Ljava/util/Map;Ljavax/net/ssl/SSLSocketFactory;)[B 4
            // 0b4: astore 16
            // 0b6: aload 16
            // 0b8: ifnonnull 14a
            // 0bb: bipush 0
            // 0bc: istore 9
            // 0be: bipush 0
            // 0bf: istore 7
            // 0c1: bipush 0
            // 0c2: istore 8
            // 0c4: iload 9
            // 0c6: istore 6
            // 0c8: iload 7
            // 0ca: istore 5
            // 0cc: aload 0
            // 0cd: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;
            // 0d0: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;
            // 0d3: astore 15
            // 0d5: iload 9
            // 0d7: istore 6
            // 0d9: iload 7
            // 0db: istore 5
            // 0dd: new java/lang/StringBuilder
            // 0e0: astore 12
            // 0e2: iload 9
            // 0e4: istore 6
            // 0e6: iload 7
            // 0e8: istore 5
            // 0ea: aload 12
            // 0ec: invokespecial java/lang/StringBuilder.<init> ()V
            // 0ef: iload 9
            // 0f1: istore 6
            // 0f3: iload 7
            // 0f5: istore 5
            // 0f7: aload 15
            // 0f9: aload 12
            // 0fb: ldc "Response was null, unexpected failure posting to "
            // 0fd: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
            // 100: aload 4
            // 102: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
            // 105: ldc "."
            // 107: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
            // 10a: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
            // 10d: invokestatic com/mixpanel/android/mpmetrics/AnalyticsMessages.a (Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;Ljava/lang/String;)V
            // 110: iload 8
            // 112: istore 5
            // 114: iload 5
            // 116: ifeq 34f
            // 119: aload 0
            // 11a: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;
            // 11d: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;
            // 120: ldc "Not retrying this batch of events, deleting them from DB."
            // 122: invokestatic com/mixpanel/android/mpmetrics/AnalyticsMessages.a (Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;Ljava/lang/String;)V
            // 125: aload 1
            // 126: aload 13
            // 128: aload 3
            // 129: aload 2
            // 12a: iload 10
            // 12c: invokevirtual com/mixpanel/android/mpmetrics/MPDbAdapter.a (Ljava/lang/String;Lcom/mixpanel/android/mpmetrics/MPDbAdapter$Table;Ljava/lang/String;Z)V
            // 12f: aload 1
            // 130: aload 3
            // 131: aload 2
            // 132: iload 10
            // 134: invokevirtual com/mixpanel/android/mpmetrics/MPDbAdapter.a (Lcom/mixpanel/android/mpmetrics/MPDbAdapter$Table;Ljava/lang/String;Z)[Ljava/lang/String;
            // 137: astore 12
            // 139: aload 12
            // 13b: ifnull 3d6
            // 13e: aload 12
            // 140: bipush 2
            // 141: aaload
            // 142: invokestatic java/lang/Integer.valueOf (Ljava/lang/String;)Ljava/lang/Integer;
            // 145: astore 11
            // 147: goto 04f
            // 14a: bipush 1
            // 14b: istore 7
            // 14d: bipush 1
            // 14e: istore 8
            // 150: bipush 1
            // 151: istore 9
            // 153: iload 7
            // 155: istore 6
            // 157: iload 8
            // 159: istore 5
            // 15b: new java/lang/String
            // 15e: astore 12
            // 160: iload 7
            // 162: istore 6
            // 164: iload 8
            // 166: istore 5
            // 168: aload 12
            // 16a: aload 16
            // 16c: ldc "UTF-8"
            // 16e: invokespecial java/lang/String.<init> ([BLjava/lang/String;)V
            // 171: iload 7
            // 173: istore 6
            // 175: iload 8
            // 177: istore 5
            // 179: aload 0
            // 17a: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.g I
            // 17d: ifle 19b
            // 180: iload 7
            // 182: istore 6
            // 184: iload 8
            // 186: istore 5
            // 188: aload 0
            // 189: bipush 0
            // 18a: putfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.g I
            // 18d: iload 7
            // 18f: istore 6
            // 191: iload 8
            // 193: istore 5
            // 195: aload 0
            // 196: bipush 2
            // 197: aload 2
            // 198: invokevirtual com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.removeMessages (ILjava/lang/Object;)V
            // 19b: iload 7
            // 19d: istore 6
            // 19f: iload 8
            // 1a1: istore 5
            // 1a3: aload 0
            // 1a4: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;
            // 1a7: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;
            // 1aa: astore 16
            // 1ac: iload 7
            // 1ae: istore 6
            // 1b0: iload 8
            // 1b2: istore 5
            // 1b4: new java/lang/StringBuilder
            // 1b7: astore 17
            // 1b9: iload 7
            // 1bb: istore 6
            // 1bd: iload 8
            // 1bf: istore 5
            // 1c1: aload 17
            // 1c3: invokespecial java/lang/StringBuilder.<init> ()V
            // 1c6: iload 7
            // 1c8: istore 6
            // 1ca: iload 8
            // 1cc: istore 5
            // 1ce: aload 16
            // 1d0: aload 17
            // 1d2: ldc "Successfully posted to "
            // 1d4: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
            // 1d7: aload 4
            // 1d9: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
            // 1dc: ldc ": \n"
            // 1de: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
            // 1e1: aload 15
            // 1e3: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
            // 1e6: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
            // 1e9: invokestatic com/mixpanel/android/mpmetrics/AnalyticsMessages.a (Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;Ljava/lang/String;)V
            // 1ec: iload 7
            // 1ee: istore 6
            // 1f0: iload 8
            // 1f2: istore 5
            // 1f4: aload 0
            // 1f5: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;
            // 1f8: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;
            // 1fb: astore 16
            // 1fd: iload 7
            // 1ff: istore 6
            // 201: iload 8
            // 203: istore 5
            // 205: new java/lang/StringBuilder
            // 208: astore 15
            // 20a: iload 7
            // 20c: istore 6
            // 20e: iload 8
            // 210: istore 5
            // 212: aload 15
            // 214: invokespecial java/lang/StringBuilder.<init> ()V
            // 217: iload 7
            // 219: istore 6
            // 21b: iload 8
            // 21d: istore 5
            // 21f: aload 16
            // 221: aload 15
            // 223: ldc "Response was "
            // 225: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
            // 228: aload 12
            // 22a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
            // 22d: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
            // 230: invokestatic com/mixpanel/android/mpmetrics/AnalyticsMessages.a (Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;Ljava/lang/String;)V
            // 233: iload 9
            // 235: istore 5
            // 237: goto 114
            // 23a: astore 12
            // 23c: iload 6
            // 23e: istore 5
            // 240: ldc "MixpanelAPI.Messages"
            // 242: new java/lang/StringBuilder
            // 245: dup
            // 246: invokespecial java/lang/StringBuilder.<init> ()V
            // 249: ldc_w "Out of memory when posting to "
            // 24c: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
            // 24f: aload 4
            // 251: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
            // 254: ldc "."
            // 256: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
            // 259: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
            // 25c: aload 12
            // 25e: invokestatic com/mixpanel/android/util/MPLog.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
            // 261: goto 114
            // 264: astore 15
            // 266: iload 7
            // 268: istore 6
            // 26a: iload 8
            // 26c: istore 5
            // 26e: new java/lang/RuntimeException
            // 271: astore 12
            // 273: iload 7
            // 275: istore 6
            // 277: iload 8
            // 279: istore 5
            // 27b: aload 12
            // 27d: ldc_w "UTF not supported on this platform?"
            // 280: aload 15
            // 282: invokespecial java/lang/RuntimeException.<init> (Ljava/lang/String;Ljava/lang/Throwable;)V
            // 285: iload 7
            // 287: istore 6
            // 289: iload 8
            // 28b: istore 5
            // 28d: aload 12
            // 28f: athrow
            // 290: astore 12
            // 292: ldc "MixpanelAPI.Messages"
            // 294: new java/lang/StringBuilder
            // 297: dup
            // 298: invokespecial java/lang/StringBuilder.<init> ()V
            // 29b: ldc_w "Cannot interpret "
            // 29e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
            // 2a1: aload 4
            // 2a3: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
            // 2a6: ldc_w " as a URL."
            // 2a9: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
            // 2ac: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
            // 2af: aload 12
            // 2b1: invokestatic com/mixpanel/android/util/MPLog.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
            // 2b4: goto 114
            // 2b7: astore 12
            // 2b9: aload 0
            // 2ba: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;
            // 2bd: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;
            // 2c0: new java/lang/StringBuilder
            // 2c3: dup
            // 2c4: invokespecial java/lang/StringBuilder.<init> ()V
            // 2c7: ldc_w "Cannot post message to "
            // 2ca: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
            // 2cd: aload 4
            // 2cf: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
            // 2d2: ldc "."
            // 2d4: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
            // 2d7: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
            // 2da: aload 12
            // 2dc: invokestatic com/mixpanel/android/mpmetrics/AnalyticsMessages.a (Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;Ljava/lang/String;Ljava/lang/Throwable;)V
            // 2df: bipush 0
            // 2e0: istore 5
            // 2e2: aload 0
            // 2e3: aload 12
            // 2e5: invokevirtual com/mixpanel/android/util/RemoteService$ServiceUnavailableException.a ()I
            // 2e8: sipush 1000
            // 2eb: imul
            // 2ec: i2l
            // 2ed: putfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.f J
            // 2f0: goto 114
            // 2f3: astore 12
            // 2f5: aload 0
            // 2f6: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;
            // 2f9: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;
            // 2fc: new java/lang/StringBuilder
            // 2ff: dup
            // 300: invokespecial java/lang/StringBuilder.<init> ()V
            // 303: ldc_w "Cannot post message to "
            // 306: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
            // 309: aload 4
            // 30b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
            // 30e: ldc "."
            // 310: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
            // 313: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
            // 316: aload 12
            // 318: invokestatic com/mixpanel/android/mpmetrics/AnalyticsMessages.a (Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;Ljava/lang/String;Ljava/lang/Throwable;)V
            // 31b: bipush 0
            // 31c: istore 5
            // 31e: goto 114
            // 321: astore 12
            // 323: aload 0
            // 324: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;
            // 327: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;
            // 32a: new java/lang/StringBuilder
            // 32d: dup
            // 32e: invokespecial java/lang/StringBuilder.<init> ()V
            // 331: ldc_w "Cannot post message to "
            // 334: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
            // 337: aload 4
            // 339: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
            // 33c: ldc "."
            // 33e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
            // 341: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
            // 344: aload 12
            // 346: invokestatic com/mixpanel/android/mpmetrics/AnalyticsMessages.a (Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;Ljava/lang/String;Ljava/lang/Throwable;)V
            // 349: bipush 0
            // 34a: istore 5
            // 34c: goto 114
            // 34f: aload 0
            // 350: bipush 2
            // 351: aload 2
            // 352: invokevirtual com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.removeMessages (ILjava/lang/Object;)V
            // 355: aload 0
            // 356: ldc2_w 2.0
            // 359: aload 0
            // 35a: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.g I
            // 35d: i2d
            // 35e: invokestatic java/lang/Math.pow (DD)D
            // 361: d2l
            // 362: ldc2_w 60000
            // 365: lmul
            // 366: aload 0
            // 367: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.f J
            // 36a: invokestatic java/lang/Math.max (JJ)J
            // 36d: putfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.f J
            // 370: aload 0
            // 371: aload 0
            // 372: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.f J
            // 375: ldc2_w 600000
            // 378: invokestatic java/lang/Math.min (JJ)J
            // 37b: putfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.f J
            // 37e: invokestatic android/os/Message.obtain ()Landroid/os/Message;
            // 381: astore 1
            // 382: aload 1
            // 383: bipush 2
            // 384: putfield android/os/Message.what I
            // 387: aload 1
            // 388: aload 2
            // 389: putfield android/os/Message.obj Ljava/lang/Object;
            // 38c: aload 0
            // 38d: aload 1
            // 38e: aload 0
            // 38f: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.f J
            // 392: invokevirtual com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.sendMessageDelayed (Landroid/os/Message;J)Z
            // 395: pop
            // 396: aload 0
            // 397: aload 0
            // 398: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.g I
            // 39b: bipush 1
            // 39c: iadd
            // 39d: putfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.g I
            // 3a0: aload 0
            // 3a1: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;
            // 3a4: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;
            // 3a7: new java/lang/StringBuilder
            // 3aa: dup
            // 3ab: invokespecial java/lang/StringBuilder.<init> ()V
            // 3ae: ldc_w "Retrying this batch of events in "
            // 3b1: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
            // 3b4: aload 0
            // 3b5: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.f J
            // 3b8: invokevirtual java/lang/StringBuilder.append (J)Ljava/lang/StringBuilder;
            // 3bb: ldc_w " ms"
            // 3be: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
            // 3c1: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
            // 3c4: invokestatic com/mixpanel/android/mpmetrics/AnalyticsMessages.a (Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;Ljava/lang/String;)V
            // 3c7: return
            // 3c8: astore 12
            // 3ca: iload 6
            // 3cc: istore 5
            // 3ce: goto 292
            // 3d1: astore 12
            // 3d3: goto 240
            // 3d6: goto 147
            // try (75 -> 85): 449 java/lang/OutOfMemoryError
            // try (75 -> 85): 445 java/net/MalformedURLException
            // try (75 -> 85): 322 com/mixpanel/android/util/RemoteService$ServiceUnavailableException
            // try (75 -> 85): 348 java/net/SocketTimeoutException
            // try (75 -> 85): 367 java/io/IOException
            // try (97 -> 101): 269 java/lang/OutOfMemoryError
            // try (97 -> 101): 307 java/net/MalformedURLException
            // try (97 -> 101): 322 com/mixpanel/android/util/RemoteService$ServiceUnavailableException
            // try (97 -> 101): 348 java/net/SocketTimeoutException
            // try (97 -> 101): 367 java/io/IOException
            // try (105 -> 107): 269 java/lang/OutOfMemoryError
            // try (105 -> 107): 307 java/net/MalformedURLException
            // try (105 -> 107): 322 com/mixpanel/android/util/RemoteService$ServiceUnavailableException
            // try (105 -> 107): 348 java/net/SocketTimeoutException
            // try (105 -> 107): 367 java/io/IOException
            // try (111 -> 113): 269 java/lang/OutOfMemoryError
            // try (111 -> 113): 307 java/net/MalformedURLException
            // try (111 -> 113): 322 com/mixpanel/android/util/RemoteService$ServiceUnavailableException
            // try (111 -> 113): 348 java/net/SocketTimeoutException
            // try (111 -> 113): 367 java/io/IOException
            // try (117 -> 127): 269 java/lang/OutOfMemoryError
            // try (117 -> 127): 307 java/net/MalformedURLException
            // try (117 -> 127): 322 com/mixpanel/android/util/RemoteService$ServiceUnavailableException
            // try (117 -> 127): 348 java/net/SocketTimeoutException
            // try (117 -> 127): 367 java/io/IOException
            // try (166 -> 168): 286 java/io/UnsupportedEncodingException
            // try (166 -> 168): 269 java/lang/OutOfMemoryError
            // try (166 -> 168): 307 java/net/MalformedURLException
            // try (166 -> 168): 322 com/mixpanel/android/util/RemoteService$ServiceUnavailableException
            // try (166 -> 168): 348 java/net/SocketTimeoutException
            // try (166 -> 168): 367 java/io/IOException
            // try (172 -> 176): 286 java/io/UnsupportedEncodingException
            // try (172 -> 176): 269 java/lang/OutOfMemoryError
            // try (172 -> 176): 307 java/net/MalformedURLException
            // try (172 -> 176): 322 com/mixpanel/android/util/RemoteService$ServiceUnavailableException
            // try (172 -> 176): 348 java/net/SocketTimeoutException
            // try (172 -> 176): 367 java/io/IOException
            // try (180 -> 183): 269 java/lang/OutOfMemoryError
            // try (180 -> 183): 307 java/net/MalformedURLException
            // try (180 -> 183): 322 com/mixpanel/android/util/RemoteService$ServiceUnavailableException
            // try (180 -> 183): 348 java/net/SocketTimeoutException
            // try (180 -> 183): 367 java/io/IOException
            // try (187 -> 190): 269 java/lang/OutOfMemoryError
            // try (187 -> 190): 307 java/net/MalformedURLException
            // try (187 -> 190): 322 com/mixpanel/android/util/RemoteService$ServiceUnavailableException
            // try (187 -> 190): 348 java/net/SocketTimeoutException
            // try (187 -> 190): 367 java/io/IOException
            // try (194 -> 198): 269 java/lang/OutOfMemoryError
            // try (194 -> 198): 307 java/net/MalformedURLException
            // try (194 -> 198): 322 com/mixpanel/android/util/RemoteService$ServiceUnavailableException
            // try (194 -> 198): 348 java/net/SocketTimeoutException
            // try (194 -> 198): 367 java/io/IOException
            // try (202 -> 206): 269 java/lang/OutOfMemoryError
            // try (202 -> 206): 307 java/net/MalformedURLException
            // try (202 -> 206): 322 com/mixpanel/android/util/RemoteService$ServiceUnavailableException
            // try (202 -> 206): 348 java/net/SocketTimeoutException
            // try (202 -> 206): 367 java/io/IOException
            // try (210 -> 212): 269 java/lang/OutOfMemoryError
            // try (210 -> 212): 307 java/net/MalformedURLException
            // try (210 -> 212): 322 com/mixpanel/android/util/RemoteService$ServiceUnavailableException
            // try (210 -> 212): 348 java/net/SocketTimeoutException
            // try (210 -> 212): 367 java/io/IOException
            // try (216 -> 218): 269 java/lang/OutOfMemoryError
            // try (216 -> 218): 307 java/net/MalformedURLException
            // try (216 -> 218): 322 com/mixpanel/android/util/RemoteService$ServiceUnavailableException
            // try (216 -> 218): 348 java/net/SocketTimeoutException
            // try (216 -> 218): 367 java/io/IOException
            // try (222 -> 234): 269 java/lang/OutOfMemoryError
            // try (222 -> 234): 307 java/net/MalformedURLException
            // try (222 -> 234): 322 com/mixpanel/android/util/RemoteService$ServiceUnavailableException
            // try (222 -> 234): 348 java/net/SocketTimeoutException
            // try (222 -> 234): 367 java/io/IOException
            // try (238 -> 242): 269 java/lang/OutOfMemoryError
            // try (238 -> 242): 307 java/net/MalformedURLException
            // try (238 -> 242): 322 com/mixpanel/android/util/RemoteService$ServiceUnavailableException
            // try (238 -> 242): 348 java/net/SocketTimeoutException
            // try (238 -> 242): 367 java/io/IOException
            // try (246 -> 248): 269 java/lang/OutOfMemoryError
            // try (246 -> 248): 307 java/net/MalformedURLException
            // try (246 -> 248): 322 com/mixpanel/android/util/RemoteService$ServiceUnavailableException
            // try (246 -> 248): 348 java/net/SocketTimeoutException
            // try (246 -> 248): 367 java/io/IOException
            // try (252 -> 254): 269 java/lang/OutOfMemoryError
            // try (252 -> 254): 307 java/net/MalformedURLException
            // try (252 -> 254): 322 com/mixpanel/android/util/RemoteService$ServiceUnavailableException
            // try (252 -> 254): 348 java/net/SocketTimeoutException
            // try (252 -> 254): 367 java/io/IOException
            // try (258 -> 266): 269 java/lang/OutOfMemoryError
            // try (258 -> 266): 307 java/net/MalformedURLException
            // try (258 -> 266): 322 com/mixpanel/android/util/RemoteService$ServiceUnavailableException
            // try (258 -> 266): 348 java/net/SocketTimeoutException
            // try (258 -> 266): 367 java/io/IOException
            // try (291 -> 293): 269 java/lang/OutOfMemoryError
            // try (291 -> 293): 307 java/net/MalformedURLException
            // try (291 -> 293): 322 com/mixpanel/android/util/RemoteService$ServiceUnavailableException
            // try (291 -> 293): 348 java/net/SocketTimeoutException
            // try (291 -> 293): 367 java/io/IOException
            // try (297 -> 301): 269 java/lang/OutOfMemoryError
            // try (297 -> 301): 307 java/net/MalformedURLException
            // try (297 -> 301): 322 com/mixpanel/android/util/RemoteService$ServiceUnavailableException
            // try (297 -> 301): 348 java/net/SocketTimeoutException
            // try (297 -> 301): 367 java/io/IOException
            // try (305 -> 307): 269 java/lang/OutOfMemoryError
            // try (305 -> 307): 307 java/net/MalformedURLException
            // try (305 -> 307): 322 com/mixpanel/android/util/RemoteService$ServiceUnavailableException
            // try (305 -> 307): 348 java/net/SocketTimeoutException
            // try (305 -> 307): 367 java/io/IOException
         }

         private void a(String var1) {
            try {
               try {
                  if (GoogleApiAvailability.a().a(this.a.a.a) != 0) {
                     MPLog.c("MixpanelAPI.Messages", "Can't register for push notifications, Google Play Services are not installed.");
                     return;
                  }
               } catch (RuntimeException var2) {
                  MPLog.c("MixpanelAPI.Messages", "Can't register for push notifications, Google Play services are not configured.");
                  return;
               }

               var1 = InstanceID.c(this.a.a.a).b(var1, "GCM", null);
            } catch (IOException var3) {
               MPLog.c("MixpanelAPI.Messages", "Exception when trying to register for GCM", var3);
               return;
            } catch (NoClassDefFoundError var4) {
               MPLog.d("MixpanelAPI.Messages", "Google play services were not part of this build, push notifications cannot be registered or delivered");
               return;
            }

            MixpanelAPI.a(new MixpanelAPI.InstanceProcessor(this, var1) {
               final String a;
               final AnalyticsMessages.Worker.AnalyticsMessageHandler b;

               {
                  this.b = var1;
                  this.a = var2;
               }

               @Override
               public void a(MixpanelAPI var1) {
                  MPLog.a("MixpanelAPI.Messages", "Using existing pushId " + this.a);
                  var1.c().b(this.a);
               }
            });
         }

         private JSONObject b() throws JSONException {
            // $VF: Couldn't be decompiled
            // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
            // java.lang.RuntimeException: parsing failure!
            //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
            //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
            //
            // Bytecode:
            // 000: new org/json/JSONObject
            // 003: dup
            // 004: invokespecial org/json/JSONObject.<init> ()V
            // 007: astore 3
            // 008: aload 3
            // 009: ldc_w "mp_lib"
            // 00c: ldc_w "android"
            // 00f: invokevirtual org/json/JSONObject.put (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
            // 012: pop
            // 013: aload 3
            // 014: ldc_w "$lib_version"
            // 017: ldc_w "5.2.1"
            // 01a: invokevirtual org/json/JSONObject.put (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
            // 01d: pop
            // 01e: aload 3
            // 01f: ldc_w "$os"
            // 022: ldc_w "Android"
            // 025: invokevirtual org/json/JSONObject.put (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
            // 028: pop
            // 029: getstatic android/os/Build$VERSION.RELEASE Ljava/lang/String;
            // 02c: ifnonnull 1ce
            // 02f: ldc_w "UNKNOWN"
            // 032: astore 2
            // 033: aload 3
            // 034: ldc_w "$os_version"
            // 037: aload 2
            // 038: invokevirtual org/json/JSONObject.put (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
            // 03b: pop
            // 03c: getstatic android/os/Build.MANUFACTURER Ljava/lang/String;
            // 03f: ifnonnull 1d5
            // 042: ldc_w "UNKNOWN"
            // 045: astore 2
            // 046: aload 3
            // 047: ldc_w "$manufacturer"
            // 04a: aload 2
            // 04b: invokevirtual org/json/JSONObject.put (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
            // 04e: pop
            // 04f: getstatic android/os/Build.BRAND Ljava/lang/String;
            // 052: ifnonnull 1dc
            // 055: ldc_w "UNKNOWN"
            // 058: astore 2
            // 059: aload 3
            // 05a: ldc_w "$brand"
            // 05d: aload 2
            // 05e: invokevirtual org/json/JSONObject.put (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
            // 061: pop
            // 062: getstatic android/os/Build.MODEL Ljava/lang/String;
            // 065: ifnonnull 1e3
            // 068: ldc_w "UNKNOWN"
            // 06b: astore 2
            // 06c: aload 3
            // 06d: ldc_w "$model"
            // 070: aload 2
            // 071: invokevirtual org/json/JSONObject.put (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
            // 074: pop
            // 075: invokestatic com/google/android/gms/common/GoogleApiAvailability.a ()Lcom/google/android/gms/common/GoogleApiAvailability;
            // 078: aload 0
            // 079: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;
            // 07c: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;
            // 07f: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages.a Landroid/content/Context;
            // 082: invokevirtual com/google/android/gms/common/GoogleApiAvailability.a (Landroid/content/Context;)I
            // 085: istore 1
            // 086: iload 1
            // 087: tableswitch 53 0 9 355 399 413 427 53 53 53 53 53 441
            // 0bc: aload 0
            // 0bd: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;
            // 0c0: invokestatic com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.c (Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;)Lcom/mixpanel/android/mpmetrics/SystemInformation;
            // 0c3: invokevirtual com/mixpanel/android/mpmetrics/SystemInformation.f ()Landroid/util/DisplayMetrics;
            // 0c6: astore 2
            // 0c7: aload 3
            // 0c8: ldc_w "$screen_dpi"
            // 0cb: aload 2
            // 0cc: getfield android/util/DisplayMetrics.densityDpi I
            // 0cf: invokevirtual org/json/JSONObject.put (Ljava/lang/String;I)Lorg/json/JSONObject;
            // 0d2: pop
            // 0d3: aload 3
            // 0d4: ldc_w "$screen_height"
            // 0d7: aload 2
            // 0d8: getfield android/util/DisplayMetrics.heightPixels I
            // 0db: invokevirtual org/json/JSONObject.put (Ljava/lang/String;I)Lorg/json/JSONObject;
            // 0de: pop
            // 0df: aload 3
            // 0e0: ldc_w "$screen_width"
            // 0e3: aload 2
            // 0e4: getfield android/util/DisplayMetrics.widthPixels I
            // 0e7: invokevirtual org/json/JSONObject.put (Ljava/lang/String;I)Lorg/json/JSONObject;
            // 0ea: pop
            // 0eb: aload 0
            // 0ec: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;
            // 0ef: invokestatic com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.c (Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;)Lcom/mixpanel/android/mpmetrics/SystemInformation;
            // 0f2: invokevirtual com/mixpanel/android/mpmetrics/SystemInformation.a ()Ljava/lang/String;
            // 0f5: astore 2
            // 0f6: aload 2
            // 0f7: ifnull 10c
            // 0fa: aload 3
            // 0fb: ldc_w "$app_version"
            // 0fe: aload 2
            // 0ff: invokevirtual org/json/JSONObject.put (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
            // 102: pop
            // 103: aload 3
            // 104: ldc_w "$app_version_string"
            // 107: aload 2
            // 108: invokevirtual org/json/JSONObject.put (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
            // 10b: pop
            // 10c: aload 0
            // 10d: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;
            // 110: invokestatic com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.c (Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;)Lcom/mixpanel/android/mpmetrics/SystemInformation;
            // 113: invokevirtual com/mixpanel/android/mpmetrics/SystemInformation.b ()Ljava/lang/Integer;
            // 116: astore 2
            // 117: aload 2
            // 118: ifnull 12d
            // 11b: aload 3
            // 11c: ldc_w "$app_release"
            // 11f: aload 2
            // 120: invokevirtual org/json/JSONObject.put (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
            // 123: pop
            // 124: aload 3
            // 125: ldc_w "$app_build_number"
            // 128: aload 2
            // 129: invokevirtual org/json/JSONObject.put (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
            // 12c: pop
            // 12d: aload 0
            // 12e: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;
            // 131: invokestatic com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.c (Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;)Lcom/mixpanel/android/mpmetrics/SystemInformation;
            // 134: invokevirtual com/mixpanel/android/mpmetrics/SystemInformation.d ()Z
            // 137: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
            // 13a: astore 2
            // 13b: aload 2
            // 13c: ifnull 14b
            // 13f: aload 3
            // 140: ldc_w "$has_nfc"
            // 143: aload 2
            // 144: invokevirtual java/lang/Boolean.booleanValue ()Z
            // 147: invokevirtual org/json/JSONObject.put (Ljava/lang/String;Z)Lorg/json/JSONObject;
            // 14a: pop
            // 14b: aload 0
            // 14c: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;
            // 14f: invokestatic com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.c (Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;)Lcom/mixpanel/android/mpmetrics/SystemInformation;
            // 152: invokevirtual com/mixpanel/android/mpmetrics/SystemInformation.e ()Z
            // 155: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
            // 158: astore 2
            // 159: aload 2
            // 15a: ifnull 169
            // 15d: aload 3
            // 15e: ldc_w "$has_telephone"
            // 161: aload 2
            // 162: invokevirtual java/lang/Boolean.booleanValue ()Z
            // 165: invokevirtual org/json/JSONObject.put (Ljava/lang/String;Z)Lorg/json/JSONObject;
            // 168: pop
            // 169: aload 0
            // 16a: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;
            // 16d: invokestatic com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.c (Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;)Lcom/mixpanel/android/mpmetrics/SystemInformation;
            // 170: invokevirtual com/mixpanel/android/mpmetrics/SystemInformation.g ()Ljava/lang/String;
            // 173: astore 2
            // 174: aload 2
            // 175: ifnull 181
            // 178: aload 3
            // 179: ldc_w "$carrier"
            // 17c: aload 2
            // 17d: invokevirtual org/json/JSONObject.put (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
            // 180: pop
            // 181: aload 0
            // 182: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;
            // 185: invokestatic com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.c (Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;)Lcom/mixpanel/android/mpmetrics/SystemInformation;
            // 188: invokevirtual com/mixpanel/android/mpmetrics/SystemInformation.h ()Ljava/lang/Boolean;
            // 18b: astore 2
            // 18c: aload 2
            // 18d: ifnull 19c
            // 190: aload 3
            // 191: ldc_w "$wifi"
            // 194: aload 2
            // 195: invokevirtual java/lang/Boolean.booleanValue ()Z
            // 198: invokevirtual org/json/JSONObject.put (Ljava/lang/String;Z)Lorg/json/JSONObject;
            // 19b: pop
            // 19c: aload 0
            // 19d: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;
            // 1a0: invokestatic com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.c (Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;)Lcom/mixpanel/android/mpmetrics/SystemInformation;
            // 1a3: invokevirtual com/mixpanel/android/mpmetrics/SystemInformation.i ()Ljava/lang/Boolean;
            // 1a6: astore 2
            // 1a7: aload 2
            // 1a8: ifnull 1b4
            // 1ab: aload 3
            // 1ac: ldc_w "$bluetooth_enabled"
            // 1af: aload 2
            // 1b0: invokevirtual org/json/JSONObject.put (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
            // 1b3: pop
            // 1b4: aload 0
            // 1b5: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;
            // 1b8: invokestatic com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.c (Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;)Lcom/mixpanel/android/mpmetrics/SystemInformation;
            // 1bb: invokevirtual com/mixpanel/android/mpmetrics/SystemInformation.j ()Ljava/lang/String;
            // 1be: astore 2
            // 1bf: aload 2
            // 1c0: ifnull 1cc
            // 1c3: aload 3
            // 1c4: ldc_w "$bluetooth_version"
            // 1c7: aload 2
            // 1c8: invokevirtual org/json/JSONObject.put (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
            // 1cb: pop
            // 1cc: aload 3
            // 1cd: areturn
            // 1ce: getstatic android/os/Build$VERSION.RELEASE Ljava/lang/String;
            // 1d1: astore 2
            // 1d2: goto 033
            // 1d5: getstatic android/os/Build.MANUFACTURER Ljava/lang/String;
            // 1d8: astore 2
            // 1d9: goto 046
            // 1dc: getstatic android/os/Build.BRAND Ljava/lang/String;
            // 1df: astore 2
            // 1e0: goto 059
            // 1e3: getstatic android/os/Build.MODEL Ljava/lang/String;
            // 1e6: astore 2
            // 1e7: goto 06c
            // 1ea: aload 3
            // 1eb: ldc_w "$google_play_services"
            // 1ee: ldc_w "available"
            // 1f1: invokevirtual org/json/JSONObject.put (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
            // 1f4: pop
            // 1f5: goto 0bc
            // 1f8: astore 2
            // 1f9: aload 3
            // 1fa: ldc_w "$google_play_services"
            // 1fd: ldc_w "not configured"
            // 200: invokevirtual org/json/JSONObject.put (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
            // 203: pop
            // 204: goto 0bc
            // 207: astore 2
            // 208: aload 3
            // 209: ldc_w "$google_play_services"
            // 20c: ldc_w "not included"
            // 20f: invokevirtual org/json/JSONObject.put (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
            // 212: pop
            // 213: goto 0bc
            // 216: aload 3
            // 217: ldc_w "$google_play_services"
            // 21a: ldc_w "missing"
            // 21d: invokevirtual org/json/JSONObject.put (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
            // 220: pop
            // 221: goto 0bc
            // 224: aload 3
            // 225: ldc_w "$google_play_services"
            // 228: ldc_w "out of date"
            // 22b: invokevirtual org/json/JSONObject.put (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
            // 22e: pop
            // 22f: goto 0bc
            // 232: aload 3
            // 233: ldc_w "$google_play_services"
            // 236: ldc_w "disabled"
            // 239: invokevirtual org/json/JSONObject.put (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
            // 23c: pop
            // 23d: goto 0bc
            // 240: aload 3
            // 241: ldc_w "$google_play_services"
            // 244: ldc_w "invalid"
            // 247: invokevirtual org/json/JSONObject.put (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
            // 24a: pop
            // 24b: goto 0bc
            // try (55 -> 62): 218 java/lang/RuntimeException
            // try (55 -> 62): 225 java/lang/NoClassDefFoundError
            // try (212 -> 217): 218 java/lang/RuntimeException
            // try (212 -> 217): 225 java/lang/NoClassDefFoundError
            // try (219 -> 224): 225 java/lang/NoClassDefFoundError
            // try (232 -> 237): 218 java/lang/RuntimeException
            // try (232 -> 237): 225 java/lang/NoClassDefFoundError
            // try (238 -> 243): 218 java/lang/RuntimeException
            // try (238 -> 243): 225 java/lang/NoClassDefFoundError
            // try (244 -> 249): 218 java/lang/RuntimeException
            // try (244 -> 249): 225 java/lang/NoClassDefFoundError
            // try (250 -> 255): 218 java/lang/RuntimeException
            // try (250 -> 255): 225 java/lang/NoClassDefFoundError
         }

         protected DecideChecker a() {
            return new DecideChecker(this.a.a.a, this.a.a.b);
         }

         public void handleMessage(Message param1) {
            // $VF: Couldn't be decompiled
            // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
            // java.lang.RuntimeException: parsing failure!
            //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
            //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
            //
            // Bytecode:
            // 000: aconst_null
            // 001: astore 8
            // 003: bipush 1
            // 004: istore 2
            // 005: aload 0
            // 006: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.b Lcom/mixpanel/android/mpmetrics/MPDbAdapter;
            // 009: ifnonnull 05c
            // 00c: aload 0
            // 00d: aload 0
            // 00e: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;
            // 011: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;
            // 014: aload 0
            // 015: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;
            // 018: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;
            // 01b: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages.a Landroid/content/Context;
            // 01e: invokevirtual com/mixpanel/android/mpmetrics/AnalyticsMessages.b (Landroid/content/Context;)Lcom/mixpanel/android/mpmetrics/MPDbAdapter;
            // 021: putfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.b Lcom/mixpanel/android/mpmetrics/MPDbAdapter;
            // 024: aload 0
            // 025: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.b Lcom/mixpanel/android/mpmetrics/MPDbAdapter;
            // 028: invokestatic java/lang/System.currentTimeMillis ()J
            // 02b: aload 0
            // 02c: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;
            // 02f: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;
            // 032: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages.b Lcom/mixpanel/android/mpmetrics/MPConfig;
            // 035: invokevirtual com/mixpanel/android/mpmetrics/MPConfig.c ()I
            // 038: i2l
            // 039: lsub
            // 03a: getstatic com/mixpanel/android/mpmetrics/MPDbAdapter$Table.EVENTS Lcom/mixpanel/android/mpmetrics/MPDbAdapter$Table;
            // 03d: invokevirtual com/mixpanel/android/mpmetrics/MPDbAdapter.a (JLcom/mixpanel/android/mpmetrics/MPDbAdapter$Table;)V
            // 040: aload 0
            // 041: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.b Lcom/mixpanel/android/mpmetrics/MPDbAdapter;
            // 044: invokestatic java/lang/System.currentTimeMillis ()J
            // 047: aload 0
            // 048: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;
            // 04b: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;
            // 04e: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages.b Lcom/mixpanel/android/mpmetrics/MPConfig;
            // 051: invokevirtual com/mixpanel/android/mpmetrics/MPConfig.c ()I
            // 054: i2l
            // 055: lsub
            // 056: getstatic com/mixpanel/android/mpmetrics/MPDbAdapter$Table.PEOPLE Lcom/mixpanel/android/mpmetrics/MPDbAdapter$Table;
            // 059: invokevirtual com/mixpanel/android/mpmetrics/MPDbAdapter.a (JLcom/mixpanel/android/mpmetrics/MPDbAdapter$Table;)V
            // 05c: bipush -3
            // 05e: istore 3
            // 05f: aload 1
            // 060: getfield android/os/Message.what I
            // 063: ifne 146
            // 066: aload 1
            // 067: getfield android/os/Message.obj Ljava/lang/Object;
            // 06a: checkcast com/mixpanel/android/mpmetrics/AnalyticsMessages$PeopleDescription
            // 06d: astore 8
            // 06f: aload 0
            // 070: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;
            // 073: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;
            // 076: ldc_w "Queuing people record for sending later"
            // 079: invokestatic com/mixpanel/android/mpmetrics/AnalyticsMessages.a (Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;Ljava/lang/String;)V
            // 07c: aload 0
            // 07d: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;
            // 080: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;
            // 083: astore 1
            // 084: new java/lang/StringBuilder
            // 087: astore 9
            // 089: aload 9
            // 08b: invokespecial java/lang/StringBuilder.<init> ()V
            // 08e: aload 1
            // 08f: aload 9
            // 091: ldc_w "    "
            // 094: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
            // 097: aload 8
            // 099: invokevirtual com/mixpanel/android/mpmetrics/AnalyticsMessages$PeopleDescription.toString ()Ljava/lang/String;
            // 09c: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
            // 09f: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
            // 0a2: invokestatic com/mixpanel/android/mpmetrics/AnalyticsMessages.a (Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;Ljava/lang/String;)V
            // 0a5: aload 8
            // 0a7: invokevirtual com/mixpanel/android/mpmetrics/AnalyticsMessages$PeopleDescription.d ()Ljava/lang/String;
            // 0aa: astore 1
            // 0ab: aload 0
            // 0ac: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.b Lcom/mixpanel/android/mpmetrics/MPDbAdapter;
            // 0af: aload 8
            // 0b1: invokevirtual com/mixpanel/android/mpmetrics/AnalyticsMessages$PeopleDescription.a ()Lorg/json/JSONObject;
            // 0b4: aload 1
            // 0b5: getstatic com/mixpanel/android/mpmetrics/MPDbAdapter$Table.PEOPLE Lcom/mixpanel/android/mpmetrics/MPDbAdapter$Table;
            // 0b8: bipush 0
            // 0b9: invokevirtual com/mixpanel/android/mpmetrics/MPDbAdapter.a (Lorg/json/JSONObject;Ljava/lang/String;Lcom/mixpanel/android/mpmetrics/MPDbAdapter$Table;Z)I
            // 0bc: istore 2
            // 0bd: iload 2
            // 0be: aload 0
            // 0bf: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;
            // 0c2: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;
            // 0c5: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages.b Lcom/mixpanel/android/mpmetrics/MPConfig;
            // 0c8: invokevirtual com/mixpanel/android/mpmetrics/MPConfig.a ()I
            // 0cb: if_icmpge 0d4
            // 0ce: iload 2
            // 0cf: bipush -2
            // 0d1: if_icmpne 3ec
            // 0d4: aload 0
            // 0d5: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.g I
            // 0d8: ifgt 3ec
            // 0db: aload 1
            // 0dc: ifnull 3ec
            // 0df: aload 0
            // 0e0: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;
            // 0e3: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;
            // 0e6: astore 8
            // 0e8: new java/lang/StringBuilder
            // 0eb: astore 9
            // 0ed: aload 9
            // 0ef: invokespecial java/lang/StringBuilder.<init> ()V
            // 0f2: aload 8
            // 0f4: aload 9
            // 0f6: ldc_w "Flushing queue due to bulk upload limit ("
            // 0f9: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
            // 0fc: iload 2
            // 0fd: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
            // 100: ldc_w ") for project "
            // 103: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
            // 106: aload 1
            // 107: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
            // 10a: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
            // 10d: invokestatic com/mixpanel/android/mpmetrics/AnalyticsMessages.a (Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;Ljava/lang/String;)V
            // 110: aload 0
            // 111: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;
            // 114: invokestatic com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.a (Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;)V
            // 117: aload 0
            // 118: aload 0
            // 119: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.b Lcom/mixpanel/android/mpmetrics/MPDbAdapter;
            // 11c: aload 1
            // 11d: invokespecial com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a (Lcom/mixpanel/android/mpmetrics/MPDbAdapter;Ljava/lang/String;)V
            // 120: invokestatic android/os/SystemClock.elapsedRealtime ()J
            // 123: lstore 6
            // 125: aload 0
            // 126: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.e J
            // 129: lstore 4
            // 12b: lload 6
            // 12d: lload 4
            // 12f: lcmp
            // 130: iflt 145
            // 133: aload 0
            // 134: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.c Lcom/mixpanel/android/mpmetrics/DecideChecker;
            // 137: aload 1
            // 138: aload 0
            // 139: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;
            // 13c: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;
            // 13f: invokevirtual com/mixpanel/android/mpmetrics/AnalyticsMessages.b ()Lcom/mixpanel/android/util/RemoteService;
            // 142: invokevirtual com/mixpanel/android/mpmetrics/DecideChecker.a (Ljava/lang/String;Lcom/mixpanel/android/util/RemoteService;)V
            // 145: return
            // 146: aload 1
            // 147: getfield android/os/Message.what I
            // 14a: bipush 1
            // 14b: if_icmpne 1fe
            // 14e: aload 1
            // 14f: getfield android/os/Message.obj Ljava/lang/Object;
            // 152: checkcast com/mixpanel/android/mpmetrics/AnalyticsMessages$EventDescription
            // 155: astore 9
            // 157: aload 0
            // 158: aload 9
            // 15a: invokespecial com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a (Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$EventDescription;)Lorg/json/JSONObject;
            // 15d: astore 8
            // 15f: aload 0
            // 160: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;
            // 163: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;
            // 166: ldc_w "Queuing event for sending later"
            // 169: invokestatic com/mixpanel/android/mpmetrics/AnalyticsMessages.a (Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;Ljava/lang/String;)V
            // 16c: aload 0
            // 16d: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;
            // 170: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;
            // 173: astore 1
            // 174: new java/lang/StringBuilder
            // 177: astore 10
            // 179: aload 10
            // 17b: invokespecial java/lang/StringBuilder.<init> ()V
            // 17e: aload 1
            // 17f: aload 10
            // 181: ldc_w "    "
            // 184: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
            // 187: aload 8
            // 189: invokevirtual org/json/JSONObject.toString ()Ljava/lang/String;
            // 18c: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
            // 18f: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
            // 192: invokestatic com/mixpanel/android/mpmetrics/AnalyticsMessages.a (Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;Ljava/lang/String;)V
            // 195: aload 9
            // 197: invokevirtual com/mixpanel/android/mpmetrics/AnalyticsMessages$EventDescription.d ()Ljava/lang/String;
            // 19a: astore 1
            // 19b: aload 0
            // 19c: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.c Lcom/mixpanel/android/mpmetrics/DecideChecker;
            // 19f: aload 1
            // 1a0: invokevirtual com/mixpanel/android/mpmetrics/DecideChecker.b (Ljava/lang/String;)Lcom/mixpanel/android/mpmetrics/DecideMessages;
            // 1a3: astore 10
            // 1a5: aload 10
            // 1a7: ifnull 1ba
            // 1aa: aload 9
            // 1ac: invokevirtual com/mixpanel/android/mpmetrics/AnalyticsMessages$EventDescription.c ()Z
            // 1af: ifeq 1ba
            // 1b2: aload 10
            // 1b4: invokevirtual com/mixpanel/android/mpmetrics/DecideMessages.e ()Z
            // 1b7: ifeq 145
            // 1ba: aload 0
            // 1bb: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.b Lcom/mixpanel/android/mpmetrics/MPDbAdapter;
            // 1be: aload 8
            // 1c0: aload 1
            // 1c1: getstatic com/mixpanel/android/mpmetrics/MPDbAdapter$Table.EVENTS Lcom/mixpanel/android/mpmetrics/MPDbAdapter$Table;
            // 1c4: aload 9
            // 1c6: invokevirtual com/mixpanel/android/mpmetrics/AnalyticsMessages$EventDescription.c ()Z
            // 1c9: invokevirtual com/mixpanel/android/mpmetrics/MPDbAdapter.a (Lorg/json/JSONObject;Ljava/lang/String;Lcom/mixpanel/android/mpmetrics/MPDbAdapter$Table;Z)I
            // 1cc: istore 2
            // 1cd: goto 0bd
            // 1d0: astore 8
            // 1d2: aconst_null
            // 1d3: astore 1
            // 1d4: new java/lang/StringBuilder
            // 1d7: astore 10
            // 1d9: aload 10
            // 1db: invokespecial java/lang/StringBuilder.<init> ()V
            // 1de: ldc "MixpanelAPI.Messages"
            // 1e0: aload 10
            // 1e2: ldc_w "Exception tracking event "
            // 1e5: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
            // 1e8: aload 9
            // 1ea: invokevirtual com/mixpanel/android/mpmetrics/AnalyticsMessages$EventDescription.a ()Ljava/lang/String;
            // 1ed: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
            // 1f0: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
            // 1f3: aload 8
            // 1f5: invokestatic com/mixpanel/android/util/MPLog.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
            // 1f8: bipush -3
            // 1fa: istore 2
            // 1fb: goto 1cd
            // 1fe: aload 1
            // 1ff: getfield android/os/Message.what I
            // 202: bipush 2
            // 203: if_icmpne 2bc
            // 206: aload 0
            // 207: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;
            // 20a: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;
            // 20d: ldc_w "Flushing queue due to scheduled or forced flush"
            // 210: invokestatic com/mixpanel/android/mpmetrics/AnalyticsMessages.a (Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;Ljava/lang/String;)V
            // 213: aload 0
            // 214: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;
            // 217: invokestatic com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.a (Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;)V
            // 21a: aload 1
            // 21b: getfield android/os/Message.obj Ljava/lang/Object;
            // 21e: checkcast java/lang/String
            // 221: astore 8
            // 223: aload 1
            // 224: getfield android/os/Message.arg1 I
            // 227: bipush 1
            // 228: if_icmpne 267
            // 22b: aload 0
            // 22c: aload 0
            // 22d: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.b Lcom/mixpanel/android/mpmetrics/MPDbAdapter;
            // 230: aload 8
            // 232: invokespecial com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a (Lcom/mixpanel/android/mpmetrics/MPDbAdapter;Ljava/lang/String;)V
            // 235: iload 2
            // 236: ifeq 25f
            // 239: invokestatic android/os/SystemClock.elapsedRealtime ()J
            // 23c: lstore 4
            // 23e: aload 0
            // 23f: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.e J
            // 242: lstore 6
            // 244: lload 4
            // 246: lload 6
            // 248: lcmp
            // 249: iflt 25f
            // 24c: aload 0
            // 24d: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.c Lcom/mixpanel/android/mpmetrics/DecideChecker;
            // 250: aload 8
            // 252: aload 0
            // 253: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;
            // 256: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;
            // 259: invokevirtual com/mixpanel/android/mpmetrics/AnalyticsMessages.b ()Lcom/mixpanel/android/util/RemoteService;
            // 25c: invokevirtual com/mixpanel/android/mpmetrics/DecideChecker.a (Ljava/lang/String;Lcom/mixpanel/android/util/RemoteService;)V
            // 25f: aload 8
            // 261: astore 1
            // 262: iload 3
            // 263: istore 2
            // 264: goto 0bd
            // 267: bipush 0
            // 268: istore 2
            // 269: goto 22b
            // 26c: astore 1
            // 26d: aload 0
            // 26e: invokestatic android/os/SystemClock.elapsedRealtime ()J
            // 271: aload 1
            // 272: invokevirtual com/mixpanel/android/util/RemoteService$ServiceUnavailableException.a ()I
            // 275: sipush 1000
            // 278: imul
            // 279: i2l
            // 27a: ladd
            // 27b: putfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.e J
            // 27e: goto 25f
            // 281: astore 8
            // 283: ldc "MixpanelAPI.Messages"
            // 285: ldc_w "Worker threw an unhandled exception"
            // 288: aload 8
            // 28a: invokestatic com/mixpanel/android/util/MPLog.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
            // 28d: aload 0
            // 28e: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;
            // 291: invokestatic com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.b (Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;)Ljava/lang/Object;
            // 294: astore 1
            // 295: aload 1
            // 296: monitorenter
            // 297: aload 0
            // 298: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;
            // 29b: aconst_null
            // 29c: invokestatic com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.a (Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;Landroid/os/Handler;)Landroid/os/Handler;
            // 29f: pop
            // 2a0: invokestatic android/os/Looper.myLooper ()Landroid/os/Looper;
            // 2a3: invokevirtual android/os/Looper.quit ()V
            // 2a6: ldc "MixpanelAPI.Messages"
            // 2a8: ldc_w "Mixpanel will not process any more analytics messages"
            // 2ab: aload 8
            // 2ad: invokestatic com/mixpanel/android/util/MPLog.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
            // 2b0: aload 1
            // 2b1: monitorexit
            // 2b2: goto 145
            // 2b5: astore 8
            // 2b7: aload 1
            // 2b8: monitorexit
            // 2b9: aload 8
            // 2bb: athrow
            // 2bc: aload 1
            // 2bd: getfield android/os/Message.what I
            // 2c0: bipush 12
            // 2c2: if_icmpne 338
            // 2c5: aload 0
            // 2c6: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;
            // 2c9: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;
            // 2cc: ldc_w "Installing a check for in-app notifications"
            // 2cf: invokestatic com/mixpanel/android/mpmetrics/AnalyticsMessages.a (Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;Ljava/lang/String;)V
            // 2d2: aload 1
            // 2d3: getfield android/os/Message.obj Ljava/lang/Object;
            // 2d6: checkcast com/mixpanel/android/mpmetrics/DecideMessages
            // 2d9: astore 9
            // 2db: aload 0
            // 2dc: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.c Lcom/mixpanel/android/mpmetrics/DecideChecker;
            // 2df: aload 9
            // 2e1: invokevirtual com/mixpanel/android/mpmetrics/DecideChecker.a (Lcom/mixpanel/android/mpmetrics/DecideMessages;)V
            // 2e4: invokestatic android/os/SystemClock.elapsedRealtime ()J
            // 2e7: lstore 4
            // 2e9: aload 0
            // 2ea: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.e J
            // 2ed: lstore 6
            // 2ef: iload 3
            // 2f0: istore 2
            // 2f1: aload 8
            // 2f3: astore 1
            // 2f4: lload 4
            // 2f6: lload 6
            // 2f8: lcmp
            // 2f9: iflt 0bd
            // 2fc: aload 0
            // 2fd: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.c Lcom/mixpanel/android/mpmetrics/DecideChecker;
            // 300: aload 9
            // 302: invokevirtual com/mixpanel/android/mpmetrics/DecideMessages.a ()Ljava/lang/String;
            // 305: aload 0
            // 306: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;
            // 309: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;
            // 30c: invokevirtual com/mixpanel/android/mpmetrics/AnalyticsMessages.b ()Lcom/mixpanel/android/util/RemoteService;
            // 30f: invokevirtual com/mixpanel/android/mpmetrics/DecideChecker.a (Ljava/lang/String;Lcom/mixpanel/android/util/RemoteService;)V
            // 312: iload 3
            // 313: istore 2
            // 314: aload 8
            // 316: astore 1
            // 317: goto 0bd
            // 31a: astore 1
            // 31b: invokestatic android/os/SystemClock.elapsedRealtime ()J
            // 31e: lstore 4
            // 320: aload 0
            // 321: aload 1
            // 322: invokevirtual com/mixpanel/android/util/RemoteService$ServiceUnavailableException.a ()I
            // 325: sipush 1000
            // 328: imul
            // 329: i2l
            // 32a: lload 4
            // 32c: ladd
            // 32d: putfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.e J
            // 330: iload 3
            // 331: istore 2
            // 332: aload 8
            // 334: astore 1
            // 335: goto 0bd
            // 338: aload 1
            // 339: getfield android/os/Message.what I
            // 33c: bipush 13
            // 33e: if_icmpne 354
            // 341: aload 0
            // 342: aload 1
            // 343: getfield android/os/Message.obj Ljava/lang/Object;
            // 346: checkcast java/lang/String
            // 349: invokespecial com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a (Ljava/lang/String;)V
            // 34c: iload 3
            // 34d: istore 2
            // 34e: aload 8
            // 350: astore 1
            // 351: goto 0bd
            // 354: aload 1
            // 355: getfield android/os/Message.what I
            // 358: bipush 5
            // 359: if_icmpne 3ad
            // 35c: new java/lang/StringBuilder
            // 35f: astore 1
            // 360: aload 1
            // 361: invokespecial java/lang/StringBuilder.<init> ()V
            // 364: ldc "MixpanelAPI.Messages"
            // 366: aload 1
            // 367: ldc_w "Worker received a hard kill. Dumping all events and force-killing. Thread id "
            // 36a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
            // 36d: invokestatic java/lang/Thread.currentThread ()Ljava/lang/Thread;
            // 370: invokevirtual java/lang/Thread.getId ()J
            // 373: invokevirtual java/lang/StringBuilder.append (J)Ljava/lang/StringBuilder;
            // 376: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
            // 379: invokestatic com/mixpanel/android/util/MPLog.d (Ljava/lang/String;Ljava/lang/String;)V
            // 37c: aload 0
            // 37d: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;
            // 380: invokestatic com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.b (Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;)Ljava/lang/Object;
            // 383: astore 1
            // 384: aload 1
            // 385: monitorenter
            // 386: aload 0
            // 387: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.b Lcom/mixpanel/android/mpmetrics/MPDbAdapter;
            // 38a: invokevirtual com/mixpanel/android/mpmetrics/MPDbAdapter.a ()V
            // 38d: aload 0
            // 38e: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;
            // 391: aconst_null
            // 392: invokestatic com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.a (Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;Landroid/os/Handler;)Landroid/os/Handler;
            // 395: pop
            // 396: invokestatic android/os/Looper.myLooper ()Landroid/os/Looper;
            // 399: invokevirtual android/os/Looper.quit ()V
            // 39c: aload 1
            // 39d: monitorexit
            // 39e: iload 3
            // 39f: istore 2
            // 3a0: aload 8
            // 3a2: astore 1
            // 3a3: goto 0bd
            // 3a6: astore 8
            // 3a8: aload 1
            // 3a9: monitorexit
            // 3aa: aload 8
            // 3ac: athrow
            // 3ad: new java/lang/StringBuilder
            // 3b0: astore 9
            // 3b2: aload 9
            // 3b4: invokespecial java/lang/StringBuilder.<init> ()V
            // 3b7: ldc "MixpanelAPI.Messages"
            // 3b9: aload 9
            // 3bb: ldc_w "Unexpected message received by Mixpanel worker: "
            // 3be: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
            // 3c1: aload 1
            // 3c2: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
            // 3c5: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
            // 3c8: invokestatic com/mixpanel/android/util/MPLog.e (Ljava/lang/String;Ljava/lang/String;)V
            // 3cb: iload 3
            // 3cc: istore 2
            // 3cd: aload 8
            // 3cf: astore 1
            // 3d0: goto 0bd
            // 3d3: astore 1
            // 3d4: invokestatic android/os/SystemClock.elapsedRealtime ()J
            // 3d7: lstore 4
            // 3d9: aload 0
            // 3da: aload 1
            // 3db: invokevirtual com/mixpanel/android/util/RemoteService$ServiceUnavailableException.a ()I
            // 3de: sipush 1000
            // 3e1: imul
            // 3e2: i2l
            // 3e3: lload 4
            // 3e5: ladd
            // 3e6: putfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.e J
            // 3e9: goto 145
            // 3ec: iload 2
            // 3ed: ifle 145
            // 3f0: aload 0
            // 3f1: bipush 2
            // 3f2: aload 1
            // 3f3: invokevirtual com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.hasMessages (ILjava/lang/Object;)Z
            // 3f6: ifne 145
            // 3f9: aload 0
            // 3fa: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$Worker;
            // 3fd: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker.a Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;
            // 400: astore 9
            // 402: new java/lang/StringBuilder
            // 405: astore 8
            // 407: aload 8
            // 409: invokespecial java/lang/StringBuilder.<init> ()V
            // 40c: aload 9
            // 40e: aload 8
            // 410: ldc_w "Queue depth "
            // 413: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
            // 416: iload 2
            // 417: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
            // 41a: ldc_w " - Adding flush in "
            // 41d: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
            // 420: aload 0
            // 421: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.d J
            // 424: invokevirtual java/lang/StringBuilder.append (J)Ljava/lang/StringBuilder;
            // 427: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
            // 42a: invokestatic com/mixpanel/android/mpmetrics/AnalyticsMessages.a (Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;Ljava/lang/String;)V
            // 42d: aload 0
            // 42e: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.d J
            // 431: lconst_0
            // 432: lcmp
            // 433: iflt 145
            // 436: invokestatic android/os/Message.obtain ()Landroid/os/Message;
            // 439: astore 8
            // 43b: aload 8
            // 43d: bipush 2
            // 43e: putfield android/os/Message.what I
            // 441: aload 8
            // 443: aload 1
            // 444: putfield android/os/Message.obj Ljava/lang/Object;
            // 447: aload 8
            // 449: bipush 1
            // 44a: putfield android/os/Message.arg1 I
            // 44d: aload 0
            // 44e: aload 8
            // 450: aload 0
            // 451: getfield com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.d J
            // 454: invokevirtual com/mixpanel/android/mpmetrics/AnalyticsMessages$Worker$AnalyticsMessageHandler.sendMessageDelayed (Landroid/os/Message;J)Z
            // 457: pop
            // 458: goto 145
            // 45b: astore 8
            // 45d: ldc "MixpanelAPI.Messages"
            // 45f: ldc_w "Could not halt looper"
            // 462: aload 8
            // 464: invokestatic com/mixpanel/android/util/MPLog.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
            // 467: goto 2b0
            // 46a: astore 8
            // 46c: goto 1d4
            // try (43 -> 84): 288 java/lang/RuntimeException
            // try (84 -> 91): 288 java/lang/RuntimeException
            // try (94 -> 97): 288 java/lang/RuntimeException
            // try (99 -> 132): 288 java/lang/RuntimeException
            // try (136 -> 144): 455 com/mixpanel/android/util/RemoteService$ServiceUnavailableException
            // try (136 -> 144): 288 java/lang/RuntimeException
            // try (145 -> 153): 288 java/lang/RuntimeException
            // try (153 -> 182): 205 org/json/JSONException
            // try (153 -> 182): 288 java/lang/RuntimeException
            // try (182 -> 187): 525 org/json/JSONException
            // try (182 -> 187): 288 java/lang/RuntimeException
            // try (189 -> 195): 525 org/json/JSONException
            // try (189 -> 195): 288 java/lang/RuntimeException
            // try (195 -> 204): 525 org/json/JSONException
            // try (195 -> 204): 288 java/lang/RuntimeException
            // try (208 -> 222): 288 java/lang/RuntimeException
            // try (225 -> 245): 288 java/lang/RuntimeException
            // try (245 -> 250): 288 java/lang/RuntimeException
            // try (252 -> 257): 288 java/lang/RuntimeException
            // try (261 -> 269): 277 com/mixpanel/android/util/RemoteService$ServiceUnavailableException
            // try (261 -> 269): 288 java/lang/RuntimeException
            // try (278 -> 287): 288 java/lang/RuntimeException
            // try (299 -> 304): 313 null
            // try (304 -> 310): 519 java/lang/Exception
            // try (304 -> 310): 313 null
            // try (310 -> 312): 313 null
            // try (314 -> 316): 313 null
            // try (318 -> 340): 288 java/lang/RuntimeException
            // try (348 -> 357): 362 com/mixpanel/android/util/RemoteService$ServiceUnavailableException
            // try (348 -> 357): 288 java/lang/RuntimeException
            // try (363 -> 374): 288 java/lang/RuntimeException
            // try (379 -> 388): 288 java/lang/RuntimeException
            // try (393 -> 416): 288 java/lang/RuntimeException
            // try (416 -> 428): 433 null
            // try (434 -> 436): 433 null
            // try (436 -> 438): 288 java/lang/RuntimeException
            // try (438 -> 450): 288 java/lang/RuntimeException
            // try (456 -> 467): 288 java/lang/RuntimeException
            // try (470 -> 518): 288 java/lang/RuntimeException
            // try (520 -> 524): 313 null
         }
      }
   }
}
