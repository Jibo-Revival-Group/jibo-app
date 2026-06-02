package com.mixpanel.android.viewcrawler;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Build.VERSION;
import android.util.Base64OutputStream;
import android.util.DisplayMetrics;
import android.util.JsonWriter;
import android.util.LruCache;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.mixpanel.android.mpmetrics.MPConfig;
import com.mixpanel.android.mpmetrics.ResourceIds;
import com.mixpanel.android.util.MPLog;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONObject;

@TargetApi(16)
class ViewSnapshot {
   private final MPConfig a;
   private final ViewSnapshot.RootViewFinder b;
   private final List<PropertyDescription> c;
   private final ViewSnapshot.ClassNameCache d;
   private final Handler e;
   private final ResourceIds f;

   public ViewSnapshot(Context var1, List<PropertyDescription> var2, ResourceIds var3) {
      this.a = MPConfig.a(var1);
      this.c = var2;
      this.f = var3;
      this.e = new Handler(Looper.getMainLooper());
      this.b = new ViewSnapshot.RootViewFinder();
      this.d = new ViewSnapshot.ClassNameCache(255);
   }

   private void b(JsonWriter var1, View var2) throws IOException {
      float var3 = 0.0F;
      if (var2.getVisibility() != 4 || !this.a.q()) {
         int var5 = var2.getId();
         String var7;
         if (-1 == var5) {
            var7 = null;
         } else {
            var7 = this.f.a(var5);
         }

         var1.beginObject();
         var1.name("hashCode").value(var2.hashCode());
         var1.name("id").value(var5);
         var1.name("mp_id_name").value(var7);
         CharSequence var15 = var2.getContentDescription();
         if (var15 == null) {
            var1.name("contentDescription").nullValue();
         } else {
            var1.name("contentDescription").value(var15.toString());
         }

         Class var16 = (Class)var2.getTag();
         if (var16 == null) {
            var1.name("tag").nullValue();
         } else if (var16 instanceof CharSequence) {
            var1.name("tag").value(var16.toString());
         }

         var1.name("top").value(var2.getTop());
         var1.name("left").value(var2.getLeft());
         var1.name("width").value(var2.getWidth());
         var1.name("height").value(var2.getHeight());
         var1.name("scrollX").value(var2.getScrollX());
         var1.name("scrollY").value(var2.getScrollY());
         var1.name("visibility").value(var2.getVisibility());
         float var4;
         if (VERSION.SDK_INT >= 11) {
            var3 = var2.getTranslationX();
            var4 = var2.getTranslationY();
         } else {
            var4 = 0.0F;
         }

         var1.name("translationX").value(var3);
         var1.name("translationY").value(var4);
         var1.name("classes");
         var1.beginArray();
         var16 = var2.getClass();

         do {
            var1.value((String)this.d.get(var16));
            var16 = var16.getSuperclass();
         } while (var16 != Object.class && var16 != null);

         var1.endArray();
         this.c(var1, var2);
         LayoutParams var18 = var2.getLayoutParams();
         if (var18 instanceof android.widget.RelativeLayout.LayoutParams) {
            int[] var19 = ((android.widget.RelativeLayout.LayoutParams)var18).getRules();
            var1.name("layoutRules");
            var1.beginArray();
            int var6 = var19.length;

            for (int var10 = 0; var10 < var6; var10++) {
               var1.value(var19[var10]);
            }

            var1.endArray();
         }

         var1.name("subviews");
         var1.beginArray();
         if (var2 instanceof ViewGroup) {
            ViewGroup var8 = (ViewGroup)var2;
            int var13 = var8.getChildCount();

            for (int var11 = 0; var11 < var13; var11++) {
               View var20 = var8.getChildAt(var11);
               if (var20 != null) {
                  var1.value(var20.hashCode());
               }
            }
         }

         var1.endArray();
         var1.endObject();
         if (var2 instanceof ViewGroup) {
            ViewGroup var21 = (ViewGroup)var2;
            int var14 = var21.getChildCount();

            for (int var12 = 0; var12 < var14; var12++) {
               var2 = var21.getChildAt(var12);
               if (var2 != null) {
                  this.b(var1, var2);
               }
            }
         }
      }
   }

   private void c(JsonWriter var1, View var2) throws IOException {
      Class var4 = var2.getClass();

      for (PropertyDescription var3 : this.c) {
         if (var3.b.isAssignableFrom(var4) && var3.c != null) {
            Object var6 = var3.c.a(var2);
            if (var6 != null) {
               if (var6 instanceof Number) {
                  var1.name(var3.a).value((Number)var6);
               } else if (var6 instanceof Boolean) {
                  var1.name(var3.a).value((Boolean)var6);
               } else if (var6 instanceof ColorStateList) {
                  var1.name(var3.a).value(((ColorStateList)var6).getDefaultColor());
               } else if (!(var6 instanceof Drawable)) {
                  var1.name(var3.a).value(var6.toString());
               } else {
                  Drawable var7 = (Drawable)var6;
                  Rect var10 = var7.getBounds();
                  var1.name(var3.a);
                  var1.beginObject();
                  var1.name("classes");
                  var1.beginArray();

                  for (Class var8 = var7.getClass(); var8 != Object.class; var8 = var8.getSuperclass()) {
                     var1.value(var8.getCanonicalName());
                  }

                  var1.endArray();
                  var1.name("dimensions");
                  var1.beginObject();
                  var1.name("left").value(var10.left);
                  var1.name("right").value(var10.right);
                  var1.name("top").value(var10.top);
                  var1.name("bottom").value(var10.bottom);
                  var1.endObject();
                  if (var7 instanceof ColorDrawable) {
                     ColorDrawable var9 = (ColorDrawable)var7;
                     var1.name("color").value(var9.getColor());
                  }

                  var1.endObject();
               }
            }
         }
      }
   }

   void a(JsonWriter var1, View var2) throws IOException {
      var1.beginArray();
      this.b(var1, var2);
      var1.endArray();
   }

   public void a(UIThreadSet<Activity> var1, OutputStream var2) throws IOException {
      this.b.a(var1);
      FutureTask var5 = new FutureTask<>(this.b);
      this.e.post(var5);
      OutputStreamWriter var6 = new OutputStreamWriter(var2);
      List var11 = Collections.emptyList();
      var6.write("[");

      label28: {
         try {
            var12 = (List)var5.get(1L, TimeUnit.SECONDS);
         } catch (InterruptedException var8) {
            MPLog.b("MixpanelAPI.Snapshot", "Screenshot interrupted, no screenshot will be sent.", var8);
            break label28;
         } catch (TimeoutException var9) {
            MPLog.c("MixpanelAPI.Snapshot", "Screenshot took more than 1 second to be scheduled and executed. No screenshot will be sent.", var9);
            break label28;
         } catch (ExecutionException var10) {
            MPLog.e("MixpanelAPI.Snapshot", "Exception thrown during screenshot attempt", var10);
            break label28;
         }

         var11 = var12;
      }

      int var4 = var11.size();

      for (int var3 = 0; var3 < var4; var3++) {
         if (var3 > 0) {
            var6.write(",");
         }

         ViewSnapshot.RootViewInfo var13 = (ViewSnapshot.RootViewInfo)var11.get(var3);
         var6.write("{");
         var6.write("\"activity\":");
         var6.write(JSONObject.quote(var13.a));
         var6.write(",");
         var6.write("\"scale\":");
         var6.write(String.format("%s", var13.d));
         var6.write(",");
         var6.write("\"serialized_objects\":");
         JsonWriter var7 = new JsonWriter(var6);
         var7.beginObject();
         var7.name("rootObject").value(var13.b.hashCode());
         var7.name("objects");
         this.a(var7, var13.b);
         var7.endObject();
         var7.flush();
         var6.write(",");
         var6.write("\"screenshot\":");
         var6.flush();
         var13.c.a(CompressFormat.PNG, 100, var2);
         var6.write("}");
      }

      var6.write("]");
      var6.flush();
   }

   private static class CachedBitmap {
      private Bitmap a;
      private final Paint b = new Paint(2);

      public CachedBitmap() {
         this.a = null;
      }

      public void a(int param1, int param2, int param3, Bitmap param4) {
         // $VF: Couldn't be decompiled
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         // java.lang.RuntimeException: parsing failure!
         //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
         //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
         //
         // Bytecode:
         // 00: aload 0
         // 01: monitorenter
         // 02: aload 0
         // 03: getfield com/mixpanel/android/viewcrawler/ViewSnapshot$CachedBitmap.a Landroid/graphics/Bitmap;
         // 06: ifnull 23
         // 09: aload 0
         // 0a: getfield com/mixpanel/android/viewcrawler/ViewSnapshot$CachedBitmap.a Landroid/graphics/Bitmap;
         // 0d: invokevirtual android/graphics/Bitmap.getWidth ()I
         // 10: iload 1
         // 11: if_icmpne 23
         // 14: aload 0
         // 15: getfield com/mixpanel/android/viewcrawler/ViewSnapshot$CachedBitmap.a Landroid/graphics/Bitmap;
         // 18: invokevirtual android/graphics/Bitmap.getHeight ()I
         // 1b: istore 5
         // 1d: iload 5
         // 1f: iload 2
         // 20: if_icmpeq 3e
         // 23: aload 0
         // 24: iload 1
         // 25: iload 2
         // 26: getstatic android/graphics/Bitmap$Config.RGB_565 Landroid/graphics/Bitmap$Config;
         // 29: invokestatic android/graphics/Bitmap.createBitmap (IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
         // 2c: putfield com/mixpanel/android/viewcrawler/ViewSnapshot$CachedBitmap.a Landroid/graphics/Bitmap;
         // 2f: aload 0
         // 30: getfield com/mixpanel/android/viewcrawler/ViewSnapshot$CachedBitmap.a Landroid/graphics/Bitmap;
         // 33: ifnull 3e
         // 36: aload 0
         // 37: getfield com/mixpanel/android/viewcrawler/ViewSnapshot$CachedBitmap.a Landroid/graphics/Bitmap;
         // 3a: iload 3
         // 3b: invokevirtual android/graphics/Bitmap.setDensity (I)V
         // 3e: aload 0
         // 3f: getfield com/mixpanel/android/viewcrawler/ViewSnapshot$CachedBitmap.a Landroid/graphics/Bitmap;
         // 42: ifnull 60
         // 45: new android/graphics/Canvas
         // 48: astore 6
         // 4a: aload 6
         // 4c: aload 0
         // 4d: getfield com/mixpanel/android/viewcrawler/ViewSnapshot$CachedBitmap.a Landroid/graphics/Bitmap;
         // 50: invokespecial android/graphics/Canvas.<init> (Landroid/graphics/Bitmap;)V
         // 53: aload 6
         // 55: aload 4
         // 57: fconst_0
         // 58: fconst_0
         // 59: aload 0
         // 5a: getfield com/mixpanel/android/viewcrawler/ViewSnapshot$CachedBitmap.b Landroid/graphics/Paint;
         // 5d: invokevirtual android/graphics/Canvas.drawBitmap (Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
         // 60: aload 0
         // 61: monitorexit
         // 62: return
         // 63: astore 6
         // 65: aload 0
         // 66: aconst_null
         // 67: putfield com/mixpanel/android/viewcrawler/ViewSnapshot$CachedBitmap.a Landroid/graphics/Bitmap;
         // 6a: goto 2f
         // 6d: astore 4
         // 6f: aload 0
         // 70: monitorexit
         // 71: aload 4
         // 73: athrow
         // try (2 -> 14): 54 null
         // try (17 -> 23): 49 java/lang/OutOfMemoryError
         // try (17 -> 23): 54 null
         // try (23 -> 30): 54 null
         // try (30 -> 46): 54 null
         // try (50 -> 53): 54 null
      }

      public void a(CompressFormat var1, int var2, OutputStream var3) throws IOException {
         synchronized (this) {
            if (this.a != null && this.a.getWidth() != 0 && this.a.getHeight() != 0) {
               var3.write(34);
               Base64OutputStream var6 = new Base64OutputStream(var3, 2);
               this.a.compress(CompressFormat.PNG, 100, var6);
               var6.flush();
               var3.write(34);
            } else {
               var3.write("null".getBytes());
            }
         }
      }
   }

   private static class ClassNameCache extends LruCache<Class<?>, String> {
      public ClassNameCache(int var1) {
         super(var1);
      }

      protected String a(Class<?> var1) {
         return var1.getCanonicalName();
      }
   }

   private static class RootViewFinder implements Callable<List<ViewSnapshot.RootViewInfo>> {
      private UIThreadSet<Activity> a;
      private final List<ViewSnapshot.RootViewInfo> b;
      private final DisplayMetrics c;
      private final ViewSnapshot.CachedBitmap d;
      private final int e = 160;

      public RootViewFinder() {
         this.c = new DisplayMetrics();
         this.b = new ArrayList<>();
         this.d = new ViewSnapshot.CachedBitmap();
      }

      private void a(ViewSnapshot.RootViewInfo var1) {
         View var11 = var1.b;

         Bitmap var8;
         try {
            Method var20 = View.class.getDeclaredMethod("createSnapshot", Config.class, int.class, boolean.class);
            var20.setAccessible(true);
            var8 = (Bitmap)var20.invoke(var11, Config.RGB_565, -1, false);
         } catch (NoSuchMethodException var12) {
            MPLog.a("MixpanelAPI.Snapshot", "Can't call createSnapshot, will use drawCache", var12);
            var8 = null;
         } catch (IllegalArgumentException var13) {
            MPLog.b("MixpanelAPI.Snapshot", "Can't call createSnapshot with arguments", var13);
            var8 = null;
         } catch (InvocationTargetException var14) {
            MPLog.e("MixpanelAPI.Snapshot", "Exception when calling createSnapshot", var14);
            var8 = null;
         } catch (IllegalAccessException var15) {
            MPLog.e("MixpanelAPI.Snapshot", "Can't access createSnapshot, using drawCache", var15);
            var8 = null;
         } catch (ClassCastException var16) {
            MPLog.e("MixpanelAPI.Snapshot", "createSnapshot didn't return a bitmap?", var16);
            var8 = null;
         }

         Boolean var9;
         label61:
         if (var8 == null) {
            Bitmap var21;
            label59: {
               label58: {
                  try {
                     var9 = var11.isDrawingCacheEnabled();
                  } catch (RuntimeException var18) {
                     var10 = var18;
                     var9 = null;
                     break label58;
                  }

                  try {
                     var11.setDrawingCacheEnabled(true);
                     var11.buildDrawingCache(true);
                     var21 = var11.getDrawingCache();
                     break label59;
                  } catch (RuntimeException var17) {
                     var10 = var17;
                  }
               }

               MPLog.a("MixpanelAPI.Snapshot", "Can't take a bitmap snapshot of view " + var11 + ", skipping for now.", var10);
               break label61;
            }

            var8 = var21;
         } else {
            var9 = null;
         }

         float var2 = 1.0F;
         float var3 = var2;
         if (var8 != null) {
            int var4 = var8.getDensity();
            if (var4 != 0) {
               var2 = 160.0F / var4;
            }

            int var5 = var8.getWidth();
            int var6 = var8.getHeight();
            var4 = (int)(var8.getWidth() * var2 + 0.5);
            int var7 = (int)(var8.getHeight() * var2 + 0.5);
            var3 = var2;
            if (var5 > 0) {
               var3 = var2;
               if (var6 > 0) {
                  var3 = var2;
                  if (var4 > 0) {
                     var3 = var2;
                     if (var7 > 0) {
                        this.d.a(var4, var7, 160, var8);
                        var3 = var2;
                     }
                  }
               }
            }
         }

         if (var9 != null && !var9) {
            var11.setDrawingCacheEnabled(false);
         }

         var1.d = var3;
         var1.c = this.d;
      }

      public List<ViewSnapshot.RootViewInfo> a() throws Exception {
         this.b.clear();

         for (Activity var5 : this.a.a()) {
            String var6 = var5.getClass().getCanonicalName();
            View var4 = var5.getWindow().getDecorView().getRootView();
            var5.getWindowManager().getDefaultDisplay().getMetrics(this.c);
            ViewSnapshot.RootViewInfo var7 = new ViewSnapshot.RootViewInfo(var6, var4);
            this.b.add(var7);
         }

         int var2 = this.b.size();

         for (int var1 = 0; var1 < var2; var1++) {
            this.a(this.b.get(var1));
         }

         return this.b;
      }

      public void a(UIThreadSet<Activity> var1) {
         this.a = var1;
      }
   }

   private static class RootViewInfo {
      public final String a;
      public final View b;
      public ViewSnapshot.CachedBitmap c;
      public float d;

      public RootViewInfo(String var1, View var2) {
         this.a = var1;
         this.b = var2;
         this.c = null;
         this.d = 1.0F;
      }
   }
}
