package com.jibo.p019ui.fragment.wifi;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.WindowManager;
import butterknife.OnClick;
import butterknife.Optional;
import com.jibo.R;
import com.jibo.p019ui.activity.BaseActivity;
import com.jibo.p019ui.fragment.BaseFragment;
import com.jibo.utils.LogUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class WiFiBaseFragment extends BaseFragment {

    /* JADX INFO: renamed from: d */
    public static final String f11312d = LogUtils.m11405a(WiFiBaseFragment.class);

    /* JADX INFO: renamed from: e */
    static Bundle f11313e = new Bundle();

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            f11313e.putAll(bundle);
        }
        setHasOptionsMenu(true);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putAll(f11313e);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10334a(ActionBar actionBar) {
        super.mo10334a(actionBar);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        m10350l();
        m11156b(actionBar);
    }

    @OnClick
    @Optional
    public void onBtnHelpClick(View view) {
        ((BaseActivity) getActivity()).m10193c(WiFiHelpFragment.class, null);
    }

    /* JADX INFO: renamed from: b */
    private void m11156b(ActionBar actionBar) {
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.jibo_blue)));
        actionBar.setHomeAsUpIndicator(R.drawable.arrow_white);
    }

    /* JADX INFO: renamed from: b */
    protected void m11157b() {
        WindowManager.LayoutParams attributes = getActivity().getWindow().getAttributes();
        attributes.screenBrightness = -1.0f;
        getActivity().getWindow().setAttributes(attributes);
    }
}
