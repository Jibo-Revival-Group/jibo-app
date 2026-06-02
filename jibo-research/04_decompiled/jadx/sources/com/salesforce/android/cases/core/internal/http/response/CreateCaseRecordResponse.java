package com.salesforce.android.cases.core.internal.http.response;

import com.facebook.GraphResponse;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CreateCaseRecordResponse {

    @SerializedName(m9428a = "created")
    private boolean created;

    @SerializedName(m9428a = "errors")
    private List<String> errors;

    /* JADX INFO: renamed from: id */
    @SerializedName(m9428a = ShareConstants.WEB_DIALOG_PARAM_ID)
    private String f12323id;

    @SerializedName(m9428a = GraphResponse.SUCCESS_KEY)
    private boolean success;

    /* JADX INFO: renamed from: a */
    public String m12327a() {
        return this.f12323id;
    }

    /* JADX INFO: renamed from: b */
    public List<String> m12328b() {
        return this.errors == null ? Collections.emptyList() : Collections.unmodifiableList(this.errors);
    }

    /* JADX INFO: renamed from: c */
    public boolean m12329c() {
        return this.success;
    }

    /* JADX INFO: renamed from: d */
    public boolean m12330d() {
        return this.created;
    }
}
