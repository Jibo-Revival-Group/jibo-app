package com.salesforce.android.cases.core.requests;

public class CaseListRequest extends FetchSaveRequest {
   private final String a;

   CaseListRequest(CaseListRequest.CaseListRequestBuilder var1) {
      super(var1);
      this.a = var1.a;
   }

   public static CaseListRequest a(String var0) {
      return new CaseListRequest.CaseListRequestBuilder(var0).c(true).d(true).e(true).b();
   }

   public String a() {
      return this.a;
   }

   public static class CaseListRequestBuilder
      extends com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest.FetchSaveRequestBuilder<CaseListRequest.CaseListRequestBuilder> {
      private String a;

      public CaseListRequestBuilder(String var1) {
         this.a = var1;
      }

      protected CaseListRequest.CaseListRequestBuilder a() {
         return this;
      }

      public CaseListRequest b() {
         return new CaseListRequest(this);
      }
   }
}
