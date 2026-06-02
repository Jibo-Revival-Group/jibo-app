package com.jibo.ui.fragment.account.skills;

import android.view.View;
import android.webkit.WebView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class OauthFragment_ViewBinding implements Unbinder {
   private OauthFragment b;

   public OauthFragment_ViewBinding(OauthFragment var1, View var2) {
      this.b = var1;
      var1.webview = Utils.a(var2, 2131297076, "field 'webview'", WebView.class);
   }

   @Override
   public void unbind() {
      OauthFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.webview = null;
   }
}
