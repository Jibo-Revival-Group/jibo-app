package com.facebook;

import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class GraphResponse {
   private static final String BODY_KEY = "body";
   private static final String CODE_KEY = "code";
   public static final String NON_JSON_RESPONSE_PROPERTY = "FACEBOOK_NON_JSON_RESULT";
   private static final String RESPONSE_LOG_TAG = "Response";
   public static final String SUCCESS_KEY = "success";
   private final HttpURLConnection connection;
   private final FacebookRequestError error;
   private final JSONObject graphObject;
   private final JSONArray graphObjectArray;
   private final String rawResponse;
   private final GraphRequest request;

   GraphResponse(GraphRequest var1, HttpURLConnection var2, FacebookRequestError var3) {
      this(var1, var2, null, null, null, var3);
   }

   GraphResponse(GraphRequest var1, HttpURLConnection var2, String var3, JSONArray var4) {
      this(var1, var2, var3, null, var4, null);
   }

   GraphResponse(GraphRequest var1, HttpURLConnection var2, String var3, JSONObject var4) {
      this(var1, var2, var3, var4, null, null);
   }

   GraphResponse(GraphRequest var1, HttpURLConnection var2, String var3, JSONObject var4, JSONArray var5, FacebookRequestError var6) {
      this.request = var1;
      this.connection = var2;
      this.rawResponse = var3;
      this.graphObject = var4;
      this.graphObjectArray = var5;
      this.error = var6;
   }

   static List<GraphResponse> constructErrorResponses(List<GraphRequest> var0, HttpURLConnection var1, FacebookException var2) {
      int var4 = var0.size();
      ArrayList var5 = new ArrayList(var4);

      for (int var3 = 0; var3 < var4; var3++) {
         var5.add(new GraphResponse((GraphRequest)var0.get(var3), var1, new FacebookRequestError(var1, var2)));
      }

      return var5;
   }

   private static GraphResponse createResponseFromObject(GraphRequest var0, HttpURLConnection var1, Object var2, Object var3) throws JSONException {
      Object var4 = var2;
      if (var2 instanceof JSONObject) {
         var2 = var2;
         var3 = FacebookRequestError.checkResponseAndCreateError(var2, var3, var1);
         if (var3 != null) {
            if (var3.getErrorCode() == 190 && Utility.isCurrentAccessToken(var0.getAccessToken())) {
               AccessToken.setCurrentAccessToken(null);
            }

            return new GraphResponse(var0, var1, var3);
         }

         Object var7 = Utility.getStringPropertyAsJSON(var2, "body", "FACEBOOK_NON_JSON_RESULT");
         if (var7 instanceof JSONObject) {
            return new GraphResponse(var0, var1, var7.toString(), (JSONObject)var7);
         }

         if (var7 instanceof JSONArray) {
            return new GraphResponse(var0, var1, var7.toString(), (JSONArray)var7);
         }

         var4 = JSONObject.NULL;
      }

      if (var4 != JSONObject.NULL) {
         throw new FacebookException("Got unexpected object type in response, class: " + var4.getClass().getSimpleName());
      } else {
         return new GraphResponse(var0, var1, var4.toString(), (JSONObject)null);
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static List<GraphResponse> createResponsesFromObject(HttpURLConnection var0, List<GraphRequest> var1, Object var2) throws FacebookException, JSONException {
      byte var4;
      int var5;
      Object var6;
      ArrayList var7;
      label62: {
         var4 = 0;
         var5 = var1.size();
         var7 = new ArrayList(var5);
         label61:
         if (var5 == 1) {
            GraphRequest var8 = (GraphRequest)var1.get(0);

            JSONObject var9;
            try {
               var9 = new JSONObject();
               var9.put("body", var2);
            } catch (JSONException var16) {
               var7.add(new GraphResponse(var8, var0, new FacebookRequestError(var0, var16)));
               var6 = (JSONArray)var2;
               break label62;
            } catch (IOException var17) {
               var7.add(new GraphResponse(var8, var0, new FacebookRequestError(var0, var17)));
               break label61;
            }

            int var3;
            if (var0 != null) {
               try {
                  var3 = var0.getResponseCode();
               } catch (JSONException var14) {
                  var7.add(new GraphResponse(var8, var0, new FacebookRequestError(var0, var14)));
                  var6 = (JSONArray)var2;
                  break label62;
               } catch (IOException var15) {
                  var7.add(new GraphResponse(var8, var0, new FacebookRequestError(var0, var15)));
                  break label61;
               }
            } else {
               var3 = 200;
            }

            try {
               var9.put("code", var3);
               var6 = new JSONArray();
               var6.put(var9);
               break label62;
            } catch (JSONException var12) {
               var7.add(new GraphResponse(var8, var0, new FacebookRequestError(var0, var12)));
               var6 = (JSONArray)var2;
               break label62;
            } catch (IOException var13) {
               var7.add(new GraphResponse(var8, var0, new FacebookRequestError(var0, var13)));
            }
         }

         var6 = (JSONArray)var2;
      }

      if (var6 instanceof JSONArray && var6.length() == var5) {
         var6 = var6;

         for (int var18 = var4; var18 < var6.length(); var18++) {
            GraphRequest var20 = (GraphRequest)var1.get(var18);

            try {
               var7.add(createResponseFromObject(var20, var0, var6.get(var18), var2));
            } catch (JSONException var10) {
               var7.add(new GraphResponse(var20, var0, new FacebookRequestError(var0, var10)));
            } catch (FacebookException var11) {
               var7.add(new GraphResponse(var20, var0, new FacebookRequestError(var0, var11)));
            }
         }

         return var7;
      } else {
         throw new FacebookException("Unexpected number of results");
      }
   }

   static List<GraphResponse> createResponsesFromStream(InputStream var0, HttpURLConnection var1, GraphRequestBatch var2) throws FacebookException, JSONException, IOException {
      String var3 = Utility.readStreamToString(var0);
      Logger.log(LoggingBehavior.INCLUDE_RAW_RESPONSES, "Response", "Response (raw)\n  Size: %d\n  Response:\n%s\n", var3.length(), var3);
      return createResponsesFromString(var3, var1, var2);
   }

   static List<GraphResponse> createResponsesFromString(String var0, HttpURLConnection var1, GraphRequestBatch var2) throws FacebookException, JSONException, IOException {
      List var3 = createResponsesFromObject(var1, var2, new JSONTokener(var0).nextValue());
      Logger.log(LoggingBehavior.REQUESTS, "Response", "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n", var2.getId(), var0.length(), var3);
      return var3;
   }

   static List<GraphResponse> fromHttpConnection(HttpURLConnection param0, GraphRequestBatch param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aconst_null
      // 01: astore 7
      // 03: aconst_null
      // 04: astore 2
      // 05: aconst_null
      // 06: astore 6
      // 08: aload 6
      // 0a: astore 5
      // 0c: aload 7
      // 0e: astore 4
      // 10: aload 2
      // 11: astore 3
      // 12: aload 0
      // 13: invokevirtual java/net/HttpURLConnection.getResponseCode ()I
      // 16: sipush 400
      // 19: if_icmplt 44
      // 1c: aload 6
      // 1e: astore 5
      // 20: aload 7
      // 22: astore 4
      // 24: aload 2
      // 25: astore 3
      // 26: aload 0
      // 27: invokevirtual java/net/HttpURLConnection.getErrorStream ()Ljava/io/InputStream;
      // 2a: astore 2
      // 2b: aload 2
      // 2c: astore 5
      // 2e: aload 2
      // 2f: astore 4
      // 31: aload 2
      // 32: astore 3
      // 33: aload 2
      // 34: aload 0
      // 35: aload 1
      // 36: invokestatic com/facebook/GraphResponse.createResponsesFromStream (Ljava/io/InputStream;Ljava/net/HttpURLConnection;Lcom/facebook/GraphRequestBatch;)Ljava/util/List;
      // 39: astore 6
      // 3b: aload 6
      // 3d: astore 0
      // 3e: aload 2
      // 3f: invokestatic com/facebook/internal/Utility.closeQuietly (Ljava/io/Closeable;)V
      // 42: aload 0
      // 43: areturn
      // 44: aload 6
      // 46: astore 5
      // 48: aload 7
      // 4a: astore 4
      // 4c: aload 2
      // 4d: astore 3
      // 4e: aload 0
      // 4f: invokevirtual java/net/HttpURLConnection.getInputStream ()Ljava/io/InputStream;
      // 52: astore 2
      // 53: goto 2b
      // 56: astore 2
      // 57: aload 5
      // 59: astore 3
      // 5a: getstatic com/facebook/LoggingBehavior.REQUESTS Lcom/facebook/LoggingBehavior;
      // 5d: ldc "Response"
      // 5f: ldc_w "Response <Error>: %s"
      // 62: bipush 1
      // 63: anewarray 4
      // 66: dup
      // 67: bipush 0
      // 68: aload 2
      // 69: aastore
      // 6a: invokestatic com/facebook/internal/Logger.log (Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      // 6d: aload 5
      // 6f: astore 3
      // 70: aload 1
      // 71: aload 0
      // 72: aload 2
      // 73: invokestatic com/facebook/GraphResponse.constructErrorResponses (Ljava/util/List;Ljava/net/HttpURLConnection;Lcom/facebook/FacebookException;)Ljava/util/List;
      // 76: astore 0
      // 77: aload 5
      // 79: invokestatic com/facebook/internal/Utility.closeQuietly (Ljava/io/Closeable;)V
      // 7c: goto 42
      // 7f: astore 2
      // 80: aload 4
      // 82: astore 3
      // 83: getstatic com/facebook/LoggingBehavior.REQUESTS Lcom/facebook/LoggingBehavior;
      // 86: ldc "Response"
      // 88: ldc_w "Response <Error>: %s"
      // 8b: bipush 1
      // 8c: anewarray 4
      // 8f: dup
      // 90: bipush 0
      // 91: aload 2
      // 92: aastore
      // 93: invokestatic com/facebook/internal/Logger.log (Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      // 96: aload 4
      // 98: astore 3
      // 99: new com/facebook/FacebookException
      // 9c: astore 5
      // 9e: aload 4
      // a0: astore 3
      // a1: aload 5
      // a3: aload 2
      // a4: invokespecial com/facebook/FacebookException.<init> (Ljava/lang/Throwable;)V
      // a7: aload 4
      // a9: astore 3
      // aa: aload 1
      // ab: aload 0
      // ac: aload 5
      // ae: invokestatic com/facebook/GraphResponse.constructErrorResponses (Ljava/util/List;Ljava/net/HttpURLConnection;Lcom/facebook/FacebookException;)Ljava/util/List;
      // b1: astore 0
      // b2: aload 4
      // b4: invokestatic com/facebook/internal/Utility.closeQuietly (Ljava/io/Closeable;)V
      // b7: goto 42
      // ba: astore 0
      // bb: aload 3
      // bc: invokestatic com/facebook/internal/Utility.closeQuietly (Ljava/io/Closeable;)V
      // bf: aload 0
      // c0: athrow
      // try (12 -> 16): 52 com/facebook/FacebookException
      // try (12 -> 16): 75 java/lang/Exception
      // try (12 -> 16): 107 null
      // try (22 -> 25): 52 com/facebook/FacebookException
      // try (22 -> 25): 75 java/lang/Exception
      // try (22 -> 25): 107 null
      // try (31 -> 36): 52 com/facebook/FacebookException
      // try (31 -> 36): 75 java/lang/Exception
      // try (31 -> 36): 107 null
      // try (48 -> 51): 52 com/facebook/FacebookException
      // try (48 -> 51): 75 java/lang/Exception
      // try (48 -> 51): 107 null
      // try (55 -> 65): 107 null
      // try (67 -> 72): 107 null
      // try (78 -> 88): 107 null
      // try (90 -> 92): 107 null
      // try (94 -> 97): 107 null
      // try (99 -> 104): 107 null
   }

   public final HttpURLConnection getConnection() {
      return this.connection;
   }

   public final FacebookRequestError getError() {
      return this.error;
   }

   public final JSONArray getJSONArray() {
      return this.graphObjectArray;
   }

   public final JSONObject getJSONObject() {
      return this.graphObject;
   }

   public String getRawResponse() {
      return this.rawResponse;
   }

   public GraphRequest getRequest() {
      return this.request;
   }

   public GraphRequest getRequestForPagedResults(GraphResponse.PagingDirection var1) {
      Object var3;
      label31: {
         var3 = null;
         if (this.graphObject != null) {
            JSONObject var2 = this.graphObject.optJSONObject("paging");
            if (var2 != null) {
               if (var1 == GraphResponse.PagingDirection.NEXT) {
                  var7 = var2.optString("next");
               } else {
                  var7 = var2.optString("previous");
               }
               break label31;
            }
         }

         var7 = null;
      }

      GraphRequest var8;
      if (Utility.isNullOrEmpty(var7)) {
         var8 = (GraphRequest)var3;
      } else {
         if (var7 != null) {
            var8 = (GraphRequest)var3;
            if (var7.equals(this.request.getUrlForSingleRequest())) {
               return var8;
            }
         }

         try {
            AccessToken var5 = this.request.getAccessToken();
            URL var4 = new URL(var7);
            var8 = new GraphRequest(var5, var4);
         } catch (MalformedURLException var6) {
            var8 = (GraphRequest)var3;
         }
      }

      return var8;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @Override
   public String toString() {
      int var1;
      Locale var5;
      label21: {
         try {
            var5 = Locale.US;
            if (this.connection != null) {
               var1 = this.connection.getResponseCode();
               break label21;
            }
         } catch (IOException var4) {
            String var2 = "unknown";
            return "{Response: " + " responseCode: " + var2 + ", graphObject: " + this.graphObject + ", error: " + this.error + "}";
         }

         var1 = 200;
      }

      try {
         var6 = String.format(var5, "%d", var1);
      } catch (IOException var3) {
         var6 = "unknown";
      }

      return "{Response: " + " responseCode: " + var6 + ", graphObject: " + this.graphObject + ", error: " + this.error + "}";
   }

   public enum PagingDirection {
      NEXT,
      PREVIOUS;

      private static final GraphResponse.PagingDirection[] $VALUES = new GraphResponse.PagingDirection[]{
         GraphResponse.PagingDirection.NEXT, GraphResponse.PagingDirection.PREVIOUS
      };
   }
}
