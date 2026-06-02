package com.jibo.aws.integration.helpers;

import android.text.TextUtils;
import com.jibo.aws.integration.aws.services.jot.model.Message;
import com.jibo.aws.integration.aws.services.jot.model.MessagePart;

public class JotHelper {
   private static MessagePart a(Message var0, String var1) {
      MessagePart var4;
      if (var0.getParts() != null && !var0.getParts().isEmpty()) {
         int var3 = var0.getParts().size();
         int var2 = 0;

         while (true) {
            if (var2 >= var3) {
               var4 = null;
               break;
            }

            MessagePart var5 = var0.getParts().get(var2);
            if (!TextUtils.isEmpty(var5.getType())) {
               var4 = var5;
               if (var5.getType().equals(var1)) {
                  break;
               }
            }

            var2++;
         }
      } else {
         var4 = null;
      }

      return var4;
   }

   public static MessagePart getAudio(Message var0) {
      return a(var0, "audio");
   }

   public static MessagePart getPhoto(Message var0) {
      return a(var0, "image");
   }

   public static MessagePart getRobotThumbnail(Message var0) {
      return a(var0, "thumb_robot");
   }

   public static MessagePart getThumbnail(Message var0) {
      return a(var0, "thumb");
   }

   public static MessagePart getVideo(Message var0) {
      return a(var0, "recording");
   }

   public static boolean hasAudio(Message var0) {
      return hasMedia(var0, "audio");
   }

   public static boolean hasDeletedMedia(Message var0) {
      boolean var3;
      if (var0.getParts() != null && !var0.getParts().isEmpty()) {
         int var2 = var0.getParts().size();
         int var1 = 0;

         while (true) {
            if (var1 >= var2) {
               var3 = false;
               break;
            }

            MessagePart var4 = var0.getParts().get(var1);
            if (TextUtils.isEmpty(var4.getType()) || TextUtils.isEmpty(var4.getUrl())) {
               var3 = true;
               break;
            }

            var1++;
         }
      } else {
         var3 = false;
      }

      return var3;
   }

   public static boolean hasMedia(Message var0, String var1) {
      boolean var4;
      if (var0.getParts() != null && !var0.getParts().isEmpty()) {
         int var3 = var0.getParts().size();
         int var2 = 0;

         while (true) {
            if (var2 >= var3) {
               var4 = false;
               break;
            }

            MessagePart var5 = var0.getParts().get(var2);
            if (!TextUtils.isEmpty(var5.getType()) && var5.getType().equals(var1) && !TextUtils.isEmpty(var5.getUrl())) {
               var4 = true;
               break;
            }

            var2++;
         }
      } else {
         var4 = false;
      }

      return var4;
   }

   public static boolean hasPhoto(Message var0) {
      return hasMedia(var0, "image");
   }

   public static boolean hasPhotoOrVideo(Message var0) {
      boolean var1 = true;
      if (!hasMedia(var0, "image") && !hasMedia(var0, "recording")) {
         var1 = false;
      }

      return var1;
   }

   public static boolean hasVideo(Message var0) {
      return hasMedia(var0, "recording");
   }
}
