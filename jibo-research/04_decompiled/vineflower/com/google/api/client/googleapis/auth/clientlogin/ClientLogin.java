package com.google.api.client.googleapis.auth.clientlogin;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.UrlEncodedContent;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Key;
import com.google.api.client.util.StringUtils;
import com.google.api.client.util.Strings;
import java.io.IOException;

@Beta
public final class ClientLogin {
   @Key
   public String accountType;
   @Key("source")
   public String applicationName;
   @Key("service")
   public String authTokenType;
   @Key("logincaptcha")
   public String captchaAnswer;
   @Key("logintoken")
   public String captchaToken;
   @Key("Passwd")
   public String password;
   public GenericUrl serverUrl = new GenericUrl("https://www.google.com");
   public HttpTransport transport;
   @Key("Email")
   public String username;

   public static String getAuthorizationHeaderValue(String var0) {
      var0 = String.valueOf(var0);
      if (var0.length() != 0) {
         var0 = "GoogleLogin auth=".concat(var0);
      } else {
         var0 = new String("GoogleLogin auth=");
      }

      return var0;
   }

   public ClientLogin.Response authenticate() throws IOException {
      GenericUrl var1 = this.serverUrl.clone();
      var1.appendRawPath("/accounts/ClientLogin");
      HttpRequest var5 = this.transport.createRequestFactory().buildPostRequest(var1, new UrlEncodedContent(this));
      var5.setParser(AuthKeyValueParser.INSTANCE);
      var5.setContentLoggingLimit(0);
      var5.setThrowExceptionOnExecuteError(false);
      HttpResponse var4 = var5.execute();
      if (var4.isSuccessStatusCode()) {
         return var4.parseAs(ClientLogin.Response.class);
      }

      HttpResponseException.Builder var6 = new HttpResponseException.Builder(var4.getStatusCode(), var4.getStatusMessage(), var4.getHeaders());
      ClientLogin.ErrorInfo var3 = var4.parseAs(ClientLogin.ErrorInfo.class);
      String var2 = var3.toString();
      StringBuilder var7 = HttpResponseException.computeMessageBuffer(var4);
      if (!Strings.isNullOrEmpty(var2)) {
         var7.append(StringUtils.LINE_SEPARATOR).append(var2);
         var6.setContent(var2);
      }

      var6.setMessage(var7.toString());
      throw new ClientLoginResponseException(var6, var3);
   }

   public static final class ErrorInfo {
      @Key("CaptchaToken")
      public String captchaToken;
      @Key("CaptchaUrl")
      public String captchaUrl;
      @Key("Error")
      public String error;
      @Key("Url")
      public String url;
   }

   public static final class Response implements HttpExecuteInterceptor, HttpRequestInitializer {
      @Key("Auth")
      public String auth;

      public String getAuthorizationHeaderValue() {
         return ClientLogin.getAuthorizationHeaderValue(this.auth);
      }

      @Override
      public void initialize(HttpRequest var1) {
         var1.setInterceptor(this);
      }

      @Override
      public void intercept(HttpRequest var1) {
         var1.getHeaders().setAuthorization(this.getAuthorizationHeaderValue());
      }
   }
}
