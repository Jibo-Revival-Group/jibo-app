package android.support.v4.media;

import android.os.Bundle;

public class MediaBrowserCompatUtils {
   public static boolean a(Bundle var0, Bundle var1) {
      boolean var2 = true;
      if (var0 != var1) {
         if (var0 == null) {
            if (var1.getInt("android.media.browse.extra.PAGE", -1) != -1 || var1.getInt("android.media.browse.extra.PAGE_SIZE", -1) != -1) {
               var2 = false;
            }
         } else if (var1 == null) {
            if (var0.getInt("android.media.browse.extra.PAGE", -1) != -1 || var0.getInt("android.media.browse.extra.PAGE_SIZE", -1) != -1) {
               var2 = false;
            }
         } else if (var0.getInt("android.media.browse.extra.PAGE", -1) != var1.getInt("android.media.browse.extra.PAGE", -1)
            || var0.getInt("android.media.browse.extra.PAGE_SIZE", -1) != var1.getInt("android.media.browse.extra.PAGE_SIZE", -1)) {
            var2 = false;
         }
      }

      return var2;
   }
}
