package com.salesforce.android.cases.core.requests;

public class CaseFeedRequest extends FetchSaveRequest {
   private final String a;
   private final String b;

   CaseFeedRequest(CaseFeedRequest.CaseFeedRequestBuilder var1) {
      super(var1);
      this.a = var1.a;
      this.b = var1.b;
   }

   public String a() {
      return this.a;
   }

   public String b() {
      return this.b;
   }

   public static class CaseFeedRequestBuilder
      extends com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest.FetchSaveRequestBuilder<CaseFeedRequest.CaseFeedRequestBuilder> {
      private String a;
      private String b;

      public CaseFeedRequestBuilder(String var1, String var2) {
         this.a = var1;
         this.b = var2;
      }

      protected CaseFeedRequest.CaseFeedRequestBuilder a() {
         return this;
      }

      public CaseFeedRequest b() {
         return new CaseFeedRequest(this);
      }
   }
}
