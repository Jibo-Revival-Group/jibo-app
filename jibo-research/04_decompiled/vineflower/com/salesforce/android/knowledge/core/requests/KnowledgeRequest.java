package com.salesforce.android.knowledge.core.requests;

import com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest;

public abstract class KnowledgeRequest extends FetchSaveRequest {
   protected KnowledgeRequest(KnowledgeRequest.KnowledgeRequestBuilder var1) {
      super(var1);
   }

   public abstract static class KnowledgeRequestBuilder<T extends KnowledgeRequest.KnowledgeRequestBuilder<T>>
      extends FetchSaveRequest.FetchSaveRequestBuilder<T> {
   }
}
