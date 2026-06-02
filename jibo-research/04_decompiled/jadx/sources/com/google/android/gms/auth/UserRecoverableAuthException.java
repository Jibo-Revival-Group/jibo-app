package com.google.android.gms.auth;

import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public class UserRecoverableAuthException extends GoogleAuthException {

    /* JADX INFO: renamed from: a */
    private final Intent f5857a;

    public UserRecoverableAuthException(String str, Intent intent) {
        super(str);
        this.f5857a = intent;
    }

    /* JADX INFO: renamed from: b */
    public Intent m6673b() {
        if (this.f5857a == null) {
            return null;
        }
        return new Intent(this.f5857a);
    }
}
