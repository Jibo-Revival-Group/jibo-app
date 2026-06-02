package com.jibo.p019ui.fragment.settings;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class ChangeEmailFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private ChangeEmailFragment f10930b;

    public ChangeEmailFragment_ViewBinding(ChangeEmailFragment changeEmailFragment, View view) {
        this.f10930b = changeEmailFragment;
        changeEmailFragment.email = (EditText) Utils.m5161b(view, R.id.email, "field 'email'", EditText.class);
        changeEmailFragment.footer = (TextView) Utils.m5161b(view, R.id.footer1, "field 'footer'", TextView.class);
        changeEmailFragment.footerError = (TextView) Utils.m5161b(view, R.id.footer_error, "field 'footerError'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ChangeEmailFragment changeEmailFragment = this.f10930b;
        if (changeEmailFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10930b = null;
        changeEmailFragment.email = null;
        changeEmailFragment.footer = null;
        changeEmailFragment.footerError = null;
    }
}
