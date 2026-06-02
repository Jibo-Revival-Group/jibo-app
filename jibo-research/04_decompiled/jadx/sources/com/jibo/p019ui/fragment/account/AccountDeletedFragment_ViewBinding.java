package com.jibo.p019ui.fragment.account;

import android.R;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

/* JADX INFO: loaded from: classes.dex */
public class AccountDeletedFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private AccountDeletedFragment f9977b;

    /* JADX INFO: renamed from: c */
    private View f9978c;

    public AccountDeletedFragment_ViewBinding(final AccountDeletedFragment accountDeletedFragment, View view) {
        this.f9977b = accountDeletedFragment;
        View viewM5158a = Utils.m5158a(view, R.id.closeButton, "field 'closeButton' and method 'onCloseButtonClick'");
        accountDeletedFragment.closeButton = (ImageView) Utils.m5162c(viewM5158a, R.id.closeButton, "field 'closeButton'", ImageView.class);
        this.f9978c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.account.AccountDeletedFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                accountDeletedFragment.onCloseButtonClick();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AccountDeletedFragment accountDeletedFragment = this.f9977b;
        if (accountDeletedFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f9977b = null;
        accountDeletedFragment.closeButton = null;
        this.f9978c.setOnClickListener(null);
        this.f9978c = null;
    }
}
