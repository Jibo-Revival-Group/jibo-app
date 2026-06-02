package com.jibo.service;

import android.os.AsyncTask;
import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;
import com.jibo.utils.LogUtils;

/* JADX INFO: loaded from: classes.dex */
public class KeysCheckerJobService extends JobService {

    /* JADX INFO: renamed from: a */
    public static final String f9748a = LogUtils.m11405a(KeysCheckerJobService.class);

    /* JADX INFO: renamed from: b */
    private AsyncTask f9749b;

    @Override // com.firebase.jobdispatcher.JobService
    /* JADX INFO: renamed from: a */
    public boolean mo6621a(final JobParameters jobParameters) {
        this.f9749b = new AsyncTask<Object, Void, Void>() { // from class: com.jibo.service.KeysCheckerJobService.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void doInBackground(Object... objArr) {
                LogUtils.m11407a(KeysCheckerJobService.f9748a, "onStartJob-start");
                KeyRequestingSharingService.m10160a(KeysCheckerJobService.this.getApplicationContext());
                LogUtils.m11407a(KeysCheckerJobService.f9748a, "onStartJob-end");
                return null;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(Void r4) {
                KeysCheckerJobService.this.m6622b(jobParameters, false);
            }
        };
        this.f9749b.execute(new Object[0]);
        return true;
    }

    @Override // com.firebase.jobdispatcher.JobService
    /* JADX INFO: renamed from: b */
    public boolean mo6623b(JobParameters jobParameters) {
        this.f9749b.cancel(true);
        return true;
    }
}
