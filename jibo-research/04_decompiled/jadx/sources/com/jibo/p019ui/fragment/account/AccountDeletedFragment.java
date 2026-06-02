package com.jibo.p019ui.fragment.account;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.OnClick;
import com.jibo.JiboAnalytics;
import com.jibo.R;
import com.jibo.p019ui.activity.TabbedActivity;
import com.jibo.p019ui.fragment.BaseFragment;
import com.jibo.utils.ImageUtils;

/* JADX INFO: loaded from: classes.dex */
public class AccountDeletedFragment extends BaseFragment {

    /* JADX INFO: renamed from: a */
    public static final String f9976a = AccountDeletedFragment.class.getSimpleName();

    @BindView
    ImageView closeButton;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        m10349k();
        return layoutInflater.inflate(R.layout.fragment_account_deleted, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.closeButton.setImageDrawable(ImageUtils.m11392a(getActivity(), R.drawable.x_white, R.color.jibo_blue));
        String string = getArguments() != null ? getArguments().getString(JiboAnalytics.f9227ak, "") : "";
        if (string.equals(JiboAnalytics.f9206aG) || string.equals(JiboAnalytics.f9205aF)) {
        }
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10334a(ActionBar actionBar) {
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return "";
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, com.jibo.p019ui.fragment.IBaseFragment
    /* JADX INFO: renamed from: h */
    public boolean mo10346h() {
        onCloseButtonClick();
        return true;
    }

    @OnClick
    public void onCloseButtonClick() {
        getActivity().setResult(TabbedActivity.f9761c);
        getActivity().finish();
    }
}
