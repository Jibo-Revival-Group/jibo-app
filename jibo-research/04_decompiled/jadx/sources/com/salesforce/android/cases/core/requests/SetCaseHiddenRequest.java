package com.salesforce.android.cases.core.requests;

import com.salesforce.android.cases.core.SaveRequestBuilder;

/* JADX INFO: loaded from: classes.dex */
public class SetCaseHiddenRequest extends SaveRequest {

    /* JADX INFO: renamed from: a */
    private final String f12601a;

    /* JADX INFO: renamed from: b */
    private final boolean f12602b;

    public SetCaseHiddenRequest(SetCaseHiddenRequestBuilder setCaseHiddenRequestBuilder) {
        super(setCaseHiddenRequestBuilder);
        this.f12601a = setCaseHiddenRequestBuilder.f12603a;
        this.f12602b = setCaseHiddenRequestBuilder.f12604b;
    }

    /* JADX INFO: renamed from: a */
    public static SetCaseHiddenRequest m12691a(String str, boolean z) {
        return new SetCaseHiddenRequestBuilder(str, z).m12191a(true).m12193b(false).m12697e();
    }

    /* JADX INFO: renamed from: c */
    public String m12692c() {
        return this.f12601a;
    }

    /* JADX INFO: renamed from: d */
    public boolean m12693d() {
        return this.f12602b;
    }

    public static class SetCaseHiddenRequestBuilder extends SaveRequestBuilder<SetCaseHiddenRequestBuilder> {

        /* JADX INFO: renamed from: a */
        private final String f12603a;

        /* JADX INFO: renamed from: b */
        private final boolean f12604b;

        public SetCaseHiddenRequestBuilder(String str, boolean z) {
            this.f12603a = str;
            this.f12604b = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.salesforce.android.cases.core.SaveRequestBuilder
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public SetCaseHiddenRequestBuilder mo12195c() {
            return this;
        }

        /* JADX INFO: renamed from: e */
        public SetCaseHiddenRequest m12697e() {
            return new SetCaseHiddenRequest(this);
        }
    }
}
