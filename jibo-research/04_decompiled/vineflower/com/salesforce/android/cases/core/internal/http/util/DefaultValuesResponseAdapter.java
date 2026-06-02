package com.salesforce.android.cases.core.internal.http.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.salesforce.android.cases.core.internal.http.response.DefaultValuesResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

public class DefaultValuesResponseAdapter extends TypeAdapter<DefaultValuesResponse> {
   private Gson a = new GsonBuilder().a("yyyy-MM-dd'T'HH:mm:ss.SSSZ").a();

   private DefaultValuesResponseAdapter() {
   }

   public static DefaultValuesResponseAdapter a() {
      return new DefaultValuesResponseAdapter();
   }

   public DefaultValuesResponse a(JsonReader var1) throws IOException {
      JsonObject var3 = this.a.a(this.a.a(var1, Object.class)).l();
      DefaultValuesResponse var2 = this.a.a(var3, DefaultValuesResponse.class);
      HashMap var6 = new HashMap();

      for (Entry var4 : var3.a()) {
         String var5 = (String)var4.getKey();
         if (!"attributes".equals(var5)) {
            var6.put(var5, ((JsonElement)var4.getValue()).c());
         }
      }

      var2.a(var6);
      return var2;
   }

   public void a(JsonWriter var1, DefaultValuesResponse var2) throws IOException {
   }
}
