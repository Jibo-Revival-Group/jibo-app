package com.salesforce.androidsdk.p025ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.accounts.UserAccountManager;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AccountSwitcherActivity extends Activity {

    /* JADX INFO: renamed from: a */
    private SalesforceR f14351a;

    /* JADX INFO: renamed from: b */
    private UserAccountManager f14352b;

    @Override // android.app.Activity
    protected void onStart() {
        AppStartTrace.setLauncherActivityOnStartTime("com.salesforce.androidsdk.ui.AccountSwitcherActivity");
        super.onStart();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        AppStartTrace.setLauncherActivityOnCreateTime("com.salesforce.androidsdk.ui.AccountSwitcherActivity");
        super.onCreate(bundle);
        this.f14351a = SalesforceSDKManager.m14403a().m14438e();
        this.f14352b = SalesforceSDKManager.m14403a().m14450o();
        setContentView(this.f14351a.m14972ak());
    }

    @Override // android.app.Activity
    public void onResume() {
        AppStartTrace.setLauncherActivityOnResumeTime("com.salesforce.androidsdk.ui.AccountSwitcherActivity");
        super.onResume();
        m14830a();
    }

    public void switchToExistingAccount(View view) {
        RadioGroup radioGroup = (RadioGroup) findViewById(this.f14351a.m14973al());
        SalesforceAccountRadioButton salesforceAccountRadioButton = (SalesforceAccountRadioButton) radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
        if (salesforceAccountRadioButton != null) {
            this.f14352b.m14269a(salesforceAccountRadioButton.getAccount(), -1, (Bundle) null);
        }
        finish();
    }

    public void switchToNewAccount(View view) {
        this.f14352b.m14278e();
        finish();
    }

    /* JADX INFO: renamed from: a */
    private void m14830a() {
        RadioGroup radioGroup = (RadioGroup) findViewById(this.f14351a.m14973al());
        radioGroup.removeAllViews();
        UserAccount userAccountM14275b = this.f14352b.m14275b();
        List<UserAccount> listM14277d = this.f14352b.m14277d();
        if (listM14277d != null && listM14277d.size() != 0) {
            UserAccount userAccount = userAccountM14275b == null ? listM14277d.get(0) : userAccountM14275b;
            int i = 0;
            for (int i2 = 0; i2 < listM14277d.size(); i2++) {
                UserAccount userAccount2 = listM14277d.get(i2);
                if (userAccount2 != null) {
                    m14831a(radioGroup, userAccount2);
                    if (userAccount2.equals(userAccount)) {
                        i = i2;
                    }
                }
            }
            SalesforceAccountRadioButton salesforceAccountRadioButton = (SalesforceAccountRadioButton) radioGroup.getChildAt(i);
            if (salesforceAccountRadioButton != null) {
                salesforceAccountRadioButton.setChecked(true);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m14831a(RadioGroup radioGroup, UserAccount userAccount) {
        radioGroup.addView(new SalesforceAccountRadioButton(this, userAccount));
    }
}
