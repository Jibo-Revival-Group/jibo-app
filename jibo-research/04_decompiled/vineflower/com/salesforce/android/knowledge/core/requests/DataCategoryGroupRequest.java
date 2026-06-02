package com.salesforce.android.knowledge.core.requests;

import com.salesforce.android.knowledge.core.KnowledgeClient;
import com.salesforce.android.knowledge.core.model.DataCategoryGroup;
import com.salesforce.android.service.common.utilities.control.Async;

public class DataCategoryGroupRequest extends KnowledgeRequest {
   private final String a;

   DataCategoryGroupRequest(DataCategoryGroupRequest.Builder var1) {
      super(var1);
      this.a = var1.a;
   }

   public static DataCategoryGroupRequest.Builder a(String var0) {
      return new DataCategoryGroupRequest.Builder(var0);
   }

   public String a() {
      return this.a;
   }

   public static class Builder extends KnowledgeRequest.KnowledgeRequestBuilder<DataCategoryGroupRequest.Builder> {
      final String a;

      Builder(String var1) {
         this.a = var1;
      }

      public DataCategoryGroupRequest a() {
         return new DataCategoryGroupRequest(this);
      }

      public Async<DataCategoryGroup> a(KnowledgeClient var1) {
         return var1.a(this.a());
      }

      protected DataCategoryGroupRequest.Builder e() {
         return this;
      }
   }
}
