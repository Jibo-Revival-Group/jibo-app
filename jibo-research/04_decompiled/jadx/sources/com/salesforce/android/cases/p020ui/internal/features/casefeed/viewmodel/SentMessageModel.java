package com.salesforce.android.cases.p020ui.internal.features.casefeed.viewmodel;

import com.salesforce.android.service.common.p023ui.internal.messaging.Message;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class SentMessageModel implements Message {

    /* JADX INFO: renamed from: a */
    private final String f12696a;

    /* JADX INFO: renamed from: b */
    private final Date f12697b;

    public SentMessageModel(String str, Date date) {
        this.f12696a = str;
        this.f12697b = date;
    }

    /* JADX INFO: renamed from: a */
    public String m12831a() {
        return this.f12696a;
    }

    @Override // com.salesforce.android.service.common.p023ui.internal.messaging.Message
    /* JADX INFO: renamed from: d */
    public Date mo12829d() {
        return this.f12697b;
    }
}
