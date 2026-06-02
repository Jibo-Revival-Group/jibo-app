package com.salesforce.android.cases.core;

import com.salesforce.androidsdk.accounts.UserAccount;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class CaseConfiguration {

    /* JADX INFO: renamed from: a */
    private final String f12251a;

    /* JADX INFO: renamed from: b */
    private final String f12252b;

    /* JADX INFO: renamed from: c */
    private final String f12253c;

    /* JADX INFO: renamed from: d */
    private final long f12254d;

    /* JADX INFO: renamed from: e */
    private final boolean f12255e;

    /* JADX INFO: renamed from: f */
    private final boolean f12256f;

    /* JADX INFO: renamed from: g */
    private final int f12257g;

    /* JADX INFO: renamed from: h */
    private final CaseClientCallbacks f12258h;

    /* JADX INFO: renamed from: i */
    private final UserAccount f12259i;

    private CaseConfiguration(String str, String str2, String str3, long j, boolean z, boolean z2, int i, CaseClientCallbacks caseClientCallbacks, UserAccount userAccount) {
        this.f12251a = str;
        this.f12252b = str2;
        this.f12253c = str3;
        this.f12254d = j;
        this.f12255e = z;
        this.f12256f = z2;
        this.f12257g = i;
        this.f12258h = caseClientCallbacks;
        this.f12259i = userAccount;
    }

    /* JADX INFO: renamed from: a */
    public String m12176a() {
        return this.f12251a;
    }

    /* JADX INFO: renamed from: b */
    public String m12177b() {
        return this.f12252b;
    }

    /* JADX INFO: renamed from: c */
    public String m12178c() {
        return this.f12253c;
    }

    /* JADX INFO: renamed from: d */
    public boolean m12179d() {
        return this.f12255e;
    }

    /* JADX INFO: renamed from: e */
    public long m12180e() {
        return this.f12254d;
    }

    /* JADX INFO: renamed from: f */
    public boolean m12181f() {
        return this.f12256f;
    }

    /* JADX INFO: renamed from: g */
    public int m12182g() {
        return this.f12257g;
    }

    /* JADX INFO: renamed from: h */
    public CaseClientCallbacks m12183h() {
        return this.f12258h;
    }

    /* JADX INFO: renamed from: i */
    public UserAccount m12184i() {
        return this.f12259i;
    }

    public static class Builder {

        /* JADX INFO: renamed from: a */
        private final String f12260a;

        /* JADX INFO: renamed from: b */
        private final String f12261b;

        /* JADX INFO: renamed from: c */
        private String f12262c;

        /* JADX INFO: renamed from: d */
        private long f12263d = TimeUnit.DAYS.toSeconds(1);

        /* JADX INFO: renamed from: e */
        private boolean f12264e;

        /* JADX INFO: renamed from: f */
        private boolean f12265f;

        /* JADX INFO: renamed from: g */
        private int f12266g;

        /* JADX INFO: renamed from: h */
        private CaseClientCallbacks f12267h;

        /* JADX INFO: renamed from: i */
        private UserAccount f12268i;

        public Builder(String str, String str2) {
            this.f12260a = str;
            this.f12261b = str2;
        }

        /* JADX INFO: renamed from: a */
        public CaseConfiguration m12186a() {
            return new CaseConfiguration(this.f12260a, this.f12261b, this.f12262c, this.f12263d, this.f12264e, this.f12265f, this.f12266g, this.f12267h, this.f12268i);
        }

        /* JADX INFO: renamed from: a */
        public Builder m12185a(CaseClientCallbacks caseClientCallbacks) {
            this.f12267h = caseClientCallbacks;
            return this;
        }
    }
}
