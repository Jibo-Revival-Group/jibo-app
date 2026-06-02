package com.salesforce.android.knowledge.core.requests;

import com.salesforce.android.knowledge.core.KnowledgeClient;
import com.salesforce.android.knowledge.core.model.DataCategoryList;
import com.salesforce.android.service.common.utilities.control.Async;

public class DataCategoriesRequest extends KnowledgeRequest {
   private final String a;
   private final String b;

   DataCategoriesRequest(DataCategoriesRequest.Builder var1) {
      super(var1);
      this.b = var1.b;
      this.a = var1.a;
   }

   public static DataCategoriesRequest.Builder a(String var0, String var1) {
      return new DataCategoriesRequest.Builder(var0, var1);
   }

   public String a() {
      return this.b;
   }

   public String b() {
      return this.a;
   }

   public static class Builder extends KnowledgeRequest.KnowledgeRequestBuilder<DataCategoriesRequest.Builder> {
      final String a;
      final String b;

      Builder(String var1, String var2) {
         this.a = var1;
         this.b = var2;
      }

      public DataCategoriesRequest a() {
         return new DataCategoriesRequest(this);
      }

      public Async<DataCategoryList> a(KnowledgeClient var1) {
         return var1.a(this.a());
      }

      protected DataCategoriesRequest.Builder e() {
         return this;
      }
   }
}
