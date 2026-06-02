package com.salesforce.android.service.common.utilities.internal.device;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.salesforce.android.service.common.utilities.internal.android.IntentFactory;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.validation.Arguments;

/* JADX INFO: loaded from: classes.dex */
public class BatteryLevelTracker {

    /* JADX INFO: renamed from: a */
    private static final ServiceLogger f13861a = ServiceLogging.m14203a((Class<?>) BatteryLevelTracker.class);

    /* JADX INFO: renamed from: b */
    private final Context f13862b;

    /* JADX INFO: renamed from: c */
    private final IntentFilter f13863c;

    protected BatteryLevelTracker(Builder builder) {
        this.f13862b = builder.f13864a;
        this.f13863c = builder.f13865b.m14113a("android.intent.action.BATTERY_CHANGED");
    }

    /* JADX INFO: renamed from: a */
    public int m14142a() {
        Intent intentRegisterReceiver = this.f13862b.registerReceiver(null, this.f13863c);
        if (intentRegisterReceiver == null) {
            return 0;
        }
        int iRound = Math.round((intentRegisterReceiver.getIntExtra("level", 0) / (intentRegisterReceiver.getIntExtra("scale", -1) != 0 ? r1 : -1)) * 100.0f);
        f13861a.mo14191c("Battery level: {}", Integer.valueOf(iRound));
        return iRound;
    }

    public static class Builder {

        /* JADX INFO: renamed from: a */
        protected Context f13864a;

        /* JADX INFO: renamed from: b */
        protected IntentFactory f13865b;

        /* JADX INFO: renamed from: a */
        public Builder m14143a(Context context) {
            this.f13864a = context;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public BatteryLevelTracker m14144a() {
            Arguments.m14235a(this.f13864a);
            if (this.f13865b == null) {
                this.f13865b = new IntentFactory();
            }
            return new BatteryLevelTracker(this);
        }
    }
}
