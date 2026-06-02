package com.google.android.gms.maps;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.zza;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MapView extends FrameLayout {

    /* JADX INFO: renamed from: a */
    private final zzb f8255a;

    static class zzb extends zza<Object> {

        /* JADX INFO: renamed from: a */
        private final ViewGroup f8256a;

        /* JADX INFO: renamed from: b */
        private final Context f8257b;

        /* JADX INFO: renamed from: c */
        private final GoogleMapOptions f8258c;

        /* JADX INFO: renamed from: d */
        private final List<Object> f8259d = new ArrayList();

        zzb(ViewGroup viewGroup, Context context, GoogleMapOptions googleMapOptions) {
            this.f8256a = viewGroup;
            this.f8257b = context;
            this.f8258c = googleMapOptions;
        }
    }

    public MapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8255a = new zzb(this, context, GoogleMapOptions.m8815a(context, attributeSet));
        setClickable(true);
    }

    public MapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8255a = new zzb(this, context, GoogleMapOptions.m8815a(context, attributeSet));
        setClickable(true);
    }
}
