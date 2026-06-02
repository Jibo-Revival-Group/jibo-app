package com.jibo.p019ui.fragment.account.skills;

import android.view.View;
import android.widget.TextView;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class LocationFragment_ViewBinding extends com.jibo.p019ui.fragment.settings.LocationFragment_ViewBinding {

    /* JADX INFO: renamed from: b */
    private LocationFragment f10057b;

    public LocationFragment_ViewBinding(LocationFragment locationFragment, View view) {
        super(locationFragment, view);
        this.f10057b = locationFragment;
        locationFragment.txtLocation = (TextView) Utils.m5159a(view, R.id.txtLocation, "field 'txtLocation'", TextView.class);
        locationFragment.txtTimezone = (TextView) Utils.m5159a(view, R.id.txtTimezone, "field 'txtTimezone'", TextView.class);
    }

    @Override // com.jibo.p019ui.fragment.settings.LocationFragment_ViewBinding, butterknife.Unbinder
    public void unbind() {
        LocationFragment locationFragment = this.f10057b;
        if (locationFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10057b = null;
        locationFragment.txtLocation = null;
        locationFragment.txtTimezone = null;
        super.unbind();
    }
}
