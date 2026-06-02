package com.facebook.share.internal;

import com.facebook.internal.DialogFeature;

public enum ShareDialogFeature implements DialogFeature {
   HASHTAG(20160327),
   LINK_SHARE_QUOTES(20160327),
   MULTIMEDIA(20160327),
   PHOTOS(20140204),
   SHARE_DIALOG(20130618),
   VIDEO(20141028);

   private static final ShareDialogFeature[] $VALUES = new ShareDialogFeature[]{
      ShareDialogFeature.SHARE_DIALOG,
      ShareDialogFeature.PHOTOS,
      ShareDialogFeature.VIDEO,
      ShareDialogFeature.MULTIMEDIA,
      ShareDialogFeature.HASHTAG,
      ShareDialogFeature.LINK_SHARE_QUOTES
   };
   private int minVersion;

   ShareDialogFeature(int var3) {
      this.minVersion = var3;
   }

   @Override
   public String getAction() {
      return "com.facebook.platform.action.request.FEED_DIALOG";
   }

   @Override
   public int getMinVersion() {
      return this.minVersion;
   }
}
