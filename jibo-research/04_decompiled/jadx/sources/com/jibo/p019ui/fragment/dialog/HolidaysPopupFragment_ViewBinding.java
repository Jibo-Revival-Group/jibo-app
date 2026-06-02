package com.jibo.p019ui.fragment.dialog;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class HolidaysPopupFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private HolidaysPopupFragment f10238b;

    /* JADX INFO: renamed from: c */
    private View f10239c;

    /* JADX INFO: renamed from: d */
    private View f10240d;

    public HolidaysPopupFragment_ViewBinding(final HolidaysPopupFragment holidaysPopupFragment, View view) {
        this.f10238b = holidaysPopupFragment;
        View viewM5158a = Utils.m5158a(view, R.id.btnAddHolidays, "method 'onBtnAddHolidaysClick'");
        this.f10239c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.dialog.HolidaysPopupFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                holidaysPopupFragment.onBtnAddHolidaysClick();
            }
        });
        View viewM5158a2 = Utils.m5158a(view, R.id.btnCancel, "method 'onBtnCancelClick'");
        this.f10240d = viewM5158a2;
        viewM5158a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.dialog.HolidaysPopupFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                holidaysPopupFragment.onBtnCancelClick();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        if (this.f10238b == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10238b = null;
        this.f10239c.setOnClickListener(null);
        this.f10239c = null;
        this.f10240d.setOnClickListener(null);
        this.f10240d = null;
    }
}
