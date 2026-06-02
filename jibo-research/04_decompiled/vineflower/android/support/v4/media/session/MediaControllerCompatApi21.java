package android.support.v4.media.session;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.PlaybackState;
import android.media.session.MediaSession.QueueItem;
import android.media.session.MediaSession.Token;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.KeyEvent;
import java.util.List;

class MediaControllerCompatApi21 {
   public static Object a(Context var0, Object var1) {
      return new MediaController(var0, (Token)var1);
   }

   public static Object a(MediaControllerCompatApi21.Callback var0) {
      return new MediaControllerCompatApi21.CallbackProxy<>(var0);
   }

   public static void a(Object var0, String var1, Bundle var2, ResultReceiver var3) {
      ((MediaController)var0).sendCommand(var1, var2, var3);
   }

   public static boolean a(Object var0, KeyEvent var1) {
      return ((MediaController)var0).dispatchMediaButtonEvent(var1);
   }

   public interface Callback {
      void a();

      void a(int var1, int var2, int var3, int var4, int var5);

      void a(Bundle var1);

      void a(CharSequence var1);

      void a(Object var1);

      void a(String var1, Bundle var2);

      void a(List<?> var1);

      void b(Object var1);
   }

   static class CallbackProxy<T extends MediaControllerCompatApi21.Callback> extends android.media.session.MediaController.Callback {
      protected final T a;

      public CallbackProxy(T var1) {
         this.a = (T)var1;
      }

      public void onAudioInfoChanged(android.media.session.MediaController.PlaybackInfo var1) {
         this.a
            .a(var1.getPlaybackType(), MediaControllerCompatApi21.PlaybackInfo.b(var1), var1.getVolumeControl(), var1.getMaxVolume(), var1.getCurrentVolume());
      }

      public void onExtrasChanged(Bundle var1) {
         this.a.a(var1);
      }

      public void onMetadataChanged(MediaMetadata var1) {
         this.a.b(var1);
      }

      public void onPlaybackStateChanged(PlaybackState var1) {
         this.a.a(var1);
      }

      public void onQueueChanged(List<QueueItem> var1) {
         this.a.a(var1);
      }

      public void onQueueTitleChanged(CharSequence var1) {
         this.a.a(var1);
      }

      public void onSessionDestroyed() {
         this.a.a();
      }

      public void onSessionEvent(String var1, Bundle var2) {
         this.a.a(var1, var2);
      }
   }

   public static class PlaybackInfo {
      private static int a(AudioAttributes var0) {
         byte var2 = 3;
         byte var1;
         if ((var0.getFlags() & 1) == 1) {
            var1 = 7;
         } else if ((var0.getFlags() & 4) == 4) {
            var1 = 6;
         } else {
            var1 = var2;
            switch (var0.getUsage()) {
               case 1:
               case 11:
               case 12:
               case 14:
                  break;
               case 2:
                  var1 = 0;
                  break;
               case 3:
                  var1 = 8;
                  break;
               case 4:
                  var1 = 4;
                  break;
               case 5:
               case 7:
               case 8:
               case 9:
               case 10:
                  var1 = 5;
                  break;
               case 6:
                  var1 = 2;
                  break;
               case 13:
                  var1 = 1;
                  break;
               default:
                  var1 = var2;
            }
         }

         return var1;
      }

      public static AudioAttributes a(Object var0) {
         return ((android.media.session.MediaController.PlaybackInfo)var0).getAudioAttributes();
      }

      public static int b(Object var0) {
         return a(a(var0));
      }
   }
}
