package com.firebase.jobdispatcher;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class JobTrigger {

    public static final class ImmediateTrigger extends JobTrigger {
        ImmediateTrigger() {
        }
    }

    public static final class ExecutionWindowTrigger extends JobTrigger {

        /* JADX INFO: renamed from: a */
        private final int f5780a;

        /* JADX INFO: renamed from: b */
        private final int f5781b;

        ExecutionWindowTrigger(int i, int i2) {
            this.f5780a = i;
            this.f5781b = i2;
        }

        /* JADX INFO: renamed from: a */
        public int m6635a() {
            return this.f5780a;
        }

        /* JADX INFO: renamed from: b */
        public int m6636b() {
            return this.f5781b;
        }
    }

    public static final class ContentUriTrigger extends JobTrigger {

        /* JADX INFO: renamed from: a */
        private final List<ObservedUri> f5779a;

        ContentUriTrigger(List<ObservedUri> list) {
            this.f5779a = list;
        }

        /* JADX INFO: renamed from: a */
        public List<ObservedUri> m6634a() {
            return this.f5779a;
        }
    }
}
