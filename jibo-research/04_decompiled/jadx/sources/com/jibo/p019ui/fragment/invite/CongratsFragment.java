package com.jibo.p019ui.fragment.invite;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;
import butterknife.BindView;
import butterknife.OnClick;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.utils.SharedPreferencesUtil;

/* JADX INFO: loaded from: classes.dex */
public class CongratsFragment extends BaseLoopInviteFragment {

    @BindView
    TextView text;

    @BindView
    TextView title;

    @BindView
    VideoView video;

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment, com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_invite_congrats, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment, com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m10341c().postDelayed(new Runnable() { // from class: com.jibo.ui.fragment.invite.CongratsFragment.1
            @Override // java.lang.Runnable
            public void run() {
                CongratsFragment.this.video.setVideoURI(Uri.parse("android.resource://" + CongratsFragment.this.getContext().getPackageName() + "/" + R.raw.video_congrats));
                CongratsFragment.this.video.start();
            }
        }, 800L);
    }

    @OnClick
    public void onViewMyLoop(View view) {
        m10689r();
    }

    @OnClick
    public void onDontShowAgain(View view) {
        SharedPreferencesUtil.m11452l(getContext());
        m10689r();
    }

    /* JADX INFO: renamed from: r */
    private void m10689r() {
        getActivity().setResult(-1);
        getActivity().finish();
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return getString(R.string.title_your_loops);
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
        String firstName = TextUtils.isEmpty(this.f10399d) ? this.f10398c.getFirstName() : this.f10399d;
        this.title.setText(getString(R.string.invite_congrats_title, firstName));
        this.text.setText(getString(R.string.invite_congrats_text, firstName, getString(m10690s())));
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment
    /* JADX INFO: renamed from: b */
    public void mo10661b() {
    }

    /* JADX INFO: renamed from: s */
    private int m10690s() {
        if (this.f10398c.getGender().equals(Account.Gender.male)) {
            return R.string.his;
        }
        if (this.f10398c.getGender().equals(Account.Gender.female)) {
            return R.string.her;
        }
        return R.string.their;
    }
}
