package com.jibo.p019ui.activity;

import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public final class TipVideoActivity_ViewBinding extends BaseActivity_ViewBinding {

    /* JADX INFO: renamed from: b */
    private TipVideoActivity f9903b;

    public TipVideoActivity_ViewBinding(TipVideoActivity tipVideoActivity) {
        this(tipVideoActivity, tipVideoActivity.getWindow().getDecorView());
    }

    public TipVideoActivity_ViewBinding(TipVideoActivity tipVideoActivity, View view) {
        super(tipVideoActivity, view);
        this.f9903b = tipVideoActivity;
        tipVideoActivity.wvWistia = (WebView) Utils.m5161b(view, R.id.webView, "field 'wvWistia'", WebView.class);
        tipVideoActivity.pbLoader = (ProgressBar) Utils.m5161b(view, android.R.id.progress, "field 'pbLoader'", ProgressBar.class);
    }

    @Override // com.jibo.p019ui.activity.BaseActivity_ViewBinding, butterknife.Unbinder
    public void unbind() {
        TipVideoActivity tipVideoActivity = this.f9903b;
        if (tipVideoActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f9903b = null;
        tipVideoActivity.wvWistia = null;
        tipVideoActivity.pbLoader = null;
        super.unbind();
    }
}
