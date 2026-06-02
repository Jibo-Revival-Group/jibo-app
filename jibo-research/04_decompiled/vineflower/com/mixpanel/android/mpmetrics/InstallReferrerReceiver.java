package com.mixpanel.android.mpmetrics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.mixpanel.android.util.MPLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstallReferrerReceiver extends BroadcastReceiver {
   private final Pattern a = Pattern.compile("(^|&)utm_source=([^&#=]*)([#&]|$)");
   private final Pattern b = Pattern.compile("(^|&)utm_medium=([^&#=]*)([#&]|$)");
   private final Pattern c = Pattern.compile("(^|&)utm_campaign=([^&#=]*)([#&]|$)");
   private final Pattern d = Pattern.compile("(^|&)utm_content=([^&#=]*)([#&]|$)");
   private final Pattern e = Pattern.compile("(^|&)utm_term=([^&#=]*)([#&]|$)");

   private String a(Matcher var1) {
      if (var1.find()) {
         String var3 = var1.group(2);
         if (var3 != null) {
            try {
               return URLDecoder.decode(var3, "UTF-8");
            } catch (UnsupportedEncodingException var2) {
               MPLog.e("MixpanelAPI.InstRfrRcvr", "Could not decode a parameter into UTF-8");
            }
         }
      }

      return null;
   }

   public void onReceive(Context var1, Intent var2) {
      Bundle var5 = var2.getExtras();
      if (var5 != null) {
         String var3 = var5.getString("referrer");
         if (var3 != null) {
            HashMap var6 = new HashMap();
            var6.put("referrer", var3);
            String var4 = this.a(this.a.matcher(var3));
            if (var4 != null) {
               var6.put("utm_source", var4);
            }

            var4 = this.a(this.b.matcher(var3));
            if (var4 != null) {
               var6.put("utm_medium", var4);
            }

            var4 = this.a(this.c.matcher(var3));
            if (var4 != null) {
               var6.put("utm_campaign", var4);
            }

            var4 = this.a(this.d.matcher(var3));
            if (var4 != null) {
               var6.put("utm_content", var4);
            }

            var3 = this.a(this.e.matcher(var3));
            if (var3 != null) {
               var6.put("utm_term", var3);
            }

            PersistentIdentity.a(var1, "com.mixpanel.android.mpmetrics.ReferralInfo", var6);
         }
      }
   }
}
