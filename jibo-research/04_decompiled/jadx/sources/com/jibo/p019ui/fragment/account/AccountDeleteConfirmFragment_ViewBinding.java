package com.jibo.p019ui.fragment.account;

import android.R;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.p019ui.view.proxima.CustomFontTextView;

/* JADX INFO: loaded from: classes.dex */
public class AccountDeleteConfirmFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private AccountDeleteConfirmFragment f9961b;

    /* JADX INFO: renamed from: c */
    private View f9962c;

    /* JADX INFO: renamed from: d */
    private View f9963d;

    public AccountDeleteConfirmFragment_ViewBinding(final AccountDeleteConfirmFragment accountDeleteConfirmFragment, View view) {
        this.f9961b = accountDeleteConfirmFragment;
        View viewM5158a = Utils.m5158a(view, R.id.closeButton, "field 'closeButton' and method 'onCloseButtonClick'");
        accountDeleteConfirmFragment.closeButton = (ImageView) Utils.m5162c(viewM5158a, R.id.closeButton, "field 'closeButton'", ImageView.class);
        this.f9962c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.account.AccountDeleteConfirmFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                accountDeleteConfirmFragment.onCloseButtonClick();
            }
        });
        accountDeleteConfirmFragment.cross1 = (ImageView) Utils.m5161b(view, com.jibo.R.id.cross1, "field 'cross1'", ImageView.class);
        accountDeleteConfirmFragment.cross2 = (ImageView) Utils.m5161b(view, com.jibo.R.id.cross2, "field 'cross2'", ImageView.class);
        accountDeleteConfirmFragment.cross3 = (ImageView) Utils.m5161b(view, com.jibo.R.id.cross3, "field 'cross3'", ImageView.class);
        accountDeleteConfirmFragment.cross4 = (ImageView) Utils.m5161b(view, com.jibo.R.id.cross4, "field 'cross4'", ImageView.class);
        accountDeleteConfirmFragment.hideWarning = Utils.m5158a(view, com.jibo.R.id.hideWarning, "field 'hideWarning'");
        accountDeleteConfirmFragment.title = (CustomFontTextView) Utils.m5161b(view, com.jibo.R.id.title, "field 'title'", CustomFontTextView.class);
        accountDeleteConfirmFragment.warning1 = (CustomFontTextView) Utils.m5161b(view, com.jibo.R.id.warning1, "field 'warning1'", CustomFontTextView.class);
        accountDeleteConfirmFragment.warning2 = (CustomFontTextView) Utils.m5161b(view, com.jibo.R.id.warning2, "field 'warning2'", CustomFontTextView.class);
        accountDeleteConfirmFragment.warning3 = (CustomFontTextView) Utils.m5161b(view, com.jibo.R.id.warning3, "field 'warning3'", CustomFontTextView.class);
        View viewM5158a2 = Utils.m5158a(view, com.jibo.R.id.btnDelete, "method 'onBtnDelete'");
        this.f9963d = viewM5158a2;
        viewM5158a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.account.AccountDeleteConfirmFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                accountDeleteConfirmFragment.onBtnDelete();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AccountDeleteConfirmFragment accountDeleteConfirmFragment = this.f9961b;
        if (accountDeleteConfirmFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f9961b = null;
        accountDeleteConfirmFragment.closeButton = null;
        accountDeleteConfirmFragment.cross1 = null;
        accountDeleteConfirmFragment.cross2 = null;
        accountDeleteConfirmFragment.cross3 = null;
        accountDeleteConfirmFragment.cross4 = null;
        accountDeleteConfirmFragment.hideWarning = null;
        accountDeleteConfirmFragment.title = null;
        accountDeleteConfirmFragment.warning1 = null;
        accountDeleteConfirmFragment.warning2 = null;
        accountDeleteConfirmFragment.warning3 = null;
        this.f9962c.setOnClickListener(null);
        this.f9962c = null;
        this.f9963d.setOnClickListener(null);
        this.f9963d = null;
    }
}
