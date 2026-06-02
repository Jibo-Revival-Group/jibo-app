package com.salesforce.androidsdk.p025ui;

import android.app.Activity;
import android.app.ExpandableListActivity;
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
public abstract class SalesforceExpandableListActivity extends ExpandableListActivity {

    /* JADX INFO: renamed from: a */
    private PasscodeManager f14439a;

    /* JADX INFO: renamed from: b */
    private UserSwitchReceiver f14440b;

    /* JADX INFO: renamed from: c */
    private LogoutCompleteReceiver f14441c;

    /* JADX INFO: renamed from: a */
    public abstract void m14930a(RestClient restClient);

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f14439a = SalesforceSDKManager.m14403a().m14449n();
        this.f14440b = new ActivityUserSwitchReceiver();
        registerReceiver(this.f14440b, new IntentFilter("com.salesforce.USERSWITCHED"));
        this.f14441c = new ActivityLogoutCompleteReceiver();
        registerReceiver(this.f14441c, new IntentFilter("com.salesforce.LOGOUT_COMPLETE"));
        EventsObservable.m15006a().m15009a(EventsObservable.EventType.MainActivityCreateComplete, this);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f14439a.m14648b((Activity) this)) {
            new ClientManager(this, SalesforceSDKManager.m14403a().m14420B(), SalesforceSDKManager.m14403a().m14443h(), SalesforceSDKManager.m14403a().m14445j()).m14563a(this, new ClientManager.RestClientCallback() { // from class: com.salesforce.androidsdk.ui.SalesforceExpandableListActivity.1
                @Override // com.salesforce.androidsdk.rest.ClientManager.RestClientCallback
                /* JADX INFO: renamed from: a */
                public void mo14590a(RestClient restClient) {
                    if (restClient == null) {
                        SalesforceSDKManager.m14403a().m14428a((Activity) SalesforceExpandableListActivity.this);
                    } else {
                        SalesforceExpandableListActivity.this.m14930a(restClient);
                        EventsObservable.m15006a().m15008a(EventsObservable.EventType.RenditionComplete);
                    }
                }
            });
        }
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        this.f14439a.m14655f();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.f14439a.m14635a((Activity) this);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        unregisterReceiver(this.f14440b);
        unregisterReceiver(this.f14441c);
        super.onDestroy();
    }

    /* JADX INFO: renamed from: a */
    protected void m14929a() {
        if (this.f14439a.m14648b((Activity) this)) {
            new ClientManager(this, SalesforceSDKManager.m14403a().m14420B(), SalesforceSDKManager.m14403a().m14443h(), SalesforceSDKManager.m14403a().m14445j()).m14563a(this, new ClientManager.RestClientCallback() { // from class: com.salesforce.androidsdk.ui.SalesforceExpandableListActivity.2
                @Override // com.salesforce.androidsdk.rest.ClientManager.RestClientCallback
                /* JADX INFO: renamed from: a */
                public void mo14590a(RestClient restClient) {
                    if (restClient == null) {
                        SalesforceSDKManager.m14403a().m14428a((Activity) SalesforceExpandableListActivity.this);
                    } else {
                        SalesforceExpandableListActivity.this.m14930a(restClient);
                        EventsObservable.m15006a().m15008a(EventsObservable.EventType.RenditionComplete);
                    }
                }
            });
        }
    }

    /* JADX INFO: renamed from: b */
    protected void m14931b() {
    }

    private class ActivityUserSwitchReceiver extends UserSwitchReceiver {
        private ActivityUserSwitchReceiver() {
        }

        @Override // com.salesforce.androidsdk.util.UserSwitchReceiver
        /* JADX INFO: renamed from: a */
        protected void mo14928a() {
            SalesforceExpandableListActivity.this.m14929a();
        }
    }

    private class ActivityLogoutCompleteReceiver extends LogoutCompleteReceiver {
        private ActivityLogoutCompleteReceiver() {
        }

        @Override // com.salesforce.androidsdk.util.LogoutCompleteReceiver
        /* JADX INFO: renamed from: a */
        protected void mo14927a() {
            SalesforceExpandableListActivity.this.m14931b();
        }
    }
}
