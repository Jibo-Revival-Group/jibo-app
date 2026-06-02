package com.google.android.gms.maps;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.zza;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class StreetViewPanoramaView extends FrameLayout {

    /* JADX INFO: renamed from: a */
    private final zzb f8269a;

    static class zzb extends zza<Object> {

        /* JADX INFO: renamed from: a */
        private final ViewGroup f8270a;

        /* JADX INFO: renamed from: b */
        private final Context f8271b;

        /* JADX INFO: renamed from: c */
        private final StreetViewPanoramaOptions f8272c;

        /* JADX INFO: renamed from: d */
        private final List<Object> f8273d = new ArrayList();

        zzb(ViewGroup viewGroup, Context context, StreetViewPanoramaOptions streetViewPanoramaOptions) {
            this.f8270a = viewGroup;
            this.f8271b = context;
            this.f8272c = streetViewPanoramaOptions;
        }
    }

    public StreetViewPanoramaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8269a = new zzb(this, context, null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8269a = new zzb(this, context, null);
    }
}
