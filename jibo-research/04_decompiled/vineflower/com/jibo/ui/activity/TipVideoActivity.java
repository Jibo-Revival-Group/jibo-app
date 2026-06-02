package com.jibo.ui.activity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import butterknife.BindView;
import com.google.firebase.perf.metrics.AppStartTrace;

public final class TipVideoActivity extends BaseActivity {
   @BindView
   ProgressBar pbLoader;
   @BindView
   WebView wvWistia;

   private void a(String var1) {
      this.wvWistia.getSettings().setJavaScriptEnabled(true);
      this.wvWistia.setWebViewClient(new WebViewClient(this) {
         final TipVideoActivity a;

         {
            this.a = var1;
         }

         public void onPageFinished(WebView var1, String var2) {
            super.onPageFinished(var1, var2);
            this.a.pbLoader.setVisibility(8);
         }
      });
      this.wvWistia.setWebChromeClient(new WebChromeClient());
      this.wvWistia.loadUrl(var1);
   }

   private void q() {
      this.getWindow().getDecorView().setSystemUiVisibility(5894);
   }

   @Override
   protected void onCreate(Bundle var1) {
      AppStartTrace.setLauncherActivityOnCreateTime("com.jibo.ui.activity.TipVideoActivity");
      this.getIntent().putExtra(BaseActivity.b, 2131427365);
      super.onCreate(var1);
      int var2 = this.getIntent().getIntExtra("extra_video_url_res_id", -1);
      String var3;
      if (var2 == -1) {
         var3 = "";
      } else {
         var3 = this.getString(var2);
      }

      this.q();
      this.a(var3);
   }

   @Override
   protected void onResume() {
      AppStartTrace.setLauncherActivityOnResumeTime("com.jibo.ui.activity.TipVideoActivity");
      super.onResume();
   }

   @Override
   protected void onStart() {
      AppStartTrace.setLauncherActivityOnStartTime("com.jibo.ui.activity.TipVideoActivity");
      super.onStart();
   }
}
