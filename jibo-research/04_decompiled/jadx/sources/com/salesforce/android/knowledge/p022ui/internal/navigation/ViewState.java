package com.salesforce.android.knowledge.p022ui.internal.navigation;

import android.os.Bundle;
import com.salesforce.android.knowledge.p022ui.internal.ViewBinder;

/* JADX INFO: loaded from: classes.dex */
public class ViewState {

    /* JADX INFO: renamed from: a */
    private final ViewBinder f13381a;

    /* JADX INFO: renamed from: b */
    private final Bundle f13382b;

    ViewState(ViewBinder viewBinder, Bundle bundle) {
        this.f13381a = viewBinder;
        this.f13382b = bundle;
    }

    /* JADX INFO: renamed from: a */
    public ViewBinder m13652a() {
        return this.f13381a;
    }

    /* JADX INFO: renamed from: b */
    public void m13653b() {
        this.f13381a.mo13414a(this.f13382b);
    }

    /* JADX INFO: renamed from: c */
    public void m13654c() {
        this.f13381a.mo13418b(this.f13382b);
    }
}
