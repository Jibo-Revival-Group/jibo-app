package com.salesforce.android.service.common.utilities.internal.android;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* JADX INFO: loaded from: classes.dex */
public class IntentFactory {
    /* JADX INFO: renamed from: a */
    public Intent m14112a(Context context, Class<?> cls) {
        return new Intent(context, cls);
    }

    /* JADX INFO: renamed from: a */
    public IntentFilter m14113a(String str) {
        return new IntentFilter(str);
    }
}
