package com.facebook.share.internal;

import com.facebook.internal.DialogFeature;

public enum AppInviteDialogFeature implements DialogFeature {
   APP_INVITES_DIALOG(20140701);

   private static final AppInviteDialogFeature[] $VALUES = new AppInviteDialogFeature[]{AppInviteDialogFeature.APP_INVITES_DIALOG};
   private int minVersion;

   AppInviteDialogFeature(int var3) {
      this.minVersion = var3;
   }

   @Override
   public String getAction() {
      return "com.facebook.platform.action.request.APPINVITES_DIALOG";
   }

   @Override
   public int getMinVersion() {
      return this.minVersion;
   }
}
