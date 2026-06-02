package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new Parcelable.Creator<ParcelableVolumeInfo>() { // from class: android.support.v4.media.session.ParcelableVolumeInfo.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableVolumeInfo createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableVolumeInfo[] newArray(int i) {
            return new ParcelableVolumeInfo[i];
        }
    };

    /* JADX INFO: renamed from: a */
    public int f2084a;

    /* JADX INFO: renamed from: b */
    public int f2085b;

    /* JADX INFO: renamed from: c */
    public int f2086c;

    /* JADX INFO: renamed from: d */
    public int f2087d;

    /* JADX INFO: renamed from: e */
    public int f2088e;

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f2084a = parcel.readInt();
        this.f2086c = parcel.readInt();
        this.f2087d = parcel.readInt();
        this.f2088e = parcel.readInt();
        this.f2085b = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f2084a);
        parcel.writeInt(this.f2086c);
        parcel.writeInt(this.f2087d);
        parcel.writeInt(this.f2088e);
        parcel.writeInt(this.f2085b);
    }
}
