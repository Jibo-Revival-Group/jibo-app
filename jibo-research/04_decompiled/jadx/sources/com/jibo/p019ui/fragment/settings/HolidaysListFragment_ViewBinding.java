package com.jibo.p019ui.fragment.settings;

import android.R;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;

/* JADX INFO: loaded from: classes.dex */
public class HolidaysListFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private HolidaysListFragment f11025b;

    public HolidaysListFragment_ViewBinding(HolidaysListFragment holidaysListFragment, View view) {
        this.f11025b = holidaysListFragment;
        holidaysListFragment.list = (RecyclerView) Utils.m5161b(view, R.id.list, "field 'list'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        HolidaysListFragment holidaysListFragment = this.f11025b;
        if (holidaysListFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f11025b = null;
        holidaysListFragment.list = null;
    }
}
