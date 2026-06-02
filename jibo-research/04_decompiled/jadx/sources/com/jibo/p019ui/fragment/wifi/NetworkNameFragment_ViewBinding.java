package com.jibo.p019ui.fragment.wifi;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class NetworkNameFragment_ViewBinding extends WiFiBaseFragment_ViewBinding {

    /* JADX INFO: renamed from: b */
    private NetworkNameFragment f11242b;

    public NetworkNameFragment_ViewBinding(NetworkNameFragment networkNameFragment, View view) {
        super(networkNameFragment, view);
        this.f11242b = networkNameFragment;
        networkNameFragment.editSSID = (EditText) Utils.m5161b(view, R.id.editSSID, "field 'editSSID'", EditText.class);
        networkNameFragment.footer = (TextView) Utils.m5161b(view, R.id.footer, "field 'footer'", TextView.class);
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiBaseFragment_ViewBinding, butterknife.Unbinder
    public void unbind() {
        NetworkNameFragment networkNameFragment = this.f11242b;
        if (networkNameFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f11242b = null;
        networkNameFragment.editSSID = null;
        networkNameFragment.footer = null;
        super.unbind();
    }
}
