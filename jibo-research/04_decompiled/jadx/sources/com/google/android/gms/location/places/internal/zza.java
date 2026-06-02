package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.style.CharacterStyle;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.location.places.AutocompletePrediction;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zza extends zzbfm implements AutocompletePrediction {
    public static final Parcelable.Creator<zza> CREATOR = new zzc();

    /* JADX INFO: renamed from: a */
    private static final List<zzb> f8158a = Collections.emptyList();

    /* JADX INFO: renamed from: b */
    private String f8159b;

    /* JADX INFO: renamed from: c */
    private String f8160c;

    /* JADX INFO: renamed from: d */
    private List<Integer> f8161d;

    /* JADX INFO: renamed from: e */
    private List<zzb> f8162e;

    /* JADX INFO: renamed from: f */
    private int f8163f;

    /* JADX INFO: renamed from: g */
    private String f8164g;

    /* JADX INFO: renamed from: h */
    private List<zzb> f8165h;

    /* JADX INFO: renamed from: i */
    private String f8166i;

    /* JADX INFO: renamed from: j */
    private List<zzb> f8167j;

    zza(String str, List<Integer> list, int i, String str2, List<zzb> list2, String str3, List<zzb> list3, String str4, List<zzb> list4) {
        this.f8160c = str;
        this.f8161d = list;
        this.f8163f = i;
        this.f8159b = str2;
        this.f8162e = list2;
        this.f8164g = str3;
        this.f8165h = list3;
        this.f8166i = str4;
        this.f8167j = list4;
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    /* JADX INFO: renamed from: a */
    public final CharSequence mo8760a(CharacterStyle characterStyle) {
        return zzg.m8799a(this.f8159b, this.f8162e, characterStyle);
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    /* JADX INFO: renamed from: a */
    public final String mo8761a() {
        return this.f8160c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zza)) {
            return false;
        }
        zza zzaVar = (zza) obj;
        return zzbg.m7371a(this.f8160c, zzaVar.f8160c) && zzbg.m7371a(this.f8161d, zzaVar.f8161d) && zzbg.m7371a(Integer.valueOf(this.f8163f), Integer.valueOf(zzaVar.f8163f)) && zzbg.m7371a(this.f8159b, zzaVar.f8159b) && zzbg.m7371a(this.f8162e, zzaVar.f8162e) && zzbg.m7371a(this.f8164g, zzaVar.f8164g) && zzbg.m7371a(this.f8165h, zzaVar.f8165h) && zzbg.m7371a(this.f8166i, zzaVar.f8166i) && zzbg.m7371a(this.f8167j, zzaVar.f8167j);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f8160c, this.f8161d, Integer.valueOf(this.f8163f), this.f8159b, this.f8162e, this.f8164g, this.f8165h, this.f8166i, this.f8167j});
    }

    public final String toString() {
        return zzbg.m7370a(this).m7372a("placeId", this.f8160c).m7372a("placeTypes", this.f8161d).m7372a("fullText", this.f8159b).m7372a("fullTextMatchedSubstrings", this.f8162e).m7372a("primaryText", this.f8164g).m7372a("primaryTextMatchedSubstrings", this.f8165h).m7372a("secondaryText", this.f8166i).m7372a("secondaryTextMatchedSubstrings", this.f8167j).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7748a(parcel, 1, this.f8159b, false);
        zzbfp.m7748a(parcel, 2, this.f8160c, false);
        zzbfp.m7749a(parcel, 3, this.f8161d, false);
        zzbfp.m7762c(parcel, 4, this.f8162e, false);
        zzbfp.m7738a(parcel, 5, this.f8163f);
        zzbfp.m7748a(parcel, 6, this.f8164g, false);
        zzbfp.m7762c(parcel, 7, this.f8165h, false);
        zzbfp.m7748a(parcel, 8, this.f8166i, false);
        zzbfp.m7762c(parcel, 9, this.f8167j, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
