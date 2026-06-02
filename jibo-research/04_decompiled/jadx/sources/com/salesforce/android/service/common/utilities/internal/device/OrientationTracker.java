package com.salesforce.android.service.common.utilities.internal.device;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.salesforce.android.service.common.utilities.internal.android.IntentFactory;
import com.salesforce.android.service.common.utilities.spatial.Orientation;
import com.salesforce.android.service.common.utilities.validation.Arguments;

/* JADX INFO: loaded from: classes.dex */
public class OrientationTracker extends BroadcastReceiver {

    /* JADX INFO: renamed from: a */
    private final Context f13881a;

    /* JADX INFO: renamed from: b */
    private final Listener f13882b;

    public interface Listener {
        /* JADX INFO: renamed from: a */
        void mo13028a(Orientation orientation);
    }

    protected OrientationTracker(Builder builder) {
        this.f13881a = builder.f13883a;
        this.f13882b = builder.f13884b;
        this.f13881a.registerReceiver(this, builder.f13885c.m14113a("android.intent.action.CONFIGURATION_CHANGED"));
    }

    /* JADX INFO: renamed from: a */
    public void m14157a() {
        this.f13881a.unregisterReceiver(this);
    }

    /* JADX INFO: renamed from: b */
    public Orientation m14158b() {
        return this.f13881a.getResources().getConfiguration().orientation == 1 ? Orientation.f13925e : Orientation.f13926f;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.CONFIGURATION_CHANGED")) {
            this.f13882b.mo13028a(m14158b());
        }
    }

    public static class Builder {

        /* JADX INFO: renamed from: a */
        protected Context f13883a;

        /* JADX INFO: renamed from: b */
        protected Listener f13884b;

        /* JADX INFO: renamed from: c */
        protected IntentFactory f13885c;

        /* JADX INFO: renamed from: a */
        public Builder m14159a(Context context) {
            this.f13883a = context;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m14160a(Listener listener) {
            this.f13884b = listener;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public OrientationTracker m14161a() {
            Arguments.m14235a(this.f13883a);
            Arguments.m14235a(this.f13884b);
            if (this.f13885c == null) {
                this.f13885c = new IntentFactory();
            }
            return new OrientationTracker(this);
        }
    }
}
