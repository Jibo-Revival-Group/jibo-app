package com.salesforce.android.cases.core.requests;

import com.salesforce.android.cases.core.SaveRequestBuilder;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class SetCaseLastReadDateRequest extends SaveRequest {

    /* JADX INFO: renamed from: a */
    private final String f12605a;

    /* JADX INFO: renamed from: b */
    private final Date f12606b;

    public SetCaseLastReadDateRequest(SetCaseLastReadDateRequestBuilder setCaseLastReadDateRequestBuilder) {
        super(setCaseLastReadDateRequestBuilder);
        this.f12605a = setCaseLastReadDateRequestBuilder.f12607a;
        this.f12606b = setCaseLastReadDateRequestBuilder.f12608b;
    }

    /* JADX INFO: renamed from: a */
    public static SetCaseLastReadDateRequest m12698a(String str, Date date) {
        return new SetCaseLastReadDateRequestBuilder(str, date).m12191a(true).m12193b(false).m12704e();
    }

    /* JADX INFO: renamed from: c */
    public String m12699c() {
        return this.f12605a;
    }

    /* JADX INFO: renamed from: d */
    public Date m12700d() {
        return this.f12606b;
    }

    public static class SetCaseLastReadDateRequestBuilder extends SaveRequestBuilder<SetCaseLastReadDateRequestBuilder> {

        /* JADX INFO: renamed from: a */
        private final String f12607a;

        /* JADX INFO: renamed from: b */
        private final Date f12608b;

        public SetCaseLastReadDateRequestBuilder(String str, Date date) {
            this.f12607a = str;
            this.f12608b = date;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.salesforce.android.cases.core.SaveRequestBuilder
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public SetCaseLastReadDateRequestBuilder mo12195c() {
            return this;
        }

        /* JADX INFO: renamed from: e */
        public SetCaseLastReadDateRequest m12704e() {
            return new SetCaseLastReadDateRequest(this);
        }
    }
}
