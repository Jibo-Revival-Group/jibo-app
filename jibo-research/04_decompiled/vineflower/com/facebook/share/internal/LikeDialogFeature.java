package com.facebook.share.internal;

import com.facebook.internal.DialogFeature;

public enum LikeDialogFeature implements DialogFeature {
   LIKE_DIALOG(20140701);

   private static final LikeDialogFeature[] $VALUES = new LikeDialogFeature[]{LikeDialogFeature.LIKE_DIALOG};
   private int minVersion;

   LikeDialogFeature(int var3) {
      this.minVersion = var3;
   }

   @Override
   public String getAction() {
      return "com.facebook.platform.action.request.LIKE_DIALOG";
   }

   @Override
   public int getMinVersion() {
      return this.minVersion;
   }
}
