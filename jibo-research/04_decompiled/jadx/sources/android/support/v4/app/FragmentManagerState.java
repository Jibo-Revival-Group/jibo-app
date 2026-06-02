package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: FragmentManager.java */
/* JADX INFO: loaded from: classes.dex */
final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new Parcelable.Creator<FragmentManagerState>() { // from class: android.support.v4.app.FragmentManagerState.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FragmentManagerState createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FragmentManagerState[] newArray(int i) {
            return new FragmentManagerState[i];
        }
    };

    /* JADX INFO: renamed from: a */
    FragmentState[] f1546a;

    /* JADX INFO: renamed from: b */
    int[] f1547b;

    /* JADX INFO: renamed from: c */
    BackStackState[] f1548c;

    /* JADX INFO: renamed from: d */
    int f1549d;

    /* JADX INFO: renamed from: e */
    int f1550e;

    public FragmentManagerState() {
        this.f1549d = -1;
    }

    public FragmentManagerState(Parcel parcel) {
        this.f1549d = -1;
        this.f1546a = (FragmentState[]) parcel.createTypedArray(FragmentState.CREATOR);
        this.f1547b = parcel.createIntArray();
        this.f1548c = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
        this.f1549d = parcel.readInt();
        this.f1550e = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f1546a, i);
        parcel.writeIntArray(this.f1547b);
        parcel.writeTypedArray(this.f1548c, i);
        parcel.writeInt(this.f1549d);
        parcel.writeInt(this.f1550e);
    }
}
