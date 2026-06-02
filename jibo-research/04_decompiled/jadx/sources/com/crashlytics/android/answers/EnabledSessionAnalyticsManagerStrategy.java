package com.crashlytics.android.answers;

import android.content.Context;
import com.crashlytics.android.answers.SessionEvent;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.common.ApiKey;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.events.FilesSender;
import io.fabric.sdk.android.services.events.TimeBasedFileRollOverRunnable;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
class EnabledSessionAnalyticsManagerStrategy implements SessionAnalyticsManagerStrategy {

    /* JADX INFO: renamed from: a */
    final SessionEventMetadata f5048a;

    /* JADX INFO: renamed from: b */
    FilesSender f5049b;

    /* JADX INFO: renamed from: h */
    private final Kit f5055h;

    /* JADX INFO: renamed from: i */
    private final HttpRequestFactory f5056i;

    /* JADX INFO: renamed from: j */
    private final Context f5057j;

    /* JADX INFO: renamed from: k */
    private final SessionAnalyticsFilesManager f5058k;

    /* JADX INFO: renamed from: l */
    private final ScheduledExecutorService f5059l;

    /* JADX INFO: renamed from: m */
    private final AtomicReference<ScheduledFuture<?>> f5060m = new AtomicReference<>();

    /* JADX INFO: renamed from: c */
    ApiKey f5050c = new ApiKey();

    /* JADX INFO: renamed from: d */
    EventFilter f5051d = new KeepAllEventFilter();

    /* JADX INFO: renamed from: e */
    boolean f5052e = true;

    /* JADX INFO: renamed from: f */
    boolean f5053f = true;

    /* JADX INFO: renamed from: g */
    volatile int f5054g = -1;

    public EnabledSessionAnalyticsManagerStrategy(Kit kit, Context context, ScheduledExecutorService scheduledExecutorService, SessionAnalyticsFilesManager sessionAnalyticsFilesManager, HttpRequestFactory httpRequestFactory, SessionEventMetadata sessionEventMetadata) {
        this.f5055h = kit;
        this.f5057j = context;
        this.f5059l = scheduledExecutorService;
        this.f5058k = sessionAnalyticsFilesManager;
        this.f5056i = httpRequestFactory;
        this.f5048a = sessionEventMetadata;
    }

    @Override // com.crashlytics.android.answers.SessionAnalyticsManagerStrategy
    /* JADX INFO: renamed from: a */
    public void mo5648a(AnalyticsSettingsData analyticsSettingsData, String str) {
        this.f5049b = AnswersRetryFilesSender.m5637a(new SessionAnalyticsFilesSender(this.f5055h, str, analyticsSettingsData.f14721a, this.f5056i, this.f5050c.m15165a(this.f5057j)));
        this.f5058k.m5661a(analyticsSettingsData);
        this.f5052e = analyticsSettingsData.f14726f;
        Fabric.m15085h().mo15063a("Answers", "Custom event tracking " + (this.f5052e ? "enabled" : "disabled"));
        this.f5053f = analyticsSettingsData.f14727g;
        Fabric.m15085h().mo15063a("Answers", "Predefined event tracking " + (this.f5053f ? "enabled" : "disabled"));
        if (analyticsSettingsData.f14729i > 1) {
            Fabric.m15085h().mo15063a("Answers", "Event sampling enabled");
            this.f5051d = new SamplingEventFilter(analyticsSettingsData.f14729i);
        }
        this.f5054g = analyticsSettingsData.f14722b;
        m5652a(0L, this.f5054g);
    }

    @Override // com.crashlytics.android.answers.SessionAnalyticsManagerStrategy
    /* JADX INFO: renamed from: a */
    public void mo5647a(SessionEvent.Builder builder) {
        SessionEvent sessionEventM5678a = builder.m5678a(this.f5048a);
        if (!this.f5052e && SessionEvent.Type.CUSTOM.equals(sessionEventM5678a.f5077c)) {
            Fabric.m15085h().mo15063a("Answers", "Custom events tracking disabled - skipping event: " + sessionEventM5678a);
            return;
        }
        if (!this.f5053f && SessionEvent.Type.PREDEFINED.equals(sessionEventM5678a.f5077c)) {
            Fabric.m15085h().mo15063a("Answers", "Predefined events tracking disabled - skipping event: " + sessionEventM5678a);
            return;
        }
        if (this.f5051d.mo5654a(sessionEventM5678a)) {
            Fabric.m15085h().mo15063a("Answers", "Skipping filtered event: " + sessionEventM5678a);
            return;
        }
        try {
            this.f5058k.m15320a(sessionEventM5678a);
        } catch (IOException e) {
            Fabric.m15085h().mo15073e("Answers", "Failed to write event: " + sessionEventM5678a, e);
        }
        m5653e();
    }

    /* JADX INFO: renamed from: e */
    public void m5653e() {
        if (this.f5054g != -1) {
            m5652a(this.f5054g, this.f5054g);
        }
    }

    @Override // com.crashlytics.android.answers.SessionAnalyticsManagerStrategy
    /* JADX INFO: renamed from: a */
    public void mo5646a() {
        int size;
        Exception e;
        if (this.f5049b == null) {
            CommonUtils.m15185a(this.f5057j, "skipping files send because we don't yet know the target endpoint");
            return;
        }
        CommonUtils.m15185a(this.f5057j, "Sending all files");
        List<File> listE = this.f5058k.m15323e();
        int i = 0;
        while (listE.size() > 0) {
            try {
                CommonUtils.m15185a(this.f5057j, String.format(Locale.US, "attempt to send batch of %d files", Integer.valueOf(listE.size())));
                boolean zMo5638a = this.f5049b.mo5638a(listE);
                if (zMo5638a) {
                    size = listE.size() + i;
                    try {
                        this.f5058k.m15321a(listE);
                        i = size;
                    } catch (Exception e2) {
                        e = e2;
                        CommonUtils.m15186a(this.f5057j, "Failed to send batch of analytics files to server: " + e.getMessage(), e);
                        i = size;
                    }
                }
                if (!zMo5638a) {
                    break;
                } else {
                    listE = this.f5058k.m15323e();
                }
            } catch (Exception e3) {
                size = i;
                e = e3;
            }
        }
        if (i == 0) {
            this.f5058k.m15325g();
        }
    }

    @Override // io.fabric.sdk.android.services.events.FileRollOverManager
    /* JADX INFO: renamed from: d */
    public void mo5651d() {
        if (this.f5060m.get() != null) {
            CommonUtils.m15185a(this.f5057j, "Cancelling time-based rollover because no events are currently being generated.");
            this.f5060m.get().cancel(false);
            this.f5060m.set(null);
        }
    }

    @Override // com.crashlytics.android.answers.SessionAnalyticsManagerStrategy
    /* JADX INFO: renamed from: b */
    public void mo5649b() {
        this.f5058k.m15324f();
    }

    @Override // io.fabric.sdk.android.services.events.FileRollOverManager
    /* JADX INFO: renamed from: c */
    public boolean mo5650c() {
        try {
            return this.f5058k.m15322d();
        } catch (IOException e) {
            CommonUtils.m15186a(this.f5057j, "Failed to roll file over.", e);
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    void m5652a(long j, long j2) {
        if (this.f5060m.get() == null) {
            TimeBasedFileRollOverRunnable timeBasedFileRollOverRunnable = new TimeBasedFileRollOverRunnable(this.f5057j, this);
            CommonUtils.m15185a(this.f5057j, "Scheduling time based file roll over every " + j2 + " seconds");
            try {
                this.f5060m.set(this.f5059l.scheduleAtFixedRate(timeBasedFileRollOverRunnable, j, j2, TimeUnit.SECONDS));
            } catch (RejectedExecutionException e) {
                CommonUtils.m15186a(this.f5057j, "Failed to schedule time based file roll over", e);
            }
        }
    }
}
