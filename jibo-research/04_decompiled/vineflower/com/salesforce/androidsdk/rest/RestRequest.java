package com.salesforce.androidsdk.rest;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.TimeZone;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONException;
import org.json.JSONObject;

public class RestRequest {
   public static final MediaType a = MediaType.a("application/json; charset=utf-8");
   public static final String b = StandardCharsets.UTF_8.name();
   public static final DateFormat c = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z");
   private final RestRequest.RestMethod d;
   private final String e;
   private final RequestBody f;
   private final Map<String, String> g;
   private final JSONObject h;

   static {
      c.setTimeZone(TimeZone.getTimeZone("GMT"));
   }

   public RestRequest(RestRequest.RestMethod var1, String var2) {
      this(var1, var2, (RequestBody)null, null);
   }

   public RestRequest(RestRequest.RestMethod var1, String var2, RequestBody var3, Map<String, String> var4) {
      this.d = var1;
      this.e = var2;
      this.f = var3;
      this.g = var4;
      this.h = null;
   }

   public RestRequest(RestRequest.RestMethod var1, String var2, JSONObject var3) {
      this(var1, var2, var3, null);
   }

   public RestRequest(RestRequest.RestMethod var1, String var2, JSONObject var3, Map<String, String> var4) {
      this.d = var1;
      this.e = var2;
      RequestBody var5;
      if (var3 == null) {
         var5 = null;
      } else {
         var5 = RequestBody.a(a, var3.toString());
      }

      this.f = var5;
      this.g = var4;
      this.h = var3;
   }

   public static RestRequest a(String var0, String var1, String var2) {
      return new RestRequest(RestRequest.RestMethod.DELETE, RestRequest.RestAction.DELETE.getPath(var0, var1, var2));
   }

   public static RestRequest a(String var0, String var1, Map<String, Object> var2) throws IOException {
      RestRequest.RestMethod var3 = RestRequest.RestMethod.POST;
      var1 = RestRequest.RestAction.CREATE.getPath(var0, var1);
      JSONObject var4;
      if (var2 == null) {
         var4 = null;
      } else {
         var4 = new JSONObject(var2);
      }

      return new RestRequest(var3, var1, var4);
   }

   public RestRequest.RestMethod a() {
      return this.d;
   }

   public String b() {
      return this.e;
   }

   public RequestBody c() {
      return this.f;
   }

   public JSONObject d() {
      return this.h;
   }

   public Map<String, String> e() {
      return this.g;
   }

   protected JSONObject f() throws JSONException {
      JSONObject var1 = new JSONObject();
      var1.put("method", this.a().toString());
      var1.put("url", this.b());
      var1.put("body", this.d());
      if (this.e() != null) {
         var1.put("httpHeaders", new JSONObject(this.e()));
      }

      return var1;
   }

   @Override
   public String toString() {
      String var1;
      try {
         var1 = this.f().toString(2);
      } catch (JSONException var2) {
         var1 = super.toString();
      }

      return var1;
   }

   private enum RestAction {
      BATCH("/services/data/%s/composite/batch"),
      COMPOSITE("/services/data/%s/composite"),
      CREATE("/services/data/%s/sobjects/%s"),
      DELETE("/services/data/%s/sobjects/%s/%s"),
      DESCRIBE("/services/data/%s/sobjects/%s/describe/"),
      DESCRIBE_GLOBAL("/services/data/%s/sobjects/"),
      METADATA("/services/data/%s/sobjects/%s/"),
      QUERY("/services/data/%s/query"),
      RESOURCES("/services/data/%s/"),
      RETRIEVE("/services/data/%s/sobjects/%s/%s"),
      SEARCH("/services/data/%s/search"),
      SEARCH_RESULT_LAYOUT("/services/data/%s/search/layout"),
      SEARCH_SCOPE_AND_ORDER("/services/data/%s/search/scopeOrder"),
      SOBJECT_TREE("/services/data/%s/composite/tree/%s"),
      UPDATE("/services/data/%s/sobjects/%s/%s"),
      UPSERT("/services/data/%s/sobjects/%s/%s/%s"),
      VERSIONS("/services/data/");

      private static final RestRequest.RestAction[] $VALUES = new RestRequest.RestAction[]{
         RestRequest.RestAction.VERSIONS,
         RestRequest.RestAction.RESOURCES,
         RestRequest.RestAction.DESCRIBE_GLOBAL,
         RestRequest.RestAction.METADATA,
         RestRequest.RestAction.DESCRIBE,
         RestRequest.RestAction.CREATE,
         RestRequest.RestAction.RETRIEVE,
         RestRequest.RestAction.UPSERT,
         RestRequest.RestAction.UPDATE,
         RestRequest.RestAction.DELETE,
         RestRequest.RestAction.QUERY,
         RestRequest.RestAction.SEARCH,
         RestRequest.RestAction.SEARCH_SCOPE_AND_ORDER,
         RestRequest.RestAction.SEARCH_RESULT_LAYOUT,
         RestRequest.RestAction.COMPOSITE,
         RestRequest.RestAction.BATCH,
         RestRequest.RestAction.SOBJECT_TREE
      };
      private final String pathTemplate;

      RestAction(String var3) {
         this.pathTemplate = var3;
      }

      public String getPath(Object... var1) {
         return String.format(this.pathTemplate, var1);
      }
   }

   public enum RestMethod {
      DELETE,
      GET,
      HEAD,
      PATCH,
      POST,
      PUT;

      private static final RestRequest.RestMethod[] $VALUES = new RestRequest.RestMethod[]{
         RestRequest.RestMethod.GET,
         RestRequest.RestMethod.POST,
         RestRequest.RestMethod.PUT,
         RestRequest.RestMethod.DELETE,
         RestRequest.RestMethod.HEAD,
         RestRequest.RestMethod.PATCH
      };
   }
}
