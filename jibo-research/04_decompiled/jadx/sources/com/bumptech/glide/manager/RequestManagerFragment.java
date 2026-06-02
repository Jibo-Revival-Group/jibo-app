package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import com.bumptech.glide.RequestManager;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(11)
public class RequestManagerFragment extends Fragment {

    /* JADX INFO: renamed from: a */
    private final ActivityFragmentLifecycle f4901a;

    /* JADX INFO: renamed from: b */
    private final RequestManagerTreeNode f4902b;

    /* JADX INFO: renamed from: c */
    private RequestManager f4903c;

    /* JADX INFO: renamed from: d */
    private final HashSet<RequestManagerFragment> f4904d;

    /* JADX INFO: renamed from: e */
    private RequestManagerFragment f4905e;

    public RequestManagerFragment() {
        this(new ActivityFragmentLifecycle());
    }

    @SuppressLint({"ValidFragment"})
    RequestManagerFragment(ActivityFragmentLifecycle activityFragmentLifecycle) {
        this.f4902b = new FragmentRequestManagerTreeNode();
        this.f4904d = new HashSet<>();
        this.f4901a = activityFragmentLifecycle;
    }

    /* JADX INFO: renamed from: a */
    public void m5466a(RequestManager requestManager) {
        this.f4903c = requestManager;
    }

    /* JADX INFO: renamed from: a */
    ActivityFragmentLifecycle m5465a() {
        return this.f4901a;
    }

    /* JADX INFO: renamed from: b */
    public RequestManager m5467b() {
        return this.f4903c;
    }

    /* JADX INFO: renamed from: c */
    public RequestManagerTreeNode m5468c() {
        return this.f4902b;
    }

    /* JADX INFO: renamed from: a */
    private void m5463a(RequestManagerFragment requestManagerFragment) {
        this.f4904d.add(requestManagerFragment);
    }

    /* JADX INFO: renamed from: b */
    private void m5464b(RequestManagerFragment requestManagerFragment) {
        this.f4904d.remove(requestManagerFragment);
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f4905e = RequestManagerRetriever.m5469a().m5477a(getActivity().getFragmentManager());
        if (this.f4905e != this) {
            this.f4905e.m5463a(this);
        }
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.f4905e != null) {
            this.f4905e.m5464b(this);
            this.f4905e = null;
        }
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f4901a.m5451a();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.f4901a.m5453b();
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f4901a.m5454c();
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        if (this.f4903c != null) {
            this.f4903c.m5282a(i);
        }
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        if (this.f4903c != null) {
            this.f4903c.m5281a();
        }
    }

    private class FragmentRequestManagerTreeNode implements RequestManagerTreeNode {
        private FragmentRequestManagerTreeNode() {
        }
    }
}
