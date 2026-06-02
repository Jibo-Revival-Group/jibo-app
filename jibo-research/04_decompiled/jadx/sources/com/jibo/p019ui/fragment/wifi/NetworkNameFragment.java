package com.jibo.p019ui.fragment.wifi;

import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.p019ui.activity.BaseActivity;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.LogUtils;
import com.jibo.utils.Util;

/* JADX INFO: loaded from: classes.dex */
public class NetworkNameFragment extends WiFiValidatedFragment {

    /* JADX INFO: renamed from: a */
    public static final String f11239a = LogUtils.m11405a(NetworkNameFragment.class);

    /* JADX INFO: renamed from: b */
    final TextWatcher f11240b = new TextWatcher() { // from class: com.jibo.ui.fragment.wifi.NetworkNameFragment.1
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            NetworkNameFragment.this.getActivity().invalidateOptionsMenu();
            NetworkNameFragment.this.m11124r();
        }
    };

    @BindView
    EditText editSSID;

    @BindView
    TextView footer;

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
        return layoutInflater.inflate(R.layout.fragment_wifi_network_name, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m11124r();
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.editSSID.addTextChangedListener(this.f11240b);
        this.editSSID.requestFocus();
        m10335a(this.editSSID);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.editSSID.removeTextChangedListener(this.f11240b);
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiValidatedFragment
    /* JADX INFO: renamed from: a */
    protected void mo11126a(MenuItem menuItem) {
        if (m11123q().length() > 0) {
            menuItem.setEnabled(true);
        } else {
            menuItem.setEnabled(false);
        }
        ImageUtils.m11394a(getActivity(), menuItem, menuItem.isEnabled() ? R.color.white : R.color.charlotte);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return getString(R.string.title_manually_enter_network);
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiValidatedFragment
    /* JADX INFO: renamed from: a */
    protected void mo11125a() {
        f11313e.putString("ARG_SSID", Util.m11489a(m11123q()));
        Bundle bundle = new Bundle();
        bundle.putParcelable(Loop.class.getSimpleName(), this.f9934k);
        ((BaseActivity) getActivity()).m10193c(NetworkPwdFragment.class, bundle);
    }

    /* JADX INFO: renamed from: q */
    private String m11123q() {
        try {
            return this.editSSID != null ? this.editSSID.getText().toString().trim() : "";
        } catch (Exception e) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: r */
    public void m11124r() {
        StringBuilder sb = new StringBuilder();
        String string = getString(R.string.label_enter_ssid_length);
        sb.append(getString(R.string.label_enter_ssid_prefix));
        sb.append(" ");
        sb.append(string);
        sb.append(" ");
        sb.append(getString(R.string.label_enter_ssid_suffix));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(sb);
        if (m11123q().length() >= 32) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.firecracker)), sb.indexOf(string), sb.indexOf(string) + string.length(), 18);
        }
        this.footer.setText(spannableStringBuilder);
    }
}
