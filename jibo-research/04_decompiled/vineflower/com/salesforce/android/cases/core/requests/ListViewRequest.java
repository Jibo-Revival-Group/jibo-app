package com.salesforce.android.cases.core.requests;

public class ListViewRequest extends FetchSaveRequest {
   private String a;

   ListViewRequest(ListViewRequest.ListViewRequestBuilder var1) {
      super(var1);
      this.a = var1.a;
   }

   public static ListViewRequest a(String var0) {
      return new ListViewRequest.ListViewRequestBuilder(var0).e(false).e();
   }

   public String a() {
      return this.a;
   }

   public static class ListViewRequestBuilder
      extends com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest.FetchSaveRequestBuilder<ListViewRequest.ListViewRequestBuilder> {
      private final String a;

      public ListViewRequestBuilder(String var1) {
         this.a = var1;
      }

      protected ListViewRequest.ListViewRequestBuilder a() {
         return this;
      }

      @Override
      public boolean d() {
         return true;
      }

      public ListViewRequest e() {
         return new ListViewRequest(this);
      }

      @Override
      public boolean f_() {
         return true;
      }
   }
}
