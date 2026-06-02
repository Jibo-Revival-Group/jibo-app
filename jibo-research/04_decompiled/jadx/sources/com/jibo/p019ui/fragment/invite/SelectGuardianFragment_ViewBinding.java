package com.jibo.p019ui.fragment.invite;

import android.R;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;

/* JADX INFO: loaded from: classes.dex */
public class SelectGuardianFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private SelectGuardianFragment f10537b;

    public SelectGuardianFragment_ViewBinding(SelectGuardianFragment selectGuardianFragment, View view) {
        this.f10537b = selectGuardianFragment;
        selectGuardianFragment.list = (RecyclerView) Utils.m5161b(view, R.id.list, "field 'list'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SelectGuardianFragment selectGuardianFragment = this.f10537b;
        if (selectGuardianFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10537b = null;
        selectGuardianFragment.list = null;
    }
}
