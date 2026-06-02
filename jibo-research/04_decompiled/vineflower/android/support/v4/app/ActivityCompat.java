package android.support.v4.app;

import android.app.Activity;
import android.app.SharedElementCallback.OnSharedElementsReadyListener;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import android.view.View;
import java.util.List;
import java.util.Map;

public class ActivityCompat extends ContextCompat {
   private static ActivityCompat.PermissionCompatDelegate a;

   public static ActivityCompat.PermissionCompatDelegate a() {
      return a;
   }

   public static void a(Activity var0) {
      if (VERSION.SDK_INT >= 16) {
         var0.finishAffinity();
      } else {
         var0.finish();
      }
   }

   public static void a(Activity var0, Intent var1, int var2, Bundle var3) {
      if (VERSION.SDK_INT >= 16) {
         var0.startActivityForResult(var1, var2, var3);
      } else {
         var0.startActivityForResult(var1, var2);
      }
   }

   public static void a(Activity var0, IntentSender var1, int var2, Intent var3, int var4, int var5, int var6, Bundle var7) throws SendIntentException {
      if (VERSION.SDK_INT >= 16) {
         var0.startIntentSenderForResult(var1, var2, var3, var4, var5, var6, var7);
      } else {
         var0.startIntentSenderForResult(var1, var2, var3, var4, var5, var6);
      }
   }

   public static void a(Activity var0, SharedElementCallback var1) {
      android.app.SharedElementCallback var2 = null;
      Object var3 = null;
      if (VERSION.SDK_INT >= 23) {
         var2 = (android.app.SharedElementCallback)var3;
         if (var1 != null) {
            var2 = new ActivityCompat.SharedElementCallback23Impl(var1);
         }

         var0.setEnterSharedElementCallback(var2);
      } else if (VERSION.SDK_INT >= 21) {
         if (var1 != null) {
            var2 = new ActivityCompat.SharedElementCallback21Impl(var1);
         }

         var0.setEnterSharedElementCallback(var2);
      }
   }

   public static void a(Activity var0, String[] var1, int var2) {
      if (a == null || !a.a(var0, var1, var2)) {
         if (VERSION.SDK_INT >= 23) {
            if (var0 instanceof ActivityCompat.RequestPermissionsRequestCodeValidator) {
               ((ActivityCompat.RequestPermissionsRequestCodeValidator)var0).validateRequestPermissionsRequestCode(var2);
            }

            var0.requestPermissions(var1, var2);
         } else if (var0 instanceof ActivityCompat.OnRequestPermissionsResultCallback) {
            new Handler(Looper.getMainLooper()).post(new Runnable(var1, var0, var2) {
               final String[] a;
               final Activity b;
               final int c;

               {
                  this.a = var1;
                  this.b = var2x;
                  this.c = var3;
               }

               @Override
               public void run() {
                  int[] var4 = new int[this.a.length];
                  PackageManager var5 = this.b.getPackageManager();
                  String var3 = this.b.getPackageName();
                  int var2x = this.a.length;

                  for (int var1x = 0; var1x < var2x; var1x++) {
                     var4[var1x] = var5.checkPermission(this.a[var1x], var3);
                  }

                  ((ActivityCompat.OnRequestPermissionsResultCallback)this.b).onRequestPermissionsResult(this.c, this.a, var4);
               }
            });
         }
      }
   }

   public static boolean a(Activity var0, String var1) {
      boolean var2;
      if (VERSION.SDK_INT >= 23) {
         var2 = var0.shouldShowRequestPermissionRationale(var1);
      } else {
         var2 = false;
      }

      return var2;
   }

   public static void b(Activity var0) {
      if (VERSION.SDK_INT >= 21) {
         var0.finishAfterTransition();
      } else {
         var0.finish();
      }
   }

   public static void b(Activity var0, SharedElementCallback var1) {
      Object var3 = null;
      android.app.SharedElementCallback var2 = null;
      if (VERSION.SDK_INT >= 23) {
         if (var1 != null) {
            var2 = new ActivityCompat.SharedElementCallback23Impl(var1);
         }

         var0.setExitSharedElementCallback(var2);
      } else if (VERSION.SDK_INT >= 21) {
         var2 = (android.app.SharedElementCallback)var3;
         if (var1 != null) {
            var2 = new ActivityCompat.SharedElementCallback21Impl(var1);
         }

         var0.setExitSharedElementCallback(var2);
      }
   }

   public static void c(Activity var0) {
      if (VERSION.SDK_INT >= 21) {
         var0.postponeEnterTransition();
      }
   }

   public static void d(Activity var0) {
      if (VERSION.SDK_INT >= 21) {
         var0.startPostponedEnterTransition();
      }
   }

   public interface OnRequestPermissionsResultCallback {
      void onRequestPermissionsResult(int var1, String[] var2, int[] var3);
   }

   public interface PermissionCompatDelegate {
      boolean a(Activity var1, int var2, int var3, Intent var4);

      boolean a(Activity var1, String[] var2, int var3);
   }

   public interface RequestPermissionsRequestCodeValidator {
      void validateRequestPermissionsRequestCode(int var1);
   }

   private static class SharedElementCallback21Impl extends android.app.SharedElementCallback {
      protected SharedElementCallback a;

      SharedElementCallback21Impl(SharedElementCallback var1) {
         this.a = var1;
      }

      public Parcelable onCaptureSharedElementSnapshot(View var1, Matrix var2, RectF var3) {
         return this.a.a(var1, var2, var3);
      }

      public View onCreateSnapshotView(Context var1, Parcelable var2) {
         return this.a.a(var1, var2);
      }

      public void onMapSharedElements(List<String> var1, Map<String, View> var2) {
         this.a.a(var1, var2);
      }

      public void onRejectSharedElements(List<View> var1) {
         this.a.a(var1);
      }

      public void onSharedElementEnd(List<String> var1, List<View> var2, List<View> var3) {
         this.a.b(var1, var2, var3);
      }

      public void onSharedElementStart(List<String> var1, List<View> var2, List<View> var3) {
         this.a.a(var1, var2, var3);
      }
   }

   private static class SharedElementCallback23Impl extends ActivityCompat.SharedElementCallback21Impl {
      SharedElementCallback23Impl(SharedElementCallback var1) {
         super(var1);
      }

      public void onSharedElementsArrived(List<String> var1, List<View> var2, OnSharedElementsReadyListener var3) {
         this.a.a(var1, var2, new SharedElementCallback.OnSharedElementsReadyListener(this, var3) {
            final OnSharedElementsReadyListener a;
            final ActivityCompat.SharedElementCallback23Impl b;

            {
               this.b = var1;
               this.a = var2x;
            }

            @Override
            public void a() {
               this.a.onSharedElementsReady();
            }
         });
      }
   }
}
