package com.jibo.p019ui.fragment.invite;

import android.R;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

/* JADX INFO: loaded from: classes.dex */
public class LegalGuardianFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private LegalGuardianFragment f10456b;

    public LegalGuardianFragment_ViewBinding(LegalGuardianFragment legalGuardianFragment, View view) {
        this.f10456b = legalGuardianFragment;
        legalGuardianFragment.name = (TextView) Utils.m5161b(view, R.id.text1, "field 'name'", TextView.class);
        legalGuardianFragment.email = (TextView) Utils.m5161b(view, R.id.text2, "field 'email'", TextView.class);
        legalGuardianFragment.avatar = (ImageView) Utils.m5161b(view, R.id.icon, "field 'avatar'", ImageView.class);
        legalGuardianFragment.legalGuardianInfo = (TextView) Utils.m5161b(view, com.jibo.R.id.legalGuardianInfo, "field 'legalGuardianInfo'", TextView.class);
        legalGuardianFragment.legalGuardianTitle = (TextView) Utils.m5161b(view, com.jibo.R.id.legalGuardianTitle, "field 'legalGuardianTitle'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        LegalGuardianFragment legalGuardianFragment = this.f10456b;
        if (legalGuardianFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10456b = null;
        legalGuardianFragment.name = null;
        legalGuardianFragment.email = null;
        legalGuardianFragment.avatar = null;
        legalGuardianFragment.legalGuardianInfo = null;
        legalGuardianFragment.legalGuardianTitle = null;
    }
}
