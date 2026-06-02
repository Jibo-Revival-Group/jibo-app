package com.salesforce.android.knowledge.p022ui.internal.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.salesforce.android.knowledge.p022ui.R;
import com.salesforce.android.knowledge.p022ui.internal.client.KnowledgeUIClientImpl;

/* JADX INFO: loaded from: classes.dex */
public class KnowledgeActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: a */
    private KnowledgeUIClientImpl f13106a;

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        AppStartTrace.setLauncherActivityOnResumeTime("com.salesforce.android.knowledge.ui.internal.activity.KnowledgeActivity");
        super.onResume();
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        AppStartTrace.setLauncherActivityOnStartTime("com.salesforce.android.knowledge.ui.internal.activity.KnowledgeActivity");
        super.onStart();
    }

    /* JADX INFO: renamed from: a */
    public static void m13431a(Context context) {
        Intent intent = new Intent(context, (Class<?>) KnowledgeActivity.class);
        intent.addFlags(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        context.startActivity(intent);
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        AppStartTrace.setLauncherActivityOnCreateTime("com.salesforce.android.knowledge.ui.internal.activity.KnowledgeActivity");
        super.onCreate(bundle);
        setContentView(R.layout.knowledge_activity);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f13106a != null) {
            this.f13106a.m13538m();
        } else {
            super.onBackPressed();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m13433a(KnowledgeUIClientImpl knowledgeUIClientImpl) {
        this.f13106a = knowledgeUIClientImpl;
    }

    /* JADX INFO: renamed from: a */
    public KnowledgeUIClientImpl m13432a() {
        return this.f13106a;
    }
}
