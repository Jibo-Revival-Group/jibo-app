package com.salesforce.android.cases.core.requests;

public class ListViewDescribeRequest extends FetchSaveRequest {
   private final String a;

   ListViewDescribeRequest(ListViewDescribeRequest.ListViewDescribeRequestBuilder var1) {
      super(var1);
      this.a = var1.a;
   }

   public static ListViewDescribeRequest a(String var0) {
      return new ListViewDescribeRequest.ListViewDescribeRequestBuilder(var0).c(true).d(true).e(false).b();
   }

   public String a() {
      return this.a;
   }

   public static class ListViewDescribeRequestBuilder
      extends com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest.FetchSaveRequestBuilder<ListViewDescribeRequest.ListViewDescribeRequestBuilder> {
      private String a;

      public ListViewDescribeRequestBuilder(String var1) {
         this.a = var1;
      }

      protected ListViewDescribeRequest.ListViewDescribeRequestBuilder a() {
         return this;
      }

      public ListViewDescribeRequest b() {
         return new ListViewDescribeRequest(this);
      }
   }
}
