package io.fabric.sdk.android;

import com.yalantis.ucrop.util.FileUtils;
import io.fabric.sdk.android.services.common.TimingMetric;
import io.fabric.sdk.android.services.concurrency.Priority;
import io.fabric.sdk.android.services.concurrency.PriorityAsyncTask;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;

/* JADX INFO: loaded from: classes2.dex */
class InitializationTask<Result> extends PriorityAsyncTask<Void, Void, Result> {

    /* JADX INFO: renamed from: a */
    final Kit<Result> f14528a;

    public InitializationTask(Kit<Result> kit) {
        this.f14528a = kit;
    }

    @Override // io.fabric.sdk.android.services.concurrency.AsyncTask
    /* JADX INFO: renamed from: a */
    protected void mo15111a() {
        super.mo15111a();
        TimingMetric timingMetricM15108a = m15108a("onPreExecute");
        try {
            try {
                boolean zMo5607a_ = this.f14528a.mo5607a_();
                timingMetricM15108a.m15269b();
                if (!zMo5607a_) {
                    m15278a(true);
                }
            } catch (UnmetDependencyException e) {
                throw e;
            } catch (Exception e2) {
                Fabric.m15085h().mo15073e("Fabric", "Failure onPreExecute()", e2);
                timingMetricM15108a.m15269b();
                m15278a(true);
            }
        } catch (Throwable th) {
            timingMetricM15108a.m15269b();
            m15278a(true);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.fabric.sdk.android.services.concurrency.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Result mo15109a(Void... voidArr) {
        TimingMetric timingMetricM15108a = m15108a("doInBackground");
        Result resultMo5604f = null;
        if (!m15280e()) {
            resultMo5604f = this.f14528a.mo5604f();
        }
        timingMetricM15108a.m15269b();
        return resultMo5604f;
    }

    @Override // io.fabric.sdk.android.services.concurrency.AsyncTask
    /* JADX INFO: renamed from: a */
    protected void mo15112a(Result result) {
        this.f14528a.m15116a(result);
        this.f14528a.f14532h.mo15100a(result);
    }

    @Override // io.fabric.sdk.android.services.concurrency.AsyncTask
    /* JADX INFO: renamed from: b */
    protected void mo15113b(Result result) {
        this.f14528a.m15117b(result);
        this.f14528a.f14532h.mo15099a(new InitializationException(this.f14528a.mo5601b() + " Initialization was cancelled"));
    }

    @Override // io.fabric.sdk.android.services.concurrency.PriorityAsyncTask, io.fabric.sdk.android.services.concurrency.PriorityProvider
    /* JADX INFO: renamed from: b */
    public Priority mo5882b() {
        return Priority.HIGH;
    }

    /* JADX INFO: renamed from: a */
    private TimingMetric m15108a(String str) {
        TimingMetric timingMetric = new TimingMetric(this.f14528a.mo5601b() + FileUtils.HIDDEN_PREFIX + str, "KitInitialization");
        timingMetric.m15268a();
        return timingMetric;
    }
}
