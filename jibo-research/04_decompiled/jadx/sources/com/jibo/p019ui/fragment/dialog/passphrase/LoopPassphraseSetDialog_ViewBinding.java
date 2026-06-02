package com.jibo.p019ui.fragment.dialog.passphrase;

import android.view.View;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class LoopPassphraseSetDialog_ViewBinding extends LoopPassphraseBaseDialog_ViewBinding {

    /* JADX INFO: renamed from: b */
    private LoopPassphraseSetDialog f10303b;

    /* JADX INFO: renamed from: c */
    private View f10304c;

    /* JADX INFO: renamed from: d */
    private View f10305d;

    public LoopPassphraseSetDialog_ViewBinding(final LoopPassphraseSetDialog loopPassphraseSetDialog, View view) {
        super(loopPassphraseSetDialog, view);
        this.f10303b = loopPassphraseSetDialog;
        View viewM5158a = Utils.m5158a(view, R.id.btnSet, "method 'onSetClicked'");
        this.f10304c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.dialog.passphrase.LoopPassphraseSetDialog_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                loopPassphraseSetDialog.onSetClicked(view2);
            }
        });
        View viewM5158a2 = Utils.m5158a(view, R.id.btnCancel, "method 'onCancelClicked'");
        this.f10305d = viewM5158a2;
        viewM5158a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.dialog.passphrase.LoopPassphraseSetDialog_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                loopPassphraseSetDialog.onCancelClicked(view2);
            }
        });
    }

    @Override // com.jibo.p019ui.fragment.dialog.passphrase.LoopPassphraseBaseDialog_ViewBinding, butterknife.Unbinder
    public void unbind() {
        if (this.f10303b == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10303b = null;
        this.f10304c.setOnClickListener(null);
        this.f10304c = null;
        this.f10305d.setOnClickListener(null);
        this.f10305d = null;
        super.unbind();
    }
}
