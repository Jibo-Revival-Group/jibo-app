package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.jibo.aws.integration.helpers.RobotHelper;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AutocompleteFilter extends zzbfm implements ReflectedParcelable {
    public static final Parcelable.Creator<AutocompleteFilter> CREATOR = new zzc();

    /* JADX INFO: renamed from: a */
    private int f8089a;

    /* JADX INFO: renamed from: b */
    private boolean f8090b;

    /* JADX INFO: renamed from: c */
    private List<Integer> f8091c;

    /* JADX INFO: renamed from: d */
    private String f8092d;

    /* JADX INFO: renamed from: e */
    private int f8093e;

    public static final class Builder {

        /* JADX INFO: renamed from: a */
        private boolean f8094a = false;

        /* JADX INFO: renamed from: b */
        private int f8095b = 0;

        /* JADX INFO: renamed from: c */
        private String f8096c = "";

        /* JADX INFO: renamed from: a */
        public final AutocompleteFilter m8759a() {
            return new AutocompleteFilter(1, false, Arrays.asList(Integer.valueOf(this.f8095b)), this.f8096c);
        }
    }

    AutocompleteFilter(int i, boolean z, List<Integer> list, String str) {
        this.f8089a = i;
        this.f8091c = list;
        this.f8093e = (list == null || list.isEmpty()) ? 0 : list.iterator().next().intValue();
        this.f8092d = str;
        if (this.f8089a <= 0) {
            this.f8090b = z ? false : true;
        } else {
            this.f8090b = z;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AutocompleteFilter)) {
            return false;
        }
        AutocompleteFilter autocompleteFilter = (AutocompleteFilter) obj;
        return this.f8093e == autocompleteFilter.f8093e && this.f8090b == autocompleteFilter.f8090b && this.f8092d == autocompleteFilter.f8092d;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.f8090b), Integer.valueOf(this.f8093e), this.f8092d});
    }

    public String toString() {
        return zzbg.m7370a(this).m7372a("includeQueryPredictions", Boolean.valueOf(this.f8090b)).m7372a("typeFilter", Integer.valueOf(this.f8093e)).m7372a(RobotHelper.FIELD_COUNTRY, this.f8092d).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7751a(parcel, 1, this.f8090b);
        zzbfp.m7749a(parcel, 2, this.f8091c, false);
        zzbfp.m7748a(parcel, 3, this.f8092d, false);
        zzbfp.m7738a(parcel, 1000, this.f8089a);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
