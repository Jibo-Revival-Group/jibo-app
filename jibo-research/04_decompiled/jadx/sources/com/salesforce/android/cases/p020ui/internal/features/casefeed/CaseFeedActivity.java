package com.salesforce.android.cases.p020ui.internal.features.casefeed;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.salesforce.android.cases.R;
import com.salesforce.android.cases.p020ui.internal.features.casefeed.CaseFeedContract;
import com.salesforce.android.cases.p020ui.internal.features.shared.CasesSdkActivity;
import com.salesforce.android.cases.p020ui.internal.utils.ViewUtils;

/* JADX INFO: loaded from: classes.dex */
public class CaseFeedActivity extends AppCompatActivity implements CasesSdkActivity {

    /* JADX INFO: renamed from: a */
    private CaseFeedContract.View f12630a;

    /* JADX INFO: renamed from: b */
    private CaseFeedActivityDelegate f12631b = new CaseFeedActivityDelegate(this);

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        AppStartTrace.setLauncherActivityOnResumeTime("com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedActivity");
        super.onResume();
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        AppStartTrace.setLauncherActivityOnStartTime("com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedActivity");
        super.onStart();
    }

    /* JADX INFO: renamed from: a */
    public static void m12742a(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) CaseFeedActivity.class);
        intent.putExtra("EXTRA_CASE_ID", str);
        context.startActivity(intent);
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        AppStartTrace.setLauncherActivityOnCreateTime("com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedActivity");
        super.onCreate(bundle);
        setContentView(R.layout.activity_case_feed);
        ViewUtils.m13057a(this);
        this.f12630a = (CaseFeedContract.View) findViewById(R.id.case_feed_view);
        this.f12631b.m13008a(bundle);
        this.f12630a.setCaseId(getIntent().getStringExtra("EXTRA_CASE_ID"));
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f12631b.m13009b(bundle);
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f12631b.mo12744a();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (!this.f12631b.mo12748c()) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        this.f12631b.m13010e();
    }

    /* JADX INFO: renamed from: a */
    public CaseFeedContract.View m12743a() {
        return this.f12630a;
    }
}
