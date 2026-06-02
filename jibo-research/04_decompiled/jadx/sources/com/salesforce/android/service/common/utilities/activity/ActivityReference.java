package com.salesforce.android.service.common.utilities.activity;

import android.app.Activity;
import com.salesforce.android.service.common.utilities.functional.OptionalReference;

/* JADX INFO: loaded from: classes.dex */
public class ActivityReference<T extends Activity> extends OptionalReference<T> {

    /* JADX INFO: renamed from: a */
    private static final ActivityReference<?> f13805a = new ActivityReference<>(null);

    protected ActivityReference(T t) {
        super(t);
    }

    /* JADX INFO: renamed from: a */
    public static <T extends Activity> ActivityReference<T> m14054a(T t) {
        return new ActivityReference<>(t);
    }

    /* JADX INFO: renamed from: a */
    public static <T extends Activity> ActivityReference<T> m14053a() {
        return (ActivityReference<T>) f13805a;
    }
}
