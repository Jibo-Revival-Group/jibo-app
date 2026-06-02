package com.amazonaws.http;

import com.amazonaws.AmazonClientException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.util.HttpUtils;
import com.amazonaws.util.StringUtils;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HttpRequestFactory {
   private void configureHeaders(Map<String, String> var1, Request<?> var2, ExecutionContext var3, ClientConfiguration var4) {
      URI var7 = var2.getEndpoint();
      String var6 = var7.getHost();
      String var5 = var6;
      if (HttpUtils.isUsingNonDefaultPort(var7)) {
         var5 = var6 + ":" + var7.getPort();
      }

      var1.put("Host", var5);

      for (Entry var8 : var2.getHeaders().entrySet()) {
         var1.put(var8.getKey(), var8.getValue());
      }

      if (var1.get("Content-Type") == null || ((String)var1.get("Content-Type")).isEmpty()) {
         var1.put("Content-Type", "application/x-www-form-urlencoded; charset=" + "UTF-8".toLowerCase());
      }

      if (var3 != null && var3.getContextUserAgent() != null) {
         var1.put("User-Agent", this.createUserAgentString(var4, var3.getContextUserAgent()));
      }
   }

   private String createUserAgentString(ClientConfiguration var1, String var2) {
      String var3;
      if (var1.getUserAgent().contains(var2)) {
         var3 = var1.getUserAgent();
      } else {
         var3 = var1.getUserAgent() + " " + var2;
      }

      return var3;
   }

   public HttpRequest createHttpRequest(Request<?> var1, ClientConfiguration var2, ExecutionContext var3) {
      boolean var6 = false;
      String var7 = HttpUtils.appendUri(var1.getEndpoint().toString(), var1.getResourcePath(), true);
      String var10 = HttpUtils.encodeParameters(var1);
      boolean var4;
      if (var1.getContent() != null) {
         var4 = true;
      } else {
         var4 = false;
      }

      boolean var5;
      if (var1.getHttpMethod() == HttpMethodName.POST) {
         var5 = true;
      } else {
         var5 = false;
      }

      label56: {
         if (var5) {
            var5 = var6;
            if (!var4) {
               break label56;
            }
         }

         var5 = true;
      }

      if (var10 != null && var5) {
         var7 = var7 + "?" + var10;
      }

      InputStream var8 = var1.getContent();
      String var9 = var1.getHttpMethod().toString();
      if (var9.equals("POST") && var1.getContent() == null && var10 != null) {
         var8 = new ByteArrayInputStream(var10.getBytes(StringUtils.UTF8));
         var1.addHeader("Content-Length", String.valueOf(var10.length()));
      }

      if (var9.equals("POST") || var9.equals("PUT")) {
         var10 = var1.getHeaders().get("Content-Length");
         if (var10 == null || var10.isEmpty()) {
            if (var8 != null) {
               throw new AmazonClientException("Unknown content-length");
            }

            var1.addHeader("Content-Length", "0");
         }
      }

      if (var1.getHeaders().get("Accept-Encoding") == null) {
         var1.addHeader("Accept-Encoding", "gzip");
      }

      HashMap var13 = new HashMap();
      this.configureHeaders(var13, var1, var3, var2);
      return new HttpRequest(var9, URI.create(var7), var13, var8);
   }
}
