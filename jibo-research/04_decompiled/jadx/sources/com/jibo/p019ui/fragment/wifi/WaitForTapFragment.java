package com.jibo.p019ui.fragment.wifi;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.OnClick;
import com.jibo.JiboSupport;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.p019ui.activity.BaseActivity;
import com.jibo.utils.LogUtils;

/* JADX INFO: loaded from: classes.dex */
public class WaitForTapFragment extends WiFiBaseFragment {

    /* JADX INFO: renamed from: a */
    public static final String f11304a = LogUtils.m11405a(WaitForTapFragment.class);

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_wifi_wait_for_tap, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m10351m();
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiBaseFragment, com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10334a(ActionBar actionBar) {
        super.mo10334a(actionBar);
        actionBar.setHomeAsUpIndicator(R.drawable.arrow_white);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return "";
    }

    @OnClick
    public void btnJiboOkClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(Loop.class.getSimpleName(), this.f9934k);
        ((BaseActivity) getActivity()).m10187a(WiFiTokenGetterFragment.class, bundle);
    }

    @OnClick
    public void btnNoScreenClick(View view) {
        JiboSupport.m9868a((Activity) getActivity());
    }
}
