package com.google.android.gms.common;

import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public class GooglePlayServicesRepairableException extends UserRecoverableException {

    /* JADX INFO: renamed from: a */
    private final int f6078a;

    public GooglePlayServicesRepairableException(int i, String str, Intent intent) {
        super(str, intent);
        this.f6078a = i;
    }

    /* JADX INFO: renamed from: a */
    public int m6846a() {
        return this.f6078a;
    }
}
