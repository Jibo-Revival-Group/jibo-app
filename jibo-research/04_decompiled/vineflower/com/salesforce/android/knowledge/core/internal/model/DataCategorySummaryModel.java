package com.salesforce.android.knowledge.core.internal.model;

import com.salesforce.android.knowledge.core.internal.http.response.DataCategoryGroupsResponse;
import com.salesforce.android.knowledge.core.model.DataCategorySummary;

public class DataCategorySummaryModel implements DataCategorySummary {
   private final String a;
   private final String b;
   private final int c;
   private final String d;

   DataCategorySummaryModel(String var1, String var2, int var3, String var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public static DataCategorySummaryModel a(DataCategoryGroupsResponse.DataCategory var0, String var1) {
      return a(var0.b(), var0.a(), var0.c().size(), var1);
   }

   public static DataCategorySummaryModel a(String var0, String var1, int var2, String var3) {
      return new DataCategorySummaryModel(var0, var1, var2, var3);
   }

   @Override
   public String a() {
      return this.a;
   }

   @Override
   public String b() {
      return this.b;
   }

   @Override
   public int c() {
      return this.c;
   }

   public String d() {
      return this.d;
   }

   @Override
   public String toString() {
      return this.b;
   }
}
