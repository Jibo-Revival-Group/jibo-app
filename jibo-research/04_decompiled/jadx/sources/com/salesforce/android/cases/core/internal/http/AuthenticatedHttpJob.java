package com.salesforce.android.cases.core.internal.http;

import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.google.gson.Gson;
import com.salesforce.android.service.common.utilities.control.ResultReceiver;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.threading.Job;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.rest.ClientManager;
import java.io.IOException;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes.dex */
class AuthenticatedHttpJob<T> implements Job<T> {

    /* JADX INFO: renamed from: a */
    private static final ServiceLogger f12285a = ServiceLogging.m14203a((Class<?>) AuthenticatedHttpJob.class);

    /* JADX INFO: renamed from: b */
    private final ClientManager f12286b;

    /* JADX INFO: renamed from: c */
    private final UserAccount f12287c;

    /* JADX INFO: renamed from: d */
    private final Request f12288d;

    /* JADX INFO: renamed from: e */
    private final Class<T> f12289e;

    /* JADX INFO: renamed from: f */
    private final Gson f12290f;

    /* JADX INFO: renamed from: a */
    public static <T> AuthenticatedHttpJob<T> m12209a(ClientManager clientManager, UserAccount userAccount, Request request, Class<T> cls, Gson gson) {
        return new AuthenticatedHttpJob<>(clientManager, userAccount, request, cls, gson);
    }

    private AuthenticatedHttpJob(ClientManager clientManager, UserAccount userAccount, Request request, Class<T> cls, Gson gson) {
        this.f12286b = clientManager;
        this.f12287c = userAccount;
        this.f12288d = request;
        this.f12289e = cls;
        this.f12290f = gson;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.salesforce.android.service.common.utilities.threading.Job
    /* JADX INFO: renamed from: a */
    public void mo12210a(ResultReceiver<T> resultReceiver) {
        f12285a.mo14187a("Submitting http request to {}", this.f12288d.m15765a());
        try {
            Response responseExecute = FirebasePerfOkHttpClient.execute(this.f12286b.m14561a(this.f12287c).m14602d().mo15540a(this.f12288d));
            if (!responseExecute.m15794d()) {
                f12285a.mo14193d("Unsuccessful HTTP request: {}", responseExecute);
                resultReceiver.mo12615b((Throwable) new IOException("Unsuccessful HTTP request: " + responseExecute));
            } else {
                resultReceiver.mo12614b(this.f12290f.m9353a(responseExecute.m15798h().m15825e(), (Class) this.f12289e));
                resultReceiver.mo12613b();
            }
        } catch (Exception e) {
            f12285a.mo14193d("Encountered Exception during HTTP request {}", e);
            resultReceiver.mo12615b((Throwable) e);
        }
    }
}
