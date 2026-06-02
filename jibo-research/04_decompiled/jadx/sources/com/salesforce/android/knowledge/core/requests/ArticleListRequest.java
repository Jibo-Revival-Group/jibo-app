package com.salesforce.android.knowledge.core.requests;

import com.salesforce.android.knowledge.core.KnowledgeClient;
import com.salesforce.android.knowledge.core.model.ArticleList;
import com.salesforce.android.knowledge.core.requests.KnowledgeRequest;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.validation.Arguments;

/* JADX INFO: loaded from: classes.dex */
public class ArticleListRequest extends KnowledgeRequest {

    /* JADX INFO: renamed from: a */
    private final String f13040a;

    /* JADX INFO: renamed from: b */
    private final String f13041b;

    /* JADX INFO: renamed from: c */
    private final int f13042c;

    /* JADX INFO: renamed from: d */
    private final int f13043d;

    /* JADX INFO: renamed from: e */
    private final int f13044e;

    /* JADX INFO: renamed from: f */
    private final CharSequence f13045f;

    /* JADX INFO: renamed from: g */
    private final int f13046g;

    /* JADX INFO: renamed from: h */
    private final int f13047h;

    ArticleListRequest(Builder builder) {
        super(builder);
        this.f13040a = builder.f13048a;
        this.f13041b = builder.f13049b;
        this.f13042c = builder.f13050c;
        this.f13043d = builder.f13051d;
        this.f13044e = builder.f13052e;
        this.f13045f = builder.f13053f;
        this.f13046g = builder.f13054g;
        this.f13047h = builder.f13055h;
    }

    /* JADX INFO: renamed from: a */
    public static Builder m13309a() {
        return new Builder();
    }

    /* JADX INFO: renamed from: b */
    public int m13310b() {
        return this.f13042c;
    }

    /* JADX INFO: renamed from: c */
    public int m13311c() {
        return this.f13043d;
    }

    /* JADX INFO: renamed from: d */
    public String m13312d() {
        switch (this.f13044e) {
            case 1:
                return "BELOW";
            default:
                throw new IllegalArgumentException("Unknown query method");
        }
    }

    /* JADX INFO: renamed from: e */
    public int m13313e() {
        return this.f13046g;
    }

    /* JADX INFO: renamed from: f */
    public String m13314f() {
        switch (this.f13046g) {
            case 1:
                return "LastPublishedDate";
            case 2:
                return "Title";
            case 3:
                return "ViewScore";
            default:
                throw new IllegalArgumentException("Unknown sortBy");
        }
    }

    /* JADX INFO: renamed from: g */
    public int m13315g() {
        return this.f13047h;
    }

    /* JADX INFO: renamed from: h */
    public String m13316h() {
        return this.f13047h == 1 ? "ASC" : "DESC";
    }

    /* JADX INFO: renamed from: i */
    public String m13317i() {
        return this.f13041b;
    }

    /* JADX INFO: renamed from: j */
    public String m13318j() {
        return this.f13040a;
    }

    /* JADX INFO: renamed from: k */
    public CharSequence m13319k() {
        return this.f13045f;
    }

    public static class Builder extends KnowledgeRequest.KnowledgeRequestBuilder<Builder> {

        /* JADX INFO: renamed from: a */
        String f13048a;

        /* JADX INFO: renamed from: b */
        String f13049b;

        /* JADX INFO: renamed from: f */
        CharSequence f13053f;

        /* JADX INFO: renamed from: c */
        int f13050c = 1;

        /* JADX INFO: renamed from: d */
        int f13051d = 3;

        /* JADX INFO: renamed from: e */
        int f13052e = 1;

        /* JADX INFO: renamed from: g */
        int f13054g = 1;

        /* JADX INFO: renamed from: h */
        int f13055h = 2;

        Builder() {
        }

        /* JADX INFO: renamed from: a */
        public Builder m13320a(int i) {
            Arguments.m14239a(i >= 1, "Page number must be greater than zero.");
            this.f13050c = i;
            return this;
        }

        /* JADX INFO: renamed from: b */
        public Builder m13325b(int i) {
            Arguments.m14239a(i >= 1, "Page size must be greater than zero.");
            this.f13051d = i;
            return this;
        }

        /* JADX INFO: renamed from: c */
        public Builder m13326c(int i) {
            this.f13052e = i;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m13322a(String str, String str2) {
            this.f13048a = str;
            this.f13049b = str2;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m13321a(CharSequence charSequence) {
            this.f13053f = charSequence;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Async<ArticleList> m13324a(KnowledgeClient knowledgeClient) {
            return knowledgeClient.mo13066a(m13323a());
        }

        /* JADX INFO: renamed from: a */
        public ArticleListRequest m13323a() {
            return new ArticleListRequest(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.salesforce.android.service.common.fetchsave.requests.FetchSaveRequest.FetchSaveRequestBuilder
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Builder mo12627c() {
            return this;
        }
    }
}
