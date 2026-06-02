package com.salesforce.android.cases.core.internal.local;

import com.salesforce.android.service.common.utilities.control.ResultReceiver;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.threading.Job;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.smartstore.store.QuerySpec;
import com.salesforce.androidsdk.smartstore.store.SmartStore;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class ReadJob implements Job<JSONArray> {

    /* JADX INFO: renamed from: a */
    private static final ServiceLogger f12339a = ServiceLogging.m14203a((Class<?>) ReadJob.class);

    /* JADX INFO: renamed from: b */
    private SmartStore f12340b;

    /* JADX INFO: renamed from: c */
    private QuerySpec f12341c;

    /* JADX INFO: renamed from: d */
    private int f12342d;

    /* JADX INFO: renamed from: e */
    private UserAccount f12343e;

    private ReadJob(SmartStore smartStore, QuerySpec querySpec, int i, UserAccount userAccount) {
        this.f12340b = smartStore;
        this.f12341c = querySpec;
        this.f12342d = i;
        this.f12343e = userAccount;
    }

    @Override // com.salesforce.android.service.common.utilities.threading.Job
    /* JADX INFO: renamed from: a */
    public void mo12210a(ResultReceiver<JSONArray> resultReceiver) {
        try {
            if (!DbUtils.m12369a(this.f12343e)) {
                resultReceiver.mo12615b(new IllegalStateException("Cannot read from db, not authenticated"));
                resultReceiver.mo12613b();
            } else {
                resultReceiver.mo12614b(this.f12340b.m14786a(this.f12341c, this.f12342d));
                resultReceiver.mo12613b();
            }
        } catch (JSONException e) {
            resultReceiver.mo12615b(e);
            resultReceiver.mo12613b();
        }
    }

    /* JADX INFO: renamed from: a */
    public static ReadJob m12396a(SmartStore smartStore, QuerySpec querySpec, int i, UserAccount userAccount) {
        return new ReadJob(smartStore, querySpec, i, userAccount);
    }
}
