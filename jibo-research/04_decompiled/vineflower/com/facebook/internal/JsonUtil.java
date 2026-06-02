package com.facebook.internal;

import android.annotation.SuppressLint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

class JsonUtil {
   static void jsonObjectClear(JSONObject var0) {
      Iterator var1 = var0.keys();

      while (var1.hasNext()) {
         var1.next();
         var1.remove();
      }
   }

   static boolean jsonObjectContainsValue(JSONObject var0, Object var1) {
      Iterator var3 = var0.keys();

      boolean var2;
      while (true) {
         if (var3.hasNext()) {
            Object var4 = var0.opt((String)var3.next());
            if (var4 == null || !var4.equals(var1)) {
               continue;
            }

            var2 = true;
            break;
         }

         var2 = false;
         break;
      }

      return var2;
   }

   static Set<Entry<String, Object>> jsonObjectEntrySet(JSONObject var0) {
      HashSet var1 = new HashSet();
      Iterator var2 = var0.keys();

      while (var2.hasNext()) {
         String var3 = (String)var2.next();
         var1.add(new JsonUtil.JSONObjectEntry(var3, var0.opt(var3)));
      }

      return var1;
   }

   static Set<String> jsonObjectKeySet(JSONObject var0) {
      HashSet var1 = new HashSet();
      Iterator var2 = var0.keys();

      while (var2.hasNext()) {
         var1.add(var2.next());
      }

      return var1;
   }

   static void jsonObjectPutAll(JSONObject var0, Map<String, Object> var1) {
      for (Entry var2 : var1.entrySet()) {
         try {
            var0.putOpt((String)var2.getKey(), var2.getValue());
         } catch (JSONException var3) {
            throw new IllegalArgumentException(var3);
         }
      }
   }

   static Collection<Object> jsonObjectValues(JSONObject var0) {
      ArrayList var1 = new ArrayList();
      Iterator var2 = var0.keys();

      while (var2.hasNext()) {
         var1.add(var0.opt((String)var2.next()));
      }

      return var1;
   }

   private static final class JSONObjectEntry implements Entry<String, Object> {
      private final String key;
      private final Object value;

      JSONObjectEntry(String var1, Object var2) {
         this.key = var1;
         this.value = var2;
      }

      @SuppressLint("FieldGetter")
      public String getKey() {
         return this.key;
      }

      @Override
      public Object getValue() {
         return this.value;
      }

      @Override
      public Object setValue(Object var1) {
         throw new UnsupportedOperationException("JSONObjectEntry is immutable");
      }
   }
}
