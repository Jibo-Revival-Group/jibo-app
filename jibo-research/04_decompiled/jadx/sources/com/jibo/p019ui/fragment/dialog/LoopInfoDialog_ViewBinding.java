package com.jibo.p019ui.fragment.dialog;

import android.R;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

/* JADX INFO: loaded from: classes.dex */
public class LoopInfoDialog_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private LoopInfoDialog f10251b;

    /* JADX INFO: renamed from: c */
    private View f10252c;

    public LoopInfoDialog_ViewBinding(final LoopInfoDialog loopInfoDialog, View view) {
        this.f10251b = loopInfoDialog;
        loopInfoDialog.text = (TextView) Utils.m5161b(view, R.id.text1, "field 'text'", TextView.class);
        loopInfoDialog.peopleCountMessage = (TextView) Utils.m5161b(view, com.jibo.R.id.people_count, "field 'peopleCountMessage'", TextView.class);
        View viewM5158a = Utils.m5158a(view, com.jibo.R.id.btnSet, "method 'okayClicked'");
        this.f10252c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.dialog.LoopInfoDialog_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                loopInfoDialog.okayClicked(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        LoopInfoDialog loopInfoDialog = this.f10251b;
        if (loopInfoDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10251b = null;
        loopInfoDialog.text = null;
        loopInfoDialog.peopleCountMessage = null;
        this.f10252c.setOnClickListener(null);
        this.f10252c = null;
    }
}
