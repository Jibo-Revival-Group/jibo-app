package com.jibo.p019ui.fragment.phone;

import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class PhoneEditFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private PhoneEditFragment f10841b;

    public PhoneEditFragment_ViewBinding(PhoneEditFragment phoneEditFragment, View view) {
        this.f10841b = phoneEditFragment;
        phoneEditFragment.phone = (EditText) Utils.m5161b(view, R.id.phone, "field 'phone'", EditText.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        PhoneEditFragment phoneEditFragment = this.f10841b;
        if (phoneEditFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10841b = null;
        phoneEditFragment.phone = null;
    }
}
