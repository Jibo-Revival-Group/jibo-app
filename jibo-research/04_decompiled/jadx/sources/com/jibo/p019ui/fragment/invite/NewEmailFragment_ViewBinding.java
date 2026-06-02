package com.jibo.p019ui.fragment.invite;

import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class NewEmailFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private NewEmailFragment f10509b;

    public NewEmailFragment_ViewBinding(NewEmailFragment newEmailFragment, View view) {
        this.f10509b = newEmailFragment;
        newEmailFragment.email = (AutoCompleteTextView) Utils.m5161b(view, R.id.email, "field 'email'", AutoCompleteTextView.class);
        newEmailFragment.title = (TextView) Utils.m5161b(view, R.id.title, "field 'title'", TextView.class);
        newEmailFragment.footer = (TextView) Utils.m5161b(view, R.id.footer, "field 'footer'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        NewEmailFragment newEmailFragment = this.f10509b;
        if (newEmailFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10509b = null;
        newEmailFragment.email = null;
        newEmailFragment.title = null;
        newEmailFragment.footer = null;
    }
}
