package com.jibo.p019ui.fragment.wifi;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class NetworkSelectionFragment_ViewBinding extends WiFiBaseFragment_ViewBinding {

    /* JADX INFO: renamed from: b */
    private NetworkSelectionFragment f11251b;

    /* JADX INFO: renamed from: c */
    private View f11252c;

    /* JADX INFO: renamed from: d */
    private View f11253d;

    /* JADX INFO: renamed from: e */
    private View f11254e;

    /* JADX INFO: renamed from: f */
    private View f11255f;

    /* JADX INFO: renamed from: g */
    private View f11256g;

    public NetworkSelectionFragment_ViewBinding(final NetworkSelectionFragment networkSelectionFragment, View view) {
        super(networkSelectionFragment, view);
        this.f11251b = networkSelectionFragment;
        networkSelectionFragment.cntNoNetwork = (ViewGroup) Utils.m5161b(view, R.id.cntNoNetwork, "field 'cntNoNetwork'", ViewGroup.class);
        networkSelectionFragment.cntNetworkOn = (ViewGroup) Utils.m5161b(view, R.id.cntNetworkOn, "field 'cntNetworkOn'", ViewGroup.class);
        networkSelectionFragment.textStep2Message = (TextView) Utils.m5161b(view, R.id.textStep2Message, "field 'textStep2Message'", TextView.class);
        View viewM5158a = Utils.m5158a(view, R.id.btnSelectCurrentNetwork, "field 'btnSelectCurrentNetwork' and method 'onSelectCurrentNetwork'");
        networkSelectionFragment.btnSelectCurrentNetwork = (TextView) Utils.m5162c(viewM5158a, R.id.btnSelectCurrentNetwork, "field 'btnSelectCurrentNetwork'", TextView.class);
        this.f11252c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.wifi.NetworkSelectionFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                networkSelectionFragment.onSelectCurrentNetwork(view2);
            }
        });
        View viewM5158a2 = Utils.m5158a(view, R.id.btnEnterNetworkManually, "method 'onEnterNetworkManually'");
        this.f11253d = viewM5158a2;
        viewM5158a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.wifi.NetworkSelectionFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                networkSelectionFragment.onEnterNetworkManually(view2);
            }
        });
        View viewM5158a3 = Utils.m5158a(view, R.id.btnSelectOtherNetwork, "method 'onSelectOtherNetwork'");
        this.f11254e = viewM5158a3;
        viewM5158a3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.wifi.NetworkSelectionFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                networkSelectionFragment.onSelectOtherNetwork(view2);
            }
        });
        View viewM5158a4 = Utils.m5158a(view, R.id.btnWiFiSettings, "method 'onSelectOtherNetwork'");
        this.f11255f = viewM5158a4;
        viewM5158a4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.wifi.NetworkSelectionFragment_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                networkSelectionFragment.onSelectOtherNetwork(view2);
            }
        });
        View viewM5158a5 = Utils.m5158a(view, R.id.btnMacFiltering, "method 'onShowMacFilteringInfo'");
        this.f11256g = viewM5158a5;
        viewM5158a5.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.wifi.NetworkSelectionFragment_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                networkSelectionFragment.onShowMacFilteringInfo(view2);
            }
        });
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiBaseFragment_ViewBinding, butterknife.Unbinder
    public void unbind() {
        NetworkSelectionFragment networkSelectionFragment = this.f11251b;
        if (networkSelectionFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f11251b = null;
        networkSelectionFragment.cntNoNetwork = null;
        networkSelectionFragment.cntNetworkOn = null;
        networkSelectionFragment.textStep2Message = null;
        networkSelectionFragment.btnSelectCurrentNetwork = null;
        this.f11252c.setOnClickListener(null);
        this.f11252c = null;
        this.f11253d.setOnClickListener(null);
        this.f11253d = null;
        this.f11254e.setOnClickListener(null);
        this.f11254e = null;
        this.f11255f.setOnClickListener(null);
        this.f11255f = null;
        this.f11256g.setOnClickListener(null);
        this.f11256g = null;
        super.unbind();
    }
}
