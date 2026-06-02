package com.jibo.p019ui.fragment.account.skills;

import android.R;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;

/* JADX INFO: loaded from: classes.dex */
public class SkillSettingsFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private SkillSettingsFragment f10093b;

    public SkillSettingsFragment_ViewBinding(SkillSettingsFragment skillSettingsFragment, View view) {
        this.f10093b = skillSettingsFragment;
        skillSettingsFragment.list = (RecyclerView) Utils.m5161b(view, R.id.list, "field 'list'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SkillSettingsFragment skillSettingsFragment = this.f10093b;
        if (skillSettingsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10093b = null;
        skillSettingsFragment.list = null;
    }
}
