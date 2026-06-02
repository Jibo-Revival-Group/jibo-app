package com.jibo.p019ui.fragment.phone;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class PhoneConfirmFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private PhoneConfirmFragment f10834b;

    /* JADX INFO: renamed from: c */
    private View f10835c;

    public PhoneConfirmFragment_ViewBinding(final PhoneConfirmFragment phoneConfirmFragment, View view) {
        this.f10834b = phoneConfirmFragment;
        phoneConfirmFragment.code = (EditText) Utils.m5161b(view, R.id.code, "field 'code'", EditText.class);
        phoneConfirmFragment.footer_error = (TextView) Utils.m5161b(view, R.id.footer_error, "field 'footer_error'", TextView.class);
        phoneConfirmFragment.footer1 = (TextView) Utils.m5161b(view, R.id.footer1, "field 'footer1'", TextView.class);
        View viewM5158a = Utils.m5158a(view, R.id.resend_code, "method 'onResendCode'");
        this.f10835c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.phone.PhoneConfirmFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                phoneConfirmFragment.onResendCode(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        PhoneConfirmFragment phoneConfirmFragment = this.f10834b;
        if (phoneConfirmFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10834b = null;
        phoneConfirmFragment.code = null;
        phoneConfirmFragment.footer_error = null;
        phoneConfirmFragment.footer1 = null;
        this.f10835c.setOnClickListener(null);
        this.f10835c = null;
    }
}
