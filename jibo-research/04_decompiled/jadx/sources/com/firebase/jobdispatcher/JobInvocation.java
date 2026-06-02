package com.firebase.jobdispatcher;

import android.os.Bundle;
import java.util.Arrays;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class JobInvocation implements JobParameters {

    /* JADX INFO: renamed from: a */
    private final String f5742a;

    /* JADX INFO: renamed from: b */
    private final String f5743b;

    /* JADX INFO: renamed from: c */
    private final JobTrigger f5744c;

    /* JADX INFO: renamed from: d */
    private final boolean f5745d;

    /* JADX INFO: renamed from: e */
    private final int f5746e;

    /* JADX INFO: renamed from: f */
    private final int[] f5747f;

    /* JADX INFO: renamed from: g */
    private final Bundle f5748g;

    /* JADX INFO: renamed from: h */
    private final RetryStrategy f5749h;

    /* JADX INFO: renamed from: i */
    private final boolean f5750i;

    /* JADX INFO: renamed from: j */
    private final TriggerReason f5751j;

    private JobInvocation(Builder builder) {
        this.f5742a = builder.f5752a;
        this.f5743b = builder.f5753b;
        this.f5744c = builder.f5754c;
        this.f5749h = builder.f5759h;
        this.f5745d = builder.f5755d;
        this.f5746e = builder.f5756e;
        this.f5747f = builder.f5757f;
        this.f5748g = builder.f5758g;
        this.f5750i = builder.f5760i;
        this.f5751j = builder.f5761j;
    }

    @Override // com.firebase.jobdispatcher.JobParameters
    /* JADX INFO: renamed from: i */
    public String mo6570i() {
        return this.f5743b;
    }

    @Override // com.firebase.jobdispatcher.JobParameters
    /* JADX INFO: renamed from: e */
    public String mo6566e() {
        return this.f5742a;
    }

    @Override // com.firebase.jobdispatcher.JobParameters
    /* JADX INFO: renamed from: f */
    public JobTrigger mo6567f() {
        return this.f5744c;
    }

    @Override // com.firebase.jobdispatcher.JobParameters
    /* JADX INFO: renamed from: g */
    public int mo6568g() {
        return this.f5746e;
    }

    @Override // com.firebase.jobdispatcher.JobParameters
    /* JADX INFO: renamed from: h */
    public boolean mo6569h() {
        return this.f5745d;
    }

    @Override // com.firebase.jobdispatcher.JobParameters
    /* JADX INFO: renamed from: a */
    public int[] mo6562a() {
        return this.f5747f;
    }

    @Override // com.firebase.jobdispatcher.JobParameters
    /* JADX INFO: renamed from: b */
    public Bundle mo6563b() {
        return this.f5748g;
    }

    @Override // com.firebase.jobdispatcher.JobParameters
    /* JADX INFO: renamed from: c */
    public RetryStrategy mo6564c() {
        return this.f5749h;
    }

    @Override // com.firebase.jobdispatcher.JobParameters
    /* JADX INFO: renamed from: d */
    public boolean mo6565d() {
        return this.f5750i;
    }

    static final class Builder {

        /* JADX INFO: renamed from: a */
        private String f5752a;

        /* JADX INFO: renamed from: b */
        private String f5753b;

        /* JADX INFO: renamed from: c */
        private JobTrigger f5754c;

        /* JADX INFO: renamed from: d */
        private boolean f5755d;

        /* JADX INFO: renamed from: e */
        private int f5756e;

        /* JADX INFO: renamed from: f */
        private int[] f5757f;

        /* JADX INFO: renamed from: g */
        private final Bundle f5758g = new Bundle();

        /* JADX INFO: renamed from: h */
        private RetryStrategy f5759h;

        /* JADX INFO: renamed from: i */
        private boolean f5760i;

        /* JADX INFO: renamed from: j */
        private TriggerReason f5761j;

        Builder() {
        }

        /* JADX INFO: renamed from: a */
        JobInvocation m6615a() {
            if (this.f5752a == null || this.f5753b == null || this.f5754c == null) {
                throw new IllegalArgumentException("Required fields were not populated.");
            }
            return new JobInvocation(this);
        }

        /* JADX INFO: renamed from: a */
        public Builder m6612a(String str) {
            this.f5752a = str;
            return this;
        }

        /* JADX INFO: renamed from: b */
        public Builder m6616b(String str) {
            this.f5753b = str;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m6609a(JobTrigger jobTrigger) {
            this.f5754c = jobTrigger;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m6613a(boolean z) {
            this.f5755d = z;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m6607a(int i) {
            this.f5756e = i;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m6614a(int[] iArr) {
            this.f5757f = iArr;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m6608a(Bundle bundle) {
            if (bundle != null) {
                this.f5758g.putAll(bundle);
            }
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m6610a(RetryStrategy retryStrategy) {
            this.f5759h = retryStrategy;
            return this;
        }

        /* JADX INFO: renamed from: b */
        public Builder m6617b(boolean z) {
            this.f5760i = z;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m6611a(TriggerReason triggerReason) {
            this.f5761j = triggerReason;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !getClass().equals(obj.getClass())) {
            return false;
        }
        JobInvocation jobInvocation = (JobInvocation) obj;
        return this.f5742a.equals(jobInvocation.f5742a) && this.f5743b.equals(jobInvocation.f5743b);
    }

    public int hashCode() {
        return (this.f5742a.hashCode() * 31) + this.f5743b.hashCode();
    }

    public String toString() {
        return "JobInvocation{tag='" + JSONObject.quote(this.f5742a) + "', service='" + this.f5743b + "', trigger=" + this.f5744c + ", recurring=" + this.f5745d + ", lifetime=" + this.f5746e + ", constraints=" + Arrays.toString(this.f5747f) + ", extras=" + this.f5748g + ", retryStrategy=" + this.f5749h + ", replaceCurrent=" + this.f5750i + ", triggerReason=" + this.f5751j + '}';
    }
}
