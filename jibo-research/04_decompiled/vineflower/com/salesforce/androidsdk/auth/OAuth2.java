package com.salesforce.androidsdk.auth;

import android.net.Uri;
import android.text.TextUtils;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.rest.RestResponse;
import com.salesforce.androidsdk.util.SalesforceSDKLogger;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.Map.Entry;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

public class OAuth2 {
   public static final OAuth2.IdServiceResponse a(HttpAccess var0, String var1, String var2) throws IOException, URISyntaxException {
      Request.Builder var3 = new Request.Builder().a(var1).a();
      a(var3, var2);
      Request var4 = var3.c();
      return new OAuth2.IdServiceResponse(FirebasePerfOkHttpClient.execute(var0.b().a(var4)));
   }

   public static OAuth2.TokenEndpointResponse a(HttpAccess var0, URI var1, String var2, String var3, String var4, Map<String, String> var5) throws OAuth2.OAuthFailedException, IOException {
      FormBody.Builder var6 = a("refresh_token", var2, var4, var5);
      var6.a("refresh_token", var3);
      var6.a("format", "json");
      return a(var0, var1, var6);
   }

   private static OAuth2.TokenEndpointResponse a(HttpAccess var0, URI var1, FormBody.Builder var2) throws OAuth2.OAuthFailedException, IOException {
      String var4 = var1.toString() + "/services/oauth2/token";
      FormBody var6 = var2.a();
      Request var5 = new Request.Builder().a(var4).a(var6).c();
      Response var3 = FirebasePerfOkHttpClient.execute(var0.b().a(var5));
      if (var3.d()) {
         return new OAuth2.TokenEndpointResponse(var3);
      } else {
         throw new OAuth2.OAuthFailedException(new OAuth2.TokenErrorResponse(var3), var3.c());
      }
   }

   private static String a() {
      String var1 = SalesforceSDKManager.a().r();
      if (var1 != null && !var1.trim().isEmpty()) {
         String var0 = var1;
         if (!var1.startsWith("/")) {
            var0 = "/" + var1;
         }

         var1 = var0;
         if (var0.endsWith("/")) {
            var1 = var0.substring(0, var0.length() - 1);
         }
      } else {
         var1 = "";
      }

      return var1;
   }

   private static String a(String[] var0) {
      String[] var1 = var0;
      if (var0 == null) {
         var1 = new String[0];
      }

      TreeSet var2 = new TreeSet<>(Arrays.asList(var1));
      var2.add("refresh_token");
      return TextUtils.join(" ", var2.toArray(new String[0]));
   }

   public static URI a(URI var0, String var1, String var2, String[] var3, String var4, String var5) {
      return a(var0, var1, var2, var3, var4, var5, null);
   }

   public static URI a(URI var0, String var1, String var2, String[] var3, String var4, String var5, String var6, String var7, Map<String, String> var8) {
      if (var6 != null && var7 != null) {
         StringBuilder var13 = new StringBuilder(var7);
         var13.append("/secur/frontdoor.jsp?");
         var13.append("sid").append("=").append(var6);
         var13.append("&").append("retURL").append("=").append(Uri.encode(a(var0, var1, var2, var3, var4, var5).toString()));
         if (var8 != null && var8.size() > 0) {
            for (Entry var11 : var8.entrySet()) {
               String var10;
               if (var11.getValue() == null) {
                  var10 = "";
               } else {
                  var10 = (String)var11.getValue();
               }

               var13.append("&").append((String)var11.getKey()).append("=").append(Uri.encode(var10));
            }
         }

         var0 = URI.create(var13.toString());
      } else {
         var0 = a(var0, var1, var2, var3, var4, var5, var8);
      }

      return var0;
   }

   public static URI a(URI var0, String var1, String var2, String[] var3, String var4, String var5, Map<String, String> var6) {
      StringBuilder var7 = new StringBuilder(var0.toString());
      var7.append("/services/oauth2/authorize").append(a());
      StringBuilder var8 = var7.append("?display=");
      String var9 = var5;
      if (var5 == null) {
         var9 = "touch";
      }

      var8.append(var9);
      StringBuilder var14 = var7.append("&").append("response_type").append("=");
      String var10;
      if (var4 == null) {
         var10 = "token";
      } else {
         var10 = "activated_client_code";
      }

      var14.append(var10);
      var7.append("&").append("client_id").append("=").append(Uri.encode(var1));
      if (var3 != null && var3.length > 0) {
         var7.append("&").append("scope").append("=").append(Uri.encode(a(var3)));
      }

      var7.append("&").append("redirect_uri").append("=").append(var2);
      if (var6 != null && var6.size() > 0) {
         for (Entry var13 : var6.entrySet()) {
            String var11;
            if (var13.getValue() == null) {
               var11 = "";
            } else {
               var11 = (String)var13.getValue();
            }

            var7.append("&").append((String)var13.getKey()).append("=").append(Uri.encode(var11));
         }
      }

      return URI.create(var7.toString());
   }

   private static FormBody.Builder a(String var0, String var1, String var2, Map<String, String> var3) {
      FormBody.Builder var4 = new FormBody.Builder().a("grant_type", var0).a("client_id", var1);
      if (var2 != null) {
         var4.a("client_secret", var2);
      }

      if (var3 != null) {
         for (Entry var6 : var3.entrySet()) {
            var4.a((String)var6.getKey(), (String)var6.getValue());
         }
      }

      return var4;
   }

   public static final Request.Builder a(Request.Builder var0, String var1) {
      return var0.a("Authorization", "Bearer " + var1);
   }

   public static void a(HttpAccess var0, URI var1, String var2) {
      StringBuilder var4 = new StringBuilder(var1.toString());
      var4.append("/services/oauth2/revoke?token=");
      var4.append(Uri.encode(var2));
      Request var5 = new Request.Builder().a(var4.toString()).a().c();

      try {
         FirebasePerfOkHttpClient.execute(var0.b().a(var5));
      } catch (IOException var3) {
         SalesforceSDKLogger.b("OAuth2", "Exception thrown while revoking refresh token", var3);
      }
   }

   public static OAuth2.TokenEndpointResponse b(HttpAccess var0, URI var1, String var2) throws IOException, URISyntaxException, OAuth2.OAuthFailedException {
      return a(var0, var1, new FormBody.Builder().a("grant_type", "urn:ietf:params:oauth:grant-type:jwt-bearer").a("assertion", var2));
   }

   public static class IdServiceResponse {
      public String a;
      public String b;
      public String c;
      public String d;
      public String e;
      public String f;
      public String g;
      public int h = -1;
      public int i = -1;
      public JSONObject j;
      public JSONObject k;

      // $VF: Duplicated exception handlers to handle obfuscated exceptions
      public IdServiceResponse(Response var1) {
         JSONObject var7;
         try {
            RestResponse var2 = new RestResponse(var1);
            var7 = var2.f();
            this.a = var7.getString("username");
            this.b = var7.getString("email");
            this.c = var7.getString("first_name");
            this.d = var7.getString("last_name");
            this.e = var7.getString("display_name");
            var6 = var7.getJSONObject("photos");
         } catch (Exception var5) {
            SalesforceSDKLogger.b("OAuth2", "Could not parse identity response", var5);
            return;
         }

         if (var6 != null) {
            try {
               this.f = var6.getString("picture");
               this.g = var6.getString("thumbnail");
            } catch (Exception var4) {
               SalesforceSDKLogger.b("OAuth2", "Could not parse identity response", var4);
               return;
            }
         }

         try {
            this.j = var7.optJSONObject("custom_attributes");
            this.k = var7.optJSONObject("custom_permissions");
            if (var7.has("mobile_policy")) {
               this.h = var7.getJSONObject("mobile_policy").getInt("pin_length");
               this.i = var7.getJSONObject("mobile_policy").getInt("screen_lock");
            }
         } catch (Exception var3) {
            SalesforceSDKLogger.b("OAuth2", "Could not parse identity response", var3);
         }
      }
   }

   public static class OAuthFailedException extends Exception {
      final OAuth2.TokenErrorResponse a;
      final int b;

      OAuthFailedException(OAuth2.TokenErrorResponse var1, int var2) {
         super(var1.toString());
         this.a = var1;
         this.b = var2;
      }

      public boolean a() {
         boolean var1;
         if (this.b != 401 && this.b != 403 && this.b != 400) {
            var1 = false;
         } else {
            var1 = true;
         }

         return var1;
      }

      public OAuth2.TokenErrorResponse b() {
         return this.a;
      }

      public int c() {
         return this.b;
      }
   }

   public static class TokenEndpointResponse {
      public String a;
      public String b;
      public String c;
      public String d;
      public String e;
      public String f;
      public String g;
      public String h;
      public String i;
      public String j;
      public Map<String, String> k;

      // $VF: Duplicated exception handlers to handle obfuscated exceptions
      public TokenEndpointResponse(Map<String, String> var1) {
         SalesforceSDKManager var2;
         try {
            this.a = (String)var1.get("access_token");
            this.b = (String)var1.get("refresh_token");
            this.c = (String)var1.get("instance_url");
            this.d = (String)var1.get("id");
            this.h = (String)var1.get("code");
            this.a();
            this.i = (String)var1.get("sfdc_community_id");
            this.j = (String)var1.get("sfdc_community_url");
            var2 = SalesforceSDKManager.a();
         } catch (Exception var7) {
            SalesforceSDKLogger.b("OAuth2", "Could not parse token endpoint response", var7);
            return;
         }

         if (var2 != null) {
            List var3;
            try {
               var3 = var2.v();
            } catch (Exception var6) {
               SalesforceSDKLogger.b("OAuth2", "Could not parse token endpoint response", var6);
               return;
            }

            if (var3 != null) {
               try {
                  if (var3.isEmpty()) {
                     return;
                  }

                  HashMap var8 = new HashMap();
                  this.k = var8;
                  var10 = var3.iterator();
               } catch (Exception var4) {
                  SalesforceSDKLogger.b("OAuth2", "Could not parse token endpoint response", var4);
                  return;
               }

               while (true) {
                  try {
                     if (!var10.hasNext()) {
                        break;
                     }

                     String var9 = (String)var10.next();
                     if (!TextUtils.isEmpty(var9)) {
                        this.k.put(var9, (String)var1.get(var9));
                     }
                  } catch (Exception var5) {
                     SalesforceSDKLogger.b("OAuth2", "Could not parse token endpoint response", var5);
                     break;
                  }
               }
            }
         }
      }

      // $VF: Duplicated exception handlers to handle obfuscated exceptions
      public TokenEndpointResponse(Response var1) {
         try {
            RestResponse var2 = new RestResponse(var1);
            var13 = var2.f();
            this.a = var13.getString("access_token");
            this.c = var13.getString("instance_url");
            this.d = var13.getString("id");
            this.a();
            if (var13.has("refresh_token")) {
               this.b = var13.getString("refresh_token");
            }
         } catch (Exception var12) {
            SalesforceSDKLogger.b("OAuth2", "Could not parse token endpoint response", var12);
            return;
         }

         try {
            if (var13.has("sfdc_community_id")) {
               this.i = var13.getString("sfdc_community_id");
            }
         } catch (Exception var11) {
            SalesforceSDKLogger.b("OAuth2", "Could not parse token endpoint response", var11);
            return;
         }

         try {
            if (var13.has("sfdc_community_url")) {
               this.j = var13.getString("sfdc_community_url");
            }
         } catch (Exception var10) {
            SalesforceSDKLogger.b("OAuth2", "Could not parse token endpoint response", var10);
            return;
         }

         SalesforceSDKManager var14;
         try {
            var14 = SalesforceSDKManager.a();
         } catch (Exception var9) {
            SalesforceSDKLogger.b("OAuth2", "Could not parse token endpoint response", var9);
            return;
         }

         if (var14 != null) {
            try {
               var15 = var14.v();
            } catch (Exception var8) {
               SalesforceSDKLogger.b("OAuth2", "Could not parse token endpoint response", var8);
               return;
            }

            if (var15 != null) {
               Iterator var17;
               try {
                  if (var15.isEmpty()) {
                     return;
                  }

                  HashMap var3 = new HashMap();
                  this.k = var3;
                  var17 = var15.iterator();
               } catch (Exception var6) {
                  SalesforceSDKLogger.b("OAuth2", "Could not parse token endpoint response", var6);
                  return;
               }

               while (true) {
                  String var4;
                  try {
                     while (true) {
                        if (!var17.hasNext()) {
                           return;
                        }

                        var16 = (String)var17.next();
                        if (!TextUtils.isEmpty(var16)) {
                           var4 = var13.optString(var16, null);
                           break;
                        }
                     }
                  } catch (Exception var7) {
                     SalesforceSDKLogger.b("OAuth2", "Could not parse token endpoint response", var7);
                     break;
                  }

                  if (var4 != null) {
                     try {
                        this.k.put(var16, var4);
                     } catch (Exception var5) {
                        SalesforceSDKLogger.b("OAuth2", "Could not parse token endpoint response", var5);
                        break;
                     }
                  }
               }
            }
         }
      }

      private void a() throws URISyntaxException {
         this.e = this.d.replace(new URI(this.d).getHost(), new URI(this.c).getHost());
         String[] var1 = this.d.split("/");
         this.g = var1[var1.length - 1];
         this.f = var1[var1.length - 2];
      }
   }

   public static class TokenErrorResponse {
      public String a;
      public String b;

      public TokenErrorResponse(Response var1) {
         try {
            RestResponse var2 = new RestResponse(var1);
            JSONObject var4 = var2.f();
            this.a = var4.getString("error");
            this.b = var4.getString("error_description");
         } catch (Exception var3) {
            SalesforceSDKLogger.b("OAuth2", "Could not parse token error response", var3);
         }
      }

      @Override
      public String toString() {
         return this.a + ":" + this.b;
      }
   }
}
