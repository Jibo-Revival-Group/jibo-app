package com.firebase.jobdispatcher;

import android.text.TextUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ValidationEnforcer implements JobValidator {

    /* JADX INFO: renamed from: a */
    private final JobValidator f5793a;

    public ValidationEnforcer(JobValidator jobValidator) {
        this.f5793a = jobValidator;
    }

    @Override // com.firebase.jobdispatcher.JobValidator
    /* JADX INFO: renamed from: a */
    public List<String> mo6506a(JobParameters jobParameters) {
        return this.f5793a.mo6506a(jobParameters);
    }

    /* JADX INFO: renamed from: b */
    public final void m6645b(JobParameters jobParameters) {
        m6644a(mo6506a(jobParameters));
    }

    /* JADX INFO: renamed from: a */
    private static void m6644a(List<String> list) {
        if (list != null) {
            throw new ValidationException("JobParameters is invalid", list);
        }
    }

    public static final class ValidationException extends RuntimeException {

        /* JADX INFO: renamed from: a */
        private final List<String> f5794a;

        public ValidationException(String str, List<String> list) {
            super(str + ": " + TextUtils.join("\n  - ", list));
            this.f5794a = list;
        }
    }
}
