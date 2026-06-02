package com.jibo.p019ui.fragment.settings;

import android.R;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.jibo.p019ui.view.RecyclerViewFastScroller;

/* JADX INFO: loaded from: classes.dex */
public class HolidaySettingsFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private HolidaySettingsFragment f11008b;

    public HolidaySettingsFragment_ViewBinding(HolidaySettingsFragment holidaySettingsFragment, View view) {
        this.f11008b = holidaySettingsFragment;
        holidaySettingsFragment.list = (RecyclerView) Utils.m5161b(view, R.id.list, "field 'list'", RecyclerView.class);
        holidaySettingsFragment.fastScroller = (RecyclerViewFastScroller) Utils.m5161b(view, com.jibo.R.id.fastscroller, "field 'fastScroller'", RecyclerViewFastScroller.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        HolidaySettingsFragment holidaySettingsFragment = this.f11008b;
        if (holidaySettingsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f11008b = null;
        holidaySettingsFragment.list = null;
        holidaySettingsFragment.fastScroller = null;
    }
}
