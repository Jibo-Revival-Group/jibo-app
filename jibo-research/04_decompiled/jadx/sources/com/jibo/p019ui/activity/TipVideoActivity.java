package com.jibo.p019ui.activity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import butterknife.BindView;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public final class TipVideoActivity extends BaseActivity {

    @BindView
    ProgressBar pbLoader;

    @BindView
    WebView wvWistia;

    @Override // com.jibo.p019ui.activity.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        AppStartTrace.setLauncherActivityOnResumeTime("com.jibo.ui.activity.TipVideoActivity");
        super.onResume();
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        AppStartTrace.setLauncherActivityOnStartTime("com.jibo.ui.activity.TipVideoActivity");
        super.onStart();
    }

    @Override // com.jibo.p019ui.activity.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        AppStartTrace.setLauncherActivityOnCreateTime("com.jibo.ui.activity.TipVideoActivity");
        getIntent().putExtra(BaseActivity.f9760b, R.layout.activity_tip_video);
        super.onCreate(bundle);
        int intExtra = getIntent().getIntExtra("extra_video_url_res_id", -1);
        String string = intExtra == -1 ? "" : getString(intExtra);
        m10312q();
        m10311a(string);
    }

    /* JADX INFO: renamed from: q */
    private void m10312q() {
        getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    /* JADX INFO: renamed from: a */
    private void m10311a(String str) {
        this.wvWistia.getSettings().setJavaScriptEnabled(true);
        this.wvWistia.setWebViewClient(new WebViewClient() { // from class: com.jibo.ui.activity.TipVideoActivity.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str2) {
                super.onPageFinished(webView, str2);
                TipVideoActivity.this.pbLoader.setVisibility(8);
            }
        });
        this.wvWistia.setWebChromeClient(new WebChromeClient());
        this.wvWistia.loadUrl(str);
    }
}
