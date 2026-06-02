package com.jibo.p019ui.fragment.invite;

import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class EmailFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private EmailFragment f10438b;

    public EmailFragment_ViewBinding(EmailFragment emailFragment, View view) {
        this.f10438b = emailFragment;
        emailFragment.email = (AutoCompleteTextView) Utils.m5161b(view, R.id.email, "field 'email'", AutoCompleteTextView.class);
        emailFragment.title = (TextView) Utils.m5161b(view, R.id.title, "field 'title'", TextView.class);
        emailFragment.footer = (TextView) Utils.m5161b(view, R.id.footer, "field 'footer'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        EmailFragment emailFragment = this.f10438b;
        if (emailFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10438b = null;
        emailFragment.email = null;
        emailFragment.title = null;
        emailFragment.footer = null;
    }
}
