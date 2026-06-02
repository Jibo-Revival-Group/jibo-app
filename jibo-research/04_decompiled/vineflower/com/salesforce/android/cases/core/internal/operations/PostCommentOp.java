package com.salesforce.android.cases.core.internal.operations;

import com.salesforce.android.cases.core.internal.remote.RemoteRepository;
import com.salesforce.android.cases.core.model.CommentPost;
import com.salesforce.android.cases.core.requests.CommentPostRequest;
import com.salesforce.android.service.common.utilities.control.Async;

public class PostCommentOp extends CaseFetchSaveOperation<CommentPostRequest, CommentPost> {
   public PostCommentOp(CommentPostRequest var1, RemoteRepository var2) {
      super(var1, null, var2);
   }

   protected Async<CommentPost> a(RemoteRepository var1, CommentPostRequest var2) {
      return var1.a(var2);
   }

   @Override
   protected String b() {
      return "Cannot Post Case Comment, Offline";
   }
}
