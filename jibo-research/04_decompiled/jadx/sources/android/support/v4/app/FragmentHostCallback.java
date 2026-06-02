package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentHostCallback<E> extends FragmentContainer {

    /* JADX INFO: renamed from: a */
    private final Activity f1472a;

    /* JADX INFO: renamed from: b */
    final Context f1473b;

    /* JADX INFO: renamed from: c */
    final int f1474c;

    /* JADX INFO: renamed from: d */
    final FragmentManagerImpl f1475d;

    /* JADX INFO: renamed from: e */
    private final Handler f1476e;

    /* JADX INFO: renamed from: g */
    public abstract E mo1435g();

    FragmentHostCallback(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, fragmentActivity.mHandler, 0);
    }

    FragmentHostCallback(Activity activity, Context context, Handler handler, int i) {
        this.f1475d = new FragmentManagerImpl();
        this.f1472a = activity;
        this.f1473b = context;
        this.f1476e = handler;
        this.f1474c = i;
    }

    /* JADX INFO: renamed from: a */
    public void mo1426a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    /* JADX INFO: renamed from: a */
    public boolean mo1427a(Fragment fragment) {
        return true;
    }

    /* JADX INFO: renamed from: b */
    public LayoutInflater mo1429b() {
        return LayoutInflater.from(this.f1473b);
    }

    /* JADX INFO: renamed from: d */
    public void mo1432d() {
    }

    /* JADX INFO: renamed from: a */
    public void mo1423a(Fragment fragment, Intent intent, int i, Bundle bundle) {
        if (i != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        this.f1473b.startActivity(intent);
    }

    /* JADX INFO: renamed from: a */
    public void mo1424a(Fragment fragment, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (i != -1) {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
        ActivityCompat.m1344a(this.f1472a, intentSender, i, intent, i2, i3, i4, bundle);
    }

    /* JADX INFO: renamed from: a */
    public void mo1425a(Fragment fragment, String[] strArr, int i) {
    }

    /* JADX INFO: renamed from: a */
    public boolean mo1428a(String str) {
        return false;
    }

    /* JADX INFO: renamed from: e */
    public boolean mo1433e() {
        return true;
    }

    /* JADX INFO: renamed from: f */
    public int mo1434f() {
        return this.f1474c;
    }

    @Override // android.support.v4.app.FragmentContainer
    /* JADX INFO: renamed from: a */
    public View mo1401a(int i) {
        return null;
    }

    @Override // android.support.v4.app.FragmentContainer
    /* JADX INFO: renamed from: a */
    public boolean mo1402a() {
        return true;
    }

    /* JADX INFO: renamed from: h */
    Activity m1463h() {
        return this.f1472a;
    }

    /* JADX INFO: renamed from: i */
    Context m1464i() {
        return this.f1473b;
    }

    /* JADX INFO: renamed from: j */
    Handler m1465j() {
        return this.f1476e;
    }

    /* JADX INFO: renamed from: k */
    FragmentManagerImpl m1466k() {
        return this.f1475d;
    }

    /* JADX INFO: renamed from: b */
    void mo1430b(Fragment fragment) {
    }
}
