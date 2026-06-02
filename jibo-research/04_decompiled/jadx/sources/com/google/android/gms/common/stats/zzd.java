package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfn;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzd implements Parcelable.Creator<WakeLockEvent> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ WakeLockEvent createFromParcel(Parcel parcel) {
        int iM7700a = zzbfn.m7700a(parcel);
        int iM7712f = 0;
        long jM7714h = 0;
        int iM7712f2 = 0;
        String strM7722p = null;
        int iM7712f3 = 0;
        ArrayList<String> arrayListM7696B = null;
        String strM7722p2 = null;
        long jM7714h2 = 0;
        int iM7712f4 = 0;
        String strM7722p3 = null;
        String strM7722p4 = null;
        float fM7717k = CropImageView.DEFAULT_ASPECT_RATIO;
        long jM7714h3 = 0;
        String strM7722p5 = null;
        while (parcel.dataPosition() < iM7700a) {
            int i = parcel.readInt();
            switch (65535 & i) {
                case 1:
                    iM7712f = zzbfn.m7712f(parcel, i);
                    break;
                case 2:
                    jM7714h = zzbfn.m7714h(parcel, i);
                    break;
                case 3:
                case 7:
                case 9:
                default:
                    zzbfn.m7706b(parcel, i);
                    break;
                case 4:
                    strM7722p = zzbfn.m7722p(parcel, i);
                    break;
                case 5:
                    iM7712f3 = zzbfn.m7712f(parcel, i);
                    break;
                case 6:
                    arrayListM7696B = zzbfn.m7696B(parcel, i);
                    break;
                case 8:
                    jM7714h2 = zzbfn.m7714h(parcel, i);
                    break;
                case 10:
                    strM7722p3 = zzbfn.m7722p(parcel, i);
                    break;
                case 11:
                    iM7712f2 = zzbfn.m7712f(parcel, i);
                    break;
                case 12:
                    strM7722p2 = zzbfn.m7722p(parcel, i);
                    break;
                case 13:
                    strM7722p4 = zzbfn.m7722p(parcel, i);
                    break;
                case 14:
                    iM7712f4 = zzbfn.m7712f(parcel, i);
                    break;
                case 15:
                    fM7717k = zzbfn.m7717k(parcel, i);
                    break;
                case 16:
                    jM7714h3 = zzbfn.m7714h(parcel, i);
                    break;
                case 17:
                    strM7722p5 = zzbfn.m7722p(parcel, i);
                    break;
            }
        }
        zzbfn.m7699E(parcel, iM7700a);
        return new WakeLockEvent(iM7712f, jM7714h, iM7712f2, strM7722p, iM7712f3, arrayListM7696B, strM7722p2, jM7714h2, iM7712f4, strM7722p3, strM7722p4, fM7717k, jM7714h3, strM7722p5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ WakeLockEvent[] newArray(int i) {
        return new WakeLockEvent[i];
    }
}
