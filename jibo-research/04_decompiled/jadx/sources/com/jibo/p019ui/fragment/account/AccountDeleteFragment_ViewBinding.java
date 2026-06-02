package com.jibo.p019ui.fragment.account;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class AccountDeleteFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private AccountDeleteFragment f9972b;

    /* JADX INFO: renamed from: c */
    private View f9973c;

    public AccountDeleteFragment_ViewBinding(final AccountDeleteFragment accountDeleteFragment, View view) {
        this.f9972b = accountDeleteFragment;
        accountDeleteFragment.mLeaveReasonGroup = (RadioGroup) Utils.m5161b(view, R.id.leaveReasonGroup, "field 'mLeaveReasonGroup'", RadioGroup.class);
        accountDeleteFragment.reason1 = (RadioButton) Utils.m5161b(view, R.id.delete_reason1, "field 'reason1'", RadioButton.class);
        accountDeleteFragment.reason2 = (RadioButton) Utils.m5161b(view, R.id.delete_reason2, "field 'reason2'", RadioButton.class);
        accountDeleteFragment.reason3 = (RadioButton) Utils.m5161b(view, R.id.delete_reason3, "field 'reason3'", RadioButton.class);
        accountDeleteFragment.reason4 = (RadioButton) Utils.m5161b(view, R.id.delete_reason4, "field 'reason4'", RadioButton.class);
        accountDeleteFragment.footer = (TextView) Utils.m5161b(view, R.id.footer, "field 'footer'", TextView.class);
        View viewM5158a = Utils.m5158a(view, R.id.btnDelete, "field 'btnDelete' and method 'onBtnDelete'");
        accountDeleteFragment.btnDelete = viewM5158a;
        this.f9973c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.account.AccountDeleteFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                accountDeleteFragment.onBtnDelete();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AccountDeleteFragment accountDeleteFragment = this.f9972b;
        if (accountDeleteFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f9972b = null;
        accountDeleteFragment.mLeaveReasonGroup = null;
        accountDeleteFragment.reason1 = null;
        accountDeleteFragment.reason2 = null;
        accountDeleteFragment.reason3 = null;
        accountDeleteFragment.reason4 = null;
        accountDeleteFragment.footer = null;
        accountDeleteFragment.btnDelete = null;
        this.f9973c.setOnClickListener(null);
        this.f9973c = null;
    }
}
