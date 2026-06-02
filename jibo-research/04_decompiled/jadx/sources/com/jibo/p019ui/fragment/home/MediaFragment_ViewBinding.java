package com.jibo.p019ui.fragment.home;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class MediaFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private MediaFragment f10394b;

    public MediaFragment_ViewBinding(MediaFragment mediaFragment, View view) {
        this.f10394b = mediaFragment;
        mediaFragment.swipeRefreshLayout = (SwipeRefreshLayout) Utils.m5161b(view, R.id.swipeRefreshLayout, "field 'swipeRefreshLayout'", SwipeRefreshLayout.class);
        mediaFragment.list = (RecyclerView) Utils.m5161b(view, android.R.id.list, "field 'list'", RecyclerView.class);
        mediaFragment.emptyView = Utils.m5158a(view, android.R.id.empty, "field 'emptyView'");
        mediaFragment.viewNoKey = Utils.m5158a(view, R.id.viewNoKey, "field 'viewNoKey'");
        mediaFragment.progressView = Utils.m5158a(view, android.R.id.progress, "field 'progressView'");
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        MediaFragment mediaFragment = this.f10394b;
        if (mediaFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10394b = null;
        mediaFragment.swipeRefreshLayout = null;
        mediaFragment.list = null;
        mediaFragment.emptyView = null;
        mediaFragment.viewNoKey = null;
        mediaFragment.progressView = null;
    }
}
