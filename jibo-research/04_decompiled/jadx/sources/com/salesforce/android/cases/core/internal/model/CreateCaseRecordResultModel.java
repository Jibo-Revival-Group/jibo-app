package com.salesforce.android.cases.core.internal.model;

import com.salesforce.android.cases.core.internal.http.response.CreateCaseRecordResponse;
import com.salesforce.android.cases.core.model.CreateCaseRecordResult;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CreateCaseRecordResultModel implements CreateCaseRecordResult {

    /* JADX INFO: renamed from: a */
    private String f12503a;

    /* JADX INFO: renamed from: b */
    private List<String> f12504b;

    /* JADX INFO: renamed from: c */
    private boolean f12505c;

    /* JADX INFO: renamed from: d */
    private boolean f12506d;

    /* JADX INFO: renamed from: a */
    public static CreateCaseRecordResultModel m12494a(CreateCaseRecordResponse createCaseRecordResponse) {
        return new CreateCaseRecordResultModel(createCaseRecordResponse);
    }

    public CreateCaseRecordResultModel(CreateCaseRecordResponse createCaseRecordResponse) {
        if (createCaseRecordResponse == null) {
            throw new IllegalStateException("CaseRecordResponse cannot be null.");
        }
        this.f12503a = createCaseRecordResponse.m12327a();
        this.f12504b = createCaseRecordResponse.m12328b();
        this.f12505c = createCaseRecordResponse.m12329c();
        this.f12506d = createCaseRecordResponse.m12330d();
    }

    @Override // com.salesforce.android.cases.core.model.CreateCaseRecordResult
    /* JADX INFO: renamed from: a */
    public String mo12495a() {
        return this.f12503a;
    }
}
