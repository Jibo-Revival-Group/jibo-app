package com.jibo.p019ui.fragment.account.skills;

import android.view.View;
import android.webkit.WebView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class OauthFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private OauthFragment f10074b;

    public OauthFragment_ViewBinding(OauthFragment oauthFragment, View view) {
        this.f10074b = oauthFragment;
        oauthFragment.webview = (WebView) Utils.m5159a(view, R.id.webview, "field 'webview'", WebView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        OauthFragment oauthFragment = this.f10074b;
        if (oauthFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10074b = null;
        oauthFragment.webview = null;
    }
}
