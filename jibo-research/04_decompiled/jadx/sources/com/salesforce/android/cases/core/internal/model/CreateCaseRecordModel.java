package com.salesforce.android.cases.core.internal.model;

import com.google.gson.annotations.SerializedName;
import com.salesforce.android.cases.core.model.CreateCaseRecord;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class CreateCaseRecordModel implements CreateCaseRecord {

    @SerializedName(m9428a = "record")
    private Map<String, String> record;

    public CreateCaseRecordModel(Builder builder) {
        if (builder == null) {
            throw new IllegalStateException("CaseRecordModel.Builder cannot be null.");
        }
        this.record = builder.f12502a;
    }

    public static class Builder {

        /* JADX INFO: renamed from: a */
        private Map<String, String> f12502a = new HashMap();

        /* JADX INFO: renamed from: a */
        public Builder m12492a(String str, String str2) {
            this.f12502a.put(str, str2);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public CreateCaseRecordModel m12493a() {
            return new CreateCaseRecordModel(this);
        }
    }
}
