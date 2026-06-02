package com.crashlytics.android.core;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.ScrollView;
import android.widget.TextView;
import io.fabric.sdk.android.services.settings.PromptSettingsData;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
class CrashPromptDialog {

    /* JADX INFO: renamed from: a */
    private final OptInLatch f5157a;

    /* JADX INFO: renamed from: b */
    private final AlertDialog.Builder f5158b;

    interface AlwaysSendCallback {
        /* JADX INFO: renamed from: a */
        void mo5775a(boolean z);
    }

    private static class OptInLatch {

        /* JADX INFO: renamed from: a */
        private boolean f5163a;

        /* JADX INFO: renamed from: b */
        private final CountDownLatch f5164b;

        private OptInLatch() {
            this.f5163a = false;
            this.f5164b = new CountDownLatch(1);
        }

        /* JADX INFO: renamed from: a */
        void m5776a(boolean z) {
            this.f5163a = z;
            this.f5164b.countDown();
        }

        /* JADX INFO: renamed from: a */
        boolean m5777a() {
            return this.f5163a;
        }

        /* JADX INFO: renamed from: b */
        void m5778b() {
            try {
                this.f5164b.await();
            } catch (InterruptedException e) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static CrashPromptDialog m5771a(Activity activity, PromptSettingsData promptSettingsData, final AlwaysSendCallback alwaysSendCallback) {
        final OptInLatch optInLatch = new OptInLatch();
        DialogStringResolver dialogStringResolver = new DialogStringResolver(activity, promptSettingsData);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        ScrollView scrollViewM5770a = m5770a(activity, dialogStringResolver.m5907b());
        builder.setView(scrollViewM5770a).setTitle(dialogStringResolver.m5906a()).setCancelable(false).setNeutralButton(dialogStringResolver.m5908c(), new DialogInterface.OnClickListener() { // from class: com.crashlytics.android.core.CrashPromptDialog.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                optInLatch.m5776a(true);
                dialogInterface.dismiss();
            }
        });
        if (promptSettingsData.f14771d) {
            builder.setNegativeButton(dialogStringResolver.m5910e(), new DialogInterface.OnClickListener() { // from class: com.crashlytics.android.core.CrashPromptDialog.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    optInLatch.m5776a(false);
                    dialogInterface.dismiss();
                }
            });
        }
        if (promptSettingsData.f14773f) {
            builder.setPositiveButton(dialogStringResolver.m5909d(), new DialogInterface.OnClickListener() { // from class: com.crashlytics.android.core.CrashPromptDialog.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    alwaysSendCallback.mo5775a(true);
                    optInLatch.m5776a(true);
                    dialogInterface.dismiss();
                }
            });
        }
        return new CrashPromptDialog(builder, optInLatch);
    }

    /* JADX INFO: renamed from: a */
    private static ScrollView m5770a(Activity activity, String str) {
        float f = activity.getResources().getDisplayMetrics().density;
        int iM5769a = m5769a(f, 5);
        TextView textView = new TextView(activity);
        textView.setAutoLinkMask(15);
        textView.setText(str);
        textView.setTextAppearance(activity, R.style.TextAppearance.Medium);
        textView.setPadding(iM5769a, iM5769a, iM5769a, iM5769a);
        textView.setFocusable(false);
        ScrollView scrollView = new ScrollView(activity);
        scrollView.setPadding(m5769a(f, 14), m5769a(f, 2), m5769a(f, 10), m5769a(f, 12));
        scrollView.addView(textView);
        return scrollView;
    }

    /* JADX INFO: renamed from: a */
    private static int m5769a(float f, int i) {
        return (int) (i * f);
    }

    private CrashPromptDialog(AlertDialog.Builder builder, OptInLatch optInLatch) {
        this.f5157a = optInLatch;
        this.f5158b = builder;
    }

    /* JADX INFO: renamed from: a */
    public void m5772a() {
        this.f5158b.show();
    }

    /* JADX INFO: renamed from: b */
    public void m5773b() {
        this.f5157a.m5778b();
    }

    /* JADX INFO: renamed from: c */
    public boolean m5774c() {
        return this.f5157a.m5777a();
    }
}
