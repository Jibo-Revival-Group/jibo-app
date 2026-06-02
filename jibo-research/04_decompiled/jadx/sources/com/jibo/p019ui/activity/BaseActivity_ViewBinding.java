package com.jibo.p019ui.activity;

import android.view.View;
import android.widget.ProgressBar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class BaseActivity_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private BaseActivity f9779b;

    public BaseActivity_ViewBinding(BaseActivity baseActivity) {
        this(baseActivity, baseActivity.getWindow().getDecorView());
    }

    public BaseActivity_ViewBinding(BaseActivity baseActivity, View view) {
        this.f9779b = baseActivity;
        baseActivity.mProgressBar = (ProgressBar) Utils.m5159a(view, R.id.progressBar, "field 'mProgressBar'", ProgressBar.class);
        baseActivity.mDimmer = view.findViewById(R.id.dimmer);
        baseActivity.viewNetworkDown = view.findViewById(R.id.viewNetworkDown);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        BaseActivity baseActivity = this.f9779b;
        if (baseActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f9779b = null;
        baseActivity.mProgressBar = null;
        baseActivity.mDimmer = null;
        baseActivity.viewNetworkDown = null;
    }
}
