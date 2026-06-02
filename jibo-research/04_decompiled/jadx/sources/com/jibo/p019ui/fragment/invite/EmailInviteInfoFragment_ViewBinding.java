package com.jibo.p019ui.fragment.invite;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class EmailInviteInfoFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private EmailInviteInfoFragment f10441b;

    /* JADX INFO: renamed from: c */
    private View f10442c;

    /* JADX INFO: renamed from: d */
    private View f10443d;

    public EmailInviteInfoFragment_ViewBinding(final EmailInviteInfoFragment emailInviteInfoFragment, View view) {
        this.f10441b = emailInviteInfoFragment;
        emailInviteInfoFragment.title = (TextView) Utils.m5161b(view, R.id.title, "field 'title'", TextView.class);
        emailInviteInfoFragment.text = (TextView) Utils.m5161b(view, R.id.text, "field 'text'", TextView.class);
        View viewM5158a = Utils.m5158a(view, R.id.btnYes, "method 'goToEmail'");
        this.f10442c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.invite.EmailInviteInfoFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                emailInviteInfoFragment.goToEmail(view2);
            }
        });
        View viewM5158a2 = Utils.m5158a(view, R.id.btnNo, "method 'dontGoToEMail'");
        this.f10443d = viewM5158a2;
        viewM5158a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.invite.EmailInviteInfoFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                emailInviteInfoFragment.dontGoToEMail(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        EmailInviteInfoFragment emailInviteInfoFragment = this.f10441b;
        if (emailInviteInfoFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10441b = null;
        emailInviteInfoFragment.title = null;
        emailInviteInfoFragment.text = null;
        this.f10442c.setOnClickListener(null);
        this.f10442c = null;
        this.f10443d.setOnClickListener(null);
        this.f10443d = null;
    }
}
