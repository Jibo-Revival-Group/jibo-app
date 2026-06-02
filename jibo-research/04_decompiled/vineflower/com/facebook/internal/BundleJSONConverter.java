package com.facebook.internal;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BundleJSONConverter {
   private static final Map<Class<?>, BundleJSONConverter.Setter> SETTERS = new HashMap<>();

   static {
      SETTERS.put(Boolean.class, new BundleJSONConverter.Setter() {
         @Override
         public void setOnBundle(Bundle var1, String var2, Object var3) throws JSONException {
            var1.putBoolean(var2, (Boolean)var3);
         }

         @Override
         public void setOnJSON(JSONObject var1, String var2, Object var3) throws JSONException {
            var1.put(var2, var3);
         }
      });
      SETTERS.put(Integer.class, new BundleJSONConverter.Setter() {
         @Override
         public void setOnBundle(Bundle var1, String var2, Object var3) throws JSONException {
            var1.putInt(var2, (Integer)var3);
         }

         @Override
         public void setOnJSON(JSONObject var1, String var2, Object var3) throws JSONException {
            var1.put(var2, var3);
         }
      });
      SETTERS.put(Long.class, new BundleJSONConverter.Setter() {
         @Override
         public void setOnBundle(Bundle var1, String var2, Object var3) throws JSONException {
            var1.putLong(var2, (Long)var3);
         }

         @Override
         public void setOnJSON(JSONObject var1, String var2, Object var3) throws JSONException {
            var1.put(var2, var3);
         }
      });
      SETTERS.put(Double.class, new BundleJSONConverter.Setter() {
         @Override
         public void setOnBundle(Bundle var1, String var2, Object var3) throws JSONException {
            var1.putDouble(var2, (Double)var3);
         }

         @Override
         public void setOnJSON(JSONObject var1, String var2, Object var3) throws JSONException {
            var1.put(var2, var3);
         }
      });
      SETTERS.put(String.class, new BundleJSONConverter.Setter() {
         @Override
         public void setOnBundle(Bundle var1, String var2, Object var3) throws JSONException {
            var1.putString(var2, (String)var3);
         }

         @Override
         public void setOnJSON(JSONObject var1, String var2, Object var3) throws JSONException {
            var1.put(var2, var3);
         }
      });
      SETTERS.put(String[].class, new BundleJSONConverter.Setter() {
         @Override
         public void setOnBundle(Bundle var1, String var2, Object var3) throws JSONException {
            throw new IllegalArgumentException("Unexpected type from JSON");
         }

         @Override
         public void setOnJSON(JSONObject var1, String var2, Object var3) throws JSONException {
            JSONArray var6 = new JSONArray();
            var3 = var3;
            int var5 = var3.length;

            for (int var4 = 0; var4 < var5; var4++) {
               var6.put(var3[var4]);
            }

            var1.put(var2, var6);
         }
      });
      SETTERS.put(JSONArray.class, new BundleJSONConverter.Setter() {
         @Override
         public void setOnBundle(Bundle var1, String var2, Object var3) throws JSONException {
            JSONArray var6 = (JSONArray)var3;
            ArrayList var5 = new ArrayList();
            if (var6.length() == 0) {
               var1.putStringArrayList(var2, var5);
            } else {
               for (int var4 = 0; var4 < var6.length(); var4++) {
                  var3 = var6.get(var4);
                  if (!(var3 instanceof String)) {
                     throw new IllegalArgumentException("Unexpected type in an array: " + var3.getClass());
                  }

                  var5.add((String)var3);
               }

               var1.putStringArrayList(var2, var5);
            }
         }

         @Override
         public void setOnJSON(JSONObject var1, String var2, Object var3) throws JSONException {
            throw new IllegalArgumentException("JSONArray's are not supported in bundles.");
         }
      });
   }

   public static Bundle convertToBundle(JSONObject var0) throws JSONException {
      Bundle var5 = new Bundle();
      Iterator var3 = var0.keys();

      while (var3.hasNext()) {
         String var2 = (String)var3.next();
         Object var4 = var0.get(var2);
         if (var4 != null && var4 != JSONObject.NULL) {
            if (var4 instanceof JSONObject) {
               var5.putBundle(var2, convertToBundle((JSONObject)var4));
            } else {
               BundleJSONConverter.Setter var1 = SETTERS.get(var4.getClass());
               if (var1 == null) {
                  throw new IllegalArgumentException("Unsupported type: " + var4.getClass());
               }

               var1.setOnBundle(var5, var2, var4);
            }
         }
      }

      return var5;
   }

   public static JSONObject convertToJSON(Bundle var0) throws JSONException {
      JSONObject var1 = new JSONObject();

      for (String var3 : var0.keySet()) {
         Object var5 = var0.get(var3);
         if (var5 != null) {
            if (var5 instanceof List) {
               JSONArray var6 = new JSONArray();
               Iterator var7 = ((List)var5).iterator();

               while (var7.hasNext()) {
                  var6.put((String)var7.next());
               }

               var1.put(var3, var6);
            } else if (var5 instanceof Bundle) {
               var1.put(var3, convertToJSON((Bundle)var5));
            } else {
               BundleJSONConverter.Setter var4 = SETTERS.get(var5.getClass());
               if (var4 == null) {
                  throw new IllegalArgumentException("Unsupported type: " + var5.getClass());
               }

               var4.setOnJSON(var1, var3, var5);
            }
         }
      }

      return var1;
   }

   public interface Setter {
      void setOnBundle(Bundle var1, String var2, Object var3) throws JSONException;

      void setOnJSON(JSONObject var1, String var2, Object var3) throws JSONException;
   }
}
