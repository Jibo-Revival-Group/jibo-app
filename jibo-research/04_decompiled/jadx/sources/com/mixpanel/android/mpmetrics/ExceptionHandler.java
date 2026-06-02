package com.mixpanel.android.mpmetrics;

import android.os.Process;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import java.lang.Thread;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ExceptionHandler implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a */
    private static ExceptionHandler f11858a;

    /* JADX INFO: renamed from: b */
    private final Thread.UncaughtExceptionHandler f11859b = Thread.getDefaultUncaughtExceptionHandler();

    public ExceptionHandler() {
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    /* JADX INFO: renamed from: a */
    public static void m11716a() {
        if (f11858a == null) {
            synchronized (ExceptionHandler.class) {
                if (f11858a == null) {
                    f11858a = new ExceptionHandler();
                }
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, final Throwable th) {
        MixpanelAPI.m11818a(new MixpanelAPI.InstanceProcessor() { // from class: com.mixpanel.android.mpmetrics.ExceptionHandler.1
            @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.InstanceProcessor
            /* JADX INFO: renamed from: a */
            public void mo11692a(MixpanelAPI mixpanelAPI) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("$ae_crashed_reason", th.toString());
                    mixpanelAPI.m11837a("$ae_crashed", jSONObject, true);
                } catch (JSONException e) {
                }
            }
        });
        MixpanelAPI.m11818a(new MixpanelAPI.InstanceProcessor() { // from class: com.mixpanel.android.mpmetrics.ExceptionHandler.2
            @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.InstanceProcessor
            /* JADX INFO: renamed from: a */
            public void mo11692a(MixpanelAPI mixpanelAPI) {
                mixpanelAPI.m11852m();
            }
        });
        if (this.f11859b != null) {
            this.f11859b.uncaughtException(thread, th);
        } else {
            m11717b();
        }
    }

    /* JADX INFO: renamed from: b */
    private void m11717b() {
        try {
            Thread.sleep(400L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Process.killProcess(Process.myPid());
        System.exit(10);
    }
}
