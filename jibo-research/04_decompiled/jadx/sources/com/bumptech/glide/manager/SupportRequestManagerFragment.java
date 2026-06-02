package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.app.Fragment;
import com.bumptech.glide.RequestManager;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class SupportRequestManagerFragment extends Fragment {

    /* JADX INFO: renamed from: a */
    private RequestManager f4915a;

    /* JADX INFO: renamed from: b */
    private final ActivityFragmentLifecycle f4916b;

    /* JADX INFO: renamed from: c */
    private final RequestManagerTreeNode f4917c;

    /* JADX INFO: renamed from: d */
    private final HashSet<SupportRequestManagerFragment> f4918d;

    /* JADX INFO: renamed from: e */
    private SupportRequestManagerFragment f4919e;

    public SupportRequestManagerFragment() {
        this(new ActivityFragmentLifecycle());
    }

    @SuppressLint({"ValidFragment"})
    public SupportRequestManagerFragment(ActivityFragmentLifecycle activityFragmentLifecycle) {
        this.f4917c = new SupportFragmentRequestManagerTreeNode();
        this.f4918d = new HashSet<>();
        this.f4916b = activityFragmentLifecycle;
    }

    /* JADX INFO: renamed from: a */
    public void m5488a(RequestManager requestManager) {
        this.f4915a = requestManager;
    }

    /* JADX INFO: renamed from: a */
    ActivityFragmentLifecycle m5487a() {
        return this.f4916b;
    }

    /* JADX INFO: renamed from: b */
    public RequestManager m5489b() {
        return this.f4915a;
    }

    /* JADX INFO: renamed from: c */
    public RequestManagerTreeNode m5490c() {
        return this.f4917c;
    }

    /* JADX INFO: renamed from: a */
    private void m5485a(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.f4918d.add(supportRequestManagerFragment);
    }

    /* JADX INFO: renamed from: b */
    private void m5486b(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.f4918d.remove(supportRequestManagerFragment);
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f4919e = RequestManagerRetriever.m5469a().m5478a(getActivity().getSupportFragmentManager());
        if (this.f4919e != this) {
            this.f4919e.m5485a(this);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.f4919e != null) {
            this.f4919e.m5486b(this);
            this.f4919e = null;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.f4916b.m5451a();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.f4916b.m5453b();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f4916b.m5454c();
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        if (this.f4915a != null) {
            this.f4915a.m5281a();
        }
    }

    private class SupportFragmentRequestManagerTreeNode implements RequestManagerTreeNode {
        private SupportFragmentRequestManagerTreeNode() {
        }
    }
}
