package com.jibo.p019ui.fragment.wifi;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class NetworkPwdFragment_ViewBinding extends WiFiBaseFragment_ViewBinding {

    /* JADX INFO: renamed from: b */
    private NetworkPwdFragment f11246b;

    /* JADX INFO: renamed from: c */
    private View f11247c;

    public NetworkPwdFragment_ViewBinding(final NetworkPwdFragment networkPwdFragment, View view) {
        super(networkPwdFragment, view);
        this.f11246b = networkPwdFragment;
        networkPwdFragment.editPassword = (EditText) Utils.m5161b(view, R.id.editPassword, "field 'editPassword'", EditText.class);
        networkPwdFragment.txtPasswordHint = (TextView) Utils.m5161b(view, R.id.txtPasswordHint, "field 'txtPasswordHint'", TextView.class);
        View viewM5158a = Utils.m5158a(view, R.id.btnStaticOptions, "field 'btnStaticOptions' and method 'onStaticClick'");
        networkPwdFragment.btnStaticOptions = (TextView) Utils.m5162c(viewM5158a, R.id.btnStaticOptions, "field 'btnStaticOptions'", TextView.class);
        this.f11247c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.wifi.NetworkPwdFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                networkPwdFragment.onStaticClick(view2);
            }
        });
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiBaseFragment_ViewBinding, butterknife.Unbinder
    public void unbind() {
        NetworkPwdFragment networkPwdFragment = this.f11246b;
        if (networkPwdFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f11246b = null;
        networkPwdFragment.editPassword = null;
        networkPwdFragment.txtPasswordHint = null;
        networkPwdFragment.btnStaticOptions = null;
        this.f11247c.setOnClickListener(null);
        this.f11247c = null;
        super.unbind();
    }
}
