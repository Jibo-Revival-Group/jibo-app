package com.google.android.gms.auth;

import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public class GooglePlayServicesAvailabilityException extends UserRecoverableAuthException {

    /* JADX INFO: renamed from: a */
    private final int f5850a;

    GooglePlayServicesAvailabilityException(int i, String str, Intent intent) {
        super(str, intent);
        this.f5850a = i;
    }

    /* JADX INFO: renamed from: a */
    public int m6670a() {
        return this.f5850a;
    }
}
