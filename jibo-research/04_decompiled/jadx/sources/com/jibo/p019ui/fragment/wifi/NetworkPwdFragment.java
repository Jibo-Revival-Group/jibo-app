package com.jibo.p019ui.fragment.wifi;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.p019ui.activity.BaseActivity;
import com.jibo.p019ui.fragment.wifi.StaticOptionsDialogFragment;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.LogUtils;

/* JADX INFO: loaded from: classes.dex */
public class NetworkPwdFragment extends WiFiValidatedFragment implements StaticOptionsDialogFragment.OnStaticOptionsChangeListener {

    /* JADX INFO: renamed from: a */
    public static final String f11243a = LogUtils.m11405a(NetworkPwdFragment.class);

    /* JADX INFO: renamed from: b */
    final TextWatcher f11244b = new TextWatcher() { // from class: com.jibo.ui.fragment.wifi.NetworkPwdFragment.1
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            NetworkPwdFragment.this.m11128q();
            NetworkPwdFragment.this.getActivity().invalidateOptionsMenu();
        }
    };

    @BindView
    TextView btnStaticOptions;

    @BindView
    EditText editPassword;

    @BindView
    TextView txtPasswordHint;

    @Override // com.jibo.p019ui.fragment.wifi.WiFiValidatedFragment, android.support.v4.app.Fragment
    public /* bridge */ /* synthetic */ void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiValidatedFragment, android.support.v4.app.Fragment
    public /* bridge */ /* synthetic */ boolean onOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_wifi_network_pwd, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m10352n();
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.editPassword.setHint(f11313e.getString("ARG_SSID") + getString(R.string.hint_wifi_password));
        this.btnStaticOptions.setText(f11313e.getString("ARG_IPADDRESS", null) == null ? R.string.btn_show_static_ip_options : R.string.btn_edit_static_ip_options);
        m11128q();
        this.editPassword.addTextChangedListener(this.f11244b);
        if (getActivity().getSupportFragmentManager().mo1481e() > 4) {
            onStaticClick(null);
        } else {
            this.editPassword.requestFocus();
            m10335a(this.editPassword);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.editPassword.removeTextChangedListener(this.f11244b);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, com.jibo.p019ui.fragment.IBaseFragment
    /* JADX INFO: renamed from: h */
    public boolean mo10346h() {
        if (getActivity().getSupportFragmentManager().mo1481e() <= 3) {
            f11313e.remove("ARG_IPADDRESS");
            f11313e.remove("ARG_SUBNETMASK");
            f11313e.remove("ARG_ROUTER");
            f11313e.remove("ARG_DNS1");
            f11313e.remove("ARG_DNS2");
        }
        return super.mo10346h();
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
        return getString(R.string.title_wifi_credentials);
    }

    @OnClick
    public void onStaticClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putAll(f11313e);
        StaticOptionsDialogFragment staticOptionsDialogFragment = new StaticOptionsDialogFragment();
        staticOptionsDialogFragment.setArguments(bundle);
        staticOptionsDialogFragment.setTargetFragment(this, 0);
        staticOptionsDialogFragment.show(getActivity().getSupportFragmentManager(), StaticOptionsDialogFragment.class.getSimpleName());
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiValidatedFragment
    /* JADX INFO: renamed from: a */
    protected void mo11126a(MenuItem menuItem) {
        menuItem.setEnabled(m11129r().length() >= 8 || m11129r().length() == 0);
        ImageUtils.m11394a(getActivity(), menuItem, menuItem.isEnabled() ? R.color.white : R.color.charlotte);
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiValidatedFragment
    /* JADX INFO: renamed from: a */
    protected void mo11125a() {
        m10343e();
        f11313e.putString("ARG_PASSWORD", m11129r());
        if (getActivity().getSupportFragmentManager().mo1481e() > 4) {
            getActivity().getSupportFragmentManager().mo1475a(WiFiHelpFragment.class.getSimpleName(), 1);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable(Loop.class.getSimpleName(), this.f9934k);
        ((BaseActivity) getActivity()).m10193c(WaitForTapFragment.class, bundle);
    }

    @Override // com.jibo.ui.fragment.wifi.StaticOptionsDialogFragment.OnStaticOptionsChangeListener
    /* JADX INFO: renamed from: a */
    public void mo11130a(String str, String str2, String str3, String str4, String str5) {
        f11313e.putString("ARG_IPADDRESS", str);
        f11313e.putString("ARG_SUBNETMASK", str2);
        f11313e.putString("ARG_ROUTER", str3);
        f11313e.putString("ARG_DNS1", str4);
        f11313e.putString("ARG_DNS2", str5);
        this.btnStaticOptions.setText(f11313e.getString("ARG_IPADDRESS", null) == null ? R.string.btn_show_static_ip_options : R.string.btn_edit_static_ip_options);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: q */
    public void m11128q() {
        if (!m11129r().isEmpty() && m11129r().length() < 8) {
            this.txtPasswordHint.setText(R.string.error_password_not_long_enough);
            this.txtPasswordHint.setTextColor(ImageUtils.m11399b(getActivity(), R.color.firecracker));
        } else {
            this.txtPasswordHint.setText(R.string.label_wifi_password);
            this.txtPasswordHint.setTextColor(ImageUtils.m11399b(getActivity(), R.color.steel));
        }
    }

    /* JADX INFO: renamed from: r */
    private String m11129r() {
        try {
            return this.editPassword != null ? this.editPassword.getText().toString().trim() : "";
        } catch (Exception e) {
            return "";
        }
    }
}
