package com.jibo.p019ui.fragment.onboarding;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class DevSettingsFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private DevSettingsFragment f10703b;

    /* JADX INFO: renamed from: c */
    private View f10704c;

    /* JADX INFO: renamed from: d */
    private View f10705d;

    /* JADX INFO: renamed from: e */
    private View f10706e;

    /* JADX INFO: renamed from: f */
    private View f10707f;

    /* JADX INFO: renamed from: g */
    private View f10708g;

    /* JADX INFO: renamed from: h */
    private View f10709h;

    /* JADX INFO: renamed from: i */
    private View f10710i;

    /* JADX INFO: renamed from: j */
    private View f10711j;

    public DevSettingsFragment_ViewBinding(final DevSettingsFragment devSettingsFragment, View view) {
        this.f10703b = devSettingsFragment;
        devSettingsFragment.current_endpoint = (TextView) Utils.m5161b(view, R.id.current_endpoint, "field 'current_endpoint'", TextView.class);
        devSettingsFragment.endpointSpinner = (Spinner) Utils.m5161b(view, R.id.endpoint, "field 'endpointSpinner'", Spinner.class);
        devSettingsFragment.textVersion = (TextView) Utils.m5161b(view, R.id.textVersion, "field 'textVersion'", TextView.class);
        devSettingsFragment.switchEncryption = (Switch) Utils.m5161b(view, R.id.switchEncryption, "field 'switchEncryption'", Switch.class);
        devSettingsFragment.loopsSpinner = (Spinner) Utils.m5161b(view, R.id.loops, "field 'loopsSpinner'", Spinner.class);
        devSettingsFragment.loops1Spinner = (Spinner) Utils.m5161b(view, R.id.loops1, "field 'loops1Spinner'", Spinner.class);
        devSettingsFragment.gqaLoopsSpinner = (Spinner) Utils.m5161b(view, R.id.loops2, "field 'gqaLoopsSpinner'", Spinner.class);
        devSettingsFragment.ugcLoopSpinner = (Spinner) Utils.m5161b(view, R.id.loops3, "field 'ugcLoopSpinner'", Spinner.class);
        devSettingsFragment.suspensionLoopSpinner = (Spinner) Utils.m5161b(view, R.id.loops4, "field 'suspensionLoopSpinner'", Spinner.class);
        devSettingsFragment.ugcKeyText = (TextView) Utils.m5161b(view, R.id.ugcKey, "field 'ugcKeyText'", TextView.class);
        devSettingsFragment.questionEdit = (EditText) Utils.m5161b(view, R.id.question_edit, "field 'questionEdit'", EditText.class);
        devSettingsFragment.responseText = (TextView) Utils.m5161b(view, R.id.responseText, "field 'responseText'", TextView.class);
        devSettingsFragment.endpointEdit = (EditText) Utils.m5161b(view, R.id.endpoint_edit, "field 'endpointEdit'", EditText.class);
        View viewM5158a = Utils.m5158a(view, R.id.btnSetEndpoint, "field 'buttonSetEndpoint' and method 'setEndpoint'");
        devSettingsFragment.buttonSetEndpoint = (Button) Utils.m5162c(viewM5158a, R.id.btnSetEndpoint, "field 'buttonSetEndpoint'", Button.class);
        this.f10704c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.onboarding.DevSettingsFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                devSettingsFragment.setEndpoint(view2);
            }
        });
        View viewM5158a2 = Utils.m5158a(view, R.id.btnLogout, "method 'logout'");
        this.f10705d = viewM5158a2;
        viewM5158a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.onboarding.DevSettingsFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                devSettingsFragment.logout(view2);
            }
        });
        View viewM5158a3 = Utils.m5158a(view, R.id.btnRequestKey, "method 'onBtnRequestKeyClick'");
        this.f10706e = viewM5158a3;
        viewM5158a3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.onboarding.DevSettingsFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                devSettingsFragment.onBtnRequestKeyClick(view2);
            }
        });
        View viewM5158a4 = Utils.m5158a(view, R.id.btnListAttributions, "method 'onBtnListAttributions'");
        this.f10707f = viewM5158a4;
        viewM5158a4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.onboarding.DevSettingsFragment_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                devSettingsFragment.onBtnListAttributions(view2);
            }
        });
        View viewM5158a5 = Utils.m5158a(view, R.id.btnSendQuestion, "method 'onBtnSendQuestion'");
        this.f10708g = viewM5158a5;
        viewM5158a5.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.onboarding.DevSettingsFragment_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                devSettingsFragment.onBtnSendQuestion(view2);
            }
        });
        View viewM5158a6 = Utils.m5158a(view, R.id.btnGenerateKey, "method 'onBtnGenerateKeyClick'");
        this.f10709h = viewM5158a6;
        viewM5158a6.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.onboarding.DevSettingsFragment_ViewBinding.6
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                devSettingsFragment.onBtnGenerateKeyClick(view2);
            }
        });
        View viewM5158a7 = Utils.m5158a(view, R.id.btnSuspendLoop, "method 'onBtnSuspendLoopClick'");
        this.f10710i = viewM5158a7;
        viewM5158a7.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.onboarding.DevSettingsFragment_ViewBinding.7
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                devSettingsFragment.onBtnSuspendLoopClick(view2);
            }
        });
        View viewM5158a8 = Utils.m5158a(view, R.id.dev_settings, "method 'showDevSettings'");
        this.f10711j = viewM5158a8;
        viewM5158a8.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.jibo.ui.fragment.onboarding.DevSettingsFragment_ViewBinding.8
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                return devSettingsFragment.showDevSettings(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        DevSettingsFragment devSettingsFragment = this.f10703b;
        if (devSettingsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10703b = null;
        devSettingsFragment.current_endpoint = null;
        devSettingsFragment.endpointSpinner = null;
        devSettingsFragment.textVersion = null;
        devSettingsFragment.switchEncryption = null;
        devSettingsFragment.loopsSpinner = null;
        devSettingsFragment.loops1Spinner = null;
        devSettingsFragment.gqaLoopsSpinner = null;
        devSettingsFragment.ugcLoopSpinner = null;
        devSettingsFragment.suspensionLoopSpinner = null;
        devSettingsFragment.ugcKeyText = null;
        devSettingsFragment.questionEdit = null;
        devSettingsFragment.responseText = null;
        devSettingsFragment.endpointEdit = null;
        devSettingsFragment.buttonSetEndpoint = null;
        this.f10704c.setOnClickListener(null);
        this.f10704c = null;
        this.f10705d.setOnClickListener(null);
        this.f10705d = null;
        this.f10706e.setOnClickListener(null);
        this.f10706e = null;
        this.f10707f.setOnClickListener(null);
        this.f10707f = null;
        this.f10708g.setOnClickListener(null);
        this.f10708g = null;
        this.f10709h.setOnClickListener(null);
        this.f10709h = null;
        this.f10710i.setOnClickListener(null);
        this.f10710i = null;
        this.f10711j.setOnLongClickListener(null);
        this.f10711j = null;
    }
}
