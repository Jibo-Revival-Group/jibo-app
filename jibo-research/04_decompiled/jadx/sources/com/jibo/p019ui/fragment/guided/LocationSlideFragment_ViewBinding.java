package com.jibo.p019ui.fragment.guided;

import android.view.View;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;
import com.jibo.p019ui.fragment.settings.LocationFragment_ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public class LocationSlideFragment_ViewBinding extends LocationFragment_ViewBinding {

    /* JADX INFO: renamed from: b */
    private LocationSlideFragment f10327b;

    /* JADX INFO: renamed from: c */
    private View f10328c;

    public LocationSlideFragment_ViewBinding(final LocationSlideFragment locationSlideFragment, View view) {
        super(locationSlideFragment, view);
        this.f10327b = locationSlideFragment;
        locationSlideFragment.topText = (TextView) Utils.m5161b(view, R.id.text, "field 'topText'", TextView.class);
        locationSlideFragment.text2 = (TextView) Utils.m5161b(view, R.id.text2, "field 'text2'", TextView.class);
        View viewM5158a = Utils.m5158a(view, R.id.btnSetLocation, "method 'btnSetLocationClick'");
        this.f10328c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.guided.LocationSlideFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                locationSlideFragment.btnSetLocationClick(view2);
            }
        });
    }

    @Override // com.jibo.p019ui.fragment.settings.LocationFragment_ViewBinding, butterknife.Unbinder
    public void unbind() {
        LocationSlideFragment locationSlideFragment = this.f10327b;
        if (locationSlideFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10327b = null;
        locationSlideFragment.topText = null;
        locationSlideFragment.text2 = null;
        this.f10328c.setOnClickListener(null);
        this.f10328c = null;
        super.unbind();
    }
}
