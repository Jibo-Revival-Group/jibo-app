package com.jibo.p019ui.fragment.settings;

import android.view.View;
import android.widget.AutoCompleteTextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class ManualLocationFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private ManualLocationFragment f11069b;

    public ManualLocationFragment_ViewBinding(ManualLocationFragment manualLocationFragment, View view) {
        this.f11069b = manualLocationFragment;
        manualLocationFragment.locationEdit = (AutoCompleteTextView) Utils.m5161b(view, R.id.location, "field 'locationEdit'", AutoCompleteTextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ManualLocationFragment manualLocationFragment = this.f11069b;
        if (manualLocationFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f11069b = null;
        manualLocationFragment.locationEdit = null;
    }
}
