package com.facebook.share.internal;

import com.facebook.internal.DialogFeature;

public enum OpenGraphActionDialogFeature implements DialogFeature {
   OG_ACTION_DIALOG(20130618);

   private static final OpenGraphActionDialogFeature[] $VALUES = new OpenGraphActionDialogFeature[]{OpenGraphActionDialogFeature.OG_ACTION_DIALOG};
   private int minVersion;

   OpenGraphActionDialogFeature(int var3) {
      this.minVersion = var3;
   }

   @Override
   public String getAction() {
      return "com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG";
   }

   @Override
   public int getMinVersion() {
      return this.minVersion;
   }
}
