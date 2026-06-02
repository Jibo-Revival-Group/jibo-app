package com.jibo.p019ui.fragment.dialog;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class ChangeLoopNameDialog_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private ChangeLoopNameDialog f10173b;

    /* JADX INFO: renamed from: c */
    private View f10174c;

    /* JADX INFO: renamed from: d */
    private View f10175d;

    public ChangeLoopNameDialog_ViewBinding(final ChangeLoopNameDialog changeLoopNameDialog, View view) {
        this.f10173b = changeLoopNameDialog;
        changeLoopNameDialog.nameEdit = (EditText) Utils.m5161b(view, R.id.name_edit, "field 'nameEdit'", EditText.class);
        changeLoopNameDialog.tipText = (TextView) Utils.m5161b(view, R.id.tip, "field 'tipText'", TextView.class);
        View viewM5158a = Utils.m5158a(view, R.id.cancel_action, "method 'onCancelClicked'");
        this.f10174c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.dialog.ChangeLoopNameDialog_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                changeLoopNameDialog.onCancelClicked(view2);
            }
        });
        View viewM5158a2 = Utils.m5158a(view, R.id.set_action, "method 'onSetClicked'");
        this.f10175d = viewM5158a2;
        viewM5158a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.dialog.ChangeLoopNameDialog_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                changeLoopNameDialog.onSetClicked(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ChangeLoopNameDialog changeLoopNameDialog = this.f10173b;
        if (changeLoopNameDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10173b = null;
        changeLoopNameDialog.nameEdit = null;
        changeLoopNameDialog.tipText = null;
        this.f10174c.setOnClickListener(null);
        this.f10174c = null;
        this.f10175d.setOnClickListener(null);
        this.f10175d = null;
    }
}
