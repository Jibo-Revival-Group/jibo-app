package com.facebook.internal;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import com.facebook.FacebookSdk;

public class CustomTab {
   private Uri uri;

   public CustomTab(String var1, Bundle var2) {
      Bundle var3 = var2;
      if (var2 == null) {
         var3 = new Bundle();
      }

      this.uri = Utility.buildUri(ServerProtocol.getDialogAuthority(), FacebookSdk.getGraphApiVersion() + "/" + "dialog/" + var1, var3);
   }

   public void openCustomTab(Activity var1, String var2) {
      CustomTabsIntent var3 = new CustomTabsIntent.Builder().a();
      var3.a.setPackage(var2);
      var3.a.addFlags(1073741824);
      var3.a(var1, this.uri);
   }
}
