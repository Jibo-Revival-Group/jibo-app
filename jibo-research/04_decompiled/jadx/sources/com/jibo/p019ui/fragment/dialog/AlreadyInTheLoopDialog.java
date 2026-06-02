package com.jibo.p019ui.fragment.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.loop.model.Member;
import com.jibo.p019ui.activity.SingleFragmentActivity;
import com.jibo.p019ui.fragment.profile.ProfileFragment;

/* JADX INFO: loaded from: classes.dex */
public class AlreadyInTheLoopDialog extends DialogFragment {

    /* JADX INFO: renamed from: a */
    Unbinder f10153a;

    /* JADX INFO: renamed from: b */
    private Loop f10154b;

    /* JADX INFO: renamed from: c */
    private Account f10155c;

    @BindView
    TextView textView;

    @Override // android.support.v4.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        TextView textView = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.dialog_title, (ViewGroup) null);
        textView.setText(R.string.email_present_title);
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_already_in_loop, (ViewGroup) null);
        AlertDialog.Builder builderM3233b = new AlertDialog.Builder(getActivity()).m3225a(textView).m3233b(viewInflate);
        this.f10153a = ButterKnife.m5154a(this, viewInflate);
        this.f10154b = (Loop) (bundle != null ? bundle.getParcelable(Loop.class.getSimpleName()) : getArguments().getParcelable(Loop.class.getSimpleName()));
        this.f10155c = (Account) (bundle != null ? bundle.getParcelable(Account.class.getSimpleName()) : getArguments().getParcelable(Account.class.getSimpleName()));
        if (this.f10155c != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getString(R.string.email_already_in_loop, this.f10155c.getFullName(), this.f10155c.getEmail()));
            spannableStringBuilder.setSpan(new StyleSpan(1), 0, this.f10155c.getFullName().length(), 33);
            this.textView.setText(spannableStringBuilder);
        }
        return builderM3233b.m3236b();
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f10153a.unbind();
    }

    @OnClick
    public void onAdultClicked(View view) {
        dismiss();
    }

    @OnClick
    public void onViewProfileClicked(View view) {
        String email;
        Member member = null;
        for (Member member2 : this.f10154b.getMembers()) {
            if (member2.getAccount() == null || (email = member2.getAccount().getEmail()) == null || !email.equals(this.f10155c.getEmail())) {
                member2 = member;
            }
            member = member2;
        }
        if (member != null) {
            SingleFragmentActivity.Builder builder = new SingleFragmentActivity.Builder(getActivity(), ProfileFragment.class.getName());
            builder.m10272a(Member.class.getSimpleName(), (Parcelable) member).m10272a(Loop.class.getSimpleName(), (Parcelable) this.f10154b).m10274a("ARGS_ALLOW_EDIT", false);
            builder.m10275a(1007);
            dismiss();
        }
    }
}
