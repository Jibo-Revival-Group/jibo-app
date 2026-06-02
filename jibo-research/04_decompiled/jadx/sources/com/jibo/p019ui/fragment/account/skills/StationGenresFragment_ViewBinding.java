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
public class StationGenresFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private StationGenresFragment f10116b;

    public StationGenresFragment_ViewBinding(StationGenresFragment stationGenresFragment, View view) {
        this.f10116b = stationGenresFragment;
        stationGenresFragment.swipeRefreshLayout = (SwipeRefreshLayout) Utils.m5161b(view, R.id.swipeRefreshLayout, "field 'swipeRefreshLayout'", SwipeRefreshLayout.class);
        stationGenresFragment.list = (RecyclerView) Utils.m5161b(view, android.R.id.list, "field 'list'", RecyclerView.class);
        stationGenresFragment.emptyView = Utils.m5158a(view, android.R.id.empty, "field 'emptyView'");
        stationGenresFragment.emptyViewTitle = (TextView) Utils.m5161b(view, android.R.id.title, "field 'emptyViewTitle'", TextView.class);
        stationGenresFragment.emptyViewIcon = (ImageView) Utils.m5161b(view, android.R.id.icon, "field 'emptyViewIcon'", ImageView.class);
        stationGenresFragment.emptyViewTextInfo = (TextView) Utils.m5161b(view, android.R.id.text1, "field 'emptyViewTextInfo'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        StationGenresFragment stationGenresFragment = this.f10116b;
        if (stationGenresFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10116b = null;
        stationGenresFragment.swipeRefreshLayout = null;
        stationGenresFragment.list = null;
        stationGenresFragment.emptyView = null;
        stationGenresFragment.emptyViewTitle = null;
        stationGenresFragment.emptyViewIcon = null;
        stationGenresFragment.emptyViewTextInfo = null;
    }
}
