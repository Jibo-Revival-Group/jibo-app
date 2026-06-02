package android.support.v4.media.session;

import android.media.session.MediaSession.Token;

class MediaSessionCompatApi21 {
   public static Object a(Object var0) {
      if (var0 instanceof Token) {
         return var0;
      } else {
         throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
      }
   }

   static class QueueItem {
      public static Object a(Object var0) {
         return ((android.media.session.MediaSession.QueueItem)var0).getDescription();
      }

      public static long b(Object var0) {
         return ((android.media.session.MediaSession.QueueItem)var0).getQueueId();
      }
   }
}
