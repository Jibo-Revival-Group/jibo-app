package com.salesforce.android.cases.core.internal.http.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.salesforce.android.cases.core.internal.http.response.CaseDetailResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

public class CaseDetailResponseAdapter extends TypeAdapter<CaseDetailResponse> {
   private Gson a = new GsonBuilder().a("yyyy-MM-dd'T'HH:mm:ss.SSSZ").a();

   private CaseDetailResponseAdapter() {
   }

   public static CaseDetailResponseAdapter a() {
      return new CaseDetailResponseAdapter();
   }

   public CaseDetailResponse a(JsonReader var1) throws IOException {
      JsonObject var3 = this.a.a(this.a.a(var1, Object.class)).l();
      CaseDetailResponse var2 = this.a.a(var3, CaseDetailResponse.class);
      HashMap var6 = new HashMap();

      for (Entry var7 : var3.a()) {
         String var5 = (String)var7.getKey();
         if (var5.endsWith("__c")) {
            var6.put(var5, ((JsonElement)var7.getValue()).c());
         }
      }

      var2.a(var6);
      return var2;
   }

   public void a(JsonWriter var1, CaseDetailResponse var2) throws IOException {
   }
}
