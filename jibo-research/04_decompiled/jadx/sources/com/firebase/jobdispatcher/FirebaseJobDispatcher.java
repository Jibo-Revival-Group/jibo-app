package com.firebase.jobdispatcher;

import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.RetryStrategy;

/* JADX INFO: loaded from: classes.dex */
public final class FirebaseJobDispatcher {

    /* JADX INFO: renamed from: a */
    private final Driver f5698a;

    /* JADX INFO: renamed from: b */
    private final ValidationEnforcer f5699b;

    /* JADX INFO: renamed from: c */
    private final RetryStrategy.Builder f5700c;

    public FirebaseJobDispatcher(Driver driver) {
        this.f5698a = driver;
        this.f5699b = new ValidationEnforcer(driver.mo6512a());
        this.f5700c = new RetryStrategy.Builder(this.f5699b);
    }

    /* JADX INFO: renamed from: a */
    public int m6521a(Job job) {
        if (this.f5698a.mo6513b()) {
            return this.f5698a.mo6510a(job);
        }
        return 2;
    }

    /* JADX INFO: renamed from: a */
    public int m6522a(String str) {
        if (this.f5698a.mo6513b()) {
            return this.f5698a.mo6511a(str);
        }
        return 2;
    }

    /* JADX INFO: renamed from: a */
    public Job.Builder m6523a() {
        return new Job.Builder(this.f5699b);
    }
}
