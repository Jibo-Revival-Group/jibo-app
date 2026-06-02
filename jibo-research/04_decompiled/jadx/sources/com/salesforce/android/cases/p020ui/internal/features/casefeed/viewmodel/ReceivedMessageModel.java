package com.salesforce.android.cases.p020ui.internal.features.casefeed.viewmodel;

import com.salesforce.android.service.common.p023ui.internal.messaging.MultiActorMessage;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class ReceivedMessageModel implements MultiActorMessage {

    /* JADX INFO: renamed from: a */
    private final String f12692a;

    /* JADX INFO: renamed from: b */
    private final String f12693b;

    /* JADX INFO: renamed from: c */
    private final String f12694c;

    /* JADX INFO: renamed from: d */
    private final Date f12695d;

    ReceivedMessageModel(String str, String str2, String str3, Date date) {
        this.f12692a = str;
        this.f12693b = str2;
        this.f12694c = str3;
        this.f12695d = date;
    }

    /* JADX INFO: renamed from: a */
    public String m12826a() {
        return this.f12692a;
    }

    /* JADX INFO: renamed from: b */
    public String m12827b() {
        return this.f12693b;
    }

    /* JADX INFO: renamed from: c */
    public String m12828c() {
        return this.f12694c;
    }

    @Override // com.salesforce.android.service.common.p023ui.internal.messaging.Message
    /* JADX INFO: renamed from: d */
    public Date mo12829d() {
        return this.f12695d;
    }

    @Override // com.salesforce.android.service.common.p023ui.internal.messaging.MultiActorMessage
    /* JADX INFO: renamed from: e */
    public String mo12830e() {
        return m12828c();
    }
}
