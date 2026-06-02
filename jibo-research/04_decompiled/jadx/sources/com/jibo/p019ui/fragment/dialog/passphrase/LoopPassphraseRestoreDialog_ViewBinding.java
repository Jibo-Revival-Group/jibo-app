package com.jibo.p019ui.fragment.dialog.passphrase;

import android.view.View;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class LoopPassphraseRestoreDialog_ViewBinding extends LoopPassphraseBaseDialog_ViewBinding {

    /* JADX INFO: renamed from: b */
    private LoopPassphraseRestoreDialog f10294b;

    /* JADX INFO: renamed from: c */
    private View f10295c;

    /* JADX INFO: renamed from: d */
    private View f10296d;

    public LoopPassphraseRestoreDialog_ViewBinding(final LoopPassphraseRestoreDialog loopPassphraseRestoreDialog, View view) {
        super(loopPassphraseRestoreDialog, view);
        this.f10294b = loopPassphraseRestoreDialog;
        View viewM5158a = Utils.m5158a(view, R.id.btnSet, "method 'onSetClicked'");
        this.f10295c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.dialog.passphrase.LoopPassphraseRestoreDialog_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                loopPassphraseRestoreDialog.onSetClicked(view2);
            }
        });
        View viewM5158a2 = Utils.m5158a(view, R.id.btnCancel, "method 'onCancelClicked'");
        this.f10296d = viewM5158a2;
        viewM5158a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.dialog.passphrase.LoopPassphraseRestoreDialog_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                loopPassphraseRestoreDialog.onCancelClicked(view2);
            }
        });
    }

    @Override // com.jibo.p019ui.fragment.dialog.passphrase.LoopPassphraseBaseDialog_ViewBinding, butterknife.Unbinder
    public void unbind() {
        if (this.f10294b == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10294b = null;
        this.f10295c.setOnClickListener(null);
        this.f10295c = null;
        this.f10296d.setOnClickListener(null);
        this.f10296d = null;
        super.unbind();
    }
}
