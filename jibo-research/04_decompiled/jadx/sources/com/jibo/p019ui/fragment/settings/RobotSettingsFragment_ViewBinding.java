package com.jibo.p019ui.fragment.settings;

import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class RobotSettingsFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private RobotSettingsFragment f11100b;

    /* JADX INFO: renamed from: c */
    private View f11101c;

    /* JADX INFO: renamed from: d */
    private View f11102d;

    /* JADX INFO: renamed from: e */
    private View f11103e;

    /* JADX INFO: renamed from: f */
    private View f11104f;

    /* JADX INFO: renamed from: g */
    private View f11105g;

    /* JADX INFO: renamed from: h */
    private View f11106h;

    /* JADX INFO: renamed from: i */
    private View f11107i;

    public RobotSettingsFragment_ViewBinding(final RobotSettingsFragment robotSettingsFragment, View view) {
        this.f11100b = robotSettingsFragment;
        robotSettingsFragment.txtJiboName = (TextView) Utils.m5161b(view, R.id.txtJiboName, "field 'txtJiboName'", TextView.class);
        robotSettingsFragment.imgJiboAvatar = (ImageView) Utils.m5161b(view, R.id.imgJiboAvatar, "field 'imgJiboAvatar'", ImageView.class);
        robotSettingsFragment.txtJiboWifi = (TextView) Utils.m5161b(view, R.id.txtJiboWifi, "field 'txtJiboWifi'", TextView.class);
        robotSettingsFragment.txtJiboLocation = (TextView) Utils.m5161b(view, R.id.txtJiboLocation, "field 'txtJiboLocation'", TextView.class);
        View viewM5158a = Utils.m5158a(view, R.id.btnAbout, "field 'btnAbout' and method 'showAbout'");
        robotSettingsFragment.btnAbout = viewM5158a;
        this.f11101c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.settings.RobotSettingsFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                robotSettingsFragment.showAbout(view2);
            }
        });
        robotSettingsFragment.btnPassphrase = Utils.m5158a(view, R.id.btnPassphrase, "field 'btnPassphrase'");
        robotSettingsFragment.iconPassphrase = (ImageView) Utils.m5161b(view, R.id.icon_passphrase, "field 'iconPassphrase'", ImageView.class);
        robotSettingsFragment.passphraseText = (TextView) Utils.m5161b(view, R.id.passphrase_text, "field 'passphraseText'", TextView.class);
        robotSettingsFragment.mRemoteSwitch = (Switch) Utils.m5161b(view, R.id.switchRemoteEnable, "field 'mRemoteSwitch'", Switch.class);
        View viewM5158a2 = Utils.m5158a(view, R.id.btnJiboName, "method 'changeName'");
        this.f11102d = viewM5158a2;
        viewM5158a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.settings.RobotSettingsFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                robotSettingsFragment.changeName(view2);
            }
        });
        View viewM5158a3 = Utils.m5158a(view, R.id.btnJiboAvatar, "method 'btnJiboAvatarClick'");
        this.f11103e = viewM5158a3;
        viewM5158a3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.settings.RobotSettingsFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                robotSettingsFragment.btnJiboAvatarClick();
            }
        });
        View viewM5158a4 = Utils.m5158a(view, R.id.btnWiFiSettings, "method 'btnWiFiSettingsClick'");
        this.f11104f = viewM5158a4;
        viewM5158a4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.settings.RobotSettingsFragment_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                robotSettingsFragment.btnWiFiSettingsClick();
            }
        });
        View viewM5158a5 = Utils.m5158a(view, R.id.btnLocation, "method 'btnLocationClick'");
        this.f11105g = viewM5158a5;
        viewM5158a5.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.settings.RobotSettingsFragment_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                robotSettingsFragment.btnLocationClick();
            }
        });
        View viewM5158a6 = Utils.m5158a(view, R.id.btnEnableRemoteControl, "method 'btnEnableRemoteClick'");
        this.f11106h = viewM5158a6;
        viewM5158a6.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.settings.RobotSettingsFragment_ViewBinding.6
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                robotSettingsFragment.btnEnableRemoteClick();
            }
        });
        View viewM5158a7 = Utils.m5158a(view, R.id.btnHolidays, "method 'btnHolidaysClick'");
        this.f11107i = viewM5158a7;
        viewM5158a7.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.settings.RobotSettingsFragment_ViewBinding.7
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                robotSettingsFragment.btnHolidaysClick();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        RobotSettingsFragment robotSettingsFragment = this.f11100b;
        if (robotSettingsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f11100b = null;
        robotSettingsFragment.txtJiboName = null;
        robotSettingsFragment.imgJiboAvatar = null;
        robotSettingsFragment.txtJiboWifi = null;
        robotSettingsFragment.txtJiboLocation = null;
        robotSettingsFragment.btnAbout = null;
        robotSettingsFragment.btnPassphrase = null;
        robotSettingsFragment.iconPassphrase = null;
        robotSettingsFragment.passphraseText = null;
        robotSettingsFragment.mRemoteSwitch = null;
        this.f11101c.setOnClickListener(null);
        this.f11101c = null;
        this.f11102d.setOnClickListener(null);
        this.f11102d = null;
        this.f11103e.setOnClickListener(null);
        this.f11103e = null;
        this.f11104f.setOnClickListener(null);
        this.f11104f = null;
        this.f11105g.setOnClickListener(null);
        this.f11105g = null;
        this.f11106h.setOnClickListener(null);
        this.f11106h = null;
        this.f11107i.setOnClickListener(null);
        this.f11107i = null;
    }
}
