package com.jibo.p019ui.fragment.invite;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.loop.model.Member;
import com.jibo.p019ui.fragment.invite.EmailFragment;

/* JADX INFO: loaded from: classes.dex */
public class EmailInviteInfoFragment extends BaseLoopInviteFragment {

    /* JADX INFO: renamed from: a */
    private EmailFragment.LaunchMode f10439a;

    /* JADX INFO: renamed from: r */
    private Member f10440r;

    @BindView
    TextView text;

    @BindView
    TextView title;

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment, com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_email_invite_info, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment, com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: b */
    public void mo10340b(Bundle bundle) {
        super.mo10340b(bundle);
        if (bundle.containsKey("ARG_MODE")) {
            this.f10439a = EmailFragment.LaunchMode.values()[bundle.getInt("ARG_MODE")];
        }
        if (bundle.containsKey(Member.class.getSimpleName())) {
            this.f10440r = (Member) bundle.getParcelable(Member.class.getSimpleName());
        }
    }

    @OnClick
    public void goToEmail(View view) {
        if (this.f10439a == EmailFragment.LaunchMode.add_email) {
            Bundle bundle = new Bundle();
            bundle.putInt("ARG_MODE", EmailFragment.LaunchMode.add_email.ordinal());
            bundle.putParcelable(Member.class.getSimpleName(), this.f10440r);
            m10674a(NewEmailFragment.class, bundle);
            return;
        }
        m10673a(EmailFragment.class);
    }

    @OnClick
    public void dontGoToEMail(View view) {
        if (this.f10439a == EmailFragment.LaunchMode.add_email) {
            getActivity().finish();
        } else {
            this.f10398c.setEmail(null);
            m10676q();
        }
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return getString(R.string.invite_to_gallery);
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment, com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10334a(ActionBar actionBar) {
        super.mo10334a(actionBar);
        m10349k();
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment
    /* JADX INFO: renamed from: a */
    public void mo10660a() {
        String str;
        Account.Gender gender;
        String string;
        if (this.f10403n != null) {
            str = this.f10403n.getFirstName() + " " + this.f10403n.getLastName();
        } else {
            str = this.f10398c.getFirstName() + " " + this.f10398c.getLastName();
        }
        String str2 = TextUtils.isEmpty(this.f10399d) ? str : this.f10399d;
        this.title.setText(getString(R.string.email_invite_info_title, str));
        if (this.f10403n == null) {
            gender = this.f10398c.getGender();
        } else {
            gender = this.f10403n.getGender();
        }
        String string2 = getString(R.string.their);
        if (gender == Account.Gender.female) {
            string = getString(R.string.his);
        } else {
            string = gender == Account.Gender.male ? getString(R.string.her) : string2;
        }
        this.text.setText(getString(R.string.email_invite_info_text, str2, string));
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment
    /* JADX INFO: renamed from: b */
    public void mo10661b() {
    }
}
