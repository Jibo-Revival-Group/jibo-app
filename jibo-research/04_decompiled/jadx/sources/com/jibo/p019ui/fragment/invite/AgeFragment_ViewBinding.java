package com.jibo.p019ui.fragment.invite;

import android.view.View;
import android.widget.RadioButton;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class AgeFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private AgeFragment f10396b;

    public AgeFragment_ViewBinding(AgeFragment ageFragment, View view) {
        this.f10396b = ageFragment;
        ageFragment.mTeenageOrAdult = (RadioButton) Utils.m5161b(view, R.id.radio_button_adult, "field 'mTeenageOrAdult'", RadioButton.class);
        ageFragment.mChild = (RadioButton) Utils.m5161b(view, R.id.radio_button_child, "field 'mChild'", RadioButton.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AgeFragment ageFragment = this.f10396b;
        if (ageFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10396b = null;
        ageFragment.mTeenageOrAdult = null;
        ageFragment.mChild = null;
    }
}
