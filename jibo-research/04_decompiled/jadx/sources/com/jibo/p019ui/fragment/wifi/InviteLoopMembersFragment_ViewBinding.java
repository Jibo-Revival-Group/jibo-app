package com.jibo.p019ui.fragment.wifi;

import android.R;
import android.view.View;
import android.widget.ImageView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.p019ui.view.proxima.CustomFontButton;

/* JADX INFO: loaded from: classes.dex */
public class InviteLoopMembersFragment_ViewBinding extends WiFiBaseFragment_ViewBinding {

    /* JADX INFO: renamed from: b */
    private InviteLoopMembersFragment f11201b;

    /* JADX INFO: renamed from: c */
    private View f11202c;

    /* JADX INFO: renamed from: d */
    private View f11203d;

    public InviteLoopMembersFragment_ViewBinding(final InviteLoopMembersFragment inviteLoopMembersFragment, View view) {
        super(inviteLoopMembersFragment, view);
        this.f11201b = inviteLoopMembersFragment;
        View viewM5158a = Utils.m5158a(view, R.id.closeButton, "field 'closeButton' and method 'onCloseClick'");
        inviteLoopMembersFragment.closeButton = (ImageView) Utils.m5162c(viewM5158a, R.id.closeButton, "field 'closeButton'", ImageView.class);
        this.f11202c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.wifi.InviteLoopMembersFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                inviteLoopMembersFragment.onCloseClick(view2);
            }
        });
        View viewM5158a2 = Utils.m5158a(view, com.jibo.R.id.btnInvitePeople, "field 'btnInvitePeople' and method 'btnInvitePeople'");
        inviteLoopMembersFragment.btnInvitePeople = (CustomFontButton) Utils.m5162c(viewM5158a2, com.jibo.R.id.btnInvitePeople, "field 'btnInvitePeople'", CustomFontButton.class);
        this.f11203d = viewM5158a2;
        viewM5158a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.wifi.InviteLoopMembersFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                inviteLoopMembersFragment.btnInvitePeople(view2);
            }
        });
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiBaseFragment_ViewBinding, butterknife.Unbinder
    public void unbind() {
        InviteLoopMembersFragment inviteLoopMembersFragment = this.f11201b;
        if (inviteLoopMembersFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f11201b = null;
        inviteLoopMembersFragment.closeButton = null;
        inviteLoopMembersFragment.btnInvitePeople = null;
        this.f11202c.setOnClickListener(null);
        this.f11202c = null;
        this.f11203d.setOnClickListener(null);
        this.f11203d = null;
        super.unbind();
    }
}
