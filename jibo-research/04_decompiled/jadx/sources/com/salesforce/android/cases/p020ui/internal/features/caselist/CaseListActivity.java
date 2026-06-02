package com.salesforce.android.cases.p020ui.internal.features.caselist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.salesforce.android.cases.R;
import com.salesforce.android.cases.p020ui.internal.features.caselist.CaseListContract;
import com.salesforce.android.cases.p020ui.internal.features.shared.CasesSdkActivity;
import com.salesforce.android.cases.p020ui.internal.utils.ViewUtils;

/* JADX INFO: loaded from: classes.dex */
public class CaseListActivity extends AppCompatActivity implements CasesSdkActivity {

    /* JADX INFO: renamed from: a */
    private CaseListContract.View f12698a;

    /* JADX INFO: renamed from: b */
    private CaseListActivityDelegate f12699b = new CaseListActivityDelegate(this);

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        AppStartTrace.setLauncherActivityOnStartTime("com.salesforce.android.cases.ui.internal.features.caselist.CaseListActivity");
        super.onStart();
    }

    /* JADX INFO: renamed from: a */
    public static void m12832a(Context context) {
        context.startActivity(new Intent(context, (Class<?>) CaseListActivity.class));
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        AppStartTrace.setLauncherActivityOnCreateTime("com.salesforce.android.cases.ui.internal.features.caselist.CaseListActivity");
        super.onCreate(bundle);
        setContentView(R.layout.activity_case_list);
        ViewUtils.m13057a(this);
        this.f12698a = (CaseListContract.View) findViewById(R.id.case_list_view);
        this.f12699b.m13008a(bundle);
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f12699b.m13009b(bundle);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        AppStartTrace.setLauncherActivityOnResumeTime("com.salesforce.android.cases.ui.internal.features.caselist.CaseListActivity");
        super.onResume();
        this.f12699b.mo12836g_();
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f12699b.mo12744a();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (!this.f12699b.mo12748c()) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        this.f12699b.m13010e();
    }

    /* JADX INFO: renamed from: a */
    public CaseListContract.View m12833a() {
        return this.f12698a;
    }
}
