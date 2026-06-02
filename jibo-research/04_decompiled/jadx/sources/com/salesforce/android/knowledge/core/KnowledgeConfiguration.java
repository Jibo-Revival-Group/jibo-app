package com.salesforce.android.knowledge.core;

import com.salesforce.android.knowledge.core.offline.OfflineResourceConfig;
import com.salesforce.android.knowledge.core.util.LanguageManager;
import com.salesforce.androidsdk.accounts.UserAccount;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class KnowledgeConfiguration {

    /* JADX INFO: renamed from: a */
    private final String f12873a;

    /* JADX INFO: renamed from: b */
    private final OfflineResourceConfig f12874b;

    /* JADX INFO: renamed from: c */
    private final String f12875c;

    /* JADX INFO: renamed from: d */
    private final String f12876d;

    /* JADX INFO: renamed from: e */
    private final UserAccount f12877e;

    /* JADX INFO: renamed from: a */
    public static KnowledgeConfiguration m13073a(String str) {
        return m13074b(str).m13080a();
    }

    /* JADX INFO: renamed from: b */
    public static Builder m13074b(String str) {
        return new Builder(str);
    }

    KnowledgeConfiguration(Builder builder) {
        this.f12873a = builder.f12878a;
        this.f12874b = builder.f12879b;
        this.f12875c = builder.f12880c;
        this.f12876d = builder.f12881d;
        this.f12877e = builder.f12882e;
    }

    /* JADX INFO: renamed from: a */
    public String m13075a() {
        return this.f12873a;
    }

    /* JADX INFO: renamed from: b */
    public OfflineResourceConfig m13076b() {
        return this.f12874b;
    }

    /* JADX INFO: renamed from: c */
    public String m13077c() {
        return this.f12875c;
    }

    /* JADX INFO: renamed from: d */
    public String m13078d() {
        return this.f12876d;
    }

    /* JADX INFO: renamed from: e */
    public UserAccount m13079e() {
        return this.f12877e;
    }

    public static class Builder {

        /* JADX INFO: renamed from: a */
        final String f12878a;

        /* JADX INFO: renamed from: b */
        OfflineResourceConfig f12879b;

        /* JADX INFO: renamed from: c */
        String f12880c = LanguageManager.m13339a(Locale.US);

        /* JADX INFO: renamed from: d */
        String f12881d;

        /* JADX INFO: renamed from: e */
        UserAccount f12882e;

        Builder(String str) {
            this.f12878a = str;
            this.f12881d = LanguageManager.m13340b(Locale.getDefault()) ? LanguageManager.m13339a(Locale.getDefault()) : this.f12880c;
        }

        /* JADX INFO: renamed from: a */
        public KnowledgeConfiguration m13080a() {
            if (this.f12879b == null) {
                this.f12879b = OfflineResourceConfig.m13296a();
            }
            return new KnowledgeConfiguration(this);
        }
    }
}
