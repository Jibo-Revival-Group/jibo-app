package com.salesforce.android.cases.core.internal.local;

import com.salesforce.android.service.common.utilities.control.ResultReceiver;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.threading.Job;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.smartstore.store.SmartStore;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class WriteJob implements Job<Void> {

    /* JADX INFO: renamed from: a */
    private static final ServiceLogger f12369a = ServiceLogging.m14203a((Class<?>) WriteJob.class);

    /* JADX INFO: renamed from: b */
    private SmartStore f12370b;

    /* JADX INFO: renamed from: c */
    private String f12371c;

    /* JADX INFO: renamed from: d */
    private JSONArray f12372d;

    /* JADX INFO: renamed from: e */
    private final UserAccount f12373e;

    private WriteJob(SmartStore smartStore, String str, JSONArray jSONArray, UserAccount userAccount) {
        this.f12370b = smartStore;
        this.f12371c = str;
        this.f12372d = jSONArray;
        this.f12373e = userAccount;
    }

    @Override // com.salesforce.android.service.common.utilities.threading.Job
    /* JADX INFO: renamed from: a */
    public void mo12210a(ResultReceiver<Void> resultReceiver) {
        try {
            if (!DbUtils.m12369a(this.f12373e)) {
                resultReceiver.mo12615b(new IllegalStateException("Cannot write to db, not authenticated"));
                resultReceiver.mo12613b();
                return;
            }
            this.f12370b.m14799b(this.f12371c);
            f12369a.mo14189b("Starting Write to {}", this.f12371c);
            for (int i = 0; i < this.f12372d.length(); i++) {
                this.f12370b.m14788a(this.f12371c, this.f12372d.getJSONObject(i));
            }
            f12369a.mo14189b("Write to {} complete", this.f12371c);
            resultReceiver.mo12613b();
        } catch (JSONException e) {
            resultReceiver.mo12615b(e);
            resultReceiver.mo12613b();
        }
    }

    /* JADX INFO: renamed from: a */
    public static WriteJob m12406a(SmartStore smartStore, String str, JSONArray jSONArray, UserAccount userAccount) {
        return new WriteJob(smartStore, str, jSONArray, userAccount);
    }
}
