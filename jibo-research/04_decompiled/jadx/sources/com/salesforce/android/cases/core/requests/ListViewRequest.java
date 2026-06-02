package com.salesforce.android.cases.core.requests;

import com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest;

/* JADX INFO: loaded from: classes.dex */
public class ListViewRequest extends FetchSaveRequest {

    /* JADX INFO: renamed from: a */
    private String f12597a;

    ListViewRequest(ListViewRequestBuilder listViewRequestBuilder) {
        super(listViewRequestBuilder);
        this.f12597a = listViewRequestBuilder.f12598a;
    }

    /* JADX INFO: renamed from: a */
    public static ListViewRequest m12678a(String str) {
        return new ListViewRequestBuilder(str).m13742e(false).m12683e();
    }

    /* JADX INFO: renamed from: a */
    public String m12679a() {
        return this.f12597a;
    }

    public static class ListViewRequestBuilder extends FetchSaveRequest.FetchSaveRequestBuilder<ListViewRequestBuilder> {

        /* JADX INFO: renamed from: a */
        private final String f12598a;

        public ListViewRequestBuilder(String str) {
            this.f12598a = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest.FetchSaveRequestBuilder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ListViewRequestBuilder mo12627c() {
            return this;
        }

        @Override // com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest.FetchSaveRequestBuilder
        /* JADX INFO: renamed from: f_ */
        public boolean mo12684f_() {
            return true;
        }

        @Override // com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest.FetchSaveRequestBuilder
        /* JADX INFO: renamed from: d */
        public boolean mo12682d() {
            return true;
        }

        /* JADX INFO: renamed from: e */
        public ListViewRequest m12683e() {
            return new ListViewRequest(this);
        }
    }
}
