package com.jibo.p019ui.fragment.settings;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class ChangePasswordFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private ChangePasswordFragment f10939b;

    public ChangePasswordFragment_ViewBinding(ChangePasswordFragment changePasswordFragment, View view) {
        this.f10939b = changePasswordFragment;
        changePasswordFragment.password = (EditText) Utils.m5161b(view, R.id.password, "field 'password'", EditText.class);
        changePasswordFragment.footer = (TextView) Utils.m5161b(view, R.id.footer1, "field 'footer'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ChangePasswordFragment changePasswordFragment = this.f10939b;
        if (changePasswordFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10939b = null;
        changePasswordFragment.password = null;
        changePasswordFragment.footer = null;
    }
}
