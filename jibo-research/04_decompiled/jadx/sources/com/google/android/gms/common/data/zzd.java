package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.internal.zzbfq;

/* JADX INFO: loaded from: classes.dex */
public class zzd<T extends zzbfq> extends AbstractDataBuffer<T> {

    /* JADX INFO: renamed from: b */
    private static final String[] f6488b = {ShareConstants.WEB_DIALOG_PARAM_DATA};

    /* JADX INFO: renamed from: c */
    private final Parcelable.Creator<T> f6489c;

    public zzd(DataHolder dataHolder, Parcelable.Creator<T> creator) {
        super(dataHolder);
        this.f6489c = creator;
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public T mo7265a(int i) {
        byte[] bArrM7278d = this.f6459a.m7278d(ShareConstants.WEB_DIALOG_PARAM_DATA, i, this.f6459a.m7269a(i));
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArrM7278d, 0, bArrM7278d.length);
        parcelObtain.setDataPosition(0);
        T tCreateFromParcel = this.f6489c.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        return tCreateFromParcel;
    }
}
