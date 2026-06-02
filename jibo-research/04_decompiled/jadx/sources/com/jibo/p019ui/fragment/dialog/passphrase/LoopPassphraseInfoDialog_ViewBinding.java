package com.jibo.p019ui.fragment.dialog.passphrase;

import android.view.View;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class LoopPassphraseInfoDialog_ViewBinding extends LoopPassphraseBaseDialog_ViewBinding {

    /* JADX INFO: renamed from: b */
    private LoopPassphraseInfoDialog f10284b;

    /* JADX INFO: renamed from: c */
    private View f10285c;

    /* JADX INFO: renamed from: d */
    private View f10286d;

    public LoopPassphraseInfoDialog_ViewBinding(final LoopPassphraseInfoDialog loopPassphraseInfoDialog, View view) {
        super(loopPassphraseInfoDialog, view);
        this.f10284b = loopPassphraseInfoDialog;
        loopPassphraseInfoDialog.passphrase = (TextView) Utils.m5161b(view, R.id.passphrase, "field 'passphrase'", TextView.class);
        View viewM5158a = Utils.m5158a(view, R.id.btnSet, "method 'okayClicked'");
        this.f10285c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.dialog.passphrase.LoopPassphraseInfoDialog_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                loopPassphraseInfoDialog.okayClicked(view2);
            }
        });
        View viewM5158a2 = Utils.m5158a(view, R.id.btnCancel, "method 'cancelClicked'");
        this.f10286d = viewM5158a2;
        viewM5158a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.dialog.passphrase.LoopPassphraseInfoDialog_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                loopPassphraseInfoDialog.cancelClicked(view2);
            }
        });
    }

    @Override // com.jibo.p019ui.fragment.dialog.passphrase.LoopPassphraseBaseDialog_ViewBinding, butterknife.Unbinder
    public void unbind() {
        LoopPassphraseInfoDialog loopPassphraseInfoDialog = this.f10284b;
        if (loopPassphraseInfoDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10284b = null;
        loopPassphraseInfoDialog.passphrase = null;
        this.f10285c.setOnClickListener(null);
        this.f10285c = null;
        this.f10286d.setOnClickListener(null);
        this.f10286d = null;
        super.unbind();
    }
}
