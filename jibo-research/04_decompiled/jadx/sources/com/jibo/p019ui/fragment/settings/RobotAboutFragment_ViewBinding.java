package com.jibo.p019ui.fragment.settings;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class RobotAboutFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private RobotAboutFragment f11072b;

    public RobotAboutFragment_ViewBinding(RobotAboutFragment robotAboutFragment, View view) {
        this.f11072b = robotAboutFragment;
        robotAboutFragment.ownerName = (TextView) Utils.m5161b(view, R.id.owner_name, "field 'ownerName'", TextView.class);
        robotAboutFragment.ownerEmail = (TextView) Utils.m5161b(view, R.id.owner_email, "field 'ownerEmail'", TextView.class);
        robotAboutFragment.osVersion = (TextView) Utils.m5161b(view, R.id.os_version, "field 'osVersion'", TextView.class);
        robotAboutFragment.serialName = (TextView) Utils.m5161b(view, R.id.serial_name, "field 'serialName'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        RobotAboutFragment robotAboutFragment = this.f11072b;
        if (robotAboutFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f11072b = null;
        robotAboutFragment.ownerName = null;
        robotAboutFragment.ownerEmail = null;
        robotAboutFragment.osVersion = null;
        robotAboutFragment.serialName = null;
    }
}
