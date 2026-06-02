package com.facebook.login.widget;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.login.DeviceLoginManager;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;

public class DeviceLoginButton extends LoginButton {
   private Uri deviceRedirectUri;

   public DeviceLoginButton(Context var1) {
      super(var1);
   }

   public DeviceLoginButton(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   public DeviceLoginButton(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
   }

   public Uri getDeviceRedirectUri() {
      return this.deviceRedirectUri;
   }

   @Override
   protected LoginButton.LoginClickListener getNewLoginClickListener() {
      return new DeviceLoginButton.DeviceLoginClickListener(this);
   }

   public void setDeviceRedirectUri(Uri var1) {
      this.deviceRedirectUri = var1;
   }

   private class DeviceLoginClickListener extends LoginButton.LoginClickListener {
      final DeviceLoginButton this$0;

      private DeviceLoginClickListener(DeviceLoginButton var1) {
         super(var1);
         this.this$0 = var1;
      }

      @Override
      protected LoginManager getLoginManager() {
         DeviceLoginManager var1 = DeviceLoginManager.getInstance();
         var1.setDefaultAudience(this.this$0.getDefaultAudience());
         var1.setLoginBehavior(LoginBehavior.DEVICE_AUTH);
         var1.setDeviceRedirectUri(this.this$0.getDeviceRedirectUri());
         return var1;
      }
   }
}
