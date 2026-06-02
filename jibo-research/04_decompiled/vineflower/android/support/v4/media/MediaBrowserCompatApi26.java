package android.support.v4.media;

import android.media.browse.MediaBrowser.MediaItem;
import android.os.Bundle;
import java.util.List;

class MediaBrowserCompatApi26 {
   static Object a(MediaBrowserCompatApi26.SubscriptionCallback var0) {
      return new MediaBrowserCompatApi26.SubscriptionCallbackProxy<>(var0);
   }

   interface SubscriptionCallback extends MediaBrowserCompatApi21.SubscriptionCallback {
      void a(String var1, Bundle var2);

      void a(String var1, List<?> var2, Bundle var3);
   }

   static class SubscriptionCallbackProxy<T extends MediaBrowserCompatApi26.SubscriptionCallback> extends MediaBrowserCompatApi21.SubscriptionCallbackProxy<T> {
      SubscriptionCallbackProxy(T var1) {
         super((T)var1);
      }

      public void onChildrenLoaded(String var1, List<MediaItem> var2, Bundle var3) {
         this.a.a(var1, var2, var3);
      }

      public void onError(String var1, Bundle var2) {
         this.a.a(var1, var2);
      }
   }
}
