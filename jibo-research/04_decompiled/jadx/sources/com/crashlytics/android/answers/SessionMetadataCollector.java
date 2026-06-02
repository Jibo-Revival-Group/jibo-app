package com.crashlytics.android.answers;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.IdManager;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
class SessionMetadataCollector {

    /* JADX INFO: renamed from: a */
    private final Context f5104a;

    /* JADX INFO: renamed from: b */
    private final IdManager f5105b;

    /* JADX INFO: renamed from: c */
    private final String f5106c;

    /* JADX INFO: renamed from: d */
    private final String f5107d;

    public SessionMetadataCollector(Context context, IdManager idManager, String str, String str2) {
        this.f5104a = context;
        this.f5105b = idManager;
        this.f5106c = str;
        this.f5107d = str2;
    }

    /* JADX INFO: renamed from: a */
    public SessionEventMetadata m5682a() {
        Map<IdManager.DeviceIdentifierType, String> mapM15233i = this.f5105b.m15233i();
        return new SessionEventMetadata(this.f5105b.m15227c(), UUID.randomUUID().toString(), this.f5105b.m15226b(), mapM15233i.get(IdManager.DeviceIdentifierType.ANDROID_ID), mapM15233i.get(IdManager.DeviceIdentifierType.ANDROID_ADVERTISING_ID), this.f5105b.m15236l(), mapM15233i.get(IdManager.DeviceIdentifierType.FONT_TOKEN), CommonUtils.m15210m(this.f5104a), this.f5105b.m15228d(), this.f5105b.m15231g(), this.f5106c, this.f5107d);
    }
}
