package com.firebase.jobdispatcher;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class Job implements JobParameters {

    /* JADX INFO: renamed from: a */
    private final String f5722a;

    /* JADX INFO: renamed from: b */
    private final String f5723b;

    /* JADX INFO: renamed from: c */
    private final JobTrigger f5724c;

    /* JADX INFO: renamed from: d */
    private final RetryStrategy f5725d;

    /* JADX INFO: renamed from: e */
    private final int f5726e;

    /* JADX INFO: renamed from: f */
    private final boolean f5727f;

    /* JADX INFO: renamed from: g */
    private final int[] f5728g;

    /* JADX INFO: renamed from: h */
    private final boolean f5729h;

    /* JADX INFO: renamed from: i */
    private final Bundle f5730i;

    private Job(Builder builder) {
        int[] iArr;
        this.f5722a = builder.f5732b;
        this.f5730i = builder.f5733c == null ? null : new Bundle(builder.f5733c);
        this.f5723b = builder.f5734d;
        this.f5724c = builder.f5735e;
        this.f5725d = builder.f5738h;
        this.f5726e = builder.f5736f;
        this.f5727f = builder.f5740j;
        if (builder.f5737g == null) {
            iArr = new int[0];
        } else {
            iArr = builder.f5737g;
        }
        this.f5728g = iArr;
        this.f5729h = builder.f5739i;
    }

    @Override // com.firebase.jobdispatcher.JobParameters
    /* JADX INFO: renamed from: a */
    public int[] mo6562a() {
        return this.f5728g;
    }

    @Override // com.firebase.jobdispatcher.JobParameters
    /* JADX INFO: renamed from: b */
    public Bundle mo6563b() {
        return this.f5730i;
    }

    @Override // com.firebase.jobdispatcher.JobParameters
    /* JADX INFO: renamed from: c */
    public RetryStrategy mo6564c() {
        return this.f5725d;
    }

    @Override // com.firebase.jobdispatcher.JobParameters
    /* JADX INFO: renamed from: d */
    public boolean mo6565d() {
        return this.f5729h;
    }

    @Override // com.firebase.jobdispatcher.JobParameters
    /* JADX INFO: renamed from: e */
    public String mo6566e() {
        return this.f5723b;
    }

    @Override // com.firebase.jobdispatcher.JobParameters
    /* JADX INFO: renamed from: f */
    public JobTrigger mo6567f() {
        return this.f5724c;
    }

    @Override // com.firebase.jobdispatcher.JobParameters
    /* JADX INFO: renamed from: g */
    public int mo6568g() {
        return this.f5726e;
    }

    @Override // com.firebase.jobdispatcher.JobParameters
    /* JADX INFO: renamed from: h */
    public boolean mo6569h() {
        return this.f5727f;
    }

    @Override // com.firebase.jobdispatcher.JobParameters
    /* JADX INFO: renamed from: i */
    public String mo6570i() {
        return this.f5722a;
    }

    public static final class Builder implements JobParameters {

        /* JADX INFO: renamed from: a */
        private final ValidationEnforcer f5731a;

        /* JADX INFO: renamed from: b */
        private String f5732b;

        /* JADX INFO: renamed from: c */
        private Bundle f5733c;

        /* JADX INFO: renamed from: d */
        private String f5734d;

        /* JADX INFO: renamed from: e */
        private JobTrigger f5735e;

        /* JADX INFO: renamed from: f */
        private int f5736f;

        /* JADX INFO: renamed from: g */
        private int[] f5737g;

        /* JADX INFO: renamed from: h */
        private RetryStrategy f5738h;

        /* JADX INFO: renamed from: i */
        private boolean f5739i;

        /* JADX INFO: renamed from: j */
        private boolean f5740j;

        Builder(ValidationEnforcer validationEnforcer) {
            this.f5735e = Trigger.f5791a;
            this.f5736f = 1;
            this.f5738h = RetryStrategy.f5784a;
            this.f5739i = false;
            this.f5740j = false;
            this.f5731a = validationEnforcer;
        }

        Builder(ValidationEnforcer validationEnforcer, JobParameters jobParameters) {
            this.f5735e = Trigger.f5791a;
            this.f5736f = 1;
            this.f5738h = RetryStrategy.f5784a;
            this.f5739i = false;
            this.f5740j = false;
            this.f5731a = validationEnforcer;
            this.f5734d = jobParameters.mo6566e();
            this.f5732b = jobParameters.mo6570i();
            this.f5735e = jobParameters.mo6567f();
            this.f5740j = jobParameters.mo6569h();
            this.f5736f = jobParameters.mo6568g();
            this.f5737g = jobParameters.mo6562a();
            this.f5733c = jobParameters.mo6563b();
            this.f5738h = jobParameters.mo6564c();
        }

        /* JADX INFO: renamed from: a */
        public Builder m6584a(boolean z) {
            this.f5739i = z;
            return this;
        }

        /* JADX INFO: renamed from: j */
        public Job m6587j() {
            this.f5731a.m6645b(this);
            return new Job(this);
        }

        @Override // com.firebase.jobdispatcher.JobParameters
        /* JADX INFO: renamed from: i */
        public String mo6570i() {
            return this.f5732b;
        }

        /* JADX INFO: renamed from: a */
        public Builder m6582a(Class<? extends JobService> cls) {
            this.f5732b = cls == null ? null : cls.getName();
            return this;
        }

        @Override // com.firebase.jobdispatcher.JobParameters
        /* JADX INFO: renamed from: e */
        public String mo6566e() {
            return this.f5734d;
        }

        /* JADX INFO: renamed from: a */
        public Builder m6583a(String str) {
            this.f5734d = str;
            return this;
        }

        @Override // com.firebase.jobdispatcher.JobParameters
        /* JADX INFO: renamed from: f */
        public JobTrigger mo6567f() {
            return this.f5735e;
        }

        /* JADX INFO: renamed from: a */
        public Builder m6581a(JobTrigger jobTrigger) {
            this.f5735e = jobTrigger;
            return this;
        }

        @Override // com.firebase.jobdispatcher.JobParameters
        /* JADX INFO: renamed from: g */
        public int mo6568g() {
            return this.f5736f;
        }

        /* JADX INFO: renamed from: a */
        public Builder m6580a(int i) {
            this.f5736f = i;
            return this;
        }

        @Override // com.firebase.jobdispatcher.JobParameters
        /* JADX INFO: renamed from: h */
        public boolean mo6569h() {
            return this.f5740j;
        }

        /* JADX INFO: renamed from: b */
        public Builder m6586b(boolean z) {
            this.f5740j = z;
            return this;
        }

        @Override // com.firebase.jobdispatcher.JobParameters
        /* JADX INFO: renamed from: a */
        public int[] mo6562a() {
            return this.f5737g == null ? new int[0] : this.f5737g;
        }

        /* JADX INFO: renamed from: a */
        public Builder m6585a(int... iArr) {
            this.f5737g = iArr;
            return this;
        }

        @Override // com.firebase.jobdispatcher.JobParameters
        /* JADX INFO: renamed from: b */
        public Bundle mo6563b() {
            return this.f5733c;
        }

        @Override // com.firebase.jobdispatcher.JobParameters
        /* JADX INFO: renamed from: c */
        public RetryStrategy mo6564c() {
            return this.f5738h;
        }

        @Override // com.firebase.jobdispatcher.JobParameters
        /* JADX INFO: renamed from: d */
        public boolean mo6565d() {
            return this.f5739i;
        }
    }
}
