package com.jibo.p019ui.fragment.wifi;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.jibo.R;
import com.jibo.utils.Commons;
import com.jibo.utils.SubnetUtils;
import java.security.InvalidParameterException;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class StaticOptionsDialogFragment extends DialogFragment {

    /* JADX INFO: renamed from: a */
    Unbinder f11296a;

    @BindView
    EditText editDns1;

    @BindView
    EditText editDns2;

    @BindView
    EditText editIpAddress;

    @BindView
    EditText editRouter;

    @BindView
    EditText editSubnetMask;

    public interface OnStaticOptionsChangeListener {
        /* JADX INFO: renamed from: a */
        void mo11130a(String str, String str2, String str3, String str4, String str5);
    }

    @Override // android.support.v4.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        TextView textView = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.dialog_title, (ViewGroup) null);
        textView.setText(R.string.dialog_title_static_settings);
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_static_ip_options, (ViewGroup) null);
        AlertDialog.Builder builderM3230a = new AlertDialog.Builder(getActivity()).m3225a(textView).m3233b(viewInflate).m3230a(true);
        this.f11296a = ButterKnife.m5154a(this, viewInflate);
        if (bundle == null) {
            this.editIpAddress.setText(getArguments().getString("ARG_IPADDRESS", getString(R.string.text_default_ip_value)));
            this.editSubnetMask.setText(getArguments().getString("ARG_SUBNETMASK", getString(R.string.text_default_ip_value)));
            this.editRouter.setText(getArguments().getString("ARG_ROUTER", getString(R.string.text_default_ip_value)));
            this.editDns1.setText(getArguments().getString("ARG_DNS1", getString(R.string.text_default_dns1_value)));
            this.editDns2.setText(getArguments().getString("ARG_DNS2", getString(R.string.text_default_dns2_value)));
        }
        return builderM3230a.m3236b();
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f11296a.unbind();
    }

    @OnClick
    public void onCancelClicked(View view) {
        dismiss();
    }

    @OnClick
    public void onSetClicked(View view) {
        if (m11155f()) {
            if (getTargetFragment() != null && (getTargetFragment() instanceof OnStaticOptionsChangeListener)) {
                ((OnStaticOptionsChangeListener) getTargetFragment()).mo11130a(m11148a(), m11151b(), m11152c(), m11153d(), m11154e());
            }
            dismiss();
        }
    }

    /* JADX INFO: renamed from: a */
    private String m11148a() {
        try {
            return this.editIpAddress.getText().toString().trim();
        } catch (Exception e) {
            return "";
        }
    }

    /* JADX INFO: renamed from: b */
    private String m11151b() {
        try {
            return this.editSubnetMask.getText().toString().trim();
        } catch (Exception e) {
            return "";
        }
    }

    /* JADX INFO: renamed from: c */
    private String m11152c() {
        try {
            return this.editRouter.getText().toString().trim();
        } catch (Exception e) {
            return "";
        }
    }

    /* JADX INFO: renamed from: d */
    private String m11153d() {
        try {
            return this.editDns1.getText().toString().trim();
        } catch (Exception e) {
            return "";
        }
    }

    /* JADX INFO: renamed from: e */
    private String m11154e() {
        try {
            return this.editDns2.getText().toString().trim();
        } catch (Exception e) {
            return "";
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m11150a(EditText editText, Pattern pattern) {
        String strTrim = "";
        try {
            strTrim = editText.getText().toString().trim();
        } catch (Exception e) {
        }
        if (!strTrim.isEmpty() && !pattern.matcher(strTrim).matches()) {
            ((TextInputLayout) editText.getParent()).setError(getString(R.string.valid_ip_address));
            editText.requestFocus();
            return false;
        }
        ((TextInputLayout) editText.getParent()).setError(null);
        ((TextInputLayout) editText.getParent()).setErrorEnabled(false);
        return true;
    }

    /* JADX INFO: renamed from: a */
    private boolean m11149a(EditText editText, EditText editText2, EditText editText3) {
        String str;
        String strTrim;
        String strTrim2 = "";
        String strTrim3 = "";
        try {
            strTrim2 = editText.getText().toString().trim();
            strTrim3 = editText2.getText().toString().trim();
            str = strTrim2;
            strTrim = editText3.getText().toString().trim();
        } catch (Exception e) {
            str = strTrim2;
            strTrim = "";
        }
        try {
            if (!new SubnetUtils(str, strTrim).m11469a().m11471a().equals(new SubnetUtils(strTrim3, strTrim).m11469a().m11471a())) {
                ((TextInputLayout) editText3.getParent()).setError(getString(R.string.valid_subnet_mask));
                editText3.requestFocus();
                return false;
            }
            ((TextInputLayout) editText3.getParent()).setError(null);
            ((TextInputLayout) editText3.getParent()).setErrorEnabled(false);
            return true;
        } catch (IllegalArgumentException e2) {
            editText3.requestFocus();
            ((TextInputLayout) editText3.getParent()).setError(getString(R.string.valid_subnet_mask));
            return false;
        }
    }

    /* JADX INFO: renamed from: f */
    private boolean m11155f() {
        boolean zM11150a = true;
        try {
            boolean zM11150a2 = m11150a(this.editIpAddress, Patterns.IP_ADDRESS) & m11150a(this.editSubnetMask, Patterns.IP_ADDRESS) & m11150a(this.editRouter, Patterns.IP_ADDRESS);
            if (zM11150a2) {
                zM11150a2 &= m11149a(this.editIpAddress, this.editRouter, this.editSubnetMask);
            }
            zM11150a = zM11150a2 & m11150a(this.editDns1, Commons.f11681f);
            return zM11150a & m11150a(this.editDns2, Commons.f11681f);
        } catch (InvalidParameterException e) {
            return false;
        } catch (Exception e2) {
            return zM11150a;
        }
    }
}
