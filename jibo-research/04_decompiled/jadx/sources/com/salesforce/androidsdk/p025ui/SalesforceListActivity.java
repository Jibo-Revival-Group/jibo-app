package com.salesforce.androidsdk.p025ui;

import android.app.Activity;
import android.app.ListActivity;
import android.content.IntentFilter;
import android.os.Bundle;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.rest.ClientManager;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.security.PasscodeManager;
import com.salesforce.androidsdk.util.EventsObservable;
import com.salesforce.androidsdk.util.LogoutCompleteReceiver;
import com.salesforce.androidsdk.util.UserSwitchReceiver;

/* JADX INFO: loaded from: classes.dex */
public abstract class SalesforceListActivity extends ListActivity {

    /* JADX INFO: renamed from: a */
    private PasscodeManager f14446a;

    /* JADX INFO: renamed from: b */
    private UserSwitchReceiver f14447b;

    /* JADX INFO: renamed from: c */
    private LogoutCompleteReceiver f14448c;

    /* JADX INFO: renamed from: a */
    public abstract void m14933a(RestClient restClient);

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f14446a = SalesforceSDKManager.m14403a().m14449n();
        this.f14447b = new ActivityUserSwitchReceiver();
        registerReceiver(this.f14447b, new IntentFilter("com.salesforce.USERSWITCHED"));
        this.f14448c = new ActivityLogoutCompleteReceiver();
        registerReceiver(this.f14448c, new IntentFilter("com.salesforce.LOGOUT_COMPLETE"));
        EventsObservable.m15006a().m15009a(EventsObservable.EventType.MainActivityCreateComplete, this);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f14446a.m14648b((Activity) this)) {
            new ClientManager(this, SalesforceSDKManager.m14403a().m14420B(), SalesforceSDKManager.m14403a().m14443h(), SalesforceSDKManager.m14403a().m14445j()).m14563a(this, new ClientManager.RestClientCallback() { // from class: com.salesforce.androidsdk.ui.SalesforceListActivity.1
                @Override // com.salesforce.androidsdk.rest.ClientManager.RestClientCallback
                /* JADX INFO: renamed from: a */
                public void mo14590a(RestClient restClient) {
                    if (restClient == null) {
                        SalesforceSDKManager.m14403a().m14428a((Activity) SalesforceListActivity.this);
                    } else {
                        SalesforceListActivity.this.m14933a(restClient);
                        EventsObservable.m15006a().m15008a(EventsObservable.EventType.RenditionComplete);
                    }
                }
            });
        }
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        this.f14446a.m14655f();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.f14446a.m14635a((Activity) this);
    }

    @Override // android.app.ListActivity, android.app.Activity
    public void onDestroy() {
        unregisterReceiver(this.f14447b);
        unregisterReceiver(this.f14448c);
        super.onDestroy();
    }

    /* JADX INFO: renamed from: a */
    protected void m14932a() {
        if (this.f14446a.m14648b((Activity) this)) {
            new ClientManager(this, SalesforceSDKManager.m14403a().m14420B(), SalesforceSDKManager.m14403a().m14443h(), SalesforceSDKManager.m14403a().m14445j()).m14563a(this, new ClientManager.RestClientCallback() { // from class: com.salesforce.androidsdk.ui.SalesforceListActivity.2
                @Override // com.salesforce.androidsdk.rest.ClientManager.RestClientCallback
                /* JADX INFO: renamed from: a */
                public void mo14590a(RestClient restClient) {
                    if (restClient == null) {
                        SalesforceSDKManager.m14403a().m14428a((Activity) SalesforceListActivity.this);
                    } else {
                        SalesforceListActivity.this.m14933a(restClient);
                        EventsObservable.m15006a().m15008a(EventsObservable.EventType.RenditionComplete);
                    }
                }
            });
        }
    }

    /* JADX INFO: renamed from: b */
    protected void m14934b() {
    }

    private class ActivityUserSwitchReceiver extends UserSwitchReceiver {
        private ActivityUserSwitchReceiver() {
        }

        @Override // com.salesforce.androidsdk.util.UserSwitchReceiver
        /* JADX INFO: renamed from: a */
        protected void mo14928a() {
            SalesforceListActivity.this.m14932a();
        }
    }

    private class ActivityLogoutCompleteReceiver extends LogoutCompleteReceiver {
        private ActivityLogoutCompleteReceiver() {
        }

        @Override // com.salesforce.androidsdk.util.LogoutCompleteReceiver
        /* JADX INFO: renamed from: a */
        protected void mo14927a() {
            SalesforceListActivity.this.m14934b();
        }
    }
}
