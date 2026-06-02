package com.jibo.p019ui.fragment.settings;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;
import com.jibo.p019ui.view.proxima.CustomFontAutoCompleteTextView;
import com.jibo.p019ui.view.proxima.CustomFontTextView;

/* JADX INFO: loaded from: classes.dex */
public class CustomHolidaySettingsFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private CustomHolidaySettingsFragment f10968b;

    /* JADX INFO: renamed from: c */
    private View f10969c;

    public CustomHolidaySettingsFragment_ViewBinding(final CustomHolidaySettingsFragment customHolidaySettingsFragment, View view) {
        this.f10968b = customHolidaySettingsFragment;
        customHolidaySettingsFragment.holidayName = (CustomFontAutoCompleteTextView) Utils.m5161b(view, R.id.holidayName, "field 'holidayName'", CustomFontAutoCompleteTextView.class);
        View viewM5158a = Utils.m5158a(view, R.id.date, "field 'date' and method 'selectDate'");
        customHolidaySettingsFragment.date = (CustomFontTextView) Utils.m5162c(viewM5158a, R.id.date, "field 'date'", CustomFontTextView.class);
        this.f10969c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.settings.CustomHolidaySettingsFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                customHolidaySettingsFragment.selectDate(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        CustomHolidaySettingsFragment customHolidaySettingsFragment = this.f10968b;
        if (customHolidaySettingsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10968b = null;
        customHolidaySettingsFragment.holidayName = null;
        customHolidaySettingsFragment.date = null;
        this.f10969c.setOnClickListener(null);
        this.f10969c = null;
    }
}
