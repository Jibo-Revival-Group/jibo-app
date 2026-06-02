package com.jibo.p019ui.fragment.dialog;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class CircleProgressFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private CircleProgressFragment f10195b;

    public CircleProgressFragment_ViewBinding(CircleProgressFragment circleProgressFragment, View view) {
        this.f10195b = circleProgressFragment;
        circleProgressFragment.mProgressCircle = (ImageView) Utils.m5161b(view, R.id.progressCircle, "field 'mProgressCircle'", ImageView.class);
        circleProgressFragment.mProgressSuccess = (ImageView) Utils.m5161b(view, R.id.progressSuccess, "field 'mProgressSuccess'", ImageView.class);
        circleProgressFragment.mProgressFailure = (ImageView) Utils.m5161b(view, R.id.progressFailure, "field 'mProgressFailure'", ImageView.class);
        circleProgressFragment.mProgressStatusText = (TextView) Utils.m5161b(view, R.id.progress_status_text, "field 'mProgressStatusText'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        CircleProgressFragment circleProgressFragment = this.f10195b;
        if (circleProgressFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10195b = null;
        circleProgressFragment.mProgressCircle = null;
        circleProgressFragment.mProgressSuccess = null;
        circleProgressFragment.mProgressFailure = null;
        circleProgressFragment.mProgressStatusText = null;
    }
}
