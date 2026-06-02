package com.salesforce.android.cases.core.requests;

import com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest;

/* JADX INFO: loaded from: classes.dex */
public class ListViewDescribeRequest extends FetchSaveRequest {

    /* JADX INFO: renamed from: a */
    private final String f12595a;

    ListViewDescribeRequest(ListViewDescribeRequestBuilder listViewDescribeRequestBuilder) {
        super(listViewDescribeRequestBuilder);
        this.f12595a = listViewDescribeRequestBuilder.f12596a;
    }

    /* JADX INFO: renamed from: a */
    public static ListViewDescribeRequest m12673a(String str) {
        return new ListViewDescribeRequestBuilder(str).mo12687c(true).mo12688d(true).m13742e(false).m12677b();
    }

    /* JADX INFO: renamed from: a */
    public String m12674a() {
        return this.f12595a;
    }

    public static class ListViewDescribeRequestBuilder extends FetchSaveRequest.FetchSaveRequestBuilder<ListViewDescribeRequestBuilder> {

        /* JADX INFO: renamed from: a */
        private String f12596a;

        public ListViewDescribeRequestBuilder(String str) {
            this.f12596a = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest.FetchSaveRequestBuilder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ListViewDescribeRequestBuilder mo12627c() {
            return this;
        }

        /* JADX INFO: renamed from: b */
        public ListViewDescribeRequest m12677b() {
            return new ListViewDescribeRequest(this);
        }
    }
}
