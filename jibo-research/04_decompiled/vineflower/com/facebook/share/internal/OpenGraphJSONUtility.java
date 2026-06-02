package com.facebook.share.internal;

import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.SharePhoto;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class OpenGraphJSONUtility {
   private OpenGraphJSONUtility() {
   }

   private static JSONArray toJSONArray(List var0, OpenGraphJSONUtility.PhotoJSONProcessor var1) throws JSONException {
      JSONArray var2 = new JSONArray();
      Iterator var3 = var0.iterator();

      while (var3.hasNext()) {
         var2.put(toJSONValue(var3.next(), var1));
      }

      return var2;
   }

   public static JSONObject toJSONObject(ShareOpenGraphAction var0, OpenGraphJSONUtility.PhotoJSONProcessor var1) throws JSONException {
      JSONObject var2 = new JSONObject();

      for (String var4 : var0.keySet()) {
         var2.put(var4, toJSONValue(var0.get(var4), var1));
      }

      return var2;
   }

   private static JSONObject toJSONObject(ShareOpenGraphObject var0, OpenGraphJSONUtility.PhotoJSONProcessor var1) throws JSONException {
      JSONObject var2 = new JSONObject();

      for (String var4 : var0.keySet()) {
         var2.put(var4, toJSONValue(var0.get(var4), var1));
      }

      return var2;
   }

   public static Object toJSONValue(Object var0, OpenGraphJSONUtility.PhotoJSONProcessor var1) throws JSONException {
      Object var2;
      if (var0 == null) {
         var2 = JSONObject.NULL;
      } else {
         var2 = var0;
         if (!(var0 instanceof String)) {
            var2 = var0;
            if (!(var0 instanceof Boolean)) {
               var2 = var0;
               if (!(var0 instanceof Double)) {
                  var2 = var0;
                  if (!(var0 instanceof Float)) {
                     var2 = var0;
                     if (!(var0 instanceof Integer)) {
                        var2 = var0;
                        if (!(var0 instanceof Long)) {
                           if (var0 instanceof SharePhoto) {
                              if (var1 != null) {
                                 var2 = var1.toJSONObject((SharePhoto)var0);
                              } else {
                                 var2 = null;
                              }
                           } else if (var0 instanceof ShareOpenGraphObject) {
                              var2 = toJSONObject((ShareOpenGraphObject)var0, var1);
                           } else {
                              if (!(var0 instanceof List)) {
                                 throw new IllegalArgumentException("Invalid object found for JSON serialization: " + var0.toString());
                              }

                              var2 = toJSONArray((List)var0, var1);
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      return var2;
   }

   public interface PhotoJSONProcessor {
      JSONObject toJSONObject(SharePhoto var1);
   }
}
