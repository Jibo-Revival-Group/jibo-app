package com.jibo.p019ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.jibo.R;
import com.jibo.utils.LogUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class SingleFragmentActivity extends BaseActivity {

    /* JADX INFO: renamed from: h */
    public static final String f9862h = LogUtils.m11405a(SingleFragmentActivity.class);

    /* JADX INFO: renamed from: i */
    public static final String f9863i = SingleFragmentActivity.class.getName() + ".FRAGMENT_CLASS";

    /* JADX INFO: renamed from: j */
    private Intent f9864j;

    @Override // com.jibo.p019ui.activity.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        AppStartTrace.setLauncherActivityOnResumeTime("com.jibo.ui.activity.SingleFragmentActivity");
        super.onResume();
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        AppStartTrace.setLauncherActivityOnStartTime("com.jibo.ui.activity.SingleFragmentActivity");
        super.onStart();
    }

    /* JADX INFO: renamed from: q */
    public synchronized Intent m10268q() {
        if (this.f9864j == null) {
            this.f9864j = new Intent();
        }
        return this.f9864j;
    }

    @Override // com.jibo.p019ui.activity.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        AppStartTrace.setLauncherActivityOnCreateTime("com.jibo.ui.activity.SingleFragmentActivity");
        if (getIntent().getIntExtra(f9760b, -1) == -1) {
            getIntent().putExtra(f9760b, R.layout.activity_common);
        }
        super.onCreate(bundle);
        if (bundle == null) {
            m10269r();
        }
    }

    /* JADX INFO: renamed from: r */
    public void m10269r() {
        Fragment fragmentInstantiate = Fragment.instantiate(this, getIntent().getStringExtra(f9863i), getIntent().getExtras());
        getSupportFragmentManager().mo1471a().mo1378b(R.id.fragment_container, fragmentInstantiate).mo1368a(LogUtils.m11406a(fragmentInstantiate.getClass().getSimpleName())).mo1385d();
    }

    @Override // com.jibo.p019ui.activity.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f9864j != null) {
            setResult(-1, this.f9864j);
        }
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public void finish() {
        if (this.f9864j != null) {
            setResult(-1, this.f9864j);
        }
        super.finish();
    }

    @Override // com.jibo.p019ui.activity.BaseActivity
    /* JADX INFO: renamed from: e */
    public void mo10195e() {
        if (getCallingActivity() == null) {
            m10194d();
        } else {
            super.mo10195e();
        }
    }

    public static class Builder {

        /* JADX INFO: renamed from: a */
        private Context f9865a;

        /* JADX INFO: renamed from: b */
        private Fragment f9866b;

        /* JADX INFO: renamed from: c */
        private Intent f9867c;

        public Builder(Context context, String str) {
            this.f9865a = context;
            this.f9867c = new Intent(context, (Class<?>) SingleFragmentActivity.class);
            this.f9867c.putExtra(SingleFragmentActivity.f9863i, str);
        }

        public Builder(Fragment fragment, String str) {
            this(fragment.getActivity(), str);
            this.f9866b = fragment;
        }

        /* JADX INFO: renamed from: a */
        public Builder m10272a(String str, Parcelable parcelable) {
            this.f9867c.putExtra(str, parcelable);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m10274a(String str, boolean z) {
            this.f9867c.putExtra(str, z);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m10273a(String str, Serializable serializable) {
            this.f9867c.putExtra(str, serializable);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m10271a(String str, int i) {
            this.f9867c.putExtra(str, i);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public void m10275a(int i) {
            if (TextUtils.isEmpty(this.f9867c.getStringExtra(SingleFragmentActivity.f9863i))) {
                LogUtils.m11412d(SingleFragmentActivity.f9862h, SingleFragmentActivity.f9863i + " must be supplied in Extras!");
                return;
            }
            if (i == -1) {
                LogUtils.m11407a(SingleFragmentActivity.f9862h, "Request code must be supplied!");
                return;
            }
            if (this.f9865a == null && this.f9866b == null) {
                LogUtils.m11407a(SingleFragmentActivity.f9862h, "Neither context OR fragment must be supplied!");
                return;
            }
            if (this.f9866b != null) {
                this.f9866b.startActivityForResult(this.f9867c, i);
            } else if (this.f9865a != null && (this.f9865a instanceof Activity)) {
                ((Activity) this.f9865a).startActivityForResult(this.f9867c, i);
            }
            this.f9866b = null;
            this.f9865a = null;
            this.f9867c = null;
        }

        /* JADX INFO: renamed from: a */
        public Intent m10270a() {
            return this.f9867c;
        }
    }
}
