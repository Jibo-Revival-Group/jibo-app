package android.support.v4.media.session;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.BroadcastReceiver.PendingResult;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.RemoteException;
import android.os.Build.VERSION;
import android.support.v4.media.MediaBrowserCompat;
import android.util.Log;
import android.view.KeyEvent;
import java.util.List;

public class MediaButtonReceiver extends BroadcastReceiver {
   private static ComponentName a(Context var0, String var1) {
      PackageManager var3 = var0.getPackageManager();
      Intent var2 = new Intent(var1);
      var2.setPackage(var0.getPackageName());
      List var4 = var3.queryIntentServices(var2, 0);
      ComponentName var6;
      if (var4.size() == 1) {
         ResolveInfo var5 = (ResolveInfo)var4.get(0);
         var6 = new ComponentName(var5.serviceInfo.packageName, var5.serviceInfo.name);
      } else {
         if (!var4.isEmpty()) {
            throw new IllegalStateException("Expected 1 service that handles " + var1 + ", found " + var4.size());
         }

         var6 = null;
      }

      return var6;
   }

   private static void a(Context var0, Intent var1) {
      if (VERSION.SDK_INT >= 26) {
         var0.startForegroundService(var1);
      } else {
         var0.startService(var1);
      }
   }

   public void onReceive(Context var1, Intent var2) {
      if (var2 != null && "android.intent.action.MEDIA_BUTTON".equals(var2.getAction()) && var2.hasExtra("android.intent.extra.KEY_EVENT")) {
         ComponentName var3 = a(var1, "android.intent.action.MEDIA_BUTTON");
         if (var3 != null) {
            var2.setComponent(var3);
            a(var1, var2);
         } else {
            var3 = a(var1, "android.media.browse.MediaBrowserService");
            if (var3 == null) {
               throw new IllegalStateException(
                  "Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service."
               );
            }

            PendingResult var4 = this.goAsync();
            var1 = var1.getApplicationContext();
            MediaButtonReceiver.MediaButtonConnectionCallback var7 = new MediaButtonReceiver.MediaButtonConnectionCallback(var1, var2, var4);
            MediaBrowserCompat var6 = new MediaBrowserCompat(var1, var3, var7, null);
            var7.a(var6);
            var6.a();
         }
      } else {
         Log.d("MediaButtonReceiver", "Ignore unsupported intent: " + var2);
      }
   }

   private static class MediaButtonConnectionCallback extends MediaBrowserCompat.ConnectionCallback {
      private final Context c;
      private final Intent d;
      private final PendingResult e;
      private MediaBrowserCompat f;

      MediaButtonConnectionCallback(Context var1, Intent var2, PendingResult var3) {
         this.c = var1;
         this.d = var2;
         this.e = var3;
      }

      private void d() {
         this.f.b();
         this.e.finish();
      }

      @Override
      public void a() {
         try {
            MediaControllerCompat var1 = new MediaControllerCompat(this.c, this.f.c());
            var1.a((KeyEvent)this.d.getParcelableExtra("android.intent.extra.KEY_EVENT"));
         } catch (RemoteException var2) {
            Log.e("MediaButtonReceiver", "Failed to create a media controller", var2);
         }

         this.d();
      }

      void a(MediaBrowserCompat var1) {
         this.f = var1;
      }

      @Override
      public void b() {
         this.d();
      }

      @Override
      public void c() {
         this.d();
      }
   }
}
