package com.salesforce.android.cases.core.requests;

public class CreateCaseQuickActionRequest extends FetchSaveRequest {
   private final String a;

   CreateCaseQuickActionRequest(CreateCaseQuickActionRequest.CreateCaseQuickActionRequestBuilder var1) {
      super(var1);
      this.a = var1.a;
   }

   public static CreateCaseQuickActionRequest a(String var0) {
      return new CreateCaseQuickActionRequest.CreateCaseQuickActionRequestBuilder(var0).c(true).d(true).b();
   }

   public String a() {
      return this.a;
   }

   public static class CreateCaseQuickActionRequestBuilder
      extends com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest.FetchSaveRequestBuilder<CreateCaseQuickActionRequest.CreateCaseQuickActionRequestBuilder> {
      private final String a;

      public CreateCaseQuickActionRequestBuilder(String var1) {
         this.a = var1;
      }

      protected CreateCaseQuickActionRequest.CreateCaseQuickActionRequestBuilder a() {
         return this;
      }

      public CreateCaseQuickActionRequest b() {
         return new CreateCaseQuickActionRequest(this);
      }
   }
}
