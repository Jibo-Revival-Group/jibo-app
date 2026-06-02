package com.jibo.p019ui.fragment.wifi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.p019ui.activity.GuidedExperienceActivity;
import com.jibo.p019ui.activity.WifiActivity;
import com.jibo.p019ui.view.proxima.CustomFontButton;
import com.jibo.utils.LogUtils;

/* JADX INFO: loaded from: classes.dex */
public class WiFiSuccessFragment extends WiFiBaseFragment {

    /* JADX INFO: renamed from: a */
    public static final String f11414a = LogUtils.m11405a(WiFiSuccessFragment.class);

    /* JADX INFO: renamed from: b */
    private WifiActivity.Mode f11415b;

    @BindView
    CustomFontButton btnContinue;

    @BindView
    ImageView jiboImage;

    @BindView
    TextView txtInfo;

    @BindView
    TextView txtTitle;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        m10349k();
        this.f11415b = getActivity() instanceof WifiActivity ? ((WifiActivity) getActivity()).m10321t() : WifiActivity.Mode.INIT;
        return layoutInflater.inflate(R.layout.fragment_wifi_success, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        switch (this.f11415b) {
            case RECONNECT_SUSPENDED:
                this.txtTitle.setText(R.string.text_wifi_success_screen_title3);
                this.txtInfo.setText(R.string.text_wifi_success_screen_info3);
                this.jiboImage.setImageResource(R.drawable.jibo_all_set_up);
                this.btnContinue.setText(R.string.text_wifi_success_screen_go_button3);
                break;
            case INIT:
                this.txtTitle.setText(R.string.text_wifi_success_screen_title1);
                this.txtInfo.setText(R.string.text_wifi_success_screen_info1);
                this.jiboImage.setImageResource(R.drawable.getting_ready);
                this.btnContinue.setText(R.string.text_wifi_success_screen_go_button1);
                break;
            case RECONNECT:
                this.txtTitle.setText(R.string.text_wifi_success_screen_title2);
                this.txtInfo.setText(R.string.text_wifi_success_screen_info2);
                this.jiboImage.setImageResource(R.drawable.jibo_all_set_up);
                this.btnContinue.setText(R.string.text_wifi_success_screen_go_button2);
                break;
        }
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, com.jibo.p019ui.fragment.IBaseFragment
    /* JADX INFO: renamed from: h */
    public boolean mo10346h() {
        if (this.f11415b == WifiActivity.Mode.INIT) {
            Intent intent = new Intent();
            intent.putExtra(Loop.class.getSimpleName(), (Parcelable) this.f9934k);
            intent.putExtra("ARG_TAB_SELECTED", 0);
            getActivity().setResult(-1, intent);
        }
        getActivity().finish();
        return true;
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiBaseFragment, com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10334a(ActionBar actionBar) {
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return "";
    }

    @OnClick
    public void onBtnContinueClick(View view) {
        if (this.f11415b != WifiActivity.Mode.INIT) {
            mo10346h();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(Loop.class.getSimpleName(), (Parcelable) this.f9934k);
        intent.setClass(getContext(), GuidedExperienceActivity.class);
        getActivity().finish();
        getActivity().startActivity(intent);
    }
}
