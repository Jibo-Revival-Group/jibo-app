package com.jibo.p019ui.fragment.tips;

import android.R;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;

/* JADX INFO: loaded from: classes.dex */
public class TipsFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private TipsFragment f11183b;

    public TipsFragment_ViewBinding(TipsFragment tipsFragment, View view) {
        this.f11183b = tipsFragment;
        tipsFragment.list = (RecyclerView) Utils.m5161b(view, R.id.list, "field 'list'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        TipsFragment tipsFragment = this.f11183b;
        if (tipsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f11183b = null;
        tipsFragment.list = null;
    }
}
