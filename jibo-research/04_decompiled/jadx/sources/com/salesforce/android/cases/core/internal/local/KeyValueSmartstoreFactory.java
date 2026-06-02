package com.salesforce.android.cases.core.internal.local;

import com.salesforce.androidsdk.accounts.UserAccount;

/* JADX INFO: loaded from: classes.dex */
public class KeyValueSmartstoreFactory {

    /* JADX INFO: renamed from: a */
    private final UserAccount f12338a;

    public KeyValueSmartstoreFactory(UserAccount userAccount) {
        this.f12338a = userAccount;
    }

    /* JADX INFO: renamed from: a */
    public KeyValueSmartstore m12373a(String str) {
        return new KeyValueSmartstore(str, this.f12338a);
    }
}
