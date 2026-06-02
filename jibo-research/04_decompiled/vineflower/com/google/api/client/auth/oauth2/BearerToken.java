package com.google.api.client.auth.oauth2;

import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.UrlEncodedContent;
import com.google.api.client.util.Data;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class BearerToken {
   static final Pattern INVALID_TOKEN_ERROR = Pattern.compile("\\s*error\\s*=\\s*\"?invalid_token\"?");
   static final String PARAM_NAME = "access_token";

   public static Credential.AccessMethod authorizationHeaderAccessMethod() {
      return new BearerToken.AuthorizationHeaderAccessMethod();
   }

   public static Credential.AccessMethod formEncodedBodyAccessMethod() {
      return new BearerToken.FormEncodedBodyAccessMethod();
   }

   public static Credential.AccessMethod queryParameterAccessMethod() {
      return new BearerToken.QueryParameterAccessMethod();
   }

   static final class AuthorizationHeaderAccessMethod implements Credential.AccessMethod {
      static final String HEADER_PREFIX = "Bearer ";

      @Override
      public String getAccessTokenFromRequest(HttpRequest var1) {
         List var3 = var1.getHeaders().getAuthorizationAsList();
         if (var3 != null) {
            for (String var4 : var3) {
               if (var4.startsWith("Bearer ")) {
                  return var4.substring("Bearer ".length());
               }
            }
         }

         return null;
      }

      @Override
      public void intercept(HttpRequest var1, String var2) throws IOException {
         HttpHeaders var3 = var1.getHeaders();
         String var4 = String.valueOf("Bearer ");
         var2 = String.valueOf(var2);
         String var5;
         if (var2.length() != 0) {
            var5 = var4.concat(var2);
         } else {
            var5 = new String(var4);
         }

         var3.setAuthorization(var5);
      }
   }

   static final class FormEncodedBodyAccessMethod implements Credential.AccessMethod {
      private static Map<String, Object> getData(HttpRequest var0) {
         return Data.mapOf(UrlEncodedContent.getContent(var0).getData());
      }

      @Override
      public String getAccessTokenFromRequest(HttpRequest var1) {
         String var2 = (String)getData(var1).get("access_token");
         if (var2 == null) {
            var2 = null;
         } else {
            var2 = var2.toString();
         }

         return var2;
      }

      @Override
      public void intercept(HttpRequest var1, String var2) throws IOException {
         boolean var3;
         if (!"GET".equals(var1.getRequestMethod())) {
            var3 = true;
         } else {
            var3 = false;
         }

         Preconditions.checkArgument(var3, "HTTP GET method is not supported");
         getData(var1).put("access_token", var2);
      }
   }

   static final class QueryParameterAccessMethod implements Credential.AccessMethod {
      @Override
      public String getAccessTokenFromRequest(HttpRequest var1) {
         String var2 = (String)var1.getUrl().get("access_token");
         if (var2 == null) {
            var2 = null;
         } else {
            var2 = var2.toString();
         }

         return var2;
      }

      @Override
      public void intercept(HttpRequest var1, String var2) throws IOException {
         var1.getUrl().set("access_token", var2);
      }
   }
}
