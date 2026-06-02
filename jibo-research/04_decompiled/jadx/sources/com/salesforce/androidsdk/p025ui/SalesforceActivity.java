package com.salesforce.androidsdk.p025ui;

import android.app.Activity;
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
public abstract class SalesforceActivity extends Activity {

    /* JADX INFO: renamed from: a */
    private PasscodeManager f14432a;

    /* JADX INFO: renamed from: b */
    private UserSwitchReceiver f14433b;

    /* JADX INFO: renamed from: c */
    private LogoutCompleteReceiver f14434c;

    /* JADX INFO: renamed from: a */
    public abstract void m14925a(RestClient restClient);

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f14432a = SalesforceSDKManager.m14403a().m14449n();
        this.f14433b = new ActivityUserSwitchReceiver();
        registerReceiver(this.f14433b, new IntentFilter("com.salesforce.USERSWITCHED"));
        this.f14434c = new ActivityLogoutCompleteReceiver();
        registerReceiver(this.f14434c, new IntentFilter("com.salesforce.LOGOUT_COMPLETE"));
        EventsObservable.m15006a().m15009a(EventsObservable.EventType.MainActivityCreateComplete, this);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f14432a.m14648b((Activity) this)) {
            new ClientManager(this, SalesforceSDKManager.m14403a().m14420B(), SalesforceSDKManager.m14403a().m14443h(), SalesforceSDKManager.m14403a().m14445j()).m14563a(this, new ClientManager.RestClientCallback() { // from class: com.salesforce.androidsdk.ui.SalesforceActivity.1
                @Override // com.salesforce.androidsdk.rest.ClientManager.RestClientCallback
                /* JADX INFO: renamed from: a */
                public void mo14590a(RestClient restClient) {
                    if (restClient == null) {
                        SalesforceSDKManager.m14403a().m14428a((Activity) SalesforceActivity.this);
                    } else {
                        SalesforceActivity.this.m14925a(restClient);
                        EventsObservable.m15006a().m15008a(EventsObservable.EventType.RenditionComplete);
                    }
                }
            });
        }
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        this.f14432a.m14655f();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.f14432a.m14635a((Activity) this);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        unregisterReceiver(this.f14433b);
        unregisterReceiver(this.f14434c);
        super.onDestroy();
    }

    /* JADX INFO: renamed from: a */
    protected void m14924a() {
        if (this.f14432a.m14648b((Activity) this)) {
            new ClientManager(this, SalesforceSDKManager.m14403a().m14420B(), SalesforceSDKManager.m14403a().m14443h(), SalesforceSDKManager.m14403a().m14445j()).m14563a(this, new ClientManager.RestClientCallback() { // from class: com.salesforce.androidsdk.ui.SalesforceActivity.2
                @Override // com.salesforce.androidsdk.rest.ClientManager.RestClientCallback
                /* JADX INFO: renamed from: a */
                public void mo14590a(RestClient restClient) {
                    if (restClient == null) {
                        SalesforceSDKManager.m14403a().m14428a((Activity) SalesforceActivity.this);
                    } else {
                        SalesforceActivity.this.m14925a(restClient);
                        EventsObservable.m15006a().m15008a(EventsObservable.EventType.RenditionComplete);
                    }
                }
            });
        }
    }

    /* JADX INFO: renamed from: b */
    protected void m14926b() {
    }

    private class ActivityUserSwitchReceiver extends UserSwitchReceiver {
        private ActivityUserSwitchReceiver() {
        }

        @Override // com.salesforce.androidsdk.util.UserSwitchReceiver
        /* JADX INFO: renamed from: a */
        protected void mo14928a() {
            SalesforceActivity.this.m14924a();
        }
    }

    private class ActivityLogoutCompleteReceiver extends LogoutCompleteReceiver {
        private ActivityLogoutCompleteReceiver() {
        }

        @Override // com.salesforce.androidsdk.util.LogoutCompleteReceiver
        /* JADX INFO: renamed from: a */
        protected void mo14927a() {
            SalesforceActivity.this.m14926b();
        }
    }
}
