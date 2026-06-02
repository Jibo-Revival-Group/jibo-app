package com.jibo.p019ui.fragment.dialog;

import android.R;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

/* JADX INFO: loaded from: classes.dex */
public class AlreadyInTheLoopDialog_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private AlreadyInTheLoopDialog f10156b;

    /* JADX INFO: renamed from: c */
    private View f10157c;

    /* JADX INFO: renamed from: d */
    private View f10158d;

    public AlreadyInTheLoopDialog_ViewBinding(final AlreadyInTheLoopDialog alreadyInTheLoopDialog, View view) {
        this.f10156b = alreadyInTheLoopDialog;
        alreadyInTheLoopDialog.textView = (TextView) Utils.m5161b(view, R.id.text1, "field 'textView'", TextView.class);
        View viewM5158a = Utils.m5158a(view, com.jibo.R.id.edit_invite, "method 'onAdultClicked'");
        this.f10157c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.dialog.AlreadyInTheLoopDialog_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                alreadyInTheLoopDialog.onAdultClicked(view2);
            }
        });
        View viewM5158a2 = Utils.m5158a(view, com.jibo.R.id.view_profile, "method 'onViewProfileClicked'");
        this.f10158d = viewM5158a2;
        viewM5158a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.dialog.AlreadyInTheLoopDialog_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                alreadyInTheLoopDialog.onViewProfileClicked(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AlreadyInTheLoopDialog alreadyInTheLoopDialog = this.f10156b;
        if (alreadyInTheLoopDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10156b = null;
        alreadyInTheLoopDialog.textView = null;
        this.f10157c.setOnClickListener(null);
        this.f10157c = null;
        this.f10158d.setOnClickListener(null);
        this.f10158d = null;
    }
}
