package com.salesforce.androidsdk.analytics;

import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.rest.ApiVersionStrings;
import com.salesforce.androidsdk.rest.ClientManager;
import com.salesforce.androidsdk.rest.RestRequest;
import com.salesforce.androidsdk.util.SalesforceSDKLogger;
import java.io.IOException;
import java.util.HashMap;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AILTNPublisher implements AnalyticsPublisher {
   private RequestBody a(RequestBody var1) throws IOException {
      Buffer var2 = new Buffer();
      var1.a(var2);
      return new RequestBody(this, var1, var2) {
         final RequestBody a;
         final Buffer b;
         final AILTNPublisher c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         @Override
         public MediaType a() {
            return this.a.a();
         }

         @Override
         public void a(BufferedSink var1) throws IOException {
            var1.b(this.b.w());
         }

         @Override
         public long b() {
            return this.b.b();
         }
      };
   }

   private RequestBody b(RequestBody var1) {
      return new RequestBody(this, var1) {
         final RequestBody a;
         final AILTNPublisher b;

         {
            this.b = var1;
            this.a = var2;
         }

         @Override
         public MediaType a() {
            return this.a.a();
         }

         @Override
         public void a(BufferedSink var1) throws IOException {
            var1 = Okio.a(new GzipSink(var1));
            this.a.a(var1);
            var1.close();
         }

         @Override
         public long b() {
            return -1L;
         }
      };
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @Override
   public boolean a(JSONArray var1) {
      boolean var3 = false;
      if (var1 != null && var1.length() != 0) {
         JSONArray var6 = new JSONArray();
         int var2 = 0;

         while (true) {
            JSONObject var5;
            try {
               if (var2 >= var1.length()) {
                  break;
               }

               var5 = var1.optJSONObject(var2);
            } catch (JSONException var9) {
               SalesforceSDKLogger.a("AILTNPublisher", "Exception thrown while constructing event payload", var9);
               return var3;
            }

            if (var5 != null) {
               try {
                  JSONObject var4 = new JSONObject();
                  var4.put("code", "ailtn");
                  JSONObject var7 = new JSONObject();
                  var7.put("schemaType", var5.optString("schemaType"));
                  var5.remove("schemaType");
                  var7.put("payload", var5.toString());
                  var4.put("data", var7);
                  var6.put(var4);
               } catch (JSONException var8) {
                  SalesforceSDKLogger.a("AILTNPublisher", "Exception thrown while constructing event payload", var8);
                  return var3;
               }
            }

            var2++;
         }

         var3 = this.b(var6);
      } else {
         var3 = true;
      }

      return var3;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public boolean b(JSONArray var1) {
      boolean var3 = false;
      JSONObject var5 = new JSONObject();

      try {
         var5.put("logLines", var1);
      } catch (JSONException var12) {
         SalesforceSDKLogger.a("AILTNPublisher", "Exception thrown while constructing event payload", var12);
         return var3;
      }

      label42: {
         String var4;
         OkHttpClient var6;
         try {
            var4 = String.format("/services/data/%s/connect/proxy/app-analytics-logging", ApiVersionStrings.a(SalesforceSDKManager.a().k()));
            var14 = SalesforceSDKManager.a().E().b();
            var6 = var14.d();
         } catch (ClientManager.AccountInfoNotFoundException var10) {
            SalesforceSDKLogger.a("AILTNPublisher", "Exception thrown while constructing rest client", var10);
            var13 = null;
            break label42;
         } catch (IOException var11) {
            SalesforceSDKLogger.a("AILTNPublisher", "Exception thrown while making network request", var11);
            var13 = null;
            break label42;
         }

         if (var6 == null) {
            boolean var17 = var3;
            return var17;
         }

         try {
            RequestBody var15 = this.a(this.b(RequestBody.a(RestRequest.a, var5.toString())));
            HashMap var16 = new HashMap();
            var16.put("Content-Encoding", "gzip");
            var16.put("Content-Length", Long.toString(var15.b()));
            RestRequest var7 = new RestRequest(RestRequest.RestMethod.POST, var4, var15, var16);
            var13 = var14.b(var7);
         } catch (ClientManager.AccountInfoNotFoundException var8) {
            SalesforceSDKLogger.a("AILTNPublisher", "Exception thrown while constructing rest client", var8);
            var13 = null;
         } catch (IOException var9) {
            SalesforceSDKLogger.a("AILTNPublisher", "Exception thrown while making network request", var9);
            var13 = null;
         }
      }

      boolean var2 = var3;
      if (var13 != null) {
         var2 = var3;
         if (var13.b()) {
            var2 = true;
         }
      }

      return var2;
   }
}
