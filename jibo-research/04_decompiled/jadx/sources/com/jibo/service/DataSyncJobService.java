package com.jibo.service;

import android.os.AsyncTask;
import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;
import com.jibo.p018db.EntityData;
import com.jibo.utils.LogUtils;

/* JADX INFO: loaded from: classes.dex */
public class DataSyncJobService extends JobService {

    /* JADX INFO: renamed from: a */
    public static final String f9733a = LogUtils.m11405a(DataSyncJobService.class);

    /* JADX INFO: renamed from: b */
    private AsyncTask f9734b;

    @Override // com.firebase.jobdispatcher.JobService
    /* JADX INFO: renamed from: a */
    public boolean mo6621a(final JobParameters jobParameters) {
        this.f9734b = new AsyncTask<Void, Void, Void>() { // from class: com.jibo.service.DataSyncJobService.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void doInBackground(Void... voidArr) throws Throwable {
                LogUtils.m11407a(DataSyncJobService.f9733a, "onStartJob-start");
                EntityData.m10089a(DataSyncJobService.this).m10113a(jobParameters.mo6563b());
                LogUtils.m11407a(DataSyncJobService.f9733a, "onStartJob-end");
                return null;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(Void r4) {
                DataSyncJobService.this.m6622b(jobParameters, false);
            }
        };
        this.f9734b.execute(new Object[0]);
        return true;
    }

    @Override // com.firebase.jobdispatcher.JobService
    /* JADX INFO: renamed from: b */
    public boolean mo6623b(JobParameters jobParameters) {
        this.f9734b.cancel(true);
        return true;
    }
}
