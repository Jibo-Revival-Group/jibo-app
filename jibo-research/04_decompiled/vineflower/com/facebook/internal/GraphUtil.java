package com.facebook.internal;

import com.facebook.FacebookException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GraphUtil {
   private static final String[] dateFormats = new String[]{"yyyy-MM-dd'T'HH:mm:ssZ", "yyyy-MM-dd'T'HH:mm:ss", "yyyy-MM-dd"};

   public static JSONObject createOpenGraphActionForPost(String var0) {
      JSONObject var1 = new JSONObject();
      if (var0 != null) {
         try {
            var1.put("type", var0);
         } catch (JSONException var2) {
            throw new FacebookException("An error occurred while setting up the open graph action", var2);
         }
      }

      return var1;
   }

   public static JSONObject createOpenGraphObjectForPost(String var0) {
      return createOpenGraphObjectForPost(var0, null, null, null, null, null, null);
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static JSONObject createOpenGraphObjectForPost(String var0, String var1, String var2, String var3, String var4, JSONObject var5, String var6) {
      JSONObject var7 = new JSONObject();
      if (var0 != null) {
         try {
            var7.put("type", var0);
         } catch (JSONException var13) {
            throw new FacebookException("An error occurred while setting up the graph object", var13);
         }
      }

      try {
         var7.put("title", var1);
      } catch (JSONException var12) {
         throw new FacebookException("An error occurred while setting up the graph object", var12);
      }

      if (var2 != null) {
         try {
            JSONObject var14 = new JSONObject();
            var14.put("url", var2);
            JSONArray var15 = new JSONArray();
            var15.put(var14);
            var7.put("image", var15);
         } catch (JSONException var11) {
            throw new FacebookException("An error occurred while setting up the graph object", var11);
         }
      }

      try {
         var7.put("url", var3);
         var7.put("description", var4);
         var7.put("fbsdk:create_object", true);
      } catch (JSONException var10) {
         throw new FacebookException("An error occurred while setting up the graph object", var10);
      }

      if (var5 != null) {
         try {
            var7.put("data", var5);
         } catch (JSONException var9) {
            throw new FacebookException("An error occurred while setting up the graph object", var9);
         }
      }

      if (var6 != null) {
         try {
            var7.put("id", var6);
         } catch (JSONException var8) {
            throw new FacebookException("An error occurred while setting up the graph object", var8);
         }
      }

      return var7;
   }

   public static boolean isOpenGraphObjectForPost(JSONObject var0) {
      boolean var1;
      if (var0 != null) {
         var1 = var0.optBoolean("fbsdk:create_object");
      } else {
         var1 = false;
      }

      return var1;
   }
}
