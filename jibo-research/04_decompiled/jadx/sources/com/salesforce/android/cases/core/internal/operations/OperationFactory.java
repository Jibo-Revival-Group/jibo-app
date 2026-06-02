package com.salesforce.android.cases.core.internal.operations;

import com.salesforce.android.cases.core.internal.local.LocalRepository;
import com.salesforce.android.cases.core.internal.remote.RemoteRepository;
import com.salesforce.android.cases.core.model.CaseDetailRecord;
import com.salesforce.android.cases.core.model.CaseFeed;
import com.salesforce.android.cases.core.model.CaseLayoutData;
import com.salesforce.android.cases.core.model.CaseListRecord;
import com.salesforce.android.cases.core.model.CommentPost;
import com.salesforce.android.cases.core.model.Community;
import com.salesforce.android.cases.core.model.CompleteCaseFeed;
import com.salesforce.android.cases.core.model.CreateCaseRecordResult;
import com.salesforce.android.cases.core.model.DefaultValues;
import com.salesforce.android.cases.core.model.ListViewDescribe;
import com.salesforce.android.cases.core.requests.CaseDetailRequest;
import com.salesforce.android.cases.core.requests.CaseFeedRequest;
import com.salesforce.android.cases.core.requests.CaseListRequest;
import com.salesforce.android.cases.core.requests.CommentPostRequest;
import com.salesforce.android.cases.core.requests.CommunitiesListRequest;
import com.salesforce.android.cases.core.requests.CompleteCaseFeedRequest;
import com.salesforce.android.cases.core.requests.CreateCaseQuickActionRequest;
import com.salesforce.android.cases.core.requests.CreateCaseRecordRequest;
import com.salesforce.android.cases.core.requests.DefaultValuesRequest;
import com.salesforce.android.cases.core.requests.ListViewDescribeRequest;
import com.salesforce.android.cases.core.requests.ListViewRequest;
import com.salesforce.android.cases.core.requests.SetCaseHiddenRequest;
import com.salesforce.android.cases.core.requests.SetCaseLastReadDateRequest;
import com.salesforce.android.service.common.fetchsave.internal.operations.Operation;
import com.salesforce.androidsdk.accounts.UserAccount;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class OperationFactory {
    /* JADX INFO: renamed from: a */
    public Operation<CaseLayoutData> m12565a(CreateCaseQuickActionRequest createCaseQuickActionRequest, LocalRepository localRepository, RemoteRepository remoteRepository, UserAccount userAccount) {
        return new GetCreateCaseLayoutDataOp(createCaseQuickActionRequest, localRepository, remoteRepository, userAccount);
    }

    /* JADX INFO: renamed from: a */
    public Operation<CreateCaseRecordResult> m12566a(CreateCaseRecordRequest createCaseRecordRequest, RemoteRepository remoteRepository) {
        return new CreateCaseRecordOp(createCaseRecordRequest, remoteRepository);
    }

    /* JADX INFO: renamed from: a */
    public Operation<List<Community>> m12563a(CommunitiesListRequest communitiesListRequest, LocalRepository localRepository, RemoteRepository remoteRepository) {
        return new GetCommunitiesListOp(communitiesListRequest, localRepository, remoteRepository);
    }

    /* JADX INFO: renamed from: a */
    public Operation<String> m12569a(ListViewRequest listViewRequest, LocalRepository localRepository, RemoteRepository remoteRepository) {
        return new GetListViewIdOp(listViewRequest, localRepository, remoteRepository);
    }

    /* JADX INFO: renamed from: b */
    public Operation<String> m12572b(ListViewRequest listViewRequest, LocalRepository localRepository, RemoteRepository remoteRepository) {
        return new GetListViewLabelOp(listViewRequest, localRepository, remoteRepository);
    }

    /* JADX INFO: renamed from: a */
    public Operation<ListViewDescribe> m12568a(ListViewDescribeRequest listViewDescribeRequest, LocalRepository localRepository, RemoteRepository remoteRepository) {
        return new GetListViewDescribeOp(listViewDescribeRequest, localRepository, remoteRepository);
    }

    /* JADX INFO: renamed from: a */
    public Operation<List<CaseListRecord>> m12561a(CaseListRequest caseListRequest, LocalRepository localRepository, RemoteRepository remoteRepository) {
        return new GetCaseListOp(caseListRequest, localRepository, remoteRepository);
    }

    /* JADX INFO: renamed from: a */
    public Operation<CaseFeed> m12560a(CaseFeedRequest caseFeedRequest, LocalRepository localRepository, RemoteRepository remoteRepository) {
        return new GetCaseFeedOp(caseFeedRequest, localRepository, remoteRepository);
    }

    /* JADX INFO: renamed from: a */
    public Operation<CaseDetailRecord> m12559a(CaseDetailRequest caseDetailRequest, LocalRepository localRepository, RemoteRepository remoteRepository) {
        return new GetCaseDetailOp(caseDetailRequest, localRepository, remoteRepository);
    }

    /* JADX INFO: renamed from: a */
    public Operation<CommentPost> m12562a(CommentPostRequest commentPostRequest, RemoteRepository remoteRepository) {
        return new PostCommentOp(commentPostRequest, remoteRepository);
    }

    /* JADX INFO: renamed from: a */
    public Operation<DefaultValues> m12567a(DefaultValuesRequest defaultValuesRequest, LocalRepository localRepository, RemoteRepository remoteRepository) {
        return new GetDefaultValuesOp(defaultValuesRequest, localRepository, remoteRepository);
    }

    /* JADX INFO: renamed from: a */
    public Operation<Void> m12571a(SetCaseLastReadDateRequest setCaseLastReadDateRequest, LocalRepository localRepository, RemoteRepository remoteRepository) {
        return new SetCaseLastReadDateOp(setCaseLastReadDateRequest, localRepository, remoteRepository);
    }

    /* JADX INFO: renamed from: a */
    public Operation<Void> m12570a(SetCaseHiddenRequest setCaseHiddenRequest, LocalRepository localRepository, RemoteRepository remoteRepository) {
        return new SetCaseHiddenOp(setCaseHiddenRequest, localRepository, remoteRepository);
    }

    /* JADX INFO: renamed from: a */
    public Operation<CompleteCaseFeed> m12564a(CompleteCaseFeedRequest completeCaseFeedRequest, LocalRepository localRepository, RemoteRepository remoteRepository, UserAccount userAccount) {
        return new GetCompleteCaseFeedOp(completeCaseFeedRequest, localRepository, remoteRepository, this, userAccount);
    }
}
