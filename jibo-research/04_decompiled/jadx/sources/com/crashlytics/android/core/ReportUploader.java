package com.crashlytics.android.core;

import com.facebook.appevents.AppEventsConstants;
import com.yalantis.ucrop.view.CropImageView;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.common.BackgroundPriorityRunnable;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class ReportUploader {

    /* JADX INFO: renamed from: a */
    static final Map<String, String> f5321a = Collections.singletonMap("X-CRASHLYTICS-INVALID-SESSION", AppEventsConstants.EVENT_PARAM_VALUE_YES);

    /* JADX INFO: renamed from: b */
    private static final short[] f5322b = {10, 20, 30, 60, 120, 300};

    /* JADX INFO: renamed from: c */
    private final Object f5323c = new Object();

    /* JADX INFO: renamed from: d */
    private final CreateReportSpiCall f5324d;

    /* JADX INFO: renamed from: e */
    private final String f5325e;

    /* JADX INFO: renamed from: f */
    private final ReportFilesProvider f5326f;

    /* JADX INFO: renamed from: g */
    private final HandlingExceptionCheck f5327g;

    /* JADX INFO: renamed from: h */
    private Thread f5328h;

    interface HandlingExceptionCheck {
        /* JADX INFO: renamed from: a */
        boolean mo5862a();
    }

    interface ReportFilesProvider {
        /* JADX INFO: renamed from: a */
        File[] mo5860a();

        /* JADX INFO: renamed from: b */
        File[] mo5861b();
    }

    interface SendCheck {
        /* JADX INFO: renamed from: a */
        boolean mo5859a();
    }

    static final class AlwaysSendCheck implements SendCheck {
        AlwaysSendCheck() {
        }

        @Override // com.crashlytics.android.core.ReportUploader.SendCheck
        /* JADX INFO: renamed from: a */
        public boolean mo5859a() {
            return true;
        }
    }

    public ReportUploader(String str, CreateReportSpiCall createReportSpiCall, ReportFilesProvider reportFilesProvider, HandlingExceptionCheck handlingExceptionCheck) {
        if (createReportSpiCall == null) {
            throw new IllegalArgumentException("createReportCall must not be null.");
        }
        this.f5324d = createReportSpiCall;
        this.f5325e = str;
        this.f5326f = reportFilesProvider;
        this.f5327g = handlingExceptionCheck;
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m5965a(float f, SendCheck sendCheck) {
        if (this.f5328h != null) {
            Fabric.m15085h().mo15063a("CrashlyticsCore", "Report upload has already been started.");
        } else {
            this.f5328h = new Thread(new Worker(f, sendCheck), "Crashlytics Report Uploader");
            this.f5328h.start();
        }
    }

    /* JADX INFO: renamed from: a */
    boolean m5966a(Report report) {
        boolean zMo5897a;
        boolean z = false;
        synchronized (this.f5323c) {
            try {
                zMo5897a = this.f5324d.mo5897a(new CreateReportRequest(this.f5325e, report));
                Fabric.m15085h().mo15068c("CrashlyticsCore", "Crashlytics report upload " + (zMo5897a ? "complete: " : "FAILED: ") + report.mo5915b());
            } catch (Exception e) {
                Fabric.m15085h().mo15073e("CrashlyticsCore", "Error occurred sending report " + report, e);
            }
            if (zMo5897a) {
                report.mo5919f();
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: renamed from: a */
    List<Report> m5964a() {
        File[] fileArrMo5860a;
        File[] fileArrMo5861b;
        Fabric.m15085h().mo15063a("CrashlyticsCore", "Checking for crash reports...");
        synchronized (this.f5323c) {
            fileArrMo5860a = this.f5326f.mo5860a();
            fileArrMo5861b = this.f5326f.mo5861b();
        }
        LinkedList linkedList = new LinkedList();
        if (fileArrMo5860a != null) {
            for (File file : fileArrMo5860a) {
                Fabric.m15085h().mo15063a("CrashlyticsCore", "Found crash report " + file.getPath());
                linkedList.add(new SessionReport(file));
            }
        }
        HashMap map = new HashMap();
        if (fileArrMo5861b != null) {
            for (File file2 : fileArrMo5861b) {
                String strM5783a = CrashlyticsController.m5783a(file2);
                if (!map.containsKey(strM5783a)) {
                    map.put(strM5783a, new LinkedList());
                }
                ((List) map.get(strM5783a)).add(file2);
            }
        }
        for (String str : map.keySet()) {
            Fabric.m15085h().mo15063a("CrashlyticsCore", "Found invalid session: " + str);
            List list = (List) map.get(str);
            linkedList.add(new InvalidSessionReport(str, (File[]) list.toArray(new File[list.size()])));
        }
        if (linkedList.isEmpty()) {
            Fabric.m15085h().mo15063a("CrashlyticsCore", "No reports found.");
        }
        return linkedList;
    }

    private class Worker extends BackgroundPriorityRunnable {

        /* JADX INFO: renamed from: b */
        private final float f5330b;

        /* JADX INFO: renamed from: c */
        private final SendCheck f5331c;

        Worker(float f, SendCheck sendCheck) {
            this.f5330b = f;
            this.f5331c = sendCheck;
        }

        @Override // io.fabric.sdk.android.services.common.BackgroundPriorityRunnable
        /* JADX INFO: renamed from: a */
        public void mo5968a() {
            try {
                m5967b();
            } catch (Exception e) {
                Fabric.m15085h().mo15073e("CrashlyticsCore", "An unexpected error occurred while attempting to upload crash reports.", e);
            }
            ReportUploader.this.f5328h = null;
        }

        /* JADX INFO: renamed from: b */
        private void m5967b() {
            Fabric.m15085h().mo15063a("CrashlyticsCore", "Starting report processing in " + this.f5330b + " second(s)...");
            if (this.f5330b > CropImageView.DEFAULT_ASPECT_RATIO) {
                try {
                    Thread.sleep((long) (this.f5330b * 1000.0f));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            List<Report> listM5964a = ReportUploader.this.m5964a();
            if (!ReportUploader.this.f5327g.mo5862a()) {
                if (!listM5964a.isEmpty() && !this.f5331c.mo5859a()) {
                    Fabric.m15085h().mo15063a("CrashlyticsCore", "User declined to send. Removing " + listM5964a.size() + " Report(s).");
                    Iterator<Report> it = listM5964a.iterator();
                    while (it.hasNext()) {
                        it.next().mo5919f();
                    }
                    return;
                }
                List<Report> list = listM5964a;
                int i = 0;
                while (!list.isEmpty() && !ReportUploader.this.f5327g.mo5862a()) {
                    Fabric.m15085h().mo15063a("CrashlyticsCore", "Attempting to send " + list.size() + " report(s)");
                    Iterator<Report> it2 = list.iterator();
                    while (it2.hasNext()) {
                        ReportUploader.this.m5966a(it2.next());
                    }
                    List<Report> listM5964a2 = ReportUploader.this.m5964a();
                    if (listM5964a2.isEmpty()) {
                        list = listM5964a2;
                    } else {
                        int i2 = i + 1;
                        long j = ReportUploader.f5322b[Math.min(i, ReportUploader.f5322b.length - 1)];
                        Fabric.m15085h().mo15063a("CrashlyticsCore", "Report submisson: scheduling delayed retry in " + j + " seconds");
                        try {
                            Thread.sleep(j * 1000);
                            i = i2;
                            list = listM5964a2;
                        } catch (InterruptedException e2) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                }
            }
        }
    }
}
