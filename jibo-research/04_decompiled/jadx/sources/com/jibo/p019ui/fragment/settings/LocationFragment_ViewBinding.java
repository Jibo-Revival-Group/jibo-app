package com.jibo.p019ui.fragment.settings;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class LocationFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private LocationFragment f11043b;

    /* JADX INFO: renamed from: c */
    private View f11044c;

    /* JADX INFO: renamed from: d */
    private View f11045d;

    public LocationFragment_ViewBinding(final LocationFragment locationFragment, View view) {
        this.f11043b = locationFragment;
        locationFragment.txtLocation = (TextView) Utils.m5159a(view, R.id.txtLocation, "field 'txtLocation'", TextView.class);
        locationFragment.txtTimezone = (TextView) Utils.m5159a(view, R.id.txtTimezone, "field 'txtTimezone'", TextView.class);
        View viewFindViewById = view.findViewById(R.id.btnSetLocation);
        if (viewFindViewById != null) {
            this.f11044c = viewFindViewById;
            viewFindViewById.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.settings.LocationFragment_ViewBinding.1
                @Override // butterknife.internal.DebouncingOnClickListener
                /* JADX INFO: renamed from: a */
                public void mo5157a(View view2) {
                    locationFragment.btnSetLocationClick(view2);
                }
            });
        }
        View viewFindViewById2 = view.findViewById(R.id.btnSetManually);
        if (viewFindViewById2 != null) {
            this.f11045d = viewFindViewById2;
            viewFindViewById2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.settings.LocationFragment_ViewBinding.2
                @Override // butterknife.internal.DebouncingOnClickListener
                /* JADX INFO: renamed from: a */
                public void mo5157a(View view2) {
                    locationFragment.setManuallyClick(view2);
                }
            });
        }
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        LocationFragment locationFragment = this.f11043b;
        if (locationFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f11043b = null;
        locationFragment.txtLocation = null;
        locationFragment.txtTimezone = null;
        if (this.f11044c != null) {
            this.f11044c.setOnClickListener(null);
            this.f11044c = null;
        }
        if (this.f11045d != null) {
            this.f11045d.setOnClickListener(null);
            this.f11045d = null;
        }
    }
}
