package com.salesforce.android.cases.p020ui.internal.features.publisher;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.salesforce.android.cases.R;
import com.salesforce.android.cases.p020ui.internal.features.publisher.CasePublisherContract;
import com.salesforce.android.cases.p020ui.internal.features.shared.CasesSdkActivity;
import com.salesforce.android.cases.p020ui.internal.utils.ViewUtils;

/* JADX INFO: loaded from: classes.dex */
public class CasePublisherActivity extends AppCompatActivity implements CasesSdkActivity {

    /* JADX INFO: renamed from: a */
    private CasePublisherContract.View f12773a;

    /* JADX INFO: renamed from: b */
    private CasePublisherActivityDelegate f12774b = new CasePublisherActivityDelegate(this);

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        AppStartTrace.setLauncherActivityOnResumeTime("com.salesforce.android.cases.ui.internal.features.publisher.CasePublisherActivity");
        super.onResume();
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        AppStartTrace.setLauncherActivityOnStartTime("com.salesforce.android.cases.ui.internal.features.publisher.CasePublisherActivity");
        super.onStart();
    }

    /* JADX INFO: renamed from: a */
    public static void m12928a(Context context) {
        context.startActivity(new Intent(context, (Class<?>) CasePublisherActivity.class));
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        AppStartTrace.setLauncherActivityOnCreateTime("com.salesforce.android.cases.ui.internal.features.publisher.CasePublisherActivity");
        super.onCreate(bundle);
        setContentView(R.layout.activity_case_publisher);
        ViewUtils.m13057a(this);
        this.f12773a = (CasePublisherContract.View) findViewById(R.id.case_publisher_view);
        this.f12774b.m13008a(bundle);
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f12774b.m13009b(bundle);
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f12774b.mo12744a();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (!this.f12774b.mo12748c()) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        this.f12774b.m13010e();
    }

    /* JADX INFO: renamed from: a */
    public CasePublisherContract.View m12929a() {
        return this.f12773a;
    }
}
