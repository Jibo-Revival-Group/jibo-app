package com.facebook.share.internal;

import com.facebook.internal.DialogFeature;

public enum MessageDialogFeature implements DialogFeature {
   MESSAGE_DIALOG(20140204),
   PHOTOS(20140324),
   VIDEO(20141218);

   private static final MessageDialogFeature[] $VALUES = new MessageDialogFeature[]{
      MessageDialogFeature.MESSAGE_DIALOG, MessageDialogFeature.PHOTOS, MessageDialogFeature.VIDEO
   };
   private int minVersion;

   MessageDialogFeature(int var3) {
      this.minVersion = var3;
   }

   @Override
   public String getAction() {
      return "com.facebook.platform.action.request.MESSAGE_DIALOG";
   }

   @Override
   public int getMinVersion() {
      return this.minVersion;
   }
}
