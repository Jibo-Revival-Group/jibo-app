package com.jibo.p019ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.p019ui.fragment.wifi.JiboPreparationsFragment;
import com.jibo.p019ui.fragment.wifi.NetworkSelectionFragment;
import com.jibo.p019ui.fragment.wifi.SetupOrReconnectFragment;
import com.jibo.p019ui.fragment.wifi.WaitForTapFragment;
import com.jibo.p019ui.fragment.wifi.WiFiQRCodeFragment;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class WifiActivity extends BaseActivity {

    /* JADX INFO: renamed from: h */
    public static final String f9910h = WifiActivity.class.getSimpleName();

    /* JADX INFO: renamed from: i */
    private Loop f9911i;

    /* JADX INFO: renamed from: j */
    private ArrayList<Loop> f9912j;

    /* JADX INFO: renamed from: k */
    private Mode f9913k = Mode.INIT_OR_RECONNECT;

    public enum Mode {
        INIT_OR_RECONNECT,
        INIT,
        RECONNECT,
        RECONNECT_SUSPENDED
    }

    @Override // com.jibo.p019ui.activity.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        AppStartTrace.setLauncherActivityOnResumeTime("com.jibo.ui.activity.WifiActivity");
        super.onResume();
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        AppStartTrace.setLauncherActivityOnStartTime("com.jibo.ui.activity.WifiActivity");
        super.onStart();
    }

    /* JADX INFO: renamed from: a */
    private static void m10314a(Activity activity, Intent intent) {
        activity.startActivityForResult(intent, 1000);
    }

    /* JADX INFO: renamed from: a */
    public static void m10316a(Activity activity, ArrayList<Loop> arrayList) {
        Intent intent = new Intent(activity, (Class<?>) WifiActivity.class);
        if (arrayList == null || arrayList.isEmpty()) {
            m10314a(activity, intent.putExtra("ARGS_MODE", Mode.INIT.ordinal()).putExtra("ARGS_SHOW_INTRO", true));
            return;
        }
        ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
        for (Loop loop : arrayList) {
            if (loop.isSuspended().booleanValue()) {
                arrayList2.add(loop);
            }
        }
        if (arrayList2.isEmpty()) {
            m10314a(activity, intent.putExtra("ARGS_MODE", Mode.INIT.ordinal()).putExtra("ARGS_SHOW_INTRO", false));
        } else {
            intent.putParcelableArrayListExtra("ARGS_SUSPENDED_LOOP_LIST", arrayList2);
            m10314a(activity, intent.putExtra("ARGS_MODE", Mode.INIT_OR_RECONNECT.ordinal()));
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m10315a(Activity activity, Loop loop) {
        Intent intent = new Intent(activity, (Class<?>) WifiActivity.class);
        intent.putExtra("ARGS_MODE", loop.isSuspended().booleanValue() ? Mode.RECONNECT_SUSPENDED.ordinal() : Mode.RECONNECT.ordinal());
        intent.putExtra(Loop.class.getSimpleName(), (Parcelable) loop);
        m10314a(activity, intent);
    }

    @Override // com.jibo.p019ui.activity.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        AppStartTrace.setLauncherActivityOnCreateTime("com.jibo.ui.activity.WifiActivity");
        getIntent().putExtra(BaseActivity.f9760b, R.layout.activity_common);
        super.onCreate(bundle);
        if (bundle != null) {
            this.f9911i = (Loop) bundle.getParcelable(Loop.class.getSimpleName());
            this.f9912j = bundle.getParcelableArrayList("ARGS_SUSPENDED_LOOP_LIST");
            this.f9913k = Mode.values()[bundle.getInt("ARGS_MODE", Mode.INIT.ordinal())];
        } else {
            this.f9911i = (Loop) getIntent().getParcelableExtra(Loop.class.getSimpleName());
            this.f9912j = getIntent().getParcelableArrayListExtra("ARGS_SUSPENDED_LOOP_LIST");
            this.f9913k = Mode.values()[getIntent().getIntExtra("ARGS_MODE", Mode.INIT.ordinal())];
        }
        if (bundle == null) {
            if (this.f9913k == Mode.INIT_OR_RECONNECT) {
                m10320s();
            } else if (getIntent().hasExtra("ARGS_SHOW_INTRO") && getIntent().getBooleanExtra("ARGS_SHOW_INTRO", false)) {
                m10319r();
            } else {
                m10318q();
            }
        }
    }

    @Override // com.jibo.p019ui.activity.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (16908332 == menuItem.getItemId()) {
            if (getSupportFragmentManager().mo1468a(R.id.fragment_container) != null && (getSupportFragmentManager().mo1468a(R.id.fragment_container) instanceof WiFiQRCodeFragment)) {
                getSupportFragmentManager().mo1475a(WaitForTapFragment.class.getSimpleName(), 1);
                return true;
            }
            return super.onOptionsItemSelected(menuItem);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(Loop.class.getSimpleName(), this.f9911i);
        bundle.putParcelableArrayList("ARGS_SUSPENDED_LOOP_LIST", this.f9912j);
        bundle.putInt("ARGS_MODE", this.f9913k.ordinal());
    }

    /* JADX INFO: renamed from: q */
    public void m10318q() {
        Bundle bundle = new Bundle();
        if (this.f9911i == null) {
            this.f9913k = Mode.INIT;
        } else {
            bundle.putParcelable(Loop.class.getSimpleName(), this.f9911i);
        }
        m10193c(NetworkSelectionFragment.class, bundle);
    }

    /* JADX INFO: renamed from: r */
    public void m10319r() {
        m10193c(JiboPreparationsFragment.class, null);
    }

    /* JADX INFO: renamed from: s */
    public void m10320s() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("ARGS_SUSPENDED_LOOP_LIST", this.f9912j);
        m10193c(SetupOrReconnectFragment.class, bundle);
    }

    /* JADX INFO: renamed from: t */
    public Mode m10321t() {
        return this.f9913k;
    }

    /* JADX INFO: renamed from: a */
    public void m10317a(Mode mode) {
        this.f9913k = mode;
    }
}
