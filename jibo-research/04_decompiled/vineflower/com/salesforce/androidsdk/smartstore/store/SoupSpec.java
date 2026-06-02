package com.salesforce.androidsdk.smartstore.store;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SoupSpec {
   public static final String[] a = new String[]{"externalStorage"};
   private String b;
   private List<String> c;

   public SoupSpec(String var1) {
      this.b = var1;
      this.c = Collections.emptyList();
   }

   public SoupSpec(String var1, String... var2) {
      this.b = var1;
      if (var2 != null) {
         this.c = Arrays.asList(var2);
      } else {
         this.c = Collections.emptyList();
      }
   }

   public static SoupSpec a(JSONObject var0) throws JSONException {
      JSONArray var2 = var0.optJSONArray("features");
      SoupSpec var4;
      if (var2 != null) {
         String[] var3 = new String[var2.length()];

         for (int var1 = 0; var1 < var2.length(); var1++) {
            var3[var1] = (String)var2.get(var1);
         }

         var4 = new SoupSpec(var0.getString("name"), var3);
      } else {
         var4 = new SoupSpec(var0.getString("name"));
      }

      return var4;
   }

   public String a() {
      return this.b;
   }

   public List<String> b() {
      return this.c;
   }
}
