package com.crashlytics.android.answers;

import android.content.Context;
import com.crashlytics.android.answers.SessionEvent;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.events.EventsStorageListener;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
class AnswersEventsHandler implements EventsStorageListener {

    /* JADX INFO: renamed from: a */
    final ScheduledExecutorService f5018a;

    /* JADX INFO: renamed from: b */
    SessionAnalyticsManagerStrategy f5019b = new DisabledSessionAnalyticsManagerStrategy();

    /* JADX INFO: renamed from: c */
    private final Kit f5020c;

    /* JADX INFO: renamed from: d */
    private final Context f5021d;

    /* JADX INFO: renamed from: e */
    private final AnswersFilesManagerProvider f5022e;

    /* JADX INFO: renamed from: f */
    private final SessionMetadataCollector f5023f;

    /* JADX INFO: renamed from: g */
    private final HttpRequestFactory f5024g;

    public AnswersEventsHandler(Kit kit, Context context, AnswersFilesManagerProvider answersFilesManagerProvider, SessionMetadataCollector sessionMetadataCollector, HttpRequestFactory httpRequestFactory, ScheduledExecutorService scheduledExecutorService) {
        this.f5020c = kit;
        this.f5021d = context;
        this.f5022e = answersFilesManagerProvider;
        this.f5023f = sessionMetadataCollector;
        this.f5024g = httpRequestFactory;
        this.f5018a = scheduledExecutorService;
    }

    /* JADX INFO: renamed from: a */
    public void m5618a(SessionEvent.Builder builder) {
        m5619a(builder, false, false);
    }

    /* JADX INFO: renamed from: b */
    public void m5623b(SessionEvent.Builder builder) {
        m5619a(builder, false, true);
    }

    /* JADX INFO: renamed from: c */
    public void m5625c(SessionEvent.Builder builder) {
        m5619a(builder, true, false);
    }

    /* JADX INFO: renamed from: a */
    public void m5620a(final AnalyticsSettingsData analyticsSettingsData, final String str) {
        m5613b(new Runnable() { // from class: com.crashlytics.android.answers.AnswersEventsHandler.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AnswersEventsHandler.this.f5019b.mo5648a(analyticsSettingsData, str);
                } catch (Exception e) {
                    Fabric.m15085h().mo15073e("Answers", "Failed to set analytics settings data", e);
                }
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public void m5617a() {
        m5613b(new Runnable() { // from class: com.crashlytics.android.answers.AnswersEventsHandler.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SessionAnalyticsManagerStrategy sessionAnalyticsManagerStrategy = AnswersEventsHandler.this.f5019b;
                    AnswersEventsHandler.this.f5019b = new DisabledSessionAnalyticsManagerStrategy();
                    sessionAnalyticsManagerStrategy.mo5649b();
                } catch (Exception e) {
                    Fabric.m15085h().mo15073e("Answers", "Failed to disable events", e);
                }
            }
        });
    }

    @Override // io.fabric.sdk.android.services.events.EventsStorageListener
    /* JADX INFO: renamed from: a */
    public void mo5621a(String str) {
        m5613b(new Runnable() { // from class: com.crashlytics.android.answers.AnswersEventsHandler.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AnswersEventsHandler.this.f5019b.mo5646a();
                } catch (Exception e) {
                    Fabric.m15085h().mo15073e("Answers", "Failed to send events files", e);
                }
            }
        });
    }

    /* JADX INFO: renamed from: b */
    public void m5622b() {
        m5613b(new Runnable() { // from class: com.crashlytics.android.answers.AnswersEventsHandler.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SessionEventMetadata sessionEventMetadataM5682a = AnswersEventsHandler.this.f5023f.m5682a();
                    SessionAnalyticsFilesManager sessionAnalyticsFilesManagerM5626a = AnswersEventsHandler.this.f5022e.m5626a();
                    sessionAnalyticsFilesManagerM5626a.m15319a((EventsStorageListener) AnswersEventsHandler.this);
                    AnswersEventsHandler.this.f5019b = new EnabledSessionAnalyticsManagerStrategy(AnswersEventsHandler.this.f5020c, AnswersEventsHandler.this.f5021d, AnswersEventsHandler.this.f5018a, sessionAnalyticsFilesManagerM5626a, AnswersEventsHandler.this.f5024g, sessionEventMetadataM5682a);
                } catch (Exception e) {
                    Fabric.m15085h().mo15073e("Answers", "Failed to enable events", e);
                }
            }
        });
    }

    /* JADX INFO: renamed from: c */
    public void m5624c() {
        m5613b(new Runnable() { // from class: com.crashlytics.android.answers.AnswersEventsHandler.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AnswersEventsHandler.this.f5019b.mo5650c();
                } catch (Exception e) {
                    Fabric.m15085h().mo15073e("Answers", "Failed to flush events", e);
                }
            }
        });
    }

    /* JADX INFO: renamed from: a */
    void m5619a(final SessionEvent.Builder builder, boolean z, final boolean z2) {
        Runnable runnable = new Runnable() { // from class: com.crashlytics.android.answers.AnswersEventsHandler.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AnswersEventsHandler.this.f5019b.mo5647a(builder);
                    if (z2) {
                        AnswersEventsHandler.this.f5019b.mo5650c();
                    }
                } catch (Exception e) {
                    Fabric.m15085h().mo15073e("Answers", "Failed to process event", e);
                }
            }
        };
        if (z) {
            m5611a(runnable);
        } else {
            m5613b(runnable);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m5611a(Runnable runnable) {
        try {
            this.f5018a.submit(runnable).get();
        } catch (Exception e) {
            Fabric.m15085h().mo15073e("Answers", "Failed to run events task", e);
        }
    }

    /* JADX INFO: renamed from: b */
    private void m5613b(Runnable runnable) {
        try {
            this.f5018a.submit(runnable);
        } catch (Exception e) {
            Fabric.m15085h().mo15073e("Answers", "Failed to submit events task", e);
        }
    }
}
