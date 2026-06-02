package com.jibo.p019ui.fragment.settings;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.loop.model.Member;
import com.jibo.aws.integration.aws.services.robotProperties.model.Robot;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.aws.integration.helpers.RobotHelper;
import com.jibo.p019ui.fragment.BaseFragment;

/* JADX INFO: loaded from: classes.dex */
public class RobotAboutFragment extends BaseFragment {

    /* JADX INFO: renamed from: a */
    public static final String f11070a = RobotAboutFragment.class.getSimpleName();

    /* JADX INFO: renamed from: b */
    private Robot f11071b;

    @BindView
    TextView osVersion;

    @BindView
    TextView ownerEmail;

    @BindView
    TextView ownerName;

    @BindView
    TextView serialName;

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f11071b = (Robot) bundle.getParcelable(Robot.class.getSimpleName());
        } else if (getArguments() != null) {
            this.f11071b = (Robot) getArguments().getParcelable(Robot.class.getSimpleName());
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_robot_about, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Member owner = LoopHelper.getOwner(this.f9934k);
        if (TextUtils.isEmpty(owner.getNickname())) {
            this.ownerName.setText(owner.getAccount().getFullName());
        } else {
            this.ownerName.setText(owner.getNickname());
        }
        this.ownerEmail.setText(owner.getAccount().getEmail());
        this.osVersion.setText(TextUtils.isEmpty(RobotHelper.getRobotOS(this.f11071b)) ? getString(R.string.robot_info_not_available) : RobotHelper.getRobotOS(this.f11071b));
        this.serialName.setText(TextUtils.isEmpty(RobotHelper.getRobotSerialName(this.f11071b)) ? getString(R.string.robot_info_not_available) : RobotHelper.getRobotSerialName(this.f11071b));
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(Robot.class.getSimpleName(), this.f11071b);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f9934k == null) {
            getActivity().onBackPressed();
        }
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10334a(ActionBar actionBar) {
        super.mo10334a(actionBar);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return getString(R.string.title_robot_about);
    }
}
