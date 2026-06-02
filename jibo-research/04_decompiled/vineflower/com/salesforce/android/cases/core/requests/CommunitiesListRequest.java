package com.salesforce.android.cases.core.requests;

public class CommunitiesListRequest extends FetchSaveRequest {
   CommunitiesListRequest(com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest.FetchSaveRequestBuilder var1) {
      super(var1);
   }

   public static class CommunitiesListRequestBuilder
      extends com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest.FetchSaveRequestBuilder<CommunitiesListRequest.CommunitiesListRequestBuilder> {
      protected CommunitiesListRequest.CommunitiesListRequestBuilder a() {
         return this;
      }

      public CommunitiesListRequest b() {
         return new CommunitiesListRequest(this);
      }
   }
}
