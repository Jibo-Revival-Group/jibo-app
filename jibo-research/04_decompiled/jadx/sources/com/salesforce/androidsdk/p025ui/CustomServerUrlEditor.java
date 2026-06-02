package com.salesforce.androidsdk.p025ui;

import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.config.LoginServerManager;

/* JADX INFO: loaded from: classes.dex */
public class CustomServerUrlEditor extends DialogFragment {

    /* JADX INFO: renamed from: a */
    boolean f14353a;

    /* JADX INFO: renamed from: e */
    private View f14357e;

    /* JADX INFO: renamed from: d */
    private Context f14356d = SalesforceSDKManager.m14403a().m14446k();

    /* JADX INFO: renamed from: b */
    private SalesforceR f14354b = SalesforceSDKManager.m14403a().m14438e();

    /* JADX INFO: renamed from: c */
    private LoginServerManager f14355c = SalesforceSDKManager.m14403a().m14447l();

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f14357e = layoutInflater.inflate(this.f14354b.m14953S(), viewGroup);
        String strM14838b = m14838b(this.f14354b.m14947M());
        String strM14838b2 = m14838b(this.f14354b.m14948N());
        this.f14353a = strM14838b2.equals(getString(this.f14354b.m14950P()));
        if (this.f14353a) {
            getDialog().setTitle(this.f14354b.m14951Q());
        } else {
            getDialog().setTitle(this.f14354b.m14952R());
        }
        m14835a(this.f14354b.m14947M(), strM14838b);
        m14835a(this.f14354b.m14948N(), strM14838b2);
        ((Button) this.f14357e.findViewById(this.f14354b.m14954T())).setOnClickListener(new View.OnClickListener() { // from class: com.salesforce.androidsdk.ui.CustomServerUrlEditor.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String strM14833a;
                String strM14833a2 = CustomServerUrlEditor.this.m14833a(CustomServerUrlEditor.this.f14354b.m14947M());
                if (strM14833a2 != null && (strM14833a = CustomServerUrlEditor.this.m14833a(CustomServerUrlEditor.this.f14354b.m14948N())) != null) {
                    CustomServerUrlEditor.this.f14355c.m14519a(strM14833a2, strM14833a);
                    CustomServerUrlEditor.this.dismiss();
                }
            }
        });
        ((Button) this.f14357e.findViewById(this.f14354b.m14955U())).setOnClickListener(new View.OnClickListener() { // from class: com.salesforce.androidsdk.ui.CustomServerUrlEditor.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CustomServerUrlEditor.this.dismiss();
            }
        });
        return this.f14357e;
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        ServerPickerActivity serverPickerActivity = (ServerPickerActivity) getActivity();
        if (serverPickerActivity != null) {
            serverPickerActivity.m15005c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m14835a(int i, String str) {
        if (str == null) {
            throw new RuntimeException("Value cannot be null");
        }
        EditText editText = (EditText) this.f14357e.findViewById(i);
        SpannableString spannableString = new SpannableString(str);
        if (editText != null) {
            editText.setText(spannableString);
            if (editText.getOnFocusChangeListener() == null) {
                editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.salesforce.androidsdk.ui.CustomServerUrlEditor.3
                    @Override // android.view.View.OnFocusChangeListener
                    public void onFocusChange(View view, boolean z) {
                        EditText editText2 = (EditText) view;
                        boolean zEquals = editText2.getText().toString().equals(CustomServerUrlEditor.this.m14838b(editText2.getId()));
                        if (z && zEquals) {
                            editText2.getText().clear();
                            return;
                        }
                        if (!z && editText2.getText().toString().equals("")) {
                            if (editText2.getId() == CustomServerUrlEditor.this.f14354b.m14947M()) {
                                CustomServerUrlEditor.this.m14835a(CustomServerUrlEditor.this.f14354b.m14947M(), CustomServerUrlEditor.this.m14838b(editText2.getId()));
                            } else {
                                CustomServerUrlEditor.this.m14835a(CustomServerUrlEditor.this.f14354b.m14948N(), CustomServerUrlEditor.this.m14838b(editText2.getId()));
                            }
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public String m14833a(int i) {
        EditText editText = (EditText) this.f14357e.findViewById(i);
        Editable text = editText.getText();
        boolean z = text.toString().equals(m14838b(i)) || text.toString().equals("");
        if (i == this.f14354b.m14948N()) {
            z = !URLUtil.isHttpsUrl(text.toString());
            if (z) {
                Toast.makeText(this.f14356d, getString(this.f14354b.m14956V()), 0).show();
            }
        }
        if (z) {
            editText.selectAll();
            editText.requestFocus();
            return null;
        }
        return text.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public String m14838b(int i) {
        return i == this.f14354b.m14947M() ? getString(this.f14354b.m14949O()) : getString(this.f14354b.m14950P());
    }
}
