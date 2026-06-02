package com.firebase.jobdispatcher;

import com.firebase.jobdispatcher.JobTrigger;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class Trigger {

    /* JADX INFO: renamed from: a */
    public static final JobTrigger.ImmediateTrigger f5791a = new JobTrigger.ImmediateTrigger();

    /* JADX INFO: renamed from: a */
    public static JobTrigger.ExecutionWindowTrigger m6643a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Window start can't be less than 0");
        }
        if (i2 < i) {
            throw new IllegalArgumentException("Window end can't be less than window start");
        }
        return new JobTrigger.ExecutionWindowTrigger(i, i2);
    }

    /* JADX INFO: renamed from: a */
    public static JobTrigger.ContentUriTrigger m6642a(List<ObservedUri> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Uris must not be null or empty.");
        }
        return new JobTrigger.ContentUriTrigger(list);
    }
}
