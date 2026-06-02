package com.google.android.gms.common;

import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public class UserRecoverableException extends Exception {

    /* JADX INFO: renamed from: a */
    private final Intent f6085a;

    public UserRecoverableException(String str, Intent intent) {
        super(str);
        this.f6085a = intent;
    }

    /* JADX INFO: renamed from: b */
    public Intent m6849b() {
        return new Intent(this.f6085a);
    }
}
