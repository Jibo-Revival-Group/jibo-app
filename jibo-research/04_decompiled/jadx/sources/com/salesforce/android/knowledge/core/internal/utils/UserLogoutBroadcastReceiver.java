package com.salesforce.android.knowledge.core.internal.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.salesforce.android.knowledge.core.LogoutListener;
import com.salesforce.android.service.common.http.HttpClient;
import com.salesforce.android.service.common.http.okhttp.SalesforceOkHttpClient;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.smartstore.app.SmartStoreSDKManager;
import com.salesforce.androidsdk.smartstore.store.SmartStore;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class UserLogoutBroadcastReceiver extends BroadcastReceiver implements MobileSdkUserManager {

    /* JADX INFO: renamed from: b */
    private static final ServiceLogger f13002b = ServiceLogging.m14203a((Class<?>) UserLogoutBroadcastReceiver.class);

    /* JADX INFO: renamed from: a */
    private final SmartStoreSDKManager f13003a;

    /* JADX INFO: renamed from: c */
    private UserAccount f13004c;

    /* JADX INFO: renamed from: d */
    private SmartStore f13005d;

    /* JADX INFO: renamed from: e */
    private HttpClient f13006e;

    /* JADX INFO: renamed from: f */
    private final List<LogoutListener> f13007f = new ArrayList();

    protected UserLogoutBroadcastReceiver(Builder builder) {
        this.f13003a = builder.m13282b();
        if (builder.m13281a() != null && m13278a(builder.m13281a())) {
            this.f13004c = builder.m13281a();
            builder.m13283c().registerReceiver(this, new IntentFilter("com.salesforce.USERSWITCHED"));
            builder.m13283c().registerReceiver(this, new IntentFilter("com.salesforce.LOGOUT_COMPLETE"));
        }
        m13277a(this.f13004c != null);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getAction().equals("com.salesforce.LOGOUT_COMPLETE")) {
            m13279d();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m13280a(Context context) {
        if (this.f13004c != null) {
            context.unregisterReceiver(this);
            this.f13004c = null;
            this.f13007f.clear();
        }
    }

    @Override // com.salesforce.android.knowledge.core.internal.utils.MobileSdkUserManager
    /* JADX INFO: renamed from: a */
    public void mo13274a(LogoutListener logoutListener) {
        this.f13007f.add(logoutListener);
    }

    @Override // com.salesforce.android.knowledge.core.internal.utils.MobileSdkUserManager
    /* JADX INFO: renamed from: c */
    public void mo13276c() {
        if (m13278a(this.f13004c)) {
            this.f13003a.m14670c(this.f13004c);
        } else {
            this.f13003a.m14672h("anonymous");
        }
    }

    @Override // com.salesforce.android.knowledge.core.internal.utils.MobileSdkUserManager
    /* JADX INFO: renamed from: a */
    public SmartStore mo13273a() {
        return this.f13005d;
    }

    @Override // com.salesforce.android.knowledge.core.internal.utils.MobileSdkUserManager
    /* JADX INFO: renamed from: b */
    public HttpClient mo13275b() {
        return this.f13006e;
    }

    /* JADX INFO: renamed from: d */
    private void m13279d() {
        boolean zM13278a = m13278a(this.f13004c);
        if (this.f13004c != null && !zM13278a) {
            this.f13004c = null;
            m13277a(false);
            Iterator<LogoutListener> it = this.f13007f.iterator();
            while (it.hasNext()) {
                it.next().mo13084a();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m13278a(UserAccount userAccount) {
        List<UserAccount> listM14277d;
        return (userAccount == null || (listM14277d = this.f13003a.m14450o().m14277d()) == null || !listM14277d.contains(userAccount)) ? false : true;
    }

    /* JADX INFO: renamed from: a */
    private void m13277a(boolean z) {
        if (z) {
            f13002b.mo14188b("Setting up authenticated Kb access.");
            this.f13006e = SalesforceOkHttpClient.m13785a(this.f13003a.m14423E().m14561a(this.f13004c).m14602d());
            this.f13005d = this.f13003a.m14667b(this.f13004c);
        } else {
            f13002b.mo14188b("Setting up unauthenticated Kb access.");
            this.f13006e = SalesforceOkHttpClient.m13785a(this.f13003a.m14423E().m14559a().m14602d());
            this.f13005d = this.f13003a.m14671g("anonymous");
        }
    }

    public static class Builder {

        /* JADX INFO: renamed from: a */
        private final UserAccount f13008a;

        /* JADX INFO: renamed from: b */
        private SmartStoreSDKManager f13009b;

        /* JADX INFO: renamed from: c */
        private final Context f13010c;

        public Builder(Context context, UserAccount userAccount) {
            this.f13008a = userAccount;
            this.f13010c = context;
        }

        /* JADX INFO: renamed from: a */
        public UserAccount m13281a() {
            return this.f13008a;
        }

        /* JADX INFO: renamed from: b */
        public SmartStoreSDKManager m13282b() {
            return this.f13009b;
        }

        /* JADX INFO: renamed from: c */
        public Context m13283c() {
            return this.f13010c;
        }

        /* JADX INFO: renamed from: d */
        public UserLogoutBroadcastReceiver m13284d() {
            if (this.f13009b == null) {
                this.f13009b = SmartStoreSDKManager.m14661H();
            }
            return new UserLogoutBroadcastReceiver(this);
        }
    }
}
