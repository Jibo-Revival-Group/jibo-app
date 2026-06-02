package com.jibo.aws.integration.helpers;

import android.net.Uri;
import com.jibo.aws.integration.aws.services.jot.model.Message;
import com.jibo.aws.integration.aws.services.jot.model.MessagePart;
import com.jibo.aws.integration.aws.services.media.model.Media;
import java.io.File;

public class MediaHelper {
   public static File getShareableFile(String var0, Media var1) {
      return new File(var0, "share_" + Math.abs(var1.hashCode()) + var1.getCreated() + ".jpg");
   }

   public static String getUrl(boolean var0, Message var1, MessagePart var2) {
      String var3;
      if (isMessageEncrypted(var0, var1)) {
         var3 = Uri.parse(var2.getUrl()).buildUpon().appendQueryParameter("loopId", var1.getLoopId()).build().toString();
      } else {
         var3 = var2.getUrl();
      }

      return var3;
   }

   public static String getUrl(boolean var0, Media var1) {
      String var2;
      if (isMediaEncrypted(var0, var1)) {
         var2 = Uri.parse(var1.getUrl()).buildUpon().appendQueryParameter("loopId", var1.getLoopId()).build().toString();
      } else {
         var2 = var1.getUrl();
      }

      return var2;
   }

   public static boolean isMediaEncrypted(boolean var0, Media var1) {
      if (var0 && var1.isEncrypted() != null && var1.isEncrypted()) {
         var0 = true;
      } else {
         var0 = false;
      }

      return var0;
   }

   public static boolean isMessageEncrypted(boolean var0, Message var1) {
      if (var0 && var1.isEncrypted() != null && var1.isEncrypted()) {
         var0 = true;
      } else {
         var0 = false;
      }

      return var0;
   }
}
