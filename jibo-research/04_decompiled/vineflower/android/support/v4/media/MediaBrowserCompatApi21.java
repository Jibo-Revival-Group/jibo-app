package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import java.util.List;

class MediaBrowserCompatApi21 {
   public static Object a(Context var0, ComponentName var1, Object var2, Bundle var3) {
      return new MediaBrowser(var0, var1, (android.media.browse.MediaBrowser.ConnectionCallback)var2, var3);
   }

   public static Object a(MediaBrowserCompatApi21.ConnectionCallback var0) {
      return new MediaBrowserCompatApi21.ConnectionCallbackProxy<>(var0);
   }

   public static Object a(MediaBrowserCompatApi21.SubscriptionCallback var0) {
      return new MediaBrowserCompatApi21.SubscriptionCallbackProxy<>(var0);
   }

   public static void a(Object var0) {
      ((MediaBrowser)var0).connect();
   }

   public static void b(Object var0) {
      ((MediaBrowser)var0).disconnect();
   }

   public static Bundle c(Object var0) {
      return ((MediaBrowser)var0).getExtras();
   }

   public static Object d(Object var0) {
      return ((MediaBrowser)var0).getSessionToken();
   }

   interface ConnectionCallback {
      void a();

      void b();

      void c();
   }

   static class ConnectionCallbackProxy<T extends MediaBrowserCompatApi21.ConnectionCallback> extends android.media.browse.MediaBrowser.ConnectionCallback {
      protected final T a;

      public ConnectionCallbackProxy(T var1) {
         this.a = (T)var1;
      }

      public void onConnected() {
         this.a.a();
      }

      public void onConnectionFailed() {
         this.a.c();
      }

      public void onConnectionSuspended() {
         this.a.b();
      }
   }

   static class MediaItem {
      public static int a(Object var0) {
         return ((android.media.browse.MediaBrowser.MediaItem)var0).getFlags();
      }

      public static Object b(Object var0) {
         return ((android.media.browse.MediaBrowser.MediaItem)var0).getDescription();
      }
   }

   interface SubscriptionCallback {
      void a(String var1);

      void a(String var1, List<?> var2);
   }

   static class SubscriptionCallbackProxy<T extends MediaBrowserCompatApi21.SubscriptionCallback>
      extends android.media.browse.MediaBrowser.SubscriptionCallback {
      protected final T a;

      public SubscriptionCallbackProxy(T var1) {
         this.a = (T)var1;
      }

      public void onChildrenLoaded(String var1, List<android.media.browse.MediaBrowser.MediaItem> var2) {
         this.a.a(var1, var2);
      }

      public void onError(String var1) {
         this.a.a(var1);
      }
   }
}
