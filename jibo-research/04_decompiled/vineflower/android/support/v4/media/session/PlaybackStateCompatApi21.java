package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Bundle;
import java.util.List;

class PlaybackStateCompatApi21 {
   public static int a(Object var0) {
      return ((PlaybackState)var0).getState();
   }

   public static long b(Object var0) {
      return ((PlaybackState)var0).getPosition();
   }

   public static long c(Object var0) {
      return ((PlaybackState)var0).getBufferedPosition();
   }

   public static float d(Object var0) {
      return ((PlaybackState)var0).getPlaybackSpeed();
   }

   public static long e(Object var0) {
      return ((PlaybackState)var0).getActions();
   }

   public static CharSequence f(Object var0) {
      return ((PlaybackState)var0).getErrorMessage();
   }

   public static long g(Object var0) {
      return ((PlaybackState)var0).getLastPositionUpdateTime();
   }

   public static List<Object> h(Object var0) {
      return ((PlaybackState)var0).getCustomActions();
   }

   public static long i(Object var0) {
      return ((PlaybackState)var0).getActiveQueueItemId();
   }

   static final class CustomAction {
      public static String a(Object var0) {
         return ((android.media.session.PlaybackState.CustomAction)var0).getAction();
      }

      public static CharSequence b(Object var0) {
         return ((android.media.session.PlaybackState.CustomAction)var0).getName();
      }

      public static int c(Object var0) {
         return ((android.media.session.PlaybackState.CustomAction)var0).getIcon();
      }

      public static Bundle d(Object var0) {
         return ((android.media.session.PlaybackState.CustomAction)var0).getExtras();
      }
   }
}
