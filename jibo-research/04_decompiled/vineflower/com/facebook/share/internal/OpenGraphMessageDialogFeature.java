package com.facebook.share.internal;

import com.facebook.internal.DialogFeature;

public enum OpenGraphMessageDialogFeature implements DialogFeature {
   OG_MESSAGE_DIALOG(20140204);

   private static final OpenGraphMessageDialogFeature[] $VALUES = new OpenGraphMessageDialogFeature[]{OpenGraphMessageDialogFeature.OG_MESSAGE_DIALOG};
   private int minVersion;

   OpenGraphMessageDialogFeature(int var3) {
      this.minVersion = var3;
   }

   @Override
   public String getAction() {
      return "com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG";
   }

   @Override
   public int getMinVersion() {
      return this.minVersion;
   }
}
