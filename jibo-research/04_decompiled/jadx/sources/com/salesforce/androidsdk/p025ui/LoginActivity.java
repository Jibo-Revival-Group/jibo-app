package com.salesforce.androidsdk.p025ui;

import android.accounts.AccountAuthenticatorActivity;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.security.KeyChain;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.facebook.internal.Utility;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.accounts.UserAccountManager;
import com.salesforce.androidsdk.analytics.SalesforceAnalyticsManager;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.config.RuntimeConfig;
import com.salesforce.androidsdk.p025ui.OAuthWebviewHelper;
import com.salesforce.androidsdk.rest.ClientManager;
import com.salesforce.androidsdk.util.EventsObservable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LoginActivity extends AccountAuthenticatorActivity implements OAuthWebviewHelper.OAuthWebviewHelperEvents {

    /* JADX INFO: renamed from: a */
    private SalesforceR f14368a;

    /* JADX INFO: renamed from: b */
    private boolean f14369b;

    /* JADX INFO: renamed from: c */
    private OAuthWebviewHelper f14370c;

    @Override // android.app.Activity
    protected void onStart() {
        AppStartTrace.setLauncherActivityOnStartTime("com.salesforce.androidsdk.ui.LoginActivity");
        super.onStart();
    }

    @Override // android.accounts.AccountAuthenticatorActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        AppStartTrace.setLauncherActivityOnCreateTime("com.salesforce.androidsdk.ui.LoginActivity");
        super.onCreate(bundle);
        this.f14368a = SalesforceSDKManager.m14403a().m14438e();
        ClientManager.LoginOptions loginOptionsM14575a = ClientManager.LoginOptions.m14575a(getIntent().getExtras());
        m14851b();
        getWindow().setFlags(Utility.DEFAULT_STREAM_BUFFER_SIZE, Utility.DEFAULT_STREAM_BUFFER_SIZE);
        setContentView(this.f14368a.m14974b());
        WebView webView = (WebView) findViewById(this.f14368a.m14975c());
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        EventsObservable.m15006a().m15009a(EventsObservable.EventType.AuthWebViewCreateComplete, webView);
        this.f14370c = m14845a(this, loginOptionsM14575a, webView, bundle);
        EventsObservable.m15006a().m15009a(EventsObservable.EventType.LoginActivityCreateComplete, this);
        m14846a();
    }

    /* JADX INFO: renamed from: a */
    protected void m14846a() {
        if (m14853c()) {
            KeyChain.choosePrivateKeyAlias(this, this.f14370c, null, null, null, 0, RuntimeConfig.m14524a(this).m14529a(RuntimeConfig.ConfigKey.ManagedAppCertAlias));
        } else {
            this.f14370c.m14876g();
        }
    }

    /* JADX INFO: renamed from: b */
    protected void m14851b() {
        getWindow().requestFeature(2);
        getWindow().requestFeature(5);
    }

    /* JADX INFO: renamed from: c */
    protected boolean m14853c() {
        return RuntimeConfig.m14524a(this).m14532c(RuntimeConfig.ConfigKey.RequireCertAuth).booleanValue();
    }

    /* JADX INFO: renamed from: a */
    protected OAuthWebviewHelper m14845a(OAuthWebviewHelper.OAuthWebviewHelperEvents oAuthWebviewHelperEvents, ClientManager.LoginOptions loginOptions, WebView webView, Bundle bundle) {
        return new OAuthWebviewHelper(this, oAuthWebviewHelperEvents, loginOptions, webView, bundle);
    }

    @Override // android.app.Activity
    protected void onResume() {
        AppStartTrace.setLauncherActivityOnResumeTime("com.salesforce.androidsdk.ui.LoginActivity");
        super.onResume();
        if (this.f14369b) {
            this.f14370c.m14871b();
            this.f14370c.m14876g();
            this.f14369b = false;
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f14370c.m14867a(bundle);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (m14850a(i)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: renamed from: a */
    protected boolean m14850a(int i) {
        if (i == 4) {
            if (SalesforceSDKManager.m14403a().m14450o().m14277d() == null) {
                this.f14369b = true;
                moveTaskToBack(true);
                return true;
            }
            this.f14369b = true;
            finish();
            return true;
        }
        return false;
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(this.f14368a.m14981i(), menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == this.f14368a.m14982j()) {
            onClearCookiesClick(null);
            return true;
        }
        if (itemId == this.f14368a.m14983k()) {
            onPickServerClick(null);
            return true;
        }
        if (itemId == this.f14368a.m14984l()) {
            onReloadClick(null);
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.salesforce.androidsdk.ui.OAuthWebviewHelper.OAuthWebviewHelperEvents
    /* JADX INFO: renamed from: a */
    public void mo14848a(String str) {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle(str);
        }
    }

    @Override // com.salesforce.androidsdk.ui.OAuthWebviewHelper.OAuthWebviewHelperEvents
    /* JADX INFO: renamed from: b */
    public void mo14852b(int i) {
        mo14849a(false);
        setProgress(i);
    }

    @Override // com.salesforce.androidsdk.ui.OAuthWebviewHelper.OAuthWebviewHelperEvents
    /* JADX INFO: renamed from: a */
    public void mo14849a(boolean z) {
        setProgressBarIndeterminateVisibility(z);
        setProgressBarIndeterminate(z);
    }

    @Override // com.salesforce.androidsdk.ui.OAuthWebviewHelper.OAuthWebviewHelperEvents
    /* JADX INFO: renamed from: a */
    public void mo14847a(Bundle bundle) {
        setAccountAuthenticatorResult(bundle);
    }

    public void onClearCookiesClick(View view) {
        this.f14370c.m14866a();
        this.f14370c.m14876g();
    }

    public void onReloadClick(View view) {
        this.f14370c.m14876g();
    }

    public void onPickServerClick(View view) {
        startActivityForResult(new Intent(this, (Class<?>) ServerPickerActivity.class), 10);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 10 && i2 == -1) {
            this.f14370c.m14876g();
        } else if (i == 777 && i2 == -1) {
            this.f14370c.m14872c();
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.accounts.AccountAuthenticatorActivity, android.app.Activity, com.salesforce.androidsdk.ui.OAuthWebviewHelper.OAuthWebviewHelperEvents
    public void finish() {
        int i = 0;
        m14844d();
        UserAccountManager userAccountManagerM14450o = SalesforceSDKManager.m14403a().m14450o();
        List<UserAccount> listM14277d = userAccountManagerM14450o.m14277d();
        int size = listM14277d == null ? 0 : listM14277d.size();
        if (size != 1) {
            i = size > 1 ? 1 : -1;
        }
        userAccountManagerM14450o.m14267a(i, (Bundle) null);
        super.finish();
    }

    /* JADX INFO: renamed from: d */
    private void m14844d() {
        SalesforceAnalyticsManager salesforceAnalyticsManagerM14292a = SalesforceAnalyticsManager.m14292a(SalesforceSDKManager.m14403a().m14450o().m14275b());
        if (salesforceAnalyticsManagerM14292a != null) {
            salesforceAnalyticsManagerM14292a.m14305b();
        }
    }
}
