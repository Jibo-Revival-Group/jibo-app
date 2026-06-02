package com.jibo.p019ui.fragment.dialog;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class LocationSetDialog_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private LocationSetDialog f10246b;

    /* JADX INFO: renamed from: c */
    private View f10247c;

    public LocationSetDialog_ViewBinding(final LocationSetDialog locationSetDialog, View view) {
        this.f10246b = locationSetDialog;
        locationSetDialog.location = (TextView) Utils.m5161b(view, R.id.location, "field 'location'", TextView.class);
        locationSetDialog.timezone = (TextView) Utils.m5161b(view, R.id.timezone, "field 'timezone'", TextView.class);
        View viewM5158a = Utils.m5158a(view, R.id.btnSet, "method 'onBtnSetClicked'");
        this.f10247c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.dialog.LocationSetDialog_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                locationSetDialog.onBtnSetClicked(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        LocationSetDialog locationSetDialog = this.f10246b;
        if (locationSetDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10246b = null;
        locationSetDialog.location = null;
        locationSetDialog.timezone = null;
        this.f10247c.setOnClickListener(null);
        this.f10247c = null;
    }
}
