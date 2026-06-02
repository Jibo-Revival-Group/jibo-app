package com.salesforce.android.cases.core.requests;

public class CompleteCaseFeedRequest extends FetchSaveRequest {
   private final String a;
   private final String b;
   private final String c;

   CompleteCaseFeedRequest(CompleteCaseFeedRequest.CompleteCaseFeedRequestBuilder var1) {
      super(var1);
      this.a = var1.a;
      this.b = var1.b;
      this.c = var1.c;
   }

   public String a() {
      return this.a;
   }

   public String b() {
      return this.b;
   }

   public String c() {
      return this.c;
   }

   public static class CompleteCaseFeedRequestBuilder
      extends com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest.FetchSaveRequestBuilder<CompleteCaseFeedRequest.CompleteCaseFeedRequestBuilder> {
      private final String a;
      private final String b;
      private final String c;

      public CompleteCaseFeedRequestBuilder(String var1, String var2, String var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }

      protected CompleteCaseFeedRequest.CompleteCaseFeedRequestBuilder a() {
         return this;
      }

      public CompleteCaseFeedRequest b() {
         return new CompleteCaseFeedRequest(this);
      }
   }
}
