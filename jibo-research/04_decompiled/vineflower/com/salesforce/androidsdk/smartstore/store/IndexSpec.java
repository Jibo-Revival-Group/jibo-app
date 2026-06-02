package com.salesforce.androidsdk.smartstore.store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class IndexSpec {
   public final String a;
   public final SmartStore.Type b;
   public final String c;

   public IndexSpec(String var1, SmartStore.Type var2) {
      this.a = var1;
      this.b = var2;
      this.c = null;
   }

   public IndexSpec(String var1, SmartStore.Type var2, String var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public static IndexSpec a(JSONObject var0) throws JSONException {
      return new IndexSpec(var0.getString("path"), SmartStore.Type.valueOf(var0.getString("type")), var0.optString("columnName"));
   }

   public static Map<String, IndexSpec> a(IndexSpec[] var0) {
      HashMap var3 = new HashMap();

      for (IndexSpec var4 : var0) {
         var3.put(var4.a, var4);
      }

      return var3;
   }

   public static IndexSpec[] a(JSONArray var0) throws JSONException {
      ArrayList var2 = new ArrayList();

      for (int var1 = 0; var1 < var0.length(); var1++) {
         var2.add(a(var0.getJSONObject(var1)));
      }

      return var2.toArray(new IndexSpec[0]);
   }

   public static boolean b(IndexSpec[] var0) {
      boolean var4 = false;
      int var2 = var0.length;
      int var1 = 0;

      boolean var3;
      while (true) {
         var3 = var4;
         if (var1 >= var2) {
            break;
         }

         if (var0[var1].b == SmartStore.Type.full_text) {
            var3 = true;
            break;
         }

         var1++;
      }

      return var3;
   }

   public static boolean c(IndexSpec[] var0) {
      boolean var4 = false;
      int var2 = var0.length;
      int var1 = 0;

      boolean var3;
      while (true) {
         var3 = var4;
         if (var1 >= var2) {
            break;
         }

         if (var0[var1].b == SmartStore.Type.json1) {
            var3 = true;
            break;
         }

         var1++;
      }

      return var3;
   }

   public String a() {
      return this.a + "|" + this.b;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var4 = true;
      boolean var3 = false;
      if (var1 != null) {
         if (var1 == this) {
            var3 = true;
         } else if (var1 instanceof IndexSpec) {
            var1 = var1;
            boolean var2;
            if (this.a.equals(var1.a)) {
               var2 = true;
            } else {
               var2 = false;
            }

            if (var2 && this.b.equals(var1.b)) {
               var2 = true;
            } else {
               var2 = false;
            }

            if (this.c == null) {
               if (var2 && this.c == var1.c) {
                  var3 = var4;
               } else {
                  var3 = false;
               }
            } else {
               if (var2) {
                  var3 = var4;
                  if (this.c.equals(var1.c)) {
                     return var3;
                  }
               }

               var3 = false;
            }
         }
      }

      return var3;
   }

   @Override
   public int hashCode() {
      int var2 = (this.a.hashCode() + 527) * 31 + this.b.hashCode();
      int var1 = var2;
      if (this.c != null) {
         var1 = var2 * 31 + this.c.hashCode();
      }

      return var1;
   }
}
