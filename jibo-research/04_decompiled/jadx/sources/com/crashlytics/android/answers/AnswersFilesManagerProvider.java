package com.crashlytics.android.answers;

import android.content.Context;
import android.os.Looper;
import io.fabric.sdk.android.services.common.SystemCurrentTimeProvider;
import io.fabric.sdk.android.services.events.GZIPQueueFileEventStorage;
import io.fabric.sdk.android.services.persistence.FileStore;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class AnswersFilesManagerProvider {

    /* JADX INFO: renamed from: a */
    final Context f5035a;

    /* JADX INFO: renamed from: b */
    final FileStore f5036b;

    public AnswersFilesManagerProvider(Context context, FileStore fileStore) {
        this.f5035a = context;
        this.f5036b = fileStore;
    }

    /* JADX INFO: renamed from: a */
    public SessionAnalyticsFilesManager m5626a() throws IOException {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("AnswersFilesManagerProvider cannot be called on the main thread");
        }
        return new SessionAnalyticsFilesManager(this.f5035a, new SessionEventTransform(), new SystemCurrentTimeProvider(), new GZIPQueueFileEventStorage(this.f5035a, this.f5036b.mo15418a(), "session_analytics.tap", "session_analytics_to_send"));
    }
}
