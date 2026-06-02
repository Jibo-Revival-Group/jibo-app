package com.jibo;

import android.app.Application;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.segment.analytics.Analytics;

/* JADX INFO: loaded from: classes.dex */
public class JiboApplication extends BasicJiboApplication {
    public native String getThirPartyKey1();

    public native String getThirPartyKey4();

    @Override // com.jibo.BasicJiboApplication
    /* JADX INFO: renamed from: a */
    protected void mo9831a() {
        m9862c();
        m9863d();
        m9864e();
    }

    /* JADX INFO: renamed from: c */
    private void m9862c() {
        FacebookSdk.setApplicationId(getThirPartyKey1());
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp((Application) this);
    }

    /* JADX INFO: renamed from: d */
    private void m9863d() {
        Analytics.setSingletonInstance(new Analytics.Builder(this, getThirPartyKey4()).trackApplicationLifecycleEvents().build());
    }

    /* JADX INFO: renamed from: e */
    private void m9864e() {
        JiboSupport.m9869a(this);
    }

    @Override // com.jibo.BasicJiboApplication
    /* JADX INFO: renamed from: b */
    public void mo9832b() {
        LoginManager.getInstance().logOut();
        super.mo9832b();
    }

    static {
        System.loadLibrary("utils-jni");
    }
}
