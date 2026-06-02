package com.salesforce.androidsdk.p025ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.salesforce.androidsdk.app.SalesforceSDKManager;

/* JADX INFO: loaded from: classes.dex */
public class ManageSpaceActivity extends Activity {

    /* JADX INFO: renamed from: a */
    private SalesforceR f14371a;

    /* JADX INFO: renamed from: b */
    private AlertDialog f14372b;

    @Override // android.app.Activity
    protected void onResume() {
        AppStartTrace.setLauncherActivityOnResumeTime("com.salesforce.androidsdk.ui.ManageSpaceActivity");
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onStart() {
        AppStartTrace.setLauncherActivityOnStartTime("com.salesforce.androidsdk.ui.ManageSpaceActivity");
        super.onStart();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        AppStartTrace.setLauncherActivityOnCreateTime("com.salesforce.androidsdk.ui.ManageSpaceActivity");
        super.onCreate(bundle);
        this.f14371a = SalesforceSDKManager.m14403a().m14438e();
        setContentView(this.f14371a.m14970ai());
        this.f14372b = m14854a();
        this.f14372b.show();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        this.f14372b.dismiss();
        super.onDestroy();
    }

    /* JADX INFO: renamed from: a */
    protected AlertDialog m14854a() {
        return new AlertDialog.Builder(this).setMessage(this.f14371a.m14971aj()).setPositiveButton(getString(this.f14371a.m14940F()), new DialogInterface.OnClickListener() { // from class: com.salesforce.androidsdk.ui.ManageSpaceActivity.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                SalesforceSDKManager.m14403a().m14429a((Activity) ManageSpaceActivity.this, false);
            }
        }).setNegativeButton(getString(this.f14371a.m14941G()), new DialogInterface.OnClickListener() { // from class: com.salesforce.androidsdk.ui.ManageSpaceActivity.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                ManageSpaceActivity.this.finish();
            }
        }).create();
    }
}
