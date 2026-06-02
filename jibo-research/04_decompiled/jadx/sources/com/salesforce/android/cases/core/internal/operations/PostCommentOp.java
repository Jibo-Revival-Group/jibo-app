package com.salesforce.android.cases.core.internal.operations;

import com.salesforce.android.cases.core.internal.remote.RemoteRepository;
import com.salesforce.android.cases.core.model.CommentPost;
import com.salesforce.android.cases.core.requests.CommentPostRequest;
import com.salesforce.android.service.common.utilities.control.Async;

/* JADX INFO: loaded from: classes.dex */
public class PostCommentOp extends CaseFetchSaveOperation<CommentPostRequest, CommentPost> {
    public PostCommentOp(CommentPostRequest commentPostRequest, RemoteRepository remoteRepository) {
        super(commentPostRequest, null, remoteRepository);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.android.cases.core.internal.operations.CaseFetchSaveOperation
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Async<CommentPost> mo12510a(RemoteRepository remoteRepository, CommentPostRequest commentPostRequest) {
        return remoteRepository.m12597a(commentPostRequest);
    }

    @Override // com.salesforce.android.cases.core.internal.operations.CaseFetchSaveOperation
    /* JADX INFO: renamed from: b */
    protected String mo12514b() {
        return "Cannot Post Case Comment, Offline";
    }
}
