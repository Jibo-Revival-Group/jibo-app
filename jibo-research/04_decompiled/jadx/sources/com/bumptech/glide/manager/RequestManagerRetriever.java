package com.bumptech.glide.manager;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.util.Util;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class RequestManagerRetriever implements Handler.Callback {

    /* JADX INFO: renamed from: c */
    private static final RequestManagerRetriever f4907c = new RequestManagerRetriever();

    /* JADX INFO: renamed from: d */
    private volatile RequestManager f4910d;

    /* JADX INFO: renamed from: a */
    final Map<FragmentManager, RequestManagerFragment> f4908a = new HashMap();

    /* JADX INFO: renamed from: b */
    final Map<android.support.v4.app.FragmentManager, SupportRequestManagerFragment> f4909b = new HashMap();

    /* JADX INFO: renamed from: e */
    private final Handler f4911e = new Handler(Looper.getMainLooper(), this);

    /* JADX INFO: renamed from: a */
    public static RequestManagerRetriever m5469a() {
        return f4907c;
    }

    RequestManagerRetriever() {
    }

    /* JADX INFO: renamed from: b */
    private RequestManager m5470b(Context context) {
        if (this.f4910d == null) {
            synchronized (this) {
                if (this.f4910d == null) {
                    this.f4910d = new RequestManager(context.getApplicationContext(), new ApplicationLifecycle(), new EmptyRequestManagerTreeNode());
                }
            }
        }
        return this.f4910d;
    }

    /* JADX INFO: renamed from: a */
    public RequestManager m5473a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (Util.m5594b() && !(context instanceof Application)) {
            if (context instanceof FragmentActivity) {
                return m5476a((FragmentActivity) context);
            }
            if (context instanceof Activity) {
                return m5472a((Activity) context);
            }
            if (context instanceof ContextWrapper) {
                return m5473a(((ContextWrapper) context).getBaseContext());
            }
        }
        return m5470b(context);
    }

    /* JADX INFO: renamed from: a */
    public RequestManager m5476a(FragmentActivity fragmentActivity) {
        if (Util.m5596c()) {
            return m5473a(fragmentActivity.getApplicationContext());
        }
        m5471b((Activity) fragmentActivity);
        return m5475a(fragmentActivity, fragmentActivity.getSupportFragmentManager());
    }

    @TargetApi(11)
    /* JADX INFO: renamed from: a */
    public RequestManager m5472a(Activity activity) {
        if (Util.m5596c() || Build.VERSION.SDK_INT < 11) {
            return m5473a(activity.getApplicationContext());
        }
        m5471b(activity);
        return m5474a(activity, activity.getFragmentManager());
    }

    @TargetApi(17)
    /* JADX INFO: renamed from: b */
    private static void m5471b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    @TargetApi(17)
    /* JADX INFO: renamed from: a */
    RequestManagerFragment m5477a(FragmentManager fragmentManager) {
        RequestManagerFragment requestManagerFragment = (RequestManagerFragment) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (requestManagerFragment == null) {
            RequestManagerFragment requestManagerFragment2 = this.f4908a.get(fragmentManager);
            if (requestManagerFragment2 == null) {
                RequestManagerFragment requestManagerFragment3 = new RequestManagerFragment();
                this.f4908a.put(fragmentManager, requestManagerFragment3);
                fragmentManager.beginTransaction().add(requestManagerFragment3, "com.bumptech.glide.manager").commitAllowingStateLoss();
                this.f4911e.obtainMessage(1, fragmentManager).sendToTarget();
                return requestManagerFragment3;
            }
            return requestManagerFragment2;
        }
        return requestManagerFragment;
    }

    @TargetApi(11)
    /* JADX INFO: renamed from: a */
    RequestManager m5474a(Context context, FragmentManager fragmentManager) {
        RequestManagerFragment requestManagerFragmentM5477a = m5477a(fragmentManager);
        RequestManager requestManagerM5467b = requestManagerFragmentM5477a.m5467b();
        if (requestManagerM5467b == null) {
            RequestManager requestManager = new RequestManager(context, requestManagerFragmentM5477a.m5465a(), requestManagerFragmentM5477a.m5468c());
            requestManagerFragmentM5477a.m5466a(requestManager);
            return requestManager;
        }
        return requestManagerM5467b;
    }

    /* JADX INFO: renamed from: a */
    SupportRequestManagerFragment m5478a(android.support.v4.app.FragmentManager fragmentManager) {
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) fragmentManager.mo1470a("com.bumptech.glide.manager");
        if (supportRequestManagerFragment == null) {
            SupportRequestManagerFragment supportRequestManagerFragment2 = this.f4909b.get(fragmentManager);
            if (supportRequestManagerFragment2 == null) {
                SupportRequestManagerFragment supportRequestManagerFragment3 = new SupportRequestManagerFragment();
                this.f4909b.put(fragmentManager, supportRequestManagerFragment3);
                fragmentManager.mo1471a().mo1367a(supportRequestManagerFragment3, "com.bumptech.glide.manager").mo1386e();
                this.f4911e.obtainMessage(2, fragmentManager).sendToTarget();
                return supportRequestManagerFragment3;
            }
            return supportRequestManagerFragment2;
        }
        return supportRequestManagerFragment;
    }

    /* JADX INFO: renamed from: a */
    RequestManager m5475a(Context context, android.support.v4.app.FragmentManager fragmentManager) {
        SupportRequestManagerFragment supportRequestManagerFragmentM5478a = m5478a(fragmentManager);
        RequestManager requestManagerM5489b = supportRequestManagerFragmentM5478a.m5489b();
        if (requestManagerM5489b == null) {
            RequestManager requestManager = new RequestManager(context, supportRequestManagerFragmentM5478a.m5487a(), supportRequestManagerFragmentM5478a.m5490c());
            supportRequestManagerFragmentM5478a.m5488a(requestManager);
            return requestManager;
        }
        return requestManagerM5489b;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        ComponentCallbacks componentCallbacksRemove;
        Object obj = null;
        boolean z = true;
        switch (message.what) {
            case 1:
                obj = (FragmentManager) message.obj;
                componentCallbacksRemove = this.f4908a.remove(obj);
                break;
            case 2:
                obj = (android.support.v4.app.FragmentManager) message.obj;
                componentCallbacksRemove = this.f4909b.remove(obj);
                break;
            default:
                z = false;
                componentCallbacksRemove = null;
                break;
        }
        if (z && componentCallbacksRemove == null && Log.isLoggable("RMRetriever", 5)) {
            Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj);
        }
        return z;
    }
}
