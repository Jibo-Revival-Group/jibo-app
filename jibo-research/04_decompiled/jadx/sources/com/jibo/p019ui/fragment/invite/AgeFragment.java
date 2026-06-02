package com.jibo.p019ui.fragment.invite;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import butterknife.BindView;
import com.jibo.R;
import com.jibo.utils.LogUtils;
import com.jibo.utils.UIUtils;

/* JADX INFO: loaded from: classes.dex */
public class AgeFragment extends BaseLoopInviteFragment {

    /* JADX INFO: renamed from: a */
    public static final String f10395a = LogUtils.m11405a(AgeFragment.class);

    @BindView
    RadioButton mChild;

    @BindView
    RadioButton mTeenageOrAdult;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_age, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment, android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        this.f10405p.setEnabled(true);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return getString(R.string.title_invite_loop_member);
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment
    /* JADX INFO: renamed from: a */
    public void mo10660a() {
        this.mTeenageOrAdult.setText(UIUtils.m11473a(getActivity(), getString(R.string.title_teen_or_adult), getString(R.string.age_13_or_older)));
        this.mChild.setText(UIUtils.m11473a(getActivity(), getString(R.string.title_child), getString(R.string.age_under_13)));
        this.mTeenageOrAdult.setChecked(true);
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment
    /* JADX INFO: renamed from: b */
    public void mo10661b() {
        this.f10397b = Boolean.valueOf(this.mChild.isChecked());
        this.f10398c.setBirthday(null);
        if (!this.f10397b.booleanValue()) {
            m10673a(NameBirthdayGenderFragment.class);
        } else {
            m10673a(SelectGuardianFragment.class);
        }
    }
}
