package com.jibo.p019ui.fragment.wifi;

import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class StaticOptionsDialogFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private StaticOptionsDialogFragment f11297b;

    /* JADX INFO: renamed from: c */
    private View f11298c;

    /* JADX INFO: renamed from: d */
    private View f11299d;

    public StaticOptionsDialogFragment_ViewBinding(final StaticOptionsDialogFragment staticOptionsDialogFragment, View view) {
        this.f11297b = staticOptionsDialogFragment;
        staticOptionsDialogFragment.editIpAddress = (EditText) Utils.m5161b(view, R.id.editIpAddress, "field 'editIpAddress'", EditText.class);
        staticOptionsDialogFragment.editSubnetMask = (EditText) Utils.m5161b(view, R.id.editSubnetMask, "field 'editSubnetMask'", EditText.class);
        staticOptionsDialogFragment.editRouter = (EditText) Utils.m5161b(view, R.id.editRouter, "field 'editRouter'", EditText.class);
        staticOptionsDialogFragment.editDns1 = (EditText) Utils.m5161b(view, R.id.editDns1, "field 'editDns1'", EditText.class);
        staticOptionsDialogFragment.editDns2 = (EditText) Utils.m5161b(view, R.id.editDns2, "field 'editDns2'", EditText.class);
        View viewM5158a = Utils.m5158a(view, R.id.cancel_action, "method 'onCancelClicked'");
        this.f11298c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.wifi.StaticOptionsDialogFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                staticOptionsDialogFragment.onCancelClicked(view2);
            }
        });
        View viewM5158a2 = Utils.m5158a(view, R.id.set_action, "method 'onSetClicked'");
        this.f11299d = viewM5158a2;
        viewM5158a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.wifi.StaticOptionsDialogFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                staticOptionsDialogFragment.onSetClicked(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        StaticOptionsDialogFragment staticOptionsDialogFragment = this.f11297b;
        if (staticOptionsDialogFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f11297b = null;
        staticOptionsDialogFragment.editIpAddress = null;
        staticOptionsDialogFragment.editSubnetMask = null;
        staticOptionsDialogFragment.editRouter = null;
        staticOptionsDialogFragment.editDns1 = null;
        staticOptionsDialogFragment.editDns2 = null;
        this.f11298c.setOnClickListener(null);
        this.f11298c = null;
        this.f11299d.setOnClickListener(null);
        this.f11299d = null;
    }
}
