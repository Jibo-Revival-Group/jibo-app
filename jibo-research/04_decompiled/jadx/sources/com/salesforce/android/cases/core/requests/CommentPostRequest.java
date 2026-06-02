package com.salesforce.android.cases.core.requests;

/* JADX INFO: loaded from: classes.dex */
public class CommentPostRequest extends FetchSaveRequest {

    /* JADX INFO: renamed from: a */
    private final String f12575a;

    /* JADX INFO: renamed from: b */
    private final String f12576b;

    /* JADX INFO: renamed from: c */
    private final String f12577c;

    CommentPostRequest(CommentPostRequestBuilder commentPostRequestBuilder) {
        super(commentPostRequestBuilder);
        this.f12575a = commentPostRequestBuilder.f12578a;
        this.f12577c = commentPostRequestBuilder.f12579b;
        this.f12576b = commentPostRequestBuilder.f12580c;
    }

    /* JADX INFO: renamed from: a */
    public String m12639a() {
        return this.f12575a;
    }

    /* JADX INFO: renamed from: b */
    public String m12640b() {
        return this.f12577c;
    }

    /* JADX INFO: renamed from: c */
    public String m12641c() {
        return this.f12576b;
    }

    public static class CommentPostRequestBuilder extends NoCacheRequestBuilder<CommentPostRequestBuilder> {

        /* JADX INFO: renamed from: a */
        private final String f12578a;

        /* JADX INFO: renamed from: b */
        private final String f12579b;

        /* JADX INFO: renamed from: c */
        private final String f12580c;

        public CommentPostRequestBuilder(String str, String str2, String str3) {
            this.f12580c = str;
            this.f12578a = str2;
            this.f12579b = str3;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest.FetchSaveRequestBuilder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CommentPostRequestBuilder mo12627c() {
            return this;
        }

        /* JADX INFO: renamed from: b */
        public CommentPostRequest m12646b() {
            return new CommentPostRequest(this);
        }
    }
}
