package com.google.firebase.iid;

import android.text.TextUtils;
import android.util.Log;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

final class zzz {
   private static final long b = TimeUnit.DAYS.toMillis(7L);
   final String a;
   private String c;
   private long d;

   private zzz(String var1, String var2, long var3) {
      this.a = var1;
      this.c = var2;
      this.d = var3;
   }

   static zzz a(String var0) {
      Object var1 = null;
      zzz var4;
      if (TextUtils.isEmpty(var0)) {
         var4 = (zzz)var1;
      } else if (var0.startsWith("{")) {
         try {
            JSONObject var2 = new JSONObject(var0);
            var4 = new zzz(var2.getString("token"), var2.getString("appVersion"), var2.getLong("timestamp"));
         } catch (JSONException var3) {
            var0 = String.valueOf(var3);
            Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(var0).length() + 23).append("Failed to parse token: ").append(var0).toString());
            var4 = (zzz)var1;
         }
      } else {
         var4 = new zzz(var0, null, 0L);
      }

      return var4;
   }

   static String a(String var0, String var1, long var2) {
      try {
         JSONObject var4 = new JSONObject();
         var4.put("token", var0);
         var4.put("appVersion", var1);
         var4.put("timestamp", var2);
         var0 = var4.toString();
      } catch (JSONException var5) {
         var0 = String.valueOf(var5);
         Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(var0).length() + 24).append("Failed to encode token: ").append(var0).toString());
         var0 = null;
      }

      return var0;
   }

   final boolean b(String var1) {
      boolean var2;
      if (System.currentTimeMillis() <= this.d + b && var1.equals(this.c)) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }
}
