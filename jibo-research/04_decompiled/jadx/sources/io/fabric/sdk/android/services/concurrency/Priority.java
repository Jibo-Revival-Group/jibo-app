package io.fabric.sdk.android.services.concurrency;

/* JADX INFO: loaded from: classes2.dex */
public enum Priority {
    LOW,
    NORMAL,
    HIGH,
    IMMEDIATE;

    static <Y> int compareTo(PriorityProvider priorityProvider, Y y) {
        Priority priorityMo5882b;
        if (y instanceof PriorityProvider) {
            priorityMo5882b = ((PriorityProvider) y).mo5882b();
        } else {
            priorityMo5882b = NORMAL;
        }
        return priorityMo5882b.ordinal() - priorityProvider.mo5882b().ordinal();
    }
}
