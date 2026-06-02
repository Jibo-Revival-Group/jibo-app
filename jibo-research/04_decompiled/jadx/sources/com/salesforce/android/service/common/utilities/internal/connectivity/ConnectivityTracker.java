package com.salesforce.android.service.common.utilities.internal.connectivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import com.salesforce.android.service.common.utilities.internal.android.IntentFactory;
import com.salesforce.android.service.common.utilities.internal.connectivity.ConnectionInfo;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.validation.Arguments;

/* JADX INFO: loaded from: classes.dex */
public class ConnectivityTracker extends BroadcastReceiver {

    /* JADX INFO: renamed from: a */
    private static final ServiceLogger f13849a = ServiceLogging.m14203a((Class<?>) ConnectivityTracker.class);

    /* JADX INFO: renamed from: b */
    private final Context f13850b;

    /* JADX INFO: renamed from: c */
    private final Listener f13851c;

    /* JADX INFO: renamed from: d */
    private final ConnectivityManager f13852d;

    /* JADX INFO: renamed from: e */
    private final ConnectionInfo.Builder f13853e;

    /* JADX INFO: renamed from: f */
    private ConnectivityState f13854f;

    public interface Listener {
        /* JADX INFO: renamed from: a */
        void mo13027a(ConnectionInfo connectionInfo, ConnectivityState connectivityState, ConnectivityState connectivityState2);
    }

    protected ConnectivityTracker(Builder builder) {
        this.f13854f = ConnectivityState.UNKNOWN;
        this.f13850b = builder.f13856a;
        this.f13851c = builder.f13857b;
        this.f13852d = builder.f13859d;
        this.f13853e = builder.f13860e;
        f13849a.mo14188b("Setting up network connectivity broadcast receiver");
        this.f13850b.registerReceiver(this, builder.f13858c.m14113a("android.net.conn.CONNECTIVITY_CHANGE"));
        this.f13854f = m14135a();
    }

    /* JADX INFO: renamed from: a */
    public ConnectivityState m14135a() {
        NetworkInfo activeNetworkInfo = this.f13852d.getActiveNetworkInfo();
        return m14136a(activeNetworkInfo, this.f13853e.m14133a(activeNetworkInfo).m14134a().m14130a());
    }

    /* JADX INFO: renamed from: b */
    public ConnectionInfo m14137b() {
        return this.f13853e.m14133a(this.f13852d.getActiveNetworkInfo()).m14134a();
    }

    /* JADX INFO: renamed from: c */
    public void m14138c() {
        f13849a.mo14188b("Removing network connectivity broadcast receiver");
        this.f13850b.unregisterReceiver(this);
    }

    /* JADX INFO: renamed from: com.salesforce.android.service.common.utilities.internal.connectivity.ConnectivityTracker$1 */
    static /* synthetic */ class C16471 {

        /* JADX INFO: renamed from: a */
        static final /* synthetic */ int[] f13855a = new int[NetworkInfo.State.values().length];

        static {
            try {
                f13855a[NetworkInfo.State.DISCONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f13855a[NetworkInfo.State.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    ConnectivityState m14136a(NetworkInfo networkInfo, boolean z) {
        switch (C16471.f13855a[(networkInfo != null ? networkInfo.getState() : NetworkInfo.State.DISCONNECTED).ordinal()]) {
            case 1:
                return z ? ConnectivityState.SWITCHING : ConnectivityState.DISCONNECTED;
            case 2:
                return ConnectivityState.CONNECTED;
            default:
                return ConnectivityState.UNKNOWN;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Object obj;
        Bundle extras = intent.getExtras();
        if (extras != null && (obj = extras.get("networkInfo")) != null && (obj instanceof NetworkInfo)) {
            NetworkInfo networkInfo = (NetworkInfo) obj;
            ConnectionInfo connectionInfoM14134a = this.f13853e.m14133a(networkInfo).m14134a();
            ConnectivityState connectivityStateM14136a = m14136a(networkInfo, connectionInfoM14134a.m14130a());
            if (connectivityStateM14136a != this.f13854f) {
                ConnectivityState connectivityState = this.f13854f;
                this.f13854f = connectivityStateM14136a;
                f13849a.mo14189b("Connectivity change: {} -> {}", connectivityState.name(), this.f13854f.name());
                f13849a.mo14189b("{}", connectionInfoM14134a);
                this.f13851c.mo13027a(connectionInfoM14134a, this.f13854f, connectivityState);
            }
        }
    }

    public static class Builder {

        /* JADX INFO: renamed from: a */
        protected Context f13856a;

        /* JADX INFO: renamed from: b */
        protected Listener f13857b;

        /* JADX INFO: renamed from: c */
        protected IntentFactory f13858c;

        /* JADX INFO: renamed from: d */
        protected ConnectivityManager f13859d;

        /* JADX INFO: renamed from: e */
        protected ConnectionInfo.Builder f13860e;

        /* JADX INFO: renamed from: a */
        public Builder m14139a(Context context) {
            this.f13856a = context;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m14140a(Listener listener) {
            this.f13857b = listener;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public ConnectivityTracker m14141a() {
            Arguments.m14235a(this.f13856a);
            Arguments.m14235a(this.f13857b);
            if (this.f13859d == null) {
                this.f13859d = (ConnectivityManager) this.f13856a.getSystemService("connectivity");
            }
            if (this.f13858c == null) {
                this.f13858c = new IntentFactory();
            }
            if (this.f13860e == null) {
                this.f13860e = new ConnectionInfo.Builder();
            }
            return new ConnectivityTracker(this);
        }
    }
}
