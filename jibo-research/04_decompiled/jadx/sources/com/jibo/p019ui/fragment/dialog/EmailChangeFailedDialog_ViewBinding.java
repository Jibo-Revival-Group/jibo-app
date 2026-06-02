package com.jibo.p019ui.fragment.dialog;

import android.R;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

/* JADX INFO: loaded from: classes.dex */
public class EmailChangeFailedDialog_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private EmailChangeFailedDialog f10230b;

    /* JADX INFO: renamed from: c */
    private View f10231c;

    /* JADX INFO: renamed from: d */
    private View f10232d;

    public EmailChangeFailedDialog_ViewBinding(final EmailChangeFailedDialog emailChangeFailedDialog, View view) {
        this.f10230b = emailChangeFailedDialog;
        emailChangeFailedDialog.textView = (TextView) Utils.m5161b(view, R.id.text1, "field 'textView'", TextView.class);
        emailChangeFailedDialog.email = (TextView) Utils.m5161b(view, com.jibo.R.id.email, "field 'email'", TextView.class);
        emailChangeFailedDialog.footer = (TextView) Utils.m5161b(view, com.jibo.R.id.footer, "field 'footer'", TextView.class);
        View viewM5158a = Utils.m5158a(view, com.jibo.R.id.btnCancel, "method 'onCancelClicked'");
        this.f10231c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.dialog.EmailChangeFailedDialog_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                emailChangeFailedDialog.onCancelClicked(view2);
            }
        });
        View viewM5158a2 = Utils.m5158a(view, com.jibo.R.id.btnTryAgain, "method 'onTryAgainClicked'");
        this.f10232d = viewM5158a2;
        viewM5158a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.dialog.EmailChangeFailedDialog_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                emailChangeFailedDialog.onTryAgainClicked(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        EmailChangeFailedDialog emailChangeFailedDialog = this.f10230b;
        if (emailChangeFailedDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10230b = null;
        emailChangeFailedDialog.textView = null;
        emailChangeFailedDialog.email = null;
        emailChangeFailedDialog.footer = null;
        this.f10231c.setOnClickListener(null);
        this.f10231c = null;
        this.f10232d.setOnClickListener(null);
        this.f10232d = null;
    }
}
