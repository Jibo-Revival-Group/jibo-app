package com.jibo.p019ui.fragment.dialog;

import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class MaterialDatePickerDialogFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private MaterialDatePickerDialogFragment f10264b;

    /* JADX INFO: renamed from: c */
    private View f10265c;

    /* JADX INFO: renamed from: d */
    private View f10266d;

    public MaterialDatePickerDialogFragment_ViewBinding(final MaterialDatePickerDialogFragment materialDatePickerDialogFragment, View view) {
        this.f10264b = materialDatePickerDialogFragment;
        materialDatePickerDialogFragment.textDayOfMonth = (TextView) Utils.m5161b(view, R.id.textDayOfMonth, "field 'textDayOfMonth'", TextView.class);
        materialDatePickerDialogFragment.textMonthYear = (TextView) Utils.m5161b(view, R.id.textMonthYear, "field 'textMonthYear'", TextView.class);
        materialDatePickerDialogFragment.datePicker = (DatePicker) Utils.m5161b(view, R.id.date_picker, "field 'datePicker'", DatePicker.class);
        materialDatePickerDialogFragment.textTitle = (TextView) Utils.m5161b(view, R.id.textTitle, "field 'textTitle'", TextView.class);
        View viewM5158a = Utils.m5158a(view, R.id.btnCancel, "method 'onCancelClick'");
        this.f10265c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.dialog.MaterialDatePickerDialogFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                materialDatePickerDialogFragment.onCancelClick(view2);
            }
        });
        View viewM5158a2 = Utils.m5158a(view, R.id.btnSet, "method 'onSetClick'");
        this.f10266d = viewM5158a2;
        viewM5158a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.dialog.MaterialDatePickerDialogFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                materialDatePickerDialogFragment.onSetClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        MaterialDatePickerDialogFragment materialDatePickerDialogFragment = this.f10264b;
        if (materialDatePickerDialogFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10264b = null;
        materialDatePickerDialogFragment.textDayOfMonth = null;
        materialDatePickerDialogFragment.textMonthYear = null;
        materialDatePickerDialogFragment.datePicker = null;
        materialDatePickerDialogFragment.textTitle = null;
        this.f10265c.setOnClickListener(null);
        this.f10265c = null;
        this.f10266d.setOnClickListener(null);
        this.f10266d = null;
    }
}
