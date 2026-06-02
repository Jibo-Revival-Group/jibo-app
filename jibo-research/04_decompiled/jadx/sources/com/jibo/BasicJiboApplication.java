package com.jibo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.multidex.MultiDexApplication;
import com.crashlytics.android.Crashlytics;
import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.util.Commons;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.view.proxima.ProximaHelper;
import com.jibo.service.DeviceUnRegistrationService;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public abstract class BasicJiboApplication extends MultiDexApplication {

    /* JADX INFO: renamed from: a */
    public static FirebaseJobDispatcher f9172a;

    /* JADX INFO: renamed from: a */
    protected abstract void mo9831a();

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        Commons._DEBUG_LOG_OUTPUT = false;
        m9827c();
        m9828d();
        m9829e();
        m9830f();
        ProximaHelper.m11355a(getApplicationContext());
        mo9831a();
    }

    /* JADX INFO: renamed from: c */
    private void m9827c() {
    }

    /* JADX INFO: renamed from: d */
    private void m9828d() {
        f9172a = new FirebaseJobDispatcher(new GooglePlayDriver(this));
    }

    /* JADX INFO: renamed from: e */
    private void m9829e() {
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.app_name), 0);
        Commons.ROOT_ENDPOINT = Commons.API_ENDPOINT;
        Commons.setRootEndpoint(sharedPreferences.getString("PREF_END_POINT", Commons.ROOT_ENDPOINT));
    }

    /* JADX INFO: renamed from: f */
    private void m9830f() {
        try {
            EntityData.m10089a(this);
        } catch (Exception e) {
            Crashlytics.m5597a((Throwable) e);
        }
    }

    /* JADX INFO: renamed from: b */
    public void mo9832b() throws Throwable {
        EntityData.m10089a(this).m10133h();
        Intent intent = new Intent(this, (Class<?>) DeviceUnRegistrationService.class);
        intent.putExtra(Account.class.getSimpleName(), (Serializable) EntityData.m10089a(this).m10134i());
        startService(intent);
    }
}
