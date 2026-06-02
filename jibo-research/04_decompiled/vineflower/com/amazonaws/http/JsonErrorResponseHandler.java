package com.amazonaws.http;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.amazonaws.util.json.JsonUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class JsonErrorResponseHandler implements HttpResponseHandler<AmazonServiceException> {
   private final List<? extends JsonErrorUnmarshaller> unmarshallerList;

   public JsonErrorResponseHandler(List<? extends JsonErrorUnmarshaller> var1) {
      this.unmarshallerList = var1;
   }

   private AmazonServiceException runErrorUnmarshallers(JsonErrorResponseHandler.JsonErrorResponse var1) {
      Iterator var3 = this.unmarshallerList.iterator();

      while (true) {
         if (var3.hasNext()) {
            JsonErrorUnmarshaller var2 = (JsonErrorUnmarshaller)var3.next();
            if (!var2.match(var1)) {
               continue;
            }

            var4 = var2.unmarshall(var1);
            break;
         }

         var4 = null;
         break;
      }

      return var4;
   }

   public AmazonServiceException handle(HttpResponse var1) {
      JsonErrorResponseHandler.JsonErrorResponse var3;
      try {
         var3 = JsonErrorResponseHandler.JsonErrorResponse.fromResponse(var1);
      } catch (IOException var4) {
         throw new AmazonClientException("Unable to parse error response", var4);
      }

      AmazonServiceException var2 = this.runErrorUnmarshallers(var3);
      AmazonServiceException var5;
      if (var2 == null) {
         var5 = null;
      } else {
         var2.setStatusCode(var1.getStatusCode());
         if (var1.getStatusCode() < 500) {
            var2.setErrorType(AmazonServiceException.ErrorType.Client);
         } else {
            var2.setErrorType(AmazonServiceException.ErrorType.Service);
         }

         var2.setErrorCode(var3.getErrorCode());

         for (Entry var7 : var1.getHeaders().entrySet()) {
            if (((String)var7.getKey()).equalsIgnoreCase("X-Amzn-RequestId")) {
               var2.setRequestId((String)var7.getValue());
            }
         }

         var5 = var2;
      }

      return var5;
   }

   @Override
   public boolean needsConnectionLeftOpen() {
      return false;
   }

   public static class JsonErrorResponse {
      private final String errorCode;
      private final Map<String, String> map;
      private final String message;
      private final int statusCode;

      private JsonErrorResponse(int var1, String var2, Map<String, String> var3) {
         this.statusCode = var1;
         this.errorCode = var2;
         this.map = var3;
         this.message = this.get("message");
      }

      public static JsonErrorResponseHandler.JsonErrorResponse fromResponse(HttpResponse var0) {
         int var1 = var0.getStatusCode();

         Map var2;
         try {
            InputStreamReader var6 = new InputStreamReader(var0.getContent());
            BufferedReader var3 = new BufferedReader(var6);
            var2 = JsonUtils.jsonToMap(var3);
         } catch (Exception var4) {
            var2 = new HashMap();
         }

         String var5 = var0.getStatusText();
         if (var2.containsKey("code")) {
            var5 = (String)var2.get("code");
         } else if (var2.containsKey("error")) {
            var5 = (String)var2.get("error");
         }

         return new JsonErrorResponseHandler.JsonErrorResponse(var1, var5, var2);
      }

      public String get(String var1) {
         if (var1 != null && var1.length() != 0) {
            String var2 = var1.substring(0, 1).toLowerCase() + var1.substring(1);
            String var3 = var1.substring(0, 1).toUpperCase() + var1.substring(1);
            var1 = "";
            if (this.map.containsKey(var3)) {
               var1 = this.map.get(var3);
            } else if (this.map.containsKey(var2)) {
               var1 = this.map.get(var2);
            }
         } else {
            var1 = null;
         }

         return var1;
      }

      public String getErrorCode() {
         return this.errorCode;
      }

      public String getMessage() {
         return this.message;
      }

      public int getStatusCode() {
         return this.statusCode;
      }
   }
}
