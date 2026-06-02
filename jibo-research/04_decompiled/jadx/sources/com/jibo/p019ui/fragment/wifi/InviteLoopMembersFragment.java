package com.jibo.p019ui.fragment.wifi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.OnClick;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.p019ui.activity.SingleFragmentActivity;
import com.jibo.p019ui.fragment.invite.NameBirthdayGenderFragment;
import com.jibo.p019ui.view.proxima.CustomFontButton;
import com.jibo.utils.LogUtils;

/* JADX INFO: loaded from: classes.dex */
public class InviteLoopMembersFragment extends WiFiBaseFragment {

    /* JADX INFO: renamed from: a */
    public static final String f11199a = LogUtils.m11405a(InviteLoopMembersFragment.class);

    /* JADX INFO: renamed from: b */
    private Loop f11200b = null;

    @BindView
    CustomFontButton btnInvitePeople;

    @BindView
    ImageView closeButton;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_wifi_invite_loop_members, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.closeButton.setImageResource(R.drawable.arrow_blue);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1005) {
            Intent intent2 = new Intent();
            intent2.putExtra(Loop.class.getSimpleName(), (Parcelable) this.f11200b);
            intent2.putExtra("ARG_TAB_SELECTED", 0);
            getActivity().setResult(-1, intent2);
            getActivity().finish();
        }
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f11200b == null) {
            getActivity().finish();
        }
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiBaseFragment, com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(Loop.class.getSimpleName(), this.f11200b);
    }

    @Override // android.support.v4.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 96) {
            SingleFragmentActivity.Builder builder = new SingleFragmentActivity.Builder(this, NameBirthdayGenderFragment.class.getName());
            builder.m10272a(Loop.class.getSimpleName(), (Parcelable) this.f11200b);
            builder.m10275a(1005);
        }
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: b */
    public void mo10340b(Bundle bundle) {
        super.mo10340b(bundle);
        this.f11200b = (Loop) bundle.getParcelable(Loop.class.getSimpleName());
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiBaseFragment, com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10334a(ActionBar actionBar) {
        super.mo10334a(actionBar);
        m10349k();
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return "";
    }

    @OnClick
    public void onCloseClick(View view) {
        getActivity().onBackPressed();
    }

    @OnClick
    public void btnInvitePeople(View view) {
        if (PermissionChecker.m1896a(getActivity(), "android.permission.READ_CONTACTS") == 0) {
            SingleFragmentActivity.Builder builder = new SingleFragmentActivity.Builder(this, NameBirthdayGenderFragment.class.getName());
            builder.m10272a(Loop.class.getSimpleName(), (Parcelable) this.f11200b);
            builder.m10275a(1005);
            return;
        }
        requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 96);
    }
}
