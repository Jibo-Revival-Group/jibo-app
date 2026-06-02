package com.jibo.p019ui.fragment.wifi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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
import com.jibo.utils.ImageUtils;
import com.jibo.utils.LogUtils;
import com.jibo.utils.Util;

/* JADX INFO: loaded from: classes.dex */
public class WiFiError1Fragment extends WiFiHelpAbstractFragment {

    /* JADX INFO: renamed from: a */
    public static final String f11344a = LogUtils.m11405a(WiFiError1Fragment.class);

    @BindView
    TextView btnTryAgain;

    @BindView
    EditText editPassword;

    @BindView
    EditText editSSID;

    @BindView
    TextView txtPasswordHint;

    /* JADX INFO: renamed from: b */
    final TextWatcher f11345b = new TextWatcher() { // from class: com.jibo.ui.fragment.wifi.WiFiError1Fragment.1
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WiFiError1Fragment.this.m11184r();
        }
    };

    /* JADX INFO: renamed from: c */
    final TextWatcher f11346c = new TextWatcher() { // from class: com.jibo.ui.fragment.wifi.WiFiError1Fragment.2
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WiFiError1Fragment.this.m11184r();
        }
    };

    @Override // com.jibo.p019ui.fragment.wifi.WiFiHelpAbstractFragment, android.support.v4.app.Fragment
    public /* bridge */ /* synthetic */ void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiHelpAbstractFragment, android.support.v4.app.Fragment
    public /* bridge */ /* synthetic */ boolean onOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_wifi_error1, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (bundle == null) {
            this.editSSID.setText(f11313e.getString("ARG_SSID"));
            this.editPassword.setText(f11313e.getString("ARG_PASSWORD"));
        }
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.editSSID.addTextChangedListener(this.f11345b);
        this.editPassword.addTextChangedListener(this.f11346c);
        m11184r();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.editSSID.removeTextChangedListener(this.f11345b);
        this.editPassword.removeTextChangedListener(this.f11346c);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return getString(R.string.title_wifi_error1_screen);
    }

    @OnClick
    public void btnTryAgainClick(View view) {
        m10343e();
        f11313e.putString("ARG_SSID", Util.m11489a(m11181a()));
        f11313e.putString("ARG_PASSWORD", m11183q());
        getActivity().getSupportFragmentManager().mo1475a(WiFiQRCodeFragment.class.getSimpleName(), 0);
    }

    @OnClick
    public void btnSupportClick(View view) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getString(R.string.support_faq_error1_url))));
    }

    /* JADX INFO: renamed from: a */
    private String m11181a() {
        try {
            return this.editSSID != null ? this.editSSID.getText().toString().trim() : "";
        } catch (Exception e) {
            return "";
        }
    }

    /* JADX INFO: renamed from: q */
    private String m11183q() {
        try {
            return this.editPassword != null ? this.editPassword.getText().toString().trim() : "";
        } catch (Exception e) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: r */
    public void m11184r() {
        String string;
        StringBuilder sb = new StringBuilder();
        if (Util.m11489a(m11181a()).isEmpty()) {
            sb.append(getString(R.string.error_ssid_empty)).append("\n");
        }
        if (!m11183q().isEmpty() && m11183q().length() < 8) {
            sb.append(getString(R.string.error_password_not_long_enough)).append("\n");
        }
        boolean z = sb.toString().length() == 0;
        this.txtPasswordHint.setTextColor(ImageUtils.m11399b(getActivity(), !z ? R.color.firecracker : R.color.steel));
        this.txtPasswordHint.setText(!z ? sb.toString() : getString(R.string.label_enter_ssid_pwd));
        EditText editText = this.editPassword;
        if (Util.m11489a(m11181a()).length() > 0) {
            string = Util.m11489a(m11181a()) + getString(R.string.hint_wifi_password);
        } else {
            string = getString(R.string.hint_wifi_password_simple);
        }
        editText.setHint(string);
        this.btnTryAgain.setEnabled(z);
    }
}
