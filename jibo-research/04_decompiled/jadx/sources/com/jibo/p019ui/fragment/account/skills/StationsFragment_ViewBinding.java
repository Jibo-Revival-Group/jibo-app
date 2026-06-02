package com.jibo.p019ui.fragment.account.skills;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class StationsFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private StationsFragment f10141b;

    public StationsFragment_ViewBinding(StationsFragment stationsFragment, View view) {
        this.f10141b = stationsFragment;
        stationsFragment.swipeRefreshLayout = (SwipeRefreshLayout) Utils.m5161b(view, R.id.swipeRefreshLayout, "field 'swipeRefreshLayout'", SwipeRefreshLayout.class);
        stationsFragment.list = (RecyclerView) Utils.m5161b(view, android.R.id.list, "field 'list'", RecyclerView.class);
        stationsFragment.emptyView = Utils.m5158a(view, android.R.id.empty, "field 'emptyView'");
        stationsFragment.emptyViewTitle = (TextView) Utils.m5161b(view, android.R.id.title, "field 'emptyViewTitle'", TextView.class);
        stationsFragment.emptyViewIcon = (ImageView) Utils.m5161b(view, android.R.id.icon, "field 'emptyViewIcon'", ImageView.class);
        stationsFragment.emptyViewTextInfo = (TextView) Utils.m5161b(view, android.R.id.text1, "field 'emptyViewTextInfo'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        StationsFragment stationsFragment = this.f10141b;
        if (stationsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10141b = null;
        stationsFragment.swipeRefreshLayout = null;
        stationsFragment.list = null;
        stationsFragment.emptyView = null;
        stationsFragment.emptyViewTitle = null;
        stationsFragment.emptyViewIcon = null;
        stationsFragment.emptyViewTextInfo = null;
    }
}
