package com.facebook.login;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.internal.NativeProtocol;

class KatanaProxyLoginMethodHandler extends NativeAppLoginMethodHandler {
   public static final Creator<KatanaProxyLoginMethodHandler> CREATOR = new Creator() {
      public KatanaProxyLoginMethodHandler createFromParcel(Parcel var1) {
         return new KatanaProxyLoginMethodHandler(var1);
      }

      public KatanaProxyLoginMethodHandler[] newArray(int var1) {
         return new KatanaProxyLoginMethodHandler[var1];
      }
   };

   KatanaProxyLoginMethodHandler(Parcel var1) {
      super(var1);
   }

   KatanaProxyLoginMethodHandler(LoginClient var1) {
      super(var1);
   }

   public int describeContents() {
      return 0;
   }

   @Override
   String getNameForLogging() {
      return "katana_proxy_auth";
   }

   @Override
   boolean tryAuthorize(LoginClient.Request var1) {
      String var2 = LoginClient.getE2E();
      Intent var3 = NativeProtocol.createProxyAuthIntent(
         this.loginClient.getActivity(),
         var1.getApplicationId(),
         var1.getPermissions(),
         var2,
         var1.isRerequest(),
         var1.hasPublishPermission(),
         var1.getDefaultAudience(),
         this.getClientState(var1.getAuthId())
      );
      this.addLoggingExtra("e2e", var2);
      return this.tryIntent(var3, LoginClient.getLoginRequestCode());
   }

   @Override
   public void writeToParcel(Parcel var1, int var2) {
      super.writeToParcel(var1, var2);
   }
}
