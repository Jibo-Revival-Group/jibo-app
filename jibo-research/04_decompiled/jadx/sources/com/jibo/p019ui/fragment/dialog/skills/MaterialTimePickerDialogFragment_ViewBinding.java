package com.jibo.p019ui.fragment.dialog.skills;

import android.view.View;
import android.widget.TimePicker;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class MaterialTimePickerDialogFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private MaterialTimePickerDialogFragment f10318b;

    /* JADX INFO: renamed from: c */
    private View f10319c;

    /* JADX INFO: renamed from: d */
    private View f10320d;

    public MaterialTimePickerDialogFragment_ViewBinding(final MaterialTimePickerDialogFragment materialTimePickerDialogFragment, View view) {
        this.f10318b = materialTimePickerDialogFragment;
        materialTimePickerDialogFragment.simpleTimePicker = (TimePicker) Utils.m5161b(view, R.id.simpleTimePicker, "field 'simpleTimePicker'", TimePicker.class);
        View viewM5158a = Utils.m5158a(view, R.id.btnCancel, "method 'onCancelClick'");
        this.f10319c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.dialog.skills.MaterialTimePickerDialogFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                materialTimePickerDialogFragment.onCancelClick(view2);
            }
        });
        View viewM5158a2 = Utils.m5158a(view, R.id.btnSet, "method 'onSetClick'");
        this.f10320d = viewM5158a2;
        viewM5158a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.dialog.skills.MaterialTimePickerDialogFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                materialTimePickerDialogFragment.onSetClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        MaterialTimePickerDialogFragment materialTimePickerDialogFragment = this.f10318b;
        if (materialTimePickerDialogFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10318b = null;
        materialTimePickerDialogFragment.simpleTimePicker = null;
        this.f10319c.setOnClickListener(null);
        this.f10319c = null;
        this.f10320d.setOnClickListener(null);
        this.f10320d = null;
    }
}
