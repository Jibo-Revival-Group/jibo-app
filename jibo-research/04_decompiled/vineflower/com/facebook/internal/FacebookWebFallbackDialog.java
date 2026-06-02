package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import org.json.JSONException;
import org.json.JSONObject;

public class FacebookWebFallbackDialog extends WebDialog {
   private static final int OS_BACK_BUTTON_RESPONSE_TIMEOUT_MILLISECONDS = 1500;
   private static final String TAG = FacebookWebFallbackDialog.class.getName();
   private boolean waitingForDialogToClose;

   public FacebookWebFallbackDialog(Context var1, String var2, String var3) {
      super(var1, var2);
      this.setExpectedRedirectUrl(var3);
   }

   @Override
   public void cancel() {
      WebView var1 = this.getWebView();
      if (!this.isPageFinished() || this.isListenerCalled() || var1 == null || !var1.isShown()) {
         super.cancel();
      } else if (!this.waitingForDialogToClose) {
         this.waitingForDialogToClose = true;
         var1.loadUrl(
            "javascript:"
               + "(function() {  var event = document.createEvent('Event');  event.initEvent('fbPlatformDialogMustClose',true,true);  document.dispatchEvent(event);})();"
         );
         new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) {
            final FacebookWebFallbackDialog this$0;

            {
               this.this$0 = var1;
            }

            @Override
            public void run() {
               this.this$0.cancel();
            }
         }, 1500L);
      }
   }

   @Override
   protected Bundle parseResponseUri(String var1) {
      Bundle var3 = Utility.parseUrlQueryString(Uri.parse(var1).getQuery());
      String var2 = var3.getString("bridge_args");
      var3.remove("bridge_args");
      if (!Utility.isNullOrEmpty(var2)) {
         try {
            JSONObject var6 = new JSONObject(var2);
            var3.putBundle("com.facebook.platform.protocol.BRIDGE_ARGS", BundleJSONConverter.convertToBundle(var6));
         } catch (JSONException var5) {
            Utility.logd(TAG, "Unable to parse bridge_args JSON", var5);
         }
      }

      var2 = var3.getString("method_results");
      var3.remove("method_results");
      if (!Utility.isNullOrEmpty(var2)) {
         var1 = var2;
         if (Utility.isNullOrEmpty(var2)) {
            var1 = "{}";
         }

         try {
            JSONObject var9 = new JSONObject(var1);
            var3.putBundle("com.facebook.platform.protocol.RESULT_ARGS", BundleJSONConverter.convertToBundle(var9));
         } catch (JSONException var4) {
            Utility.logd(TAG, "Unable to parse bridge_args JSON", var4);
         }
      }

      var3.remove("version");
      var3.putInt("com.facebook.platform.protocol.PROTOCOL_VERSION", NativeProtocol.getLatestKnownVersion());
      return var3;
   }
}
