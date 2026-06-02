package com.salesforce.android.cases.p020ui;

import com.salesforce.android.cases.core.CaseConfiguration;

/* JADX INFO: loaded from: classes.dex */
public class CaseUIConfiguration {

    /* JADX INFO: renamed from: a */
    private final CaseConfiguration f12617a;

    /* JADX INFO: renamed from: b */
    private final int f12618b;

    private CaseUIConfiguration(CaseConfiguration caseConfiguration, int i) {
        this.f12617a = caseConfiguration;
        this.f12618b = i;
    }

    /* JADX INFO: renamed from: a */
    public static CaseUIConfiguration m12723a(CaseConfiguration caseConfiguration) {
        return m12724a(caseConfiguration, 4);
    }

    /* JADX INFO: renamed from: a */
    public static CaseUIConfiguration m12724a(CaseConfiguration caseConfiguration, int i) {
        return new CaseUIConfiguration(caseConfiguration, i);
    }

    /* JADX INFO: renamed from: a */
    public int m12725a() {
        return this.f12618b;
    }

    /* JADX INFO: renamed from: b */
    public int m12726b() {
        return m12722a(this.f12618b);
    }

    /* JADX INFO: renamed from: a */
    private int m12722a(int i) {
        switch (i) {
            case 0:
            case 1:
                return -2;
            case 2:
                return -1;
            case 3:
            default:
                return 0;
            case 4:
                return 1;
            case 5:
                return 2;
        }
    }

    /* JADX INFO: renamed from: c */
    public CaseConfiguration m12727c() {
        return this.f12617a;
    }
}
