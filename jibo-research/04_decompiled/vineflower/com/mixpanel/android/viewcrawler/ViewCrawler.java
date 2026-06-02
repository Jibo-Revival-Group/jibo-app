package com.mixpanel.android.viewcrawler;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.JsonWriter;
import android.util.Pair;
import com.mixpanel.android.mpmetrics.MPConfig;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.mixpanel.android.mpmetrics.OnMixpanelTweaksUpdatedListener;
import com.mixpanel.android.mpmetrics.ResourceReader;
import com.mixpanel.android.mpmetrics.SuperPropertyUpdate;
import com.mixpanel.android.mpmetrics.Tweaks;
import com.mixpanel.android.util.ImageStore;
import com.mixpanel.android.util.JSONUtils;
import com.mixpanel.android.util.MPLog;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(16)
public class ViewCrawler implements TrackingDebug, UpdatesFromMixpanel, ViewVisitor.OnLayoutErrorListener {
   private final MPConfig a;
   private final Context b;
   private final MixpanelAPI c;
   private final DynamicEventTracker d;
   private final EditState e;
   private final Tweaks f;
   private final Map<String, String> g;
   private final ViewCrawler.ViewCrawlerHandler h;
   private final float i;
   private final Set<OnMixpanelTweaksUpdatedListener> j;

   public ViewCrawler(Context var1, String var2, MixpanelAPI var3, Tweaks var4) {
      this.a = MPConfig.a(var1);
      this.b = var1;
      this.e = new EditState();
      this.f = var4;
      this.g = var3.e();
      this.i = Resources.getSystem().getDisplayMetrics().scaledDensity;
      this.j = Collections.newSetFromMap(new ConcurrentHashMap<>());
      HandlerThread var5 = new HandlerThread(ViewCrawler.class.getCanonicalName());
      var5.setPriority(10);
      var5.start();
      this.h = new ViewCrawler.ViewCrawlerHandler(this, var1, var2, var5.getLooper(), this);
      this.d = new DynamicEventTracker(var3, this.h);
      this.c = var3;
      ((Application)var1.getApplicationContext()).registerActivityLifecycleCallbacks(new ViewCrawler.LifecycleCallbacks(this));
      this.f.a(new Tweaks.OnTweakDeclaredListener(this) {
         final ViewCrawler a;

         {
            this.a = var1;
         }

         @Override
         public void a() {
            Message var1x = this.a.h.obtainMessage(4);
            this.a.h.sendMessage(var1x);
         }
      });
   }

   @Override
   public void a() {
      this.h.a();
      this.b();
   }

   @Override
   public void a(ViewVisitor.LayoutErrorMessage var1) {
      Message var2 = this.h.obtainMessage();
      var2.what = 12;
      var2.obj = var1;
      this.h.sendMessage(var2);
   }

   @Override
   public void a(String var1) {
      Message var2 = this.h.obtainMessage();
      var2.what = 7;
      var2.obj = var1;
      this.h.sendMessage(var2);
   }

   @Override
   public void a(JSONArray var1) {
      if (var1 != null) {
         Message var2 = this.h.obtainMessage(13);
         var2.obj = var1;
         this.h.sendMessage(var2);
      }
   }

   @Override
   public void b() {
      this.h.sendMessage(this.h.obtainMessage(0));
   }

   @Override
   public void b(JSONArray var1) {
      if (var1 != null) {
         Message var2 = this.h.obtainMessage(5);
         var2.obj = var1;
         this.h.sendMessage(var2);
      }
   }

   @Override
   public void c(JSONArray var1) {
      if (var1 != null) {
         Message var2 = this.h.obtainMessage(9);
         var2.obj = var1;
         this.h.sendMessage(var2);
      }
   }

   private class Editor implements EditorConnection.Editor {
      final ViewCrawler a;

      private Editor(ViewCrawler var1) {
         this.a = var1;
      }

      @Override
      public void a() {
         Message var1 = this.a.h.obtainMessage(4);
         this.a.h.sendMessage(var1);
      }

      @Override
      public void a(JSONObject var1) {
         Message var2 = this.a.h.obtainMessage(2);
         var2.obj = var1;
         this.a.h.sendMessage(var2);
      }

      @Override
      public void b() {
         Message var1 = this.a.h.obtainMessage(8);
         this.a.h.sendMessage(var1);
      }

      @Override
      public void b(JSONObject var1) {
         Message var2 = this.a.h.obtainMessage(3);
         var2.obj = var1;
         this.a.h.sendMessage(var2);
      }

      @Override
      public void c(JSONObject var1) {
         Message var2 = this.a.h.obtainMessage(10);
         var2.obj = var1;
         this.a.h.sendMessage(var2);
      }

      @Override
      public void d(JSONObject var1) {
         Message var2 = this.a.h.obtainMessage(6);
         var2.obj = var1;
         this.a.h.sendMessage(var2);
      }

      @Override
      public void e(JSONObject var1) {
         Message var2 = this.a.h.obtainMessage(11);
         var2.obj = var1;
         this.a.h.sendMessage(var2);
      }
   }

   private class EmulatorConnector implements Runnable {
      final ViewCrawler a;
      private volatile boolean b;

      public EmulatorConnector(ViewCrawler var1) {
         this.a = var1;
         this.b = true;
      }

      public void a() {
         this.b = false;
         this.a.h.post(this);
      }

      public void b() {
         this.b = true;
         this.a.h.removeCallbacks(this);
      }

      @Override
      public void run() {
         if (!this.b) {
            Message var1 = this.a.h.obtainMessage(1);
            this.a.h.sendMessage(var1);
         }

         this.a.h.postDelayed(this, 30000L);
      }
   }

   private class LifecycleCallbacks implements ActivityLifecycleCallbacks, FlipGesture.OnFlipGestureListener {
      final ViewCrawler a;
      private final FlipGesture b;
      private final ViewCrawler.EmulatorConnector c;

      public LifecycleCallbacks(ViewCrawler var1) {
         this.a = var1;
         this.b = new FlipGesture(this);
         this.c = var1.new EmulatorConnector(var1);
      }

      private void a(Activity var1) {
         if (this.b() && !this.a.a.f()) {
            this.c.a();
         } else if (!this.a.a.e()) {
            SensorManager var3 = (SensorManager)var1.getSystemService("sensor");
            Sensor var2 = var3.getDefaultSensor(1);
            var3.registerListener(this.b, var2, 3);
         }
      }

      private void b(Activity var1) {
         if (this.b() && !this.a.a.f()) {
            this.c.b();
         } else if (!this.a.a.e()) {
            ((SensorManager)var1.getSystemService("sensor")).unregisterListener(this.b);
         }
      }

      private boolean b() {
         boolean var2 = false;
         boolean var3;
         if (!Build.HARDWARE.toLowerCase().equals("goldfish") && !Build.HARDWARE.toLowerCase().equals("ranchu")) {
            var3 = var2;
         } else {
            if (!Build.BRAND.toLowerCase().startsWith("generic") && !Build.BRAND.toLowerCase().equals("android")) {
               var3 = var2;
               if (!Build.BRAND.toLowerCase().equals("google")) {
                  return var3;
               }
            }

            var3 = var2;
            if (Build.DEVICE.toLowerCase().startsWith("generic")) {
               var3 = var2;
               if (Build.PRODUCT.toLowerCase().contains("sdk")) {
                  var3 = var2;
                  if (Build.MODEL.toLowerCase(Locale.US).contains("sdk")) {
                     var3 = true;
                  }
               }
            }
         }

         return var3;
      }

      @Override
      public void a() {
         this.a.c.b("$ab_gesture3");
         Message var1 = this.a.h.obtainMessage(1);
         this.a.h.sendMessage(var1);
      }

      public void onActivityCreated(Activity var1, Bundle var2) {
      }

      public void onActivityDestroyed(Activity var1) {
      }

      public void onActivityPaused(Activity var1) {
         this.a.e.b(var1);
         this.b(var1);
      }

      public void onActivityResumed(Activity var1) {
         this.a(var1);
         this.a.e.a(var1);
      }

      public void onActivitySaveInstanceState(Activity var1, Bundle var2) {
      }

      public void onActivityStarted(Activity var1) {
      }

      public void onActivityStopped(Activity var1) {
      }
   }

   private static class VariantChange {
      public final String a;
      public final String b;
      public final JSONObject c;
      public final Pair<Integer, Integer> d;

      public VariantChange(String var1, String var2, JSONObject var3, Pair<Integer, Integer> var4) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
         this.d = var4;
      }

      @Override
      public boolean equals(Object var1) {
         boolean var3 = false;
         boolean var2 = var3;
         if (var1 instanceof ViewCrawler.VariantChange) {
            var2 = var3;
            if (var1.hashCode() == this.hashCode()) {
               var2 = true;
            }
         }

         return var2;
      }

      @Override
      public int hashCode() {
         return this.a.hashCode();
      }
   }

   private static class VariantTweak {
      public final String a;
      public final JSONObject b;
      public final Pair<Integer, Integer> c;

      public VariantTweak(String var1, JSONObject var2, Pair<Integer, Integer> var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }

      @Override
      public boolean equals(Object var1) {
         boolean var3 = false;
         boolean var2 = var3;
         if (var1 instanceof ViewCrawler.VariantTweak) {
            var2 = var3;
            if (var1.hashCode() == this.hashCode()) {
               var2 = true;
            }
         }

         return var2;
      }

      @Override
      public int hashCode() {
         return this.a.hashCode();
      }
   }

   private class ViewCrawlerHandler extends Handler {
      final ViewCrawler a;
      private EditorConnection b;
      private ViewSnapshot c;
      private final String d;
      private final Lock e;
      private final EditProtocol f;
      private final ImageStore g;
      private final Map<String, Pair<String, JSONObject>> h;
      private final List<JSONObject> i;
      private final List<String> j;
      private final Map<String, Pair<String, JSONObject>> k;
      private final Set<ViewCrawler.VariantChange> l;
      private final Set<ViewCrawler.VariantTweak> m;
      private final Set<Pair<Integer, Integer>> n;
      private final Set<Pair<String, JSONObject>> o;
      private final Set<Pair<String, JSONObject>> p;
      private final Set<Pair<Integer, Integer>> q;

      public ViewCrawlerHandler(ViewCrawler var1, Context var2, String var3, Looper var4, ViewVisitor.OnLayoutErrorListener var5) {
         super(var4);
         this.a = var1;
         this.d = var3;
         this.c = null;
         var3 = var1.a.x();
         String var6 = var3;
         if (var3 == null) {
            var6 = var2.getPackageName();
         }

         ResourceReader.Ids var7 = new ResourceReader.Ids(var6, var2);
         this.g = new ImageStore(var2, "ViewCrawler");
         this.f = new EditProtocol(var2, var7, this.g, var5);
         this.p = new HashSet<>();
         this.h = new HashMap<>();
         this.i = new ArrayList<>();
         this.j = new ArrayList<>();
         this.k = new HashMap<>();
         this.l = new HashSet<>();
         this.m = new HashSet<>();
         this.n = new HashSet<>();
         this.o = new HashSet<>();
         this.q = new HashSet<>();
         this.e = new ReentrantLock();
         this.e.lock();
      }

      private void a(ViewVisitor.LayoutErrorMessage var1) {
         if (this.b != null && this.b.a() && this.b.b()) {
            JsonWriter var2 = new JsonWriter(new OutputStreamWriter(this.b.c()));

            try {
               var2.beginObject();
               var2.name("type").value("layout_error");
               var2.name("exception_type").value(var1.a());
               var2.name("cid").value(var1.b());
               var2.endObject();
            } catch (IOException var9) {
               MPLog.e("MixpanelAPI.ViewCrawler", "Can't write track_message to server", var9);
            } finally {
               try {
                  var2.close();
               } catch (IOException var8) {
                  MPLog.e("MixpanelAPI.ViewCrawler", "Can't close writer.", var8);
               }
            }
         }
      }

      // $VF: Duplicated exception handlers to handle obfuscated exceptions
      private void a(String var1) {
         if (var1 != null) {
            JSONArray var3;
            try {
               var3 = new JSONArray(var1);
               this.o.clear();
            } catch (JSONException var8) {
               MPLog.c("MixpanelAPI.ViewCrawler", "JSON error when loading event bindings, clearing persistent memory", var8);
               android.content.SharedPreferences.Editor var9 = this.g().edit();
               var9.remove("mixpanel.viewcrawler.bindings");
               var9.apply();
               return;
            }

            int var2 = 0;

            while (true) {
               try {
                  if (var2 >= var3.length()) {
                     break;
                  }

                  JSONObject var11 = var3.getJSONObject(var2);
                  String var4 = JSONUtils.a(var11, "target_activity");
                  Set var5 = this.o;
                  Pair var6 = new Pair(var4, var11);
                  var5.add(var6);
               } catch (JSONException var7) {
                  MPLog.c("MixpanelAPI.ViewCrawler", "JSON error when loading event bindings, clearing persistent memory", var7);
                  android.content.SharedPreferences.Editor var10 = this.g().edit();
                  var10.remove("mixpanel.viewcrawler.bindings");
                  var10.apply();
                  break;
               }

               var2++;
            }
         }
      }

      // $VF: Duplicated exception handlers to handle obfuscated exceptions
      private void a(String var1, boolean var2) {
         if (var1 != null) {
            int var5;
            JSONArray var8;
            try {
               var8 = new JSONArray(var1);
               var5 = var8.length();
            } catch (JSONException var21) {
               MPLog.c("MixpanelAPI.ViewCrawler", "JSON error when loading ab tests / tweaks, clearing persistent memory", var21);
               android.content.SharedPreferences.Editor var22 = this.g().edit();
               var22.remove("mixpanel.viewcrawler.changes");
               var22.apply();
               return;
            }

            for (int var3 = 0; var3 < var5; var3++) {
               JSONArray var10;
               JSONObject var11;
               int var32;
               try {
                  var11 = var8.getJSONObject(var3);
                  int var4 = var11.getInt("id");
                  var32 = var11.getInt("experiment_id");
                  var24 = new Pair(var32, var4);
                  var10 = var11.getJSONArray("actions");
                  var32 = var10.length();
               } catch (JSONException var16) {
                  MPLog.c("MixpanelAPI.ViewCrawler", "JSON error when loading ab tests / tweaks, clearing persistent memory", var16);
                  android.content.SharedPreferences.Editor var23 = this.g().edit();
                  var23.remove("mixpanel.viewcrawler.changes");
                  var23.apply();
                  break;
               }

               for (int var30 = 0; var30 < var32; var30++) {
                  try {
                     JSONObject var14 = var10.getJSONObject(var30);
                     String var13 = JSONUtils.a(var14, "target_activity");
                     String var9 = var14.getString("name");
                     ViewCrawler.VariantChange var12 = new ViewCrawler.VariantChange(var9, var13, var14, var24);
                     this.l.add(var12);
                  } catch (JSONException var15) {
                     MPLog.c("MixpanelAPI.ViewCrawler", "JSON error when loading ab tests / tweaks, clearing persistent memory", var15);
                     android.content.SharedPreferences.Editor var25 = this.g().edit();
                     var25.remove("mixpanel.viewcrawler.changes");
                     var25.apply();
                     return;
                  }
               }

               int var7;
               try {
                  var35 = var11.getJSONArray("tweaks");
                  var7 = var35.length();
               } catch (JSONException var20) {
                  MPLog.c("MixpanelAPI.ViewCrawler", "JSON error when loading ab tests / tweaks, clearing persistent memory", var20);
                  android.content.SharedPreferences.Editor var26 = this.g().edit();
                  var26.remove("mixpanel.viewcrawler.changes");
                  var26.apply();
                  break;
               }

               for (int var31 = 0; var31 < var7; var31++) {
                  try {
                     JSONObject var34 = var35.getJSONObject(var31);
                     String var33 = var34.getString("name");
                     ViewCrawler.VariantTweak var36 = new ViewCrawler.VariantTweak(var33, var34, var24);
                     this.m.add(var36);
                  } catch (JSONException var19) {
                     MPLog.c("MixpanelAPI.ViewCrawler", "JSON error when loading ab tests / tweaks, clearing persistent memory", var19);
                     android.content.SharedPreferences.Editor var27 = this.g().edit();
                     var27.remove("mixpanel.viewcrawler.changes");
                     var27.apply();
                     return;
                  }
               }

               if (!var2) {
                  try {
                     this.q.add(var24);
                  } catch (JSONException var18) {
                     MPLog.c("MixpanelAPI.ViewCrawler", "JSON error when loading ab tests / tweaks, clearing persistent memory", var18);
                     android.content.SharedPreferences.Editor var28 = this.g().edit();
                     var28.remove("mixpanel.viewcrawler.changes");
                     var28.apply();
                     break;
                  }
               }

               if (var7 == 0 && var32 == 0) {
                  try {
                     this.n.add(var24);
                  } catch (JSONException var17) {
                     MPLog.c("MixpanelAPI.ViewCrawler", "JSON error when loading ab tests / tweaks, clearing persistent memory", var17);
                     android.content.SharedPreferences.Editor var29 = this.g().edit();
                     var29.remove("mixpanel.viewcrawler.changes");
                     var29.apply();
                     break;
                  }
               }
            }
         }
      }

      // $VF: Duplicated exception handlers to handle obfuscated exceptions
      private void a(Set<Pair<Integer, Integer>> var1) {
         if (var1 != null && var1.size() > 0) {
            JSONObject var4 = new JSONObject();

            try {
               var10 = var1.iterator();
            } catch (JSONException var9) {
               MPLog.f("MixpanelAPI.ViewCrawler", "Could not build JSON for reporting experiment start", var9);
               return;
            }

            while (true) {
               try {
                  if (!var10.hasNext()) {
                     break;
                  }

                  Pair var5 = (Pair)var10.next();
                  int var2 = (Integer)var5.first;
                  int var3 = (Integer)var5.second;
                  JSONObject var11 = new JSONObject();
                  var11.put("$experiment_id", var2);
                  var11.put("$variant_id", var3);
                  var4.put(Integer.toString(var2), var3);
                  this.a.c.c().a("$experiments", var4);
                  MixpanelAPI var6 = this.a.c;
                  SuperPropertyUpdate var7 = new SuperPropertyUpdate(this, var4) {
                     final JSONObject a;
                     final ViewCrawler.ViewCrawlerHandler b;

                     {
                        this.b = var1;
                        this.a = var2x;
                     }

                     @Override
                     public JSONObject a(JSONObject var1) {
                        try {
                           var1.put("$experiments", this.a);
                        } catch (JSONException var3x) {
                           MPLog.f("MixpanelAPI.ViewCrawler", "Can't write $experiments super property", var3x);
                        }

                        return var1;
                     }
                  };
                  var6.a(var7);
                  this.a.c.a("$experiment_started", var11);
               } catch (JSONException var8) {
                  MPLog.f("MixpanelAPI.ViewCrawler", "Could not build JSON for reporting experiment start", var8);
                  break;
               }
            }
         }
      }

      private void a(JSONArray var1) {
         android.content.SharedPreferences.Editor var2 = this.g().edit();
         var2.putString("mixpanel.viewcrawler.changes", var1.toString());
         var2.apply();
      }

      private void a(JSONObject var1) {
         long var2 = System.currentTimeMillis();

         try {
            var1 = var1.getJSONObject("payload");
            if (var1.has("config")) {
               this.c = this.f.b(var1);
               MPLog.a("MixpanelAPI.ViewCrawler", "Initializing snapshot with configuration");
            }
         } catch (JSONException var17) {
            MPLog.e("MixpanelAPI.ViewCrawler", "Payload with snapshot config required with snapshot request", var17);
            this.b("Payload with snapshot config required with snapshot request");
            return;
         } catch (EditProtocol.BadInstructionsException var18) {
            MPLog.e("MixpanelAPI.ViewCrawler", "Editor sent malformed message with snapshot request", var18);
            this.b(var18.getMessage());
            return;
         }

         if (this.c == null) {
            this.b("No snapshot configuration (or a malformed snapshot configuration) was sent.");
            MPLog.d("MixpanelAPI.ViewCrawler", "Mixpanel editor is misconfigured, sent a snapshot request without a valid configuration.");
         } else {
            BufferedOutputStream var6 = this.b.c();
            OutputStreamWriter var20 = new OutputStreamWriter(var6);

            try {
               var20.write("{");
               var20.write("\"type\": \"snapshot_response\",");
               var20.write("\"payload\": {");
               var20.write("\"activities\":");
               var20.flush();
               this.c.a(this.a.e, var6);
               long var4 = System.currentTimeMillis();
               var20.write(",\"snapshot_time_millis\": ");
               var20.write(Long.toString(var4 - var2));
               var20.write("}");
               var20.write("}");
            } catch (IOException var15) {
               MPLog.e("MixpanelAPI.ViewCrawler", "Can't write snapshot request to server", var15);
            } finally {
               try {
                  var20.close();
               } catch (IOException var14) {
                  MPLog.e("MixpanelAPI.ViewCrawler", "Can't close writer.", var14);
               }
            }
         }
      }

      private void b() {
         SharedPreferences var2 = this.g();
         String var1 = var2.getString("mixpanel.viewcrawler.changes", null);
         String var3 = var2.getString("mixpanel.viewcrawler.bindings", null);
         this.l.clear();
         this.m.clear();
         this.q.clear();
         this.a(var1, false);
         this.o.clear();
         this.a(var3);
         this.f();
      }

      private void b(String var1) {
         if (this.b != null && this.b.a() && this.b.b()) {
            JSONObject var2 = new JSONObject();

            try {
               var2.put("error_message", var1);
            } catch (JSONException var12) {
               MPLog.e("MixpanelAPI.ViewCrawler", "Apparently impossible JSONException", var12);
            }

            OutputStreamWriter var13 = new OutputStreamWriter(this.b.c());

            try {
               var13.write("{\"type\": \"error\", ");
               var13.write("\"payload\": ");
               var13.write(var2.toString());
               var13.write("}");
            } catch (IOException var10) {
               MPLog.e("MixpanelAPI.ViewCrawler", "Can't write error message to editor", var10);
            } finally {
               try {
                  var13.close();
               } catch (IOException var9) {
                  MPLog.e("MixpanelAPI.ViewCrawler", "Could not close output writer to editor", var9);
               }
            }
         }
      }

      private void b(JSONArray var1) {
         this.a(var1);
         this.a(var1.toString(), true);
         this.f();
      }

      // $VF: Duplicated exception handlers to handle obfuscated exceptions
      private void b(JSONObject var1) {
         JSONArray var4;
         try {
            var4 = var1.getJSONObject("payload").getJSONArray("actions");
         } catch (JSONException var10) {
            MPLog.e("MixpanelAPI.ViewCrawler", "Bad change request received", var10);
            return;
         }

         int var2 = 0;

         while (true) {
            try {
               if (var2 >= var4.length()) {
                  break;
               }

               JSONObject var5 = var4.getJSONObject(var2);
               String var6 = JSONUtils.a(var5, "target_activity");
               String var11 = var5.getString("name");
               Map var3 = this.h;
               Pair var7 = new Pair(var6, var5);
               var3.put(var11, var7);
            } catch (JSONException var9) {
               MPLog.e("MixpanelAPI.ViewCrawler", "Bad change request received", var9);
               return;
            }

            var2++;
         }

         try {
            this.f();
         } catch (JSONException var8) {
            MPLog.e("MixpanelAPI.ViewCrawler", "Bad change request received", var8);
         }
      }

      private void c() {
         MPLog.a("MixpanelAPI.ViewCrawler", "connecting to editor");
         if (this.b != null && this.b.a()) {
            MPLog.a("MixpanelAPI.ViewCrawler", "There is already a valid connection to an events editor.");
         } else {
            SSLSocketFactory var2 = this.a.a.y();
            if (var2 == null) {
               MPLog.a("MixpanelAPI.ViewCrawler", "SSL is not available on this device, no connection will be attempted to the events editor.");
            } else {
               String var1 = MPConfig.a(this.a.b).o() + this.d;

               try {
                  Socket var9 = var2.createSocket();
                  URI var4 = new URI(var1);
                  ViewCrawler.Editor var5 = this.a.new Editor(this.a);
                  EditorConnection var3 = new EditorConnection(var4, var5, var9);
                  this.b = var3;
               } catch (URISyntaxException var6) {
                  MPLog.e("MixpanelAPI.ViewCrawler", "Error parsing URI " + var1 + " for editor websocket", var6);
               } catch (EditorConnection.EditorConnectionException var7) {
                  MPLog.e("MixpanelAPI.ViewCrawler", "Error connecting to URI " + var1, var7);
               } catch (IOException var8) {
                  MPLog.c("MixpanelAPI.ViewCrawler", "Can't create SSL Socket to connect to editor service", var8);
               }
            }
         }
      }

      private void c(String var1) {
         if (this.b != null && this.b.a() && this.b.b()) {
            JsonWriter var2 = new JsonWriter(new OutputStreamWriter(this.b.c()));

            try {
               var2.beginObject();
               var2.name("type").value("track_message");
               var2.name("payload");
               var2.beginObject();
               var2.name("event_name").value(var1);
               var2.endObject();
               var2.endObject();
               var2.flush();
            } catch (IOException var9) {
               MPLog.e("MixpanelAPI.ViewCrawler", "Can't write track_message to server", var9);
            } finally {
               try {
                  var2.close();
               } catch (IOException var8) {
                  MPLog.e("MixpanelAPI.ViewCrawler", "Can't close writer.", var8);
               }
            }
         }
      }

      private void c(JSONArray var1) {
         android.content.SharedPreferences.Editor var2 = this.g().edit();
         var2.putString("mixpanel.viewcrawler.bindings", var1.toString());
         var2.apply();
         this.a(var1.toString());
         this.f();
      }

      // $VF: Duplicated exception handlers to handle obfuscated exceptions
      private void c(JSONObject var1) {
         label26: {
            try {
               var6 = var1.getJSONObject("payload").getJSONArray("actions");
            } catch (JSONException var5) {
               MPLog.e("MixpanelAPI.ViewCrawler", "Bad clear request received", var5);
               break label26;
            }

            int var2 = 0;

            while (true) {
               try {
                  if (var2 >= var6.length()) {
                     break;
                  }

                  String var3 = var6.getString(var2);
                  this.h.remove(var3);
               } catch (JSONException var4) {
                  MPLog.e("MixpanelAPI.ViewCrawler", "Bad clear request received", var4);
                  break;
               }

               var2++;
            }
         }

         this.f();
      }

      private void d() {
         // $VF: Couldn't be decompiled
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         // java.lang.RuntimeException: parsing failure!
         //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
         //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
         //
         // Bytecode:
         // 000: aload 0
         // 001: getfield com/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler.b Lcom/mixpanel/android/viewcrawler/EditorConnection;
         // 004: ifnull 01b
         // 007: aload 0
         // 008: getfield com/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler.b Lcom/mixpanel/android/viewcrawler/EditorConnection;
         // 00b: invokevirtual com/mixpanel/android/viewcrawler/EditorConnection.a ()Z
         // 00e: ifeq 01b
         // 011: aload 0
         // 012: getfield com/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler.b Lcom/mixpanel/android/viewcrawler/EditorConnection;
         // 015: invokevirtual com/mixpanel/android/viewcrawler/EditorConnection.b ()Z
         // 018: ifne 01c
         // 01b: return
         // 01c: new android/util/JsonWriter
         // 01f: dup
         // 020: new java/io/OutputStreamWriter
         // 023: dup
         // 024: aload 0
         // 025: getfield com/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler.b Lcom/mixpanel/android/viewcrawler/EditorConnection;
         // 028: invokevirtual com/mixpanel/android/viewcrawler/EditorConnection.c ()Ljava/io/BufferedOutputStream;
         // 02b: invokespecial java/io/OutputStreamWriter.<init> (Ljava/io/OutputStream;)V
         // 02e: invokespecial android/util/JsonWriter.<init> (Ljava/io/Writer;)V
         // 031: astore 1
         // 032: aload 1
         // 033: invokevirtual android/util/JsonWriter.beginObject ()Landroid/util/JsonWriter;
         // 036: pop
         // 037: aload 1
         // 038: ldc "type"
         // 03a: invokevirtual android/util/JsonWriter.name (Ljava/lang/String;)Landroid/util/JsonWriter;
         // 03d: ldc_w "device_info_response"
         // 040: invokevirtual android/util/JsonWriter.value (Ljava/lang/String;)Landroid/util/JsonWriter;
         // 043: pop
         // 044: aload 1
         // 045: ldc_w "payload"
         // 048: invokevirtual android/util/JsonWriter.name (Ljava/lang/String;)Landroid/util/JsonWriter;
         // 04b: invokevirtual android/util/JsonWriter.beginObject ()Landroid/util/JsonWriter;
         // 04e: pop
         // 04f: aload 1
         // 050: ldc_w "device_type"
         // 053: invokevirtual android/util/JsonWriter.name (Ljava/lang/String;)Landroid/util/JsonWriter;
         // 056: ldc_w "Android"
         // 059: invokevirtual android/util/JsonWriter.value (Ljava/lang/String;)Landroid/util/JsonWriter;
         // 05c: pop
         // 05d: aload 1
         // 05e: ldc_w "device_name"
         // 061: invokevirtual android/util/JsonWriter.name (Ljava/lang/String;)Landroid/util/JsonWriter;
         // 064: astore 3
         // 065: new java/lang/StringBuilder
         // 068: astore 2
         // 069: aload 2
         // 06a: invokespecial java/lang/StringBuilder.<init> ()V
         // 06d: aload 3
         // 06e: aload 2
         // 06f: getstatic android/os/Build.BRAND Ljava/lang/String;
         // 072: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 075: ldc_w "/"
         // 078: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 07b: getstatic android/os/Build.MODEL Ljava/lang/String;
         // 07e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 081: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
         // 084: invokevirtual android/util/JsonWriter.value (Ljava/lang/String;)Landroid/util/JsonWriter;
         // 087: pop
         // 088: aload 1
         // 089: ldc_w "scaled_density"
         // 08c: invokevirtual android/util/JsonWriter.name (Ljava/lang/String;)Landroid/util/JsonWriter;
         // 08f: aload 0
         // 090: getfield com/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler.a Lcom/mixpanel/android/viewcrawler/ViewCrawler;
         // 093: invokestatic com/mixpanel/android/viewcrawler/ViewCrawler.f (Lcom/mixpanel/android/viewcrawler/ViewCrawler;)F
         // 096: f2d
         // 097: invokevirtual android/util/JsonWriter.value (D)Landroid/util/JsonWriter;
         // 09a: pop
         // 09b: aload 0
         // 09c: getfield com/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler.a Lcom/mixpanel/android/viewcrawler/ViewCrawler;
         // 09f: invokestatic com/mixpanel/android/viewcrawler/ViewCrawler.g (Lcom/mixpanel/android/viewcrawler/ViewCrawler;)Ljava/util/Map;
         // 0a2: invokeinterface java/util/Map.entrySet ()Ljava/util/Set; 1
         // 0a7: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
         // 0ac: astore 3
         // 0ad: aload 3
         // 0ae: invokeinterface java/util/Iterator.hasNext ()Z 1
         // 0b3: ifeq 0fb
         // 0b6: aload 3
         // 0b7: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
         // 0bc: checkcast java/util/Map$Entry
         // 0bf: astore 2
         // 0c0: aload 1
         // 0c1: aload 2
         // 0c2: invokeinterface java/util/Map$Entry.getKey ()Ljava/lang/Object; 1
         // 0c7: checkcast java/lang/String
         // 0ca: invokevirtual android/util/JsonWriter.name (Ljava/lang/String;)Landroid/util/JsonWriter;
         // 0cd: aload 2
         // 0ce: invokeinterface java/util/Map$Entry.getValue ()Ljava/lang/Object; 1
         // 0d3: checkcast java/lang/String
         // 0d6: invokevirtual android/util/JsonWriter.value (Ljava/lang/String;)Landroid/util/JsonWriter;
         // 0d9: pop
         // 0da: goto 0ad
         // 0dd: astore 2
         // 0de: ldc "MixpanelAPI.ViewCrawler"
         // 0e0: ldc_w "Can't write device_info to server"
         // 0e3: aload 2
         // 0e4: invokestatic com/mixpanel/android/util/MPLog.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
         // 0e7: aload 1
         // 0e8: invokevirtual android/util/JsonWriter.close ()V
         // 0eb: goto 01b
         // 0ee: astore 1
         // 0ef: ldc "MixpanelAPI.ViewCrawler"
         // 0f1: ldc_w "Can't close websocket writer"
         // 0f4: aload 1
         // 0f5: invokestatic com/mixpanel/android/util/MPLog.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
         // 0f8: goto 01b
         // 0fb: aload 0
         // 0fc: getfield com/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler.a Lcom/mixpanel/android/viewcrawler/ViewCrawler;
         // 0ff: invokestatic com/mixpanel/android/viewcrawler/ViewCrawler.h (Lcom/mixpanel/android/viewcrawler/ViewCrawler;)Lcom/mixpanel/android/mpmetrics/Tweaks;
         // 102: invokevirtual com/mixpanel/android/mpmetrics/Tweaks.a ()Ljava/util/Map;
         // 105: astore 2
         // 106: aload 1
         // 107: ldc_w "tweaks"
         // 10a: invokevirtual android/util/JsonWriter.name (Ljava/lang/String;)Landroid/util/JsonWriter;
         // 10d: invokevirtual android/util/JsonWriter.beginArray ()Landroid/util/JsonWriter;
         // 110: pop
         // 111: aload 2
         // 112: invokeinterface java/util/Map.entrySet ()Ljava/util/Set; 1
         // 117: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
         // 11c: astore 3
         // 11d: aload 3
         // 11e: invokeinterface java/util/Iterator.hasNext ()Z 1
         // 123: ifeq 2c4
         // 126: aload 3
         // 127: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
         // 12c: checkcast java/util/Map$Entry
         // 12f: astore 4
         // 131: aload 4
         // 133: invokeinterface java/util/Map$Entry.getValue ()Ljava/lang/Object; 1
         // 138: checkcast com/mixpanel/android/mpmetrics/Tweaks$TweakValue
         // 13b: astore 2
         // 13c: aload 4
         // 13e: invokeinterface java/util/Map$Entry.getKey ()Ljava/lang/Object; 1
         // 143: checkcast java/lang/String
         // 146: astore 4
         // 148: aload 1
         // 149: invokevirtual android/util/JsonWriter.beginObject ()Landroid/util/JsonWriter;
         // 14c: pop
         // 14d: aload 1
         // 14e: ldc_w "name"
         // 151: invokevirtual android/util/JsonWriter.name (Ljava/lang/String;)Landroid/util/JsonWriter;
         // 154: aload 4
         // 156: invokevirtual android/util/JsonWriter.value (Ljava/lang/String;)Landroid/util/JsonWriter;
         // 159: pop
         // 15a: aload 1
         // 15b: ldc_w "minimum"
         // 15e: invokevirtual android/util/JsonWriter.name (Ljava/lang/String;)Landroid/util/JsonWriter;
         // 161: aload 2
         // 162: invokevirtual com/mixpanel/android/mpmetrics/Tweaks$TweakValue.d ()Ljava/lang/Number;
         // 165: invokevirtual android/util/JsonWriter.value (Ljava/lang/Number;)Landroid/util/JsonWriter;
         // 168: pop
         // 169: aload 1
         // 16a: ldc_w "maximum"
         // 16d: invokevirtual android/util/JsonWriter.name (Ljava/lang/String;)Landroid/util/JsonWriter;
         // 170: aload 2
         // 171: invokevirtual com/mixpanel/android/mpmetrics/Tweaks$TweakValue.e ()Ljava/lang/Number;
         // 174: invokevirtual android/util/JsonWriter.value (Ljava/lang/Number;)Landroid/util/JsonWriter;
         // 177: pop
         // 178: aload 2
         // 179: getfield com/mixpanel/android/mpmetrics/Tweaks$TweakValue.a I
         // 17c: tableswitch 32 1 4 86 141 210 279
         // 19c: new java/lang/StringBuilder
         // 19f: astore 4
         // 1a1: aload 4
         // 1a3: invokespecial java/lang/StringBuilder.<init> ()V
         // 1a6: ldc "MixpanelAPI.ViewCrawler"
         // 1a8: aload 4
         // 1aa: ldc_w "Unrecognized Tweak Type "
         // 1ad: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 1b0: aload 2
         // 1b1: getfield com/mixpanel/android/mpmetrics/Tweaks$TweakValue.a I
         // 1b4: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
         // 1b7: ldc_w " encountered."
         // 1ba: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 1bd: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
         // 1c0: invokestatic com/mixpanel/android/util/MPLog.f (Ljava/lang/String;Ljava/lang/String;)V
         // 1c3: aload 1
         // 1c4: invokevirtual android/util/JsonWriter.endObject ()Landroid/util/JsonWriter;
         // 1c7: pop
         // 1c8: goto 11d
         // 1cb: astore 2
         // 1cc: aload 1
         // 1cd: invokevirtual android/util/JsonWriter.close ()V
         // 1d0: aload 2
         // 1d1: athrow
         // 1d2: aload 1
         // 1d3: ldc "type"
         // 1d5: invokevirtual android/util/JsonWriter.name (Ljava/lang/String;)Landroid/util/JsonWriter;
         // 1d8: ldc_w "boolean"
         // 1db: invokevirtual android/util/JsonWriter.value (Ljava/lang/String;)Landroid/util/JsonWriter;
         // 1de: pop
         // 1df: aload 1
         // 1e0: ldc_w "value"
         // 1e3: invokevirtual android/util/JsonWriter.name (Ljava/lang/String;)Landroid/util/JsonWriter;
         // 1e6: aload 2
         // 1e7: invokevirtual com/mixpanel/android/mpmetrics/Tweaks$TweakValue.c ()Ljava/lang/Boolean;
         // 1ea: invokevirtual java/lang/Boolean.booleanValue ()Z
         // 1ed: invokevirtual android/util/JsonWriter.value (Z)Landroid/util/JsonWriter;
         // 1f0: pop
         // 1f1: aload 1
         // 1f2: ldc_w "default"
         // 1f5: invokevirtual android/util/JsonWriter.name (Ljava/lang/String;)Landroid/util/JsonWriter;
         // 1f8: aload 2
         // 1f9: invokevirtual com/mixpanel/android/mpmetrics/Tweaks$TweakValue.f ()Ljava/lang/Object;
         // 1fc: checkcast java/lang/Boolean
         // 1ff: invokevirtual java/lang/Boolean.booleanValue ()Z
         // 202: invokevirtual android/util/JsonWriter.value (Z)Landroid/util/JsonWriter;
         // 205: pop
         // 206: goto 1c3
         // 209: aload 1
         // 20a: ldc "type"
         // 20c: invokevirtual android/util/JsonWriter.name (Ljava/lang/String;)Landroid/util/JsonWriter;
         // 20f: ldc_w "number"
         // 212: invokevirtual android/util/JsonWriter.value (Ljava/lang/String;)Landroid/util/JsonWriter;
         // 215: pop
         // 216: aload 1
         // 217: ldc_w "encoding"
         // 21a: invokevirtual android/util/JsonWriter.name (Ljava/lang/String;)Landroid/util/JsonWriter;
         // 21d: ldc_w "d"
         // 220: invokevirtual android/util/JsonWriter.value (Ljava/lang/String;)Landroid/util/JsonWriter;
         // 223: pop
         // 224: aload 1
         // 225: ldc_w "value"
         // 228: invokevirtual android/util/JsonWriter.name (Ljava/lang/String;)Landroid/util/JsonWriter;
         // 22b: aload 2
         // 22c: invokevirtual com/mixpanel/android/mpmetrics/Tweaks$TweakValue.b ()Ljava/lang/Number;
         // 22f: invokevirtual java/lang/Number.doubleValue ()D
         // 232: invokevirtual android/util/JsonWriter.value (D)Landroid/util/JsonWriter;
         // 235: pop
         // 236: aload 1
         // 237: ldc_w "default"
         // 23a: invokevirtual android/util/JsonWriter.name (Ljava/lang/String;)Landroid/util/JsonWriter;
         // 23d: aload 2
         // 23e: invokevirtual com/mixpanel/android/mpmetrics/Tweaks$TweakValue.f ()Ljava/lang/Object;
         // 241: checkcast java/lang/Number
         // 244: invokevirtual java/lang/Number.doubleValue ()D
         // 247: invokevirtual android/util/JsonWriter.value (D)Landroid/util/JsonWriter;
         // 24a: pop
         // 24b: goto 1c3
         // 24e: aload 1
         // 24f: ldc "type"
         // 251: invokevirtual android/util/JsonWriter.name (Ljava/lang/String;)Landroid/util/JsonWriter;
         // 254: ldc_w "number"
         // 257: invokevirtual android/util/JsonWriter.value (Ljava/lang/String;)Landroid/util/JsonWriter;
         // 25a: pop
         // 25b: aload 1
         // 25c: ldc_w "encoding"
         // 25f: invokevirtual android/util/JsonWriter.name (Ljava/lang/String;)Landroid/util/JsonWriter;
         // 262: ldc_w "l"
         // 265: invokevirtual android/util/JsonWriter.value (Ljava/lang/String;)Landroid/util/JsonWriter;
         // 268: pop
         // 269: aload 1
         // 26a: ldc_w "value"
         // 26d: invokevirtual android/util/JsonWriter.name (Ljava/lang/String;)Landroid/util/JsonWriter;
         // 270: aload 2
         // 271: invokevirtual com/mixpanel/android/mpmetrics/Tweaks$TweakValue.b ()Ljava/lang/Number;
         // 274: invokevirtual java/lang/Number.longValue ()J
         // 277: invokevirtual android/util/JsonWriter.value (J)Landroid/util/JsonWriter;
         // 27a: pop
         // 27b: aload 1
         // 27c: ldc_w "default"
         // 27f: invokevirtual android/util/JsonWriter.name (Ljava/lang/String;)Landroid/util/JsonWriter;
         // 282: aload 2
         // 283: invokevirtual com/mixpanel/android/mpmetrics/Tweaks$TweakValue.f ()Ljava/lang/Object;
         // 286: checkcast java/lang/Number
         // 289: invokevirtual java/lang/Number.longValue ()J
         // 28c: invokevirtual android/util/JsonWriter.value (J)Landroid/util/JsonWriter;
         // 28f: pop
         // 290: goto 1c3
         // 293: aload 1
         // 294: ldc "type"
         // 296: invokevirtual android/util/JsonWriter.name (Ljava/lang/String;)Landroid/util/JsonWriter;
         // 299: ldc_w "string"
         // 29c: invokevirtual android/util/JsonWriter.value (Ljava/lang/String;)Landroid/util/JsonWriter;
         // 29f: pop
         // 2a0: aload 1
         // 2a1: ldc_w "value"
         // 2a4: invokevirtual android/util/JsonWriter.name (Ljava/lang/String;)Landroid/util/JsonWriter;
         // 2a7: aload 2
         // 2a8: invokevirtual com/mixpanel/android/mpmetrics/Tweaks$TweakValue.a ()Ljava/lang/String;
         // 2ab: invokevirtual android/util/JsonWriter.value (Ljava/lang/String;)Landroid/util/JsonWriter;
         // 2ae: pop
         // 2af: aload 1
         // 2b0: ldc_w "default"
         // 2b3: invokevirtual android/util/JsonWriter.name (Ljava/lang/String;)Landroid/util/JsonWriter;
         // 2b6: aload 2
         // 2b7: invokevirtual com/mixpanel/android/mpmetrics/Tweaks$TweakValue.f ()Ljava/lang/Object;
         // 2ba: checkcast java/lang/String
         // 2bd: invokevirtual android/util/JsonWriter.value (Ljava/lang/String;)Landroid/util/JsonWriter;
         // 2c0: pop
         // 2c1: goto 1c3
         // 2c4: aload 1
         // 2c5: invokevirtual android/util/JsonWriter.endArray ()Landroid/util/JsonWriter;
         // 2c8: pop
         // 2c9: aload 1
         // 2ca: invokevirtual android/util/JsonWriter.endObject ()Landroid/util/JsonWriter;
         // 2cd: pop
         // 2ce: aload 1
         // 2cf: invokevirtual android/util/JsonWriter.endObject ()Landroid/util/JsonWriter;
         // 2d2: pop
         // 2d3: aload 1
         // 2d4: invokevirtual android/util/JsonWriter.close ()V
         // 2d7: goto 01b
         // 2da: astore 1
         // 2db: ldc "MixpanelAPI.ViewCrawler"
         // 2dd: ldc_w "Can't close websocket writer"
         // 2e0: aload 1
         // 2e1: invokestatic com/mixpanel/android/util/MPLog.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
         // 2e4: goto 01b
         // 2e7: astore 1
         // 2e8: ldc "MixpanelAPI.ViewCrawler"
         // 2ea: ldc_w "Can't close websocket writer"
         // 2ed: aload 1
         // 2ee: invokestatic com/mixpanel/android/util/MPLog.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
         // 2f1: goto 1d0
         // try (22 -> 76): 94 java/io/IOException
         // try (22 -> 76): 182 null
         // try (76 -> 93): 94 java/io/IOException
         // try (76 -> 93): 182 null
         // try (95 -> 99): 182 null
         // try (99 -> 101): 102 java/io/IOException
         // try (108 -> 122): 94 java/io/IOException
         // try (108 -> 122): 182 null
         // try (122 -> 163): 94 java/io/IOException
         // try (122 -> 163): 182 null
         // try (163 -> 178): 94 java/io/IOException
         // try (163 -> 178): 182 null
         // try (178 -> 181): 94 java/io/IOException
         // try (178 -> 181): 182 null
         // try (183 -> 185): 311 java/io/IOException
         // try (187 -> 210): 94 java/io/IOException
         // try (187 -> 210): 182 null
         // try (211 -> 240): 94 java/io/IOException
         // try (211 -> 240): 182 null
         // try (241 -> 270): 94 java/io/IOException
         // try (241 -> 270): 182 null
         // try (271 -> 292): 94 java/io/IOException
         // try (271 -> 292): 182 null
         // try (293 -> 302): 94 java/io/IOException
         // try (293 -> 302): 182 null
         // try (302 -> 304): 305 java/io/IOException
      }

      // $VF: Duplicated exception handlers to handle obfuscated exceptions
      private void d(JSONObject var1) {
         label26: {
            int var3;
            try {
               this.i.clear();
               var7 = var1.getJSONObject("payload").getJSONArray("tweaks");
               var3 = var7.length();
            } catch (JSONException var6) {
               MPLog.e("MixpanelAPI.ViewCrawler", "Bad tweaks received", var6);
               break label26;
            }

            for (int var2 = 0; var2 < var3; var2++) {
               try {
                  JSONObject var4 = var7.getJSONObject(var2);
                  this.i.add(var4);
               } catch (JSONException var5) {
                  MPLog.e("MixpanelAPI.ViewCrawler", "Bad tweaks received", var5);
                  break;
               }
            }
         }

         this.f();
      }

      private void e() {
         this.h.clear();
         this.k.clear();
         this.i.clear();
         this.o.addAll(this.p);
         this.p.clear();
         this.c = null;
         MPLog.a("MixpanelAPI.ViewCrawler", "Editor closed- freeing snapshot");
         this.f();

         for (String var2 : this.j) {
            this.g.c(var2);
         }
      }

      private void e(JSONObject var1) {
         try {
            var12 = var1.getJSONObject("payload").getJSONArray("events");
         } catch (JSONException var11) {
            MPLog.e("MixpanelAPI.ViewCrawler", "Bad event bindings received", var11);
            return;
         }

         int var3 = var12.length();
         this.k.clear();
         if (!this.o.isEmpty() && this.p.isEmpty()) {
            this.p.addAll(this.o);

            for (Pair var5 : this.o) {
               try {
                  this.k.put(((JSONObject)var5.second).get("path").toString(), var5);
               } catch (JSONException var10) {
                  var10.printStackTrace();
               }
            }

            this.o.clear();
         }

         for (int var2 = 0; var2 < var3; var2++) {
            try {
               JSONObject var13 = var12.getJSONObject(var2);
               String var8 = JSONUtils.a(var13, "target_activity");
               Map var6 = this.k;
               String var14 = var13.get("path").toString();
               Pair var7 = new Pair(var8, var13);
               var6.put(var14, var7);
            } catch (JSONException var9) {
               MPLog.e("MixpanelAPI.ViewCrawler", "Bad event binding received from editor in " + var12.toString(), var9);
            }
         }

         this.f();
      }

      // $VF: Duplicated exception handlers to handle obfuscated exceptions
      private void f() {
         ArrayList var6 = new ArrayList();
         HashSet var5 = new HashSet();
         HashSet var4 = new HashSet();

         for (ViewCrawler.VariantChange var9 : this.l) {
            try {
               EditProtocol.Edit var7 = this.f.a(var9.c);
               Pair var8 = new Pair(var9.b, var7.a);
               var6.add(var8);
               if (!this.q.contains(var9.d)) {
                  var5.add(var9.d);
               }
            } catch (EditProtocol.CantGetEditAssetsException var19) {
               MPLog.a("MixpanelAPI.ViewCrawler", "Can't load assets for an edit, won't apply the change now", var19);
            } catch (EditProtocol.InapplicableInstructionsException var20) {
               MPLog.c("MixpanelAPI.ViewCrawler", var20.getMessage());
            } catch (EditProtocol.BadInstructionsException var21) {
               MPLog.e("MixpanelAPI.ViewCrawler", "Bad persistent change request cannot be applied.", var21);
            }
         }

         for (ViewCrawler.VariantTweak var44 : this.m) {
            Pair var38;
            label203: {
               try {
                  var38 = this.f.c(var44.b);
                  if (!this.q.contains(var44.c)) {
                     var5.add(var44.c);
                     var4.add(var38.first);
                     break label203;
                  }
               } catch (EditProtocol.BadInstructionsException var26) {
                  MPLog.e("MixpanelAPI.ViewCrawler", "Bad editor tweak cannot be applied.", var26);
                  continue;
               }

               try {
                  if (this.a.f.b((String)var38.first, var38.second)) {
                     var4.add(var38.first);
                  }
               } catch (EditProtocol.BadInstructionsException var25) {
                  MPLog.e("MixpanelAPI.ViewCrawler", "Bad editor tweak cannot be applied.", var25);
                  continue;
               }
            }

            label176: {
               try {
                  if (this.a.f.a().containsKey(var38.first)) {
                     break label176;
                  }

                  var45 = Tweaks.TweakValue.a(var44.b);
               } catch (EditProtocol.BadInstructionsException var24) {
                  MPLog.e("MixpanelAPI.ViewCrawler", "Bad editor tweak cannot be applied.", var24);
                  continue;
               }

               if (var45 != null) {
                  try {
                     this.a.f.a((String)var38.first, var45.f(), var45.d(), var45.e(), var45.a);
                  } catch (EditProtocol.BadInstructionsException var23) {
                     MPLog.e("MixpanelAPI.ViewCrawler", "Bad editor tweak cannot be applied.", var23);
                     continue;
                  }
               }
            }

            try {
               this.a.f.a((String)var38.first, var38.second);
            } catch (EditProtocol.BadInstructionsException var18) {
               MPLog.e("MixpanelAPI.ViewCrawler", "Bad editor tweak cannot be applied.", var18);
            }
         }

         if (this.m.size() == 0) {
            for (Entry var46 : this.a.f.b().entrySet()) {
               Tweaks.TweakValue var39 = (Tweaks.TweakValue)var46.getValue();
               String var47 = (String)var46.getKey();
               if (this.a.f.b(var47, var39.g())) {
                  this.a.f.a(var47, var39.g());
                  var4.add(var47);
               }
            }
         }

         for (Pair var52 : this.h.values()) {
            try {
               EditProtocol.Edit var48 = this.f.a((JSONObject)var52.second);
               Pair var40 = new Pair(var52.first, var48.a);
               var6.add(var40);
               this.j.addAll(var48.b);
            } catch (EditProtocol.CantGetEditAssetsException var15) {
               MPLog.a("MixpanelAPI.ViewCrawler", "Can't load assets for an edit, won't apply the change now", var15);
            } catch (EditProtocol.InapplicableInstructionsException var16) {
               MPLog.c("MixpanelAPI.ViewCrawler", var16.getMessage());
            } catch (EditProtocol.BadInstructionsException var17) {
               MPLog.e("MixpanelAPI.ViewCrawler", "Bad editor change request cannot be applied.", var17);
            }
         }

         int var2 = this.i.size();

         for (int var1 = 0; var1 < var2; var1++) {
            JSONObject var32 = this.i.get(var1);

            try {
               var33 = this.f.c(var32);
               if (this.a.f.b((String)var33.first, var33.second)) {
                  var4.add(var33.first);
               }
            } catch (EditProtocol.BadInstructionsException var22) {
               MPLog.e("MixpanelAPI.ViewCrawler", "Strange tweaks received", var22);
               continue;
            }

            try {
               this.a.f.a((String)var33.first, var33.second);
            } catch (EditProtocol.BadInstructionsException var14) {
               MPLog.e("MixpanelAPI.ViewCrawler", "Strange tweaks received", var14);
            }
         }

         if (this.k.size() == 0 && this.p.size() == 0) {
            for (Pair var53 : this.o) {
               try {
                  ViewVisitor var49 = this.f.a((JSONObject)var53.second, this.a.d);
                  Pair var41 = new Pair(var53.first, var49);
                  var6.add(var41);
               } catch (EditProtocol.InapplicableInstructionsException var12) {
                  MPLog.c("MixpanelAPI.ViewCrawler", var12.getMessage());
               } catch (EditProtocol.BadInstructionsException var13) {
                  MPLog.e("MixpanelAPI.ViewCrawler", "Bad persistent event binding cannot be applied.", var13);
               }
            }
         }

         for (Pair var54 : this.k.values()) {
            try {
               ViewVisitor var50 = this.f.a((JSONObject)var54.second, this.a.d);
               Pair var42 = new Pair(var54.first, var50);
               var6.add(var42);
            } catch (EditProtocol.InapplicableInstructionsException var10) {
               MPLog.c("MixpanelAPI.ViewCrawler", var10.getMessage());
            } catch (EditProtocol.BadInstructionsException var11) {
               MPLog.e("MixpanelAPI.ViewCrawler", "Bad editor event binding cannot be applied.", var11);
            }
         }

         HashMap var43 = new HashMap();
         var2 = var6.size();

         for (int var27 = 0; var27 < var2; var27++) {
            Pair var51 = (Pair)var6.get(var27);
            List var36;
            if (var43.containsKey(var51.first)) {
               var36 = (List)var43.get(var51.first);
            } else {
               var36 = new ArrayList();
               var43.put(var51.first, var36);
            }

            var36.add(var51.second);
         }

         this.a.e.a(var43);
         this.q.addAll(var5);
         var5.addAll(this.n);
         this.a(var5);
         this.n.clear();
         if (var4.size() > 0) {
            Iterator var37 = this.a.j.iterator();

            while (var37.hasNext()) {
               ((OnMixpanelTweaksUpdatedListener)var37.next()).a(var4);
            }
         }
      }

      private SharedPreferences g() {
         String var1 = "mixpanel.viewcrawler.changes" + this.d;
         return this.a.b.getSharedPreferences(var1, 0);
      }

      public void a() {
         this.e.unlock();
      }

      public void handleMessage(Message param1) {
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
         // 000: aload 0
         // 001: getfield com/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler.e Ljava/util/concurrent/locks/Lock;
         // 004: invokeinterface java/util/concurrent/locks/Lock.lock ()V 1
         // 009: aload 1
         // 00a: getfield android/os/Message.what I
         // 00d: istore 2
         // 00e: iload 2
         // 00f: tableswitch 69 0 13 79 98 112 168 105 182 196 126 238 154 210 224 140 245
         // 054: aload 0
         // 055: getfield com/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler.e Ljava/util/concurrent/locks/Lock;
         // 058: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
         // 05d: return
         // 05e: aload 0
         // 05f: invokespecial com/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler.b ()V
         // 062: goto 054
         // 065: astore 1
         // 066: aload 0
         // 067: getfield com/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler.e Ljava/util/concurrent/locks/Lock;
         // 06a: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
         // 06f: aload 1
         // 070: athrow
         // 071: aload 0
         // 072: invokespecial com/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler.c ()V
         // 075: goto 054
         // 078: aload 0
         // 079: invokespecial com/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler.d ()V
         // 07c: goto 054
         // 07f: aload 0
         // 080: aload 1
         // 081: getfield android/os/Message.obj Ljava/lang/Object;
         // 084: checkcast org/json/JSONObject
         // 087: invokespecial com/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler.a (Lorg/json/JSONObject;)V
         // 08a: goto 054
         // 08d: aload 0
         // 08e: aload 1
         // 08f: getfield android/os/Message.obj Ljava/lang/Object;
         // 092: checkcast java/lang/String
         // 095: invokespecial com/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler.c (Ljava/lang/String;)V
         // 098: goto 054
         // 09b: aload 0
         // 09c: aload 1
         // 09d: getfield android/os/Message.obj Ljava/lang/Object;
         // 0a0: checkcast com/mixpanel/android/viewcrawler/ViewVisitor$LayoutErrorMessage
         // 0a3: invokespecial com/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler.a (Lcom/mixpanel/android/viewcrawler/ViewVisitor$LayoutErrorMessage;)V
         // 0a6: goto 054
         // 0a9: aload 0
         // 0aa: aload 1
         // 0ab: getfield android/os/Message.obj Ljava/lang/Object;
         // 0ae: checkcast org/json/JSONArray
         // 0b1: invokespecial com/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler.b (Lorg/json/JSONArray;)V
         // 0b4: goto 054
         // 0b7: aload 0
         // 0b8: aload 1
         // 0b9: getfield android/os/Message.obj Ljava/lang/Object;
         // 0bc: checkcast org/json/JSONObject
         // 0bf: invokespecial com/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler.b (Lorg/json/JSONObject;)V
         // 0c2: goto 054
         // 0c5: aload 0
         // 0c6: aload 1
         // 0c7: getfield android/os/Message.obj Ljava/lang/Object;
         // 0ca: checkcast org/json/JSONArray
         // 0cd: invokespecial com/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler.c (Lorg/json/JSONArray;)V
         // 0d0: goto 054
         // 0d3: aload 0
         // 0d4: aload 1
         // 0d5: getfield android/os/Message.obj Ljava/lang/Object;
         // 0d8: checkcast org/json/JSONObject
         // 0db: invokespecial com/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler.e (Lorg/json/JSONObject;)V
         // 0de: goto 054
         // 0e1: aload 0
         // 0e2: aload 1
         // 0e3: getfield android/os/Message.obj Ljava/lang/Object;
         // 0e6: checkcast org/json/JSONObject
         // 0e9: invokespecial com/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler.c (Lorg/json/JSONObject;)V
         // 0ec: goto 054
         // 0ef: aload 0
         // 0f0: aload 1
         // 0f1: getfield android/os/Message.obj Ljava/lang/Object;
         // 0f4: checkcast org/json/JSONObject
         // 0f7: invokespecial com/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler.d (Lorg/json/JSONObject;)V
         // 0fa: goto 054
         // 0fd: aload 0
         // 0fe: invokespecial com/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler.e ()V
         // 101: goto 054
         // 104: aload 0
         // 105: aload 1
         // 106: getfield android/os/Message.obj Ljava/lang/Object;
         // 109: checkcast org/json/JSONArray
         // 10c: invokespecial com/mixpanel/android/viewcrawler/ViewCrawler$ViewCrawlerHandler.a (Lorg/json/JSONArray;)V
         // 10f: goto 054
         // try (3 -> 6): 15 null
         // try (12 -> 14): 15 null
         // try (21 -> 23): 15 null
         // try (24 -> 26): 15 null
         // try (27 -> 32): 15 null
         // try (33 -> 38): 15 null
         // try (39 -> 44): 15 null
         // try (45 -> 50): 15 null
         // try (51 -> 56): 15 null
         // try (57 -> 62): 15 null
         // try (63 -> 68): 15 null
         // try (69 -> 74): 15 null
         // try (75 -> 80): 15 null
         // try (81 -> 83): 15 null
         // try (84 -> 89): 15 null
      }
   }
}
