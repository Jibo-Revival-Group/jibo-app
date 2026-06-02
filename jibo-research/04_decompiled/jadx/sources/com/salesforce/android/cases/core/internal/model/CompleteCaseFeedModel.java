package com.salesforce.android.cases.core.internal.model;

import com.salesforce.android.cases.core.model.CaseDetailRecord;
import com.salesforce.android.cases.core.model.CaseFeed;
import com.salesforce.android.cases.core.model.CaseLayoutData;
import com.salesforce.android.cases.core.model.CompleteCaseFeed;
import com.salesforce.android.cases.core.model.DefaultValues;

/* JADX INFO: loaded from: classes.dex */
public class CompleteCaseFeedModel implements CompleteCaseFeed {

    /* JADX INFO: renamed from: a */
    private String f12497a;

    /* JADX INFO: renamed from: b */
    private CaseFeed f12498b;

    /* JADX INFO: renamed from: c */
    private CaseDetailRecord f12499c;

    /* JADX INFO: renamed from: d */
    private CaseLayoutData f12500d;

    /* JADX INFO: renamed from: e */
    private DefaultValues f12501e;

    /* JADX INFO: renamed from: a */
    public boolean m12484a() {
        return (this.f12497a == null || this.f12498b == null || this.f12499c == null || this.f12500d == null || this.f12501e == null) ? false : true;
    }

    /* JADX INFO: renamed from: b */
    public CompleteCaseFeed m12485b() {
        return new CompleteCaseFeedModel().m12483a(this.f12497a).m12480a(this.f12498b).m12479a(this.f12499c).m12481a(this.f12500d).m12482a(this.f12501e);
    }

    /* JADX INFO: renamed from: a */
    public CompleteCaseFeedModel m12483a(String str) {
        this.f12497a = str;
        return this;
    }

    @Override // com.salesforce.android.cases.core.model.CompleteCaseFeed
    /* JADX INFO: renamed from: c */
    public String mo12486c() {
        return this.f12497a;
    }

    /* JADX INFO: renamed from: a */
    public CompleteCaseFeedModel m12480a(CaseFeed caseFeed) {
        this.f12498b = caseFeed;
        return this;
    }

    @Override // com.salesforce.android.cases.core.model.CompleteCaseFeed
    /* JADX INFO: renamed from: d */
    public CaseFeed mo12487d() {
        return this.f12498b;
    }

    /* JADX INFO: renamed from: a */
    public CompleteCaseFeedModel m12479a(CaseDetailRecord caseDetailRecord) {
        this.f12499c = caseDetailRecord;
        return this;
    }

    @Override // com.salesforce.android.cases.core.model.CompleteCaseFeed
    /* JADX INFO: renamed from: e */
    public CaseDetailRecord mo12488e() {
        return this.f12499c;
    }

    /* JADX INFO: renamed from: a */
    public CompleteCaseFeedModel m12481a(CaseLayoutData caseLayoutData) {
        this.f12500d = caseLayoutData;
        return this;
    }

    @Override // com.salesforce.android.cases.core.model.CompleteCaseFeed
    /* JADX INFO: renamed from: f */
    public CaseLayoutData mo12489f() {
        return this.f12500d;
    }

    /* JADX INFO: renamed from: a */
    public CompleteCaseFeedModel m12482a(DefaultValues defaultValues) {
        this.f12501e = defaultValues;
        return this;
    }

    @Override // com.salesforce.android.cases.core.model.CompleteCaseFeed
    /* JADX INFO: renamed from: g */
    public DefaultValues mo12490g() {
        return this.f12501e;
    }
}
