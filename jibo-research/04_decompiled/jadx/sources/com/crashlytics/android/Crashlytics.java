package com.crashlytics.android;

import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.beta.Beta;
import com.crashlytics.android.core.CrashlyticsCore;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.KitGroup;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class Crashlytics extends Kit<Void> implements KitGroup {

    /* JADX INFO: renamed from: a */
    public final Answers f5013a;

    /* JADX INFO: renamed from: b */
    public final Beta f5014b;

    /* JADX INFO: renamed from: c */
    public final CrashlyticsCore f5015c;

    /* JADX INFO: renamed from: d */
    public final Collection<? extends Kit> f5016d;

    public Crashlytics() {
        this(new Answers(), new Beta(), new CrashlyticsCore());
    }

    Crashlytics(Answers answers, Beta beta, CrashlyticsCore crashlyticsCore) {
        this.f5013a = answers;
        this.f5014b = beta;
        this.f5015c = crashlyticsCore;
        this.f5016d = Collections.unmodifiableCollection(Arrays.asList(answers, beta, crashlyticsCore));
    }

    @Override // io.fabric.sdk.android.Kit
    /* JADX INFO: renamed from: a */
    public String mo5600a() {
        return "2.6.8.dev";
    }

    @Override // io.fabric.sdk.android.Kit
    /* JADX INFO: renamed from: b */
    public String mo5601b() {
        return "com.crashlytics.sdk.android:crashlytics";
    }

    @Override // io.fabric.sdk.android.KitGroup
    /* JADX INFO: renamed from: c */
    public Collection<? extends Kit> mo5602c() {
        return this.f5016d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.fabric.sdk.android.Kit
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Void mo5604f() {
        return null;
    }

    /* JADX INFO: renamed from: e */
    public static Crashlytics m5598e() {
        return (Crashlytics) Fabric.m15076a(Crashlytics.class);
    }

    /* JADX INFO: renamed from: a */
    public static void m5597a(Throwable th) {
        m5599g();
        m5598e().f5015c.m5869a(th);
    }

    /* JADX INFO: renamed from: g */
    private static void m5599g() {
        if (m5598e() == null) {
            throw new IllegalStateException("Crashlytics must be initialized by calling Fabric.with(Context) prior to calling Crashlytics.getInstance()");
        }
    }
}
