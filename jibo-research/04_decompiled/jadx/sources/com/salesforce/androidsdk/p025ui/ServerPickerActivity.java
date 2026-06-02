package com.salesforce.androidsdk.p025ui;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.salesforce.androidsdk.R;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.config.LoginServerManager;
import com.salesforce.androidsdk.config.RuntimeConfig;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ServerPickerActivity extends Activity implements RadioGroup.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a */
    private CustomServerUrlEditor f14457a;

    /* JADX INFO: renamed from: b */
    private SalesforceR f14458b;

    /* JADX INFO: renamed from: c */
    private LoginServerManager f14459c;

    @Override // android.app.Activity
    protected void onStart() {
        AppStartTrace.setLauncherActivityOnStartTime("com.salesforce.androidsdk.ui.ServerPickerActivity");
        super.onStart();
    }

    /* JADX INFO: renamed from: d */
    private void m15002d() {
        this.f14459c.m14520b();
        m15005c();
        this.f14457a = new CustomServerUrlEditor();
    }

    public void setCancelReturnValue(View view) {
        onBackPressed();
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        SalesforceServerRadioButton salesforceServerRadioButton;
        if (radioGroup != null && (salesforceServerRadioButton = (SalesforceServerRadioButton) radioGroup.findViewById(i)) != null) {
            this.f14459c.m14518a(new LoginServerManager.LoginServer(salesforceServerRadioButton.getName(), salesforceServerRadioButton.getUrl(), salesforceServerRadioButton.m15000b()));
        }
    }

    public void onResetClick(View view) {
        m15002d();
    }

    /* JADX INFO: renamed from: a */
    protected int m15003a() {
        return this.f14458b.m14957W();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        AppStartTrace.setLauncherActivityOnCreateTime("com.salesforce.androidsdk.ui.ServerPickerActivity");
        super.onCreate(bundle);
        this.f14458b = SalesforceSDKManager.m14403a().m14438e();
        this.f14459c = SalesforceSDKManager.m14403a().m14447l();
        setContentView(this.f14458b.m14958X());
        Button button = (Button) findViewById(R.id.sf__show_custom_url_edit);
        if (button != null && RuntimeConfig.m14524a(this).m14532c(RuntimeConfig.ConfigKey.OnlyShowAuthorizedHosts).booleanValue()) {
            button.setVisibility(8);
        }
        ((RadioGroup) findViewById(m15003a())).setOnCheckedChangeListener(this);
        this.f14457a = new CustomServerUrlEditor();
        this.f14457a.setRetainInstance(true);
    }

    @Override // android.app.Activity
    public void onResume() {
        AppStartTrace.setLauncherActivityOnResumeTime("com.salesforce.androidsdk.ui.ServerPickerActivity");
        super.onResume();
        m15005c();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        ((RadioGroup) findViewById(m15003a())).setOnCheckedChangeListener(null);
        this.f14457a = null;
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(this.f14458b.m14962aa(), menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != this.f14458b.m14963ab()) {
            return super.onOptionsItemSelected(menuItem);
        }
        m15002d();
        return true;
    }

    public void setPositiveReturnValue(View view) {
        setResult(-1, null);
        finish();
    }

    public void showCustomUrlDialog(View view) {
        FragmentManager fragmentManager = getFragmentManager();
        if (!this.f14457a.isAdded()) {
            this.f14457a.show(fragmentManager, "custom_server_dialog");
        }
    }

    /* JADX INFO: renamed from: a */
    private void m15001a(RadioGroup radioGroup, LoginServerManager.LoginServer loginServer) {
        radioGroup.addView(new SalesforceServerRadioButton(this, loginServer.f14189a, loginServer.f14190b, loginServer.f14191c));
    }

    /* JADX INFO: renamed from: b */
    protected void m15004b() {
        RadioGroup radioGroup = (RadioGroup) findViewById(m15003a());
        List<LoginServerManager.LoginServer> listM14521c = this.f14459c.m14521c();
        if (listM14521c != null) {
            Iterator<LoginServerManager.LoginServer> it = listM14521c.iterator();
            while (it.hasNext()) {
                m15001a(radioGroup, it.next());
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public void m15005c() {
        RadioGroup radioGroup = (RadioGroup) findViewById(m15003a());
        radioGroup.removeAllViews();
        m15004b();
        LoginServerManager.LoginServer loginServerM14517a = this.f14459c.m14517a();
        int childCount = radioGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            SalesforceServerRadioButton salesforceServerRadioButton = (SalesforceServerRadioButton) radioGroup.getChildAt(i);
            if (salesforceServerRadioButton != null && new LoginServerManager.LoginServer(salesforceServerRadioButton.getName(), salesforceServerRadioButton.getUrl(), salesforceServerRadioButton.m15000b()).equals(loginServerM14517a)) {
                salesforceServerRadioButton.setChecked(true);
            }
        }
    }
}
