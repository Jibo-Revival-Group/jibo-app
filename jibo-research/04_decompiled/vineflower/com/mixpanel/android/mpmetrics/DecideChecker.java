package com.mixpanel.android.mpmetrics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;
import com.mixpanel.android.util.ImageStore;
import com.mixpanel.android.util.MPLog;
import com.mixpanel.android.util.RemoteService;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class DecideChecker {
   private static final JSONArray f = new JSONArray();
   private final MPConfig a;
   private final Context b;
   private final Map<String, DecideMessages> c;
   private final ImageStore d;
   private final SystemInformation e;

   public DecideChecker(Context var1, MPConfig var2) {
      this.b = var1;
      this.a = var2;
      this.c = new HashMap<>();
      this.d = this.a(var1);
      this.e = SystemInformation.a(var1);
   }

   @SuppressLint("NewApi")
   private static int a(Display var0) {
      int var1;
      if (VERSION.SDK_INT < 13) {
         var1 = var0.getWidth();
      } else {
         Point var2 = new Point();
         var0.getSize(var2);
         var1 = var2.x;
      }

      return var1;
   }

   private Bitmap a(InAppNotification var1, Context var2) throws RemoteService.ServiceUnavailableException {
      int var3 = 0;
      String var6 = var1.j();
      String var5 = var1.i();
      int var4 = a(((WindowManager)var2.getSystemService("window")).getDefaultDisplay());
      String[] var8;
      if (var1.d() == InAppNotification.Type.TAKEOVER && var4 >= 720) {
         String[] var10 = new String[]{var1.k(), var1.j(), var1.i()};
         var8 = var10;
      } else {
         var8 = new String[]{var6, var5};
      }

      var4 = var8.length;

      while (true) {
         if (var3 < var4) {
            var5 = var8[var3];

            try {
               var11 = this.d.b(var5);
            } catch (ImageStore.CantGetImageException var7) {
               MPLog.a("MixpanelAPI.DChecker", "Can't load image " + var5 + " for a notification", var7);
               var3++;
               continue;
            }

            var9 = var11;
            break;
         }

         var9 = null;
         break;
      }

      return var9;
   }

   static DecideChecker.Result a(String var0) throws DecideChecker.UnintelligibleMessageException {
      DecideChecker.Result var4 = new DecideChecker.Result();

      JSONObject var3;
      try {
         var3 = new JSONObject(var0);
      } catch (JSONException var13) {
         throw new DecideChecker.UnintelligibleMessageException("Mixpanel endpoint returned unparsable result:\n" + var0, var13);
      }

      label71: {
         if (var3.has("notifications")) {
            try {
               var15 = var3.getJSONArray("notifications");
               break label71;
            } catch (JSONException var14) {
               MPLog.e("MixpanelAPI.DChecker", "Mixpanel endpoint returned non-array JSON for notifications: " + var3);
            }
         }

         var15 = null;
      }

      if (var15 != null) {
         int var2 = Math.min(var15.length(), 2);

         for (int var1 = 0; var1 < var2; var1++) {
            try {
               JSONObject var5 = var15.getJSONObject(var1);
               String var6 = var5.getString("type");
               if (var6.equalsIgnoreCase("takeover")) {
                  TakeoverInAppNotification var16 = new TakeoverInAppNotification(var5);
                  var4.a.add(var16);
               } else if (var6.equalsIgnoreCase("mini")) {
                  MiniInAppNotification var17 = new MiniInAppNotification(var5);
                  var4.a.add(var17);
               }
            } catch (JSONException var10) {
               MPLog.e("MixpanelAPI.DChecker", "Received a strange response from notifications service: " + var15.toString(), var10);
            } catch (BadDecideObjectException var11) {
               MPLog.e("MixpanelAPI.DChecker", "Received a strange response from notifications service: " + var15.toString(), var11);
            } catch (OutOfMemoryError var12) {
               MPLog.e("MixpanelAPI.DChecker", "Not enough memory to show load notification from package: " + var15.toString(), var12);
            }
         }
      }

      if (var3.has("event_bindings")) {
         try {
            var4.b = var3.getJSONArray("event_bindings");
         } catch (JSONException var9) {
            MPLog.e("MixpanelAPI.DChecker", "Mixpanel endpoint returned non-array JSON for event bindings: " + var3);
         }
      }

      if (var3.has("variants")) {
         try {
            var4.c = var3.getJSONArray("variants");
         } catch (JSONException var8) {
            MPLog.e("MixpanelAPI.DChecker", "Mixpanel endpoint returned non-array JSON for variants: " + var3);
         }
      }

      if (var3.has("automatic_events")) {
         try {
            var4.d = var3.getBoolean("automatic_events");
         } catch (JSONException var7) {
            MPLog.e("MixpanelAPI.DChecker", "Mixpanel endpoint returned a non boolean value for automatic events: " + var3);
         }
      }

      return var4;
   }

   private DecideChecker.Result a(String var1, String var2, RemoteService var3) throws RemoteService.ServiceUnavailableException, DecideChecker.UnintelligibleMessageException {
      var2 = this.b(var1, var2, var3);
      MPLog.a("MixpanelAPI.DChecker", "Mixpanel decide server response was:\n" + var2);
      DecideChecker.Result var5 = null;
      if (var2 != null) {
         var5 = a(var2);
         Iterator var7 = var5.a.iterator();

         while (var7.hasNext()) {
            InAppNotification var8 = (InAppNotification)var7.next();
            Bitmap var4 = this.a(var8, this.b);
            if (var4 == null) {
               MPLog.c("MixpanelAPI.DChecker", "Could not retrieve image for notification " + var8.b() + ", will not show the notification.");
               var7.remove();
            } else {
               var8.a(var4);
            }
         }
      }

      return var5;
   }

   private static byte[] a(RemoteService var0, Context var1, String var2) throws RemoteService.ServiceUnavailableException {
      Object var3 = null;
      MPConfig var4 = MPConfig.a(var1);
      byte[] var9;
      if (!var0.a(var1, var4.z())) {
         var9 = (byte[])var3;
      } else {
         try {
            var9 = var0.a(var2, null, var4.y());
         } catch (MalformedURLException var5) {
            MPLog.e("MixpanelAPI.DChecker", "Cannot interpret " + var2 + " as a URL.", var5);
            var9 = (byte[])var3;
         } catch (FileNotFoundException var6) {
            MPLog.a("MixpanelAPI.DChecker", "Cannot get " + var2 + ", file not found.", var6);
            var9 = (byte[])var3;
         } catch (IOException var7) {
            MPLog.a("MixpanelAPI.DChecker", "Cannot get " + var2 + ".", var7);
            var9 = (byte[])var3;
         } catch (OutOfMemoryError var8) {
            MPLog.e("MixpanelAPI.DChecker", "Out of memory when getting to " + var2 + ".", var8);
            var9 = (byte[])var3;
         }
      }

      return var9;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private String b(String var1, String var2, RemoteService var3) throws RemoteService.ServiceUnavailableException {
      Object var4 = null;

      String var5;
      try {
         var5 = URLEncoder.encode(var1, "utf-8");
      } catch (UnsupportedEncodingException var9) {
         throw new RuntimeException("Mixpanel library requires utf-8 string encoding to be available", var9);
      }

      if (var2 != null) {
         try {
            var1 = URLEncoder.encode(var2, "utf-8");
         } catch (UnsupportedEncodingException var8) {
            throw new RuntimeException("Mixpanel library requires utf-8 string encoding to be available", var8);
         }
      } else {
         var1 = null;
      }

      StringBuilder var16 = new StringBuilder().append("?version=1&lib=android&token=").append(var5);
      if (var1 != null) {
         var16.append("&distinct_id=").append(var1);
      }

      var16.append("&properties=");
      JSONObject var11 = new JSONObject();

      try {
         var11.putOpt("$android_lib_version", "5.2.1");
         var11.putOpt("$android_app_version", this.e.a());
         var11.putOpt("$android_version", VERSION.RELEASE);
         var11.putOpt("$android_app_release", this.e.b());
         var11.putOpt("$android_device_model", Build.MODEL);
         var16.append(URLEncoder.encode(var11.toString(), "utf-8"));
      } catch (Exception var7) {
         MPLog.e("MixpanelAPI.DChecker", "Exception constructing properties JSON", var7.getCause());
      }

      var1 = var16.toString();
      var1 = this.a.m() + var1;
      MPLog.a("MixpanelAPI.DChecker", "Querying decide server, url: " + var1);
      byte[] var14 = a(var3, this.b, var1);
      if (var14 == null) {
         var1 = (String)var4;
      } else {
         try {
            var1 = new String(var14, "UTF-8");
         } catch (UnsupportedEncodingException var6) {
            throw new RuntimeException("UTF not supported on this platform?", var6);
         }
      }

      return var1;
   }

   protected ImageStore a(Context var1) {
      return new ImageStore(var1, "DecideChecker");
   }

   public void a(DecideMessages var1) {
      this.c.put(var1.a(), var1);
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public void a(String var1, RemoteService var2) throws RemoteService.ServiceUnavailableException {
      DecideMessages var6 = this.c.get(var1);
      if (var6 != null) {
         String var3 = var6.b();

         try {
            var7 = this.a(var6.a(), var3, var2);
         } catch (DecideChecker.UnintelligibleMessageException var5) {
            MPLog.e("MixpanelAPI.DChecker", var5.getMessage(), var5);
            return;
         }

         if (var7 != null) {
            try {
               var6.a(var7.a, var7.b, var7.c, var7.d);
            } catch (DecideChecker.UnintelligibleMessageException var4) {
               MPLog.e("MixpanelAPI.DChecker", var4.getMessage(), var4);
            }
         }
      }
   }

   public DecideMessages b(String var1) {
      return this.c.get(var1);
   }

   static class Result {
      public final List<InAppNotification> a = new ArrayList<>();
      public JSONArray b = DecideChecker.f;
      public JSONArray c = DecideChecker.f;
      public boolean d = false;

      public Result() {
      }
   }

   static class UnintelligibleMessageException extends Exception {
      public UnintelligibleMessageException(String var1, JSONException var2) {
         super(var1, var2);
      }
   }
}
