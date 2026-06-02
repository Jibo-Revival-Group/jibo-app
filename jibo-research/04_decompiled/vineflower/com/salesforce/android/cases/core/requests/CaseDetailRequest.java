package com.salesforce.android.cases.core.requests;

public class CaseDetailRequest extends FetchSaveRequest {
   private final String a;

   CaseDetailRequest(CaseDetailRequest.CaseDetailRequestBuilder var1) {
      super(var1);
      this.a = var1.a;
   }

   public String a() {
      return this.a;
   }

   public static class CaseDetailRequestBuilder
      extends com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest.FetchSaveRequestBuilder<CaseDetailRequest.CaseDetailRequestBuilder> {
      private final String a;

      public CaseDetailRequestBuilder(String var1) {
         this.a = var1;
      }

      protected CaseDetailRequest.CaseDetailRequestBuilder a() {
         return this;
      }

      public CaseDetailRequest b() {
         return new CaseDetailRequest(this);
      }
   }
}
