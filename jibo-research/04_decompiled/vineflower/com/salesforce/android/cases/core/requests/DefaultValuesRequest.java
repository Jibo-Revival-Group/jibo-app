package com.salesforce.android.cases.core.requests;

public class DefaultValuesRequest extends FetchSaveRequest {
   private String a;

   DefaultValuesRequest(DefaultValuesRequest.DefaultValuesRequestBuilder var1) {
      super(var1);
      this.a = var1.a;
   }

   public static DefaultValuesRequest a(String var0) {
      return new DefaultValuesRequest.DefaultValuesRequestBuilder(var0).c(true).d(true).b();
   }

   public String a() {
      return this.a;
   }

   public static class DefaultValuesRequestBuilder
      extends com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest.FetchSaveRequestBuilder<DefaultValuesRequest.DefaultValuesRequestBuilder> {
      private final String a;

      public DefaultValuesRequestBuilder(String var1) {
         this.a = var1;
      }

      protected DefaultValuesRequest.DefaultValuesRequestBuilder a() {
         return this;
      }

      public DefaultValuesRequest b() {
         return new DefaultValuesRequest(this);
      }
   }
}
