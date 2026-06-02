package com.jibo.p019ui.fragment.wifi;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class WiFiBaseFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private WiFiBaseFragment f11314b;

    /* JADX INFO: renamed from: c */
    private View f11315c;

    /* JADX INFO: renamed from: d */
    private View f11316d;

    public WiFiBaseFragment_ViewBinding(final WiFiBaseFragment wiFiBaseFragment, View view) {
        this.f11314b = wiFiBaseFragment;
        View viewFindViewById = view.findViewById(R.id.btnHelp);
        if (viewFindViewById != null) {
            this.f11315c = viewFindViewById;
            viewFindViewById.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.wifi.WiFiBaseFragment_ViewBinding.1
                @Override // butterknife.internal.DebouncingOnClickListener
                /* JADX INFO: renamed from: a */
                public void mo5157a(View view2) {
                    wiFiBaseFragment.onBtnHelpClick(view2);
                }
            });
        }
        View viewFindViewById2 = view.findViewById(R.id.btnHelp1);
        if (viewFindViewById2 != null) {
            this.f11316d = viewFindViewById2;
            viewFindViewById2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.wifi.WiFiBaseFragment_ViewBinding.2
                @Override // butterknife.internal.DebouncingOnClickListener
                /* JADX INFO: renamed from: a */
                public void mo5157a(View view2) {
                    wiFiBaseFragment.onBtnHelpClick(view2);
                }
            });
        }
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        if (this.f11314b == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f11314b = null;
        if (this.f11315c != null) {
            this.f11315c.setOnClickListener(null);
            this.f11315c = null;
        }
        if (this.f11316d != null) {
            this.f11316d.setOnClickListener(null);
            this.f11316d = null;
        }
    }
}
