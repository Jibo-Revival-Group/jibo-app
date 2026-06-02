package com.jibo.p019ui.fragment.invite;

import android.R;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;

/* JADX INFO: loaded from: classes.dex */
public class LoopMembersFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private LoopMembersFragment f10459b;

    public LoopMembersFragment_ViewBinding(LoopMembersFragment loopMembersFragment, View view) {
        this.f10459b = loopMembersFragment;
        loopMembersFragment.list = (RecyclerView) Utils.m5161b(view, R.id.list, "field 'list'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        LoopMembersFragment loopMembersFragment = this.f10459b;
        if (loopMembersFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10459b = null;
        loopMembersFragment.list = null;
    }
}
