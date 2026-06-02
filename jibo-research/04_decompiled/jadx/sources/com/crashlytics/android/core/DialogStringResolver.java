package com.crashlytics.android.core;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.settings.PromptSettingsData;

/* JADX INFO: loaded from: classes.dex */
class DialogStringResolver {

    /* JADX INFO: renamed from: a */
    private final Context f5262a;

    /* JADX INFO: renamed from: b */
    private final PromptSettingsData f5263b;

    public DialogStringResolver(Context context, PromptSettingsData promptSettingsData) {
        this.f5262a = context;
        this.f5263b = promptSettingsData;
    }

    /* JADX INFO: renamed from: a */
    public String m5906a() {
        return m5903a("com.crashlytics.CrashSubmissionPromptTitle", this.f5263b.f14768a);
    }

    /* JADX INFO: renamed from: b */
    public String m5907b() {
        return m5903a("com.crashlytics.CrashSubmissionPromptMessage", this.f5263b.f14769b);
    }

    /* JADX INFO: renamed from: c */
    public String m5908c() {
        return m5903a("com.crashlytics.CrashSubmissionSendTitle", this.f5263b.f14770c);
    }

    /* JADX INFO: renamed from: d */
    public String m5909d() {
        return m5903a("com.crashlytics.CrashSubmissionAlwaysSendTitle", this.f5263b.f14774g);
    }

    /* JADX INFO: renamed from: e */
    public String m5910e() {
        return m5903a("com.crashlytics.CrashSubmissionCancelTitle", this.f5263b.f14772e);
    }

    /* JADX INFO: renamed from: a */
    private String m5903a(String str, String str2) {
        return m5905b(CommonUtils.m15195b(this.f5262a, str), str2);
    }

    /* JADX INFO: renamed from: b */
    private String m5905b(String str, String str2) {
        return m5904a(str) ? str2 : str;
    }

    /* JADX INFO: renamed from: a */
    private boolean m5904a(String str) {
        return str == null || str.length() == 0;
    }
}
