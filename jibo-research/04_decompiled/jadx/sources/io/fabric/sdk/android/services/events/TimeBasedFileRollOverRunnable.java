package io.fabric.sdk.android.services.events;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;

/* JADX INFO: loaded from: classes2.dex */
public class TimeBasedFileRollOverRunnable implements Runnable {

    /* JADX INFO: renamed from: a */
    private final Context f14681a;

    /* JADX INFO: renamed from: b */
    private final FileRollOverManager f14682b;

    public TimeBasedFileRollOverRunnable(Context context, FileRollOverManager fileRollOverManager) {
        this.f14681a = context;
        this.f14682b = fileRollOverManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            CommonUtils.m15185a(this.f14681a, "Performing time based file roll over.");
            if (!this.f14682b.mo5650c()) {
                this.f14682b.mo5651d();
            }
        } catch (Exception e) {
            CommonUtils.m15186a(this.f14681a, "Failed to roll over file", e);
        }
    }
}
